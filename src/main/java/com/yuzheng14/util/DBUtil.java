package com.yuzheng14.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author yuzheng14
 */
@Component
@PropertySource("classpath:/MySQL-config.properties")
public class DBUtil {

    private static String URL;
    private static String LOGIN_NAME;
    private static String PASSWORD;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Properties properties = new Properties();
            // 使用InPutStream流读取properties文件
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/main/resources/MySQL-config.properties")));
            properties.load(bufferedReader);
            // 获取key对应的value值
            URL=properties.getProperty("url");
            LOGIN_NAME=properties.getProperty("loginName");
            PASSWORD=properties.getProperty("password");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, LOGIN_NAME, PASSWORD);
    }
}
