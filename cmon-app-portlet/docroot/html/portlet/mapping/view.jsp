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
<%@page import="org.oep.cmon.portlet.mapping.utils.Constaints"%>
<%@page import="org.oep.cmon.dao.thamso.model.AnhXa"%>


<%@page import="org.oep.cmon.dao.thamso.service.AnhXaLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.HeThong"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="org.oep.cmon.portlet.thamso.util.ThamSoConstants"%>
<%@page import="org.oep.cmon.dao.cd.service.HeThongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.thamso.business.ThamSoBusiness"%>
<%@page import="org.oep.cmon.dao.thamso.model.ThamSo"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="/html/portlet/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	
	int curnext = ParamUtil.getInteger(request, "cur", 0);
	int deltanext = ParamUtil.getInteger(request, "delta", 0);
	if(curnext >0){
		portletSession.setAttribute("cur", String.valueOf(curnext));
		
	}
	if(deltanext != 0){
		portletSession.setAttribute("delta", String.valueOf(deltanext));
		
	}
	

	int cur = Integer.parseInt(Constaints.getSessionValue(portletSession, "cur", "1"));
	int delta = Integer.parseInt(Constaints.getSessionValue(portletSession, "delta", "10"));
	String keyword = Constaints.getSessionValue(portletSession, "keyword", "");
	String table = Constaints.getSessionValue(portletSession, "table", "");
	Long appId = Long.valueOf(Constaints.getSessionValue(portletSession, "appId", "0"));
	

	PortletURL pagingURL = renderResponse.createRenderURL();
	pagingURL.setParameter("cur", String.valueOf(cur));
	pagingURL.setParameter("delta", String.valueOf(delta));
	
	
	
	PortletURL searchURL = renderResponse.createActionURL();
	searchURL.setParameter(ActionRequest.ACTION_NAME, "search");	
	
	
	PortletURL addNewUrl = renderResponse.createRenderURL();	
	addNewUrl.setParameter("jspPage", "/html/portlet/mapping/add.jsp");
	
	PortletURL synchUrl = renderResponse.createRenderURL();	
	synchUrl.setParameter("jspPage", "/html/portlet/mapping/synch.jsp");
	
	PortletURL deleteAllUrl = renderResponse.createRenderURL();	
	deleteAllUrl.setParameter("jspPage", "/html/portlet/mapping/delete.jsp");
	
	
	
	
	
	
	List<AnhXa>  result = new ArrayList<AnhXa>(); 
	
	SearchContainer searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			cur, delta, pagingURL, null, null);
	
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	
	Long total=0L;

	total= AnhXaLocalServiceUtil.countSearch(keyword, appId, table);
	if(total > 0){
		result = AnhXaLocalServiceUtil.search(keyword, appId, table, start, end); 
	}
	
	
	
	// Paging
	searchContainer.setTotal(total.intValue());
	searchContainer.setResults(result);

%>

