<%@include file="includes/smallHeader.jsp" %>
<div id="body">
	<div class="container-fluid">
	    <section class="container">
	    	<div id="userCreationSuccess" class="alert alert-success fade in">
			  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			 <strong>Felicitaciones</strong> su cuenta ha sido creada con exito.
			</div>
			<div id="userCreationFail" class="alert alert-danger fade in">
			  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			  <strong>Oops!</strong> se produjo un error al intentar crear el usuario, intentelo mas tarde.
			</div>
			<div id="emailMissmatch" class="alert alert-danger fade in">
			  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			  <strong>Oops!</strong> los e-Mails ingresados no coinciden.
			</div>
			<div id="passwordMissmatch" class="alert alert-danger fade in">
			  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			  <strong>Oops!</strong> las contrase&ntildeas ingresadas no coinciden.
			</div>
			<div id="wrongPasswordOrUser2" class="alert alert-danger fade in">
			  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			  <strong>Oops!</strong> la contrase&ntildea o usuario son incorrectos.
			</div>
				<form action="Login" method="post" class="col-md-4">
					<h3 class="dark-grey">Iniciar Sesi&oacuten</h3>
					<div class="row">	
						<div class="form-group col-lg-12">
							<label>Mail</label>
							<input type="text" name="email" class="form-control" id="" value="">
						</div>
					</div>
					<div class="row">
						<div class="form-group col-lg-12">
							<label>Contrase&ntildea</label>
							<input type="password" name="password" class="form-control" id="" value="">
						</div>
					</div>
					<div class="row submit-wrapper">
						<button type="submit" class="btn btn-primary submit-button">Aceptar</button>
					</div>
				</form>
				<div class="col-md-2">
					<div class="separator"></div>
				</div>
				<form action="Register" method="post" class="col-md-6">
					<h3 class="dark-grey">Registrarse</h3>
					
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
						<button type="submit" class="btn btn-primary submit-button">Registrarse</button>
					</div>
				</form>
		</section>
	</div>
</div>
<script>
	$('#datePicker').datepicker({
	    format: "dd/mm/yyyy",
	    todayBtn: true,
	    language: "es"
	});
</script>
<%@include file="includes/footer.jsp" %>