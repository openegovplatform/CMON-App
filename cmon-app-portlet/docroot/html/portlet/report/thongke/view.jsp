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
<%@page import="org.oep.cmon.dao.report.model.ReportThongKe"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
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
PortletPreferences prefs = renderRequest.getPreferences();
String portletResource = ParamUtil.getString(request, "portletResource");
if(Validator.isNotNull(portletResource)){
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}
String[] id_capcoquan = prefs.getValues("id_capcoquan",new String[] {});
if(id_capcoquan.length!=0){
int idBaoCao = 0;
String viewPage = "";
if(Validator.isNotNull(request.getParameter("idBaoCao"))){
	idBaoCao = Integer.valueOf(request.getParameter("idBaoCao").toString());
}
if(Validator.isNotNull(request.getParameter("viewPage"))){
	viewPage = request.getParameter("viewPage").toString();
}
Calendar cal = Calendar.getInstance();

String id_coquanquanly = id_capcoquan[0];
String reportTieuChi = "thang";
String selectedthang = "1";
String selectedquy = "I";
String thang = "1";
String nam = String.valueOf(cal.get(Calendar.YEAR));
List<ReportThongKe> listResult = new ArrayList<ReportThongKe>();

if(Validator.isNotNull(request.getAttribute("listReportThongKe"))){
	listResult = (List<ReportThongKe>)request.getAttribute("listReportThongKe");
}
if(Validator.isNotNull(request.getAttribute("id_coquanquanly"))){
	id_coquanquanly = request.getAttribute("id_coquanquanly").toString();
}
if(Validator.isNotNull(request.getAttribute("report_tieuchi"))){
	reportTieuChi = request.getAttribute("report_tieuchi").toString();
}
if(Validator.isNotNull(request.getAttribute("selectedthang"))){
	selectedthang = request.getAttribute("selectedthang").toString();
}
if(Validator.isNotNull(request.getAttribute("selectedquy"))){
	selectedquy = request.getAttribute("selectedquy").toString();
}

if(Validator.isNotNull(request.getAttribute("thang"))){
	thang = request.getAttribute("thang").toString();
}
if(Validator.isNotNull(request.getAttribute("nam"))){
	nam = request.getAttribute("nam").toString();
}
if(Validator.isNotNull(request.getAttribute("nam"))){
	nam = request.getAttribute("nam").toString();
}

PortletURL baocaoUrl = renderResponse.createActionURL();
baocaoUrl.setParameter(ActionRequest.ACTION_NAME, "baoCaoThongKe");
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
		<input name="thang" id="thang" value="<%=thang%>" type="hidden"/>
<div class="report_outer">  
    <div class="report_inner">
    	<table class="egov-table-form" width="100%">
		  <caption>
		  	<label class="egov-label-header">
		  		<br>BÁO CÁO THỐNG KÊ
		  	</label>
		  </caption>
		  
		  <tr>
		    <td style="width: 100px">
		    	<label class ="egov-label-bold">Thống kê theo</label>
		    </td>
		    <td>
		    	<div id="div_report_type" >
		    	<%for(int i = 0;i<id_capcoquan.length;i++){ %>
		    		<input type="radio" <%=id_capcoquan[i].equals(id_coquanquanly)?"checked":"" %> name="id_coquanquanly" id="rd_ccq_<%=id_capcoquan[i].toString() %>" value="<%=id_capcoquan[i].toString() %>" ><label for="rd_ccq_<%=id_capcoquan[i].toString() %>"><%=CapCoQuanQuanLyLocalServiceUtil.getCapCoQuanQuanLy(Long.valueOf(id_capcoquan[i].toString())).getTen() %></label>
		    	<%} %>
		    	</div>
		    </td>
		  </tr>
		  <tr>
		    <td>
		    	<label class ="egov-label-bold">Chọn tiêu chí</label>
		    </td>
		    <td>
		    	<div id="div_report_tieuchi" >
		    		<input type="radio" <%=reportTieuChi.equals("thang")?"checked":"" %> name="report_tieuchi" id="rd_thang" value="thang" title="Tháng" ><label onclick="RadionButtonSelectedValueSet('selectedthang','1')" for="rd_thang">Tháng</label>
		    		<input type="radio" <%=reportTieuChi.equals("quy")?"checked":"" %> name="report_tieuchi" id="rd_quy" value="quy" title="Quý" ><label onclick="RadionButtonSelectedValueSet('selectedquy','I')" for="rd_quy">Quý</label>
		    		<input type="radio" <%=reportTieuChi.equals("nam")?"checked":"" %> name="report_tieuchi" id="rd_nam" value="nam" title="Năm" ><label onclick="thang_click('0')" for="rd_nam">Năm</label>
		    		<input type="radio" <%=reportTieuChi.equals("6thangdau")?"checked":"" %> name="report_tieuchi" id="rd_6td" value="6thangdau" title="6 tháng đầu" ><label for="rd_6td" onclick="thang_click('1,2,3,4,5,6')">6 tháng đầu</label>
		    		<input type="radio" <%=reportTieuChi.equals("6thangcuoi")?"checked":"" %> name="report_tieuchi" id="rd_6tc" value="6thangcuoi" title="6 tháng cuối" ><label onclick="thang_click('7,8,9,10,11,12')" for="rd_6tc">6 tháng cuối</label>
		    	</div>
		    </td>
		  </tr>
		  <tr id="tr_select_thang">
		    <td>
		    	<label class ="egov-label-bold">Tháng</label>
		    </td>
		    <td>
		    	<input name = "selectedthang" value="1" <%=selectedthang.equals("1")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('1');"> 01 
			    <input name = "selectedthang" value="2" <%=selectedthang.equals("2")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('2');"> 02 
			    <input name = "selectedthang" value="3" <%=selectedthang.equals("3")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('3');"> 03 
			    <input name = "selectedthang" value="4" <%=selectedthang.equals("4")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('4');"> 04 
			    <input name = "selectedthang" value="5" <%=selectedthang.equals("5")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('5');"> 05 
			    <input name = "selectedthang" value="6" <%=selectedthang.equals("6")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('6');"> 06 
			    <input name = "selectedthang" value="7" <%=selectedthang.equals("7")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('7');"> 07 
			    <input name = "selectedthang" value="8" <%=selectedthang.equals("8")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('8');"> 08 
			    <input name = "selectedthang" value="9" <%=selectedthang.equals("9")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('9');"> 09 
			    <input name = "selectedthang" value="10" <%=selectedthang.equals("10")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('10');"> 10 
			    <input name = "selectedthang" value="11" <%=selectedthang.equals("11")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('11');"> 11 
			    <input name = "selectedthang" value="12" <%=selectedthang.equals("12")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('12');"> 12 
		    </td>
		  </tr>	  
		  <tr id="tr_select_quy">
		    <td>
		    	<label class ="egov-label-bold">Quý</label>
		    </td>
		    <td>
		    	 <input name = "selectedquy" value="I" <%=selectedquy.equals("I")?"checked":""%> class="egov-radio" type = "radio" onClick="qui_click('01');"/> I 
				 <input name = "selectedquy" value="II" <%=selectedquy.equals("II")?"checked":""%> class="egov-radio" type = "radio" onClick="qui_click('02');"/> II 
				 <input name = "selectedquy" value="III" <%=selectedquy.equals("III")?"checked":""%> class="egov-radio" type = "radio" onClick="qui_click('03');"/> III 
				 <input name = "selectedquy" value="IV" <%=selectedquy.equals("IV")?"checked":""%> class="egov-radio" type = "radio" onClick="qui_click('04');"/> IV
		    </td>
		  </tr>
		  <tr>
		    <td>
		    	<label class ="egov-label-bold">Năm</label>
		    </td>
		    <td>
		    	<select name="nam" id="nam" class="egov-select" onchange="resetDate()" style="width: 100px">
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
		    	<input type="submit" value="Hiển thị"  class="egov-button" />
		    	<input type="button" id="btn-excel" class="egov-button" value="Xuất excel">
		    	<input type="button" id="btn-word" class="egov-button" value="Xuất word">
		    </td>
		  </tr>
		</table>
	</div>
</div>
</form><br>
	<%
	if(listResult.size()!=0){
	%>
	<table class="egov-table report-table" width="100%">
		<thead>
			<tr>
				<th rowspan="2" align="center">STT</th>
				<th rowspan="2" align="center">Cơ quan</th>
				<th rowspan="2" align="center">Tổng</th>
				<th rowspan="2" align="center">Tiếp nhận</th>
				<th rowspan="2" align="center">Kỳ trước chuyển qua</th>
				<th colspan="4" align="center">Hồ sơ đã giải quyết</th>
				<th colspan="3" align="center">Hồ sơ đang giải quyết</th>
				<th rowspan="2" align="center">CD rút hồ sơ</th>
				<th rowspan="2" align="center">Hồ sơ trả lại</th>
				<th rowspan="2" align="center">Tồn cuối</th>
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
					ReportThongKe report = listResult.get(i);
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
				<td nowrap="nowrap"><%=CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(report.getCOQUANQUANLYID()).getTen()%></td>
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
				<td colspan="2">Tổng cộng</td>
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
	<%}else{ %>
	<h3>KHÔNG TÌM THẤY DỮ LIỆU TRONG HỆ THỐNG</h3>
<%}}else{ %>
<div style="width: 100%;text-align: center;"><h1>VUI LÒNG CẤU HÌNH CHỌN CẤP CƠ QUAN QUẢN LÝ	</h1></div>
<%} %>
</div>
<portlet:resourceURL escapeXml="false" var="exportExcel">
</portlet:resourceURL>
<script type="text/javascript">
$(function(){
	$("#div_report_type").buttonset();	
	$("#div_report_tieuchi").buttonset();	
	
	function testCheckTieuChi() {
	    /* var tieuchi = $(this).val(); */
	    var tieuchi = $('div#div_report_tieuchi :radio:checked').val();
		if(tieuchi=='thang'){
			$('#tr_select_thang').show();
			$('#tr_select_quy').hide();
		}
		if(tieuchi=='quy'){
			$('#tr_select_thang').hide();
			$('#tr_select_quy').show();
		}
		if(tieuchi=='nam'||tieuchi=='6thangdau'||tieuchi=='6thangcuoi'){
			$('#tr_select_thang').hide();
			$('#tr_select_quy').hide();
		}
		
	};
	testCheckTieuChi();
	$("#div_report_tieuchi :radio").click(function(e) {
		testCheckTieuChi();
	});
	
	jQuery("#btn-excel").click(function(){
		var url = '<%=exportExcel.toString()%>';
		var id_coquanquanly = jQuery('input[name="id_coquanquanly"]:checked', '#baoCaoTongHopForm').val();
		url+='&report_type=thongke';
		url+='&id_coquanquanly='+id_coquanquanly;
		url+='&thang='+$('#thang').val();
		url+='&nam='+$('#nam').val();
	    window.location = url;
	});
	
	jQuery("#btn-word").click(function(){
		var url = '<%=request.getContextPath()%>/html/portlet/report/thongke/word.jsp?';
		var id_coquanquanly = jQuery('input[name="id_coquanquanly"]:checked', '#baoCaoTongHopForm').val();
		url+='&report_type=thongke';
		url+='&id_coquanquanly='+id_coquanquanly;
		url+='&thang='+$('#thang').val();
		url+='&nam='+$('#nam').val();
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
function RadionButtonSelectedValueSet(name, SelectdValue) {
	var selectedtime = jQuery('input[name="'+name+'"]:checked', '#baoCaoTongHopForm').val();
	if(name=='selectedthang'){
		document.baoCaoTongHopForm.elements["thang"].value = selectedtime;
	}else{
		if(selectedtime=='I'){
			document.baoCaoTongHopForm.elements["thang"].value = '1,2,3';
		}
		if(selectedtime=='II'){
			document.baoCaoTongHopForm.elements["thang"].value = '4,5,6';
		}
		if(selectedtime=='III'){
			document.baoCaoTongHopForm.elements["thang"].value = '7,8,9';
		}
		if(selectedtime=='IV'){
			document.baoCaoTongHopForm.elements["thang"].value = '10,11,12';
		}
	}
}
</script>