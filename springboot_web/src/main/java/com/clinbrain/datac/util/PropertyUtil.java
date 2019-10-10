package com.clinbrain.datac.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

/**
 * @Author：ligen
 * @Date: Created:17:08  2019/7/10
 * @Description:
 **/
public class PropertyUtil {
    private PropertyUtil() {
    };

    private static class SingletonHolder{
        String file = PropertyUtil.class.getResource("/").getPath()+"compare.properties";
        private static PropertiesConfiguration propertyUtil = init(PropertyUtil.class.getResource("/").getPath()+"compare.properties");
    }

    public static PropertiesConfiguration getProps() {
        return SingletonHolder.propertyUtil;
    }

    /**
     * 初始化
     *
     * @param propertiesFile
     * @see
     */
    private static PropertiesConfiguration init(String propertiesFile) {
        PropertiesConfiguration PropertyUtil = null;
        try {
            PropertyUtil = new PropertiesConfiguration(propertiesFile);
            // 自动重新加载
            PropertyUtil
                    .setReloadingStrategy(new FileChangedReloadingStrategy());
            // 自动保存
            PropertyUtil.setAutoSave(true);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return PropertyUtil;
    }

    /**
     * 根据Key获得对应的value
     *
     * @param key
     * @return
     * @see
     */
    public static Object getProperty(String key) {
        return getProps().getProperty(key);
    }

    /**
     * 设置属性
     *
     * @param key
     * @param value
     * @see
     */
    public static void setProperty(String key, String value) {
        getProps().setProperty(key, value);
    }

    public static void main(String[] args) {
    }
}
