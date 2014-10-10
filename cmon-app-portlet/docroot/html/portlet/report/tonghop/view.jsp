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
<%@page import="org.oep.cmon.dao.report.model.ReportTongHopChiTiet"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="org.oep.cmon.dao.report.model.impl.ReportTongHopImpl"%>
<%@page import="org.oep.cmon.dao.report.model.ReportTongHop"%>
<%@page import="org.oep.cmon.dao.nsd.model.impl.TaiKhoanNguoiDungImpl"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.report.portlet.util.ActionUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Calendar"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@page import="java.util.Arrays"%>
<%@page import="org.apache.commons.lang.Validate"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
int idBaoCao = 0;
String viewPage = "";
if(Validator.isNotNull(request.getParameter("idBaoCao"))){
	idBaoCao = Integer.valueOf(request.getParameter("idBaoCao").toString());
}
if(Validator.isNotNull(request.getParameter("viewPage"))){
	viewPage = request.getParameter("viewPage").toString();
}
Calendar cal = Calendar.getInstance();
String thang = "1";
String report_type ="tongquat";
String selectedtime = "1";
String nam = String.valueOf(cal.get(Calendar.YEAR));
String isDisplay = request.getAttribute("isDisplay")!=null?request.getAttribute("isDisplay").toString():"0";
List<Long> id_loaihoso = new ArrayList<Long>();
List<Long> id_linhvuc = new ArrayList<Long>();
long id_donvi = 0;

if(Validator.isNotNull(request.getAttribute("thang"))){
	thang = request.getAttribute("thang").toString();
}
if(Validator.isNotNull(request.getAttribute("report_type"))){
	report_type = request.getAttribute("report_type").toString();
}
if(Validator.isNotNull(request.getAttribute("selectedtime"))){
	selectedtime = request.getAttribute("selectedtime").toString();
}
if(Validator.isNotNull(request.getAttribute("nam"))){
	nam = request.getAttribute("nam").toString();
}
if(Validator.isNotNull(request.getAttribute("id_donvi"))){
	id_donvi =Long.valueOf(request.getAttribute("id_donvi").toString());
}
if(Validator.isNotNull(request.getAttribute("id_loaihoso"))){
	id_loaihoso =(List<Long>) request.getAttribute("id_loaihoso");
}
if(Validator.isNotNull(request.getAttribute("id_linhvuc"))){
	id_linhvuc =(List<Long>) request.getAttribute("id_linhvuc");
}
PortletURL baocaoUrl = renderResponse.createActionURL();
baocaoUrl.setParameter(ActionRequest.ACTION_NAME, "baoCaoTongHop");
List<CoQuanQuanLy> listCoQuan = new ArrayList<CoQuanQuanLy>();
List<NhomThuTucHanhChinh> listnhomtt = new ArrayList<NhomThuTucHanhChinh>();
List<ThuTucHanhChinh> listTTHC = new ArrayList<ThuTucHanhChinh>();
TaiKhoanNguoiDung loginUser = new TaiKhoanNguoiDungImpl();
if(themeDisplay.isSignedIn()){
	boolean test = false;
	loginUser = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(PortalUtil.getUserId(request));
	if(loginUser!=null){
		test = ActionUtil.testReportPermission(loginUser.getId(),idBaoCao);
		listCoQuan = ActionUtil.getCoquanquanly(test,loginUser.getId(),idBaoCao);
		if(id_donvi==0&&listCoQuan.size()!=0){
			id_donvi = listCoQuan.get(0).getId();
		}
		if(id_donvi!=0){
			listnhomtt= ActionUtil.getNhomTTHC(test,loginUser.getId(),idBaoCao,id_donvi);
			if(report_type.equals("chitiet")){
				listTTHC = ActionUtil.getTTHC(test,loginUser.getId(),idBaoCao,id_donvi);
			}
		}
	}
}
%>
<style>
.report-table thead tr th{
	text-align: center !important;
	white-space: normal !important;	
}
.report_outer {
  width: 100%;
  text-align: center;
}

