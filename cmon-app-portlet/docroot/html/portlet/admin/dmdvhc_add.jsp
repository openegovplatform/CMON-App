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
<%@page import="org.oep.cmon.dao.qlhc.service.CapDonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh"%>
<%@page import="org.oep.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.QuocGia"%>
<%@page import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DonViHanhChinh"%>
<%@page import="org.oep.cmon.admin.portlet.business.CapDonViHanhChinhBusiness"%>
<%@page import="org.oep.cmon.admin.portlet.business.QuocGiaBusiness"%>
<%@page import="org.oep.cmon.admin.portlet.business.DanhMucDonViHanhChinhBusiness"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<body>
<%
PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "editOrAddDanhMucDonViHanhChinhRequest");

String keyWord = renderRequest.getParameter("searchKeyWord");
String actionTyPe= ParamUtil.getString(request, "ActionType");
String donViHanhChinhId= ParamUtil.getString(request, "DonViHanhChinhId");
String chaId= ParamUtil.getString(request, "chaId");

if ( Validator.isNull (actionTyPe)) {
	actionTyPe = "";
}
if ( Validator.isNull (donViHanhChinhId)) {
	donViHanhChinhId = "";
}
DonViHanhChinh quocGia = null;
if (donViHanhChinhId.trim().length() > 0) {
	quocGia = DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(ConvertUtil.convertToLong(donViHanhChinhId));
}
%>

