package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import java.sql.SQLException;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class Main {
    public static void main(String[] args) throws SQLException, HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException {

        UserService userService = new UserServiceImpl();

        getSessionFactory();

        userService.createUsersTable();

        userService.saveUser("Name1", "LastName1", (byte) 20);
        userService.saveUser("Name2", "LastName2", (byte) 25);
        userService.saveUser("Name3", "LastName3", (byte) 31);
        userService.saveUser("Name4", "LastName4", (byte) 38);
//
//        userService.getAllUsers();
//        userService.removeUserById(4);
//
//        userService.cleanUsersTable();
//        userService.dropUsersTable();

    }



}
