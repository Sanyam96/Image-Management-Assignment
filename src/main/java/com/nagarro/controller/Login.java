package com.nagarro.controller;

import com.nagarro.models.User;
import com.nagarro.services.LoginImplementation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sanyam Goel created on 4/9/18
 */
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginImplementation login = new LoginImplementation();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (login.userAuthentication(username, password)) {
            User user = login.getUserDetails(username);
            request.getSession().setAttribute("authorized", "true");
            request.getSession().setAttribute("user", user);
            response.sendRedirect("userhome.jsp");
        } else {
            request.getSession().setAttribute("authorized", "false");
            response.sendRedirect("index.jsp");
        }
    }
}

