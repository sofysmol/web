/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function addCost(cost, count)
{
    var sum=parseInt(document.getElementById('result_cost').innerHTML,10);
    sum+=cost*count;
    document.getElementById('result_cost').innerHTML=sum;   
}
function refuseProduct(i,id,price,count)
{
    //alert(id);
        document.getElementById("product_"+i).style.display='none';
        addCost(-price,count);
        sendAddServlet(remove,id,count);
}
function onchangeCount(i,id,cost,old)
{    
    var value=document.getElementById("count_"+i).value;    
    if(!value||value<1)
    {
        document.getElementById("count_"+i).value=old;
    }
    else
    {
        
        addCost(cost,value-old);
        //document.getElementById("oldcount_"+i).innerHTML=value;
        if(value>old)
        {
            //
            sendAddServlet('add',id,value-old);
            
        }
        else sendAddServlet('remove',id,old-value);
        //alert("yy");
    }
}
function sendAddServlet(word,id,count)
{
     var xhr=new XMLHttpRequest();
        xhr.open('GET', 'http://localhost:8084/Febos2/AddItemServlet?'+word+'='+id+'&count='+count,true);
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