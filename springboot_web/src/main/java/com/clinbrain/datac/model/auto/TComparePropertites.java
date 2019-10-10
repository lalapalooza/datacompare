package com.clinbrain.datac.model.auto;

import java.io.Serializable;
import java.util.Date;

public class TComparePropertites implements Serializable {
    private Integer id;

    private String propertitesName;

    private String propertitesCron;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public TComparePropertites(Integer id, String propertitesName, String propertitesCron, Date createTime, Date updateTime) {
        this.id = id;
        this.propertitesName = propertitesName;
        this.propertitesCron = propertitesCron;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TComparePropertites() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPropertitesName() {
        return propertitesName;
    }

    public void setPropertitesName(String propertitesName) {
        this.propertitesName = propertitesName == null ? null : propertitesName.trim();
    }

    public String getPropertitesCron() {
        return propertitesCron;
    }

    public void setPropertitesCron(String propertitesCron) {
        this.propertitesCron = propertitesCron == null ? null : propertitesCron.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}