function validateform()
{
	var proId = document.getElementById("proId").value;
	var proName = document.getElementById("proName").value;
	var proPrice = document.getElementById("proPrice").value;
	var proBrand = document.getElementById("proBrand").value;
	var proMadeIn = document.getElementById("proMadeIn").value;
	
	if(proId.trim()===""|| proName.trim()===""|| proPrice.trim()===""|| proBrand.trim()===""
	||proMadeIn.trim()==="")
   {
	   alert("All fields must be field out ");
	   return false;
   }	
   if(parseFloat(proPrice)<0)
   {
	   alert("proprice must be a non-negitive value")
	   return false;
   }
   if(proName.length>50 || proBrand.length>50)
   {
	   alert("product name and probrand must be less tha 50 characters");
	   return false;
   }
  //get the mfg and exp data
  var proMfgDate = document.getElementById("proMfgDate").value;
  var proExpDate = document.getElementById("proExpDate").value;
  
  // convert into data formate
  var manufacturingDateObj = new Date(proMfgDate);
  var expiryDateObj = new Date(proExpDate);
  
  //check the validation of dates
  if(manufacturingDateObj>expiryDateObj) 
  {
	  alert("Manufacturing date cannot be greater than expiry date ");
	  return false;
  }
  return true;
  }
   
  
