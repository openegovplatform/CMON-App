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
<%@page import="org.oep.sharedservice.cmon.provider.storage.DocumentStorageImpl"%>
<%@page import="org.oep.sharedservice.cmon.provider.storage.IDocumentStorage"%>
<%@page import="org.oep.cmon.dao.dvc.service.VanBanHuongDanLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.VanBanHuongDan"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page
	import="org.oep.cmon.portlet.document.util.DocumentConstants"%>
<%@page import="org.oep.cmon.portlet.document.business.ThuTucHanhChinhBusiness"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/init.jsp"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	PortletURL searchURL = renderResponse.createActionURL();
	searchURL.setParameter(ActionRequest.ACTION_NAME, "searchCHVBBM");
	
	String ungDung = ParamUtil.getString(request,"ungDung", "0");
	String nhomTTHC= ParamUtil.getString(request,"nhomTTHC", "0");
	
	Long tthc = ParamUtil.getLong(request,"tthcId");
	Long loaiTaiLieu= ParamUtil.getLong(request,"loaiTaiLieuId");
	Long tthcId = tthc == 0L ? null:tthc;
	Long loaiTaiLieuId = loaiTaiLieu == 0L ? 1L:loaiTaiLieu;
	Long TTHC=ParamUtil.getLong(request,"tthcID");
	Long tthcID = TTHC == 0L ? null:TTHC;
	if(tthcID!=null)
	{
		tthcId=tthcID;
	}
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();	
	iteratorUrl.setParameter(	"jspPage","/html/portlet/document/setting/cau_hinh_huong_dan_bieu_mau.jsp");
	
	 if (renderRequest.getParameter("tthcID") != null) {
		 iteratorUrl.setParameter("tthcID", String.valueOf(tthcId));
	 }
	 if (renderRequest.getParameter("loaiTaiLieuId") != null) {
		 iteratorUrl.setParameter("loaiTaiLieuId", String.valueOf(loaiTaiLieuId));
	 }	 

	int cur =  Integer.valueOf(prefs.getValue("curBM", "1"));
	int delta =  Integer.valueOf(prefs.getValue("deltaBM", "10"));
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
	
	List<VanBanHuongDan> results = null;
	
	Long size = ThuTucHanhChinhLocalServiceUtil.countByTTHC2HDBM(tthcId, loaiTaiLieuId, DocumentConstants.TTHC2DT.DaXoa);
	
	SearchContainer searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			cur, delta, iteratorUrl, null, null);
	
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();	
	
	if (size.intValue() > 0) {
		results=ThuTucHanhChinhLocalServiceUtil.searchByTTHC2HDBM(tthcId, loaiTaiLieuId, DocumentConstants.TTHC2DT.DaXoa, start, end);
		
		
	}
	if (results == null) {
		results = new ArrayList<VanBanHuongDan>();
	}
	
	searchContainer.setTotal(size.intValue());
	searchContainer.setResults(results);

%>
<portlet:actionURL var="searchCHVBBM" name="searchCHVBBM">
	<portlet:param name="jspPage" value="/html/portlet/document/setting/cau_hinh_huong_dan_bieu_mau.jsp"/>	
</portlet:actionURL>	
<div class="egov-container">
<jsp:include page="/html/portlet/document/setting/tabs.jsp"
		flush="false" />
