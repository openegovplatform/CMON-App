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
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="javax.persistence.criteria.CriteriaBuilder.In"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTuc2GiayToLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo"%>
<%@page
	import="org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.tlct.model.DanhMucGiayTo"%>
<%@page
	import="org.oep.cmon.portlet.document.util.DocumentConstants"%>
<%@page import="org.oep.cmon.portlet.document.business.ThuTucHanhChinhBusiness"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/document/setting/init.jsp"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<portlet:actionURL var="searchCHDMGT" name="searchCHDMGT">
	<portlet:param name="jspPage" value="/html/portlet/document/setting/cau_hinh_danh_muc_giay_to.jsp"/>	
</portlet:actionURL>	
<%

	PortletURL searchURL = renderResponse.createActionURL();
	searchURL.setParameter(ActionRequest.ACTION_NAME, "searchCHDMGT");
	searchURL.setWindowState(LiferayWindowState.NORMAL);
	
	String ungDung = ParamUtil.getString(request,"ungDung", "0");
	String nhomTTHC= ParamUtil.getString(request,"nhomTTHC", "0");
		
	Long tthc = ParamUtil.getLong(request,"tthcId");
	Long giaiDoan= ParamUtil.getLong(request,"giaiDoanId");
	Long tthcId = tthc == 0L ? null:tthc;
	Long giaiDoanId = giaiDoan == 0L ? 1L:giaiDoan;
	Long TTHC=ParamUtil.getLong(request,"tthcID");
	Long tthcID = TTHC == 0L ? null:TTHC;
	if(tthcID!=null)
	{
		tthcId=tthcID;
	}
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setWindowState(LiferayWindowState.NORMAL);	
	iteratorUrl.setParameter(	"jspPage","/html/portlet/document/setting/cau_hinh_danh_muc_giay_to.jsp");
	
	 if (renderRequest.getParameter("tthcID") != null) {
		 iteratorUrl.setParameter("tthcID", String.valueOf(tthcId));
	 }
	 if (renderRequest.getParameter("giaiDoanId") != null) {
		 iteratorUrl.setParameter("giaiDoanId", String.valueOf(giaiDoanId));
	 }
	
	int cur =  Integer.valueOf(prefs.getValue("curGT", "1"));
	int delta =  Integer.valueOf(prefs.getValue("deltaGT", "10"));
	int curnext = ParamUtil.getInteger(renderRequest, "cur", 1);
	int deltanext = ParamUtil.getInteger(renderRequest, "delta", 10);
	if(curnext!=cur)
	{
		cur=curnext;
	}
	if(deltanext!=delta)
	{
		delta=deltanext;
	}
	
	List<ThuTuc2GiayTo> results = null;
	
	Long size = ThuTucHanhChinhLocalServiceUtil.countByTTHCIdOrGDId(tthcId, giaiDoanId, DocumentConstants.TTHC2DT.DaXoa);
	
	SearchContainer searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			cur, delta, iteratorUrl, null, null);
	
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();	
	
	if (size.intValue() > 0) {
		results=ThuTucHanhChinhLocalServiceUtil.searchByTTHCIdOrGDId(tthcId, giaiDoanId, DocumentConstants.TTHC2DT.DaXoa, start, end);
		
	}
	if (results == null) {
		results = new ArrayList<ThuTuc2GiayTo>();
	}
	
	searchContainer.setTotal(size.intValue());
	searchContainer.setResults(results);

%>
<div class="egov-container">
<jsp:include page="/html/portlet/document/setting/tabs.jsp"
		flush="false" />
