package com.clinbrain.datac.compare;

import com.clinbrain.datac.common.domain.BaseObject;
import com.google.gson.Gson;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Liaopan on 2019/7/17.
 */
public class ClassResultHandler implements ResultSetHandler<List<BaseObject>> {

    private static final Gson GSON = new Gson();
    private Class<BaseObject> clazz;

    public ClassResultHandler(Class clz) {
        this.clazz = clz;
    }

    @Override
    public List<BaseObject> handle(ResultSet rs) throws SQLException {
        final ResultSetMetaData rsMetaData = rs.getMetaData();
        int columnCount = rsMetaData.getColumnCount();
        List<BaseObject> resultList = new ArrayList<>();
        while (rs.next()) {
            Map<String, Object> values = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsMetaData.getColumnName(i);
                int columnType = rsMetaData.getColumnType(i);
                Object columnValue = ResultSetUtil.getValue(rs, i, columnType);
                values.put(columnName, columnValue);
            }
            resultList.add(GSON.fromJson(GSON.toJson(values), clazz));
        }
        return resultList;
    }
}
