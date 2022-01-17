package core;

import org.openqa.selenium.By;

import java.io.IOException;
import java.sql.Struct;
import java.util.Properties;

public class ReadProperties {
    private static Properties properties = null;
    private static String filename = "config.properties";

    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String getBrowserName() {
        return properties.getProperty("browser");
    }

    public static String getUsername() {
        return properties.getProperty("username");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }

    public static int getTimeOut() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }


    public static String getProject_name(){return properties.getProperty("project_name1");}
    public static String getAnnouncement(){return properties.getProperty("announcement1");}
    public static String getProject_name1(){return properties.getProperty("project_name1");}
    public static String getAnnouncement1(){return properties.getProperty("announcement1");}
    public static String getProject_name2(){return properties.getProperty("project_name2");}
    public static String getAnnouncement2(){return properties.getProperty("announcement2");}
    public static String getProject_name3(){return properties.getProperty("project_name3");}
    public static String getAnnouncement3(){return properties.getProperty("announcement3");}

}