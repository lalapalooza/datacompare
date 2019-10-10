package com.clinbrain.datac.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import static com.alibaba.druid.pool.DruidDataSourceFactory.PROP_DRIVERCLASSNAME;
import static com.alibaba.druid.pool.DruidDataSourceFactory.PROP_INIT;
import static com.alibaba.druid.pool.DruidDataSourceFactory.PROP_INITIALSIZE;
import static com.alibaba.druid.pool.DruidDataSourceFactory.PROP_MAXACTIVE;
import static com.alibaba.druid.pool.DruidDataSourceFactory.PROP_MINEVICTABLEIDLETIMEMILLIS;
import static com.alibaba.druid.pool.DruidDataSourceFactory.PROP_PASSWORD;
import static com.alibaba.druid.pool.DruidDataSourceFactory.PROP_TESTWHILEIDLE;
import static com.alibaba.druid.pool.DruidDataSourceFactory.PROP_URL;
import static com.alibaba.druid.pool.DruidDataSourceFactory.PROP_USERNAME;
import static com.alibaba.druid.pool.DruidDataSourceFactory.createDataSource;

/**
 * Created by Liaopan on 2019/6/21.
 */
public class DataSourceManager {

    private static final Logger LOG = LoggerFactory.getLogger(DataSourceManager.class);

    private static final Map<String, DataSource> ds = new ConcurrentHashMap<>();

    private DataSourceManager() {
    }

    private static String key(String... args) {
        return MD5Util.encode(StringUtils.join(args, "|"));
    }

    public static DataSource getInstance(String driverClassName, String jdbcUrl, String userName, String password) throws Exception{
        return getInstance(driverClassName, jdbcUrl, userName, password, 30);
    }

    public static DataSource getInstance(String driverClassName, String jdbcUrl, String userName,
                                         String password, int poolSize) throws Exception {
        DataSource d = null;

            String key = key(jdbcUrl, userName, password);
            synchronized (ds) {
                d = ds.get(key);
                if (d == null) {
                    Map<String, String> config = new HashMap<>();
                    config.put(PROP_URL, jdbcUrl);
                    config.put(PROP_USERNAME, userName);
                    config.put(PROP_PASSWORD, password);
                    config.put(PROP_INITIALSIZE, "" + poolSize);
                    config.put(PROP_MAXACTIVE, "" + poolSize);
                    config.put(PROP_TESTWHILEIDLE, "false");
                    if (StringUtils.isNotEmpty(driverClassName)) {
                        config.put(PROP_DRIVERCLASSNAME, driverClassName);
                    }
                    config.put(PROP_MINEVICTABLEIDLETIMEMILLIS, String.valueOf(TimeUnit.HOURS.toMillis(2)));
                    config.put(PROP_INIT, "false");
                    DruidDataSource dataSource = (DruidDataSource) createDataSource(config);
                    dataSource.setConnectionErrorRetryAttempts(3);
                    dataSource.setBreakAfterAcquireFailure(true);
                    dataSource.init();
                    d = dataSource;

          /*HikariConfig hikariConfig = new HikariConfig();
          hikariConfig.setJdbcUrl(jdbcUrl);
          hikariConfig.setUsername(userName);
          hikariConfig.setPassword(password);
          hikariConfig.setMaximumPoolSize(poolSize);
          hikariConfig.setValidationTimeout(10000);
          if(StringUtils.isNotEmpty(driverClassName)) {
            hikariConfig.setDriverClassName(driverClassName);
          }
          d = new HikariDataSource(hikariConfig);*/
                    ds.put(key, d);
                }
            }

        return d;

    }

    public static DataSource getInstance(String jdbcUrl, String userName, String password) throws Exception{
        return getInstance(null, jdbcUrl, userName, password);
    }

    public static void main(String[] args) throws Exception {

        final DataSource mysql = DataSourceManager.getInstance("com.cloudera.impala.jdbc41.Driver",
                "jdbc:impala://node4:21050", "impala", "impala");
        try {
            final DatabaseMetaData metaData = mysql.getConnection().getMetaData();
            final ResultSet columns = metaData
                    .getColumns("clb_dip_metadata", "clb_dip_metadata",
                            "etl_connection", null);
            ResultSetMetaData rsMetaData = columns.getMetaData();
            final int columnCount = rsMetaData.getColumnCount();
            for (int j = 1; j <= columnCount; j++) {
                final String columnName = rsMetaData.getColumnName(j);
                System.out.println("name:" + columnName);
                if (columns.next()) {
                    System.out.println("value: " + columns.getObject(columnName));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        /*for(int i = 0; i < 8; i++) {
            final int d = i + 1;
            new Thread(() -> {
                final DataSource mysql = DataSourceManager.getInstance("com.mysql.jdbc.Driver",
                        "jdbc:mysql://192.168.6.92/clb_dip_metadata", "root", "root");
                try {
                  final DatabaseMetaData metaData = mysql.getConnection().getMetaData();
                  final ResultSet columns = metaData
                      .getColumns("clb_dip_metadata", "clb_dip_metadata",
                          "etl_connection", null);
                  ResultSetMetaData rsMetaData = columns.getMetaData();
                  final int columnCount = rsMetaData.getColumnCount();
                  while (columns.next()) {
                    for (int j = 0; j < columnCount; j++) {
                      System.out.println(rsMetaData.getColumnName(j));
                    }
                  }

                }catch (Exception e) {
                  e.printStackTrace();
                }
                QueryRunner queryRunner = new QueryRunner(mysql);
                try {
                    queryRunner.query("select * from etl_connection", rs -> {
                      while (rs.next()) {
                            System.out.println(Thread.currentThread() + ":" + rs.getString(d));
                            return "";
                        }
                        return "";
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                final DataSource mysql = DataSourceManager.getInstance( "com.pivotal.jdbc.GreenplumDriver","jdbc:pivotal:greenplum://192.168.0.113:5432;DatabaseName=cdr", "gpadmin", "gpadmin");

                QueryRunner queryRunner = new QueryRunner(mysql);
                try {
                    System.out.println("select。。");
                    queryRunner.query("select * from public.table1", rs -> {
                        if (rs.next()) {
                            System.out.println(Thread.currentThread().getName() + ":" + rs.getString(1));
                            return "";
                        }
                        return "";
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }*/
    }

}
