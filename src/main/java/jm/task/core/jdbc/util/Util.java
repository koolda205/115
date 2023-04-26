package jm.task.core.jdbc.util;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/mybase?useSSL=false";
    private static final String USERNAME = "rootroot";
    private static final String PASSWORD = "root";


    public static Connection getConnection() {

        Connection connection = null;
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
        } finally {
            try {
                connection.close();
                System.out.println("Соединение закрыто");
            } catch (SQLException e) {
                System.err.println("Соединение не закрыто");
            }
        }
        return connection;
    }
}
