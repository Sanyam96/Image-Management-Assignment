package com.nagarro.controller;

import com.nagarro.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sanyam Goel created on 4/9/18
 */
public class Logout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Logout() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("authorized");
        request.getSession().invalidate();
        response.sendRedirect(Constants.logoutPage);
    }

}

