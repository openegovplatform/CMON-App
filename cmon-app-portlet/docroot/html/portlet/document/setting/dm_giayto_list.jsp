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
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung"%>
<%@page import="org.oep.sharedservice.cmon.Constants"%>
<%@page
	import="org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.admin.portlet.business.LoaiDoiTuongBusiness"%>
<%@page import="org.oep.cmon.dao.dvc.model.DoiTuongSuDung"%>
<%@page
	import="org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.tlct.model.DanhMucGiayTo"%>
<%@page
	import="org.oep.cmon.portlet.document.util.DocumentConstants"%>
<%@page import="org.oep.cmon.portlet.document.business.DanhMucGiayToBusiness"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/init.jsp"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	PortletURL searchUrl = renderResponse.createActionURL();
	searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchDocument");
	
	PortletURL addNewUrl = renderResponse.createRenderURL();
	addNewUrl.setParameter("ActionType", "editOrAddDMGTRequest");
	addNewUrl.setParameter("jspPage", "/html/portlet/document/setting/dm_giayto_add.jsp");
	
	String keyWord = ParamUtil.getString(request,"searchKeyWord", "");
	String doituongGroup= ParamUtil.getString(request,"doituongGroup","");
	String statusUD="";
	
	// Get default search value
	String defaultSearch = LanguageUtil.get(pageContext, "org.oep.cmon.document.setting.dmgt.search.defaultValue");
		
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage",
	"/html/portlet/document/setting/dm_giayto_list.jsp");	
	 if (Validator.isNotNull(keyWord)) {
		 iteratorUrl.setParameter("searchKeyWord", keyWord);
	 }
	 if (Validator.isNotNull(doituongGroup)) {
		 iteratorUrl.setParameter("doituongGroup", doituongGroup);
	 }	 
	 addNewUrl.setParameter("searchKeyWord", keyWord);
	 addNewUrl.setParameter("doituongGroup", doituongGroup);
	
	int cur =  Integer.valueOf(prefs.getValue("curDMGT", "1"));
	int delta =  Integer.valueOf(prefs.getValue("deltaDMGT", "10"));
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
	
	SearchContainer searchContainer = new SearchContainer(renderRequest, null,
	null, SearchContainer.DEFAULT_CUR_PARAM,
	cur, delta, iteratorUrl, null, null);

	List<DanhMucGiayTo> result = null;
	
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();	
	Long longTotal=DanhMucGiayToLocalServiceUtil.countDanhMucGiayTo(keyWord, FormatUtil.convertToLong(doituongGroup));
	result = DanhMucGiayToLocalServiceUtil.searchDanhMucGiayTo(keyWord,	FormatUtil.convertToLong(doituongGroup), start, end/*(int)DanhMucGiayToLocalServiceUtil.countDanhMucGiayTo(keyWord, doituongGroup)*/);

	if (result == null) {
		result = new ArrayList<DanhMucGiayTo>();
	}

	List<DoiTuongSuDung> lstDoiTuong = new ArrayList<DoiTuongSuDung>();
	lstDoiTuong = DoiTuongSuDungLocalServiceUtil
			.getDSDoiTuongSuDung(Constants.ACTIVATED);
	
	searchContainer.setTotal(longTotal.intValue());
	searchContainer.setResults(result);
	
	
