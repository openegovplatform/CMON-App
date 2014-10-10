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
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.YKienTraoDoi"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@ include file="/html/portlet/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.oep.cmon.Constants"%>
<%
	
	//get Vai tro can bo lanhdao/nhanvien
	String cb = Constants.CanBoXuLy.PROCESSING_CAN_BO_PREF_PARAM;
	String statuscb = portletPreferences.getValue(cb, ""); 
	String idHoSo = request.getParameter("hoSoTTHCCongId");
	String coQuanTiepNhanId =  request.getParameter("coQuanTiepNhanId");	
	String nguoiGuiId =  request.getParameter("nguoiGuiId");	
	
	long yKienTraoDoiId = ParamUtil.getLong(request, "yKienTraoDoiId");
	if (yKienTraoDoiId == 0 ){
		yKienTraoDoiId = ConvertUtil.convertToLong( request.getParameter("yKienTraoDoiId"));

	}
	
	String yktdId =  request.getParameter("yKienTraoDoiId");
	
	String urlQuaylaiChiTiet = request.getParameter("quayLai");	
	String urlQuaylaiDanhSach = request.getParameter("guiYkien");	
	
	YKienTraoDoi yKienTraoDoi = YKienTraoDoiLocalServiceUtil.fetchYKienTraoDoi(yKienTraoDoiId);
	
	long userId = PortalUtil.getUserId(request);
	TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(userId);
	
	CongDan congDan = CongDanLocalServiceUtil.findByTaiKhoanNguoiDungId(taiKhoanNguoiDung.getTaiKhoanNguoiDungId());
	
	String type = request.getParameter("type");	
	
	String quayLaiLink = null;
	
	if (urlQuaylaiChiTiet == null){
		quayLaiLink =urlQuaylaiDanhSach;
	} else {
		quayLaiLink =urlQuaylaiChiTiet;
	}
	
	if (quayLaiLink == null){
		quayLaiLink = request.getParameter("quayLaiLink");
	}
		
	PortletURL backUrl = renderResponse.createRenderURL();
	backUrl.setParameter("jspPage",	 String.valueOf(quayLaiLink));
    backUrl.setParameter("idHoSo", String.valueOf(idHoSo));
    backUrl.setParameter("type", String.valueOf(type));
	backUrl.setParameter("hoSoTTHCCongId", String.valueOf(idHoSo));
	backUrl.setParameter("yKienTraoDoiId", String.valueOf(yktdId));
	
	String loaiCanBo = request.getParameter("loaiCanBo");
    
    HoSoTTHCCong idHoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(FormatUtil.convertToLong(idHoSo));
    
%>
<head>
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/customEgovTheme.css"
	type="text/css" media="screen" />
