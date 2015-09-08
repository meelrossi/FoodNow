<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="includes/header.jsp" %>
<div id="body">
  <div class="row">
    <div class="col-md-3 section filters">
      <div class="fading-side-menu" data-spy="affix" data-offset-top="350">
        <ul class="list-unstyled">
          <c:forEach var="category" items="${categories}">
            <li class="filter-element">
              <c:url var="url" value="/restaurantList">
                <c:param name="category" value="${category}" />
              </c:url>
              <a href="${url}">
                <span class="glyphicon glyphicon-play"></span><c:out value="${category}"/>
              </a>
            </li>
          </c:forEach>
        </ul>
      </div>
    </div>
    <div class="col-md-8 section">
      <div class="page-title">
        <h1> Restoranes </h1>
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
                  <p><a href="">Ver Menu</a> - <a href="">Calificar Restoran</a></p>
                </div>
              </div>
              <div class="col-md-5">
                <input id="input-21e" type="number" value="3.4" showclear="false" readonly="true" data-default-caption="{rating}" data-star-captions="{}" class="rating" min=0 max=5 step=0.5 data-size="xs">
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>
</div>
<%@include file="includes/footer.jsp" %>