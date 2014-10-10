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
<%@page import="org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep"%>
<%@page import="org.oep.cmon.portlet.doanhnghiep.xacthuc.utils.XacThucDoanhNghiepUtils"%>
<%@page import="org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.kios.model.DanhSachThongKe"%>
<%@page import="org.oep.cmon.dao.kios.model.DanhSachCoQuan"%>
<%@page import="org.oep.cmon.dao.kios.service.DanhSachHoSoLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.oep.cmon.dao.kios.model.DanhSachHoSo"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
PortletURL demo = renderResponse.createRenderURL();
demo.setParameter("jspPage","/html/portlet/doanhnghiep/xacthuc/hocathe/hocathe.jsp");
PortletURL demo1 = renderResponse.createRenderURL();
demo1.setParameter("jspPage","/html/portlet/doanhnghiep/xacthuc/doanhnghiep/doanhnghiep.jsp");
%>
<a href="<%=demo.toString()%>">Hộ cá thể</a><br/>
<a href="<%=demo1.toString()%>">Doanh nghiệp</a>
<%
long loaiDoiTuongId = 0l;
int trangThai = 99;
String maOrTenOrEmail = "";
int total = 0;
/* //get request atts
if(Validator.isNotNull(request.getAttribute("loaiDoiTuongId"))){
	loaiDoiTuongId = Long.valueOf(request.getAttribute("loaiDoiTuongId").toString());
}
if(Validator.isNotNull(request.getAttribute("trangThai"))){
	trangThai = Integer.valueOf(request.getAttribute("trangThai").toString());
}
if(Validator.isNotNull(request.getAttribute("maOrTenOrEmail"))){
	maOrTenOrEmail = request.getAttribute("maOrTenOrEmail").toString();
} */
//get render params
if ( Validator.isNotNull(ParamUtil.getString(request,"loaiDoiTuongId")) ) {
	loaiDoiTuongId = ParamUtil.getLong(request,"loaiDoiTuongId");
}
if ( Validator.isNotNull(ParamUtil.getString(request,"trangThai")) ) {
	trangThai = ParamUtil.getInteger(request,"trangThai");
}
if ( Validator.isNotNull(ParamUtil.getString(request,"maOrTenOrEmail")) ) {
	maOrTenOrEmail = URLDecoder.decode(ParamUtil.getString(request,"maOrTenOrEmail"),StringPool.UTF8);
}
//end get param values
PortletURL pagingUrl = renderResponse.createRenderURL();
pagingUrl.setParameter("maOrTenOrEmail",URLEncoder.encode(maOrTenOrEmail,StringPool.UTF8));
pagingUrl.setParameter("trangThai",String.valueOf(trangThai));
pagingUrl.setParameter("loaiDoiTuongId",String.valueOf(loaiDoiTuongId));


PortletURL searchUrl = renderResponse.createActionURL();
searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchListYeuCau");

SearchContainer searchContainer = null;
int currentTransPage = ParamUtil.getInteger(request,"currentTransPage");
if (currentTransPage > 0) {
	searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			currentTransPage, 10, pagingUrl, null, null);
} else {
	searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM, 10,
			pagingUrl, null, null);
}

int start = searchContainer.getStart();
int end = searchContainer.getEnd();
//get total records here
total = XacThucDoanhNghiepUtils.countListYeuCauDangKy(maOrTenOrEmail, loaiDoiTuongId, trangThai);
List<YeuCauDangKyDoanhNghiep> listYeuCau = XacThucDoanhNghiepUtils.getListYeuCauDangKy(maOrTenOrEmail, loaiDoiTuongId, trangThai, start, end);

searchContainer.setTotal(total);
searchContainer.setResults(listYeuCau);

%>
<div>
	<liferay-ui:success  key="insert.success" message="org.oep.cmon.portlet.doanhnghiep.success.insert" />
