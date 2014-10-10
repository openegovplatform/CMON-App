$(document).ready(function() {	
	var tbl_dvc_header_thutuc = $('#ipThuTucTitle').val();
	var tbl_dvc_header_nguoinop = $('#ipNguoiNopTitle').val();
	var tbl_dvc_header_ngaynop = $('#ipNgayNopTitle').val();
	var tbl_dvc_header_thaotac = $('#ipThaoTacTitle').val();
	$('.tbl_dvc_header_thutuc').empty().append(tbl_dvc_header_thutuc);
	$('.tbl_dvc_header_nguoinop').empty().append(tbl_dvc_header_nguoinop);
	$('.tbl_dvc_header_ngaynop').empty().append(tbl_dvc_header_ngaynop);
	$('.tbl_dvc_header_thaotac').empty().append(tbl_dvc_header_thaotac);
	
	//display active data
    $(".wd-list-menu li:first-child.wd-has-sub ul").css("display", "block");
	$(".wd-main-content div.side-content:first-child").css("display", "block");
	
    $(".wd-list-menu > li").toggle(function() {
        $(this).find("ul.wd-submenu").slideDown(300);
    }, function() {
        $(this).find("ul.wd-submenu").slideUp(300);
    });
    
	$("#menu_dvc > li > a").on("click",function(event){
		var hrefval = $(this).attr("href"); 
		if(hrefval != "#"){
			$('#menu_dvc li').removeClass('wd-active');
			$(".side-content").hide();
			$(this).parents('li').addClass('wd-active');
			$(hrefval).show();
		}
	});
	$("#menu_dvc > li > ul > li > a").on("click",function(event){
		var hrefval = $(this).attr("href"); 
		if(hrefval != "#"){
			$('#menu_dvc li').removeClass('wd-active');
			$(".side-content").hide();
			$(this).parents('li').addClass('wd-active');
			$(hrefval).show();
		}
	});
});