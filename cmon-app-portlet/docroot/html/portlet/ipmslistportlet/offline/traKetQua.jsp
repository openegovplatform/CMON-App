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
<%@page import="org.oep.cmon.util.EgovUtil"%>
<%@page import="org.oep.egovcore.util.StringPool"%>
<%@page import="org.oep.cmon.dao.cd.model.GioiTinh"%>
<%@page import="org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil"%>
<%@page import="org.oep.egovcore.util.DateTimeUtil"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil"%>
<%@page import="org.oep.cmon.dao.beans.congdan.CongDan"%>
<%@page import="org.oep.cmon.dao.hosolienthong.service.HoSoLienThongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosolienthong.model.HoSoLienThong"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTFields"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTBusinessUtil"%>
<%@page import="org.oep.cmon.portlet.ruthoso.RutHoSoFields"%>
<%@page import="org.oep.egovcore.util.HSRParamUtil"%>
<%@page import="org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.util.DateUtil"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Time"%>
<%@page
	import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DonViHanhChinh"%>
<%@page import="org.oep.cmon.portlet.ipmslist.business.TraKetQuaXuLy"%>
<%@page import="org.oep.cmon.dao.tlct.model.DanhMucGiayTo"%>
<%@page
	import="org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.tlct.model.TaiLieuChungThuc"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>   
<%@page import="org.oep.cmon.dao.hosohcc.model.FileDinhKem"%>
<%@page
	import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page
	import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/html/portlet/ipmslistportlet/offline/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
 
 
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/customEgovTheme.css">  

<portlet:resourceURL var="fetchValues" id="fetchDonViHanhChinh" />
<portlet:renderURL var="quaylai">
	<portlet:param name="jspPage"
		value="<%=Constants.PATH_TRA_KET_QUA.PATH_QUAY_LAI%>" />
</portlet:renderURL>

<script type="text/javascript">
function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode;
   if (charCode != 46 && charCode > 31 
     && (charCode < 48 || charCode > 57))
      return false;
   
   return true;
}
</script>
<%
	Log log = LogFactoryUtil.getLog("DEBUG"); 

PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "traHoSoRequest");

//Get data from object form when view on View
 String tinhId="";
 String huyenId="";
 String xaId=""; 
 
 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 Calendar cal = Calendar.getInstance();
 
 TraKetQuaXuLy traketqua = null;
 List<DanhMucGiayTo> listGiaytoKq = null;
 List<Boolean> statusKetQua =  null;
 List<Integer> listnNumber = null;
 
 List<DanhMucGiayTo> listGiayToNop = null;
 List<Boolean> statusGiayToNop = null;
 String urlQuayLaiThongTinChung ="/html/portlet/ipmslistportlet/view.jsp";
 
 long idCongVanKhongDuDK =0;
 //Get tham so gia tri -> id cong van tra loi
 if(ThamSoLocalServiceUtil.getValue(Constants.CONGVAN_TRALOI_KHONGDUKD) != null)
 {
	 if(!ThamSoLocalServiceUtil.getValue(Constants.CONGVAN_TRALOI_KHONGDUKD).isEmpty() )
	 {
		 idCongVanKhongDuDK =Long.parseLong(ThamSoLocalServiceUtil.getValue(Constants.CONGVAN_TRALOI_KHONGDUKD));
	 }
 }
 
 if (ParamUtil.getString(request, "ulrRollBack") != null) {
		if(!ParamUtil.getString(request, "ulrRollBack").isEmpty())
		{
	urlQuayLaiThongTinChung  = ParamUtil.getString(request, "ulrRollBack");
		}
		else
		{
		  urlQuayLaiThongTinChung ="javascript:history.back()";	
		}	
	}
 
 try
 {
	 
	 if(request.getParameter("HosotthcCongId") != null)
 	  {
		 if(!request.getParameter("HosotthcCongId").isEmpty() )
		 {
 			traketqua  = new TraKetQuaXuLy(request);
		 }
	 } 
	else
	{
		if(request.getAttribute(Constants.SESSION_KEY.KEY_TRAKETQUA) != null)
		{
	traketqua = (TraKetQuaXuLy)request.getAttribute(Constants.SESSION_KEY.KEY_TRAKETQUA);
		}
	}
 }
 catch(Exception e)
 {
	 e.printStackTrace();
 }
     
	if(traketqua != null)
	 {
		 listGiaytoKq = traketqua.getGiayToKetQua();
		 statusKetQua = traketqua.getCheckTraKetQua();
		 listnNumber=traketqua.getNumberGiayToTra();
		 
		 listGiayToNop = traketqua.getGiayToBCNop();
		 statusGiayToNop=traketqua.getCheckTraGiayTo();
		 
/* 		 xaId = traketqua.getXaId();
		 huyenId = traketqua.getHuyenId();
		 tinhId =traketqua.getTinhId(); */
	 }
