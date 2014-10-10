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
<%@page import="com.liferay.portal.SystemException"%>
<%@page import="com.liferay.portal.NoSuchRepositoryEntryException"%>
<%@page import="org.oep.sharedservice.cmon.provider.storage.DocumentStorageImpl"%>
<%@page import="org.oep.sharedservice.cmon.provider.storage.IDocumentStorage"%>
<%@page import="org.oep.cmon.dao.nsd.model.impl.TaiKhoanNguoiDungImpl"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.sharedservice.cmon.SharedserviceUtil"%>
<%@page import="org.oep.sharedservice.cmon.provider.thamso.ThamSoServiceImpl"%>
<%@page import="org.oep.sharedservice.cmon.provider.thamso.IThamSoService"%>
<%@page import="org.oep.cmon.dao.tlct.model.TaiLieuChungThuc"%>
<%@page import="org.oep.cmon.portlet.document.action.CitizenDocumentPortlet"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.util.Helpers"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
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
int cur =  Integer.valueOf(prefs.getValue("curCTCD", "1"));
int delta =  Integer.valueOf(prefs.getValue("deltaCTCD", String.valueOf(Constants.Paging.DELTA)));
int curnext = ParamUtil.getInteger(renderRequest, "cur", 1);
int deltanext = ParamUtil.getInteger(renderRequest, "delta", Constants.Paging.DELTA);
if(curnext!=cur) {
	cur = curnext;
}
if(deltanext!=delta) {
	delta = deltanext;
}
long doiTuongId = ParamUtil.getLong(renderRequest, "doiTuongId");
long congDanId = ParamUtil.getLong(renderRequest, "congDanId");
if(doiTuongId <= 0) {
	try {
		IThamSoService  thamSo = new ThamSoServiceImpl();
		doiTuongId = (thamSo == null) ? 1	: FormatUtil.convertToLong(thamSo.getValue(Constants.TS_CONG_DAN));
	} catch (Exception e) {

	}
}
if(congDanId <= 0) {
	try {
		long liferay_user = PortalUtil.getUserId(request);
		TaiKhoanNguoiDung tkUser = new TaiKhoanNguoiDungImpl(); 
		tkUser = SharedserviceUtil.getTaiKhoanNguoiDungByLiferayId(liferay_user);
		congDanId = (tkUser == null) ? 0	: tkUser.getId();
	} catch (Exception e) {

	}
}

String searchKeyWord = ParamUtil.getString(renderRequest, "searchKeyWord", "");
if (Helpers.isEmpty(searchKeyWord) && renderRequest.getPortletSession().getAttribute("searchKeyWord") != null) {
	searchKeyWord = renderRequest.getPortletSession().getAttribute("searchKeyWord").toString();
}

CitizenDocumentPortlet portlet = new CitizenDocumentPortlet();

PortletURL addUrl = renderResponse.createActionURL();
addUrl.setParameter(ActionRequest.ACTION_NAME, "addChungThucCongDan");
addUrl.setParameter("jspPage", "/html/portlet/document/citizen/citizen_document_form.jsp");
portlet.setSearchParameter(addUrl, cur, delta);

PortletURL searchUrl = renderResponse.createActionURL();
searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchChungThucCongDan");
searchUrl.setParameter("jspPage", "/html/portlet/document/citizen/citizen_document_list.jsp");

