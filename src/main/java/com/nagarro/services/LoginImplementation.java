package com.nagarro.services;

import com.nagarro.interfaces.LoginInterface;
import com.nagarro.models.User;
import com.nagarro.utils.HibernateUtilities;
import org.hibernate.Session;

/**
 * @author Sanyam Goel created on 4/9/18
 */
public class LoginImplementation implements LoginInterface {

    /**
     * returns true if user with the given name and password exists
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public Boolean userAuthentication(String username, String password) {
        try (Session session = HibernateUtilities.getSessionInstance()) {
            session.getTransaction().begin();
            User user = session.get(User.class, username);
            if (user.getUsername() != null && user.getPassword().equals(password))
                return true;
            else
                return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Returns user with given username
     *
     * @param username
     * @return
     */
    @Override
    public User getUserDetails(String username) {
        User user = null;
        try (Session session = HibernateUtilities.getSessionInstance();) {
            session.getTransaction().begin();
            user = session.get(User.class, username);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    /**
     * Updates the password for a given username
     *
     * @param username
     * @param password
     */
    public void updatePassword(String username, String password) {
        User user = null;
        try (Session session = HibernateUtilities.getSessionInstance();) {
            session.getTransaction().begin();
            user = session.get(User.class, username);
            user.setPassword(password);
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
