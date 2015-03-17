package com.seostella.hibernate.basics.dao;

import com.seostella.hibernate.basics.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.util.List;

/**
 *
 * @author seostella.com
 */
public class UserDAO extends DAO {

    public User createUser(String username, String password)
            throws Exception {
        try {
            begin();
            User user = new User(username, password);
            getSession().save(user);
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not create user " + username, e);
        }
    }

    public User retrieveUser(String username) throws Exception {
        try {
            begin();
            Query q = getSession().createQuery("from User where name = :username");
            q.setString("username", username);
            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get user " + username, e);
        }
    }

    public void deleteUser( User user ) throws Exception {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not delete user " + user.getName(), e);
        }
    }

    public List<User> list() throws Exception{
        try {
            begin();
            List<User> users = getSession().createQuery("from User").list();
            return users;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get user list", e);
        }
    }
}
