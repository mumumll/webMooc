package com.mumu.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author mumu
 * @Description:
 * @date 2021/4/15 17:22
 */
public class ProUtil {
    public Properties Pro;
    public ProUtil(String FilePath) {
        Pro = RedProperties(FilePath);
    }
    private Properties RedProperties(String FilePath) {
        Properties properties = new Properties();
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(FilePath);
            BufferedInputStream In = new BufferedInputStream(fileInputStream);
            properties.load(In);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return properties;

    }

    public String GetPro(String key) {
        String value;
        if (Pro.containsKey(key)) {
            value = Pro.getProperty(key);
            return value;
        }else {
            return "";
        }
    }
    public int GetLines() {
        return Pro.size();
    }



}
