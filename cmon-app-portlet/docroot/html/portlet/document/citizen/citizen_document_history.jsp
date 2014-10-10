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
<%@page import="org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil"%>
<%@page import="org.oep.sharedservice.cmon.provider.storage.IDocumentStorage"%>
<%@page import="org.oep.sharedservice.cmon.provider.storage.DocumentStorageImpl"%>
<%@page import="org.oep.cmon.dao.tlct.model.TaiLieuChungThuc"%>
<%@page import="org.oep.cmon.portlet.document.action.CitizenDocumentPortlet"%>
<%@page import="org.oep.cmon.dao.nsd.model.impl.TaiKhoanNguoiDungImpl"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.sharedservice.cmon.SharedserviceUtil"%>
<%@page import="org.oep.sharedservice.cmon.provider.thamso.ThamSoServiceImpl"%>
<%@page import="org.oep.sharedservice.cmon.provider.thamso.IThamSoService"%>
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
long doiTuongId = ParamUtil.getLong(request, "doiTuongId");
long congDanId = ParamUtil.getLong(request, "congDanId");
long danhMucGiayToId = ParamUtil.getLong(request, "danhMucGiayToId");

if(doiTuongId <= 0) {
	try {
		IThamSoService  thamSo = new ThamSoServiceImpl();
		doiTuongId = (thamSo == null) ? 0	: FormatUtil.convertToLong(thamSo.getValue(Constants.TS_CONG_DAN));
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

CitizenDocumentPortlet portlet = new CitizenDocumentPortlet();

PortletURL backURL = renderResponse.createRenderURL();
backURL.setParameter("jspPage", "/html/portlet/document/citizen/citizen_document_list.jsp");

%>
<div class="egov-container" id="_cttl_cong_dan_history">
	<form name = "<portlet:namespace/>searchCTTLCongDanHistoryForm" method="post" action="">
	<input type="hidden" name="doiTuongId" value="<%=doiTuongId%>">
	<input type="hidden" name="congDanId" value="<%=congDanId%>">
	<input type="hidden" name="danhMucGiayToId" value="<%=danhMucGiayToId%>">
		<table class="egov-table-form2" style="width: 100%">
		  <tr>
		  <tr>
			<td colspan="3" align="left"><br><br>
				<label class="egov-label-header">
					<liferay-ui:message key="vn.dtt.cmon.document.citizen.list.history.title"/><%=DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(danhMucGiayToId).getTen() %>
				</label>
				<br><br>
			</td>
		</tr>
		    <td colspan="3">
		    	<liferay-ui:error key="notExist" message = "vn.dtt.cmon.document.citizen.error.notexist"/>
		    </td>
		 </tr>
		</table>
	</form>
	<%
		PortletURL iteratorUrl = renderResponse.createRenderURL();
		iteratorUrl.setParameter("jspPage", "/html/portlet/document/citizen/citizen_document_history.jsp");
				
	%>
	<table cellpadding="0" cellspacing="0" class="egov-table" width="100%">
	<thead>
		<tr>
			<th width="5%"><liferay-ui:message key="vn.dtt.cmon.document.citizen.list.header.stt"/></th>
			<th width="10%"><liferay-ui:message key="vn.dtt.cmon.document.citizen.list.header.phienban"/></th>
			<th width="15%">Ngày tải tài liệu</th>
			<th width="20%"><liferay-ui:message key="vn.dtt.cmon.document.citizen.list.header.trangthai"/></th>
			<th width="40%"><liferay-ui:message key="vn.dtt.cmon.document.citizen.list.header.hieuluc"/></th>
			<th width="10%"><liferay-ui:message key="vn.dtt.cmon.document.citizen.list.header.chucnang"/></th>
		</tr>
	</thead>
	<tbody>
		<%
		SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, cur, delta, iteratorUrl, null, null);
		int start = searchContainer.getStart();
		int end = searchContainer.getEnd();
		
		List<TaiLieuChungThuc> list = portlet.listTaiLieuChungThucHistory(danhMucGiayToId, congDanId, start, end);
		long count = portlet.countTaiLieuChungThucHistory(danhMucGiayToId, congDanId);
		
		searchContainer.setTotal((int)count);
		searchContainer.setResults(list);
		
		if(!Helpers.isEmpty(list)) {
			for (int i = 0; i < list.size(); i++) {
				TaiLieuChungThuc taiLieuChungThuc = list.get(i);
				
				PortletURL viewUrl = renderResponse.createActionURL();
				viewUrl.setParameter(ActionRequest.ACTION_NAME, "viewChungThucCongDan");
				viewUrl.setParameter("jspPage", "/html/portlet/cosokinhdoanh/citizen_document_use.jsp");
				viewUrl.setParameter("id", String.valueOf(taiLieuChungThuc.getId()));
				viewUrl.setParameter("doiTuongId", String.valueOf(doiTuongId));
				viewUrl.setParameter("danhMucGiayToId", String.valueOf(taiLieuChungThuc.getDanhMucGiayToId()));
				viewUrl.setParameter("hoSoTTHCCongId", String.valueOf(taiLieuChungThuc.getHoSoTTHCCId()));
				portlet.setSearchParameter(viewUrl, cur, delta);
				
				//Get File Upload			
				long fileUploadId = taiLieuChungThuc.getNoiLuuTruId();	
				IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
				String urlFileUpload="#";
				if(fileUploadId>0)
				{
					urlFileUpload=iDocumentStorage.getURLById(fileUploadId);
				}
		%>
		<tr>
			<td style="text-align: center;"><%=(start + i + 1)%></td>
			<td style="text-align: center;"><%=HtmlUtil.escape(String.valueOf(taiLieuChungThuc.getPhienBan())) %></td>
			<td style="text-align: center;"><%=HtmlUtil.escape(FormatUtil.getFormatDate(taiLieuChungThuc.getNgayUpload())) %></td>
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
						classTrangThai = "blue";
					}  else if (taiLieuChungThuc.getTrangThai() == Constants.Citizen.TrangThai_TuChoi) {
						classTrangThai = "gray";
					}	else if (taiLieuChungThuc.getTrangThai() == Constants.Citizen.TrangThai_XoaTam) {
						classTrangThai = "yellow";
					}
				%>
			
				<span class="egov-status-<%=classTrangThai%>" title="<%=strToolTip%>">
					<%=LanguageUtil.get(pageContext, "vn.dtt.cmon.document.citizen.trangthai."+taiLieuChungThuc.getTrangThai()) %>
				</span>
			</td>
			<td style="text-align: center;"><%=HtmlUtil.escape(FormatUtil.getFormatDate(taiLieuChungThuc.getHieuLucTuNgay())) %><%=LanguageUtil.get(pageContext, "vn.dtt.cmon.document.citizen.denngay") %><%=HtmlUtil.escape(FormatUtil.getFormatDate(taiLieuChungThuc.getHieuLucDenNgay())) %> </td>
			<td style="text-align: center;">
				<table class="egov-table-function" style="width:100%">
				<tbody>
					<tr>
						<td style="text-align: center; width: 100%"><a href="<%=urlFileUpload%>" style="padding: 0px"><button class="egov-func-download" title="<liferay-ui:message key="vn.dtt.cmon.document.citizen.list.item.down"/>"></button></a></td>
						<!-- <td style="width: 50%"><a href="#<%//viewUrl.toString()%>);" style="padding: 0px"><button class="egov-func-history" title="<liferay-ui:message key="vn.dtt.cmon.document.citizen.list.item.use"/>"></button></a></td> -->
						
					</tr>
				</tbody>
				</table>
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
	<div class="egov-button-bar">
	<br>
		<table cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td align="left">
					<a href="<%=backURL.toString()%>">
						<input type="button" id="<portlet:namespace/>_back" value="<liferay-ui:message key="vn.dtt.cmon.document.citizen.form.back"/>" class="egov-button-normal">
					</a>
				</td>
			</tr>
		</table>
	</div>
</div>