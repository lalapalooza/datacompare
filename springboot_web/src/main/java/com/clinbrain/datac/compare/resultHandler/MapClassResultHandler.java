package com.clinbrain.datac.compare.resultHandler;

import org.apache.commons.dbutils.ResultSetHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Liaopan on 2019/7/17.
 */
public class MapClassResultHandler implements ResultSetHandler<Map<String,Object>> {

    private static final Logger LOG = LoggerFactory.getLogger(MapClassResultHandler.class);

    private String flag;

    public MapClassResultHandler(String flag) {
        this.flag = flag;
    }

    @Override
    public Map<String,Object> handle(ResultSet rs) throws SQLException {
        LOG.info(flag + "查询完成，处理返回信息...");
        final ResultSetMetaData rsMetaData = rs.getMetaData();
        int columnCount = rsMetaData.getColumnCount();
        Map<String,Object> resultMap = new HashMap<>(1024);
        while (rs.next()) {
            Map<String, Object> values = new HashMap<>(columnCount);
            for (int i = 1; i <= columnCount; i++) {
                Object columnValue = rs.getString(i);
                if("".equals(columnValue) || null == columnValue) {
                    continue;
                }
                String columnName = rsMetaData.getColumnName(i);
                /*String attrname =
                        StringUtils.uncapitalize(GenUtils.columnToJava(StringUtils.lowerCase(columnName)));
                if(StringUtils.isJavaSpecialName(StringUtils.lowerCase(attrname))) {
                    attrname += "2";
                }*/
                values.put(columnName.toLowerCase(), columnValue);
            }
            resultMap.put(values.toString(), values);
        }
        LOG.info(flag + "处理完成,总数：" + resultMap.size());
        return resultMap;
    }
}