%>
<div class="egov-container" >
	<form name = "<portlet:namespace/>searchCTTLCongDanForm" method="post" action="<%=searchUrl%>">
	<input type="hidden" name="doiTuongId" value="<%=doiTuongId%>">
	<input type="hidden" name="congDanId" value="<%=congDanId%>">
		<table class="egov-table-form2" style="width: 100%">
		  <tr>
		    <td align="left" width="30%">
		    	<input name="searchKeyWord" style="width: 90%;" type="text" value="<%=HtmlUtil.escape(searchKeyWord) %>" class="egov-inputfield-search" placeholder="<liferay-ui:message key="vn.dtt.cmon.document.citizen.list.search.ten.placeholder"/>" />
		    </td>
		    <td align="left" valign="middle">
		 		<input type="submit" value="Tìm kiếm" title="<liferay-ui:message key="vn.dtt.cmon.document.citizen.list.search.submit"/>" class="egov-button-search" />
		 	</td>	
		 	<td align="left" valign="middle" width="90%">	
		 		<input type="button" value="<liferay-ui:message key="vn.dtt.cmon.document.citizen.list.add"/>" class="egov-button-normal" onclick="javascript: window.location='<%=addUrl.toString() %>'" style="float: right; margin-top: 10px;" />
		 	</td>			 	
		  </tr>
		  <tr>
		    <td colspan="3">
		    	<liferay-ui:error key="notExist" message = "vn.dtt.cmon.document.citizen.error.notexist"/>
				<liferay-ui:error key="errorDelete" message = "vn.dtt.cmon.document.citizen.error.delete"/>
				<liferay-ui:success key="successDelete" message = "vn.dtt.cmon.document.citizen.completed.delete"/>
		    </td>
		 </tr>
		</table>
	</form>
	<%
		PortletURL iteratorUrl = renderResponse.createRenderURL();
		iteratorUrl.setParameter("jspPage", "/html/portlet/document/citizen/citizen_document_list.jsp");
		
		if(!Helpers.isEmpty(searchKeyWord)) {
			iteratorUrl.setParameter("searchKeyWord", searchKeyWord);
		}
		
	%>
	<table cellpadding="0" cellspacing="0" class="egov-table" width="100%">
	<thead>
		<tr>
			<th width="5%"><liferay-ui:message key="vn.dtt.cmon.document.citizen.list.header.stt"/></th>
			<th width="38%"><liferay-ui:message key="vn.dtt.cmon.document.citizen.list.header.ten"/></th>
			<th width="5%"><liferay-ui:message key="vn.dtt.cmon.document.citizen.list.header.ma"/></th>
			<th width="7%">Hiệu lực từ ngày</th>
			<th width="7%">Hiệu lực đến ngày</th>
			<th width="3%">Phiên bản</th>
			<th width="12%"><liferay-ui:message key="vn.dtt.cmon.document.citizen.list.header.trangthai"/></th>
			<th width="6%">Ngày tải tài liệu</th>
			<th width="18%" style="text-align: center;"><liferay-ui:message key="vn.dtt.cmon.document.citizen.list.header.chucnang"/></th>
		</tr>
	</thead>
	<tbody>
		<%
		SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, cur, delta, iteratorUrl, null, null);
		int start = searchContainer.getStart();
		int end = searchContainer.getEnd();
		
		List<TaiLieuChungThuc> list = portlet.listTaiLieuChungThuc(searchKeyWord, congDanId, doiTuongId, start, end);
		long count = portlet.countTaiLieuChungThuc(searchKeyWord, congDanId, doiTuongId);
		
		searchContainer.setTotal((int)count);
		searchContainer.setResults(list);
		
		if(!Helpers.isEmpty(list)) {
			for (int i = 0; i < list.size(); i++) {
				TaiLieuChungThuc taiLieuChungThuc = list.get(i);
				
				PortletURL viewUrl = renderResponse.createActionURL();
				viewUrl.setParameter(ActionRequest.ACTION_NAME, "viewChungThucCongDan");
				viewUrl.setParameter("jspPage", "/html/portlet/document/citizen/citizen_document_history.jsp");
				viewUrl.setParameter("id", String.valueOf(taiLieuChungThuc.getId()));
				viewUrl.setParameter("doiTuongId", String.valueOf(doiTuongId));
				viewUrl.setParameter("danhMucGiayToId", String.valueOf(taiLieuChungThuc.getDanhMucGiayToId()));
				portlet.setSearchParameter(viewUrl, cur, delta);
				
				PortletURL deleteUrl = renderResponse.createActionURL();
				deleteUrl.setParameter(ActionRequest.ACTION_NAME, "deleteChungThucCongDan");
				deleteUrl.setParameter("jspPage", "/html/portlet/document/citizen/citizen_document_list.jsp");
				deleteUrl.setParameter("id", String.valueOf(taiLieuChungThuc.getId()));
				deleteUrl.setParameter("doiTuongId", String.valueOf(doiTuongId));
				viewUrl.setParameter("danhMucGiayToId", String.valueOf(taiLieuChungThuc.getDanhMucGiayToId()));
				portlet.setSearchParameter(deleteUrl, cur, delta);
				
				PortletURL editUrl = renderResponse.createActionURL();
				editUrl.setParameter(ActionRequest.ACTION_NAME, "editChungThucCongDan");
				editUrl.setParameter("jspPage", "/html/portlet/document/citizen/citizen_document_form.jsp");
				editUrl.setParameter("id", String.valueOf(taiLieuChungThuc.getId()));
				editUrl.setParameter("doiTuongId", String.valueOf(doiTuongId));
				viewUrl.setParameter("danhMucGiayToId", String.valueOf(taiLieuChungThuc.getDanhMucGiayToId()));
				portlet.setSearchParameter(editUrl, cur, delta);
				
				long fileUploadId = taiLieuChungThuc.getNoiLuuTruId();	
				int version = taiLieuChungThuc.getPhienBan();
				
				
				IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
				String urlFileUpload="#";
				if(fileUploadId>0)
				{
					try
					{
						urlFileUpload=iDocumentStorage.getURLById(fileUploadId);
					}
					catch(Exception e)
					{
						//not Found File Download
						//e.printStackTrace();
						urlFileUpload="#";
					}
					
				}
		%>
		<tr>
			<td style="text-align: center;"><%=(start + i + 1)%></td>
			<td style="text-align: left;"><%=HtmlUtil.escape(taiLieuChungThuc.getTen()) %></td>
			<td style="text-align: center;"><%=HtmlUtil.escape(taiLieuChungThuc.getGhiChu()) %></td>
			<td style="text-align: center;"><%=HtmlUtil.escape(FormatUtil.getFormatDate(taiLieuChungThuc.getHieuLucTuNgay())) %></td>
			<td style="text-align: center;"><%=HtmlUtil.escape(FormatUtil.getFormatDate(taiLieuChungThuc.getHieuLucDenNgay())) %></td>
			<td style="text-align: center;"><%=version %></td>
			<td style="text-align: center;">
			<%
					String classTrangThai = "red";
					String strToolTip="";
					if (taiLieuChungThuc.getTrangThai() == Constants.Citizen.TrangThai_Moi) {
						classTrangThai = "red";
					} else if (taiLieuChungThuc.getTrangThai() == Constants.Citizen.TrangThai_ChungThuc) {
						strToolTip = LanguageUtil.get(pageContext, "vn.dtt.cmon.document.citizen.hieuluc");
						if(taiLieuChungThuc.getHieuLucTuNgay()!=null)
						{
							strToolTip +=" " + LanguageUtil.get(pageContext, "vn.dtt.cmon.document.citizen.tungay")+" "+FormatUtil.getFormatDate(taiLieuChungThuc.getHieuLucTuNgay()) ;
						}
						if(taiLieuChungThuc.getHieuLucDenNgay()!=null)
						{
							strToolTip +=" " + LanguageUtil.get(pageContext, "vn.dtt.cmon.document.citizen.dengay")+" "+FormatUtil.getFormatDate(taiLieuChungThuc.getHieuLucDenNgay()) ;
						}
						else
						{
							strToolTip +=" " + LanguageUtil.get(pageContext, "vn.dtt.cmon.document.citizen.vohan");
						}
						classTrangThai = "yellow";
					}  else if (taiLieuChungThuc.getTrangThai() == Constants.Citizen.TrangThai_TuChoi) {
						classTrangThai = "gray";
					}	else if (taiLieuChungThuc.getTrangThai() == Constants.Citizen.TrangThai_XoaTam) {
						classTrangThai = "green";
					} else if (taiLieuChungThuc.getTrangThai() == Constants.Citizen.TrangThai_KQDVC){
						classTrangThai = "blue";
					}
				%>
			
				<span class="egov-status-<%=classTrangThai%>" title="<%=strToolTip%>">
					<%=LanguageUtil.get(pageContext, "vn.dtt.cmon.document.citizen.trangthai."+taiLieuChungThuc.getTrangThai()) %>
				</span>
			</td>
			
			<td style="text-align: center;"><%=HtmlUtil.escape(FormatUtil.getFormatDate(taiLieuChungThuc.getNgayUpload())) %></td>
			<td style="text-align: center;">
				
						<a href="<%=editUrl.toString()%>" style="padding: 0px">
								<button class="egov-func-upload" title="<liferay-ui:message key="vn.dtt.cmon.document.citizen.list.item.upload"/>"></button>
						</a>
						<a href="<%=urlFileUpload=="" ?"#":urlFileUpload%>" style="padding: 0px">
						<button class="egov-func-download" title="<liferay-ui:message key="vn.dtt.cmon.document.citizen.list.item.down"/>"></button>
						</a>
						<a href="<%=viewUrl.toString()%>" style="padding: 0px"><button class="egov-func-history" title="<liferay-ui:message key="vn.dtt.cmon.document.citizen.list.item.view"/>"></button></a>
						<%
						if (taiLieuChungThuc.getTrangThai() == Constants.Citizen.TrangThai_Moi) {
						%>
						<a href="javascript: <portlet:namespace/>deleteChungThucCongDan('<%=deleteUrl.toString()%>');" style="padding: 0px"><button class="egov-func-delete" title="<liferay-ui:message key="vn.dtt.cmon.document.citizen.list.item.delete"/>"></button></a>
						<%
						}
						%>
					
			</td>
		</tr>
		<%	}
		} else {%>
		<tr>
		  	<td colspan="6" align="center"><label class="egov-label">
				<liferay-ui:message key="vn.dtt.cmon.document.citizen.list.search.noData"/>
			</label></td>
		</tr>
		<% } %>
	</tbody>
	</table>
	<div id="pagination">
		<liferay-ui:search-paginator searchContainer="<%=searchContainer%>" />
	</div>
</div>
<script type="text/javascript">
function <portlet:namespace/>deleteChungThucCongDan(url) {
	var answer = confirm('<%=LanguageUtil.get(pageContext, "vn.dtt.cmon.document.citizen.confirm.delete") %>');
	if (answer){
		window.location = url;
	}
}

</script>