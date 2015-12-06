/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function addInHistory(user,shop)
{
    var xhr=new XMLHttpRequest();
        xhr.open('GET', 'http://localhost:8084/Febos2/DaoWorker?work=buy&user='+user+'&shop='+shop,true);
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
