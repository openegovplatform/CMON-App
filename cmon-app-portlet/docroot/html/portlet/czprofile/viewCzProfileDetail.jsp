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
<%@page import="org.oep.cmon.dao.cd.model.TonGiao"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.OutputStream"%>
<%@page import="org.oep.cmon.anhcongdan.service.AnhCongDanLocalServiceUtil"%>
<%@page import="org.oep.cmon.anhcongdan.model.AnhCongDan"%>
<%@page import="org.oep.cmon.czprofile.portlet.util.ConvertUtil"%>
<%@page import="com.liferay.portal.kernel.util.Base64"%>
<%@page import="com.liferay.portal.kernel.util.Validator" %>
<%@page import="org.oep.cmon.dao.cd.model.TrinhDoHocVan" %>
<%@page import="org.oep.cmon.dao.cd.service.TrinhDoHocVanLocalServiceUtil" %>
<%@page import="org.oep.cmon.dao.cd.model.TinhTrangHonNhan" %>
<%@page import="org.oep.cmon.dao.cd.service.TinhTrangHonNhanLocalServiceUtil" %>
<%@page import="org.oep.cmon.dao.qlhc.model.DonViHanhChinh" %>
<%@page import="org.oep.cmon.dao.cd.model.GioiTinh" %>
<%@page import="org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Map" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%
	TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(user.getUserId());
	
	CongDan congDan = CongDanLocalServiceUtil.findByTaiKhoanNguoiDungId(taiKhoanNguoiDung.getId());
	//CongDan congDan = CongDanLocalServiceUtil.findByTaiKhoanNguoiDungId(taiKhoanNguoiDung.getId());

