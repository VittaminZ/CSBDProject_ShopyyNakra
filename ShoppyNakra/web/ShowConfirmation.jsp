<%-- 
    Document   : ShowComfirmation
    Created on : Oct 27, 2023, 11:22:43 AM
    Author     : ItipatSongsampansakul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm</title>
        <link href="Css/Style.css" rel ="stylesheet" type ="text/css"/>
    </head>
    <body>
        <h1>Your Order is confirmed!</h1>
        <h1>The total amount is $ <%= request.getAttribute("totalPrice") %></h1>
    </body>
</html>
