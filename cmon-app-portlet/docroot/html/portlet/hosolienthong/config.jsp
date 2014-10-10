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
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="org.oep.egovcore.util.StringPool"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTBusinessUtil"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTFields"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<portlet:defineObjects />
<%
	PortletPreferences pref = PortletPreferencesFactoryUtil.getPortletSetup(
		renderRequest, 
		ParamUtil.getString(renderRequest, "portletResource")
	);

	String loaiDanhSach = pref.getValue(
		HSLTFields.loaiDanhSach,
		HSLTBusinessUtil.LDS_NOI_NHAN
	);
%>
<form action='<liferay-portlet:actionURL portletConfiguration="true"/>' method="post">
	<h1 class="center septop20 sepbot20 upper">
		Cấu hình dánh sách hồ sơ liên thông
	</h1>
	<div class="fi">
		<div class="fi-wrapper">
			<div class="fi-label">
				<label class="egov-label-bold">
					Loại danh sách
				</label>
				<label class="egov-label-red"> * </label>
			</div>
			<div class="fi-input">
				<select class="egov-select" name="<%=HSLTFields.loaiDanhSach%>">
					<option value="<%=HSLTBusinessUtil.LDS_NOI_GUI%>"
						<%=HSLTBusinessUtil.LDS_NOI_GUI.equals(loaiDanhSach) 
							? StringPool.SELECTED 
							: StringPool.BLANK%>
					>
						Hồ sơ đã gửi liên thông
					</option>
					<option value="<%=HSLTBusinessUtil.LDS_NOI_NHAN%>"
						<%=HSLTBusinessUtil.LDS_NOI_NHAN.equals(loaiDanhSach) 
							? StringPool.SELECTED 
							: StringPool.BLANK%>
					>
						Hồ sơ chờ tiếp nhận liên thông
					</option>
				</select>
			</div>
		</div>
	</div>
	<div class="hidden-sep">&nbsp;</div>
	<div class="button-bar">
		<button class="egov-button" type="submit">
			Lưu cấu hình
		</button>
	</div>
</form>