package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.util.Properties;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/first_db?useSSL=false";
    private static final String USERNAME = "rootroot";
    private static final String PASSWORD = "root";
    public static Connection connection;
    public static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();

                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, URL);
                settings.put(Environment.USER, USERNAME);
                settings.put(Environment.PASS, PASSWORD);
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                System.out.println("No Problem creating session factory");
            } catch (Exception e) {
                System.out.println("Problem creating session factory");
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

//    public static Connection getConnection(){
//
//        try {
//            Driver driver = new FabricMySQLDriver();
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


}
