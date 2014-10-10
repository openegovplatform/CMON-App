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
<%@page import="org.oep.cmon.portlet.thamso.action.ThamSoPortlet"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="org.oep.cmon.dao.cd.service.HeThongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.HeThong"%>
<%@page import="org.oep.cmon.portlet.thamso.util.ThamSoConstants"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="org.oep.cmon.portlet.thamso.business.ThamSoBusiness"%>
<%@page import="org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.thamso.model.ThamSo"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/init.jsp"%>

<%
PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "editOrAddThamSoRequest");

String keyWord = renderRequest.getParameter("searchKeyWord");
String actionTyPe= ParamUtil.getString(request, "ActionType");
String thamSoId= ParamUtil.getString(request, "thamSoId");
if ( Validator.isNull (actionTyPe)) {
	actionTyPe = "";
}
if ( Validator.isNull (thamSoId)) {
	thamSoId = "";
}
ThamSo thamSo = null;
if (thamSoId.trim().length() > 0) {
	thamSo = ThamSoLocalServiceUtil.fetchThamSo(FormatUtil.convertToLong(thamSoId));
}
%>
<div class="egov-container">
<form id="<portlet:namespace/>thamSoForm" name="<portlet:namespace/>thamSoForm" method="post" action="<%=actionUrl.toString() %>">
<table align="center" border="0" class="egov-table-form">

