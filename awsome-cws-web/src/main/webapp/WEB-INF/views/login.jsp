<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
	<title>Login CWS</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/png" href="<c:url value='/static/images/icons/favicon.ico'/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/static/css/util.css'/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/static/css/main.css'/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/static/fonts/font-awesome-4.7.0/css/font-awesome.min.css'/>" />
	<script type="text/javascript" src="<c:url value='/static/vendor/jquery/jquery-3.2.1.min.js'/>" /></script>
</head>
<body>
	
	<div class="limiter">
		<div class="container-login">
			<div class="wrap-login">
				<div class="login-form-title" style="background-image: url(<c:url value='/static/images/background.jpg)'/>; ">
					<span class="login-form-title-1">
						Sign In
					</span>
				</div>

				<form class="login-form validate-form" action="<c:url value='/login' />" method="post">
					<div class="wrap-input validate-input m-b-26" data-validate="Username is required">
						<span class="label-input">Username</span>
						<input class="input" type="text" name="username" placeholder="Enter username">
						<span class="focus-input"></span>
					</div>

					<div class="wrap-input validate-input m-b-18" data-validate = "Password is required">
						<span class="label-input">Password</span>
						<input class="input" type="password" name="pass" placeholder="Enter password">
						<span class="focus-input"></span>
					</div>

					<div class="flex-sb-m w-full p-b-30">
						<div class="contact-form-checkbox">
							<input class="input-checkbox" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox" for="ckb1">Remember me</label>
						</div>

						<div>
							<a href="#" class="txt1">Forgot Password?</a>
						</div>
					</div>
					
					<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> --%>
					<div class="container-login-form-btn">
						<button class="login-form-btn">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="<c:url value='/static/js/main.js'/> "></script>
</body>
</html>