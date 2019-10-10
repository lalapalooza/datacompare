package com.clinbrain.datac.compare.resultHandler;

import org.apache.commons.dbutils.ResultSetHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Liaopan on 2019/7/17.
 */
public class CountClassResultHandler implements ResultSetHandler<Long> {

    private static final Logger LOG = LoggerFactory.getLogger(CountClassResultHandler.class);

    private String flag;

    public CountClassResultHandler(String flag) {
        this.flag = flag;
    }

    @Override
    public Long handle(ResultSet rs) throws SQLException {
        long resultCount = -1;
        if (rs.next()) {
            resultCount = rs.getLong(1);
        }
        LOG.info(flag + "查询完成,总数：" + resultCount);
        return resultCount;
    }
}
