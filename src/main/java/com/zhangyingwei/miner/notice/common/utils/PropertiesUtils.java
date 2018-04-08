package com.zhangyingwei.miner.notice.common.utils;

import java.io.*;
import java.util.Properties;

/**
 * Created by zhangyw on 2018/4/8.
 */
public class PropertiesUtils {
    private static final String filePath = "resources/miner-mail.properties";
//    private static final String filePath = "src/main/resources/miner-mail.properties";
    private static Properties properties;
    public static void loadProp() throws IOException {
        if (properties == null) {
            properties = new Properties();
            properties.load(new InputStreamReader(new FileInputStream(new File(filePath)),"utf-8"));
        }
    }

    public static String get(String key) throws IOException {
        if (properties == null) {
            loadProp();
        }
        return properties.getProperty(key);
    }
}
