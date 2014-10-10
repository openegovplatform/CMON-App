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
<%@page import="java.text.DateFormat"%>
<%@page import="org.oep.cmon.report.portlet.util.ActionUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.impl.CongChucImpl"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.impl.TaiKhoanNguoiDungImpl"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="java.util.TimeZone"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.util.Portal"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.oep.cmon.dao.report.model.Baocaochitiet"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="org.oep.cmon.dao.report.service.BaocaochitietLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.model.User"%>

<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setContentType("application/vnd.ms-word");
	response.setHeader("Content-Disposition", "attachment; filename=Baocaochitiet.doc");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	
	 String[] listloaihoso = null;
	 if(Validator.isNotNull(ParamUtil.getParameterValues(request,"chon_hoso"))){
		 listloaihoso = ParamUtil.getParameterValues(request,"chon_hoso");
	 }
	 String ngaynhan_tungay = "";
	 if(Validator.isNotNull(ParamUtil.getString(request, "ngaynhan_tungay"))){
		 ngaynhan_tungay = ParamUtil.getString(request, "ngaynhan_tungay");
	 }
	 String ngaynhan_denngay = "";
	 if(Validator.isNotNull(ParamUtil.getString(request, "ngaynhan_denngay"))){
		 ngaynhan_denngay = ParamUtil.getString(request, "ngaynhan_denngay");
	 }
	 String trangthai_hoso = "";
	 if(Validator.isNotNull(ParamUtil.getString(request, "trangthai_hoso"))){
		 trangthai_hoso = ParamUtil.getString(request, "trangthai_hoso");
	 }
	 
	 String tinhtrang = "";
	 if(Validator.isNotNull(ParamUtil.getString(request, "tinhtrang_hoso"))){
		 tinhtrang = ParamUtil.getString(request, "tinhtrang_hoso");
	 }
	 String loaidangky = "";
	 if(Validator.isNotNull(ParamUtil.getString(request, "loaidangky_hoso"))){
		 loaidangky = ParamUtil.getString(request, "loaidangky_hoso");
	 }
	 String ten_donvi ="";
	 if(Validator.isNotNull(ParamUtil.getString(request,"chon_donvi"))){
		 ten_donvi = ParamUtil.getString(request,"chon_donvi");
	 }
	 
	 List<Baocaochitiet> list = BaocaochitietLocalServiceUtil.hienthiDanhsachBaocao(listloaihoso, ngaynhan_tungay, ngaynhan_denngay, trangthai_hoso, tinhtrang, loaidangky, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<table style="width: 100%;">
		<tr>
		    <td style="font-size: 17px; width:40%;text-align: center;"><p style="text-decoration: underline">QUẬN LIÊN CHIỂU</p></td>
		    <td colspan="2" style="font-size: 17px;width: 60%;text-align: center;">CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</td>
		</tr>
		<tr>
		    <td style="font-size: 17px; width:40%;text-align: center;"></td>
		    <td colspan="2" style="font-size: 18.5px; width:60%;text-align: center;"><p style="text-decoration: underline">Độc lập - Tự do - Hành chính</p></td>
		</tr>
	<%
	 Calendar dateTime = Calendar.getInstance();
	 SimpleDateFormat ngay_format = new SimpleDateFormat("dd");
	 SimpleDateFormat thang_format = new SimpleDateFormat("MM");
	 SimpleDateFormat nam_format = new SimpleDateFormat("yyyy");
	 TimeZone timeZone = TimeZone.getTimeZone("GMT+7");
	 ngay_format.setTimeZone(timeZone);
	 thang_format.setTimeZone(timeZone);
	 nam_format.setTimeZone(timeZone);
	 Date time = dateTime.getTime();
     String day = ngay_format.format(time);
     String month = thang_format.format(time);
     String year = nam_format.format(time);
     if(day !="" && month !="" && year !=""){
	%>
	 <tr><td  colspan="11" style="text-align:right; font-style:italic"><%=ten_donvi%> ,&#32;ngày&#32;<%=day%>&#32;tháng&#32;<%=month%>&#32;năm&#32;<%=year%></td></tr>
	<%}%>
	 </table>
     <table style="width: 100%;">
     <tr><td style="text-align:center; font-weight:bold; margin-top:40px;" colspan="2">BÁO CÁO TÌNH HÌNH TIẾP NHẬN VÀ GIẢI QUYẾT HỒ SƠ</td></tr>
	<%
	if(ngaynhan_tungay!="" && ngaynhan_denngay!=""){
	%>
   	 <tr><td style="text-align:center; font-style:italic" colspan="2">Từ ngày: <%=ngaynhan_tungay%> đến ngày: <%=ngaynhan_denngay%></td></tr>
	 <%}else if(ngaynhan_tungay!="" && ngaynhan_denngay==""){
		ngaynhan_denngay = "01/12/"+ngaynhan_tungay.substring(6,10);%>
		<tr><td style="text-align:center; font-style:italic" colspan="2">Từ ngày: <%=ngaynhan_tungay%> đến ngày: <%=ngaynhan_denngay%></td></tr>
	 <%}else if(ngaynhan_tungay=="" && ngaynhan_denngay!=""){
		ngaynhan_tungay = "01/01/"+ngaynhan_denngay.substring(6,10);%> 
		<tr><td style="text-align:center; font-style:italic" colspan="2">Từ ngày: <%=ngaynhan_tungay%> đến ngày: <%=ngaynhan_denngay%></td></tr>
	 <%}else{
		ngaynhan_tungay  = "01/01/"+year;
		ngaynhan_denngay = "01/12/"+year;%>
		<tr><td style="text-align:center; font-style:italic" colspan="2">Từ ngày: <%=ngaynhan_tungay%> đến ngày: <%=ngaynhan_denngay%></td></tr>
	 <%}
   if(!trangthai_hoso.equals("")){%>
   		<tr><td style="text-align:center; font-style:italic" colspan="2">Trạng thái: <%=TrangThaiHoSoLocalServiceUtil.getTrangThaiHoSo(Long.parseLong(trangthai_hoso)).getTrangThai()%></td></tr>
	 <%}%>
	</table>
		<br/>
			<table style="border:0.3px solid black; border-collapse: collapse; width:100%; margrin-left:-40px">
		    	<tr>
		    		<th style=" border:0.3px solid black; padding:5px 0; text-align:center; width:5%;">STT</th>
		    		<th style=" border:0.3px solid black; padding:5px 0; text-align:center; width:24%;">Lĩnh vực</th>
		    		<th style=" border:0.3px solid black; padding:5px 0; text-align:center; width:24%;">Tên hồ sơ</th>
		    		<th style=" border:0.3px solid black; padding:5px 0; text-align:center; width:8%;">Số hồ sơ</th>
		    		<th style=" border:0.3px solid black; padding:5px 0; text-align:center; width:6%;">Trạng thái</th>
		    		<th style=" border:0.3px solid black; padding:5px 0; text-align:center; width:11%">Địa chỉ</th>
		    		<th style=" border:0.3px solid black; padding:5px 0; text-align:center; width:10%;">Điện thoại</th>
		    		<th style=" border:0.3px solid black; padding:5px 0; text-align:center; width:6%;">Người nộp hồ sơ</th>
		    		<th style=" border:0.3px solid black; padding:5px 0; text-align:center; width:6%">Chủ hồ sơ</th>
		    		<th style=" border:0.3px solid black; padding:5px 0; text-align:center; width:8%;">Ngày nhận</th>
		    		<th style=" border:0.3px solid black; padding:5px 0; text-align:center; width:8%;">Ngày hẹn trả</th>
		    		<th style=" border:0.3px solid black; padding:5px 0; text-align:center; width:8%;">Tình trạng<br>hồ sơ</th>
		    		<th style=" border:0.3px solid black; padding:5px 0; text-align:center; width:10%;">Ghi chú</th>
		    	</tr>
		   <%
		  		long count = 0;
		   if(list!=null && list.size()>0){
				long linhvucId = 0L;
				for(int a=0;a<list.size();a++){
						String tinh_trang = "";
						if(Validator.isNotNull(list.get(a).getNGAYTRAKETQUA()) && Validator.isNotNull(list.get(a).getNGAYHENTRAKETQUA())){
							DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							Date ngaytra = df.parse(list.get(a).getNGAYTRAKETQUA());
							Date ngayhentra = df.parse(list.get(a).getNGAYHENTRAKETQUA());
							if(ngaytra.before(ngayhentra)){
								tinh_trang = "Sớm hẹn";
							}else if(ngaytra.equals(ngayhentra)){
								tinh_trang ="Đúng hẹn";
							}else if(ngaytra.after(ngayhentra)){
								tinh_trang ="Trễ hẹn";
							}
						}
						%>
							<tr>
						 	<td style="border:0.3px solid black; padding:5px; width:5px;"><%=(a+1)%></td>
						 	<td style="border:0.3px solid black; padding:5px; width:5px;"><%=NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(list.get(a).getLINHVUCID()).getTen()%></td>
						    <td style="border:0.3px solid black; padding:5px; width:30px;"><%=list.get(a).getTEN()%></td>
						    <td style="border:0.3px solid black; padding:5px; width:15px;"><%=list.get(a).getMASOHOSO()%></td>
						    <td style="border:0.3px solid black; padding:5px; width:10px;"><%=list.get(a).getTRANGTHAI()%></td>
						    <td style="border:0.3px solid black; padding:5px; width:12px;"><%=list.get(a).getDIACHIHIENNAY()%></td>
						    <td style="border:0.3px solid black; padding:5px; width:8px;"><%=list.get(a).getDIENTHOAIDIDONG()%></td>
						    <td style="border:0.3px solid black; padding:5px; width:8px;"><%=list.get(a).getHOTENNGUOINOPHOSO()%></td>
						    <td style="border:0.3px solid black; padding:5px; width:10px;"><%=list.get(a).getNGUOIDAIDIENPHAPLUAT()%></td>
						    <td style="border:0.3px solid black; padding:5px; width:8px"><%=list.get(a).getNGAYNHANHOSO()%></td>
						    <td style="border:0.3px solid black; padding:5px; width:8px"><%=list.get(a).getNGAYTRAKETQUA()%></td>
						    <td style="border:0.3px solid black; padding:5px; width:8px"><%=tinh_trang%></td>
						    <td style="border:0.3px solid black; padding:5px; width:12px;"><%=list.get(a).getGHICHU()%></td>
						    </tr>
					 <%count++;
				}%>
				<tr>
				<td colspan="12" style="text-align:right; padding:5px; border: 0.3px solid black;"><p style="font-weight:bold">Tổng số hồ sơ</p></td>
				<td style="text-align:right; padding:5px; border: 0.3px solid black;"><%=count%></td>
				</tr>
				</table>
				<table  style="width: 100%;margin-top:40px;">
				<tr>
				<td colspan="2" style="font-weight:bold">Người lập</td>
				<td colspan="5" style="font-weight:bold; text-align:center">Người báo cáo</td>
				</tr>
				</table>
				<%
					CongChuc congchuc = new CongChucImpl();
					TaiKhoanNguoiDung taikhoan = new TaiKhoanNguoiDungImpl();
					taikhoan = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(PortalUtil.getUserId(request));
					congchuc = ActionUtil.getCongchucByTaiKhoanNguoiDungId(taikhoan.getId());
				%>
				<br/>
				<br/>
				<br/>
				<br/>
				<h2 style="margin-left:50px;"><%=congchuc!=null?congchuc.getHoVaTen():""%></h2>
				<%}else{%>
					<tr>
					 	<td style="border:0.3px solid black; padding:5px; width:5px;"></td>
					 	<td style="border:0.3px solid black; padding:5px; width:30px;"></td>
					    <td style="border:0.3px solid black; padding:5px; width:30px;"></td>
					    <td style="border:0.3px solid black; padding:5px; width:15px;"></td>
					    <td style="border:0.3px solid black; padding:5px; width:10px;"></td>
					    <td style="border:0.3px solid black; padding:5px; width:12px;"></td>
					    <td style="border:0.3px solid black; padding:5px; width:8px;"></td>
					    <td style="border:0.3px solid black; padding:5px; width:8px;"></td>
					    <td style="border:0.3px solid black; padding:5px; width:10px;"></td>
					    <td style="border:0.3px solid black; padding:5px; width:8px"></td>
					    <td style="border:0.3px solid black; padding:5px; width:8px"></td>
					    <td style="border:0.3px solid black; padding:5px; width:8px"></td>
					    <td style="border:0.3px solid black; padding:5px; width:12px;"></td>
				    </tr>
				    <%count=0;%>
				    <tr>
					<td colspan="12" style="text-align:right; padding:5px; border: 0.3px solid black;"><p style="font-weight:bold">Tổng số hồ sơ</p></td>
					<td style="text-align:right; padding:5px; border: 0.3px solid black;"><%=count%></td>
					</tr>
					</table>
					<table  style="width: 100%;margin-top:40px;">
					<tr>
					<td colspan="2" style="font-weight:bold; text-align:center">Người lập</td>
					<td colspan="5" style="font-weight:bold; text-align:center">Người báo cáo</td>
					</tr>
					</table>
					<%
						CongChuc congchuc = new CongChucImpl();
						TaiKhoanNguoiDung taikhoan = new TaiKhoanNguoiDungImpl();
						taikhoan = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(PortalUtil.getUserId(request));
						congchuc = ActionUtil.getCongchucByTaiKhoanNguoiDungId(taikhoan.getId());
					%>
					<br/>
					<br/>
					<br/>
					<br/>
					<h2 style="margin-left:50px;"><%=congchuc!=null?congchuc.getHoVaTen():""%></h2>
				<%}%>
</body>
</html>


