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
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="org.oep.cmon.dao.nsd.model.impl.TaiKhoanNguoiDungImpl"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.report.portlet.util.ActionUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.report.service.BaocaochitietLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DonViHanhChinh"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="org.oep.cmon.dao.report.service.BaocaochitietLocalService"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="org.oep.cmon.dao.report.model.Baocaochitiet"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.bi.rules.Query"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page contentType="text/html; charset=UTF-8"%>
<liferay-theme:defineObjects />
<portlet:defineObjects />
	<%
	/*lay thong tin tu action truyen xuong*/
	int idBaoCao = 0;
	String viewPage = "";
	long id_donvi = 0;
	String[] loaihoso = null;
	String[] linhvuc_hoso = null;
	String ngaynhan_tungay = "";
	String ngaynhan_denngay = "";
	String trang_thai = "";
	String time ="";
	String nam_select="";
	String tinhtrang="";
	String loaidangky="";
	
	Calendar cal = Calendar.getInstance();
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat yf = new SimpleDateFormat("yyyy");
	TimeZone timeZ = TimeZone.getTimeZone("GMT+7");
	df.setTimeZone(timeZ);
	yf.setTimeZone(timeZ);
	Date timenow = cal.getTime();
	String today = df.format(timenow);
	String nam_ht =yf.format(timenow);
	if(Validator.isNotNull(request.getParameter("idBaoCao"))){
		idBaoCao = Integer.valueOf(request.getParameter("idBaoCao").toString());
	}
	if(Validator.isNotNull(request.getParameter("viewPage"))){
		viewPage = request.getParameter("viewPage").toString();
	}
	
	if(Validator.isNotNull(renderRequest.getAttribute("loaihoso"))){
		loaihoso =(String[]) request.getAttribute("loaihoso");
	}
	
	if(Validator.isNotNull(renderRequest.getAttribute("linhvuc_hoso"))){
		linhvuc_hoso =(String[]) request.getAttribute("linhvuc_hoso");
	}
	
	if(Validator.isNotNull(renderRequest.getAttribute("ngaynhan_tungay"))){
		ngaynhan_tungay = (String) request.getAttribute("ngaynhan_tungay");
	}
	
	if(Validator.isNotNull(request.getAttribute("id_donvi"))){
		id_donvi = Long.parseLong(request.getAttribute("id_donvi").toString());
	}
	
	if(Validator.isNotNull(renderRequest.getAttribute("ngaynhan_denngay"))){
		ngaynhan_denngay = (String) request.getAttribute("ngaynhan_denngay");
	}
	
	if(Validator.isNotNull(renderRequest.getAttribute("trangthai"))){
		trang_thai = (String) request.getAttribute("trangthai");
	}
	
	if(Validator.isNotNull(renderRequest.getAttribute("time"))){
		time = (String) renderRequest.getAttribute("time");
	}
	
	if(Validator.isNotNull(renderRequest.getAttribute("year"))){
		nam_select = (String) request.getAttribute("year");
	}
	
	if(Validator.isNotNull(request.getAttribute("tinhtrang"))){
		tinhtrang =(String) request.getAttribute("tinhtrang");
	}
	
	if(Validator.isNotNull(request.getAttribute("loaidangky"))){
		loaidangky =(String) request.getAttribute("loaidangky");
	}
	/*ket thuc viec lay thong tin tu action*/
	
	
	//lay du lieu cho phan trang
	List<Baocaochitiet>	result = new ArrayList<Baocaochitiet>();
	if(Validator.isNotNull(renderRequest.getAttribute("listBaocao"))){
		result = (List<Baocaochitiet>) request.getAttribute("listBaocao");
	}
	if( result == null ) {
		 result = new ArrayList<Baocaochitiet>();
	}
	String linhvuc_hoso_tmpl = "";
	if ( Validator.isNotNull(renderRequest.getParameter("linhvuc_hoso")) ) {
		linhvuc_hoso_tmpl = renderRequest.getParameter("linhvuc_hoso");
		String str_linhvuc = linhvuc_hoso_tmpl.substring(1,linhvuc_hoso_tmpl.length()-1);
		linhvuc_hoso = str_linhvuc.split(",");
		for(int i=0;i<linhvuc_hoso.length; i++){
			linhvuc_hoso[i] = linhvuc_hoso[i].trim();
		}
	}
	String loai_hoso_tmpl = "";
	if ( Validator.isNotNull(renderRequest.getParameter("loai_hoso")) ) {
		loai_hoso_tmpl = renderRequest.getParameter("loai_hoso");
		String str_loaihoso = loai_hoso_tmpl.substring(1,loai_hoso_tmpl.length()-1);
		loaihoso = str_loaihoso.split(",");
		for(int i=0;i<loaihoso.length; i++){
			loaihoso[i] = loaihoso[i].trim();
		}

	}
	if ( Validator.isNotNull(renderRequest.getParameter("ngaynhan_tungay_")) ) {
		ngaynhan_tungay = renderRequest.getParameter("ngaynhan_tungay_");
	}
	if ( Validator.isNotNull(renderRequest.getParameter("ngaynhan_denngay_")) ) {
		ngaynhan_denngay = renderRequest.getParameter("ngaynhan_denngay_");
		//
	}
	if ( Validator.isNotNull(renderRequest.getParameter("trang_thai")) ) {
		trang_thai = renderRequest.getParameter("trang_thai");
	}
	String search_flag = "";
	if(Validator.isNotNull(renderRequest.getParameter("search_result"))){
		search_flag = renderRequest.getParameter("search_result");
	}
	if(Validator.isNotNull(renderRequest.getParameter("time"))){
		time = renderRequest.getParameter("time");
	}
	if(Validator.isNotNull(renderRequest.getParameter("tinhtrang"))){
		tinhtrang = renderRequest.getParameter("tinhtrang");
	}
	if(Validator.isNotNull(renderRequest.getParameter("id_donvi"))){
		id_donvi = Long.parseLong( renderRequest.getParameter("id_donvi"));
	}
	if(Validator.isNotNull(renderRequest.getParameter("loaidangky"))){
		loaidangky = renderRequest.getParameter("loaidangky");
	}

	if(search_flag.equals("search_")){
		result = BaocaochitietLocalServiceUtil.hienthiDanhsachBaocao(loaihoso, ngaynhan_tungay, ngaynhan_denngay, trang_thai, tinhtrang, loaidangky, QueryUtil.ALL_POS,QueryUtil.ALL_POS);
	}
		//	
	

	PortletURL hienthiURL = renderResponse.createActionURL();
	hienthiURL.setParameter(ActionRequest.ACTION_NAME, "baocaoChiTiet");
	
	
	
	List<CoQuanQuanLy> listCoquan = new ArrayList<CoQuanQuanLy>();
	List<NhomThuTucHanhChinh> listNhomThuTuc = new ArrayList<NhomThuTucHanhChinh>();
	List<ThuTucHanhChinh> listthutuc = new ArrayList<ThuTucHanhChinh>();
	TaiKhoanNguoiDung loginUser = new TaiKhoanNguoiDungImpl();
	CongChuc congChuc = new CongChucImpl();
	if(themeDisplay.isSignedIn()){
		boolean test = false;
		loginUser = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(PortalUtil.getUserId(request));
		if(loginUser!=null){
			test = ActionUtil.testReportPermission(loginUser.getId(),idBaoCao);
			listCoquan = ActionUtil.getCoquanquanly(test,loginUser.getId(),idBaoCao);
			if(id_donvi==0&&listCoquan.size()!=0){
				id_donvi = listCoquan.get(0).getId();
			}
			if(id_donvi!=0){
				listNhomThuTuc= ActionUtil.getNhomTTHC(test,loginUser.getId(),idBaoCao,id_donvi);
				listthutuc = ActionUtil.getTTHC(test,loginUser.getId(),idBaoCao,id_donvi);
			}
		}
	}
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/html/portlet/report/view.jsp");
	iteratorUrl.setParameter("ngaynhan_tungay_", ngaynhan_tungay);
	iteratorUrl.setParameter("ngaynhan_denngay_", ngaynhan_denngay);
	iteratorUrl.setParameter("trang_thai", trang_thai);
	iteratorUrl.setParameter("time",time);
	iteratorUrl.setParameter("loai_hoso",Arrays.toString(loaihoso));
	iteratorUrl.setParameter("year",nam_select);
	iteratorUrl.setParameter("id_donvi",String.valueOf(id_donvi));
	iteratorUrl.setParameter("tinhtrang",tinhtrang);
	iteratorUrl.setParameter("loaidangky",loaidangky);
	iteratorUrl.setParameter("idBaoCao",String.valueOf(idBaoCao));
	iteratorUrl.setParameter("viewPage",viewPage);
	iteratorUrl.setParameter("search_result", "search_");
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, iteratorUrl, null, "");
	if(result==null){
		result = new ArrayList<Baocaochitiet>();
	}
	List<Baocaochitiet> newResults = ListUtil.subList(result, searchContainer.getStart(), searchContainer.getEnd());
	searchContainer.setTotal(result.size());
	searchContainer.setResults(newResults);

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
	<form action="<%=hienthiURL.toString()%>" method="post" name="frmTieuchi" id="frmTieuchi">
		<input type="hidden" name="idBaoCao" value="<%=idBaoCao%>"/>
		<input type="hidden" name="viewPage" value="<%=viewPage%>"/>
		<input type="hidden" name="display_result" id="display_result">