.report_inner {
  display: inline-block;
}
</style>
<div class="egov-container">
	<form name = "baoCaoTongHopForm" id="baoCaoTongHopForm" method = "post" action = "<%=baocaoUrl%>">
		<input type="hidden" name="idBaoCao" value="<%=idBaoCao%>"/>
		<input type="hidden" name="viewPage" value="<%=viewPage%>"/>
		<input type="hidden" id="isDisplay" name="isDisplay" value="0"/>
<div class="report_outer">  
    <div class="report_inner">		
		<table class="egov-table-form" width="100%">
		  <caption>
		  	<label class="egov-label-header">
		  		<br>BÁO CÁO TỔNG HỢP
		  	</label>
		  </caption>
		  <tr>
		    <td style="width: 100px">
		    	<label class ="egov-label-bold">Báo cáo theo</label>
		    </td>
		    <td>
		    	<select name="report_type" id="report_type" class="egov-select" style="width: 300px">
		    		<option value="tongquat" <%=report_type.equals("tongquat")?"selected":""%>>Tổng quát</option>
		    		<option value="chitiet" <%=report_type.equals("chitiet")?"selected":""%>>Chi tiết</option>
		    		<option value="nam" <%=report_type.equals("nam")?"selected":""%>>Năm</option>
		    	</select>
		    </td>
		  </tr>
		  <tr>
		    <td>
		    	<label class ="egov-label-bold">Chọn đơn vị</label>
		    </td>
		    <td>
		    	<select name="id_donvi" id="id_donvi" class="egov-select" style="width: 300px">
	    			<%
						for (int i = 0; i < listCoQuan.size(); ++ i) {
					%>
						<option value="<%=listCoQuan.get(i).getId()%>" <%=listCoQuan.get(i).getId()==id_donvi?"selected":"" %> ><%=listCoQuan.get(i).getTen()%></option>
					<%	} %>
		    	</select>
		    </td>
		  </tr>
		  <%
		  if(report_type.equals("chitiet")){
		  %>
		  <tr>
		    <td>
		    	<label class ="egov-label-bold">Loại hồ sơ</label>
		    </td>
		    <td>
		    	<select name="id_loaihoso" id="id_loaihoso" class="egov-select" multiple="multiple" style="width: 300px">
	    			<%
						for (int i = 0; i < listnhomtt.size(); ++ i) {
					%>
						<optgroup label="<%=listnhomtt.get(i).getTen()%>">
					<%	
						for(int j=0;j<listTTHC.size();j++){
							ThuTucHanhChinh tthc = listTTHC.get(j);
							if(listnhomtt.get(i).getId()==tthc.getNhomThuTucHanhChinhId()){
					%>
						<option value="<%= tthc.getId() %>" <%=id_loaihoso.contains(tthc.getId())?"selected":"" %>><%=tthc.getTen()%></option>
					<%	
							 }
						 }
					%>
						</optgroup>
					<%	}	%>
		    	</select>
		    	<label style="color: red">${message}</label>
		    </td>
		  </tr>
		  <%}else{
			  %>
		  <tr>
		    <td>
		    	<label class ="egov-label-bold">Lĩnh vực</label>
		    </td>
		    <td>
		    	<select name="id_linhvuc" id="id_linhvuc" class="egov-select" multiple="multiple" style="width: 300px">
	    			<%
						for (int i = 0; i < listnhomtt.size(); ++ i) {
					%>
						<option value="<%=listnhomtt.get(i).getId()%>"  <%=id_linhvuc.contains(listnhomtt.get(i).getId())?"selected":"" %>><%=listnhomtt.get(i).getTen()%></option>
					<%	} %>
		    	</select>
		    	<label style="color: red">${message}</label>
		    </td>
		  </tr>
		  <%} %>
		  <%if(!report_type.equals("nam")){ %>
		  <input name="thang" id="thang" value="<%=thang%>" type="hidden"/>
		  <tr>
		    <td>
		    	<label class ="egov-label-bold">Tháng</label>
		    </td>		    
		    <td>
		    	<input name = "selectedtime" value="1" <%=selectedtime.equals("1")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('1');"> 01 
			    <input name = "selectedtime" value="2" <%=selectedtime.equals("2")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('2');"> 02 
			    <input name = "selectedtime" value="3" <%=selectedtime.equals("3")?"checked":""%>class="egov-radio" type = "radio" onClick="thang_click('3');"> 03 
			    <input name = "selectedtime" value="4" <%=selectedtime.equals("4")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('4');"> 04 
			    <input name = "selectedtime" value="5" <%=selectedtime.equals("5")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('5');"> 05 
			    <input name = "selectedtime" value="6" <%=selectedtime.equals("6")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('6');"> 06 
			    <input name = "selectedtime" value="7" <%=selectedtime.equals("7")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('7');"> 07 
			    <input name = "selectedtime" value="8" <%=selectedtime.equals("8")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('8');"> 08 
			    <input name = "selectedtime" value="9" <%=selectedtime.equals("9")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('9');"> 09 
			    <input name = "selectedtime" value="10" <%=selectedtime.equals("10")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('10');"> 10 
			    <input name = "selectedtime" value="11" <%=selectedtime.equals("11")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('11');"> 11 
			    <input name = "selectedtime" value="12" <%=selectedtime.equals("12")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('12');"> 12 
		    </td>
		  </tr>
		  <tr>
		    <td>
		    	<label class ="egov-label-bold">Quý</label>
		    </td>
		    <td>
		    	 <input name = "selectedtime" value="I" <%=selectedtime.equals("I")?"checked":""%> class="egov-radio" type = "radio" onClick="qui_click('01');"/> I 
				 <input name = "selectedtime" value="II" <%=selectedtime.equals("II")?"checked":""%> class="egov-radio" type = "radio" onClick="qui_click('02');"/> II 
				 <input name = "selectedtime" value="III" <%=selectedtime.equals("III")?"checked":""%> class="egov-radio" type = "radio" onClick="qui_click('03');"/> III 
				 <input name = "selectedtime" value="IV" <%=selectedtime.equals("IV")?"checked":""%> class="egov-radio" type = "radio" onClick="qui_click('04');"/> IV
		    </td>
		  </tr>
		  <%} %>
		  <tr>
		    <td>
		    	<label class ="egov-label-bold">Năm</label>
		    </td>
		    <td>
		    	<select name="nam" id="nam" class="egov-select" style="width: 100px">
		    	<%
		    	for(int i=cal.get(Calendar.YEAR);i>=2012;i--){
		    	%>
		    		<option value="<%=i%>" <%=i==Integer.valueOf(nam)?"selected":""%>><%=i%></option>
		    	<%}%>
		    	</select>
		    </td>
		  </tr>
		  <tr>
		    <td colspan="2" style="text-align: center;">
		    	<input type="submit" id="btn-display" value="Hiển thị"  class="egov-button" />
		    	<input type="button" id="btn-excel" class="egov-button" value="Xuất excel">
		    	<input type="button" id="btn-word" class="egov-button" value="Xuất word">
		    </td>
		  </tr>
		</table>
