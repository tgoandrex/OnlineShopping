$(document).ready(function(){
	
	setTimeout(function(){
		$(".alert").fadeOut("slow");
	} ,5000);
	
	$(".shopping-datatable").DataTable({
		stateSave: true,
		lengthChange: false,
		info:false
	});
});