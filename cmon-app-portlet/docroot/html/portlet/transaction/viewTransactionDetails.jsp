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
<%@page import="org.oep.cmon.portlet.ruthoso.RutHoSoBusinessUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.FileDinhKem"%>
<%@page import="org.oep.cmon.dao.tlct.model.TaiLieuChungThuc"%>
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page import="org.oep.cmon.portlet.ipmslist.business.FileKetQua"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.YKienTraoDoi"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.portlet.transaction.TransactionUtils"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.util.Date"%>

<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
 <%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script src="<%=request.getContextPath()%>/js/jquery.form.js"
	type="text/javascript"></script>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<!-- hoangtrung.nguyen fix 2 man hinh danh sach ho so  -->
			<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/core.css" />
			<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/customEgovTheme.css" />
			<style type="text/css">
				div.egov-container {
					padding-left: 10px;
					padding-right: 10px;
					overflow: auto; 
				}
				div.egov-container .result-grid {
					min-width: 760px !important;
					width: auto !important;
				}
				table.egov-table.result-grid td a {
					margin-left: 0 !important;
				}
				table.egov-table.result-grid td.fn a {
					padding: 0 !important;
					margin: 0 !important;
					line-height: 0 !important;
				}
				table.egov-table.result-grid td.fn a {
					text-decoration: none !important;
				}
				.fi .inner {
					margin-right: 8px;
				}
				.fi.last .inner {
					margin-right: 0;
				}
				.span-button{
					margin-top: 10px;
				}
				
			</style>
			
<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	String transIdStr = null;
	transIdStr	=	ParamUtil.getString(request, TransactionUtils.TRANSACTION_ID,"");
	if (Validator.isNull(transIdStr)){
		transIdStr = renderRequest.getAttribute(TransactionUtils.TRANSACTION_ID).toString();
	}
	String transType = ParamUtil.getString(request, "transType","");
	String currentTransPage = ParamUtil.getString(request, "currentTransPage","");
	String transactionKeyword = ParamUtil.getString(request, "transactionKeyword","");
	String CanBoXuLyHienThoiId =  null;
	String status = "0";
	String statusText="";
	Object pagingYkXl1 = request.getAttribute("pagingYkXl");
	boolean reloadPaging = pagingYkXl1 == null? false: true;
	if(reloadPaging) {
		request.removeAttribute("pagingYkXl");
	}
	if(reloadPage) {
		transIdStr = (String) request.getAttribute("transactionId");
		transType = (String) request.getAttribute("transType");
		currentTransPage = (String) request.getAttribute("currentTransPage");
		transactionKeyword = (String) request.getAttribute("transactionKeyword");
		currentTransPage = (String) request.getAttribute("currentTransPage");
		transactionKeyword = (String) request.getAttribute("transactionKeyword");
		CanBoXuLyHienThoiId = (String) request.getAttribute("CanBoXuLyHienThoiId");
		status = (String) request.getAttribute("status");
		request.removeAttribute("transType");
		request.removeAttribute("currentTransPage");
		request.removeAttribute("transactionKeyword");
		request.removeAttribute("transactionId");
		request.removeAttribute("CanBoXuLyHienThoiId");
		request.removeAttribute("status");
	}
	long transId = 0;
	if (transIdStr.length() > 0) {
		transId = Long.parseLong(transIdStr);
	}
	HoSoTTHCCong instance = TransactionUtils.getHoSoTTHCCong(transId);//HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(transId);
	Long hoSoId = transId;
	String requestUrl = PortalUtil.getCurrentURL(request);
	
	if(!reloadPage) {
		 CanBoXuLyHienThoiId =  ParamUtil.getString(request, "CanBoXuLyHienThoiId", String.valueOf(instance.getCanBoXuLyHienThoiId()));
		 status = ParamUtil.getString(request, "status", String.valueOf(instance.getTrangThaiHoSo()));
	
	}
	
	statusText=TrangThaiHoSoLocalServiceUtil.getTrangThaiHoSo(Long.parseLong(status)).getTrangThai() ;
	String tieude = LanguageUtil.get(pageContext, "org.oep.brms.registry.viewTransaction.details.yeuCauHuy");

    
    PortletURL listYkienXlUrl = renderResponse.createRenderURL();
    listYkienXlUrl.setParameter("pagingYkXl", "YES");
    listYkienXlUrl.setParameter(TransactionUtils.TRANSACTION_ID, String.valueOf(instance.getId()));
    listYkienXlUrl.setParameter(TransactionUtils.PARAM_VIEW_TYPE, TransactionUtils.VIEW_TRANSACTION_DETAILS);
    listYkienXlUrl.setParameter("transType", transType);
    listYkienXlUrl.setParameter("currentTransPage", currentTransPage);
    listYkienXlUrl.setParameter("transactionKeyword", transactionKeyword);   
    listYkienXlUrl.setParameter("CanBoXuLyHienThoiId", String.valueOf(instance.getCanBoXuLyHienThoiId()));
    listYkienXlUrl.setParameter("status", status);
    
	PortletURL url = renderResponse.createRenderURL();
		url.setParameter("jspPage", "/html/portlet/viewUploadFile.jsp");
		url.setParameter("hoSoTTHCCongId", String.valueOf(instance.getId()));
		url.setWindowState(LiferayWindowState.POP_UP);
		url.setPortletMode(PortletMode.VIEW);
