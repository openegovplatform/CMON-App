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
<%@page import="org.oep.cmon.dao.cc.model.impl.CongChucImpl"%>
<%@page import="org.oep.cmon.dao.nsd.model.impl.TaiKhoanNguoiDungImpl"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.report.portlet.util.ActionAdminUtil"%>
<%@page import="org.oep.cmon.dao.report.service.Lephi_tonghopLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.report.model.Lephi_tonghop"%>
<%@page import="org.oep.cmon.report.portlet.util.ActionUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.report.service.Lephi_linhvucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.report.model.Lephi_linhvuc"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Arrays"%>
<%@page import="org.oep.cmon.dao.report.service.Lephi_chitietLocalServiceUtil"%>
<%@page import="org.apache.commons.lang.Validate"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="org.oep.cmon.dao.report.model.Lephi_chitiet"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<liferay-theme:defineObjects />
<portlet:defineObjects />
<%
Calendar cal = Calendar.getInstance();
TimeZone timeZone2 = TimeZone.getTimeZone("GMT+7");
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
df.setTimeZone(timeZone2);
long idBaoCao = request.getParameter("idBaoCao")!=null?Long.valueOf(request.getParameter("idBaoCao")):0;
String viewPage =request.getParameter("viewPage")!=null?request.getParameter("viewPage"):"";
String ngaynhan_tungay = request.getParameter("ngaynhan_tungay")!=null?request.getParameter("ngaynhan_tungay"):"01/01/"+cal.get(Calendar.YEAR);
String ngaynhan_denngay = request.getParameter("ngaynhan_denngay")!=null?request.getParameter("ngaynhan_denngay"):df.format(cal.getTime());
long id_donvi  = request.getParameter("id_donvi")!=null?Long.valueOf(request.getParameter("id_donvi")):0;
String report_type = request.getParameter("report_type")!=null?request.getParameter("report_type"):"lephichitiet";
String selectedtime = request.getParameter("selectedtime")!=null?request.getParameter("selectedtime"):"";
String nam = request.getParameter("nam")!=null?request.getParameter("nam"):String.valueOf(cal.get(Calendar.YEAR));
String display_result = request.getParameter("display_result")!=null?request.getParameter("display_result"):"0";
String str_loaihoso = request.getParameter("id_loaihoso")!=null?request.getParameter("id_loaihoso"):"";
String str_linhvuc = request.getParameter("id_linhvuc")!=null?request.getParameter("id_linhvuc"):"";
List<String> id_loaihoso = new ArrayList<String>();
List<String> id_linhvuc = new ArrayList<String>();
if(!str_loaihoso.equals("")){
	id_loaihoso = new ArrayList<String>(Arrays.asList(str_loaihoso.split(",")));
}
if(!str_linhvuc.equals("")){
	id_linhvuc = new ArrayList<String>(Arrays.asList(str_linhvuc.split(",")));
}


List<CoQuanQuanLy> listcqql = new ArrayList<CoQuanQuanLy>();
List<NhomThuTucHanhChinh> listnhomtt = new ArrayList<NhomThuTucHanhChinh>();
List<ThuTucHanhChinh> listTTHC = new ArrayList<ThuTucHanhChinh>();
TaiKhoanNguoiDung nguoidung = new TaiKhoanNguoiDungImpl();
CongChuc congchuc = null;
ThuTucHanhChinh tthc;
if(themeDisplay.isSignedIn()){
	boolean test = false;
	nguoidung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(PortalUtil.getUserId(request));
	if(nguoidung!=null){
		test = ActionUtil.testReportPermission(nguoidung.getId(),idBaoCao);
		congchuc = ActionUtil.getCongchucByTaiKhoanNguoiDungId(nguoidung.getId());
		listcqql = ActionUtil.getCoquanquanly(test,nguoidung.getId(),idBaoCao);
		if(id_donvi==0&&listcqql.size()!=0){
			id_donvi = listcqql.get(0).getId();
		}
		if(id_donvi!=0){
			listnhomtt= ActionUtil.getNhomTTHC(test,nguoidung.getId(),idBaoCao,id_donvi);
			if(report_type.equals("lephichitiet") || report_type.equals("lephitonghop") ){
				listTTHC = ActionUtil.getTTHC(test,nguoidung.getId(),idBaoCao,id_donvi);
			}
		}
	}
}
PortletURL baocaoUrl = renderResponse.createActionURL();
baocaoUrl.setParameter(ActionRequest.ACTION_NAME, "baocaoLePhi");

PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("jspPage", "/html/portlet/report/view.jsp");
iteratorUrl.setParameter("ngaynhan_tungay",ngaynhan_tungay);
iteratorUrl.setParameter("ngaynhan_denngay",ngaynhan_denngay);
iteratorUrl.setParameter("report_type",report_type);
iteratorUrl.setParameter("id_donvi",String.valueOf(id_donvi));
iteratorUrl.setParameter("selectedtime",selectedtime);
iteratorUrl.setParameter("nam",nam);
iteratorUrl.setParameter("id_loaihoso",str_loaihoso);
iteratorUrl.setParameter("id_linhvuc",str_linhvuc);
iteratorUrl.setParameter("paging","true");
iteratorUrl.setParameter("idBaoCao",String.valueOf(idBaoCao));
iteratorUrl.setParameter("viewPage",viewPage);


SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, iteratorUrl, null, "");

List<Lephi_chitiet>  result = new ArrayList<Lephi_chitiet>();
if(Validator.isNotNull(request.getAttribute("listlephichitiet"))){
	result = (List<Lephi_chitiet>) request.getAttribute("listlephichitiet");	
}

if ( result == null ) {
	 result = new ArrayList<Lephi_chitiet>();
}
//result linhvuc
List<Lephi_linhvuc>  resultlv = new ArrayList<Lephi_linhvuc>();
if(Validator.isNotNull(request.getAttribute("listlephilinhvuc"))){
	resultlv = (List<Lephi_linhvuc>) request.getAttribute("listlephilinhvuc");	
}

if ( resultlv == null ) {
	resultlv = new ArrayList<Lephi_linhvuc>();
}

//result tonghop
List<Lephi_tonghop>  resultth = new ArrayList<Lephi_tonghop>();
if(Validator.isNotNull(request.getAttribute("listlephitonghop"))){
	resultth = (List<Lephi_tonghop>) request.getAttribute("listlephitonghop");	
}

if ( resultth == null ) {
	resultth = new ArrayList<Lephi_tonghop>();
}

if(Validator.isNotNull(request.getParameter("paging"))){
	if(report_type.equals("lephichitiet")){
		result = Lephi_chitietLocalServiceUtil.lephichitiet(str_loaihoso, ngaynhan_tungay, ngaynhan_denngay);
	}else if(report_type.equals("lephilinhvuc")){
		resultth = Lephi_tonghopLocalServiceUtil.lephitonghop(str_loaihoso, ngaynhan_tungay, ngaynhan_denngay);
	}else if(report_type.equals("lephitonghop")){
		resultlv = Lephi_linhvucLocalServiceUtil.lephilinhvuc(str_linhvuc, ngaynhan_tungay, ngaynhan_denngay);
	}
}

List<Lephi_chitiet> newResults = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());
List<Lephi_linhvuc> newResultslv = ListUtil.subList(resultlv, searchContainer.getStart(), searchContainer.getEnd());
List<Lephi_tonghop> newResultsth = ListUtil.subList(resultth, searchContainer.getStart(), searchContainer.getEnd());

