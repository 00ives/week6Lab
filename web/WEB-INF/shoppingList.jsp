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
            <!--            <a href="login?logout" name="logout" value="logout"> Logout</a>
                        value='/cart?productCode=8601' -->
            <a href="<c:url value='/ShoppingList?logout=logout'/>" >Logout</a>
        </div> 

        <h2>List</h2>
        <form action="ShoppingList" method="post">

            Add item: <input type="text" name="userItemInput"> <input type="submit" value="Add">
        </form>

        <form action="ShoppingList" method="post">
            <ul>

                <c:forEach items="${store.shoppingList}" var="x" varStatus="loop">

                    <input type="radio" name="groceryList" value="${loop.index}" >
                    <label>${x.getItem()}</label>
                    <br>

                </c:forEach>

            </ul>

            <input type="submit" value="Delete">
        </form>    
        <h1> the loop index is ${loopIndex}</h1>  
    </body>
</html>
