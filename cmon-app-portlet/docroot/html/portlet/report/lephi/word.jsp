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
	response.setHeader("Content-Disposition", "attachment; filename=Baocaotinhhinhthulephi.doc");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	
	String id_loaihoso = request.getParameter("id_loaihoso");
	String id_linhvuc = request.getParameter("id_linhvuc");
	String ngaynhan_tungay = request.getParameter("tungay");
	String ngaynhan_denngay = request.getParameter("denngay");
	String report_type = request.getParameter("report_type");
	String coQuanQuanLyId = request.getParameter("coQuanQuanLyId");
	List<NhomThuTucHanhChinh> listnhomtt = NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinhs(0,NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinhsCount());
	List<Lephi_chitiet> lephi_chitiet = Lephi_chitietLocalServiceUtil.lephichitiet(id_loaihoso, ngaynhan_tungay, ngaynhan_denngay);
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
<%
if(report_type.equals("lephichitiet")){
%>
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
		<strong>BÁO CÁO TÌNH HÌNH THU LỆ PHÍ CHI TIẾT</strong>
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
		<th>STT</th>
		<th>Loại hồ sơ</th>
		<th>Người nộp</th>
		<th>Chủ hồ sơ</th>
		<th>Địa chỉ</th>
		<th>Số bộ hồ sơ</th>
		<th>Lệ phí</th>
		<th>Phí hồ sơ</th>
		<th>Tổng lệ phí</th>
		<th>Ghi chú</th>
	</tr>
	<%
	int stt=0;
	long tong = 0;
	for(int j=0;j<listnhomtt.size();j++){
		if(ActionUtil.checkHosoByNHOMTTHCID(listnhomtt.get(j).getId(),lephi_chitiet)){		
	%>
	<tr>
		<td colspan="10"><strong><%=listnhomtt.get(j).getTen()%></strong></td>
	</tr>
	<%
		for(int i=0;i<lephi_chitiet.size();i++){
			if(listnhomtt.get(j).getId()==lephi_chitiet.get(i).getNHOMTHUTUCHANHCHINHID()){
			stt++;
			tong+= Long.valueOf(lephi_chitiet.get(i).getTONGLEPHI());
	%>
	<tr>
		<td style="text-align: center;"><%=stt%></td>
		<td><%=lephi_chitiet.get(i).getTENHOSO()%></td>
		<td><%=lephi_chitiet.get(i).getNGUOINOP()%></td>
		<td><%=lephi_chitiet.get(i).getCHUHOSO()%></td>
		<td><%=lephi_chitiet.get(i).getDIACHI()%></td>
		<td style="text-align: center;"><%=lephi_chitiet.get(i).getSOBOHOSO()%></td>
		<td style="text-align: right;"><%=lephi_chitiet.get(i).getLEPHI()%></td>
		<td style="text-align: right;"><%=lephi_chitiet.get(i).getPHIHOSO()%></td>
		<td style="text-align: right;"><%=lephi_chitiet.get(i).getTONGLEPHI()%></td>
		<td><%=lephi_chitiet.get(i).getGHICHU()%></td>
	</tr>
		<%
			}
		}
	  }
	}
	%>
	<tr>
		<td colspan="8" style="text-align: right"><strong>Tổng cộng</strong></td>
		<td style="text-align: right"><%=tong%></td>
		<td></td>
	</tr>
</table>
<%}%>

