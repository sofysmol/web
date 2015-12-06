<%-- 
    Document   : PersonalAccount
    Created on : 14.11.2015, 14:14:37
    Author     : SofySmo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@page language="java" import="domain.*"%>
<%@page language="java" import="java.util.*"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="active_page" value="PersonalAccount.jsp" scope="session" />
<c:set var="history" value="${sessionScope.historyUser}"/>
<c:set var='comments' value="${sessionScope.comments}"/>
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
<html onload="">
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/newcss.css">
        <link rel="stylesheet" type="text/css" href="style/account.css">
        <script type="text/javascript" src="js/pageJS.js"></script>
        <script type="text/javascript" src="js/auth.js"></script>
        <script type="text/javascript" src="js/personal_account.js"></script>
        <script type="text/javascript" src="js/JS_data.js"></script>
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
                                <img src="style/img/panda.jpg" id="avatar" width="200px"/>
                                
                            <div id="info_account">
                                <label><fmt:message key='email'/>:</label>
                                <span>${user.getLogin()}</span>   <br><br>
                                <label><fmt:message key='tab'/></label>
                                <c:if test="${initParam.default_tab==0}">
                                <span><fmt:message key="characteristic"/></span> <br>
                                </c:if>
                                <c:if test="${initParam.default_tab==1}">
                                <span><fmt:message key="reviews"/></span> <br>
                                </c:if>
                            </div>      
                            <div id="datanow"></div>
                            <div id="timenow"></div>
                            <script>startTime('${lang}');</script>
                            </div>      
                                <div id="purchases_info">
                                    <h3><fmt:message key="my_purchases"/></h3>
                                    <table id="purchases">
                                        <tr>
                                            <td>№</td>
                                            <td><fmt:message key="info_product_0"/></td>
                                            <td><fmt:message key="info_product_1"/></td>
                                            <td><fmt:message key="shop"/></td>
                                            <td><fmt:message key="date_order"/></td>
                                            <td><fmt:message key="info_product_7"/></td>
                                        </tr>                                        
                                        <c:if test="${history!=null && history.size()!=0}">
                                        <c:forEach var="i" begin="0" end="${history.size()-1}">
                                        <c:set var="his" value="${history.get(i)}"/>
                                        <c:if test="${his!=null}">
                                        <tr>
                                            <td>${his.get(0)}</td>
                                            <td>${his.get(1)}</td>
                                            <td>${his.get(2)}</td>
                                            <c:choose>
                                                <c:when test='${his.get(3).equals("0")}'>
                                                   <td><fmt:message key="courier_delivery"/></td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>${his.get(3)}</td>
                                                </c:otherwise>
                                            </c:choose>                                            
                                            
                                            <td>${his.get(4)}</td>
                                            <td>&#36;${his.get(5)}</td>                                           
                                        </tr>
                                         </c:if>
                                        
                                        </c:forEach>
                                        </c:if>
                                         <tr>
                                            <td>_ </td>
                                            <td> </td>
                                            <td> </td>
                                            <td> </td>
                                            <td> </td>
                                            <td></td>                                           
                                        </tr>
                                    </table>
                                </div>
                                        <div id="com_bl">
                                            <h3><fmt:message key="my_review_about_shop"/></h3>
                                            <div id="comments"> 
                                                <c:if test="${comments!=null && comments.size()!=0}">
                                                <c:forEach var="i" begin="0" end="${comments.size()-1}">
                                                    <div class="comment">${comments.get(i).getContent()}</div>
                                                </c:forEach>
                                                </c:if>
                                            </div>
                                            <div id="input_comment">
                                                <textarea name="comment" id="new_com" rows="3" spellcheck placeholder=<fmt:message key="comments"/> ></textarea>
                                                <div class="button_next" onclick="sendComment();">
                                                    <fmt:message key="send"/>
                                                </div>
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

