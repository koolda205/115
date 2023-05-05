package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import java.sql.SQLException;
import java.util.List;


public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoHibernateImpl();

    public UserServiceImpl() throws SQLException {
    }

    public void createUsersTable() throws SQLException, HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException {
        userDao.createUsersTable();
    }

    public void dropUsersTable() throws SQLException, HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        userDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws SQLException {
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return  userDao.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
        userDao.cleanUsersTable();
    }
}
