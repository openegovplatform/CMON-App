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
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="org.oep.egovcore.util.Helper"%>
<%@page import="org.oep.egovcore.util.StringPool"%>
<%@page import="org.oep.egovcore.util.HSRParamUtil"%>
<%@page import="org.oep.cmon.portlet.ipmslist.utils.HoSoMotCuaURLUtil"%>
<%@page import="org.oep.cmon.util.CmonFields"%>
<%@page import="org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc"%>
<%@page import="org.oep.cmon.portlet.ruthoso.RutHoSoFields"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil"%>
<%@page import="org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@page import="vn.dtt.sharedservice.WebserviceFactory"%>
<%@page import="vn.dtt.sharedservice.cmon.consumer.citizen.ICitizenService"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoFields"%>
<%@page import="org.oep.cmon.portlet.ruthoso.RutHoSoBusinessUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.YKienTraoDoi"%>
<%@page import="org.oep.cmon.util.ComUtils"%>
<%@page import="org.oep.cmon.util.EgovUtil"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="org.apache.commons.lang.WordUtils"%>
<%@page import="org.oep.egovcore.language.BusinessMessagerUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.portlet.transaction.TransactionUtils"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="javax.portlet.PortletRequest"%>

<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.xml.datatype.XMLGregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %> 
<%@ page import="javax.portlet.PortletURL" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@page import="org.oep.egovcore.util.DateTimeUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@page import="org.oep.egovcore.util.DateTimeUtil"%>
<%@page import="org.oep.cmon.portlet.ipmslist.business.ValidatorIPMSList"%>
<%@ taglib prefix="egov" uri="/WEB-INF/tld/egov.tld"%>
<%@page import="com.liferay.portal.kernel.log.Log" %>
<portlet:defineObjects />

<script src="<%=request.getContextPath()%>/js/egovUI.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/js_citizen_transaction.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/css/egovUI.css" rel="stylesheet" type="text/css" /> 
<link href="<%=request.getContextPath()%>/css/egov-custom-table.css" rel="stylesheet" type="text/css" /> 

<%
	long uid = PortalUtil.getUserId(request);
	//cqqlId=18;
	CongChuc congChuc = EgovUtil.getCongChucDaDangNhap(uid);	 	 	
	//Get ID cua can bo login(trong database)		
	long dbCongchucID=congChuc.getId(); 	
	
	PortletURL editURL = renderResponse.createRenderURL();
	editURL.setParameter("jspPage", "/html/portlet/hosotructiep/default.jsp");
	
	// get thu tuc hanh chinh by can bo
	List<ThongTinThuTuc> dsThuTuc2CanBo = HoSoBusinessUtil.getDSThuTuc2CanBo(congChuc);

	long selectedNhomThuTucId = HSRParamUtil.getLong(request, "nhomThuTucId");
	long selectedThuTucId = HSRParamUtil.getLong(request, "thuTucId");
 	String today = DateTimeUtil.getDayMonthYear(new java.util.Date()); 	
  	String dayCurrent=DateTimeUtil.getDay(new java.util.Date());
  	String monthCurrent=DateTimeUtil.getMonth(new java.util.Date());
  	String yearCurrent=DateTimeUtil.getYear(new java.util.Date());
  	//Get first time of Current year
  	String firstDayOfYear="01/01/"+yearCurrent;
  	
  	//Refill calendar when submit 
  	String NgayBD=ParamUtil.getString(request, "TuNgay", firstDayOfYear);
  	String NgayKT=ParamUtil.getString(request, "DenNgay", today);

  	//Get Ngay from calendar by input tag name 
  	Date d1 = DateTimeUtil.getRequestDate(request, "TuNgay");
  	Date d2 = DateTimeUtil.getRequestDate(request, "DenNgay");				 
  	String strDateFormat = "dd/MM/yyyy";
  	Log logger = LogFactoryUtil.getLog(this.getClass());
  	
  	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strDateFormat);
  	String tuNgay, denNgay;
  	tuNgay="01/01/"+yearCurrent;
  	denNgay=dayCurrent +"/"+monthCurrent+"/"+yearCurrent;
  	
  	
  	
  	if (NgayBD != null && ValidatorIPMSList.checkDateValid(NgayBD) == true) {
  		tuNgay=NgayBD;
  		logger.info("Trong IF tuNgay :"+ tuNgay); 
  	} else {
  		NgayBD=tuNgay;
	}
  	
  	if (NgayKT != null && ValidatorIPMSList.checkDateValid(NgayKT) == true) {
  		//adding more 1 day, using in SQL(Between)
  		Date date = null;
    			Date formatteddate = null;
    			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    			date = df.parse(NgayKT);  	            	        
    	        
  		Date nextdenNgay = new Date(date.getTime() + (1000 * 60 * 60 * 24));
  		denNgay=simpleDateFormat.format(nextdenNgay);
  		logger.info("Trong IF denNgay :"+ denNgay);
  	} else {
  		NgayKT = denNgay;
	}
  	
   	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
   	int ACTIVATED = 0;
   	String defaultSearchStr = "Nhập tên người nộp/mã biên nhận/mã hồ sơ";
   	String transactionKeyword = URLDecoder.decode(
		ParamUtil.getString(request, "transactionKeyword"),
		StringPool.UTF8
	);
   	
   	String searchKeyWord = transactionKeyword;

   	/*   	PortletURL nopHoSoRequestUrl = renderResponse.createRenderURL();
   		nopHoSoRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/offline/nopHoSoOffline.jsp");
   		nopHoSoRequestUrl.setParameter("transactionKeyword", transactionKeyword); */

   	int currentTransPage = ParamUtil.getInteger(request, "currentTransPage");
   	if (transactionKeyword.equals(StringPool.BLANK)) {
   		transactionKeyword = defaultSearchStr;
   	}
   	
   	String transType = ParamUtil.getString(request, "transType", "0");
   	
	if (transType.isEmpty() || transType.equals("0")) {
		transType = ComUtils.getListTTHCID(dsThuTuc2CanBo);
	}
	
	// Avoid SQL Exception
	long[] arrThuTuc = Helper.parseArrayLong(transType);
	transType = Helper.join(arrThuTuc);
			
   	String statusPreParam = Constants.QuanLiHoSo.HSTTHCC_CURRENT_STATUS_PREF_PARAM;
   	String statusHS = portletPreferences.getValue(statusPreParam, "");
   	// rut ho so
   	String yeuCauRutValue = portletPreferences.getValue(Constants.QuanLiHoSo.YEU_CAU_RUT, "");
   	int yeuCauRutInt = 0;
   	if ("on".equals(yeuCauRutValue)) {
   		yeuCauRutInt = 1;
   	}

   	PortletURL portletUrl = renderResponse.createRenderURL();

   	portletUrl.setParameter(TransactionUtils.PARAM_VIEW_TYPE,
   			TransactionUtils.VIEW_TRANSACTION_LIST);
   	portletUrl.setParameter("tabs1", "tab.ipmslist.dangXuLy");
   	//User currentUser = PortalUtil.getUser(request);
   	long cqqlId = -1;
   	long taikhoanNguoiDungId = -1;

   	if (uid > 0) {

   		try {
   			TaiKhoanNguoiDung taiKhoanNguoiDungs = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(uid);
   			taikhoanNguoiDungId = taiKhoanNguoiDungs.getId();
   		} catch (Exception e) {
   			taikhoanNguoiDungId = 0;
   		}

   		try {
   			List<CongChuc> congChucs = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(taikhoanNguoiDungId);
   			
   			if (congChucs.size() > 0) {
   				cqqlId = congChucs.get(0).getCoQuanQuanLyId();	 				
   			}
   		} catch (Exception e) {
   			cqqlId = 0;
   		}
   	}
 %>

