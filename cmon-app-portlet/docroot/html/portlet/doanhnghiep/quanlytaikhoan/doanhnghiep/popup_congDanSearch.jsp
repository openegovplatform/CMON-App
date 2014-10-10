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
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ include file="/html/portlet/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.utils.FormatUtils"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@page import="org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.business.CongDanBusiness"%>
<%@page import="org.oep.cmon.portlet.doanhnghiep.quanlytaikhoan.utils.QuanLyTKConstants"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<style>
	.cssTable th 
	{
	    text-align:center; 	    
	}
	.searchForm
	{
		margin-bottom: 10pt;
		margin-top: 20pt;
	}
</style>

<%
PortletURL searchUrl = renderResponse.createActionURL();
searchUrl.setParameter(ActionRequest.ACTION_NAME, "popUpListCongDan");
int cur = ParamUtil.getInteger(request,"currentTransPage");

String maOrTenOrEmail = ParamUtil.getString(request, "maOrTenOrEmail");

PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("jspPage","/html/portlet/doanhnghiep/quanlytaikhoan/doanhnghiep/popup_congDanSearch.jsp");
iteratorUrl.setParameter("maOrTenOrEmail",maOrTenOrEmail);

List<CongDan> listCongDan = new ArrayList<CongDan>();
long longTotal = 0;
int total = 0;
SearchContainer searchContainer = null;

longTotal = CongDanBusiness.countByCongDan(maOrTenOrEmail);

if (cur > 0) {
	searchContainer = new SearchContainer<CongDan>(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM, cur, 10,
			iteratorUrl, null, null);
} else {
	searchContainer = new SearchContainer<CongDan>(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM, 10,
			iteratorUrl, null, null);
}
int start = searchContainer.getStart();
int end = searchContainer.getEnd();

if (longTotal > 0) {
	listCongDan = CongDanBusiness.findByCongDan(maOrTenOrEmail, start, end);
}

total = Integer.parseInt(String.valueOf(longTotal));
searchContainer.setTotal(total);
searchContainer.setResults(listCongDan); 
int k = 1;


	/* PortletURL searchUrl = renderResponse.createActionURL();
	searchUrl
			.setParameter(ActionRequest.ACTION_NAME, "searchPopUpCongDan");

	int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
	
	String maOrTenOrEmail = ParamUtil.getString(request, "maOrTenOrEmail");

	

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage",
			"/html/portlet/doanhnghiep/quanlytaikhoan/doanhnghiep/popup_congDanSearch.jsp");

	if (Validator.isNull(maOrTenOrEmail) || maOrTenOrEmail.trim().length() == 0) {
		iteratorUrl.setParameter("maOrTenOrEmail", "");
	}

	
	List<CongDan> listCongDan = null;
	long longTotal = 0;
	int total = 0;
	SearchContainer searchContainer = null;

	longTotal = CongDanBusiness.countByCongDan(maOrTenOrEmail,String.valueOf( QuanLyTKConstants.TaoCongDan.CHUA_CO_TAI_KHOAN));

	if (cur > 0) {
		searchContainer = new SearchContainer<CongDan>(renderRequest, null,
				null, SearchContainer.DEFAULT_CUR_PARAM, cur, 10,
				iteratorUrl, null, null);
	} else {
		searchContainer = new SearchContainer<CongDan>(renderRequest, null,
				null, SearchContainer.DEFAULT_CUR_PARAM, 10,
				iteratorUrl, null, null);
	}

	
	
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();

	if (longTotal > 0) {
		listCongDan = CongDanBusiness.findByCongDan(maOrTenOrEmail, String.valueOf(QuanLyTKConstants.TaoCongDan.CHUA_CO_TAI_KHOAN),start,end);
		
		if (renderRequest.getPortletSession()
				.getAttribute("maOrTenOrEmail") != null) {
			iteratorUrl.setParameter("maOrTenOrEmail", renderRequest
					.getPortletSession().getAttribute("maOrTenOrEmail")
					.toString());
		}
		

	}

	total = Integer.parseInt(String.valueOf(longTotal));
	searchContainer.setTotal(total);
	searchContainer.setResults(listCongDan); 
	int k = 1; */	