<br>
	<form name = "<portlet:namespace/>updateForm" method = "post" action = "<%=searchURL%>">
	<input type="hidden" name="tthcID" id="tthcID" value="<%=tthcId%>">	
	<input type="hidden" name="giaytoId" id="giaytoId" value="">
	<input type="hidden" name="ungDung" id="ungDung" value="<%=ungDung%>">
	<input type="hidden" name="nhomTTHC" id="nhomTTHC" value="<%=nhomTTHC%>">
		<p><label class="egov-label-header">Cấu hình tài liệu cho: </label><span style="font-size: 16px;font-style: italic">"<%=ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(tthcId).getTen() %>"</span></p>
		<br>
			<table   class="egov-table-form2" style="width: 100%">
			<tbody>
				<tr>
					<td colspan="2" align = "left" width="30%"><select class="egov-select" name="giaiDoanId"
						id="giaiDoanId" onchange="document.<portlet:namespace/>updateForm.submit()">							
							<%
								
							%>
							<option value="<%=DocumentConstants.GIAIDOAN.NOPHOSO %>" <%=DocumentConstants.GIAIDOAN.NOPHOSO ==giaiDoanId ? "selected"
						: ""%>	>						
							<liferay-ui:message key="org.oep.cmon.document.setting.chdmgt.select.nohoso"/></option>
							<option value="<%=DocumentConstants.GIAIDOAN.TRAKETQUA %>"  <%=DocumentConstants.GIAIDOAN.TRAKETQUA ==giaiDoanId ? "selected"
						: ""%>>							
							<liferay-ui:message key="org.oep.cmon.document.setting.chdmgt.select.traketqua"/></option>
					</select>
				</td>	
			 <td align = "right" width="70%">
			 <%
							PortletURL addMoreDMGTUrl = renderResponse.createRenderURL();
							// This will remove header and footer in theme
							//addMoreDMGTUrl.setWindowState(LiferayWindowState.POP_UP);
							addMoreDMGTUrl.setWindowState(LiferayWindowState.EXCLUSIVE);	
							addMoreDMGTUrl.setParameter("tt2popId",String.valueOf(tthcId));
							addMoreDMGTUrl.setParameter("giaiDoan2popId",String.valueOf(giaiDoanId));
							addMoreDMGTUrl.setParameter("jspPage", "/html/portlet/document/setting/popup_giay_to.jsp");					
							%>
			    	<button type="button" name="addMoreDMGT" class="egov-button-normal" title="Bổ sung thêm giấy tờ" onclick="javascript:<portlet:namespace/>showPopup('<%=addMoreDMGTUrl%>')">Bổ sung thêm giấy tờ</button>
			    </td>
		</tr>
		  <tr>
			    <td colspan="6">
			    	<liferay-ui:error key="errorDeleteTT2GT" message = "org.oep.cmon.document.setting.chdmgt.error.delete"/>
			    	<%
				if (request.getAttribute("delete_success") != null && request.getAttribute("delete_success").toString().trim().length() > 0) {
					%>				
					<liferay-ui:success key="successDeleteTT2GT" message="org.oep.cmon.document.setting.chdmgt.completed.delete"/>
					<%
				}
				%>
				<liferay-ui:error key="errorUpdateTT2GT" message = "org.oep.cmon.document.setting.chdmgt.error.update"/>
			    	<%
				if (request.getAttribute("update_success") != null && request.getAttribute("update_success").toString().trim().length() > 0) {
					%>
					<liferay-ui:success key="successUpdateTT2GT" message="org.oep.cmon.document.setting.chdmgt.completed.update"/>
					<%
				}
				%>
			    </td>
			 </tr>
		</tbody>
		</table>
		
				<table width="100%" cellpadding="0" cellspacing="0" class="egov-table">
					<tr>
						<td width="5%" style="text-align:center"><label class="egov-label-bold">STT</label></td>
						<td width="65%"  style="text-align:center"><label class="egov-label-bold">Tên tài liệu</label></td>
						<td width="10%" style="text-align:center"><label class="egov-label-bold">Bắt buộc</label></td>
						<td width="10%" style="text-align:center"><label class="egov-label-bold">Thứ tự</label></td>
						<td width="5%" style="text-align:center"><label class="egov-label-bold">Chức năng</label></td>
					</tr>
					<%
					List items = results;
					int index=0;
					for (int i = 0; i < results.size(); i++) {
						ThuTuc2GiayTo tt2GT = (ThuTuc2GiayTo) items.get(i);
						index++;
					PortletURL deleteUrl = renderResponse.createActionURL();
					deleteUrl.setParameter(ActionRequest.ACTION_NAME, "deleteGTRequest");
					deleteUrl.setParameter("jspPage", "/html/portlet/document/setting/cau_hinh_danh_muc_giay_to.jsp");
					deleteUrl.setParameter("tt2gtId", String.valueOf(tt2GT.getId()));
					 %>
						<tr>
							<td style="text-align:center"><%=(searchContainer.getStart()+i+1)%></td>
							
							<td>
							<%
							//DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(tt2GT.getDanhMucGiayToId()).getTen();
							%> 
							<p>	<%=tt2GT.getNguoiTao() %></p> 
							
							</td>
							<td style="text-align:center">
							<input type="checkbox" name="<%=tt2GT.getId() %>_batbuoc"  <%=ThuTucHanhChinhBusiness.checkTrueValue(tt2GT.getBatBuoc(),DocumentConstants.TTHC2DT.BatBuoc)%> value="<%=DocumentConstants.TTHC2DT.BatBuoc %>" />
							</td>
							<td style="text-align:center">
							<input name="<%=tt2GT.getId() %>_thutu"  type="text" id="txtThutu" maxlength="5" class = "egov-inputfield" value = "<%=tt2GT.getThuTuHienThi()%>" style="width:50px" onkeypress="CheckNumeric(event);" />
							
							</td>
							<td style="text-align:center"><button class="egov-func-delete" title="Xóa" onclick="javascript:<portlet:namespace/>submitForm('<%=deleteUrl.toString()%>')"></button></td>
						
					</tr>
					<%
					}
				%>				
			</table>
			
				<div id="pagination">
				<liferay-ui:search-paginator searchContainer="<%=searchContainer%>" />
				</div>
				<table class="egov-table-form2">
					<tbody>
						<tr>
						<%
						PortletURL editRequestUrl = renderResponse.createActionURL();
						editRequestUrl.setParameter("ActionType", "editGTRequest");
						editRequestUrl.setParameter("jspPage", "/html/portlet/document/setting/cau_hinh_danh_muc_giay_to.jsp");
						
						//editRequestUrl.setParameter("tt2gtId", String.valueOf(tt2GT.getId()));
					
						// back URL
						PortletURL backUrl = renderResponse.createRenderURL();
						backUrl.setParameter("jspPage",
								"/html/portlet/document/setting/thu_tuc_hanh_chinh_list.jsp");
						if (Validator.isNotNull(ungDung)) {
							backUrl.setParameter("ungDung", ungDung);
						}
						if (Validator.isNotNull(nhomTTHC)) {
							backUrl.setParameter("nhomTTHC", nhomTTHC);
						}
						%>
							<td>
							<input type="submit" class="egov-button-normal"
							value="<liferay-ui:message key="org.oep.cmon.document.setting.chdmgt.button.ghilai"/>"
							id="ghilai" name="ghilai"></td>
							<td><a
						href="<%=backUrl.toString()%>"><input type="button"
							name="backUrl" class="egov-button-normal" value="Quay lại danh sách" /></a></td>
						</tr>
							
					</tbody>
				</table>
				</form>
	</div>
	