%>
<div class="egov-container">
	<select style="display: none; width: 100%" id="egov-form-errors">
	    <option value="email">
			<liferay-ui:error key="email"
				message="org.oep.form.traketqua.error.email" />
		   <liferay-ui:error key="emailnguoitraLon"
				message="org.oep.form.traketqua.error.emailLon" />
		</option>
	   <option value="dienthoaididong">
			<liferay-ui:error key="dienthoaididong"
				message="org.oep.form.traketqua.error.dienthoaididong" />
		</option>
	  <option value="nguoinhanketqua">
			<liferay-ui:error key="nguoinhanketqua"
				message="org.oep.form.traketqua.error.nguoinhanketqua" />
		</option>
		<option value="ngaysinh">
			<liferay-ui:error key="ngaysinh"
				message="org.oep.form.traketqua.error.ngaysinh" />
		</option>

		<option value="cmnd">
			<liferay-ui:error key="cmnd"
				message="org.oep.form.traketqua.error.cmnd" />
				<liferay-ui:error key="cmndNumber"
				message="org.oep.form.traketqua.error.cmndNumber" />
		   <liferay-ui:error key="cmndLon"
				message="org.oep.form.traketqua.error.cmndLon" />
		</option>

		<option value="diachi">
			<liferay-ui:error key="diachi"
				message="org.oep.form.traketqua.error.diachi" />
		</option>

		<option value="tinhId">
			<liferay-ui:error key="tinhId"
				message="org.oep.form.traketqua.error.tinhId" />
		</option>

		<option value="huyenId">
			<liferay-ui:error key="huyenId"
				message="org.oep.form.traketqua.error.huyenId" />
		</option>
		<option value="nguoitra">
			<liferay-ui:error key="nguoitra"
				message="org.oep.form.traketqua.error.nguoitra" />
		</option>

	</select>
	
<portlet:actionURL var="giayphep" name="themgphdycqdn">
</portlet:actionURL>

<%
	HoSoTTHCCong hosoTTHCC = traketqua.getHoSo();
	CongDan congDanNop = HoSoBusinessUtil.getCongDanNopHoSo(hosoTTHCC);
	boolean laChucNangRutHoSo = HSRParamUtil.getBoolean(request, RutHoSoFields.laRutHoSo);
	HoSoLienThong hoSoLienThong = HSLTBusinessUtil.getHoSoLienThongCanTraKetQua(hosoTTHCC);
	boolean laHoSoCanTraKQLienThong = (hoSoLienThong != null);
	List<GioiTinh> listGioiTinh = GioiTinhLocalServiceUtil.getDSGioiTinh();
