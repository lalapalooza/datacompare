package com.clinbrain.datac.model.auto;

import java.io.Serializable;
import java.util.Date;

import com.clinbrain.datac.common.domain.BaseObject;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 数据库连接信息
 *
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-07-11 10:59:46
 */
public class TConnection extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     *
     */
    private String connectionCode;

    /**
     *
     */
    private String url;

    /**
     *
     */
    private String user;

    /**
     *
     */
    private String password;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdAt;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedAt;

    /**
     *
     */
    private String driver;

    public TConnection(String connectionCode, String url, String user, String password, Date createdAt, Date updatedAt, String driver) {
        this.connectionCode = connectionCode;
        this.url = url;
        this.user = user;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.driver = driver;
    }

    public TConnection() {
        super();
    }


    public String getConnectionCode() {
        return connectionCode;
    }

    public void setConnectionCode(String connectionCode) {
        this.connectionCode = connectionCode == null ? null : connectionCode.trim();
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver == null ? null : driver.trim();
    }


}