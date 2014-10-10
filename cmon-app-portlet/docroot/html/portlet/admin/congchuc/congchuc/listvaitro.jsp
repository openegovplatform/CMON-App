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
<%@page import="org.oep.cmon.dao.nsd.service.TaiNguyenLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiNguyen2VaiTroLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="org.oep.cmon.dao.nsd.service.VaiTroLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.ChucVu2VaiTroLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro"%>
<%@page import="org.oep.cmon.dao.cc.model.ChucVu"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
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
<script type="text/javascript">

	function openWindow(url) {
		var newWindow = window.open(url,'Search popup','height=350,width=700,left=90,top=100,resizable=no,location=no,status=no,menubar=no,scrollbars=yes');

		if (window.focus) {
			newWindow.focus();
		}

		return false;
	} 
</script>
<%
//define variables
long congChucId = 0l;
long coQuanQuanLyId = 0l;
String maOrTenOrEmail = "";
//get request atts
if(Validator.isNotNull(request.getAttribute("congChucId"))){
	congChucId = Long.valueOf(request.getAttribute("congChucId").toString());
}
if(Validator.isNotNull(request.getAttribute("coQuanQuanLyId"))){
	coQuanQuanLyId = Long.valueOf(request.getAttribute("coQuanQuanLyId").toString());
}
if(Validator.isNotNull(request.getAttribute("maOrTenOrEmail"))){
	maOrTenOrEmail = request.getAttribute("maOrTenOrEmail").toString();
}
//end get params
CongChuc congChuc = CongChucLocalServiceUtil.fetchCongChuc(congChucId);
ChucVu chucVu = null;
List<ChucVu2VaiTro> listChucVu2VaiTro = new ArrayList<ChucVu2VaiTro>();
if(Validator.isNotNull(request.getAttribute("listChucVu2VaiTro"))){
	chucVu = ChucVuLocalServiceUtil.fetchChucVu(congChuc.getChucVuId());
}
if(Validator.isNotNull(request.getAttribute("listChucVu2VaiTro"))){
	listChucVu2VaiTro = (List<ChucVu2VaiTro>)request.getAttribute("listChucVu2VaiTro");
}
List<NguoiDung2VaiTro> listNguoiDung2VaiTro = new ArrayList<NguoiDung2VaiTro>();
if(Validator.isNotNull(request.getAttribute("listNguoiDung2VaiTro"))){
	listNguoiDung2VaiTro = (List<NguoiDung2VaiTro>)request.getAttribute("listNguoiDung2VaiTro");
}

%>
<div class="egov-container">
<div>
	<liferay-ui:error key="deleteVaiTroError" message = "org.oep.cmon.admin.portlet.vaitro.err.delete"/>
	<liferay-ui:success key="deleteVaiTroSuccess" message = "org.oep.cmon.admin.portlet.vaitro.success.delete"/>
</div>
<div style=" width:100% ;margin-top: 10px;margin-bottom: 10px">
	<h3>Quyền hạn của cán bộ: <%=congChuc!=null?congChuc.getHoVaTen():"" %></h3>
