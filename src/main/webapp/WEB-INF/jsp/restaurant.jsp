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
					<button type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#myModal">Calificar</button>
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
	<div id="myModal" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h3 class="modal-title"><c:out value="${restaurant.name}"/></h3>
	      </div>
		      <div class="modal-body">
	      		<form method="POST" action="/FoodNow/addRating">
		        	<label>Calificacion</label>
		        	<input id="input-21e" type="number" name="rating" value="0"  data-symbol="&#9733;" data-default-caption="{rating}" data-star-captions="{}" class="rating" min=0 max=5 step=0.5 data-size="xs">
		        	<input name="restaurantID" value="${restaurant.id}" style="display:none">
		        	<label for="comment">Descripci&oacuten </label>
					 <textarea name="description" class="form-control" rows="5" id="description"></textarea><br>
		        	<button type="submit" class="btn btn-info" style="position:absolute;right:10px;bottom:10px">Calificar</button>
		        </form>
		      </div> 
	  		</div>
	  	</div>
	</div>
</div>
<%@include file="includes/footer.jsp" %>