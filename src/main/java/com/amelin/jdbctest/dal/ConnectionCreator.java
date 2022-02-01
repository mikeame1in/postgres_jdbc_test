package com.amelin.jdbctest.dal;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {
    private static final Properties PROPERTIES;
    private static final String DATABASE_URL;
    private static final String RESOURCE_NAME;

    static {
        PROPERTIES = new Properties();
        RESOURCE_NAME = "database.properties";

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(RESOURCE_NAME)) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DATABASE_URL = (String) PROPERTIES.getProperty("db.url");
    }

    private ConnectionCreator() {}

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, PROPERTIES);
    }

}
