package com.nagarro.controller;

import com.nagarro.models.User;
import com.nagarro.services.LoginImplementation;
import com.nagarro.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sanyam Goel created on 4/9/18
 */
public class ResetPassword extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ResetPassword() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        request.getSession().setAttribute("message", "");
        LoginImplementation login = new LoginImplementation();
        String username = request.getParameter("username");
        String fullName = request.getParameter("fullname");
        String password = request.getParameter("passwordnew");
        String passwordConfirm = request.getParameter("passwordnewconfirm");
        User user = login.getUserDetails(username);
        if (user != null) {
            if (password.equals(passwordConfirm)) {
                if (user.getFullName().equalsIgnoreCase(fullName)) {
                    login.updatePassword(username, password);
                    request.getSession().setAttribute("passwordmessage", "Password Updated Successfully");
                    message = "Success";
                } else {
                    request.getSession().setAttribute("passwordmessage", "One of the given information is incorrect... (Full Name)");
                    message = "One of the given information is incorrect... (Full Name)";
                }
            } else {
                request.getSession().setAttribute("passwordmessage", "Password does not match");
                message = "Password does not match";
            }
        } else {
            request.getSession().setAttribute("passwordmessage", "No user exists with such username");
            message = "No user exists with such username";
        }
        System.out.println(message);

        response.sendRedirect(Constants.indexPage);
    }

}
