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
<%@page import="org.oep.cmon.portlet.document.business.DanhMucGiayToBusiness"%>
<%@page import="org.oep.cmon.portlet.document.util.DocumentConstants"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTuc2GiayToLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.document.business.ThuTucHanhChinhBusiness"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="/html/portlet/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<portlet:actionURL var="searchTTHC" name="searchTTHC">
	<portlet:param name="jspPage" value="/html/portlet/document/setting/thu_tuc_hanh_chinh_list.jsp"/>	
</portlet:actionURL>	

<%
	PortletURL searchURL = renderResponse.createActionURL();
	searchURL.setParameter(ActionRequest.ACTION_NAME, "searchTTHC");	
		
	PortletURL addNewUrl = renderResponse.createRenderURL();
	addNewUrl.setParameter("ActionType", "editOrAddTTHCRequest");
	addNewUrl.setParameter("jspPage", "/html/portlet/document/setting/thu_tuc_hanh_chinh_add.jsp");
	
	Long ungDung = ParamUtil.getLong(request,"ungDung");
	Long nhomTTHC= ParamUtil.getLong(request,"nhomTTHC");
	Long ungDungId = ungDung == 0L ? null:ungDung;
	Long nhomTTHCId = nhomTTHC == 0L ? null:nhomTTHC;
	String statusTTHC="";
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/html/portlet/document/setting/thu_tuc_hanh_chinh_list.jsp");
	 if (renderRequest.getParameter("ungDung") != null) {
		 iteratorUrl.setParameter("ungDung", String.valueOf(ungDung));
	 }
	 if (renderRequest.getParameter("nhomTTHC") != null) {
		 iteratorUrl.setParameter("nhomTTHC", String.valueOf(nhomTTHC));
	 }	 
	
	if(ungDung!=null)
	{
	 	addNewUrl.setParameter("ungDungId", String.valueOf(ungDung));	
	}
	if(nhomTTHC!=null)
	{
		addNewUrl.setParameter("nhomTTHCId", String.valueOf(nhomTTHC));	
	}
	int cur =  Integer.valueOf(prefs.getValue("curTTHC", "1"));
	int delta =  Integer.valueOf(prefs.getValue("deltaTTHC", "10"));
	//int count =  Integer.valueOf(prefs.getValue("count", "10"));
	int curnext = ParamUtil.getInteger(renderRequest, "cur", 1);
	int deltanext = ParamUtil.getInteger(renderRequest, "delta", 10);
	if(curnext!=cur)
	{
		cur=curnext;
	}
	if(deltanext!=delta)
	{
		delta=deltanext;
	}
	List<ThuTucHanhChinh> results = null;
	
	Long size = ThuTucHanhChinhLocalServiceUtil.countByUngDungOrNhom(ungDungId, nhomTTHCId);
	
	SearchContainer searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			cur, delta, iteratorUrl, null, null);
	
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	
	
	if (size.intValue() > 0) {
		results=ThuTucHanhChinhLocalServiceUtil.searchByUngDungOrNhom(ungDungId, nhomTTHCId, start, end);
		
	}
	if (results == null) {
		results = new ArrayList<ThuTucHanhChinh>();
	}
	
	searchContainer.setTotal(size.intValue());
	searchContainer.setResults(results); 
		
	String updateThanhcong = ParamUtil.getString(request, "CompletedUpdatePortlet2TTHC");
%>
<div class="egov-container">
<jsp:include page="/html/portlet/document/setting/tabs.jsp"
		flush="false" />
