package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;

public class Util {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private static final String USERNAME = "rootroot";
    private static final String PASSWORD = "root";
    public static Connection connection;
    public static SessionFactory sessionFactory;

    public static SessionFactory getConnection() {

        try {
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.driver_class", DRIVER)
                    .setProperty("hibernate.connection.url", URL)
                    .setProperty("hibernate.connection.username", USERNAME)
                    .setProperty("hibernate.connection.password", PASSWORD)
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
                    .addAnnotatedClass(User.class)
                    .setProperty("hibernate.c3p0.min_size","5")
                    .setProperty("hibernate.c3p0.max_size","200")
                    .setProperty("hibernate.c3p0.max_statements","200");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
}

//    public static Connection getConnection(){
//
//        try {
//            FabricMySQLDriver driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
//        } catch (SQLException e) {
//            System.err.println("Не удалось загрузить драйвер");
//        }
//        try {
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            System.out.println("Соединение установлено");
//        } catch (SQLException e) {
//            System.err.println("Не удалось соединение");
//        }
//        return connection;
//    }
//}