%>
<html>
	<body>
		<%
		if (congDan != null) {

			PortletURL inputDetailUrl = renderResponse.createActionURL();
			inputDetailUrl.setParameter(ActionRequest.ACTION_NAME, "updateDetail");
			
			Long trinhDoHocVanId = null;
			Long tinhTrangHonNhanId = null;
			Long noiCapCmndId = null;
			int gioiTinhId = 0;
			String diaChiHienNay = null;
			String ngayHetHanHoChieu = null;
			String soBaoHiemYTe = null;
			// Get user request from session
			Map <String, String> userRequest = (Map <String, String>)renderRequest.getPortletSession().getAttribute("USER_REQUEST_OBJECT");
			if ( userRequest == null ) {
				userRequest = new HashMap<String, String>();
				trinhDoHocVanId = congDan.getTrinhDoHocVanId();
				tinhTrangHonNhanId = congDan.getTinhTrangHonNhanId();
				noiCapCmndId = congDan.getNoiCapCmndId();
				gioiTinhId = congDan.getGioiTinh();
				diaChiHienNay = congDan.getDiaChiHienNay();
				ngayHetHanHoChieu = ConvertUtil.parseDateToTring(congDan.getNgayHetHanHoChieu());
				soBaoHiemYTe = congDan.getSoBaoHiemYTe();
				renderRequest.getPortletSession().setAttribute("USER_REQUEST_OBJECT", userRequest);
			} else {
				//trinhDoHocVanId = userRequest.get("IDTRINHDOHOCVAN") == null ? congDan.getTrinhDoHocVanId() : Long.parseLong(userRequest.get("IDTRINHDOHOCVAN"));
				//tinhTrangHonNhanId = userRequest.get("IDTINHTRANGHONNHAN") ==  null ? congDan.getTinhTrangHonNhanId() : Long.parseLong(userRequest.get("IDTINHTRANGHONNHAN"));
				//noiCapCmndId = userRequest.get("IDNOICAPCMND") == null ? congDan.getNoiCapCmndId() : Long.parseLong(userRequest.get("IDNOICAPCMND"));
			//	gioiTinhId = userRequest.get("IDGIOITINH") == null ? congDan.getGioiTinh() : Integer.parseInt(userRequest.get("IDGIOITINH"));
			//	diaChiHienNay = userRequest.get("MOTADIACHIHIENTAI") == null ? congDan.getDiaChiHienNay() : userRequest.get("MOTADIACHIHIENTAI");
				//ngayHetHanHoChieu = userRequest.get("NGAYHETHANHOCHIEU") == null ? ConvertUtil.parseDateToTring(congDan.getNgayHetHanHoChieu()) : userRequest.get("NGAYHETHANHOCHIEU");
			//	soBaoHiemYTe = userRequest.get("SOBAOHIEMYTE") == null ? congDan.getSoBaoHiemYTe() : userRequest.get("SOBAOHIEMYTE");
				
			}
		%>
	<div class="egov-container">
		<form id="updateDetailForm" name="updateDetailForm" method="post" action="<%=inputDetailUrl%>">
		<table align="center" class="egov-table-form" width="100%">
			
			<tr>
				<td colspan="6" align = "left">
					<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.gioiTinh"  message = "org.oep.cmon.userreg.form.input.err.gioiTinh" />
					<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.tinhTrangHonNhan"  message = "org.oep.cmon.userreg.form.input.err.tinhTrangHonNhan" />
					<liferay-ui:success key="success" message="Thông tin đã được cập nhật" />
				</td>
			</tr>
			<tr>
				<td align="left" width="16.67%">
					<label class="egov-label-bold">
						Số định danh:
					</label>
				</td>
				<td align="left" width="16.67%">
					<label>
						<%=congDan.getMa() %>
					</label>
					<input id="id" name="id" type="hidden" value="<%=congDan.getId()%>"/>
				</td>
				<td width="10%">&nbsp;</td>
				<td width="23.34%"><label class="egov-label-bold">
						Họ và tên:
					</label></td>
				<td width="10%">&nbsp;</td>
				<td width="23.34%"><label class="egov-label-bold">
						Trình độ học vấn:
					</label></td>
			</tr>
			<tr>
				<td align="left">
					<label class="egov-label-bold">
						Ngày sinh:
					</label>
				</td>
				<td align="left">
					<label>
						<%=ConvertUtil.parseDateToTring(congDan.getNgaySinh()) %>
					</label>
				</td>
				<td width="10%">&nbsp;</td>
				<td width="23.34%">
					<input type="text" name="tenDaydu" id="tenDaydu" class="readonly egov-inputfield" disabled="disabled" style="width:92%" value="<%=congDan.getTenDayDu() %>"  />
				</td>
				<td width="10%">&nbsp;</td>
				<td width="23.34%">
					<%
						List <TrinhDoHocVan> trinhDoHocVanList = TrinhDoHocVanLocalServiceUtil.findAll();
					%>
					<select name="trinhDoHocVan" id="trinhDoHocVan" class = "egov-select custom" style="width:93%; display:block;">
						<%
							String selected = "";
							for ( TrinhDoHocVan trinhDoHocVan: trinhDoHocVanList) {
								if ( Validator.isNotNull(trinhDoHocVanId) && trinhDoHocVan.getId() == trinhDoHocVanId ) {
									selected = "selected";
								} else {
									selected = "";
								}
						%>
						<option value = "<%=trinhDoHocVan.getId()%>" <%=selected %>><%=trinhDoHocVan.getTen() %></option>
						<% } %>
					</select>
				</td>
			</tr>
			<tr>
				<td align="left">
					<label class="egov-label-bold">
						Điện thoại di động:
					</label>
				</td>
				<td align="left">
					<label>
						<%=congDan.getDienThoaiDiDong() %>
					</label>
				</td>
				<td width="10%">&nbsp;</td>
				<td width="23.34%"><label class="egov-label-bold">
						Điện thoại cố định:
					</label></td>
				<td width="10%">&nbsp;</td>
				<td width="23.34%"><label class="egov-label-bold">
						Trình độ chuyên môn:
					</label></td>
			</tr>
			<tr>
				<td align="left">
					<label class="egov-label-bold">
						Email:
					</label>
				</td>
				<td align="left">
					<label>
						<%=congDan.getEmail() %>
					</label>
				</td>
				<td width="10%">&nbsp;</td>
				<td width="23.34%">
					<input name="dtCoDinh" type="text" id="dtCoDinh"  maxlength="15" class = "readonly egov-inputfield" disabled="disabled" value = "<%=congDan.getDienThoaiCoDinh()%>" style = 'width:92%'/>
				</td>
				<td width="10%">&nbsp;</td>
				<td width="23.34%">
					<input type="text" name="trinhDoChuyenMon" id="trinhDoChuyenMon" class="readonly egov-inputfield" disabled="disabled" style="width:92%"
					 value="<%//=ConvertUtil.getTrinhDoChuyenMon(congDan.getTrinhDoChuyenMonId()).getTen() %>
					 "  />
				</td>
			</tr>
			<tr>
				<td align="left">
					<label class="egov-label-bold">
						Dân tộc:
					</label>
				</td>
				<td align="left">
					<label>
					
						<%=ConvertUtil.getDanToc(congDan.getDanTocId()).getTen() %>
						
					</label>
				</td>
				<td width="10%">&nbsp;</td>
				<td width="23.34%"><label class="egov-label-bold">Tình trạng hôn nhân:</label></td>
				<td width="10%">&nbsp;</td>
				<td width="23.34%"><label class="egov-label-bold">
						Nghề nghiệp:
					</label></td>
			</tr>
			<tr>
				<td align="left">
					<label class="egov-label-bold">
						Tôn giáo:
					</label>
				</td>
				<td align="left">
					<label>
						<%
							if (congDan.getTonGiaoId() != null){
								TonGiao tonGiaoo = ConvertUtil.getTonGiao(congDan.getTonGiaoId());
								if (tonGiaoo != null) {
						%>
									<%=tonGiaoo.getTen() %>
						
						<%
								}
							} 
						%>
					</label>
				</td>
				<td width="10%">&nbsp;</td>
				<td width="23.34%">
					<%
						List <TinhTrangHonNhan> tinhTrangHonNhanList = TinhTrangHonNhanLocalServiceUtil.getTinhTrangHonNhans(0, TinhTrangHonNhanLocalServiceUtil.getTinhTrangHonNhansCount());
					%>
					<select name="tinhTrangHonNhan" id="trinhTrangHonNhan" class = "egov-select custom" style="width:93%; display:block;">
					<%
						selected = "";
						for ( TinhTrangHonNhan tinhTrangHonNhan: tinhTrangHonNhanList) {
							if ( Validator.isNotNull(tinhTrangHonNhanId) && tinhTrangHonNhan.getId() == tinhTrangHonNhanId ) {
								selected = "selected";
							} else {
								selected = "";
							}
					%>
					<option value = "<%=tinhTrangHonNhan.getId()%>" <%=selected %>><%=tinhTrangHonNhan.getTen() %></option>
					<% } %>
					</select>
				</td>
				<td width="10%">&nbsp;</td>
				<td width="23.34%">
					<input name="ngheNghiep" type="text" id="ngheNghiep" maxlength="12" class = "readonly egov-inputfield" disabled="disabled" 
					value = "<%//=ConvertUtil.getNgheNghiep(congDan.getNgheNghiepId()).getTen()%>
					" style = 'width:92%'/>
				</td>
			</tr>
				<tr>
					<td align="left">
						<label class="egov-label-bold">
							Quốc tịch:
						</label>
					</td>
					<td align="left">
						<label>
						
							<%=ConvertUtil.getQuocGia(congDan.getQuocTichId()).getTen() %>
							
						</label>
					</td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%"><label class="egov-label-bold">
							Số CMND:
						</label></td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%"><label class="egov-label-bold">
							Nơi cấp CMND:
						</label></td>
				</tr>
				<tr>
					<td align="left">
						<label class="egov-label-bold">
							Số hộ khẩu:
						</label>
					</td>
					<td align="left">
						<label>
							<%=congDan.getSoHoKhau() %>
						</label>
					</td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%">
						<input name="soCmnd" type="text" id="soCmnd" maxlength="12" class = "readonly egov-inputfield" disabled="disabled" value = "<%=congDan.getSoCmnd()%>" style = 'width:92%'/>
					</td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%">
					<%
						List <DonViHanhChinh> tinhThanhList = DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();
					%>
					<select name="noiCapCmnd" id="noiCapCmnd" class = "egov-select custom" style="width:93%; display:block;">
					<%
						selected = "";
						for ( DonViHanhChinh tinhThanh: tinhThanhList) {
							if ( Validator.isNotNull(noiCapCmndId) && tinhThanh.getId() == noiCapCmndId ) {
								selected = "selected";
							} else {
								selected = "";
							}
					%>
						<option value = "<%=tinhThanh.getId()%>" <%=selected %>><%=tinhThanh.getTen() %></option>
						<% } %>
					</select>
					</td>
				</tr>
				<tr>
					<td align="left">
						<label class="egov-label-bold">
							Số hộ chiếu:
						</label>
					</td>
					<td align="left">
						<label>
							<%=congDan.getSoHoChieu() %>
						</label>
					</td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%"><label class="egov-label-bold">Ngày cấp CMND:
					</label></td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%"><label class="egov-label-bold">
							Ghi chú CMND:
						</label></td>
				</tr>
				<tr>
					<td align="left">
						<label class="egov-label-bold">
							Ngày cấp hộ chiếu:
						</label>
					</td>
					<td align="left">
						<label>
							<%=ConvertUtil.parseDateToTring(congDan.getNgayCapHoChieu()) %>
						</label>
					</td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%">
						<input name="ngayCapCmnd" type="text" id="ngayCapCmnd" maxlength="10" class = "egov-calendar readonly" disabled="disabled" value = "<%=ConvertUtil.parseDateToTring(congDan.getNgayCapCmnd())%>" style = 'width:92%'/>
					</td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%">
						<input name="ghiChuCmnd" type="text" id="ghiChuCmnd"  maxlength="150" class = "readonly egov-inputfield" disabled="disabled" value = "<%=congDan.getGhiChuCmnd()%>" style = 'width:92%'/>
					</td>
				</tr>
				<tr>
					<td align="left">
						<label class="egov-label-bold">
							Ghi chú hộ chiếu:
						</label>
					</td>
					<td align="left">
						<label>
							<%=congDan.getGhiChuHoChieu() %>
						</label>
					</td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%"><label class="egov-label-bold">
							Giới tính:
						</label></td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%"><label class="egov-label-bold">
							Mã số thuế cá nhân:
						</label></td>
				</tr>
				<tr>
					<td align="left" colspan="2">
						<label class="egov-label-bold">
							Nơi thường trú:
						</label>
						<label>
							<%=congDan.getDiaChiThuongTru() %>,<%=ConvertUtil.getDonViHanhChinh(congDan.getDiaChiThuongTruXaId()).getTen() %>,<%=ConvertUtil.getDonViHanhChinh(congDan.getDiaChiThuongTruHuyenId()).getTen() %>,<%=ConvertUtil.getDonViHanhChinh(congDan.getDiaChiThuongTruTinhId()).getTen() %>
						</label>
					</td>
					<%--
					<td align="left">
						<label>
							<%=congDan.getDiaChiThuongTru() %>,<%=ConvertUtil.getDonViHanhChinh(congDan.getDiaChiThuongTruXaId()).getTen() %>,<%=ConvertUtil.getDonViHanhChinh(congDan.getDiaChiThuongTruHuyenId()).getTen() %>,<%=ConvertUtil.getDonViHanhChinh(congDan.getDiaChiThuongTruTinhId()).getTen() %>
						</label>
					</td>
					--%>
					<td width="10%">&nbsp;</td>
					<td width="23.34%">
					<%
						List <GioiTinh> gioiTinhList = GioiTinhLocalServiceUtil.getDSGioiTinh();
					%>
						<select name="gioiTinh" id="gioiTinh" class = "egov-select custom" style="width:93%; display:block;">
						<%
							selected = "";
							for ( GioiTinh gioiTinh: gioiTinhList) {
								if ( Validator.isNotNull(gioiTinhId) && gioiTinh.getId() == gioiTinhId ) {
									selected = "selected";
								} else {
									selected = "";
								}
						%>
							<option value = "<%=gioiTinh.getId()%>" <%=selected %>><%=gioiTinh.getTen() %></option>
						<% } %>
						</select>
					</td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%">
						<input name="mstCaNhan" type="text" id="mstCaNhan" maxlength="15" class = "readonly egov-inputfield" disabled="disabled" value = "<%=congDan.getMaSoThueCaNhan()%>" style = 'width:92%'/>
					</td>
				</tr>
				<tr>
					<td align="left">
						<label class="egov-label-bold">
							Nơi ở hiện tại:
						</label>
					</td>
					<td width="16.67%">&nbsp;</td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%"><label class="egov-label-bold">
							Ngày hết hạn hộ chiếu:
						</label></td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%"><label class="egov-label-bold">Sổ BHYT:</label></td>
				</tr>
				<tr>
					<td align="left" colspan="2">
						<input name="motaDiachiHienTai" type="text" id="motaDiachiHienTai"  maxlength="100" class = "egov-inputfield custom" value = "<%=diaChiHienNay%>" style = 'width:92%'/>
					</td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%">
						<input name="ngayHetHanHoChieu" type="text" id="ngayHetHanHoChieu"  maxlength="10" class = "egov-calendar custom" value = "<%=ngayHetHanHoChieu %>" style = 'width:92%'/>
					</td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%">
						<input name="soBhyt" type="text" id="soBhyt"  maxlength="15" class = "egov-inputfield custom" value = "<%=soBaoHiemYTe%>" style = 'width:92%'/>
					</td>
				</tr>
				<tr>
					<td colspan="6">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" >
						<input type="submit" name="update" id="update" value="Cập nhật" class = "egov-button-normal"/>
						<a href="/group/guest">
							<input type="button" class = "egov-button-normal" name="back" id="back" value="Quay lại"/>
						</a>
					</td>
					<td width="10%">&nbsp;</td>
					<td width="23.34">&nbsp;</td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%">&nbsp;</td>
				</tr>
		</table>
		
		<%
			PortletURL redirectUrl= renderResponse.createRenderURL();
			redirectUrl.setParameter("jspPage","/html/portlet/czprofile/view.jsp");
		%>
		<input type="hidden" name=redirectUrl value="<%=redirectUrl%>"/>
		</form>
		<%
		} else {
			%>
			<font color="red" style="font-family: serif;">Bạn chưa có thông tin tài khoản công dân.</font>
			<%
		}
		%>
	</div>
	</body>
</html>
