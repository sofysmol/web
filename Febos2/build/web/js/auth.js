/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function checkInDB()
{
    var login=document.getElementById("email").value;
    sendServlet('http://localhost:8084/Febos2/DaoWorker?work=auth&login='+login);
}
function singout()
{
    
    sendServlet('http://localhost:8084/Febos2/SignOutServlet');
    // window.location.href = "http://localhost:8084/Febos2/PageServlet"
   // alert('77');
}
function sendServlet(request)
{
    var xhr=new XMLHttpRequest();
        xhr.open('GET',request,false);
          xhr.send();
        xhr.onreadystatechange = function() {
            if (this.readyState !== 4) return;
            if (this.status !== 200) {
              alert('Error while removing item to order'+this.status);
              return;
            } 
        
}
}