%>
<div class="egov-container">
	<form name="<portlet:namespace/>searchForm" method="post" action="<%=searchUrl%>" onsubmit = "<portlet:namespace/>checkForm()">
		<br>
			<table   class="egov-table-form" style="width: 100%">
			<tbody>
				<tr>
					<td align = "left"  style="width:23%">
						<input name="searchKeyWord" type="text"  class="egov-inputfield-search" size="40" style="width: 200px;" value = "<%=HtmlUtil.escape(keyWord)%>" placeholder="<%=defaultSearch%>"/>
			     	</td>
					<td align = "left" style="width:20%" ><select class="egov-select" style="width: 190px" name="doituongGroup"
						id="doituongGroup" onchange="document.<portlet:namespace/>searchForm.submit()">
							<option value="">--Lọc tất cả các nhóm--</option>
							<%
								for (DoiTuongSuDung doiTuong : lstDoiTuong) {
							%>
							<option value="<%=doiTuong.getId()%>"
								<%=DanhMucGiayToBusiness.checkSelectedValue(doituongGroup, doiTuong.getId())%> ><%=doiTuong.getTen()%></option>

							<%
								}
							%>

					</select></td>
					<td align = "left"><span style="padding-left: 5px"><input type="submit" name="button" value=""  class="egov-button-search" /></span></td>
					<td align="right" width="50%" style="text-align: right">
			    	<input type="button" name="button" value="+ THÊM MỚI"  class="egov-button-normal" onclick="javascript: window.location = '<%=addNewUrl.toString() %>'"/>
			    </td>
				</tr>
		  		<tr>
			    <td>
			    	<liferay-ui:error key="errorDeleteDMGT" message = "org.oep.cmon.document.setting.dmgt.error.delete"/>
			    	<%
				if (request.getAttribute("delete_success") != null && request.getAttribute("delete_success").toString().trim().length() > 0) {
					%>
					<liferay-ui:success key="successDeleteDMGT" message="org.oep.cmon.document.setting.dmgt.completed.delete"/>
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
					<th  width="5%" style="text-align:center">STT</th>
					<th  width="65%">Tên tài liệu</th>
					<th	 width="5%" style="text-align:center">Mã</th>
					<th	 width="20%" style="text-align:center">Đối tượng sử dụng</th>					
					<th	 width="5%" style="text-align:center">Chức năng</th>
				</tr>
				<tr>
					<%
					List items = result;//searchContainer.getResultRows();
					List<DoiTuongSuDung> groupDMDT = DoiTuongSuDungLocalServiceUtil.getDSDoiTuongSuDung(DocumentConstants.ACTIVE);
					for (int i = 0; i < result.size(); i++) {
						DanhMucGiayTo danhMucGiayTo = (DanhMucGiayTo) items.get(i);
						
						PortletURL viewRequestUrl = renderResponse.createRenderURL();
						viewRequestUrl.setParameter("ActionType", DanhMucGiayToBusiness.VIEW_DM_GIAYTO);
						viewRequestUrl.setParameter("jspPage", "/html/portlet/document/setting/dm_giayto_add.jsp");
						viewRequestUrl.setParameter("dMGTId", String.valueOf(danhMucGiayTo.getId()));
						viewRequestUrl.setParameter("searchKeyWord", keyWord);
						viewRequestUrl.setParameter("doituongGroup", doituongGroup);
						 
						PortletURL editRequestUrl = renderResponse.createRenderURL();
						editRequestUrl.setParameter("ActionType", "editDMGTRequest");		
						editRequestUrl.setParameter("jspPage", "/html/portlet/document/setting/dm_giayto_add.jsp");
						editRequestUrl.setParameter("dMGTId", String.valueOf(danhMucGiayTo.getId()));
						editRequestUrl.setParameter("searchKeyWord", keyWord);
						editRequestUrl.setParameter("doituongGroup", doituongGroup);
						
						PortletURL deleteUrl = renderResponse.createActionURL();
						deleteUrl.setParameter(ActionRequest.ACTION_NAME, "deleteDMGTRequest");
						deleteUrl.setParameter("jspPage", "/html/portlet/document/setting/dm_giayto_list.jsp");
						deleteUrl.setParameter("dMGTId", String.valueOf(danhMucGiayTo.getId()));
						deleteUrl.setParameter("searchKeyWord", keyWord);
						deleteUrl.setParameter("doituongGroup", doituongGroup);
						
					%>
					<td style="text-align:center"><%=(searchContainer.getStart()+i+1)%></td>
					<td align="left"><a href="<%=viewRequestUrl.toString()%>" class="bold"><%=danhMucGiayTo.getTen()%></a></td>
					<td style="text-align:center"><%=danhMucGiayTo.getMa()%></td>
					<td style="text-align: left">
						<%
										List<DanhMucGiayTo2DoiTuongSuDung> docList = DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil
													.getTheoLoaiGT_DSDMGT2DTSD(danhMucGiayTo.getId());
						
											int idx = 0;
											String selectedGroup = null;
											for (DanhMucGiayTo2DoiTuongSuDung doc:docList ) {
												idx++;
												selectedGroup = "";
												for (DoiTuongSuDung group : groupDMDT) {
												if (doc.getLoaiDoiTuongId() == group.getId()) {
													selectedGroup = group.getTen();
												}
										%> <%}%>
						<p><%=idx %>.
							<%=selectedGroup %></p> <% }%>
					</td>
					<td >
						<table class="egov-table-function">
							<tbody>
								<tr>
									<td >
				<table class="egov-table-function"
						style="text-align: center;">
						<tbody>
							<tr>
								<td><a href="<%=editRequestUrl.toString()%>"><button
											class="egov-func-edit" title="Chỉnh sửa"></button></a></td>
								<td><button class="egov-func-delete" title="Xóa"
										onclick="javascript:<portlet:namespace/>deleteRow('<%=deleteUrl.toString()%>')"></button> </td>
							</tr>
						</tbody>
					</table>
				</td>
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
	var answer = confirm('<%=LanguageUtil.get(pageContext, "org.oep.cmon.document.setting.dmgt.confirm.delete") %>');
	if (answer){
		window.location = url;
	}
}
</script>
