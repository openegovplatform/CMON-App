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
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCongClp"%>
<%@page import="org.oep.egovcore.util.HSRParamUtil"%>
<%@page import="org.oep.egovcore.util.StringPool"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTBusinessUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="static org.oep.cmon.portlet.ipmslist.utils.HoSoXuLyURLUtil.*"%>
<%@page import="org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc"%>
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="org.oep.egovcore.util.Helper"%>
<%@page import="org.oep.cmon.util.UengineUtil"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil"%>
<%@page import="org.oep.cmon.util.EgovUtil"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="org.apache.commons.lang.WordUtils"%>
<%@page import="org.oep.cmon.util.ComUtils"%>
<%@page import="java.util.Collections"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="org.oep.cmon.Constants"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page
	import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.portlet.transaction.TransactionUtils"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.portlet.PortletRequest"%>

<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.xml.datatype.XMLGregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page import="java.text.DateFormat"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.egovcore.util.DateTimeUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.log.Log" %>
<%@page import="org.oep.cmon.portlet.ipmslist.business.ValidatorIPMSList"%>
<%@ taglib prefix="egov" uri="/WEB-INF/tld/egov.tld"%>
<portlet:defineObjects />
<link href="<%=request.getContextPath()%>/css/egov-custom-table.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/js_citizen_transaction.js" type="text/javascript"></script>

