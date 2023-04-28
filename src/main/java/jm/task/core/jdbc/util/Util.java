package jm.task.core.jdbc.util;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/first_db?useSSL=false";
    private static final String USERNAME = "rootroot";
    private static final String PASSWORD = "root";
    public static Connection connection = null;

    public static Connection getConnection() {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.println("Не удалось загрузить драйвер");
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Соединение установлено");
        } catch (SQLException e) {
            System.err.println("Не удалось соединение");
        }
        return connection;
    }
}
