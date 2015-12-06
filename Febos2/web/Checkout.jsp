<%-- 
    Document   : Checkout
    Created on : 22.11.2015, 17:06:09
    Author     : SofySmo
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ff" uri="/WEB-INF/tlds/myfunction.tld"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="active_page" value="Checkout.jsp" scope="session" />
<c:choose>
<c:when test="${empty param.lang}">
    <c:set var="lang" value="ru"/>
</c:when>
<c:otherwise>
    <c:set var="lang" value="${param.lang}"/>
</c:otherwise>
</c:choose>
<c:set var="order" value="${sessionScope.order}"/>
<c:set var="user" value="${sessionScope.user}"/>
<c:set var="keyMap" value="AIzaSyBn-n_YE16-wRuliuABCGrZun0l-pvnbVs"/>
<c:set var="shopid" value="${cookie.shopid.value}"/>
<fmt:setBundle var="en" basename="page_product_en" />
<fmt:setBundle basename="page_product_${lang}" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/newcss.css">
        <link rel="stylesheet" type="text/css" href="style/checkout.css">
        <script type="text/javascript" src="js/cart.js"></script>
        <script type="text/javascript" src="js/map.js"></script>
        <script type="text/javascript" src="js/checkout.js"></script>
        <script type="text/javascript" src="js/dao.js"></script>        

        <script src="masonry.js"></script>
       <title><fmt:message key="title_site" /></title>
    </head>
    <body>
        <div id="main_conteiner">
           <div id="header-conteiner">
               
               <div id="hat_page">
                   <c:import url="hat_page.jsp?lang=${lang}&parant=Checkout.jsp"/>    
              </div>
           </div>
        </div>
        <div id="big_contain">
            <div class="for_inline">
                <div id="channel-checkout" class="channel-homepage">                            
                    <h2><fmt:message key="checkout" /></h2>
                    <hr>
                    <div id="way_of_receipt">
                       <h3> <fmt:message key="way_rec" /></h3>
                       <div class="choiсe_way for_inline">
                           <div id="button_pickup" class="tab_1" onclick="show('pickup_info','button_pickup','delivery_info','button_delivery');"><fmt:message key="pickup" /></div>
                           <div id="button_delivery" class="tab_1" onclick="show('delivery_info','button_delivery','pickup_info','button_pickup');"><fmt:message key="delivery" /></div>
                           <div id="pickup_info">
                               <h4><fmt:message key="select_store" /></h4>
                               <div id="map"></div>
                               <script type="text/javascript">initMap();</script>
                               <script async defer src="https://maps.googleapis.com/maps/api/js?key=${keyMap}&callback=initMap&language=${lang}"></script>
                               <span class="just_text"><fmt:message key="choce_store"/> </span>
                               <span id="location_store" class="just_text"><fmt:message key="nothing"/></span>
                               <br><br>
                           </div>
                           
                           <div id="delivery_info">
                               <h4><fmt:message key="shipping_address"/></h4><br>
                               <span class="just_text"><fmt:message key="specify_address"/></span><br><br>
                                    <label for="country"><fmt:message key="country"/></label><br>
                                    <input type="text" id="country"  placeholder=<fmt:message key='country'/> size="30"/><br><br>
                                    <label for="locality"><fmt:message key="locality"/></label><br>
                                    <input type="text" id="locality"  placeholder=<fmt:message key='locality'/> size="30"/><br><br>
                                     <label for="street"><fmt:message key="street"/></label><br>
                                    <input type="text" id="street"  placeholder=<fmt:message key='street'/> size="30"/><br><br>
                                     <label for="house"><fmt:message key="house"/></label><br>
                                    <input type="text" id="house"  placeholder=<fmt:message key='house'/> size="30"/><br><br>
                                     <label for="flat"><fmt:message key="flat"/></label><br>
                                    <input type="text" id="flat"  placeholder=<fmt:message key='flat'/> size="30"/><br><br>
                                    
                           </div>
                                    <div class="button_next" onclick="completeWayOfReceipt();"><fmt:message key="next"/></div>
                                    <script>show('pickup_info','button_pickup','delivery_info','button_delivery');</script>
                       </div>
                    </div>
                    <div id="confirmation">
                       <h3><fmt:message key="confirmation" /></h3> 
                            <span><fmt:message key="sum_cost"/>: $</span>
                                <strong id="result_cost">0</strong>
                                <div id="list_product_checkout">
                       <h4><fmt:message key="shopping_list" /></h4>
                       
                            <div class="list_product grid js-masonry">
                                <c:set var="sum" value="${0}"/>
                                <c:set var="i" value="${0}"/>
                                        <c:forEach var="item" items="${order.getItemList()}">
                                            <fmt:parseNumber var="id" type="number" value="${item.getId()}"/>
                                                <%--<c:set var="indexFile" value="${id/100}"/>
                                                <c:set var="indexPicture" value="${id%100}"/>--%>
                                                <c:set var="art" value="${ff:getArt(id)}"/>
                                                <c:set var="sum" value="${sum+art.price}"/>
                                                <div class="product grid-item choose_product" id="product_${i}">
                                                <br>
                                                <script type="text/javascript"> addCost(${art.price},${item.getCount()});</script>
                                                <c:import url="product.jsp?lang=${lang}&name=${art.name}&author=${art.author}&path=${art.pathartwork}&price=${art.price}"/>   
                                                <strong><fmt:message key="count"/></strong>
                                                <lable>'${item.getCount()}'</lable>
                                                  </div>
                                                <c:set var="i" value="${i+1}"/>
                                        </c:forEach>
                            </div>
                       </div>
                           
                                <div id="shot_info_way">
                                        <h4> <fmt:message key="way_rec" />: </h4>
                                        <span id="spen_way_rec" class="just_text"></span>

                                        <h4><fmt:message key="shipping_address"/></h4><br>
                                        <span id="spen_shipping_address" class="just_text"></span> <br><br> 
                                         <div class="for_inline">
                                            <div class="button_next" onclick="next('confirmation','way_of_receipt');"><fmt:message key="back"/></div>
                                            <div class="button_next" onclick="confirmationOrder(${user.getId()});"><fmt:message key="next"/></div>
                                        </div>

                                </div>
                    </div>
                                <div id="making">
                                   <h3><fmt:message key="making" />!</h3> 
                                   <a href="http://localhost:8084/Febos2/ListOfProductsPage.jsp?lang=${lang}">
                                       <div class="button_next" onclick="">Ок</div>
                                   </a>
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
