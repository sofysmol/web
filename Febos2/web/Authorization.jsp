<%-- 
    Document   : Authorization
    Created on : 08.11.2015, 1:23:25
    Author     : SofySmo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
<c:when test="${empty param.lang}">
    <c:set var="lang" value="ru"/>
</c:when>
<c:otherwise>
    <c:set var="lang" value="${param.lang}"/>
</c:otherwise>
</c:choose>
<fmt:setBundle var="en" basename="page_product_en" />
<fmt:setBundle basename="page_product_${lang}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/newcss.css">
        <script type="text/javascript" src="js/pageJS.js"></script>
        <script type="text/javascript" src="js/auth.js"></script>
        <link rel="stylesheet" type="text/css" href="style/auth.css">
        <title><fmt:message key="header_3" /></title>
    </head>
    <body>
        <div id="main_conteiner">
           <div id="header-conteiner">
               
               <div id="hat_page">
                   <c:import url="hat_page.jsp?lang=${lang}&parant=Authorization.jsp"/>                  
              </div>
           </div>
        </div>
              
        <div id="big_contain">
             <div class="for_inline">
                <div id="shopfilter">
                    <h3><fmt:message key="left-menu_painting"/></h3>
                    <ul class="menu-list" id="left-navigation">
                        <li class="left-navigation-item">
                            <a class="left-link" href="http://localhost:8084/Febos2/ListOfProductsPage.jsp?lang=${lang}"><fmt:message key="left-navigation-item_0" /></a>
                        </li>
                        <c:forEach var="i" begin="1" end="4">
                            <li class="left-navigation-item">
                                <a class="left-link" href="http://localhost:8084/Febos2/ListOfProductsPage.jsp?lang=${lang}&genre_filter=<fmt:message bundle="${en}" key="left-navigation-item_${i}"/>"><fmt:message key="left-navigation-item_${i}" /></a>
                        </li>
                        </c:forEach>
                        </ul>
                </div>
                
                        <div class="channel-homepage">
                            
                            
                            <div id="auth">
                                
                                <h2><fmt:message key="header_3"/></h2>
                                <form action="j_security_check" method="post" name="loginForm">
                                    <label for="name"><fmt:message key="name"/></label><br>
                                    <input type="text" id="name" name="username" placeholder=<fmt:message key='name'/> size="30"/><br><br>
                                    
                                     <label for="surname"><fmt:message key="surname"/></label><br>
                                    <input type="text" id="surname" name="usersurname"  placeholder=<fmt:message key='surname'/> size="30"/><br><br>
                                    
                                    <label for="email"><fmt:message key="email"/></label><br>
                                    <input type="text" id="email" name="useremail" placeholder=<fmt:message key='email'/> size="30"/><br><br>
                                    
                                    <label for="password"><fmt:message key="password" /></label><br>
                                    <input type="password" id="password" name="password" size="30"  placeholder=<fmt:message key='password'/> /><br><br>                                   
                                    <input type="submit" value=<fmt:message key="header_0"/> />
                                </form>
                                
                                
                            </div>
                          
                        </div>
             </div>
        </div>
           <div class="endpage">
              <p>&copy;2015 Фебос.</p>
           </div>
        </div>
    </body>
    
</html>