<div class="report_outer">  
    <div class="report_inner">		
		<table class="egov-table-form" width="100%">
			<caption>
		  	<label class="egov-label-header">
		  		BÁO CÁO CHI TIẾT TÌNH HÌNH GIẢI QUYẾT HỒ SƠ
		  	</label>
		  </caption>
		  <%if(listCoquan.size()>1){%>
		  <tr>
		  	<td style="width: 100px; text-align:right; vertical-align: middle; padding-right:5px;">
		  		<label class ="egov-label-bold">Đơn vị</label>
		  	</td>
		  	<td>
		  		<select id="chon_donvi" name="chon_donvi" class="egov-select" style="width: 300px">
		  			<option value="0" <%=id_donvi==0?"selected":""%>>-Chọn đơn vị-</option>
		  			<%
		  				for(int coquan_i = 0; coquan_i<listCoquan.size();coquan_i++){
		  					String selected = "";
							if(id_donvi != 0){
								if(listCoquan.get(coquan_i).getId() == id_donvi){
									selected = "selected";
								}
							}
		  			%>
		  				<option value="<%=listCoquan.get(coquan_i).getId()%>" <%=selected%>><c:out value="<%=listCoquan.get(coquan_i).getTen()%>"/></option>
		  			<%}%>
		  		</select>
		  	</td>
		  </tr>
		    <%}else{%>
		  	<input type="hidden" name="chon_donvi" value="<%=id_donvi%>"/>
		  <%}%>
		  <tr>
		    <td style="width: 100px; text-align:right; vertical-align: middle; padding-right:5px;">
		    	<label class ="egov-label-bold">Loại hồ sơ</label>
		    </td>
		    <td>
		    	<select id="chon_hoso" title="Chọn loại hồ sơ" multiple="multiple" name="loai-hoso" style="width: 300px">
					<%
					
					for(int optgroup = 0; optgroup < listNhomThuTuc.size(); optgroup++){
					%>
					<optgroup label="<c:out value='<%=listNhomThuTuc.get(optgroup).getTen()%>'/>">
						<%
						for(int option = 0; option<listthutuc.size();option++){
							if(listthutuc.get(option).getNhomThuTucHanhChinhId() == listNhomThuTuc.get(optgroup).getId()){
							String selected_loaihoso = "";
							if(loaihoso != null){
								for(int kt_select = 0; kt_select < loaihoso.length;kt_select++){
									if(listthutuc.get(option).getId() == Long.parseLong(loaihoso[kt_select])){
										selected_loaihoso = "selected";
									}
								}
							}
						%>
							<option value="<%=listthutuc.get(option).getId()%>" <%=selected_loaihoso%>><c:out value="<%= listthutuc.get(option).getTen()%>"/></option>
						<%}}%>			
					</optgroup>
					<%}%>	
				</select>
		    </td>
		  </tr>
		   <tr>
		    <td style="text-align:right; vertical-align: middle; padding-right:5px;">
		    	<label class ="egov-label-bold">Ngày nhận</label>
		    </td>
		    <td>
		    	<label class ="egov-label">Từ ngày&ensp;</label><input id="ngaynhan_tungay" name="ngaynhan_tungay" class="egov-calendar validate" type="test" style="width:120px !important" value="<%if(ngaynhan_tungay.equals("")){out.print("01/01/"+nam_ht);}else{out.print(ngaynhan_tungay);}%>">
		    	<label class ="egov-label">Đến ngày&ensp;</label><input id="ngaynhan_denngay" name="ngaynhan_denngay" class="egov-calendar validate" type="test" style="width:120px !important" value="<%if(ngaynhan_denngay.equals("")){out.print(today);}else{out.print(ngaynhan_denngay);}%>"> 
		    </td>
		  </tr>
		  <tr>
		    <td style="text-align:right; vertical-align: middle; padding-right:5px;">
		    	<label class ="egov-label-bold">Tháng</label>
		    </td>
		    <td>
		    	<div class="radio_box">
		    		<%for(int thang=1;thang<=12;thang++){%>
		    			<input class="egov-radio time" type="radio" name="time" value="<%=thang%>"  <%if(!time.equals("") && time.length()<=2){if(thang==Integer.parseInt(time)){out.print("checked");}}%>><%=thang%>&ensp;
		    		<%}%>
		    	</div>
		    </td>
		  </tr>
		  <tr>
		    <td style="text-align:right; vertical-align: middle; padding-right:5px;">
		    	<label class ="egov-label-bold">Quý</label>
		    </td>
		    <td>
		    	<div class="radio_box">
					<input class="egov-radio time" type="radio" name="time" value="quy1" <%if(time.equals("quy1")){out.print("checked");} %>>I&ensp;
					<input class="egov-radio time" type="radio" name="time" value="quy2" <%if(time.equals("quy2")){out.print("checked");} %>>II&ensp;
					<input class="egov-radio time" type="radio" name="time" value="quy3" <%if(time.equals("quy3")){out.print("checked");} %>>III&ensp;
					<input class="egov-radio time" type="radio" name="time" value="quy4" <%if(time.equals("quy4")){out.print("checked");} %>>IV&ensp;
				</div>
		    </td>
		  </tr>
		  <tr>
		    <td style="text-align:right; vertical-align: middle; padding-right:5px;">
		    	<label class ="egov-label-bold">Năm</label>
		    </td>
		    <td>
		    	<select name="nam" id="nam" class="egov-select" style="width: 100px">
		    	<option value="0" <%if(nam_select.equals("0")){out.print("selected");}%>>Tất cả</option>
		    	<%
		    	Calendar dateTime = new GregorianCalendar();
		    	int year = dateTime.get(Calendar.YEAR);
		    		
		    		for(int i_nam = year;i_nam >= 2012;i_nam--)
		    		{
		    			if(nam_select.equals("") && i_nam == 2014){
		    				%>
		    				<option value="<%=i_nam%>" selected><%=i_nam%></option>
		    				
		    			<%i_nam--;}else if(!nam_select.equals("") && i_nam == Integer.parseInt(nam_select)){%>
		    				<option value="<%=i_nam%>" selected><%=i_nam%></option>
		    			<%i_nam--;}%>
		    		<option value="<%=i_nam%>"<%if(!nam_select.equals("") && !nam_select.equals("0") && Integer.parseInt(nam_select) == i_nam){out.print("selected");}%>><%=i_nam%></option>
		    	<%}%>
		    	</select>
		    </td>
		  </tr>
		  <tr>
		    <td style="text-align:right; vertical-align: middle; padding-right:5px;">
		    	<label class ="egov-label-bold">Trạng thái</label>
		    </td>
		    <td>
		    	<select id="trangthai_hoso" name="trangthai_hoso" class="egov-select" name="trangthai_hoso" style="width:200px;">
					<option value="" selected>Tất cả</option>
					<%
					List<TrangThaiHoSo> listTrangthai = TrangThaiHoSoLocalServiceUtil.getTrangThaiHoSos(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
						int j = 1;
						for(TrangThaiHoSo trangthai_id:listTrangthai){
							String selected = "";
							if(trang_thai != ""){
								if(trangthai_id.getId() == Long.valueOf(trang_thai.trim())){
									selected = "selected";
								}
							}
					%>
						<option value="<%=trangthai_id.getId()%>" <%=selected%>> <%=j%> - <%=trangthai_id.getTrangThai()%></option>
					<%j++;}%>
				</select>
		    </td>
		  </tr>
		  <tr>
		  	<td style="text-align:right; vertical-align: middle; padding-right:5px;">
		  		<label class ="egov-label-bold">Tình trạng</label>
		  	</td>
		  	<td>
		    	<select name="tinhtrang_hoso" id="tinhtrang_hoso" class="egov-select" style="width: 200px">
		    		<option value="" <%if(tinhtrang.equals("")){out.print("selected");}%>>Tất cả</option>
		    		<option value="0" <%if(tinhtrang.equals("0")){out.print("selected");}%>>Hồ sơ đúng hẹn</option>
		    		<option value="1" <%if(tinhtrang.equals("1")){out.print("selected");}%>>Hồ sơ sớm</option>
		    		<option value="2" <%if(tinhtrang.equals("2")){out.print("selected");}%>>Hồ sơ trể hẹn</option>
		    	</select>
		    </td>
		  </tr>
		  <tr>
		  	<td style="text-align:right; vertical-align: middle; padding-right:5px;">
		  		<label class ="egov-label-bold">Loại đăng ký</label>
		  	</td>
		  	<td>
		    	<select name="loaidangky_hoso" id="loaidangky_hoso" class="egov-select" style="width: 200px">
		    		<option value="" <%if(loaidangky.equals("")){out.print("selected");}%>>Tất cả</option>
		    		<option value="<%=org.oep.cmon.Constants.LOAI_HO_SO_TRUC_TIEP%>" <%if(loaidangky.equals(String.valueOf(org.oep.cmon.Constants.LOAI_HO_SO_TRUC_TIEP))){out.print("selected");}%>>Hồ sơ trực tiếp</option>
		    		<option value="<%=org.oep.cmon.Constants.LOAI_HO_SO_TRUC_TUYEN%>" <%if(loaidangky.equals(String.valueOf(org.oep.cmon.Constants.LOAI_HO_SO_TRUC_TUYEN))){out.print("selected");}%>>Hồ sơ online</option>
		    	</select>
		    </td>
		  </tr>
		  <tr>
		    <td colspan="2" style="text-align:center">
		   		<input type="submit" id="btn-hienthi" value="Hiển thị" class="egov-button"/>
		   		<input type="button" id="btn-excel" class="egov-button" value="Xuất excel"/>
				<input type="button" id="btn-word" class="egov-button" value="Xuất word"/>
		    </td>
		  </tr>
		</table>
</div>
</div>		
	</form>
	<br/>
	<br/>
	
	<%
	if(newResults.size()>0){
		int t=0;
		int k=1;
		long linhvucId = 0L;
	%>
	<table class="egov-table">
		<thead>
			<tr>
				<th>STT</th>
				<th style="text-align:center">Tên hồ sơ</th>
				<th style="text-align:center">Số hồ sơ</th>
				<th>Trạng thái</th>
				<th>Địa chỉ</th>
				<th>Điện thoại</th>
				<th>Người nộp<br/> hồ sơ</th>
				<th>Chủ hồ sơ</th>
				<th>Ngày nhận</th>
				<th>Ngày hẹn trả</th>
				<th>Tình trạng<br> hồ sơ</th>
				<th>Ghi chú</th>
			</tr>
		</thead>
		<tbody>
	<%
		
		for(Baocaochitiet baocao : newResults){
			t++;
			if (linhvucId != baocao.getLINHVUCID()) {
				linhvucId = baocao.getLINHVUCID();
	%>
				<tr><td colspan="12" align="center" style="padding:4px 0 4px 10px"><h3>Lĩnh vực&ensp;-&ensp;<%=NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(linhvucId).getTen()%></h3></td></tr>
			<%}
			if(k==3){
				k=1;
			}
			if(baocao.getLINHVUCID() == linhvucId){
				String tinh_trang = "";
				if(Validator.isNotNull(baocao.getNGAYTRAKETQUA()) && Validator.isNotNull(baocao.getNGAYHENTRAKETQUA())){
					Date ngaytra = df.parse(baocao.getNGAYTRAKETQUA());
					Date ngayhentra = df.parse(baocao.getNGAYHENTRAKETQUA());
					if(ngaytra.before(ngayhentra)){
						tinh_trang = "Sớm hẹn";
					}else if(ngaytra.equals(ngayhentra)){
						tinh_trang ="Đúng hẹn";
					}else if(ngaytra.after(ngayhentra)){
						tinh_trang ="Trễ hẹn";
					}
				}
			%>
				<tr class="bgcolor-<%=k%>">
					<td style="text-align:center"><%=searchContainer.getStart()+t%></td>
					<td class="text-left" style="padding:4px 10px;"><p style="min-width:150px;"><%=baocao.getTEN()%></p></td>
					<td class="text-left" style="padding:4px 10px;"><p><%=baocao.getMASOHOSO()%></p></td>
					<td class="text-left" style="padding:4px 10px;"><p><%=baocao.getTRANGTHAI()%></p></td>
					<td class="text-left" style="padding:4px 10px;"><p><%=baocao.getDIACHIHIENNAY()%></p></td>
					<td class="text-left" style="padding:4px 10px;"><p><%=baocao.getDIENTHOAIDIDONG()%></p></td>
					<td class="text-left" style="padding:4px 10px;"><p style="max-width:60px;"><%=baocao.getHOTENNGUOINOPHOSO()%></p></td>
					<td class="text-left" style="padding:4px 10px;"><p><%=baocao.getNGUOIDAIDIENPHAPLUAT()%></p></td>
					<td class="text-left" style="padding:4px 10px;"><p><%=baocao.getNGAYNHANHOSO()%></p></td>
					<td class="text-left" style="padding:4px 10px;"><p><%=baocao.getNGAYTRAKETQUA()%></p></td>
					<td class="text-left" style="padding:4px 10px;"><p><%=tinh_trang%></p></td>
					<td class="text-left" style="padding:4px 10px;"><p><%=baocao.getGHICHU()%></p></td>
				</tr>
			<%}k++;}%>			
		</tbody>
	</table>
	<div id="pagination">
		<liferay-ui:search-paginator searchContainer="<%=searchContainer%>"/>
	</div>
	<%}else{%>
		<div>
			<h3>KHÔNG TÌM THẤY DỮ LIỆU TRONG HỆ THỐNG</h3>
		</div>
	<%}%>
	
</div>
<portlet:resourceURL escapeXml="false" var="exportBaocaochitietExcel">
	<portlet:param name="report_type" value="chitiet"></portlet:param>
</portlet:resourceURL>
<portlet:resourceURL escapeXml="false" var="exportBaocaochitietPdf">
	<portlet:param name="reportBaocaoType" value="pdf"></portlet:param>
</portlet:resourceURL>
<script type="text/javascript">
		$(document).ready(function(){
			
			$("#chon_hoso").multiselect({
				noneSelectedText:"Vui lòng chọn",
			});
			
			/* export word button*/
			$("#btn-word").click(function(){
				 var url = '<%=request.getContextPath()%>/html/portlet/report/chitiet/word.jsp?';
				url +="&chon_hoso="+$('#chon_hoso').val();
			  	url +="&ngaynhan_tungay="+$('#ngaynhan_tungay').val();
			  	url +="&ngaynhan_denngay="+$('#ngaynhan_denngay').val();
			  	url +="&trangthai_hoso="+$('#trangthai_hoso').val();
			  	url +="&tinhtrang_hoso="+$('#tinhtrang_hoso').val();
			  	url +="&loaidangky_hoso="+$('#loaidangky_hoso').val();
			  	url +="&chon_donvi="+$('#chon_donvi').find('option:selected').text();
			  	window.location = url;
			});
			
			/* export excel button*/
			$("#btn-excel").click(function(){
				  var url = '<%=exportBaocaochitietExcel.toString()%>';
				  url +="&chon_hoso="+$('#chon_hoso').val();
				  url +="&ngaynhan_tungay="+$('#ngaynhan_tungay').val();
				  url +="&ngaynhan_denngay="+$('#ngaynhan_denngay').val();
				  url +="&trangthai_hoso="+$('#trangthai_hoso').val();
				  url +="&tinhtrang_hoso="+$('#tinhtrang_hoso').val();
				  url +="&loaidangky_hoso="+$('#loaidangky_hoso').val();
				  url +="&chon_donvi="+$('#chon_donvi').find('option:selected').text();
				     //$("#btn-excel").attr('href',url);
				  //alert(url);
				  window.location = url;
				  
			});
			/*export PDF button*/
	
			/*Validate time */
			$('#ngaynhan_tungay').change(function(){
				var date = $(this).val();
				if(isValidDate(date) == false){
					alert("Hãy nhập ngày đúng định dạng dd/mm/yyyy!");
					$('#ngaynhan_tungay').val("");
				}
			});
			$('#ngaynhan_denngay').change(function(){
				var date = $(this).val();
				if(isValidDate(date) == false){
					alert("Ngày tháng không đúng. xin vui lòng nhập lại!!");
					$('#ngaynhan_denngay').val("");
				}
			});
			/* radio button event*/
			$('.time').change(function(){
				$('#ngaynhan_tungay').val('<%=ngaynhan_tungay%>');
				$('#ngaynhan_denngay').val('<%=ngaynhan_denngay%>');
				var nam_select =$("#nam").val();
				var now = new Date();
				if(nam_select == null || nam_select ==""){
					nam_select = now.getFullYear();
				}
				time_select = $('input[name=time]:checked', '#frmTieuchi').val();
				if(time_select == 'quy1'){
					var ngaynhan_tungay = '01/01/'+nam_select;
					var cuoithang = getDaysOfMonth(nam_select,3);
					var ngaynhan_denngay = cuoithang+'/03/'+nam_select;
					//alert("test---ngaynhan_tungay--:"+ngaynhan_tungay+"--ngay nhan_denngay--"+ngaynhan_denngay);
					$("#ngaynhan_tungay").datepicker('setDate',ngaynhan_tungay);
					$("#ngaynhan_denngay").datepicker('setDate',ngaynhan_denngay);
				}else if(time_select == 'quy2'){
					var ngaynhan_tungay = '01/04/'+nam_select;
					var cuoithang = getDaysOfMonth(nam_select,6);
					var ngaynhan_denngay = cuoithang+'/06/'+nam_select;
					//alert("test---ngaynhan_tungay--:"+ngaynhan_tungay+"--ngay nhan_denngay--"+ngaynhan_denngay);
					$("#ngaynhan_tungay").datepicker('setDate',ngaynhan_tungay);
					$("#ngaynhan_denngay").datepicker('setDate',ngaynhan_denngay);
				}else if(time_select == 'quy3'){
					var ngaynhan_tungay = '01/07/'+nam_select;
					var cuoithang = getDaysOfMonth(nam_select,9);
					var ngaynhan_denngay = cuoithang+'/09/'+nam_select;
					//alert("test---ngaynhan_tungay--:"+ngaynhan_tungay+"--ngay nhan_denngay--"+ngaynhan_denngay);
					$("#ngaynhan_tungay").datepicker('setDate',ngaynhan_tungay);
					$("#ngaynhan_denngay").datepicker('setDate',ngaynhan_denngay);
				}else if(time_select == 'quy4'){
					var ngaynhan_tungay = '01/10/'+nam_select;
					var cuoithang = getDaysOfMonth(nam_select,6);
					var ngaynhan_denngay = cuoithang+'/12/'+nam_select;
					//alert("test---ngaynhan_tungay--:"+ngaynhan_tungay+"--ngay nhan_denngay--"+ngaynhan_denngay);
					$("#ngaynhan_tungay").datepicker('setDate',ngaynhan_tungay);
					$("#ngaynhan_denngay").datepicker('setDate',ngaynhan_denngay);
				}else{
					var ngaynhan_tungay= '01/'+time_select+'/'+nam_select;//set ngày bắt đầu của tháng
					var songayOfthang = getDaysOfMonth(nam_select, time_select);
					var ngaynhan_denngay= songayOfthang+'/'+time_select+'/'+nam_select;
					$("#ngaynhan_tungay").datepicker('setDate',ngaynhan_tungay);
					$("#ngaynhan_denngay").datepicker('setDate',ngaynhan_denngay);
				}
				
			});
				
			/*selectbox nam action*/
			$('#nam').change(function(){
				var now = new Date();
				var ngaynhan_tungay = $('#ngaynhan_tungay').val();
				var ngaynhan_denngay = $('#ngaynhan_denngay').val();
				var nam_select = $('#nam').val();
				if(nam_select == "0" || nam_select == null){
					$("#ngaynhan_tungay").val("");
					$("#ngaynhan_denngay").val("");
					$('.time').prop('checked',false);
				}else{
					ngaynhan_tungay = '01/01/'+nam_select;
					var songayOfthang = getDaysOfMonth(nam_select,12);
					ngaynhan_denngay = songayOfthang+'/12/'+nam_select;
					$("#ngaynhan_tungay").datepicker('setDate',ngaynhan_tungay);
					$("#ngaynhan_denngay").datepicker('setDate',ngaynhan_denngay);
				}

				/*alert("test ----:ngay nhan tu ngay:--"+ngaynhan_tungay+"-----:ngay nhan den ngay:----"+ngaynhan_denngay+"---:nam select:----"+nam_select);*/
			});
			
			$('#chon_donvi').change(function(){
					var Coquanid = $('#chon_donvi option:selected').val();
					$('#chon_hoso').find('option').remove().end();
					$('#display_result').val('0');
					$('#frmTieuchi').submit();
			});
			
			$('#btn-hienthi').click(function(){
				$('#display_result').val('1');
			});
			
	
			/*function tim ngay cuoi cua thang va function tinh ngay trong quy*/
			function getDaysOfMonth(year, month) { 
			    return new Date(year, month, 0).getDate(); 
			}
			function isValidDate(dateString)
			{
			    if(!/^\d{1,2}\/\d{1,2}\/\d{4}$/.test(dateString))
			        return false;
			    var parts = dateString.split("/");
			    var day = parseInt(parts[0], 10);
			    var month = parseInt(parts[1], 10);
			    var year = parseInt(parts[2], 10);

			  
			    if(year < 1000 || year > 3000 || month == 0 || month > 12)
			        return false;

			    var monthLength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

			    
			    if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)){
			        monthLength[1] = 29;
			    	if(month == 2 && day != 29){
			    		return false;
			    	}
			    }
			   
			    if(day < 0 && day > monthLength[month - 1])
			    	return false;
			};
		});
	</script>

