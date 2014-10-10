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
<%@page import="org.oep.cmon.touchscreen.portlet.util.TouchscreenUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="org.oep.cmon.report.portlet.util.ActionAdminUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
	String id_donvi = "";
	String idTTHC = "";
	if(Validator.isNotNull(request.getParameter("idTTHC"))){
		idTTHC = request.getParameter("idTTHC");
	}
	if(Validator.isNotNull(request.getParameter("id_donvi"))){
		id_donvi = request.getParameter("id_donvi");
	}
	if(!idTTHC.equals("")){
		ThuTucHanhChinh thuTuc = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(Long.valueOf(idTTHC));
		PortletURL tthcsubdetails = renderResponse.createRenderURL();
		tthcsubdetails.setParameter("jspPage","/html/portlet/touchscreen/view.jsp");
		tthcsubdetails.setParameter("viewPage","/html/portlet/touchscreen/tthcsubdetails.jsp");
		tthcsubdetails.setParameter("idTTHC",idTTHC);
		tthcsubdetails.setParameter("id_donvi",id_donvi);
		PortletURL tthctthc = renderResponse.createRenderURL();
    		tthctthc.setParameter("jspPage","/html/portlet/touchscreen/view.jsp");
    		tthctthc.setParameter("viewPage","/html/portlet/touchscreen/tthctthc.jsp");
    		tthctthc.setParameter("idNhomTTHC",String.valueOf(thuTuc.getNhomThuTucHanhChinhId()));
    		tthctthc.setParameter("id_donvi",id_donvi);
%>
<div class="content-block">
	<div class="header-block">
		<div class="breadcrumb">
			<div class="breadcrumb-title first">
				<h4>
					<span>THỦ TỤC HÀNH CHÍNH</span>
				</h4>
			</div>

			<div class="breadcrumb-title-1">
				<h4>
					<span><%=NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(thuTuc.getNhomThuTucHanhChinhId()).getTen() %></span>
				</h4>
			</div>

			<div class="breadcrumb-title-2 last">
				<h4>
					<p><%=thuTuc.getTen() %></p>
				</h4>
			</div>
		</div>
	</div>
	<!--/header-block-->
	<div class="detailgroup-block">
		<div class="detail-col col-first">
			<div>
				<table class="detail-table">
					<tr>
						<td class="bold color"><p>Trình tự thực hiện</p></td>
						<td class="color">
							<p><%=TouchscreenUtil.trimString(thuTuc.getTrinhTuThucHien().toString(),500) %></p>
							<%
								tthcsubdetails.setParameter("detailType","trinhtuthuchien");
							%>
							<a class="detail-button" href="<%=tthcsubdetails.toString()%>">Chi tiết</a>
						</td>
					</tr>
					<tr>
						<td class="bold color"><p>Cách thực hiện</p></td>
						<td class="color"><p><%=thuTuc.getCachThucHien() %></p></td>
					</tr>
					<tr>
						<td class="bold color"><p>Số ngày xử lý</p></td>
						<td class="color"><p><%=thuTuc.getSoNgayXuLy() %></p></td>
					</tr>
					<tr>
						<td class="bold color"><p>Lệ phí</p></td>
						<td class="color"><p><%=thuTuc.getLePhi() %>&nbsp;<%=thuTuc.getDonViLePhi() %></p></td>
					</tr>
					<tr>
						<td class="bold color"><p>Phí</p></td>
						<td class="color"><p><%=thuTuc.getPhi() %>&nbsp;<%=thuTuc.getDonViPhi() %></p></td>
					</tr>
					<tr>
						<td class="bold color"><p>Yêu cầu, điều kiện thực hiện</p></td>
						<td class="color"><p><%=thuTuc.getYeuCauDieuKienThucHien() %></p>
					</tr>
				</table>
			</div>
		</div>
		<!--/col-first-->
		<div class="detail-col col">
			<div>
				<table class="detail-table">
					<tr>
						<td class="bold color"><p>Thành phần hồ sơ</p></td>
					</tr>
					<tr>
						<td class="color">
							<p><%=TouchscreenUtil.trimString(thuTuc.getThanhPhanHoSo(),1000) %></p>
							<%
								tthcsubdetails.setParameter("detailType","thanhphanhoso");
							%>
							<a class="detail-button" href="<%=tthcsubdetails.toString()%>">Chi tiết</a>
						</td>
					</tr>
					<tr>
						<td class="bold color">
							<p>Số lượng: 
							<span class="no-bold"><%=thuTuc.getPhienBan() %>&nbsp;bộ</span></p>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<!--/col-->
		<div class="detail-col col-last">
			<div>
				<table class="detail-table">
					<tr>
						<td class="bold color"><p>Căn cứ pháp lý</p></td>
					</tr>
					<tr>
						<td class="color">
							<p><%=TouchscreenUtil.trimString(thuTuc.getCanCuPhapLy(),800) %></p> 
							<%
								tthcsubdetails.setParameter("detailType","cancuphaply");
							%>
							<a class="detail-button" href="<%=tthcsubdetails.toString()%>">Chi tiết</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	
	<!--/detailgroup-block-->
	<div class="back-button">
		<a href="<%=tthctthc.toString()%>">Trở lại</a>
	</div>
</div>
<%} %>