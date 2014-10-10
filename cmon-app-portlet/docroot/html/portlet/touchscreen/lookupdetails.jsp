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
<%@page import="java.text.DecimalFormat"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.impl.TrangThaiHoSoImpl"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.impl.NhomThuTucHanhChinhImpl"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.impl.HoSoTTHCCongImpl"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
DecimalFormat myFormatter = new DecimalFormat("###,###.###");
HoSoTTHCCong hoso = new HoSoTTHCCongImpl();
NhomThuTucHanhChinh nhomTTHC = new NhomThuTucHanhChinhImpl();
TrangThaiHoSo trangthaiHoSo = new TrangThaiHoSoImpl();
if(Validator.isNotNull(request.getAttribute("hoso"))){
	hoso = (HoSoTTHCCong) request.getAttribute("hoso");
	ThuTucHanhChinh tthc = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(hoso.getThuTucHanhChinhId());
	nhomTTHC = NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(tthc.getNhomThuTucHanhChinhId());
	trangthaiHoSo = TrangThaiHoSoLocalServiceUtil.getTrangThaiHoSo(hoso.getTrangThaiHoSo());
}
String masohs = request.getParameter("masohs")!=null?request.getParameter("masohs"):"";
PortletURL backurl = renderResponse.createRenderURL();
backurl.setParameter("jspPage","/html/portlet/touchscreen/view.jsp");
backurl.setParameter("viewPage","/html/portlet/touchscreen/lookup.jsp");
backurl.setParameter("masohs",masohs);
%>
<div class="content-block">
	<div class="header-block">
			<div class="title-header">
				<h4>
					<span>TRA CỨU TRẠNG THÁI HỒ SƠ ĐÃ NỘP</span>
				</h4>
			</div>
			<%-- <div class="breadcrumb-title-1 last">
				<h4>
					<span><%=trangthaiHoSo.getTrangThai()%></span>
				</h4>
			</div> --%>
	</div>
	<!--/header-block-->
	<%if(Validator.isNotNull(hoso.getId())){%>
	<div class="detailgroup-block">
		<div class="detail-col result result-first">
			<div>
				<table class="result-table">
					<tr>
						<td class="bold color"><p>Lĩnh vực</p></td>
						<td class="color">
							<p><%=nhomTTHC.getTen()%></p>
						</td>
					</tr>
					<tr>
						<td class="bold color"><p>Loại hồ sơ</p></td>
						<td class="color"><p><%=hoso.getTenThuTucHanhChinh()%></p></td>
					</tr>
					<tr>
						<td class="bold color"><p>Phí</p></td>
						<td class="color"><p><%=Validator.isNotNull(hoso.getPhiHoSo())?myFormatter.format(hoso.getPhiHoSo())+" đồng":""%></p></td>
					</tr>
					<tr>
						<td class="bold color"><p>Mã số biên nhận</p></td>
						<td class="bold red"><p><%=hoso.getMaSoBienNhan()%></p></td>
					</tr>
					<tr>
						<td class="bold color"><p>Người nộp hồ sơ</p></td>
						<td class="color uppercase bold"><p><%=hoso.getHoTenNguoiNopHoSo()%></p></td>
					</tr>
					<tr>
						<td class="bold color"><p>Email</p></td>
						<td class="color"><p><%=hoso.getEmailNguoiNop()!=null?hoso.getEmailNguoiNop():""%></p>
					</tr>
					<tr>
						<td class="bold color"><p>Địa chỉ</p></td>
						<td class="color"><p><%=hoso.getDiaChiThuongTruNguoiNop()%></p></td>
					</tr>
					<tr>
						<td class="bold color"><p>Ngày tiếp nhận</p></td>
						<td class="color"><p><%=hoso.getNgayNhanHoSo()!=null?df.format(hoso.getNgayNhanHoSo()):""%></p></td>
					</tr>
					<tr>
						<td class="bold color"><p>Ngày xử lý xong</p></td>
						<td class="color"><p><%=hoso.getNgayKetThucXuLy()!=null?df.format(hoso.getNgayKetThucXuLy()):""%></p></td>
					</tr>
					<tr>
						<td class="bold color"><p>Trạng thái hồ sơ</p></td>
						<td class="red"><p><%=trangthaiHoSo.getTrangThai()%>
						<%
							if(hoso.getTenPhongBanXuLyHienThoi()!=null && !hoso.getTenPhongBanXuLyHienThoi().equals("")){
								out.print(" tại "+hoso.getTenPhongBanXuLyHienThoi());
							}
						%>
						</p></td>
					</tr>
				</table>
			</div>
		</div>
		<!--/result-first-->
		<div class="detail-col result result-last">
			<div>
				<table class="result-table">
					<tr>
						<td class="bold color"><p>Nộp tại</p></td>
						<td class="bold red"><p><%=hoso.getTenCoQuanTiepNhan()%></p></td>
					</tr>
					<tr>
						<td class="bold color space"><p>Cách nộp</p></td>
						<td class="<%=hoso.getLoaiHoSo()==0?"green":"orange"%> space"><p><%=hoso.getLoaiHoSo()==0?"Trực tuyến":"Trực tiếp"%></p></td>
					</tr>
					<tr>
						<td class="bold color space"><p>Lệ phí</p></td>
						<td class="color space"><p><%=Validator.isNotNull(hoso.getLePhi())?myFormatter.format(hoso.getLePhi())+" đồng":""%></p>
					</tr>
					<tr>
						<td class="bold color"><p>Chủ hồ sơ</p></td>
						<td class="color uppercase bold"><p><%=hoso.getChuSoHuu()%></p></td>
					</tr>
					<tr>
						<td class="bold color space"><p>Điện thoại</p></td>
						<td class="color bold space "><p><%=hoso.getDienThoiCoDinhNguoiNhan()%></p></td>
					</tr>
					<tr>
						<td class="bold color"><p>Ngày trả hẹn</p></td>
						<td class="color"><p><%=hoso.getNgayHenTraKetQua()!=null?df.format(hoso.getNgayHenTraKetQua()):""%></p></td>
					</tr>
					<tr>
						<td class="bold color space"><p>Ngày trả kết quả</p></td>
						<td class="red space"><p><%=hoso.getNgayTraKetQua()!=null?df.format(hoso.getNgayTraKetQua()):""%></p></td>
					</tr>
				</table>
			</div>
		</div>
		<!--/result-last-->
	</div>
	<!--/detailgroup-block-->
	<%}else{%>
	<center><h1 style="color: #fff"><%=Validator.isNull(hoso.getId())?"Không có hồ sơ chứa mã số biên nhận "+masohs+" trong hệ thống !<br> Vui lòng kiểm tra lại mã số biên nhận. <br> Xin cảm ơn !":""%></h1></center>
	<%}%>
	<div class="back-button">
		<a href="<%=backurl%>">Trở lại</a>
	</div>

</div>
<!--/content-block-->