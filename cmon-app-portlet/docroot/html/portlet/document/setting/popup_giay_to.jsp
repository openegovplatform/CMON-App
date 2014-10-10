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
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="javax.persistence.criteria.CriteriaBuilder.In"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="org.oep.cmon.portlet.document.util.ListUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTuc2GiayToLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung"%>
<%@page import="org.oep.sharedservice.cmon.Constants"%>
<%@page
	import="org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.admin.portlet.business.LoaiDoiTuongBusiness"%>
<%@page import="org.oep.cmon.dao.dvc.model.DoiTuongSuDung"%>
<%@page
	import="org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.tlct.model.DanhMucGiayTo"%>
<%@page
	import="org.oep.cmon.portlet.document.util.DocumentConstants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/document/setting/init.jsp"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	PortletURL searchUrl = renderResponse.createActionURL();
	searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchPopupDocument");
		
	String keyWord = ParamUtil.getString(request,"searchKeyWord", "");
	String doituongGroup= ParamUtil.getString(request,"doituongSuDung", "");
	Long tthcId=ParamUtil.getLong(request, "tt2popId");
	Long giaiDoanId=ParamUtil.getLong(request, "giaiDoan2popId");
	Long tthcID=ParamUtil.getLong(request, "tthcId");
	Long giaiDoanID=ParamUtil.getLong(request, "giaiDoanId");	
	
	// Get default search value
	String defaultSearch = LanguageUtil.get(pageContext, "org.oep.cmon.document.setting.popup.dmgt.search.defaultValue");
	
	if(Validator.isNotNull(tthcID))
	{
		tthcId=tthcID;
	}
	if(Validator.isNotNull(giaiDoanID))
	{
		giaiDoanId=giaiDoanID;
	}
	
	//searchKeyWord
	PortletURL iteratorUrl = renderResponse.createRenderURL();		
	//iteratorUrl.setWindowState(LiferayWindowState.EXCLUSIVE);
	iteratorUrl.setParameter("jspPage", "/html/portlet/document/setting/popup_giay_to_result.jsp");
	//iteratorUrl.setParameter("doituongSuDung", doituongGroup);
	if(Validator.isNotNull(keyWord)){
		 iteratorUrl.setParameter("searchKeyWord", keyWord);
	 }
	 if (Validator.isNotNull(doituongGroup)) {
		 iteratorUrl.setParameter("doituongSuDung", doituongGroup);
	 }
	 
	 if (Validator.isNotNull(tthcId)) {
		 iteratorUrl.setParameter("tthcId", String.valueOf(tthcId));
	 }
	 if (Validator.isNotNull(giaiDoanId)) {
		 iteratorUrl.setParameter("giaiDoanId", String.valueOf(giaiDoanId));
	 }
	
	int cur =  Integer.valueOf(prefs.getValue("cur2pop", "1"));
	int delta =  Integer.valueOf(prefs.getValue("delta2pop", "10"));
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
	
	SearchContainer searchContainer = new SearchContainer(renderRequest, null,
	null, SearchContainer.DEFAULT_CUR_PARAM,
	cur, delta, iteratorUrl, null, null);

	List<DanhMucGiayTo> result = null;
	
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();	
		
	Long longTotal=DanhMucGiayToLocalServiceUtil.countByTTHCIdOrGDId(keyWord, doituongGroup, tthcId, giaiDoanId, DocumentConstants.TTHC2DT.DaXoa);
	result = DanhMucGiayToLocalServiceUtil.searchByTTHCIdOrGDId(keyWord, doituongGroup, tthcId, giaiDoanId, DocumentConstants.TTHC2DT.DaXoa, start, end);
	
	if (result == null) {
		result = new ArrayList<DanhMucGiayTo>();
	}

	List<DoiTuongSuDung> lstDoiTuong = new ArrayList<DoiTuongSuDung>();
	lstDoiTuong = DoiTuongSuDungLocalServiceUtil
			.getDSDoiTuongSuDung(Constants.ACTIVATED);

	searchContainer.setTotal(longTotal.intValue());
	searchContainer.setResults(result);
%>

<div class="egov-container">
	<form name="<portlet:namespace/>searchForm" method="post" action="<%=searchUrl.toString()%>"  onsubmit='<%="event.preventDefault(); "%>'>
	<input type="hidden" name="tthcId" id="tthcId" value="<%=tthcId%>">	
	<input type="hidden" name="giaiDoanId" id="giaiDoanId" value="<%=giaiDoanId%>">
	<input type="hidden" name="action" id="action" value="">
		<br>
		<p><label class="egov-label-header">Bổ sung thêm giấy tờ</label></p>
		<br>
			<table   class="egov-table-form2" style="width: 100%">
			<tbody>
				<tr>
					<td align = "left"  style="width:25%">
					<input name="searchKeyWord" type="text" id="searchKeyWord"  class="egov-inputfield-search" size="40" style="width: 200px;" value = "<%=HtmlUtil.escape(keyWord)%>" placeholder="<%=defaultSearch%>" />
					</td>
			     	<td align = "left" style="width:23%; padding-left: 5px" ><select class="egov-select" style="width: 190px" name="doituongSuDung"
						id="doituongSuDung" >
							<option value="">--Lọc tất cả các nhóm--</option>
							<%
								for (DoiTuongSuDung doiTuong : lstDoiTuong) {
							%>
							<option value="<%=doiTuong.getMa()%>"
								<%=doiTuong.getMa().equals(doituongGroup) ? "selected"
						: ""%>><%=doiTuong.getTen()%></option>

							<%
								}
							%>

					</select></td>
					<td align = "left"><span style="padding-left: 5px"><input type="submit" name="buttonSearch" id="buttonSearch" value=""  class="egov-button-search" /></span></td>								
				</tr>
				 <tr>
			    <td colspan="6" style="width:95%">
			    	<liferay-ui:error key="errorAddPopupTT2GT" message = "org.oep.cmon.document.setting.popup.dmgt.error.add"/>
			    	<%
				if (request.getAttribute("add_success") != null 
					&& request.getAttribute("add_success").toString().trim().length() > 0) {
					%>
					<liferay-ui:success key="successAddPopupTT2GT" message="org.oep.cmon.document.setting.popup.dmgt.completed.add"/>
					<%
				}
				%>
			    </td>
			 </tr>
			</tbody>
		</table>
		<div id="danhSachTaiLieu">
		<!-- TABLE RESULT -->
		</div>
		<table class="egov-table-form2" >
					<tbody>
						<tr>
						
							<td>
							<input type="submit" class="egov-button-normal" value="Chọn tài liệu"  title="Chọn tài liệu"  id="selectButton" name="selectButton" /></td>
							<td><button name="closeForm" id="closeForm" class="egov-button-normal" title="Đóng lại" onclick="javascript:closeAuiPopUp();">Đóng lại</button></td>
						</tr>
							
					</tbody>
				</table>
	</form>	
