package com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoMySQL {

    private static final String PROPERTIES_FILE = "db.properties";

    public static Connection conectar() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)) {
            props.load(fis);

            String url = props.getProperty("db.url");
            String usuario = props.getProperty("db.username");
            String senha = props.getProperty("db.password");

            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
