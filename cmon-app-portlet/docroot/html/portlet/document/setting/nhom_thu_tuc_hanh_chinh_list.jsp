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
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.document.business.ThuTucHanhChinhBusiness"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>

<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/portlet/init.jsp" %>

<%
	PortletURL searchUrl = renderResponse.createActionURL();
	searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchNhomTTHCRequest");

	PortletURL addNewUrl = renderResponse.createRenderURL();
	addNewUrl.setParameter("ActionType", "addNTTHCRequest");
	addNewUrl.setParameter("jspPage", "/html/portlet/document/setting/nhom_thu_tuc_hanh_chinh_add.jsp");

	String formGroup = ParamUtil.getString(request, "formGroup", "");
	String statusUD="";
	 
	if (Validator.isNull(formGroup)	&& renderRequest.getPortletSession().getAttribute("formGroup") != null)
	{
		formGroup = renderRequest.getPortletSession().getAttribute("formGroup").toString();
	}
	 
	 PortletURL iteratorUrl = renderResponse.createRenderURL();
	 iteratorUrl.setParameter("jspPage", "/html/portlet/document/setting/thu_tuc_hanh_chinh_list.jsp");
	 if (renderRequest.getParameter("formGroup") != null) {
		 iteratorUrl.setParameter("formGroup", formGroup);
	 }
	 addNewUrl.setParameter("formGroup", formGroup);
	 SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, iteratorUrl, null, "");

	// Get the search result from session if it exists
	 List<NhomThuTucHanhChinh>  result = new ArrayList<NhomThuTucHanhChinh>(); 
	
	 if (formGroup != null) {
		result = ThuTucHanhChinhBusiness.findByUngDungId(FormatUtil.convertToLong(formGroup));
	 }
	 else
	 {
		 result = ThuTucHanhChinhBusiness.findByUngDungId(0);
	 }

	if (result == null) {
		result = new ArrayList<NhomThuTucHanhChinh>();
	}

	List<NhomThuTucHanhChinh> newResults = ListUtil.subList(result,
			searchContainer.getStart(), searchContainer.getEnd());

	searchContainer.setTotal(result.size());
	searchContainer.setResults(newResults);
%>

<div class="egov-container">
<jsp:include page="/html/portlet/document/setting/tabs.jsp"		flush="false" />
<form name = "<portlet:namespace/>searchForm" method = "post" action = "<%=searchUrl%>">
<br>
<table   class="egov-table-form" style="width: 100%">
	<tbody>
		<tr>
		<td colspan="2" align = "left" width="40%"><select class="egov-select" name="formGroup"
			id="formGroup" onchange="document.<portlet:namespace/>searchForm.submit()">
				<option value="">--Lọc theo tất cả các nhóm--</option>
				<%
					List<DanhMucUngDung> groups = DanhMucUngDungLocalServiceUtil.getDSUngDung(0);
					for (DanhMucUngDung group : groups) {
				%>
				<option value="<%=group.getId()%>" <%=ThuTucHanhChinhBusiness.checkSelectedValue(formGroup, group.getId()) %>><%=group.getTen()%></option>
				<%
					}
				%>
		</select>
		</td>	
		<td style="text-align: right" width="60%">
		    	<input type="button" name="button" value="+ THÊM MỚI"  class="egov-button-normal" onclick="javascript: window.location = '<%=addNewUrl.toString() %>'"/>
		</td>
		</tr>
		  <tr>
			    <td>
			    	<liferay-ui:error key="errorDeleteNTTHC" message = "vn.dtt.cmon.document.setting.ntthc.error.delete"/>
			    	<%
				if (request.getAttribute("delete_success") != null && request.getAttribute("delete_success").toString().trim().length() > 0) {
					%>
					<liferay-ui:success key="successDeleteNTTHC" message="vn.dtt.cmon.document.setting.ntthc.completed.delete"/>
					<%
				}
				%>
			    </td>
			 </tr>
	</tbody>
</table>
</form>
<table cellpadding="0" cellspacing="0" class="egov-table" width="100%">
	<tbody>
		<tr>
			<th style="text-align:center">TT</th>
			<th>Tên nhóm thủ tục</th>
			<th style="text-align:center">Mã nhóm</th>
			<th style="width: 9%;text-align:center">Trạng thái</th>			
			<th style="text-align:center">Chức năng</th>
		</tr>
				<%
					int i = 0;
					for (NhomThuTucHanhChinh ntthc : newResults) {
						i++;
						
						PortletURL viewRequestUrl = renderResponse.createRenderURL();
						viewRequestUrl.setParameter("ActionType", ThuTucHanhChinhBusiness.VIEW_NHOM_TTHC);
						viewRequestUrl.setParameter("jspPage", "/html/portlet/document/setting/nhom_thu_tuc_hanh_chinh_add.jsp");
						viewRequestUrl.setParameter("nTTHCId", String.valueOf(ntthc.getId()));
						if (renderRequest.getParameter("formGroup") != null) {
							viewRequestUrl.setParameter("formGroup", formGroup);
						}
						
						PortletURL editRequestUrl = renderResponse.createRenderURL();
						editRequestUrl.setParameter("ActionType", "editNTTHCRequest");		
						editRequestUrl.setParameter("jspPage", "/html/portlet/document/setting/nhom_thu_tuc_hanh_chinh_add.jsp");
						editRequestUrl.setParameter("nTTHCId", String.valueOf(ntthc.getId()));
						if (renderRequest.getParameter("formGroup") != null) {
							editRequestUrl.setParameter("formGroup", formGroup);
						}
						
						PortletURL deleteUrl = renderResponse.createActionURL();
						deleteUrl.setParameter(ActionRequest.ACTION_NAME, "deleteNTTHCRequest");
						deleteUrl.setParameter("jspPage", "/html/portlet/document/setting/nhom_thu_tuc_hanh_chinh_list.jsp");
						deleteUrl.setParameter("nTTHCId", String.valueOf(ntthc.getId()));
						if (renderRequest.getParameter("formGroup") != null) {
							deleteUrl.setParameter("formGroup", formGroup);
						}
				%>
				<tr>
			<td style="text-align:center"><%=i%></td>
			<td><a href="<%=viewRequestUrl.toString()%>" class="bold"><%=ntthc.getTen()%></a></td>
			<td style="text-align:center"><%=ntthc.getMa()%></td>
			<%if(ntthc.getDaXoa()==1)
			{
				statusUD=LanguageUtil.get(pageContext,"vn.dtt.cmon.document.setting.ntthc.inactive.status");
			}
			else
			{
				statusUD=LanguageUtil.get(pageContext,"vn.dtt.cmon.document.setting.ntthc.active.status");
			}
				%>
			<td style="text-align:center">
			<%=statusUD %>
			<td width="10%">
				<table class="egov-table-function"
						style="text-align: center; width: 90px">
						<tbody>
							<tr>

								<td><a href="<%=editRequestUrl.toString()%>"><button
											class="egov-func-edit" title="Chỉnh sửa"></button></a></td>
								<td><!--<button class="egov-func-delete" title="Xóa"
										onclick="javascript:<portlet:namespace/>deleteRow('<%=deleteUrl.toString()%>')"></button>--></td>
							</tr>
						</tbody>
					</table>
			</td>
		</tr>
		
		<%} %>	
	</tbody>
</table>
	
</div>
<script type="text/javascript">
function <portlet:namespace/>deleteRow(url) {
	var answer = confirm('<%=LanguageUtil.get(pageContext, "vn.dtt.cmon.document.setting.ntthc.confirm.delete") %>');
	if (answer){
		window.location = url;
	}
}
</script>