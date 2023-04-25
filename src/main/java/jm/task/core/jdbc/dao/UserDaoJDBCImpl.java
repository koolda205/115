package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

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