//	PortletURL backUrl = renderResponse.createRenderURL();
	//	backUrl.setParameter("jspPage",	"/html/portlet/transaction/viewTransactionDetails.jsp");
		//backUrl.setParameter("hoSoTTHCCongId", String.valueOf(instance.getId()));
	PortletURL portletUrl = renderResponse.createRenderURL();
 		portletUrl.setParameter(TransactionUtils.PARAM_VIEW_TYPE, TransactionUtils.VIEW_TRANSACTION_LIST);	
 		portletUrl.setParameter("tabs1", "tab.ipmslist.dangXuLy");
%>

<!-- Url go to nop phi qua tai khoan  -->
<portlet:renderURL var="nopphi">
	<portlet:param name="jspPage"
		value="/html/portlet/transaction/nopphi.jsp" />
	<portlet:param name="hoSoId" value="<%=hoSoId.toString()%>"></portlet:param>	
	<portlet:param name="parentUrl" value="<%=requestUrl%>"></portlet:param>
</portlet:renderURL>

<div class="wd-data-item">
	<div class="wd-details">
	
		<portlet:renderURL var="brms_viewList">
		 	<portlet:param name="<%=TransactionUtils.PARAM_VIEW_TYPE%>" value="<%=TransactionUtils.VIEW_TRANSACTION_LIST%>" />
		 	<portlet:param name="transType" value="<%=transType%>" />
		 	<portlet:param name="currentTransPage" value="<%=currentTransPage%>" />
		 	<portlet:param name="transactionKeyword" value="<%=transactionKeyword%>" />
		</portlet:renderURL>
		<liferay-ui:error key="YCHuy-required" message="org.oep.brms.registry.viewTransaction.details.YCHuy-required"></liferay-ui:error>
		
		<!--  --> <div style="float: right;">
			<!-- 	<a class="wd-detail-back" href="<%=brms_viewList%>" >
			<liferay-ui:message key="org.oep.brms.registry.viewTransaction.back"/> 	</a> 
			<a class="wd-detail-back" href="#" onclick="javascript: history.go(-1);"><liferay-ui:message key="org.oep.brms.registry.viewTransaction.back"/></a>
		 <a href = "javascript:history.back()">
      <input type="button" id="<portlet:namespace/>_back" value="<liferay-ui:message key="org.oep.brms.registry.viewTransaction.back"/>" class="egov-button-normal">
		</div> -->
	
		<%
			if (instance != null) {
		%>
		<div class="egov-container">
			<h1 style="font-size: 18px; font-weight: bold; text-align: center; text-transform: uppercase; padding-bottom: 13px; padding-top: 26px;">
				<liferay-ui:message key="org.oep.brms.registry.viewTransactionDetails.chitiet" />
			
			</h1>	
<!--		<%if (request.getAttribute("huy_success") != null) {%>	
					<font color="blue"><liferay-ui:message key="org.oep.brms.registry.viewTransactionDetails.huySuccess" /></font>	
			<%}%> -->
			<table border="0" class="egov-table-form">
			
				<tr>
					<td style="font-size: 13px; font-weight: bold;">
						<liferay-ui:message key="org.oep.brms.registry.viewTransaction.name" /> :
					</td>
					<td  colspan="3" class="wd-fw-bold">
						<%=instance.getTenThuTucHanhChinh()%>
					</td>
				</tr>
				<tr>
					<td style="font-size: 13px; font-weight: bold;">
						<liferay-ui:message key="org.oep.brms.registry.viewTransaction.details.ngayNop" /> :
					</td>
					<td class="wd-fw-bold">
						<%=instance.getNgayNopHoSo()==null? "":sdf.format(instance.getNgayNopHoSo())%>
					</td>
				</tr>
				<tr>	
					<td style="font-size: 13px; font-weight: bold;">
						Ngày tiếp nhận :
					</td>
					<td class="wd-fw-bold">
						<%=instance.getNgayNhanHoSo()==null? "":sdf.format(instance.getNgayNhanHoSo())%>
					</td>
				</tr>
				<tr>	
					<td style="font-size: 13px; font-weight: bold;">
						Ngày hẹn trả :
					</td>
					<td class="wd-fw-bold">
						<%=instance.getNgayHenTraKetQua()==null? "":sdf.format(instance.getNgayHenTraKetQua())%>
					</td>
				</tr>	
						
			<!-- 	<tr>
					<td>
						<liferay-ui:message key="org.oep.brms.registry.viewTransaction.code" /> :
					</td>					
					<td class="wd-fw-bold">
						<%=instance.getMaSoHoSo()%>
					</td>
				</tr> -->
				<tr>	
					<td style="font-size: 13px; font-weight: bold;">
						<liferay-ui:message key="org.oep.brms.registry.viewTransaction.status"/> :
					</td>
					<td class="wd-fw-bold">
						<% if (RutHoSoBusinessUtil.laHoSoDaYeuCauRut(instance)) { %>
							Đã yêu cầu rút
						<% } else { %>
							<%=TrangThaiHoSoLocalServiceUtil.getTrangThaiHoSo(instance.getTrangThaiHoSo()).getTrangThai()%>
						<% } %>
					</td>							
				</tr>	
				<tr>
					
					<td style="font-size: 13px; font-weight: bold;">
						<liferay-ui:message key="org.oep.brms.registry.viewTransaction.result" /> :
					</td>
					<td class="wd-fw-bold">
					<%
						List<FileDinhKem> liFileUploadsIservice3 = ConvertUtil.convertFromObjectToFileDinhKem(
											FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(instance.getId(), 3));
									List<FileKetQua> listFileDinhKem = ConvertUtil.findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoan(instance.getThuTucHanhChinhId(), 3);

							if (listFileDinhKem.size() > 0) {
									for (int i=0; i< listFileDinhKem.size(); i ++) {
										FileKetQua danhMucGiayTo = listFileDinhKem.get(i);
										
										TaiLieuChungThuc taiLieuChungThucDB = null;
										FileDinhKem fileUploadDB = null;
										for (FileDinhKem fileUpload : liFileUploadsIservice3) {
											TaiLieuChungThuc taiLieuChungThuc = ConvertUtil.getTaiLieuChungThucFromNoiLuuTruTaiLieuId(fileUpload);
											if (taiLieuChungThuc != null && fileUpload.getDanhMucGiayToId()==danhMucGiayTo.getDanhMucGiayToId()) {
												taiLieuChungThucDB = taiLieuChungThuc;
												fileUploadDB = fileUpload;
												break;
											}
										}
										
										if (taiLieuChungThucDB != null) {
				%>
							<liferay-ui:icon image="download"/>								
							<a href ="<%=ConvertUtil.getURLFromNoiLuuTruId(taiLieuChungThucDB.getNoiLuuTruId())%>">
								<liferay-ui:message key= "org.oep.brms.registry.viewTransaction.taixuong" />
							</a>
				<%
									}
							}
									
						} else {
					%>
							<liferay-ui:message key= "org.oep.brms.registry.viewTransaction.result.value" />
					<%
						}
					%>
					</td>							
				</tr>					
			</table>
			<div id="wd-fancy-configuration-template" class="wd-fancy-document-list">
				<fieldset style="border:0px !important;">					
					<div class="wd-submit">
						<%
							long transPortletId = 0; 
											
											String transPortletName = "";
											String schemaName =instance.getMaUngDung().trim().toLowerCase();
											String maQuyTrinh="";
											String delimiter = "_";
											//schemaName ="dkkd";// schemaName.split(delimiter);
											String portletId = prefs.getValue(schemaName+"Id","0");
											if (portletId != null && portletId.length() > 0) {
												transPortletId = Long.parseLong(portletId);
											}
											
											transPortletName = prefs.getValue(schemaName+"Name","");
											
											ThuTucHanhChinh thuTucHanhChinh = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(instance.getThuTucHanhChinhId());
											if(thuTucHanhChinh !=null) {
												maQuyTrinh = thuTucHanhChinh.getMa();
											}
											int trangThai = instance.getTrangThaiHoSo();
						%>
						<liferay-portlet:renderURL plid="<%=transPortletId%>" 
							portletName="<%=transPortletName%>" var="LINK">
 							<liferay-portlet:param name="<%=TransactionUtils.PARAM_PORTLET_NAME%>" value="<%=schemaName%>" />
 							<liferay-portlet:param name="<%=TransactionUtils.PARAM_ID%>" value="<%=String.valueOf(instance.getId())%>" />
 							<liferay-portlet:param name="<%=TransactionUtils.PARAM_ID_QUY_TRINH%>" value="<%=String.valueOf(instance.getThuTucHanhChinhId())%>" />
							<liferay-portlet:param name="maQuyTrinh" value="<%=maQuyTrinh%>" />
							<portlet:param name="backURL" value="<%=PortalUtil.getCurrentCompleteURL(request)%>"></portlet:param>
						</liferay-portlet:renderURL>
						
						<portlet:renderURL var="urlQuayLai">
						<portlet:param name="<%=TransactionUtils.TRANSACTION_ID%>"
						value="<%=String.valueOf(instance.getId())%>" />
						<portlet:param name="<%=TransactionUtils.PARAM_VIEW_TYPE%>"
						value="transactionDetails" />
					    <portlet:param name="jspPage" value="/html/portlet/transaction/view.jsp" />
				   		</portlet:renderURL>	
				   		
						<portlet:renderURL var="urlParent">
					    <portlet:param name="jspPage" value="/html/portlet/transaction/view.jsp" />
				   		</portlet:renderURL>	
				   		
						
						<form  method="post" name="form_document_upload" id="form_document_upload">
						<%
							if (instance.getLoaiHoSo() == 1) {
						%>
								
							    
						<%
  								} else {
  							%>
						    	<button type="button" onclick="window.location='<%=LINK%>';" class="egov-button span-button">
						    	<%=LanguageUtil.get(pageContext, "org.oep.brms.registry.viewTransaction.details.xemGiaoDich")%>
						    	</button>
						<%
							}
						%>
						<portlet:renderURL var="yKienTraoDoi_Url" windowState="<%=LiferayWindowState.NORMAL.toString()%>">
							 	<portlet:param name="hoSoTTHCCongId" value="<%=String.valueOf(instance.getId())%>" />
							 	<portlet:param name="coQuanTiepNhanId" value="<%=String.valueOf(instance.getCoQuanTiepNhanId())%>" />
							 	<portlet:param name="type" value="<%=Constants.CONG_DAN%>" />
							 	<portlet:param name="parentUrl" value="<%=requestUrl%>"></portlet:param>
							 	<portlet:param name="jspPage" value="/html/cmon/ykientraodoi/danh_sach_y_kien.jsp" />
							 </portlet:renderURL>
<!-- <a class="wd-detail-back" href="#" onclick="javascript: history.go(-1);">Quay lại Danh Sách</a> -->
							
							 <portlet:renderURL var="viewFileDinhKem" windowState="<%=LiferayWindowState.NORMAL.toString()%>">
							 	<portlet:param name="hoSoTTHCCongId" value="<%=String.valueOf(instance.getId())%>" />
							 	<portlet:param name="coQuanTiepNhanId" value="<%=String.valueOf(instance.getCoQuanTiepNhanId())%>" />
							 	<portlet:param name="type" value="<%=Constants.CONG_DAN%>" />
							 	<portlet:param name="jspPage" value="/html/portlet/viewUploadFile.jsp" />
							 </portlet:renderURL>
							 
							 <portlet:renderURL var="urlXemYeuCauBoXung">
								<portlet:param name="idHoSo" value="<%=String.valueOf(instance.getId())%>" />
								<portlet:param name="backURL" value="<%=urlQuayLai%>" />
								<portlet:param name="type" value="<%=Constants.CONG_DAN%>" />
								<portlet:param name="jspPage" value="/html/portlet/transaction/Xemyeucauboxunghs_congdan.jsp" />
							</portlet:renderURL>	
		
	  		
						
					<%
						if ( trangThai == 5){
					%>
						   
						   	<button type="button" class="egov-button span-button" onclick="showDocumentPopup('<%=url.toString()%>', this.value)">Xem thành phần hồ sơ</button>

							<button type="button"  class="egov-button span-button"  onclick="sendRedirect('<%=yKienTraoDoi_Url%>')">Trao đổi thông tin</button>
				 			
				 			<button type="button" class="egov-button span-button">Nộp lệ phí trực tuyến</button>
							<button type="button" class="egov-button span-button" onclick="gotoUploadLePhi('<%=nopphi%>');">Nộp lệ phí qua tài khoản</button>
							
						<%
							} else  if(trangThai == 3){
						%>		
							<button type="button" class="egov-button span-button" onclick="showDocumentPopup('<%=url.toString()%>', this.value)">Xem thành phần hồ sơ</button>

							<button type="button" class="egov-button span-button"  onclick="sendRedirect('<%=yKienTraoDoi_Url%>')">Trao đổi thông tin</button>		
				 			<button type="button" class="egov-button span-button">Nộp lệ phí trực tuyến</button>
							<button type="button" class="egov-button span-button" onclick="gotoUploadLePhi('<%=nopphi%>');">Nộp lệ phí qua tài khoản</button>
							<button type="button" class="egov-button span-button" onclick="location.href='<%=urlXemYeuCauBoXung%>'">Xem yêu cầu bổ sung</button>
						<%
							} else  if(trangThai == 0){
						%>	
							<button type="button" class="egov-button span-button" onclick="showDocumentPopup('<%=url.toString()%>', this.value)">Xem thành phần hồ sơ</button>
		
							<button type="button"  class="egov-button span-button" onclick="sendRedirect('<%=yKienTraoDoi_Url%>')">Trao đổi thông tin</button>												  			
							<button type="button" class="egov-button span-button">Nộp phí trực tuyến</button>
							<%
								if(instance.getLePhi() > 0){
							%>
							<button type="button" class="egov-button span-button" onclick="gotoUploadPhi('<%=nopphi%>');">Nộp phí qua tài khoản</button>
							<%
								}else if(instance.getLePhi() <=0){
							%>
							<%
								}else{
							%>
							<%
								}
							%>
						
						<%
							} else {
						%>						
							
				  			<button type="button" class="egov-button span-button" onclick="showDocumentPopup('<%=url.toString()%>', this.value)">Xem thành phần hồ sơ</button>

							<button type="button" class="egov-button span-button"  onclick="sendRedirect('<%=yKienTraoDoi_Url%>')" value="">Trao đổi thông tin</button>												  			
							<button type="button" class="egov-button span-button">Nộp phí trực tuyến</button>
							<button type="button" class="egov-button span-button"onclick="gotoUploadPhi('<%=nopphi%>');">Nộp phí qua tài khoản</button>
							
							<% if (instance.getDungXuLy()) { %>
								<button type="button" class="egov-button span-button" onclick="location.href='<%=urlXemYeuCauBoXung%>'">Xem ý kiến dừng xử lí</button>
							<% }  %>
										
						<%-- 	<portlet:renderURL var="tuChoiHoSo_Url" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
							 	<portlet:param name="hoSoTTHCCongId" value="<%=String.valueOf(instance.getId())%>" />
							 	<portlet:param name="coQuanTiepNhanId" value="<%=String.valueOf(instance.getCoQuanTiepNhanId())%>" />
							 	<portlet:param name="type" value="<%=Constants.CONG_DAN%>" />
							 	<portlet:param name="jspPage" value="/html/cmon/tuchoi/tuchoihoso_form.jsp" />
							 </portlet:renderURL>
										
							<input type="button"  class="egov-button span-button"  onclick="sendRedirect('<%= tuChoiHoSo_Url%>')"  value="Từ chối" />		 --%>
							
									
						<%
					}					
				%>			

					<jsp:include page="<%= RutHoSoBusinessUtil.JSP_PATH_BUTTONS %>">
						<jsp:param value="<%= instance.getId() %>" name="hoSoId"/>						
					</jsp:include>
						
					<button type="button" class="egov-button span-button" onclick="location.href='<%= urlParent%>'">Quay lại</button>
					
					</form>
					
				</div>
				
				<!-- LICH SU TRAO DOI -->
					<% if (reloadPaging) { %>
						   <div id ="list2" class="wd-submit wd-list-transaction" style="display:;">	
						<% } else { %>
							<div id ="list2" class="wd-submit wd-list-transaction" style="display:none;">					

						<% } %>					
					<fieldset class="wd-list-transaction-form">
						<table cellpadding="0" cellspacing="0" class="egov-table" >
							<thead>
								<tr>
									<th>Stt</th>
									<th><liferay-ui:message key="org.oep.brms.registry.viewTransaction.details.nguoiGui" /></th>
									<th><liferay-ui:message key="org.oep.brms.registry.viewTransaction.details.tieuDe" /></th>
									<th><liferay-ui:message key="org.oep.brms.registry.viewTransaction.details.ngayGui" /></th>
									<th>Thao tác</th>
								</tr>
							</thead>
							<tbody>
							<%
								SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 10, listYkienXlUrl, null, null);
								
								List<YKienTraoDoi>	results = YKienTraoDoiLocalServiceUtil.findByHoSoTTHCCongId(instance.getId(), searchContainer.getStart(), searchContainer.getEnd()); 								
								
								long longTotal = YKienTraoDoiLocalServiceUtil.countByHoSoTTHCCongId(instance.getId());
							    int total = Integer.parseInt(String.valueOf(longTotal));
						    	searchContainer.setTotal(total);
						    	searchContainer.setResults(results);		
						
								for (int i=0; i < results.size(); i++) {
									YKienTraoDoi yKienTraoDoi = (YKienTraoDoi) results.get(i);
								%>
									<portlet:actionURL var="getPhanHoiDetailsURL" name="getPhanHoiDetails">
										<portlet:param name="idPhanHoi" value="<%= Long.toString(yKienTraoDoi.getId()) %>" />
									</portlet:actionURL>
								
									<tr onclick="getPhanHoiByAjax('<%=getPhanHoiDetailsURL.toString()%>');">
										<td><%=i+1 %></td>
										<td><a href="#"><%//= TransactionUtils.gettebNguoiDUng(yKienTraoDoi.getNguoiGuiId()) %></a></td>
										 <td align = "left"><a href="#"><%= yKienTraoDoi.getTieuDe() %></a></td>
										<td><a href="#"><%= sdf.format(yKienTraoDoi.getThoiGianGuiYKien()) %></a></td>
										<td></td>
									</tr>
							
							<%  } %>
								</tbody>
								
							</table>
						</fieldset>
						<fieldset id ="thongTinPhanHoiDetails" style="margin-top: 2px;" hidden="true">
							<b>
								<liferay-ui:message key="org.oep.brms.registry.viewTransaction.details.chiTietTitle" />
							</b>
							<table class="egov-table-form"  cellpadding="0" cellspacing="0" border="0"  >
								<tr>
									<td width="100">
										<liferay-ui:message key="org.oep.brms.registry.viewTransaction.details.tieuDe" />
									</td>
									<td id ="cmonTransTieude"></td>
								</tr>
								<tr>
									<td>
										<liferay-ui:message key="org.oep.brms.registry.viewTransaction.details.noiDung" />
									</td>
									<td id ="cmonTransNoiDung"></td>
								</tr>
							</table>
						</fieldset>
		<div id = "paginationTrans">
			<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
		</div>
						
					</div>
					<!-- End LICH SU TRAO DOI -->
					
				</fieldset>
				
			</div>
			<!-- End Cancel -->
		</div>
		<% } else { %>
			<br />
			<liferay-ui:message key="org.oep.brms.registry.viewTransactionDetails.khongCoGiaoDich" />	
		<% } %>
	</div>
