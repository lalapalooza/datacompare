package com.clinbrain.datac.spark;

/**
 * Created by Liaopan on 2019/9/25.
 */
public class JdbcModel {

    private String jdbcUrl;
    private String driver;
    private String dbTable;
    private String query;
    private String user;
    private String password;

    public JdbcModel(String[] args) {
        this.jdbcUrl = args[0];
        this.driver = args[1];
        this.dbTable = args[2];
        this.query = args[3];
        this.user = args[4];
        this.password = args[5];
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDbTable() {
        return dbTable;
    }

    public void setDbTable(String dbTable) {
        this.dbTable = dbTable;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
