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
<%@page import="net.sf.ehcache.hibernate.management.impl.BeanUtils"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.CongDan"%>
<%@ include file="/html/portlet/userreg/init.jsp" %>
<%@page import="org.oep.cmon.dao.cd.service.QuanHeGiaDinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.QuanHeGiaDinh"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="org.oep.cmon.dao.cd.model.TinhTrangHonNhan"%>
<%@page import="org.oep.cmon.dao.cd.service.TinhTrangHonNhanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.service.TrinhDoChuyenMonLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.TrinhDoChuyenMon"%>
<%@page import="org.oep.cmon.dao.cd.service.NgheNghiepLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.NgheNghiep"%>
<%@page import="org.oep.cmon.dao.cd.model.TrinhDoHocVan"%>
<%@page import="org.oep.cmon.dao.cd.service.TrinhDoHocVanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.QuocGia"%>
<%@page import="org.oep.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.service.TonGiaoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.TonGiao"%>
<%@page import="org.oep.cmon.dao.cd.model.DanToc"%>
<%@page import="org.oep.cmon.dao.cd.service.DanTocLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.GioiTinh"%>
<%@page import="org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DonViHanhChinh"%>
<%@page import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<portlet:resourceURL var="fetchValues" id="fetchDonViHanhChinh"/>
<script type="text/javascript">
	$(document).ready(function(){		
		// CHange event on noisinh_tinhthanh combobox
		$("#noisinh_tinhthanh").change(function(){
		  	var url="<%=fetchValues%>";
		  	var parentId = $("#noisinh_tinhthanh").val();	  	
		  	
		  	$("#noisinh_quanhuyen").empty();
		  	$("#noisinh_quanhuyen").append("<option value=''>Chọn</option>");
		  	
		  	if (parentId != "") {	 
				jQuery.getJSON(url+"&parentId=" + parentId, function(data)  {
				   	for(var i=0; i < data.donViHanhChinhArray.length; i++){
				   		donViHanhChinhArray = data.donViHanhChinhArray[i].split(":");
				    	$("#noisinh_quanhuyen").append("<option value='"+ donViHanhChinhArray[0] +"'>"+donViHanhChinhArray[1]+"</option> " );
				   	}
		  		});
		  	}
		  	
		  	$("#noisinh_quanhuyen").change();
	 	});	
		
		// CHange event on thuongtru_tinhthanh combobox
		$("#thuongtru_tinhthanh").change(function(){
		  	var url="<%=fetchValues%>";
		  	var parentId = $("#thuongtru_tinhthanh").val();	  	
		  	
		  	$("#thuongtru_quanhuyen").empty();
			$("#thuongtru_quanhuyen").append("<option value=''>Chọn</option>");
			
		  	if (parentId != "") {	
		  		jQuery.getJSON(url+"&parentId=" + parentId , function(data)  {
				   	for(var i=0; i < data.donViHanhChinhArray.length; i++){
				   		donViHanhChinhArray = data.donViHanhChinhArray[i].split(":");
				    	$("#thuongtru_quanhuyen").append("<option value='"+ donViHanhChinhArray[0] +"'>"+donViHanhChinhArray[1]+"</option> " );
				   	}		   		
	  			});
		  	}
		  	
		  	$("#thuongtru_quanhuyen").change();
	 	});	
		
		// CHange event on noio tinh thanh combobox
		$("#noio_tinhthanh").change(function(){
		  	var url="<%=fetchValues%>";
		  	var parentId = $("#noio_tinhthanh").val();	  	
		  	
		  	$("#noio_quanhuyen").empty();
		  	$("#noio_quanhuyen").append("<option value=''>Chọn</option>");
		  	
		  	if (parentId != "") {	  		
			  	jQuery.getJSON(url+"&parentId=" + parentId , function(data)  {
				   	for(var i=0; i < data.donViHanhChinhArray.length; i++){
				   		donViHanhChinhArray = data.donViHanhChinhArray[i].split(":");
				    	$("#noio_quanhuyen").append("<option value='"+ donViHanhChinhArray[0] +"'>"+donViHanhChinhArray[1]+"</option> " );
				   	}				   
		  		});
		  	}
		  	
			$("#noio_quanhuyen").change();
	 	});
		
		// CHange event on noisinh_quanhuyen combobox
		$("#noisinh_quanhuyen").change(function(){
		  	var url="<%=fetchValues%>";
		  	var parentId = $("#noisinh_quanhuyen").val();	  	
		  	
		  	$("#noisinh_phuongxa").empty();
		  	$("#noisinh_phuongxa").append("<option value=''>Chọn</option>");
		  	
		  	if (parentId == "") {
		  		return;
		  	}	
		  	
		  	jQuery.getJSON(url+"&parentId=" + parentId , function(data)  {
			   	for(var i=0; i < data.donViHanhChinhArray.length; i++){
			   		donViHanhChinhArray = data.donViHanhChinhArray[i].split(":");
			    	$("#noisinh_phuongxa").append("<option value='"+ donViHanhChinhArray[0] +"'>"+donViHanhChinhArray[1]+"</option> " );
			   	}
	  		});
	 	});
		
		
		// CHange event on thuongtru_quanhuyen combobox
		$("#thuongtru_quanhuyen").change(function(){
		  	var url="<%=fetchValues%>";
		  	var parentId = $("#thuongtru_quanhuyen").val();	 	  	
		  	
		  	$("#thuongtru_phuongxa").empty();
		  	
		  	$("#thuongtru_phuongxa").append("<option value=''>Chọn</option>");
		  	
		  	if (parentId == "") {
		  		return;
		  	}
		  	
		  	jQuery.getJSON(url+"&parentId=" + parentId , function(data)  {
			   	for(var i=0; i < data.donViHanhChinhArray.length; i++){
			   		donViHanhChinhArray = data.donViHanhChinhArray[i].split(":");
			    	$("#thuongtru_phuongxa").append("<option value='"+ donViHanhChinhArray[0] +"'>"+donViHanhChinhArray[1]+"</option> " );
			   	}
	  		});
	 	});
		
		// CHange event on noio_quanhuyen combobox
		$("#noio_quanhuyen").change(function(){
		  	var url="<%=fetchValues%>";
		  	var parentId = $("#noio_quanhuyen").val();	  	
		  	
		  	$("#noio_phuongxa").empty();
		  	$("#noio_phuongxa").append("<option value=''>Chọn</option>");
		  	
		  	if (parentId == "") {
		  		return;
		  	}
		  	
		  	jQuery.getJSON(url+"&parentId=" + parentId , function(data)  {
			   	for(var i=0; i < data.donViHanhChinhArray.length; i++){
			   		donViHanhChinhArray = data.donViHanhChinhArray[i].split(":");
			    	$("#noio_phuongxa").append("<option value='"+ donViHanhChinhArray[0] +"'>"+donViHanhChinhArray[1]+"</option> " );
			   	}
	  		});
	 	});
	}); 
