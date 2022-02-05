<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ include file="/common/head.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Forgot Password</title>
<%@ include file="/common/head.jsp"%>

<script>
	$('#forgotBtn').click(function() {	
		var email = $('#email').val();
		var formData = {'email': email};
		$.ajax({
			url: 'forgorPass',
			type: 'POST',
			data: formData
		}).then(function(data) {
			$('#message').text('Reset mat khau thanh cong!');
			setTimeout(function() {
				window.location.href = 'http://localhost:8080/Assignment/login';
			}, 5*1000);
		}).fail(function(error) {
			$('#message').text('Reset mat khau khong thanh cong');
		});
	});
</script>
</head>
<body class="form-v6">
	<%@ include file="/common/header.jsp"%>
	<div class="page-content">
		<div class="form-v6-content">
			<div class="form-detail">
				<form action="forgotPass" method="POST">
					<h2>Forgot Password</h2>
					<div class="form-row">
						<input type="text" name="email" id="email" class="input-text"
							placeholder="Email" required>
					</div>

					<div class="form-row-last">
						<button type="submit" class="btn btn-primary" id="forgotBtn">Send</button>
					</div>
					<h5 style="color: orange" id="message" class="message"></h5>


				</form>
			</div>
		</div>
	</div>
</body>

</html>