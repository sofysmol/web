<%-- 
    Document   : ProductPage
    Created on : 25.11.2015, 15:46:06
    Author     : SofySmo
--%>
<%@page language="java" import="domain.*"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ff" uri="/WEB-INF/tlds/myfunction.tld"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="active_page" value="ProductPage.jsp" scope="session" />
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
<c:choose>
<c:when test="${empty param.id}">
    <c:set var="idPicture" value="5"/>
</c:when>
<c:otherwise>
    <c:set var="idPicture" value="${param.id}"/>
</c:otherwise>
</c:choose>

<%--<c:set var="indexPicture" value=""/>--%>
<c:set var="art" value="${null}"/>
<c:forEach var="product" items="${sessionScope.art}">
    <c:if test="${product.getId() eq idPicture}">
        <c:set var="art" value="${product}"/>
    </c:if>
</c:forEach>
<c:if test="${art eq null}">
<c:set var="art" value="${ff:getArt(idPicture)}"/>
</c:if>
<c:set var="picture" value="${ff:getArtAsArray(art)}"/>
<!DOCTYPE html>
<html><head><title><fmt:message key="title_site"/></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style/newcss.css">
                    <link rel="stylesheet" type="text/css" href="style/hat_page.css">
                    <script type="text/javascript" src="js/auth.js"></script>
                    <script type="text/javascript" src="js/pageJS.js"></script>
                    <script type="text/javascript" src="js/buy_button.js"></script>
                    </head><body><div id="main_conteiner">
                    <div id="header-conteiner">
                    
                    
                    <div id="hat_page">
                            <c:import url="hat_page.jsp?lang=${lang}&parant=CartPage.jsp"/>  
                    </div>
        </div>
               </div>      
                    </div>
                    <div id=big_contain>
                    <div class=" for_inline">
                        <div id="shopfilter">
                            <h3><fmt:message key="left-menu_painting"/></h3>
                            <ul class="menu-list" id="left-navigation">
                                <li class="left-navigation-item">
                                    <a class="left-link" href="http://localhost:8084/Febos2/ListOfProductsPage.jsp?lang=${lang}"><fmt:message key="left-navigation-item_0"/></a> 
                                </li>
                                <c:forEach var="i" begin="1" end="4">
                                    <li class="left-navigation-item">
                                        <a class="left-link" href="http://localhost:8084/Febos2/ListOfProductsPage.jsp?lang=${lang}&genre_filter=<fmt:message bundle="${en}" key="left-navigation-item_${i}"/>">
                                            <fmt:message key="left-navigation-item_${i}"/></a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    <div class="channel-homepage">
                    <img id="main_picture" src="${art.pathartwork}" width="350" alt="${art.name}"/>
                    <div class="product-attributs" id="main_info">
                    <h3><fmt:message key="main_charact"/></h3>
                    <c:forEach var="i" begin="0" end="6">
                        <div>
                            <div class="with_points info_product_item">
                                <strong><fmt:message key="info_product_${i}"/></strong>
                            </div>
                           <span>${picture[i]}</span>
                        </div>
                    </c:forEach>
            <div id="buy_div">
                <span>&#36;${art.price}</span>
                    
                    <span class="buy_product" onclick="buyButtonFuck(${idPicture});">
                        <fmt:message key="buy"/>
                    </span>
            </div>
            </div>
                    <div id="bottom_list">
                        <ul class="horizontal_list">
                        <li  onclick=show1()>
                        <span id="characteristic" class="navigerion-bar-span">
                            <fmt:message key="characteristic"/></span>
                        </li>
                        <li  onclick=show2()>
                            <span id="reviews" class="navigerion-bar-span"><fmt:message key="reviews"/></span></li>
                        </ul>
                    </div>
                    <div class="product-attributs" id="full_info" >
                        <c:forEach var="i" begin="0" end="6">  
                            <div>
                                <div class="with_points info_product_item">
                                    <strong><fmt:message key="info_product_${i}"/></strong>
                                </div>
                               <span>${picture[i]}</span>
                            </div>
                        </c:forEach>
                    </div>
                    <div id="reviews_conteiner">
                        <c:forEach var="i" begin="0" end="1">
                            <div class="review">
                                    <div class="review_head">
                                        user
                                    </div>
                                     <p class="review_text">
                                        comment
                                     </p>
                            </div>  
                        </c:forEach>
                    </div>
                </div>
            </div>
      </div>
    <!-- <script>setDefaultTab(}tab "</script>-->
      <div class="endpage">
        <p>&copy;2015 Фебос.</p>
      </div>
    </div>
</body>
</html>
