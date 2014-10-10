/**
 * DNICT
 */

var SelectAll = function(selobj,childobj){
	var arr = document.getElementsByName(childobj+"[]");
	for(var i=0;i<arr.length;i++){
		arr[i].checked = selobj.checked;
	}
}

function TestSelectOneCheck(objValue,strError)
{
	var objradio = document.getElementsByName(objValue);
	var one_selected=false;
	for(var r=0;r < objradio.length;r++)
	{
	  if(objradio[r].checked)
	  {
	  	one_selected=true;
		break;
	  }
	}
	if(false == one_selected)
	{
			return false;
	}
    return true;
}