	
	
// Ve lai danh sach don vi hanh chinh
function reDrawSelectBox(selectName, changeName, url) {
			
	var id = document.getElementById(selectName).options[document.getElementById(selectName).selectedIndex].value;
	// if quan huyen is not selected then return
	if (id == "") return;
	
	var obj = document.getElementById(changeName);

	$.ajax({
		type: 'POST'
		,url: url
		,data : {id: id}
		,success: function(data) {		

			// preferred
			var data2 = JSON.parse(data);
			// Xoa cac old item in select
			
			while (obj.options.length > 1) {
				obj.remove(1);
			}				
            
			for (var i = 0; i < data2.id.length; i++) {
				obj.add(new Option(data2.name[i], data2.id[i]), null);
			}
		}
	});
}

function openWindow()
{
    var colno, pid;
    var w = 950;
    var h = 350;
    var t = 0;
    var l = 0;
    var scrollbars = 1;
    var modal = 'yes';

    var reportWindow = "";
    reportWindow = window.open("Search.aspx" + '', '', "width=" + w + ",height=" + h + ",left=" + l + ",top=" + t + ',scrollbars=' + scrollbars + 'modal' + modal);
    reportWindow.focus();
    return false;
}
