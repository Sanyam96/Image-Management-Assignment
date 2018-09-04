<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.nagarro.models.User"%>
<%@page import="com.nagarro.models.Image"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
    <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- link
        href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
        rel="stylesheet" id="bootstrap-css"-->
    <!-- script
        src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script-->
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script
        src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <!-- script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script-->
    </head>

    <body>
        <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Image Management</a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <%
                    if (session.getAttribute("user") == null) {
                        response.sendRedirect("index.jsp");
                %>
                <jsp:forward page="index.jsp">
                    <jsp:param name="tutorialname" value="jsp forward action" />
                </jsp:forward>
                <%
                    }
                    String fullName = "";
                    User user = (User) session.getAttribute("user");
                    try {
                        fullName = user.getFullName();
                    } catch (Exception e) {
                        response.sendRedirect("index.jsp");
                    }
                %>
                <li><a href="Logout"><span
                        class="glyphicon glyphicon-log-in"><%=fullName%></span> Logout</a></li>
            </ul>
        </div>
        </nav>

        <div class="container">
            <form action="ImageUpload" method="post" enctype="multipart/form-data">
                <input type="text" name="imagename" placeholder="Name of image" required>
                <br />
                <input type="file" name="image"
                    accept="image/*" required> <br /> <input type="submit"
                    value="Upload">
                <hr />
            </form>
            <%
                if (session.getAttribute("message") != null) {
                    String message = session.getAttribute("message").toString();
            %>
            <p>
                <%=message%>
            </p>
            <%
                }
            %>


        </div>

        <div class="container">
            <div class="row">


                <div class="col-md-12">
                    <h4>Images Available</h4>
                    <div class="table-responsive">


                        <table id="mytable" class="table table-bordred table-striped">

                            <thead>

                                <th>Image Id</th>
                                <th>Image</th>
                                <th>Image Name</th>
                                <th>Image Size</th>
                                <th>Edit</th>

                                <th>Delete</th>
                            </thead>
                            <tbody>
                                <%
                                    Collection<Image> images = user.getImages();
                                    int i = 0;
                                    if (!images.isEmpty()) {
                                        for (Image image : images) {
                                            i++;
                                %>
                                <!-- This will be in a for loop for all the images there are  -->
                                <tr>
                                    <td><%=i%></td>
                                    <td><img
                                        src="ImageRetriever?imageId=<%=image.getImageId()%>"
                                        height="99" width="99"></img></td>
                                    <td><%=image.getImageName()%></td>
                                    <td><%=image.getImageSize()%></td>
                                    <!-- Modal starts here -->
                                    <td>
                                        <button type="button"
                                            class="glyphicon glyphicon-edit btn btn-primary a-btn-slide-text"
                                            data-toggle="modal" data-target="#editModal">Edit</button> <!-- Modal -->
                                        <div class="modal fade" id="editModal" role="dialog">
                                            <div class="modal-dialog">

                                                <!-- Modal content-->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title">Edit Image</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <form action="ImageEdit?imageId=<%=image.getImageId()%>"
                                                            method="post" enctype="multipart/form-data">
                                                            <input type="text" name="imagenamenew"
                                                                placeholder="Name of image"
                                                                value=<%=image.getImageName()%> required> <br />
                                                            <input type="file" name="imagenew" accept="image/*"
                                                                required> <br /> <input type="submit"
                                                                value="Update">
                                                            <hr />
                                                        </form>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default"
                                                            data-dismiss="modal">Close</button>
                                                    </div>
                                                </div>

                                            </div>
                                        </div> <!-- Modal ends here --> <!-- a href="#"
                                        class="btn btn-primary a-btn-slide-text"> <span
                                            class="glyphicon glyphicon-edit" aria-hidden="true"></span> <span><strong>Edit</strong></span>
                                    </a-->
                                    <td><a href="ImageDelete?imageid=<%=image.getImageId()%>"
                                        class="btn btn-primary a-btn-slide-text"> <span
                                            class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                            <span><strong>Delete</strong></span>
                                    </a>
                                </tr>
                                <%
                                    }
                                    }
                                %>
                                </div>
                                </div>
                                </div>
                                </div>
    </body>
    </html>
    </body>
</html>