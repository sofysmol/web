<%-- 
    Document   : hat_page
    Created on : 23.10.2015, 16:48:11
    Author     : SofySmo
<link rel="stylesheet" type="text/css" href="newcss.css">
--%>

<%@page import="domain.Order"%>
<%@page import="java.security.Principal"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@page import="domain.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="order" value="${sessionScope.order}"/>   
<%
    
    String lang=request.getParameter("lang");    
            if(lang==null)
            {
                lang="ru";
            }
            Locale locale =new Locale(lang);
            
           ResourceBundle res=ResourceBundle.getBundle("page_product", locale);
           String parant=request.getParameter("parant");
           
           boolean user=false;
           
           if(request.getRemoteUser()!=null)
           {
              user=true;
           }
           String id=null;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/franklin-gothic-demi-cond.ttf">
        <link rel="stylesheet" type="text/css" href="style/hat_page.css">
        <script type="text/javascript" src="js/auth.js"></script>
    </head>
    <body>
        <div id="hat">      
             <div id="right_block">
            <% if(!user){
            %>
                <a href="PersonalServlet?lang=<%=lang%>"><span><%=res.getString("header_0")%></span></a>/
                 <a href="Authorization.jsp?lang=<%=lang%>"><span><%=res.getString("header_3")%></span></a>
                 <a href="CartPage.jsp?lang=<%=lang%>"><span><%=res.getString("header_1")%></span></a>
                 
             <%}
            else{%>
                <%=res.getString("header_2")%>:
                <a href="PersonalServlet?lang=<%=lang%>"><span><%=request.getRemoteUser()%></span></a><br>
                <a href="CartPage.jsp?lang=<%=lang%>"><span><%=res.getString("header_1")%></span></a>
                <c:if test="${order!=null &&!(order.isEmpty())}">
                                        <a href="CheckoutServlet?lang=<%=lang%>"><span><%=res.getString("checkout")%></span></a>  
                                     </c:if>
                
                <a href="PersonalServlet?lang=<%=lang%>" onclick="singout();"><span>  <%=res.getString("header_4")%></span></a>                
            <%}%>
                
            <div>
            <form  id="form_lang" name="lang_form" action="<%=parant%>" method="get"> 
                    <select onchange="document.lang_form.submit()" name="lang" id="chooseLand">
                        <% for(int i=0; res.containsKey("lang_"+i); i++)
                        { 
                            %> <option value=<%=res.getString("l_"+i)%>><%=res.getString("lang_"+i)%></option> 
                        <%}%>
                        </select>
                   </form>
            </div>
            
        </div> 
                        <h1><%=res.getString("title_site")%></h1>
        </div>
        <div id="fon_top_menu">
                    <div id="menu-contater">
                    <nav>
                        <ul class="menu_list horizontal_list" id="top_menu">
                        <li class="navigation-bar-item">
                             <a class=navigerion-bar-link href="ListOfProductsPage.jsp?lang=<%=lang%>">
                                 <span class=navigerion-bar-span><%=res.getString("navigation_menu_item_"+0)%></span>
                             </a>
                         </li>
                         <% for(int i=1; res.containsKey("navigation_menu_item_"+i);i++)
                         {%>
                         <li class="navigation-bar-item">
                             <a class=navigerion-bar-link href="">
                                 <span class=navigerion-bar-span><%=res.getString("navigation_menu_item_"+i)%></span>
                             </a>
                         </li>
                         <%}%>
                         </ul>
                    </nav>
                    </div>
               </div>
                         
    </body>
</html>
