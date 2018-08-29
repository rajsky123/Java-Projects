<div class="container">

	<div class="row">

		<!-- would be to display sidebar -->

		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>


		<!-- would be to display products -->
		<div class="col-md-9">

			<!-- added breadcrumb element -->
			<div class="row">

				<div class="lg-col-12">

					<c:if test="${userClickAllProducts==true}">
					
					 <script>

                         window.categoryId="";
					 </script>
					
					
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>

					</c:if>
					
					<c:if test="${userClickCategoryProducts==true}">
					
					<script>
                          window.categoryId='${category.id}';
					 </script>
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>

					</c:if>
				</div>


			</div>


			<div class="row">
			
			   <div class="col-xs-12">
			      
			      <table id="productListTable" class="table table-striped table-bordered">
			      
			           <thead>
			               <tr>
			                     <th></th>
			                     <th>NAME</th>
			                     <th>BRAND</th>
			                     <th>PRICE</th>
			                     <th>QTY AVAILABLE</th>
			                     <th></th>
			               </tr>
			           </thead>
			      
			      </table>
			   </div>
			</div>
		</div>
	</div>
</div>