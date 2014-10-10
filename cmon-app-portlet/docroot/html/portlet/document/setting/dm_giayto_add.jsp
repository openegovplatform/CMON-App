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
<%@page import="org.oep.cmon.portlet.document.util.ListUtil"%>
<%@page import="org.oep.cmon.portlet.document.util.DocumentConstants"%>

<%@page import="org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.DoiTuongSuDung"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung"%>
<%@page import="org.oep.cmon.portlet.document.business.DanhMucGiayToBusiness"%>
<%@page import="org.oep.cmon.dao.tlct.model.DanhMucGiayTo"%>
<%@page import="org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/init.jsp"%>

<%
PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "editOrAddDMGTRequest");

String keyWord = ParamUtil.getString(request, "searchKeyWord", "");
String doituongGroup= ParamUtil.getString(request,"doituongGroup","");

String actionTyPe= ParamUtil.getString(request, "ActionType");
String dMGTId= ParamUtil.getString(request, "dMGTId");
if ( Validator.isNull (actionTyPe)) {
	actionTyPe = "";
}
if ( Validator.isNull (dMGTId)) {
	dMGTId = "";
}
DanhMucGiayTo dMGT = null;
if (dMGTId.trim().length() > 0) {
	dMGT = DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(FormatUtil.convertToLong(dMGTId));
}


%>
<div class="egov-container">
<form id="<portlet:namespace/>dMGTForm" name="<portlet:namespace/>dMGTForm" method="post" action="<%=actionUrl.toString() %>">
<input type="hidden" name="searchKeyWord" id="searchKeyWord" value="<%=keyWord%>">
<input type="hidden" name="doituongGroup" id="doituongGroup" value="<%=doituongGroup%>">
<table align="center" border="0" class="egov-table-form" width="100%"> 
<tr>
	<td width="16.67%">&nbsp;</td>
	<td width="16.67%">&nbsp;</td>
	<td width="16.67%">&nbsp;</td>
	<td width="16.67%">&nbsp;</td>
	<td width="16.67%">&nbsp;</td>
	<td width="16.67%">&nbsp;</td>
