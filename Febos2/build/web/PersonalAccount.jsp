<%-- 
    Document   : PersonalAccount
    Created on : 14.11.2015, 14:14:37
    Author     : SofySmo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@page language="java" import="domain.*"%>
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
<c:set var="user" value="${sessionScope.user}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/newcss.css">
        <link rel="stylesheet" type="text/css" href="style/account.css">
        <script type="text/javascript" src="js/pageJS.js"></script>
        <script type="text/javascript" src="js/auth.js"></script>
        <title><fmt:message key="header_3" /></title>
    </head>
    <body>
        <div id="main_conteiner">
           <div id="header-conteiner">
               
               <div id="hat_page">
                   <c:import url="hat_page.jsp?lang=${lang}&parant=PersonalAccount.jsp"/>                  
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
                            <h2><fmt:message key='header_2'/></h2>
                            <div id="profile">
                                <img src="style/panda.jpg" id="avatar" width="200px"/>
                            <div id="info_account">
                                <h3>${user.getName()} ${user.getSurname()}</h3>
                                <label><fmt:message key='email'/></label>
                                <span>${user.getEmail()}</span>   <br><br>
                                <label><fmt:message key='tab'/></label>
                                <c:if test="${initParam.default_tab==0}">
                                <span><fmt:message key="characteristic"/></span> <br>
                                </c:if>
                                <c:if test="${initParam.default_tab==1}">
                                <span><fmt:message key="reviews"/></span> <br>
                                </c:if>
                            </div>        
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
