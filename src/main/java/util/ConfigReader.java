package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    static{
        try(FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config.properties")){
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties");
        }
    }
    public static String getBrowser(){
        return properties.getProperty("browser");
    }
    public static String getUrl(){
        return properties.getProperty("baseUrl");
    }
}