<liferay-portlet:renderURL var="editHoSo" portletName="HoSoTrucTiepPortlet" windowState="maximized" >
<liferay-portlet:param name="jspPage" value="/html/portlet/hosotructiep/default.jsp"></liferay-portlet:param>
</liferay-portlet:renderURL>


<portlet:resourceURL var="moveListHoSo" id="moveListHoSo" >
</portlet:resourceURL>

<portlet:resourceURL var="rutHoSo" id="rutHoSo" >
</portlet:resourceURL>

<div class="egov-container">
<form id="searchIpmsListForm" name="searchIpmsListForm" method="post" action="<%=portletUrl.toString()%>" autocomplete="off" >
	<input id="hidden_thu_tuc_duoc_chon" type="hidden" name="transType" value="<%= transType %>" />
	<liferay-ui:success message="org.oep.registry.sucessfuly.message" key="org.oep.registry.sucessfuly.message"/>
	<h2 width="70%" align="right">&nbsp;&nbsp;&nbsp;Đóng/Mở</h2>
	<!-- Star edit --> 
	<div class="clearfix septop10 sepbot10">
		<div class="fi fi30">
			<div class="fi-wrapper">
				<div class="fi-label">
					<label  class="egov-label-bold">
						Chọn lĩnh vực
					</label>
				</div>
				<div class="fi-input">
					<select
						id="sel_nhom_thu_tuc"
						name="nhomThuTucId"
						class="egov-select"
						onchange="selectNhomThuTuc();"
						auto-tooltip="true"
					>
				        <option value="0">Tất cả lĩnh vực</option>
						<% long breakKey = 0L, nhomThuTucId = 0L; %>
						<% for (ThongTinThuTuc thuTuc : dsThuTuc2CanBo) { %>
							<% nhomThuTucId = thuTuc.getNhomThuTucId(); %>
							<% if (breakKey != nhomThuTucId) { %>
								<% breakKey = nhomThuTucId; %>
								<option value="<%= nhomThuTucId %>" 
									<%= (nhomThuTucId == selectedNhomThuTucId) ? StringPool.SELECTED : StringPool.BLANK %>
								>
									<%= thuTuc.getTenNhomThuTuc() %>
								</option>
							<% } %>
						<% } %>
				    </select>
				</div>
			</div>
		</div>
		<div class="fi fi70">
			<div class="fi-wrapper">
				<div class="fi-label">
					<label  class="egov-label-bold">
						Chọn loại hồ sơ
					</label>
				</div>
				<div class="fi-input">
					<select
						id="sel_thu_tuc"
						class="egov-select"
						onchange="selectThuTuc();"
						auto-tooltip="true"
					>
				        <option value="0">Tất cả loại hồ sơ</option>
				        <% selectedThuTucId = (transType.isEmpty() || transType.contains(",")) ? 0L : GetterUtil.getLong(transType); %>
						<egov:option-list 
							data="<%= dsThuTuc2CanBo %>"
							selectedValue="<%= selectedThuTucId %>"
							isGroupable="<%= true %>"
							isDataSorted="<%= true %>"
						/>
				    </select>
			   </div>
			</div>
		</div>
		<div class="clear fi fi35">
			<div class="fi-wrapper">
				<div class="fi-label">
					<label  class="egov-label-bold">
						<%=defaultSearchStr%>
					</label>
				</div>
				<div class="fi-input">
					<input
						id="textSearch"
						name="transactionKeyword"
						type="text"
						class="egov-inputfield"
						value="<%=searchKeyWord%>"
					/>
				</div>
			</div>
		</div>
		<div class=" fi fi30">
			<div class="fi-wrapper">
				<div class="fi-label">
					<label id="tu_ngay_label" class="egov-label-bold">
						Từ ngày
					</label>
					 
				</div>
				<div class="fi-input">
					<input
						type="text"
						class="egov-calendar wd-vn-date-format"
						value="<%=NgayBD%>"
						name="TuNgay"
						maxlength="10"
					/>
					</div>
				</div>
			</div>
			<div class="fi fi30">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Đến ngày
						</label>
					</div>
					<div class="fi-input">
						<input
							type="text"
							class="egov-calendar wd-vn-date-format"
							value="<%=NgayKT%>"
							name="DenNgay"
							maxlength="10"
							
						/>
					</div>
				</div>
			</div>
			<div class="fi fi5">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							&nbsp;
						</label>
					</div>
					<div class="fi-input">
						<button type="button"
							onclick="clickButtonSearch();"
							class="egov-button-search small"
						>&nbsp;</button>
					</div>
				</div>
			</div>
		</div>		
	
	<% if (statusHS.equals(Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN + "")) { %>
		<div>
			<button style="margin-bottom: 15px; margin-top: 5px;" class="egov-button right MOVEHS" type="button"><liferay-ui:message key="org.oep.cmon.ipms.chuyenhoso"/></button>
		</div>
	<% } %>
	
	<table class="egov-table result-grid clear hoso-grid">
		<tr>
		    <th align = "center"><liferay-ui:message key="org.oep.cmon.ipms.list.stt"/></th>
