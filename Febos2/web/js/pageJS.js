  /* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function setDefaultTab(i)
{
 if(i==0) show1()
 else if(i==1) show2();
}
function show1(){
document.getElementById('full_info').style.display = 'block';
document.getElementById('characteristic').style.background = 'white';
document.getElementById('reviews_conteiner').style.display = 'none';
document.getElementById('reviews').style.background = '#e9e9e9';
}
function show2(){
document.getElementById('full_info').style.display = 'none';
document.getElementById('characteristic').style.background = '#e9e9e9';
document.getElementById('reviews_conteiner').style.display = 'block';
document.getElementById('reviews').style.background = 'white';
}
function itemsChanged(lang, genre){
                var value = document.getElementById('direction_select').value;
                    location.href=('http://localhost:8084/Febos1/ListOfProductsPage.jsp?lang='+lang+'&genre_filter='+genre+'&direction='+value);
                }
function setCookie(name,cookie)
{
    //alert("хей");
    var updatedCookie=name+"="+cookie+";";
    document.cookie = updatedCookie;
}

function delCookie(name) {
 document.cookie = name + "=" + "; expires=Thu, 01 Jan 1970 00:00:01 GMT";
  
}


