
<%@page import="java.util.List"%>
<%-- 
    Document   : ListOfProductsPage
    Created on : 18.10.2015, 14:11:05
    Author     : SofySmo
--%>

<%@page import="java.util.Scanner"%>
<%@page import="java.io.File"%>
<%@page language="java" import="java.util.Locale"%>
<%@page language="java" import="java.util.ResourceBundle"%>
<%@page language="java" import="java.util.ArrayList"%>
<%@page language="java" import="dao.products.*"%>
<%@page language="java" import="domain.*"%>
<%@page language="java" import="org.apache.logging.log4j.LogManager"%>
<%@page language="java" import="org.apache.logging.log4j.Logger"%>

 <% 
     request.getSession().setAttribute("active_page", request.getRequestURI());
     Logger logger=LogManager.getLogger("shopLog");
     Cookie cookies[]=request.getCookies();
     String lang=request.getParameter("lang");    
            if(lang==null)
                lang="ru";
            Locale locale =new Locale(lang);
            Locale localeEn=new Locale("en");
           ResourceBundle res=ResourceBundle.getBundle("page_product", locale);
           ResourceBundle resEn=ResourceBundle.getBundle("page_product", localeEn);
           String genre=request.getParameter("genre_filter");
           if (genre==null) genre="All";
           //ArrayList<Artwork[]> art=(ArrayList<Artwork[]>)session.getAttribute("art");//new request.getSession();
           List<Products> art=(List<Products>)session.getAttribute("art");
           if(art==null)
           {
               //logger.info("get all picture");
               ProductService ser=new ProductService();
               art=ser.findAll();
               request.getSession().setAttribute("art", art);
           }
            String cookieName="idirection";
            String direction="Any";
            Cookie myCookie = null;
            
            String idirection=request.getParameter("direction");
            if(idirection==null)
            {
                idirection="0";
            
                if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals (cookieName)) {
                        myCookie=cookies[i]; 
                        break;
                    }
                } 
              }  
            if(myCookie!=null)
                idirection=myCookie.getValue();
            }
            if(idirection==null) idirection="0";
                direction=resEn.getString("direction_"+idirection);         
            
 %>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/newcss.css">
        <script type="text/javascript" src="js/pageJS.js"></script>
       <script type="text/javascript" src="js/masonry.js"></script>
        <title><%=res.getString("title_site")%></title>
    </head>
    <body onunload="setCookie('idirection','<%=idirection%>');">
        
        <div id="main_conteiner">
           <div id="header-conteiner">
               
               <div id="hat_page">
               <jsp:include page="hat_page.jsp">
                            <jsp:param name="lang" value="<%=lang%>"/>
                            <jsp:param name="parant" value="ListOfProductsPage.jsp"/>
                            
               </jsp:include>
               </div>
           </div>
           <div id="big_contain">
            <div class="for_inline">
                <div id="shopfilter">
                    <h3><%=res.getString("left-menu_painting")%></h3>
                    <ul class="menu-list" id="left-navigation">
                        <li class="left-navigation-item">
                            <a class="left-link" href="http://localhost:8084/Febos2/ListOfProductsPage.jsp?lang=<%=lang%>&direction=<%=idirection%>"><%=res.getString("left-navigation-item_"+0)%></a>
                        </li>
                    <%for(int i=1;res.containsKey("left-navigation-item_"+i); i++)
                    {%>
                        <li class="left-navigation-item">
                            <a class="left-link" href="http://localhost:8084/Febos2/ListOfProductsPage.jsp?lang=<%=lang%>&genre_filter=<%=resEn.getString("left-navigation-item_"+i)%>&direction=<%=idirection%>"><%=res.getString("left-navigation-item_"+i)%></a>
                        </li>
                    <%}%>
                    </ul>
                </div>
                <div class="channel-homepage">
                    <div class="direction-filter grid-item">
                        <span><%=res.getString("info_product_2")%></span>
                        <form method="GET">
                        <select id="direction_select" onchange="itemsChanged('<%=lang%>', '<%=genre%>');">
                        <% for(int i=0; res.containsKey("direction_"+i); i++)
                        {
                        if(idirection.equals(Integer.toString(i)))
                            {%> <option value="<%=i%>" SELECTED><%=res.getString("direction_"+i)%></option> 
                            <% } else{ %>
                            <option value="<%=i%>"><%=res.getString("direction_"+i)%></option> 
                        <%}}%>
                        </select>
                        </form>
                    </div>
                    <div class="list_product grid js-masonry">
                    
                <%        
                    for(int j=0; j<art.size(); j++)
                    //for(int i=0;i<art.get(j).length; i++)
                    {
                if(genre.equals("All")||(art.get(j).getGenre()!=null&&art.get(j).getGenre().equals(genre)))
                {if(direction.equals("Any")||(art.get(j).getDirection()!=null&&art.get(j).getDirection().equals(direction))){%>
                <a href="http://localhost:8084/Febos2/ProductPage.jsp?lang=<%=lang%>&id=<%=art.get(j).getId()%>">
                    <div class="product grid-item">
                    <jsp:include page="product.jsp">
                            <jsp:param name="lang" value="<%=lang%>"/>
                            <jsp:param name="name" value="<%=art.get(j).getName()%>" />
                            
                            <jsp:param name="author" value="<%=art.get(j).getAuthor()%>" />
                            <jsp:param name="path" value="<%=art.get(j).getPathartwork() %>" />
                            <jsp:param name="price" value="<%=art.get(j).getPrice()%>" />
                    </jsp:include>                       
                        <span class="buy_product" onclick=""><%=res.getString("buy")%></span>
                    </div> 
                </a>       
                    <%}}}
                    
                %>
                </div>
                </div>
            </div>
           </div>
           <div class="endpage">
                    <p>&copy;2015.</p>
           </div>
        </div>
    </body>
</html>
     