<!-- 		    <th scope="col" width="10%"><liferay-ui:message key="org.oep.brms.registry.viewTransaction.code"/></th> -->
		    <th scope="col" width="10%">Mã số biên nhận</th>
		    <th scope="col" width="30%"><liferay-ui:message key="org.oep.cmon.ipms.list.dvc"/></th>
		    <th scope="col" width="14%"><liferay-ui:message key="org.oep.cmon.ipms.list.nguoiGui"/></th>
		   <!--  <th scope="col" width="11%"><liferay-ui:message key="org.oep.brms.registry.viewTransaction.status"/></th> -->
   		    <th scope="col" width="20%">
<!--    		    <liferay-ui:message key="org.oep.cmon.ipms.list.diachi"/> -->
			Địa chỉ
   		    </th>
		    <th scope="col" width="7%"><liferay-ui:message key="org.oep.cmon.ipms.list.ngayNop"/></th>
		    <th scope="col" width="7%"><liferay-ui:message key="org.oep.cmon.ipms.list.ngayHenTra"/></th>
		    <%
		    	if (statusHS
		    		    		    			.equals(Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN
		    		    		    					+ "")
		    		    		    			&& (yeuCauRutInt != Constants.LOAI_Y_KIEN_TRAO_DOI.RUT_HO_SO)) {
		    %>
		    
		     <th scope="col" width="7%" style="text-align: center;"><div class="HEADER"><span class=""><input class="egov-checkbox HEADER" type="checkbox" /></span></div></th>
		     <%
		     	}
		     %>
		    <th scope="col"><liferay-ui:message key="org.oep.cmon.ipms.list.thaotac"/></th>
		</tr>
		<%
			String searchTransKeyword = transactionKeyword;
			if (searchTransKeyword.equals(defaultSearchStr)) {
				searchTransKeyword = null;
			}
			portletUrl.setParameter("transType", transType);
			portletUrl.setParameter("thuTucId", Long.toString(selectedThuTucId));
			portletUrl.setParameter("nhomThuTucId", Long.toString(selectedNhomThuTucId));
			//portletUrl.setParameter("statusHS", statusHS);
			if (searchTransKeyword != null) {
				portletUrl.setParameter("transactionKeyword",
						URLEncoder.encode(searchTransKeyword, StringPool.UTF8));
			}

			// Pagination search
			SearchContainer searchContainer = null;
			if (currentTransPage > 0) {
				searchContainer = new SearchContainer(renderRequest, null,
						null, SearchContainer.DEFAULT_CUR_PARAM,
						currentTransPage, 10, portletUrl, null, null);
			} else {
				searchContainer = new SearchContainer(renderRequest, null,
						null, SearchContainer.DEFAULT_CUR_PARAM, 10,
						portletUrl, null, null);
			}
			int start = searchContainer.getStart();
			int end = searchContainer.getEnd();

			//ThuTucHanhChinhLocalServiceUtil.getListTTHCByCanBo(canBoId);
			List<HoSoTTHCCong> results = HoSoTTHCCongLocalServiceUtil
				.findByMutilStatusAndTTHC(transType, searchKeyWord, dbCongchucID,
				null, cqqlId, statusHS, yeuCauRutInt,tuNgay, denNgay,start, end);
					
			int longTotal = HoSoTTHCCongLocalServiceUtil
				.countByMutilStatusAndTTHC(transType, searchKeyWord, dbCongchucID,
					null, cqqlId, statusHS, yeuCauRutInt,tuNgay, denNgay, start, end);
							
							
			int total = Integer.parseInt(String.valueOf(longTotal));
			searchContainer.setTotal(total);
			searchContainer.setResults(results);
			searchContainer.setTotal(total);

			List items = results;//searchContainer.getResultRows();
			for (int i = 0; i < results.size(); i++) {
				HoSoTTHCCong instance = (HoSoTTHCCong) items.get(i);
				statusHS = String.valueOf(instance.getTrangThaiHoSo());

				YKienTraoDoi ykien = null;
				if (instance.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_BO_SUNG || 
						instance.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_DA_XU_LY_XONG) {
					List<YKienTraoDoi> listYkiens = YKienTraoDoiLocalServiceUtil
							.findByHoSoTTHCCongId(instance.getId());

					if (listYkiens != null && listYkiens.size() > 0) {
						// get the last one						
						ykien = listYkiens.get(listYkiens.size() - 1);
					}
				}

				CongDan congDan = CongDanLocalServiceUtil.getCongDan(instance
						.getCongDanNopId());
		%>
			<tr <%if (instance.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_RUT_HS) {%>style="background-color: rgba(224, 229, 230, 0.65);"<%}%>>
				<td style="text-align: center;"><%=(searchContainer.getStart() + i + 1)%></td>
				
		<!-- them mau dungnd-->		
			<%
						if (instance.getLoaiHoSo() == 0) {
					%>	
<%-- 				<td  style="color:#009900; text-align: center;" ><%=instance.getMaSoHoSo()%> </td> --%>
				<td style="color:#009900; text-align: center;" > 
				<%
 					if (instance.getMaSoBienNhan() != null) {
 				%>
					<%=instance.getMaSoBienNhan()%>
				<%
					}
				%>
				</td>
			<%
				} else {
			%>
<%-- 				<td style="text-align: center;"><%=instance.getMaSoHoSo()%> </td> --%>
				<td style="text-align: center;">  
				<%
  					if (instance.getMaSoBienNhan() != null) {
  				%>
					<%=instance.getMaSoBienNhan()%>
				<%
					}
				%>
				</td>
				
			<%
								}
							%>
		<!-- done -->					
				<td>
				
					<portlet:renderURL var="brms_viewDetailDangXL">
	 				   	<portlet:param name="ipmsId" value="<%=String.valueOf(instance.getId())%>" />
						<portlet:param name="transType" value="<%=transType%>" />
					 	<portlet:param name="currentTransPage" value="<%=String.valueOf(searchContainer.getCur())%>" />
					 	<portlet:param name="transactionKeyword" value="<%=transactionKeyword%>" />
					 	<portlet:param name="tabs1" value="tab.ipmslist.dangXuLy" />
					 	<portlet:param name="statusHS" value="<%=statusHS%>" />
					 	<portlet:param name="type" value="<%=Constants.CAN_BO%>" />
					 	<portlet:param name="loaiCanBo" value="1" />
					 	<portlet:param name="jspPage" value="/html/portlet/ipmslistportlet/detailsHoSo/Details_DangKyMoi_choTn.jsp" />
					 	<portlet:param name="idHoSo" value="<%=String.valueOf(instance.getId())%>" />
					 </portlet:renderURL>
					<%
						HoSoMotCuaURLUtil.storeDanhSachURL(request, PortalUtil.getCurrentCompleteURL(request));
					%>
					<a href="<%=brms_viewDetailDangXL%>"><%=instance.getTenThuTucHanhChinh()%></a>
				</td>
				
				<td   style="margin-left: 5px;">	
					<%=WordUtils.capitalizeFully(instance
						.getHoTenNguoiNopHoSo())%>
				</td>	
				
<%-- 				<td  style="line-height: 20px ">
					<%=TrangThaiHoSoLocalServiceUtil.getTrangThaiHoSo(instance.getTrangThaiHoSo()).getTrangThai()  %>
				</td> --%>
				<td   style="margin-left: 5px;">	
					<%=HoSoBusinessUtil
						.getDiaChiDayDuCongDanNopHoSo(instance)%>
				</td>	
				
				<td style="text-align: center;">
					<%=((instance.getNgayNopHoSo() != null) ? dateFormat
						.format(instance.getNgayNopHoSo()) : "")%>
				</td>
				
				<td style="text-align: center;">
					<%=((instance.getNgayHenTraKetQua() != null) ? dateFormat
						.format(instance.getNgayHenTraKetQua()) : "")%>	
				</td>
				<%
					if (Integer.parseInt(statusHS) == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN
								&& (yeuCauRutInt != Constants.LOAI_Y_KIEN_TRAO_DOI.RUT_HO_SO)) {
				%>
				<td style="text-align: center;">
					<span class=""><input class="egov-checkbox" type="checkbox" idHoso=<%=instance.getId()%> /></span>
				</td>
				<%
					}
				%>
				<td class="fn" style="text-align: center;">
					<!-- BinhNT Add 25-06-2013 -->
					<%
						PortletURL taiFileKetQuaRequestUrl = renderResponse
									.createRenderURL();
							taiFileKetQuaRequestUrl
									.setParameter("jspPage",
											"/html/portlet/ipmslistportlet/offline/taiFileKetQua.jsp");
							taiFileKetQuaRequestUrl.setParameter("HosotthcCongId",
									String.valueOf(instance.getId()));
							taiFileKetQuaRequestUrl.setParameter("transactionKeyword",
									searchKeyWord);
							taiFileKetQuaRequestUrl.setParameter("transType", transType);
							taiFileKetQuaRequestUrl.setParameter("statusHS", statusHS);

							PortletURL taiFileKetDoanhNghiepQuaRequestUrl = renderResponse
									.createRenderURL();
							taiFileKetDoanhNghiepQuaRequestUrl
									.setParameter("jspPage",
											"/html/portlet/ipmslistportlet/company/taiFileKetQua.jsp");
							taiFileKetDoanhNghiepQuaRequestUrl.setParameter(
									"HosotthcCongId", String.valueOf(instance.getId()));
							taiFileKetDoanhNghiepQuaRequestUrl.setParameter(
									"transactionKeyword", searchKeyWord);
							taiFileKetDoanhNghiepQuaRequestUrl.setParameter("transType",
									transType);
							taiFileKetDoanhNghiepQuaRequestUrl.setParameter("statusHS",
									statusHS);

							PortletURL traKetQuaRequestUrl = renderResponse
									.createRenderURL();
							traKetQuaRequestUrl.setParameter("jspPage",
									"/html/portlet/ipmslistportlet/offline/traKetQua.jsp");
							traKetQuaRequestUrl.setParameter("HosotthcCongId",
									String.valueOf(instance.getId()));
							traKetQuaRequestUrl.setParameter("transactionKeyword",
									searchKeyWord);
							traKetQuaRequestUrl.setParameter("transType", transType);
							traKetQuaRequestUrl.setParameter("statusHS", statusHS);

							PortletURL traKetQuaDoanhNghiepRequestUrl = renderResponse
									.createRenderURL();
							traKetQuaDoanhNghiepRequestUrl.setParameter("jspPage",
									"/html/portlet/ipmslistportlet/company/traKetQua.jsp");
							traKetQuaDoanhNghiepRequestUrl.setParameter("HosotthcCongId",
									String.valueOf(instance.getId()));
							traKetQuaDoanhNghiepRequestUrl.setParameter(
									"transactionKeyword", searchKeyWord);
							traKetQuaDoanhNghiepRequestUrl.setParameter("transType",
									transType);
							traKetQuaDoanhNghiepRequestUrl.setParameter("statusHS",
									statusHS);

							PortletURL taiThemTaiLieuRequestUrl = renderResponse
									.createRenderURL();
							taiThemTaiLieuRequestUrl
									.setParameter("jspPage",
											"/html/portlet/ipmslistportlet/offline/taiThemTaiLieu.jsp");
							taiThemTaiLieuRequestUrl.setParameter("HosotthcCongId",
									String.valueOf(instance.getId()));
							taiThemTaiLieuRequestUrl.setParameter("transactionKeyword",
									searchKeyWord);
							taiThemTaiLieuRequestUrl.setParameter("transType", transType);
							taiThemTaiLieuRequestUrl.setParameter("statusHS", statusHS);

							PortletURL taiThemTaiLieuDoanhNghiepRequestUrl = renderResponse
									.createRenderURL();
							taiThemTaiLieuDoanhNghiepRequestUrl
									.setParameter("jspPage",
											"/html/portlet/ipmslistportlet/company/taiThemTaiLieu.jsp");
							taiThemTaiLieuDoanhNghiepRequestUrl.setParameter(
									"HosotthcCongId", String.valueOf(instance.getId()));
							taiThemTaiLieuDoanhNghiepRequestUrl.setParameter(
									"transactionKeyword", searchKeyWord);
							taiThemTaiLieuDoanhNghiepRequestUrl.setParameter("transType",
									transType);
							taiThemTaiLieuDoanhNghiepRequestUrl.setParameter("statusHS",
									statusHS);

							PortletURL xemTaiLieuRequestUrl = renderResponse
									.createRenderURL();
							xemTaiLieuRequestUrl.setParameter("statusHS", statusHS);
							xemTaiLieuRequestUrl
									.setParameter("jspPage",
											"/html/portlet/ipmslistportlet/offline/xemTaiLieuDinhKem.jsp");
							xemTaiLieuRequestUrl.setParameter("HosotthcCongId",
									String.valueOf(instance.getId()));
							xemTaiLieuRequestUrl.setParameter("transactionKeyword",
									searchKeyWord);
							xemTaiLieuRequestUrl.setParameter("transType", transType);

							PortletURL xemTaiLieuDoanhNghiepRequestUrl = renderResponse
									.createRenderURL();
							xemTaiLieuDoanhNghiepRequestUrl.setParameter("statusHS",
									statusHS);
							xemTaiLieuDoanhNghiepRequestUrl
									.setParameter("jspPage",
											"/html/portlet/ipmslistportlet/company/xemTaiLieuDinhKem.jsp");
							xemTaiLieuDoanhNghiepRequestUrl.setParameter("HosotthcCongId",
									String.valueOf(instance.getId()));
							xemTaiLieuDoanhNghiepRequestUrl.setParameter(
									"transactionKeyword", searchKeyWord);
							xemTaiLieuDoanhNghiepRequestUrl.setParameter("transType",
									transType);

							PortletURL doiChieuHoSoDoanhNghiepRequestUrl = renderResponse
									.createRenderURL();
							doiChieuHoSoDoanhNghiepRequestUrl.setParameter("statusHS",
									statusHS);
							doiChieuHoSoDoanhNghiepRequestUrl
									.setParameter("jspPage",
											"/html/portlet/ipmslistportlet/company/doiChieuHoSoChiTiet.jsp");
							doiChieuHoSoDoanhNghiepRequestUrl.setParameter(
									"HosotthcCongId", String.valueOf(instance.getId()));
							doiChieuHoSoDoanhNghiepRequestUrl.setParameter(
									"transactionKeyword", searchKeyWord);
							doiChieuHoSoDoanhNghiepRequestUrl.setParameter("transType",
									transType);

							PortletURL doiChieuHoSoRequestUrl = renderResponse
									.createRenderURL();
							doiChieuHoSoRequestUrl.setParameter("statusHS", statusHS);
							doiChieuHoSoRequestUrl.setParameter("backUrl",
									PortalUtil.getCurrentCompleteURL(request));
							doiChieuHoSoRequestUrl
									.setParameter("jspPage",
											"/html/portlet/ipmslistportlet/offline/doiChieuHoSoChiTiet.jsp");
							doiChieuHoSoRequestUrl.setParameter("HosotthcCongId",
									String.valueOf(instance.getId()));
							doiChieuHoSoRequestUrl.setParameter("transactionKeyword",
									searchKeyWord);
							doiChieuHoSoRequestUrl.setParameter("transType", transType);

							PortletURL boSungHoSo_Url = renderResponse.createRenderURL();
							boSungHoSo_Url.setParameter("jspPage",
									"/html/cmon/yeucaubosung/bosunghoso_form.jsp");
							boSungHoSo_Url.setParameter("idHoSo",
									String.valueOf(instance.getId()));
							boSungHoSo_Url
									.setParameter("backUrl", Constants.JSP_DANH_SACH_HO_SO_MOT_CUA);

							PortletURL xemYCBoSungHoSo_Url = renderResponse
									.createRenderURL();
							xemYCBoSungHoSo_Url.setParameter("jspPage",
									"/html/cmon/yeucaubosung/xem_bosunghoso.jsp");
							xemYCBoSungHoSo_Url.setParameter("idHoSo",
									String.valueOf(instance.getId()));
							xemYCBoSungHoSo_Url.setParameter("loaiCanBo",
									Constants.LOAI_CAN_BO.LOAI_MOT_CUA);
							xemYCBoSungHoSo_Url.setParameter("urlQuayLai",
									portletUrl.toString());

							PortletURL dungXuLy_Url = renderResponse.createRenderURL();
							dungXuLy_Url
									.setParameter("jspPage",
											"/html/portlet/ipmslistportlet/detailsHoSo/Details_DangKyMoi_choTn.jsp");
							dungXuLy_Url.setParameter("idHoSo",
									String.valueOf(instance.getId()));//Quocdv :Thay hoSoTTHCCongId =>idHoSo
							//Quocdv add code :set link into detail : set tham so :idHoSo,loaiCanBo,urlQuayLai				
							dungXuLy_Url.setParameter("loaiCanBo",
									Constants.LOAI_CAN_BO.LOAI_MOT_CUA);//Add them
							dungXuLy_Url.setParameter("urlQuayLai", portletUrl.toString()); //Add them

							PortletURL xemTuChoiHoSo_Url = renderResponse.createRenderURL();
							xemTuChoiHoSo_Url.setParameter("jspPage",
									"/html/cmon/tuchoi/xem_tuchoihoso.jsp");
							xemTuChoiHoSo_Url.setParameter("idHoSo",
									String.valueOf(instance.getId()));

							ThuTucHanhChinh tthc = ThuTucHanhChinhLocalServiceUtil
									.fetchThuTucHanhChinh(instance.getThuTucHanhChinhId());
							String schemaName = instance.getMaUngDung().trim()
									.toLowerCase();
							String plName = renderRequest.getPreferences().getValue(
									schemaName + "Name", "");
							
							LiferayURL chiTietDonURL = LiferayURL
									.createRenderURL(renderRequest, plName, null)
									.setParameter(TransactionUtils.PARAM_PORTLET_NAME,
											schemaName)
									.setParameter(TransactionUtils.PARAM_ID,
											Long.toString(instance.getId()))
									.setParameter(TransactionUtils.PARAM_ID_QUY_TRINH,
											Long.toString(instance.getThuTucHanhChinhId()))
									.setParameter("maQuyTrinh", tthc.getMa())
									.setParameter("backURL",
											PortalUtil.getCurrentCompleteURL(request));
							;

							LiferayURL editHoSoMoi = LiferayURL
									.createRenderURL(renderRequest,
											"HoSoTrucTiepPortlet_WAR_cmonappportlet",
											"/html/portlet/hosotructiep/default.jsp")
									.setParameter(HoSoFields.hoSoId,
											Long.toString(instance.getId()))
									.setParameter("backURL",
											PortalUtil.getCurrentCompleteURL(request));
							;
							
							 String thongTinTraKetQuaRutHoSoURL = RutHoSoBusinessUtil.getURLTraHoSoDaYeuCauRut(
										request, instance.getId(),
										instance.getTrangThaiHoSo());
							

							// Cho loại đơn không có quy trình

							if (ConvertUtil.checkLoaiDoiTuongCongDan(
									instance.getThuTucHanhChinhId(), "003")
									&& instance.getDoiTuongCanXuLyId() != null
									&& instance.getDoiTuongCanXuLyId() > 0) {

								if (instance.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_DA_XU_LY_XONG) {
								%>
									<a href="<%=taiFileKetDoanhNghiepQuaRequestUrl.toString()%>" title="Tải kết quả"><span class="icon-14" title="Upload kết quả"/></span></a>	
									&ensp;|&ensp;<a href="<%=traKetQuaDoanhNghiepRequestUrl.toString()%>" title="Xem thông tin trả kết quả"><span class="icon-13" /></span></a>	
								<%
								} else {
								%>
										&ensp;<a href="<%=taiThemTaiLieuDoanhNghiepRequestUrl
										.toString()%>" title="Tải tài liệu"><span class="icon-14" title="Upload kết quả"/></span></a>	
								<%
										if (instance.getLoaiHoSo() == 0) {
								%>
											<a href="<%=doiChieuHoSoDoanhNghiepRequestUrl
											.toString()%>" title="Đối chiếu hồ sơ"><span class="icon-10" title="Đối chiếu"/></span></a>	
									
								<%
										}
								}

							} else {

									if (RutHoSoBusinessUtil.laHoSoDaYeuCauRut(instance)) {
																		%>
										<a href="<%= thongTinTraKetQuaRutHoSoURL %>" 
											title="Trả lại hồ sơ yêu cầu rút" style="padding: 2px"><span class="icon-13"/></span></a>	
									<%
									} else
								// Hồ sơ đã xử lý xong
											if (instance.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_DA_XU_LY_XONG) {
								%>
												<a href="<%=traKetQuaRequestUrl.toString()%>" title="Trả kết quả trực tiếp" style="padding: 2px"><span class="icon-13" title="Trả kết quả trực tiếp"/></span></a>	
												<a href="<%=taiFileKetQuaRequestUrl.toString()%>" title="Upload kết quả" style="padding: 2px"><span class="icon-14" title="Upload kết quả"/></span></a>							
										
												<!-- HS dừng xử lý -->
												<% if (instance.getDungXuLy())  {%>
													<% if (ykien == null || ykien.getChaiId() == null ||  ykien.getChaiId() ==0) { %>
													<a href="<%=xemYCBoSungHoSo_Url.toString() %>" title="Hồ sơ đã dừng xử lý (thông tin chưa được gửi đến công dân)" style="padding: 2px"><span class="icon-12" /></span></a>
													<% } else { %>
													<a href="<%=xemYCBoSungHoSo_Url.toString() %>" title="Thông tin hồ sơ dừng xử lý đã được gửi đến công dân" style="padding: 2px"><span class="icon-11"></span></a>
													<% } %>
											 	<% }  %> 
											
												<%
								//	Hồ sơ đã tiếp nhận
											} else if (instance.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_RECEIVED) {
								%>
										
													<%-- <a href="<%=boSungHoSo_Url.toString() %>" title="Yêu cầu bổ sung" style="padding: 2px"><span class="icon-9" title="Yêu cầu bổ sung"/></span></a>	 --%>						
													<a href="<%=doiChieuHoSoRequestUrl.toString()%>" title="Đối chiếu" style="padding: 2px"><span class="icon-10" title="Đối chiếu"/></span></a>	
											
								<%
								//  Hồ sơ đăng ký mới trực tuyến
											} else if (instance.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_NEW) {
																				%>
													<a href="<%=chiTietDonURL.toString()%>" title="Xem chi tiết hồ sơ" style="padding: 2px"> <span class="icon-8"  title="Xem chi tiết hồ sơ"/></span> </a>
													<%-- <a href="<%=boSungHoSo_Url.toString() %>" title="Yêu cầu bổ sung" style="padding: 2px"><span class="icon-9" title="Yêu cầu bổ sung"/></span></a> --%>
													<a href="<%=doiChieuHoSoRequestUrl.toString()%>" title="Đối chiếu hồ sơ" style="padding: 2px" ><span class="icon-10" title="Đối chiếu"/></span></a>								
											
									<%
									// Hồ sơ bị từ chối
											} else if (instance.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_TU_CHOI) {
																									%>
												<a href="<%=xemTuChoiHoSo_Url.toString()%>" title="Xem ý kiến từ chối" style="padding: 2px"><span class="icon-11" title="Xem ý kiến từ chối"/></span> </a>
								<%	
									// Hồ sơ yêu cầu bổ sung
											} else if (instance.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_BO_SUNG) {
								%>
												<%
													if (ykien == null || ykien.getChaiId() == null || ykien.getChaiId() == 0) {
												%>
													<a href="<%=xemYCBoSungHoSo_Url.toString()%>" title="Xem yêu cầu bổ sung (thông tin chưa được gửi đến công dân)" style="padding: 2px"><span class="icon-12" /></span></a>
												<%
													} else {
												%>
													<a href="<%=xemYCBoSungHoSo_Url.toString()%>" title="Thông tin bổ sung đã được gửi đến công dân" style="padding: 2px"><span class="icon-11"></span></a>
												<%
													}
												%>
												
												<%
												if (instance.getLoaiHoSo() == Constants.QuanLiHoSo.TYPE_HOSO_OFFLINE) {
												%>
													<button onclick="location.href='<%=editHoSoMoi.toString()%>'" class="egov-func-edit" title="Bổ sung hồ sơ"  type="button"></button>
												<%
													}
												%>
							<%
								//Hồ sơ đã được bổ sung ;chờ tiếp nhận 
											} else if (instance.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_DA_BS_CHO_XU_LY) {
							%>
												<a href="<%=chiTietDonURL.toString()%>" title="Xem chi tiết hồ sơ" style="padding: 2px"><span class="icon-8"  title="Xem chi tiết hồ sơ"/></span></a>
								
								<%
											} else if (instance.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_DANG_XU_LY) {
																%>
												<%-- <a href="<%=boSungHoSo_Url.toString() %>" title="Yêu cầu bổ sung" style="padding: 2px"><span class="icon-9" title="Yêu cầu bổ sung"/></span></a>	 --%>						
												<a href="<%=doiChieuHoSoRequestUrl.toString()%>" title="Đối chiếu" style="padding: 2px"><span class="icon-10" title="Đối chiếu"/></span></a>	
											
							<%
								//  Hồ sơ đã trả kết quả trực tuyến
											} else if (instance.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_DA_TRA_KET_QUA) {
																%>
												<a href="<%=traKetQuaRequestUrl.toString()%>" title="Xem thông tin trả kết quả" style="padding: 2px"><span class="icon-13"  title="Xem thông tin trả kết quả"/></span></a>	
						<%
								// 	rut ho so
											} else if (instance.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_RUT_HS) {
										
							%>
												<a href="<%=thongTinTraKetQuaRutHoSoURL%>" title="Xem thông tin rút hồ sơ" style="padding: 2px"><span class="icon-13"  title="Xem thông tin rút hồ sơ"/></span></a>
						<%
											} else if (instance.getTrangThaiHoSo() == Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_MOI_TIEP_NHAN) {
													if (instance.getLoaiHoSo() == Constants.QuanLiHoSo.TYPE_HOSO_OFFLINE) {
													%>
														<button onclick="location.href='<%=editHoSoMoi.toString()%>'" class="egov-func-edit" title="Bổ sung hồ sơ"  type="button"></button>
														<button onclick="rutHoSo('<%=rutHoSo%>','<%=instance.getId()%>');" class="egov-func-delete" title="Xóa hồ sơ"  type="button" style="width: 15px; height: 15px;"></button>
													<%
													}
													%>
														<button onclick="moveOneHS('<%=instance.getId()%>');"  title="Chuyển phòng chuyên môn" style="padding: 2px; border: none" class="icon-13 MOVEHS" type="button"></button>
													<%
												}
										}
									}
								%>
							
				</td>
				
			</tr>
	
	</table>
	<br />
	<div id = "paginationTrans">
		<liferay-ui:search-paginator searchContainer="<%=searchContainer%>" />
	</div>
