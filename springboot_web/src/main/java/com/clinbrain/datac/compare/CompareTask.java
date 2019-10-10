package com.clinbrain.datac.compare;

import com.clinbrain.datac.compare.define.CompareResult;
import com.clinbrain.datac.model.auto.TableConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Liaopan on 2019/7/4.
 */
public class CompareTask extends AbstractCompareThread {

    private static final Logger LOG = LoggerFactory.getLogger(CompareTask.class);

    private BaseCompare compare;

    public CompareTask(TableConfig tableConfig) {
        super(tableConfig);
    }

    public CompareTask(TableConfig tableConfig, BaseCompare compare) {
        super(tableConfig);
        this.compare = compare;
    }

    public CompareTask(TableConfig tableConfig,String mdcValue, BaseCompare compare) {
        super(tableConfig,mdcValue);
        this.compare = compare;
    }

    public CompareResult taskRun(String sourceQuery, String targetQuery, Class<? extends BaseCompare> compareClass) throws Exception {
        this.compare = compareClass.newInstance();
        compare.init(sourceDataSource, targetDataSource,sourceFieldList,targetFieldList,source,target);
        compare.setTableLogger(tableLoggerWithBLOBs);
        return compare.compare(sourceQuery,targetQuery);
    }

}
