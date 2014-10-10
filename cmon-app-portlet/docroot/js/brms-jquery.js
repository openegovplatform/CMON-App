jQuery.getNumber = function(str) {

	var count = 0;
	var tmp = "";
	for (var i = str.length - 1; i >= 0; i--) {

		if(!(str[i] >= 0 && str[i] <=9)) continue;

		count ++;
		if (count == 4) {
			tmp += "," + str[i];
			count = 0;
		} else {
			tmp += str[i];
		}
	}

	var ret = "";
	for (var i = tmp.length - 1; i >= 0; i--) {
		ret += tmp[i];
	}

	return ret;

};


$.fn.vndFormat = function() {
	$(this).each(function() {
		var $this = $(this);

		$this.keyup(function() {
			var str = jQuery.trim($this.val());
			var strTemp = jQuery.getNumber(str);

			if (strTemp.length < 3) {
				$this.val(strTemp);
			} else {
				var strResult = "";
				for(var i =0; i< strTemp.length; i++)
					strTemp = strTemp.replace(",", "");
				for(var i = strTemp.length; i>=0; i--) {
					if(strResult.length >0 && (strTemp.length - i -1) % 3 == 0)
						strResult = "," + strResult;
					strResult = strTemp.substring(i, i + 1) + strResult;
				}
				$this.val(strResult);
			}
		});
	});
};