</script>
<%
	// Get user request from session
	Map <String, String> userRequest = (Map <String, String>)renderRequest.getPortletSession().getAttribute("USER_REQUEST_OBJECT");


	CongDan congDan = CongDanLocalServiceUtil.findByNgaySinhAndSoCMND(FormatUtil.parseStringToDate(userRequest.get("NGAYSINH")), userRequest.get("SOCMND"));
	CongDan congDanExist = null;
	if (congDan !=null ){
		congDanExist = CongDanLocalServiceUtil.fetchCongDan(congDan.getId());
	}
	
	long yeuCauDangKyCongDanId = ParamUtil.getLong(request, "yeuCauDangKyCongDanId");
	
	PortletURL inputDetailUrlExist = renderResponse.createActionURL();
	inputDetailUrlExist.setParameter(ActionRequest.ACTION_NAME, "saveYeuCauDangKyCongDan");
	
%>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/customEgovTheme.css" type="text/css" media="screen" />	
</head>
	<div class="egov-container">	
		<form id="endorseForm" name="endorseForm" method="post" action="<%=inputDetailUrlExist%>">
		  <table cellspacing="0" cellpadding="0" class="egov-table-form">
		    <tr>
		      <td colspan="6" align = "left">	
		      <select style="display: none;"	id="egov-form-errors" >	  
		      		<option value="ho">	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.hoCongDan" message = "org.oep.cmon.userreg.form.input.err.hoCongDan"/>
						</option>    
						<option value="ten">	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.tenCongDan" message = "org.oep.cmon.userreg.form.input.err.tenCongDan"/>
						</option>    
						<option value="soCmnd">	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.soCmnd"  message = "org.oep.cmon.userreg.form.input.err.soCmnd" />
							<liferay-ui:error key="err.soCmndVoPhaiNamTrongKhoangTuChinDenMuoiHaiChuSo"  message = "Số CMND phải có 9 số hoặc 12 số" />
						</option>
						<option value="ngayCapCmnd">	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.ngayCapCmnd"  message = "org.oep.cmon.userreg.form.input.err.ngayCapCmnd" />
						</option>
						<option value="noiCapCmnd">	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.noiCapCmnd"   message = "org.oep.cmon.userreg.form.input.err.noiCapCmnd" />
						</option>
						<option value="email">	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.email"  message = "org.oep.cmon.userreg.form.input.err.email" />
						
						</option>
						<option value="email">
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.email1"  message = "Email không đúng định dạng" />
						</option>
						<option value="gioiTinh">	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.gioiTinh"  message = "org.oep.cmon.userreg.form.input.err.gioiTinh" />
						</option>
						<option value="danToc">	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.danToc"  message = "org.oep.cmon.userreg.form.input.err.danToc" />
						</option>
						<option value="tonGiao">	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.tonGiao"  message = "org.oep.cmon.userreg.form.input.err.tonGiao" />
						</option>
						<option value="ho">	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.quocTich"  message = "org.oep.cmon.userreg.form.input.err.quocTich" />
						</option>
						<option value="ngaySinh">	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.ngaySinh"  message = "org.oep.cmon.userreg.form.input.err.ngaySinh" />
						</option>
						<option value="ngaySinh">	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.ngaySinh.greaterThanCurrent"  message = "org.oep.cmon.userreg.form.input.err.ngaySinh.greaterThanCurrent" />
						</option>
						
						<option>	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.tinhThuongTru"  message = "org.oep.cmon.userreg.form.input.err.tinhThuongTru" />
						</option>
						<option>	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.huyenThuongTru"  message = "org.oep.cmon.userreg.form.input.err.huyenThuongTru" />
						</option>
						<option>	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.xaThuongTru"  message = "org.oep.cmon.userreg.form.input.err.xaThuongTru" />
						</option>
						
						<option>	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.motaThuongTru"  message = "org.oep.cmon.userreg.form.input.err.motaThuongTru" />
						</option>
						
						<option value="soCmnd">	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.requestExists"  message = "org.oep.cmon.userreg.form.input.err.requestExists" />
						</option>
						<option value="email">	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.email.alreadyOwned"  message = "org.oep.cmon.userreg.form.input.err.email.alreadyOwned" />
						</option>
						<option value="captcha">	
							<liferay-ui:error key="org.oep.cmon.userreg.form.input.err.captcha"  message = "org.oep.cmon.userreg.form.input.err.captcha" />
						</option>	
				</select>		
				</td>	
		    </tr>
		   <!--  <tr>
		      <td width="10" colspan="3" scope="col"><label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.userreg.form.input.hoVaTen"/> <font color = "red">(*)</font></label></td>
		      <td width="20" colspan="3" rowspan="8" scope="col">
			      <table class = "egov-table-form2" >
			        <tr>
			          <td valign = "top">
			          	<%
			          	//PortletURL uploadUrl = renderResponse.createRenderURL();
			          	// This will remove header and footer in theme
			          //	uploadUrl.setWindowState(LiferayWindowState.POP_UP);
			          //	uploadUrl.setParameter("jspPage","/html/portlet/userreg/upload_avatar.jsp");
							
			          	%>
			          	<iframe src = "<%//=uploadUrl %>" frameborder="0" scrolling = "no" height = "215px"></iframe>
			          </td>
			        </tr>			        
			      </table>
		      </td>
		    </tr> -->
		    <tr>
		    	<td colspan="3">
		    		<label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.userreg.form.input.email" /> <font color = "red">(*)</font></label>
		    		<br>
		    		<input name="email" type="text" id="email"  maxlength="50" class = "egov-inputfield" value = "<%=userRequest.get("EMAIL")%>" style = 'width:95%'/>
		    	</td>
		    </tr>
		    
		    <tr>
		      <td>
		      	<label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.userreg.form.input.hoVaTen"/> <font color = "red">(*)</font></label>
		      	<br>
		      	<input name="ho" type="text" id="ho"  maxlength="20" class = "egov-inputfield" value = "<%=congDanExist.getHo()%>" style = 'width:85%'/>
		      </td>
		      <td>
		      <br>
		      <input name="dem" type="text" id="dem"  maxlength="50" class = "egov-inputfield" value = "<%=congDanExist.getDem()%>" style = 'width:85%' /></td>
		      <td>
		      <br>
		      <input name="ten" type="text" id="ten"  maxlength="20" class = "egov-inputfield" value = "<%=congDanExist.getTen()%>" style = 'width:85%'/></td>
		       <td colspan="3">
		       <label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.userreg.form.input.ngaySinh" /> <font color = "red">(*)</font></label>
		         <br>
		         <input name="ngaySinh" type="text" id="ngaySinh" class = "egov-calendar   " value = "<%=FormatUtil.parseDateToTring(congDanExist.getNgaySinh())%>" style = 'width:95%'/>
		         
		       </td>
		      
		    </tr>
		    
		    <tr>
		      <td colspan="2"><label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.userreg.form.input.soCmnd" /> <font color = "red">(*)</font></label>
		      <br>
		      	<input name="soCmnd" type="text" id="soCmnd" maxlength="12" class = "egov-inputfield" value = "<%=congDanExist.getSoCmnd()%>" style = 'width:95%'/>
		      </td>
		      <td colspan="2"><label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.userreg.form.input.ngayCapCmnd" /> <font color = "red">(*)</font></label>
		      <br>
		      <input name="ngayCapCmnd" type="text" id="ngayCapCmnd" maxlength="10" class = "egov-calendar   " value = "<%=FormatUtil.parseDateToTring(congDanExist.getNgayCapCmnd())%>" style = 'width:95%'/>
		      </td>
		      
		      <td colspan="2"><label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.userreg.form.input.noiCapCmnd" /> <font color = "red">(*)</font></label>
		      	<br>
		      	 <%
				List <DonViHanhChinh> tinhThanhList = DonViHanhChinhLocalServiceUtil.getDanhSachTinhThanh();
		      	
		      %>
		        <select name="noiCapCmnd" id="noiCapCmnd" class = "egov-select   " style="width:99%; display:block;">
		        <option id = "" value = "0">-Chọn-</option>
		        	<%
		        		String selected = "";
		        		for ( DonViHanhChinh tinhThanh: tinhThanhList) {
		        			if ( Validator.isNotNull(congDanExist.getNoiCapCmndId()) && tinhThanh.getId() == congDanExist.getNoiCapCmndId() )  {
		        				selected = "selected";
		        			}else {
		        				selected = "";
		        			}
		        	%>
		        			<option value = "<%=tinhThanh.getId()%>" <%=selected %>>Công an <%=tinhThanh.getTen() %></option>
		        	<%} %>
		      </select>
		      </td>
		    </tr>
		   
		    <tr>
		    	 <td colspan="2"><label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.userreg.form.input.gioiTinh" /> <font color = "red">(*)</font></label>
		    	 <br>
		    	 <%
				      	List <GioiTinh> gioiTinhList = GioiTinhLocalServiceUtil.getDSGioiTinh();
				      %>
				      <select name="gioiTinh" id="gioiTinh" class = "egov-select   " style="width:99%; display:block;">
				      	   	<%
				        		selected = "";
				      	   		for ( GioiTinh gioiTinh: gioiTinhList) {
					      	  		if ( Validator.isNotNull(congDanExist.getGioiTinh()) && gioiTinh.getId() == congDanExist.getGioiTinh() )  {
				        				selected = "selected";
				        			} else {
				        				selected = "";
				        			}
				        	%>
				        	<option value = "<%=gioiTinh.getId()%>" <%=selected %>><%=gioiTinh.getTen() %></option>
				        	<%} %>
				      </select>
		    	 </td>
		     	 <td colspan="2"><label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.userreg.form.input.danToc" /> </label>
		     	 <br>
		     	 	<%
				      	List <DanToc> danTocList = DanTocLocalServiceUtil.findAll();
				      
				      %>
				      <select name="danToc" id="danToc" class = "egov-select   " style="width:99%; display:block;">
				      		<%
				        		selected = "";
				      			for ( DanToc danToc: danTocList) {
				      				if ( Validator.isNotNull(congDanExist.getDanTocId()) && danToc.getId() == congDanExist.getDanTocId()  ) {
				        				selected = "selected";
				        			} else {
				        				selected = "";
				        			}
				        	%>
				        	<option value = "<%=danToc.getId()%>" <%=selected %>><%=danToc.getTen() %></option>
				        	<%} %>
				      </select>
		     	 
		     	 </td>
		      	<td colspan="2"><label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.userreg.form.input.tonGiao" /> </label>
		      	<br>
		      			<%
				      	List <TonGiao> tonGiaoList = TonGiaoLocalServiceUtil.findAll();
				      %>
				      <select name="tonGiao" id="tonGiao" class = "egov-select   " style="width:99%; display:block;">
			      	   	<%
			        		selected = "";
			      	   		for ( TonGiao tonGiao: tonGiaoList) {
				      	   		if ( Validator.isNotNull(congDanExist.getTonGiaoId()) && tonGiao.getId() == congDanExist.getTonGiaoId()  ) {
			        				selected = "selected";
			        			} else {
			        				selected = "";
			        			}
			        	%>
			        	<option value = "<%=tonGiao.getId()%>" <%=selected%>><%=tonGiao.getTen() %></option>
			        	<%} %>
				      </select>
		      	
		      	</td>
		    	
		    </tr>
		    
		    <tr>
		      <td colspan="3">
		      	<label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.userreg.form.input.noiThuongTru" /> </label>
		      </td>
		    </tr>
		    
		    <tr>
		    	<td colspan="6">
			    	<label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.userreg.form.input.motaThuongTru" /></label>
			    	<br>
			    	 <input name="motaThuongTru" type="text" id="motaThuongTru"  maxlength="100" class = "egov-inputfield" value = "<%=congDanExist.getDiaChiThuongTru()%>" style = 'width:95%'/>
			    	
			   </td>
		    </tr>
		    
		    <tr>
		      <td colspan="2">
		      <label class ="egov-label-bold"><liferay-ui:message key="Tỉnh/ Thành phố" /><font color = "red">(*)</font></label>
		      <br>
		      		<select name="tinhThuongTru" id="thuongtru_tinhthanh" class = "egov-select   " style="width:99%; display:block;">
			      	<% 		   
						long idTinhThuongTru = congDanExist.getDiaChiThuongTruTinhId();
						if ( idTinhThuongTru < 1){ %>
							<option id = "Chọn" value = "">-Chọ-n</option>
						<%}
						for (DonViHanhChinh tinhThanh: tinhThanhList) {
							selected = "";
							if ( tinhThanh.getId() == idTinhThuongTru){
								selected = "selected";
							}
						%>
							<option value="<%=tinhThanh.getId()%>" <%=selected %>><%=tinhThanh.getTen()%></option>
								
					 <%	} // for
					  %>		      
			      
			      </select>
		      </td>
		      <td colspan="2">
		      	<label class ="egov-label-bold"><liferay-ui:message key="Quận/ Huyện" /><font color = "red">(*)</font></label>
		      	<br>
		      			<select name="huyenThuongTru" id="thuongtru_quanhuyen" class = "egov-select   " style="width:99%; display:block;">
				      	<% 		   
							long idHuyenThuongTru = congDanExist.getDiaChiThuongTruHuyenId();
							if ( idHuyenThuongTru  < 1){ %>
								<option id = "Chọn" value = "">-Chọn-</option>
							<%} else { 
								// Get quan huyen belong to tinh thanh
								if (idTinhThuongTru > 0) {
									// Get all quan huyen
									List <DonViHanhChinh> quanHuyenList = DonViHanhChinhLocalServiceUtil.findByChaId(idTinhThuongTru, 0);
											
									for (DonViHanhChinh quanHuyen: quanHuyenList) {
										selected = "";
										if ( quanHuyen.getId() == idHuyenThuongTru){
											selected = "selected";
										}
								%>
										<option value="<%=quanHuyen.getId()%>" <%=selected %>><%=quanHuyen.getTen()%></option>
									
						  <%		} // for
								} // If
						 } %>
				      </select>
		      		
		      	</td>
		      	
		      	<td colspan="2">
		      	<label class ="egov-label-bold"><liferay-ui:message key="Phường/ Xã" /><font color = "red">(*)</font></label>
		      	<br>
		      			<select name="xaThuongTru" id="thuongtru_phuongxa" class = "egov-select   " style="width:99%; display:block;">
				      	<% 		   
							long idXaThuongTru = congDanExist.getDiaChiThuongTruXaId();
							if ( idXaThuongTru < 1){ %>
								<option id = "Chọn" value = "">-Chọn-</option>
								<%
		                        if (idHuyenThuongTru > 0) {
		                            // Get all quan huyen
		                            List <DonViHanhChinh> phuongXaList = DonViHanhChinhLocalServiceUtil.findByChaId(idHuyenThuongTru, 0);
		                            for (DonViHanhChinh phuongXa: phuongXaList) {
		                        %>
		                                <option value="<%=phuongXa.getId()%>"><%=phuongXa.getTen()%></option>
		                        <%       
		                        } }// for
		                        %>
							<%} else { 
								// Get quan huyen belong to quan huyen
								if (idHuyenThuongTru > 0) {
									// Get all quan huyen
									List <DonViHanhChinh> phuongXaList = DonViHanhChinhLocalServiceUtil.findByChaId(idHuyenThuongTru, 0);
											
									for (DonViHanhChinh phuongXa: phuongXaList) {
										selected = "";
										if ( phuongXa.getId() == idXaThuongTru){
											selected = "selected";
										}
								%>
										<option value="<%=phuongXa.getId()%>" <%=selected %>><%=phuongXa.getTen()%></option>
									
						  <%		} // for
								} // If
						 } %>
				      </select>
		      	
		      	</td>
		      	
		    </tr>
		    
		    <tr>
		      <td colspan="3" style="display: none;"><label class ="egov-label-bold"><liferay-ui:message key="org.oep.cmon.userreg.form.input.quocTich" /> <font color = "red">(*)</font></label></td>
		      <br>
		      
		      <%
		      		List <QuocGia> quocGiaList = QuocGiaLocalServiceUtil.findAll();
		      	%>
		        <select name="quocTich" id="quocTich" class = "egov-select   " style="width:99%; display:none;">
		        <%
	        		selected = "";
		        	for ( QuocGia quocGia: quocGiaList) {
		        		if ( Validator.isNotNull(userRequest.get("IDQUOCTICH")) && quocGia.getId() == Long.parseLong(userRequest.get("IDQUOCTICH") ) ) {
	        				selected = "selected";
	        			}else {
	        				selected = "";
	        			}
	        	%>
	        	<option value = "<%=quocGia.getId()%>" <%=selected %>><%=quocGia.getTen() %></option>
	        	<%} %>
		        </select>
		      
		    </tr>
		    
		    
		    <tr>
		      <td colspan="2">
		      <label class ="egov-label-bold"><liferay-ui:message key="Mã xác nhận" /> <font color = "red">(*)</font></label>
		      <br>
		      <input id="captcha" class="egov-inputfield custom" type="text" style="width:95%" maxlength="20" name="captcha">
		          
			  </td>
			  <td colspan="3">
			  <br>
			  	<portlet:resourceURL var="captchaURL" id="captcha"/>
			      <img class="captcha" src="<%= captchaURL%> alt="Text to identify" style=" width:85px; height:32px;" />
			      <input id="reloadcapchar" name="reloadcapchar" type="hidden" value=""/>
		          <a href="javascript: submitReloadCapcha()" class="wd-refresh">
		             <img src="<%=request.getContextPath()%>/images/reload_capcha.jpg" alt="Lấy lại mã bảo mật" style="height:32px;" />            
		          </a>	
			  </td>
		    </tr>
		     <tr>
		      <td colspan="3">&nbsp;</td>
		      <td colspan="3">&nbsp;</td>
		    </tr>
		    <tr>
		      <td colspan="6" align = "center">
		      	<%			
				// Create upload avatar URL
				PortletURL backUrl = renderResponse.createRenderURL();	
		      	backUrl.setParameter("jspPage","/html/portlet/userreg/view.jsp");
		      	
				PortletURL redirectUrl = renderResponse.createRenderURL();	
				redirectUrl.setParameter("jspPage","/html/portlet/userreg/input_detail.jsp");
				
				PortletURL accountRegisterSuccessUrl = renderResponse.createRenderURL();
				accountRegisterSuccessUrl.setParameter("jspPage","/html/portlet/userreg/account_register_success.jsp");  
		            
		        PortletURL accountCreationUrl = renderResponse.createRenderURL();            
		        accountCreationUrl.setParameter("jspPage","/html/portlet/userreg/account_creation.jsp");
		        accountCreationUrl.setParameter("authCode", "DUMMY_AUTH_CODE"); 
		        
		        PortletURL citizenRegisterSuccessUrl = renderResponse.createRenderURL();          
		        citizenRegisterSuccessUrl.setParameter("jspPage","/html/portlet/userreg/citizen_register_success.jsp");
		         
		        PortletURL accountExistDialog = renderResponse.createRenderURL();
		  		accountExistDialog.setParameter("jspPage","/html/portlet/userreg/account_exist.jsp");
		  		
		  		PortletURL inputDetailDialogUrlExistInCongDan = renderResponse.createRenderURL();
		  		inputDetailDialogUrlExistInCongDan.setParameter("jspPage","/html/portlet/userreg/input_detail_dialog_exist.jsp");
		      	%>
		      	<input type="hidden" name="inputDetailDialogUrlExistInCongDan"  value="<%= inputDetailDialogUrlExistInCongDan%>"/>
		      	<input type = "hidden" name = "accountExistDialog" value = "<%=accountExistDialog %>" />	
		      	<input type = "hidden" name = "redirectUrl" value = "<%=redirectUrl %>" />		      	
		      	<input type = "hidden" name = "successUrl" value = "<%=backUrl %>" />		      	
		      	<input type="hidden" name="accountCreationUrl" value="<%= accountCreationUrl%>"/>		      	
				<input type="hidden" name="accountRegisterSuccessUrl" value="<%= accountRegisterSuccessUrl%>"/>
				<input type="hidden" name="citizenRegisterSuccessUrl" value="<%= citizenRegisterSuccessUrl%>"/>
				
		      	<input type="submit" class = "egov-button" name="submitButton"  value="<liferay-ui:message key="org.oep.cmon.userreg.form.input.submitButton"/>" />
		      	<a href = "<%=backUrl %>" >
		      		<input type="button" class = "egov-button" name="backButton"  value="<liferay-ui:message key="org.oep.cmon.userreg.form.input.backButton"/>" />
		      	</a>		      	
		      </td>
		    </tr>
		  </table>
		</form>
	</div>
	<br/>
	<script type = "text/javascript">
        function submitReloadCapcha() {
            document.getElementById("reloadcapchar").value = 'reloadcapchar';
            document.getElementById("endorseForm").submit();
        }
    </script>