</div>
<%
if(chucVu!=null){
%>
<fieldset style="padding: 20px 30px 20px 30px !important">
	<legend>Quyền hạn của chức vụ: <%=chucVu.getTen() %></legend>
	<table class="egov-table">
		<thead>
			<tr>
				<th style="width: 15px;text-align: center;">STT</th>
				<th style="text-align: center;">Tên quyền hạn</th>
				<th style="text-align: center;">Tài nguyên sử dụng</th>
			</tr>
		</thead>
		<tbody>
		<%
		int stt = 0;
		int rowStyle = 1;
		for(ChucVu2VaiTro chucVu2VaiTro : listChucVu2VaiTro){
			stt++;
			List<TaiNguyen2VaiTro> listTaiNguyen2VaiTro = TaiNguyen2VaiTroLocalServiceUtil.findByVaiTroID(chucVu2VaiTro.getVaiTroId(), 0);
		%>
		<tr class="bgcolor-<%=rowStyle%>">
			<td style="text-align: center;"><%=stt %></td>
			<td><%=VaiTroLocalServiceUtil.fetchVaiTro(chucVu2VaiTro.getVaiTroId()).getTen()%></td>
			<td>
				<%
				for(int i = 0; i< listTaiNguyen2VaiTro.size();i++){
					TaiNguyen2VaiTro tn2vt = listTaiNguyen2VaiTro.get(i); 
					String taiNguyenName = TaiNguyenLocalServiceUtil.fetchTaiNguyen(tn2vt.getTaiNguyenId()).getTen();
				%>
				- <%=taiNguyenName %><%=i==(listTaiNguyen2VaiTro.size()-1)?"":"<br/>" %>
				<%
					}
				%>
			</td>
		</tr>
		<%
			rowStyle = rowStyle==1?2:1;
		}
		%>
		</tbody>
	</table>
</fieldset>
<%} %>
<div style="margin-top: 10px;margin-bottom: 10px"></div>
<%
//add chuc vu to another CQQL
PortletURL addVaiTroToCanBoURL = renderResponse.createRenderURL();
addVaiTroToCanBoURL.setParameter("jspPage", "/html/portlet/admin/congchuc/congchuc/addvaitrotocanbo.jsp");
addVaiTroToCanBoURL.setWindowState(LiferayWindowState.POP_UP);
addVaiTroToCanBoURL.setParameter("congChucId",String.valueOf(congChucId));
%>
<fieldset style="padding: 20px 30px 20px 30px !important" >
	<legend>Quyền riêng</legend>
	<div style="width: 100%;text-align: right;margin-bottom: 10px">
		<button onclick="openWindow('<%=addVaiTroToCanBoURL%>')" class="egov-button-normal">Gán quyền riêng</button>
	</div>
	<table class="egov-table">
		<thead>
			<tr>
				<th style="width: 15px;text-align: center;">STT</th>
				<th style="text-align: center;">Tên quyền hạn</th>
				<th style="text-align: center;">Tài nguyên sử dụng</th>
				<th style="text-align: center;">Hành động</th>
			</tr>
		</thead>
		<tbody>
		<%
		int stt = 0;
		for(NguoiDung2VaiTro nguoiDung2VaiTro : listNguoiDung2VaiTro){
			stt++;
			List<TaiNguyen2VaiTro> listTaiNguyen2VaiTro = TaiNguyen2VaiTroLocalServiceUtil.findByVaiTroID(nguoiDung2VaiTro.getVaiTroId(), 0);
			//delete chuc vu URL
			PortletURL deleteVaiTroURL = renderResponse.createActionURL();
			deleteVaiTroURL.setParameter(ActionRequest.ACTION_NAME, "deleteVaiTroToCanBo");
			deleteVaiTroURL.setParameter("congChucId",String.valueOf(congChucId));
			deleteVaiTroURL.setParameter("vaiTroId", String.valueOf(nguoiDung2VaiTro.getVaiTroId()));
			deleteVaiTroURL.setParameter("maOrTenOrEmail",maOrTenOrEmail);
			deleteVaiTroURL.setParameter("coQuanQuanLyId",String.valueOf(coQuanQuanLyId));
		%>
		<tr>
			<td style="text-align: center;"><%=stt %></td>
			<td><%=VaiTroLocalServiceUtil.fetchVaiTro(nguoiDung2VaiTro.getVaiTroId()).getTen()%></td>
			<td>
				<%
				for(int i = 0; i< listTaiNguyen2VaiTro.size();i++){
					TaiNguyen2VaiTro tn2vt = listTaiNguyen2VaiTro.get(i); 
					String taiNguyenName = TaiNguyenLocalServiceUtil.fetchTaiNguyen(tn2vt.getTaiNguyenId()).getTen();
				%>
				- <%=taiNguyenName %><%=i==(listTaiNguyen2VaiTro.size()-1)?"":"<br/>" %>
				<%
					}
				%>
			</td>
			<td style="text-align: center;">
				<a href="<%=deleteVaiTroURL.toString()%>"  onclick = "return confirmDelete()">Xóa</a>
			</td>
		</tr>
		<%}%>
		</tbody>
	</table>
</fieldset>
<%
PortletURL listCongChucURL = renderResponse.createRenderURL();
listCongChucURL.setParameter("tab", "CC");
listCongChucURL.setParameter("maOrTenOrEmail",maOrTenOrEmail);
listCongChucURL.setParameter("coQuanQuanLyId",String.valueOf(coQuanQuanLyId));
%>
<div style="width: 100%;margin-top: 10px;margin-bottom: 10px;text-align: left;">
	<a href="<%=listCongChucURL %>"><button class="egov-button-normal">Quay lại danh sách</button></a>
</div>
</div>
<%
//can bo quyen han URL
PortletURL congChucQuyenURL = renderResponse.createActionURL();
congChucQuyenURL.setParameter(ActionRequest.ACTION_NAME, "quyenCongChuc");
congChucQuyenURL.setParameter("congChucId",String.valueOf(congChucId));
congChucQuyenURL.setParameter("maOrTenOrEmail",maOrTenOrEmail);
congChucQuyenURL.setParameter("coQuanQuanLyId",String.valueOf(coQuanQuanLyId));
%>
<script type = "text/javascript">
	function confirmDelete(){
		return confirm("Bạn thực sự muốn xóa vai trò này?");
	}
	function funcTest(){
		window.location = "<%=congChucQuyenURL%>";
	}
</script>
