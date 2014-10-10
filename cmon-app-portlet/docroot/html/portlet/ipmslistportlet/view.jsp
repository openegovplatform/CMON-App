<!-- 
 * Copyright (c) 2014 by Open eGovPlatform (http://http://openegovplatform.org/).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
  -->
<%@page import="org.oep.cmon.portlet.transaction.TransactionUtils"%>
<%@page import="javax.portlet.WindowState"%>
<%@ page import="javax.portlet.PortletSession" %>
<%@ include file="/html/portlet/init.jsp" %>
 
<%
 	Object reloadPageObj = request.getAttribute("reload-page");
   	boolean reloadPage = reloadPageObj == null? false: true;
   	String viewType ="";
   	String tabs1 = ParamUtil.getString(request, "tabs1", "tab.ipmslist.dangHD");
   	if(reloadPage) {
   		 viewType = (String) request.getAttribute(TransactionUtils.PARAM_VIEW_TYPE);
   		 tabs1 = (String) request.getAttribute("tabs1");
   		 request.removeAttribute(TransactionUtils.PARAM_VIEW_TYPE);
   		 request.removeAttribute("tabs1");
   	}else {
   		 viewType = ParamUtil.getString(request, TransactionUtils.PARAM_VIEW_TYPE);
   	}
   	
   	// BinhNT Add
   	Object jsp_include = renderRequest.getAttribute("jsp_include");
   	if (jsp_include == null) {
   		if (renderRequest.getParameter("jsp_include") != null) {
   	jsp_include = renderRequest.getParameter("jsp_include");
   		}
   	}
   	if (jsp_include == null) {
   		jsp_include = "";
   	}
   	
   	// End BinhNT Add
   	PortletURL portletURL = renderResponse.createRenderURL();	
   	portletURL.setWindowState(WindowState.NORMAL);	
   	//portletURL.setParameter("struts_action", "/ext/reports/view_reports");
   	portletURL.setParameter("tabs1", tabs1);
   	
   	//String tabNames = "tab.ipmslist.dangHD,tab.ipmslist.dangXuLy";
   	String tabNames = "tab.ipmslist.dangXuLy";
   	portletSession.removeAttribute("returnURL", PortletSession.APPLICATION_SCOPE);

   	String processingProfilePrefParam = org.oep.cmon.Constants.XuLyHoSo.PROCESSING_PROFILE_PREF_PARAM;
 	String processingProfilePrefValue = portletPreferences.getValue(processingProfilePrefParam, Constants.XuLyHoSo.OTHER_VALUE);
 	boolean laCanBoMotCua = Constants.XuLyHoSo.OTHER_VALUE.equals(processingProfilePrefValue);
 %>
<% if (laCanBoMotCua) { %>
	<%@include file="/html/portlet/ipmslistportlet/danhSachHoSoMotCua.jsp"%>
<% } else { %>
	<%@include file="/html/portlet/ipmslistportlet/danhSachHoSoXuLy.jsp"%>
<% } %>

<!-- hoangtrung.nguyen fix 2 man hinh danh sach ho so  -->
<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/core.css" />
<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/customEgovTheme.css" />
<style type="text/css">
	div.egov-container {
		padding-left: 10px;
		padding-right: 10px;
		overflow: auto; 
	}
	div.egov-container .result-grid.hoso-grid {
		min-width: 760px !important;
		width: auto !important;
	}
	table.egov-table.result-grid.hoso-grid td a {
		margin-left: 0 !important;
	}
	table.egov-table.result-grid.hoso-grid td.fn a {
		padding: 0 !important;
		margin: 0 !important;
		line-height: 0 !important;
	}
	table.egov-table.result-grid.hoso-grid td.fn a {
		text-decoration: none !important;
	}
	.dungxuly {
		background: url("<%=request.getContextPath()%>/images/dungxuly.png") no-repeat scroll 0 0 rgba(0, 0, 0, 0);
		display: inline-block;
		height: 16px;
		overflow: hidden;
		vertical-align: top;
		width: 16px;
	}
	.traodoithongtin {
		background: url("<%=request.getContextPath()%>/images/trao_doi_thong_tin.png") no-repeat scroll 0 0 rgba(0, 0, 0, 0);
		display: inline-block;
		height: 16px;
		overflow: hidden;
		vertical-align: top;
		width: 16px;
	}
</style>
<script type="text/javascript">
	function getWidthSpecifiedByPercent($el) {
		var $elRoler, $parentRoler, $parent, specPercent;
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
	jQuery(function($) {
		$('select').each(function() {
			this.title = $(this).find('option:selected').text();
		});
		
		// Xu ly day nut
		var buttonsPerRow = 3;
		$('td.fn').each(function() {
			var $td, html = '';
			$td = $(this);
			$td.children().each(function(i) {
				var button = this;
				console.log( button.nodeName);
				if ((i % buttonsPerRow) == 0) {
					html += '<div class="nonbreak-wrapper">';
				}
				
				html += '<div class="nonbreak" style="padding: 3px; line-height: 0">' + button.outerHTML + '</div>';
				if ((i % buttonsPerRow) == (buttonsPerRow - 1)) {
					html += '</div>';
				}
			});
			
			$td.html(html);
		});
		
		// Xu ly de tranh menu trai bi hap' ziem
	    var $col2, specWidth;
	    $col2 = $('#column-2');
		specWidth = getWidthSpecifiedByPercent($col2);
		
		// Bi tran`
		if (($col2.width() - 1) > specWidth) {
			$('.egov-container').css('width', specWidth + 'px');
		}
	});
</script>			
