package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import javax.management.Query;
import javax.transaction.*;
import java.util.Arrays;
import java.util.List;

import static jm.task.core.jdbc.util.Util.*;
public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }
    @Override
    public void createUsersTable() throws HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "CREATE TABLE IF NOT EXISTS users " +
                "(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50) NOT NULL, lastName VARCHAR(50) NOT NULL, " +
                "age TINYINT NOT NULL)";

        NativeQuery query = session.createSQLQuery(sql).addEntity(User.class);
        transaction.commit();
        session.close();
        System.out.println("Table was create and session was closed");
    }

    @Override
    public void dropUsersTable() throws HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "DROP TABLE user";
        NativeQuery query = session.createSQLQuery(sql).addEntity(User.class);
        transaction.commit();
        session.close();
        System.out.println("Table was dropted and session was closed");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        User user = new User(name, lastName, age);
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        System.out.println("User was added and session was closed");
        }

//        User user = new User(name, lastName, age);
//        Session session = getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        session.save(user);
//        session.getTransaction().commit();
//        session.close();
//        System.out.println("User was added and session was closed");
//    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        List <User> result = null;
        try (Session session = sessionFactory.openSession()) {
            Query query = (Query) session.createQuery("FROM User").list();
            System.out.println(Arrays.toString(result.toArray()));
        }
        return result;
    }

    @Override
    public void cleanUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "DROP TABLE IF EXISTS user";
        NativeQuery query = session.createSQLQuery(sql).addEntity(User.class);
        transaction.commit();
        session.close();
        System.out.println("Table was dropted and session was closed");

    }
}
