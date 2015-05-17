<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>History Billing</title>
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
				<h2>Lịch sử mua hàng</h2>
			</div>
		</div>
		<div class="c6384">
			<div class="c6385">
				<div class="c6291">
					<table class="c6293">
						<thead>
							<tr>
								<th>Mã đơn hàng</th>
								<th>Ngày mua</th>
								<th>Người nhận</th>
								<th>Địa chỉ</th>
								<th>Điện thoại</th>
								<th>Tổng tiền</th>
								<th>Chi tiết</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${history}">
								<tr>
									<td>${item.id}</td>
									<td>${item.date}</a></td>
									<td>${item.name}</td>
									<td>${item.address}</td>
									<td>${item.phone}</td>
									<td><fmt:formatNumber value="${item.total}" maxFractionDigits="0"></fmt:formatNumber> VND</td>
									<td><a href="detail-billing.html?id=${item.id}">Chi tiết</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>