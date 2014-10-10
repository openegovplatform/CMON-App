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
<%@page import="org.oep.egovcore.util.StringPool"%>
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.cmon.portlet.document.business.ThuTucHanhChinhBusiness"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="egov" uri="/WEB-INF/tld/egov.tld"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
 	long thuTucId = ParamUtil.getLong(request, "thuTucId");
	StringBuilder backURL = new StringBuilder(ParamUtil.getString(request, "backURL"));
	
	LiferayURL saveURL = LiferayURL.createActionURL(request, "luuCauHinhLienThong");
	
	ThuTucHanhChinh thuTuc = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(thuTucId);
	
	NhomThuTucHanhChinh nhomThuTuc = 
		NhomThuTucHanhChinhLocalServiceUtil.fetchNhomThuTucHanhChinh(thuTuc.getNhomThuTucHanhChinhId());
	
	DanhMucUngDung ungDung =
		DanhMucUngDungLocalServiceUtil.fetchDanhMucUngDung(nhomThuTuc.getDanhMucUngDungId());
	
	List<ThongTinThuTuc> list = 
		ThuTucHanhChinhLocalServiceUtil.getDSThongTinThuTucByUngDung(ungDung.getId());
	
	backURL
		.append(StringPool.AMPERSAND).append("ungDung").append(StringPool.EQUAL).append(ungDung.getId())
		.append(StringPool.AMPERSAND).append("nhomTTHC").append(StringPool.EQUAL).append(nhomThuTuc.getId())
	;
%>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/core.css"/>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/egovUI.css"/>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/customEgovTheme.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/egovUI.js"></script>
<div class="egov-container _outer">
	<div class="_wrapper mix">
		<h1 class="lv1-title">
			<label class="lv1-title-text">
				Cấu hình thủ tục liên thông
			</label>
		</h1>
		<div class="line ">
			<div class="item">
				<label class="egov-label strong">
					Thủ tục:
				</label>
				<label class="egov-label">
					<c:out value="<%= thuTuc.getTen() %>"/>
				</label>
			</div>
		</div>
		<div class="line ">
			<div class="item">
				<label class="egov-label strong">
					Thuôc nhóm:
				</label>
				<label class="egov-label">
					<c:out value="<%= nhomThuTuc.getTen() %>"/>
				</label>
			</div>
		</div>
		<div class="line ">
			<div class="item">
				<label class="egov-label strong">
					Thuộc ứng dụng:
				</label>
				<label class="egov-label">
					<c:out value="<%= ungDung.getTen() %>"/>
				</label>
			</div>
		</div>
		<form method="post" action="<%= saveURL %>">
			<input type="hidden" name="thuTucId" value="<%= thuTucId %>" />
			<input type="hidden" name="redirectURl" value="<%= backURL %>" />
			<div class="fi">
				<div class="fi-wrapper">
					<div class="fi-label">
						<label class="egov-label-bold">
							Liên thông với thủ tục:
						</label>
					</div>
					<div class="fi-input">
						<select 
							class="egov-select"
							name="thuTucLienThongId"
							auto-tooltip
						>
							<option value="0" class="default">- Không liên thông với thủ tục nào cả - </option>
							<egov:option-list 
								data="<%= list %>"
								selectedValue="<%= thuTuc.getThuTucLienThongId() %>"
								isGroupable="<%= true %>"
							/>
						</select>
					</div>
				</div>
			</div>
			<div class="hidden-sep">&nbsp;</div>
			<div class="button-bar">
				<button type="submit" class="egov-button">Lưu cấu hình</button>
				<button type="button" class="egov-button" onclick="location.href='<%= backURL %>'">Quay lại</button>
			</div>
			<div class="hidden-sep">&nbsp;</div>
		</form>
	</div>
</div>