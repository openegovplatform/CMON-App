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
<%@page import="java.util.Enumeration"%>
<%@page import="com.liferay.portal.model.ThemeSetting"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<liferay-theme:defineObjects />
<%
	LiferayURL getProcessURL = LiferayURL.createResourceURL(request, "getProcessingProcess");
%>
<div id="processViewId" title="Quá trình xử lý" style="display: none;" class="egov-popup" popup-width="80%">
	<div class="egov-container " style="width: 100%; padding-left: 0; padding-right: 0;">
		<input id="portalUrlId" type="hidden" value="<%=PortalUtil.getPortalURL(request)%>"/>
		<div class="result-grid-ctn blockcenter">
			<table class="egov-table result-grid" id="processDataId">
				<thead>
					<tr>
						<th><liferay-ui:message key="vn.dtt.brms.registry.viewTransaction.stt" /></th>
						<th><liferay-ui:message key="vn.dtt.worklist.name" /></th>
						<th><liferay-ui:message key="vn.dtt.worklist.cbxl" /></th>
						<th><liferay-ui:message key="vn.dtt.worklist.status" /></th>
						<th><liferay-ui:message key="vn.dtt.worklist.start" /></th>
						<th><liferay-ui:message key="vn.dtt.worklist.end" /></th>
						<th><liferay-ui:message key="vn.dtt.worklist.pb" /></th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
		</div>
		<div class="button-bar">
			<button class="egov-button egov-popup-closer" popup-id="processViewId">
				Thoát
			</button>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		$(document.body).delegate('.xem-tien-trinh', 'click', function(e) {
			var profileCode = $(this).attr('id');
			doAjaxOpenDialog(profileCode);
			e.preventDefault();
		});

		// for list of buttons on page
		$("#profileListId .viewProcessButtonClass").each(function() {
			$(this).button().mouseover(function() {
				$(this).css("cursor", "pointer");
			});
			$(this).button().click(function() {
				var profileCode = $(this).attr('id');
				doAjaxOpenDialog(profileCode);
			});
		});

		// for one button
		$("input[name='viewProcessButtonName']").click(function() {
			var profileCode = $(this).attr('id');
			doAjaxOpenDialog(profileCode);
		});
	});

	function addRow(index, rowData) {
		if ("COMPLETED" == rowData["info"]) {
			status = "Hoàn thành";
		} else {
			status = "Đang xử lý";
		}
		var row = '<tr>';
		row = row + '<td class="center"><label class="egov-label">' + (index + 1) + '</label></td>';
		row = row + '<td align="left"><label class="egov-label">' + rowData["title"] + '</label></td>';
		row = row + '<td align="left"><label class="egov-label">' + rowData["canBoXuLy"] + '</label></td>';
		row = row + '<td align="left"><label class="egov-label">' + status + '</label></td>';
		
		row = row + '<td class="center"><label class="egov-label">' 
			+ $.datepicker.formatDate('dd/mm/yy', $.datepicker.parseDate('yy-mm-dd', rowData["startDate"])) 
			+ '</label></td>';
		row = row + '<td class="center"><label class="egov-label">' 
			+ $.datepicker.formatDate('dd/mm/yy', $.datepicker.parseDate('yy-mm-dd', rowData["endDate"]))  
			+ '</label></td>';
			
		//row = row + '<td><label class="egov-label">' + rowData["startDate"] + '</label></td>';
		//row = row + '<td><label class="egov-label">' + rowData["endDate"] + '</label></td>';
		row = row + '<td align="left"><label class="egov-label">' + rowData["phongBanThucHien"] 	+ '</label></td>';
		row = row + '</tr>';
		$("#processDataId tbody").append(row);
	}

	function doAjaxOpenDialog(profileCode) {
		// Using the core $.ajax() method
		$.ajax({
			// the URL for the request
			url: "<%=getProcessURL%>",

			// the data to send (will be converted to a query string)
			data : {
				profileCode : profileCode
			},

			// whether this is a POST or GET request
			//type: "POST",

			// the type of data we expect back
			dataType : "json",

			// code to run if the request succeeds;
			// the response is passed to the function
			success : function(json) {
				// delete old data
				$("#processDataId tbody tr").remove();
				var data = json['workLists'];
				for ( var i = 0; i < data.length; i++) {
					var rowData = data[i];
					addRow(i, rowData);
				}
			}
		});

		$("#processViewId").dialog("open");
	}
</script>
