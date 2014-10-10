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
long coQuanQuanLyId = 0l;
String searchInputText = ""; 
String parentId = "";
//get request atts
if(Validator.isNotNull(request.getAttribute("coQuanQuanLyId"))){
	coQuanQuanLyId = Long.valueOf(request.getAttribute("coQuanQuanLyId").toString());
}
if(Validator.isNotNull(request.getAttribute("searchInputText"))){
	searchInputText = request.getAttribute("searchInputText").toString();
}
if(Validator.isNotNull(request.getAttribute("parentId"))){
	parentId = request.getAttribute("parentId").toString();
}
CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(coQuanQuanLyId);
//end get params
List<ChucVu2VaiTro> listChucVu2VaiTro = new ArrayList<ChucVu2VaiTro>();
Set<Long> setChucVuId = new HashSet<Long>();
if(Validator.isNotNull(request.getAttribute("setChucVuId"))){
	setChucVuId = (Set<Long>)request.getAttribute("setChucVuId");
}
if(Validator.isNotNull(request.getAttribute("listChucVu2VaiTro"))){
	listChucVu2VaiTro = (List<ChucVu2VaiTro>)request.getAttribute("listChucVu2VaiTro");
}
//create new chuc vu URL
PortletURL createChucVu = renderResponse.createActionURL();
createChucVu.setParameter(ActionRequest.ACTION_NAME, "createChucVu");
createChucVu.setParameter("coQuanQuanLyId", String.valueOf(coQuanQuanLyId));
createChucVu.setParameter("parentId", parentId);
createChucVu.setParameter("searchInputText", searchInputText);
//back to list CQQL URL
PortletURL backToCQQLURL = renderResponse.createRenderURL();
backToCQQLURL.setParameter("parentId", parentId);
backToCQQLURL.setParameter("searchInputText", searchInputText);
%>
<div class="egov-container">

<div>
	<liferay-ui:error key="not.login.error" message="org.oep.cmon.admin.portlet.congchuc.err.not.login"/>
	<liferay-ui:error key="addChucVuError" message = "org.oep.cmon.admin.portlet.chucvu.err.create"/>
	<liferay-ui:error key="deleteChucVuError" message = "org.oep.cmon.admin.portlet.chucvu.err.delete"/>
	<liferay-ui:success key="createChucVuSuccess" message = "org.oep.cmon.admin.portlet.chucvu.success.create"/>
	<liferay-ui:success key="deleteChucVuSuccess" message = "org.oep.cmon.admin.portlet.chucvu.success.delete"/>
</div>
<div style="width: 100%;padding-top: 10px;padding-bottom: 10px">
	<h3>Danh sách chức vụ của: <%=coQuanQuanLy!=null?coQuanQuanLy.getTen():"" %></h3>
</div>
<div style="width: 100%;padding-top: 10px;padding-bottom: 10px;text-align: right;">
	<a href = "<%=createChucVu%>"><input type="button" value="+ THÊM MỚI"  class="egov-button-normal" /></a>
	<a href = "<%=backToCQQLURL%>"><input type="button" value="Quay lại danh sách"  class="egov-button-normal" /></a>
</div>
<%
if(setChucVuId.size()>0){
	int stt = 0;
%>
<div>
	
</div>
<table class="egov-table">
	<thead>
		<tr>
			<th style="width: 15px;text-align: center;">STT</th>
			<th style="text-align: center;">Chức vụ</th>
			<th style="text-align: center;">Vai trò</th>
			<th style="text-align: center;">Hành động</th>
		</tr>
	</thead>
	<tbody>
	<%
	int rowStyle = 1;
	for(long chucVuId : setChucVuId){
		stt++;
		//edit chuc vu URL
		PortletURL editChucVuURL = renderResponse.createActionURL();
		editChucVuURL.setParameter(ActionRequest.ACTION_NAME, "editChucVu");
		editChucVuURL.setParameter("chucVuId",String.valueOf(chucVuId));
		editChucVuURL.setParameter("coQuanQuanLyId",String.valueOf(coQuanQuanLyId));
		editChucVuURL.setParameter("parentId", parentId);
		editChucVuURL.setParameter("searchInputText", searchInputText);
		//delete chuc vu URL
		PortletURL deleteChucVuURL = renderResponse.createActionURL();
		deleteChucVuURL.setParameter(ActionRequest.ACTION_NAME, "deleteChucVu");
		deleteChucVuURL.setParameter("chucVuId",String.valueOf(chucVuId));
		deleteChucVuURL.setParameter("coQuanQuanLyId",String.valueOf(coQuanQuanLyId));
		deleteChucVuURL.setParameter("parentId", parentId);
		deleteChucVuURL.setParameter("searchInputText", searchInputText);
		//add chuc vu to another CQQL
		PortletURL addChucVu2CQQLURL = renderResponse.createRenderURL();
		addChucVu2CQQLURL.setParameter("jspPage", "/html/portlet/admin/congchuc/coquanquanly/addchucvutocqql.jsp");
		addChucVu2CQQLURL.setWindowState(LiferayWindowState.POP_UP);
		addChucVu2CQQLURL.setParameter("chucVuId",String.valueOf(chucVuId));
		addChucVu2CQQLURL.setParameter("coQuanQuanLyId",String.valueOf(coQuanQuanLyId));
	%>
	<tr class="bgcolor-<%=rowStyle%>">
		<td style="text-align: center;"><%=stt %></td>
		<td><%=ChucVuLocalServiceUtil.fetchChucVu(chucVuId).getTen()%></td>
		<td>
			<%
			for(int i = 0; i< listChucVu2VaiTro.size();i++){
				ChucVu2VaiTro cv2vt = listChucVu2VaiTro.get(i); 
				if(cv2vt.getChucVuId()==chucVuId){
				String vaiTroName = VaiTroLocalServiceUtil.getVaiTro(cv2vt.getVaiTroId()).getTen();
			%>
			- <%=vaiTroName %><%=i==(listChucVu2VaiTro.size()-1)?"":"<br/>" %>
			<%
				}
			} %>
		</td>
		<td style="text-align: center;">
			<a href="<%=editChucVuURL.toString()%>"><button class="egov-func-edit" title="Chỉnh sửa" ></button></a>
			<a href="<%=deleteChucVuURL.toString()%>"  onclick = "return confirmDelete()"><button class="egov-func-delete" title="Xóa" ></button></a>
			<a href="#" onclick="openWindow('<%=addChucVu2CQQLURL%>')"><button class="egov-func-add" title="Áp dụng cho cơ quan khác" ></button></a>
		</td>
	</tr>
	<%
		rowStyle = rowStyle==1?2:1;
	}
	%>
	</tbody>
</table>
<%
}else{
%>
<h3>CHƯA CÓ CHỨC VỤ NÀO</h3>
<%} %>
<div style="margin-top: 10px;margin-bottom: 10px">
	
</div>
</div>
<script type = "text/javascript">
	function confirmDelete(){
		return confirm("Bạn thực sự muốn xóa chức vụ này?");
	}
</script>