<tr>
		<td colspan="6" align="center">
		<br>
			<label class="egov-label-header">Quản lý tham số hệ thống</label>
		<br><br>	
		</td>
	</tr>
		    <tr>
		      <td colspan="6" align = "left">
		      	<select style="display: none;" id="egov-form-errors">
					<option value="tenThamSo"><liferay-ui:error key="existTenThamSo" message = "vn.dtt.cmon.thamso.form.exist.ten"/></option>
					<option value="tenThamSo"><liferay-ui:error key="emptyTenThamSo" message = "vn.dtt.cmon.thamso.form.empty.ten"/></option>
				</select>
				<liferay-ui:error key="errorAddThamSo" message = "vn.dtt.cmon.thamso.form.error.add"/>
				<liferay-ui:error key="errorUpdateThamSo" message = "vn.dtt.cmon.thamso.form.error.update"/>
				<%
				if (ParamUtil.getString(request, "CompletedUpdateThamSo") != null && ParamUtil.getString(request, "CompletedUpdateThamSo").trim().length() > 0) {
					%>
					<liferay-ui:success key="successUpdateThamSo" message="vn.dtt.cmon.thamso.form.completed.update"/>					
					<%
				}
				if (ParamUtil.getString(request, "CompletedAddThamSo") != null && ParamUtil.getString(request, "CompletedAddThamSo").trim().length() > 0) {
					%>
					<liferay-ui:success key="successAddThamSo" message="vn.dtt.cmon.thamso.form.completed.add"/>
					<%
				}
				%>
				<input type="hidden" name = "actionType" id = "actionType" value = "<%= actionTyPe%>"/>
				<%
				if (keyWord != null) {
				%>
					<input type="hidden" name = "searchKeyWord" id = "searchKeyWord" value = "<%=keyWord%>"/>
				<%} %>
				<input type="hidden" name = "thamSoId" id = "thamSoId" value = "<%=thamSoId%>"/>
			  </td>	
		    </tr>
		    <tr>
		      <td colspan="4">
		      		<label class="egov-label-bold">Tên tham số</label>(<label class="egov-label-red">*</label>)<br>
		      		<input name="tenThamSo" type="text" <%=ThamSoBusiness.checkReadOnly(actionTyPe) %> 
		      		id="tenThamSo" maxlength="50" class = "egov-inputfield" 
		      		value = "<%=ThamSoBusiness.checkDataReturn(thamSo, ParamUtil.getString(request, "tenThamSo"), 1)%>"/>
		      </td>
		      <td colspan="2"><label class ="egov-label-bold">Kiểu dữ liệu</label><br>
		      		<select id="kieuDuLieu" name="kieuDuLieu" class="egov-select" <%=ThamSoBusiness.checkDisabled(actionTyPe, ThamSoBusiness.VIEW_THAM_SO) %>>
		      			<option <%=ThamSoBusiness.checkStatusSelected(thamSo, ParamUtil.getString(request, "kieuDuLieu"), "0") %> value = "0">STRING</option>
		      			<option <%=ThamSoBusiness.checkStatusSelected(thamSo, ParamUtil.getString(request, "kieuDuLieu"), "1") %> value = "1">INTEGER</option>
		      			<option <%=ThamSoBusiness.checkStatusSelected(thamSo, ParamUtil.getString(request, "kieuDuLieu"), "2") %> value = "2">DOUBLE</option>
		      		</select>	
		      	
		      </td>
		    </tr>
		    <tr>
		    <td colspan="3">
		      		<label class="egov-label-bold">Giá trị </label><br>
		      		<input name="giaTri" type="text" <%=ThamSoBusiness.checkReadOnly(actionTyPe) %> 
		      		id="giaTri" maxlength="150" class = "egov-inputfield" 
		      		value = "<%=ThamSoBusiness.checkDataReturn(thamSo, ParamUtil.getString(request, "giaTri"), 3)%>"/>
		      </td>
		      <td colspan="3"><label class ="egov-label-bold">Trạng thái</label><br>
		      		<select id="trangThaiThamSo" name="trangThaiThamSo" class="egov-select" <%=ThamSoBusiness.checkDisabled(actionTyPe, ThamSoBusiness.VIEW_THAM_SO) %>>
		      			<option <%=ThamSoBusiness.checkStatusSelected(thamSo, ParamUtil.getString(request, "trangThaiThamSo"), "0") %> value = "0">Hoạt động</option>
		      			<option <%=ThamSoBusiness.checkStatusSelected(thamSo, ParamUtil.getString(request, "trangThaiThamSo"), "1") %> value = "1">Khóa</option>
		      		</select>	
		      </td>
		    </tr>		    
		      <tr>
		      <td colspan="3"><label class ="egov-label-bold">Ứng dụng</label><br>
		      		<select id="ungDungId" name="ungDungId" class="egov-select" <%=ThamSoBusiness.checkDisabled(actionTyPe, ThamSoBusiness.VIEW_THAM_SO) %>>
			      		<option value="0">--Chọn ứng dụng--</option>	 
			      		<%
			      		List<DanhMucUngDung> ungDungList = ThamSoBusiness.getUngDungList();//DanhMucUngDungLocalServiceUtil.getDanhMucUngDungs(0, DanhMucUngDungLocalServiceUtil.getDanhMucUngDungsCount());
			      		
			      		for (DanhMucUngDung ungDung : ungDungList) {
			      			if (thamSo== null) {
				      			%>
				      			<option value="<%=ungDung.getId() %>"  
				      						<%=ThamSoBusiness.checkSelectedValue(ParamUtil.getString(request, "ungDungId"), ungDung.getId())%>>
				      				<%=ungDung.getTen() %>
				      			</option>
				      			<%
			      			} else {
			      				%>		      				
				      			<option value="<%=ungDung.getId() %>" 
				      					<%=ThamSoBusiness.checkSelectedValue(String.valueOf(thamSo.getUngDungId()), ungDung.getId())%>>
				      				<%=ungDung.getTen() %>
				      			</option>
				      			<%
			      			}
			      		}
			      		%>
		      		</select>	
		      </td>
		      <td colspan="3"><label class ="egov-label-bold">Hệ thống</label><br>
		      		<select id="heThongId" name="heThongId" class="egov-select" <%=ThamSoBusiness.checkDisabled(actionTyPe, ThamSoBusiness.VIEW_THAM_SO) %>>
		      			<option value="0">--Chọn hệ thống-</option>	 
			      		<%
			      		List<HeThong> heThongList = ThamSoBusiness.getHeThongList();//HeThongLocalServiceUtil.getHeThongs(0, HeThongLocalServiceUtil.getHeThongsCount());
			      		
			      		for (HeThong heThong : heThongList) {
			      			if (thamSo== null) {
				      			%>
				      			<option value="<%=heThong.getId() %>"  
				      						<%=ThamSoBusiness.checkSelectedValue(ParamUtil.getString(request, "heThongId"), heThong.getId())%>>
				      				<%=heThong.getTen() %>
				      			</option>
				      			<%
			      			} else {
			      				%>		      				
				      			<option value="<%=heThong.getId() %>" 
				      					<%=ThamSoBusiness.checkSelectedValue(String.valueOf(thamSo.getHeThongId()), heThong.getId())%>>
				      				<%=heThong.getTen() %>
				      			</option>
				      			<%
			      			}
			      		}
			      		%>
		      		</select>	
		      </td>
		    </tr>	
		    <tr>
		<td colspan="6" valign="top">
		<label class="egov-label-bold"> Mô tả về loại tham số này </label>
		<textarea name="moTaThamSo" id="moTaThamSo" class = "egov-textarea"
		 rows="8" cols="43" maxlength="450" <%=ThamSoBusiness.checkReadOnly(actionTyPe)%>><%=ThamSoBusiness.checkDataReturn(thamSo, ParamUtil.getString(request, "moTaThamSo"), 2)%></textarea>
		  (Số kí tự tối đa: 450)<br/>
  			<span id="charLeft"> </span>  Kí tự còn lại
		 </td>
		</tr>
		    	   
			<tr>
				<td align="left"></td>
				<td align="left">
					<%
						// Create upload avatar URL
						PortletURL backUrl = renderResponse.createRenderURL();
						backUrl.setParameter("jspPage",
								"/html/portlet/thamso/tham_so_view.jsp");
						if (keyWord != null) {
							backUrl.setParameter("searchKeyWord", keyWord);
						}

						if (actionTyPe.compareTo(ThamSoBusiness.VIEW_THAM_SO) != 0) {
					%> <span><input type="submit" class="egov-button-normal"
						name="submitButton" value="Lưu lại" /></span> 
						<%
						}
				 	%> 	
				 <span style="padding-left: 10px;">
 					<a
						href="<%=backUrl.toString()%>">
						<input type="button"	name="backUrl" 
							class="egov-button-normal" value="Quay lại danh sách" />
					</a>
		</span>
		<br>
				</td>
			</tr>

		</table>
</form>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		
		$('#moTaThamSo').keyup(function() {
            var len = this.value.length;
            if (len >= 450) {
                this.value = this.value.substring(0, 450);
            }
            $('#charLeft').text(450 - len);
        });
		$('#submitButton').click(function(){			
			 document.<portlet:namespace/>thamSoForm.submit();
		});
	   }
	);

  $('#tenThamSo').keyup(function() {
        $(this).val($(this).val().toUpperCase());
  });
</script>