<form name="<portlet:namespace/>searchTTHCForm" method="post" action="<%=searchURL%>" >
<br>
<table   cellpadding="0" cellspacing="0" class="egov-table-form" style="width: 100%;table-layout: fixed;">
	<tbody>
		<tr>
			
			<td width="60%">
			<%if (request.getAttribute("CompletedUpdatePortlet2TTHC") != null && request.getAttribute("CompletedUpdatePortlet2TTHC").toString().trim().length() > 0) {%>
			<liferay-ui:success key="CompletedUpdatePortlet2TTHC" message="Update tên portlet thành công"/>
			<%} %>
			<liferay-ui:success key="luuCauHinhLienThongThanhCong" message="Lưu cấu hình liên thông thành công"/>
			</td>
		</tr>	
		<tr>
			
			<td width="20%">
					<select class="egov-select" name="ungDung"
						id="ungDung" onchange="javascript:<portlet:namespace/>checkForm();">
							<option value="">--Chọn ứng dụng--</option>
							<%
								List<DanhMucUngDung> groups = DanhMucUngDungLocalServiceUtil.getDSUngDung(0);
								if (groups.size() > 0){
								for (DanhMucUngDung group : groups) {
							%>
								<option value="<%=group.getId()%>" <%=ThuTucHanhChinhBusiness.checkSelectedValue(group.getId(), ungDungId)%>>							
								<%=group.getTen()%>
								</option>
							<%
								}}
							%>
					</select>
			</td>
			<td width="20%" style="padding-left: 5px;">
					<select class="egov-select" name="nhomTTHC"
						id="nhomTTHC" onchange="document.<portlet:namespace/>searchTTHCForm.submit()">
							<option value="">--Chọn nhóm TTHC--</option>
							<%
							if(ungDungId!=null)
							{
								List<NhomThuTucHanhChinh> gpTTHC = NhomThuTucHanhChinhLocalServiceUtil.getDSNhomThuTucHanhChinhBoiUngDung(ungDungId, 0);
								

								for (NhomThuTucHanhChinh grp : gpTTHC) {
									
							%>
								<option value="<%=grp.getId()%>" <%= ThuTucHanhChinhBusiness.checkSelectedValue(grp.getId(), nhomTTHCId) %> >							
									<%=grp.getTen()%>
								</option>
							<%
								}
							}
							%>
					</select>
			</td>			
			<td align="right" width="60%">			
			<input type="button"
				class="egov-button-normal" value="Thêm mới" style="float: right;" onclick="javascript: window.location = '<%=addNewUrl.toString() %>'"></td>
		</tr>
		  <tr>
			    <td colspan="3">
			    	<liferay-ui:error key="errorDeleteTTHC" message = "org.oep.cmon.document.setting.tthc.error.delete"/>
			    	<%
				if (request.getAttribute("delete_success") != null && request.getAttribute("delete_success").toString().trim().length() > 0) {
					%>
					<liferay-ui:success key="successDeleteTTHC" message="org.oep.cmon.document.setting.tthc.completed.delete"/>
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
			<th width="8%" style="text-align:center">TT</th>
			<th width="55%">Tên tài liệu</th>
			<th width="10%" style="text-align:center">Ứng dụng</th>
			<th width="10%" style="text-align:center">Trạng thái</th>
			<th width="17%" style="text-align:center"> Chức năng</th>
		</tr>
		<%
		
		List items = results;
		for (int i = 0; i < results.size(); i++) {
			ThuTucHanhChinh tthc = (ThuTucHanhChinh) items.get(i);
						
			PortletURL viewRequestUrl = renderResponse.createRenderURL();
			viewRequestUrl.setParameter("ActionType", ThuTucHanhChinhBusiness.VIEW_TTHC);
			viewRequestUrl.setParameter("jspPage", "/html/portlet/document/setting/thu_tuc_hanh_chinh_add.jsp");
			viewRequestUrl.setParameter("tthcId", String.valueOf(tthc.getId()));			
			if(ungDung!=null)
			{
				viewRequestUrl.setParameter("ungDungId", String.valueOf(ungDung));	
			}
			if(nhomTTHC!=null)
			{
				viewRequestUrl.setParameter("nhomTTHCId", String.valueOf(nhomTTHC));	
			}
			PortletURL editRequestUrl = renderResponse.createRenderURL();
			editRequestUrl.setParameter("ActionType", "editTTHCRequest");		
			editRequestUrl.setParameter("jspPage", "/html/portlet/document/setting/thu_tuc_hanh_chinh_add.jsp");
			editRequestUrl.setParameter("tthcId", String.valueOf(tthc.getId()));
			if(ungDung!=null)
			{
				editRequestUrl.setParameter("ungDungId", String.valueOf(ungDung));	
			}
			if(nhomTTHC!=null)
			{
				editRequestUrl.setParameter("nhomTTHCId", String.valueOf(nhomTTHC));	
			}
			
			PortletURL deleteUrl = renderResponse.createActionURL();
			deleteUrl.setParameter(ActionRequest.ACTION_NAME, "deleteTTHCRequest");
			deleteUrl.setParameter("jspPage", "/html/portlet/document/setting/thu_tuc_hanh_chinh_list.jsp");
			deleteUrl.setParameter("tthcId", String.valueOf(tthc.getId()));
			if(ungDung!=null)
			{
				deleteUrl.setParameter("ungDungId", String.valueOf(ungDung));	
			}
			if(nhomTTHC!=null)
			{
				deleteUrl.setParameter("nhomTTHCId", String.valueOf(nhomTTHC));	
			}
		%>
		<tr>
			<td style="text-align: center"><%=(searchContainer.getStart()+i+1)%></td>
			<td><a href="<%=viewRequestUrl.toString()%>" class="bold"><%=tthc.getTen()%></a></td>
			<td style="text-align: center">
			<%=tthc.getNguoiTao() %>
			</td>
			<%
			if(tthc.getTrangThai() == 1) {
					statusTTHC = LanguageUtil
							.get(pageContext,
									"org.oep.cmon.document.setting.tthc.active.status");
				} else {
					statusTTHC = LanguageUtil.get(pageContext,
							"org.oep.cmon.document.setting.tthc.inactive.status");
			}
			%>
			<td style="text-align: center"><%=statusTTHC%></td>
			<td width="10%">
				<table class="egov-table-function">
					<tbody>
						<tr>
							<td><button class="egov-func-delete" title="Xóa" onclick="javascript:<portlet:namespace/>deleteRow('<%=deleteUrl.toString()%>')"></button></td>
							<td><a href="<%=editRequestUrl.toString()%>"><button class="egov-func-edit" title="Chỉnh sửa"></button></a></td>
							<%
							PortletURL searchDMGTUrl = renderResponse.createRenderURL();							
							searchDMGTUrl.setParameter("tthcId", String.valueOf(tthc.getId()));
							searchDMGTUrl.setParameter("ungDung", String.valueOf(ungDung));
							searchDMGTUrl.setParameter("nhomTTHC", String.valueOf(nhomTTHC));
							searchDMGTUrl.setParameter("jspPage",
									"/html/portlet/document/setting/cau_hinh_danh_muc_giay_to.jsp");
							
							PortletURL searchCQQLYUrl = renderResponse.createRenderURL();						
							searchCQQLYUrl.setParameter("tthcId", String.valueOf(tthc.getId()));
							searchCQQLYUrl.setParameter("ungDung", String.valueOf(ungDung));
							searchCQQLYUrl.setParameter("nhomTTHC", String.valueOf(nhomTTHC));
							searchCQQLYUrl.setParameter("jspPage",
									"/html/portlet/document/setting/cau_hinh_co_quan_quan_ly.jsp");
							
							PortletURL searchHDBMUrl = renderResponse.createRenderURL();							
							searchHDBMUrl.setParameter("tthcId", String.valueOf(tthc.getId()));
							searchHDBMUrl.setParameter("ungDung", String.valueOf(ungDung));
							searchHDBMUrl.setParameter("nhomTTHC", String.valueOf(nhomTTHC));
							searchHDBMUrl.setParameter("jspPage",
									"/html/portlet/document/setting/cau_hinh_huong_dan_bieu_mau.jsp");
							
							PortletURL cauHinhPortletUrl = renderResponse.createRenderURL();							
							cauHinhPortletUrl.setParameter("tthcId", String.valueOf(tthc.getId()));
							cauHinhPortletUrl.setParameter("ungDung", String.valueOf(ungDung));
							cauHinhPortletUrl.setParameter("nhomTTHC", String.valueOf(nhomTTHC));
							cauHinhPortletUrl.setParameter("jspPage",
									"/html/portlet/document/setting/cau_hinh_portlet.jsp");
							
							PortletURL cauHinhLienThongUrl = renderResponse.createRenderURL();							
							cauHinhLienThongUrl.setParameter("thuTucId", String.valueOf(tthc.getId()));
							cauHinhLienThongUrl.setParameter("backURL", PortalUtil.getCurrentCompleteURL(request));
							cauHinhLienThongUrl.setParameter("jspPage",
									"/html/portlet/document/setting/cau_hinh_lien_thong.jsp");
							
							%>
							<td><a href="<%=searchDMGTUrl.toString()%>"><button type="button" class="egov-func-copy" title="Cấu hình danh mục giấy tờ" ></button></a></td>
							<td><a href="<%=searchCQQLYUrl.toString()%>"><button type="button" class="egov-func-config" title="Cấu hình cơ quan quản lý" ></button></a></td>
							<td><a href="<%=searchHDBMUrl.toString()%>"><button type="button" class="egov-func-history" title="Cấu hình hướng dẫn và biểu mẫu" ></button></a></td>											
							<td><a href="<%=cauHinhPortletUrl.toString()%>"><button type="button" class="egov-func-calendar" title="Cấu hình portlet" ></button></a></td>
							<td><a href="<%=cauHinhLienThongUrl.toString()%>"><button style="vertical-align: inherit; border: none;" type="button" class="icon-19" title="Cấu hình thủ tục liên thông" ></button></a></td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
		<%
		}
		%>
	</tbody>
</table>

<div id="pagination">
			<liferay-ui:search-paginator searchContainer="<%=searchContainer%>" />
		</div>
</div>
<script type="text/javascript">
function <portlet:namespace/>deleteRow(url) {
	var answer = confirm('<%=LanguageUtil.get(pageContext, "org.oep.cmon.document.setting.tthc.confirm.delete") %>');
	if (answer){
		window.location = url;
	}
}
function <portlet:namespace/>checkForm(){
	var form = document.<portlet:namespace/>searchTTHCForm;
	
	if (form.ungDung.options.selectedIndex > 0){
		form.nhomTTHC.options.selectedIndex = 0;
	}

	form.nhomTTHC.options.selectedIndex = 0;
	form.submit();
};
</script>
