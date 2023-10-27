<%-- 
    Document   : cart
    Created on : Oct 27, 2023, 11:12:10 AM
    Author     : ItipatSongsampansakul
--%>

<%@page import="controller.CallProductTable"%>
<%@page import="java.util.List"%>
<%@page import="model.Product3"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Cart</title>
        <link href="Css/Style.css" rel ="stylesheet" type ="text/css"/>
    </head>
    <body>        
        <center>
            <h1>Shopping Cart</h1>
            <form name="AddToCartForm" action="ShowConfirmation_Controller" method="POST">
                <table border="1" width="30%" cellspacing="1" cellpadding="1" >
                    <thead>
                        <tr>
                            <th>DVD names</th>
                            <th>Rating</th>
                            <th>Year</th>
                            <th>Price/Unit</th>
                            <th>Quantity</th>
                            <th>Price</th>
                        </tr>
                    </thead>

                    <tbody>
                        <%
                            String[] checkbArray = request.getParameterValues("CBDVDName"); //Movie name add in array
                            List<Product3> pdList = CallProductTable.findAllProduct();
                            for(String MVname : checkbArray){  // call all Movie name                      
                                for(Product3 pd : pdList){  
                                    if(MVname.trim().equals(pd.getMovie()) && !request.getParameter(MVname.trim()).equals("")){  
                        %>
                        <tr>
                            <td>
                                <%= pd.getMovie() %>
                            </td>
                            <td>
                                <%= pd.getRating() %>
                            </td>
                            <td>
                                <%= pd.getYearcreate() %>
                            </td>
                            <td>
                                <%= pd.getPrice() %>
                            </td>
                            <td>
                                <%= Integer.parseInt(request.getParameter(MVname.trim()))%>
                            </td>
                            <td>
                                <%= request.getAttribute(MVname.trim() + "_unitPrice")%>
                            </td>
                        </tr>
                        <%}}}%>
                        <tr>
                            <td colspan="5">  
                                <div style="text-align: center;">
                                    Total
                                </div>
                            </td>
                            <td>
                                <% out.println(request.getAttribute("totalPrice")); %>
                            </td>
                        </tr>  
                    </tbody>
                </table>                
                    <input type="submit" value="Check out" name="BTCheckOut" />
                    <%= "<input type=\"hidden\" value=\"" + request.getAttribute("totalPrice") + "\"name=\"totalPrice\">" %>
            </form>
        </center>               
    </body>
    
</html>
