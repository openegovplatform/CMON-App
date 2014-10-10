
(function () {
	
	// For checkbox and radio
	DataFiller.regist(
		function(container, key, value) {
			var $input = $(container).findInput(key);
			if ($input.hasClass('egov-checkbox')
				|| $input.hasClass('egov-radio')
			) {
				if (value) {
					$input.check();
				} else {
					$input.uncheck();
				}
			}
		}
	);
	
	// For fileupload
	DataFiller.regist(
		function(container, key, value) {
			var $input = $(container).findInput(key);
			if ($input.hasClass('egov-uploadfile')) {
				$input.resetFile(value);
			}
		}
	);
	
})();

// Extra helper methods
$.fn.check = function(checked) {
	if (checked === undefined || checked) {
		return this.each(function() {
			if (this.type.toLowerCase() === 'radio') {
				$('[name="' + this.name + '"]').uncheck();
			}
			this.checked = true;
			$(this).parent().addClass('checked');
		});
	} else {
		return this.uncheck();
	}
};
$.fn.uncheck = function() {
	return this.each(function() {
		this.checked = false;
		$(this).parent().removeClass('checked');
	});
};
$.fn.disable = function() {
	return this.each(function() {
		
		// For file upload
		if (this.className.indexOf('egov-uploadfile') !== -1)  {
			$(this).prop('disabled', true).next().addClass('disabled');
			
		// For radio and checkbox
		} else {
			$(this).prop('disabled', true).closest('div').addClass('disabled');
		}
	});
};
$.fn.enable = function() {
	return this.each(function() {
		
		// For file upload
		if (this.className.indexOf('egov-uploadfile') !== -1)  {
			$(this).prop('disabled', false).next().removeClass('disabled');
			
		// For radio and checkbox
		} else {
			$(this).prop('disabled', false).closest('div').removeClass('disabled');
		}
	});
};
$.fn.resetFile = function(defaultLink) {
	return this.each(function() {
		var $fileInput = $(this),
			$ui = $fileInput.next('.egov-upload-wrapper')
		;
		
		$fileInput.val('');
		$ui.find('.filename').text('Chưa chọn file');
		
		defaultLink = defaultLink || $fileInput.attr('link');
		defaultLink = VarUtil.getString(defaultLink);
		if (defaultLink && defaultLink.length > 4) {
			$fileInput.attr('link', defaultLink);
			$ui.find('.button-content').prop('title', 'Bấm để chọn một tệp tin mới');
			$ui.find('.filename').html('<a class="link" href="' + defaultLink + '">Tải về tệp đã upload</a>');
		} else {
			$ui.find('.button-content').prop('title', 'Bấm để chọn một tệp tin');
			$ui.find('.filename').html('Chưa chọn tệp tin');
		}
	});
};
$.fn.egovFileUpload = function(defaultLink) {
	return this.each(function() {
		var $fileInput = $(this), $ui;
		$ui = $fileInput.next('.egov-upload-wrapper');
		if ($ui.length === 0) {
			$ui = $('<div class="egov-upload-wrapper">\
					<span class="egov-uploadfile">\
						<span class="button-content">Chọn tệp tin</span>\
					</span>\
					<label class="filename egov-label"></label>\
				</div>'
			);
			$fileInput.after($ui);
		}
		
		if (this.hasAttribute('id')) {
			$ui.prop('id', this.id + '_ui');
		}
		
		$fileInput.hide();
		if ($fileInput.is('[disabled]')) {
			$fileInput.disable();
		}
		$.data(this, 'ui', $ui.get(0));
		$fileInput.attr('ui', 'true');
		$fileInput.resetFile(defaultLink);
	});
};
jQuery(document).ready(function() {
	
	// Radio and checkbox
	var $body = $(this.body);
	$body
		.delegate('.egov-radio', 'click', function() {
			$body.find('.egov-radio[name="' + this.name + '"]')
				.parent()
				.removeClass('checked');
			
			$(this).parent().addClass('checked');
		})
		.delegate('.egov-checkbox', 'click', function() {
			if (this.checked) {
				$(this).parent().addClass('checked');
			} else {
				$(this).parent().removeClass('checked');
			}
		})
		.delegate('.egov-radio, .egov-checkbox', 'mouseenter', function() {
			$(this).closest('div').addClass('hover');
		})
		.delegate('.egov-radio, .egov-checkbox', 'mouseleave', function() {
			$(this).closest('div').removeClass('hover');
		})
		.delegate('label[for]', 'mouseenter', function() {
			$('#' + $(this).attr('for')).trigger('mouseenter');
		})
		.delegate('label[for]', 'mouseleave', function() {
			$('#' + $(this).attr('for')).trigger('mouseleave');
		});

	// File upload control
	$('input.egov-uploadfile').egovFileUpload();
	
	$body.delegate('span.egov-uploadfile', 'click', function() {
		var $ui = $(this).parent();
		if (!$ui.hasClass('disabled')) {
			$ui.prev().trigger('click');
		}
	});
	$body.delegate('input.egov-uploadfile', 'change', function() {
		var $fileInput, $fileName, fileName;
		$fileInput = $(this);
		$fileName = $fileInput.next().find('.filename');
		fileName = $fileInput.val().split('\\').slice(-1)[0].trim().replace(/\s+/g, ' ');
		$fileName.html(fileName);
		
		if ($fileName.isOverflow()) {
			fileName = $fileName.text();
			$fileName.prop('title', fileName);
			$fileName.html(fileName.left(10) + ' ... ' + fileName.right(15));
		}
	});
});