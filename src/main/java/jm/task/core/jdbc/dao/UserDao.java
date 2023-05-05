package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void createUsersTable() throws SQLException, HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException;

    void dropUsersTable() throws SQLException, HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException;

    void saveUser(String name, String lastName, byte age) throws SQLException;

    void removeUserById(long id) throws SQLException;

    List<User> getAllUsers() throws SQLException;

    void cleanUsersTable() throws SQLException;
}
