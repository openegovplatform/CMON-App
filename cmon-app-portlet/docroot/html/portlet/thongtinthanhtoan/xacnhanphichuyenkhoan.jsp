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
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="org.oep.cmon.dao.ttthanhtoan.model.impl.ThongTinThanhToanImpl"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.cmon.dao.ttthanhtoan.service.persistence.ThongTinThanhToanUtil"%>
<%@page import="org.oep.cmon.czprofile.portlet.util.ConvertUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="vn.dtt.sharedservice.WebserviceFactory"%>
<%@page import="org.oep.cmon.dao.ttthanhtoan.service.ThongTinThanhToanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@include file="/html/portlet/ipmslistportlet/offline/init.jsp" %>
<portlet:defineObjects />

<html>
<head>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/egov-cmon-upload.css" type="text/css" media="screen" />
</head>

<%

	Long hoSoTTHCCongId = ParamUtil.getLong(request, "hoSoTTHCCongId");

	Long thongTinThanhToanId = ParamUtil.getLong(request,
			"thongTinThanhToanId");

	String urlParentPage = ParamUtil.getString(request, "parentUrl");

	Long typePhi = ParamUtil.getLong(request, "typePhi");
	boolean view = ParamUtil.getBoolean(request, "view");


	ThongTinThanhToan thongTinThanhToan = null;
	if (thongTinThanhToanId <=0) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
				ThongTinThanhToanImpl.class,
				PortalClassLoaderUtil.getClassLoader());
			query.add(PropertyFactoryUtil.forName("hoSoTTHCCongId").eq(hoSoTTHCCongId));
			query.add(PropertyFactoryUtil.forName("loaiPhi").eq(typePhi));
			/* query.add(PropertyFactoryUtil.forName("loaiThanhToan").eq(typeThanhToan)); */
			
		List<ThongTinThanhToan> thongTinThanhToans = ThongTinThanhToanLocalServiceUtil.dynamicQuery(
					query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		if (thongTinThanhToans != null && thongTinThanhToans.size() > 0) {
			 thongTinThanhToan = thongTinThanhToans.get(0);
			 if (thongTinThanhToan != null) {
				 thongTinThanhToanId = thongTinThanhToan.getId();
			 }
		}
		
	} else {
	 	 thongTinThanhToan = ThongTinThanhToanLocalServiceUtil
	 			.getThongTinThanhToan(thongTinThanhToanId); 
	}

		
	String title = "";
	String message = "";
	if (typePhi == 1) {
		title = "Xác nhận nộp phí qua tài khoản";
		message = "phí";
	} else {
		message = "lệ phí";
		title = "Xác nhận nộp lệ phí qua tài khoản";
	}
	
	// Set title
	renderResponse.setTitle(title);
	
	HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil
			.getHoSoTTHCCong(hoSoTTHCCongId);
	


	String urlPhieuThanhToan = null;
	int index = 0;
	while (urlPhieuThanhToan == null && index < 3) {
		urlPhieuThanhToan = WebserviceFactory.getOfficerService()
				.getURLCuaGiayToDinhKem(
						thongTinThanhToan.getNoiLuuTruId());
		index++;
	}
%>
<portlet:actionURL var="xacNhanNopTien" name="xacNhanNopTien">
	<portlet:param name="hoSoTTHCCongId" value="<%=hoSoTTHCCongId.toString()%>"></portlet:param>
	<portlet:param name="thongTinThanhToanId" value="<%=thongTinThanhToanId.toString()%>"></portlet:param>
	<portlet:param name="typePhi" value="<%=typePhi.toString()%>"></portlet:param>
	<portlet:param name="parentUrl" value="<%=urlParentPage%>"></portlet:param>
	 <portlet:param name="targetPage" value="/html/portlet/thongtinthanhtoan/xacnhanphichuyenkhoan.jsp"></portlet:param> 
</portlet:actionURL>

