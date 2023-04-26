package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;




public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }
//    UserDaoJDBCImpl - здесь расписываем основной функционал
//    (CRUD методы взаимодействия с SQL)

//    String переменная = "команда на языке БД"
//    Statement переменная = наш метод из класса Util
//    используя нашу созданную переменную Statement,
//    запихиваем туда нашу переменную String (та, что с командами БД)

//    Statement statement = getConnection();
//    Statement statement = connection.createStatement()) {

    public void createUsersTable() {

    }

    public void dropUsersTable() {

    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
