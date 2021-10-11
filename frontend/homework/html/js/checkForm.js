function inerestAll() {
	var interest = document.getElementById("allCheck");
	var interestList = document.getElementsByName("one");
	for (var i = 0; i < interestList.length; i++) {
		interestList[i].checked = interest.checked;
	}
}

function interestOne() {
	var interest = document.getElementById("allCheck");
	var interestList = document.getElementsByName("one");
	for (var i = 0; i < interestList.length; i++) {
		if (interestList[i].checked == false) {
			interest.checked = false;
			return false;
		}
	}
	interest.checked = true;
}

function checkName() {
	var name = document.getElementById("username").value;
	var info = document.getElementById("namePrompt");
	if (name == "" || name.length == null) {
		info.innerHTML = "姓名不能为空";
		info.style.color = "red";
		return false;
	} else if (name.length < 4) {
		info.innerHTML = "长度不可低于4位";
		info.style.color = "red";
		return false;
	}
	info.innerHTML = "可用";
	info.style.color = "springgreen";
	return true;
}

function checkPassword() {
	var pw = document.getElementById("pwd1").value;
	var info = document.getElementById("pwdPrompt");
	if (pw == "" || pw.length == null) {
		info.innerHTML = "密码不能为空";
		info.style.color = "red";
		return false;
	} else if (pw.length < 8) {
		info.innerHTML = "长度不可低于8位";
		info.style.color = "red";
		return false;
	}
	info.innerHTML = "可用";
	info.style.color = "springgreen";
	return true;
}

function comparePassword() {
	var pw1 = document.getElementById("pwd1").value;
	var pw2 = document.getElementById("pwd2").value;
	var info = document.getElementById("pwd2Prompt");
	if (!checkPassword()) {
		info.innerHTML = "请先输入合法密码";
		info.style.color = "red";
		return false;
	} else if (pw1 == pw2) {
		info.innerHTML = "密码一致";
		info.style.color = "springgreen";
		return true;
	} else {
		info.innerHTML = "密码不一致，请重试";
		info.style.color = "red";
		return false;
	}
}

function checkPhone() {
	var reg = /[1][0-9]{10}/i;
	var phone = document.getElementById("telephone").value;
	var info = document.getElementById("phonePrompt");
	var flag = reg.test(phone);
	if (flag) {
		info.innerHTML = "合法手机号";
		info.style.color = "springgreen";
		return true;
	} else {
		info.innerHTML = "手机号不合法，请从新输入";
		info.style.color = "red";
		return false;
	}
}

function checkEmail() {
	var email = document.getElementById("email").value;
	var reg = new RegExp(/^\w+@[a-zA-Z0-9]{2,10}(?:\.[a-z]{2,4}){1,3}$/);
	var info = document.getElementById("emailPrompt");
	if (email.match(reg) != null) {
		info.innerHTML = "邮箱合法";
		info.style.color = "springgreen";
		return true;
	}
	info.innerHTML = "邮箱不合法";
	info.style.color = "red";
	return false;
}

function checkSchool() {
	var school = document.getElementById("academy").value;
	var info = document.getElementById("schoolPrompt");
	if (school == null || school == "") {
		info.innerHTML = "学校有误";
		info.style.color = "red";
		return false;
	} else {
		info.innerHTML = "可用";
		info.style.color = "springgreen";
		return true;
	}
}

function checkSpecialize() {
	var school = document.getElementById("major").value;
	var info = document.getElementById("specializePrompt");
	if (school == null || school == "") {
		info.innerHTML = "专业有误";
		info.style.color = "red";
		return false;
	} else {
		info.innerHTML = "可用";
		info.style.color = "springgreen";
		return true;
	}
}
var citylist = new Array();
citylist[0] = new Array("铜陵市", "巢湖市", "蚌埠市", "合肥市");
citylist[1] = new Array("南京市", "苏州市", "常州市", "镇江市");
citylist[2] = new Array("朝阳区", "大兴区", "海淀区", "东城区", "西城区");
citylist[3] = new Array("凉州自治州", "成都市", "攀枝花市", "绵阳市", "自贡市");

function changecity(val) {
	var city = document.getElementById("city");
	//先清空列表，不然会堆加
	city.options.length = 0;
	for (var i = 0; i < citylist[val].length; i++) {
		var option = document.createElement("option");
		option.innerHTML = citylist[val][i];
		option.value = citylist[val][i];
		city.appendChild(option);
	}
}

function checkForm() {
	return checkName() && checkPassword() && comparePassword() && checkPhone() && checkEmail() && checkInterest() &&
		checkAgree() && checkCity();
}

function checkInterest() {
	var checkAll = document.getElementById("allCheck").checked;
	if (checkAll) {
		return true;
	}
	var one = document.getElementsByName("one");
	for (var i = 0; i < one.length; i++) {
		if (one[i].checked == true) {
			return true;
		}
	}
	var info = document.getElementById("interestPrompt");
	info.innerHTML = "请至少选择一个兴趣";
	info.style.color = "red";
	return false;
}

function checkAgree() {
	var agree = document.getElementById("agree").checked;
	if (agree) {
		return true;
	}
	alert("请同意规定！");
	return false;
}

function checkCity() {
	var province = document.getElementById("province").value;
	var city = document.getElementById("cityPrompt");
	if (province == -1) {
		city.innerHTML = "请选择省份和城市";
		city.style.color = "red";
		return false;
	}
	return true;
}
