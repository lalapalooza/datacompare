package com.clinbrain.datac.model.custom;

import org.apache.log4j.Logger;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Properties;

/**
 * @Author：ligen
 * @Date: Created:12:16  2019/7/9
 * @Description: 对比配置文件
 **/

public class CompareProperties  {
    private static Logger log = Logger.getLogger(CompareProperties.class);
    private static String profilepath;
    static {
        try {
            profilepath = ResourceUtils.getURL("classpath:compare.properties").getPath();
            System.out.println(profilepath);
        } catch (FileNotFoundException e) {
            log.error("加载cron 配置文件失败", e);
        }
    }

    public static Object getProperty(String key) {
        Properties properties = new Properties();
        try {
            InputStream in = new FileInputStream(profilepath);
            properties.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }

    public synchronized static boolean updateProperties(String keyname,String keyvalue) {
        boolean success = false;
        // region
        OutputStream out = null;
        InputStream in = null;
        Properties properties = new Properties();
        try {
            out = new FileOutputStream(profilepath);
            properties.setProperty(keyname, keyvalue);
            properties.store(out, "data compare quartz cron");
            out.flush();
            out.close();
            success=true;
        } catch (Exception e) {
            success=false;
            System.err.println("属性文件更新错误:"+e.getMessage());
        }finally {
            if(null!=out) {
                try {
                    out.close();
                    if(null!=in) in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // endregion
        return success;
    }

    public static void main(String[] args) {

    }


}
