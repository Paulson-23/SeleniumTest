package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestRunConfig {

    public static final String Browser = get("browser");

    private static String get(String property) {
        String value = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            value = properties.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace(); // You can log this or rethrow as a runtime exception
        }
        return value;
    }


    public static final String url=getBaseUrl("url");

    private static String getBaseUrl(String property) {
        String value = null;
        try {
            FileInputStream fileInputStream1 = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream1);
            String link = properties.getProperty(property);
            FileInputStream fileInputStream2 = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/environment.properties");
            Properties properties2 = new Properties();
            properties2.load(fileInputStream2);
            value = properties2.getProperty(link + ".base.url");
        } catch (IOException e) {
            e.printStackTrace(); // Or use a logger if preferred
        }
        return value;
    }
}
