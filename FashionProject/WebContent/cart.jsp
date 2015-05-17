<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script language="javascript" type="text/javascript"
	src="js/bootstrap.min.js"></script>
<script language="javascript" type="text/javascript"
	src="js/nicole-fashion.js"></script>
<script type="text/javascript">
	function removeCart(id) {
		$("." + id).remove();
		var number = parseInt($("#number").text()) - 1;
		$("#number").text(number);
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var total = parseInt(xmlhttp.responseText);
				$(".total").text(total);
			}
		}
		xmlhttp.open("POST", "cart.html", true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("action=removecart&" + "id=" + id);
	}
	
	function updateCart(id) {
		var number =  $("input[name=quantity" + id + "]").val();
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				$("." + id).children(".c1994").text("x" + number);
				var result = xmlhttp.responseText;
				var res = result.split("-");
				$("." + id).find(".c1995").text(res[0]);
				$(".total").text(res[1]);
			}
		}
		xmlhttp.open("POST", "cart.html", true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("action=updatecart&" + "id=" + id + "&quantity=" + number);
	}
</script>
</head>
<body>
	<jsp:include page="hearder.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="c6383">
		<div class="c6384" style="margin-top: -20px;">
			<div class="c6385">
				<h2>Giỏ hàng</h2>
			</div>
		</div>
		<div class="c6384">
			<div class="c6385">
				<div class="c6291">
					<table class="c6293">
						<thead>
							<tr>
								<th>Ảnh</th>
								<th>Nhà sản xuất</th>
								<th>Màu sắc</th>
								<th>Kích thước</th>
								<th>Số lượng</th>
								<th>Tổng tiền</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${cart.cart}" varStatus="status">
								<tr class="${status.index}">
									<td class="c6299"><img alt="IMAGE" src="${item.image}"></td>
									<td class="c6368"><a href="product.html">${item.name}</a></td>
									<td>${item.color}</td>
									<td class="c6302">${item.size}</td>
									<td class="c6301"><input type="text" size="1"
										value="${item.number}" name="quantity${status.index}"> 
										<input type="image" title="Update" alt="Update" src="image/update.png" onclick="updateCart(${status.index})" > 
										<input type="image" title="Remove" alt="Remove" src="image/remove.png" onclick="removeCart(${status.index})"></td>
									<td><span class="c1995">${item.total}</span> VND</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="c6384">
			<div class="c6385">
				<h3>Tổng tiền giỏ hàng</h3>
				<div class="c817">
					<table class="c6293">
						<tbody>
							<tr>
								<th>Tổng tiền</th>
								<td><span class="total"><fmt:formatNumber value="${cart.getTotalCart()}"
										maxFractionDigits="0"></fmt:formatNumber></span> VND</td>
							</tr>
							<tr>
								<th>Phí vận chuyển</th>
								<td>Miễn phí</td>
							</tr>
							<tr>
								<th><span>Tổng tiền</span></th>
								<td><span class="total"><fmt:formatNumber value="${cart.getTotalCart()}"
										maxFractionDigits="0"></fmt:formatNumber></span> VND</td>
							</tr>
						</tbody>
					</table>
					<p>
						<a class="c6164 c6165" href="checkout.html">Thanh toán</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>