%>

	<form id="addHoSoRequestForm" name="addHoSoRequestForm" method="post"
		action="<%=actionUrl.toString() %>">
		<input type="hidden" name="IdHoSoTT" value="<%=traketqua.getHoSo().getId()%>" />
		<input type="hidden" name="<%= HSLTFields.hoSoLienThongId %>" 
			value="<%= laHoSoCanTraKQLienThong ? hoSoLienThong.getId() : 0%>" />
		<input type="hidden" name="<%= HSLTFields.laHoSoCanTraKQLienThong %>" 
			value="<%= laHoSoCanTraKQLienThong ? 1 : 0%>" />

		<table class="egov-table-form" style="width: 100%;">
			<tr>
				<td colspan="6">
				<div style="padding: 15px 0; text-align: center; text-transform: uppercase;">
					<label class="egov-label-bold" style="font-size: 20px;">
					
					<% if (laHoSoCanTraKQLienThong) { %>
					
						Trả kết quả xử lý hô sơ liên thông
						
					<% } else if (laChucNangRutHoSo) { %>
						
						Thông tin trả hồ sơ yêu cầu rút
						
					<% } else { %>
					
						<liferay-ui:message key="org.oep.form.lable.title"/>
						
					<% } %>
					
					</label>
				</div>
			</td>
			</tr>
			<tr>
				<td colspan="1"><label class="egov-label-bold"><liferay-ui:message key="org.oep.form.lable.sobiennhan"/></label></td>
				<td colspan="5" align="left"><label class="egov-label-bold"><%=traketqua.getMaSoBienNhan() %></label></td>
			</tr>
			<tr>
				<td colspan="1"><label class="egov-label-bold"><liferay-ui:message key="org.oep.form.lable.sohoso"/></label></td>
				<td colspan="5"><label class="egov-label-bold"><%=traketqua.getMaSoHoSo()%></label></td>
			</tr>


		<%-- IF#la_tra_ket_qua_lien_thong --%>
		<% if (laHoSoCanTraKQLienThong) { %>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold">
						Đơn vị nhận kết quả xử lý hồ sơ liên thông:
					</label>
					<label class="egov-label-bold">
						<c:out value="<%= hoSoLienThong.getTenCoQuanGui() %>"/>
					</label>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<label class="egov-label-bold">
						Cán bộ nhận kết quả xử lý hồ sơ liên thông:
					</label>
					<label class="egov-label-bold">
						<c:out value="<%= hoSoLienThong.getHoTenCanBoNopHoSoGiay() %>"/>
					</label>
				</td>
			</tr>
		<% } %>

			<tr>
				<td colspan="6">
				
				<% if (laHoSoCanTraKQLienThong) { %>
				
					<label class="egov-label-bold" style="color: #0000FF;">
						Thông tin công dân nộp hồ sơ
					</label>
				
				<% } else { %>
					<% if (laChucNangRutHoSo) { %>
						
						<label class="egov-label-bold" style="color: #0000FF;">
							Thông tin người nhận hồ sơ
						</label>
						(là người nộp) <span id="laNguoiNopWrapper"><input id="laNguoiNop" type="checkbox"  class="egov-checkbox" checked="checked"/></span>
						
					<% } else { %>
						
						<label class="egov-label-bold" style="color: #0000FF;">
							<liferay-ui:message key="org.oep.form.lable.titlenguoinhan"/>
						</label>
						 (là người nộp) <span id="laNguoiNopWrapper"><input id="laNguoiNop" type="checkbox"  class="egov-checkbox" checked="checked"/></span>
						 		
					<% } %>
				<% } %>
				</td>
			</tr>
		
			<tr>
				<td colspan="3">
					
					<label class="egov-label-bold">
						Họ và tên
						<label class="egov-label-red">*</label>:
					</label>
					 <br /> 
					 <input type="text" name="nguoinhanketqua"	class="egov-inputfield" id="nguoinhanketqua" maxlength="49" value="<%= congDanNop.getHoTenDayDu() %>" />

				 </td>
				<td colspan="3"><label class="egov-label-bold">Email :</label>
					<br /> <input type="text" name="email" class="egov-inputfield"
					id="email" value="<%= congDanNop.getEmail() %>" maxlength="49" /></td>
			</tr>

			<tr>
				<td colspan="3"><label class="egov-label-bold"><liferay-ui:message key="org.oep.form.lable.ngaysinh"/><label class="egov-label-red">*</label>:
				</label> <br /> <input type="text" name="ngaysinh" class="egov-calendar"
					id="ngaysinh" value="<%= DateTimeUtil.getDayMonthYear(congDanNop.getNgaySinh()) %>" readonly="readonly" /></td>
				<td colspan="3"><label class="egov-label-bold"><liferay-ui:message key="org.oep.form.lable.dienthoaididong"/> :</label> <br /> <input type="text" name="dienthoaididong"
					class="egov-inputfield" id="dienthoaididong" maxlength="15" value="<%=congDanNop.getDienThoaiDiDong()%>" onkeypress="return isNumberKey(event)" /></td>
			</tr>
			<tr>
				<td colspan="2"><label class="egov-label-bold"><liferay-ui:message key="org.oep.form.lable.cmdn"/>:
				</label> <br /> <input type="text" name="cmnd" class="egov-inputfield"
					id="cmnd" value="<%= congDanNop.getSoCMND() %>" onkeypress="return isNumberKey(event)" maxlength="12"/></td>
				<td colspan="2"><label class="egov-label-bold"><liferay-ui:message key="org.oep.form.lable.gioitinh"/> <label class="egov-label-red">*</label>:
				</label> <br /> 
			    	  <select id="gioitinh" name="gioitinh" class="egov-select">
						<% for(GioiTinh item : listGioiTinh) { %>
							<option value="<%= item.getId() %>"
							<%= (item.getId() == congDanNop.getGioiTinhId()) ? StringPool.SELECTED : StringPool.BLANK %>
							>
								<c:out value="<%= item.getTen() %>"/>
							</option>
						<% } %>
					</select>
				</td>
				<td colspan="2"><label class="egov-label-bold"><liferay-ui:message key="org.oep.form.lable.dtcodinh"/> :</label> <br /> <input type="text" name="dienthoaicodinh"
					class="egov-inputfield" id="dienthoaicodinh" maxlength="15" value="<%= congDanNop.getDienThoaiCoDinh() %>" onkeypress="return isNumberKey(event)"/></td>
			</tr>

			<tr>
				<td colspan="6"><label class="egov-label-bold"><liferay-ui:message key="org.oep.form.lable.sonhaduongpho"/><label class="egov-label-red">*</label>:
				</label> <br /> <input type="text" name="diachi" class="egov-inputfield"
					id="diachi" value="<%= congDanNop.getDiaChiChiTiet() %>" /></td>
			</tr>
			<tr>
				<td colspan="2"><label class="egov-label-bold"><liferay-ui:message key="org.oep.form.lable.tinhtp"/> <label class="egov-label-red">*</label>:
				</label> <br /> <select id="tinhId1" name="tinhId" class="egov-select"
					style="display: block;">
						<option value="0"><liferay-ui:message key="org.oep.form.lable.chontinh"/></option>
						<%
							//long idTinh = 31;
						
			      		  /* if(tinhId !=null && tinhId.length()>0)
			      		   {
			      				idTinh = Long.parseLong(tinhId);
			      		   }
			      		 	*/
						List<DonViHanhChinh> list_tinh= DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();
															   
															    if(list_tinh!=null && list_tinh.size()>0){
															    	
															     for(int i=0;i<list_tinh.size();i++){ 
															    	 DonViHanhChinh donvihanhchinh=   list_tinh.get(i);
															    	 String selected = "";
															    	 if ( donvihanhchinh.getId() == congDanNop.getTinhDiaChiId(true)){
																			selected = "selected";
																		}				 
						%>

						<option value="<%=donvihanhchinh.getId()%>" <%=selected %>><%=donvihanhchinh.getTen()%></option>

						<%
							}
						} 
						%>
				</select></td>

				<td colspan="2"><label class="egov-label-bold"><liferay-ui:message key="org.oep.form.lable.quanhuyen"/>
						<label class="egov-label-red">*</label>:
				</label> <br /> <select id="huyenId" name="huyenId" class="egov-select" 
					style="display: block;">

							<option value="0"><liferay-ui:message key="org.oep.form.lable.chonHuyen"/></option>
						<%
                			 
                			List<DonViHanhChinh> list_huyen= DonViHanhChinhLocalServiceUtil.findByChaId(congDanNop.getTinhDiaChiId(true), 0);
                			
                			for (DonViHanhChinh quanHuyen: list_huyen) {
        						String selected = "";
        						if (quanHuyen.getId() == congDanNop.getHuyenDiaChiId(true)){
        							selected = "selected";
        						}
                			 
                			%>
							<option <%=selected %> value="<%=quanHuyen.getId()%>"><%=quanHuyen.getTen()%></option>
						<%}// end for
                			
                		 %>

				</select></td>

				<td colspan="2"><label class="egov-label-bold"><liferay-ui:message key="org.oep.form.lable.xa"/>
						: </label> <br /> 
						<select id="xaId" name="xaId" class="egov-select" style="display: block;">
							<option value="0"><liferay-ui:message key="org.oep.form.lable.chonXa"/></option>
							<%
								long huyenid = congDanNop.getHuyenDiaChiId(true);
				      		  	if (huyenid > 0) {
	                			List<DonViHanhChinh> list_xa = DonViHanhChinhLocalServiceUtil.findByChaId(huyenid, 0);
	                			for (DonViHanhChinh xaphuong: list_xa) {
	        						String selected = "";
	        						if (xaphuong.getId()== congDanNop.getXaDiaChiId(true)) {
	        							selected = "selected";
	        						}
	                			 
                			%>
							<option <%=selected %> value="<%=xaphuong.getId()%>"><%=xaphuong.getTen()%></option>
							
						<%}// end for
                			
                		} %>

				</select></td>
			</tr>
	
			<tr>
				<td colspan="6">
				<%
					if (laChucNangRutHoSo) {
				%>
					<label class="egov-label-bold" style="color: #0000FF;">
						Thông tin người trả hồ sơ:
					</label>
				<%
					} else {
				%>
					<label class="egov-label-bold" style="color: #0000FF;">
						<liferay-ui:message key="org.oep.form.lable.tile.nguoitra"/>:
					</label>
				<%
					}
				%>
				</td>
			</tr>

			<tr>
				<td colspan="2"><label class="egov-label-bold"><liferay-ui:message key="org.oep.form.lable.tennguoitra"/>  <label class="egov-label-red">*</label>:
				</label> <br /> <input type="text" name="nguoitra" class="egov-inputfield" maxlength="30"
					 id="nguoitra" readonly="readonly"
					value="<%=EgovUtil.getCongChucDaDangNhap(PortalUtil.getUserId(request)).getHoVaTen() %>" /></td>

				<td colspan="2"><label class="egov-label-bold"><liferay-ui:message key="org.oep.form.lable.ngaytra"/>: </label> <br /> <input type="text" name="ngaytra" class="egov-calendar"
					id="ngaytra" value="<%=traketqua.getNgayTraKQ() %>"
					readonly="readonly" /></td>

				<td colspan="2"><label class="egov-label-bold"><liferay-ui:message key="org.oep.form.lable.giotra"/>:</label>
					<br />
			      <input
					name="giotra"
					type="text"
					class="egov-inputfield egov-timepicker"
					value="<%= traketqua.getGioTra()%>"
					id="giotra"
					maxlength="20"
				/>
			     </td>	 
			</tr>
		<%
			if (!laChucNangRutHoSo) {
		%>
			<tr>
				<td colspan="6"><label class="egov-label-bold"
					style="color: #0000FF;"><liferay-ui:message key="org.oep.form.lable.thongtinkqxuly"/>:</label></td>
			</tr>
			<tr>
				<td colspan="3"><label class="egov-label-bold"><liferay-ui:message key="org.oep.form.lable.ketquaxuly"/></label></td>
				<td colspan="1"><label class="egov-label-bold"></label></td>
				<td colspan="2"><label class="egov-label-bold"><liferay-ui:message key="org.oep.form.lable.soban"/></label></td>
			</tr>
			<%
			    int i =1;
			    String check ="";
			    String indexCongVanStr =traketqua.getIndexCongVan(listGiaytoKq);
			    String [] strIndexArray = indexCongVanStr.split(",");
			    int indexCongVan = Integer.parseInt(strIndexArray[0]);
			    int indexGiayPhep =Integer.parseInt(strIndexArray[1]);
			    
			    if (indexGiayPhep >= listGiaytoKq.size() || indexGiayPhep >= listnNumber.size()) {
			    	indexGiayPhep = indexCongVan;
			    }
			    
			    if(listGiaytoKq != null)
			    {
			    	if(listGiaytoKq.size() >0)
			    	{
			    		for(int m=0;m<listGiaytoKq.size();m++)
			    		{
			    			if(statusKetQua.get(m).booleanValue() == false)
			    			{
			    				check ="";
			    			}
			    			else
			    			{
			    				check ="checked=\"true\"";
			    			}
			    			
			    			if(traketqua.getHoSo().getDungXuLy() == true)
			    			{
		    			 		%>
									<tr>
										<td colspan="3"><%=i %>. <%=listGiaytoKq.get(indexCongVan).getTen() %></td>
										<td>
										<input type="checkbox" class="egov-checkbox"
											value="<%=listGiaytoKq.get(indexCongVan).getId()%>"  name="checkGTKQ"
											style="width: 20px; height: 30px;"  checked="true" /></td>
										<td colspan="2"><input type="text" name="soban" onkeypress="return isNumberKey(event)" 
											value="<%=listnNumber.get(indexCongVan).intValue() %>" class="egov-inputfield" />
										</td>
									</tr>
								<%
				    		 }
			    			else
			    			{
			    				%>
								<tr>
									<td colspan="3"> <%=i %>. <%=listGiaytoKq.get(indexGiayPhep).getTen() %></td>
									<td>
									<div>
										<input type="hidden">
										<input type="checkbox"  class="egov-checkbox" value="<%=listGiaytoKq.get(indexGiayPhep).getId()%>"  name="checkGTKQ"
											style="width: 20px; height: 30px;" checked="checked" />
											</div>
										</td>										
									<td colspan="2">
									
									<input type="text" name="soban" onkeypress="return isNumberKey(event)" 
										value="<%=listnNumber.get(indexGiayPhep).intValue() %>" class="egov-inputfield" />
									</td>
								</tr>
							<%	
			    			}
			    			break; 
			    		}
			    	}
			    }	
			%>
			
			<%
			  int j=1;
			  String checkGTNop ="";
			  
			  if(listGiayToNop != null)
			  {
				  if(listGiayToNop.size() >0)
				  {
					  %>
					  	<tr>
							 <td colspan="6"><label class="egov-label-bold"><liferay-ui:message key="org.oep.form.lable.thanhphan"/></label></td>
					  	</tr>
					  <%
					  
					  for(int n =0;n< listGiayToNop.size();n++)
					  {
						  if(statusGiayToNop.get(n).booleanValue() == false)
			    			{
							  checkGTNop ="";
			    			}
						  else
						  {
							  checkGTNop ="checked=\"checked\"";
						  }
						  %>
						<tr>
							<td colspan="3"><%=j %>. <%=listGiayToNop.get(n).getTen() %></td>
							<td colspan="3"><input type="checkbox" <%=checkGTNop %>
								value="<%=listGiayToNop.get(n).getId()%>" name="checkGTNop"
								class="egov-checkbox" /></td>
						</tr>
						<% 
						j++;
					  }
				  }
			  } %>
			  
		<% if (traketqua.getHoSo().getDaDangKyChuyenPhatNhanh() == 1) { %>
		
			<tr>
				<td colspan="6">
					<label class="egov-label highlight" style="font-size:1.3em;">
						Hồ sơ này có đăng ký nhận kết quả bằng chuyển phát nhanh (EMS)
					</label>
				</td>
			</tr>
		
		<% } %>
			  
	<% } %>
			<tr>
				<td colspan="6" align="left" style="padding: 25px 0 15px;">
					<button type="submit" class="egov-button-normal" name="trahoso">Trả hồ sơ</button>
					<button 
						style="margin-left: 8px;" 
						type="button" 
						class="egov-button" 
						onclick="location.href='<%=urlQuayLaiThongTinChung%>'"
					>
						Quay lại
					</button>
			   </td>
			</tr>
		</table>
	</form>
