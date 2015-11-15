/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function sendSingInServlet()
{
 
    
    var email=document.getElementById("email").value;
     var xhr=new XMLHttpRequest();
        xhr.open('GET', 'http://localhost:8084/Febos2/SingInServlet?email='+email,true);
          xhr.send();
          
        //alert("nen");
        xhr.onreadystatechange = function() {
            if (this.readyState !== 4) return;
            if (this.status !== 200) {
              alert('Error while removing item to order'+this.status);
              return;
            } 
        }
}
function singout()
{
     var xhr=new XMLHttpRequest();
        xhr.open('GET', 'http://localhost:8084/Febos2/SignOutServlet',true);
          xhr.send();
         
          
        //alert("nen");
        xhr.onreadystatechange = function() {
            if (this.readyState !== 4) return;
            if (this.status !== 200) {
              alert('Error while removing item to order'+this.status);
              return;
            } 
        
}
}

