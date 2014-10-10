$(document).ready(function(){
	$(".wd-new-profile-table tbody tr:odd").css("background-color","#f6f8f8");
	$('.wd-accordion').accordion({
		autoHeight  : false,
		navigation  : true
	});
	$(".wd-user-employee .wd-select").uniform();
	$(".wd-user-employee-02 .wd-select").uniform();
	$(".wd-new-profile-table .wd-authentication-popup").fancybox();
})