$(document).ready(function(){
	$("#wd-function-user .wd-user p.wd-button a").click(function(e){
		e.stopPropagation();
		$(this).parents("#wd-function-user").find(".wd-function").slideToggle(400);
	});
	$('#wd-function-user .wd-function').clickoutside(function(){
		$(this).slideUp(400);
	});
});
(function(jQuery) {
	jQuery.fn.clickoutside = function(callback) {
		var outside = 1, self = $(this);
		self.cb = callback;
		this.click(function() {
			outside = 0;
		});
		$(document).click(function() {
			outside && self.cb();
			outside = 1;
		});
		return $(this);
	}
})(jQuery);
