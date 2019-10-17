package test;

import cn.hutool.setting.Setting;
import com.clinbrain.datac.compare.CompareResultList;
import com.clinbrain.datac.model.auto.TableLoggerWithBLOBs;
import com.clinbrain.datac.util.DataSourceManager;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Liaopan on 2019/7/4.
 */
public class Test {

    public void test1() {

        List<TableLoggerWithBLOBs> left = new ArrayList<>();
        List<TableLoggerWithBLOBs> right = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            TableLoggerWithBLOBs tableLogger = new TableLoggerWithBLOBs();
            TableLoggerWithBLOBs tableLogger2 = new TableLoggerWithBLOBs();
            tableLogger.setId(i);
            tableLogger2.setId(i);
            tableLogger.setSourceData("source_data" + i);
            tableLogger2.setSourceData("source_data" + i);
            left.add(tableLogger);
            right.add(tableLogger2);
        }
        CompareResultList list = new CompareResultList.Builder().left(left).right(right).builder();
        Pair<List, List> pair = list.leftCompareRight();
        Gson gson = new Gson();
        gson.toJson(list);
        System.out.println(pair.getLeft());
        System.out.println(pair.getRight());
    }

    public void testSqlServer() throws Exception {
        DataSource instance = DataSourceManager.getInstance("jdbc:sqlserver://202.202.3.67:1433", "sa", "P@ssw0rd");
        System.out.println(instance.getConnection());

    }

    public void testOracle() throws Exception {
      /*DataSource instance = DataSourceManager.getInstance("jdbc:oracle:thin:@192.168.0.114:1521:orcl", "jira", "jira");
      Table table = new Table("OGGTEST.TEST", null, instance.getConnection());
      table.getPkColumns().forEach(System.out::println);*/
        DataSource instance = DataSourceManager.getInstance("jdbc:oracle:thin:@192.168.0.114:1521/orcl", "jira", "jira");

    }

    public void testMysql() throws Exception {
      /*DataSource instance = DataSourceManager.getInstance("jdbc:oracle:thin:@192.168.0.114:1521:orcl", "jira", "jira");
      Table table = new Table("OGGTEST.TEST", null, instance.getConnection());
      table.getPkColumns().forEach(System.out::println);*/
        DataSource instance = DataSourceManager.getInstance("com.cloudera.impala.jdbc41.Driver","jdbc:impala://100.101.1.103:21050", "impala", "impala");
        /*ResultSet tables = metaData.getTables("test", "dbo", "person", new String[]{"TABLE"});
        System.out.println(tables.next());*/
        /*Table table = new Table("test.teacher", "created", instance.getConnection());
        table.getColumns().forEach(System.out::println);*/
        instance.getConnection().isValid(1000);
    }

    public void testGP() throws Exception {
        DataSource instance = DataSourceManager.getInstance("com.pivotal.jdbc.GreenplumDriver",
                "jdbc:pivotal:greenplum://100.101.1.104:5432;DatabaseName=cdr_db", "gpadmin", "gpadmin");
        System.out.println(instance.getConnection().getMetaData().getDatabaseProductVersion());

        QueryRunner r = new QueryRunner(instance);
        String sql = "set Optimizer = 'off';select resourcetablekeyvalue,regdate\n" +
                "  from pa_op_registration\n" +
                " where regdate between '2019-08-08' and '2019-08-09'\n" +
                "   and isdeleted = 0";
        String sqls[] = sql.split(";");
        r.execute(sqls[0],null);
        r.query(sqls[1], new ResultSetHandler<String>() {
            @Override
            public String handle(ResultSet resultSet) throws SQLException {
                String returStn = "";
                if(resultSet.next()) {
                    returStn = resultSet.getString(1);
                    System.out.println(returStn);
                }
                return returStn;
            }
        });
        /*ResultSet rs = instance.getConnection().getMetaData().getTables("", "public", "gp_test", new String[]{"TABLE"});
        while (rs.next()) {
            System.out.println(rs.getString("TABLE_CAT"));
            System.out.println(rs.getString("TABLE_SCHEM"));
            System.out.println(rs.getString("TABLE_TYPE"));
            System.out.println(rs.getString("REMARKS"));
            System.out.println(rs.getString("TABLE_NAME"));
        }*/
        /*Table table = new Table("public.ctest", "lastupdatedttm", instance.getConnection());
        table.getColumns().forEach(System.out::println);*/
    }

    public void testComplier() throws Exception {
        //JavaStringCompiler compiler = new JavaStringCompiler(JsonFormat.class.getClassLoader());
        URL resource = JsonFormat.class.getResource("");
        String path = "file:/opt/apache-tomcat-8.5.23/webapps/compare/WEB-INF/lib/jackson-annotations-2.9.0.jar!/com/fasterxml/jackson/annotation/";
        String libPath = StringUtils.substringBetween(path, "file:", "!");
        String libaryPath = StringUtils.substringBeforeLast(libPath, "/");
        File file1 = new File(libaryPath + "/");
        if (file1.exists() && file1.isDirectory()) {
            File[] jarFiles = file1.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().endsWith(".jar");
                }
            });
            Stream.of(jarFiles).map(File::getPath).collect(Collectors.joining(";"));
        }
        System.out.println(StringUtils.substringBeforeLast(libaryPath, "/") + "/classes");
        System.out.println(StringUtils.substringBeforeLast(libPath, "/"));
    }

    public void testIsJavaSpecilName() {

    }

    Logger log = LoggerFactory.getLogger(Test.class);
    public void testThreadLogFile() throws Exception{

        for(int i = 0; i< 5; i++) {
            final int a = i;
            new Thread(() -> {
                System.out.println(MDC.class);
                MDC.put("logFileName", UUID.randomUUID().toString());
                log.debug("hello," + a);
                MDC.remove("logFileName");
            }).start();
        }
        for(;;);
    }

    public void testCompare() {
        ArrayList<String> all = Lists.newArrayList("batj.tj_zlxz_dk", "bqxt.bq_ybjl", "bqxt.sm_ssfy", "bqxt.zy_bqyz", "bqxt.zy_bqyzzx", "bqxt.zy_zybrljmx", "fzxt.fz_zsxx_ls", "luna_mcs.mcs_doc_form", "medsurgery.med_pat_monitor_data", "mzxt.h_fp_zffs", "mzxt.h_mz_zhjymx", "mzxt.mz_brdakz", "mzxt.mz_dz01", "mzxt.mz_fpk_ls", "mzxt.mz_ghxx", "mzxt.mz_yyxx", "ysz1.e_qtjl", "ysz1.e_zyblbcllb", "ysz1.e_zyblbclnr", "ysz1.e_zyblnrxh50");
        ArrayList<String> ready = Lists.newArrayList("mzxt.mz_yyxx", "mzxt.mz_yyxx", "mzxt.mz_fpk_ls", "mzxt.mz_ghxx", "mzxt.mz_yyxx", "mzxt.mz_ghxx", "mzxt.mz_fpk_ls", "mzxt.mz_ghxx", "bqxt.sm_ssfy", "mzxt.mz_yyxx", "bqxt.zy_bqyz", "bqxt.bq_ybjl", "batj.tj_zlxz_dk");
        all.removeAll(ready);
        List<String> collect = all.stream().map(a -> "'" + a + "'").collect(Collectors.toList());
        System.out.println(StringUtils.join(collect,","));
    }

    public static void lockTable(Connection connection) throws Exception{

    }

    @org.junit.Test
    public void testByte() throws Exception {
        try{
            Setting setting = new Setting("compare.setting",true);
            System.out.println(setting);
            System.out.println(setting.getStr("ssh.host")+
                    +setting.getInt("ssh.port")+setting.getStr("ssh.user")+
                    setting.getStr("ssh.password"));
        }catch (Exception e) {
            System.out.println(ExceptionUtils.getFullStackTrace(e));
        }
    }

    @org.junit.Test
    public void testSetDiff() throws Exception{
        Set<String> list1 = Sets.newHashSet("3","4","5");
        Set<String> list2 = Sets.newHashSet("3","4","5","6");
        Sets.SetView<String> difference = Sets.symmetricDifference(list1, list2);
        System.out.println(difference);
        System.out.println(String.join(",",list2) + list1);
        Process exec = Runtime.getRuntime().exec("D:\\Program Files\\EditPlus 3\\editplus.exe");

        Thread.sleep(2000);
        exec.waitFor();
        System.out.println(exec);
    }

    @org.junit.Test
    public void testSpark() {
        try {
            DataSource instance = DataSourceManager.getInstance("com.cloudera.impala.jdbc41.Driver",
                    "jdbc:impala://192.168.0.113:21050", "impala", "impala");
            QueryRunner q = new QueryRunner(instance);
            q.query("select name from stest.table2", new ResultSetHandler<Object>() {
                @Override
                public Object handle(ResultSet rs) throws SQLException {
                    while (rs.next()) {
                        System.out.println(rs.getString(1));
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test4() {

    }

    public static void main(String[] args) {

    }
}