<%
	long selectedNhomThuTucId = HSRParamUtil.getLong(request, "nhomThuTucId");
	long selectedThuTucId = HSRParamUtil.getLong(request, "thuTucId");
	String canBotransType = ParamUtil.getString(request, "canBotransType", "0");
	long idTempMember=Long.valueOf(canBotransType);
	long uid = PortalUtil.getUserId(request);
	String today = DateTimeUtil.getDayMonthYear(new java.util.Date()); 	
	String dayCurrent=DateTimeUtil.getDay(new java.util.Date());
	String monthCurrent=DateTimeUtil.getMonth(new java.util.Date());
	String yearCurrent=DateTimeUtil.getYear(new java.util.Date());
	//Get first time of Current year
	String firstDayOfYear="01/01/"+yearCurrent;

	int ACTIVATED = 0;
	String defaultSearchStr = "Nhập Mã hồ sơ/Tên người nộp";
	String transactionKeyword = URLDecoder.decode(ParamUtil.getString(request, "transactionKeyword"), StringPool.UTF8) ;
	String searchKeyWord = transactionKeyword;
	CongChuc congChuc = null;
	if (idTempMember > 0 && idTempMember!= 1) {
  		congChuc = CongChucLocalServiceUtil.getCongChuc(idTempMember);

  	} else {
  		congChuc = EgovUtil.getCongChucDaDangNhap(uid);
  	}
	
	List<ThongTinThuTuc> dsThuTuc2CanBo = HoSoBusinessUtil.getDSThuTuc2CanBo(congChuc);
	
   	String transType = ParamUtil.getString(request, "transType", "0");
   	
	if (transType.isEmpty() || transType.equals("0")) {
		transType = ComUtils.getListTTHCID(dsThuTuc2CanBo);
	}
	
	// Avoid SQL Exception
	long[] arrThuTuc = Helper.parseArrayLong(transType);
	transType = Helper.join(arrThuTuc);
	
	//Refill calendar when submit 
	String NgayBD=ParamUtil.getString(request, "TuNgay", firstDayOfYear);
	String NgayKT=ParamUtil.getString(request, "DenNgay", today);
		
	//add new
	//Get Ngay from calendar by input tag name 
	Date d1 = DateTimeUtil.getRequestDate(request, "TuNgay");
	Date d2 = DateTimeUtil.getRequestDate(request, "DenNgay");				 
	
	Log logger = LogFactoryUtil.getLog(this.getClass());
	String tuNgay, denNgay;
	tuNgay="01/01/"+yearCurrent;
	denNgay=dayCurrent +"/"+monthCurrent+"/"+yearCurrent;

	
	if(NgayBD !=null && ValidatorIPMSList.checkDateValid(NgayBD)==true){
		tuNgay=NgayBD;
		logger.info("Trong IF tuNgay :"+ tuNgay); 
	}else{NgayBD=tuNgay;}
	
	if(NgayKT !=null && ValidatorIPMSList.checkDateValid(NgayKT)==true ){
		//adding more 1 day, using in SQL(Between)
		Date date = null;
  			Date formatteddate = null;
  			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
  			date = df.parse(NgayKT);  	            	        
  	        
		Date nextdenNgay = new Date(date.getTime() + (1000 * 60 * 60 * 24));
		denNgay=DateTimeUtil.getDayMonthYear(nextdenNgay);
		logger.info("Trong IF denNgay :"+ denNgay);
	}else{NgayKT=denNgay;}
		
	
	logger.info("tuNgay :"+ tuNgay);
	logger.info("denNgay :"+ denNgay);

	PortletURL nopHoSoRequestUrl = renderResponse.createRenderURL();
	nopHoSoRequestUrl.setParameter("jspPage", "/html/portlet/ipmslistportlet/offline/nopHoSoOffline.jsp");
	nopHoSoRequestUrl.setParameter("transactionKeyword", transactionKeyword);
	
	int currentTransPage = ParamUtil.getInteger(request, "currentTransPage");
	if (transactionKeyword.equals(StringPool.BLANK)) {
		transactionKeyword = defaultSearchStr;
	}
	
	// String transType = ParamUtil.getString(request, "transType", "0");
	String statusPreParam = Constants.QuanLiHoSo.HSTTHCC_CURRENT_STATUS_PREF_PARAM;
	String statusHS = portletPreferences.getValue(statusPreParam, ""); 
	
	//Lay Hien thị cán bộ
	String cb = Constants.CanBoXuLy.PROCESSING_CAN_BO_PREF_PARAM;
	String statuscb = portletPreferences.getValue(cb, Constants.CanBoXuLy.NHAN_VIEN); 
	
	/* //Lay trang thai ho so tu portlet cau hinh
	String tt = Constants.TRANGTHAIHOSO.PROCESSING_CAN_BO_PREF_PARAM;
	String statuscb = portletPreferences.getValue(cb, "");  */
	
	/* String statusHS = ParamUtil.getString(request, "statusHS", "-1"); */ 
	// nopHoSoRequestUrl.setParameter("transType", transType);
	nopHoSoRequestUrl.setParameter("statusHS", statusHS);
	PortletURL portletUrl = renderResponse.createRenderURL();
	portletUrl.setParameter(TransactionUtils.PARAM_VIEW_TYPE, TransactionUtils.VIEW_TRANSACTION_LIST);
	portletUrl.setParameter("tabs1", "tab.ipmslist.dangXuLy");
	// long cqqlId = -1;
	String emailCanBo = null;
	long taikhoanNguoiDungId = -1;
	if (uid > 0) {
		try {
	TaiKhoanNguoiDung taiKhoanNguoiDungs = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(uid);
	taikhoanNguoiDungId = taiKhoanNguoiDungs.getId();
	emailCanBo = taiKhoanNguoiDungs.getEmail();
		} catch (Exception e) {
	taikhoanNguoiDungId = 0;
	emailCanBo = null;
		}
		
	}
	
	logger.info("memberId la : " + canBotransType);
		  	
  	logger.info("congChuc la :" + congChuc);
	List<CongChuc> cc=Collections.emptyList();
	
	if (Constants.CanBoXuLy.LANH_DAO.equals(statuscb)) { 
		CongChuc currentMember = EgovUtil.getCongChucDaDangNhap(uid);
		cc = CongChucLocalServiceUtil.findByCoQuanQuanLyID(currentMember.getCoQuanQuanLyId());
	}
	
	// get thu tuc hanh chinh cua cong chuc login

%>

