$(document).ready(function(){
	$(".wd-list-transaction .wd-list-transaction-form .wd-list-transaction-table tbody tr:odd").css("background-color","#f6f8f8");
	$('.wd-accordion').accordion({
		autoHeight  : false,
		navigation  : true
	});
	$(".wd-list-citizen .wd-search-filter .wd-filter .wd-select").uniform();
	$(".wd-list-citizen-02 .wd-search-filter .wd-filter .wd-select").uniform();
	$(".wd-function .wd-fancy-change-pass").fancybox();
});