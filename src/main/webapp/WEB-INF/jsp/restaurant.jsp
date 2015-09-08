<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="includes/smallHeader.jsp"%>
<div id="body">
	<div class="restaurant-info">
		<h1 class="restaurant-name"><c:out value="${restaurant.name}"/></h1>
		<div class="row">
			<div class="col-md-6">
				<img class="restaurant-img" src="images/restaurante.jpeg"></img>
			</div>
			<div class="col-md-6 restaurant-detail">
				<h4>Adress y street</h4>
				<h5>Horario</h5>
			</div>
		</div>
		<div class="row menus">
			<h4 class="menu-title">MENU</h4>
			<div class="menu-type-container">
				<c:forEach var="menutype" items="${restaurant.menu}">
					<h3 class="menu-type"><c:out value="${menutype.categoryName}"/></h3>
					<div class="media">
						<c:forEach var="dish" items="menutype.dishes">
							<div class="row">
								<div class="col-md-8 restaurant-info">
								<a class="media-left" href="#">
									<img src="images/logo-restaurante.png">
								</a>
									<div class="media-body">
										<h4 class="media-heading user_name"><c:out value="${dish.name}"/></h4>
										<br><c:out value="${dish.description}"/></br>
									</div>
								</div>
								<div class="col-md-2 col-md-offset-1 quantity-container">
									<form id='myform' method='POST' action='#'>
										<input type='button' value='-' class='qtyminus' field='quantity' />
										<input type='text' name='quantity' value='0' class='qty' />
										<input type='button' value='+' class='qtyplus' field='quantity' />
									</form>
								</div>
							</div>
						</c:forEach>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<%@include file="includes/footer.jsp" %>