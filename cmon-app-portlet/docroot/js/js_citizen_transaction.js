function submitTransForm(defaultSearchStr)
{
	var form = document.searchTransForm;
	if ( form.transactionKeyword.value == defaultSearchStr){
		form.transactionKeyword.value = "";
	}
	form.submit();
}

function submitIpmsListForm(defaultSearchStr)
{
	var form = document.searchIpmsListForm;
	if ( form.transactionKeyword.value == defaultSearchStr){
		form.transactionKeyword.value = "";
	}
	form.submit();
}

function setHuyHoSoForm(isHidden) 
{
	document.getElementById('formYeuCauHuy').hidden = isHidden;
	if (!isHidden) {
		document.getElementById('formThongTinPhanHoi').hidden = true;
	}
}

function setThongTinPhanHoiForm(isHidden) 
{
	document.getElementById('formThongTinPhanHoi').hidden = isHidden;
	if (!isHidden) {
		document.getElementById('formYeuCauHuy').hidden = true;
	}
}

function setWorklistForm(isHidden) 
{
	document.getElementById('worklist').hidden = isHidden;
	if (!isHidden) {
		document.getElementById('formYeuCauHuy').hidden = true;
	}
}


function toggle_visibility(id) {
    var e = document.getElementById(id);
    if (e.style.display == 'block') e.style.display = 'none';
    else e.style.display = 'block';
    
    hideAllBut(id);
}

function hideAllBut(id) {
    var lists = document.querySelectorAll("#list1, #list2,#list3");
    for (var i = lists.length; i--; ) {
        if (lists[i].id != id) {
            lists[i].style.display = 'none';
        }
    }
}

function setColor(btn, color){
	//var property=document.getElementById(btn);
    if (btn.style.backgroundColor == "#f47121") {
        btn.style.backgroundColor = color;
    } else {
        btn.style.backgroundColor = "#f47121";
    }
}

function viewTaskInfo(portalUrl,taskid, instanceId, tracingTag) {

	
	var screenWidth = screen.width;
	var screenHeight = screen.Height;
	var windowWidth = 950;
	var windowHeight = 650;
	var window_left = (screenWidth - windowWidth) / 2;
	var window_top = (screenHeight - windowHeight) / 2;	

	var option = "left=" + window_left + ", top=" + window_top + ", width=" + windowWidth + ", height=" + windowHeight + " ,scrollbars=yes,resizable=yes";
	var url = portalUrl+"/uengine-web/processparticipant/worklist/workitemHandler.jsp?taskId="+taskid+"&instanceId="+instanceId+"&tracingTag="+tracingTag+"&from=DNG";
	var openedWih = window.open(url, "processView", option);
	openedWih.onclose = refresh;	

}

function showPopup(portalUrl,taskid, instanceId, tracingTag) {
	var url = "http://danangegov.vn/uengine-web/processparticipant/worklist/workitemHandler.jsp?taskId="+taskid+"&instanceId="+instanceId+"&tracingTag="+tracingTag;
	//alert(url);
	

	AUI().use('aui-dialog', 'aui-io', function(A) {

	    var dialog = new A.Dialog({
	    title: 'Upload Details',
	    centered: true,
	    modal: true,
	    width: 500,
	    height: 400,
	    }).plug(A.Plugin.IO, {uri: url}).render();

	});	} 


function parentPage(portalUrl,taskid, instanceId, tracingTag) {
	var url = "http://danangegov.vn/uengine-web/processparticipant/worklist/workitemHandler.jsp?taskId="+taskid+"&instanceId="+instanceId+"&tracingTag="+tracingTag+"&from=DNG";

	var popup = Liferay.Popup(
	{
	stack: true,
	draggable:false,
	title: 'aa',
	position:[110,50],
	modal:true,
	width:450,
	height:365,
	url:url
	}
	);
	}

function getPhanHoiByAjax(url) 
{
	$.ajax({
	    type : "POST",
	    url : url,
	    cache:false,
	    dataType: "json",
	    success : function(data) 
	    {
	    	document.getElementById('cmonTransTieude').innerHTML = data.tieuDe;
	    	document.getElementById('cmonTransNoiDung').innerHTML = data.noiDung;
	    	document.getElementById('thongTinPhanHoiDetails').hidden = false;
	    },
	    error : function(XMLHttpRequest, textStatus, errorThrown) 
	    {
	    	alert('error :' + textStatus);
	    }
	  });
}

jQuery.getNumberToDate = function(str) {
	var temp = str;
	for(var i =0; i< str.length; i++) {
		temp = temp.replace("/", "");
	}
	
	if (temp.length < 8) {
		return temp;
	} else {
		return temp.substring(0, 8);
	}

};

$.fn.vnDateFormat = function() {
	$(this).each(function() {
		
		var $this = $(this);
		
		$this.keyup(function() {
			var strTemp = $.trim($this.val());
			var str = $.getNumberToDate(strTemp);
			
			if (str.length > 2) {
				str = str.substring(0, 2) + "/" + str.substring(2, str.length);
			}
			
			if (str.length > 5) {
				str = str.substring(0, 5) + "/" + str.substring(5, str.length);
			}
			$this.val(str);
		});
	});
};