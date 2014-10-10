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
<%@page import="org.oep.cmon.dao.nsd.model.VaiTro"%>
<%@page import="org.oep.cmon.dao.cc.model.ChucVu"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.qlhc.service.ChucVu2VaiTroLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro"%>
<%@page import="org.oep.cmon.admin.portlet.business.ChucVuVaiTroBusiness"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<body>
<%
String coQuanQuanLyId = renderRequest.getParameter("coQuanQuanLyId");
String chucVuVaiTroId = "";
if (renderRequest.getParameter("chucVuVaiTroId") != null) {
	chucVuVaiTroId = renderRequest.getParameter("chucVuVaiTroId");
}

PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "editOrAddChucVuVaiTroRequest");

String keyWord = renderRequest.getParameter("searchKeyWord");
String actionTyPe= ParamUtil.getString(request, "ActionType");

ChucVu2VaiTro quocGia = null;

if (chucVuVaiTroId != null) {
	quocGia = ChucVu2VaiTroLocalServiceUtil.fetchChucVu2VaiTro(ConvertUtil.convertToLong(chucVuVaiTroId));
}
CoQuanQuanLy coQuanQuanLy = ChucVuVaiTroBusiness.getCoQuanQuanLyByIdCoQuanQuanLy(coQuanQuanLyId);
%>
<div class="wd-main-content">	
		<form id="quocGiaForm" name="quocGiaForm" method="post" action="<%=actionUrl.toString() %>">
		  <table border="0">
		    <tr>
		      <td colspan="3" align = "left">	
				<liferay-ui:error key="emptyChucVuIdChucVu2VaiTro" message = "org.oep.cmon.admin.coquanquanly.chucvu.vaitro.error.empty.chucvuid"/>
				<liferay-ui:error key="emptyVaiTroIdChucVu2VaiTro" message = "org.oep.cmon.admin.coquanquanly.chucvu.vaitro.error.empty.vaitroid"/>
				<liferay-ui:error key="exitChucVu2VaiTro" message = "org.oep.cmon.admin.coquanquanly.chucvu.vaitro.error.exit"/>
				<liferay-ui:error key="errorAddChucVu2VaiTro" message = "org.oep.cmon.admin.coquanquanly.chucvu.vaitro.error.add"/>
				<liferay-ui:error key="errorUpdateChucVu2VaiTro" message = "org.oep.cmon.admin.coquanquanly.chucvu.vaitro.error.update"/>
				<%
				if (ParamUtil.getString(request, "CompletedUpdateChucVu2VaiTro") != null && ParamUtil.getString(request, "CompletedUpdateChucVu2VaiTro").trim().length() > 0) {
					%>
					<font color="blue"><liferay-ui:message key="org.oep.cmon.admin.coquanquanly.chucvu.vaitro.completed.update"/></font>					
					<%
				}
				if (ParamUtil.getString(request, "CompletedAddChucVu2VaiTro") != null && ParamUtil.getString(request, "CompletedAddChucVu2VaiTro").trim().length() > 0) {
					%>
					<font color="blue">
						<liferay-ui:message key="org.oep.cmon.admin.coquanquanly.chucvu.vaitro.completed.add"/>
					</font>					
					<%
				}
				%>
				<input type="hidden" name = "actionType" id = "actionType" value = "<%= actionTyPe%>"/>
				<input type="hidden" name = "coQuanQuanLyId" id = "coQuanQuanLyId" value = "<%= coQuanQuanLyId%>"/>
				<input type="hidden" name = "chucVuVaiTroId" id = "chucVuVaiTroId" value = "<%= chucVuVaiTroId%>"/>
				<%
				if (keyWord != null) {
				%>
					<input type="hidden" name = "searchKeyWord" id = "searchKeyWord" value = "<%=keyWord%>"/>
				<%} %>
			  </td>	
		    </tr>
		    <tr>
		      <td width="50%">
		      		<label class ="egov-label">Mã cơ quan quản lý </label>
		      </td>
		      <td>
		      		<%=coQuanQuanLy.getMa() %>
		      </td>
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Tên cơ quan quản lý</label>
		      </td>
		      <td>
		      		<%=coQuanQuanLy.getTen() %>
		      </td>
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Chức vụ</label>
		      </td>
		      <td>
		      		<%
		      			List<ChucVu> listChucVu = ChucVuVaiTroBusiness.findChucVuByTrangThai();
		      		%>
		      		<%
		    	if (actionTyPe.compareTo(ChucVuVaiTroBusiness.VIEW_CHUC_VU_VAI_TRO) == 0) {
		    		%>
		    		<select id="chucVuId" name="chucVuId" class="egov-select custom" disabled="disabled">
		    		<%
		    	} else {
		    		%>
		    		<select id="chucVuId" name="chucVuId" class="egov-select custom" >
		    		<%
		    	}
		    %>
		      		<%
			      		if (quocGia == null) {
		      				%>
		      				<option value = "">Chọn chức vụ</option>
		      				<%
		      			}
		      			for (ChucVu chucVu : listChucVu) {
		      				%>
		      				<option  <%=ChucVuVaiTroBusiness.checkSelectedChucVu(quocGia, chucVu.getId(), renderRequest.getParameter("chucVuId")) %> value = "<%=chucVu.getId() %>"><%=chucVu.getTen() %></option>
		      				<%
		      			}
		      		%>
		      		</select>
		      </td>
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Vai trò</label>
		      </td>
		      <td>
		      		<%
		      			List<VaiTro> listVaiTro = ChucVuVaiTroBusiness.findVaiTroByTrangThai();
		      		%>
		      		   <%
		    	if (actionTyPe.compareTo(ChucVuVaiTroBusiness.VIEW_CHUC_VU_VAI_TRO) == 0) {
		    		%>
		    		<select id="vaiTroId" name="vaiTroId" class="egov-select custom" disabled="disabled">
		    		<%
		    	} else {
		    		%>
		    		<select id="vaiTroId" name="vaiTroId" class="egov-select custom" >
		    		<%
		    	}
		    %>
		      		<%
		      			if (quocGia == null) {
		      				%>
		      				<option value = "">Chọn vai trò</option>
		      				<%
		      			}
		      			for (VaiTro chucVu : listVaiTro) {
		      				%>
		      				<option <%=ChucVuVaiTroBusiness.checkSelectedVaiTro(quocGia, chucVu.getId(), renderRequest.getParameter("vaiTroId")) %> value = "<%=chucVu.getId() %>"><%=chucVu.getTen() %></option>
		      				<%
		      			}
		      		%>
		      		</select>
		      </td>
		    </tr>
		    <tr>
		      <td colspan="2">&nbsp;</td>
		    </tr>
		    <%
		    	if (actionTyPe.compareTo(ChucVuVaiTroBusiness.VIEW_CHUC_VU_VAI_TRO) != 0) {
		    %>
		    <tr>
		    	<td align = "left">
		    	</td>
		      	<td align = "left">
		      		<input type="submit" class = "egov-button" name="submitButton"  value="Cập nhật" />
		      	</td>
		    </tr>
		    <%
		    	} 
		    %>
		     <tr>
		      <td colspan="2" align = "left">
		      	<%			
				// Create upload avatar URL
				PortletURL backUrl = renderResponse.createRenderURL();	
		      	backUrl.setParameter("jspPage","/html/portlet/admin/dm_co_quan_quan_ly_chuc_vu_list_cv.jsp");
		      	if (keyWord != null) {
		      		backUrl.setParameter("searchKeyWord", keyWord);
		      	}
		      	if (coQuanQuanLyId != null) {
		      		backUrl.setParameter("coQuanQuanLyId", coQuanQuanLyId);
		      	}
		      	%>
		      	<a href = "<%=backUrl %>" title="Quay lại trang danh sách chức vụ">Quay Lại</a>
		      </td>
		    </tr>
		  </table>
		</form>
	</div>

</body>
