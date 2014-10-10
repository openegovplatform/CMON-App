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
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="java.util.Arrays"%>
<%@page import="org.oep.cmon.dao.chungthuc.service.HoSoChungThucLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.oep.cmon.dao.chungthuc.model.HoSoChungThuc"%>
<%@page import="org.oep.cmon.dao.qlhc.model.impl.CoQuanQuanLyImpl"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.report.service.Lephi_tonghopLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.report.model.Lephi_tonghop"%>
<%@page import="org.oep.cmon.dao.report.service.Lephi_linhvucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.report.model.Lephi_linhvuc"%>
<%@page import="org.oep.cmon.report.portlet.util.ActionUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.report.service.Lephi_chitietLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.report.model.Lephi_chitiet"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setContentType("application/vnd.ms-word");
	response.setHeader("Content-Disposition", "attachment; filename=Baocaohosochungthuc.doc");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	String str_loaihoso = request.getParameter("id_loaihoso");
	String id_linhvuc = request.getParameter("id_linhvuc");
	String ngaynhan_tungay = request.getParameter("tungay");
	String ngaynhan_denngay = request.getParameter("denngay");
	String coQuanQuanLyId = request.getParameter("coQuanQuanLyId");
	List<HoSoChungThuc> hosochungthuc = new ArrayList<HoSoChungThuc>();
	hosochungthuc = ActionUtil.listhsct(str_loaihoso, ngaynhan_tungay, ngaynhan_denngay);
	CoQuanQuanLy coQuanQuanLy = new CoQuanQuanLyImpl();
	if(coQuanQuanLyId!=null && !coQuanQuanLyId.equals("0")){
		coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(Long.valueOf(coQuanQuanLyId));
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<table style="width: 113%;margin-left:-40px;">
	<tr>
		<td></td>
		<td style="font-size: 17px;width: 60%;text-align: center;font-weight: bold;">CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</td>
	</tr>
	<tr>
		<td style="font-size: 17px;text-align: center;font-weight: bold;"><u><%=coQuanQuanLy.getTen()%></u></td>
		<td style="font-size: 18.5px;text-align: center;font-weight: bold;"><u>Độc lập -Tự do - Hạnh phúc</u></td>
	</tr>
	<tr style="margin-top:40px">
		<td colspan="2" style="text-align: center">
		<strong>BÁO CÁO HỒ SƠ CHỨNG THỰC</strong>
		</td>
	</tr>
	<tr style="margin-top:10px">
		<td colspan="2" style="text-align: center">
		<i>Từ ngày <%=ngaynhan_tungay %> đến ngày <%=ngaynhan_denngay%></i>
		</td>
	</tr>
</table><br>
<br>
<table id="tablelich" border="1" style="border-collapse: collapse;width: 113%;margin-left:-40px;font-size: 16px;">
	<tr style="height:35px;font-weight: bold;">
		<th>TT</th>
		<th style="text-align: center;">Số CT</th>
		<th style="text-align: center;">Người nộp<br> hồ sơ</th>
		<th style="text-align: center;">Địa chỉ<br>Số điện thoại</th>
		<th style="text-align: center;">Nội dung<br>công việc</th>
		<th style="text-align: center;">Loại giấy tờ</th>
		<th style="text-align: center;">Số bộ</th>
		<th style="text-align: center;">Số trang</th>
		<th style="text-align: center;">Ngày nhận</th>
		<th style="text-align: center;">Ngày trả<br> kết quả</th>
		<th style="text-align: center;">Lệ phí</th>
		<th style="text-align: center;">Người thực hiện</th>
		<th style="text-align: center;">Người ký</th>
	</tr>
	<%
	int i=0;
	for(HoSoChungThuc hschungthuc : hosochungthuc) {
	%>
	<tr>
		<td style="text-align: center"><%=++i%></td>
		<td><%=hschungthuc.getSoChungThuc()!=null?hschungthuc.getSoChungThuc():""%></td>
		<td><%=hschungthuc.getHoTenNguoiNopHoSo()!=null?hschungthuc.getHoTenNguoiNopHoSo():""%></td>
		<td><%
			if(hschungthuc.getDiaChiThuongTruNguoiNop()!=null){				
			  out.write(hschungthuc.getDiaChiThuongTruNguoiNop());
			}
			if(hschungthuc.getSoDienThoaiDiDongNguoiNop()!=null){				
			  out.write("<br>ĐT: "+hschungthuc.getSoDienThoaiDiDongNguoiNop());
			}
		%>
		<td><%=hschungthuc.getTenChungThuc()!=null?hschungthuc.getTenChungThuc():""%></td>
		<td style="text-align: center"><%=hschungthuc.getThuTucHanhChinhId()!=null?ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(hschungthuc.getThuTucHanhChinhId()).getTen():""%></td>
		<td style="text-align: center;"><%=hschungthuc.getSoBoHoSo()%></td>
		<td style="text-align: center;"><%=hschungthuc.getSoTo()%></td>
		<td><%=hschungthuc.getNgayNopHoSo()!=null?df.format(hschungthuc.getNgayNopHoSo()):""%></td>
		<td><%=hschungthuc.getNgayTraKetQua()!=null?df.format(hschungthuc.getNgayTraKetQua()):""%></td>
		<td style="text-align: right;"><%=hschungthuc.getLePhi()%></td>
		<td><%=hschungthuc.getCanBoTiepNhanId()!=null?CongChucLocalServiceUtil.fetchCongChuc(hschungthuc.getCanBoTiepNhanId()).getHoVaTen():""%></td>
		<td><%=hschungthuc.getTenCanBoKy()!=null?hschungthuc.getTenCanBoKy():""%></td>
	</tr>
	<%}%>
</table>
</body>
</html>

