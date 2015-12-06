<%-- 
    Document   : Main
    Created on : 06.12.2015, 18:12:20
    Author     : SofySmo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="active_page" value="Main.jsp" scope="session" />
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
        <link rel="stylesheet" type="text/css" href="style/main.css">
        <script type="text/javascript" src="js/main.js"></script>
        <title><fmt:message key="navigation_menu_item_0" /></title>
    </head>
    <body>
        <div id="main_conteiner">
           <div id="header-conteiner">
               
               <div id="Hat">
                   <c:import url="Hat.jsp?lang=${lang}&parant=Login.jsp"/>                  
              </div>
           </div>
        </div>
              
        <div id="big_contain">
             <div class="for_inline">
                               
                        <div class="channel-homepage_m">                      
                            <span id="welcome"><fmt:message key="welcome"/></span><br>
                            <span id="contin_wel"><fmt:message key="contin_wel"/>  </span>
                            <span id="febos_span"><fmt:message key="title_site"/></span><br>
                            <span id="here_can"><fmt:message key="here_can"/></span>
                        </div>
             </div>
        </div>
           <div class="endpage">
              <p>&copy;2015 Фебос.</p>
           </div>
        </div>
    </body>
    
</html>