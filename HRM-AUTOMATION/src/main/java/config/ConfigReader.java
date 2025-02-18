package config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties config = new Properties();

    static{
        try{
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            config.load(fis);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return config.getProperty(key);
    }
}
