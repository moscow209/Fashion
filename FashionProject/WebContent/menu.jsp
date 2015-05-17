<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="c6383 c6307">
		<div class="c6384">
			<div class="c6385">
				<div class="c6310">
					<div class="c6311">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#myNavbar">
							<span class="c6312">Toggle navigation</span> <span class="c6315"></span>
							<span class="c6315"></span> <span class="c6315"></span>
						</button>
					</div>
					<div class="navbar-collapse collapse" id="myNavbar">
						<ul class="c6316 c6317">
							<li><a href="home.html">Trang chủ</a></li>
							<li><a href="cart.html?action=viewcart">Giỏ hàng</a></li>
							<li><a href="checkout.html">Thanh toán</a></li>
						</ul>

						<ul class="c6316 c6317 navbar-right">
							<c:choose>
								<c:when test="${empty username}">
									<li><a href="login.html">Đăng nhập</a></li>
								</c:when>
								<c:otherwise>
									<li class="c6321"><a class="c6322" data-toggle="dropdown"
										href="#">Tài khoản</a>
										<ul class="c6323">
											<li><a href="logout.html">Đăng xuất</a></li>
											<li><a href="history-billing.html">Lịch sử mua hàng</a></li>
											<li><a href="account.html">Sửa thông tin tài khoản</a></li>
											<li><a href="account.html">Đổi mật khẩu</a></li>
											
										</ul>
									</li>
								</c:otherwise>
							</c:choose>
							<li><a href="register.html">Đăng kí</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>