<br>
	<form name = "<portlet:namespace/>updateForm" method = "post" action = "<%=searchURL%>">
	<input type="hidden" name="tthcID" id="tthcID" value="<%=tthcId%>">	
	<input type="hidden" name="giaytoId" id="giaytoId" value="">
	<input type="hidden" name="ungDung" id="ungDung" value="<%=ungDung%>">
	<input type="hidden" name="nhomTTHC" id="nhomTTHC" value="<%=nhomTTHC%>">
		<p><label class="egov-label-header">Cấu hình hướng dẫn và biểu mẫu cho: </label><span style="font-size: 16px;font-style: italic">"<%=ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(tthcId).getTen() %>"</span></p>
		<br>
			<table   class="egov-table-form2" style="width: 100%">
			<tbody>
				<tr>
					<td colspan="2" align = "left" width="30%"><select class="egov-select" name="loaiTaiLieuId"
						id="loaiTaiLieuId" onchange="document.<portlet:namespace/>updateForm.submit()">							
							
							<option value="<%=DocumentConstants.TTHC2VBBM.HUONG_DAN %>" <%=DocumentConstants.TTHC2VBBM.HUONG_DAN == loaiTaiLieuId ? "selected"
						: ""%>	>--						
							<liferay-ui:message key="org.oep.cmon.document.setting.chhdbm.select.huongdan"/>--
							</option>
							<option value="<%=DocumentConstants.TTHC2VBBM.BIEU_MAU %>"  <%=DocumentConstants.TTHC2VBBM.BIEU_MAU ==loaiTaiLieuId ? "selected"
						: ""%>>	--					
							<liferay-ui:message key="org.oep.cmon.document.setting.chhdbm.select.bieumau"/>
							--</option>
					</select>
				</td>	
			 <td align = "right" width="70%">
			 <%
							PortletURL addMoreTaiLieuUrl = renderResponse.createRenderURL();
							// This will remove header and footer in theme
							//addMoreTaiLieuUrl.setWindowState(LiferayWindowState.POP_UP);
							addMoreTaiLieuUrl.setWindowState(LiferayWindowState.EXCLUSIVE);							
							addMoreTaiLieuUrl.setParameter("tt2popId",String.valueOf(tthcId));
							addMoreTaiLieuUrl.setParameter("loaiTL2popId",String.valueOf(loaiTaiLieuId));
							addMoreTaiLieuUrl.setParameter("jspPage",
									"/html/portlet/document/setting/popup_tai_lieu.jsp");					
							%>
			    	<button type="button" name="addMoreTaiLieu" class="egov-button-normal" title="Bổ sung thêm tài liệu" onclick="javascript:<portlet:namespace/>showPopup('<%=addMoreTaiLieuUrl%>')">Bổ sung thêm tài liệu</button>
			    </td>
		</tr>
		  <tr>
			    <td colspan="6">
			    	<liferay-ui:error key="errorDeleteHDVB" message = "org.oep.cmon.document.setting.chhdbm.error.delete"/>
			    	<%
				if (request.getAttribute("delete_success") != null && request.getAttribute("delete_success").toString().trim().length() > 0) {
					%>
					<liferay-ui:success key="successDeleteHDVB" message="org.oep.cmon.document.setting.chhdbm.completed.delete"/>
					<%
				}
				%>
				<liferay-ui:error key="errorUpLoadHDVB" message = "org.oep.cmon.document.setting.chhdbm.error.upload"/>
				<liferay-ui:error key="errorUpdateHDVB" message = "org.oep.cmon.document.setting.chhdbm.error.update"/>
			    	<%
				if (request.getAttribute("update_success") != null && request.getAttribute("update_success").toString().trim().length() > 0) {
					%>
					<liferay-ui:success key="successUpdateHDVB" message="org.oep.cmon.document.setting.chhdbm.completed.update"/>
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
						<td width="10%"  style="text-align:center"><label class="egov-label-bold">Tải file</label></td>
						<td width="10%" style="text-align:center"><label class="egov-label-bold">Chức năng</label></td>
					</tr>
					<%
					List items = results;
					int index=0;
					for (int i = 0; i < results.size(); i++) {
						VanBanHuongDan tt2VB = (VanBanHuongDan) items.get(i);
						index++;
					PortletURL deleteUrl = renderResponse.createActionURL();
					deleteUrl.setParameter(ActionRequest.ACTION_NAME, "deleteVBRequest");
					deleteUrl.setParameter("jspPage", "/html/portlet/document/setting/cau_hinh_huong_dan_bieu_mau.jsp");
					deleteUrl.setParameter("tt2vbId", String.valueOf(tt2VB.getId()));
					
					PortletURL getFileUrl = renderResponse.createActionURL();
					getFileUrl.setParameter(ActionRequest.ACTION_NAME, "getFileUploadRequest");
					getFileUrl.setParameter("jspPage", "/html/portlet/document/setting/cau_hinh_huong_dan_bieu_mau.jsp");
					getFileUrl.setParameter("tt2vbId", String.valueOf(tt2VB.getId()));
					getFileUrl.setParameter("noiluutruId", String.valueOf(tt2VB.getNoiLuuTruId()));
					
					//Get File Upload			
					long fileUploadId = tt2VB.getNoiLuuTruId();	
					IDocumentStorage iDocumentStorage = new DocumentStorageImpl();
					String urlFileUpload=iDocumentStorage.getURLById(fileUploadId);
					 %>
					<tr>
						<td style="text-align:center"><%=(searchContainer.getStart()+i+1)%></td>
						<td><%=tt2VB.getTenTaiLieu() %></td>
						<td style="text-align:center"><span>
						<a href="<%=urlFileUpload%>">
						<img id = "<%=tt2VB.getId() %>_image_download" style="display: inherit;" src="/cmon-app-portlet/images/bg-detail-download.png" title="Tải file" />
						</a>
						</span></td>
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
							
							<td><a	href="<%=backUrl.toString()%>"><input type="button"
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
            title: 'Upload File',
   			height:542,
   			width:577,
            centered: true,
            draggable: true,
            destroyOnClose: true,
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
					'height=530,width=900,left=90,top=100,resizable=no,location=no,status=no,menubar=no');

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
	var answer = confirm('<%=LanguageUtil.get(pageContext, "org.oep.cmon.document.setting.chhdbm.confirm.delete") %>');
		if (answer){
		document.<portlet:namespace/>updateForm.action=url;
		document.<portlet:namespace/>updateForm.submit();
	}
}
function getFileUpload(UrlDelete, fileId) {
	document.getElementById('message_error').innerHTML = '';
	document.getElementById('message_error_delete_file').innerHTML = '';
	$.ajax({
		type: 'POST'
		,url: UrlDelete
		,data : {}
		,success: function(data) {		

			// preferred
			var data2 = JSON.parse(data);
			// Xoa cac old item in select
			
			if (data2.deleteComplete == 'completed') {
				document.getElementById(fileId).style.display = 'none';
				document.getElementById(fileId + '_image_delete').style.display = 'none';
				document.getElementById('message_error_delete_file').innerHTML = messageDeleted;
			} else {
				document.getElementById('message_error').innerHTML = '';
				document.getElementById('message_error').innerHTML = '<%=LanguageUtil.get(pageContext, "org.oep.cmon.document.setting.chvbbm.error.delete.file.upload") %>';
			}
		}
	});
}

</script>