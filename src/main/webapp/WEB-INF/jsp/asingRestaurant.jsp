<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="includes/header.jsp" %>
  <nav class="navbar navbar-default">
    <div class="container-fluid topbar">
      <ul class="nav navbar-nav">
          <li><a href="/FoodNow/index"><span class="glyphicon glyphicon-home" aria-hidden="true" style="font-size:20px"></span></a></li>
          <li class="active"><a href="/FoodNow/restaurantList">Restoranes</a></li>
      </ul>
    </div>
  </nav>
</div>
<div id="body">
  <div class="row">
    <div class="col-md-8 section">
      <div class="page-title">
        <h2> Elija un restoran para asignarle al gerente:  <c:out value="${user.name}"/> <c:out value="${user.lastname}"/> </h2>
      </div> 
      <div class="comments-list">
        <c:forEach var="restaurant" items="${restaurants}">
          <div class="media">
            <div class="row restaurant-info">
              <div class="col-md-7">
                <a class="media-left" href="#">
                  <img src="images/logo-restaurante.png"/>
                </a>
                <div class="media-body">
                  <h4 class="media-heading user_name"><c:out value="${restaurant.name}"/></h4>
                  <br><c:out value="${restaurant.address.street}"/>  <c:out value="${restaurant.address.number}"/>
                  <div class="row actions-row">
                  	<form action="asignRestaurant" method="POST">
                  		<input type="hidden" name="restaurantId" value="${restaurant.id}" />
                  		<input type="hidden" name="userId" value="${user.id}" />
						<button type="submit" class="btn btn-primary submit-button">Asignar restoran</button>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>
</div>
<%@include file="includes/footer.jsp" %>