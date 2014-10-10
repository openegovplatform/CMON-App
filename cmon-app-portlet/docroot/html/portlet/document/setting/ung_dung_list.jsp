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
<%@page import="org.oep.cmon.Constants.Paging"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="org.oep.cmon.portlet.document.business.ThuTucHanhChinhBusiness"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/portlet/init.jsp" %>

<%
int cur =  Integer.valueOf(prefs.getValue("curUD", "1"));
int delta =  Integer.valueOf(prefs.getValue("deltaUD", String.valueOf(Paging.DELTA)));
int curnext = ParamUtil.getInteger(renderRequest, "cur", 1);
int deltanext = ParamUtil.getInteger(renderRequest, "delta", Paging.DELTA);
if(curnext!=cur) {
	cur = curnext;
}
if(deltanext!=delta) {
	delta = deltanext;
}

PortletURL searchUrl = renderResponse.createActionURL();
searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchUngDungRequest");

PortletURL addNewUrl = renderResponse.createActionURL();
addNewUrl.setParameter(ActionRequest.ACTION_NAME, "AddUngDungRequest");
addNewUrl.setParameter("jspPage", "/html/portlet/document/setting/ung_dung_add.jsp");
addNewUrl.setParameter("cur", String.valueOf(cur));
addNewUrl.setParameter("delta", String.valueOf(delta));

String keyWord = ParamUtil.getString(request,"searchKeyWord", "");
String statusUD="";

// Get default search value
String defaultSearch = LanguageUtil.get(pageContext, "vn.dtt.cmon.document.setting.dmud.search.defaultValue");
if (Validator.isNull(keyWord) && renderRequest.getPortletSession().getAttribute("searchKeyWord") != null) {
	keyWord = renderRequest.getPortletSession().getAttribute("searchKeyWord").toString();
}

PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("jspPage", "/html/portlet/document/setting/ung_dung_list.jsp");
 
if (renderRequest.getParameter("searchKeyWord") != null) {
	iteratorUrl.setParameter("searchKeyWord", keyWord);
}

// Get the search result from session if it exists
List<DanhMucUngDung>  result = new ArrayList<DanhMucUngDung>(); 

SearchContainer searchContainer = new SearchContainer(renderRequest, null,
		null, SearchContainer.DEFAULT_CUR_PARAM,
		cur, delta, iteratorUrl, null, null);

 if (keyWord != null) {
	 result = ThuTucHanhChinhBusiness.findByTenUngDung(keyWord);
 }
 else
 {
	 result = ThuTucHanhChinhBusiness.findByTenUngDung("");
 }
if ( result == null ) {	
	 result = new ArrayList<DanhMucUngDung>();
	
}

// Paging
List<DanhMucUngDung> newResults = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());

searchContainer.setTotal(result.size());
searchContainer.setResults(newResults);
%>

<div class="egov-container">
	<jsp:include page="/html/portlet/document/setting/tabs.jsp"
		flush="false" />
<form name = "<portlet:namespace/>searchForm" method = "post" action = "<%=searchUrl%>" onsubmit = "<portlet:namespace/>checkForm2()">
<br>
			<table   class="egov-table-form" style="width: 100%">
			  <tr>
			    <td align = "left" width="35%">		    
			     	<input name="searchKeyWord" type="text"  class="egov-inputfield" style="width: 92%;"
			     	      value = "<%=HtmlUtil.escape(keyWord)%>" placeholder="<%=defaultSearch%>"/>
			    </td>
			    <td  width="5%" valign="top" style="padding-left: 5px;"> 		
			 			<input type="submit" name="button" value="Tìm kiếm"  class="egov-button-search" />
			 	</td>		
			    <td align = "right" width="60%">
			    	<input type="button" name="button" value="+ THÊM MỚI" 
			    	 class="egov-button-normal" onclick="javascript: window.location = '<%=addNewUrl.toString() %>'" style="float: right;"/>
			    </td>
			  </tr>
			  <tr>
			    <td>
			    	<liferay-ui:error key="errorDeleteUngDung" message = "vn.dtt.cmon.document.setting.dmud.error.delete"/>
			    	<%
				if (request.getAttribute("delete_success") != null && request.getAttribute("delete_success").toString().trim().length() > 0) {
					%>
					<liferay-ui:success key="successDeleteUngDung" message="vn.dtt.cmon.document.setting.dmud.completed.delete"/>
					<%
				}
				%>
			    </td>
			 </tr>
			</table>
		</form>
