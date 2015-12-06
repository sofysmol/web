/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function show(show_block,show_tab,hide_block,hide_tab){
document.getElementById(show_block).style.display = 'block';
document.getElementById(show_tab).style.background = '#f4f3f3';
document.getElementById(hide_block).style.display = 'none';
document.getElementById(hide_tab).style.background = '#dadada';
}
function next(old_block,new_block)
{
    
    document.getElementById(old_block).style.display='none';
    document.getElementById(new_block).style.display='block';
    
}
function setWay()
{
    if (document.getElementById('pickup_info').style.display=='none')
    {
        var country=document.getElementById('country').value;
        var locality=document.getElementById('locality').value;
        var street=document.getElementById('street').value;
        var house=document.getElementById('house').value;
        var flat=document.getElementById('flat').value;
        document.getElementById('spen_way_rec').innerHTML=document.getElementById('button_delivery').innerHTML;
        document.getElementById('spen_shipping_address').innerHTML=country+", "+locality+", "+street+", "+house+"-"+flat;
    }else
    {
        var location=document.getElementById('location_store').innerHTML;
        
        document.getElementById('spen_way_rec').innerHTML=document.getElementById('button_pickup').innerHTML;
        document.getElementById('spen_shipping_address').innerHTML=location;
    }
        
}
function completeWayOfReceipt()
{
    
    if (document.getElementById('pickup_info').style.display=='none')
    {
        document.cookie="shopid=0";
     var country=document.getElementById('country').value;
        if(!country) 
        {alert("Не введена страна");
        return;}
    }
    else 
    {
        if(!readCookie("shopid")) 
        {alert("Не выбран магазин");
            return;}
    }
    setWay();
    next('way_of_receipt','confirmation');
}

function confirmationOrder(user)
{
    var shop=readCookie("shopid");
    addInHistory(user,shop);
    delCookie("shopid");
    
    next('confirmation','making');
    }
function readCookie(cookieName) {
    var re = new RegExp('[; ]'+cookieName+'=([^\\s;]*)');
    var sMatch = (' '+document.cookie).match(re);
    if (cookieName && sMatch) return unescape(sMatch[1]);
}
function delCookie(name) {
  document.cookie = name + "=" + "; expires=Thu, 01 Jan 1970 00:00:01 GMT";
}
function addInHistory(user,shop)
{
    var xhr=new XMLHttpRequest();
        xhr.open('GET', 'http://localhost:8084/Febos2/DaoWorker?work=buy&user='+user+'&shop='+shop,false);
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