<%
if(report_type.equals("lephilinhvuc")){
	List<Lephi_linhvuc> lephi_linhvuc = Lephi_linhvucLocalServiceUtil.lephilinhvuc(id_linhvuc, ngaynhan_tungay, ngaynhan_denngay);
%>
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
		<strong>BÁO CÁO TÌNH HÌNH THU LỆ PHÍ THEO LĨNH VỰC</strong>
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
		<th>STT</th>
		<th>Lĩnh vực</th>
		<th>Tổng hồ sơ</th>
		<th>Lệ phí hồ sơ</th>
		<th>Phí hồ sơ</th>
		<th>Tổng lệ phí</th>
		<th>Ghi chú</th>
	</tr>
	<%
		int stt=0;
		int tong_hoso = 0;
		long tong_lephihoso =0;
		long tong_phihoso =0;
		long tong_lephi = 0;
		for(int i=0;i<lephi_linhvuc.size();i++){
			stt++;
			tong_hoso += Integer.valueOf(lephi_linhvuc.get(i).getTONGHOSO());
			tong_phihoso += Long.valueOf(lephi_linhvuc.get(i).getPHIHOSO());
			tong_lephihoso += Long.valueOf(lephi_linhvuc.get(i).getLEPHIHOSO());
			tong_lephi += Long.valueOf(lephi_linhvuc.get(i).getTONGLEPHI());
	%>
	<tr>
		<td style="text-align: center;"><%=stt%></td>
		<td><%=NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(lephi_linhvuc.get(i).getNHOMTHUTUCHANHCHINHID()).getTen()%></td>
		<td style="text-align: right;"><%=lephi_linhvuc.get(i).getTONGHOSO()%></td>
		<td style="text-align: right;"><%=lephi_linhvuc.get(i).getLEPHIHOSO()%></td>
		<td style="text-align: right;"><%=lephi_linhvuc.get(i).getPHIHOSO()%></td>
		<td style="text-align: right;"><%=lephi_linhvuc.get(i).getTONGLEPHI()%></td>
		<td></td>
	</tr>
		<%
		}
	%>
	<tr>
		<td colspan="2" style="text-align: right"><strong>Tổng cộng</strong></td>
		<td style="text-align: right"><%=tong_hoso%></td>
		<td style="text-align: right"><%=tong_lephihoso%></td>
		<td style="text-align: right"><%=tong_phihoso%></td>
		<td style="text-align: right"><%=tong_lephi%></td>
		<td></td>
	</tr>
</table>
<%}%>


<%
if(report_type.equals("lephitonghop")){
	List<Lephi_tonghop> lephi_tonghop = Lephi_tonghopLocalServiceUtil.lephitonghop(id_loaihoso, ngaynhan_tungay, ngaynhan_denngay);
%>
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
		<strong>BÁO CÁO TÌNH HÌNH THU LỆ PHÍ THEO LĨNH VỰC</strong>
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
		<th>STT</th>
		<th>Lĩnh vực</th>
		<th>Tổng hồ sơ</th>
		<th>Lệ phí hồ sơ</th>
		<th>Phí hồ sơ</th>
		<th>Tổng lệ phí</th>
		<th>Ghi chú</th>
	</tr>
	<%
	int stt=0;
	long tong = 0;
	for(int j=0;j<listnhomtt.size();j++){
		if(ActionUtil.checkLePhiTongHopByNHOMTTHCID(listnhomtt.get(j).getId(),lephi_tonghop)){		
	%>
	<tr>
		<td colspan="7"><strong><%=listnhomtt.get(j).getTen()%></strong></td>
	</tr>
	<%
		for(int i=0;i<lephi_tonghop.size();i++){
			if(listnhomtt.get(j).getId()==lephi_tonghop.get(i).getNHOMTHUTUCHANHCHINHID()){
			stt++;
			tong+= Long.valueOf(lephi_tonghop.get(i).getTONGLEPHI());
	%>
	<tr>
		<td style="text-align: center;"><%=stt%></td>
		<td style="text-align: left;">Tháng <%=lephi_tonghop.get(i).getTHANGNHAN()%></td>
		<td style="text-align: right;"><%=lephi_tonghop.get(i).getTONGHOSO()%></td>
		<td style="text-align: right;"><%=lephi_tonghop.get(i).getLEPHI()%></td>
		<td style="text-align: right;"><%=lephi_tonghop.get(i).getPHIHOSO()%></td>
		<td style="text-align: right;"><%=lephi_tonghop.get(i).getTONGLEPHI()%></td>
		<td></td>
	</tr>
		<%
			}
		}
	  }
	}
	%>
	<tr>
		<td colspan="5" style="text-align: right"><strong>Tổng cộng</strong></td>
		<td style="text-align: right"><%=tong%></td>
		<td></td>
	</tr>
</table>
<%}%>
</body>
</html>