</div>

<script type="text/javascript">
var tempHoTenNN = '<%=congDanNop.getHoTenDayDu()%>';
tempEmailNN = '<%=congDanNop.getEmail()%>';
tempNgaySinhNN = '<%=ConvertUtil.parseDateToTring(congDanNop.getNgaySinh())%>';
tempDienThoaiDDNN = '<%=congDanNop.getDienThoaiDiDong()%>';
tempDienThoaiCDNN = '<%=congDanNop.getDienThoaiCoDinh()%>';
tempCMNDNN = '<%=congDanNop.getSoCMND()%>';
tempGioiTinhIdNN = <%=congDanNop.getGioiTinhId()%>;
tempDiaChiNN = '<%=congDanNop.getDiaChiChiTiet()%>';
tempTinhIdNN = <%=congDanNop.getTinhDiaChiId(true)%>;
tempQuanIdNN = <%=congDanNop.getHuyenDiaChiId(true)%>;
tempXaIdNN = <%=congDanNop.getXaDiaChiId(true)%>;
	
function loadDefaultData(newData) {
	if (newData) {
		$('#nguoinhanketqua').val(tempHoTenNN);
		$('#email').val(tempEmailNN);
		$('#ngaysinh').val(tempNgaySinhNN);
		$('#dienthoaididong').val(tempDienThoaiDDNN);
		$('#dienthoaicodinh').val(tempDienThoaiCDNN);
		$('#cmnd').val(tempCMNDNN);
		$('#diachi').val(tempDiaChiNN);
		$('#gioitinh').val(tempGioiTinhIdNN);
		$('#tinhId1').val(tempTinhIdNN);
		$('#huyenId').val(tempQuanIdNN);
		$('#xaId').val(tempXaIdNN);
		
	} else {
		$('#nguoinhanketqua').val('');
		$('#email').val('');
		$('#ngaysinh').val('');
		$('#dienthoaididong').val('');
		$('#dienthoaicodinh').val('');
		$('#cmnd').val('');
		$('#diachi').val('');
		$('#gioitinh').val(1);
		$('#tinhId1').val(0);
		$('#huyenId').val(0);
		$('#xaId').val(0);
	}
}

