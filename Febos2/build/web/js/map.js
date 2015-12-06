/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
var map;
var choseMarker;
var shopId;
/*= [
  ['Gallery', 59.971934, 30.323784, 1,'ул. Профессора Попова'],
  ['Herry', 59.938329, 30.330050,2,' ул. Салова, 30'],
  ['Valery', 59.927578, 30.296834,3,' ул. Глинки, 2'],
  ['Galla', 59.897243, 30.374682, 4,'ул. Садова, 30']
];*/

function initMap() {
    var shops=[];
    var cookie=getCookie("shops"); 
    if(cookie) {
        getShops(shops);
    }
     
  map = new google.maps.Map(document.getElementById('map'), {
    center: {lat: 59.956339, lng: 30.306275},
    zoom: 10
  });
  
  setMarkers(map,shops);
   
} 
function setMarkers(map,shops)
  {   
       for (var i = 0; i < shops.length; i++) {
           
    var shop = shops[i];
    var marker = new google.maps.Marker({
      position: {lat: parseFloat(shop[1]), lng: parseFloat(shop[2])},
      map: map,
      title: shop[0],
      zIndex: parseFloat(shop[3]),
      icon: 'http://maps.google.com/mapfiles/ms/icons/red-dot.png',
    });
    marker.addListener('click', onclickMarkers);
    
  }
  }
  function onclickMarkers(marker)
  {
     
      if(choseMarker!=null)
      choseMarker.setIcon('http://maps.google.com/mapfiles/ms/icons/red-dot.png');    
      this.setIcon('http://maps.google.com/mapfiles/ms/icons/blue-dot.png');
      choseMarker=this;
      var geocoder = new google.maps.Geocoder;
    geocoder.geocode({'location': this.position}, function(results, status) {
    if (status === google.maps.GeocoderStatus.OK) {
      if (results[1]) {
          document.getElementById("location_store").innerHTML=choseMarker.title+', '+results[0].formatted_address+' ';
            }}});
    document.cookie ="shopid="+this.getZIndex();
      //text.innerHTML();    
  }
  
  
  function getShops(shops){
   var cookie=" "+getCookie("shops");  
   var j=0;
    var shop=[];
    var c=0;
    var i=0;
    var indexShop=0;
   if (cookie)
   {
       while(i!=-1)
       {
           var str=cookie.substr(i,cookie.indexOf("%",i+1)-i);
           j=0;
           shop=[];
           c=0;
           while(j!=-1)
           {
               shop[c]=str.substr(j+1,str.indexOf("&",j+1)-j-1);
               j = str.indexOf("&",j+1); 
               c++;
           }
           shops[indexShop]=shop;
           i=cookie.indexOf("%",i+1);
           indexShop++;
        }
   }
}
function getCookie(name) {
  var matches = document.cookie.match(new RegExp(
    "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
  ));
  return matches ? decodeURIComponent(matches[1]) : undefined;
}
function shopsToCookie()
{
    var xhr=new XMLHttpRequest();
        xhr.open('GET', 'http://localhost:8084/Febos2/DaoWorker?work=shops',true);
          xhr.send();
          
        //alert("nen");
        xhr.onreadystatechange = function() {
            if (this.readyState !== 4) return;
            if (this.status !== 200) {
              //alert('Error '+this.status);
              return;
            } 
        }
}