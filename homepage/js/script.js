var validateForm = function(){
	var name = document.getElementsByName("fname").value;
	if(name == null || name == ""){
		alert("Name field must be filled out");
		return false;

	}
	var email = document.getElementsByName("email").value;
	if(email == null || email == ""){
		alert("Email field must be filled out");
		return false;
	}
}

document.getElementsById("submit").onclick = function(){ validateForm();}