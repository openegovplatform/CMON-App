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
<%@page import="org.oep.cmon.Constants"%>
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
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %> 
<%@page pageEncoding="UTF-8"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<portlet:defineObjects />
<head>
	<script src="<%=request.getContextPath()%>/js/egov-common.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/jquery-1.8.0.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.ui.core.js" type="text/javascript"></script>	
	<script src="<%=request.getContextPath()%>/js/js-citizen.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/js_citizen_transaction.js" type="text/javascript"></script>		
</head>
 <%
  	int ACTIVATED=0;
 	String defaultSearchStr = "Nh&#7853;p m&#227; h&#7891; s&#417;";
  	String transactionKeyword  = ParamUtil.getString(request,"transactionKeyword", StringPool.BLANK);
  	int currentTransPage  = ParamUtil.getInteger(request,"currentTransPage");
  	if (transactionKeyword.equals(StringPool.BLANK)) {
  		transactionKeyword = defaultSearchStr;
  	}
  	String transType = ParamUtil.getString(request, "transType", "0");
  	PortletURL portletUrl = renderResponse.createRenderURL();

  	portletUrl.setParameter(TransactionUtils.PARAM_VIEW_TYPE, TransactionUtils.VIEW_TRANSACTION_LIST);	
 	User currentUser = PortalUtil.getUser(request);
 	
   	//List<ThuTucHanhChinh> thuTucHanhChinhs = ThuTucHanhChinhLocalServiceUtil.findByTrangThai(ACTIVATED);
   	List<NhomThuTucHanhChinh> thuTucHanhChinhs = NhomThuTucHanhChinhLocalServiceUtil.getDSNhomThuTucHanhChinh(ACTIVATED);
   	long	 congdanId = 0;
    long uid = PortalUtil.getUserId(request);
  
//    if (uid > 0 ){
// 		TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(uid);
// 		if (taiKhoanNguoiDung!=null) {
//   	  	CongDan congDan =		CongDanLocalServiceUtil.findByTaiKhoanNguoiDungId(taiKhoanNguoiDung.getId());
//   	   	if(congDan != null ){
//   	   		congdanId = congDan.getId();
   	   		
//   	   	}
//   	   	}
  		
//   	}

 	long taikhoanNguoiDungId=-1;
   	

   	if (uid > 0 ){
   		
   		
   		try {
   			TaiKhoanNguoiDung taiKhoanNguoiDungs = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(uid);
   			taikhoanNguoiDungId  = taiKhoanNguoiDungs.getId();
		} catch (Exception e) {
			taikhoanNguoiDungId = 0;
		
	 }

   		
   		try {
   			CongDan congDan =		CongDanLocalServiceUtil.findByTaiKhoanNguoiDungId(taikhoanNguoiDungId);
   			if(congDan != null ){
   				congdanId = congDan.getId();
   	   	}
   		} catch (Exception e) {
   			congdanId = 0;
		
	 }
   	}   	
   	
   	
 %>
 <div class="egov-container">
