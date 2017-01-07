
document.querySelector('#button').addEventListener('click',function(){
var username = document.querySelector('#name').value;
var password = document.querySelector('#input').value;

console.log(username,password);
if(!username || !password){
  document.querySelector('#errorMessage').innerText = "faild";

  return;
}else{
  document.querySelector('#errorMessage').innerText = "successful";
}
},false);


var  input = document.getElementById('input');
input.addEventListener('click',function(){
var username = document.getElementById('name').value;
var password = document.getElementById('input').value;

console.log(username,password);
},false);

var http = new XMLHttpRequest();


http.onreadystatechange = function () {
  if(this.readyState == 4 && this.state == 200){
     document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
  }else{
document.querySelector('#errorMessage').innerText = "faild";
    }
  var payload ={
    username:username,
    password:password
  }
  http.open('post','user',true);
  http.send(JSON.stringify(payload));
  http.setRequestHeader('context-type','application/json');
};
