<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detail Billing</title>
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
				<h2>Chi tiết hóa đơn</h2>
			</div>
		</div>
		<div class="c6384">
			<div class="c6385">
				<div class="c6291">
					<table class="c6293">
						<thead>
							<tr>
								<th>Mã đơn hàng</th>
								<th>Mã sản phẩm</th>
								<th>Màu sắc</th>
								<th>Kích thước</th>
								<th>Số lượng</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${detail}">
								<tr>
									<td>${item.id}</td>
									<td><a href="detail-product.html?id=${item.product}">${item.product}</a></td>
									<td>${item.color}</td>
									<td>${item.size}</td>
									<td>${item.number}</td>
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