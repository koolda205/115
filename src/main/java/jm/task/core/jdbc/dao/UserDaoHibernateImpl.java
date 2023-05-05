package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;
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

        String sql = "DROP TABLE IF EXISTS users";
        NativeQuery query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();

        transaction.commit();
        session.close();
        System.out.println("Table was dropped and session was closed");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

//        User user = new User(name, lastName, age);
//        Session session = getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(user);
//        transaction.commit();
//        session.close();
//        System.out.println("User was added and session was closed");
//        }

//        User user = new User(name, lastName, age);
//        Session session = getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        session.save(user);
//        session.getTransaction().commit();
//        session.close();
//        System.out.println("User was added and session was closed");

        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User(name, lastName, age);

        session.save(user);
        transaction.commit();
        session.close();
        System.out.println("User was added and session was closed");
    }

    @Override
    public void removeUserById(long id) {
//        User user = new User();
//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//        user = session.get(User.class, id);
//        session.remove(user);
//        session.getTransaction().commit();
//        session.close();
//        System.out.println("User was deleted and session was closed");
//        Session session = getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        User user = (User) session.get(User.class, id);
//        String sql = "DELETE FROM user WHERE id = :id";
//        NativeQuery query = session.createSQLQuery(sql).addEntity(User.class);
//        query.setParameter("id", id);
//        query.executeUpdate();
//
//        transaction.commit();
//        session.close();
//        System.out.println("User was deleted and session was closed");
//    }
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        User user = (User) session.get(User.class, id);

        session.remove(user);
        transaction.commit();
        session.close();
        System.out.println("User was deleted and session was closed");
    }

    @Override
    public List<User> getAllUsers() {
//        List <User> result = null;
//        String hql = "FROM User";
//        try (Session session = sessionFactory.openSession()) {
//            NativeQuery query = session.createSQLQuery(hql);
//            query.list();
//            System.out.println(Arrays.toString(result.toArray()));
//        }
//        return result;
//    }


//        Session session = getSessionFactory().openSession();
//
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//
//        CriteriaQuery cq = cb.createQuery(User.class);
//
//        Root<User> root = cq.from(User.class);
//
//        cq.select(root);
//
//        Query query = session.createSQLQuery(String.valueOf(cq));
//
//        List<User> result = query.getResultList();
//
//        session.close();
//
//        result.forEach(System.out::println);
//
//        return result;
//    }
//        Session session = getSessionFactory().openSession();
//
//        List <User> result = session.createQuery("From User").list();
//
//        session.close();
//        result.forEach(System.out::println);
//        return result;
//    }
//        Session session = getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//
//        String sql = "SELECT * FROM user";
//
//        NativeQuery query = session.createSQLQuery(sql).addEntity(User.class);
//
//        List <User> result = query.list();
//        transaction.commit();
//        session.close();
//        result.forEach(System.out::println);
//        return result;
//    }
//        Session session = getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        List<User> result = null;
//        result.addAll(session.createCriteria(User.class).list());
//        session.close();
//        result.forEach(System.out::println);
//        return result;
//    }
//        Session session = getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//
//        List<User> result = session.createCriteria(User.class).list();
//
//        transaction.commit();
//        session.close();
//        result.forEach(System.out::println);
//        return result;
//    }

//        List<User> result = (List<User>)  Util.getSessionFactory().openSession().createQuery("From User").list();
//        result.forEach(System.out::println);
//        return result;
//    }
        Session session = getSessionFactory().openSession();
        CriteriaQuery<User> criteriaQuery = session.getCriteriaBuilder().createQuery(User.class);
        criteriaQuery.from(User.class);
        Transaction transaction = session.beginTransaction();
        List<User> result = session.createQuery(criteriaQuery).getResultList();
        try {
            transaction.commit();
            return result;
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return result;
    }


    @Override
    public void cleanUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "TRUNCATE TABLE user";

        NativeQuery query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();
        transaction.commit();
        session.close();
        System.out.println("Table was clean (TRUNCATE) and session was closed");

    }
}
