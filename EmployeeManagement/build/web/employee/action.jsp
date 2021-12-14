<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : action
    Created on : Dec 12, 2021, 9:47:46 AM
    Author     : Loki Kun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Action Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h2>Add new</h2>
            <c:if test="${errors != null}">
                <div class="alert alert-danger" role="alert">
                           This Employee is existed, please try other!!
                </div>
            </c:if>
            
            <form class="form-horizontal" method="post">
                <div class="form-group">
                    <label class="control-label col-sm-2" >Employee No:</label>
                    <div class="col-sm-10">
                        <input type="text" name="employeeNo" class="form-controll" placeholder="Enter Employee No" required/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" >Name</label>
                    <div class="col-sm-10">          
                        <input type="text" name="name" class="form-controll" placeholder="Enter Name" required/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" >Place of Work</label>
                    <div class="col-sm-10">          
                        <input type="text" name="place" class="form-controll" placeholder="Enter Place Of Work" required/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" >Phone</label>
                    <div class="col-sm-10">          
                        <input type="text" name="phone" class="form-controll" placeholder="Enter Phone" required/>
                    </div>
                </div>
                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>
            </form>
        </div>

    </body>
</html>
