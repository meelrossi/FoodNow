<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="includes/smallHeader.jsp"%>
<div id="body">
	<div class="restaurant-view">
		<h1 class="restaurant-name"><c:out value="${restaurant.name}"/></h1>
		<div class="row">
			<div class="col-md-6">
				<img class="restaurant-img" src="images/restaurante.jpeg"></img>
			</div>
			<div class="col-md-6 restaurant-detail">
				<div class="row address">
					<p><c:out value="${restaurant.address.street}"/>  <c:out value="${restaurant.address.number}"/></p>
				</div>
				<div class="row availableTime">
					<p><c:out value="${restaurant.availableTime}"/></p>
				</div>
				<div class="row restaurant-description">
					<p><c:out value="${restaurant.description}"/></p>
				</div>
				<div class="row rating">
                	<input id="input-21e" type="number" value="${restaurant.rating}"  data-symbol="&#9733;" readonly="true" data-default-caption="{rating}" data-star-captions="{}" class="rating" min=0 max=5 step=0.5 data-size="xs">
                	<c:url var="url" value="/ratings">
                    	<c:param name="id" value="${restaurant.id}" />
                	</c:url>
                	<a href="${url}">Ver Calificaciones </a>
                </div>
			</div>
		</div>
		<div class="row menus">
			<h4 class="menu-title">MENU</h4>
			<div class="menu-type-container">
				<c:forEach var="menutype" items="${restaurant.menu}">
					<h3 class="menu-type"><c:out value="${menutype.categoryName}"/></h3>
					<div class="media">
						<c:forEach var="dish" items="${menutype.dishes}">
							<div class="row">
								<div class="col-md-8 ">
								<div class="media-left">
									<img src="images/logo-restaurante.png">
								</div>
									<div class="media-body">
										<h4 class="media-heading user_name"><c:out value="${dish.name}"/></h4>
										<br><c:out value="${dish.description}"/></br>
									</div>	
								</div>
								<div class="col-md-2 col-md-offset-1 quantity-container">
									<form method='POST' action='#'>
										<input type="number" value="0" name="quantity" min="1" max="5">
									</form>
								</div>
							</div>
						</c:forEach>
					</div>
				</c:forEach>
				<br>
				<button type="submit" class="btn btn-primary submit-button" style="margin-left:50%">Realizar pedido</button>
			</div>
		</div>
	</div>
</div>
<%@include file="includes/footer.jsp" %>