</head>
<portlet:actionURL var="saveTraoDoiCanBo" name="saveTraoDoiCanBo">
	</portlet:actionURL>
	<div class="egov-container">

		<form action="<%=saveTraoDoiCanBo%>" name="mnyForm" id="myForm" method="POST">
			<table  cellspacing="0" cellpadding="0" class="egov-table-form" >   
				<tr>
					<td >
						<input type="hidden" value="<%= idHoSo %>" name="hoSoTTHCCongId" id="hoSoTTHCCongId" />
						<input type="hidden" value="<%= taiKhoanNguoiDung.getId() %>" name="nguoiGuiId" id="nguoiGuiId" />
						<input type="hidden" value="<%= coQuanTiepNhanId %>" name="coQuanTiepNhanId" id="coQuanTiepNhanId" />
						<input type="hidden" value="<%= yKienTraoDoiId %>" name="chaId" id="chaId" />
						<input type="hidden" value="<%= type %>" name="type" id="type" />
						<input type="hidden" value="<%= loaiCanBo %>" name="loaiCanBo" id="loaiCanBo" />
						<input type="hidden" value="<%= quayLaiLink %>" name="quayLaiLink" id="quayLaiLink" />
					</td>

				</tr>
				<tr>
					<td colspan="2">
						<select style="display: none;"	id="egov-form-errors" >
							<option value="tieuDe">
								<liferay-ui:error key="err.tieuDe"  message="Tiêu đề không được để trống" />
							</option>
							
							<option value="noiDung">
								<liferay-ui:error key="err.noiDung"  message="Nội dung không được để trống" />
							</option>
							
							<option value="nguoiNhanId">
								<liferay-ui:error key="err.nguoiNhanId"  message="Bạn phải chọn người nhận" />
								<br/>
								<liferay-ui:error key="err.canBoXuLyHienThoiId"  message="Không có cán bộ xử lý hồ sơ" />
								<br/>
								<liferay-ui:error key="err.congDanNopId"  message="Không có công dân nộp hồ sơ " />
							</option>
							
														
						</select>
					</td>
				</tr>
				
				
				<tr>
	     			<td colspan="3">
						<label class="egov-label-header">
						Gửi ý kiến trao đổi
						</label>	     				
	     				
	     				</td>
				</tr>
				<tr>
	     			<td colspan="3">
						<label  class="egov-label-header" >
						
						</label>	     				
	     				
	     				</td>
					<td colspan="3">
					</td>
				</tr>
				
				<%
					if (type.equals(Constants.CAN_BO)) {
						if (loaiCanBo != null && loaiCanBo.matches(Constants.LOAI_CAN_BO.LOAI_MOT_CUA)) {
				%>
				
				<tr>
					<td  colspan="3">
						<label class="egov-label-bold">Người nhận:</label><label
							class="egov-label-red">*</label><br />
							
							<%
								long nguoiNhanId = ParamUtil.getLong(request, "nguoiNhanId");
								String selected1 = null;
								String selected2 = null;
								if (nguoiNhanId >0){
									if (nguoiNhanId ==Constants.CONG_DAN_NOP_HS){
										selected1 = "selected='selected'";
									}
									if (nguoiNhanId== Constants.CAN_BO_XU_LY_HS){
										selected2 = "selected='selected'";
									}
								}
								
							%>
							
						<select class="egov-select" name="nguoiNhanId" id="nguoiNhanId" style="width: 50%;" >
							 <option value="0">--Chọn người nhận--</option>
							 <option value="<%=Constants.CONG_DAN_NOP_HS %>" <%= selected1%>> Công dân nộp hồ sơ </option>
							 <%
							 	if (idHoSoTTHCCong != null) {
							 		if (idHoSoTTHCCong.getTrangThaiHoSo() >0){
							 %>
							 <option value="<%=Constants.CAN_BO_XU_LY_HS %>" <%= selected2%>> Cán bộ xử lý hồ sơ </option>	
							 
							 <%
							 		}
							 	}
							 %>		
						</select>
					</td>
				</tr>
				
				<% 
						}
					}
				%>
				
				<%
					String tieuDe = FormatUtil.getValueString(request, "tieuDe");
					if (Validator.isNull(tieuDe) && yKienTraoDoi != null) {
						tieuDe = yKienTraoDoi.getTieuDe();
					}
				%>
				<tr>
						<td colspan="6"><label class="egov-label-bold">Tiêu đề:	</label> <label
							class="egov-label-red">*</label><br /> 
							<input  name="tieuDe" type="text" id="tieuDe"  class="egov-inputfield" maxlength="255"
								value="<%=ParamUtil.getString(request, "tieuDe").trim() %>" style="width: 55%;" />
						</td>
				</tr>	
				
				<%
					String noiDung = FormatUtil.getValueString(request, "noiDung");
					if (Validator.isNull(tieuDe) && yKienTraoDoi != null) {
						noiDung = yKienTraoDoi.getNoiDungYKien();
					}
				%>
				<tr>
						<td colspan="6">
							<label class="egov-label-bold">Nội dung:</label> <label
							class="egov-label-red">*</label><br>
							<textarea id="noiDung" class="egov-textarea" name="noiDung"   cols="20" rows="7" style="width: 75%;"><%= ParamUtil.getString(request, "noiDung").trim()%></textarea>
						</td>
						
				</tr>	
				<tr>
					<td colspan="2" align="left">
							
							<input type="submit" class="egov-button" name="traodoi"  id="traodoi" 
								value="Gửi" 	/>	
							
				<a	href="<%=backUrl.toString()%>" ><input type="button" class="egov-button" name="cancel"  id="cancel" 
					value="Quay lại" 	/>	</a>			
							
					</td>	
							
				</tr>
			</table>
			
		</form>
	</div>