<div class="egov-container">

	<form id="searchIpmsListForm" name="searchIpmsListForm" method="post" action="<%=portletUrl.toString()%>" autocomplete="off" >
		<input id="hidden_thu_tuc_duoc_chon" type="hidden" name="transType" value="<%= transType %>" />

		<liferay-ui:success message="org.oep.registry.sucessfuly.message"
			key="org.oep.registry.sucessfuly.message" />
		<h2 width="70%" align="right">&nbsp;&nbsp;&nbsp;Đóng/Mở</h2>		
		<div class="clearfix septop10 sepbot10">
				<% if(cc !=null & cc.size() != 0){ %>
			<div class="fi last">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Chọn cán bộ để thấy các hồ sơ đang được cán bộ đó xử lý
						</label>
					</div>
					<div class="fi-input">
					    <select style="height: 32px !important;" name="canBotransType" class="egov-select" onchange="submitIpmsListForm('<%=defaultSearchStr%>');">
					        <option  value = "0">
								Chính tôi
							</option>	
							<option style="font-size: 15px;font-style: italic;font-weight: bold;" <%if (idTempMember == 1) {%>selected<%}%> value = "1">
								Chọn tất cả
							</option>				
							<%
								long coQuanQLId = 0L;
								
								for (int i = 0; i < cc.size() ; i++) {
									CongChuc item = cc.get(i) ;			
									
									if (item.getTaiKhoanNguoiDungId() == null) {
										continue;
									}
									%>				
								<option <%=canBotransType.equals(String.valueOf(item.getId()))? "selected":""%>  value="<%=item.getId()%>" >
										<%=item.getHoVaTen()%>	 							
								</option>					
							<% } %>
					    	</select>
				    	</div>
				    </div>
				</div>
			<% } %>
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
		<div class="clear fi fi30">
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
					class="egov-inputfield" size="60"
					value="<%=searchKeyWord%>"												
					<%-- onfocus="if(this.value=='<%=defaultSearchStr%>') this.value='';"
					onblur="if(this.value=='') this.value='<%=defaultSearchStr%>'" --%>
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
			<div class="fi fi10">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							&nbsp;
						</label>
					</div>
					<div class="fi-input">
						<button
							type="button"
							onclick="clickButtonSearch();"
							class="egov-button-search small"
						>&nbsp;</button>
					</div>
				</div>
			</div>
	</div>
		<table class="egov-table result-grid clear hoso-grid" id="profileListId">
			<thead>
				<tr>
				    <th align = "center"><liferay-ui:message key="org.oep.cmon.ipms.list.stt"/></th>
				    <!-- <th scope="col" width="10%"><liferay-ui:message key="org.oep.brms.registry.viewTransaction.code"/></th> -->
				    <th scope="col" width="10%">Mã số biên nhận</th>
				    <th scope="col" width="30%"><liferay-ui:message key="org.oep.cmon.ipms.list.dvc"/></th>
				    <th scope="col" width="14%"><liferay-ui:message key="org.oep.cmon.ipms.list.nguoiGui"/></th>
				    <th scope="col" width="14%">Chủ hồ sơ</th>
				    <th scope="col" width="14%">Cán bộ chuyển hồ sơ</th>
				    <!-- <th scope="col" width="11%"><liferay-ui:message key="org.oep.brms.registry.viewTransaction.status"/></th> -->
				    <th scope="col" width="7%"><liferay-ui:message key="org.oep.cmon.ipms.list.ngayNop"/></th>
				    <th scope="col" width="7%"><liferay-ui:message key="org.oep.cmon.ipms.list.ngayHenTra"/></th>
				    <th scope="col"><liferay-ui:message key="org.oep.cmon.ipms.list.thaotac"/></th>
				</tr>
			</thead>
			<tbody>
			<%
				String searchTransKeyword = transactionKeyword;
				if (searchTransKeyword.equals(defaultSearchStr)) {
					searchTransKeyword = null;
				}
				portletUrl.setParameter("transType", transType);
				portletUrl.setParameter("canBotransType", canBotransType);
				portletUrl.setParameter("statusHS", statusHS);
				portletUrl.setParameter("thuTucId", Long.toString(selectedThuTucId));
				portletUrl.setParameter("nhomThuTucId", Long.toString(selectedNhomThuTucId));

				if (searchTransKeyword != null) {
					portletUrl.setParameter("transactionKeyword", URLEncoder.encode(searchTransKeyword, StringPool.UTF8));
				}
				SearchContainer<HoSoTTHCCong> searchContainer = null;
				if (currentTransPage > 0) {
					searchContainer = new SearchContainer<HoSoTTHCCong>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, currentTransPage, 10, portletUrl, null,
									null);
				} else {
					searchContainer = new SearchContainer<HoSoTTHCCong>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 10, portletUrl, null, null);
				}
				
				int start = searchContainer.getStart();
				int end = searchContainer.getEnd();

				/* List<HoSoTTHCCong> results = HoSoTTHCCongLocalServiceUtil.searchHSDangXuLy(
						searchTransKeyword, Long.parseLong(transType), Integer.parseInt(statusHS), emailCanBo, start, end);
				long total = HoSoTTHCCongLocalServiceUtil.countHSDangXuLy(
						searchTransKeyword, Long.parseLong(transType), Integer.parseInt(statusHS), emailCanBo, start, end); */
				
				String userEmail="";
				long userId = congChuc.getTaiKhoanNguoiDungId();
			   	
			   	List<String> lsMail=new ArrayList<String>();
			   	
			   	if (idTempMember >1) {
			   		//Lay userEmail cua member trong Combobox			   		
			   		CongChuc ch=CongChucLocalServiceUtil.fetchCongChuc(idTempMember);
			   		TaiKhoanNguoiDung accMember=TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(ch.getTaiKhoanNguoiDungId());			   					   		
			   		if(accMember !=null){
			   			userEmail=accMember.getEmail();			   			
			   		}else{
			   			userEmail="";
			   		}
			   		
			   	}else if(idTempMember ==1){
			   		//Lay userEmail cua All member trong Combobox			   		
			   		CongChuc currentUser = EgovUtil.getCongChucDaDangNhap(uid);
			   		List<CongChuc> ccAll = CongChucLocalServiceUtil.findByCoQuanQuanLyID(currentUser.getCoQuanQuanLyId());
			   		if(ccAll!= null && ccAll.size() > 0 ){			   			
			   			for (int i = 0; i < ccAll.size() ; i++) {
							CongChuc item = ccAll.get(i) ;	
							if(item.getTaiKhoanNguoiDungId()!= null){
								
								TaiKhoanNguoiDung accAllMember=null;
								accAllMember = TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(item.getTaiKhoanNguoiDungId());								
								
							    if(accAllMember !=null && (accAllMember.getEmail() != null || !"".equals(accAllMember.getEmail())) ){
									lsMail.add(accAllMember.getEmail());
									
								} 
							}			   				
			   			}
			   			
			   		}
			   	}		   	
			   	
			   	else{			   		
			   		//Lay userEmail cua User login
			   		userEmail=TaiKhoanNguoiDungLocalServiceUtil.getTaiKhoanNguoiDung(userId).getEmail();			   		
			   	}
				
				String yeuCauRutValue = portletPreferences.getValue( Constants.QuanLiHoSo.YEU_CAU_RUT, "");
				int yeuCauRutInt = 0;
				if ("on".equals(yeuCauRutValue)) {
					yeuCauRutInt = 1;
				}
				
				int countEmail = lsMail.size();
				
				if (countEmail == 0) {
					lsMail.add(userEmail);
				}
				List<String> lsMaHoSo = UengineUtil.getAllMaHoSoByCanBo(lsMail.toArray(new String[lsMail.size()]), tuNgay, denNgay,  Helper.parseArrayInt(statusHS));
				
				 //List Dung De Test:
				//List<String> lsMaHoSo =new ArrayList<String>(); 
				
				//Test ho so cua lanh dao
				//lsMaHoSo.add("1407747495151");
				//lsMaHoSo.add("1407291560643");
				//lsMaHoSo.add("1407291698129");
				//lsMaHoSo.add("1407229463221");
				//end test ho so cua lanh dao
				
				// HO SO CHO LIEN THONG
				//lsMaHoSo.add("1408333587187");
				//lsMaHoSo.add("1406861425627");
				//lsMaHoSo.add("1406861517233");
				//lsMaHoSo.add("1406513079759");
				
				//Test ho so da xu ly or da tra ket qua
				
				/* lsMaHoSo.add("1407318225760");
				lsMaHoSo.add("1405482716792");
				lsMaHoSo.add("1407118038476");
				lsMaHoSo.add("1405911487701"); */
				//end test ho so da xu ly or da tra ket qua
				
				//Test ho so HO_SO_DA_TIEP_NHAN or HO_SO_DANG_XU_LY
				
				/* lsMaHoSo.add("1407115436297");			
				lsMaHoSo.add("1407221612229");
				lsMaHoSo.add("1405494667238");
				lsMaHoSo.add("1407291560643");
				lsMaHoSo.add("1407291698129");
				lsMaHoSo.add("1407229463221"); */
				//end test HO_SO_DA_TIEP_NHAN or HO_SO_DANG_XU_LY
				
				//Test ho so HO_SO_CHO_BO_XUNG
				
				/* lsMaHoSo.add("1405475815462");			
				lsMaHoSo.add("1406854195381");
				lsMaHoSo.add("1407486608771"); */
				//end test  HO_SO_CHO_BO_XUNG
				
				List<HoSoTTHCCong> results = Collections.emptyList();

				int total = 0;
				
				//Lay tat ca
				logger.info("Xuat lsMaHoSo :" + lsMaHoSo);
				
				total = HoSoTTHCCongLocalServiceUtil.countAllHSDangXuLyMutilStatusAndTTHC(
					searchTransKeyword, transType, statusHS, lsMaHoSo,tuNgay, denNgay, start, end);
				results = HoSoTTHCCongLocalServiceUtil.searchAllHSDangXuLyMutilStatusAndTTHC(
					searchTransKeyword, transType, statusHS, lsMaHoSo, tuNgay, denNgay, start, end);
		 		
				searchContainer.setTotal(total);
				searchContainer.setResults(results);
				String urlDanhSachHienTai = PortalUtil.getCurrentCompleteURL(request);
				
				for (int i = 0; i < results.size(); i++) {
					HoSoTTHCCong instance = results.get(i);
			%>
				<tr>
					<td style="text-align: center;">
						<%=(searchContainer.getStart() + i + 1)%>
					</td>
	
					<% String color = (instance.getLoaiHoSo() == Constants.LOAI_HO_SO_TRUC_TUYEN) ? "color:#009900" : StringPool.BLANK; %>				
					<td style="<%= color %>; text-align: center;">
						<%=GetterUtil.getString(instance.getMaSoBienNhan())%>
					</td>
					<td>
						<%
						LiferayURL chiTietHoSoURL = LiferayURL.createRenderURL(request,
							"/html/portlet/ipmslistportlet/detailsHoSo/Details_DangKyMoi_choTn.jsp")
							.setParameter("idHoSo", instance.getId())
							.setParameter("ipmsId", instance.getId())
							.setParameter("statusHS", statusHS)
							.setParameter("currentTransPage", searchContainer.getCur())
							.setParameter("transactionKeyword", transactionKeyword)
							.setParameter("type", Constants.CAN_BO)
							.setParameter("loaiCanBo", Constants.LOAI_CAN_BO.LOAI_CAN_BO_XU_LY)
							.setParameter(Constants.CanBoXuLy.PROCESSING_CAN_BO_PREF_PARAM, statuscb)
						;
						storeDanhSachURL(request, urlDanhSachHienTai);
						%>
						<a href="<%=chiTietHoSoURL%>"><%=instance.getTenThuTucHanhChinh()%></a>
					</td>
					<td align="left" style="line-height: 20px ">
						<%= WordUtils.capitalizeFully(instance.getHoTenNguoiNopHoSo()) %>
					</td>
					<td align="left" style="line-height: 20px ">
						<%= WordUtils.capitalizeFully(instance.getChuSoHuu()) %>
					</td>
					<td style="margin-left: 5px;">
						<%= HoSoBusinessUtil.getHoTenCanBoVuaThaoTacVoiHoSo(instance) %>
					</td>
					<td style="text-align: center;">
						<%= DateTimeUtil.getDayMonthYear(instance.getNgayNopHoSo())%>
					</td>
					<td style="text-align: center;">
						<%=DateTimeUtil.getDayMonthYear(instance.getNgayHenTraKetQua())%>
					</td>
					<td style="text-align: center;" class="fn">
					
						<!-- Lanh dao theo doi ho so, chi co' 3 nut' -->
						<% if (Constants.CanBoXuLy.LANH_DAO.equals(statuscb)) { %>
						
							<% if (laHoSoCoTheTraoDoiThongTin(instance)) { %>
								<a class="traodoithongtin" 
									href="<%=getURLTraoDoiThongTin(request, instance, urlDanhSachHienTai)%>" 
									title="Trao đổi thông tin"
								>&nbsp;</a>
							<% } %>
							
							<% if (laHoSoCoTheXemTienTrinhXuLy(instance)) { %>
								<a class="xem-tien-trinh icon-16" 
									id="<%= instance.getMaSoHoSo()%>"
									title="Xem tiến trình xử lý"
									href="#"
								>&nbsp;</a>
							<% } %>
								
							<% if (laHoSoCoTheLuuTaiLieu(instance)) { %>	
								<a class="icon-17"
									href="<%=getURLLuuTaiLieu(request, instance, urlDanhSachHienTai)%>"
									title="Lưu tài liệu trong quá trình xử lý"
								>&nbsp;</a>
							<% } %>					
														
						<% } else { %>
						
							<% if (laHoSoCanLuanChuyen(instance)) { %>
								<% if (HSLTBusinessUtil.laHoSoCanGuiLienThong(instance)) { %>
									<a class="icon-19" 
										href="<%=chiTietHoSoURL%>"
										title="Vào trang chi tiết để thực hiện gửi liên thông"
									>&nbsp;</a>
								<% } else { %>
									<a class="icon-19" 
										href="<%=getURLLuanChuyen(request, instance, urlDanhSachHienTai)%>"
										title="Luân chuyển"
									>&nbsp;</a>
								<% } %>
							<% } %>
								
							<% LiferayURL capChungChiURL = getURLCapChungChiGiayPhep(request, instance, urlDanhSachHienTai); %>
							<% if ( (capChungChiURL != null) && laHoSoCoTheCapChungChiGiayPhep(instance) ) { %>
								<a class="icon-18"
									href="<%=capChungChiURL%>"
									title="Xử lý hồ sơ"
								>&nbsp;</a>
							<% } %>
							
							<% if (laHoSoCoTheTraoDoiThongTin(instance)) { %>
								<a class="traodoithongtin" 
									href="<%=getURLTraoDoiThongTin(request, instance, urlDanhSachHienTai)%>" 
									title="Trao đổi thông tin"
								>&nbsp;</a>
							<% } %>
							
							<% if (laHoSoCoTheXemTienTrinhXuLy(instance)) { %>
								<a class="xem-tien-trinh icon-16" 
									id="<%= instance.getMaSoHoSo()%>"
									title="Xem tiến trình xử lý"
									href="#"
								>&nbsp;</a>
							<% } %>
							
							<% if (laHoSoCoTheLuuTaiLieu(instance)) { %>	
								<a class="icon-17"
									href="<%=getURLLuuTaiLieu(request, instance, urlDanhSachHienTai)%>"
									title="Lưu tài liệu trong quá trình xử lý"
								>&nbsp;</a>
							<% } %>	
							
							<% if (laHoSoCoTheYeuCauBoSung(instance)) { %>
								<a class="icon-9"
									href="<%=getURLYeuCauBoSung(request, instance, urlDanhSachHienTai) %>"
									title="Yêu cầu bổ sung" 
								>&nbsp;</a>
							<% } %>
							
						<% } %>
	 				</td>
				</tr>
			<% } %>
			</tbody>
		</table>
		<br />
		<div id="paginationTrans">
			<liferay-ui:search-paginator searchContainer="<%=searchContainer%>" />
		</div>
	</form>
</div>

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

</script>

<script type="text/javascript">
$(document).ready(function() {	
	
	 $(".wd-vn-date-format").vnDateFormat();
	 
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

});

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
<%@ include file="/html/portlet/ipmslistportlet/viewProcess.jsp"%>
