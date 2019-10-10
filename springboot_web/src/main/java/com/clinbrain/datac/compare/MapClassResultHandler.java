package com.clinbrain.datac.compare;

import com.clinbrain.datac.common.domain.BaseObject;
import com.clinbrain.datac.util.StringUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.StringConverter;
import org.apache.commons.dbutils.ResultSetHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
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

    private Class<BaseObject> clazz;

    public MapClassResultHandler(Class<BaseObject> clz) {
        this.clazz = clz;
        ConvertUtils.register(new DateConverter(null), java.util.Date.class);
        ConvertUtils.register(new IntegerConverter(null), Integer.class);
        ConvertUtils.register(new LongConverter(null), Long.class);
        ConvertUtils.register(new DoubleConverter(null), Double.class);
        ConvertUtils.register(new StringConverter(null), String.class);
    }

    @Override
    public Map<String,Object> handle(ResultSet rs) throws SQLException {
        final ResultSetMetaData rsMetaData = rs.getMetaData();
        int columnCount = rsMetaData.getColumnCount();
        Map<String,Object> resultMap = new HashMap<>(20000);
        while (rs.next()) {
            Map<String, Object> values = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsMetaData.getColumnName(i);
                int columnType = rsMetaData.getColumnType(i);
                Object columnValue = ResultSetUtil.getValue(rs, i, columnType);
                if("".equals(columnValue)) {
                    columnValue = null;
                }
                values.put(StringUtils.lowerCase(columnName), columnValue);
            }
            try {
                Object obj = clazz.newInstance();
                BeanUtils.populate(obj, values);
                Method md5Method = obj.getClass().getMethod("md5");
                Object r = md5Method.invoke(obj);
                resultMap.put(r.toString(), obj);
            }catch (Exception e) {
                LOG.error("封装查询对象出错！", e);
                throw new SQLException("封装查询对象出错", e);
            }
        }
        LOG.info("====结果数据"+ clazz.getName()+"====count:" + resultMap.size());
        return resultMap;
    }
}