if(report_type.equals("lephichitiet")){
	searchContainer.setTotal(result.size());
	searchContainer.setResults(newResults);
}else if(report_type.equals("lephilinhvuc")){
	searchContainer.setTotal(resultlv.size());
	searchContainer.setResults(newResultslv);
}else if(report_type.equals("lephitonghop")){
	searchContainer.setTotal(resultth.size());
	searchContainer.setResults(newResultsth);
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
<br>
	<form name = "baocaolephiForm" id="baocaolephiForm" method = "post" action = "<%=baocaoUrl%>">
		<input type="hidden" name="idBaoCao" value="<%=idBaoCao%>"/>
		<input type="hidden" name="viewPage" value="<%=viewPage%>"/>
		<input type="hidden" name="display_result" id="display_result">
<div class="report_outer">  
    <div class="report_inner">		
		<table class="egov-table-form">
		  <caption>
		  	<label class="egov-label-header">
		  		<br>BÁO CÁO TÌNH HÌNH THU LỆ PHÍ
		  	</label>
		  </caption>
		  <tr>
		    <td style="width: 100px">
		    	<label class ="egov-label-bold">Báo cáo theo</label>
		    </td>
		    <td>
		    	<select name="report_type" id="report_type" class="egov-select" style="width: 300px">
		    		<option value="lephichitiet" <%=report_type.equals("lephichitiet")?"selected":""%>>Báo cáo chi tiết</option>
		    		<option value="lephilinhvuc" <%=report_type.equals("lephilinhvuc")?"selected":""%>>Lĩnh vực</option>
		    		<option value="lephitonghop" <%=report_type.equals("lephitonghop")?"selected":""%>>Tổng hợp</option>
		    	</select>
		    </td>
		  </tr>
		  <%if(listcqql.size()>1){%>
		  <tr>
		  		<td><label class ="egov-label-bold">Đơn vị</label></td>
		  		<td>
		  		<select name="id_donvi" id="id_donvi" class="egov-select" style="width: 300px">
		  			<option value="0" <%=id_donvi==0?"selected":""%>>-Chọn đơn vị-</option>
		  			<%
		  				for(int i=0;i<listcqql.size();i++){
		  			%>
		  				<option value="<%=listcqql.get(i).getId()%>" <%=Long.valueOf(id_donvi)==listcqql.get(i).getId()?"selected":""%>  ><%=listcqql.get(i).getTen()%></option>
		  			<%	}	%>
		  		</select>
		  		</td>
		  </tr>
		  <%}else{%>
		  <input type="hidden" name="id_donvi" value="<%=id_donvi%>"/>
		  <% }
		  
		  if(report_type.equals("lephichitiet") || report_type.equals("lephitonghop") ){
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
							 tthc = listTTHC.get(j);
							 if(listnhomtt.get(i).getId()==tthc.getNhomThuTucHanhChinhId()){
					%>
						<option value="<%= tthc.getId() %>" <%=id_loaihoso.contains(String.valueOf(tthc.getId()))?"selected":"" %>><%=tthc.getTen()%></option>
					<%	
							 }
						 }
					%>
						</optgroup>
					<%	}	%>
		    	</select>
		    </td>
		  </tr>
		  <%}else if(report_type.equals("lephilinhvuc")){ %>
		  <tr>
		    <td>
		    	<label class ="egov-label-bold">Lĩnh vực</label>
		    </td>
		    <td>
		    	<select name="id_linhvuc" id="id_linhvuc" class="egov-select" multiple="multiple" style="width: 300px">
	    			<%
						for (int i = 0; i < listnhomtt.size(); ++ i) {
					%>
						<option value="<%=listnhomtt.get(i).getId()%>"  <%=id_linhvuc.contains(String.valueOf(listnhomtt.get(i).getId()))?"selected":"" %>><%=listnhomtt.get(i).getTen()%></option>
					<%	} %>
		    	</select>
		    </td>
		  </tr>
		  <%}%>
		  <tr>
		    <td>
		    	<label class ="egov-label-bold">Ngày nhận</label>
		    </td>
		    <td>
		    	<label class ="egov-label">Từ ngày</label><input name="tungay" id="tungay" value="<%=ngaynhan_tungay%>" type="text" style="width:120px !important" class = "egov-calendar"/>
		    	<label class ="egov-label">Đến ngày</label><input name="denngay" id="denngay" value="<%=ngaynhan_denngay%>" type="text" style="width:120px !important" class = "egov-calendar"/>
		    </td>
		  </tr>
		  <tr>
		    <td>
		    	<label class ="egov-label-bold">Tháng</label>
		    </td>
		    <td>
		    	<input name = "selectedtime" value="01" <%=selectedtime.equals("01")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('01');"> 01 
			    <input name = "selectedtime" value="02" <%=selectedtime.equals("02")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('02');"> 02 
			    <input name = "selectedtime" value="03" <%=selectedtime.equals("03")?"checked":""%>class="egov-radio" type = "radio" onClick="thang_click('03');"> 03 
			    <input name = "selectedtime" value="04" <%=selectedtime.equals("04")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('04');"> 04 
			    <input name = "selectedtime" value="05" <%=selectedtime.equals("05")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('05');"> 05 
			    <input name = "selectedtime" value="06" <%=selectedtime.equals("06")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('06');"> 06 
			    <input name = "selectedtime" value="07" <%=selectedtime.equals("07")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('07');"> 07 
			    <input name = "selectedtime" value="08" <%=selectedtime.equals("08")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('08');"> 08 
			    <input name = "selectedtime" value="09" <%=selectedtime.equals("09")?"checked":""%> class="egov-radio" type = "radio" onClick="thang_click('09');"> 09 
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
		    	<input type="submit" id="btn-hienthi" value="Hiển thị"  class="egov-button" />
		    	<input type="button" id="btn-excel" class="egov-button" value="Xuất excel">
		    	<input type="button" id="btn-word" class="egov-button" value="Xuất word">
		    </td>
		  </tr>
		</table>