%>

<div class="egov-container" id="congdan_popup">
	<p class="egov-p-20">
		Tìm kiếm công dân
	</p>
	<form name="searchForm" class="searchForm" method="post" action="<%=searchUrl %>" >
		<table class="egov-table-form" >
			<tbody>
				<tr>
					<td>
						<label class="egov-label-bold" >Nhập Tên/ CMND/ Mã số công dân/ Email :</label>
					</td>
				</tr>
				<tr>
					<td> 
						<div class="left" style="width: 50%;">	
							<input style="width: 95%;" name="maOrTenOrEmail" id="maOrTenOrEmail" type="text" size="25" maxlength="150"
							class="egov-inputfield custom" value="<%=maOrTenOrEmail %>" />
						</div>
						<div>
							<input style="width: 9%;" type="submit" value="Tìm kiếm"
						class="egov-button-search" />
						</div>
					</td>
					
					
				</tr>
			</tbody>
		</table>
		
	</form>
	<form name="resultForm">
		<table id="tblContent" class="egov-table cssTable" >
			<tbody>
				<tr>
					<th>STT </th>
					<th>Mã CDĐT</th>	
					<th>Họ và tên</th>					
					<th>Số CMND</th>
					<th>Ngày sinh</th>
					<th>Email</th>	
					<th>Chọn</th>
				</tr>
				<%
					if (total > 0 && listCongDan != null) {
						List items = listCongDan;//searchContainer.getResultRows();
						for (int i = 0; i < listCongDan.size(); i++) {
							CongDan hs = (CongDan) items.get(i);
							
							
							String fullName = hs.getHo() + " " + hs.getDem() + " "
									+ hs.getTen();							
				%>
				<tr>
					<td style="text-align: center;padding: 0;" ><%= Integer.toString(k++ + searchContainer.getStart()) %></td>
					<td><%=hs.getMa()%></td>
					<td><%=fullName%></td>
					<td><%=hs.getSoCmnd() %></td>
					<td><%=FormatUtils.getFormatDate(hs.getNgaySinh())%></td>
					<td><%=hs.getEmail() %></td>
					<td class="center">
							<input type="radio" class="egov-radio"  name="rdChonCD" id="rdChonCD"value="<%=hs.getId()%>" />	
							
							<%-- <input type="hidden" id = "idCD" name="idCD" value="<%=String.valueOf(hs.getId())%>" />
							<input type="hidden" id = "macd" name="macd" value="<%=HtmlUtil.escape(hs.getMa())%>" />
							<input type="hidden" id = "hovaten" name="hovaten" value="<%=HtmlUtil.escape(fullName)%>" />
							<input type="hidden" id = "ngaysinh" name="ngaysinh" value="<%=FormatUtils.getFormatDate(hs.getNgaySinh())%>" />
					 		<input type="hidden" id = "gioitinh" name="gioitinh" value="<%=String.valueOf(hs.getGioiTinh())%>" />
					 		<input type="hidden" id = "quocgiaid" name="quocgiaid" value="<%=String.valueOf(hs.getQuocTichId())%>" />
					 		<input type="hidden" id = "dantocid" name="dantocid" value="<%=String.valueOf(hs.getDanTocId())%>" />
					 		
					 		<input type="hidden" id = "diachihiennay" name="diachihiennay" value="<%=String.valueOf(hs.getDiaChiHienNay())%>" />
					 		<input type="hidden" id = "hiennaytinhid" name="hiennaytinhid" value="<%=String.valueOf(hs.getDiaChiHienNayTinhId())%>" />
					 		<input type="hidden" id = "hiennayhuyenid" name="hiennayhuyenid" value="<%=String.valueOf(hs.getDiaChiHienNayHuyenId())%>" />
					 		<input type="hidden" id = "hiennayxaid" name="hiennayxaid" value="<%=String.valueOf(hs.getDiaChiHienNayXaId())%>" />
					 		
					 		<input type="hidden" id = "diachithuongtru" name="diachithuongtru" value="<%=String.valueOf(hs.getDiaChiThuongTru())%>" />
					 		<input type="hidden" id = "thuongtrutinhid" name="thuongtrutinhid" value="<%=String.valueOf(hs.getDiaChiThuongTruTinhId())%>" />
					 		<input type="hidden" id = "thuongtruhuyenid" name="thuongtruhuyenid" value="<%=String.valueOf(hs.getDiaChiThuongTruHuyenId())%>" />
					 		<input type="hidden" id = "thuongtruxaid" name="thuongtruxaid" value="<%=String.valueOf(hs.getDiaChiThuongTruXaId())%>" />
					 		
					 		<input type="hidden" id = "socmnd" name="socmnd" value="<%=String.valueOf(hs.getSoCmnd())%>" />
					 		<input type="hidden" id = "ngaycapcmnd" name="ngaycapcmnd" value="<%=String.valueOf(hs.getNgayCapCmnd())%>" />
					 		<input type="hidden" id = "noicapcmndid" name="noicapcmndid" value="<%=String.valueOf(hs.getNoiCapCmndId())%>" />
					 		<input type="hidden" id = "email" name="email" value="<%=String.valueOf(hs.getEmail())%>" />
					 		
					 		<input type="hidden" id = "dtdd" name="dtdd" value="<%=String.valueOf(hs.getDienThoaiDiDong())%>" />
					 		<input type="hidden" id = "fax" name="fax" value="<%=hs.getFax()%>" />				 		
					 		<input type="hidden" id = "website" name="website" value="<%=hs.getWebsite()%>" /> --%>
					 		
					</td>
				</tr>
				<%
						}
					} else {
				%>
				<tr>
					<td colspan="4" align="center"><label class="egov-label">Không có dữ liệu !</label></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<%
			if (searchContainer != null) {
		%>
		<div id="pagination">
			<liferay-ui:search-paginator searchContainer="<%=searchContainer%>" />
		</div>
		<%
			}
		%>
		<br />
		<table style="margin-bottom: 20pt;">
			<tr>
				<td align="center">
					<input name="selectId" type="button" value="Chọn" class="egov-button-normal"  onclick="selectedCongDan();" />
					<input type="button" class="egov-button" onclick="window.close();"value="Đóng"/>	
				</td>
			</tr>
		</table>

<script type="text/javascript">
	function selectedCongDan() {
		
		var checkboxs = $('input[name="rdChonCD"]:checked');
	    if (checkboxs.length == 0) {
			alert ("Bạn cần phải chọn một công dân");
			return false;
		}else{
			window.opener.choiceCongDan($('input[name=rdChonCD]:checked').val());
			window.close();
		}
	    
	 /*    
		//alert(window.name);
		
		var radios = document.getElementsByName("rdChonCD");
		
		var idCDs = document.getElementsByName("idCD"); */
		/* var hotens = document.getElementsByName("hovaten");
		var ngaysinhs = document.getElementsByName("ngaysinh");
		var gioitinhs = document.getElementsByName("gioitinh");
		var quocgiaids = document.getElementsByName("quocgiaid");
		var dantocids= document.getElementsByName("dantocid");
		var diachihiennays= document.getElementsByName("diachihiennay");
		var hiennaytinhids= document.getElementsByName("hiennaytinhid");
		var hiennayhuyenids= document.getElementsByName("hiennayhuyenid");
		var hiennayxaids= document.getElementsByName("hiennayxaid");
		
		var diachithuongtrus= document.getElementsByName("diachithuongtru");
		var thuongtrutinhids= document.getElementsByName("thuongtrutinhid");
		var thuongtruhuyenids= document.getElementsByName("thuongtruhuyenid");
		var thuongtruxaids= document.getElementsByName("thuongtruxaid");
		
		var socmnds= document.getElementsByName("socmnd");
		var ngaycapcmnds= document.getElementsByName("ngaycapcmnd");
		var noicapcmndids= document.getElementsByName("noicapcmndid");
		
		var emails= document.getElementsByName("email");
		var faxs = document.getElementsByName("fax");
		var websites = document.getElementsByName("website");		
		var dtdds = document.getElementsByName("dtdd"); */
		
		/*var id="";
		var idCD = "";
		 var ten="";
		var ngaysinh="";
		var gioitinh="";
		var quocgiaid="";
		var dantocid="";
		
		var diachihiennay="";
		var hiennaytinhid="";		
		var hiennayhuyenid="";
		var hiennayxaid="";
		
		var diachithuongtru="";
		var thuongtrutinhid="";
		var thuongtruhuyenid="";
		var thuongtruxaid="";
		
		
		var socmnd="";		
		var ngaycapcmnd="";
		var noicapcmndid="";
		
		
		var fax="";
		var website="";
		var email="";		
		var dtdd=""; */
		
		
		/* for ( var i = 0; i < radios.length; i++) {
			if (radios[i].checked) {
				id = radios[i].value;
				idCD = idCDs[i].value; */
				/* ten=hotens[i].value;
				ngaysinh=ngaysinhs[i].value;
				gioitinh=gioitinhs[i].value;
				quocgiaid = quocgiaids[i].value;
				dantocid = dantocids[i].value;
				
				diachihiennay = diachihiennays[i].value;
				hiennaytinhid = hiennaytinhids[i].value;
				hiennayhuyenid = hiennayhuyenids[i].value;
				hiennayxaid = hiennayxaids[i].value;
				
				diachithuongtru = diachithuongtrus[i].value;
				thuongtrutinhid = thuongtrutinhids[i].value;
				thuongtruhuyenid = thuongtruhuyenids[i].value;
				thuongtruxaid = thuongtruxaids[i].value;
				
				socmnd = socmnds[i].value;
				ngaycapcmnd = ngaycapcmnds[i].value;
				noicapcmndid = noicapcmndids[i].value;
				email = emails[i].value;
				fax = faxs[i].value;
				website = websites[i].value;
				email = emails[i].value;
				dtdd = dtdds[i].value; */
				
		/* 		break;
			}
		}
		
		
		if (id == "") {
			alert("Bạn cần phải chọn công dân!");
			return;
		} else {
			var data = {
					'idCD' :  idCD	 */				
					/* 'hoten' :  ten,
					'ngaysinh' : ngaysinh,
					'gioitinh' : gioitinh,
					'quocgiaid' : quocgiaid,
					'dantocid' : dantocid,
					
					'diachihiennay' : diachihiennay,
					'hiennaytinhid' : hiennaytinhid,
					'hiennayhuyenid' : hiennayhuyenid,
					'hiennayxaid' : hiennayxaid,
					
					'diachithuongtru' : diachithuongtru,
					'thuongtrutinhid' : thuongtrutinhid,
					'thuongtruhuyenid': thuongtruhuyenid,
					'thuongtruxaid' : thuongtruxaid,
					
					'socmnd' : socmnd,
					'ngaycapcmnd' : ngaycapcmnd,
					'noicapcmndid' : noicapcmndid,
					'email' : email,
					'fax' : fax,
					'website' : website,					
					'dtdd' : dtdd */
					
					
					
				//};
			
			/* alert("xuat " +data['hoten']); */
			/* if(window.name==="popupThemTV")
				window.opener.dataThemTV(data);
			else
				window.opener.dataNDD(data);
			window.close(); */
			 
		  
	}
</script>




