package jm.task.core.jdbc.util;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

    public static void getConnection() {

        final String URL = "jdbc:mysql://localhost:3306/mybase";
        final String USERNAME = "rootroot";
        final String PASSWORD = "root";
        Connection connection;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("ok");
            }
            connection.close();
            if (connection.isClosed()) {
                System.out.println("close");
            }
        } catch (SQLException e) {
            System.err.println("Не удалось загрузить драйвер");
//            e.printStackTrace();

        }

    }
}
