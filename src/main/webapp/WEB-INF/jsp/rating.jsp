<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="includes/smallHeader.jsp"%>
<div id="body">
	<div class="rating-view">
		<h1 class="restaurant-name"><c:out value="${restaurantName}"/></h1>
		<div class="row">
			<h4 class="menu-title">CALIFICACIONES</h4><br>
			<c:forEach var="rating" items="${ratings}">
				<div class="row">
					<div class="col-sm-1">
						<div class="thumbnail">
							<img class="img-responsive user-photo" src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
						</div><!-- /thumbnail -->
						<input id="input-21e" type="number" value="${rating.value}"  data-symbol="&#9733;" readonly="true" data-default-caption="{rating}" data-star-captions="{}" class="rating" min=0 max=5 step=0.5 data-size="10em">
					</div><!-- /col-sm-1 -->
					<div class="col-sm-5">
						<div class="panel panel-default">
							<div class="panel-heading">
								<strong><c:out value="${rating.user.name}"/>  <c:out value="${rating.user.lastname}"/></strong>
							</div>
							<div class="panel-body">
								 <c:out value="${rating.description}"/>
							</div><!-- /panel-body -->
						</div><!-- /panel panel-default -->
					</div><!-- /col-sm-5 -->
				</div><!-- /row -->
			</c:forEach>
		</div>
		</div>
	</div>
</div>
<%@include file="includes/footer.jsp" %>