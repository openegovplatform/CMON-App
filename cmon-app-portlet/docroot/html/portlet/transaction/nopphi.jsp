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
<%@page import="org.oep.cmon.czprofile.portlet.util.ConvertUtil"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="org.oep.cmon.dao.ttthanhtoan.model.impl.ThongTinThanhToanImpl"%>
<%@page import="org.oep.cmon.dao.ttthanhtoan.service.persistence.ThongTinThanhToanUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.cmon.dao.ttthanhtoan.service.persistence.ThongTinThanhToanFinderUtil"%>
<%@page import="org.oep.cmon.dao.ttthanhtoan.service.ThongTinThanhToanLocalServiceUtil"%>
<%@page import="vn.dtt.sharedservice.WebserviceFactory"%>
<%@page import="org.oep.cmon.dao.tlct.model.DanhMucGiayTo"%>
<%@page import="org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil"%>


<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.persistence.HoSoTTHCCongFinderImpl"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/html/portlet/ipmslistportlet/offline/init.jsp" %>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.persistence.HoSoTTHCCongUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.persistence.HoSoTTHCCongFinderUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@include file="/html/portlet/ipmslistportlet/offline/init.jsp" %>
<portlet:defineObjects />

<head>
	<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/dialog-ui.css" type="text/css" media="screen" />
	<script src="<%=request.getContextPath()%>/js/jquery.form.js"	type="text/javascript"></script>	
	<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/customEgovTheme.css" type="text/css" media="screen" />
	<script src="<%=request.getContextPath()%>/js/customEgovTheme.js"	type="text/javascript"></script>	
</head> 
<style>
.uploadblock {
	 	margin-top: 25px;
}
 .uploadblock  div strong {
 	width: 144px;
 	display: block;
 	float: left;
 }

 .uploadblock  div  {
 	clear: both;
	line-height: 25px;
 }
 
.egov-button.upload {
	height: 32px;
	font-size: 14px;
	width: 66px;
	padding: 0;
	text-transform: capitalize;
	margin-top: 10px;
}

.container-uploadblock {
	min-width: 500px;
	font-size: 0.75em;
	/* background: #e3ebed;*/
	padding-left: 44px;
}

.form-container  {
	min-width: 589px;
	font-size: 0.75em;
	padding: 36px;
}

.form-container div {
	line-height: 37px;
	clear: both;
}

.form-container div input[type='text'] {
	line-height: 28px;
	width: 221px;
}

 .form-container  div strong {
	display: block;
	float: left;
	width: 183px;
 }
 
 .submit-result-popup {
	line-height: 35px;
	vertical-align: middle;
	font-size: 14px;
	border: 1px solid rgb(216, 213, 213);
	/*background: antiquewhite;*/
	margin-top: 15px;
	text-align: center;
	color: green;
}
</style>
<!-- get object hoso  -->
<%
	Long hoSoId = ParamUtil.getLong(request, "hoSoId");
	String urlImage = ParamUtil.getString(request, "urlImage");
	Long typePhi = ParamUtil.getLong(request, "typephi");
	

	String title ="";
	if (typePhi == 1) {
		title = "Nộp phí qua tài khoản";
	} else {
		title = "Nộp lệ phí qua tài khoản";
	}
	
	// Set title
	renderResponse.setTitle(title);
	
	HoSoTTHCCong hoSoTTHCC =   HoSoTTHCCongLocalServiceUtil.getHoSoTTHCCong(hoSoId);
	//DanhMucGiayTo giayTo =  DanhMucGiayToLocalServiceUtil.findTheoMa(maHoso);
	String urlquaylai = ParamUtil.getString(request, "parentUrl");
	
	// type value 'thanh toan bang hinh thuc chuyen khoan"
	//long typeThanhToan = 2;
	long xacNhan = 0;
	Long thongTinThanhToanId = (long)0;
	
	DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			ThongTinThanhToanImpl.class,
			PortalClassLoaderUtil.getClassLoader());
		query.add(PropertyFactoryUtil.forName("hoSoTTHCCongId").eq(hoSoId));
		query.add(PropertyFactoryUtil.forName("loaiPhi").eq(typePhi));
		/* query.add(PropertyFactoryUtil.forName("loaiThanhToan").eq(typeThanhToan)); */
		
	List<ThongTinThanhToan> thongTinThanhToans = ThongTinThanhToanLocalServiceUtil.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	if (thongTinThanhToans != null && thongTinThanhToans.size() > 0) {
		ThongTinThanhToan thongTinThanhToan = thongTinThanhToans.get(0);
		xacNhan = thongTinThanhToan.getXacNhan();
		urlImage =  WebserviceFactory.getOfficerService().getURLCuaGiayToDinhKem(thongTinThanhToan.getNoiLuuTruId());
		thongTinThanhToanId = thongTinThanhToan.getId();
	}
	