<table cellpadding="0" cellspacing="0" class="egov-table" width="100%">
	<tbody>
		<tr>
			<th style="text-align:center">TT</th>
			<th>Tên ứng dụng</th>
			<th style="text-align:center">Ứng dụng</th>
			<th style="text-align:center">Trạng thái</th>
			<th style="text-align:center">Chức năng</th>
		</tr>
		<%
		if(newResults!=null)
		{
		int index=1;
		for(DanhMucUngDung ungDung : newResults) {											
			
			PortletURL viewRequestUrl = renderResponse.createRenderURL();
			viewRequestUrl.setParameter("ActionType", ThuTucHanhChinhBusiness.VIEW_UNG_DUNG);
			viewRequestUrl.setParameter("jspPage", "/html/portlet/document/setting/ung_dung_add.jsp");
			viewRequestUrl.setParameter("ungDungId", String.valueOf(ungDung.getId()));
			if (renderRequest.getParameter("searchKeyWord") != null) {
				viewRequestUrl.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
			viewRequestUrl.setParameter("cur", String.valueOf(cur));
			viewRequestUrl.setParameter("delta", String.valueOf(delta));

			
			PortletURL editRequestUrl = renderResponse.createRenderURL();
			editRequestUrl.setParameter("ActionType", "editUngDungRequest");		
			editRequestUrl.setParameter("jspPage", "/html/portlet/document/setting/ung_dung_add.jsp");
			editRequestUrl.setParameter("ungDungId", String.valueOf(ungDung.getId()));
			if (renderRequest.getParameter("searchKeyWord") != null) {
				editRequestUrl.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
			viewRequestUrl.setParameter("cur", String.valueOf(cur));
			viewRequestUrl.setParameter("delta", String.valueOf(delta));

			
			PortletURL deleteUrl = renderResponse.createActionURL();
			deleteUrl.setParameter(ActionRequest.ACTION_NAME, "deleteUngDungRequest");
			deleteUrl.setParameter("jspPage", "/html/portlet/document/setting/ung_dung_list.jsp");
			deleteUrl.setParameter("ungDungId", String.valueOf(ungDung.getId()));
			if (renderRequest.getParameter("searchKeyWord") != null) {
				deleteUrl.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
			deleteUrl.setParameter("cur", String.valueOf(cur));
			deleteUrl.setParameter("delta", String.valueOf(delta));

			
	%>
		<tr>
			<td style="text-align:center"><%=(searchContainer.getStart() +  (index++))%></td>
			<td><a href="<%=viewRequestUrl.toString()%>" class="bold"><%=ungDung.getTen() %></a></td>
			<td style="text-align:center"><%=ungDung.getMa() %></td>
			<%if(ungDung.getDaXoa()==1)
			{
				statusUD=LanguageUtil.get(pageContext,"vn.dtt.cmon.document.setting.dmud.inactive.status");
			}
			else
			{
				statusUD=LanguageUtil.get(pageContext,"vn.dtt.cmon.document.setting.dmud.active.status");
			}
				%>
			<td style="text-align:center">
			<%=statusUD %>
			</td>
			<td width="10%">
				<table class="egov-table-function"
						style="text-align: center; width: 90px">
						<tbody>
							<tr>

								<td><a href="<%=editRequestUrl.toString()%>"><button
											class="egov-func-edit" title="Chỉnh sửa"></button></a></td>
								<td><!-- <button class="egov-func-delete" title="Xóa"
										onclick="javascript:<portlet:namespace/>deleteRow('<%=deleteUrl.toString()%>')"></button> --></td>
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
				<td colspan="5" align="center"><label class="egov-label">Không
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
	var answer = confirm('<%=LanguageUtil.get(pageContext, "vn.dtt.cmon.document.setting.dmud.confirm.delete") %>');
	if (answer){
		window.location = url;
	}
}

	function <portlet:namespace/>checkForm(){
		var form = document.searchForm;
		
		if ( form.searchKeyWord.value == "<%=defaultSearch %>"){
			form.searchKeyWord.value = "";
		} 		
	};	
	
	function <portlet:namespace/>checkForm2(){
		var form = document.searchForm;
		
		if ( form.searchKeyWord.value == "<%=defaultSearch %>"){
			form.searchKeyWord.value = "";
		}

		form.reqStatus.options.selectedIndex = 0;
	};
</script>