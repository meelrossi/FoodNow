<%@include file="includes/smallHeader.jsp" %>
<div id="body">
	<div class="container-fluid">
	    <section class="container">
	    	<form method="POST">			
				<div class="col-md-8" style="margin-right:50%">
					<h3 class="dark-grey">Agregar Restoran</h3>
					<br><br>
					<div class="form-group col-lg-12">
						<label>Nombre * </label>
						<input type="" name="name" required="required" class="form-control" id="" value="">
					</div>	
					<div class="form-group col-lg-8">
						<label>Calle *</label>
						<input type="" name="addressStreet" class="form-control" id="" value="">
					</div>
					<div class="form-group col-lg-4">
						<label>Numero *</label>
						<input type="" name="addressNumber" class="form-control" id="" value="">
					</div>
					<div class="form-group col-lg-3">
		        		<label for="c2">Costo de envio *</label>
					    <div class="input-group"> 
					        <span class="input-group-addon">$</span>
					        <input type="number" name="deliveryCost" value="0" min="0" step="0.01" data-number-to-fixed="2" data-number-stepfactor="100" class="form-control currency" id="c2" />
					    </div> 
					</div>
					<div class="form-group col-lg-3">
		        		<label for="c2">Monto minimo *</label>
					    <div class="input-group"> 
					        <span class="input-group-addon">$</span>
					        <input type="number" name="minAmount" value="0" min="0" step="0.01" data-number-to-fixed="2" data-number-stepfactor="100" class="form-control currency" id="c2" />
					    </div> 
					</div>
					<br>
					<div class="form-group col-lg-12">
						<label>Horario *</label>
						<input type="" name="availableTime" class="form-control" id="" value="">
					</div>
					<div class="form-group col-lg-12">
					  <label for="comment">Descripci&oacuten </label>
					  <textarea name="description" class="form-control" rows="5" id="comment"></textarea>
					</div>
					<div class="row submit-wrapper">
						<button type="submit" class="btn btn-primary submit-button" style="margin-left:50%">Agregar restaurant</button>
						<button class="btn btn-danger submit-button" style="margin-left:10px">Cancelar</button>
					</div>
				</div>
			</form>
		</section>
	</div>
</div>
<%@include file="includes/footer.jsp" %>