</div>
<script type="text/javascript">

function closeAuiPopUp(){
		var answer = confirm('<%=LanguageUtil.get(pageContext, "org.oep.cmon.document.setting.chdmgt.confirm.exit.popup") %>');
		if (answer){
			top.document.getElementById('closethick').click();
		}
	}
		
	$(document).ready(function() {
		setTimeout(function() {
			timTaiLieu();
		},0);
	});


	function timTaiLieu() {
		AUI().use('aui-io-plugin','aui-io-request', 'aui-io', 'node', 'event', 'event-custom','gallery-base64',
		function(A) {
			var searchKeyWord = A.one('#searchKeyWord').val().trim(),
			doituongSuDung = A.one('#doituongSuDung').val().trim(),			
			url = "<%= iteratorUrl.toString() %> ";
			//alert(doituongSuDung);			
			var content = A.one('#danhSachTaiLieu');
			content.plug(A.Plugin.IO,{autoLoad: false,failureMessage: '',});
			content.io.set('uri', url+"&searchKeyWord="+searchKeyWord+"&doituongSuDung="+doituongSuDung);
			content.io.start(); 
	 	});
	}

	$('#buttonSearch').click(function(){	
		//alert("test 1");
		timTaiLieu();
	});
	
	$("#doituongSuDung").change(function(){	
		//alert("test 2");
		timTaiLieu();
	});


	function resultPageSelect(node,url){
		AUI().use('aui-io-plugin','aui-io-request', 'aui-io', 'node',
		function(A) {
			var content = A.one('#danhSachTaiLieu');
			content.plug(A.Plugin.IO,{autoLoad: false,failureMessage: '',});
			content.io.set('uri', url+$(node).val());
			content.io.start(); 
		});
	}
	

	$(window).keydown(function(event){
		if(event.keyCode == 13) {
			$('#buttonSearch').trigger('click');
		}
		if(event.keyCode == 27) {
			$('#closeForm').trigger('click');
		}
	});

	$(".delta-selector").hide(0); // Will hide the div and free its space.
	$(".delta-selector").css('visibility', 'hidden');
	
	AUI().ready('aui-io-plugin','node', function(A) {
		paginatorSearchContainer(
			A.one('#danhSachTaiLieu'), 
			A.one('.taglib-page-iterator'),
			A.one('#<portlet:namespace />page')
		);

		function paginatorSearchContainer(target, paginatorBar, pageSelector){	    
			target.plug(A.Plugin.IO,{autoLoad: false});
			if(typeof paginatorBar !== "undefined" && paginatorBar != null) {
				paginatorBar.all('a').on('click',function(event) {
					event.preventDefault();
					//chuyen che do xem tu normal sang exclusive
					var uri = event.currentTarget.get('href').replace('normal', 'exclusive');
					target.io.set('uri', uri);
					//chay duong dan sang trang
					target.io.start();
				});

				var url = paginatorBar.one('a').get('href').replace('normal', 'exclusive');
				url = url.substring(0, url.length - 1);

				var page = pageSelector.getDOM();
				$(page).attr('onchange','resultPageSelect(this,"'+url+'")');
			};
		}
		
	});
	$('#selectButton').click(function(){	
		var radios = document.getElementsByName("selectedGT");
		var value = "";
	
		for ( var i = 0; i < radios.length; i++) {
			if (radios[i].checked) {
				value = radios[i].value;	
				//alert(value);
				document.<portlet:namespace/>searchForm.submit();
				//Liferay.Util.getOpener().reloadForm(this);
			}
			
		}

		if (value == "") {
			alert("Xin chọn ít nhất một tài liệu."); 
			return;
		}
		
	});	
	
	
	function <portlet:namespace/>doUpdate(url){		
		var c = document.getElementsByTagName('input'); 
	  	for (var i = 0; i < c.length; i++) { 
		if (c[i].type == 'checkbox' && c[i].checked == true) { 
	    // At least one checkbox IS checked 	
	    document.<portlet:namespace/>selectForm.command.value= 'update';
	    document.<portlet:namespace/>selectForm.action=url;
		document.<portlet:namespace/>selectForm.submit();
	  } 
	} 
	// Nothing has been checked 
	alert("Xin chọn ít nhất một tài liệu."); 
		//return false; 
	}  
	
	<%
	if(request.getAttribute("action")!= null){
		%>
		 top.document.getElementById('closethick').click();
	     var curPortletBoundaryId = '#p_p_id<portlet:namespace />';
	     Liferay.Portlet.refresh(curPortletBoundaryId);
		<%
	}
		
	%>
</script>