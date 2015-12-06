/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function sendComment(){
    
    var comment=document.getElementById("new_com").value;
    document.getElementById("new_com").value='';
    if(comment!=='')
    {
        sendOnDao(comment);
        document.getElementById('comments').innerHTML+=' <div class="comment">'+comment+'</div>';
    }
    else{
        
    }
}
function sendOnDao(content)
{
    var xhr=new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8084/Febos2/DaoWorker',true);
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    var parametrs='work=add_com&comment='+encodeURIComponent(content);
    xhr.send(parametrs);
    
    xhr.onreadystatechange = function() {
    if (xhr.readyState==4 && xhr.status==200){
        }
    }
        
}
