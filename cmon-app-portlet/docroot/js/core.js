/*
 * jquery.noty.packaged.min.js
 */
"function"!=typeof Object.create&&(Object.create=function(a){function b(){}return b.prototype=a,new b}),function(a){var b={init:function(b){return this.options=a.extend({},a.noty.defaults,b),this.options.layout=this.options.custom?a.noty.layouts.inline:a.noty.layouts[this.options.layout],a.noty.themes[this.options.theme]?this.options.theme=a.noty.themes[this.options.theme]:b.themeClassName=this.options.theme,delete b.layout,delete b.theme,this.options=a.extend({},this.options,this.options.layout.options),this.options.id="noty_"+(new Date).getTime()*Math.floor(1e6*Math.random()),this.options=a.extend({},this.options,b),this._build(),this},_build:function(){var b=a('<div class="noty_bar noty_type_'+this.options.type+'"></div>').attr("id",this.options.id);if(b.append(this.options.template).find(".noty_text").html(this.options.text),this.$bar=null!==this.options.layout.parent.object?a(this.options.layout.parent.object).css(this.options.layout.parent.css).append(b):b,this.options.themeClassName&&this.$bar.addClass(this.options.themeClassName).addClass("noty_container_type_"+this.options.type),this.options.buttons){this.options.closeWith=[],this.options.timeout=!1;var c=a("<div/>").addClass("noty_buttons");null!==this.options.layout.parent.object?this.$bar.find(".noty_bar").append(c):this.$bar.append(c);var d=this;a.each(this.options.buttons,function(b,c){var e=a("<button/>").addClass(c.addClass?c.addClass:"gray").html(c.text).attr("id",c.id?c.id:"button-"+b).appendTo(d.$bar.find(".noty_buttons")).bind("click",function(){a.isFunction(c.onClick)&&c.onClick.call(e,d)})})}this.$message=this.$bar.find(".noty_message"),this.$closeButton=this.$bar.find(".noty_close"),this.$buttons=this.$bar.find(".noty_buttons"),a.noty.store[this.options.id]=this},show:function(){var b=this;return b.options.custom?b.options.custom.find(b.options.layout.container.selector).append(b.$bar):a(b.options.layout.container.selector).append(b.$bar),b.options.theme&&b.options.theme.style&&b.options.theme.style.apply(b),"function"===a.type(b.options.layout.css)?this.options.layout.css.apply(b.$bar):b.$bar.css(this.options.layout.css||{}),b.$bar.addClass(b.options.layout.addClass),b.options.layout.container.style.apply(a(b.options.layout.container.selector)),b.showing=!0,b.options.theme&&b.options.theme.style&&b.options.theme.callback.onShow.apply(this),a.inArray("click",b.options.closeWith)>-1&&b.$bar.css("cursor","pointer").one("click",function(a){b.stopPropagation(a),b.options.callback.onCloseClick&&b.options.callback.onCloseClick.apply(b),b.close()}),a.inArray("hover",b.options.closeWith)>-1&&b.$bar.one("mouseenter",function(){b.close()}),a.inArray("button",b.options.closeWith)>-1&&b.$closeButton.one("click",function(a){b.stopPropagation(a),b.close()}),-1==a.inArray("button",b.options.closeWith)&&b.$closeButton.remove(),b.options.callback.onShow&&b.options.callback.onShow.apply(b),b.$bar.animate(b.options.animation.open,b.options.animation.speed,b.options.animation.easing,function(){b.options.callback.afterShow&&b.options.callback.afterShow.apply(b),b.showing=!1,b.shown=!0}),b.options.timeout&&b.$bar.delay(b.options.timeout).promise().done(function(){b.close()}),this},close:function(){if(!(this.closed||this.$bar&&this.$bar.hasClass("i-am-closing-now"))){var b=this;if(this.showing)return b.$bar.queue(function(){b.close.apply(b)}),void 0;if(!this.shown&&!this.showing){var c=[];return a.each(a.noty.queue,function(a,d){d.options.id!=b.options.id&&c.push(d)}),a.noty.queue=c,void 0}b.$bar.addClass("i-am-closing-now"),b.options.callback.onClose&&b.options.callback.onClose.apply(b),b.$bar.clearQueue().stop().animate(b.options.animation.close,b.options.animation.speed,b.options.animation.easing,function(){b.options.callback.afterClose&&b.options.callback.afterClose.apply(b)}).promise().done(function(){b.options.modal&&(a.notyRenderer.setModalCount(-1),0==a.notyRenderer.getModalCount()&&a(".noty_modal").fadeOut("fast",function(){a(this).remove()})),a.notyRenderer.setLayoutCountFor(b,-1),0==a.notyRenderer.getLayoutCountFor(b)&&a(b.options.layout.container.selector).remove(),"undefined"!=typeof b.$bar&&null!==b.$bar&&(b.$bar.remove(),b.$bar=null,b.closed=!0),delete a.noty.store[b.options.id],b.options.theme.callback&&b.options.theme.callback.onClose&&b.options.theme.callback.onClose.apply(b),b.options.dismissQueue||(a.noty.ontap=!0,a.notyRenderer.render()),b.options.maxVisible>0&&b.options.dismissQueue&&a.notyRenderer.render()})}},setText:function(a){return this.closed||(this.options.text=a,this.$bar.find(".noty_text").html(a)),this},setType:function(a){return this.closed||(this.options.type=a,this.options.theme.style.apply(this),this.options.theme.callback.onShow.apply(this)),this},setTimeout:function(a){if(!this.closed){var b=this;this.options.timeout=a,b.$bar.delay(b.options.timeout).promise().done(function(){b.close()})}return this},stopPropagation:function(a){a=a||window.event,"undefined"!=typeof a.stopPropagation?a.stopPropagation():a.cancelBubble=!0},closed:!1,showing:!1,shown:!1};a.notyRenderer={},a.notyRenderer.init=function(c){var d=Object.create(b).init(c);return d.options.killer&&a.noty.closeAll(),d.options.force?a.noty.queue.unshift(d):a.noty.queue.push(d),a.notyRenderer.render(),"object"==a.noty.returns?d:d.options.id},a.notyRenderer.render=function(){var b=a.noty.queue[0];"object"===a.type(b)?b.options.dismissQueue?b.options.maxVisible>0?a(b.options.layout.container.selector+" li").length<b.options.maxVisible&&a.notyRenderer.show(a.noty.queue.shift()):a.notyRenderer.show(a.noty.queue.shift()):a.noty.ontap&&(a.notyRenderer.show(a.noty.queue.shift()),a.noty.ontap=!1):a.noty.ontap=!0},a.notyRenderer.show=function(b){b.options.modal&&(a.notyRenderer.createModalFor(b),a.notyRenderer.setModalCount(1)),b.options.custom?0==b.options.custom.find(b.options.layout.container.selector).length?b.options.custom.append(a(b.options.layout.container.object).addClass("i-am-new")):b.options.custom.find(b.options.layout.container.selector).removeClass("i-am-new"):0==a(b.options.layout.container.selector).length?a("body").append(a(b.options.layout.container.object).addClass("i-am-new")):a(b.options.layout.container.selector).removeClass("i-am-new"),a.notyRenderer.setLayoutCountFor(b,1),b.show()},a.notyRenderer.createModalFor=function(b){if(0==a(".noty_modal").length){var c=a("<div/>").addClass("noty_modal").addClass(b.options.theme).data("noty_modal_count",0);b.options.theme.modal&&b.options.theme.modal.css&&c.css(b.options.theme.modal.css),c.prependTo(a("body")).fadeIn("fast")}},a.notyRenderer.getLayoutCountFor=function(b){return a(b.options.layout.container.selector).data("noty_layout_count")||0},a.notyRenderer.setLayoutCountFor=function(b,c){return a(b.options.layout.container.selector).data("noty_layout_count",a.notyRenderer.getLayoutCountFor(b)+c)},a.notyRenderer.getModalCount=function(){return a(".noty_modal").data("noty_modal_count")||0},a.notyRenderer.setModalCount=function(b){return a(".noty_modal").data("noty_modal_count",a.notyRenderer.getModalCount()+b)},a.fn.noty=function(b){return b.custom=a(this),a.notyRenderer.init(b)},a.noty={},a.noty.queue=[],a.noty.ontap=!0,a.noty.layouts={},a.noty.themes={},a.noty.returns="object",a.noty.store={},a.noty.get=function(b){return a.noty.store.hasOwnProperty(b)?a.noty.store[b]:!1},a.noty.close=function(b){return a.noty.get(b)?a.noty.get(b).close():!1},a.noty.setText=function(b,c){return a.noty.get(b)?a.noty.get(b).setText(c):!1},a.noty.setType=function(b,c){return a.noty.get(b)?a.noty.get(b).setType(c):!1},a.noty.clearQueue=function(){a.noty.queue=[]},a.noty.closeAll=function(){a.noty.clearQueue(),a.each(a.noty.store,function(a,b){b.close()})};var c=window.alert;a.noty.consumeAlert=function(b){window.alert=function(c){b?b.text=c:b={text:c},a.notyRenderer.init(b)}},a.noty.stopConsumeAlert=function(){window.alert=c},a.noty.defaults={layout:"top",theme:"defaultTheme",type:"alert",text:"",dismissQueue:!0,template:'<div class="noty_message"><span class="noty_text"></span><div class="noty_close"></div></div>',animation:{open:{height:"toggle"},close:{height:"toggle"},easing:"swing",speed:500},timeout:!1,force:!1,modal:!1,maxVisible:5,killer:!1,closeWith:["click"],callback:{onShow:function(){},afterShow:function(){},onClose:function(){},afterClose:function(){},onCloseClick:function(){}},buttons:!1},a(window).resize(function(){a.each(a.noty.layouts,function(b,c){c.container.style.apply(a(c.container.selector))})})}(jQuery),window.noty=function(a){return jQuery.notyRenderer.init(a)},function(a){a.noty.layouts.bottom={name:"bottom",options:{},container:{object:'<ul id="noty_bottom_layout_container" />',selector:"ul#noty_bottom_layout_container",style:function(){a(this).css({bottom:0,left:"5%",position:"fixed",width:"90%",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:9999999})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none"},addClass:""}}(jQuery),function(a){a.noty.layouts.bottomCenter={name:"bottomCenter",options:{},container:{object:'<ul id="noty_bottomCenter_layout_container" />',selector:"ul#noty_bottomCenter_layout_container",style:function(){a(this).css({bottom:20,left:0,position:"fixed",width:"310px",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:1e7}),a(this).css({left:(a(window).width()-a(this).outerWidth(!1))/2+"px"})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none",width:"310px"},addClass:""}}(jQuery),function(a){a.noty.layouts.bottomLeft={name:"bottomLeft",options:{},container:{object:'<ul id="noty_bottomLeft_layout_container" />',selector:"ul#noty_bottomLeft_layout_container",style:function(){a(this).css({bottom:20,left:20,position:"fixed",width:"310px",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:1e7}),window.innerWidth<600&&a(this).css({left:5})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none",width:"310px"},addClass:""}}(jQuery),function(a){a.noty.layouts.bottomRight={name:"bottomRight",options:{},container:{object:'<ul id="noty_bottomRight_layout_container" />',selector:"ul#noty_bottomRight_layout_container",style:function(){a(this).css({bottom:20,right:20,position:"fixed",width:"310px",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:1e7}),window.innerWidth<600&&a(this).css({right:5})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none",width:"310px"},addClass:""}}(jQuery),function(a){a.noty.layouts.center={name:"center",options:{},container:{object:'<ul id="noty_center_layout_container" />',selector:"ul#noty_center_layout_container",style:function(){a(this).css({position:"fixed",width:"310px",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:1e7});var b=a(this).clone().css({visibility:"hidden",display:"block",position:"absolute",top:0,left:0}).attr("id","dupe");a("body").append(b),b.find(".i-am-closing-now").remove(),b.find("li").css("display","block");var c=b.height();b.remove(),a(this).hasClass("i-am-new")?a(this).css({left:(a(window).width()-a(this).outerWidth(!1))/2+"px",top:(a(window).height()-c)/2+"px"}):a(this).animate({left:(a(window).width()-a(this).outerWidth(!1))/2+"px",top:(a(window).height()-c)/2+"px"},500)}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none",width:"310px"},addClass:""}}(jQuery),function(a){a.noty.layouts.centerLeft={name:"centerLeft",options:{},container:{object:'<ul id="noty_centerLeft_layout_container" />',selector:"ul#noty_centerLeft_layout_container",style:function(){a(this).css({left:20,position:"fixed",width:"310px",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:1e7});var b=a(this).clone().css({visibility:"hidden",display:"block",position:"absolute",top:0,left:0}).attr("id","dupe");a("body").append(b),b.find(".i-am-closing-now").remove(),b.find("li").css("display","block");var c=b.height();b.remove(),a(this).hasClass("i-am-new")?a(this).css({top:(a(window).height()-c)/2+"px"}):a(this).animate({top:(a(window).height()-c)/2+"px"},500),window.innerWidth<600&&a(this).css({left:5})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none",width:"310px"},addClass:""}}(jQuery),function(a){a.noty.layouts.centerRight={name:"centerRight",options:{},container:{object:'<ul id="noty_centerRight_layout_container" />',selector:"ul#noty_centerRight_layout_container",style:function(){a(this).css({right:20,position:"fixed",width:"310px",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:1e7});var b=a(this).clone().css({visibility:"hidden",display:"block",position:"absolute",top:0,left:0}).attr("id","dupe");a("body").append(b),b.find(".i-am-closing-now").remove(),b.find("li").css("display","block");var c=b.height();b.remove(),a(this).hasClass("i-am-new")?a(this).css({top:(a(window).height()-c)/2+"px"}):a(this).animate({top:(a(window).height()-c)/2+"px"},500),window.innerWidth<600&&a(this).css({right:5})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none",width:"310px"},addClass:""}}(jQuery),function(a){a.noty.layouts.inline={name:"inline",options:{},container:{object:'<ul class="noty_inline_layout_container" />',selector:"ul.noty_inline_layout_container",style:function(){a(this).css({width:"100%",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:9999999})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none"},addClass:""}}(jQuery),function(a){a.noty.layouts.top={name:"top",options:{},container:{object:'<ul id="noty_top_layout_container" />',selector:"ul#noty_top_layout_container",style:function(){a(this).css({top:0,left:"5%",position:"fixed",width:"90%",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:9999999})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none"},addClass:""}}(jQuery),function(a){a.noty.layouts.topCenter={name:"topCenter",options:{},container:{object:'<ul id="noty_topCenter_layout_container" />',selector:"ul#noty_topCenter_layout_container",style:function(){a(this).css({top:20,left:0,position:"fixed",width:"310px",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:1e7}),a(this).css({left:(a(window).width()-a(this).outerWidth(!1))/2+"px"})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none",width:"310px"},addClass:""}}(jQuery),function(a){a.noty.layouts.topLeft={name:"topLeft",options:{},container:{object:'<ul id="noty_topLeft_layout_container" />',selector:"ul#noty_topLeft_layout_container",style:function(){a(this).css({top:20,left:20,position:"fixed",width:"310px",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:1e7}),window.innerWidth<600&&a(this).css({left:5})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none",width:"310px"},addClass:""}}(jQuery),function(a){a.noty.layouts.topRight={name:"topRight",options:{},container:{object:'<ul id="noty_topRight_layout_container" />',selector:"ul#noty_topRight_layout_container",style:function(){a(this).css({top:20,right:20,position:"fixed",width:"310px",height:"auto",margin:0,padding:0,listStyleType:"none",zIndex:1e7}),window.innerWidth<600&&a(this).css({right:5})}},parent:{object:"<li />",selector:"li",css:{}},css:{display:"none",width:"310px"},addClass:""}}(jQuery),function(a){a.noty.themes.defaultTheme={name:"defaultTheme",helpers:{borderFix:function(){if(this.options.dismissQueue){var b=this.options.layout.container.selector+" "+this.options.layout.parent.selector;switch(this.options.layout.name){case"top":a(b).css({borderRadius:"0px 0px 0px 0px"}),a(b).last().css({borderRadius:"0px 0px 5px 5px"});break;case"topCenter":case"topLeft":case"topRight":case"bottomCenter":case"bottomLeft":case"bottomRight":case"center":case"centerLeft":case"centerRight":case"inline":a(b).css({borderRadius:"0px 0px 0px 0px"}),a(b).first().css({"border-top-left-radius":"5px","border-top-right-radius":"5px"}),a(b).last().css({"border-bottom-left-radius":"5px","border-bottom-right-radius":"5px"});break;case"bottom":a(b).css({borderRadius:"0px 0px 0px 0px"}),a(b).first().css({borderRadius:"5px 5px 0px 0px"})}}}},modal:{css:{position:"fixed",width:"100%",height:"100%",backgroundColor:"#000",zIndex:1e4,opacity:.6,display:"none",left:0,top:0}},style:function(){switch(this.$bar.css({overflow:"hidden",background:"url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABsAAAAoCAYAAAAPOoFWAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAPZJREFUeNq81tsOgjAMANB2ov7/7ypaN7IlIwi9rGuT8QSc9EIDAsAznxvY4pXPKr05RUE5MEVB+TyWfCEl9LZApYopCmo9C4FKSMtYoI8Bwv79aQJU4l6hXXCZrQbokJEksxHo9KMOgc6w1atHXM8K9DVC7FQnJ0i8iK3QooGgbnyKgMDygBWyYFZoqx4qS27KqLZJjA1D0jK6QJcYEQEiWv9PGkTsbqxQ8oT+ZtZB6AkdsJnQDnMoHXHLGKOgDYuCWmYhEERCI5gaamW0bnHdA3k2ltlIN+2qKRyCND0bhqSYCyTB3CAOc4WusBEIpkeBuPgJMAAX8Hs1NfqHRgAAAABJRU5ErkJggg==') repeat-x scroll left top #fff"}),this.$message.css({fontSize:"13px",lineHeight:"16px",textAlign:"center",padding:"8px 10px 9px",width:"auto",position:"relative"}),this.$closeButton.css({position:"absolute",top:4,right:4,width:10,height:10,background:"url(data:image/png;base64,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)",display:"none",cursor:"pointer"}),this.$buttons.css({padding:5,textAlign:"right",borderTop:"1px solid #ccc",backgroundColor:"#fff"}),this.$buttons.find("button").css({marginLeft:5}),this.$buttons.find("button:first").css({marginLeft:0}),this.$bar.bind({mouseenter:function(){a(this).find(".noty_close").stop().fadeTo("normal",1)},mouseleave:function(){a(this).find(".noty_close").stop().fadeTo("normal",0)}}),this.options.layout.name){case"top":this.$bar.css({borderRadius:"0px 0px 5px 5px",borderBottom:"2px solid #eee",borderLeft:"2px solid #eee",borderRight:"2px solid #eee",boxShadow:"0 2px 4px rgba(0, 0, 0, 0.1)"});break;case"topCenter":case"center":case"bottomCenter":case"inline":this.$bar.css({borderRadius:"5px",border:"1px solid #eee",boxShadow:"0 2px 4px rgba(0, 0, 0, 0.1)"}),this.$message.css({fontSize:"13px",textAlign:"center"});break;case"topLeft":case"topRight":case"bottomLeft":case"bottomRight":case"centerLeft":case"centerRight":this.$bar.css({borderRadius:"5px",border:"1px solid #eee",boxShadow:"0 2px 4px rgba(0, 0, 0, 0.1)"}),this.$message.css({fontSize:"13px",textAlign:"left"});break;case"bottom":this.$bar.css({borderRadius:"5px 5px 0px 0px",borderTop:"2px solid #eee",borderLeft:"2px solid #eee",borderRight:"2px solid #eee",boxShadow:"0 -2px 4px rgba(0, 0, 0, 0.1)"});break;default:this.$bar.css({border:"2px solid #eee",boxShadow:"0 2px 4px rgba(0, 0, 0, 0.1)"})}switch(this.options.type){case"alert":case"notification":this.$bar.css({backgroundColor:"#FFF",borderColor:"#CCC",color:"#444"});break;case"warning":this.$bar.css({backgroundColor:"#FFEAA8",borderColor:"#FFC237",color:"#826200"}),this.$buttons.css({borderTop:"1px solid #FFC237"});break;case"error":this.$bar.css({backgroundColor:"red",borderColor:"darkred",color:"#FFF"}),this.$message.css({fontWeight:"bold"}),this.$buttons.css({borderTop:"1px solid darkred"});break;case"information":this.$bar.css({backgroundColor:"#57B7E2",borderColor:"#0B90C4",color:"#FFF"}),this.$buttons.css({borderTop:"1px solid #0B90C4"});break;case"success":this.$bar.css({backgroundColor:"lightgreen",borderColor:"#50C24E",color:"darkgreen"}),this.$buttons.css({borderTop:"1px solid #50C24E"});break;default:this.$bar.css({backgroundColor:"#FFF",borderColor:"#CCC",color:"#444"})}},callback:{onShow:function(){a.noty.themes.defaultTheme.helpers.borderFix.apply(this)},onClose:function(){a.noty.themes.defaultTheme.helpers.borderFix.apply(this)}}}}(jQuery);

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
			var url = '';
			if (this[AjaxResponse.keys.REDIRECT_URL] === AjaxResponse.RELOAD_MARK) {
				url = location.href;
			} else {
				url = $("<div/>").html(this[AjaxResponse.keys.REDIRECT_URL]).text();
			}
			return url.trim();
		};
		this.getGoToURL = function getGoToURL() {
			var url = '';
			if (this[AjaxResponse.keys.GOTO_URL] === AjaxResponse.RELOAD_MARK) {
				url = location.href;
			} else {
				url = $("<div/>").html(this[AjaxResponse.keys.GOTO_URL]).text();
			}
			return url.trim();
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
		VALIDATE_FLAG		: '__validateFlag',
		VALIDATE_MESSAGES 	: '__validateMessages',
		MESSAGE 			: '__message',
		MESSAGE_TYPE 		: '__messageType',
		STATUS				: '__status',
		REDIRECT_URL		: '__redirectURL',
		GOTO_URL			: '__goToURL',
		SEARCH_RESULT 		: '__searchResult',
		FETCHED_COUNT		: '__fetchedCount',
		RESULT_COUNT 		: '__resultCount'
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
	 *	reset page về 1
	 */
	AjaxSearchGrid.prototype.reload = function reload(isTriggeredByUser) {
		this.paginator.curPage = 1;
		this.load(isTriggeredByUser);
		return this;
	};
	
	AjaxSearchGrid.prototype.getRowData = function(rix) {
		return this.grid.getRowData(rix);
	};
	
	AjaxSearchGrid.prototype.bindEvent = function(jqSelector, eventType, handler) {
		return this.grid.bindEvent(jqSelector, eventType, handler);
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
		this._isUserMustWait	= true;
		this._isUploadForm		= false;
		this._requestParams 	= {};
		this._onBefore			= function() {return true};
		this._onSuccess			= function() {};
		this._onError			= function() {};
		this._onServerError		= function() {};
		this._onComplete		= function() {};
		this._isMergeWithGlobal	= true;
		this._storeKey = _store.length;
		
		var vars = {};
		vars.isRunning = false;
		_store.push(vars);
	}
	
	// METHODS
	Ajax.prototype.getIsRunning = function() {
		return _store[this._storeKey].isRunning;
	}
	Ajax.prototype.setMergeWithGlobal = function(isMerge) {
		this._isMergeWithGlobal = isMerge;
		return this;
	},
	Ajax.prototype.getMergeWithGlobal = function () {
		return this._isMergeWithGlobal;
	},
	Ajax.prototype.setForm = function (selector) {
		this.$form = $(selector);
		this._isUploadForm = this.$form.prop('enctype') === 'multipart/form-data';
		if (this._isUploadForm) {
			var iframeID = "i" + Math.random();
			var $uploadResponseTarget = 
				$('<iframe id="' + iframeID + '" name="' + iframeID + '" style="display: none;"></iframe>')
				.insertAfter(this.$form.get(0));
			this.$form.attr('target', iframeID);
			var self = this;
			$uploadResponseTarget.bind('load', function() {
				var data = $(this).contents().find('body').html();
				if (data.trim().length > 0) {
					try {
						self.success($.parseJSON(data));
					} catch (err) {
						self.error({}, '', err);
					}
					
					self.complete();
				}; 
			});
		}
		return this;
	};
	Ajax.prototype.getForm = function () {
		return this.$form;
	},
	Ajax.prototype.setLoading = function setLoading(selector, small) {
		if ($.isArray(selector)) {
			this._loadingTargets = selector;
		} else {
			this._loadingTargets = [{target:selector, isSmall:small}];
		}
		return this;
	};
	Ajax.prototype.getLoading = function () {
		return this._loadingTargets;
	},
	Ajax.prototype.setIsUserMustWait = function setIsUserMustWait(bool) {
		this._isUserMustWait = !!bool;
		return this;
	};
	Ajax.prototype.getIsUserMustWait = function () {
		return this.setIsUserMustWait;
	},
	Ajax.prototype.getIsUploadForm = function () {
		return this._isUploadForm;
	},
	Ajax.prototype.setURL = function setURL(url) {
		this.url = url;
		return this;
	};
	Ajax.prototype.getURL = function () {
		return this.url;
	};
	Ajax.prototype.setRequestParam = function setRequestParam(key, value) {
		this._requestParams[key] = value;
		return this;
	};
	Ajax.prototype.getRequestParams = function () {
		return this._requestParams;
	};
	Ajax.prototype.onBefore = function onBefore(callback) {
		this._onBefore = callback;
		return this;
	};
	Ajax.prototype.getOnBefore = function() {
		return this._onBefore;
	};
	Ajax.prototype.onSuccess = function onSuccess(callback) {
		this._onSuccess = callback;
		return this;
	};
	Ajax.prototype.getOnSuccess = function() {
		return this._onSuccess;
	};
	Ajax.prototype.onError = function onError(callback) {
		this._onError = callback;
		return this;
	};
	Ajax.prototype.getOnError = function() {
		return this._onError;
	};
	Ajax.prototype.onServerError = function onServerError(callback) {
		this._onServerError = callback;
		return this;
	};
	Ajax.prototype.getOnServerError = function() {
		return this._onServerError;
	};
	Ajax.prototype.onComplete = function onComplete(callback) {
		this._onComplete = callback;
		return this;
	};
	Ajax.prototype.getOnComplete = function() {
		return this._onComplete;
	};
	Ajax.prototype.triggerBy = function(selector, eventType, delegateTarget) {
		var	ajax = this;
		if ( arguments.length === 3 ) {
			$(delegateTarget).delegate(selector, eventType, function(ev) {
				ajax.run();
			});
		} else {
			$(selector).bind(eventType, function(ev) {
				ajax.run();
			});
		}
		return this;
	}
	Ajax.prototype.run = function run() {
		
		var hiddenInputs = []
		,	requestParams = this._requestParams
		;
		
		if (this._isMergeWithGlobal) {
			requestParams = $.extend({}, Ajax.global().getRequestParams(), requestParams);
		}
		
		var flag = this.before(this);
		if (flag === false) {
			return;
		}
		
		if (this._isUploadForm) {
			
			for (var key in requestParams) {
				var $hiddenInput = $('<input/>');
				$hiddenInput.prop('type', 'hidden');
				$hiddenInput.prop('name', key);
				$hiddenInput.val(requestParams[key]);
				this.$form.append($hiddenInput);
				hiddenInputs.push($hiddenInput.get(0));
			}
			
			// Also send disabled input value
			var $dis = this.$form.find(':input:disabled');
			$dis.prop('disabled', false);
			this.$form.get(0).submit();
			
			// Using timeout to avoid Google Chrome bug
			var self = this;
			setTimeout(
				function() {
					$dis.prop('disabled', true);
					self._wait();
				},
				1
			);
			
		} else {
			if (this.$form !== undefined) {
				for (var key in requestParams) {
					var $hiddenInput = $('<input/>');
					$hiddenInput.prop('type', 'hidden');
					$hiddenInput.prop('name', key);
					$hiddenInput.val(requestParams[key]);
					this.$form.append($hiddenInput);
					hiddenInputs.push($hiddenInput.get(0));
				}
				
				this.data = this.$form.serialize();
				
				if (this.url === '') {
					this.url = this.$form.prop('action');
				} 
			} else {
				for (var key in requestParams) {
					this.data[key] = requestParams[key];
				}
			}
			$.ajax(this);
		}
		
		$(hiddenInputs).remove();
		this._requestParams = {};
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
	Ajax.prototype._endWait = function _endWait(response) {
		
		var shouldEndWait = true;
		
		// Ajax success
		if (response !== undefined) {
			shouldEndWait = this._isUserMustWait
				&& (response.getRedirectURL() === '')
				&& (response.getGoToURL() === '')
			;
		}
		
		if (shouldEndWait) {
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
	
	Ajax.prototype.before = function($xhr) {
		
		var flag = true
		,	globalBefore = Ajax.global().getOnBefore()
		,	isGlobalBeforeFunction = $.isFunction(globalBefore)
		;
		
		if (this._isMergeWithGlobal) {
			if ( $.isFunction(this._onBefore) && isGlobalBeforeFunction ) {
				flag = this._onBefore(this, $xhr) && globalBefore.apply(this, [this, $xhr]);
			} else {
				flag = globalBefore.apply(this, [this, $xhr]);
			}
		} else {
			flag = this._onBefore(this, $xhr);
		}
		
		if (flag === false) {
			return false;
		}
		
		if ( this.getIsRunning() ) {
			return false;
		} else {
			_setIsRunning(this, true);
		}
		
		if ( !this._isUploadForm ) {
			this._wait();
		}
	},
	
	Ajax.prototype.success = function(response, textStatus, jqXHR) {
		
		$.extend(response, new AjaxResponse());
		this._endWait(response);
		
		if (response.isStatusOK()) {
			
			var url = response.getRedirectURL();
			
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
			} else if ((url = response.getGoToURL()) !== '') {
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
				if (this._isMergeWithGlobal) {
					this._onSuccess(response, textStatus, jqXHR);
					Ajax.global().getOnSuccess.apply(this, [response, textStatus, jqXHR]);
				} else {
					this._onSuccess(response, textStatus, jqXHR);
				}
			}
		} else {
			this.serverError(response);
		}
	};
	Ajax.prototype.error = function($xhr, textStatus, errorThrown) {
		this._endWait();
		
		if (textStatus === 'parsererror') {
			$error('Lỗi bất thường, hãy kiểm tra lại URL sau<br>' + this.url);
		}
		
		if (this._isMergeWithGlobal) {
			this._onError($xhr, textStatus, errorThrown);
			Ajax.global().getOnError.apply(this [$xhr, textStatus, errorThrown]);
		} else {
			this._onError($xhr, textStatus, errorThrown);
		}
	};
	Ajax.prototype.serverError = function(response) {
		this._endWait();
		
		$error(response.getMessage());
		
		if (this._isMergeWithGlobal) {
			this._onServerError(response);
			Ajax.global().getOnServerError().apply(this, [response]);
		} else {
			this._onServerError(response);
		}
	};
	Ajax.prototype.complete = function(xhr, testStatus) {
		if (this._isMergeWithGlobal) {
			this._onComplete(xhr, testStatus);
			Ajax.global().getOnComplete().apply(this, [xhr, testStatus]);
		} else {
			this._onComplete(xhr, testStatus);
		}
		_setIsRunning(this, false);
	};

	// Private vars
	var
		_store = []
	,	_setIsRunning = function(ajax, bool) {
			_store[ajax._storeKey].isRunning = bool;
		}
	,	_global = new Ajax()
	;
	
	// STATIC MEMBERS
	Ajax.SearchGrid = AjaxSearchGrid;
	
	// Factory method
	Ajax.forURL = function(url) {
		return new Ajax().setURL(url);
	};
	Ajax.global = function() { return _global };
	Ajax.isInstance = function(o) {
		return (o instanceof Ajax);
	};
	return Ajax;
})();
	
/**
 * Class paginator phục vụ phân trang cho ajax search
 * @param $holder
 * @param type
 * @param arrPageSize
 * @param isHidden
 * @returns {Paginator}
 */
var Paginator = (function() {
	
	function _construct(self, $holder, type, arrPageSize, onPageChange, onPageSizeChange, isHidden) {
		var  html = '';
		self.type = type || 1;
		self.isHidden = isHidden || false;
		self.arrPageSize = arrPageSize || Paginator.DEFAULT_PAGE_SIZES;
		self.pageSize = self.arrPageSize[0];
		
		switch (self.type) {
			case 3:
				html = '<div class="simple-paginator clearfix"><div class="result-meta">&nbsp;</div><div class="page-links"><a class="page-link prev disabled" href="#">Trước</a><a class="page-link next disabled" href="#">Tiếp</a></div></div>';
				break;
			default:
				html = '<div class="paginator clearfix"><div class="pagi-search-result"><label class="egov-label">0 kết quả</label></div><div class="pagi-controller clearfix"><span><label class="egov-label">Hàng trên trang</label><select class="page-size-selector"></select></span><span><label class="egov-label">Trang</label><select class="page-selector"><option value="1">1</option></select><input style="display:none;" type="text" class="page-inputor center"><label class="egov-label total-page"></label></span><span class="page-links"><a class="page-link first disabled" href="#1">Đầu</a><a class="page-link prev disabled" href="#">Trước</a><a class="page-link next disabled" href="#">Tiếp</a><a class="page-link last disabled" href="#">Cuối</a></span></div></div>';
		}
		
		self.$div = $(html);
		if ($holder.get(0).nodeName.toLowerCase() === 'table') {
			$holder.after(self.$div);
		} else {
			$holder.append(self.$div);
		}
		
		if (self.isHidden) {
			self.$div.css('display', 'none');
		}
		
		self.$pageLinks = self.$div.find('.page-links');
		self.$searchResult = self.$div.find('.pagi-search-result');
		self.$prevPage = self.$pageLinks.children('.prev');
		self.$nextPage = self.$pageLinks.children('.next');
		
		if (1 === self.type) {
			
			self.$pageSizeSel = self.$div.find('.page-size-selector');
			self.$pageSel = self.$div.find('.page-selector');
			self.$pageInput = self.$div.find('.page-inputor');
			self.$lastPage = self.$pageLinks.children('.last');
			self.$totalPage = self.$div.find('.total-page');
			
			var ippHtml = '';
			for (var i = 0;  i < self.arrPageSize.length; i ++) {
				ippHtml += '<option value="' + self.arrPageSize[i] + '">' + self.arrPageSize[i] + '</option>';
			}
			
			self.$pageSizeSel.html(ippHtml);
		}
		
		if (self.isHidden) {
			return;
		}
		
		// Click on page links
		self.$pageLinks.delegate('.page-link', 'click', function(event) {
			
			if ($(this).hasClass('disabled')) {
				
				// Không cho Ajax.SearchGrid chạy tiếp
				event.stopImmediatePropagation();
				
			} else {
				self.curPage = _getPageLinkNum($(this));
				onPageChange();
			}
			
			event.preventDefault();
		});
			
		if (1 === self.type) {
			
			// Select a page
			self.$pageSel.bind('change', function() {
				self.curPage = VarUtil.getInteger(this.value);
				onPageChange();
			});
			
			// Type a page and blur textbox
			self.$pageInput.bind('change',
				function() {
					var curPage = VarUtil.getInteger(this.value);
					if (curPage <= 0) {
						curPage = 1;
					} else if (curPage > self.pageCount) {
						curPage = self.pageCount;
					}
					self.curPage = curPage;
					onPageChange();
				}
			);
				
			// Type a page and press Enter
			self.$pageInput.bind('keydown',
				function(ev) {
					if (ev.which === 13) {
						
						// Triggering blur will auto trigger change if possible
						self.$pageInput.trigger('blur');
						ev.preventDefault();
					}
				}
			);
		
			// Select a page size option
			self.$pageSizeSel.bind('change', function(ev) {
				self.pageSize = VarUtil.getInteger(this.value);
				onPageSizeChange();
			});
		}
	}
	
	function _setPageLinkNum($a, num) {
		$a.attr('href', '#' + num);
	}
	
	function _getPageLinkNum($a) {
		return parseInt($a.attr('href').substring(1), 10);
	}
	
	function Paginator($holder, type, arrPageSize, onPageChange, onPageSizeChange, isHidden) {
		var self = this;
		self.type;
		self.isHidden;
		self.type;
		self.$pageSizeSel;
		self.$pageSel;
		self.$pageInput;
		self.$pageLinks;
		self.$totalPage;
		self.$div;
		self.$searchResult;
		self.$prevPage;
		self.$nextPage;
		self.$lastPage;
		self.resultCount = 0;
		self.fetchedCount = 0;
		self.arrPageSize;
		self.pageSize;
		self.curPage = 1;
		self.pageCount = 0;
		self.prevPage = 0;
		self.nextPage = 0;
		self.firstIndex = 0;
		self.lastIndex = 0;
		
		/**
		 * Get start, end for search
		 */
		self.getSearchParam = function getSearchParam() {
			
			// Phân trang bằng oracle ROWNUM được đánh số bắt đầu từ 1
			var _start = (this.curPage - 1) * this.pageSize + 1;
			var _end = _start + this.pageSize;
			
			return {start: _start, end: _end};
		};
		
		/**
		 * Refresh paginator dựa vào kết qủa search
		 * @param resultCount tổng số record search được
		 * @param fetchedCount tổng số record get về
		 */
		self.refresh = function refresh(resultCount, fetchedCount) {
			
			this.resultCount = parseInt(resultCount, 10);
			this.fetchedCount = parseInt(fetchedCount, 10);
			
			this.pageCount = parseInt(this.resultCount / this.pageSize)
							+ ((this.resultCount % this.pageSize) > 0 ? 1 : 0);
			
			this.pageCount = (this.pageCount === 0) ? 1 : this.pageCount;
			this.curPage = (this.curPage > this.pageCount) ? this.pageCount : this.curPage;
			
			this.prevPage = (this.curPage === 1) ? 1 : this.curPage - 1;
			this.nextPage = (this.curPage === this.pageCount) ? this.pageCount : this.curPage + 1;
			this.firstIndex = this.pageSize * (this.curPage - 1) + 1;
			this.lastIndex = this.firstIndex + this.fetchedCount - 1;
			
			if (!this.isHidden) {
				var message = '', pages, $page;
				
				if (1 === this.type) {
					
					if (this.pageCount < 201) {
						var html = '';
						for (var i = 1; i <= this.pageCount; i ++ ) {
							html += '<option value="' + i + '">' + i + '</option>';
						}
						
						this.$pageSel.html(html);
						this.$pageSel.val(this.curPage);
						this.$pageSel.show();
						this.$pageInput.hide();
					} else {
						
						this.$pageInput.val(this.curPage);
						this.$pageInput.width((((this.curPage + '').length * 8) + 20) + 'px');
						this.$pageSel.hide();
						this.$pageInput.show();
						
					}
					
					_setPageLinkNum(this.$lastPage, this.pageCount);
					
				}
				
				if (0 === this.fetchedCount) {
					message = '0 kết quả';
				} else {
					message = 'Hiển thị <strong>'
						+ this.firstIndex + '</strong> đến <strong>'
						+ this.lastIndex + '</strong> của <strong>' + + this.resultCount + '</strong> kết quả';
				}
				
				self.$totalPage.text(' của ' + self.pageCount);
				
				this.$searchResult.html(message);
				_setPageLinkNum(this.$prevPage, this.prevPage);
				_setPageLinkNum(this.$nextPage, this.nextPage);
				
				pages = this.$pageLinks.children();
				
				var i = pages.length;
				while(i --) {
					$page = $(pages.get(i));
					if (_getPageLinkNum($page) === this.curPage) {
						$page.addClass('disabled');
					} else {
						$page.removeClass('disabled');
					}
				}
			}
		};
		
		_construct(self, $holder, type, arrPageSize, onPageChange, onPageSizeChange, isHidden);
	}
	
	// STATIC MEMBERS
	Paginator.DEFAULT_PAGE_SIZES = [10, 20, 30, 50, 100];
	
	return Paginator;
	
})();

/**
 * @param cfg
 * 	{
 * 		required: grid
 * 		option:
 * 			isAllowAddRow,
 * 			addBtn,
 * 			deleteFn,
 * 			pkField,
 * 			afterAddRow,
 * 			afterFill,
 * 			deleteConfirmMessage
 * 	}
 * html custom attribute field
 * 		so thu tu: field="stt"
 * 		va cac field khac tu dinh nghia
 * html custom attribute fn
 * 		them row moi: fn="add"
 * 		xoa: fn="delete"
 */
var SimpleGrid = (function() {
	
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
		self.deleteConfirmMessage = cfg.deleteConfirmMessage || 'Chắc chắn muốn xóa bản ghi này?';
		
		_construct(self, cfg);
	}
	
	// METHODS
	SimpleGrid.prototype.fill = function(data, sttDauTien) {
		if ($.isArray(data)) {
			this.$tbody.empty();
			sttDauTien = sttDauTien || 1;
			
			for (var i = 0; i < data.length; i ++) {
				this.addRow(data[i], sttDauTien ++);
			}
			
			if ($.isFunction(this.config.afterFill)) {
				this.config.afterFill.apply(this.$elem, [data]);
			}
		}
	};
	
	SimpleGrid.prototype.getRowData = function(rix) {
		return $.data(this.$tbody.children().eq(rix).get(0), 'data');
	};
	
	SimpleGrid.prototype.addRow = function(data, stt) {
		
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
	};
	
	// Shortcut to jQuery delegate
	SimpleGrid.prototype.bindEvent = function(jqSelector, eventType, handler) {
		this.$elem.delegate(jqSelector, eventType, handler);
		return this;
	};
	
	// STATIC
	SimpleGrid.FIELD_PK = 'id';
	SimpleGrid.fill = function(gridSelector, data) {
		new SimpleGrid({grid: gridSelector}).fill(data);
	};
	
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
				$addBtn = $('<a fn="add" class="button btn-16 add-btn" href="#" title="Thêm hàng mới">&nbsp;</a>');
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
	
	return SimpleGrid;
	
})(); 
	
/** 
 * common onPageLoad tasks
 * @author hoangtrung.nguyen
 */
$(document).ready(function runCmonOnPageLoadTasks() {
	
	window.SCREEN_LOADING = $('<div id="_screen_loading" class="loading" style="display: none;">&nbsp;</div>').appendTo(document.body);
	
	$('select').each(function() {
		var $this = $(this), $df;
		$df = $this.find('option.default');
		if ($df.length === 0) {
			$df = $this.find('option:selected');
		}
		if ($df.length === 0) {
			$df = $this.find('option:first');
		}
		
		if (!$df.hasClass('default')) {
			$df.addClass('default');
		}
		
		this.$defaultOption = $df;
	});
	
	$('[prevent-submit-on-textbox-enter-key]')
		.delegate('input[type="text"]', 'keydown', function(ev) {
		if (ev.which === 13) {
			ev.preventDefault();
		}
	});
	
	$(document.body)
		.delegate('[disabled-by-script]', 'keydown mousedown', function(ev) {
			ev.preventDefault();
		});
		
	$('[disabled-by-script]').addClass('disabled');
});

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

/** 
 * @author unitech.trungnnh
 * define jquery plugins
 */
(function defineCmon$Plugins($) {
	
	// Ajax also send disabled input value
	var orgSerialize = $.fn.serialize;
	$.fn.serialize = function() {
		var $dis = this.find(':input:disabled');
		$dis.prop('disabled', false);
		var result = orgSerialize.apply(this);
		$dis.prop('disabled', true);
		return result;
	};
	
	var orgFocus = $.fn.focus;
	$.fn.focus = function(agr1, agr2) {
		var ui = $.data(this.get(0), 'ui')
		,	agrs = []
		;
		if (agr1 !== undefined) {
			agrs.push(agr1);
		}
		if (agr2 !== undefined) {
			agrs.push(agr2);
		}
		if (ui === undefined) {
			orgFocus.apply(this, agrs);
		} else {
			orgFocus.apply($(ui), agrs);
		}
		return this;
	};
	
	$.fn.fillData = function fillData(data) {
		return this.each(function() {
			DataFiller.fill(this, data);
		});
	};
	
	$.fn.resetOptionHTML = function resetOptionHTML() {
		return this.each(function() {
			if (this.$defaultOption.length) {
				$(this).empty().append(this.$defaultOption);
			}
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
	
	/**
	 * Print a div
	 * @author trungnnh
	 * Khong the goi print ngay sau khi load new window, vi` chrome co' van' de` :v
	 */
	$.fn.print = function print(cssURLArr, printDocReadyCallback, isLandspace) {
		var $srcDiv = this.eq(0)
		, wHeight = $(window).height()
		, newWin, newDoc, printed = false;
		
		wHeight = (wHeight < 675) ? 675 : wHeight;
		newWin = open(
			'',
			'',
			'height=' + wHeight + ',' +
			'width=' + $srcDiv.width() + ',' +
			'top=0,' +
			'resizable=no,' +
			'scrollbars=yes,' +
			'location=no,' +
			'status=no,' +
			'titlebar=no,' +
			'toolbar=no,' +
			'menubar=yes'
		);
		newDoc = newWin.document;
		newDoc.open();
		newDoc.write(getTopDeclStr());
		newDoc.write('<head>');
		newDoc.write('<meta http-equiv="Content-Type" content="text/html; charset=utf-8">');
		
		// Xóa ?v=Math.random() khi release sản phẩm
		for (var i = 0; i < cssURLArr.length; i++) {
			newDoc.write('<link type="text/css" rel="stylesheet" href="'
				+ cssURLArr[i] + '?v=' + Math.random() + '">');
		}
		
		// not crossbrowser, but fine with Chrome
		if (isLandspace) {
			newDoc.write('<style type="text/css"> @media print{@page {size: landscape}} </style>');
		} else {
			newDoc.write('<style type="text/css"> @media print{@page {size: portrait}} </style>');
		}
		
		newDoc.write('</head><body');
		newDoc.write(' id="' + $srcDiv.prop("id") + '" class="' + $srcDiv.prop("class") + ' print-body" style="' + $srcDiv.attr('style') + '">');
		newDoc.write($srcDiv.html());
		newDoc.write('<div id="_hint" style="position: fixed; z-index:10000; width: 100%; top: 20%; padding: 20px 0 ; opacity: 0.9; filter: alpha(opacity=90); text-align: center; font-size: 50px; font-weight:bold; box-shadow: 0 0 3px #CCCCCC; -moz-box-shadow: 0 0 3px #CCCCCC; -webkit-box-shadow: 0 0 3px #CCCCCC; border: 1px solid #CCCCCC; background-color: #FAFFCD;">');
		newDoc.write('Bấm Ctrl + P để in');
		newDoc.write('</div>');
		newDoc.write('</body></html>');
		newDoc.close();
		
		if ($.isFunction(printDocReadyCallback)) {
			printDocReadyCallback.apply(newDoc)
		}
		
		$(newDoc.body)
			.bind('click keydown', function() {
				$(newDoc.getElementById('_hint')).remove();
			});
		
		if (Liferay.Browser.isChrome()) {
			$(newWin)
				.bind('keydown', function(ev) {
					printed = (ev.which === 80 && ev.ctrlKey);
				})
				.bind('focus', function() {
					if (printed) {
						newWin.close();
					}
				});
		} else {
			$(newWin).bind('keydown', function(ev) {
				if (ev.which === 80 && ev.ctrlKey) {
					setTimeout(
						function() {
							newWin.close();
						},
						5
					);
				}
			});
		}
			
		newDoc.body.style.display = 'block';
		newDoc.body.style.overflow = 'visible';
		newWin.focus();
	};
	
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
	
	$.fn.isOverScreen = function() {
		
		if (!this.length) {
			return this;
		}
		
		var $screen = $(document.documentElement)
		,	screenHeight =  $screen.outerHeight(true)
		,	screenWidth = $screen.outerHeight(true)
		,	offset = this.offset();
		;
		
		
		return offset.top < 0
			|| offset.left < 0
			|| (offset.top + this.outerHeight(true)) > screenHeight
			|| (offset.width + this.outerWidth(true)) > screenWidth
		;

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
			
			if (window.SCREEN_LOADING && this === SCREEN_LOADING.get(0)) {
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
			if (window.SCREEN_LOADING && this === SCREEN_LOADING.get(0)) {
				SCREEN_LOADING.hide();
				return true;
			} 
			var $loading = $.data(this, '$loading');
			if ($loading) {
				$loading.hide();
			}
		});
	};
	
	$.fn.scrollToMe = function scrollToMe(callback) {
		if (!this.length) {
			return this;
		}
		
		var $elem = this.eq(0)
		,	ui = $.data(this.get(0), 'ui')
		;
		
		if (ui !== undefined) {
			$elem = $(ui);
		}
		
		if (!$elem.is(':visible')) {
			var ui = $.data(this.get(0), 'ui');
			if (ui !== undefined) {
				$elem = $(ui);
			}
		}
		
		return $('html, body').animate(
			{ scrollTop: $elem.offset().top - 20 },
			{ duration: 'fast', complete: callback}
		);
	};
	
	$.fn.highlight = function highlight() {
		var self = this;
		if (self.is(':visible')) {
			
			$.when(
				self.scrollToMe()
			).then(function() {
				
				var fadeToColor = '#C8EE00';
				var orgColor = self.css('background-color');
				
				try {
					self.animate({ backgroundColor: fadeToColor }, 300);
					self.animate({ backgroundColor: orgColor }, 300);
				} catch (e) {
					self.stop(true);
					self.css({ backgroundColor: fadeToColor });
					setTimeout(
						function() {
							self.css({ backgroundColor: orgColor });
						}
						, 400
					) ;
				}
			});
		}
		
		return self;
	};
	
	$.fn.isOverflow = function isOverflow () {
		var out = true, el = this.get(0);
		if (el !== undefined) {
			var curOverflow = el.style.overflow;
			if (!curOverflow || curOverflow === "visible")
				el.style.overflow = "hidden";
			var isOverflowing = el.clientWidth < el.scrollWidth || el.clientHeight < el.scrollHeight;
			el.style.overflow = curOverflow;
			return isOverflowing;
		}
		return out;
	};
	
	/**
	 * Dùng để get width in pixel được chỉ định sẵn bằng phần trăm trong css
	 */
	$.fn.widthSpecifiedByPercent = function() {
		var out = 0;
		if (this.length) {
			var $el, $elRoler, $parentRoler, $parent, specPercent;
			$el = this.eq(0);
			$parent = $el.parent();
			$elRoler = $('<div style="display:block !important; margin:0 !important; padding: !important; border: 0 none !important">&nbsp;</div>');
			$elRoler.prop('className', $el.prop('className'));
			$elRoler.attr('style', $el.attr('style'));
			$parentRoler = $('<div style="width:100px !important; display:block !important; margin:0 !important; padding: !important; border: 0 none !important""></div>');
			$parent.parent().append($parentRoler);
			$parentRoler.append($elRoler);
			specPercent = $elRoler.width();
			$parentRoler.remove();
			return ($parent.width() / 100) * specPercent;
		}
		return out;
	};
	
    $.fn.focusToEnd = function() {
        return this.each(function() {
            var v = $(this).val();
            $(this).focus().val("").val(v);
        });
    };
	
})(jQuery);

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

function isNumberKey(key, withPoint) {
	var out = (key >= 48 && key <= 57) || (key >= 96 && key <= 105);
	return withPoint ? (out || key === 190 || key === 110) : out;
}

function isValidDate(val) {
	
    // First check for the pattern
    if(!/^\d{1,2}\/\d{1,2}\/\d{4}$/.test(val))
        return false;

    // Parse the date parts to integers
    var parts = val.split("/");
    var day = parseInt(parts[0], 10);
    var month = parseInt(parts[1], 10);
    var year = parseInt(parts[2], 10);

    // Check the ranges of month and year
    if(year < 1000 || year > 3000 || month == 0 || month > 12)
        return false;

    var monthLength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

    // Adjust for leap years
    if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
        monthLength[1] = 29;

    // Check the range of the day
    return day > 0 && day <= monthLength[month - 1];
};

String.prototype.urlParam = function(key, val) {
    return this.valueOf() + '&' + key + '=' + val;
};
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
var VarUtil = {
	getInteger: function(val) {
		val = parseInt(val, 10);
		return !isFinite(val) ? 0 : val;
	},
	getString: function(val) {
		return (val === undefined || val === null)
			? ''
			: '' + val;
	},
	getFloat: function(val) {
		val = parseFloat(val);
		return !isFinite(val) ? 0.0 : val;
	}
}
Object.size = function(obj) {
    var size = 0;
    for (var key in obj) {
        if (obj.hasOwnProperty(key)) size++;
    }
    return size;
};
Object.getTheOnlyOne = function(obj) {
	for (var key in obj) {
		return [key, obj[key]];
	}
};