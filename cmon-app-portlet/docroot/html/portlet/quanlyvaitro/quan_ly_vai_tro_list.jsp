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
<%@page import="org.oep.cmon.dao.nsd.model.TaiNguyen"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="org.oep.cmon.portlet.quanlyvaitro.business.QuanLyVaiTroBusiness"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.util.DateUtil"%>
<%@page import="org.oep.cmon.util.Helpers"%>
<%@page import="org.oep.cmon.dao.nsd.model.VaiTro"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="org.oep.cmon.Constants.Paging" %>
<%@ include file="/html/portlet/init.jsp" %>

<%
	int cur =  Integer.valueOf(prefs.getValue("curCC", "1"));
	int delta =  Integer.valueOf(prefs.getValue("deltaCC", String.valueOf(Paging.DELTA)));
	int curnext = ParamUtil.getInteger(renderRequest, "cur", 1);
	int deltanext = ParamUtil.getInteger(renderRequest, "delta", Paging.DELTA);
	if(curnext!=cur) {
		cur = curnext;
	}
	if(deltanext!=delta) {
		delta = deltanext;
	}

	PortletURL searchUrl = renderResponse.createActionURL();
	searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchVaiTroRequest");

	PortletURL addNewUrl = renderResponse.createActionURL();
	addNewUrl.setParameter(ActionRequest.ACTION_NAME, "prepareVaiTroRequest");
	addNewUrl.setParameter("actionType", QuanLyVaiTroBusiness.ADD_VAI_TRO);
	addNewUrl.setParameter("jspPage", "/html/portlet/quanlyvaitro/quan_ly_vai_tro_add.jsp");
	addNewUrl.setParameter("cur", String.valueOf(cur));
	addNewUrl.setParameter("delta", String.valueOf(delta));

	String keyWord = ParamUtil.getString(request, "searchKeyWord", "");
	if (Helpers.isEmpty(keyWord) && renderRequest.getPortletSession().getAttribute("searchKeyWord") != null) {
		keyWord = renderRequest.getPortletSession().getAttribute("searchKeyWord").toString();
	}

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/html/portlet/quanlyvaitro/quan_ly_vai_tro_list.jsp");
	iteratorUrl.setParameter("searchKeyWord", keyWord);

	// Get the search result from session if it exists
	List<VaiTro> results = null;

	SearchContainer searchContainer = new SearchContainer(
	renderRequest, null, null,
	SearchContainer.DEFAULT_CUR_PARAM, cur, delta, iteratorUrl,
	null, null);

	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();

	Long size = 0L;

	try {

		size = QuanLyVaiTroBusiness.countByVaiTro(keyWord);			
		results = QuanLyVaiTroBusiness.findByVaiTro(keyWord, start, end);

	} catch (Exception e) {
		SessionErrors.add(renderRequest, "searchError");
	}

	if (results == null) {
		results = new ArrayList<VaiTro>();
	}
	searchContainer.setTotal(size.intValue());
	searchContainer.setResults(results);
%>

<div class="egov-container">
<form name = "<portlet:namespace/>searchVaiTroForm" method = "post" action = "<%=searchUrl%>" onsubmit = "<portlet:namespace/>checkForm()">

<br><br>
			<table   class="egov-table-form" style="width: 100%">
			  <tr>
			    <td align = "left" width="25%">		    
			     	<input name="searchKeyWord" type="text"  class="egov-inputfield-search" style="width: 96%;"
			     	      value = "<%=HtmlUtil.escape(keyWord)%>" placeholder="<%=LanguageUtil.get(pageContext,"org.oep.cmon.quanlyvaitro.list.search.defaultValue")%>" />
			    </td>			   
			    <td  width="10%" valign="top" style="padding-left: 15px;">&nbsp;	
			 			<input type="submit" name="button" value=""  class="egov-button-search" title="Tìm kiếm"/>
			 	</td>		
			    <td align = "right" width="65%">
			    	<input type="button" name="button" value="+ THÊM MỚI" 
			    	 class="egov-button-normal" onclick="javascript: window.location = '<%=addNewUrl.toString()%>'" style="float: right;"/>
			    </td>
			  </tr>
			  <tr>
			    <td colspan="3">
				    <liferay-ui:error key="deleteError" message = "org.oep.cmon.quanlyvaitro.list.error.delete"/>
					<liferay-ui:error key="searchError" message = "org.oep.cmon.quanlyvaitro.list.error.search"/>
					<liferay-ui:success key="deleteCompleted" message = "org.oep.cmon.quanlyvaitro.list.completed.delete"/>
			    </td>
			 </tr>
			</table>
		</form>
