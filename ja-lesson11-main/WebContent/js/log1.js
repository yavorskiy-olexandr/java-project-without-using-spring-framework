$(document).ready(function() {
	$('.message a').click(function() {
		loginSwitch();
		return false;
	});
	function loginSwitch() {
		$('form').animate({
			height : "toggle",
			opacity : "toggle"
		}, "slow");
		return false;
	}
	function showAlert() {
		$('div.alert.alert-success').show();
	}
	$('button.reg').click(function() {
		var firstName = $("form.register-form input.firstNameReg").val();
		var lastName = $("form.register-form input.lastNameReg").val();
		var email = $("form.register-form input.emailReg").val();
		var password = $("form.register-form input.passwordReg").val();
		var userRegistration = {
			firstName : firstName,
			lastName : lastName,
			email : email,
			password : password
		};
		$.post("registration", userRegistration, function(data) {
			$("form")[0].reset();
			$("form")[1].reset();
			loginSwitch();
			showAlert();
		});
		return false;
	});
	$("button.login").click(function() {
		var email = $("form.login-form input.emailReg").val();
		var password = $("form.login-form input.passwordReg").val();

		if (email == '' || password == '') {
			alert("Please fill login form!");
		} else {
			var userLogin = {
				email : email,
				password : password
			};

			$.post("login", userLogin, function(data) {
				if (data !== '') {
					var customUrl = '';
					var urlContent = window.location.href.split('/');
					for (var i = 0; i < urlContent.length - 1; i++) {
						customUrl += urlContent[i] + '/'
					}
					customUrl += 'cabinet.jsp';
					window.location = customUrl;
				}
				$("form")[1].reset();
			});
			return false;
		}
	});
});