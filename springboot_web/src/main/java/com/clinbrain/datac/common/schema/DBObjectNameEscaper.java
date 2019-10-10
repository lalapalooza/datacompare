package com.clinbrain.datac.common.schema;


import org.apache.commons.lang.StringUtils;

public class DBObjectNameEscaper {

    private String identifierQuoteString = "`";

    public DBObjectNameEscaper(String identifierQuoteString) {
        super();
        this.identifierQuoteString = StringUtils.defaultIfEmpty(identifierQuoteString.trim(),"`");
    }

    /**
     * Escapes table names for SQL queries
     * 
     * @param tableName
     *            tableName (evt. full qualified)
     * @param schemaName
     *            schema name if schema is defined, else <null>
     * @return escaped table name ( with or without schema )
     */
    public String escapeDBMonsterTableName(String tableName, String schemaName) {
        if (    schemaName == null || schemaName.isEmpty() || !tableName.contains(".")) {
            // only table name
            return escapeObjectName(tableName);
        } else {
            if (tableName.indexOf(".") != -1) {
                String[] schemaTable = splitTableAndSchemaOfTable(tableName);
                if(schemaTable[0].equalsIgnoreCase(schemaName)) {
                    return escapeObjectName(schemaTable[0]) + "." + escapeObjectName(schemaTable[1]);
                } else {
                    return escapeObjectName(tableName);
                }
                
            }
        }

        return tableName;
    }

    /**
     * Splits table from schema name, if table is full qualified CAUTION: If
     * table is not full qualified and contains a "." this method will fail
     * 
     * @param tableName
     * @return array: with first element is the schema name (if present) second
     *         table name
     */
    public String[] splitTableAndSchemaOfTable(String tableName) {
        if (!tableName.contains(".")) {
            // no schema
            return new String[] { null, tableName };
        } else {
            int idx = tableName.lastIndexOf(".");
            if (idx != -1) {
                return new String[] { tableName.substring(0, idx), tableName.substring(idx + 1) };
            } else {
                return new String[] { null, tableName };
            }

        }
    }

    /**
     * Escapes sql object name with specific escape character
     * 
     * @param objectName
     * @return
     */
    public String escapeObjectName(String objectName) {
        if (identifierQuoteString == null) {
            identifierQuoteString = "";
        }
        return identifierQuoteString + objectName + identifierQuoteString;
    }
}