</div>
</div>		
	</form><br>
	<%
	if(newResults.size()>0){
		DecimalFormat myFormatter = new DecimalFormat("###,###.###");
	%>
	<table class="egov-table">
		<thead>
			<tr>
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
		</thead>
		<tbody>
		<%
		int i=0;
		int k=1;
		Long tong_lephi=0L;
		for (int j = 0; j <listnhomtt.size(); ++ j) {
			if(ActionUtil.checkHosoByNHOMTTHCID(listnhomtt.get(j).getId(),newResults)){
		%>
		<tr>
			<td colspan="10"><strong>&nbsp;<%=listnhomtt.get(j).getTen()%></strong></td>
		</tr>
		<%
		for(Lephi_chitiet lephi_chitiet : newResults) {
			if(listnhomtt.get(j).getId()==lephi_chitiet.getNHOMTHUTUCHANHCHINHID()){
				i++;
				tong_lephi += Long.valueOf(lephi_chitiet.getTONGLEPHI());
				if(k==3){
					k = 1;
				}
		%>
			<tr class="bgcolor-<%=k%>">
				<td style="text-align: center"><%=(searchContainer.getStart()+i)%></td>
				<td><%=lephi_chitiet.getTENHOSO()%></td>
				<td><%=lephi_chitiet.getNGUOINOP()%></td>
				<td><%=lephi_chitiet.getCHUHOSO()%></td>
				<td><%=lephi_chitiet.getDIACHI()%></td>
				<td style="text-align: center"><%=lephi_chitiet.getSOBOHOSO()%></td>
				<td style="text-align: right"><%=myFormatter.format(Long.valueOf(lephi_chitiet.getLEPHI()))%></td>
				<td style="text-align: right"><%=myFormatter.format(Long.valueOf(lephi_chitiet.getPHIHOSO()))%></td>
				<td style="text-align: right"><%=myFormatter.format(Long.valueOf(lephi_chitiet.getTONGLEPHI()))%></td>
				<td><%=lephi_chitiet.getGHICHU()%></td>
			</tr>
		<%k++;}}%>
		<%}}%>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="8" style="text-align: right"><strong>Tổng cộng:</strong></td>
				<td style="text-align: right"><strong><%=myFormatter.format(tong_lephi)%></strong></td>
				<td></td>
			</tr>
		</tfoot>
	</table>
	<div id = "pagination">
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
	</div>
	<%}%>
	
	<%
	if(newResultslv.size()>0){
		DecimalFormat myFormatter = new DecimalFormat("###,###.###");
	%>
	<table class="egov-table">
		<thead>
			<tr>
				<th>STT</th>
				<th>Lĩnh vực</th>
				<th>Tổng hồ sơ</th>
				<th>Lệ phí hồ sơ</th>
				<th>Phí hồ sơ</th>
				<th>Tổng lệ phí</th>
				<th>Ghi chú</th>
			</tr>
		</thead>
		<tbody>
		<%
		int i=0;
		int k=1;
		int tong_hoso =0;
		Long tong_lephihoso=0L;
		Long tong_phihoso=0L;
		Long tong_lephi=0L;
		for(Lephi_linhvuc lephi_linhvuc : newResultslv) {
			i++;
			tong_hoso += Integer.valueOf(lephi_linhvuc.getTONGHOSO());
			tong_lephihoso += Long.valueOf(lephi_linhvuc.getLEPHIHOSO());
			tong_phihoso += Long.valueOf(lephi_linhvuc.getPHIHOSO());
			tong_lephi += Long.valueOf(lephi_linhvuc.getTONGLEPHI());
			if(k==3){
				k = 1;
			}
		%>
			<tr class="bgcolor-<%=k%>">
				<td style="text-align: center"><%=(searchContainer.getStart()+i)%></td>
				<td><%=NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(lephi_linhvuc.getNHOMTHUTUCHANHCHINHID()).getTen()%></td>
				<td style="text-align: right"><%=lephi_linhvuc.getTONGHOSO()%></td>
				<td style="text-align: right"><%=myFormatter.format(Long.valueOf(lephi_linhvuc.getLEPHIHOSO()))%></td>
				<td style="text-align: right"><%=myFormatter.format(Long.valueOf(lephi_linhvuc.getPHIHOSO()))%></td>
				<td style="text-align: right"><%=myFormatter.format(Long.valueOf(lephi_linhvuc.getTONGLEPHI()))%></td>
				<td></td>
			</tr>
		<%k++;}%>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2" style="text-align: right"><strong>Tổng cộng:</strong></td>
				<td style="text-align: right"><strong><%=tong_hoso%></strong></td>
				<td style="text-align: right"><strong><%=myFormatter.format(tong_lephihoso)%></strong></td>
				<td style="text-align: right"><strong><%=myFormatter.format(tong_phihoso)%></strong></td>
				<td style="text-align: right"><strong><%=myFormatter.format(tong_lephi)%></strong></td>
				<td></td>
			</tr>
		</tfoot>
	</table>
	<div id = "pagination">
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
	</div>
	<%}%>
	
	<%
	if(newResultsth.size()>0){
		DecimalFormat myFormatter = new DecimalFormat("###,###.###");
	%>
	<table class="egov-table">
		<thead>
			<tr>
				<th>STT</th>
				<th>Lĩnh vực</th>
				<th>Tổng hồ sơ</th>
				<th>Lệ phí</th>
				<th>Phí hồ sơ</th>
				<th>Tổng lệ phí</th>
				<th>Ghi chú</th>
			</tr>
		</thead>
		<tbody>
		<%
		int i=0;
		int k=1;
		Long tong_lephi=0L;
		for (int j = 0; j <listnhomtt.size(); ++ j) {
			if(ActionUtil.checkLePhiTongHopByNHOMTTHCID(listnhomtt.get(j).getId(),newResultsth)){
		%>
		<tr>
			<td colspan="7"><strong>&nbsp;<%=listnhomtt.get(j).getTen()%></strong></td>
		</tr>
		<%
		for(Lephi_tonghop lephi_tonghop : newResultsth) {
			if(listnhomtt.get(j).getId()==lephi_tonghop.getNHOMTHUTUCHANHCHINHID()){
				i++;
				tong_lephi += Long.valueOf(lephi_tonghop.getTONGLEPHI());
				if(k==3){
					k = 1;
				}
		%>
			<tr class="bgcolor-<%=k%>">
				<td style="text-align: center"><%=(searchContainer.getStart()+i)%></td>
				<td style="text-align: left">Tháng <%=lephi_tonghop.getTHANGNHAN()%></td>
				<td style="text-align: right"><%=lephi_tonghop.getTONGHOSO()%></td>
				<td style="text-align: right"><%=myFormatter.format(Long.valueOf(lephi_tonghop.getLEPHI()))%></td>
				<td style="text-align: right"><%=myFormatter.format(Long.valueOf(lephi_tonghop.getPHIHOSO()))%></td>
				<td style="text-align: right"><%=myFormatter.format(Long.valueOf(lephi_tonghop.getTONGLEPHI()))%></td>
				<td></td>
			</tr>
		<%k++;}}%>
		<%}}%>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5" style="text-align: right"><strong>Tổng cộng:</strong></td>
				<td style="text-align: right"><strong><%=myFormatter.format(tong_lephi)%></strong></td>
				<td></td>
			</tr>
		</tfoot>
	</table>
	<div id = "pagination">
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
	</div>
	<%}%>
	<%if(newResults.size()==0 && newResultslv.size()==0 && newResultsth.size()==0 && display_result.equals("1") ){%>
	<center><strong>KHÔNG TÌM THẤY DỮ LIỆU TRONG HỆ THỐNG !</strong></center>
	<%}%>
