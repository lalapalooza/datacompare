package com.clinbrain.datac.compare;

/**
 * Created by Liaopan on 2019/7/4.
 */
public class JobConstants {

    enum JobType {
        RDBMS2HIVE, HIVE2GP
    }

    public enum Status {
        SUCCESS(0), ERROR(1);
        private Integer code;

        Status(int i) {
            this.code = i;
        }

        public Integer getCode() {
            return code;
        }
    }

    public enum RunType {
        INCR(0), RANGE(1), ALL(2);
        private Integer code;

        RunType(int i) {
            this.code = i;
        }

        public Integer getCode() {
            return code;
        }
    }

    /**
     * 执行策略
     * 1： 只计算Count值
     * 2： 计算主键列值
     * 3： 计算所有列的值
     * PS: 如果设置的自定义查询sql，则没有这些策略的区别，统一使用自定义做查询
     */
    public enum ExecStrategy {
        COUNT(1), COUNT_DETAIL(3), COUNT_PRI(2);

        private Integer code;
        ExecStrategy(int code) {this.code = code;}

        public String getCode(){
            return String.valueOf(code);
        }
    }

}