</form>		
</div>

<div id="loading" title="Đang chuyển hồ sơ"> </div>

<style type="text/css">
h2 {
    cursor: pointer;
    color: #696;
    font-weight:bold;   
    background-image:url('<%=request.getContextPath()%>/images/plus3.jpg'); 
    background-repeat:no-repeat;
    text-indent:50px;
    background-position:93% 50%;
    					
}
.open {
    background-image:url('<%=request.getContextPath()%>/images/minusb.jpg');
}
</style>

<script type="text/javascript">

$('.clearfix').show();
$('h2').click(function () {
	$(this).toggleClass("open");
    $(this).next().toggle();
    
}); //end toggle

$( window ).load(function() {
	var inp = $(".egov-inputfield").val();
		
	if (($(".egov-select")[0].selectedIndex > 0) || (jQuery.trim(inp).length > 0)) {
		$('.clearfix').show();
    }
	  // Run code
});

$(document).ready(function() {
	$checkHeader = $('.egov-checkbox.HEADER');
	$checkHeaderSelected = $('.HEADER span');
	$checkElement = $('.checker span');
	$(".wd-vn-date-format").vnDateFormat();
	// click on the header checkbox
	$checkHeader.click(function() {
		if ($checkHeaderSelected.hasClass('checked')) {
			$checkHeaderSelected.removeClass('checked');
			$checkElement.removeClass('checked');
			
		} else {
			$checkHeaderSelected.addClass('checked');
			$checkElement.addClass('checked');
		}
	});
	
 	$('#textSearch').keypress(function(event){
	    var keycode = (event.keyCode ? event.keyCode : event.which);	    
	    if(keycode == '13'){
	    	var gt='<%=defaultSearchStr%>';	    	
	    	var form = document.searchIpmsListForm;
	    	if ( form.transactionKeyword.value == gt){
	    		form.transactionKeyword.value = "";
	    	}
	    	form.submit();
	    }
	});
	 
	// di chuyen ho so
	$('button.MOVEHS').click(function() {
		// define the element which selected
		$idHoSoSelected = $('span.checked input');
		var listHoSoId = '';
		
		// get all selecting ids
		$idHoSoSelected.each(function() {
			var value = $(this).attr('idHoso');
			if ($.isNumeric(value)) {
				listHoSoId += value + ',';
			}
		}); 
		
		// post data to server
		if (listHoSoId.length > 0) {
			var title = 'Đang chuyển hồ sơ ...';
			postDataToServer('<%=moveListHoSo%>', listHoSoId, title);
			
		} else {
			alert('Vui lòng chọn hồ sơ!', 'Thông báo');
		}
	});
});

