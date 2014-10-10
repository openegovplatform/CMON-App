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
<%@page import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.tlct.model.TaiLieuChungThuc"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.FileDinhKem"%>
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/html/portlet/ipmslistportlet/offline/init.jsp" %>
<%
String maSoHoSo = "";
if (renderRequest.getParameter("maSoHoSo") != null) {
	maSoHoSo = renderRequest.getParameter("maSoHoSo");
}

String statusHS = "";
if (renderRequest.getParameter("statusHS") != null) {
	statusHS = renderRequest.getParameter("statusHS");
}

String cqqlId = "";
if (renderRequest.getParameter("cqqlId") != null) {
	cqqlId = renderRequest.getParameter("cqqlId");
}
String idQuyTrinh = "";
if (renderRequest.getParameter("idQuyTrinh") != null) {
	idQuyTrinh = renderRequest.getParameter("idQuyTrinh");
}
String idCongDan = "";
if (renderRequest.getParameter("idCongDan") != null) {
	idCongDan = renderRequest.getParameter("idCongDan");
}

String HosotthcCongId = "";
if (renderRequest.getParameter("HosotthcCongId") != null) {
	HosotthcCongId = renderRequest.getParameter("HosotthcCongId");
}
HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(ConvertUtil.convertToLong(HosotthcCongId));
hoSoTTHCCong.setDaGuiGiayHen(1);
HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(hoSoTTHCCong);
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
	</head>
	<body>
		<table style="width: 100%;">
			<tr>
				<td width="25%" colspan="2" align="right">
					<p>
						<b><%=ConvertUtil.getTenCoQuanQuanLy(ConvertUtil.convertToLong(cqqlId)) %></b>
					</p>
				</td>
				<td width="27%">
				</td>
				<td width="48%" align="center">
					<p><b>CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</b></p>
					<p><b>Độc lập - Tự do - Hạnh phúc</b></p>
					<p>Đà nẵng, ngày <%=(new SimpleDateFormat("dd")).format(new Date()) %>, tháng <%=(new SimpleDateFormat("MM")).format(new Date()) %>, năm <%=(new SimpleDateFormat("yyyy")).format(new Date()) %></p>
				</td>
			</tr>
			<tr>
				<td colspan="5"></td>
			</tr>
			<tr>
				<td colspan="5" align="center">
					<p><b>GIẤY BIÊN NHẬN HỒ SƠ</b></p>
					<p><b>Số hồ sơ: <%=maSoHoSo %></b></p>
				</td>
			</tr>
			<tr>
				<td colspan="5"></td>
			</tr>
			<tr>
				<td width="10%"></td>
				<td colspan="3" width="70%">Họ và tên: <%=ConvertUtil.getTenCanBo(hoSoTTHCCong.getCanBoTiepNhanId()) %></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="10%"></td>
				<td colspan="3" width="70%">Chức vụ: <%=hoSoTTHCCong.getChucVuCanBoTiepNhan() %></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="10%"></td>
				<td colspan="3" width="70%">Đã tiếp nhận hồ sơ của ông(bà): <%=hoSoTTHCCong.getHoTenNguoiNopHoSo() %></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="10%"></td>
				<td colspan="3" width="70%">Thường trú tại: <%=hoSoTTHCCong.getDiaChiThuongTruNguoiNop() %></td>
				<td width="20%"></td>
			</tr>
			<%
			if (hoSoTTHCCong.getSoDienThoaiCoDinhNguoiNop() != null && hoSoTTHCCong.getSoDienThoaiCoDinhNguoiNop().length() > 0) {
				%>
				<tr>
					<td width="10%"></td>
					<td colspan="3" width="70%">Số điện thoại: <%=hoSoTTHCCong.getSoDienThoaiCoDinhNguoiNop() %></td>
					<td width="20%"></td>
				</tr>
				<%
			} else {
				%>
				<tr>
					<td width="10%"></td>
					<td colspan="3" width="70%">Số điện thoại:</td>
					<td width="20%"></td>
				</tr>
				<%
			}
			%>
			<tr>
				<td width="10%"></td>
				<td colspan="3" width="70%">Tên thủ tục tiếp nhận: <%=hoSoTTHCCong.getTenThuTucHanhChinh() %></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="10%"></td>
				<td colspan="3" width="70%">
					<table>
						<tr style="display: inherit;" id="_tr">
							<td>Hồ sơ gồm có:</td>
							<td></td>
							<td></td>
						</tr>
						<%
						StringBuilder idFileImage = new StringBuilder();
						List<FileDinhKem> lFileUploads = FileDinhKemLocalServiceUtil.findByHoSoTTHCCongID(hoSoTTHCCong.getId());
						TaiLieuChungThuc taiLieuChungThuc = null;
						int i = 1;
						for (FileDinhKem fileUpload : lFileUploads) {
							taiLieuChungThuc = ConvertUtil.getTaiLieuChungThucFromNoiLuuTruTaiLieuId(fileUpload);
							if (taiLieuChungThuc != null) {
								if (idFileImage.length() == 0) {
									idFileImage.append(ConvertUtil.getURLFromNoiLuuTruId(taiLieuChungThuc.getNoiLuuTruId()) + "_image");
								} else {
									idFileImage.append(",").append(ConvertUtil.getURLFromNoiLuuTruId(taiLieuChungThuc.getNoiLuuTruId()) + "_image");
								}
								%>
								<tr style="display: inherit;" id="<%=fileUpload.getNoiLuuTruTaiLieuId() %>_tr">
									<td align="right"><%=i++ %>.&nbsp;</td>
									<td align="left">
										<a href="<%=ConvertUtil.getURLFromNoiLuuTruId(taiLieuChungThuc.getNoiLuuTruId()) %>" style="color:black;"><%=taiLieuChungThuc.getTen() %></a>
									</td>
									<td></td>
								</tr>
								<%
							}
						}
						%>
						
					</table>
				</td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="10%"></td>
				<td colspan="3" width="70%">Ngày nhận: <%=ConvertUtil.parseDateToTring(hoSoTTHCCong.getNgayNhanHoSo()) %></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="10%"></td>
				<td colspan="3" width="70%">Ngày trả kết quả: <%=ConvertUtil.parseDateToTring(hoSoTTHCCong.getNgayHenTraKetQua()) %></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="10%"></td>
				<td colspan="3" width="70%">Để xem tiến độ giải quyết hồ sơ, hiệu chỉnh hồ sơ quý khách vào <a href="dichvucong.dsp.vn">http://dichvucong.dsp.vn</a> </td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="10%"></td>
				<td colspan="3" width="70%">
					<table width="100%">
						<tr>
							<td width="50%">
								<p><b>Nơi nhận:</b></p>
								<p></p>
								<p></p>
								<p>Lưu:</p>
							</td>
							<td width="50%" align="center">
								<p><b>NGƯỜI TIẾP NHẬN</b></p>
								<p>(Ký và ghi rõ họ tên)</p>
								<p></p>
							</td>
						</tr>
					</table>
				</td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="10%"></td>
				<td colspan="3" width="70%">
				</td>
				<td width="20%"><br></td>
			</tr>
			<tr>
				<td width="10%"></td>
				<td colspan="3" width="70%">
					<input id="button_printer" type = "button" style="height: 35px;padding:10px;display: inherit;" class = "egov-button" onclick="javascript:beforePrint();" value="In giấy" />
				</td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td colspan="5"><br></td>
			</tr>
		</table>
	</body>
</html>

<script type="text/javascript">
function beforePrint() {
	var _tenTaiLieu = '<%=idFileImage.toString()%>'.split(",");
	document.getElementById('button_printer').style.display = 'none';
	window.print();
}
</script>