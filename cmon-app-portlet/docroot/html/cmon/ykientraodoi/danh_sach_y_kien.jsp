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
<%@page import="org.oep.cmon.util.CmonFields"%>
<%@page import="org.oep.egovcore.util.HSRParamUtil"%>
<%@page import="org.oep.cmon.util.ComUtils"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.YKienTraoDoi"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
<%@page import="org.oep.cmon.portlet.transaction.TransactionUtils"%>

<%@page import="org.oep.cmon.Constants"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>

<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="javax.portlet.PortletRequest"%>

<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.xml.datatype.XMLGregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %> 
<%@page pageEncoding="UTF-8"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>


<%@ include file="/html/portlet/init.jsp" %>
<style>
.span-button{
	margin-top: 10px;
}
</style>
<portlet:defineObjects />
<head>
</head>
 <%
 String hoSoTTHCCongId =  request.getParameter("hoSoTTHCCongId");
 
 if (FormatUtil.convertToLong(hoSoTTHCCongId) ==0){
	 hoSoTTHCCongId = renderRequest.getAttribute("hoSoTTHCCongId").toString();
 }
 

 String coQuanTiepNhanId =  request.getParameter("coQuanTiepNhanId");
 
 String type = request.getParameter("type");	
 
 if (type == null ){
	 type = renderRequest.getAttribute("type").toString();
 }
 
 String urlRoleBack = request.getParameter("ulrRoleBack");	
	
 int cur =  Integer.valueOf(prefs.getValue("curND", "1"));
 int delta =  Integer.valueOf(prefs.getValue("deltaND", "10"));
 int curnext = ParamUtil.getInteger(renderRequest, "cur", 1);
 int deltanext = ParamUtil.getInteger(renderRequest, "delta", 10);
 if(curnext!=cur) {
 	cur = curnext;
 }
 
 if(deltanext!=delta) {
 	delta = deltanext;
 }

 PortletURL searchURL = renderResponse.createActionURL();
 searchURL.setParameter(ActionRequest.ACTION_NAME, "search");	
 searchURL.setParameter("hoSoTTHCCongId", String.valueOf(hoSoTTHCCongId));
 searchURL.setParameter("type", String.valueOf(type));

 String keyword =  ParamUtil.getString(renderRequest, "keyword", "");

 if((Validator.isNull(keyword) || keyword.length()<=0) && 
		 renderRequest.getAttribute("keyword")!=null) {
 	keyword = renderRequest.getAttribute("keyword").toString();
 }   	
   	
 PortletURL pagingURL = renderResponse.createRenderURL();
 pagingURL.setParameter("keyword", keyword);
 
 SearchContainer searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			cur, delta, pagingURL, null, null);

	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();

	long userId = PortalUtil.getUserId(request);
	long total=0L;
	List<YKienTraoDoi> result = null;
	
	TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(userId);
	
/* 	Loại = 0: Ý kiến trao đổi
		Loại = 1: yêu cầu hủy
		Loại = 2 Yêu cầu bổ sung hồ sơ
		Loaij = 3 Từ chối hồ sơ */
	String loaiYKien = "";		

	if (type.equals(Constants.CONG_DAN)) {// cong dan
		loaiYKien =  "0,2,3,4";
	
		result = YKienTraoDoiLocalServiceUtil.listYKienTraoDoiAndLoai(
				FormatUtil.convertToLong(hoSoTTHCCongId), taiKhoanNguoiDung.getId(), loaiYKien, keyword, start, end);
		total = YKienTraoDoiLocalServiceUtil.countYKienTraoDoiAndLoai(
				FormatUtil.convertToLong(hoSoTTHCCongId), taiKhoanNguoiDung.getId(), loaiYKien, keyword);
		
	} else { // can bo
		loaiYKien = "0";
	
		result = YKienTraoDoiLocalServiceUtil.listYKienTraoDoiAndLoai(
				FormatUtil.convertToLong(hoSoTTHCCongId), 0, loaiYKien, keyword, start, end);
		total = YKienTraoDoiLocalServiceUtil.countYKienTraoDoiAndLoai(
				FormatUtil.convertToLong(hoSoTTHCCongId), 0, loaiYKien, keyword);
	}
	
	HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(
			FormatUtil.convertToLong(hoSoTTHCCongId));
	
	 Map<String, YKienTraoDoi> mapYKTD = new LinkedHashMap<String, YKienTraoDoi>();
     for (int n = 0; n < result.size(); n++) {
    	 mapYKTD.put(result.get(n).getTieuDe(), result.get(n));
     }
     
     List<YKienTraoDoi> listPaging = new ArrayList<YKienTraoDoi>(mapYKTD.values());
     long count = listPaging.size();
	
	// Paging
	int totalLong = Integer.parseInt(String.valueOf(count));
	searchContainer.setTotal(totalLong);
	searchContainer.setResults(ListUtil.subList(listPaging, searchContainer.getStart(), searchContainer.getEnd()));	
	
    String loaiCanBo = request.getParameter("loaiCanBo");
    String backURL = HSRParamUtil.getString(request, CmonFields.backURL);
    
 %>
 
 <div class="egov-container">
