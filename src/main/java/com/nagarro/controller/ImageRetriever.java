package com.nagarro.controller;

import com.nagarro.models.Image;
import com.nagarro.services.ImageManagementImplementation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sanyam Goel created on 4/9/18
 */
public class ImageRetriever extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageRetriever() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        if(request.getSession().getAttribute("user") == null) {
            response.sendRedirect("index.jsp");
        }
        else {
            ImageManagementImplementation imageManagement = new ImageManagementImplementation();
            String imageId = request.getParameter("imageId");
            Image image = imageManagement.getImage(imageId);
            if (image != null) {
                response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
                try {
                    response.getOutputStream().flush();
                    response.getOutputStream().write(image.getPhoto());
                    response.getOutputStream().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}