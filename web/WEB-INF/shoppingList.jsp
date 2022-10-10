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
            <li>${test.shoppingList}</li>
            <li>${test.shoppingList[0]}</li>
            <li>${test.shoppingList[1]}</li>
            <li>${test.shoppingList[2]}</li>
            <li>${test.shoppingList[2].getItem()}</li>
            
            <input type="radio" name="groceryList" value="${test.shoppingList[0]}">
            <label>${test.shoppingList[0].getItem()}</label>
            <br>
            <input type="radio" name="groceryList" value="${test.shoppingList[1]}">
            <label>${test.shoppingList[1].getItem()}</label>
            <br>

            <%--<c:forEach  var="item" items="${test.shoppingList}">--%>
            <!--<li>${test.shoppingList}</li>-->
            <!--<li>${item.shoppingList.getItem()}</li>-->
            <!--<li>${item}</li>-->
            <%--</c:forEach>--%>


            <h1> try 2 </h1>
            <li>${shoppingList.shoppingList[1].getItem()}</li>
                <c:forEach items="${shoppingList.shoppingList}" var="x">
                <li>${x.getItem()}</li>
            </c:forEach>
        </ul>


            <input type="button" value="Delete">
        </form>    
    </body>
</html>
