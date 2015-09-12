<%@include file="includes/smallHeader.jsp" %>
<div id="body">
	<div class="container-fluid">
	    <section class="container">
	    	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">Agregar Tipo de Menu</h4>
			      </div>
			      <div class="modal-body">
			      	<label>Tipo * </label>
			        <input name="dishName" required="required" class="form-control" id="menuType" value="">
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="addMenuType()">Agregar</button>
			      </div>
			    </div>
			  </div>
			</div>
			<form method="POST">			
				<div class="col-md-8" style="margin-right:50%">
					<h3 class="dark-grey">Agregar Plato</h3>
					<br><br>
					<div class="row">
						<div class="col-md-4 form-group">
							<label>Tipo de Menu *</label>	
							<select id="selectElement" class="form-control" name="menuCategory">
								<c:forEach var="category" items="${menuCategories}">
							    	<option value="${category}"><c:out value="${category}"/></option>
							    </c:forEach>
							</select>
							<br>
							<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal"> Agregar Tipo de Menu
							</button>
						</div>
					</div>
					<div class="form-group col-lg-12">
						<label>Nombre * </label>
						<input type="" name="dishName" required="required" class="form-control" id="" value="">
					</div>	
					<div class="form-group col-lg-3">
		        		<label for="c2">Precio *</label>
					    <div class="input-group"> 
					        <span class="input-group-addon">$</span>
					        <input type="number" name="price" required="required" value="0" min="0" step="0.01" data-number-to-fixed="2" data-number-stepfactor="100" class="form-control currency" id="c2" />
					    </div> 
					</div>
					<div class="form-group col-lg-12">
					  <label for="comment">Descripci&oacuten </label>
					  <textarea name="description" class="form-control" rows="5" id="comment"></textarea>
					</div>
					<div class="row submit-wrapper">
						<button type="submit" class="btn btn-primary submit-button" style="margin-left:50%">Agregar plato</button>
						<button class="btn btn-danger submit-button" style="margin-left:10px">Cancelar</button>
					</div>
				</div>
			</form>
		</section>
	</div>
	<script>
		function addMenuType() {
		    var menuTypeToAdd = document.getElementById("menuType").value;
		    var select = document.getElementById('selectElement');
			var opt = document.createElement('option');
		    opt.value = menuTypeToAdd;
		    opt.innerHTML = menuTypeToAdd;
		    select.appendChild(opt);
		}
	</script>
</div>
<%@include file="includes/footer.jsp" %>