%>

<portlet:actionURL var="uploadPhieu"  name="uploadPhieu">
	<portlet:param name="hoSoId" value="<%= hoSoId.toString() %>"></portlet:param>
	<portlet:param name="thongtinthanhtoanid" value="<%= thongTinThanhToanId.toString() %>"></portlet:param>
	<portlet:param name="title" value="<%= title %>"></portlet:param>
	<portlet:param name="typePhi" value="<%= typePhi.toString() %>"></portlet:param>
	<portlet:param name="parentUrl" value="<%= urlquaylai %>"></portlet:param>
	<%-- <portlet:param name="hoSoId" value="<%= hoSoTTHCC.getId() %>"></portlet:param> --%>
</portlet:actionURL>
<%-- <portlet:renderURL var="urlquaylai"
	windowState="<%=LiferayWindowState.NORMAL.toString()%>"> 
	<portlet:param name="jspPage"
		value="/html/portlet/transaction/viewTransactionDetails.jsp" />
</portlet:renderURL> --%>

<div class="container-uploadblock" >
		<h2 style="font-size: 20px; margin-top: 25px;">TẢI HÓA ĐƠN THANH TOÁN</h2>
		<form action="<%= uploadPhieu %>" id="uploadPhieu" class="uploadblock" method="post" enctype="multipart/form-data" onsubmit="return checkUpload();">
			<input type="hidden" name="title" id="title"  value="<%=  title%>">
			<div>
			<% 
				if ( hoSoTTHCC.getMaSoBienNhan() != null) {
			%>
				<strong>Mã hồ sơ tiếp nhận: </strong><%= hoSoTTHCC.getMaSoBienNhan() %>
				<%				
				} else  {
				%>
				<strong>Mã hồ sơ tiếp nhận: </strong>  
				<%
				}
				%>
			</div>
			<div>
				<strong>Dịch vụ công: </strong><%= hoSoTTHCC.getTenThuTucHanhChinh() %>
			</div>
			<div>
				<strong>Ngày nộp hồ sơ: </strong><%=ConvertUtil.parseDateToTring(hoSoTTHCC.getNgayNopHoSo())%>
			</div>
			<div>
				<strong>Người nộp hồ sơ: </strong><%= hoSoTTHCC.getHoTenNguoiNopHoSo() %>
			</div>
			<% 
				if (urlImage != null && ! "".equals(urlImage)) {
			%>
				<div>
					<strong>Hóa đơn đã tải lên: </strong><a href="#" onclick="openWindow('<%= urlImage%>');">Xem hóa đơn đã tải lên</a>
				</div>
			<% 
				}
			%>
			<div>
				
				<%
				if (xacNhan > 0) {
				%>
				<strong>Thông tin đã xác nhận:</strong>
				<span ><input  size="40"  style="background: white;" type="file" name="uploadphieu" disabled="disabled" id="dataUpload"/></span>
				<%				
				} else  {
				%>
				<strong>Tải hóa đơn:</strong>
				<span ><input  size="40"  style="background: white;" type="file" name="uploadphieu" id="dataUpload" class="egov-uploadfile"/></span>
				<%
				}
				%>
			</div>
			<div>
				<%
				if (xacNhan > 0) {
				%>
					<input type="submit" class="egov-button upload"  value="Lưu lại" disabled="disabled"  />
				<%				
				} else  {
				%>
					<input type="submit" class="egov-button upload"  value="Lưu lại"  />
				<%
				}
				%>
					<a href="<%=urlquaylai%>"> <input type="button"
					class="egov-button upload"  value="Quay lại" /></a>
			</div>
		</form>
</div>

<script type="text/javascript">
	$(document).ready(
/* 			function () {
				var  title = $('#title').val();
				$('.portlet-title span.portlet-title-text').text(title);	
			} */
			);
	
	function checkUpload() {		
		var value = $('#dataUpload').val().length;
		if (value == 0) {
			alert("Vui lòng chọn file ảnh để tải lên!");
			return false;
			
		} else {
			var ext = $('#dataUpload').val().split('.').pop().toLowerCase();		
			if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
			    alert('Vui lòng chọn tệp tin kiểu ảnh!');
			    return false;
			}
			return true;
		}		
	}
	
	function openWindow(url) {
		var newWindow = window.open(url,
						'View image',
						'height=750,width=650,left=90,top=100,resizable=no,location=no,status=no,menubar=yes');

		if (window.focus) {
			newWindow.focus();
		}
		return false;
	}
</script>
