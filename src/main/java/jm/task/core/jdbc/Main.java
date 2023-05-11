package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException {

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Name12", "LastName11", (byte) 20);
        userService.saveUser("Name22", "LastName21", (byte) 25);
        userService.saveUser("Name32", "LastName31", (byte) 31);

        userService.getAllUsers();
        userService.removeUserById(6);

        userService.cleanUsersTable();
        userService.dropUsersTable();

    }

}