</div>
</div>		
	</form><br>
	<%if(report_type.equals("tongquat")){
		List<ReportTongHop> listResult = new ArrayList<ReportTongHop>();
		if(Validator.isNotNull(request.getAttribute("listResult"))){
			listResult = (List<ReportTongHop>)request.getAttribute("listResult");
		}
		if(listResult.size()>0 && isDisplay.equals("1")){
	%>
	<table class="egov-table">
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
				<th rowspan="2">Tồn cuối</th>
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
				for(int i=0;i<listResult.size();i++){
					ReportTongHop report = listResult.get(i);
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
		Set<Long> setIDNhomThuTuc = new HashSet<Long>(0);
		List<ReportTongHop> listResult = new ArrayList<ReportTongHop>();
		if(Validator.isNotNull(request.getAttribute("setIDNhomThuTuc"))){
			setIDNhomThuTuc = (Set<Long>)request.getAttribute("setIDNhomThuTuc");
		}
		if(Validator.isNotNull(request.getAttribute("listResult"))){
			listResult = (List<ReportTongHop>)request.getAttribute("listResult");
		}
		if(listResult.size()>0 && isDisplay.equals("1")){
	%>
	<table class="egov-table">
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
				<th rowspan="2">Tồn cuối</th>
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
			for(int i=0;i<listResult.size();i++){
				ReportTongHop report = listResult.get(i);
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
		Set<Long> setIDNhomThuTuc = new HashSet<Long>(0);
		List<ReportTongHopChiTiet> listResult = new ArrayList<ReportTongHopChiTiet>();
		if(Validator.isNotNull(request.getAttribute("setIDNhomThuTuc"))){
			setIDNhomThuTuc = (Set<Long>)request.getAttribute("setIDNhomThuTuc");
		}
		if(Validator.isNotNull(request.getAttribute("listResult"))){
			listResult = (List<ReportTongHopChiTiet>)request.getAttribute("listResult");
		}
		if(listResult.size()>0 && isDisplay.equals("1")){
	%>
	<table class="egov-table">
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
				<th rowspan="2">Tồn cuối</th>
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
			for(int i=0;i<listResult.size();i++){
				ReportTongHopChiTiet report = listResult.get(i);
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
</div>
<portlet:resourceURL escapeXml="false" var="exportExcel">
</portlet:resourceURL>
<script type="text/javascript">
$(function(){
	$("#id_loaihoso").multiselect({ selectedText: "đã chọn # loại hồ sơ"});
	$("#id_linhvuc").multiselect({ selectedText: "đã chọn # lĩnh vực"});
		
	$('#report_type').change(function(){
		document.baoCaoTongHopForm.submit();
	});
	
	$('#id_donvi').change(function(){
		document.baoCaoTongHopForm.submit();
	});
	
	jQuery("#btn-display").click(function(){
		$("#isDisplay").val("1");
	});
	
	jQuery("#btn-excel").click(function(){
		var url = '<%=exportExcel.toString()%>';
		url+='&report_type=tonghop'+$('#report_type').val();
		url+='&id_donvi='+$('#id_donvi').val();
		url+='&nam='+$('#nam').val();
		if($('#report_type').val()=='tongquat'){
			url+='&id_linhvuc='+$('#id_linhvuc').val();
			url+='&thang='+$('#thang').val();
		}
		if($('#report_type').val()=='chitiet'){
			url+='&id_loaihoso='+$('#id_loaihoso').val();
			url+='&thang='+$('#thang').val();
		}
		if($('#report_type').val()=='nam'){
			url+='&id_linhvuc='+$('#id_linhvuc').val();
		}
	    window.location = url;
	});
	
	jQuery("#btn-word").click(function(){
		var url = '<%=request.getContextPath()%>/html/portlet/report/tonghop/word.jsp?';
		url+='&report_type='+$('#report_type').val();
		url+='&id_donvi='+$('#id_donvi').val();
		url+='&nam='+$('#nam').val();
		if($('#report_type').val()=='tongquat'){
			url+='&id_linhvuc='+$('#id_linhvuc').val();
			url+='&thang='+$('#thang').val();
		}
		if($('#report_type').val()=='chitiet'){
			url+='&id_loaihoso='+$('#id_loaihoso').val();
			url+='&thang='+$('#thang').val();
		}
		if($('#report_type').val()=='nam'){
			url+='&id_linhvuc='+$('#id_linhvuc').val();
		}
		window.location = url;
	});
});
function thang_click(month){	
	document.baoCaoTongHopForm.elements["thang"].value = month;
}	
function qui_click(quarter){
	if(quarter == 1)
		document.baoCaoTongHopForm.elements["thang"].value = "1,2,3";
	if(quarter == 2)
		document.baoCaoTongHopForm.elements["thang"].value = "4,5,6";
	if(quarter == 3)
		document.baoCaoTongHopForm.elements["thang"].value = "7,8,9";
	if(quarter == 4)
		document.baoCaoTongHopForm.elements["thang"].value = "10,11,12";		
}
</script>