<form action="<%=xacNhanNopTien%>" class="form-container" method="post">
	<input  type="hidden" name="loaithanhtoan" value="2"/>
	<div><strong>Mã số biên nhận:</strong>
		<%
			if (hoSoTTHCCong.getMaSoBienNhan() != null) {
		%>
		<%=hoSoTTHCCong.getMaSoBienNhan()%>
		<%
			} else
		%>
	</div>
	<div><strong>Tổ chức / Cá nhân:</strong><%=hoSoTTHCCong.getHoTenNguoiNopHoSo()%> </div>
	<div><strong>Giao dịch đăng ký:</strong><%=hoSoTTHCCong.getTenThuTucHanhChinh()%></div>
	<div><strong>Thông tin chuyển khoản:</strong><a href="#" onclick="openWindow('<%=urlPhieuThanhToan%>')">Phiếu chuyển khoản</a> </div>
	<div><strong>Cán bộ xác nhận <label class="egov-label-red">*</label>:</strong>
	<%
		if (!view) {
	%>
	
		<%
		if (thongTinThanhToan != null) {
		%>
		<input type="text" class='egov-inputfield'  name="canboxacnhan" value="<%=thongTinThanhToan.getTenCanBoNhanTien()%>"/>
		<%
			} else {
		%>
		<input type="text" class='egov-inputfield'  name="canboxacnhan" value="<%=PortalUtil.getUser(request).getFullName()%>"/>
		<% } %>
	
	<%
		} else {
	%>
	<%=thongTinThanhToan.getTenCanBoNhanTien()%>
	<%
		}
	%>
	</div>

	<div>
		<strong>Số tiền <label class="egov-label-red">*</label>:
		</strong>
		<%
			if (!view) {
		%>
		<%
			if (thongTinThanhToan.getSoTien() > 0) {
		%>
		<input type="text" value="<%=thongTinThanhToan.getSoTien()%>VND" name="sotien" class="egov-inputfield NUMERIC" />
		<%
			} else {
		%>
		<input type="text" value="VND" name="sotien" class="egov-inputfield NUMERIC" />
		<%
			}
		%>
		
		<%
					} else {
				%>
		<%=thongTinThanhToan.getSoTien()%>
		<%
			}
		%>
	</div>

	<div><strong>Thông tin xác nhận <label class="egov-label-red">*</label>:</strong>
		<%
			if (!view) {
		%>
				<div style="width: 179px;float: left; clear: none;">
			<%
				if (thongTinThanhToan.getXacNhan() == 1) {
			%>
			<div>
				<input type="radio" name="xacnhan" value="1" style="margin: 4px;"
					checked="checked" />Xác nhận hợp lệ
			</div>
			<div>
				<input type="radio" name="xacnhan" value="0" style="margin: 4px;" />Không
				hợp lệ
			</div>
			<%
				} else {
			%>
			<div>
				<input type="radio" class="egov-radio"  name="xacnhan" value="1" style="margin: 4px;" />Xác
				nhận hợp lệ
			</div>
			<%
				if (thongTinThanhToan != null) {
			%>
			<div>
				<input type="radio" name="xacnhan" class="egov-radio"  value="0" style="margin: 4px;"
					checked="checked" />Không hợp lệ
			</div>
			<%
				} else {
			%>
			<div>
				<input type="radio" name="xacnhan" class="egov-radio"  value="0" style="margin: 4px;" />Không
				hợp lệ
			</div>
			<%
				}
			%>
			<%
				}
			%>



		</div>
		<%
			} else {
		%>
		Xác nhận hợp lệ
		<%
			}
		%>

	</div>
	
	<div><strong>Ý kiến:</strong>
		<%
			if (!view) {
		%>
		</div>
		<div><textarea class="egov-textarea" style="display: block; width: 409px; height: 74px;" name="ykien"><%=thongTinThanhToan.getYKien()%></textarea>
		<%
			} else {
		%>
		<%=thongTinThanhToan.getYKien()%>
			</div>
		<%
			}
		%>

	<div><strong>Ngày xác nhận<label class="egov-label-red">*</label>:</strong>
		<%
			if (!view) {
		%>
			<%
				if (thongTinThanhToan.getNgayXacNhan() != null) {
			%>
			<input type="text" class="egov-calendar egov-calendar-next" style="width: 156px !important;margin-left: 65px;cursor: pointer;line-height: 20px;" name="ngayxacnhan" value="<%=ConvertUtil.parseDateToTring(thongTinThanhToan
							.getNgayXacNhan())%>" />
			<%
				} else {
			%>
			<input type="text" class="egov-calendar egov-calendar-next" style="width: 156px !important;margin-left: 65px;cursor: pointer;line-height: 20px;" name="ngayxacnhan" value="<%=ConvertUtil.parseDateToTring(new Date())%>" />
			<%
				}
			%>
		
		<%
					} else {
				%>
		<%=ConvertUtil.parseDateToTring(thongTinThanhToan
						.getNgayXacNhan())%>
		<%
			}
		%>
	 </div>
	 
	<div>
		<%
			if (!view) {
		%>
			<input type="submit" value="Xác nhận" class="egov-button upload" style="font-size: 13px; height: 29px; width: 83px;"/>
			<a href="<%=urlParentPage%>"><input  type="button" value="Quay lại" class="egov-button upload" style="font-size: 13px; height: 29px; width: 83px;"/></a>
		<%
			} else {
		%>
			<a href="<%=urlParentPage%>"><input  type="button" value="Quay lại" class="egov-button upload" style="font-size: 13px; height: 29px; width: 83px;"/></a>
		<%
			}
		%>			
	</div>
</form>

<!-- popup status update  -->
<%
	int submitStatus = ParamUtil.getInteger(request, "submitStatus");
	if (!view && thongTinThanhToan != null) {
%>
	<%
		if (thongTinThanhToan.getXacNhan() == 1) {
	%>
	<div class="submit-result-popup">Hồ sơ đã nộp <%= message %> chuyển khoản thành công!</div>
	<%
		} else {
	%>
		<%
		if (submitStatus > 0) {
		%>
		<div class="submit-result-popup" style="color: red;">Hồ sơ nộp <%= message %> chuyển khoản đã xác nhận không hợp lệ!</div>
		<%
		}
		%>
	<%
		}
	%>
<%
	}
%>

<script type="text/javascript">
$(document).ready(function () {
	<%-- $('.portlet-title-text').text('<%=title%>'); --%>
	
	$('.NUMERIC').keypress(function(event){   
	    // stop entering characters and backspace
	    if(event.which != 8 && isNaN(String.fromCharCode(event.which))){
	        event.preventDefault();
	    }  
	});
});

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
</html>