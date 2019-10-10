import cn.hutool.db.Db;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.SQLException;

/**
 * Created by Liaopan on 2019/9/25.
 */
public class Test {

    @org.junit.Test
    public void test1() throws Exception {
        String filePath = "C:/opt/datac/2/target.json";
        String fileName = "source.json";
        File file = new File(filePath);

        if(!file.exists()) {
            file.getParentFile().mkdirs();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write("ni hao");

        writer.flush();
        writer.close();
    }

    @org.junit.Test
    public void test2() throws SQLException {
        Db.use().query("select * from t_connection").forEach(System.out::println);
    }
}
