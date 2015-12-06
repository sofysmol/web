<%-- 
    Document   : product
    Created on : 22.10.2015, 14:14:54
    Author     : SofySmo
--%>


<%@page import="domain.*"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.File"%>
<%@page import="java.util.ResourceBundle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.Locale"%>
<%
    String name=request.getParameter("name");
    String author=request.getParameter("author");
    String lang=request.getParameter("lang");
    String path=request.getParameter("path");
    String price=request.getParameter("price");
    int i=0;
    int j=0;
    Locale locale=new Locale(lang);
    ResourceBundle res=ResourceBundle.getBundle("page_product", locale);
    %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/newcss.css">
        
        <script src="masonry.js"></script>
    </head>
    <body>        
                      <img src="<%=path%>" width="200" alt="<%=path%>"/>
                      <div class="product-attributs" id="shot_info">
                          <p><%=res.getString("info_product_0")%>: <%=author%></p>
                        <p><%=res.getString("info_product_1")%>: <%=name%></p>
                            <p><%=res.getString("info_product_7")%>:&#36; <%=price%></p>
                      </div>
                    
    </body>
</html>
