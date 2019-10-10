package com.clinbrain.datac.common.base;


public enum DBDriver {
    GREENPLUM("pivotal","com.pivotal.jdbc.GreenplumDriver"),
    HIVE2("hive2","org.apache.hive.jdbc.HiveDriver"),
    CACHE("Cache","com.intersys.jdbc.CacheDriver"),
    IMPALA("impala","com.cloudera.impala.jdbc41.Driver"),
    MYSQL("mysql","com.mysql.jdbc.Driver"),
    ORACLE("oracle","oracle.jdbc.OracleDriver"),
    SQLSERVER("sqlserver","com.microsoft.sqlserver.jdbc.SQLServerDriver");

    private String value;
    private String driverClass;
    DBDriver(String value, String driverClass){
        this.value=value;
        this.driverClass=driverClass;
    }
    public String getDriverClass() {
        return driverClass;
    }

    public String getValue() {
        return value;
    }

    public static DBDriver parseValue(String value){
        for(DBDriver e:DBDriver.values()){
            if(e.value.equalsIgnoreCase(value))
                return e;
        }
        return null;
    }
}
