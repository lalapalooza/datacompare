package com.clinbrain.datac.compare;

/**
 * Created by Liaopan on 2019/9/29.
 */
public class CompareTaskFactory {

    public static Class<? extends BaseCompare> getCompareTask(String onlyCount) {
        if (JobConstants.ExecStrategy.COUNT.getCode().equalsIgnoreCase(onlyCount)) {
            return CompareColumnsReturnCount.class;
        } else if (JobConstants.ExecStrategy.COUNT_DETAIL.getCode().equalsIgnoreCase(onlyCount)){
            return CompareColumnsReturnSpark.class;
        } else {
            return CompareColumnsReturnMap.class;
        }
    }
}
