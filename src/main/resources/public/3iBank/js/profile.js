console.log(localStorage.getItem("UserName"));
var today = new Date();  
document.getElementById("profilename").innerHTML = localStorage.getItem("UserName");
document.getElementById("adminprofile").innerHTML = localStorage.getItem("UserName");
document.getElementById("lastlogin").innerHTML = "Last Login " + today.getDate()+'/'+(today.getMonth()+1)+'/'+today.getFullYear();

if(localStorage.getItem("UserName") == "vamsi"){
	document.getElementById('profileimg').src="images/vamsi.PNG";
    document.getElementById('profileimg2').src="images/vamsi.PNG";
}
if(localStorage.getItem("UserName") == "dakshu"){
	document.getElementById('profileimg').src="images/daku.JPG";
    document.getElementById('profileimg2').src="images/daku.JPG";
}

     $('.user-details-list').on( "click","li:last-child", function(){
        localStorage.setItem("UserName" , "");
        window.location.href = "index.html";
            })
