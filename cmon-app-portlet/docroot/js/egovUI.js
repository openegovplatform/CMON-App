/* Chosen v1.1.0 | (c) 2011-2013 by Harvest | MIT License, https://github.com/harvesthq/chosen/blob/master/LICENSE.md */
!function(){var a,AbstractChosen,Chosen,SelectParser,b,c={}.hasOwnProperty,d=function(a,b){function d(){this.constructor=a}for(var e in b)c.call(b,e)&&(a[e]=b[e]);return d.prototype=b.prototype,a.prototype=new d,a.__super__=b.prototype,a};SelectParser=function(){function SelectParser(){this.options_index=0,this.parsed=[]}return SelectParser.prototype.add_node=function(a){return"OPTGROUP"===a.nodeName.toUpperCase()?this.add_group(a):this.add_option(a)},SelectParser.prototype.add_group=function(a){var b,c,d,e,f,g;for(b=this.parsed.length,this.parsed.push({array_index:b,group:!0,label:this.escapeExpression(a.label),children:0,disabled:a.disabled}),f=a.childNodes,g=[],d=0,e=f.length;e>d;d++)c=f[d],g.push(this.add_option(c,b,a.disabled));return g},SelectParser.prototype.add_option=function(a,b,c){return"OPTION"===a.nodeName.toUpperCase()?(""!==a.text?(null!=b&&(this.parsed[b].children+=1),this.parsed.push({array_index:this.parsed.length,options_index:this.options_index,value:a.value,text:a.text,html:a.innerHTML,selected:a.selected,disabled:c===!0?c:a.disabled,group_array_index:b,classes:a.className,style:a.style.cssText})):this.parsed.push({array_index:this.parsed.length,options_index:this.options_index,empty:!0}),this.options_index+=1):void 0},SelectParser.prototype.escapeExpression=function(a){var b,c;return null==a||a===!1?"":/[\&\<\>\"\'\`]/.test(a)?(b={"<":"&lt;",">":"&gt;",'"':"&quot;","'":"&#x27;","`":"&#x60;"},c=/&(?!\w+;)|[\<\>\"\'\`]/g,a.replace(c,function(a){return b[a]||"&amp;"})):a},SelectParser}(),SelectParser.select_to_array=function(a){var b,c,d,e,f;for(c=new SelectParser,f=a.childNodes,d=0,e=f.length;e>d;d++)b=f[d],c.add_node(b);return c.parsed},AbstractChosen=function(){function AbstractChosen(a,b){this.form_field=a,this.options=null!=b?b:{},AbstractChosen.browser_is_supported()&&(this.is_multiple=this.form_field.multiple,this.set_default_text(),this.set_default_values(),this.setup(),this.set_up_html(),this.register_observers())}return AbstractChosen.prototype.set_default_values=function(){var a=this;return this.click_test_action=function(b){return a.test_active_click(b)},this.activate_action=function(b){return a.activate_field(b)},this.active_field=!1,this.mouse_on_container=!1,this.results_showing=!1,this.result_highlighted=null,this.allow_single_deselect=null!=this.options.allow_single_deselect&&null!=this.form_field.options[0]&&""===this.form_field.options[0].text?this.options.allow_single_deselect:!1,this.disable_search_threshold=this.options.disable_search_threshold||0,this.disable_search=this.options.disable_search||!1,this.enable_split_word_search=null!=this.options.enable_split_word_search?this.options.enable_split_word_search:!0,this.group_search=null!=this.options.group_search?this.options.group_search:!0,this.search_contains=this.options.search_contains||!1,this.single_backstroke_delete=null!=this.options.single_backstroke_delete?this.options.single_backstroke_delete:!0,this.max_selected_options=this.options.max_selected_options||1/0,this.inherit_select_classes=this.options.inherit_select_classes||!1,this.display_selected_options=null!=this.options.display_selected_options?this.options.display_selected_options:!0,this.display_disabled_options=null!=this.options.display_disabled_options?this.options.display_disabled_options:!0},AbstractChosen.prototype.set_default_text=function(){return this.default_text=this.form_field.getAttribute("data-placeholder")?this.form_field.getAttribute("data-placeholder"):this.is_multiple?this.options.placeholder_text_multiple||this.options.placeholder_text||AbstractChosen.default_multiple_text:this.options.placeholder_text_single||this.options.placeholder_text||AbstractChosen.default_single_text,this.results_none_found=this.form_field.getAttribute("data-no_results_text")||this.options.no_results_text||AbstractChosen.default_no_result_text},AbstractChosen.prototype.mouse_enter=function(){return this.mouse_on_container=!0},AbstractChosen.prototype.mouse_leave=function(){return this.mouse_on_container=!1},AbstractChosen.prototype.input_focus=function(){var a=this;if(this.is_multiple){if(!this.active_field)return setTimeout(function(){return a.container_mousedown()},50)}else if(!this.active_field)return this.activate_field()},AbstractChosen.prototype.input_blur=function(){var a=this;return this.mouse_on_container?void 0:(this.active_field=!1,setTimeout(function(){return a.blur_test()},100))},AbstractChosen.prototype.results_option_build=function(a){var b,c,d,e,f;for(b="",f=this.results_data,d=0,e=f.length;e>d;d++)c=f[d],b+=c.group?this.result_add_group(c):this.result_add_option(c),(null!=a?a.first:void 0)&&(c.selected&&this.is_multiple?this.choice_build(c):c.selected&&!this.is_multiple&&this.single_set_selected_text(c.text));return b},AbstractChosen.prototype.result_add_option=function(a){var b,c;return a.search_match?this.include_option_in_results(a)?(b=[],a.disabled||a.selected&&this.is_multiple||b.push("active-result"),!a.disabled||a.selected&&this.is_multiple||b.push("disabled-result"),a.selected&&b.push("result-selected"),null!=a.group_array_index&&b.push("group-option"),""!==a.classes&&b.push(a.classes),c=document.createElement("li"),c.className=b.join(" "),c.style.cssText=a.style,c.setAttribute("data-option-array-index",a.array_index),c.innerHTML=a.search_text,this.outerHTML(c)):"":""},AbstractChosen.prototype.result_add_group=function(a){var b;return a.search_match||a.group_match?a.active_options>0?(b=document.createElement("li"),b.className="group-result",b.innerHTML=a.search_text,this.outerHTML(b)):"":""},AbstractChosen.prototype.results_update_field=function(){return this.set_default_text(),this.is_multiple||this.results_reset_cleanup(),this.result_clear_highlight(),this.results_build(),this.results_showing?this.winnow_results():void 0},AbstractChosen.prototype.reset_single_select_options=function(){var a,b,c,d,e;for(d=this.results_data,e=[],b=0,c=d.length;c>b;b++)a=d[b],a.selected?e.push(a.selected=!1):e.push(void 0);return e},AbstractChosen.prototype.results_toggle=function(){return this.results_showing?this.results_hide():this.results_show()},AbstractChosen.prototype.results_search=function(){return this.results_showing?this.winnow_results():this.results_show()},AbstractChosen.prototype.winnow_results=function(){var a,b,c,d,e,f,g,h,i,j,k,l,m;for(this.no_results_clear(),e=0,g=this.get_search_text(),a=g.replace(/[-[\]{}()*+?.,\\^$|#\s]/g,"\\$&"),d=this.search_contains?"":"^",c=new RegExp(d+a,"i"),j=new RegExp(a,"i"),m=this.results_data,k=0,l=m.length;l>k;k++)b=m[k],b.search_match=!1,f=null,this.include_option_in_results(b)&&(b.group&&(b.group_match=!1,b.active_options=0),null!=b.group_array_index&&this.results_data[b.group_array_index]&&(f=this.results_data[b.group_array_index],0===f.active_options&&f.search_match&&(e+=1),f.active_options+=1),(!b.group||this.group_search)&&(b.search_text=b.group?b.label:b.html,b.search_match=this.search_string_match(b.search_text,c),b.search_match&&!b.group&&(e+=1),b.search_match?(g.length&&(h=b.search_text.search(j),i=b.search_text.substr(0,h+g.length)+"</em>"+b.search_text.substr(h+g.length),b.search_text=i.substr(0,h)+"<em>"+i.substr(h)),null!=f&&(f.group_match=!0)):null!=b.group_array_index&&this.results_data[b.group_array_index].search_match&&(b.search_match=!0)));return this.result_clear_highlight(),1>e&&g.length?(this.update_results_content(""),this.no_results(g)):(this.update_results_content(this.results_option_build()),this.winnow_results_set_highlight())},AbstractChosen.prototype.search_string_match=function(a,b){var c,d,e,f;if(b.test(a))return!0;if(this.enable_split_word_search&&(a.indexOf(" ")>=0||0===a.indexOf("["))&&(d=a.replace(/\[|\]/g,"").split(" "),d.length))for(e=0,f=d.length;f>e;e++)if(c=d[e],b.test(c))return!0},AbstractChosen.prototype.choices_count=function(){var a,b,c,d;if(null!=this.selected_option_count)return this.selected_option_count;for(this.selected_option_count=0,d=this.form_field.options,b=0,c=d.length;c>b;b++)a=d[b],a.selected&&(this.selected_option_count+=1);return this.selected_option_count},AbstractChosen.prototype.choices_click=function(a){return a.preventDefault(),this.results_showing||this.is_disabled?void 0:this.results_show()},AbstractChosen.prototype.keyup_checker=function(a){var b,c;switch(b=null!=(c=a.which)?c:a.keyCode,this.search_field_scale(),b){case 8:if(this.is_multiple&&this.backstroke_length<1&&this.choices_count()>0)return this.keydown_backstroke();if(!this.pending_backstroke)return this.result_clear_highlight(),this.results_search();break;case 13:if(a.preventDefault(),this.results_showing)return this.result_select(a);break;case 27:return this.results_showing&&this.results_hide(),!0;case 9:case 38:case 40:case 16:case 91:case 17:break;default:return this.results_search()}},AbstractChosen.prototype.clipboard_event_checker=function(){var a=this;return setTimeout(function(){return a.results_search()},50)},AbstractChosen.prototype.container_width=function(){return null!=this.options.width?this.options.width:""+this.form_field.offsetWidth+"px"},AbstractChosen.prototype.include_option_in_results=function(a){return this.is_multiple&&!this.display_selected_options&&a.selected?!1:!this.display_disabled_options&&a.disabled?!1:a.empty?!1:!0},AbstractChosen.prototype.search_results_touchstart=function(a){return this.touch_started=!0,this.search_results_mouseover(a)},AbstractChosen.prototype.search_results_touchmove=function(a){return this.touch_started=!1,this.search_results_mouseout(a)},AbstractChosen.prototype.search_results_touchend=function(a){return this.touch_started?this.search_results_mouseup(a):void 0},AbstractChosen.prototype.outerHTML=function(a){var b;return a.outerHTML?a.outerHTML:(b=document.createElement("div"),b.appendChild(a),b.innerHTML)},AbstractChosen.browser_is_supported=function(){return"Microsoft Internet Explorer"===window.navigator.appName?document.documentMode>=8:/iP(od|hone)/i.test(window.navigator.userAgent)?!1:/Android/i.test(window.navigator.userAgent)&&/Mobile/i.test(window.navigator.userAgent)?!1:!0},AbstractChosen.default_multiple_text="Select Some Options",AbstractChosen.default_single_text="Select an Option",AbstractChosen.default_no_result_text="No results match",AbstractChosen}(),a=jQuery,a.fn.extend({chosen:function(b){return AbstractChosen.browser_is_supported()?this.each(function(){var c,d;c=a(this),d=c.data("chosen"),"destroy"===b&&d?d.destroy():d||c.data("chosen",new Chosen(this,b))}):this}}),Chosen=function(c){function Chosen(){return b=Chosen.__super__.constructor.apply(this,arguments)}return d(Chosen,c),Chosen.prototype.setup=function(){return this.form_field_jq=a(this.form_field),this.current_selectedIndex=this.form_field.selectedIndex,this.is_rtl=this.form_field_jq.hasClass("chosen-rtl")},Chosen.prototype.set_up_html=function(){var b,c;return b=["chosen-container"],b.push("chosen-container-"+(this.is_multiple?"multi":"single")),this.inherit_select_classes&&this.form_field.className&&b.push(this.form_field.className),this.is_rtl&&b.push("chosen-rtl"),c={"class":b.join(" "),style:"width: "+this.container_width()+";",title:this.form_field.title},this.form_field.id.length&&(c.id=this.form_field.id.replace(/[^\w]/g,"_")+"_chosen"),this.container=a("<div />",c),this.is_multiple?this.container.html('<ul class="chosen-choices"><li class="search-field"><input type="text" value="'+this.default_text+'" class="default" autocomplete="off" style="width:25px;" /></li></ul><div class="chosen-drop"><ul class="chosen-results"></ul></div>'):this.container.html('<a class="chosen-single chosen-default" tabindex="-1"><span>'+this.default_text+'</span><div><b></b></div></a><div class="chosen-drop"><div class="chosen-search"><input type="text" autocomplete="off" /></div><ul class="chosen-results"></ul></div>'),this.form_field_jq.hide().after(this.container),this.dropdown=this.container.find("div.chosen-drop").first(),this.search_field=this.container.find("input").first(),this.search_results=this.container.find("ul.chosen-results").first(),this.search_field_scale(),this.search_no_results=this.container.find("li.no-results").first(),this.is_multiple?(this.search_choices=this.container.find("ul.chosen-choices").first(),this.search_container=this.container.find("li.search-field").first()):(this.search_container=this.container.find("div.chosen-search").first(),this.selected_item=this.container.find(".chosen-single").first()),this.results_build(),this.set_tab_index(),this.set_label_behavior(),this.form_field_jq.trigger("chosen:ready",{chosen:this})},Chosen.prototype.register_observers=function(){var a=this;return this.container.bind("mousedown.chosen",function(b){a.container_mousedown(b)}),this.container.bind("mouseup.chosen",function(b){a.container_mouseup(b)}),this.container.bind("mouseenter.chosen",function(b){a.mouse_enter(b)}),this.container.bind("mouseleave.chosen",function(b){a.mouse_leave(b)}),this.search_results.bind("mouseup.chosen",function(b){a.search_results_mouseup(b)}),this.search_results.bind("mouseover.chosen",function(b){a.search_results_mouseover(b)}),this.search_results.bind("mouseout.chosen",function(b){a.search_results_mouseout(b)}),this.search_results.bind("mousewheel.chosen DOMMouseScroll.chosen",function(b){a.search_results_mousewheel(b)}),this.search_results.bind("touchstart.chosen",function(b){a.search_results_touchstart(b)}),this.search_results.bind("touchmove.chosen",function(b){a.search_results_touchmove(b)}),this.search_results.bind("touchend.chosen",function(b){a.search_results_touchend(b)}),this.form_field_jq.bind("chosen:updated.chosen",function(b){a.results_update_field(b)}),this.form_field_jq.bind("chosen:activate.chosen",function(b){a.activate_field(b)}),this.form_field_jq.bind("chosen:open.chosen",function(b){a.container_mousedown(b)}),this.form_field_jq.bind("chosen:close.chosen",function(b){a.input_blur(b)}),this.search_field.bind("blur.chosen",function(b){a.input_blur(b)}),this.search_field.bind("keyup.chosen",function(b){a.keyup_checker(b)}),this.search_field.bind("keydown.chosen",function(b){a.keydown_checker(b)}),this.search_field.bind("focus.chosen",function(b){a.input_focus(b)}),this.search_field.bind("cut.chosen",function(b){a.clipboard_event_checker(b)}),this.search_field.bind("paste.chosen",function(b){a.clipboard_event_checker(b)}),this.is_multiple?this.search_choices.bind("click.chosen",function(b){a.choices_click(b)}):this.container.bind("click.chosen",function(a){a.preventDefault()})},Chosen.prototype.destroy=function(){return a(this.container[0].ownerDocument).unbind("click.chosen",this.click_test_action),this.search_field[0].tabIndex&&(this.form_field_jq[0].tabIndex=this.search_field[0].tabIndex),this.container.remove(),this.form_field_jq.removeData("chosen"),this.form_field_jq.show()},Chosen.prototype.search_field_disabled=function(){return this.is_disabled=this.form_field_jq[0].disabled,this.is_disabled?(this.container.addClass("chosen-disabled"),this.search_field[0].disabled=!0,this.is_multiple||this.selected_item.unbind("focus.chosen",this.activate_action),this.close_field()):(this.container.removeClass("chosen-disabled"),this.search_field[0].disabled=!1,this.is_multiple?void 0:this.selected_item.bind("focus.chosen",this.activate_action))},Chosen.prototype.container_mousedown=function(b){return this.is_disabled||(b&&"mousedown"===b.type&&!this.results_showing&&b.preventDefault(),null!=b&&a(b.target).hasClass("search-choice-close"))?void 0:(this.active_field?this.is_multiple||!b||a(b.target)[0]!==this.selected_item[0]&&!a(b.target).parents("a.chosen-single").length||(b.preventDefault(),this.results_toggle()):(this.is_multiple&&this.search_field.val(""),a(this.container[0].ownerDocument).bind("click.chosen",this.click_test_action),this.results_show()),this.activate_field())},Chosen.prototype.container_mouseup=function(a){return"ABBR"!==a.target.nodeName||this.is_disabled?void 0:this.results_reset(a)},Chosen.prototype.search_results_mousewheel=function(a){var b;return a.originalEvent&&(b=-a.originalEvent.wheelDelta||a.originalEvent.detail),null!=b?(a.preventDefault(),"DOMMouseScroll"===a.type&&(b=40*b),this.search_results.scrollTop(b+this.search_results.scrollTop())):void 0},Chosen.prototype.blur_test=function(){return!this.active_field&&this.container.hasClass("chosen-container-active")?this.close_field():void 0},Chosen.prototype.close_field=function(){return a(this.container[0].ownerDocument).unbind("click.chosen",this.click_test_action),this.active_field=!1,this.results_hide(),this.container.removeClass("chosen-container-active"),this.clear_backstroke(),this.show_search_field_default(),this.search_field_scale()},Chosen.prototype.activate_field=function(){return this.container.addClass("chosen-container-active"),this.active_field=!0,this.search_field.val(this.search_field.val()),this.search_field.focus()},Chosen.prototype.test_active_click=function(b){var c;return c=a(b.target).closest(".chosen-container"),c.length&&this.container[0]===c[0]?this.active_field=!0:this.close_field()},Chosen.prototype.results_build=function(){return this.parsing=!0,this.selected_option_count=null,this.results_data=SelectParser.select_to_array(this.form_field),this.is_multiple?this.search_choices.find("li.search-choice").remove():this.is_multiple||(this.single_set_selected_text(),this.disable_search||this.form_field.options.length<=this.disable_search_threshold?(this.search_field[0].readOnly=!0,this.container.addClass("chosen-container-single-nosearch")):(this.search_field[0].readOnly=!1,this.container.removeClass("chosen-container-single-nosearch"))),this.update_results_content(this.results_option_build({first:!0})),this.search_field_disabled(),this.show_search_field_default(),this.search_field_scale(),this.parsing=!1},Chosen.prototype.result_do_highlight=function(a){var b,c,d,e,f;if(a.length){if(this.result_clear_highlight(),this.result_highlight=a,this.result_highlight.addClass("highlighted"),d=parseInt(this.search_results.css("maxHeight"),10),f=this.search_results.scrollTop(),e=d+f,c=this.result_highlight.position().top+this.search_results.scrollTop(),b=c+this.result_highlight.outerHeight(),b>=e)return this.search_results.scrollTop(b-d>0?b-d:0);if(f>c)return this.search_results.scrollTop(c)}},Chosen.prototype.result_clear_highlight=function(){return this.result_highlight&&this.result_highlight.removeClass("highlighted"),this.result_highlight=null},Chosen.prototype.results_show=function(){return this.is_multiple&&this.max_selected_options<=this.choices_count()?(this.form_field_jq.trigger("chosen:maxselected",{chosen:this}),!1):(this.container.addClass("chosen-with-drop"),this.results_showing=!0,this.search_field.focus(),this.search_field.val(this.search_field.val()),this.winnow_results(),this.form_field_jq.trigger("chosen:showing_dropdown",{chosen:this}))},Chosen.prototype.update_results_content=function(a){return this.search_results.html(a)},Chosen.prototype.results_hide=function(){return this.results_showing&&(this.result_clear_highlight(),this.container.removeClass("chosen-with-drop"),this.form_field_jq.trigger("chosen:hiding_dropdown",{chosen:this})),this.results_showing=!1},Chosen.prototype.set_tab_index=function(){var a;return this.form_field.tabIndex?(a=this.form_field.tabIndex,this.form_field.tabIndex=-1,this.search_field[0].tabIndex=a):void 0},Chosen.prototype.set_label_behavior=function(){var b=this;return this.form_field_label=this.form_field_jq.parents("label"),!this.form_field_label.length&&this.form_field.id.length&&(this.form_field_label=a("label[for='"+this.form_field.id+"']")),this.form_field_label.length>0?this.form_field_label.bind("click.chosen",function(a){return b.is_multiple?b.container_mousedown(a):b.activate_field()}):void 0},Chosen.prototype.show_search_field_default=function(){return this.is_multiple&&this.choices_count()<1&&!this.active_field?(this.search_field.val(this.default_text),this.search_field.addClass("default")):(this.search_field.val(""),this.search_field.removeClass("default"))},Chosen.prototype.search_results_mouseup=function(b){var c;return c=a(b.target).hasClass("active-result")?a(b.target):a(b.target).parents(".active-result").first(),c.length?(this.result_highlight=c,this.result_select(b),this.search_field.focus()):void 0},Chosen.prototype.search_results_mouseover=function(b){var c;return c=a(b.target).hasClass("active-result")?a(b.target):a(b.target).parents(".active-result").first(),c?this.result_do_highlight(c):void 0},Chosen.prototype.search_results_mouseout=function(b){return a(b.target).hasClass("active-result")?this.result_clear_highlight():void 0},Chosen.prototype.choice_build=function(b){var c,d,e=this;return c=a("<li />",{"class":"search-choice"}).html("<span>"+b.html+"</span>"),b.disabled?c.addClass("search-choice-disabled"):(d=a("<a />",{"class":"search-choice-close","data-option-array-index":b.array_index}),d.bind("click.chosen",function(a){return e.choice_destroy_link_click(a)}),c.append(d)),this.search_container.before(c)},Chosen.prototype.choice_destroy_link_click=function(b){return b.preventDefault(),b.stopPropagation(),this.is_disabled?void 0:this.choice_destroy(a(b.target))},Chosen.prototype.choice_destroy=function(a){return this.result_deselect(a[0].getAttribute("data-option-array-index"))?(this.show_search_field_default(),this.is_multiple&&this.choices_count()>0&&this.search_field.val().length<1&&this.results_hide(),a.parents("li").first().remove(),this.search_field_scale()):void 0},Chosen.prototype.results_reset=function(){return this.reset_single_select_options(),this.form_field.options[0].selected=!0,this.single_set_selected_text(),this.show_search_field_default(),this.results_reset_cleanup(),this.form_field_jq.trigger("change"),this.active_field?this.results_hide():void 0},Chosen.prototype.results_reset_cleanup=function(){return this.current_selectedIndex=this.form_field.selectedIndex,this.selected_item.find("abbr").remove()},Chosen.prototype.result_select=function(a){var b,c;return this.result_highlight?(b=this.result_highlight,this.result_clear_highlight(),this.is_multiple&&this.max_selected_options<=this.choices_count()?(this.form_field_jq.trigger("chosen:maxselected",{chosen:this}),!1):(this.is_multiple?b.removeClass("active-result"):this.reset_single_select_options(),c=this.results_data[b[0].getAttribute("data-option-array-index")],c.selected=!0,this.form_field.options[c.options_index].selected=!0,this.selected_option_count=null,this.is_multiple?this.choice_build(c):this.single_set_selected_text(c.text),(a.metaKey||a.ctrlKey)&&this.is_multiple||this.results_hide(),this.search_field.val(""),(this.is_multiple||this.form_field.selectedIndex!==this.current_selectedIndex)&&this.form_field_jq.trigger("change",{selected:this.form_field.options[c.options_index].value}),this.current_selectedIndex=this.form_field.selectedIndex,this.search_field_scale())):void 0},Chosen.prototype.single_set_selected_text=function(a){return null==a&&(a=this.default_text),a===this.default_text?this.selected_item.addClass("chosen-default"):(this.single_deselect_control_build(),this.selected_item.removeClass("chosen-default")),this.selected_item.find("span").text(a)},Chosen.prototype.result_deselect=function(a){var b;return b=this.results_data[a],this.form_field.options[b.options_index].disabled?!1:(b.selected=!1,this.form_field.options[b.options_index].selected=!1,this.selected_option_count=null,this.result_clear_highlight(),this.results_showing&&this.winnow_results(),this.form_field_jq.trigger("change",{deselected:this.form_field.options[b.options_index].value}),this.search_field_scale(),!0)},Chosen.prototype.single_deselect_control_build=function(){return this.allow_single_deselect?(this.selected_item.find("abbr").length||this.selected_item.find("span").first().after('<abbr class="search-choice-close"></abbr>'),this.selected_item.addClass("chosen-single-with-deselect")):void 0},Chosen.prototype.get_search_text=function(){return this.search_field.val()===this.default_text?"":a("<div/>").text(a.trim(this.search_field.val())).html()},Chosen.prototype.winnow_results_set_highlight=function(){var a,b;return b=this.is_multiple?[]:this.search_results.find(".result-selected.active-result"),a=b.length?b.first():this.search_results.find(".active-result").first(),null!=a?this.result_do_highlight(a):void 0},Chosen.prototype.no_results=function(b){var c;return c=a('<li class="no-results">'+this.results_none_found+' "<span></span>"</li>'),c.find("span").first().html(b),this.search_results.append(c),this.form_field_jq.trigger("chosen:no_results",{chosen:this})},Chosen.prototype.no_results_clear=function(){return this.search_results.find(".no-results").remove()},Chosen.prototype.keydown_arrow=function(){var a;return this.results_showing&&this.result_highlight?(a=this.result_highlight.nextAll("li.active-result").first())?this.result_do_highlight(a):void 0:this.results_show()},Chosen.prototype.keyup_arrow=function(){var a;return this.results_showing||this.is_multiple?this.result_highlight?(a=this.result_highlight.prevAll("li.active-result"),a.length?this.result_do_highlight(a.first()):(this.choices_count()>0&&this.results_hide(),this.result_clear_highlight())):void 0:this.results_show()},Chosen.prototype.keydown_backstroke=function(){var a;return this.pending_backstroke?(this.choice_destroy(this.pending_backstroke.find("a").first()),this.clear_backstroke()):(a=this.search_container.siblings("li.search-choice").last(),a.length&&!a.hasClass("search-choice-disabled")?(this.pending_backstroke=a,this.single_backstroke_delete?this.keydown_backstroke():this.pending_backstroke.addClass("search-choice-focus")):void 0)},Chosen.prototype.clear_backstroke=function(){return this.pending_backstroke&&this.pending_backstroke.removeClass("search-choice-focus"),this.pending_backstroke=null},Chosen.prototype.keydown_checker=function(a){var b,c;switch(b=null!=(c=a.which)?c:a.keyCode,this.search_field_scale(),8!==b&&this.pending_backstroke&&this.clear_backstroke(),b){case 8:this.backstroke_length=this.search_field.val().length;break;case 9:this.results_showing&&!this.is_multiple&&this.result_select(a),this.mouse_on_container=!1;break;case 13:a.preventDefault();break;case 38:a.preventDefault(),this.keyup_arrow();break;case 40:a.preventDefault(),this.keydown_arrow()}},Chosen.prototype.search_field_scale=function(){var b,c,d,e,f,g,h,i,j;if(this.is_multiple){for(d=0,h=0,f="position:absolute; left: -1000px; top: -1000px; display:none;",g=["font-size","font-style","font-weight","font-family","line-height","text-transform","letter-spacing"],i=0,j=g.length;j>i;i++)e=g[i],f+=e+":"+this.search_field.css(e)+";";return b=a("<div />",{style:f}),b.text(this.search_field.val()),a("body").append(b),h=b.width()+25,b.remove(),c=this.container.outerWidth(),h>c-10&&(h=c-10),this.search_field.css({width:h+"px"})}},Chosen}(AbstractChosen)}.call(this);		
/* * jQuery UI Timepicker * */
(function($){function Timepicker(){this.debug=true;this._curInst=null;this._disabledInputs=[];this._timepickerShowing=false;this._inDialog=false;this._dialogClass="ui-timepicker-dialog";this._mainDivId="ui-timepicker-div";this._inlineClass="ui-timepicker-inline";this._currentClass="ui-timepicker-current";this._dayOverClass="ui-timepicker-days-cell-over";this.regional=[];this.regional[""]={hourText:"Hour",minuteText:"Minute",amPmText:["AM","PM"],closeButtonText:"Done",nowButtonText:"Now",deselectButtonText:"Deselect"};this._defaults={showOn:"focus",button:null,showAnim:"fadeIn",showOptions:{},appendText:"",beforeShow:null,onSelect:null,onClose:null,timeSeparator:":",periodSeparator:" ",showPeriod:false,showPeriodLabels:true,showLeadingZero:true,showMinutesLeadingZero:true,altField:"",defaultTime:"now",myPosition:"left top",atPosition:"left bottom",onHourShow:null,onMinuteShow:null,hours:{starts:0,ends:23},minutes:{starts:0,ends:55,interval:5,manual:[]},rows:4,showHours:true,showMinutes:true,optionalMinutes:false,showCloseButton:false,showNowButton:false,showDeselectButton:false,maxTime:{hour:null,minute:null},minTime:{hour:null,minute:null}};$.extend(this._defaults,this.regional[""]);this.tpDiv=$('<div id="'+this._mainDivId+'" class="ui-timepicker ui-widget ui-helper-clearfix ui-corner-all " style="display: none"></div>')}function extendRemove(e,t){$.extend(e,t);for(var n in t)if(t[n]==null||t[n]==undefined)e[n]=t[n];return e}$.extend($.ui,{timepicker:{version:"0.3.3"}});var PROP_NAME="timepicker",tpuuid=(new Date).getTime();$.extend(Timepicker.prototype,{markerClassName:"hasTimepicker",log:function(){if(this.debug)console.log.apply("",arguments)},_widgetTimepicker:function(){return this.tpDiv},setDefaults:function(e){extendRemove(this._defaults,e||{});return this},_attachTimepicker:function(target,settings){var inlineSettings=null;for(var attrName in this._defaults){var attrValue=target.getAttribute("time:"+attrName);if(attrValue){inlineSettings=inlineSettings||{};try{inlineSettings[attrName]=eval(attrValue)}catch(err){inlineSettings[attrName]=attrValue}}}var nodeName=target.nodeName.toLowerCase();var inline=nodeName=="div"||nodeName=="span";if(!target.id){this.uuid+=1;target.id="tp"+this.uuid}var inst=this._newInst($(target),inline);inst.settings=$.extend({},settings||{},inlineSettings||{});if(nodeName=="input"){this._connectTimepicker(target,inst);this._setTimeFromField(inst)}else if(inline){this._inlineTimepicker(target,inst)}},_newInst:function(e,t){var n=e[0].id.replace(/([^A-Za-z0-9_-])/g,"\\\\$1");return{id:n,input:e,inline:t,tpDiv:!t?this.tpDiv:$('<div class="'+this._inlineClass+' ui-timepicker ui-widget  ui-helper-clearfix"></div>')}},_connectTimepicker:function(e,t){var n=$(e);t.append=$([]);t.trigger=$([]);if(n.hasClass(this.markerClassName)){return}this._attachments(n,t);n.addClass(this.markerClassName).keydown(this._doKeyDown).keyup(this._doKeyUp).bind("setData.timepicker",function(e,n,r){t.settings[n]=r}).bind("getData.timepicker",function(e,n){return this._get(t,n)});$.data(e,PROP_NAME,t)},_doKeyDown:function(e){var t=$.timepicker._getInst(e.target);var n=true;t._keyEvent=true;if($.timepicker._timepickerShowing){switch(e.keyCode){case 9:$.timepicker._hideTimepicker();n=false;break;case 13:$.timepicker._updateSelectedValue(t);$.timepicker._hideTimepicker();return false;break;case 27:$.timepicker._hideTimepicker();break;default:n=false}}else if(e.keyCode==36&&e.ctrlKey){$.timepicker._showTimepicker(this)}else{n=false}if(n){e.preventDefault();e.stopPropagation()}},_doKeyUp:function(e){var t=$.timepicker._getInst(e.target);$.timepicker._setTimeFromField(t);$.timepicker._updateTimepicker(t)},_attachments:function(e,t){var n=this._get(t,"appendText");var r=this._get(t,"isRTL");if(t.append){t.append.remove()}if(n){t.append=$('<span class="'+this._appendClass+'">'+n+"</span>");e[r?"before":"after"](t.append)}e.unbind("focus.timepicker",this._showTimepicker);e.unbind("click.timepicker",this._adjustZIndex);if(t.trigger){t.trigger.remove()}var i=this._get(t,"showOn");if(i=="focus"||i=="both"){e.bind("focus.timepicker",this._showTimepicker);e.bind("click.timepicker",this._adjustZIndex)}if(i=="button"||i=="both"){var s=this._get(t,"button");if(s==null){s=$('<button class="ui-timepicker-trigger" type="button">...</button>');e.after(s)}$(s).bind("click.timepicker",function(){if($.timepicker._timepickerShowing&&$.timepicker._lastInput==e[0]){$.timepicker._hideTimepicker()}else if(!t.input.is(":disabled")){$.timepicker._showTimepicker(e[0])}return false})}},_inlineTimepicker:function(e,t){var n=$(e);if(n.hasClass(this.markerClassName))return;n.addClass(this.markerClassName).append(t.tpDiv).bind("setData.timepicker",function(e,n,r){t.settings[n]=r}).bind("getData.timepicker",function(e,n){return this._get(t,n)});$.data(e,PROP_NAME,t);this._setTimeFromField(t);this._updateTimepicker(t);t.tpDiv.show()},_adjustZIndex:function(e){e=e.target||e;var t=$.timepicker._getInst(e);t.tpDiv.css("zIndex",$.timepicker._getZIndex(e)+1)},_showTimepicker:function(e){e=e.target||e;if(e.nodeName.toLowerCase()!="input"){e=$("input",e.parentNode)[0]}if($.timepicker._isDisabledTimepicker(e)||$.timepicker._lastInput==e){return}$.timepicker._hideTimepicker();var t=$.timepicker._getInst(e);if($.timepicker._curInst&&$.timepicker._curInst!=t){$.timepicker._curInst.tpDiv.stop(true,true)}var n=$.timepicker._get(t,"beforeShow");extendRemove(t.settings,n?n.apply(e,[e,t]):{});t.lastVal=null;$.timepicker._lastInput=e;$.timepicker._setTimeFromField(t);if($.timepicker._inDialog){e.value=""}if(!$.timepicker._pos){$.timepicker._pos=$.timepicker._findPos(e);$.timepicker._pos[1]+=e.offsetHeight}var r=false;$(e).parents().each(function(){r|=$(this).css("position")=="fixed";return!r});var i={left:$.timepicker._pos[0],top:$.timepicker._pos[1]};$.timepicker._pos=null;t.tpDiv.css({position:"absolute",display:"block",top:"-1000px"});$.timepicker._updateTimepicker(t);if(!t.inline&&typeof $.ui.position=="object"){t.tpDiv.position({of:t.input,my:$.timepicker._get(t,"myPosition"),at:$.timepicker._get(t,"atPosition"),collision:"flip"});var i=t.tpDiv.offset();$.timepicker._pos=[i.top,i.left]}t._hoursClicked=false;t._minutesClicked=false;i=$.timepicker._checkOffset(t,i,r);t.tpDiv.css({position:$.timepicker._inDialog&&$.blockUI?"static":r?"fixed":"absolute",display:"none",left:i.left+"px",top:i.top+"px"});if(!t.inline){var s=$.timepicker._get(t,"showAnim");var o=$.timepicker._get(t,"duration");var u=function(){$.timepicker._timepickerShowing=true;var e=$.timepicker._getBorders(t.tpDiv);t.tpDiv.find("iframe.ui-timepicker-cover").css({left:-e[0],top:-e[1],width:t.tpDiv.outerWidth(),height:t.tpDiv.outerHeight()})};$.timepicker._adjustZIndex(e);if($.effects&&$.effects[s]){t.tpDiv.show(s,$.timepicker._get(t,"showOptions"),o,u)}else{t.tpDiv.show(s?o:null,u)}if(!s||!o){u()}if(t.input.is(":visible")&&!t.input.is(":disabled")){t.input.focus()}$.timepicker._curInst=t}},_getZIndex:function(e){var t=$(e);var n=0;var r,i;while(t.length&&t[0]!==document){r=t.css("position");if(r==="absolute"||r==="relative"||r==="fixed"){i=parseInt(t.css("zIndex"),10);if(!isNaN(i)&&i!==0){if(i>n){n=i}}}t=t.parent()}return n},_refreshTimepicker:function(e){var t=this._getInst(e);if(t){this._updateTimepicker(t)}},_updateTimepicker:function(e){e.tpDiv.empty().append(this._generateHTML(e));this._rebindDialogEvents(e)},_rebindDialogEvents:function(e){var t=$.timepicker._getBorders(e.tpDiv),n=this;e.tpDiv.find("iframe.ui-timepicker-cover").css({left:-t[0],top:-t[1],width:e.tpDiv.outerWidth(),height:e.tpDiv.outerHeight()}).end().find(".ui-timepicker-minute-cell").unbind().bind("click",{fromDoubleClick:false},$.proxy($.timepicker.selectMinutes,this)).bind("dblclick",{fromDoubleClick:true},$.proxy($.timepicker.selectMinutes,this)).end().find(".ui-timepicker-hour-cell").unbind().bind("click",{fromDoubleClick:false},$.proxy($.timepicker.selectHours,this)).bind("dblclick",{fromDoubleClick:true},$.proxy($.timepicker.selectHours,this)).end().find(".ui-timepicker td a").unbind().bind("mouseout",function(){$(this).removeClass("ui-state-hover");if(this.className.indexOf("ui-timepicker-prev")!=-1)$(this).removeClass("ui-timepicker-prev-hover");if(this.className.indexOf("ui-timepicker-next")!=-1)$(this).removeClass("ui-timepicker-next-hover")}).bind("mouseover",function(){if(!n._isDisabledTimepicker(e.inline?e.tpDiv.parent()[0]:e.input[0])){$(this).parents(".ui-timepicker-calendar").find("a").removeClass("ui-state-hover");$(this).addClass("ui-state-hover");if(this.className.indexOf("ui-timepicker-prev")!=-1)$(this).addClass("ui-timepicker-prev-hover");if(this.className.indexOf("ui-timepicker-next")!=-1)$(this).addClass("ui-timepicker-next-hover")}}).end().find("."+this._dayOverClass+" a").trigger("mouseover").end().find(".ui-timepicker-now").bind("click",function(e){$.timepicker.selectNow(e)}).end().find(".ui-timepicker-deselect").bind("click",function(e){$.timepicker.deselectTime(e)}).end().find(".ui-timepicker-close").bind("click",function(e){$.timepicker._hideTimepicker()}).end()},_generateHTML:function(e){var t,n,r,i,s,o,u="",a=this._get(e,"showPeriod")==true,f=this._get(e,"showPeriodLabels")==true,l=this._get(e,"showLeadingZero")==true,c=this._get(e,"showHours")==true,h=this._get(e,"showMinutes")==true,p=this._get(e,"amPmText"),d=this._get(e,"rows"),v=0,m=0,g=0,y=0,b=0,w=0,E=Array(),S=this._get(e,"hours"),x=null,T=0,N=this._get(e,"hourText"),C=this._get(e,"showCloseButton"),k=this._get(e,"closeButtonText"),L=this._get(e,"showNowButton"),A=this._get(e,"nowButtonText"),O=this._get(e,"showDeselectButton"),M=this._get(e,"deselectButtonText"),_=C||L||O;for(t=S.starts;t<=S.ends;t++){E.push(t)}x=Math.ceil(E.length/d);if(f){for(T=0;T<E.length;T++){if(E[T]<12){g++}else{y++}}T=0;v=Math.floor(g/E.length*d);m=Math.floor(y/E.length*d);if(d!=v+m){if(g&&(!y||!v||m&&g/v>=y/m)){v++}else{m++}}b=Math.min(v,1);w=v+1;if(v==0){x=Math.ceil(y/m)}else if(m==0){x=Math.ceil(g/v)}else{x=Math.ceil(Math.max(g/v,y/m))}}s='<table class="ui-timepicker-table ui-widget-content ui-corner-all"><tr>';if(c){s+='<td class="ui-timepicker-hours">'+'<div class="ui-timepicker-title ui-widget-header ui-helper-clearfix ui-corner-all">'+N+"</div>"+'<table class="ui-timepicker">';for(r=1;r<=d;r++){s+="<tr>";if(r==b&&f){s+='<th rowspan="'+v.toString()+'" class="periods" scope="row">'+p[0]+"</th>"}if(r==w&&f){s+='<th rowspan="'+m.toString()+'" class="periods" scope="row">'+p[1]+"</th>"}for(i=1;i<=x;i++){if(f&&r<w&&E[T]>=12){s+=this._generateHTMLHourCell(e,undefined,a,l)}else{s+=this._generateHTMLHourCell(e,E[T],a,l);T++}}s+="</tr>"}s+="</table>"+"</td>"}if(h){s+='<td class="ui-timepicker-minutes">';s+=this._generateHTMLMinutes(e);s+="</td>"}s+="</tr>";if(_){var D='<tr><td colspan="3"><div class="ui-timepicker-buttonpane ui-widget-content">';if(L){D+='<button type="button" class="ui-timepicker-now ui-state-default ui-corner-all" '+' data-timepicker-instance-id="#'+e.id.replace(/\\\\/g,"\\")+'" >'+A+"</button>"}if(O){D+='<button type="button" class="ui-timepicker-deselect ui-state-default ui-corner-all" '+' data-timepicker-instance-id="#'+e.id.replace(/\\\\/g,"\\")+'" >'+M+"</button>"}if(C){D+='<button type="button" class="ui-timepicker-close ui-state-default ui-corner-all" '+' data-timepicker-instance-id="#'+e.id.replace(/\\\\/g,"\\")+'" >'+k+"</button>"}s+=D+"</div></td></tr>"}s+="</table>";return s},_updateMinuteDisplay:function(e){var t=this._generateHTMLMinutes(e);e.tpDiv.find("td.ui-timepicker-minutes").html(t);this._rebindDialogEvents(e)},_generateHTMLMinutes:function(e){var t,n,r="",s=this._get(e,"rows"),o=Array(),u=this._get(e,"minutes"),a=null,f=0,l=this._get(e,"showMinutesLeadingZero")==true,c=this._get(e,"onMinuteShow"),h=this._get(e,"minuteText");if(!u.starts){u.starts=0}if(!u.ends){u.ends=59}if(!u.manual){u.manual=[]}for(t=u.starts;t<=u.ends;t+=u.interval){o.push(t)}for(i=0;i<u.manual.length;i++){var p=u.manual[i];if(typeof p!="number"||p<0||p>59||$.inArray(p,o)>=0){continue}o.push(p)}o.sort(function(e,t){return e-t});a=Math.round(o.length/s+.49);if(c&&c.apply(e.input?e.input[0]:null,[e.hours,e.minutes])==false){for(f=0;f<o.length;f+=1){t=o[f];if(c.apply(e.input?e.input[0]:null,[e.hours,t])){e.minutes=t;break}}}r+='<div class="ui-timepicker-title ui-widget-header ui-helper-clearfix ui-corner-all">'+h+"</div>"+'<table class="ui-timepicker">';f=0;for(n=1;n<=s;n++){r+="<tr>";while(f<n*a){var t=o[f];var d="";if(t!==undefined){d=t<10&&l?"0"+t.toString():t.toString()}r+=this._generateHTMLMinuteCell(e,t,d);f++}r+="</tr>"}r+="</table>";return r},_generateHTMLHourCell:function(e,t,n,r){var i=t;if(t>12&&n){i=t-12}if(i==0&&n){i=12}if(i<10&&r){i="0"+i}var s="";var o=true;var u=this._get(e,"onHourShow");var a=this._get(e,"maxTime");var f=this._get(e,"minTime");if(t==undefined){s='<td><span class="ui-state-default ui-state-disabled">&nbsp;</span></td>';return s}if(u){o=u.apply(e.input?e.input[0]:null,[t])}if(o){if(!isNaN(parseInt(a.hour))&&t>a.hour)o=false;if(!isNaN(parseInt(f.hour))&&t<f.hour)o=false}if(o){s='<td class="ui-timepicker-hour-cell" data-timepicker-instance-id="#'+e.id.replace(/\\\\/g,"\\")+'" data-hour="'+t.toString()+'">'+'<a class="ui-state-default '+(t==e.hours?"ui-state-active":"")+'">'+i.toString()+"</a></td>"}else{s="<td>"+'<span class="ui-state-default ui-state-disabled '+(t==e.hours?" ui-state-active ":" ")+'">'+i.toString()+"</span>"+"</td>"}return s},_generateHTMLMinuteCell:function(e,t,n){var r="";var i=true;var s=e.hours;var o=this._get(e,"onMinuteShow");var u=this._get(e,"maxTime");var a=this._get(e,"minTime");if(o){i=o.apply(e.input?e.input[0]:null,[e.hours,t])}if(t==undefined){r='<td><span class="ui-state-default ui-state-disabled">&nbsp;</span></td>';return r}if(i&&s!==null){if(!isNaN(parseInt(u.hour))&&!isNaN(parseInt(u.minute))&&s>=u.hour&&t>u.minute)i=false;if(!isNaN(parseInt(a.hour))&&!isNaN(parseInt(a.minute))&&s<=a.hour&&t<a.minute)i=false}if(i){r='<td class="ui-timepicker-minute-cell" data-timepicker-instance-id="#'+e.id.replace(/\\\\/g,"\\")+'" data-minute="'+t.toString()+'" >'+'<a class="ui-state-default '+(t==e.minutes?"ui-state-active":"")+'" >'+n+"</a></td>"}else{r="<td>"+'<span class="ui-state-default ui-state-disabled" >'+n+"</span>"+"</td>"}return r},_destroyTimepicker:function(e){var t=$(e);var n=$.data(e,PROP_NAME);if(!t.hasClass(this.markerClassName)){return}var r=e.nodeName.toLowerCase();$.removeData(e,PROP_NAME);if(r=="input"){n.append.remove();n.trigger.remove();t.removeClass(this.markerClassName).unbind("focus.timepicker",this._showTimepicker).unbind("click.timepicker",this._adjustZIndex)}else if(r=="div"||r=="span")t.removeClass(this.markerClassName).empty()},_enableTimepicker:function(e){var t=$(e),n=t.attr("id"),r=$.data(e,PROP_NAME);if(!t.hasClass(this.markerClassName)){return}var i=e.nodeName.toLowerCase();if(i=="input"){e.disabled=false;var s=this._get(r,"button");$(s).removeClass("ui-state-disabled").disabled=false;r.trigger.filter("button").each(function(){this.disabled=false}).end()}else if(i=="div"||i=="span"){var o=t.children("."+this._inlineClass);o.children().removeClass("ui-state-disabled");o.find("button").each(function(){this.disabled=false})}this._disabledInputs=$.map(this._disabledInputs,function(e){return e==n?null:e})},_disableTimepicker:function(e){var t=$(e);var n=$.data(e,PROP_NAME);if(!t.hasClass(this.markerClassName)){return}var r=e.nodeName.toLowerCase();if(r=="input"){var i=this._get(n,"button");$(i).addClass("ui-state-disabled").disabled=true;e.disabled=true;n.trigger.filter("button").each(function(){this.disabled=true}).end()}else if(r=="div"||r=="span"){var s=t.children("."+this._inlineClass);s.children().addClass("ui-state-disabled");s.find("button").each(function(){this.disabled=true})}this._disabledInputs=$.map(this._disabledInputs,function(t){return t==e?null:t});this._disabledInputs[this._disabledInputs.length]=t.attr("id")},_isDisabledTimepicker:function(e){if(!e){return false}for(var t=0;t<this._disabledInputs.length;t++){if(this._disabledInputs[t]==e){return true}}return false},_checkOffset:function(e,t,n){var r=e.tpDiv.outerWidth();var i=e.tpDiv.outerHeight();var s=e.input?e.input.outerWidth():0;var o=e.input?e.input.outerHeight():0;var u=document.documentElement.clientWidth+$(document).scrollLeft();var a=document.documentElement.clientHeight+$(document).scrollTop();t.left-=this._get(e,"isRTL")?r-s:0;t.left-=n&&t.left==e.input.offset().left?$(document).scrollLeft():0;t.top-=n&&t.top==e.input.offset().top+o?$(document).scrollTop():0;t.left-=Math.min(t.left,t.left+r>u&&u>r?Math.abs(t.left+r-u):0);t.top-=Math.min(t.top,t.top+i>a&&a>i?Math.abs(i+o):0);return t},_findPos:function(e){var t=this._getInst(e);var n=this._get(t,"isRTL");while(e&&(e.type=="hidden"||e.nodeType!=1)){e=e[n?"previousSibling":"nextSibling"]}var r=$(e).offset();return[r.left,r.top]},_getBorders:function(e){var t=function(e){return{thin:1,medium:2,thick:3}[e]||e};return[parseFloat(t(e.css("border-left-width"))),parseFloat(t(e.css("border-top-width")))]},_checkExternalClick:function(e){if(!$.timepicker._curInst){return}var t=$(e.target);if(t[0].id!=$.timepicker._mainDivId&&t.parents("#"+$.timepicker._mainDivId).length==0&&!t.hasClass($.timepicker.markerClassName)&&!t.hasClass($.timepicker._triggerClass)&&$.timepicker._timepickerShowing&&!($.timepicker._inDialog&&$.blockUI))$.timepicker._hideTimepicker()},_hideTimepicker:function(e){var t=this._curInst;if(!t||e&&t!=$.data(e,PROP_NAME)){return}if(this._timepickerShowing){var n=this._get(t,"showAnim");var r=this._get(t,"duration");var i=function(){$.timepicker._tidyDialog(t);this._curInst=null};if($.effects&&$.effects[n]){t.tpDiv.hide(n,$.timepicker._get(t,"showOptions"),r,i)}else{t.tpDiv[n=="slideDown"?"slideUp":n=="fadeIn"?"fadeOut":"hide"](n?r:null,i)}if(!n){i()}this._timepickerShowing=false;this._lastInput=null;if(this._inDialog){this._dialogInput.css({position:"absolute",left:"0",top:"-100px"});if($.blockUI){$.unblockUI();$("body").append(this.tpDiv)}}this._inDialog=false;var s=this._get(t,"onClose");if(s){s.apply(t.input?t.input[0]:null,[t.input?t.input.val():"",t])}}},_tidyDialog:function(e){e.tpDiv.removeClass(this._dialogClass).unbind(".ui-timepicker")},_getInst:function(e){try{return $.data(e,PROP_NAME)}catch(t){throw"Missing instance data for this timepicker"}},_get:function(e,t){return e.settings[t]!==undefined?e.settings[t]:this._defaults[t]},_setTimeFromField:function(e){if(e.input.val()==e.lastVal){return}var t=this._get(e,"defaultTime");var n=t=="now"?this._getCurrentTimeRounded(e):t;if(e.inline==false&&e.input.val()!=""){n=e.input.val()}if(n instanceof Date){e.hours=n.getHours();e.minutes=n.getMinutes()}else{var r=e.lastVal=n;if(n==""){e.hours=-1;e.minutes=-1}else{var i=this.parseTime(e,r);e.hours=i.hours;e.minutes=i.minutes}}$.timepicker._updateTimepicker(e)},_optionTimepicker:function(e,t,n){var r=this._getInst(e);if(arguments.length==2&&typeof t=="string"){return t=="defaults"?$.extend({},$.timepicker._defaults):r?t=="all"?$.extend({},r.settings):this._get(r,t):null}var i=t||{};if(typeof t=="string"){i={};i[t]=n}if(r){extendRemove(r.settings,i);if(this._curInst==r){this._hideTimepicker();this._updateTimepicker(r)}if(r.inline){this._updateTimepicker(r)}}},_setTimeTimepicker:function(e,t){var n=this._getInst(e);if(n){this._setTime(n,t);this._updateTimepicker(n);this._updateAlternate(n,t)}},_setTime:function(e,t,n){var r=e.hours;var i=e.minutes;if(t instanceof Date){e.hours=t.getHours();e.minutes=t.getMinutes()}else{var t=this.parseTime(e,t);e.hours=t.hours;e.minutes=t.minutes}if((r!=e.hours||i!=e.minutes)&&!n){e.input.trigger("change")}this._updateTimepicker(e);this._updateSelectedValue(e)},_getCurrentTimeRounded:function(e){var t=new Date,n=t.getMinutes(),r=this._get(e,"minutes"),i=Math.round(n/r.interval)*r.interval;t.setMinutes(i);return t},parseTime:function(e,t){var n=new Object;n.hours=-1;n.minutes=-1;if(!t)return"";var r=this._get(e,"timeSeparator"),i=this._get(e,"amPmText"),s=this._get(e,"showHours"),o=this._get(e,"showMinutes"),u=this._get(e,"optionalMinutes"),a=this._get(e,"showPeriod")==true,f=t.indexOf(r);if(f!=-1){n.hours=parseInt(t.substr(0,f),10);n.minutes=parseInt(t.substr(f+1),10)}else if(s&&(!o||u)){n.hours=parseInt(t,10)}else if(!s&&o){n.minutes=parseInt(t,10)}if(s){var l=t.toUpperCase();if(n.hours<12&&a&&l.indexOf(i[1].toUpperCase())!=-1){n.hours+=12}if(n.hours==12&&a&&l.indexOf(i[0].toUpperCase())!=-1){n.hours=0}}return n},selectNow:function(e){var t=$(e.target).attr("data-timepicker-instance-id"),n=$(t),r=this._getInst(n[0]);var i=new Date;r.hours=i.getHours();r.minutes=i.getMinutes();this._updateSelectedValue(r);this._updateTimepicker(r);this._hideTimepicker()},deselectTime:function(e){var t=$(e.target).attr("data-timepicker-instance-id"),n=$(t),r=this._getInst(n[0]);r.hours=-1;r.minutes=-1;this._updateSelectedValue(r);this._hideTimepicker()},selectHours:function(e){var t=$(e.currentTarget),n=t.attr("data-timepicker-instance-id"),r=parseInt(t.attr("data-hour")),i=e.data.fromDoubleClick,s=$(n),o=this._getInst(s[0]),u=this._get(o,"showMinutes")==true;if($.timepicker._isDisabledTimepicker(s.attr("id"))){return false}t.parents(".ui-timepicker-hours:first").find("a").removeClass("ui-state-active");t.children("a").addClass("ui-state-active");o.hours=r;var a=this._get(o,"onMinuteShow"),f=this._get(o,"maxTime"),l=this._get(o,"minTime");if(a||f.minute||l.minute){this._updateMinuteDisplay(o)}this._updateSelectedValue(o);o._hoursClicked=true;if(o._minutesClicked||i||u==false){$.timepicker._hideTimepicker()}return false},selectMinutes:function(e){var t=$(e.currentTarget),n=t.attr("data-timepicker-instance-id"),r=parseInt(t.attr("data-minute")),i=e.data.fromDoubleClick,s=$(n),o=this._getInst(s[0]),u=this._get(o,"showHours")==true;if($.timepicker._isDisabledTimepicker(s.attr("id"))){return false}t.parents(".ui-timepicker-minutes:first").find("a").removeClass("ui-state-active");t.children("a").addClass("ui-state-active");o.minutes=r;this._updateSelectedValue(o);o._minutesClicked=true;if(o._hoursClicked||i||u==false){$.timepicker._hideTimepicker();return false}return false},_updateSelectedValue:function(e){var t=this._getParsedTime(e);if(e.input){e.input.val(t);e.input.trigger("change")}var n=this._get(e,"onSelect");if(n){n.apply(e.input?e.input[0]:null,[t,e])}this._updateAlternate(e,t);return t},_getParsedTime:function(e){if(e.hours==-1&&e.minutes==-1){return""}if(e.hours<e.hours.starts||e.hours>e.hours.ends){e.hours=0}if(e.minutes<e.minutes.starts||e.minutes>e.minutes.ends){e.minutes=0}var t="",n=this._get(e,"showPeriod")==true,r=this._get(e,"showLeadingZero")==true,i=this._get(e,"showHours")==true,s=this._get(e,"showMinutes")==true,o=this._get(e,"optionalMinutes")==true,u=this._get(e,"amPmText"),a=e.hours?e.hours:0,f=e.minutes?e.minutes:0,l=a?a:0,c="";if(l==-1){l=0}if(f==-1){f=0}if(n){if(e.hours==0){l=12}if(e.hours<12){t=u[0]}else{t=u[1];if(l>12){l-=12}}}var h=l.toString();if(r&&l<10){h="0"+h}var p=f.toString();if(f<10){p="0"+p}if(i){c+=h}if(i&&s&&(!o||p!=0)){c+=this._get(e,"timeSeparator")}if(s&&(!o||p!=0)){c+=p}if(i){if(t.length>0){c+=this._get(e,"periodSeparator")+t}}return c},_updateAlternate:function(e,t){var n=this._get(e,"altField");if(n){$(n).each(function(e,n){$(n).val(t)})}},_getTimeAsDateTimepicker:function(e){var t=this._getInst(e);if(t.hours==-1&&t.minutes==-1){return""}if(t.hours<t.hours.starts||t.hours>t.hours.ends){t.hours=0}if(t.minutes<t.minutes.starts||t.minutes>t.minutes.ends){t.minutes=0}return new Date(0,0,0,t.hours,t.minutes,0)},_getTimeTimepicker:function(e){var t=this._getInst(e);return this._getParsedTime(t)},_getHourTimepicker:function(e){var t=this._getInst(e);if(t==undefined){return-1}return t.hours},_getMinuteTimepicker:function(e){var t=this._getInst(e);if(t==undefined){return-1}return t.minutes}});$.fn.timepicker=function(e){if(!$.timepicker.initialized){$(document).mousedown($.timepicker._checkExternalClick);$.timepicker.initialized=true}if($("#"+$.timepicker._mainDivId).length===0){$("body").append($.timepicker.tpDiv)}var t=Array.prototype.slice.call(arguments,1);if(typeof e=="string"&&(e=="getTime"||e=="getTimeAsDate"||e=="getHour"||e=="getMinute"))return $.timepicker["_"+e+"Timepicker"].apply($.timepicker,[this[0]].concat(t));if(e=="option"&&arguments.length==2&&typeof arguments[1]=="string")return $.timepicker["_"+e+"Timepicker"].apply($.timepicker,[this[0]].concat(t));return this.each(function(){typeof e=="string"?$.timepicker["_"+e+"Timepicker"].apply($.timepicker,[this].concat(t)):$.timepicker._attachTimepicker(this,e)})};$.timepicker=new Timepicker;$.timepicker.initialized=false;$.timepicker.uuid=(new Date).getTime();$.timepicker.version="0.3.3";window["TP_jQuery_"+tpuuid]=$})(jQuery);

(function defineCmon$Plugins($) {
	
	var orgClone = $.fn.clone;
	$.fn.clone = function(arg1, arg2) {
		var $clone = orgClone.apply(this, [arg1, arg2]);
		if (arg1 === true) {
			$clone.find('[ui]').each(function() {
				$.data(this, 'ui', $(this).next().get(0));
			});
		}
		return $clone;
	};
	
})(jQuery);

function registYearpicker() {
	$.fn.yearpicker = function yearpicker() {
		return this.each(function() {
			var $this, range, curYear, defaultYear, reverse, from, to, html; 
			$this = $(this);
			range = $this.attr('range') || '-80|+80';
			curYear = parseInt($this.attr('curyear') || new Date().getFullYear(), 10);
			defaultYear = $this.attr('defyear');
			reverse = $this.is('[reverse]');
			html = $this.html();
			range = range.trim().split('|');
			
			if (range.length !== 2) {
				range = [-80, +80];
			} else {
				range = [parseInt(range[0], 10), parseInt(range[1], 10)];
				range.sort();
			}
			
			if ((curYear + range[0]) > curYear) {
				from = range[0];
				to = range[1];
			} else {
				from = curYear + range[0];
				to = curYear + range[1];
			}
			
			if (reverse) {
				for (var i = to; i >= from; -- i) {
					html += '<option value="'+ i +'">' + i + '</option>'; 
				}
			} else {
				for (var i = from; i <= to; ++ i) {
					html += '<option value="'+ i +'">' + i + '</option>'; 
				}
			}
			
			$this.html(html);
			$this.val(defaultYear);
		});
	};
	$('.egov-yearpicker').yearpicker();
}

function registMonthpicker() {
	$.fn.monthpicker = function monthpicker(arg1, arg2) {
		if (arg1 === 'getMonth') {
			return $(this).eq(0).val();
		}
		return this.each(function() {
			var $this = $(this); 
			if (arg1 === 'setMonth') {
				var _date = null, data;
				try {
					_date = $.datepicker.parseDate('dd/mm/yy', '01/' + arg2);
				} catch(err) {
				    console.log('Value must be "MM/yyyy" format');
				}
				
				if (_date !== null) {
					$this.datepicker('setDate', _date);
					data = $.data(this, 'datepicker');
					data.lastVal = this.value;
					data.settings.defaultDate = _date;
					$.data(this, 'datepicker', data);
				}
				
			} else {
				var _defaultDate = null, data;
				try {
					 _defaultDate = $.datepicker.parseDate('dd/mm/yy', '01/' + this.value);
				} catch(err) {
				    console.log('input[name="' + this.name + '"]: value must be "MM/yyyy" format');
				}
				
				$this.datepicker('destroy')
					.removeClass('hasDatepicker')
					.datepicker({
						numberOfMonths: 1,
						showAnim: '',
						changeMonth: true,
				        changeYear: true,
				        showButtonPanel: true,
						dateFormat:"mm/yy",
						yearRange:"-80:+80",
						currentText: 'Tháng hiện tại',
						closeText: 'Xong',
						monthNamesShort:["Th&#225;ng 1","Th&#225;ng 2","Th&#225;ng 3","Th&#225;ng 4","Th&#225;ng 5","Th&#225;ng 6","Th&#225;ng 7","Th&#225;ng 8","Th&#225;ng 9","Th&#225;ng 10"
						                 ,"Th&#225;ng 11","Th&#225;ng 12"],
						dayNamesMin:["CN","T2","T3","T4","T5","T6","T7"],
						beforeShow: function(input, inst) {
							inst.settings.defaultDate = new Date(inst.currentYear, inst.currentMonth, inst.currentDay,0,0,0,0);
							inst.dpDiv.addClass('monthpicker-div');
						},
						onClose: function(dateText, inst) {
				            var month = inst.dpDiv.find('.ui-datepicker-month').val(),
				            year = inst.dpDiv.find('.ui-datepicker-year').val();
				            inst.input.datepicker('setDate', new Date(parseInt(year, 10), parseInt(month, 10), 1,0,0,0,0));
				            inst.lastVal = $.datepicker.formatDate(
			            		inst.settings.dateFormat,
			            		new Date(parseInt(year, 10), parseInt(month, 10), 1,0,0,0,0)
			            	);
				            inst.dpDiv.removeClass('monthpicker-div');
				        }
					});
				if (_defaultDate !== null) {
					$this.datepicker('setDate', _defaultDate);
					data = $.data(this, 'datepicker');
					data.lastVal = this.value;
					data.settings.defaultDate = _defaultDate;
					$.data(this, 'datepicker', data);
				}
			}
		});
	};
	$('.egov-monthpicker').monthpicker();
}

function registTimepicker() {
	
	DataFiller.regist(
		function(container, key, value) {
			var $input = $(container).findInput(key);
			if ( $input.hasClass('timepicker-input') ) {
				$input.timepicker('setTime', value);
			}
		}
	);
	
	(function customTimepicker(tpk) {
		var orgSetTime = tpk._setTimeFromField
		, orgAttach = tpk._attachTimepicker
		, orgUpdate = tpk._updateSelectedValue
		, org$SetTime = tpk._setTimeTimepicker;
		
		tpk._setRealValue = function(inst) {
			var ui, time;
			ui = inst.input.get(0);
			time = tpk.parseTime(inst, ui.value);
			if (time !== '' && time.hours !== -1 && time.minutes !== -1) {
				$.data(ui, '$input').val(
					('0' + inst.hours).right(2) 
					+ tpk._get(inst, 'timeSeparator') 
					+ ('0' + inst.minutes).right(2)
				);
			}
		};
		tpk._setTimeFromField = function(inst) {
			orgSetTime.apply(tpk, [inst]);
			tpk._setRealValue(inst);
		};
		tpk._updateSelectedValue = function(inst) {
			orgUpdate.apply(tpk, [inst]);
			tpk._setRealValue(inst);
		};
		tpk._getTimeTimepicker = function(input) {
			var out = '', $input;
			$input = $(input);
			if ($input.hasClass('timepicker-input')) {
				out = $input.val();
			} else if ($input.hasClass('timepicker-ui')) {
				out = $.data(input, '$input').val();
			}
			return out;
		};
		tpk._setTimeTimepicker = function(input, time) {
			var $input, ui;
			$input = $(input);
			if ($input.hasClass('timepicker-input')) {
				ui = $.data(input, 'ui');
			} else if ($input.hasClass('timepicker-ui')) {
				ui = input;
			}
			return org$SetTime.apply(tpk, [ui, time]);
		};
		tpk._attachTimepicker = function(input, settings) {
			var $input, $ui, ui, defaultTime;
			$input = $(input);
			$ui = $input.next('.timepicker-ui');
			if ($ui.length === 0) {
				$ui = $('<input type="text" class="' + input.className + ' timepicker-ui" style="' + input.style.cssText + '" maxlength="11" />');
				$input.after($ui);
				$input.attr('ui', 'true');
			}
			ui = $ui.get(0);
			$ui.prop('disabled', $input.prop('disabled'));
			$ui.prop('readonly', $input.prop('readonly'));
			$input.addClass('timepicker-input').hide();
			$.data(ui, '$input', $input);
			$.data(input, 'ui', ui);
			defaultTime = $input.val().trim();
			orgAttach.apply(tpk, [ui, settings]);
			if (defaultTime !== '') {
				tpk._setTimeTimepicker(ui, defaultTime);
			}
		};
	})($.timepicker);
	
	$.fn.bindTimepicker = function() {
		return this.each(function() {
			$(this)
				.removeClass('hasTimepicker')
				.timepicker({
					showLeadingZero: true,        
				    showMinutesLeadingZero: true, 
				    showPeriod: true,            
				    hourText: 'Giờ',             
				    minuteText: 'Phút',         
				    amPmText: ['Sáng', 'Chiều'],
				    hours: {
				        starts: 5,                
				        ends: 19,
				    },
				    minutes: {
				        starts: 0,                
				        ends: 55,                 
				        interval: 5
//				        manual: []                
				    },
				    rows: 4
				});
		});
	};
	$('.egov-timepicker').bindTimepicker();
}

/**
 * This customize apply for datepicker/monthpicker
 */
function customEgovCalendar() {
	
	/**
	 * Bind jQuery Datepicker cho các phần tử được tạo động
	 * @author unitech.trungnnh
	 * @param {String} defaulDate dd/MM/yyyy
	 */
	$.fn.bindDatepicker = function bindDatepicker(defaultDateString) {
		return this.each(function() {
			$(this)
				.removeClass('hasDatepicker')
				.datepicker({
					numberOfMonths: 1,
					changeMonth: true,
					dateFormat:"dd/mm/yy",
					yearRange:"-80:+80",
					monthNamesShort:["Th&#225;ng 1","Th&#225;ng 2","Th&#225;ng 3","Th&#225;ng 4","Th&#225;ng 5","Th&#225;ng 6","Th&#225;ng 7","Th&#225;ng 8","Th&#225;ng 9","Th&#225;ng 10"
					                 ,"Th&#225;ng 11","Th&#225;ng 12"],
					dayNamesMin:["CN","T2","T3","T4","T5","T6","T7"],
					changeYear: true
				});
			
			if (defaultDateString) {
				this.val(defaultDateString);
			}
		});
	};
	
	$('.egov-calendar-prev').each(function() {
		var $this = $(this), milestone;
		try {
			milestone = $.datepicker.parseDate('dd/mm/yy', $this.attr('milestone'));
		} catch (err) {
			milestone = new Date();
		}
		$this.datepicker('option', 'maxDate', milestone);
	});
	
	$('.egov-calendar-next').each(function() {
		var $this = $(this), milestone;
		try {
			milestone = $.datepicker.parseDate('dd/mm/yy', $this.attr('milestone'));
		} catch (err) {
			milestone = new Date();
		}
		$this.datepicker('option', 'minDate', milestone);
	});
	
	$('#ui-datepicker-div, #ui-timepicker-div').hide();
}


function registEgovSelectUI() {
	
	var orgFillOptionHTML = $.fn.fillOptionHTML;
	$.fn.fillOptionHTML = function fillOptionHTML(data, keyValue, keyText, defaultValue) {
		orgFillOptionHTML.apply(this, [data, keyValue, keyText, defaultValue]);
		return this.each(function() {
			if ($.data(this, 'chosen') !== undefined) {
				$(this).egovSelectUI();
			}
		})
	};

	var orgVal = $.fn.val;
	$.fn.val = function (value) {
		if (arguments.length === 0) {
			return orgVal.apply(this);
		} else {
			orgVal.apply(this, [value]);
			return this.each(function() {
				if ($.data(this, 'chosen') !== undefined) {
					$(this).egovSelectUI();
				}
			});
		}
	};
	
	$.fn.egovSelectUI = function() {
		return this.each(function() {
			var $sel = $(this), chosen = $.data(this, 'chosen');
			if (chosen !== undefined) {
				$sel.trigger('chosen:updated');
			} else {
				var orgClose;
				$sel.chosen();
				chosen = $.data(this, 'chosen');
				
				$.data(this, 'ui', chosen.container.get(0));
				$sel.attr('ui', 'true');
				
				if (chosen.is_multiple) {
					
					orgClose = chosen.close_field;
					chosen.close_field = function() {
						orgClose.apply(chosen);
						chosen.search_field
							.val(chosen.default_text)
							.css('width', '100%');
					}
					
					chosen.search_field
						.val(chosen.default_text)
						.css('width', '100%');
					
				}
				
				if (chosen.search_choices) {
				
					chosen.search_choices.delegate(
						'.search-choice-close-btn',
						'click',
						function() {
							$(this).children().trigger('click');
						}
					);
					
					var orgBuild = chosen.choice_build;
					chosen.choice_build = function(arg1) {
					
						orgBuild.apply(chosen, [arg1]);
						
						var $closeButton = chosen.search_choices.find('a[data-option-array-index="' + arg1.array_index + '"]');
						
						if (chosen.form_field.options[arg1.array_index].hasAttribute('required')) {
							$closeButton.remove();
						} else {
							
							var $inner = $('<span />', {
								'class' : $closeButton.attr('class'),
								'data-option-array-index' : $closeButton.attr('data-option-array-index')
							});
						
							$closeButton.append($inner);
							$closeButton.removeClass('search-choice-close').addClass('search-choice-close-btn');
						}
					};
				}
				
				$sel.trigger('chosen:updated');
				
			}
		});
	};
	
	$('.egov-select-ui').egovSelectUI();
}

function registDVHCSelect() {
	
	// Keys and params for communicate with server
	var KEY_DATA = 'data'
	,	KEY_ID = 'id'
	,	KEY_NAME = 'ten'
	,	PARAM_PARENTID = 'chaId'
	;
	
	// Reload 3 select box đơn vị hành chính, sử dụng cho selectbox tỉnh/thành
	$.fn.loadDonViHanhChinh = function(tinh, huyen, xa) {
		tinh = VarUtil.getInteger(tinh);
		$.data( this.get(0), 'defaultHuyen', huyen );
		$.data( this.get(0), 'defaultXa', xa );
		this.val(tinh).trigger('change');
	};
	
	$('.egov-dvhc-select').each(function() {
		var $tinhThanh = $(this)
		, $quanHuyen = $('#' + $tinhThanh.attr('quanHuyenId'))
		, $xaPhuong = $('#' + $tinhThanh.attr('xaPhuongId'))
		, url = $tinhThanh.attr('url');
		
		if ($quanHuyen.length) {
			
			var ajaxQH = Ajax.forURL(url)
				.setLoading($quanHuyen, true)
				.onSuccess(function(response) {
					$quanHuyen.fillOptionHTML(response[KEY_DATA], KEY_ID, KEY_NAME);
					var data = $.data($tinhThanh.get(0));
					$quanHuyen.val(VarUtil.getInteger(data.defaultHuyen)).trigger('change');
					data.defaultHuyen = 0;
				});
			
			$tinhThanh.bind('change', 
				function(ev) {
					$quanHuyen.resetOptionHTML();
					$xaPhuong.resetOptionHTML();
					
					var val = VarUtil.getInteger($tinhThanh.val());
					if (val > 0) {
						ajaxQH.setRequestParam(PARAM_PARENTID, val).run();
					}
				}
			);
			
			if ($xaPhuong.length) {
				var ajaxXP = Ajax.forURL(url)
					.setLoading($xaPhuong, true)
					.onSuccess(function(response) {
						$xaPhuong.fillOptionHTML(response[KEY_DATA], KEY_ID, KEY_NAME);
						var data = $.data($tinhThanh.get(0));
						$xaPhuong.val(VarUtil.getInteger(data.defaultXa));
						data.defaultXa = 0;
					});
				
				$quanHuyen.bind('change', 
					function(ev) {
						$xaPhuong.resetOptionHTML();
						var val = VarUtil.getInteger($quanHuyen.val());
						if (val > 0) {
							ajaxXP.setRequestParam(PARAM_PARENTID, val).run();
						}
					}
				);
			}
		}
		
		$tinhThanh.loadDonViHanhChinh(
			$tinhThanh.attr('defaultTinh'),
			$tinhThanh.attr('defaultHuyen'),
			$tinhThanh.attr('defaultXa')
		);
		
	});
}

function registAjaxForm() {
	
	function showValidateMessages(oMessage) {
		var 
			orgInputTitles = []
		,	inputs = []
		,	$this = $(this)
		;
		
		if ( ! $.data(this, 'validated') ) {
			
			$.data(this, 'validated', true);
			
			for (var key in oMessage) {
				var $input = $this.findInput(key);
				
				if ($input.length) {
					
					var $elem = undefined
					,	ui = $.data($input.get(0), 'ui')
					,	hasUI = (ui !== undefined)
					;
					
					if (hasUI) {
						$elem = $(ui);
					} else if (!$input.is(':input')) {
						$elem = $input;
					}
					
					if ($elem !== undefined) {
						$elem.find('*').each(function() {
							orgInputTitles.push(this.title);
							inputs.push(this);
							this.removeAttribute('title');
						});
					}
					
					if (hasUI) {
						$input = $elem;
					}
				}

				orgInputTitles.push($input.prop('title'));
				inputs.push($input.get(0));
				$input.addClass('egov-input-error');
				
				$input.tooltip({
					content: function() {
						return VarUtil.getString($(this).attr('title'));
					},
					show: { effect: "fade", duration: 100 },
					position : {
						my: "center bottom-1",
						at: "center top",
					},
					tooltipClass : 'egov-input-tooltip',
					hide : false
				});
				$input.tooltip('enable');
				$input.attr('title', oMessage[key]);
			}
			
			$.data(this, 'orgInputTitles', orgInputTitles);
			$.data(this, 'inputs', inputs);
		}
	}
	
	function clearValidateMessages() {
		var $this = $(this);
		if ( !$.data(this, 'validated') ) {
			return;
		}
		$.data(this, 'validated', false);
		var $input
		,	orgInputTitles = $.data(this, 'orgInputTitles')
		,	inputs = $.data(this, 'inputs');
		
		for (var index = 0; index < inputs.length; ++ index) {
			$input = $(inputs[index]);
			$input.attr('title', orgInputTitles[index]);
			if ($input.hasClass('egov-input-error')) {
				$input.removeClass('egov-input-error');
				$input.tooltip('destroy');
			}
		}
	}
	
	$.fn.egovAjaxForm = function(ajax) {
		
		return this.each(
			function() {
				var $form = $(this)
				, _ajax, successCallback, beforeCallback;
				
				if (Ajax.isInstance(ajax)) {
					successCallback = ajax.getOnSuccess();
					beforeCallback = ajax.getOnBefore();
					_ajax = $.extend({}, ajax);
				} else {
					_ajax = new Ajax();
				}
				
				_ajax.setURL(this.action)
					.setForm($form)
					.setLoading(SCREEN_LOADING)
					.onBefore(function() {
						clearValidateMessages.apply($form.get(0));
						if ($.isFunction(beforeCallback)) {
							return beforeCallback.apply(this);
						}
					}) 
					.onSuccess(function(response) {
						if (response.isValidateFail()) {
							
							var vldMessages = response.getValidateMessages();
							
							showValidateMessages.apply($form.get(0), [vldMessages]);
							
							if (Object.size(vldMessages) === 1) {
								
								var item = Object.getTheOnlyOne(vldMessages)
								,	$input = $form.findInput(item[0])
								,	message = item[1]
								
								$warning(message,
									function() {
										$input.scrollToMe(function() { $input.focus(); });
									}
								);
							} else {
								var arrOffsetTop = [], offset, tmp = {}, $input, ui;
								
								for (var key in vldMessages) {
									$input = $form.findInput(key);
									ui = $.data($input.get(0), 'ui');
									if (ui !== undefined) {
										offset = $(ui).offset().top;
									} else {
										offset = $input.offset().top;
									}
									arrOffsetTop.push(offset);
									tmp['_' + offset] = key;
								}
								
								arrOffsetTop.sort(function(a, b) { return a-b });
								var key = tmp['_' + arrOffsetTop[0]];
								var $firstInput = $form.findInput(key);
								
								$warning('Vui lòng kiểm tra lại các trường nhập liệu',
									function() {
										$firstInput.scrollToMe();
									}
								);
							}

						} else if ($.isFunction(successCallback)) {
							successCallback.apply(this, [response]);
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
			}
		);
	};
	
	$('.egov-ajax-form').egovAjaxForm();
}

function registSaveDraft() {
	$('.save-draft-button').each(function() {
		var $this = $(this), draftAjax;
		draftAjax = Ajax.forURL($this.attr('url'))
			.setForm($this.closest('form'))
			.setLoading(SCREEN_LOADING)
			.onSuccess(function(response) {
				this.showResponseMessage(response)
			});
		$this.bind('click', function() {
			draftAjax.run();
		});
	});
}

function registVNNumber() {
	
	var ChuSo = [" không ", " một ", " hai ", " ba ", " bốn ", " năm ", " sáu ", " bảy ", " tám ", " chín "];
	var Tien = ["", " nghìn", " triệu", " tỷ", " nghìn tỷ", " triệu tỷ"];
	//1. Hàm đọc số có ba chữ số;
	function DocSo3ChuSo(baso) {
		var tram;
		var chuc;
		var donvi;
		var KetQua = "";
		tram = parseInt(baso / 100, 10);
		chuc = parseInt((baso % 100) / 10);
		donvi = baso % 10;
		if (tram == 0 && chuc == 0 && donvi == 0) return "";
		if (tram != 0) {
			KetQua += ChuSo[tram] + " trăm ";
			if ((chuc == 0) && (donvi != 0)) KetQua += " linh ";
		}
		if ((chuc != 0) && (chuc != 1)) {
			KetQua += ChuSo[chuc] + " mươi";
			if ((chuc == 0) && (donvi != 0)) KetQua = KetQua + " linh ";
		}
		if (chuc == 1) KetQua += " mười ";
		switch (donvi) {
		case 1:
			if ((chuc != 0) && (chuc != 1)) {
				KetQua += " mốt ";
			} else {
				KetQua += ChuSo[donvi];
			}
			break;
		case 5:
			if (chuc == 0) {
				KetQua += ChuSo[donvi];
			} else {
				KetQua += " lăm ";
			}
			break;
		default:
			if (donvi != 0) {
				KetQua += ChuSo[donvi];
			}
			break;
		}
		return KetQua;
	}
	//2. Hàm đọc số thành chữ (Sử dụng hàm đọc số có ba chữ số)
	function toVNNumText(SoTien) {
		var lan = 0;
		var i = 0;
		var so = 0;
		var KetQua = "";
		var tmp = "";
		var ViTri = new Array();
		if (SoTien < 0) return "Số âm ";
		if (SoTien == 0) return "Không ";
		if (SoTien > 0) {
			so = SoTien;
		} else {
			so = -SoTien;
		}
		if (SoTien > 8999999999999999) {
			//SoTien = 0;
			return "Số quá lớn!";
		}
		ViTri[5] = Math.floor(so / 1000000000000000);
		if (isNaN(ViTri[5]))
			ViTri[5] = "0";
		so = so - parseFloat(ViTri[5].toString()) * 1000000000000000;
		ViTri[4] = Math.floor(so / 1000000000000);
		if (isNaN(ViTri[4]))
			ViTri[4] = "0";
		so = so - parseFloat(ViTri[4].toString()) * 1000000000000;
		ViTri[3] = Math.floor(so / 1000000000);
		if (isNaN(ViTri[3]))
			ViTri[3] = "0";
		so = so - parseFloat(ViTri[3].toString()) * 1000000000;
		ViTri[2] = parseInt(so / 1000000, 10);
		if (isNaN(ViTri[2]))
			ViTri[2] = "0";
		ViTri[1] = parseInt((so % 1000000) / 1000);
		if (isNaN(ViTri[1]))
			ViTri[1] = "0";
		ViTri[0] = parseInt(so % 1000, 10);
		if (isNaN(ViTri[0]))
			ViTri[0] = "0";
		if (ViTri[5] > 0) {
			lan = 5;
		} else if (ViTri[4] > 0) {
			lan = 4;
		} else if (ViTri[3] > 0) {
			lan = 3;
		} else if (ViTri[2] > 0) {
			lan = 2;
		} else if (ViTri[1] > 0) {
			lan = 1;
		} else {
			lan = 0;
		}
		for (var i = lan; i >= 0; i--) {
			tmp = DocSo3ChuSo(ViTri[i]);
			KetQua += tmp;
			if (ViTri[i] > 0) KetQua += Tien[i];
			if ((i > 0) && (tmp.length > 0)) KetQua += ','; //&& (!string.IsNullOrEmpty(tmp))
		}
		if (KetQua.substring(KetQua.length - 1) == ',') {
			KetQua = KetQua.substring(0, KetQua.length - 1);
		}
		KetQua = KetQua.substring(1, 2).toUpperCase() + KetQua.substring(2);
		return KetQua.replace(/\s+/g, ' '); //.substring(0, 1);//.toUpperCase();// + KetQua.substring(1);
	}

	function vnNum2Num(inStr) {
		
		var out = inStr
			.trim()
			.replace(/\./g, '')
			.replace(',', '.')
			.lTrimChar('.')
			.rTrimChar('.');
		
		return parseFloat(out.length ? out : 0);
	}
	
	function parseSetting(setting) {
		setting = setting ? (setting + '').split('.') : [10, 2];
	    var _decLen = (setting.length > 1) ? parseInt(setting[1], 10) : 0;
	    var _numLen = parseInt(setting[0], 10) - _decLen;
	    return {numLen: _numLen, decLen: _decLen};
	}

	/**
	 * @TODO:
	 * 		Làm sạch input và trả về dạng số Việt Nam 
	 * 			(dấu thập phân là "," và dấu ngăn cách hàng nghìn là dấu ".")
	 * @param inStr
	 * @param setting ví dụ input: 12.2 nghĩa là tối đa dài 12, và chấp nhận tối đa 2 số sau dấu thập phân
	 * @returns {String}
	 */
	function toVNNum(inStr, setting) {
		
		inStr = (inStr + '').trim();
		setting = parseSetting(setting);
		
	    var
		    commaIndex = 0, // index của dấu thập phân
		    cur = 0,
		    count = 0,
		    char = '',
		    leftStr = '', // chuỗi bên trái dấu thập phân
		    rightStr = '', // chuỗi kể từ dấu thập phân về sau
		    tmp = '';
	    
		var validChars = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', ',']; 
	    
	    // Loại bỏ các ký tự không cần thiết
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
	
	window.VNNumberUtil = {
		toVN: toVNNum,
		toNum: vnNum2Num,
		toVNText: toVNNumText,
		parseSetting: parseSetting
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
	
	$.fn.vnNum2Num = function(val) {
		var $this = $(this);
		val = parseInt(val, 10);
		if ($this.prop('nodeName').toLowerCase() === 'input') {
			if (isNaN(val)) {
				val = $this.val();
			}
			$this.val(vnNum2Num(val));
		} else {
			if (isNaN(val)) {
				val = $this.text();
			}
			$this.text(vnNum2Num(val));
		}
	};
	
	$.fn.toVNNumText = function(val) {
		var $this = $(this);
		if ($this.prop('nodeName').toLowerCase() === 'input') {
			if (!val) {
				val = $this.val();
			}
			$this.val(toVNNumText(val));
		} else {
			if (!val) {
				val = $this.text();
			}
			$this.text(toVNNumText(val));
		}
	};
	
	$('.vn-num').each(function() {
		$(this).toVNNum();
	});
	
	$('.vn-num-text').each(function() {
		$(this).toVNNumText();
	});
	
	$(document.body)
		.delegate('input.vn-num', 'keydown',
			function(ev) {
				var setting = parseSetting($(this).attr('numsetting'));
				var key = ev.charCode || ev.keyCode;
				if (!( isNumberKey(key) || isControlKey(key)
					|| key === 86  // v
					|| ((key === 188) && (setting.decLen > 0)) // ,
				)) {
					ev.preventDefault();
				}
			}
		)
		.delegate('input.vn-num', 'keyup',
			function(ev) {
				var key = ev.charCode || ev.keyCode;
				var lastChar = this.value.charAt(this.value.length - 1);
				if ((isNumberKey(key) && ((this.value.indexOf(',') === -1) || (lastChar !== '0')))
					|| key === 46 // delete
					|| key === 8 // backspace
					|| (key === 188 // , 
						&& (lastChar !== ','))
				) {
					$(this).toVNNum();
				}
			}
		)
		.delegate('input.vn-num', 'change',
			function() {
				$(this).toVNNum();
			}
		);
}

function registEgovPopup() {
	$.fn.egovPopup = function(_title, _width, _minHeight) {
		this.dialog({
			title: _title,
			autoOpen: false,
			width: _width,
			minHeight: _minHeight,
			resizable: false,
			draggable: false,
			closeOnEscape: true,
			modal: true,
			position: { my: "center top", at: "center top+20", of: window }
		});
		return this;
	}
	
	$('.egov-popup').each(function() {
		
		var
			width = VarUtil.getString(this.getAttribute('popup-width'))
		,	minHeight = VarUtil.getString(this.getAttribute('popup-width'))
		;
		
		if(width.indexOf('%') !== -1) {
			width = $(window).width() * VarUtil.getInteger(width) / 100
		}
		
		if(minHeight.indexOf('%') !== -1) {
			minHeight = $(window).height() * VarUtil.getInteger(minHeight) / 100
		}
		
		$(this).egovPopup( this.getAttribute('title'), width, minHeight );
	});
	
	$(document.body).delegate('.egov-popup-opener', 'click',
		function() {
			$('#' + this.getAttribute('popup-id')).dialog('open');
		}
	);
	
	$(document.body).delegate('.egov-popup-closer', 'click',
		function() {
			$('#' + this.getAttribute('popup-id')).dialog('close');
		}
	);
}

function registEgovTooltip() {
	
	var defaultSettings = {
		content: function() {
			return VarUtil.getString($(this).attr('tooltip')).trim();
		},
		tooltipClass: 'egov-tooltip',
		show: { effect: "fade", duration: 100 },
		hide: { effect: "fade", duration: 100 },

		position: {
			my: "center bottom-5",
			at: "center top"
		},
		wrapText : true
	};
	
	/**
	 * Custom jqueryUI tooltip
	 */
	$.fn.egovTooltip = function(arg1, arg2, arg3) {
		
		arg1 = arg1 || {};
			
		return this.each(function() {
				
			var $this = $(this);
			
			// Avoid conflict with validate tooltip
			if ($this.hasClass('egov-input-error')) {
				return;
			}
				
			this.setAttribute('title', ' ');
			
			if ($.isPlainObject(arg1)) {
				var tooltip = ''
				,	cloneDefault = $.extend({}, defaultSettings)
				;
				
				if (arg1.content) {
					tooltip = VarUtil.getString(arg1.content);
					delete arg1.content;
				}
				
				var config = $.extend( true, cloneDefault, arg1 );
				
				if (!config.wrapText) {
					config.tooltipClass = 'egov-tooltip non-wrap';
				} else {
					config.tooltipClass = 'egov-tooltip';
				}
				
				$this.tooltip( config );
				
				if (tooltip !== '') {
					$this.attr('tooltip', tooltip);
				}
				
			} else {
				if (arg1 === 'option' && arg2 === 'content') {
					$this.attr('tooltip', arg3);
				} else {
					$this.tooltip(arg1, arg2, arg3);
				}
			}
		});
	};
	
	$.fn.autoTooltip = function() {
		return this.each(function() {
			var $sel = $(this);
			$sel.mouseenter(function() {
				var $tmp = $.data(this, '$tmp')
				,	selectedText = $sel.find('option:selected').text()
				;
				if ($tmp === undefined) {
					$tmp = $(
						'<div style="white-space:nowrap;margin:0;padding:0;' 
							+ 'width:' +
								($sel.width()
									- 25 
									- VarUtil.getInteger($sel.css('padding-left'))
									- VarUtil.getInteger($sel.css('padding-right'))
								).toString() + 'px;'
							+ 'font-size:' + $sel.css('font-size') + ';'
							+ 'font-weight:' + $sel.css('font-weight') + ';'
						+'"></div>' 
					);
					$tmp.appendTo(document.body);
					$.data(this, '$tmp', $tmp)
				}
				
				$tmp.show().text(selectedText);
				
				if ($tmp.isOverflow()) {
					var config = {content:selectedText};
					_parseAttr(this, config);
					$sel.egovTooltip(config);
					$sel.egovTooltip('open');
				}
				
				$tmp.hide();
			});
		});
	};
	
	$('.egov-tooltip-target').each(function() {
		var config = {};
		_parseAttr(this, config);
		$(this).egovTooltip(config);
	});
	
	$('select[auto-tooltip]').autoTooltip();
	
	function _parseAttr(elem, config) {
		if (elem.hasAttribute('tooltip-no-wrap-text')) {
			config.wrapText = false;
		}
	}
}

/*
 * Đăng ký ui
 */
jQuery(document).ready(function() {
	registAjaxForm();
	registDVHCSelect();
	registSaveDraft();
	registYearpicker();
	registMonthpicker();
	registTimepicker();
	customEgovCalendar();
	registVNNumber();
	registEgovSelectUI();
	registEgovPopup();
	registEgovTooltip();
});