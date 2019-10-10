package com.clinbrain.datac.model.custom;

import java.util.Date;
public class EtlHistablePartitionsConfiguration {
    private int id;
    private String hospitalNo ;
    private String hisDbName ;
    private String hisTbName ;
    private String hisTbPartitionColumnName ;
    private String partitionType ;
    private String refCdrTbName ;
    private String dateFormat;
    private String refCdrColumnName;
    private Date createdAt;
    private Date updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHospitalNo() {
        return hospitalNo;
    }

    public void setHospitalNo(String hospitalNo) {
        this.hospitalNo = hospitalNo;
    }

    public String getHisDbName() {
        return hisDbName;
    }

    public void setHisDbName(String hisDbName) {
        this.hisDbName = hisDbName;
    }

    public String getHisTbName() {
        return hisTbName;
    }

    public void setHisTbName(String hisTbName) {
        this.hisTbName = hisTbName;
    }

    public String getHisTbPartitionColumnName() {
        return hisTbPartitionColumnName;
    }

    public void setHisTbPartitionColumnName(String hisTbPartitionColumnName) {
        this.hisTbPartitionColumnName = hisTbPartitionColumnName;
    }

    public String getPartitionType() {
        return partitionType;
    }

    public void setPartitionType(String partitionType) {
        this.partitionType = partitionType;
    }

    public String getRefCdrTbName() {
        return refCdrTbName;
    }

    public void setRefCdrTbName(String refCdrTbName) {
        this.refCdrTbName = refCdrTbName;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getRefCdrColumnName() {
        return refCdrColumnName;
    }

    public void setRefCdrColumnName(String refCdrColumnName) {
        this.refCdrColumnName = refCdrColumnName;
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
}
