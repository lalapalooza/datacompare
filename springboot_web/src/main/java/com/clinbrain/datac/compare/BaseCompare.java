package com.clinbrain.datac.compare;

import com.clinbrain.datac.common.schema.Column;
import com.clinbrain.datac.compare.define.CompareInterface;
import com.clinbrain.datac.compare.define.CompareResult;
import com.clinbrain.datac.model.auto.TConnection;
import com.clinbrain.datac.model.auto.TableLogger;
import com.github.rholder.retry.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.StatementConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BaseCompare implements CompareInterface {

    private static final Logger LOG = LoggerFactory.getLogger(BaseCompare.class);

    protected TConnection sourceConfig;
    protected TConnection targetConfig;

    private TableLogger tableLogger;

    protected DataSource source;
    protected DataSource target;

    protected List<Column> sourceFieldList;
    protected List<Column> targetFieldList;

    protected final Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
            .retryIfExceptionOfType(SQLException.class)
            .withStopStrategy(StopStrategies.stopAfterAttempt(3))
            .withWaitStrategy(WaitStrategies.fixedWait(5, TimeUnit.SECONDS))
            .build();

    // 设置查询参数
    protected static final StatementConfiguration statementConfiguration = new StatementConfiguration.Builder()
            .queryTimeout(1800).build();

    public void init(DataSource sds, DataSource tds, List<Column> sourceFieldList, List<Column> targetFieldList) {
        this.sourceFieldList = sourceFieldList;
        this.targetFieldList = targetFieldList;
        this.source = sds;
        this.target = tds;
    }

    public void init(DataSource sds, DataSource tds, List<Column> sourceFieldList, List<Column> targetFieldList,
                     TConnection source,TConnection target) {
        this.sourceFieldList = sourceFieldList;
        this.targetFieldList = targetFieldList;
        this.source = sds;
        this.target = tds;
        this.sourceConfig = source;
        this.targetConfig = target;
    }

    public void invalidate(Connection conn) {
        QueryRunner queryRunner = new QueryRunner();

        try {
            if (conn.getMetaData().getDriverName().contains("ImpalaJDBC")) {
                queryRunner.execute(conn,"invalidate metadata");
                LOG.info("invalidate metadata");
            }

            if (conn.getMetaData().getDriverName().contains("Greenplum")) {
                queryRunner.execute(conn,"set Optimizer = 'off'");
                LOG.info("set Optimizer = 'off'");
            }

        }catch(Exception e) {
            LOG.error("invalidate出错！", e);
        }
    }

    @Override
    public abstract CompareResult compare(String sourceQuery, String targetQuery) throws Exception;


    public TableLogger getTableLogger() {
        return tableLogger;
    }

    public void setTableLogger(TableLogger tableLogger) {
        this.tableLogger = tableLogger;
    }
}
