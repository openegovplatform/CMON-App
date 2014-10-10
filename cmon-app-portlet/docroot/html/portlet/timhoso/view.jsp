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
<%@page import="org.oep.cmon.dao.tlct.model.TaiLieuChungThuc"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.FileDinhKem"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="org.oep.cmon.timhoso.portlet.utils.TimHoSoUtils"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects />
<%
String searchKeyWord = "";
if (renderRequest.getParameter("searchKeyWord") != null) {
	searchKeyWord = renderRequest.getParameter("searchKeyWord");
}

PortletURL searchUrl = renderResponse.createActionURL();
searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchHoSoByMa");

List<HoSoTTHCCong> listHoSoTTHCCongs = null;
boolean search = false;
if (searchKeyWord.trim().length() > 0) {
	listHoSoTTHCCongs = HoSoTTHCCongLocalServiceUtil.findByMaSoBienNhan(searchKeyWord);
	search = true;
}
if (listHoSoTTHCCongs == null) {
	listHoSoTTHCCongs = new ArrayList<HoSoTTHCCong>();
}

%>
<div class="egov-container">
	<form name = "searchForm" method = "post" action = "<%=searchUrl%>">
		<table class="egov-table-form">
		  <caption>
		  	<label class="egov-label-header">
		  		Tra cứu thông tin hồ sơ
		  	</label>
		  </caption>
		  <tr>
		    <td align = "left">
		    	<label class ="egov-label-bold">Mã số hồ sơ:</label>
		    	<input name="searchKeyWord" id="searchKeyWord" type="text" size = "30" maxlength="30" class = "egov-inputfield custom" value = "<%=searchKeyWord%>"/>		    
		    </td>
		    <td align = "left">
		    	<input type="submit" value=""  class="egov-button-search" />
		    </td>
		  </tr>
		</table>
	</form>

<%
if (listHoSoTTHCCongs.size() > 0) {
	HoSoTTHCCong hoSoTTHCCong = listHoSoTTHCCongs.get(0);
	long uid = PortalUtil.getUserId(request);
	//TaiKhoanNguoiDung nguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(uid);
	//List<FileDinhKem> liFileUploads = TimHoSoUtils.convertFromObjectToFileDinhKem(FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(hoSoTTHCCong.getId(), 3));
	//List<FileDinhKem> liFileUploads = TimHoSoUtils.convertFromObjectToFileDinhKem(FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(hoSoTTHCCong.getId(), 3));
	%>
	<br>
	<table class="egov-table-form">
		<tr>
			<td>
				<label class ="egov-label-bold">Tên thủ tục hành chính:</label>
			</td>
			<td>
				<input class = "egov-inputfield custom" readonly="readonly" value="<%=hoSoTTHCCong.getTenThuTucHanhChinh() %>" type="text" size="50" multiple="multiple"/>
			</td>
		</tr>
		<tr>
			<td>
				<label class ="egov-label-bold">Ngày tiếp nhận:</label>
			</td>
			<td>
				<input class = "egov-inputfield custom" readonly="readonly" value="<%=TimHoSoUtils.parseDateToTring(hoSoTTHCCong.getNgayNhanHoSo()) %>" type="text" size="50"/>
			</td>
		</tr>
		<tr>
			<td>
				<label class ="egov-label-bold">Ngày hẹn trả kết quả:</label>
			</td>
			<td>
				<input class = "egov-inputfield custom" readonly="readonly" value="<%=TimHoSoUtils.parseDateToTring(hoSoTTHCCong.getNgayHenTraKetQua()) %>" type="text" size="50"/>
			</td>
		</tr>
		<tr>
			<td>
				<label class ="egov-label-bold">Trạng thái hồ sơ:</label>
			</td>
			<td>
				<input class = "egov-inputfield custom" readonly="readonly" value="<%=TimHoSoUtils.getTrangThaiHoSo(TimHoSoUtils.getTrangThaiHoSoAnhXa(hoSoTTHCCong.getId(), hoSoTTHCCong.getTrangThaiHoSo())) %>" type="text" size="50"/>
			</td>
		</tr>
		<tr>
			<td valign="top">
				<label class ="egov-label-bold">Kết quả xử lý:</label>
			</td>
			<td align="left">
			     <%
			     if(hoSoTTHCCong.getTrangThaiHoSo()==6 || hoSoTTHCCong.getTrangThaiHoSo()==5 || hoSoTTHCCong.getTrangThaiHoSo()==8)  {
			    	 if(FileDinhKemLocalServiceUtil.getFileTraKetQua(hoSoTTHCCong.getId()) !=null) {
			    		 String fileUrl = FileDinhKemLocalServiceUtil.getFileTraKetQua(hoSoTTHCCong.getId());
			     %>
			     <a href="<%=fileUrl %>" style="display: inherit;"><liferay-ui:icon image="download"/>Tải xuống</a>
				<%
			    	 }
			     }
				%>
			</td>
		</tr>
	</table>
	<%
} else if (listHoSoTTHCCongs.size() == 0 && search){
	%>
    <table class="egov-table-form">
        <tr>
            <td>
                <label style="color: red;">Không tìm được hồ sơ nào có mã số : <%=searchKeyWord %></label>
            </td>
        </tr>
    </table>
	<%
}
%>
</div>
