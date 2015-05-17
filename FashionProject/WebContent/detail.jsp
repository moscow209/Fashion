<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detail Product</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script language="javascript" type="text/javascript"
	src="js/bootstrap.min.js"></script>
<script language="javascript" type="text/javascript"
	src="js/nicole-fashion.js"></script>
<script language="javascript" type="text/javascript"
	src="js/cloud-zoom.1.0.3.js"></script>
<script type="text/javascript">
	function addCart(id) {
		var xmlhttp = new XMLHttpRequest();
		var color = $('select[name=color]').val();
		var size = $('select[name=size]').val();
		var number = $('input[name=quantity]').val();
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
		xmlhttp.send("action=addcart&" + "id=" + id + "&color=" + color + "&size=" + size + "&number=" + number);
		
	}
</script>
</head>
<body>
	<div class="c6279 c6383">
		<jsp:include page="hearder.jsp"></jsp:include>
		<jsp:include page="menu.jsp"></jsp:include>

		<div class="c6383">
			<div class="c6384 c6030">
				<div class="c6039">
					<div class="c6299">
						<a class="c6033" rel="adjustX: 0, adjustY:0" id="zoom1"
							href="${zoomImage}" title="Nano"><img src="${zoomImage}"
							title="Nano" alt="Nano" id="i199" /></a>
					</div>
				</div>
				<div class="c6039">
					<!--  -->
					<h1>${product.name}</h1>
					<div class="c6369"></div>
						Nhà sản xuất:  ${product.producer}
					<div class="c6369">
						Giá: <fmt:formatNumber value="${product.price}" maxFractionDigits="0"></fmt:formatNumber> VNĐ
					</div>
					<div class="c6048">
						<label class="c6049">Màu sắc<span class="c6069">*</span></label>
						<div class="c6051">
							<select name="color">
								<c:forEach var="itemColor" items="${color}">
									<option>${itemColor}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="c6048">
						<label class="c6049">Kích thước<span class="c6069">*</span></label>
						<div class="c6051">
							<select name="size">
								<c:forEach var="itemSize" items="${size}">
									<option>${itemSize}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="c6052"></div>
					<div class="c6053">
						<label>Qty:</label> <input type="text" value="1" class="c6054" name="quantity">
						<a class="c6164 c6165" href = "javascript:void(0)" onclick="addCart(${product.id})">Thêm giỏ hàng</a>
					</div>
				</div>
			</div>
		</div>


		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<script language="javascript" type="text/javascript"
		src="js/nicole-fashion.js"></script>
	<script>
		$.fn.CloudZoom.defaults = {
			zoomWidth : "auto",
			zoomHeight : "auto",
			position : "inside",
			adjustX : 0,
			adjustY : 0,
			adjustY : "",
			tintOpacity : 0.5,
			lensOpacity : 0.5,
			titleOpacity : 0.5,
			smoothMove : 3,
			showTitle : false
		};
		jQuery(document).ready(function() {
			$('#i157 a').click(function(e) {
				e.preventDefault();
				$(this).tab('show');
			})
		});
	</script>
	<script>
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-34009911-5' ]);
		_gaq.push([ '_trackPageview' ]);
		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl'
					: 'http://www')
					+ '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>
</body>
</html>