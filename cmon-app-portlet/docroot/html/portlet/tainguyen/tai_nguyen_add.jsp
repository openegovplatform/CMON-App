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
<%@page import="org.oep.cmon.portlet.tainguyen.action.TaiNguyenPortlet"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.HeThong"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="org.oep.cmon.portlet.tainguyen.business.TaiNguyenBusiness"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiNguyenLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiNguyen"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/init.jsp"%>
<%
TaiNguyenPortlet portlet = new TaiNguyenPortlet();
PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "editOrAddTaiNguyenRequest");
portlet.setSearchParameter(actionUrl, renderRequest);


String keyWord = renderRequest.getParameter("searchKeyWord");
String actionTyPe= ParamUtil.getString(request, "ActionType");
String taiNguyenId= ParamUtil.getString(request, "taiNguyenId","0");

//Create upload avatar URL
PortletURL backUrl = renderResponse.createRenderURL();
backUrl.setParameter("jspPage",
		"/html/portlet/tainguyen/tai_nguyen_list.jsp");
if (keyWord != null) {
	backUrl.setParameter("searchKeyWord", keyWord);
}
portlet.setSearchParameter(backUrl, renderRequest);

String titleButtonForm=LanguageUtil.get(pageContext, "vn.dtt.cmon.tainguyen.form.label.update");

if ( Validator.isNull (actionTyPe)) {
	actionTyPe = "";
}
if ( Validator.isNull (taiNguyenId)||FormatUtil.convertToInt(taiNguyenId)<=0) {
	taiNguyenId = "";
	titleButtonForm = LanguageUtil.get(pageContext, "vn.dtt.cmon.tainguyen.form.label.add");
}

if(actionTyPe.equals(TaiNguyenBusiness.VIEW_TAINGUYEN) )
{
	titleButtonForm = LanguageUtil.get(pageContext, "vn.dtt.cmon.tainguyen.form.label.view");
}

TaiNguyen taiNguyen = null;
if (taiNguyenId != null 
		&& taiNguyenId.trim().length() > 0) {
	taiNguyen = TaiNguyenLocalServiceUtil.fetchTaiNguyen(FormatUtil.convertToLong(taiNguyenId));
}
%>
<div class="egov-container">
<form id="<portlet:namespace/>taiNguyenForm" name="<portlet:namespace/>taiNguyenForm" method="post" action="<%=actionUrl.toString() %>">
<table align="center" border="0" class="egov-table-form">

