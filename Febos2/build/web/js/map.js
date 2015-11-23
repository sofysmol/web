/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
var map;
var choseMarker;

var shops = [
  ['ArtGallery_1', 59.971934, 30.323784, 4,'ул. Профессора Попова, 3'],
  ['ArtGallery_2', 59.938329, 30.330050,1,' ул. Салова, 30'],
  ['ArtGallery_3', 59.927578, 30.296834,3,' ул. Глинки, 2'],
  ['ArtGallery_4', 59.897243, 30.374682, 2,'ул. Садова, 30']
];
function initMap() {
    
  map = new google.maps.Map(document.getElementById('map'), {
    center: {lat: 59.956339, lng: 30.306275},
    zoom: 10
  });
  setMarkers(map);
  
} 
function setMarkers(map)
  {
     
       for (var i = 0; i < shops.length; i++) {
    var shop = shops[i];
    var marker = new google.maps.Marker({
      position: {lat: shop[1], lng: shop[2]},
      map: map,
      title: shop[0],
      zIndex: shop[3],
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
      var geocoder = new google.maps.Geocoder
    geocoder.geocode({'location': this.position}, function(results, status) {
    if (status === google.maps.GeocoderStatus.OK) {
      if (results[1]) {
          document.getElementById("location_store").innerHTML=choseMarker.title+', '+results[0].formatted_address+' ';
            }}});
      
      
      //text.innerHTML();    
  }