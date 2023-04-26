package jm.task.core.jdbc.util;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД

    public static void getConnection() {

        final String URL = "jdbc:mysql://localhost:3306/mybase?useSSL=false";
        final String USERNAME = "rootroot";
        final String PASSWORD = "root";


        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.println("Не удалось загрузить драйвер");
        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            System.out.println("Соединение установлено? - " + !connection.isClosed());
        } catch (SQLException e) {
            System.err.println("Не удалось соединение");
        }
    }
}