</div>
<form method="post" action="<%= searchUrl %>" name="frmSearchYeuCau" id="frmSearchYeuCau">
	<table class="egov-table-form">	
		<tr>
			<td colspan="3" style="padding: 10px">
				<h3><b>Danh sách đăng ký tài khoản Doanh nghiệp/Hộ cá thể/Hợp tác xã</b></h3>
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" value="<%= maOrTenOrEmail %>" name="maOrTenOrEmail" style="width:70%;" class='egov-inputfield' placeholder="Nhập Mã, Email, Tên" />
				<input type="submit" value="Tìm kiếm" class="egov-button-search"/>
			</td>
			<td style="text-align: right;">
				<select name="loaiDoiTuongId" class="egov-select" onchange="searchYeuCauDangKy()">
					<option value="">Lọc theo đối tượng</option>
					<option value="<%=ThamSoLocalServiceUtil.getValue("LDT_HOKDCATHE")%>" <%=Long.valueOf(ThamSoLocalServiceUtil.getValue("LDT_HOKDCATHE"))==loaiDoiTuongId?"selected":""%>>Hộ kinh doanh cá thể</option>
					<option value="<%=ThamSoLocalServiceUtil.getValue("LDT_DOANHNGHIEP")%>" <%=Long.valueOf(ThamSoLocalServiceUtil.getValue("LDT_DOANHNGHIEP"))==loaiDoiTuongId?"selected":""%>>Doanh nghiệp</option>
					<option value="<%=ThamSoLocalServiceUtil.getValue("LDT_HOPTACXA")%>" <%=Long.valueOf(ThamSoLocalServiceUtil.getValue("LDT_HOPTACXA"))==loaiDoiTuongId?"selected":""%>>Hợp tác xã</option>
				</select>
			</td>
			<td style="text-align: right;padding-left: 10px">
				<select name="trangThai" class="egov-select" onchange="searchYeuCauDangKy()">
					<option value="">Lọc theo trạng thái</option>
					<option value="0" <%=trangThai==0?"selected":""%>>Đăng ký mới</option>
					<option value="1" <%=trangThai==1?"selected":""%>>Xác thực thành công</option>
					<option value="2" <%=trangThai==2?"selected":""%>>Đăng ký đã kích hoạt email</option>
					<option value="3" <%=trangThai==3?"selected":""%>>Không xác thực</option>
				</select>
			</td>
		</tr>
	</table>
</form>
<div style="width:100%;padding-top: 10px"></div>
<table class="egov-table">
	<thead>
		<tr>
			<th style="width: 15px;text-align: center;">STT</th>
			<th style="text-align: center;">Mã giấy phép</th>
			<th style="text-align: center;">Email</th>
			<th style="text-align: center;">Tên</th>
			<th style="text-align: center;">Địa chỉ</th>
			<th style="text-align: center;">Đối tượng</th>
			<th style="text-align: center;">Trạng thái</th>
			<th style="text-align: center;">Hành động</th>
		</tr>
	</thead>
	<tbody>
	<%
	int stt = 1;
	for(int i = 0;i<listYeuCau.size();i++){
		YeuCauDangKyDoanhNghiep yeuCau = listYeuCau.get(i);
		String loaiDoiTuong = "";
		if(yeuCau.getLoaiDoiTuongId()==Long.valueOf(ThamSoLocalServiceUtil.getValue("LDT_HOKDCATHE"))){
			loaiDoiTuong = "Hộ cá thể";
		}
		if(yeuCau.getLoaiDoiTuongId()==Long.valueOf(ThamSoLocalServiceUtil.getValue("LDT_DOANHNGHIEP"))){
			loaiDoiTuong = "Doanh nghiệp";
		}
		if(yeuCau.getLoaiDoiTuongId()==Long.valueOf(ThamSoLocalServiceUtil.getValue("LDT_HOPTACXA"))){
			loaiDoiTuong = "Hợp tác xã";
		}
		String strTrangThai = "";
		if(yeuCau.getTrangThai() == 0){
			strTrangThai = "Đăng ký mới";
		}
		if(yeuCau.getTrangThai() == 1){
			strTrangThai = "Xác thực thành công";
		}
		if(yeuCau.getTrangThai() == 2){
			strTrangThai = "Đăng ký đã kích hoạt email";
		}
		if(yeuCau.getTrangThai() == 3){
			strTrangThai = "Không xác thực";
		}
		PortletURL xacThucUrl = renderResponse.createActionURL();
		xacThucUrl.setParameter(ActionRequest.ACTION_NAME, "xacThucHoCaThe");
		xacThucUrl.setParameter("idYeuCau",String.valueOf(yeuCau.getId()));
		xacThucUrl.setParameter("maOrTenOrEmail",URLEncoder.encode(maOrTenOrEmail,StringPool.UTF8));
		xacThucUrl.setParameter("trangThai",String.valueOf(trangThai));
		xacThucUrl.setParameter("loaiDoiTuongId",String.valueOf(loaiDoiTuongId));
	%>
		<tr>
			<td style="text-align: center;"><%=stt+searchContainer.getStart() %></td>
			<td style="text-align: center;"><%=yeuCau.getMaGiayPhep() %></td>
			<td style="text-align: center;"><%=yeuCau.getEmail() %></td>
			<td><%=yeuCau.getTen() %></td>
			<td><%=yeuCau.getTruSo() %></td>
			<td style="text-align: center;"><%=loaiDoiTuong %></td>
			<td style="text-align: center;"><%=strTrangThai %></td>
			<td>
				<%
				if(yeuCau.getTrangThai()==2){
				%>
				<a href="<%=xacThucUrl%>">Xác thực</a>
				<%} %>
			</td>
		</tr>
	<%} %>
	</tbody>
</table>
<div style="width: 100%;padding: 10px 10px;">
	<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
</div>
<script>
	function searchYeuCauDangKy(){
		document.getElementById("frmSearchYeuCau").submit();
	}
</script>