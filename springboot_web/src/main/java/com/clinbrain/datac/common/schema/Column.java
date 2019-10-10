package com.clinbrain.datac.common.schema;

import java.sql.Types;
public class Column implements Comparable<Column> {

    private String name;
    private int dataType = Types.VARCHAR;
    private String dataTypeName;
    private String comment;
    private boolean primaryKey;

    public Column(String name,int dataType,String dataTypeName,String comment,boolean primaryKey) {
        this.name = name;
        this.dataType = dataType;
        this.dataTypeName = dataTypeName;
        this.comment = comment;
        this.primaryKey = primaryKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public int compareTo(Column c) {
        return name.compareTo(c.name);
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getDataTypeName() {
        return dataTypeName;
    }

    public void setDataTypeName(String dataTypeName) {
        this.dataTypeName = dataTypeName;
    }
}
