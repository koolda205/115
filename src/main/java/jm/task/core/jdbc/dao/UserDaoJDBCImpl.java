package jm.task.core.jdbc.dao;

import com.mysql.jdbc.Connection;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

//    UserDaoJDBCImpl - здесь расписываем основной функционал
//    (CRUD методы взаимодействия с SQL)
//    String переменная = "команда на языке БД"
//    Statement переменная = наш метод из класса Util
//    используя нашу созданную переменную Statement,
//    запихиваем туда нашу переменную String (та, что с командами БД)

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() throws SQLException {
    }

    public static int count = 1;
    String create = "CREATE TABLE tab2 " +
            "(" +
            "id INT,\n" +
            "name VARCHAR(255) NOT NULL,\n" +
            "lastname VARCHAR(255) NOT NULL,\n" +
            "age INT,\n)";
    String drop = "DROP TABLE table";

    String remove = "select id, name, author from books";

    Connection connection = (Connection) Util.getConnection();
    Statement statement = connection.createStatement();

    public void createUsersTable() {
        try {
            statement.executeUpdate(create);
        } catch (SQLException e) {
            System.err.println("Не удалось создать таблицу");
        }
    }

    public void dropUsersTable() {
        try {
            statement.executeUpdate(drop);
        } catch (SQLException e) {
            System.err.println("Таблица удалена");
        }
    }

    public void saveUser(String name, String lastName, byte age) {

        User user = new User(name, lastName, age);
        String save = "INSERT INTO table (id, name, lastname, age) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(save);
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setInt(4, user.getAge());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Не добавлен новый User");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
            }

        }
    }

    public void removeUserById(long id) {
        try {
            statement.executeUpdate(remove);
        } catch (SQLException e) {
            System.err.println("Таблица удалена");
        }
    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