</tr>
	<tr>
		<td colspan="6" align="center">
		<br>
			<label class="egov-label-header">Quản lý danh mục giấy tờ</label>
			<br><br>
		</td>
	</tr>
	<tr>
	<td colspan="6">
		<select style="display: none;" id="egov-form-errors">
			<option value="tenDMGT"><liferay-ui:error key="existTenDMGT" message = "org.oep.cmon.document.setting.dmgt.form.exist.ten"/></option>
			<option value="tenDMGT"><liferay-ui:error key="emptyTenDMGT" message = "org.oep.cmon.document.setting.dmgt.form.empty.ten"/></option>
			<option value="maDMGT"><liferay-ui:error key="existMaDMGT" message = "org.oep.cmon.document.setting.dmgt.form.exist.ma"/></option>
			<option value="maDMGT"><liferay-ui:error key="emptyMaDMGT" message = "org.oep.cmon.document.setting.dmgt.form.empty.ma"/></option>
			<option value="kieuTaiLieu"><liferay-ui:error key="emptyTaiLieuDMGT" message = "org.oep.cmon.document.setting.dmgt.form.empty.tailieu"/></option>
			<option value="gioiHanDL"><liferay-ui:error key="emptyDungLuongDMGT" message = "org.oep.cmon.document.setting.dmgt.form.empty.dungluong"/></option>
			<option value="doituongId"><liferay-ui:error key="emptyDoiTuongSuDung" message = "org.oep.cmon.document.setting.dmgt.form.empty.dtsd"/></option>
		</select>
				<liferay-ui:error key="errorAddDMGT" message = "org.oep.cmon.document.setting.dmgt.form.error.add"/>
				<liferay-ui:error key="errorAddGT2DT" message = "org.oep.cmon.document.setting.dmgt.form.error.add2dt"/>
				<liferay-ui:error key="errorUpdateDMGT" message = "org.oep.cmon.document.setting.dmgt.form.error.update"/>
				<%
				if (ParamUtil.getString(request, "CompletedUpdateDMGT") != null && ParamUtil.getString(request, "CompletedUpdateDMGT").trim().length() > 0) {
					%>
					<liferay-ui:success key="successUpdateDMGT" message="org.oep.cmon.document.setting.dmgt.form.completed.update"/>					
					<%
				}
				if (ParamUtil.getString(request, "CompletedAddDMGT") != null && ParamUtil.getString(request, "CompletedAddDMGT").trim().length() > 0) {
					%>
					<liferay-ui:success key="successAddDMGT" message="org.oep.cmon.document.setting.dmgt.form.completed.add"/>
					<%
				}
				%>
				<input type="hidden" name = "actionType" id = "actionType" value = "<%= actionTyPe%>"/>
				<input type="hidden" name = "dMGTId" id = "dMGTId" value = "<%=dMGTId%>"/>
				<input type="hidden" id="giatridoituongId" name="giatridoituongId"	value="" />
			  </td>	
	</tr>
	<tr>
		<td colspan="4"><label class="egov-label-bold">Tên tài
				liệu</label> (<label class="egov-label-red">*</label>) <br> 
				<input name="tenDMGT" type="text"					
					<%=DanhMucGiayToBusiness.checkReadOnly(actionTyPe)%>
					id="tenDMGT" maxlength="500" 
					class="egov-inputfield"  style="width:95%;"
					value="<%=DanhMucGiayToBusiness.checkDataReturn(dMGT,
					ParamUtil.getString(request, "tenDMGT"), 1)%>" /></td>

	<td colspan="2"><label class="egov-label-bold">Mã tài
				liệu</label> (<label class="egov-label-red">*</label>) <label class="label.egov-label-note">yêu cầu viết hoa</label><br> 
				<input name="maDMGT" type="text" style="width:93%;"
					<%=DanhMucGiayToBusiness.checkReadOnly(actionTyPe)%>
					id="maDMGT" maxlength="5" class="egov-inputfield"
					value="<%=DanhMucGiayToBusiness.checkDataReturn(dMGT,
					ParamUtil.getString(request, "maDMGT"), 3)%>"  />
	</td>
	</tr>
	<tr>
		<td colspan="2"><label class="egov-label-bold">Định dạng</label>
				<label class="egov-label-note">
				  (Theo mẫu: pdf,doc...)
				  </label> 
				(<label class="egov-label-red">*</label>) <br>
			<input name="kieuTaiLieu" type="text" style="width:90%;"
					<%=DanhMucGiayToBusiness.checkReadOnly(actionTyPe)%>
					id="kieuTaiLieu" maxlength="100" class="egov-inputfield"
					value="<%=DanhMucGiayToBusiness.checkDataReturn(dMGT,
					ParamUtil.getString(request, "kieuTaiLieu"), 4)%>" >
					</td>
		<td colspan="2">
					<label class="egov-label-bold">
					Dung lượng
				  </label>
				  <label class="egov-label-note">
				  (theo byte )
				  </label>
				  (<label class="egov-label-red">*</label>) <br> 
				<input name="gioiHanDL" type="text" style="width:90%;"
					<%=DanhMucGiayToBusiness.checkReadOnly(actionTyPe)%>
					id="gioiHanDL" maxlength="12" class="egov-inputfield"
					value="<%=DanhMucGiayToBusiness.checkDataReturn(dMGT,
					ParamUtil.getString(request, "gioiHanDL"), 5)%>" >
				</td>
				<td colspan="2" ><label class="egov-label-bold">Tài liệu thay thế nếu có</label>
				<br> 
		      			<select id="TaiLieuTTId" name="TaiLieuTTId" class="egov-select" <%=DanhMucGiayToBusiness.checkDisabled(actionTyPe, DanhMucGiayToBusiness.VIEW_DM_GIAYTO) %>>
		      			<option value="-1">--Không có tài liệu thay thế--</option>	 
		      			<%
		      		List<DanhMucGiayTo> taiLieuList = DanhMucGiayToLocalServiceUtil.getDanhMucGiayToList(0);
		      		for (DanhMucGiayTo dmTaiLieu : taiLieuList) {
		      			if (dMGT== null) {
			      			%>
			      			<option value="<%=dmTaiLieu.getId() %>"  
			      						<%=DanhMucGiayToBusiness.checkSelectedValue(ParamUtil.getString(request, "TaiLieuTTId"), dmTaiLieu.getId())%>>
			      				<%=dmTaiLieu.getTen() %>
			      			</option>
			      			<%
		      			} else {
		      				%>		      				
			      			<option value="<%=dmTaiLieu.getId() %>" 
			      					<%=DanhMucGiayToBusiness.checkSelectedValue(String.valueOf(dMGT.getTailieuThayTheId()), dmTaiLieu.getId())%>>
			      				<%=dmTaiLieu.getTen() %>
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
		<%
				List<DoiTuongSuDung> sysList= DoiTuongSuDungLocalServiceUtil.getDSDoiTuongSuDung(DocumentConstants.ACTIVE);

				List<DanhMucGiayTo2DoiTuongSuDung> docList =  null;
				if(dMGT != null){
					docList = DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil.getTheoLoaiGT_DSDMGT2DTSD(dMGT.getId());;	
				}
									%>
					<table cellpadding="0" cellspacing="0" class="egov-table-form2" width="100%">
						<tr>
							<td width="43%"><label class="egov-label-bold">
									Đối tượng sử dụng
									 </label> 
		      			<select class="egov-multi-select"
								size="7" multiple="multiple" id="select-system-id" 
								<%=DanhMucGiayToBusiness.checkDisabled(actionTyPe, DanhMucGiayToBusiness.VIEW_DM_GIAYTO) %>>
		      					<%
		      					
		      					  if(sysList != null){
		      						  for(DoiTuongSuDung dtSudung:sysList){
		      							  if(!ListUtil.isExist(docList, dtSudung.getId())){
		      								%>
		      									<option value="<%=dtSudung.getId()%>"><%=dtSudung.getTen()%></option>
		      								<%			  
		      							  }
		      						  }
		      					  }
		      					%>
						</select>
							</td>
							<td width="6%" align="center" style="padding: 10px;"><br>
								<br> 
		      					<input type="button"class="egov-button-normal" value=">>"
								onclick="moveOptions('select-system-id','doituongId');"
								<%=DanhMucGiayToBusiness.checkDisabled(actionTyPe, DanhMucGiayToBusiness.VIEW_DM_GIAYTO) %>
								>
		      			<br> <br> 
		      			<input type="button"
								class="egov-button-normal" value="<<" 
											onclick="moveOptions('doituongId','select-system-id');"
											<%=DanhMucGiayToBusiness.checkDisabled(actionTyPe, DanhMucGiayToBusiness.VIEW_DM_GIAYTO) %>
								>
		      					
							</td>
							<td width="43%"><label class="egov-label-bold">
									Đối tượng được chọn
									 </label>
			      			 <select class="egov-multi-select"
									size="7" name="doituongId" multiple="multiple"
									id="doituongId" 
									<%=DanhMucGiayToBusiness.checkDisabled(actionTyPe, DanhMucGiayToBusiness.VIEW_DM_GIAYTO) %>
									>
			      				<%
		      					
			      					  if(docList != null){
			      						  for(DanhMucGiayTo2DoiTuongSuDung dm2DT:docList){
			      							  	DoiTuongSuDung dt = DoiTuongSuDungLocalServiceUtil.fetchDoiTuongSuDung(dm2DT.getLoaiDoiTuongId());
			      								%>
			      									<option value="<%=dt.getId()%>"><%=dt.getTen()%></option>
			      								<%			  
			      						  }
			      					  }
		      						%>
							</select>
							</td>
						</tr>
					</table>
				</td>
	</tr>
	<tr>
		<td colspan="6" valign="top"><label class="egov-label-bold"> Mô tả về loại giấy tờ này </label>
		<textarea name="moTaDMGT" id="moTaDMGT" class = "egov-textarea"
		 rows="8" cols="43" maxlength="200" <%=DanhMucGiayToBusiness.checkReadOnly(actionTyPe)%>><%=DanhMucGiayToBusiness.checkDataReturn(dMGT, ParamUtil.getString(request, "moTaDMGT"), 2)%></textarea>
		  (Số kí tự tối đa: 200)<br/>
  			<span id="charLeft"> </span>  Kí tự còn lại
		 </td>
	</tr>
	<tr>
		<td colspan="6" align="center">
						<%
						// Create back URL
						PortletURL backUrl = renderResponse.createRenderURL();
						backUrl.setParameter("jspPage",
								"/html/portlet/document/setting/dm_giayto_list.jsp");
						if (Validator.isNotNull(keyWord)) {
							backUrl.setParameter("searchKeyWord", keyWord);
						}
						if (Validator.isNotNull(doituongGroup)) {
							backUrl.setParameter("doituongGroup", doituongGroup);
						}

						if (actionTyPe.compareTo(DanhMucGiayToBusiness.VIEW_DM_GIAYTO) != 0) {
						%> 
						<span><input type="submit" class="egov-button-normal"
						name="submitButton" id="submitButton" value="Lưu lại" /></span> 
						<%
					 	}
					 	%> 					
 						<span style="padding-left: 10px;"><a
						href="<%=backUrl.toString()%>"><input type="button"
							name="backUrl" class="egov-button-normal" value="Quay lại danh sách" /></a></span>
		</td>
	</tr>	
	</tbody>
</table>
</form>
</div>
<script type="text/javascript">
	//liemnn
	//doan trinh sau se thuc hien chon tat ca cac gia tri trong multi check
	
	function getSelectValues(selectId){
		var selectedValues = [];
		 $("#"+selectId+" option").each(function() {
			 selectedValues.push(this.value);
		   
		   
		  });
		 return selectedValues;
		     
		}
	
	$(document).ready(function(){
		
		$('#moTaDMGT').keyup(function() {
            var len = this.value.length;
            if (len >= 200) {
                this.value = this.value.substring(0, 200);
            }
            $('#charLeft').text(200 - len);
        });
		$('#submitButton').click(function(){
			document.getElementById("giatridoituongId").value = getSelectValues('doituongId');
			//alert(document.getElementById("giatridoituongId").value);
			 document.<portlet:namespace/>dMGTForm.submit();
		});
	   }
	);

	$('#gioiHanDL').bind('input propertychange', function () {
	    $(this).val($(this).val().replace(/[^0-9]/g, ''));
	});
	//$('input#maDMGT').val($(this).val().toUpperCase());
	  $('#maDMGT').keyup(function() {
	        $(this).val($(this).val().toUpperCase());
	    });
</script>