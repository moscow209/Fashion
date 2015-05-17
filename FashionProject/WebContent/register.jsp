<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script language="javascript" type="text/javascript"
	src="js/bootstrap.min.js"></script>
<script language="javascript" type="text/javascript"
	src="js/nicole-fashion.js"></script>
<script src="js/jquery-ui.js"></script>
<script>
	$(function() {
		$("#birthday").datepicker({ dateFormat: 'yy-mm-dd' });
	});
</script>
</head>
<body>
	<jsp:include page="hearder.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="c6383">
		<div class="c6384" style="margin-top: -20px; margin-bottom: 20px;">
			<div class="c6385">
				<h2>Đăng kí</h2>
			</div>
		</div>
		<div class="c6384">
			<div class="c6039">
				<form class="c6144" action="register.html" method="post">
					<c:if test="${not empty failed }">
						<p style="color: red;">${failed}</p>
					</c:if>
					<div class="c6146">
						<label class="c6049 c6147" for="inputEmail">Tên đăng nhập<span
							class="c6069">*</span></label>
						<div class="c5741">
							<input type="text" name="username" class="c6148">
						</div>
					</div>
					<div class="c6146">
						<label class="c6049 c6147" for="inputPassword">Mật khẩu<span
							class="c6069">*</span></label>
						<div class="c5741">
							<input type="password" name="password" class="c6148">
						</div>
					</div>
					<div class="c6146">
						<label class="c6049 c6147" for="inputPassword">Nhập lại mật khẩu
						<span class="c6069">*</span></label>
						<div class="c5741">
							<input type="password" name="confirmPassword" class="c6148">
						</div>
					</div>
					<div class="c6146">
						<label class="c6049 c6147">Ngày sinh<span class="c6069">*</span>
						</label>
						<div class="c5741">
							<input type="text" id="birthday" name="birthday" class="c6148">
						</div>
					</div>
					<div class="c6146">
						<label class="c6049 c6147" for="inputSex">Giới tính<span
							class="c6069">*</span></label>
						<div class="c5741">
							<select class="c6148" name="sex">
								<option>Nam</option>
								<option>Nữ</option>
							</select>
						</div>
					</div>
					<div class="c6146">
						<label class="c6049 c6147" for="inputEmail">Email<span
							class="c6069">*</span></label>
						<div class="c5741">
							<input type="text" id="i3" class="c6148" name="email">
						</div>
					</div>
					<div class="c6146">
						<label class="c6049 c6147" for="inputPhone">Điện thoại<span class="c6069">*</span>
						</label>
						<div class="c5741">
							<input type="text" id="i4" class="c6148" name="phone">
						</div>
					</div>
					<div class="c6146">
						<label class="c6049 c6147" for="inputAddress">Địa chỉ<span class="c6069">*</span>
						</label>
						<div class="c5741">
							<input type="text" id="i4" class="c6148" name="address">
						</div>
					</div>
					<div class="c6146">
						<div class="c6385">
							<button class="c6164 c6165" type="submit">Đăng kí</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>