<form name = "<portlet:namespace/>searchThamSoForm" id = "<portlet:namespace/>searchThamSoForm" method = "post" action = "<%=searchURL%>" >
	<liferay-ui:success message="vn.dtt.registry.sucessfuly.message" key="vn.dtt.registry.sucessfuly.message"/>

	<table cellspacing="0" cellpadding="0" width="100%" class="egov-table-form">
	  <tr>
	    	<td align="left">	
			     	<input placeholder="Tiêu đề" id="keyword" name="keyword" type="text" value="<%=keyword %>" class="egov-inputfield" />	     				
			  </td>
			  <td><input type="submit" name="btnSearch" id="btnSearch" value="Tìm kiếm"  class="egov-button-search" /></td>		  
	    		<td align="right" style="text-align: right; " nowrap="nowrap">	    			
		    		 	
	    		 	<input type="button" name="quayLai" id="quayLai" value="Quay lại" class="egov-button"  onclick="sendRedirect('<%= backURL%>')"  />
		    		 	
		    		 <portlet:renderURL  var="urlThemMoi" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
		 				<portlet:param name="hoSoTTHCCongId" value="<%=String.valueOf(hoSoTTHCCongId)%>" />
		 				<portlet:param name="coQuanTiepNhanId" value="<%=String.valueOf(coQuanTiepNhanId)%>" />
		 				<portlet:param name="loaiCanBo" value="<%=loaiCanBo %>" />
		 				<portlet:param name="guiYkien" value="/html/cmon/ykientraodoi/danh_sach_y_kien.jsp" />
		 				<portlet:param name="type" value="<%=type%>" />
						<portlet:param name="jspPage" value="/html/cmon/ykientraodoi/canbo_traodoi_form.jsp" />
					</portlet:renderURL>
		    	 	<input type="button" name="btnAdd" id="btnAdd" value="Gửi ý kiến"  class="egov-button" st  onclick="sendRedirect('<%= urlThemMoi%>')"  />
	    		</td>
	  </tr>
	</table>

			<%
				String deleteValue = 	ComUtils.getValueString(request, "delete") ;
				 
				if (deleteValue.equals("failed")){
					
			%>
			<div class="portlet-msg-success" style="padding-left: 20px;" >
				 Bạn không thể xóa ý kiến đã được trả lời	
			 </div>
			<%
				}
				if( deleteValue.equals("successed")) {
			%>		
				<div class="portlet-msg-success" style="padding-left: 20px;" >
				 Ý kiến đã được xóa thành công	
			 </div>
			<%} %>		 	 
			<table cellspacing="0" cellpadding="0" class="egov-table" width="100%">
				<tbody>
				<tr>
				    <th align = "center"><liferay-ui:message key="vn.dtt.cmon.ipms.list.stt"/></th>
				    <th scope="col">Người gửi</th>
				    <th scope="col">Tiêu đề</th>
				    <th scope="col">Ngày gửi</th>
				    <%
				    	if (type.equals("1")){
				    %>
				    	 <th scope="col">Loại ý kiến</th>
				    <%
				    	}
				    %>
				    <th scope="col">Thao tác</th>
				</tr>
				
				
				<%
					/*
						YKienTraoDoi[] yk = result.toArray();
					for (YKienTraoDoi yktd : yk) {
				        if (result.indexOf(yktd.getTieuDe()) != result.lastIndexOf(yktd.getTieuDe())) {
				        	result.remove(result.lastIndexOf(yktd.getTieuDe()));
				         }
				     }*/
					
					int index=1;
					if (listPaging.size()>0){
						/*
						 Map<String, YKienTraoDoi> cleanMap = new LinkedHashMap<String, YKienTraoDoi>();
					     for (int j = 0; j < result.size(); j++) {
					          cleanMap.put(result.get(j).getTieuDe(), result.get(j));
					     
					     }
					     List<YKienTraoDoi> list = new ArrayList<YKienTraoDoi>(cleanMap.values());*/
						
					for (int i=0; i < listPaging.size(); i++) {
						YKienTraoDoi yKienTraoDoi = result.get(i);
						
						TaiKhoanNguoiDung taiKhoanNguoiDung1 = null;
						if (yKienTraoDoi.getNguoiGuiId() != null && yKienTraoDoi.getNguoiGuiId() > 0){
							taiKhoanNguoiDung1 = TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(yKienTraoDoi.getNguoiGuiId());
						}
						
				%>
					<tr>
						<td style="text-align: center;"><%=(searchContainer.getStart()+i+1)%></td>
						<td><% if (taiKhoanNguoiDung1 != null) { %> <%=taiKhoanNguoiDung1.getTenNguoiDung()%> <% } %></td>
						 
						<td align = "left">	
							<%= yKienTraoDoi.getTieuDe() %>
							<input type="hidden" id= "chaId" value="<%= yKienTraoDoi.getChaiId() %>" />
						</td>	
						<td style="text-align: center;">	
							<%= FormatUtil.parseDateToTring(yKienTraoDoi.getThoiGianGuiYKien()) %>	
						</td>
						
						<%
						if (type.equals("1")){
					    %>
					    	<td align = "center">	
								<%
									if (yKienTraoDoi.getLoai()==0){
								%>	
									Thông tin trao đổi
								<%
									} else if (yKienTraoDoi.getLoai()==2){
								%>
									Yêu cầu bổ sung
								<%
									} else if (yKienTraoDoi.getLoai()==3) {
								%>	
									Từ chối tiếp nhận
								<%
									} else if (yKienTraoDoi.getLoai()==4){
								%>	
									Dừng xử lý HS
								<%
									} 
								%>		
							</td>
					    <%
					    	}
					    %>
						
						<portlet:renderURL var="xemChiTiet_Url">
							 	<portlet:param name="yKienTraoDoiId" value="<%=String.valueOf(yKienTraoDoi.getId())%>" />
							 	<portlet:param name="hoSoTTHCCongId" value="<%=String.valueOf(hoSoTTHCCongId)%>" />
							 	<portlet:param name="type" value="<%=type%>" />
							 	<portlet:param name="loaiCanBo" value="<%=loaiCanBo %>" />
							 	<portlet:param name="jspPage" value="/html/cmon/ykientraodoi/chi_tiet_y_kien.jsp" />
						</portlet:renderURL>
						<%
						// Delete URL
						PortletURL deleteUrl = renderResponse.createActionURL();
						deleteUrl.setParameter(ActionRequest.ACTION_NAME, "delYKienTraoDoi");
						deleteUrl.setParameter("yKienTraoDoiId", String.valueOf(yKienTraoDoi.getId()));
						deleteUrl.setParameter("hoSoTTHCCongId", String.valueOf(hoSoTTHCCongId));
						deleteUrl.setParameter("type", String.valueOf(type));
						deleteUrl.setParameter("loaiCanBo", String.valueOf(loaiCanBo));
						%>	 
						<td>
							
							<a href="<%=xemChiTiet_Url%>">Xem chi tiết</a>  
							<%
								if (taiKhoanNguoiDung1 != null && (taiKhoanNguoiDung.getId() == taiKhoanNguoiDung1.getId())){
							%>
							
							| <a href = "<%=deleteUrl%>" > Xóa </a>
							
							<%
								}
							%>
						</td>
						
						
					</tr>
				<% } }%>							
				
			</tbody>	
				
			</table>
		
		<br />
		<div id = "paginationTrans">
			<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
		</div>
</form>		
</div>
<script type="text/javascript">
		if (<%= searchContainer.getStart() < 5 %>) {
			var pageTrans = document.searchTransForm.<portlet:namespace />page; 
			if (pageTrans) {
				pageTrans.value = "1";
			}
		}
</script>
<script type="text/javascript">
function sendRedirect(url) {
	window.location = url;
}
function confirmDelete(){
	return confirm("Bạn có chắc chắn muốn xóa ý kiến này không ?");	
}

function <portlet:namespace/>addCoQuanBanHanh(url) {
		var formObj =document.getElementById("<portlet:namespace/>searchThamSoForm");
		formObj.action=url;
		formObj.submit();
		
}
	
	
</script>