<tr>
		<td colspan="6" align="center">
		<br>
			<label class="egov-label-header"><%=titleButtonForm %> tài nguyên</label>
		<br><br>	
		</td>
	</tr>
		    <tr>
		      <td colspan="6" align = "left">
		      	<select style="display: none;" id="egov-form-errors">
					<option value="tenTaiNguyen"><liferay-ui:error key="existTenTaiNguyen" message = "vn.dtt.cmon.tainguyen.form.exist.ten"/></option>
					<option value="tenTaiNguyen"><liferay-ui:error key="emptyTenTaiNguyen" message = "vn.dtt.cmon.tainguyen.form.empty.ten"/></option>
					<option value="giaTri"><liferay-ui:error key="emptyGiaTri" message = "vn.dtt.cmon.tainguyen.form.empty.giatri"/></option>
				</select>
				<liferay-ui:error key="errorAddTaiNguyen" message = "vn.dtt.cmon.tainguyen.form.error.add"/>
				<liferay-ui:error key="errorUpdateTaiNguyen" message = "vn.dtt.cmon.tainguyen.form.error.update"/>
				<%
				if (ParamUtil.getString(request, "CompletedUpdateTaiNguyen") != null && ParamUtil.getString(request, "CompletedUpdateTaiNguyen").trim().length() > 0) {
					%>
					<liferay-ui:success key="successUpdateTaiNguyen" message="vn.dtt.cmon.tainguyen.form.completed.update"/>					
					<%
				}
				if (ParamUtil.getString(request, "CompletedAddTaiNguyen") != null && ParamUtil.getString(request, "CompletedAddTaiNguyen").trim().length() > 0) {
					%>
					<liferay-ui:success key="successAddTaiNguyen" message="vn.dtt.cmon.tainguyen.form.completed.add"/>
					<%
				}
				%>
				<input type="hidden" name = "actionType" id = "actionType" value = "<%= actionTyPe%>"/>
				<%
				if (keyWord != null) {
				%>
					<input type="hidden" name = "searchKeyWord" id = "searchKeyWord" value = "<%=keyWord%>"/>
				<%} %>
				<input type="hidden" name = "taiNguyenId" id = "taiNguyenId" value = "<%=taiNguyenId%>"/>
			  </td>	
		    </tr>
		    <tr>
		      <td colspan="4">
		      		<label class="egov-label-bold">Tên tài nguyên</label>(<label class="egov-label-red">*</label>)<br>
		      		<input name="tenTaiNguyen" type="text" <%=TaiNguyenBusiness.checkReadOnly(actionTyPe) %> 
		      		id="tenTaiNguyen" maxlength="50" class = "egov-inputfield"  style="width: 95%"
		      		value = "<%=TaiNguyenBusiness.checkDataReturn(taiNguyen, ParamUtil.getString(request, "tenTaiNguyen"), 1)%>"/>
		      </td>
		       <td colspan="2">
		      		<label class="egov-label-bold">Giá trị tài nguyên</label>(<label class="egov-label-red">*</label>)<br>
		      		<input name="giaTri" type="text" <%=TaiNguyenBusiness.checkReadOnly(actionTyPe) %> 
		      		id="giaTri" maxlength="150" class = "egov-inputfield" style="width: 93%"
		      		value = "<%=TaiNguyenBusiness.checkDataReturn(taiNguyen, ParamUtil.getString(request, "giaTri"), 3)%>"/>
		      </td>
		    </tr>
		     <tr>
		      <td colspan="3"><label class ="egov-label-bold">Ứng dụng</label><br>
		      		<select id="ungDungId" name="ungDungId" class="egov-select" style="width: 98%"
		      			<%=TaiNguyenBusiness.checkDisabled(actionTyPe, TaiNguyenBusiness.VIEW_TAINGUYEN) %>>
			      		<option value="0">--Chọn ứng dụng--</option>	 
			      		<%
			      		List<DanhMucUngDung> ungDungList = TaiNguyenBusiness.getUngDungList();//DanhMucUngDungLocalServiceUtil.getDanhMucUngDungs(0, DanhMucUngDungLocalServiceUtil.getDanhMucUngDungsCount());
			      		
			      		for (DanhMucUngDung ungDung : ungDungList) {
			      			if (taiNguyen== null) {
				      			%>
				      			<option value="<%=ungDung.getId() %>"  
				      						<%=TaiNguyenBusiness.checkSelectedValue(ParamUtil.getString(request, "ungDungId"), ungDung.getId())%>>
				      				<%=ungDung.getTen() %>
				      			</option>
				      			<%
			      			} else {
			      				%>		      				
				      			<option value="<%=ungDung.getId() %>" 
				      					<%=TaiNguyenBusiness.checkSelectedValue(String.valueOf(taiNguyen.getUngDungId() != null ?taiNguyen.getUngDungId():""), ungDung.getId())%>>
				      				<%=ungDung.getTen() %>
				      			</option>
				      			<%
			      			}
			      		}
			      		%>
		      		</select>	
		      </td>
		      <td colspan="3"><label class ="egov-label-bold">Hệ thống</label><br>
		      		<select id="heThongId" name="heThongId" class="egov-select"
		      			<%=TaiNguyenBusiness.checkDisabled(actionTyPe, TaiNguyenBusiness.VIEW_TAINGUYEN) %>>
		      			<%
			      		List<HeThong> heThongList = TaiNguyenBusiness.getHeThongList();//HeThongLocalServiceUtil.getHeThongs(0, HeThongLocalServiceUtil.getHeThongsCount());
			      		
			      		for (HeThong heThong : heThongList) {
			      			if (taiNguyen== null) {
				      			%>
				      			<option value="<%=heThong.getId() %>"  
				      						<%=TaiNguyenBusiness.checkSelectedValue(ParamUtil.getString(request, "heThongId"), heThong.getId())%>>
				      				<%=heThong.getTen() %>
				      			</option>
				      			<%
			      			} else {
			      				%>		      				
				      			<option value="<%=heThong.getId() %>" 
				      					<%=TaiNguyenBusiness.checkSelectedValue(String.valueOf(taiNguyen.getHeThongId()), heThong.getId())%>>
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
		    <td colspan="3"><label class ="egov-label-bold">Loại</label><br>
		      		<select id="loaiTaiNguyen" name="loaiTaiNguyen" class="egov-select" style="width: 98%"
		      			<%=TaiNguyenBusiness.checkDisabled(actionTyPe, TaiNguyenBusiness.VIEW_TAINGUYEN) %>>
		      			<option <%=TaiNguyenBusiness.checkLoaiSelected(taiNguyen, ParamUtil.getString(request, "loaiTaiNguyen"), Constants.TaiNguyen.L_Page) %> value = "<%=Constants.TaiNguyen.Loai_Page %>"><liferay-ui:message key="vn.dtt.cmon.tainguyen.list.loai.page.liferay"/></option>
		      			<option <%=TaiNguyenBusiness.checkLoaiSelected(taiNguyen, ParamUtil.getString(request, "loaiTaiNguyen"), Constants.TaiNguyen.L_Portlet) %> value = "<%=Constants.TaiNguyen.Loai_Portlet %>"><liferay-ui:message key="vn.dtt.cmon.tainguyen.list.loai.portlet.liferay"/></option>
		      			<option <%=TaiNguyenBusiness.checkLoaiSelected(taiNguyen, ParamUtil.getString(request, "loaiTaiNguyen"), Constants.TaiNguyen.L_Function) %> value = "<%=Constants.TaiNguyen.Loai_Function %>"><liferay-ui:message key="vn.dtt.cmon.tainguyen.list.loai.function.liferay"/></option>
		      		</select>	
		      </td>
		   
		      <td colspan="3"><label class ="egov-label-bold">Trạng thái</label><br>
		      		<select id="trangThaiTaiNguyen" name="trangThaiTaiNguyen" class="egov-select" <%=TaiNguyenBusiness.checkDisabled(actionTyPe, TaiNguyenBusiness.VIEW_TAINGUYEN) %>>
		      			<option <%=TaiNguyenBusiness.checkTTSelected(taiNguyen, ParamUtil.getString(request, "trangThaiTaiNguyen"), Constants.TaiNguyen.TT_HoatDong) %> value = "<%=Constants.TaiNguyen.TrangThai_HoatDong %>"><liferay-ui:message key="vn.dtt.cmon.tainguyen.list.active.status"/></option>
		      			<option <%=TaiNguyenBusiness.checkTTSelected(taiNguyen, ParamUtil.getString(request, "trangThaiTaiNguyen"), Constants.TaiNguyen.TT_Khoa) %> value = "<%=Constants.TaiNguyen.TrangThai_Khoa %>"><liferay-ui:message key="vn.dtt.cmon.tainguyen.list.inactive.status"/></option>
		      		</select>	
		      </td>
		    </tr>		    
		 <tr>
			<td colspan="6" valign="top">
			<label class="egov-label-bold"> Mô tả về loại tài nguyên này </label>
			<textarea name="moTaTaiNguyen" id="moTaTaiNguyen" class = "egov-textarea"
			 rows="8" cols="43" maxlength="450" <%=TaiNguyenBusiness.checkReadOnly(actionTyPe)%>><%=TaiNguyenBusiness.checkDataReturn(taiNguyen, ParamUtil.getString(request, "moTaTaiNguyen"), 2)%></textarea>
			  (Số kí tự tối đa: 450)<br/>
	  			<span id="charLeft"> </span>  Kí tự còn lại
			 </td>
		</tr>
			<tr>
				<td align="left"></td>
				<td align="left" colspan="2">
					<%
						if (actionTyPe.compareTo(TaiNguyenBusiness.VIEW_TAINGUYEN) != 0) {
					%> <span><input type="submit" class="egov-button-normal"
						name="submitButton" value="<%=titleButtonForm %>" /></span> 
						<%
						}
				 	%> 	
				 <span style="padding-left: 10px;">
 					<a id="linkBackToList"
						href="<%=backUrl.toString()%>">
						<input type="button" id="buttonBackToList"	name="backUrl" 
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
		if (<%= actionTyPe.equals(TaiNguyenBusiness.VIEW_TAINGUYEN)  %>) {
			disableAllItem();
		}
		$('#moTaTaiNguyen').keyup(function() {
            var len = this.value.length;
            if (len >= 450) {
                this.value = this.value.substring(0, 450);
            }
            $('#charLeft').text(450 - len);
        });
		$('#submitButton').click(function(){			
			 document.<portlet:namespace/>taiNguyenForm.submit();
		});
	   });
	function disableAllItem() {
		$('#<portlet:namespace/>taiNguyenForm input').each(function() {
			   $(this).attr('disabled','disabled'); 
			   $(this).addClass('readonly');
			   if ($(this).attr('type') == 'button' || $(this).attr('type') == 'BUTTON') {
				   $(this).attr('style','display:none');  
			   } 
		});
		$('#<portlet:namespace/>taiNguyenForm select').each(function() {
		  	   $(this).attr('disabled','disabled');  
		  	   $(this).addClass('readonly');
		});
		$('#<portlet:namespace/>taiNguyenForm a').each(function() {
		  	   $(this).attr('style','display:none');  
		});
		$('#<portlet:namespace/>taiNguyenForm textarea').each(function() {
			  $(this).attr('disabled','disabled');
			  $(this).addClass('readonly'); 
		});
		// Enable link back
		$("#linkBackToList").removeAttr('style');
		$("#buttonBackToList").removeAttr('style');
		$("#buttonBackToList").removeAttr('disabled');
		$("#buttonBackToList").removeClass('readonly');
	}
</script>