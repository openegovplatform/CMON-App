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
<%@page import="org.oep.cmon.dao.report.service.ReportTongHopChiTietLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.report.model.ReportTongHopChiTiet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="org.oep.cmon.dao.report.model.ReportTongHop"%>
<%@page import="org.oep.cmon.dao.report.service.ReportThongKeLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.report.model.ReportThongKe"%>
<%@page import="org.oep.cmon.dao.qlhc.model.impl.CoQuanQuanLyImpl"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.report.portlet.util.ActionUtil"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setContentType("application/vnd.ms-word");
	response.setHeader("Content-Disposition", "attachment; filename=Baocaotonghop.doc");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	
	String report_type = request.getParameter("report_type");
	String thang = request.getParameter("thang");
	String nam = request.getParameter("nam");
	String id_donvi = request.getParameter("id_donvi");
	String id_linhvuc = request.getParameter("id_linhvuc");
	String id_loaihoso = request.getParameter("id_loaihoso");
	String coQuanQuanLyId = request.getParameter("id_coquanquanly");
	//List<ReportThongKe> listthongke = ReportThongKeLocalServiceUtil.getListReportThongKeGroupByIDCoQuan(id_donvi, thang, nam);
	CoQuanQuanLy coQuanQuanLy = new CoQuanQuanLyImpl();
	if(coQuanQuanLyId!=null && !coQuanQuanLyId.equals("0")){
		coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(Long.valueOf(coQuanQuanLyId));
	}
	List<ReportTongHop> listTongHop = new ArrayList<ReportTongHop>();
	List<ReportTongHopChiTiet> listTongHopChiTiet = new ArrayList<ReportTongHopChiTiet>();
	Set<Long> setIDNhomThuTuc = new HashSet<Long>(0);
	if (report_type.equals("tongquat")) {
		if (!id_linhvuc.equals("")) {
			listTongHop = ActionUtil.getListReportTongHopGroupByIDNhomThuTuc(id_donvi, id_linhvuc,thang, nam);
		}
	}
	if (report_type.equals("nam")) {
		if (!id_linhvuc.equals("")) {
			listTongHop = ActionUtil.getListReportTongHop(
					String.valueOf(id_donvi), id_linhvuc, nam);
			for (int i = 0; i < listTongHop.size(); i++) {
				setIDNhomThuTuc.add(listTongHop.get(i)
						.getNHOMTHUTUCHANHCHINHID());
			}
		}
	}
	if (report_type.equals("chitiet")) {
		if (!id_loaihoso.equals("")) {
			listTongHopChiTiet = ReportTongHopChiTietLocalServiceUtil.getListReportTongHopChiTietGroupByIDThuTuc(String.valueOf(id_donvi), id_loaihoso,thang, nam);
			for (int i = 0; i < listTongHopChiTiet.size(); i++) {
				setIDNhomThuTuc.add(listTongHopChiTiet.get(i)
						.getNHOMTHUTUCHANHCHINHID());
			}
		} 
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
		<strong>BÁO CÁO THỐNG KÊ</strong>
		</td>
	</tr>
</table><br>
<br>
<%if(report_type.equals("tongquat")){
		if(listTongHop.size()!=0){
	%>
	<table id="tablelich" border="1" style="border-collapse: collapse;width: 113%;margin-left:-40px;font-size: 16px;">
		<thead>
			<tr>
				<th rowspan="2">STT</th>
				<th rowspan="2">Nhóm thủ tục hành chính</th>
				<th rowspan="2">Tổng</th>
				<th rowspan="2">Tiếp nhận</th>
				<th rowspan="2">Kỳ trước chuyển qua</th>
				<th colspan="4">Hồ sơ đã giải quyết</th>
				<th colspan="3">Hồ sơ đang giải quyết</th>
				<th rowspan="2">CD rút hồ sơ</th>
				<th rowspan="2">Hồ sơ trả lại</th>
				<th rowspan="2">Ghi chú</th>
			</tr>
			<tr>
				<th>Số hồ sơ</th>
				<th>Sớm</th>
				<th>Đúng</th>
				<th>Trễ</th>
				<th>Số hồ sơ</th>
				<th>Chưa đến hạn</th>
				<th>Đã quá hạn</th>
			</tr>
		</thead>
		<tbody>
			<%
				long tongnhan = 0;
				long tiepnhan = 0;
				long tondau = 0;
				long dagiaiquyet = 0;
				long som = 0;
				long dung = 0;
				long tre = 0;
				long danggiaiquyet = 0;
				long chuadenhan = 0;
				long quahan = 0;
				long ruthoso = 0;
				long khonghople = 0;
				long toncuoi = 0;
				for(int i=0;i<listTongHop.size();i++){
					ReportTongHop report = listTongHop.get(i);
					tongnhan += report.getTONGNHAN();
					tiepnhan += report.getTIEPNHAN();
					tondau += report.getTONDAU();
					dagiaiquyet += report.getTONGDAGIAIQUYET();
					som += report.getSOM();
					dung += report.getDUNG();
					tre += report.getTRE();
					danggiaiquyet += report.getTONGDANGGIAIQUYET();
					chuadenhan += report.getCHUADENHAN();
					quahan += report.getQUAHAN();
					ruthoso += report.getRUTHOSO();
					khonghople += report.getKHONGHOPLE();
					toncuoi += report.getTONCUOI();
			%>
			<tr>
				<td style="text-align: center !important"><%=i+1 %></td>
				<td><%=NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(report.getNHOMTHUTUCHANHCHINHID()).getTen()  %></td>
				<td style="text-align: center !important"><%=report.getTONGNHAN() %></td>
				<td style="text-align: center !important"><%=report.getTIEPNHAN() %></td>
				<td style="text-align: center !important"><%=report.getTONDAU() %></td>
				<td style="text-align: center !important"><%=report.getTONGDAGIAIQUYET() %></td>
				<td style="text-align: center !important"><%=report.getSOM() %></td>
				<td style="text-align: center !important"><%=report.getDUNG() %></td>
				<td style="text-align: center !important"><%=report.getTRE() %></td>
				<td style="text-align: center !important"><%=report.getTONGDANGGIAIQUYET() %></td>
				<td style="text-align: center !important"><%=report.getCHUADENHAN() %></td>
				<td style="text-align: center !important"><%=report.getQUAHAN() %></td>
				<td style="text-align: center !important"><%=report.getRUTHOSO() %></td>
				<td style="text-align: center !important"><%=report.getKHONGHOPLE() %></td>
				<td style="text-align: center !important"><%=report.getTONCUOI() %></td>				
			</tr>
			<%
				}
			%>
			<tr>
				<td colspan="2"><strong>Tổng cộng</strong></td>
				<td style="text-align: center !important"><%=tongnhan%></td>
				<td style="text-align: center !important"><%=tiepnhan%></td>
				<td style="text-align: center !important"><%=tondau%></td>
				<td style="text-align: center !important"><%=dagiaiquyet%></td>
				<td style="text-align: center !important"><%=som%></td>
				<td style="text-align: center !important"><%=dung%></td>
				<td style="text-align: center !important"><%=tre%></td>
				<td style="text-align: center !important"><%=danggiaiquyet%></td>
				<td style="text-align: center !important"><%=chuadenhan%></td>
				<td style="text-align: center !important"><%=quahan%></td>
				<td style="text-align: center !important"><%=ruthoso%></td>
				<td style="text-align: center !important"><%=khonghople%></td>
				<td style="text-align: center !important"><%=toncuoi%></td>
			</tr>
		</tbody>
	</table>
	<%}else{
	%>
	<h3>KHÔNG TÌM THẤY DỮ LIỆU TRONG HỆ THỐNG</h3>
	<%}}
	if(report_type.equals("nam")){
		if(listTongHop.size()!=0){
	%>
	<table id="tablelich" border="1" style="border-collapse: collapse;width: 113%;margin-left:-40px;font-size: 16px;">
		<thead>
			<tr>
				<th rowspan="2">STT</th>
				<th rowspan="2">Tháng</th>
				<th rowspan="2">Tổng</th>
				<th rowspan="2">Tiếp nhận</th>
				<th rowspan="2">Kỳ trước chuyển qua</th>
				<th colspan="4">Hồ sơ đã giải quyết</th>
				<th colspan="3">Hồ sơ đang giải quyết</th>
				<th rowspan="2">CD rút hồ sơ</th>
				<th rowspan="2">Hồ sơ trả lại</th>
				<th rowspan="2">Ghi chú</th>
			</tr>
			<tr>
				<th>Số hồ sơ</th>
				<th>Sớm</th>
				<th>Đúng</th>
				<th>Trễ</th>
				<th>Số hồ sơ</th>
				<th>Chưa đến hạn</th>
				<th>Đã quá hạn</th>
			</tr>
		</thead>
		<tbody>
			<%
			long tongnhan = 0;
			long tiepnhan = 0;
			long tondau = 0;
			long dagiaiquyet = 0;
			long som = 0;
			long dung = 0;
			long tre = 0;
			long danggiaiquyet = 0;
			long chuadenhan = 0;
			long quahan = 0;
			long ruthoso = 0;
			long khonghople = 0;
			long toncuoi = 0;
			int stt = 0;
			for (Long s : setIDNhomThuTuc) {
				stt += 1;
			%>
				<tr>
					
					<td colspan="15"><b><%=stt+"."+NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(s).getTen() %></b></td>
				</tr>
			<%
			for(int i=0;i<listTongHop.size();i++){
				ReportTongHop report = listTongHop.get(i);
				if(report.getNHOMTHUTUCHANHCHINHID()==s){
					tongnhan += report.getTONGNHAN();
					tiepnhan += report.getTIEPNHAN();
					tondau += report.getTONDAU();
					dagiaiquyet += report.getTONGDAGIAIQUYET();
					som += report.getSOM();
					dung += report.getDUNG();
					tre += report.getTRE();
					danggiaiquyet += report.getTONGDANGGIAIQUYET();
					chuadenhan += report.getCHUADENHAN();
					quahan += report.getQUAHAN();
					ruthoso += report.getRUTHOSO();
					khonghople += report.getKHONGHOPLE();
					toncuoi += report.getTONCUOI();
			%>
			<tr>
				<td colspan="2">Tháng <%=report.getTHANG() %></td>
				<td style="text-align: center !important"><%=report.getTONGNHAN() %></td>
				<td style="text-align: center !important"><%=report.getTIEPNHAN() %></td>
				<td style="text-align: center !important"><%=report.getTONDAU() %></td>
				<td style="text-align: center !important"><%=report.getTONGDAGIAIQUYET() %></td>
				<td style="text-align: center !important"><%=report.getSOM() %></td>
				<td style="text-align: center !important"><%=report.getDUNG() %></td>
				<td style="text-align: center !important"><%=report.getTRE() %></td>
				<td style="text-align: center !important"><%=report.getTONGDANGGIAIQUYET() %></td>
				<td style="text-align: center !important"><%=report.getCHUADENHAN() %></td>
				<td style="text-align: center !important"><%=report.getQUAHAN() %></td>
				<td style="text-align: center !important"><%=report.getRUTHOSO() %></td>
				<td style="text-align: center !important"><%=report.getKHONGHOPLE() %></td>
				<td style="text-align: center !important"><%=report.getTONCUOI() %></td>				
			</tr>
			<%}
				}%>
			<%
				}
			%>
			<tr>
				<td colspan="2"><strong>Tổng cộng</strong></td>
				<td style="text-align: center !important"><%=tongnhan%></td>
				<td style="text-align: center !important"><%=tiepnhan%></td>
				<td style="text-align: center !important"><%=tondau%></td>
				<td style="text-align: center !important"><%=dagiaiquyet%></td>
				<td style="text-align: center !important"><%=som%></td>
				<td style="text-align: center !important"><%=dung%></td>
				<td style="text-align: center !important"><%=tre%></td>
				<td style="text-align: center !important"><%=danggiaiquyet%></td>
				<td style="text-align: center !important"><%=chuadenhan%></td>
				<td style="text-align: center !important"><%=quahan%></td>
				<td style="text-align: center !important"><%=ruthoso%></td>
				<td style="text-align: center !important"><%=khonghople%></td>
				<td style="text-align: center !important"><%=toncuoi%></td>
			</tr>
		</tbody>
	</table>
	<%}else{
	%>
	<h3>KHÔNG TÌM THẤY DỮ LIỆU TRONG HỆ THỐNG</h3>
	<%}}
	if(report_type.equals("chitiet")){
		if(listTongHopChiTiet.size()!=0){
	%>
	<table id="tablelich" border="1" style="border-collapse: collapse;width: 113%;margin-left:-40px;font-size: 16px;">
		<thead>
			<tr>
				<th rowspan="2">STT</th>
				<th rowspan="2">Thủ tục</th>
				<th rowspan="2">Tổng</th>
				<th rowspan="2">Tiếp nhận</th>
				<th rowspan="2">Kỳ trước chuyển qua</th>
				<th colspan="4">Hồ sơ đã giải quyết</th>
				<th colspan="3">Hồ sơ đang giải quyết</th>
				<th rowspan="2">CD rút hồ sơ</th>
				<th rowspan="2">Hồ sơ trả lại</th>
				<th rowspan="2">Ghi chú</th>
			</tr>
			<tr>
				<th>Số hồ sơ</th>
				<th>Sớm</th>
				<th>Đúng</th>
				<th>Trễ</th>
				<th>Số hồ sơ</th>
				<th>Chưa đến hạn</th>
				<th>Đã quá hạn</th>
			</tr>
		</thead>
		<tbody>
			<%
			long tongnhan = 0;
			long tiepnhan = 0;
			long tondau = 0;
			long dagiaiquyet = 0;
			long som = 0;
			long dung = 0;
			long tre = 0;
			long danggiaiquyet = 0;
			long chuadenhan = 0;
			long quahan = 0;
			long ruthoso = 0;
			long khonghople = 0;
			long toncuoi = 0;
			int stt = 0;
			for (Long s : setIDNhomThuTuc) {
				stt += 1;
			%>
				<tr>					
					<td colspan="15"><b><%=stt+"."+NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(s).getTen() %></b></td>
				</tr>
			<%
			for(int i=0;i<listTongHopChiTiet.size();i++){
				ReportTongHopChiTiet report = listTongHopChiTiet.get(i);
				if(report.getNHOMTHUTUCHANHCHINHID()==s){
					tongnhan += report.getTONGNHAN();
					tiepnhan += report.getTIEPNHAN();
					tondau += report.getTONDAU();
					dagiaiquyet += report.getTONGDAGIAIQUYET();
					som += report.getSOM();
					dung += report.getDUNG();
					tre += report.getTRE();
					danggiaiquyet += report.getTONGDANGGIAIQUYET();
					chuadenhan += report.getCHUADENHAN();
					quahan += report.getQUAHAN();
					ruthoso += report.getRUTHOSO();
					khonghople += report.getKHONGHOPLE();
					toncuoi += report.getTONCUOI();
			%>
			<tr>
				<td colspan="2"><%=ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(report.getTHUTUCHANHCHINHID()).getTen() %></td>
				<td style="text-align: center !important"><%=report.getTONGNHAN() %></td>
				<td style="text-align: center !important"><%=report.getTIEPNHAN() %></td>
				<td style="text-align: center !important"><%=report.getTONDAU() %></td>
				<td style="text-align: center !important"><%=report.getTONGDAGIAIQUYET() %></td>
				<td style="text-align: center !important"><%=report.getSOM() %></td>
				<td style="text-align: center !important"><%=report.getDUNG() %></td>
				<td style="text-align: center !important"><%=report.getTRE() %></td>
				<td style="text-align: center !important"><%=report.getTONGDANGGIAIQUYET() %></td>
				<td style="text-align: center !important"><%=report.getCHUADENHAN() %></td>
				<td style="text-align: center !important"><%=report.getQUAHAN() %></td>
				<td style="text-align: center !important"><%=report.getRUTHOSO() %></td>
				<td style="text-align: center !important"><%=report.getKHONGHOPLE() %></td>
				<td style="text-align: center !important"><%=report.getTONCUOI() %></td>				
			</tr>
			<%} }%>
			<%
				}
			%>
			<tr>
				<td colspan="2"><strong>Tổng cộng</strong></td>
				<td style="text-align: center !important"><%=tongnhan%></td>
				<td style="text-align: center !important"><%=tiepnhan%></td>
				<td style="text-align: center !important"><%=tondau%></td>
				<td style="text-align: center !important"><%=dagiaiquyet%></td>
				<td style="text-align: center !important"><%=som%></td>
				<td style="text-align: center !important"><%=dung%></td>
				<td style="text-align: center !important"><%=tre%></td>
				<td style="text-align: center !important"><%=danggiaiquyet%></td>
				<td style="text-align: center !important"><%=chuadenhan%></td>
				<td style="text-align: center !important"><%=quahan%></td>
				<td style="text-align: center !important"><%=ruthoso%></td>
				<td style="text-align: center !important"><%=khonghople%></td>
				<td style="text-align: center !important"><%=toncuoi%></td>
			</tr>
		</tbody>
	</table>
	<%}else{
	%>
	<h3>KHÔNG TÌM THẤY DỮ LIỆU TRONG HỆ THỐNG</h3>
	<%}}%>
</body>
</html>

