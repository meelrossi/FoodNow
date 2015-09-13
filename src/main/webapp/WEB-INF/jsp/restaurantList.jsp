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
    <div class="col-md-3 section filters">
      <div class="fading-side-menu" data-spy="affix" data-offset-top="350">
        <form>
          <div class="checkbox">
            <c:forEach var="category" items="${categories}">
                <label>
                  <input type="checkbox" name="category" value="${category}">
                  <c:out value="${category}"/>
                </label>
                <br><br>
            </c:forEach>
          </div>
          <button type="submit" class="btn btn-primary submit-button filter-button">Buscar</button>
        <form>
      </div>
    </div>
    <div class="col-md-8 section">
      <div class="page-title">
        <h1> RESTORANES </h1>
      </div> 
      <div class="comments-list">
        <c:forEach var="restaurant" items="${restaurants}">
          <div class="media">
            <div class="row restaurant-info">
              <div class="col-md-7">
                <c:url var="url" value="/restaurant">
                    <c:param name="id" value="${restaurant.id}" />
                </c:url>
                <a class="media-left" href="${url}">
                  <img src="images/logo-restaurante.png"/>
                </a>
                <div class="media-body">
                  <h4 class="media-heading user_name"><c:out value="${restaurant.name}"/></h4>
                  <br><c:out value="${restaurant.address.street}"/>  <c:out value="${restaurant.address.number}"/>
                  <br>
                  <a href="${url}">
                    Ver menu
                  </a>
                  <div class="row actions-row">
                    <button type="button" title="Eliminar restoran" class="btn btn-danger btn-circle"><i class="glyphicon glyphicon-remove"></i></button>
                    <button type="button" title="Editar restoran" class="btn btn-primary btn-circle"><i class="glyphicon glyphicon-pencil"></i></button>
                  </div>
                </div>
              </div>
              <div class="col-md-5">
                <input id="input-21e" type="number" value="${restaurant.rating}"  data-symbol="&#9733;" readonly="true" data-default-caption="{rating}" data-star-captions="{}" class="rating" min=0 max=5 step=0.5 data-size="xs">
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>
</div>
<%@include file="includes/footer.jsp" %>