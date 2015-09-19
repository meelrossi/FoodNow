<%@include file="includes/smallHeader.jsp" %>
<div id="body">
	<div class="container-fluid">
	    <section class="container">
	    	<form method="GET">			
				<div class="col-md-8" style="margin-right:50%">
					<h3 class="dark-grey">Buscar Usuario</h3>
					
					<div class="form-group col-lg-12">
						<label>e-Mail del Usuario *</label>
						<input type="" name="email" required="required" class="form-control" id="" value="">
					</div>
					
					<div class="row submit-wrapper">
						<button type="submit" class="btn btn-primary submit-button" style="margin-left:50%">Buscar usuario</button>
					</div>
				</div>
			</form>

			<div class="col-md-8" style="margin-right:50%">
				<c:choose>
					<c:when test="${user != null}">
					<ul>
						<li>	<c:out value="${user.name}"/> <c:out value="${user.lastname}"/> </br>
								<c:out value="${user.email}"/> 
								<form action="asingRestaurant?userId=${user.id}">
								    <button type="submit" class="btn btn-primary submit-button" style="margin-left:50%">Asignar Restauran</button>
								</form>
						</li>
					</ul>
					</c:when> 
					<c:when test="${user == null && hasSearched == 'true'}">
				        <h2>Usuario no encontrado.</h2>
					</c:when> 
			   	</c:choose>
			</div>
			
			<div class="col-md-8" style="margin-right:50%">
				<form action="addManager" method="post" class="col-md-6">
						<h3 class="dark-grey">Registrar Gerente</h3>
						
						<div class="form-group col-lg-6">
							<label>Nombre</label>
							<input type="text" name="name" class="form-control" id="" value="">
						</div>
						<div class="form-group col-lg-6">
							<label>Apellido</label>
							<input type="text" name="lastName" class="form-control" id="" value="">
						</div>	
						<div class="form-group col-lg-6">
							<label>e-Mail</label>
							<input type="text" name="email" class="form-control" id="" value="">
						</div>
						<div class="form-group col-lg-6">
							<label>Repetir Mail</label>
							<input type="text" name="reEmail" class="form-control" id="" value="">
						</div>
						<div class="form-group col-lg-6">
							<label>Contrase&ntildea</label>
							<input type="password" name="password" class="form-control" id="" value="">
						</div>
						<div class="form-group col-lg-6">
							<label>Repetir Contrase&ntildea</label>
							<input type="password" name="rePassword" class="form-control" id="" value="">
						</div>
						<div class="form-group col-lg-9">
							<label>Direcci&oacuten</label>
							<input type="text" name="address" class="form-control" id="" value="">
						</div>
						<div class="form-group col-lg-3">
							<label>Nacimiento</label>
							<input type="text" name="birthday" class="form-control" id="datePicker">
						</div>
						<div class="row submit-wrapper">
							<button type="submit" class="btn btn-primary submit-button">Registrar y asignar restaurant</button>
						</div>
					</form>
				</div>
			
		</section>
	</div>
</div>
<%@include file="includes/footer.jsp" %>