</div>

<style type="text/css">
.ifr {
	width: 100% !important;
	padding: 0 !important;
}
</style>
<iframe class="ifr" id="giaytodinhkem_iframe" src="" style="display: none;"> </iframe>

<script type="text/javascript">
	gtdkURL = '<%=url.toString()%>',
		$gtdkIframe = $('#giaytodinhkem_iframe');
	
	$(function() {
		$gtdkIframe
			.dialog({
				autoOpen : false,
				width : 800,
				modal : true,
				resizable: false,
				draggable: false,
				position: { my: "center top", at: "center top+20", of: window },
				open: function() {
					var $this = $(this);
					$this.height($this.contents().outerHeight(true));
				}
			})
			.bind('load', function() {
				var $this = $(this);
				$this.height($this.contents().outerHeight(true));
			});
		
		$gtdkIframe.dialog('option', 'title', 'Thành phần hồ sơ');
	});
	
	function showDocumentPopup() {
		$gtdkIframe.dialog('open');
		if ($gtdkIframe.attr('src') !== gtdkURL) {
			$gtdkIframe.attr('src', gtdkURL);
		}
	}	
	
	function sendRedirect(url) {
		window.location = url;
	}

	function gotoUploadPhi(url) {
		window.location = url + "&typephi=1";
	}
	function gotoUploadLePhi(url) {
		window.location = url + "&typephi=2";
	}
	
</script>