<div class="wd-main-content">	
		<form id="danhMucDonViHanhChinhForm" name="danhMucDonViHanhChinhForm" method="post" action="<%=actionUrl.toString() %>">
		  <table border="0">
		    <tr>
		      <td colspan="2" align = "left">		      	
				<liferay-ui:error key="exitMaDanhMucDonViHanhChinh" message = "org.oep.cmon.admin.dmdvhc.exit.ma"/>
				<liferay-ui:error key="exitTenDanhMucDonViHanhChinh" message = "org.oep.cmon.admin.dmdvhc.exit.ten"/>
				<liferay-ui:error key="emptyMaDanhMucDonViHanhChinh" message = "org.oep.cmon.admin.dmdvhc.empty.ma"/>
				<liferay-ui:error key="emptyTenDanhMucDonViHanhChinh" message = "org.oep.cmon.admin.dmdvhc.empty.ten"/>
				<liferay-ui:error key="errorAddDanhMucDonViHanhChinh" message = "org.oep.cmon.admin.dmdvhc.error.add"/>
				<liferay-ui:error key="errorUpdateDanhMucDonViHanhChinh" message = "org.oep.cmon.admin.dmdvhc.error.update"/>
				<%
				if (ParamUtil.getString(request, "CompletedUpdateDanhMucDonViHanhChinh") != null && ParamUtil.getString(request, "CompletedUpdateDanhMucDonViHanhChinh").trim().length() > 0) {
					%>
				<font color="blue"><liferay-ui:message key="org.oep.cmon.admin.dmdvhc.completed.update"/></font>					
					<%
				}
				if (ParamUtil.getString(request, "CompletedAddDanhMucDonViHanhChinh") != null && ParamUtil.getString(request, "CompletedAddDanhMucDonViHanhChinh").trim().length() > 0) {
					%>
					<font color="blue">
						<liferay-ui:message key="org.oep.cmon.admin.dmdvhc.completed.add"/>
					</font>					
					<%
				}
				%>
				<input type="hidden" name = "actionType" id = "actionType" value = "<%= actionTyPe%>"/>
				<input type="hidden" name = "chaId" id = "chaId" value = "<%= chaId%>"/>
				<% if (keyWord != null) { %>
				<input type="hidden" name = "searchKeyWord" id = "searchKeyWord" value = "<%=keyWord%>"/>
				<%} %>
				<input type="hidden" name = "DonViHanhChinhId" id = "DonViHanhChinhId" value = "<%=donViHanhChinhId%>"/>
			  </td>	
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Cấp trên</label>
		      </td>
		      <td>
		      		<input type="text" class = "egov-inputfield" readonly="readonly" value = "<%=DanhMucDonViHanhChinhBusiness.getDonViHanhChinh(quocGia, chaId)%>"/>
		      </td>
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Mã đơn vị hành chính <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="maDonViHanhChinh" size = "42" type="text" <%=DanhMucDonViHanhChinhBusiness.checkReadOnly(actionTyPe) %> id="maDonViHanhChinh" maxlength="8" class = "egov-inputfield" value = "<%=DanhMucDonViHanhChinhBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "maDonViHanhChinh"), 2)%>"/>
		      </td>
		    </tr>
		    <tr>
		      <td>
		      		<label class ="egov-label">Tên đơn vị hành chính <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<input name="tenDonViHanhChinh" type="text"  <%=DanhMucDonViHanhChinhBusiness.checkReadOnly(actionTyPe) %> id="tenDonViHanhChinh" maxlength="50" class = "egov-inputfield" value = "<%=DanhMucDonViHanhChinhBusiness.checkDataReturn(quocGia, ParamUtil.getString(request, "tenDonViHanhChinh"), 1)%>"/>
		      </td>
		    </tr>
		    
		    
		     <tr>
		      <td>
		      		<label class ="egov-label">Quốc gia <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		<%
		    	if (actionTyPe.compareTo(DanhMucDonViHanhChinhBusiness.VIEW_DANH_MUC_DON_VI_HANH_CHINH) == 0) {
		    		%>
		    		<select id="quocGiaId" name="quocGiaId" class="egov-select custom" disabled="disabled">
		    		<%
		    	} else {
		    		%>
		    		<select id="quocGiaId" name="quocGiaId" class="egov-select custom">
		    		<%
		    	}
		      		if (chaId != null && chaId.trim().length() == 0) {
			      		List<QuocGia> liQuocGias = QuocGiaBusiness.findByTenQuocGia("");
			      		for (QuocGia quocGia2 : liQuocGias) {
			      			%>
			      			<option value="<%=quocGia2.getId() %>" <%=DanhMucDonViHanhChinhBusiness.checkSelected(ParamUtil.getString(request, "quocGiaId"), quocGia2.getId()) %>><%=quocGia2.getTen() %></option>
			      			<%
			      		}
		      		} else {
		      			QuocGia quocGia2 = QuocGiaLocalServiceUtil.fetchQuocGia(ConvertUtil.convertToLong(ParamUtil.getString(request, "quocGiaId").trim()));
		      			%>
		      			<option value="<%=ParamUtil.getString(request, "quocGiaId").trim() %>" selected="selected"><%=quocGia2.getTen() %></option>
		      			<%
		      		}
		      		%>
		      		</select>
		      </td>
		    </tr>
		     <tr>
		      <td>
		      		<label class ="egov-label">Cấp đơn vị hành chính <font color="red">(*)</font></label>
		      </td>
		      <td>
		      		   <%
		    	if (actionTyPe.compareTo(DanhMucDonViHanhChinhBusiness.VIEW_DANH_MUC_DON_VI_HANH_CHINH) == 0) {
		    		%>
		    		<select id="capDonViHanhChinhId" name="capDonViHanhChinhId" class="egov-select custom" disabled="disabled">
		    		<%
		    	} else {
		    		%>
		    		<select id="capDonViHanhChinhId" name="capDonViHanhChinhId" class="egov-select custom" >
		    		<%
		    	}
					//
		      		if (chaId != null && chaId.trim().length() == 0) {
		      			//
			      		long capDonViHanhChinhID = ConvertUtil.convertToLong(ParamUtil.getString(request, "capDonViHanhChinhId").trim());
			      		//
		      			if (quocGia != null) {
		      				capDonViHanhChinhID = quocGia.getCapDonViHanhChinhId();
		      			}
		      			List<CapDonViHanhChinh> liCapDonViHanhChinhs = null;
		      			if (quocGia != null) {
		      				CapDonViHanhChinh capDonViHanhChinhSelected = CapDonViHanhChinhLocalServiceUtil.fetchCapDonViHanhChinh(capDonViHanhChinhID);
			      			liCapDonViHanhChinhs = CapDonViHanhChinhLocalServiceUtil.findByCap(capDonViHanhChinhSelected.getCap());
		      			} else {
		      				CapDonViHanhChinh capDonViHanhChinhSelected = CapDonViHanhChinhLocalServiceUtil.fetchCapDonViHanhChinh(capDonViHanhChinhID);
		      				if (capDonViHanhChinhSelected == null) {
		      					liCapDonViHanhChinhs = CapDonViHanhChinhLocalServiceUtil.findByCap(1L);
		      				} else {
		      					liCapDonViHanhChinhs = CapDonViHanhChinhLocalServiceUtil.findByCap(capDonViHanhChinhSelected.getCap());
		      				}
		      			}

			      		for (CapDonViHanhChinh capDonViHanhChinh : liCapDonViHanhChinhs) {
			      			%>
			      			<option value="<%=capDonViHanhChinh.getId() %>" <%=DanhMucDonViHanhChinhBusiness.checkSelected(String.valueOf(capDonViHanhChinhID), capDonViHanhChinh.getId()) %>><%=capDonViHanhChinh.getTen() %></option>
			      			<%
			      		}
		      		} else {
		      			//
		      			long capDonViHanhChinhID = ConvertUtil.convertToLong(ParamUtil.getString(request, "capDonViHanhChinhId").trim());
		      			//
		      			if (quocGia != null) {
		      				capDonViHanhChinhID = quocGia.getCapDonViHanhChinhId();
		      			}
		      			//
		      			List<CapDonViHanhChinh> liCapDonViHanhChinhs = null;
		      			String completed = ParamUtil.getString(request, "completed");
			    		if (completed != null && completed.trim().length() > 0) {
			    			CapDonViHanhChinh capDonViHanhChinhSelected = CapDonViHanhChinhLocalServiceUtil.fetchCapDonViHanhChinh(capDonViHanhChinhID);
			    			liCapDonViHanhChinhs = CapDonViHanhChinhLocalServiceUtil.findByCap(capDonViHanhChinhSelected.getCap());
			    		} else {
			    			if (quocGia != null) {
			    				CapDonViHanhChinh capDonViHanhChinhSelected = CapDonViHanhChinhLocalServiceUtil.fetchCapDonViHanhChinh(capDonViHanhChinhID);
			    				liCapDonViHanhChinhs = CapDonViHanhChinhLocalServiceUtil.findByCap(capDonViHanhChinhSelected.getCap());
			    			} else {
			    				CapDonViHanhChinh capDonViHanhChinhSelected = CapDonViHanhChinhLocalServiceUtil.fetchCapDonViHanhChinh(capDonViHanhChinhID);
			    				if (renderRequest.getParameter("validation_error") != null) {
			    					liCapDonViHanhChinhs = CapDonViHanhChinhLocalServiceUtil.findByCap(capDonViHanhChinhSelected.getCap());
			    				} else {
			    					liCapDonViHanhChinhs = CapDonViHanhChinhLocalServiceUtil.findByCap(capDonViHanhChinhSelected.getCap() + 1);
			    				}
			    			}
			    		}

			      		for (CapDonViHanhChinh capDonViHanhChinh : liCapDonViHanhChinhs) {
			      			%>
			      			<option value="<%=capDonViHanhChinh.getId() %>" <%=DanhMucDonViHanhChinhBusiness.checkSelected(String.valueOf(capDonViHanhChinhID), capDonViHanhChinh.getId()) %>><%=capDonViHanhChinh.getTen() %></option>
			      			<%
			      		}
		      		}
		      		%>
		      		</select>
		      </td>
		    </tr>
		    
		    <tr>
		      <td colspan="2">&nbsp;</td>
		    </tr>
		    <%
		    	if (actionTyPe.compareTo(DanhMucDonViHanhChinhBusiness.VIEW_DANH_MUC_DON_VI_HANH_CHINH) != 0) {
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
		      	backUrl.setParameter("jspPage","/html/portlet/admin/dmdvhc_list.jsp");
		      	if (keyWord != null) {
		      		backUrl.setParameter("searchKeyWord", keyWord);
		      	}
		      	%>
		      	<a href = "<%=backUrl %>" title="Quay lại trang danh mục đơn vị hành chính">Quay Lại</a>
		      </td>
		    </tr>
		  </table>
		</form>
	</div>

</body>
