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
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/portlet/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	HoSoTTHCCong quyTrinhHD = (HoSoTTHCCong) row.getObject();
	
	
	PortletURL viewTransactionURL = renderResponse.createRenderURL();
	viewTransactionURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	viewTransactionURL.setParameter("jspPage", "/html/portlet/transaction/details.jsp");
	viewTransactionURL.setParameter("Id", String.valueOf(quyTrinhHD.getId()));
	viewTransactionURL.setParameter("showHeader", "false");
	
	String popup = "javascript:popup('"+ viewTransactionURL.toString()+"');";
%>

<liferay-ui:icon-menu>
	<liferay-ui:icon image="edit" message="Chi tiet" url="<%= viewTransactionURL.toString() %>" />
	<liferay-ui:icon image="view" message="View Details" url="<%= popup %>" />
</liferay-ui:icon-menu>

<aui:script>
	Liferay.provide(
		window,
		'popup',
		function(url) {
			var A = AUI();

			var data = {};

			var dialog = new A.Dialog(
				{
					centered: true,
					destroyOnClose: true,
					draggable: true,
					height: 330,
					width: 343,
					resizable: false,
					modal: true,
					title: 'Book Details'
				}
				).render();
					dialog.plug(
						A.Plugin.IO,
						{
							data: data,
							uri: url
						}
					);
			},
		['aui-dialog', 'aui-io']
	);
</aui:script>