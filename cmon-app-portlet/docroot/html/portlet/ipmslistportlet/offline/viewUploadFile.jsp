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
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.tlct.model.TaiLieuChungThuc"%>
<%@page import="org.oep.cmon.portlet.ipmslist.utils.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.FileDinhKem"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page import="java.math.BigDecimal"%>

<%@page import="java.util.ArrayList"%>

<%@include file="/html/portlet/ipmslistportlet/offline/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%
String id_danh_sach_ho_so = "";
if (request.getParameter("HosotthcCongId") != null) {
	id_danh_sach_ho_so = request.getParameter("HosotthcCongId").toString();
}


HoSoTTHCCong hoSoTTHCCong = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(Long.parseLong(id_danh_sach_ho_so));
List<FileDinhKem> liFileUploadsIservice1 = ConvertUtil.convertFromObjectToFileDinhKem(
		FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(hoSoTTHCCong.getId()));
List<FileDinhKem> liFileUploadsIserviceKhongGiaiDoan = ConvertUtil.convertFromObjectToFileDinhKem(
		FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoan(hoSoTTHCCong.getId()));

%>
<div id="wd-content-container" style="min-width: 100px;">
	<div class="wd-center">
		<div id="wd-register-business">
			<div class="wd-register-form-01 wd-register-form-02 wd-register-form-04" style="padding-top: 0px;">
				<fieldset class="wd-register-business">
					<table width="100%">
						<tr style="background-color: #3A88CB;">
							<td width="8%" valign="middle" style="color:white;"><strong>TT</strong></td>
							<td width="92%" style="text-align:left;color:white;"><strong>Tên giấy tờ</strong></td>
						</tr>
						<%
						int counter = 1;
						TaiLieuChungThuc taiLieuChungThuc = null;
						for (FileDinhKem fileUpload : liFileUploadsIserviceKhongGiaiDoan) {
							taiLieuChungThuc = ConvertUtil.getTaiLieuChungThucFromNoiLuuTruTaiLieuId(fileUpload);
							if (taiLieuChungThuc != null) {
							%>
							<tr>
								<td> <%= counter++ %> </td>
								<td>
									<a href="<%=ConvertUtil.getURLFromNoiLuuTruId(taiLieuChungThuc.getNoiLuuTruId()) %>" id = "<%=fileUpload.getNoiLuuTruTaiLieuId() %>" style="display: inherit;"><%=taiLieuChungThuc.getTen() %></a>
								</td>
							</tr>
						<%
							}
						}
						%>
						<%
						for (FileDinhKem fileUpload : liFileUploadsIservice1) {
							taiLieuChungThuc = ConvertUtil.getTaiLieuChungThucFromNoiLuuTruTaiLieuId(fileUpload);
							if (taiLieuChungThuc != null) {
							%>
							<tr>
								<td> <%= counter++ %> </td>
								<td>
									<a href="<%=ConvertUtil.getURLFromNoiLuuTruId(taiLieuChungThuc.getNoiLuuTruId()) %>" id = "<%=fileUpload.getNoiLuuTruTaiLieuId() %>" style="display: inherit;"><%=taiLieuChungThuc.getTen() %></a>
								</td>
							</tr>
						<%
							}
						}
						%>
					</table>
				</fieldset>
			</div>
		</div>
	</div>
</div>