<div class="egov-container">
<liferay-ui:success key="<%=Constaints.ACTION_SUCCESS%>" message = "vn.dtt.cmon.anhxa.success"/>
<form name = "<portlet:namespace/>searchThamSoForm" method = "post" action = "<%=searchURL%>" >

			<table   class="egov-table-form" style="width: 100%">
			  <tr>
			    <td align = "left" width="25%">		    
			     	<input name="keyword" type="text" value="<%=keyword %>"  class="egov-inputfield-search" style="width: 92%;"
			     	    />
			    </td>
			    <td align = "left" width="20%" style="padding-left: 5px">
		      		<select id="appId" name="appId" class="egov-select" >
			      		<option value="">--Theo ứng dụng--</option>	 
			      		<%
			      		List<DanhMucUngDung> uList = ThamSoBusiness.getUngDungList();
				      		if(uList != null){
				      		for (DanhMucUngDung ungDung : uList) {
					      			%>
					      			<option value="<%=ungDung.getId() %>" 
					      				<%=ThamSoBusiness.checkSelectedValue(ungDung.getId(), appId)%>>
					      					<%=ungDung.getTen() %>
					      			</option>
					      			<%
				      		}
			      		}
			      		%>
		      		</select>	
			    </td>
			    <td align = "left" width="20%" style="padding-left: 5px">
			    <select id="table" name="table" class="egov-select">
		      			<option value="">--Theo bảng-</option>	 
			      		<%
			      		List<String> tList = AnhXaLocalServiceUtil.getDSBang();
			      		if(tList != null){
			      		for (String bang : tList) {
				      			%>
				      			<option value="<%=bang %>"
				      			<%=ThamSoBusiness.checkSelectedValue(bang, table)%>>
				      				<%=bang %>
				      			</option>
				      			<%
			      		}
			      		}
			      		%>
		      		</select>	
			    </td>
			    <td  width="7%" valign="top" style="padding-left: 5px;"> 		
			 			<input type="submit" name="button" value=""  class="egov-button-search" />
			 	</td>		
			 		 <td  align = "right" width="8%">				 		
			    	 <input type="button" name="button" value="+ THÊM MỚI" 
			    	 class="egov-button-normal" onclick="javascript: window.location = '<%=addNewUrl.toString() %>'" style="float: right;"/>
			    </td>
			    <td align = "right" width="5%">
			    	<input type="button" name="button" value="- Xóa" 
			    	 class="egov-button-normal" onclick="javascript: window.location = '<%=deleteAllUrl.toString() %>'" style="float: right;"/>
			    </td>	 		
			    <td  align = "right" width="7%">			
			    	 <input type="button" name="button" value="Đồng bộ" 
			    	 class="egov-button-normal" onclick="javascript: window.location = '<%=synchUrl.toString() %>'" style="float: right;"/>
			    </td>
			   
			  </tr>
			 
			</table>
		</form>
<table cellpadding="0" cellspacing="0" class="egov-table" width="100%">
	<tbody>
		<tr>
			<th width="4%">TT</th>
			<th width="28%">Tên Hệ thống</th>
			<th width="10%">Mã hệ thống</th>
			<th width="28%">Tên khác</th>			
			<th width="10%">Mã khác</th>
			<th width="10%">Bảng ánh xạ</th>
			
			<th width="10%">Chức năng</th>
		</tr>
		<%
		if(result!=null)
		{
		int index=1;
		for(AnhXa anhXa : result) {											
			
			PortletURL editRequestUrl = renderResponse.createRenderURL();
			editRequestUrl.setParameter("anhxaid", String.valueOf(anhXa.getId()));
			editRequestUrl.setParameter("jspPage", "/html/portlet/mapping/add.jsp");
			
			
			PortletURL deleteUrl = renderResponse.createActionURL();
			deleteUrl.setParameter(ActionRequest.ACTION_NAME, "delete");			
			deleteUrl.setParameter("anhxaid", String.valueOf(anhXa.getId()));
			
			
			
	%>
		<tr>
			<td style="text-align:center"><%=(searchContainer.getStart() +  (index++))%></td>
			<td>
				
					<%=anhXa.getTenDNG() %>
				
			</td>
			<td >
			
				<%=anhXa.getMaDNG() %>
			</td>
			<td >
				<%=anhXa.getTenKhac()%>
			</td>
			<td >
				<%=anhXa.getMaKhac()%>
			</td>
			<td >
				<%=anhXa.getTenBang()%>
			</td>
			
			
			<td width="10%">
				<table class="egov-table-function"
						style="text-align: center; width: 90px">
						<tbody>
							<tr>
							<td><a href="<%=editRequestUrl.toString()%>"><button
										class="egov-func-edit" title="Chỉnh sửa"></button></a></td>
							<td><button class="egov-func-delete" title="Xóa"
									onclick="javascript:<portlet:namespace/>deleteRow('<%=deleteUrl.toString()%>')"></button></td>
							</tr>
						</tbody>
					</table>
				</td>
		</tr>			
			<%
				}
					} else {
			%>
			<tr>
				<td colspan="7" align="center"><label class="egov-label">Không
						có bản ghi dữ liệu nào. Sử dụng chức năng tìm kiếm để có dữ liệu.</label></td>
			</tr>
			<%
				}
			%>
			</tbody>
		</table>
		<%
			if (searchContainer != null) {
		%>
		<div id = "pagination">
			<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
		</div>
		<%
			}
		%>
</div>
<script type="text/javascript">
function <portlet:namespace/>deleteRow(url) {
	var answer = confirm('Bạn chắc chắn muốn xóa bản ghi ?');
	if (answer){
		window.location = url;
	}
}
	
</script>