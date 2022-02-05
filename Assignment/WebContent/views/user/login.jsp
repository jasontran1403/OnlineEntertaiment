<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign In</title>
<%@ include file="/common/head.jsp"%>


<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="<c:url value='/templates/user/css/style.css' />">
</head>
	<body class="form-v6">
	<%@ include file="/common/header.jsp"%>
	<div class="page-content">
		<div class="form-v6-content">
			<form class="form-detail" action="login" method="post">
				<h2>Log In</h2>
				<div class="form-row">
					<input type="text" name="username" id="user-name" class="input-text" placeholder="Username" required>
				</div>
				<div class="form-row">
					<input type="password" name="password" id="password" class="input-text" placeholder="Password" required>
				</div>
				
				<div class="form-row-last">
					<input type="submit" name="register" class="register" value="Register">
				</div>
			</form>
		</div>
	</div>
	<%@ include file="/common/footer.jsp"%>
</body>



		


</html>