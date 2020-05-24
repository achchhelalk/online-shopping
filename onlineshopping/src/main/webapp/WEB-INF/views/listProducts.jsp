<div class="container">
	<div class="row">
		<!-- Display sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- Display actual products -->
		<div class="col-md-9">

		<!-- Added breadcrumb component -->
		<div class="row">
			<div class="col-lg-12">
				<c:if test="${ userClickAllProducts == true}">
					<ol class="breadcrumb">
						<li><a href="${contextRoot}/home">Home</a></li>
						<li><a class="active">All Products</a></li>
					</ol>
				</c:if>

				<c:if test="${userClickcategoryProducts == true}">
					<ol class="breadcrumb">
						<li><a href="${contextRoot}/home">Home</a></li>
						<li><a class="active">Category</a></li>
						<li><a class="active">${category.name}</a></li>
					</ol>
				</c:if>

			</div>
		</div>
	</div>
</div>