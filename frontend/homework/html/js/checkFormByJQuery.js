
		// $(document).ready(function () {

		// });

		var province = new Array();
		province[0] = new Array("铜陵市", "巢湖市", "蚌埠市", "合肥市");
		province[1] = new Array("南京市", "苏州市", "常州市", "镇江市");
		province[2] = new Array("朝阳区", "大兴区", "海淀区", "东城区", "西城区");
		province[3] = new Array("凉州自治州", "成都市", "攀枝花市", "绵阳市", "自贡市");

		function showTime(){
			var time=new Date();
			var year=time.getFullYear();
			var month=time.getMonth()+1;
			var date=time.getDate();
			var hour=time.getHours();
			var minute=time.getMinutes();
			var second=time.getSeconds();
			$("#time").html("现在时间："+year+"年"+month+"月"+date+"日  "+hour+":"+minute+":"+second).css("color","#333");
		}
		function checkName() {
			var name = $("input[name='username']").val();
			if (name == null | name == "") {
				$("#namePrompt").html("用户名不可为空").css("color", "red");
				return false;
			} else if (/^[a-zA-Z]\w{3,}/.test(name) == false) {
				$("#namePrompt").html("不可数字开头，低于4位，不包含中文").css("color", "red");
				return false;
			} else {
				$("#namePrompt").html("可用").css("color", "springgreen");
				return true;
			}
		}

		function checkPassword() {
			var pwd = $("input[name='password1']").val();
			if (pwd == null || pwd == "") {
				$("#pwdPrompt").html("密码不可为空").css("color", "red");
				return false;
			} else if (pwd.length < 8) {
				$("span[id='pwdPrompt']").html("长度不可小于8").css("color", "red");
				return false;
			} else {
				$("span[id='pwdPrompt']").html("可用").css("color", "springgreen");
				return true;
			}
		}

		function comparePassword() {
			var flag = checkPassword();
			if (!flag) {
				return false;
			}
			if ($("input[id='pwd1']").val() != $("input[id='pwd2']").val()) {
				$("#pwd2Prompt").html("两次密码不一致").css("color", "red");
				return false;
			}
			$("#pwd2Prompt").html("一致").css("color", "springgreen");
			return true;
		}

		function checkEmail() {
			var reg = /^\w+@[a-zA-Z0-9]{2,10}(?:\.[a-z]{2,4}){1,3}$/;
			var email = $("input[name='email']").val();
			if (reg.test(email)) {
				$("#emailPrompt").html("邮箱合法").css("color", "springgreen");
				return true;
			}
			$("#emailPrompt").html("邮箱不合法").css("color", "red");
			return false;
		}

		function checkPhone() {
			var reg = /^1[356789]\d{9}$/;
			var phone = $("input[name='telephone']").val();
			if (reg.test(phone)) {
				$("#phonePrompt").html("可用").css("color", "springgreen");
				return true;
			}
			$("#phonePrompt").html("手机号错误").css("color", "red");
			return false;
		}

		function checkSchool() {
			var school = $("input[name='academy']").val();
			if (school == null || school == "") {
				$("#schoolPrompt").html("请输入学校").css("color", "red");
				return false;
			}
			$("#schoolPrompt").html("可用").css("color", "springgreen");
			return true;
		}

		function checkSpecialize() {
			var specialize = $("input[name='major']").val();
			if (specialize == null || specialize == "") {
				$("#specializePrompt").html("请输入专业").css("color", "red");
				return false;
			}
			$("#specializePrompt").html("可用").css("color", "springgreen");
			return true;
		}

		function checkCity() {
			var val = $("#city").val();
			if (val == "-1") {
				$("#cityPrompt").html("请先选择省份和城市").css("color", "red");
				return false;
			}
			return true;
		}

		function checkAgree() {
			if ($("#agree").prop("checked")) {
				return true;
			}
			alert("请同意规定");
			return false;
		}
		$(function () {
			$("#allCheck").click(function () {
				var flag = $(this).prop("checked");
				var oneList = $("input[name='one']");
				for (var i = 0; i < oneList.length; i++) {
					$(oneList[i]).prop("checked", flag);
				}
			});
			$("input[name='one']").click(function () {
				var oneList = $("input[name='one']");
				for (var i = 0; i < oneList.length; i++) {
					if (!$(oneList[i]).prop("checked")) {
						$("#allCheck").prop("checked", false);
						return;
					}
				}
				$("#allCheck").prop("checked", true);
			});
			//绑定事件start
			$("#username").blur(function () {
				checkName();
			});
			$("#pwd1").blur(function () {
				checkPassword();
			});
			$("#pwd2").blur(function () {
				comparePassword();
			});
			$("#telephone").blur(function () {
				checkPhone();
			});
			$("#email").blur(function () {
				checkEmail();
			});
			$("#academy").blur(function () {
				checkSchool();
			});
			$("#major").blur(function () {
				checkSpecialize();
			});
			$("#registerForm").submit(function () {
				return checkName() && checkPassword() && comparePassword() && checkPhone() && checkEmail() &&
					checkSchool() && checkSpecialize() && checkCity() && checkAgree();
			});
			$("#province").change(function () {
				var city = $("#city");
				//清空
				city.html("");
				var cityArray = province[$(this).val()];
				var str = "";
				for (var i = 0; i < cityArray.length; i++) {
					str += "<option value=" + cityArray[i] + ">" + cityArray[i] + "</option>";
				}
				city.html(str);
			});
			//绑定事件end
			setInterval("showTime()",1000);
		});
