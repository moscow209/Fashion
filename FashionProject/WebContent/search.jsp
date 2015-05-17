<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script language="javascript" type="text/javascript"
	src="js/bootstrap.min.js"></script>
<script language="javascript" type="text/javascript"
	src="js/nicole-fashion.js"></script>
<script type="text/javascript">
	function addCart(id) {
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				$("#cart-shopping").append(xmlhttp.responseText);
				var number = parseInt($("#number").text()) + 1;
				$("#number").text(number);
				alert("Đã thêm sản phẩm vào giỏ hàng");
			}
		}
		xmlhttp.open("POST", "cart.html", true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("action=addcart&" + "id=" + id);
	}
</script>

</head>
<body>
	<jsp:include page="hearder.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>

	<div class="c6383">
		<div class="c6384" style="margin-top: -20px;">
			<div class="c6385">
				<h2>Tìm kiếm</h2>
				<c:if test="${not empty failed}">
					<p class="c4346">Không tìm thấy kết quả tìm kiếm!</p>
				</c:if>
				<c:if test="${empty failed}">
					<p class="c4346">Kết quả tìm kiếm!</p>
				</c:if>
			</div>
		</div>
		<c:if test="${empty failed}">
			<div class="c6384">
				<c:forEach var="item" items="${productList}" begin="${(currentPage - 1)*8}" end="${currentPage*8 - 1}">
					<div class="c6366">
						<div class="c6367">
							<a href="detail-product.html?id=${item.id}"><img alt="dress"
								src="${item.image}"></a>
							<div class="c6368">
								<a href="detail-product.html?id=${item.id}">${item.name}</a>
							</div>
							<div class="c6369">
								<p>
									<fmt:formatNumber value="${item.price}" maxFractionDigits="0"></fmt:formatNumber>
									VNĐ
								</p>
							</div>
							<div class="c6190">
								<a href="javascript:void(0)" onclick="addCart(${item.id})">Add
									to cart</a>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>

			<div class="c6384">
				<div class="c6385">
					<ul class="c3590 c5568">
						<c:if test="${currentPage != 1 }">
							<li><a href="search.html?page=${currentPage - 1}${url}">«</a></li>
						</c:if>
						<c:forEach var="number" begin="1" end="${noOfPages}">
							<c:choose>
								<c:when test="${currentPage == number}">
									<li class="active"><a href="search.html?page=${number}${url}">${number}</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="search.html?page=${number}${url}">${number}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${currentPage != noOfPages }">
							<li><a href="search.html?page=${currentPage + 1}${url}">»</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</c:if>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>