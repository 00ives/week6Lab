<%-- 
    Document   : shoppingList
    Created on : 9-Oct-2022, 12:19:47 PM
    Author     : ivorl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>

        <div>
            Hello, ${username}

            <a href="<c:url value='/ShoppingList'/>">Logout</a>
        </div> 

        <h2>List</h2>

        Add item: <input type="text" name="item"> <input type="button" value="Add">

        <ul>
            <li>fasdf</li>
        </ul>
        
        <input type="button" value="Delete">
    </body>
</html>
