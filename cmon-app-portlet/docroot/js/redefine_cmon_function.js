"function"!=typeof Object.create&&(Object.create=function(a){function b(){}return b.prototype=a,new b}),function(a){var b={init:function(b){return this.options=a.extend({},a.noty.defaults,b),this.options.layout=this.options.custom?a.noty.layouts.inline:a.noty.layouts[this.options.layout],a.noty.themes[this.options.theme]?this.options.theme=a.noty.themes[this.options.theme]:b.themeClassName=this.options.theme,delete b.layout,delete b.theme,this.options=a.extend({},this.options,this.options.layout.options),this.options.id="noty_"+(new Date).getTime()*Math.floor(1e6*Math.random()),this.options=a.extend({},this.options,b),this._build(),this},_build:function(){var b=a('<div class="noty_bar noty_type_'+this.options.type+'"></div>').attr("id",this.options.id);if(b.append(this.options.template).find(".noty_text").html(this.options.text),this.$bar=null!==this.options.layout.parent.object?a(this.options.layout.parent.object).css(this.options.layout.parent.css).append(b):b,this.options.themeClassName&&this.$bar.addClass(this.options.themeClassName).addClass("noty_container_type_"+this.options.type),this.options.buttons){this.options.closeWith=[],this.options.timeout=!1;var c=a("<div/>").addClass("noty_buttons");null!==this.options.layout.parent.object?this.$bar.find(".noty_bar").append(c):this.$bar.append(c);var d=this;a.each(this.options.buttons,function(b,c){var e=a("<button/>").addClass(c.addClass?c.addClass:"gray").html(c.text).attr("id",c.id?c.id:"button-"+b).appendTo(d.$bar.find(".noty_buttons")).bind("click",function(){a.isFunction(c.onClick)&&c.onClick.call(e,d)})})}this.$message=this.$bar.find(".noty_message"),this.$closeButton=this.$bar.find(".noty_close"),this.$buttons=this.$bar.find(".noty_buttons"),a.noty.store[this.options.id]=this},show:function(){var b=this;return b.options.custom?b.options.custom.find(b.options.layout.container.selector).append(b.$bar):a(b.options.layout.container.selector).append(b.$bar),b.options.theme&&b.options.theme.style&&b.options.theme.style.apply(b),"function"===a.type(b.options.layout.css)?this.options.layout.css.apply(b.$bar):b.$bar.css(this.options.layout.css||{}),b.$bar.addClass(b.options.layout.addClass),b.options.layout.container.style.apply(a(b.options.layout.container.selector)),b.showing=!0,b.options.theme&&b.options.theme.style&&b.options.theme.callback.onShow.apply(this),a.inArray("click",b.options.closeWith)>-1&&b.$bar.css("cursor","pointer").one("click",function(a){b.stopPropagation(a),b.options.callback.onCloseClick&&b.options.callback.onCloseClick.apply(b),b.close()}),a.inArray("hover",b.options.closeWith)>-1&&b.$bar.one("mouseenter",function(){b.close()}),a.inArray("button",b.options.closeWith)>-1&&b.$closeButton.one("click",function(a){b.stopPropagation(a),b.close()}),-1==a.inArray("button",b.options.closeWith)&&b.$closeButton.remove(),b.options.callback.onShow&&b.options.callback.onShow.apply(b),b.$bar.animate(b.options.animation.open,b.options.animation.speed,b.options.animation.easing,function(){b.options.callback.afterShow&&b.options.callback.afterShow.apply(b),b.showing=!1,b.shown=!0}),b.options.timeout&&b.$bar.delay(b.options.timeout).promise().done(function(){b.close()}),this},close:function(){if(!(this.closed||this.$bar&&this.$bar.hasClass("i-am-closing-now"))){var b=this;if(this.showing)return b.$bar.queue(function(){b.close.apply(b)}),void 0;if(!this.shown&&!this.showing){var c=[];return a.each(a.noty.queue,function(a,d){d.options.id!=b.options.id&&c.push(d)}),a.noty.queue=c,void 0}b.$bar.addClass("i-am-closing-now"),b.options.callback.onClose&&b.options.callback.onClose.apply(b),b.$bar.clearQueue().stop().animate(b.options.animation.close,b.options.animation.speed,b.options.animation.easing,function(){b.options.callback.afterClose&&b.options.callback.afterClose.apply(b)}).promise().done(function(){b.options.modal&&(a.notyRenderer.setModalCount(-1),0==a.notyRenderer.getModalCount()&&a(".noty_modal").fadeOut("fast",function(){a(this).remove()})),a.notyRenderer.setLayoutCountFor(b,-1),0==a.notyRenderer.getLayoutCountFor(b)&&a(b.options.layout.container.selector).remove(),"undefined"!=typeof b.$bar&&null!==b.$bar&&(b.$bar.remove(),b.$bar=null,b.closed=!0),delete a.noty.store[b.options.id],b.options.theme.callback&&b.options.theme.callback.onClose&&b.options.theme.callback.onClose.apply(b),b.options.dismissQueue||(a.noty.ontap=!0,a.notyRenderer.render()),b.options.maxVisible>0&&b.options.dismissQueue&&a.notyRenderer.render()})}},setText:function(a){return this.closed||(this.options.text=a,this.$bar.find(".noty_text").html(a)),this},setType:function(a){return this.closed||(this.options.type=a,this.options.theme.style.apply(this),this.options.theme.callback.onShow.apply(this)),this},setTimeout:function(a){if(!this.closed){var b=this;this.options.timeout=a,b.$bar.delay(b.options.timeout).promise().done(function(){b.close()})}return this},stopPropagation:function(a){a=a||window.event,"undefined"!=typeof a.stopPropagation?a.stopPropagation():a.cancelBubble=!0},closed:!1,showing:!1,shown:!1};a.notyRenderer={},a.notyRenderer.init=function(c){var d=Object.create(b).init(c);return d.options.killer&&a.noty.closeAll(),d.options.force?a.noty.queue.unshift(d):a.noty.queue.push(d),a.notyRenderer.render(),"object"==a.noty.returns?d:d.options.id},a.notyRenderer.render=function(){var b=a.noty.queue[0];"object"===a.type(b)?b.options.dismissQueue?b.options.maxVisible>0?a(b.options.layout.container.selector+" li").length<b.options.maxVisible&&a.notyRenderer.show(a.noty.queue.shift()):a.notyRenderer.show(a.noty.queue.shift()):a.noty.ontap&&(a.notyRenderer.show(a.noty.queue.shift()),a.noty.ontap=!1):a.noty.ontap=!0},a.notyRenderer.show=function(b){b.options.modal&&(a.notyRenderer.createModalFor(b),a.notyRenderer.setModalCount(1)),b.options.custom?0==b.options.custom.find(b.options.layout.container.selector).length?b.options.custom.append(a(b.options.layout.container.object).addClass("i-am-new")):b.options.custom.find(b.options.layout.container.selector).removeClass("i-am-new"):0==a(b.options.layout.container.selector).length?a("body").append(a(b.options.layout.container.object).addClass("i-am-new")):a(b.options.layout.container.selector).removeClass("i-am-new"),a.notyRenderer.setLayoutCountFor(b,1),b.show()},a.notyRenderer.createModalFor=function(b){if(0==a(".noty_modal").length){var c=a("<div/>").addClass("noty_modal").addClass(b.options.theme).data("noty_modal_count",0);b.options.theme.modal&&b.options.theme.modal.css&&c.css(b.options.theme.modal.css),c.prependTo(a("body")).fadeIn("fast")}},a.notyRenderer.getLayoutCountFor=function(b){return a(b.options.layout.container.selector).data("noty_layout_count")||0},a.notyRenderer.setLayoutCountFor=function(b,c){return a(b.options.layout.container.selector).data("noty_layout_count",a.notyRenderer.getLayoutCountFor(b)+c)},a.notyRenderer.getModalCount=function(){return a(".noty_modal").data("noty_modal_count")||0},a.notyRenderer.setModalCount=function(b){return a(".noty_modal").data("noty_modal_count",a.notyRenderer.getModalCount()+b)},a.fn.noty=function(b){return b.custom=a(this),a.notyRenderer.init(b)},a.noty={},a.noty.queue=[],a.noty.ontap=!0,a.noty.layouts={},a.noty.themes={},a.noty.returns="object",a.noty.store={},a.noty.get=function(b){return a.noty.store.hasOwnProperty(b)?a.noty.store[b]:!1},a.noty.close=function(b){return a.noty.get(b)?a.noty.get(b).close():!1},a.noty.setText=function(b,c){return a.noty.get(b)?a.noty.get(b).setText(c):!1},a.noty.setType=function(b,c){return a.noty.get(b)?a.noty.get(b).setType(c):!1},a.noty.clearQueue=function(){a.noty.queue=[]},a.noty.closeAll=function(){a.noty.clearQueue(),a.each(a.noty.store,function(a,b){b.close()})};var c=window.alert;a.noty.consumeAlert=function(b){window.alert=function(c){b?b.text=c:b={text:c},a.notyRenderer.init(b)}},a.noty.stopConsumeAlert=function(){window.alert=c},a.noty.defaults={layout:"top",theme:"defaultTheme",type:"alert",text:"",dismissQueue:!0,template:'<div class="noty_message"><span class="noty_text"></span><div class="noty_close"></div></div>',animation:{open:{height:"toggle"},close:{height:"toggle"},easing:"swing",speed:500},timeout:!1,force:!1,modal:!1,maxVisible:5,killer:!1,closeWith:["click"],callback:{onShow:function(){},afterShow:function(){},onClose:function(){},afterClose:function(){},onCloseClick:function(){}},buttons:!1},a(window).resize(function(){a.each(a.noty.layouts,function(b,c){c.container.style.apply(a(c.container.selector))})})}(jQuery),window.noty=function(a){return jQuery.notyRenderer.init(a)},function(a){a.noty.layouts.bottom={name:"bottom",options:{},container:{object:'<ul id="noty_bottom_layout_container" />',selector:"ul#noty_bottom_layout_container",style:function(){a(this).css({bottom:0,left:"5%",position:"fixed",width:"90%",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:9999999})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none"},addClass:""}}(jQuery),function(a){a.noty.layouts.bottomCenter={name:"bottomCenter",options:{},container:{object:'<ul id="noty_bottomCenter_layout_container" />',selector:"ul#noty_bottomCenter_layout_container",style:function(){a(this).css({bottom:20,left:0,position:"fixed",width:"310px",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:1e7}),a(this).css({left:(a(window).width()-a(this).outerWidth(!1))/2+"px"})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none",width:"310px"},addClass:""}}(jQuery),function(a){a.noty.layouts.bottomLeft={name:"bottomLeft",options:{},container:{object:'<ul id="noty_bottomLeft_layout_container" />',selector:"ul#noty_bottomLeft_layout_container",style:function(){a(this).css({bottom:20,left:20,position:"fixed",width:"310px",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:1e7}),window.innerWidth<600&&a(this).css({left:5})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none",width:"310px"},addClass:""}}(jQuery),function(a){a.noty.layouts.bottomRight={name:"bottomRight",options:{},container:{object:'<ul id="noty_bottomRight_layout_container" />',selector:"ul#noty_bottomRight_layout_container",style:function(){a(this).css({bottom:20,right:20,position:"fixed",width:"310px",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:1e7}),window.innerWidth<600&&a(this).css({right:5})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none",width:"310px"},addClass:""}}(jQuery),function(a){a.noty.layouts.center={name:"center",options:{},container:{object:'<ul id="noty_center_layout_container" />',selector:"ul#noty_center_layout_container",style:function(){a(this).css({position:"fixed",width:"310px",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:1e7});var b=a(this).clone().css({visibility:"hidden",display:"block",position:"absolute",top:0,left:0}).attr("id","dupe");a("body").append(b),b.find(".i-am-closing-now").remove(),b.find("li").css("display","block");var c=b.height();b.remove(),a(this).hasClass("i-am-new")?a(this).css({left:(a(window).width()-a(this).outerWidth(!1))/2+"px",top:(a(window).height()-c)/2+"px"}):a(this).animate({left:(a(window).width()-a(this).outerWidth(!1))/2+"px",top:(a(window).height()-c)/2+"px"},500)}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none",width:"310px"},addClass:""}}(jQuery),function(a){a.noty.layouts.centerLeft={name:"centerLeft",options:{},container:{object:'<ul id="noty_centerLeft_layout_container" />',selector:"ul#noty_centerLeft_layout_container",style:function(){a(this).css({left:20,position:"fixed",width:"310px",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:1e7});var b=a(this).clone().css({visibility:"hidden",display:"block",position:"absolute",top:0,left:0}).attr("id","dupe");a("body").append(b),b.find(".i-am-closing-now").remove(),b.find("li").css("display","block");var c=b.height();b.remove(),a(this).hasClass("i-am-new")?a(this).css({top:(a(window).height()-c)/2+"px"}):a(this).animate({top:(a(window).height()-c)/2+"px"},500),window.innerWidth<600&&a(this).css({left:5})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none",width:"310px"},addClass:""}}(jQuery),function(a){a.noty.layouts.centerRight={name:"centerRight",options:{},container:{object:'<ul id="noty_centerRight_layout_container" />',selector:"ul#noty_centerRight_layout_container",style:function(){a(this).css({right:20,position:"fixed",width:"310px",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:1e7});var b=a(this).clone().css({visibility:"hidden",display:"block",position:"absolute",top:0,left:0}).attr("id","dupe");a("body").append(b),b.find(".i-am-closing-now").remove(),b.find("li").css("display","block");var c=b.height();b.remove(),a(this).hasClass("i-am-new")?a(this).css({top:(a(window).height()-c)/2+"px"}):a(this).animate({top:(a(window).height()-c)/2+"px"},500),window.innerWidth<600&&a(this).css({right:5})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none",width:"310px"},addClass:""}}(jQuery),function(a){a.noty.layouts.inline={name:"inline",options:{},container:{object:'<ul class="noty_inline_layout_container" />',selector:"ul.noty_inline_layout_container",style:function(){a(this).css({width:"100%",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:9999999})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none"},addClass:""}}(jQuery),function(a){a.noty.layouts.top={name:"top",options:{},container:{object:'<ul id="noty_top_layout_container" />',selector:"ul#noty_top_layout_container",style:function(){a(this).css({top:0,left:"5%",position:"fixed",width:"90%",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:9999999})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none"},addClass:""}}(jQuery),function(a){a.noty.layouts.topCenter={name:"topCenter",options:{},container:{object:'<ul id="noty_topCenter_layout_container" />',selector:"ul#noty_topCenter_layout_container",style:function(){a(this).css({top:20,left:0,position:"fixed",width:"310px",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:1e7}),a(this).css({left:(a(window).width()-a(this).outerWidth(!1))/2+"px"})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none",width:"310px"},addClass:""}}(jQuery),function(a){a.noty.layouts.topLeft={name:"topLeft",options:{},container:{object:'<ul id="noty_topLeft_layout_container" />',selector:"ul#noty_topLeft_layout_container",style:function(){a(this).css({top:20,left:20,position:"fixed",width:"310px",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:1e7}),window.innerWidth<600&&a(this).css({left:5})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none",width:"310px"},addClass:""}}(jQuery),function(a){a.noty.layouts.topRight={name:"topRight",options:{},container:{object:'<ul id="noty_topRight_layout_container" />',selector:"ul#noty_topRight_layout_container",style:function(){a(this).css({top:20,right:20,position:"fixed",width:"310px",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:1e7}),window.innerWidth<600&&a(this).css({right:5})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none",width:"310px"},addClass:""}}(jQuery),function(a){a.noty.themes.defaultTheme={name:"defaultTheme",helpers:{borderFix:function(){if(this.options.dismissQueue){var b=this.options.layout.container.selector+" "+this.options.layout.parent.selector;switch(this.options.layout.name){case"top":a(b).css({borderRadius:"0px 0px 0px 0px"}),a(b).last().css({borderRadius:"0px 0px 5px 5px"});break;case"topCenter":case"topLeft":case"topRight":case"bottomCenter":case"bottomLeft":case"bottomRight":case"center":case"centerLeft":case"centerRight":case"inline":a(b).css({borderRadius:"0px 0px 0px 0px"}),a(b).first().css({"border-top-left-radius":"5px","border-top-right-radius":"5px"}),a(b).last().css({"border-bottom-left-radius":"5px","border-bottom-right-radius":"5px"});break;case"bottom":a(b).css({borderRadius:"0px 0px 0px 0px"}),a(b).first().css({borderRadius:"5px 5px 0px 0px"})}}}},modal:{css:{position:"fixed",width:"100%",height:"100%",backgroundColor:"#000",zIndex:1e4,opacity:.6,display:"none",left:0,top:0}},style:function(){switch(this.$bar.css({overflow:"hidden",background:"url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABsAAAAoCAYAAAAPOoFWAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAPZJREFUeNq81tsOgjAMANB2ov7/7ypaN7IlIwi9rGuT8QSc9EIDAsAznxvY4pXPKr05RUE5MEVB+TyWfCEl9LZApYopCmo9C4FKSMtYoI8Bwv79aQJU4l6hXXCZrQbokJEksxHo9KMOgc6w1atHXM8K9DVC7FQnJ0i8iK3QooGgbnyKgMDygBWyYFZoqx4qS27KqLZJjA1D0jK6QJcYEQEiWv9PGkTsbqxQ8oT+ZtZB6AkdsJnQDnMoHXHLGKOgDYuCWmYhEERCI5gaamW0bnHdA3k2ltlIN+2qKRyCND0bhqSYCyTB3CAOc4WusBEIpkeBuPgJMAAX8Hs1NfqHRgAAAABJRU5ErkJggg==') repeat-x scroll left top #fff"}),this.$message.css({fontSize:"13px",lineHeight:"16px",textAlign:"center",padding:"8px 10px 9px",width:"auto",position:"relative"}),this.$closeButton.css({position:"absolute",top:4,right:4,width:10,height:10,background:"url(data:image/png;base64,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)",display:"none",cursor:"pointer"}),this.$buttons.css({padding:5,textAlign:"right",borderTop:"1px solid #ccc",backgroundColor:"#fff"}),this.$buttons.find("button").css({marginLeft:5}),this.$buttons.find("button:first").css({marginLeft:0}),this.$bar.bind({mouseenter:function(){a(this).find(".noty_close").stop().fadeTo("normal",1)},mouseleave:function(){a(this).find(".noty_close").stop().fadeTo("normal",0)}}),this.options.layout.name){case"top":this.$bar.css({borderRadius:"0px 0px 5px 5px",borderBottom:"2px solid #eee",borderLeft:"2px solid #eee",borderRight:"2px solid #eee",boxShadow:"0 2px 4px rgba(0, 0, 0, 0.1)"});break;case"topCenter":case"center":case"bottomCenter":case"inline":this.$bar.css({borderRadius:"5px",border:"1px solid #eee",boxShadow:"0 2px 4px rgba(0, 0, 0, 0.1)"}),this.$message.css({fontSize:"13px",textAlign:"center"});break;case"topLeft":case"topRight":case"bottomLeft":case"bottomRight":case"centerLeft":case"centerRight":this.$bar.css({borderRadius:"5px",border:"1px solid #eee",boxShadow:"0 2px 4px rgba(0, 0, 0, 0.1)"}),this.$message.css({fontSize:"13px",textAlign:"left"});break;case"bottom":this.$bar.css({borderRadius:"5px 5px 0px 0px",borderTop:"2px solid #eee",borderLeft:"2px solid #eee",borderRight:"2px solid #eee",boxShadow:"0 -2px 4px rgba(0, 0, 0, 0.1)"});break;default:this.$bar.css({border:"2px solid #eee",boxShadow:"0 2px 4px rgba(0, 0, 0, 0.1)"})}switch(this.options.type){case"alert":case"notification":this.$bar.css({backgroundColor:"#FFF",borderColor:"#CCC",color:"#444"});break;case"warning":this.$bar.css({backgroundColor:"#FFEAA8",borderColor:"#FFC237",color:"#826200"}),this.$buttons.css({borderTop:"1px solid #FFC237"});break;case"error":this.$bar.css({backgroundColor:"red",borderColor:"darkred",color:"#FFF"}),this.$message.css({fontWeight:"bold"}),this.$buttons.css({borderTop:"1px solid darkred"});break;case"information":this.$bar.css({backgroundColor:"#57B7E2",borderColor:"#0B90C4",color:"#FFF"}),this.$buttons.css({borderTop:"1px solid #0B90C4"});break;case"success":this.$bar.css({backgroundColor:"lightgreen",borderColor:"#50C24E",color:"darkgreen"}),this.$buttons.css({borderTop:"1px solid #50C24E"});break;default:this.$bar.css({backgroundColor:"#FFF",borderColor:"#CCC",color:"#444"})}},callback:{onShow:function(){a.noty.themes.defaultTheme.helpers.borderFix.apply(this)},onClose:function(){a.noty.themes.defaultTheme.helpers.borderFix.apply(this)}}}}(jQuery);

var SCREEN_LOADING = $('<div id="_screen_loading" class="loading" style="display: none;">&nbsp;</div>').appendTo(document.body);

var AjaxResponse = (function() {
	function AjaxResponse() {
		this.isStatusException = function isStatusException() {
			return this[AjaxResponse.keys.STATUS] === AjaxResponse.STATUS_EXCEPTION;
		};
		this.isStatusOK = function isStatusOK() {
			return this[AjaxResponse.keys.STATUS] === AjaxResponse.STATUS_OK;
		};
		this.isValidateFail = function isValidateFail() {
			var b = this[AjaxResponse.keys.VALIDATE_FLAG];
			return b !== undefined && !b;
		};
		this.getValidateMessages = function getValidateMessages() {
			return this[AjaxResponse.keys.VALIDATE_MESSAGES];
		};
		this.hasMessage = function hasMessage() {
			return this.getMessage() !== '';
		};
		this.getMessage = function getMessage() {
			return this[AjaxResponse.keys.MESSAGE] || '';
		};
		this.getMessageType = function getMessageType() {
			return this[AjaxResponse.keys.MESSAGE_TYPE];
		};
		this.getRedirectURL = function getRedirectURL() {
			
			if (this[AjaxResponse.keys.REDIRECT_URL] === AjaxResponse.RELOAD_MARK) {
				return location.href;
			} else {
				return $("<div/>").html(this[AjaxResponse.keys.REDIRECT_URL]).text();
			}
			
		};
		this.getGoToURL = function getGoToURL() {
			
			if (this[AjaxResponse.keys.GOTO_URL] === AjaxResponse.RELOAD_MARK) {
				return location.href;
			} else {
				return $("<div/>").html(this[AjaxResponse.keys.GOTO_URL]).text();
			}
			
		};
		this.getSearchResult = function getSearchResult() {
			return this[AjaxResponse.keys.SEARCH_RESULT] || [];
		};
		this.getFetchedCount = function getFetchedCount() {
			return this[AjaxResponse.keys.FETCHED_COUNT];
		};
		this.getResultCount = function getResultCount() {
			return this[AjaxResponse.keys.RESULT_COUNT];
		}
	}
	
	// STATIC MEMBERS
	AjaxResponse.keys = {
		VALIDATE_FLAG		: 'validateFlag',
		VALIDATE_MESSAGES 	: 'validateMessages',
		MESSAGE 			: 'message',
		MESSAGE_TYPE 		: 'messageType',
		STATUS				: 'status',
		REDIRECT_URL		: 'redirectURL',
		GOTO_URL			: 'goToURL',
		SEARCH_RESULT 		: 'searchResult',
		FETCHED_COUNT		: 'fetchedCount',
		RESULT_COUNT 		: 'resultCount'
	};
	AjaxResponse.STATUS_OK = 1;
	AjaxResponse.STATUS_EXCEPTION = 2;
	AjaxResponse.MESSAGE_TYPE_MESSAGE = 1;
	AjaxResponse.MESSAGE_TYPE_SUCCESS = 2;
	AjaxResponse.MESSAGE_TYPE_WARNING = 3;
	AjaxResponse.MESSAGE_TYPE_ERROR = 4;
	AjaxResponse.RELOAD_MARK = 666 ;
	
	return AjaxResponse;
	
})();

/**
 * @param cfg
 * 	{
 * 		required: searchURL, form, grid
 * 		option:
 * 			loading
 * 
 * 			// PAGINATOR OPTIONS
 * 				arrPageSize, isHidden
 * 	 		
 *			// SIMPLEGRID OPTIONS 
 * 				isAllowAddRow,
 * 				addBtn,
 * 				deleteFn,
 * 				pkField,
 * 				afterAddRow,
 * 				afterFill,
 * 				data,
 * 				deleteConfirmMessage
 * 	}
 * 
 * TO CLEAR SEARCH, attach the class 'clear-search' to your button
 */
var AjaxSearchGrid = (function() {

	// CONSTRUCTOR
	function AjaxSearchGrid(cfg) {
		var self = this;
		self.ajax;
		self.grid;
		self.$form;
		self.paginator;
		self.lastQueryString = '';
		_construct(self, cfg);
	}
	
	// METHODS
	AjaxSearchGrid.prototype.setVar = function (key, value) {
		return this.ajax.setVar(key, value);
	};
	AjaxSearchGrid.prototype.setParam = function (paramName, value) {
		this.$form.findInput(paramName).val(value);
		this.ajax.setRequestParam(paramName, value);
		return this;
	};
	AjaxSearchGrid.prototype.load = function (isTriggeredByUser) {
		var curQueryString = _getCurQueryString(this);
		if (isTriggeredByUser || (this.lastQueryString !== curQueryString)) {
			
			this.lastQueryString = curQueryString;
			var p = this.paginator.getSearchParam();
			this.setParam(AjaxSearchGrid.START_PNAME, p.start)
				.setParam(AjaxSearchGrid.END_PNAME, p.end);
			this.ajax.run();
		}
		
		return this;
	};
	
	/**
	 * Search khi user
	 * 		submit form
	 * 		click header sort
	 *	reset page v? 1
	 */
	AjaxSearchGrid.prototype.reload = function reload(isTriggeredByUser) {
		this.paginator.curPage = 1;
		this.load(isTriggeredByUser);
		return this;
	};
	
	AjaxSearchGrid.prototype.getRowData = function(rix) {
		return this.grid.getRowData(rix);
	};
	
	
	// STATIC MEMBERS
	AjaxSearchGrid.START_PNAME = 'start';
	AjaxSearchGrid.END_PNAME = 'end';
	
	
	// PRIVATE FUNCTIONS
	function _construct(self, cfg) {
		
		var _$form = $(cfg.form);
		self.grid = new SimpleGrid(cfg);
		self.$form = _$form;
		
		var onPageChange = $.proxy(
			function() {
				this.load(true);
			},
			self
		);
		
		var onPageSizeChange = $.proxy(
			function() {
				this.reload(true);
			},
			self
		);
		
		self.paginator = new Paginator(
			self.grid.$elem,
			1,
			cfg.arrPageSize,
			onPageChange,
			onPageSizeChange,
			cfg.isHidden
		);
		
		self.ajax = new Ajax()
			.setURL(cfg.searchURL)
			.setForm(_$form)
			.onSuccess(
				function(response) {
					_doAfterAjaxSuccess(self, response);
				}
			)
			.onError(
				function() {
					_doAfterAjaxError(self)
				}
			);
		
		if (cfg.loading !== undefined) {
			self.ajax.setLoading(cfg.loading);
		} else {
			self.ajax.setLoading(self.grid.$elem);
		}
		
		if (cfg.isHidden) {
			return;
		}
		
		_$form.bind('submit',
			function (ev) {
				_doWhenSubmitSearchForm(self, _$form);
				ev.preventDefault();
			}
		);
		
		_$form.find('.clear-search').bind('click',
			function(ev) {
				_clearSearchForm(self, _$form);
				ev.preventDefault();
			}
		);
	}
	
	function _doAfterAjaxSuccess(self, response) {
		
		// Refresh the paginator face
		self.paginator.refresh(response.getResultCount(), response.getFetchedCount());
		
		// Fill grid
		self.grid.fill(response.getSearchResult(), self.paginator.firstIndex);
	
	}
	
	function _doAfterAjaxError(self, response) {
		self.paginator.refresh(0, 0);
	}
	
	function _doWhenSubmitSearchForm(self, $form) {
		self.reload(true);
	}
	
	function _clearSearchForm(self, $form) {
		$form.get(0).reset();
		self.reload(true);
	}
	
	function _getCurQueryString(obj) {
		var pagiparam = obj.paginator.getSearchParam();
		return obj.$form.serialize() + '_' + pagiparam.start + '_' + pagiparam.end;
	}
	
	return AjaxSearchGrid;
	
})();

/**
 * Dùng khi submit form nh?p li?u = ajax
 * @param cfg
 * 	{
 * 		required: form, url
 * 		option: onSuccess
 * 	}
 */
function ajaxFormInput(cfg) {
	
	var $form = $(cfg.form);
	
	var _ajax = new Ajax()
		.setURL(cfg.url)
		.setForm($form)
		.setLoading(SCREEN_LOADING)
		.onBefore(function() {
			$form.clearValidateMessages();
		}) 
		.onSuccess(function(response) {
			if (response.isValidateFail()) {
				
				var vldMessages = response.getValidateMessages();
				if (Object.size(vldMessages) === 1) {
					var msg = Object.getTheOnlyOne(vldMessages);
					$warning(
						msg[1],
						function() {
							$form.findInput(msg[0]).focus();
						}
					);
				} else {
					$warning('Vui lòng ki?m tra l?i các tru?ng nh?p li?u');
					$form.showValidateMessages(vldMessages);
				}

			} else if ($.isFunction(cfg.onSuccess)) {
				cfg.onSuccess.apply(this, [response]);
			} else if (response.hasMessage()) {
				this.showResponseMessage(response);
			}
	});
	
	$form.bind('submit',
		function(ev) {
		
			// AUTO SWITCH TO UPLOAD FORM
			if ($form.find('input[type="file"]').length
				&& $form.prop('enctype') !== 'multipart/form-data'
			) {
				$form.prop('enctype', 'multipart/form-data');
				_ajax.setForm($form);
			}
		
			_ajax.run();
			ev.preventDefault();
		}
	);
};

var Ajax = (function() {
	
	// CONSTRUCTOR
	function Ajax() {
		
		/**
		 * jQuery ajax properties
		 */
		this.url		= '';
		this.method		= 'post';
		this.dataType	= 'json';
		this.data		= {};
		
		/**
		 * Extra properties 
		 */
		this.$form			 	= undefined;
		this._loadingTargets	= [];
		this._$disabledItems	= undefined;
		this._isUserMustWait			= true;
		this._isUploadForm		= false;
		this._$uploadResponseTarget = undefined;
		this._requestParams 		= {};
		this._onBefore			= function() {};
		this._onSuccess			= function() {};
		this._onError			= function() {};
		this._onServerError		= function() {};
	}
	
	// METHODS
	Ajax.prototype.setForm = function (selector) {
		this.$form = $(selector);
		this._isUploadForm = this.$form.prop('enctype') === 'multipart/form-data';
		if (this._isUploadForm) {
			var iframeID = "i" + Math.random();
			this._$uploadResponseTarget = 
				$('<iframe id="' + iframeID + '" name="' + iframeID + '" style="display: none;"></iframe>')
				.insertAfter(this.$form.get(0));
			this.$form.attr('target', iframeID);
			var self = this;
			this._$uploadResponseTarget.bind('load', function() {
				var data = $(this).contents().find("body").html();
				if (data.trim().length > 0) {
					try {
						self.success($.parseJSON(data));
					} catch (err) {
						self.error({}, '', err);
					}
				}; 
			});
		}
		return this;
	};
	Ajax.prototype.setLoading = function setLoading(selector, small) {
		if ($.isArray(selector)) {
			this._loadingTargets = selector;
		} else {
			this._loadingTargets = [{target:selector, isSmall:small}];
		}
		return this;
	};
	Ajax.prototype.setIsUserMustWait = function setIsUserMustWait(bool) {
		this._isUserMustWait = !!bool;
		return this;
	};
	Ajax.prototype.setURL = function setURL(url) {
		this.url = url;
		return this;
	};
	Ajax.prototype.setRequestParam = function setRequestParam(key, value) {
		this._requestParams[key] = value;
		return this;
	};
	Ajax.prototype.onBefore = function onBefore(callback) {
		this._onBefore = callback;
		return this;
	};
	Ajax.prototype.onSuccess = function onSuccess(callback) {
		this._onSuccess = callback;
		return this;
	};
	Ajax.prototype.onError = function onError(callback) {
		this._onError = callback;
		return this;
	};
	Ajax.prototype.onServerError = function onServerError(callback) {
		this._onServerError = callback;
		return this;
	};
	Ajax.prototype.onComplete = function onComplete(callback) {
		this.complete = callback;
		return this;
	};
	Ajax.prototype.run = function run() {
		
		if (this._isUploadForm) {
			
			var flag = this._onBefore(this);
			if (flag === false) {
				return false;
			}
			
			var hiddenInputs = [];
			for (var key in this._requestParams) {
				var $hiddenInput = $('<input/>');
				$hiddenInput.prop('type', 'hidden');
				$hiddenInput.prop('name', key);
				$hiddenInput.val(this._requestParams[key]);
				this.$form.append($hiddenInput);
				hiddenInputs.push($hiddenInput.get(0));
			}
			
			var $dis = this.$form.find(':input:disabled');
			$dis.prop('disabled', false);
			this.$form.get(0).submit();
			
			// fix for chrome
			var self = this;
			setTimeout(
				function() {
					self._wait();
				},
				1
			);
			
			$(hiddenInputs).remove();
			$dis.prop('disabled', true);
		} else {
			if (this.$form !== undefined) {
				
				var hiddenInputs = [];
				for (var key in this._requestParams) {
					var $hiddenInput = $('<input/>');
					$hiddenInput.prop('type', 'hidden');
					$hiddenInput.prop('name', key);
					$hiddenInput.val(this._requestParams[key]);
					this.$form.append($hiddenInput);
					hiddenInputs.push($hiddenInput.get(0));
				}
				this.data = this.$form.serialize();
				$(hiddenInputs).remove();
				if (!this.url.length) {
					this.url = this.$form.prop('action');
				} 
				
			} else {
				for (var key in this._requestParams) {
					this.data[key] = this._requestParams[key];
				}
			}
			this._requestParams = {};
			this._wait();
			$.ajax(this);
		}
	};
	Ajax.prototype._wait = function _wait() {
		if (this._isUserMustWait) {
			for (var i = 0; i < this._loadingTargets.length; ++ i) {
				$(this._loadingTargets[i]['target']).showLoading(this._loadingTargets[i]['isSmall']);
			}
			if (this.$form !== undefined) {
				this._$disabledItems =
					this.$form.find(':input, button, .button').not(':disabled').prop('disabled', true);
				
				this._$disabledItems.each(function() {
					if (this.hasAttribute('ui')) {
						$($.data(this, 'ui')).addClass('disabled');
					}
				});
			}
		}
		
		return this;
	};
	Ajax.prototype._endWait = function _endWait() {
		if (this._isUserMustWait) {
			for (var i = 0; i < this._loadingTargets.length; ++ i) {
				$(this._loadingTargets[i]['target']).hideLoading();
			}
			if (this._$disabledItems !== undefined) {
				this._$disabledItems.prop('disabled', false);
				this._$disabledItems.each(function() {
					if (this.hasAttribute('ui')) {
						$($.data(this, 'ui')).removeClass('disabled');
					}
				});
			}
		}
	
		return this;
	};
	
	Ajax.prototype.serverError = function(response) {
		this._endWait();
		this._onServerError(response);
		$error(response.getMessage());
	};
	
	Ajax.prototype.showResponseMessage = function showResponseMessage(response, callback) {
		switch (response.getMessageType()) {
			case AjaxResponse.MESSAGE_TYPE_MESSAGE:
				$alert(response.getMessage(), callback);
				break;
			case AjaxResponse.MESSAGE_TYPE_SUCCESS:
				$success(response.getMessage(), callback);
				break;
			case AjaxResponse.MESSAGE_TYPE_WARNING:
				$warning(response.getMessage(), callback);
				break;
			case AjaxResponse.MESSAGE_TYPE_ERROR:
				$error(response.getMessage(), callback);
				break;
		}
	},
	
	Ajax.prototype.beforeSend = function($xhr) {
		
		var flag = this._onBefore($xhr, this);
		if (flag === false) {
			return false;
		}
	},
	
	Ajax.prototype.success = function(response, textStatus, jqXHR) {
		
		this._endWait();
		$.extend(response, new AjaxResponse());
		
		if (response.isStatusOK()) {
			
			var url = response.getRedirectURL().trim();
			
			if (url !== '') {
				if (response.hasMessage()) {
					this.showResponseMessage(
						response
						, function() {
							location.replace(url);
						}
					);
				} else {
					location.replace(url);
				}
			} else if ((url = response.getGoToURL().trim()) !== '') {
				if (response.hasMessage()) {
					this.showResponseMessage(
						response
						, function() {
							location.href = url;
						}
					);
				} else {
					location.href = url;
				}
			} else {
				this._onSuccess(response, textStatus, jqXHR);
			}
		} else {
			this.serverError(response);
		}
	};
	Ajax.prototype.error = function($xhr, textStatus, errorThrown) {
		this._endWait();
		this._onError($xhr, textStatus, errorThrown);
		$error('Có l?i b?t thu?ng x?y ra, xin th? l?i sau. [AJAX_ERROR] ' + errorThrown);
	};

	// STATIC MEMBERS
		
	Ajax.SearchGrid = AjaxSearchGrid;
	
	// Factory method
	Ajax.forURL = function(url) {
		return new Ajax().setURL(url);
	};
		
	Ajax.formInput = ajaxFormInput
	
	return Ajax;
})();
	

var SimpleGrid = (function() {
	
	function _construct(self, cfg) {
		var tmp;
		tmp = $(cfg.grid);
		self.config = cfg;
		self.$elem = (tmp.prop('nodeName').toLowerCase() === 'table') ? tmp : tmp.find('table');
		self.$tbody = self.$elem.find('tbody').eq(0);
		self.pkField = cfg.pkField || SimpleGrid.FIELD_PK;
		self.hasAddRowCallback = $.isFunction(cfg.afterAddRow);
		self.isAllowAddRow = !!cfg.isAllowAddRow || false;
		tmp = self.$tbody.children().eq(0);
		self.$holder = tmp.clone(true);
		self.$holder.find('[fn]').addClass('button');
		tmp.remove();	
		
		// Safety for getting data on server
		self.$holder.findInput(self.pkField).val(0);
		
		self.$tbody.delegate('[fn="delete"]', 'click',
			function(ev) {
				var $tr, data;
				ev.preventDefault();
				$tr = $(this).closest('tr');
				data =  $.data($tr.get(0), 'data');
				if ($.isFunction(cfg.deleteFn)) {
					cfg.deleteFn.apply($tr, [data, $tr.attr('index'), data[self.pkField]]);
				} else {
					var pk = parseInt($tr.findInput(self.pkField).val(), 10);
					function del() {
						if (self.deleteURL.length > 1) {
							$.ajax({url: self.deleteURL.urlParam(self.pkField, pk)});
						}
						$tr.remove();
						self.$tbody.find('[field="stt"]').each(function(index) {
							$(this).text(++ index);
						});
					}
					if (!isNaN(pk) && pk > 0) {
						$confirm(self.deleteConfirmMessage, del);
					} else {
						del();
					}
				}
			}
		);
		
		if (self.isAllowAddRow) {
			var $addBtn = undefined;
			if (cfg.addBtn === undefined) {
				var $toolbar = $('<div class="sg-toolbar right clear" style="margin-bottom: 5px"></div>');
				$addBtn = $('<a fn="add" class="button btn-16 add-btn" href="#" title="Thêm hàng m?i">&nbsp;</a>');
				self.$elem.before($toolbar.append($addBtn));
				self.$elem.addClass('clear');
			} else {
				$addBtn = $(cfg.addBtn);
			}
			
			$addBtn.bind('click', function(ev) {
				self.addRow({});
				ev.preventDefault();
			});
		}
	}
	
	function SimpleGrid(cfg) {
		
		var self = this;
		
		// PROPERTIES
		self.config;
		self.$elem;
		self.$tbody;
		self.$holder;
		self.pkField;
		self.hasAddRowCallback;
		self.isAllowAddRow;
		self.deleteConfirmMessage = cfg.deleteConfirmMessage || 'Ch?c ch?n mu?n xóa b?n ghi này?';
		
		// METHODS
		self.fill;
		self.getRowData;
		self.addRow;
		
		_construct(self, cfg);
		self.fill(cfg.data);
	}
	
	// METHODS
	SimpleGrid.prototype.fill = function fill(data, sttDauTien) {
		if ($.isArray(data)) {
			this.$tbody.empty();
			sttDauTien = sttDauTien || 1;
			
			for (var i = 0; i < data.length; i ++) {
				this.addRow(data[i], sttDauTien ++);
			}
			
			if ($.isFunction(this.config.afterFill)) {
				this.config.afterFill.apply(this.$elem);
			}
		}
	};
	
	SimpleGrid.prototype.getRowData = function getRowData(rix) {
		return $.data(this.$tbody.children().eq(rix).get(0), 'data');
	};
	
	SimpleGrid.prototype.addRow = function addRow(data, stt) {
		
		var pk
			, index = this.$tbody.children().length
			, $newTr = this.$holder.clone(true);
		
		this.$tbody.append($newTr);
		pk = data[this.pkField];
		$newTr.fillData(data);
		$newTr.find('[uniqueid]').each(function() {
			if (this.name  !== '') {
				this.id = this.name + index;
			}
		});
		
		// Storing data for later use
		$.data($newTr.get(0), 'data', data);
		
		$newTr.find('[field="stt"]').text(stt || index + 1);
		$newTr.find('input[field="index"]').val(index);
		
		$newTr.addClass('grid-row');
		$newTr.attr('index', index);
		$newTr.show();
		
		if (this.hasAddRowCallback) {
			this.config.afterAddRow.apply($newTr, [data, index, pk]);
		}
		
		$newTr.find(':input:visible:first').focus();
	};
	
	// STATIC
	SimpleGrid.FIELD_PK = 'id';
	
	return SimpleGrid;
	
})(); 
	


/** 
 * @author unitech.trungnnh
 * define jquery plugins
 */
(function defineCmon$Plugins($) {
	
	if ($.fn.showValidateMessages !== undefined) {
		return;
	}
	
	var orgSerialize = $.fn.serialize;
	$.fn.serialize = function() {
		var $dis = this.find(':input:disabled');
		$dis.prop('disabled', false);
		var result = orgSerialize.apply(this);
		$dis.prop('disabled', true);
		return result;
	};
	
	$.fn.fillData = function fillData(data) {
		return this.each(function() {
			DataFiller.fill(this, data);
		});
	};
	
	$.fn.fillOptionHTML = function fillOptionHTML(data, keyValue, keyText, defaultValue) {
		return this.each(function() {
			var $this, html = '';
			$this = $(this);
			
			if (this.$defaultOption.length) {
				html += this.$defaultOption.get(0).outerHTML;
			}
			
			for (var i = 0; i < data.length; ++ i) {
				html += '<option value="' + data[i][keyValue] + '"';
				html += '>' + data[i][keyText] + '</option>';
			}
			
			$this.html(html);
			
			if (defaultValue) {
				$this.val(defaultValue).trigger('change');
			}
		});
	};
	
	function getTopDeclStr()
	{
	    var retStr= ''
	    , dt = document.doctype
	    , htmlStr = document.documentElement.outerHTML;
	    
	    if (dt) {
	        
	        retStr += '<!DOCTYPE';
	        
	        if (dt.name.length) {
	            retStr += ' ' + dt.name;
	        }
	        
	        if (dt.publicId.length) {
	            retStr += ' PUBLIC "' + dt.publicId + '"';
	        }
	        
	        if (dt.systemId.length) {
	            retStr += ' "' + dt.systemId + '"';
	        }
	        
	        retStr += '>';
	    }
		
		retStr += htmlStr.substring(0, htmlStr.indexOf("<head>"));
	    
	    return retStr;
	}
	

	
	$.fn.findInput = function findInput(name) {
		var $out = this.eq(0).find('[name="' + name + '"]');
		if (!$out.length) {
			$out = $('#' + name);
		}
		return $out;
	};
	
	$.fn.fitToText = function fitToText(defaultHeight) {
		return this.each(
			function() {
				
				if (this.nodeName.toLowerCase() !== 'textarea') {
					return true;
				}
				
				var $this = $(this);
				defaultHeight = defaultHeight || '1.7em';
				$this.css('height', defaultHeight);
				
				if ($this.css('box-sizing') === 'border-box') {
					$this.css('height',($this.prop('scrollHeight') + $this.outerHeight() - $this.height()) + 'px');
				} else {
					$this.css('height', $this.prop('scrollHeight') + 'px');
				}
			}
		);
	};
	
	$.fn.inViewPort = function inViewPort() {
		
		if (!this.is(':visible')) {
			return false;
		}
		
		var el = this.get(0)
	    ,rect = el.getBoundingClientRect();

	    return (
	        rect.top >= 0 &&
	        rect.left >= 0 &&
	        rect.bottom <= (window.innerHeight || document. documentElement.clientHeight) && /*or $(window).height() */
	        rect.right <= (window.innerWidth || document. documentElement.clientWidth) /*or $(window).width() */
	        );
	};
	
	$.fn.getZIndex = function getZIndex() {
		
		var zIndex = undefined, $tmp = this, pos;
		
		while (zIndex === undefined) {
			pos = $tmp.css('position');
			if (pos === 'relative'
				|| pos === 'absolute'
				|| pos === 'fixed'
				|| $tmp.get(0) === document.body
			) {
				zIndex = $tmp.css('z-index');
			}
			$tmp = $tmp.parent();
		}
		
		return zIndex;
	};

	$.fn.getOuter = function getOuter() {
		var $out = this.closest('._outer');
		if ($out.length === 0) {
			var pos;
			$out = this;
			while (true) {
				pos = $out.css('position');
				if (pos === 'relative'
					|| pos === 'absolute'
					|| pos === 'fixed'
					|| $out.get(0) === document.body
				) {
					break;
				}
				$out = $out.parent();
			}
		}
		
		if ($out.length === 0) {
			$out = $(document.body);
		}
		return $out;
	};
	
	$.fn.locateLoading = function locateLoading() {
		var $loading, $this, maxWidth, maxHeight, mrgLeft, mrgTop, pos;
		return this.each(function() {
			$loading = $.data(this, '$loading');
			if ($loading === undefined) {
				return true;
			}
			
			$this = $(this);
			maxWidth = $this.outerWidth(true);
			maxHeight = $this.outerHeight(true);
			mrgLeft = (maxWidth - $this.outerWidth()) / 2;
			mrgTop = (maxHeight - $this.outerHeight()) / 2;
			$loading.width(maxWidth - mrgLeft * 2);
			$loading.height(maxHeight - mrgTop * 2);
			
			if ($this.getOuter().get(0) === document.body) {
				pos = $this.offset();
				$loading.offset({
					left: pos.left + mrgLeft,
					top: pos.top + mrgTop
				});
			} else {
				pos = $this.position();
				$loading.css('left', (pos.left + mrgLeft) + 'px');
				$loading.css('top', (pos.top + mrgTop) + 'px');
			}
		});
	};
	
	$.fn.showLoading = function showLoading(small) {
		var $outer, $loading, $this;
		return this.each(function() {
			
			if (this === SCREEN_LOADING.get(0)) {
				SCREEN_LOADING.show();
				return true;
			}
			
			$this = $(this);
			if (! $this.is(':visible')) {
				return true;
			}
			
			$loading = $.data(this, '$loading');
			if ($loading === undefined) {
				$loading = $('<div class="loading" style="display:none;">&nbsp;</div>');
				$.data(this, '$loading', $loading);
				$outer = $this.getOuter();
				$outer.append($loading);
				$(window).bind('resize',
					function() {
						$this.locateLoading();
					}
				);
			}
			
			if (small) {
				$loading.addClass('loading-small');
			} else {
				$loading.removeClass('loading-small');
			}
			$loading.show();
			$this.locateLoading();
		});
	};
	
	$.fn.hideLoading = function hideLoading() {
		return this.each(function() {
			if (this === SCREEN_LOADING.get(0)) {
				SCREEN_LOADING.hide();
				return true;
			} 
			var $loading = $.data(this, '$loading');
			if ($loading) {
				$loading.hide();
			}
		});
	};
	
	$.fn.toVNNum = function(val) {
		var $this = $(this);
		val = parseInt(val, 10);
		if ($this.prop('nodeName').toLowerCase() === 'input') {
			if (isNaN(val)) {
				val = $this.val();
			}
			$this.val(toVNNum(val, $this.attr('numsetting')));
		} else {
			if (isNaN(val)) {
				val = $this.text();
			}
			$this.text(toVNNum(val, $this.attr('numsetting')));
		}
		
	};

})(jQuery);

(function customNoty() {
	
	$.noty.defaults = $.extend(true, $.noty.defaults, {
		layout: 'topCenter',
		theme: 'defaultTheme',
		animation: {
		    open: {height: 'toggle'},
		    close: {height: 'toggle'},
		    easing: 'swing',
		    speed: 50 // opening & closing animation speed
		},
		modal: true,
		callback: {
			afterShow: function() {
				this.options.layout.container.style.apply($(this.options.layout.container.selector));
				this.$bar.find('button:last').focus();
			}
		}
	});
	
	function notyMessage(_type, _text, _bt1, _bt2, _bt3) {

		var _buttons = [];
		
		_buttons.push(
			{
				addClass: 'btn btn-primary egov-button-normal small',
				text: _bt1[0],
				onClick: function($noty) {
					$noty.close();
					if ($.isFunction(_bt1[1])) {
						(_bt1[1])();
					}
				}
			}
		);
		
		if (_bt2) {
			_buttons.push(
				{
					addClass: 'btn btn-primary egov-button-normal small',
					text: _bt2[0],
					onClick: function($noty) {
						$noty.close();
						if ($.isFunction(_bt2[1])) {
							(_bt2[1])();
						}
					}
				}
			);
		}
		
		if (_bt3) {
			_buttons.push(
				{
					addClass: 'btn btn-primary egov-button-normal small',
					text: _bt3[0],
					onClick: function($noty) {
						$noty.close();
						if ($.isFunction(_bt3[1])) {
							(_bt3[1])();
						}
					}
				}
			);
		}
		
		noty({
			text: _text,
			type: _type,
			buttons: _buttons
		});
	}
	
	window.$alert = function(_text, _okCallback) {
		notyMessage('notification', _text, ['Ok', _okCallback]);
	};
	
	window.$confirm = function(_text, _okCallback, _cancelCallback) {
		notyMessage('notification', _text, ['Ok', _okCallback], ['Cancel', _cancelCallback]);
	};
	
	window.$error = function(_text, _okCallback) {
		notyMessage('error', _text, ['Ok', _okCallback]);
	};

	window.$success = function(_text, _okCallback) {
		notyMessage('success', _text, ['Ok', _okCallback]);
	};
	
	window.$warning = function(_text, _okCallback) {
		notyMessage('warning', _text, ['Ok', _okCallback]);
	};
	
	window.$message = function(_text, _bt1, _bt2, _bt3) {
		notyMessage('notification', _text, _bt1, _bt2, _bt3)
	};
})();

var DataFiller = (function() {
	
	function DataFiller() {
		this.filler = [];
	}
	
	DataFiller.prototype.regist = function(callback) {
		this.filler.push(callback);
		return this;
	};
	
	DataFiller.prototype.fill = function(container, data) {
		for(var key in data) {
			for (var i = 0; i < this.filler.length; ++ i) {
				if ($.isFunction(this.filler[i])) {
					this.filler[i](container, key, data[key])
				}
			}
		}
	};
	
	function defaultFiller(container, key, value) {
		var $input, isRadioCheckbox, $container = $(container);
		
		$input = $container.findInput(key);
		isRadioCheckbox = ($input.prop('type') === 'checkbox') || ($input.prop('type') === 'radio');
		if ($input.prop('type') !== 'file' 
			&& !isRadioCheckbox
		) {
			$input.val(value);
		} else if (isRadioCheckbox) {
			$input.prop('checked', !!value);
		}
		
		$container.find('[field="' + key + '"]').text(value);
	}
	
	return new DataFiller().regist(defaultFiller);
	
})();

function parseSetting(setting) {
	setting = setting ? (setting + '').split('.') : [10, 2];
    var _decLen = (setting.length > 1) ? parseInt(setting[1], 10) : 0;
    var _numLen = parseInt(setting[0], 10) - _decLen;
    return {numLen: _numLen, decLen: _decLen};
}

function isNumberKey(key, withPoint) {
	var out = (key >= 48 && key <= 57) || (key >= 96 && key <= 105);
	return withPoint ? (out || key === 190 || key === 110) : out;
}

/**
 * @TODO:
 * 		Làm s?ch input và tr? v? d?ng s? Vi?t Nam 
 * 			(d?u th?p phân là "," và d?u ngan cách hàng nghìn là d?u ".")
 * @param inStr
 * @param setting ví d? input: 12.2 nghia là t?i da dài 12, và ch?p nh?n t?i da 2 s? sau d?u th?p phân
 * @returns {String}
 */
function toVNNum(inStr, setting) {
	inStr = (inStr + '').trim();
	setting = parseSetting(setting);
	
    var
	    commaIndex = 0, // index c?a d?u th?p phân
	    cur = 0,
	    count = 0,
	    char = '',
	    leftStr = '', // chu?i bên trái d?u th?p phân
	    rightStr = '', // chu?i k? t? d?u th?p phân v? sau
	    tmp = '';
    
	var validChars = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', ',']; 
    
    // Lo?i b? các ký t? không c?n thi?t
    cur = inStr.length;
    while (cur --) {
    	char = inStr.charAt(cur);
    	if ( $.inArray(char, validChars) !== -1 ) {
    		tmp = char.concat(tmp);
    	}
    }
    tmp = tmp.trimChar([',','.']);
    commaIndex = tmp.lastIndexOf(',');
    tmp = tmp.replace(/\./g, ','); 

    if ((setting.decLen > 0) && (commaIndex !== -1)) {
    		
		rightStr = tmp
			.substr(commaIndex, setting.decLen + 1)
			.rTrimChar('0')
    		.rTrimChar(',');
    		
    } else {
    	commaIndex = tmp.length;
    }
    leftStr = tmp
    	.leftUntil(commaIndex)
    	.replace(/,/g, '')
    	.lTrimChar('0')
        .left(setting.numLen);
	
	cur = leftStr.length;
    count = 0;
    tmp = '';
	while ( cur -- ) {
        
        ++ count;
        tmp = leftStr.charAt(cur).concat(tmp);
        
        if (count === 3 && cur !== 0) {
            count = 0;
            tmp = '.'.concat(tmp);
        }
	}
	return tmp.concat(rightStr);
}
 
 String.prototype.lTrimChar = function(trimArr) {
		
		trimArr = $.isArray(trimArr) ? trimArr : [trimArr];
		var self = this.trim();
		var out = '', cur = 0;
		
		for (cur; cur < self.length; cur ++) {
	        
	        if ($.inArray(self.charAt(cur), trimArr) !== -1) {
	            continue;
	        }
			
	        out = self.substring(cur);
			break;
		}
		
		return out;
	};
	String.prototype.rTrimChar = function(trimArr) {
		
		trimArr = $.isArray(trimArr) ? trimArr : [trimArr];
		var self = this.trim();
		var out = '', cur = 0;
		
		cur = self.length;
		while ( cur -- ) {
			
	        if ($.inArray(self.charAt(cur), trimArr) !== -1) {
	            continue;
	        }
	        
			out = self.substring(0, ++ cur);
			break;
		}
		
		return out;
	};
	String.prototype.trimChar = function(trimArr) {
		return this.rTrimChar(trimArr).lTrimChar(trimArr);
	};
	
	String.prototype.left = function(noc) {
		return this.substr(0, noc);
	};
	String.prototype.leftUntil = function(index) {
		return this.substring(0, index);
	};
	String.prototype.right = function(noc) {
		return this.substr(this.length - noc);
	};
	String.prototype.rightUntil = function(index) {
		return this.substring(index);
	};
	
	function isControlKey(key) {
		return key === 8 // backspace
			|| key === 9 // tab
			|| key === 13 // enter
			|| key === 16 // shift
			|| (key >= 16 && key <= 20)
			|| key === 27 // escape
			|| (key >= 33 && key <= 40)
			|| key === 45 // insert
			|| key === 46; // delete
	}
