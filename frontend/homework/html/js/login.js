function  checkUsername() {
	var name=$("#username").val();
	if(name==""||name==null){
		alert("用户名不可为空");
		return false;
	}

}
function checkPwd(){
	var pwd =$("#userpwd").val();
	if(pwd==""||pwd==null){
		alert("密码不可为空");
		return false;
	}
}
$(function(){
	$("#username").blur(function(){
		checkUsername();
	});
	
	$("#userpwd").blur(function(){
		checkPwd();
	});
	
	$("#loginInfo").submit(function(){
		return checkUsername()&&checkPwd();
	});
});
