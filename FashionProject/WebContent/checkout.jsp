<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pay</title>
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
				<h2>Thanh toán</h2>
				<c:if test="${empty username}">
					<p class="c4346">
						Bạn chưa đăng nhập? <a href="login.jsp">Hãy click để đăng nhập</a>
					</p>
				</c:if>
			</div>
		</div>
		<div class="c6384">
			<div class="c6039">
				<h3>Thông tin người nhận</h3>
				<c:if test="${not empty failed }">
					<p style="color: red;">${failed}</p>
				</c:if>
				<form class="c6144" role="form" action="checkout.html" method="post">
					<div class="c6146">
						<label class="c6366 c6049" for="inputfirstname">Tên người
							nhận<span class="c6069">*</span>
						</label>
						<div class="c5428">
							<input type="text" class="c6148" placeholder="Name" name="name">
						</div>
					</div>
					<div class="c6146">
						<label class="c6366 c6049" for="inputfirstname">Địa chỉ<span
							class="c6069">*</span></label>
						<div class="c5428">
							<input type="text" class="c6148" placeholder="Address"
								name="address">
						</div>
					</div>
					<div class="c6146">
						<label class="c6366 c6049" for="inputfirstname">Điện thoại<span
							class="c6069">*</span></label>
						<div class="c5428">
							<input type="text" class="c6148" placeholder="Phone" name="phone">
						</div>
					</div>
					<div class="c6146">
						<label class="c6366 c6049" for="inputSex">Pay Method<span
							class="c6069">*</span></label>
						<div class="c5428">
							<select class="c6148" name="method">
								<option>Redirect pay</option>
							</select>
						</div>
					</div>

					<div class="c6146">
						<div class="c6385">
							<button class="c6164 c6165" type="submit">Thanh toán</button>
						</div>
					</div>
				</form>
			</div>

			<div class="c6039">
				<div class="c6385">
					<div class="c1253">
						<h3>Hóa đơn</h3>
						<table class="c6293 c5536 c1256">
							<thead>
								<tr>
									<th></th>
									<th>Tổng</th>
								</tr>
							</thead>
							<tbody>
								<tr class="c1259">
									<td><b>Tổng tiền</b></td>
									<td><fmt:formatNumber value="${cart.getTotalCart()}"
											maxFractionDigits="0"></fmt:formatNumber> VND</td>
								</tr>
								<tr class="c1259">
									<td><b>Phí vận chuyển</b></td>
									<td>Miễn phí</td>
								</tr>
								<tr class="c1259">
									<td><b>Tổng tiền</b></td>
									<td><fmt:formatNumber value="${cart.getTotalCart()}"
											maxFractionDigits="0"></fmt:formatNumber> VND</td>
								</tr>
							</tbody>
						</table>

					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>