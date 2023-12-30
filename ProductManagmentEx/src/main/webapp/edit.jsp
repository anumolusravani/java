<!DOCTYPE html>
<html>
<head>

<title>Add Product</title>
  <!-- Bootstrap CDN link to get the support of Booststrap--->
  <link rel = "stylesheet"
  href = "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="formvalidation.js"></script>
</head>
<body>
	<div class = "container mt-5 text-center">
		<h2 class="text-center fontt-italic mb-1">Edit Prodduct Date....</h2>
		<form method="post" action="./UpdateProductServlet" enctype="multipart/form-data"
		onsubmit="return validateform()">
		<div class="form-group">
			<label class="font-italic font-weight-bold" for="proId">Product Id:</label>
			<input type="text" class="form-control-sm" id="proId" name="proId"  value = "${existingProduct.proId }" required>
		</div>
		
		<div class="form-group">
			<label class="font-italic font-weight-bold" for="proName">Product Name:</label>
			<input type="text" class="form-control-sm" id="proName" name="proName" value = "${existingProduct.proName }"required>
		</div>
		
		<div class="form-group">
			<label class="font-italic font-weight-bold" for="proPrice">Product Price:</label>
			<input type="text" class="form-control-sm" id="proPrice" name="proPrice" value = "${existingProduct.proPrice }"required>
		</div>
		
		<div class="form-group">
			<label class="font-italic font-weight-bold" for="proBrand">Product Brand:</label>
			<input type="text" class="form-control-sm" id="proBrand" name="proBrand" value = "${existingProduct.proBrand }" required>
		</div>
		
		<div class="form-group">
			<label class="font-italic font-weight-bold" for="proMadeIn">Product MadeIn:</label>
			<input type="text" class="form-control-sm" id="proMadeIn" name="proMadeIn"  value = "${existingProduct.proMadeIn }"required>
		</div>
		
		<div class="form-group">
			<label class="font-italic font-weight-bold" for="proMfgDate">Product MfgDate:</label>
			<input type="date" class="form-control-sm" id="proMfgDate" name="proMfgDate" value = "${existingProduct.proMfgDate }" required>
		</div>
		
		<div class="form-group">
			<label class="font-italic font-weight-bold" for="proExpDate">Product ExpDate:</label>
			<input type="date" class="form-control-sm" id="proExpDate" name="proExpDate" value = "${existingProduct.proExpDate }" required>
		</div>
		
		<div class="form-group">
			<label class="font-italic font-weight-bold" for="proImage">Product Image:</label>
			<input type="file" class="form-control-sm" id="proImage" name="proImage"  accept="image/" value = "${existingProduct.proImage }"
			>
		</div>
		
		<div >
			<input type="submit" class="btn btn-success" id="proMfgDate" value="update product"/>
			<a href="productlist.jsp" class="btn btn-primary">List of products</a>
		</div>
		</form>
		
	</div>

</body>
</html>