</div>
<portlet:resourceURL escapeXml="false" var="exportExcel">
</portlet:resourceURL>
<script type="text/javascript">
$(function(){
	$("#id_loaihoso").multiselect({ selectedText: "đã chọn # loại hồ sơ"});
	$("#id_linhvuc").multiselect({ selectedText: "đã chọn # lĩnh vực"});
	
	$('#tungay').blur(function(){
		  re = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
		  if(this.value != '' && !this.value.match(re)) {
		    alert("Ngày sai định dạng: " + this.value  + "\n" + "Định dạng đúng: ngày/tháng/năm    vd: 01/12/2014");
		    this.value="";
		    this.focus();
		    return false;
		  }
		  if(this.value==''){
			  this.focus();
		  }
	});

	$('#denngay').blur(function(){
		  re = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
		  if(this.value != '' && !this.value.match(re)) {
		    alert("Ngày sai định dạng: " + this.value  + "\n" + "Định dạng đúng: ngày/tháng/năm    vd: 01/12/2014");
		    this.value="";
		    this.focus();
		    return false;
		  }
		  if(this.value==''){
			  this.focus();
		  }
	});
	
	$('#report_type').change(function(){
		$('#display_result').val('0');
		document.baocaolephiForm.submit();
	});
	
	$('#id_donvi').change(function(){
		$('#display_result').val('0');
		document.baocaolephiForm.submit();
	});
	
	$('#btn-hienthi').click(function(){
		$('#display_result').val('1');
	});
	
	jQuery("#btn-excel").click(function(){
		var url = '<%=exportExcel.toString()%>';
		var report_type = $('#report_type').val();
		url+='&report_type='+report_type;
		url+='&tungay='+$('#tungay').val();
		url+='&denngay='+$('#denngay').val();
		url+='&coQuanQuanLyId=<%=congchuc!=null?congchuc.getCoQuanQuanLyId():0%>'
		if(report_type=='lephichitiet' || report_type=='lephitonghop' ){
		url+='&id_loaihoso='+$('#id_loaihoso').val();
		}else{
		url+='&id_linhvuc='+$('#id_linhvuc').val();
		}
	    window.location = url;
	});
	
	jQuery("#btn-word").click(function(){
		var url = '<%=request.getContextPath()%>/html/portlet/report/lephi/word.jsp?';
		var report_type = $('#report_type').val();
		url+='&report_type='+report_type;
		url+='&tungay='+$('#tungay').val();
		url+='&denngay='+$('#denngay').val();
		url+='&coQuanQuanLyId=<%=congchuc!=null?congchuc.getCoQuanQuanLyId():0%>'
		if(report_type=='lephichitiet' || report_type=='lephitonghop' ){
		url+='&id_loaihoso='+$('#id_loaihoso').val();
		}else{
		url+='&id_linhvuc='+$('#id_linhvuc').val();
		}
		window.location = url;
	});
});
function thang_click(month){	
	var nam = document.baocaolephiForm.elements["nam"].value;	
	document.baocaolephiForm.elements["tungay"].value='';
	document.baocaolephiForm.elements["tungay"].value = "01/" + month + "/" + jQuery('#nam').val();	
	var maxdate = getDaysOfMonth(nam,month);	
	document.baocaolephiForm.elements["denngay"].value = maxdate + "/" + month + "/" + jQuery('#nam').val();;
	
}	
function getDaysOfMonth(year, month) {	
	return new Date(year, month, 0).getDate();
}
function resetDate() {
	document.baocaolephiForm.elements["tungay"].value = "01/01/" + jQuery('#nam').val();
	jQuery("#baocaolephiForm input[name='selectedtime']").attr('checked',false);
	document.baocaolephiForm.elements["denngay"].value = "31/12/" + jQuery('#nam').val();
}
	
function qui_click(quarter){
	var nam = document.baocaolephiForm.elements["nam"].value;
	var minmonth = (quarter-1)*3 + 1;
	var mindate = 	"01/" + minmonth + "/" + jQuery('#nam').val();	
	if ( minmonth < 10)	
		mindate = "01/" + "0" + minmonth + "/" + jQuery('#nam').val();
	document.baocaolephiForm.elements["tungay"].value = mindate;		
	if(quarter == 1)
		document.baocaolephiForm.elements["denngay"].value = "31/03/" + jQuery('#nam').val();
	if(quarter == 2)
		document.baocaolephiForm.elements["denngay"].value = "30/06/" + jQuery('#nam').val();
	if(quarter == 3)
		document.baocaolephiForm.elements["denngay"].value = "30/09/" + jQuery('#nam').val();
	if(quarter == 4)
		document.baocaolephiForm.elements["denngay"].value = "31/12/" + jQuery('#nam').val();		
}
</script>