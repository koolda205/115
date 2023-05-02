package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnection;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() throws SQLException {
    }
    Statement statement = getConnection().createStatement();
    PreparedStatement preparedStatement;
    public static long idNumber = 1;

    public void createUsersTable() throws SQLException {
        String sql = "CREATE TABLE user (id INT, name VARCHAR(255), lastname VARCHAR(255), age INT)";
        try {
            statement.executeUpdate(sql);
            System.out.println("Таблица создана");
        } catch (SQLException e) {
            System.err.println("Не удалось создать таблицу");
        }

    }
    public void dropUsersTable() throws SQLException {
        String sql = "DROP TABLE user";
        try {
            statement.executeUpdate(sql);
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            System.err.println("Таблица не удалена");
        }

    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {

        String sql = "INSERT INTO user values (?, ?, ?, ?)";
        idNumber = idNumber + 1;

        try {
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setLong(1, idNumber);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, lastName);
            preparedStatement.setByte(4, age);

            preparedStatement.executeUpdate();
            System.out.println("Добавлен новый User");
        } catch (SQLException e) {
            System.err.println("Не добавлен новый User");
        }

    }
    public void removeUserById(long id) throws SQLException {
        String sql = "DELETE FROM user WHERE id = ?";
        try {
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setLong(1, idNumber);

            preparedStatement.executeUpdate();
            System.out.println("Удален User с id: " + id);
        } catch (SQLException e) {
            System.err.println("Не удален User с id: \" + id");
        }

    }

    public List<User> getAllUsers() throws SQLException {
        List <User> result = new ArrayList<>();
        String sql = "SELECT * FROM user";
        User user = new User();

        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));

                result.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Список не получился");
        }
        System.out.println(Arrays.toString(result.toArray()));

        return result;

    }
    public void cleanUsersTable() throws SQLException {
        String sql = "DELETE FROM user";
        try {
            statement.executeUpdate(sql);
            System.out.println("Таблица очищена");
        } catch (SQLException e) {
            System.err.println("Таблица не удалена");
        }

    }

}

