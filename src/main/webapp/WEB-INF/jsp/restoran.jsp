<%@include file="includes/smallHeader.jsp" %>
<div id="body">
	<div class="restaurant-info">
		<h1 class="restaurant-name">Nombre Restaurante</h1>
		<div class="row">
			<div class="col-md-6">
				<img class="restaurant-img" src="../../images/restaurante.jpeg"></img>
			</div>
			<div class="col-md-6 restaurant-detail">
				<h4>Direccion 12345 </h4>
				<h5>Horario</h5>
			</div>
		</div>
		<div class="row menus">
			<h4 class="menu-title">MENU</h4>
			<div class="menu-type-container">
				<h3 class="menu-type">Tipo de menu</h3>
				<div class="media">
	                <div class="row">
	                  <div class="col-md-8 restaurant-info">
	                      <a class="media-left" href="#">
	                          <img src="../../images/logo-restaurante.png">
	                      </a>
	                      <div class="media-body">
	                            <h4 class="media-heading user_name">Nombre Plato</h4>
	                            <br>Descripcion
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
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="includes/footer.jsp" %>