//define trangthaihoso
hoSoStatus = <%=hosoTTHCC.getTrangThaiHoSo()%>;
statusDaTraKetQua = <%=Constants.HOSO_TTHC_CONG_TRANG_THAI_DA_TRA_KET_QUA%>;
statusDarut = <%=Constants.HOSO_TTHC_CONG_TRANG_THAI_HOSO_RUT_HS%>;
$(document).ready(function() {
	
	$('#addHoSoRequestForm').submit(function() {
		
		// Submit ca? cac truong` bi. disabled
		$(this).find(':input:disabled').prop('disabled', false);
	});
	
	if (<%= laHoSoCanTraKQLienThong %>) {
		$('#nguoinhanketqua').prop('disabled', true);
		$('#email').prop('disabled', true);
		$('#ngaysinh').prop('disabled', true);
		$('#dienthoaididong').prop('disabled', true);
		$('#dienthoaicodinh').prop('disabled', true);
		$('#cmnd').prop('disabled', true);
		$('#diachi').prop('disabled', true);
		$('#gioitinh').prop('disabled', true);
		$('#tinhId1').prop('disabled', true);
		$('#huyenId').prop('disabled', true);
		$('#xaId').prop('disabled', true);
	}
	
	$laNguoiNop = $('#laNguoiNop');

	loadDefaultData(true);
	
	// click on checkbox (la nguoi nop)
	$laNguoiNop.click(function() {
		loadDefaultData(this.checked);
	});
	
	// disable the text input if status = da tra ho so
	if (hoSoStatus == statusDaTraKetQua || hoSoStatus == statusDarut) {
		console.log("the sttus the same");
		$("input[type=text]").attr("disabled", "disabled");
		$("input[type=checkbox]").attr("disabled", "disabled");
		$("button[type=submit]").attr("disabled", "disabled");
		$("select").attr("disabled", "disabled");	
	}
	
	$("#tinhId1").change(function(){
	  	var url="<%=fetchValues%>";
	  	var parentId = $("#tinhId1").val();	  
	  	$("#huyenId").empty();
	  	$("#huyenId").append("<option value='0'>Ch&#7885;n Qu&#7853;n/Huy&#7879;n</option>");
	  	
	  	if (parentId != "") {	 
	  		 		 		 
			jQuery.getJSON(url+"&parentId=" + parentId, function(data)  {
				
			   	for(var i=0; i < data.donViHanhChinhArray.length; i++){
			   		donViHanhChinhArray = data.donViHanhChinhArray[i].split(":");
			    	$("#huyenId").append("<option value='"+ donViHanhChinhArray[0] +"'>"+donViHanhChinhArray[1]+"</option> " );
			   	}
				$("#huyenId").val(window.defaultHuyen).change();
	  		});
	  	}
 	});	 

	$("#huyenId").change(function(){
	  	var url="<%= fetchValues %>";
						var parentId = $("#huyenId").val();

											$("#xaId").empty();
											$("#xaId")
													.append(
															"<option value='0'>Ch&#7885;n x&atilde;</option>");

											if (parentId != "") {
												jQuery
														.getJSON(
																url
																		+ "&parentId="
																		+ parentId,
																function(data) {
																	for ( var i = 0; i < data.donViHanhChinhArray.length; i++) {
																		donViHanhChinhArray = data.donViHanhChinhArray[i]
																				.split(":");
																		$(
																				"#xaId")
																				.append(
																						"<option value='"+ donViHanhChinhArray[0] +"'>"
																								+ donViHanhChinhArray[1]
																								+ "</option> ");
																	}

																	$("#xaId")
																			.val(
																					window.defaultXa);
																});
											}

										});

					});

</script>