function rutHoSo(url, idHoSo) {           
	if (confirm('Bạn chắc chắn muốn rút hồ sơ?')) {
	  	var title = 'Đang rút hồ sơ ...';	
		postDataToServer(url, idHoSo, title);
	}
}

function moveOneHS(idHoSo) {
	var title = 'Đang chuyển hồ sơ ...';
	postDataToServer('<%=moveListHoSo%>', idHoSo, title);
}

$("#loading").dialog({
    hide: 'close',
	show: 'slide',
	autoOpen: false,
    height: 30,
    width: 250,
    resizable: false,
    title: "Đang chuyển hồ sơ ...",
    close: function() {
    	$('button[type=button]').removeAttr("disabled");
    }
});

function postDataToServer(url, idHoSo, title) {	
	$('button[type=button]').attr("disabled","disabled");
	$.ajax({
		  url : url,
		  data : "idHoSo=" + idHoSo,
		  type: "POST",
		  dataType : "json",
		  beforeSend: function(){
			  $("#loading").dialog({
				    title: title
				});
	           $("#loading").dialog('open');
	        },
		  success : function(data) {
			 $("#loading").dialog('close');
			 var  status = jQuery.parseJSON(data.status);			  
			 
			 if (status) {
				  location.reload();
			 }
			 
			 $('button[type=button]').removeAttr("disabled");
		  }
		});
}
	
