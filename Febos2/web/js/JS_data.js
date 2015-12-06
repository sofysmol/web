/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function startTime(lang)
{
    var tm=new Date();
    var day=tm.getDate();
    var month=tm.getMonth()+1;
    var year=tm.getFullYear();
    day=checkTime(day);
    month=checkTime(month)
    if(lang=='ru' || lang=='de')
    {
        document.getElementById('datanow').innerHTML=day+"."+month+"."+year;
        startTimeRUDE();
    }
    else 
    {
        document.getElementById('datanow').innerHTML=month+"-"+day+"-"+year;
        startTimeEN();   
    }
}
function checkTime(i)
{
if (i<10)
{
i="0" + i;
}
return i;
}
function startTimeRUDE()
{
   var tm=new Date();
    var h=tm.getHours();
    var m=tm.getMinutes();
    var s=tm.getSeconds();
    m=checkTime(m);
    s=checkTime(s);
    document.getElementById('timenow').innerHTML=h+":"+m+":"+s;
    t=setTimeout('startTimeRUDE()',500); 
}
function startTimeEN()
{
   var tm=new Date();
    var h=tm.getHours();
    var m=tm.getMinutes();
    var s=tm.getSeconds();
    m=checkTime(m);
    s=checkTime(s);
    document.getElementById('timenow').innerHTML=h+":"+m+":"+s;
    t=setTimeout('startTimeEN()',500); 
}


