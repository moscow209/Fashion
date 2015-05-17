<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script language="javascript" type="text/javascript"
	src="js/bootstrap.min.js"></script>
<script language="javascript" type="text/javascript"
	src="js/nicole-fashion.js"></script>
</head>
<body>
	<jsp:include page="hearder.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="c6383">
		<div class="c6384" style="margin-top: -20px;">
			<div class="c6385">
				<h2>Đăng nhập</h2>
				<c:if test="${not empty information}">
					<p class="c4346">${information}</p>
				</c:if>
			</div>
		</div>
		<div class="c6384">
			<div class="c6039">
				<form class="c233 c6144" action="login.html" method="post">
					<c:if test="${not empty failed }">
						<p style="color: red;">* Tên đăng nhập hoặc mật khẩu không đúng!</p>
					</c:if>
					<div class="c6146">
						<label class="c6049 c6147" for="inputEmail">Tên đăng nhập<span
							class="c6069">*</span>
						</label>
						<div class="c5741">
							<input type="text" class="c6148" name="username">
						</div>
					</div>
					<div class="c6146">
						<label class="c6049 c6147" for="inputPassword">Mật khẩu<span
							class="c6069">*</span></label>
						<div class="c5741">
							<input type="password" class="c6148" name="password">
						</div>
					</div>
					<div class="c6146">
						<div class="c6385">
							<button class="c6164 c6165" type="submit">Đăng nhập</button>
							<a href="forgot-password.html" style="margin-left: 30px;">Quên mật khẩu?</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>