<table cellpadding="0" cellspacing="0" class="egov-table" width="100%">
	<tbody>
		<tr>
			<th width="5%" style="text-align:center">TT</th>
			<th width="30%">Tên</th>
			<th width="10%" style="text-align:center">Mã</th>
			<th width="25%" style="text-align:center">Tên tài nguyên</th>
			<th width="17%" style="text-align:center">Trạng thái</th>
			<th width="13%" style="text-align:center">Chức năng</th>
		</tr>
		<%
			if (results != null && results.size() > 0) {
				for (int i = 0; i < results.size(); i++) {
					VaiTro vaiTro = (VaiTro) results.get(i);

					PortletURL viewRequestUrl = renderResponse.createActionURL();
					viewRequestUrl.setParameter(ActionRequest.ACTION_NAME, "prepareVaiTroRequest");
					viewRequestUrl.setParameter("actionType", QuanLyVaiTroBusiness.VIEW_VAI_TRO);
					viewRequestUrl.setParameter("jspPage", "/html/portlet/quanlyvaitro/quan_ly_vai_tro_add.jsp");
					viewRequestUrl.setParameter("vaiTroId",	String.valueOf(vaiTro.getId()));
					viewRequestUrl.setParameter("cur", String.valueOf(cur));
					viewRequestUrl.setParameter("delta", String.valueOf(delta));

					PortletURL editRequestUrl = renderResponse.createActionURL();
					editRequestUrl.setParameter(ActionRequest.ACTION_NAME, "prepareVaiTroRequest");
					editRequestUrl.setParameter("actionType", QuanLyVaiTroBusiness.UPDATE_VAI_TRO);
					editRequestUrl.setParameter("jspPage", "/html/portlet/quanlyvaitro/quan_ly_vai_tro_add.jsp");
					editRequestUrl.setParameter("vaiTroId",	String.valueOf(vaiTro.getId()));
					editRequestUrl.setParameter("cur", String.valueOf(cur));
					editRequestUrl.setParameter("delta", String.valueOf(delta));

					PortletURL deleteUrl = renderResponse.createActionURL();
					deleteUrl.setParameter(ActionRequest.ACTION_NAME, "deleteVaiTroRequest");
					deleteUrl.setParameter("jspPage", "/html/portlet/quanlyvaitro/quan_ly_vai_tro_list.jsp");
					deleteUrl.setParameter("vaiTroId", String.valueOf(vaiTro.getId()));
					deleteUrl.setParameter("cur", String.valueOf(cur));
					deleteUrl.setParameter("delta", String.valueOf(delta));
					
					PortletURL viewTaiNguyenUrl = renderResponse.createRenderURL();
		      		// This will remove header and footer in theme
		      		viewTaiNguyenUrl.setWindowState(LiferayWindowState.EXCLUSIVE);
		      		viewTaiNguyenUrl.setParameter("jspPage", "/html/portlet/tainguyen/tai_nguyen_popup.jsp");
		      		viewTaiNguyenUrl.setParameter("vaiTroId", String.valueOf(vaiTro.getId()));
					
		%>
		<tr>
			<td style="text-align:center"><%=(searchContainer.getStart() + i + 1)%></td>
			<td><a href="<%=viewRequestUrl.toString()%>" class="bold" title="<%=vaiTro.getMoTa()%>"><%=vaiTro.getTen()%></a></td>
			<td style="text-align:center"><%=vaiTro.getMa()%></td>
			<td >
			<%
			
			List<TaiNguyen> taiNguyenList = null;
			List<List<TaiNguyen>> configList = QuanLyVaiTroBusiness.findAllTaiNguyenByVaiTro(String.valueOf(vaiTro.getId()));
			if (configList != null && configList.size() > 1) {
				taiNguyenList			= (configList.get(1) != null)?configList.get(1): null;
				int idx = 0;
				String selectedGroup = null;
				for (TaiNguyen taiNguyen:taiNguyenList ) {
					idx++;
					
			%>
				<%=idx%>.<%=taiNguyen.getTen()%><br>
			<% }
			}%>
			</td>
			<td style="text-align:center">
				<%=LanguageUtil.get(pageContext,"org.oep.cmon.quanlyvaitro.form.trangThai."+vaiTro.getTrangThai())%>
			</td>
				<td align="center">
					<table class="egov-table-function" style="width: 100%">
						<tbody>
							<tr>
								<td style="width: 25%"><a href="<%=viewRequestUrl.toString()%>" style="padding: 0px">
									<button class="egov-func-detail" title="Xem"></button></a></td>
								<td style="width: 25%"><a href="<%=editRequestUrl.toString()%>" style="padding: 0px"><button
											class="egov-func-edit" title="Sửa"></button></a></td>
								<td style="width: 25%"><button class="egov-func-delete" title="Xóa"
										onclick="javascript:<portlet:namespace/>deleteRow('<%=deleteUrl.toString()%>')"></button></td>
								<td style="width: 25%"><a href="#" onclick="javascript:showPopup('<%=viewTaiNguyenUrl.toString()%>')" style="padding: 0px">
										<button class="egov-func-config" title="Xem tài nguyên"></button></a></td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>			
			<%
		}
			}
			else 
			{
				%>
				<tr>
					<td colspan="5" align="center"><label class="egov-label">Không có bản ghi dữ liệu nào.</label></td>
				</tr>
				<%
			}
				%>
			</tbody>
	</table>
	<%
			if (searchContainer != null) {
		%>
	<div id = "pagination">
			<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
		</div>
		<%
			}
		%>
</div>
<script type="text/javascript">
function <portlet:namespace/>deleteRow(url) {
	var answer = confirm('<%=LanguageUtil.get(pageContext, "org.oep.cmon.quanlyvaitro.list.confirm.delete") %>');
	if (answer){
		window.location = url;
	}
}

function <portlet:namespace/>checkForm(){
	var form = document.<portlet:namespace/>searchVaiTroForm;		
}

function showPopup(url) {
	AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
		var dialog = new A.Dialog({
			stack: true,
			title: 'Danh sách tài nguyên',
			height:600,
			width:800,
			centered: true,
			draggable: true,
			destroyOnClose: true,
			modal: true,
			on: {
				close: function(evt){
					Liferay.Portlet.refresh(A.one('#p_p_id"+renderResponse.getNamespace()+"'));
				}
			}
		}).plug(A.Plugin.IO, {uri: url}).render(); 
		dialog.show(); 
	});
}

</script>
