package com.clinbrain.datac.spark;

import java.sql.Connection;
import java.sql.DriverManager;

import cn.hutool.setting.Setting;

/**
 * Created by Liaopan on 2019/9/29.
 */
public class JdbcUtil {

    private static Setting setting;

    static {
        setting = new Setting("db.setting");
    }

    public static synchronized Connection connect(String driverClassName,
                                                  String url, String user, String pass) {
        try {
            Class.forName(driverClassName);
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static synchronized Connection getConnect() {
        return connect(setting.getStr("driver"), setting.getStr("url"),
                setting.getStr("user"), setting.getStr("pass"));
    }

}
