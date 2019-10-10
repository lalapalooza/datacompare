package com.clinbrain.datac.service;

import com.clinbrain.datac.model.auto.TConnection;
import com.clinbrain.datac.model.auto.TConnectionExample;
import com.clinbrain.datac.util.DataSourceManager;
import com.clinbrain.datac.common.base.BaseService;
import com.clinbrain.datac.common.base.DBDriver;
import com.clinbrain.datac.mapper.auto.TConnectionMapper;
import com.clinbrain.datac.model.custom.EtlHistablePartitionsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConnectionService implements BaseService<TConnection, TConnectionExample> {

    @Value("${custom.datasource.ds1.driver-class-name}")
    private String driver;

    @Value("${custom.datasource.ds1.url}")
    private String url;

    @Value("${custom.datasource.ds1.username}")
    private String username;

    @Value("${custom.datasource.ds1.password}")
    private String password;

    @Value("${custom.sql.sql_etl_connection}")
    private String sql_etl_connection;

    @Value("${custom.sql.sql_etl_histable_partitions_configuration}")
    private String sql_etl_histable_partitions_configuration;


    @Autowired
    private TConnectionMapper tConnectionMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return tConnectionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(TConnection record) {
        return tConnectionMapper.insertSelective(record);
    }

    @Override
    public TConnection selectByPrimaryKey(String id) {
        return tConnectionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TConnection record) {
        return 0;
    }

    @Override
    public int updateByExampleSelective(TConnection record, TConnectionExample example) {
        return 0;
    }

    @Override
    public int updateByExample(TConnection record, TConnectionExample example) {
        return 0;
    }

    @Override
    public List<TConnection> selectByExample(TConnectionExample example) {
        return null;
    }

    @Override
    public long countByExample(TConnectionExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(TConnectionExample example) {
        return 0;
    }

    public List<EtlHistablePartitionsConfiguration> getHisPartConf() throws Exception{
        List<EtlHistablePartitionsConfiguration> resultList = new ArrayList<>();
        List<Map<String,Object>> list = getListByEtlSql(sql_etl_histable_partitions_configuration);
        for(Map map:list){
            EtlHistablePartitionsConfiguration m = new EtlHistablePartitionsConfiguration();
            m.setId((Integer) map.get("id"));
            m.setHospitalNo((String)map.get("hospital_no"));
            m.setHisDbName((String)map.get("his_db_name"));
            m.setHisTbName((String)map.get("his_tb_name"));
            m.setHisTbPartitionColumnName((String)map.get("his_tb_partition_column_name"));
            m.setPartitionType((String)map.get("partition_type"));
            m.setRefCdrTbName((String)map.get("ref_cdr_tb_name"));
            m.setDateFormat((String)map.get("date_format"));
            m.setRefCdrColumnName((String)map.get("ref_cdr_column_name"));
            m.setCreatedAt((Date)map.get("created_at"));
            m.setUpdatedAt((Date)map.get("updated_at"));
            resultList.add(m);
        }
        return resultList;
    }
    public int insertConnectionByEtl() throws Exception {
        List<Map<String,Object>> list = getListByEtlSql(sql_etl_connection);
        for(Map map:list){
            String connectionCode = (String)map.get("connection_code");
            String url = (String)map.get("url");
            String driver = "";
            // region
            if(url.startsWith("jdbc")){
                String d = url.substring(url.indexOf(":",0)+1,url.indexOf(":",url.indexOf(":",0)+1));
                if(d.equals(DBDriver.MYSQL.getValue())){
                    driver = DBDriver.MYSQL.getDriverClass();
                }else if(d.equals(DBDriver.HIVE2.getValue())){
                    driver = DBDriver.HIVE2.getDriverClass();
                }else if(d.equals(DBDriver.GREENPLUM.getValue())){
                    driver = DBDriver.GREENPLUM.getDriverClass();
                }else if(d.equals(DBDriver.IMPALA.getValue())){
                    driver = DBDriver.IMPALA.getDriverClass();
                }else if(d.equals(DBDriver.ORACLE.getValue())){
                    driver = DBDriver.ORACLE.getDriverClass();
                }else if(d.equals(DBDriver.SQLSERVER.getValue())){
                    driver = DBDriver.SQLSERVER.getDriverClass();
                }else if(d.equals(DBDriver.CACHE.getValue())){
                    driver = DBDriver.CACHE.getDriverClass();
                }
            }
            // endregion
            TConnection connection = new TConnection();
            connection.setConnectionCode(connectionCode);
            connection.setUser((String)map.get("user"));
            connection.setPassword((String)map.get("password"));
            connection.setUrl((String)map.get("url"));
            connection.setDriver(driver);
            connection.setCreatedAt(new Date());
            if(tConnectionMapper.selectByPrimaryKey(connectionCode)==null){
                tConnectionMapper.insert(connection);
            }
        }
        return 1;

    }

    public List<Map<String,Object>> getListByEtlSql(String sql) throws Exception{
        List<Map<String,Object>> list = new ArrayList<>();
        Connection connection=null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet = null;
        DataSource  dataSource = DataSourceManager.getInstance(driver,url,username,password);
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            tranfResultSet2Map(resultSet,list);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null) resultSet.close();
            if(preparedStatement!=null) preparedStatement.close();
            if(connection!=null) connection.close();
        }
        return  list;
    }

    private static void tranfResultSet2Map(ResultSet resultSet, List<Map<String,Object>> result) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int count = metaData.getColumnCount();
        while (resultSet.next()){
            Map<String,Object> r = new HashMap<String, Object>();
            for (int i =1 ;i<=count;i++){
                r.put(metaData.getColumnName(i),resultSet.getObject(i));
            }
            result.add(r);
        }
    }
    public static void main(String[] args) {
        String url = "jdbc:mysql:/aaaaaa";
        String url2 = "jdbc:oracle:/aaaaaa";
        String url3 = "jdbc:sqlserver:/aaaaaa";
        System.out.println(url.substring(url.indexOf(":",0)+1,url.indexOf(":",url.indexOf(":",0)+1)));
    }
}