<script type="text/javascript">
function <portlet:namespace/>showPopup(url) {
  AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
    var dialog = new A.Dialog({
    		stack: true,
            title: 'Bổ sung tài liệu',
   			height:610,
   			width:897,
            centered: true,
            draggable: true,
            destroyOnClose: true,
            modal: true,
            on: {
				close: function(evt){
					//$("#congDanCT").removeAttr("readonly");
					Liferay.Portlet.refresh(A.one('#p_p_id"+renderResponse.getNamespace()+"'));
				}
			}
        }).plug(A.Plugin.IO, {uri: url}).render();     
        dialog.show();     
  });
}
</script>
<script type="text/javascript">	
function <portlet:namespace/>openWindow(url) {
	var newWindow = window
			.open(
					url,
					'Search popup',
					'height=580,width=900,left=90,top=100,resizable=no,location=no,status=no,menubar=no,scrollbars=yes');

	if (window.focus) {
		newWindow.focus();
	}

	return false;
}
function CheckNumeric(e) {
	 
    if (window.event) // IE 
    {
        if ((e.keyCode < 48 || e.keyCode > 57) & e.keyCode != 8) {
            event.returnValue = false;
            return false;

        }
    }
    else { // Fire Fox
        if ((e.which < 48 || e.which > 57) & e.which != 8) {
            e.preventDefault();
            return false;

        }
    }
}

$('#txtThutu').bind('input propertychange', function () {
	    $(this).val($(this).val().replace(/[^0-9]/g, ''));
	});

function reloadForm(popup) {	
	document.<portlet:namespace/>updateForm.submit();
	popup.close();
}

function <portlet:namespace/>submitForm(url) {	
	var answer = confirm('<%=LanguageUtil.get(pageContext, "org.oep.cmon.document.setting.chdmgt.confirm.delete") %>');
		if (answer){
		document.<portlet:namespace/>updateForm.action=url;
		document.<portlet:namespace/>updateForm.submit();
	}
}

</script>