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
<%@page import="java.util.ArrayList"%>
<%@page import="org.oep.cmon.admin.portlet.util.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.nsd.service.VaiTroLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.VaiTro"%>
<%@page import="org.oep.cmon.admin.portlet.business.CoQuanQuanLyBusiness"%>
<%@page import="org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.ChucVu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<%
	PortletURL actionUrl = renderResponse.createActionURL();
	actionUrl.setParameter(ActionRequest.ACTION_NAME, "addQuyenToCoQuanQuanLy");
	
	PortletURL changeActionUrl = renderResponse.createActionURL();
	changeActionUrl.setParameter(ActionRequest.ACTION_NAME, "reloadQuyenToCoQuanQuanLy");
	
	String coQuanQuanLyID = renderRequest.getParameter("coQuanQuanLyID");
	String chuc_vu_id = renderRequest.getParameter("chuc_vu_id");
	
	String keyWord = "";
	String searchOption = ParamUtil.getString(request, "searchOption").trim();
	String parentId = ParamUtil.getString(request, "parentId").trim();
%>

<div class="egov-container"  align="left">
	<form id="addGanQuyen" name="addGanQuyen" method="post" action="<%=actionUrl.toString() %>" onsubmit="return autoSelectedAllOptions()">
		<table class="egov-table-form" >
			<tr>
				<td width="16.67%">&nbsp;</td>
				<td width="16.67%">&nbsp;</td>
				<td width="16.67%">&nbsp;<input type="hidden" value="<%=keyWord%>" name="keyWord" id="keyWord"/></td>
				<td width="16.67%">&nbsp;<input type="hidden" value="<%=searchOption%>" name="searchOption" id="searchOption"/></td>
				<td width="16.67%">&nbsp;<input type="hidden" value="<%=parentId%>" name="parentId" id="parentId"/></td>
				<td width="16.67%">&nbsp; <input type="hidden" value="<%=coQuanQuanLyID%>" name="coQuanQuanLyID" id="coQuanQuanLyID"/> </td>
			</tr>
			<tr>
				<td  colspan="6">
					<label class="egov-label-note">Tên cơ quan quản lý:</label> <label class="egov-label-bold"><%=ConvertUtil.getTenCoQuanQuanLy(ConvertUtil.convertToLong(coQuanQuanLyID)) %></label>
				</td>
			</tr>
			<tr>
				<td  colspan="6">
					<span style="color: red" id="message_error"></span>
				</td>
			</tr>
			<tr>
				<td colspan="5">
					<label class="egov-label-note">Tên chức vụ</label> 
					:<label class="egov-label-red">(*)</label></label>
					<%
					List<ChucVu> lChucVus = CoQuanQuanLyBusiness.findChucVuByDaXoa(0);
					%>
					<select class="egov-select custom" id="chuc_vu_id" name="chuc_vu_id" onchange="javascript: changeSelectedChucVu()">
					<%
						ChucVu firstChucVu = null;
						ChucVu chucVu = null; 
						if (lChucVus.size() > 0) {
							firstChucVu = lChucVus.get(0);
						}
						for (int i = 0; i < lChucVus.size(); i++) {
							chucVu = lChucVus.get(i);
							%>
							<option <%=ConvertUtil.checkSelectedValue(chuc_vu_id, chucVu.getId()) %> value="<%=chucVu.getId() %>"><%=chucVu.getTen() %></option>
							<%
						}
						if (firstChucVu != null && (chuc_vu_id == null || chuc_vu_id.trim().length() == 0)) {
							chuc_vu_id = String.valueOf(firstChucVu.getId());
						}
					%>
					</select>
					<input type="submit" value="Thêm mới"/>
				</td>
				<td>
					<%
					PortletURL searchUrl = renderResponse.createActionURL();
					searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchCoQuanQuanLy");
					searchUrl.setParameter("keyWord", keyWord);
					searchUrl.setParameter("parentId", parentId);
					searchUrl.setParameter("searchOption", searchOption);
					%>
					<!-- <a href = "searchUrl">Quay lại</a> -->
				</td>
			</tr>
			<tr>
				<td colspan="6" valign="top">
					<table  cellpadding="0" cellspacing="0">
						<tr>
							<td width="43%">
								<label class="egov-label-bold">
									Vai trò hệ thống
								</label>
								<select class="egov-multi-select" size="11" multiple="multiple" id="select-system-id">
								<%
								List<VaiTro> lVaiTros = CoQuanQuanLyBusiness.findVaiTroByDaXoa(0);
								List<VaiTro> liVaiTrosSelected = new ArrayList<VaiTro>();
								if (chuc_vu_id != null && chuc_vu_id.trim().length() > 0) {
									liVaiTrosSelected = CoQuanQuanLyBusiness.findListVaiTroByChucVuId(ConvertUtil.convertToLong(chuc_vu_id), ConvertUtil.convertToLong(coQuanQuanLyID));
								}
								
								List<VaiTro> liVaiTrosNotSelected = CoQuanQuanLyBusiness.checkListVaiTroNotSelected(lVaiTros, liVaiTrosSelected);
								for (VaiTro vaiTro : liVaiTrosNotSelected) {
								%>
									<option value="<%=vaiTro.getId() %>"><%=vaiTro.getTen() %></option>
								<%
								}
								%>
								</select>
								<!-- du lieu cache du lieu nguon -->
								<select id="select-data-system" style="display:none;">
									<%
									for (VaiTro vaiTro : lVaiTros) {
									%>
										<option value="<%=vaiTro.getId() %>"><%=vaiTro.getTen() %></option>
										<%
									}
									%>
								</select>
								<input type="text" value=""
									onkeyup="searchOptions(this.value,'select-data-system','select-system-id','select-selected-id');" 
									class="egov-inputfield" style="width: 96.5%;">
							</td>
							<td width="4%" align="center" style="padding:10px; ">
								<br><br><br><br>
								<input type="button" class="egov-button-normal" value=">>" 
								onclick="moveOptions('select-system-id','select-selected-id');">
								<br><br>
								<input  type="button" class="egov-button-normal" value="<<" 
									onclick="moveOptions('select-selected-id','select-system-id');">
							</td>
							<td width="43%">
								<label class="egov-label-bold">
									Vai trò được chọn
								</label>
								<select class="egov-multi-select" size="13" multiple="multiple" id="select-selected-id" name="select-selected-id">
									<%
									for (VaiTro vaiTro : liVaiTrosSelected) {
									%>
										<option value="<%=vaiTro.getId() %>"><%=vaiTro.getTen() %></option>
										<%
									}
									%>
								</select>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<hr>
		<table style="background-color: white;">
			<tr>
				<td width="14%"></td>
				<td>
					<%
					if (liVaiTrosSelected.size() > 0) {
					%>
					<table cellpadding="0" cellspacing="0"  class="egov-table" width="615">
						<tr>
							<th>TT</th>
							<th>Chức vụ</th>
							<th>Vai trò</th>
							<th>Chức năng</th>
						</tr>
						<%
						int index = 1;
						for (VaiTro vaiTro : liVaiTrosSelected) {
							PortletURL deleteVaiTro = renderResponse.createActionURL();
							deleteVaiTro.setParameter(ActionRequest.ACTION_NAME, "deleteQuyenToCoQuanQuanLy");
							deleteVaiTro.setParameter("keyWord", keyWord);
							deleteVaiTro.setParameter("coQuanQuanLyID", coQuanQuanLyID);
							deleteVaiTro.setParameter("chuc_vu_id", chuc_vu_id);
							deleteVaiTro.setParameter("vaitro_id", String.valueOf(vaiTro.getId()));
							deleteVaiTro.setParameter("parentId", parentId);
							deleteVaiTro.setParameter("searchOption", searchOption);
							
							PortletURL viewChucVuChiTietPopup = renderResponse.createRenderURL();
					        viewChucVuChiTietPopup.setWindowState(LiferayWindowState.POP_UP);
					        viewChucVuChiTietPopup.setParameter("vaitro_id", String.valueOf(vaiTro.getId()));
					        viewChucVuChiTietPopup.setParameter("jspPage","/html/portlet/admin/vaitro_quyenliferay_list_popup.jsp");
							%>
							<tr>
								<td  class="bold"><%=index++ %></td>
								<td><%=ConvertUtil.findChucVuByID(ConvertUtil.convertToLong(chuc_vu_id)).getTen() %></td>
								<td><%=vaiTro.getTen() %></td>
								<td><a href = "javascript: showChucVuChiTietPopup('<%=viewChucVuChiTietPopup.toString()%>')">Xem</a>|<a href = "<%=deleteVaiTro%>">Xóa</a></td>			
							</tr>
							<%
						}
						%>
					</table>
					<%
					}
					%>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="button" value="Đóng lại" onclick="javascript: closeForm()"/>
				</td>
		</table>
	</form>
</div>

<script type = "text/javascript">
	function autoSelectedAllOptions()
	{
		var x=document.getElementById("select-selected-id");
		if (x.length > 0) {
			var i;
			for (i=0;i<x.length;i++)
			{
				x.options[i].selected = 'selected';
			}
			return true;
		} else {
			document.getElementById('message_error').innerHTML = '<%=LanguageUtil.get(pageContext, "vn.dtt.cmon.admin.coquanquanly.chucvu.vaitro.error.empty") %>';
			return false;
		}
	}

	function showChucVuChiTietPopup(url) {            
		 AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
             
             var dialog = new A.Dialog({
                 title: '',
                 draggable: true,
                 modal: true,
                 centered: true,
                 width: $(window).width()*0.6,
                 height: $(window).height()*0.5,
                 
             }).plug(A.Plugin.IO, {uri: url, data: {}}).render();
       });
    }

	function closeForm()
	{
		window.location = '<%=searchUrl.toString() %>';
	}
	
	function changeSelectedChucVu()
	{
		document.getElementById("addGanQuyen").action = '<%=changeActionUrl.toString()%>';
	    document.getElementById("addGanQuyen").submit();
	}
	
</script>