<form name ="searchTransForm" method = "post" action = "<%=portletUrl.toString()%>" >
	<liferay-ui:success message="vn.dtt.registry.sucessfuly.message" key="vn.dtt.registry.sucessfuly.message"/>

	<table cellspacing="0" cellpadding="0" class="egov-table-form">
	  <tr>
	    <td align = "left">		    
	    	<input name="transactionKeyword" type="text"  class="egov-inputfield" size="40" style="width:70%; " value="<%=transactionKeyword%>" onfocus="if(this.value=='<%=defaultSearchStr%>') this.value='';" onblur="if(this.value=='') this.value='<%=defaultSearchStr%>'"  />
	    	<input type="button" name="button" onclick="submitTransForm('<%=defaultSearchStr%>');" value="Tìm kiếm"	class="egov-button-search" />
	    </td>
			  
	    
	    <td align = "right">
		    
		     <select class="egov-select" style="width:250px;"  name="transType" onchange="submitTransForm('<%=defaultSearchStr%>');">
		        <option value = "0">
					<liferay-ui:message key="vn.dtt.brms.registry.viewTransaction.filter" /> 
				</option>					
							<%
								for (int i = 0; i < thuTucHanhChinhs.size() ; i++) {
									NhomThuTucHanhChinh item = thuTucHanhChinhs.get(i) ;
							%>	
								<option <%=transType.equals(String.valueOf(item.getId()))? "selected":""%> value="<%=thuTucHanhChinhs.get(i).getId()%>" >
									<%=thuTucHanhChinhs.get(i).getTen()%>	 							
								</option>	
							<%
								}
							%>
		    </select>
	    </td>
	  </tr>
	 <tr> 
	 </tr> 
	</table>

		
		
			<table cellpadding="0" cellspacing="0"  class="egov-table"  width="100%">
				
				<tr>
				    <th align = "center"><liferay-ui:message key="vn.dtt.cmon.ipms.list.stt"/></th>
				    <th scope="col"><liferay-ui:message key="vn.dtt.brms.registry.viewTransaction.code"/></th>
				    <th scope="col"><liferay-ui:message key="vn.dtt.brms.registry.viewTransaction.name"/></th>
				    <th scope="col">Mã số biên nhận</th>				    				     
				    <th scope="col"><liferay-ui:message key="vn.dtt.brms.registry.viewTransaction.tenToChuc"/></th>
				    <th scope="col"><liferay-ui:message key="vn.dtt.brms.registry.viewTransaction.status"/></th>
				    <th scope="col"><liferay-ui:message key="vn.dtt.brms.registry.viewTransaction.returnDay"/></th>
				    
				</tr>
				
				
				<%
					String searchTransKeyword = transactionKeyword;
					if (searchTransKeyword.equals(defaultSearchStr)) {
						searchTransKeyword = null;
					}
					portletUrl.setParameter("transType", transType);
					if (searchTransKeyword != null) {
						portletUrl.setParameter("transactionKeyword", searchTransKeyword);
					}
					SearchContainer searchContainer = null;
					if (currentTransPage > 0) {
						searchContainer = new SearchContainer(renderRequest, null, null
								,SearchContainer.DEFAULT_CUR_PARAM, currentTransPage, 10, portletUrl, null, null);	
					} else {
						searchContainer = new SearchContainer(renderRequest, null, null
								, SearchContainer.DEFAULT_CUR_PARAM, 10, portletUrl, null, null);
					} 
					int start = searchContainer.getStart();
					int end = searchContainer.getEnd();
					
							":start:" + start + ":end:" + end);
					List<HoSoTTHCCong>	results = HoSoTTHCCongLocalServiceUtil
							.searchByMaCongDanHoSo_QT(congdanId, searchTransKeyword, Long.parseLong(transType), start, end);

					long longTotal = HoSoTTHCCongLocalServiceUtil.countByMaCongDanHoSo_QT(congdanId, searchTransKeyword, Long.parseLong(transType));
							
		 			int total = Integer.parseInt(String.valueOf(longTotal));
				    searchContainer.setTotal(total);
				    searchContainer.setResults(results);
				    searchContainer.setTotal(total);
					
				    List items = results;//searchContainer.getResultRows();
					for (int i=0; i < results.size(); i++) {
						HoSoTTHCCong instance = (HoSoTTHCCong) items.get(i);
				%>
					<tr>
						<td style="text-align: center;"><%=(searchContainer.getStart()+i+1)%></td>
						
						<td style="text-align: center;"><%=instance.getMaSoHoSo()%> </td>
						 <td align = "left">
							<portlet:renderURL var="brms_viewDetails">
							 	<portlet:param name="status" value="<%=String.valueOf(instance.getTrangThaiHoSo())%>" />
							 	<portlet:param name="CanBoXuLyHienThoiId" value="<%=String.valueOf(instance.getCanBoXuLyHienThoiId())%>" />
			 				   	<portlet:param name="<%=TransactionUtils.TRANSACTION_ID%>" value="<%=String.valueOf(instance.getId())%>" />
								<portlet:param name="<%=TransactionUtils.PARAM_VIEW_TYPE%>" value="<%=TransactionUtils.VIEW_TRANSACTION_DETAILS%>" />
								<portlet:param name="transType" value="<%=transType%>" />
							 	<portlet:param name="currentTransPage" value="<%=String.valueOf(searchContainer.getCur())%>" />
							 	<portlet:param name="transactionKeyword" value="<%=transactionKeyword%>" />
							 	<portlet:param name="type" value="<%=Constants.CONG_DAN%>" />
					 			<portlet:param name="backURL" value="<%=PortalUtil.getCurrentCompleteURL(request)%>"/>					 	
							 </portlet:renderURL>
							<a href="<%=brms_viewDetails%>"><%= instance.getTenThuTucHanhChinh() %></a>
							
						</td>
						<%if(instance.getMaSoBienNhan()!= null){ %>
						<td style="text-align: center;">
						<%=instance.getMaSoBienNhan() %>
						</td>
						<%}else{ %>
						<td style="text-align: center;">						
						</td>
						<%} %>
						
						<td align = "left">	
							<%= instance.getTenCoQuanTiepNhan() %>
						</td>	
						<td>	
							<%= TrangThaiHoSoLocalServiceUtil.getTrangThaiHoSo(instance.getTrangThaiHoSo()).getTrangThai() %>	
						</td>
						
						<td style="text-align: center;">
							<%= ((instance.getNgayHenTraKetQua() != null) ? sdf.format(instance.getNgayHenTraKetQua()) : "")%>	
						</td>
						
					</tr>
				<% } %>							
				
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