function clickButtonSearch() {
	$('#searchIpmsListForm').submit();
}

function selectThuTuc() {
	var thuTucDuocChon = $('#sel_thu_tuc').val()
	,	$nhomThuTucOptgroup = $('#sel_thu_tuc').find('option[value="' + thuTucDuocChon + '"]').parent();
	;
	
	if (thuTucDuocChon !== '0') {
		$('#sel_nhom_thu_tuc').val($nhomThuTucOptgroup.attr('value'));
		$('#hidden_thu_tuc_duoc_chon').val(thuTucDuocChon);
		$('#searchIpmsListForm').submit();
	} else {
		selectNhomThuTuc();
	}
}

function selectNhomThuTuc() {
	var nhomThuTucDuocChon = $('#sel_nhom_thu_tuc').val()
	,	$nhomThuTucOptgroup = $('#sel_thu_tuc').find('optgroup[value="' + nhomThuTucDuocChon + '"]')
	,	thuTucDuocChon = ''
	;
	
	$nhomThuTucOptgroup.children().each(function() {
		var $thuTuc = $(this);
		thuTucDuocChon += $thuTuc.attr('value') + ',';
	});
	
	thuTucDuocChon = thuTucDuocChon.substring(0, thuTucDuocChon.length - 1);
	
	$('#sel_thu_tuc').val(0);
	$('#hidden_thu_tuc_duoc_chon').val(thuTucDuocChon);
	$('#searchIpmsListForm').submit();
}
</script>
