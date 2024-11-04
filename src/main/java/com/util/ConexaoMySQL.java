package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoMySQL {

    private static final String PROPERTIES_FILE = "db.properties";

    public static Connection conectar() {
        Properties props = new Properties();
        try (InputStream input = ConexaoMySQL.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                System.out.println("Desculpe, não foi possível encontrar " + PROPERTIES_FILE);
                return null;
            }
            props.load(input);

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