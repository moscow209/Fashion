<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Account</title>
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
		$("#birthday").datepicker({
			dateFormat : 'yy-mm-dd'
		});
	});
</script>
</head>
<body>
	<jsp:include page="hearder.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="c6383">
		<div class="c6384">
			<div class="c6385">
				<h2>Tài khoản</h2>
				<c:if test="${not empty information}">
					<p class="c4346">${information}</p>
				</c:if>
			</div>
		</div>
		
		<div class="c6384">
			<div class="c6039">
				<form class="c233 c6144" action="account.html?action=changepassword"
					method="post">
					<p>Đổi mật khẩu</p>
					<c:if test="${not empty failed }">
						<p style="color: red;">${failed}</p>
					</c:if>
					<div class="c6146">
						<label class="c6049 c6147" for="inputEmail">Mật khẩu cũ<span
							class="c6069">*</span>
						</label>
						<div class="c5741">
							<input type="password" class="c6148" name="oldpassword">
						</div>
					</div>
					<div class="c6146">
						<label class="c6049 c6147" for="inputPassword">Mật khẩu
							mới<span class="c6069">*</span>
						</label>
						<div class="c5741">
							<input type="password" class="c6148" name="newpassword">
						</div>
					</div>
					<div class="c6146">
						<label class="c6049 c6147" for="inputPassword">Nhập lại
							mật khẩu<span class="c6069">*</span>
						</label>
						<div class="c5741">
							<input type="password" class="c6148" name="confirmpassword">
						</div>
					</div>
					<div class="c6146">
						<div class="c6385">
							<button class="c6164 c6165" type="submit">Đổi mật khẩu</button>
						</div>
					</div>
				</form>
			</div>
			<div class="c6039">
				<form class="c233 c6144" action="account.html?action=changeinformation"
					method="post">
					<p>Đổi thông tin tài khoản</p>
					<c:if test="${not empty fail }">
						<p style="color: red;">${fail}</p>
					</c:if>
					<div class="c6146">
						<label class="c6049 c6147" for="inputEmail">Tên đăng nhập<span
							class="c6069"></span></label>
						<div class="c5741">
							<label class="c6049 c6147" for="inputEmail">${user.userName}<span
								class="c6069"></span></label>
						</div>
					</div>
					<div class="c6146">
						<label class="c6049 c6147">Ngày sinh<span class="c6069">*</span>
						</label>
						<div class="c5741">
							<input type="text" id="birthday" name="birthday" class="c6148"
								value="${user.birthday }">
						</div>
					</div>
					<div class="c6146">
						<label class="c6049 c6147" for="inputSex">Giới tính<span
							class="c6069">*</span></label>
						<div class="c5741">
							<select class="c6148" name="sex">
								<c:choose>
									<c:when test="${user.sex == 'Nam'}">
										<option selected="selected">Nam</option>
										<option>Nữ</option>
									</c:when>
									<c:otherwise>
										<option>Nam</option>
										<option selected="selected">Nữ</option>
									</c:otherwise>
								</c:choose>
							</select>
						</div>
					</div>
					<div class="c6146">
						<label class="c6049 c6147" for="inputEmail">Email<span
							class="c6069">*</span></label>
						<div class="c5741">
							<input type="text" id="i3" class="c6148" name="email"
								value="${user.email}">
						</div>
					</div>
					<div class="c6146">
						<label class="c6049 c6147" for="inputPhone">Điện thoại<span
							class="c6069">*</span>
						</label>
						<div class="c5741">
							<input type="text" id="i4" class="c6148" name="phone"
								value="${user.phone}">
						</div>
					</div>
					<div class="c6146">
						<label class="c6049 c6147" for="inputAddress">Địa chỉ<span
							class="c6069">*</span>
						</label>
						<div class="c5741">
							<input type="text" id="i4" class="c6148" name="address"
								value="${user.address}">
						</div>
					</div>
					<div class="c6146">
						<div class="c6385">
							<button class="c6164 c6165" type="submit">Đổi thông tin</button>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>