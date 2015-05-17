<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
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
				<h2>Quên mật khẩu?</h2>
				<p class="c5733">Nhập địa chỉ e-mail liên kết với tài khoản của bạn. Nhấp vào gửi để lấy mật khẩu e-mail đến bạn.</p>
			</div>
		</div>
		<div class="c6384">
			<div class="c6385">
				<div class="c5736">
					<form class="c6144" action="forgot-password.html" method="post">
						<c:if test="${not empty failed }">
							<p style="color: red;">* Email bạn nhập không liên kết với bất kì tài khoản nào!</p>
						</c:if>

						<div class="c6146">
							<label class="c6049 c6147" for="inputEmail">E-mail
								Address </label>
							<div class="c5741">
								<input type="text" id="i3" placeholder="Email" class="c6148"
									name="email">
							</div>
						</div>
						<p>
							<button class="c6164 c6165" type="submit">Hoàn thành</button>
						</p>
					</form>

				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>