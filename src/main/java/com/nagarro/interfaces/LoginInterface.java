package com.nagarro.interfaces;

import com.nagarro.models.User;

/**
 * @author Sanyam Goel created on 4/9/18
 */
public interface LoginInterface {

    Boolean userAuthentication(String username, String password);

    User getUserDetails(String username);
}
