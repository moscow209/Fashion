<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:200,300,400,600,700'
	rel='stylesheet' type='text/css' />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:200,300,400,600,700'
	rel='stylesheet' type='text/css' />
</head>
<body>
	<div class="c6383 c6282">
		<div class="c6384">
			<div class="c6284">
				<div class="c6285">
					<a href="index.html">Fashion</a>
				</div>
			</div>
			<div class="c6286">
				<form action="search.html" method="get">
					<div class="c6146">
						<div style="float: right;">
							<input type="text" placeholder="Search" id="i3" class="c6148"
								name="keyword" style="width: 210px;">
						</div>
						<select class="c6148" name="type"
							style="width: 140px; height: 35px; float: right; margin-right: 10px;">
							<option value="producer">Nhà sản xuất</option>
							<option value="color">Màu sắc</option>
							<option value="size">Kích thước</option>
							<option value="price">Giá bán</option>
						</select>
					</div>
				</form>
			</div>
		</div>



		<div class="c6384" style="padding-top: 20px;">

			<div class="c6288 c6321">
				<img alt="cart empty" src="image/shopping_basket.png"> <a
					href="cart.html" class="c6322" data-toggle="dropdown">
					<c:choose>
						<c:when test="${not empty cart}">
							<span id="number">${cart.cart.size()}</span> items(s)</a>
						</c:when>
						<c:otherwise>
							<span id="number">0</span> items(s)</a>
						</c:otherwise>
					</c:choose>
				<div class="c6291 c6323">
					<table class="c6293">
						<thead></thead>
						<tbody id="cart-shopping">
							<c:forEach var="item" items="${cart.cart}" varStatus="status">
								<tr class="${status.index}">
									<td class="c6299"><img alt="IMAGE"
										src="${item.image}"></td>
									<td class="c6368"><a href="product.html">${item.name}</a></td>
									<td class="c6301 c1994">x&nbsp;${item.number}</td>
									<td class="c6302>"><span class="c1995">${item.total}</span> VND</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="c6304">
						<div class="c6305">
							<a href="cart.html?action=viewcart">Giỏ hàng</a> | <a href="checkout.html">Thanh toán</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>