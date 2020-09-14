package com.dyz.dev.utils.cache;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
    public static String getValueByKey(String key) {
        InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("application.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = prop.getProperty(key) != null ? prop.getProperty(key) : "";
        return value;
    }
}
