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
<%@page import="org.oep.cmon.dao.dvc.service.TTHC2CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.QuocGia"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CapDonViHanhChinhLocalServiceUtil"%>
<%@page
	import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.DonViHanhChinh"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page
	import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page
	import="org.oep.cmon.portlet.document.util.DocumentConstants"%>
<%@page import="org.oep.cmon.portlet.document.business.ThuTucHanhChinhBusiness"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/init.jsp"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
		PortletURL searchURL = renderResponse.createActionURL();
		searchURL.setParameter(ActionRequest.ACTION_NAME, "updateCQQL");	
		searchURL.setParameter(	"jspPage","/html/portlet/document/setting/cau_hinh_co_quan_quan_ly.jsp");
		
		String ungDung = ParamUtil.getString(request,"ungDung", "0");
		String nhomTTHC= ParamUtil.getString(request,"nhomTTHC", "0");
		
		long tthcId = ParamUtil.getLong(request, "tthcId");
		
		String quocgiaId = "";
		String tinhId = "";
		String huyenId = "";
		String xaId = "";
		String tthcID="";
		if (tthcId == 0) {
			tthcID = renderRequest.getAttribute("tthcID").toString();
		}
		if (Validator.isNotNull(tthcID)) {
			tthcId = Long.parseLong(tthcID);
		}

		quocgiaId = (String) renderRequest.getAttribute("quocgiaId") == null ? ""
				: (String) renderRequest.getAttribute("quocgiaId");

		tinhId = (String) renderRequest.getAttribute("tinhId") == null ? ""
				: (String) renderRequest.getAttribute("tinhId");

		huyenId = (String) renderRequest.getAttribute("huyenId") == null ? ""
				: (String) renderRequest.getAttribute("huyenId");
		xaId = (String) renderRequest.getAttribute("xaId") == null ? ""
				: (String) renderRequest.getAttribute("xaId");
	%>
<portlet:resourceURL var="fetchValues" id="fetchDonViHanhChinh" />
<portlet:resourceURL var="fetchQuocGia" id="fetchQuocGia" />
<div class="egov-container">
<jsp:include page="/html/portlet/document/setting/tabs.jsp"
		flush="false" />
<br>
	<form name = "<portlet:namespace/>settingCQQLForm" method = "post" action = "<%=searchURL%>">
	<input type="hidden" name="tthcID" id="tthcID" value="<%=tthcId%>">	
	<input type="hidden" name="giaytoId" id="giaytoId" value="">
	<input type="hidden" name="ungDung" id="ungDung" value="<%=ungDung%>">
	<input type="hidden" name="nhomTTHC" id="nhomTTHC" value="<%=nhomTTHC%>">
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
				<td colspan="6" align="center"><br> <label
					class="egov-label-header">Cấu hình cơ quan quản lý cho: </label><span
					style="font-size: 16px; font-style: italic">"<%=ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(tthcId).getTen() %>"
				</span> <br>
				<br></td>
			</tr>
			<tr>
				<td colspan="6">
				<select style="display: none;" id="egov-form-errors">
		      		<option value="cqqlId"><liferay-ui:error key="emptyCoQuanQuanLy" message = "org.oep.cmon.document.setting.chcqql.form.cqql.empty"/></option>
				</select>
				<liferay-ui:error
						key="errorAddTTHC2CQQL"
						message="org.oep.cmon.document.setting.chcqql.form.error.update" /> 
				<liferay-ui:error
						key="errorUpdateTTHC"
						message="org.oep.cmon.document.setting.tthc.form.error.update" /> 
				<%
				if (ParamUtil.getString(request, "CompletedUpdateTTHC") != null 
					&& ParamUtil.getString(request, "CompletedUpdateTTHC").trim().length() > 0) {
					%> 
					<liferay-ui:success key="successUpdateTTHC" message="org.oep.cmon.document.setting.tthc.form.completed.update" />
					<%
				}%>
				 <input type="hidden" id="giatriCQQLId"	name="giatriCQQLId" value="" /></td>
			</tr>
			<tr>
				<td colspan="3"><label class="egov-label-bold">Quốc gia</label>
					<br> <select class="egov-select" id="quocgiaId"
					name="quocgiaId">
						<option value="0">
							--
							<liferay-ui:message
								key="org.oep.cmon.document.setting.chcqql.form.luachonquocgia" />
							--
						</option>
						<%
						long idQuocGia=0;
						
						if (quocgiaId != null && quocgiaId.length() > 0) {
							idQuocGia = Long.parseLong(quocgiaId);
						}
						
						List<QuocGia> list_quocgia= QuocGiaLocalServiceUtil.findByDaXoa(DocumentConstants.ACTIVE);
						for (QuocGia quocGia : list_quocgia) {
									String selectedQG = "";
									if (quocGia.getId() == idQuocGia) {
										selectedQG = "selected";
									}
						%>
						<option <%=selectedQG%> value="<%=quocGia.getId()%>"><%=quocGia.getTen()%></option>
						<%
							}// end for

						%>
				</select></td>

				<td colspan="3"><label class="egov-label-bold">Tỉnh /
						TP</label> <br> <select class="egov-select" id="tinhId" name="tinhId">
						
						<%			
						long quocgiaid = 1;
						if (quocgiaId != null && quocgiaId.length() > 0) {
							quocgiaid = Long.parseLong(quocgiaId);
						}
						if (quocgiaId == null || quocgiaId == "") {
					%>
						<option value="0">
							--
							<%=quocgiaId%><liferay-ui:message
								key="org.oep.cmon.document.setting.chcqql.form.luachontinh" />
							--
						</option>
						<%
						} else {
							
							List<DonViHanhChinh> list_tinh_tp = new ArrayList<DonViHanhChinh>();
							
							Long tp_tw=CapDonViHanhChinhLocalServiceUtil.fetchCapDonViHanhChinh(FormatUtil.convertToLong(DocumentConstants.MA_CAPDVHC.TP_TW)).getId();
							Long tinh=CapDonViHanhChinhLocalServiceUtil.fetchCapDonViHanhChinh(FormatUtil.convertToLong(DocumentConstants.MA_CAPDVHC.CAP_TINH)).getId();
							
							List<DonViHanhChinh> list_tp = DonViHanhChinhLocalServiceUtil
									.findByQuocGiaId(quocgiaid, tp_tw,  DocumentConstants.ACTIVE);
							List<DonViHanhChinh> list_tinh = DonViHanhChinhLocalServiceUtil
									.findByQuocGiaId(quocgiaid, tinh,  DocumentConstants.ACTIVE);
							list_tinh_tp.addAll(list_tp);
							list_tinh_tp.addAll(list_tinh);
							for (DonViHanhChinh tinhTo : list_tinh_tp) {
								String selectedTinh = "";
								if (tinhTo.getId() == Long.parseLong(tinhId)) {
									selectedTinh = "selected";
								}
					%>
						<option <%=selectedTinh%> value="<%=tinhTo.getId()%>"><%=tinhTo.getTen()%></option>
						<%
						}// end for

						}
					%>
				</select></td>
			</tr>
			<tr>
				<td colspan="3"><label class="egov-label-bold">Quận /
						huyện</label> <br> <select class="egov-select" name="huyenId"
					id="huyenId">

						<%
						long tinhid = 31;
						if (tinhId != null && tinhId.length() > 0) {
							tinhid = Long.parseLong(tinhId);
						}
							if (tinhId == null || tinhId == "") {
						%>

						<option value="0">
							--
							<%=tinhId%><liferay-ui:message
								key="org.oep.cmon.document.setting.chcqql.form.luachonhuyen" />
							--
						</option>
						<%
							} else {

								List<DonViHanhChinh> list_huyen = DonViHanhChinhLocalServiceUtil
										.findByChaId(tinhid, DocumentConstants.ACTIVE);

								for (DonViHanhChinh quanHuyen : list_huyen) {
									String selected = "";
									if (quanHuyen.getId() == Long.parseLong(huyenId)) {
										selected = "selected";
									}
						%>
						<option <%=selected%> value="<%=quanHuyen.getId()%>"><%=quanHuyen.getTen()%></option>
						<%
							}// end for

							}
						%>
				</select></td>
				<td colspan="3"><label class="egov-label-bold">Phường /
						xã</label> <br> <select class="egov-select" name="xaId" id="xaId">
						
						<%
							long huyenid = 10052;
							if (huyenId != null && huyenId.length() > 0) {
								huyenid = Long.parseLong(huyenId);
							}
							if (huyenId == null || huyenId == "") {
						%>

						<option value="0">
							--
							<%=huyenId%>
							<liferay-ui:message
								key="org.oep.cmon.document.setting.chcqql.form.luachonxa" />
							--
						</option>
						<%
							} else {

								List<DonViHanhChinh> list_xa = DonViHanhChinhLocalServiceUtil
										.findByChaId(huyenid,DocumentConstants.ACTIVE);
								for (DonViHanhChinh xaphuong : list_xa) {
									String selected = "";
									if (xaphuong.getId() == Long.parseLong(xaId)) {
										selected = "selected";
									}
						%>
						<option <%=selected%> value="<%=xaphuong.getId()%>"><%=xaphuong.getTen()%></option>
						<%
							}// end for

							}
						%>

				</select></td>
			</tr>
			<tr>
				<td colspan="6" valign="top">
				<%
				List<CoQuanQuanLy> sysList=null;
				if(!xaId.equals("0"))
				{
					sysList = CoQuanQuanLyLocalServiceUtil.findByAllDonViHanhChinhId(FormatUtil.convertToLong(xaId), DocumentConstants.TypeSelect.CAP_XA, DocumentConstants.ACTIVE);
				}
				else if(!huyenId.equals("0"))
				{
					sysList = CoQuanQuanLyLocalServiceUtil.findByAllDonViHanhChinhId(FormatUtil.convertToLong(huyenId), DocumentConstants.TypeSelect.CAP_HUYEN, DocumentConstants.ACTIVE);
				}
				else 
				{
					sysList = CoQuanQuanLyLocalServiceUtil.findByAllDonViHanhChinhId(FormatUtil.convertToLong(tinhId), DocumentConstants.TypeSelect.CAP_TINH, DocumentConstants.ACTIVE);
				}

				List<TTHC2CoQuanQuanLy> docList =  null;
				if(tthcId>0){
					docList = TTHC2CoQuanQuanLyLocalServiceUtil.getDSTTHC2CoQuanQuanLy(tthcId,  DocumentConstants.ACTIVE);
				}
				%>
					<table cellpadding="0" cellspacing="0" style="width: 100%;">
						<tr>
							<td width="48%"><label class="egov-label-bold"> <liferay-ui:message
										key="org.oep.cmon.document.setting.chcqql.form.cqql" />
							</label> <select class="egov-multi-select" size="11" multiple="multiple"
								id="select-system-id">
								<%
		      					  if(sysList != null){
		      						  for(CoQuanQuanLy cqQL:sysList){
		      							  if(!ListUtil.isTT2CQQLExist(docList, cqQL.getId())){
		      								%>
		      									<option value="<%=cqQL.getId()%>"><%=cqQL.getTen()%></option>
		      								<%			  
		      							  }
		      						  }
		      					  }
		      					%>
							</select> <!-- du lieu cache du lieu nguon --> 
							<select
								id="select-data-system" style="display: none;">
								<%
		      					  if(sysList != null){
		      						  for(CoQuanQuanLy cqQLCache:sysList){
		      							  if(!ListUtil.isTT2CQQLExist(docList, cqQLCache.getId())){
		      								%>
		      									<option value="<%=cqQLCache.getId()%>"><%=cqQLCache.getTen()%></option>
		      								<%			  
		      							  }
		      						  }
		      					  }
		      					%>
							</select> <input type="text" value=""
								onkeyup="searchOptions(this.value,'select-data-system','select-system-id','cqqlId');"
								class="egov-inputfield" style="width: 96.5%;"></td>
							<td width="4%" align="center" style="padding: 10px;"><br>
								<br> <br> <br> <input type="button"
								class="egov-button-normal" id="move2TableId" value=">>" />
								<br>
								<br>
								<input type="button" class="egov-button-normal"  id="move2SelectId" value="<<"/>
							</td>
							<td width="48%">
								<label class="egov-label-bold"> <liferay-ui:message key="org.oep.cmon.document.setting.chcqql.form.cqqlduocchon" />
							</label> (<label class="egov-label-red">*</label>)
							<br>
								<!-- added by phucnv 2014-03-31 -->
								<table class="egov-table egov-multi-select" id="selectedCqqlId" style="width: 100%;">
									
										<tr>
											<th align="center" width="40%">Cơ quan quản lý</th>
											<th align="center" width="16%">Số ngày xử lý</th>
											<th align="center" width="20%">Phí</th>
											<th align="center" width="20%">Lệ phí</th>
											<th align="center" width="4%"></th>
										</tr>
									
									
										<%
								  		if(docList != null){
									  		for(TTHC2CoQuanQuanLy tt2CQQL:docList){
										  		CoQuanQuanLy cqqlSelected = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(tt2CQQL.getCoQuanQuanLyId());
										  		
										%>
												<tr id="cqqlIdTr-<%= cqqlSelected.getId()%>">
													<td width="40%">
														<input type="hidden" name="cqqlId" value="<%= cqqlSelected.getId()%>" />
														<%= cqqlSelected.getTen()%>
													</td>
													<td width="16%"><input class="egov-inputfield" style="width: 70%" id="soNgayXuLyId-<%=cqqlSelected.getId()%>" name="soNgayXuLy-<%=cqqlSelected.getId()%>" type="text" value="<%= tt2CQQL.getSoNgayXyLy()%>"/></td>
													<td width="20%"><input class="egov-inputfield" style="width: 80%" id="phiId-<%=cqqlSelected.getId()%>" name="phi-<%=cqqlSelected.getId()%>" type="text" value="<%= tt2CQQL.getPhi()%>"/></td>
													<td width="20%"><input class="egov-inputfield" style="width: 80%" id="lePhiId-<%=cqqlSelected.getId()%>" name="lePhi-<%=cqqlSelected.getId()%>" type="text" value="<%= tt2CQQL.getLePhi()%>"/></td>
													<td align="center" width="4%"><input id="checkboxId-<%=cqqlSelected.getId()%>" style="margin-top : 10px" type="checkbox" value="<%=cqqlSelected.getId() + "-" + cqqlSelected.getTen()%>"/></td>
												</tr>
										<%			  
										 
									  		}
								  		}
										%>
									
								</table>
								<portlet:resourceURL id="getTTHC2CoQuanQuanLyUsingAjax" var="getTTHC2CoQuanQuanLyUsingAjax"></portlet:resourceURL>
								<!-- end adding by phucnv 2014-03-31 -->
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="6" align="right">
				<input type="submit"
					class="egov-button-normal" id="ghilai"  name="ghilai" value="<liferay-ui:message key="org.oep.cmon.document.setting.chcqql.form.ghilai"/>" /> 
					
				<%			
				// Create upload avatar URL
				PortletURL backUrl = renderResponse.createRenderURL();	
		      	backUrl.setParameter("jspPage","/html/portlet/document/setting/thu_tuc_hanh_chinh_list.jsp");
		      	if (Validator.isNotNull(ungDung)) {
					backUrl.setParameter("ungDung", ungDung);
				}
				if (Validator.isNotNull(nhomTTHC)) {
					backUrl.setParameter("nhomTTHC", nhomTTHC);
				}
		      	%> 
				<a
				href="<%=backUrl%>"> <input type="button"
					class="egov-button-normal" value="<liferay-ui:message key="org.oep.cmon.document.setting.chcqql.form.quaylaidanhsach"/>" /></a></td>
			</tr>
		</table>
	</form>
		</div>
<script type="text/javascript">

	function getSelectValues(selectedCqqlId){
		var selectedValues = [];
		$("#"+selectedCqqlId+" tr[id|='cqqlIdTr'] input[type='hidden']").each(function() {
			selectedValues.push($(this).val());
		});
		return selectedValues;
	}

	$(document).ready(function(){		
		// CHange event on tinhthanh combobox
		//form.quocgiaId.options.selectedIndex = 0;
		
		$('#ghilai').click(function(){
			var selectedValues=getSelectValues('selectedCqqlId');
			if (selectedValues.length == 0 ){
				alert('<%=LanguageUtil.get(pageContext, "org.oep.cmon.document.setting.chcqql.form.cqql.validate") %>');
				return false;
			}
			else
				{
			document.getElementById("giatriCQQLId").value = selectedValues;
			// alert(document.getElementById("giatridoituongId").value);
			document.<portlet:namespace/>settingCQQLForm.submit();
				}
		});
	  
		$("#quocgiaId").change(function(){			 
		  	var url="<%=fetchQuocGia%>";
		  	var parentId = $("#quocgiaId").val();
		  	var tthcId = $("#tthcID").val();	
		  	
		  	$("#tinhId").empty();
		  	$("#tinhId").append("<option value='0'>--Chọn tỉnh--</option>");
		  	//$("#select-system-id").empty();
		  	//$("#select-data-system").empty();
		  	
		  	if (parentId != "") { 
				jQuery.getJSON(url+"&parentId=" + parentId+"&tthcId="+tthcId, function(data)  {
				   	for(var i=0; i < data.quocgiaArray.length; i++){
				   		quocgiaArray = data.quocgiaArray[i].split(":");
				    	$("#tinhId").append("<option value='"+ quocgiaArray[0] +"'>"+quocgiaArray[1]+"</option> " );
				   	}
				   	//for(var i=0; i < data.coquanQuanLyArray.length; i++){
				   	//	coquanQuanLyArray = data.coquanQuanLyArray[i].split(":");
				    //	$("#select-system-id").append("<option value='"+ coquanQuanLyArray[0] +"'>"+coquanQuanLyArray[1]+"</option> " );
				    //	$("#select-data-system").append("<option value='"+ coquanQuanLyArray[0] +"'>"+coquanQuanLyArray[1]+"</option> " );
				   	//}
		  		});
		  	}
		  	
	 	});	 
		
		 
		$("#tinhId").change(function(){			 
		  	var url="<%=fetchValues%>";
		  	var parentId = $("#tinhId").val();	  	
		  	var tthcId = $("#tthcID").val();	
		  	var type = <%=DocumentConstants.TypeSelect.CAP_TINH%>
		  	
		  	$("#huyenId").empty();
		  	$("#huyenId").append("<option value='0'>--Chọn huyện--</option>");
		  	$("#select-system-id").empty();
			$("#select-data-system").empty();
			
		  	if (parentId != "") { 
				jQuery.getJSON(url+"&parentId=" + parentId+"&tthcId="+tthcId+"&type="+type, function(data)  {
				   	for(var i=0; i < data.donViHanhChinhArray.length; i++){
				   		donViHanhChinhArray = data.donViHanhChinhArray[i].split(":");
				    	$("#huyenId").append("<option value='"+ donViHanhChinhArray[0] +"'>"+donViHanhChinhArray[1]+"</option> " );
				   	}
				   	for(var i=0; i < data.coquanQuanLyArray.length; i++){
				   		coquanQuanLyArray = data.coquanQuanLyArray[i].split(":");
				    	$("#select-system-id").append("<option value='"+ coquanQuanLyArray[0] +"'>"+coquanQuanLyArray[1]+"</option> " );
				    	$("#select-data-system").append("<option value='"+ coquanQuanLyArray[0] +"'>"+coquanQuanLyArray[1]+"</option> " );
				   	}
		  		});
		  	}
		  	
		  	
	 	});	 
		
		// CHange event on thuongtru_tinhthanh combobox
		$("#huyenId").change(function(){
		  	var url="<%=fetchValues%>";
			var parentId = $("#huyenId").val();
			var tthcId = $("#tthcID").val();
			var type = <%=DocumentConstants.TypeSelect.CAP_HUYEN%>
			
			$("#xaId").empty();
			$("#xaId").append("<option value='0'>--Chọn xã--</option>");
			$("#select-system-id").empty();
			$("#select-data-system").empty();

			if (parentId != "") {
				jQuery.getJSON(url+ "&parentId="+ parentId+"&tthcId="+tthcId+"&type="+type,	function(data) {
					for ( var i = 0; i < data.donViHanhChinhArray.length; i++) {
						donViHanhChinhArray = data.donViHanhChinhArray[i]
								.split(":");
						$("#xaId").append("<option value='"+ donViHanhChinhArray[0] +"'>"
												+ donViHanhChinhArray[1]
												+ "</option> ");
						}
					for(var i=0; i < data.coquanQuanLyArray.length; i++){
				   		coquanQuanLyArray = data.coquanQuanLyArray[i].split(":");
				    	$("#select-system-id").append("<option value='"+ coquanQuanLyArray[0] +"'>"+coquanQuanLyArray[1]+"</option> " );
				    	$("#select-data-system").append("<option value='"+ coquanQuanLyArray[0] +"'>"+coquanQuanLyArray[1]+"</option> " );
				   	}
						});
				}
			
			});
		$("#xaId").change(function(){
		  	var url="<%=fetchValues%>";
			var parentId = $("#xaId").val();
			var tthcId = $("#tthcID").val();
			var type = <%=DocumentConstants.TypeSelect.CAP_XA%>
			
			$("#select-system-id").empty();
			$("#select-data-system").empty();

			if (parentId != "") {
				jQuery.getJSON(url+ "&parentId="+ parentId+"&tthcId="+tthcId+"&type="+type,	function(data) {
					for(var i=0; i < data.coquanQuanLyArray.length; i++){
				   		coquanQuanLyArray = data.coquanQuanLyArray[i].split(":");
				    	$("#select-system-id").append("<option value='"+ coquanQuanLyArray[0] +"'>"+coquanQuanLyArray[1]+"</option> " );
				    	$("#select-data-system").append("<option value='"+ coquanQuanLyArray[0] +"'>"+coquanQuanLyArray[1]+"</option> " );
				   	}
						});
				}

			});

		// add by phucnv 2014-03-31
		var cqqlObjectArr;
		var i = 0;
		$("#select-system-id").change(function() {
			cqqlObjectArr = new Array();
			i = 0;
			$("#select-system-id option:selected").each(function() {
				var rowObject = new Object();
				rowObject.cqqlId = $(this).val();
				rowObject.cqqlName = $(this).text();
				cqqlObjectArr[i] = rowObject;
				i++;
			});
		});
		$("#move2TableId").click(function() {
			var cqqlIdChain = "";
			for (var j = 0; j < i; j++) {
				var optionValue = cqqlObjectArr[j].cqqlId;
				var processingOption = $("#select-system-id option[value='"+ optionValue +"']");

				// remove from select
				processingOption.remove();

				if (j == 0) {
					cqqlIdChain += optionValue;
				} else {
					cqqlIdChain += "," + optionValue;
				}
			}

			// add option to table
			$.ajax({
				url : "<%=getTTHC2CoQuanQuanLyUsingAjax%>",
				data : {
					tthcId: "<%=tthcId%>",
					cqqlIdChain: cqqlIdChain
				},
				dataType : "json",
				success : function(json) {
					var jsonDataArray = json['tthc2Cqqls'];
					for (var i = 0; i < cqqlObjectArr.length; i++) {
						var selectedCqqlObject = cqqlObjectArr[i];
						selectedCqqlObject.soNgayXuLy = 0;
						selectedCqqlObject.phi = 0;
						selectedCqqlObject.lePhi = 0;
						for ( var j = 0; j < jsonDataArray.length; j++) {
							if (selectedCqqlObject.cqqlId == jsonDataArray[j]["cqqlId"]) {
								selectedCqqlObject.soNgayXuLy = jsonDataArray[j]["soNgayXuLy"];
								selectedCqqlObject.phi = jsonDataArray[j]["phi"];
								selectedCqqlObject.lePhi = jsonDataArray[j]["lePhi"];
								break;
							}
						}

						// add new data
						addRow4SelectedCqql(selectedCqqlObject);
					}
				}
			});

		});
		
		$("#move2SelectId").click(function() {
			cqqlObjectArr = new Array();
			i = 0;
			$("input[id|='checkboxId']:checked").each(function() {
				var rowObject = new Object();
				var checkedCqql = $(this).attr('value');
				rowObject.cqqlId = checkedCqql.split("-")[0];
				rowObject.cqqlName = checkedCqql.split("-")[1];
				cqqlObjectArr[i] = rowObject;
				i++;
			});
			for (var j = 0; j < i; j++) {
				var cqqlObject = cqqlObjectArr[j];

				// remove from selected coquanquanly
				removeFromSelectedCqql(cqqlObject.cqqlId);

				// add to select box - coquanquanly
				add2CoQuanQuanLy(cqqlObject);
			}
		});
	});
	function addRow4SelectedCqql(rowData) {
		var row = '<tr id="cqqlIdTr-' + rowData.cqqlId + '">';
		row += '<td width="40%"><input type="hidden" name="cqqlId" value="' + rowData.cqqlId + '" />' + rowData.cqqlName + '</td>';
		row += '<td width="16%"><input class="egov-inputfield" style="width: 70%" id="soNgayXuLyId-' + rowData.cqqlId + '" name="soNgayXuLy-' + rowData.cqqlId + '" type="text" value="' + rowData.soNgayXuLy + '"/></td>';
		row += '<td width="20%"><input class="egov-inputfield" style="width: 80%" id="phiId-' + rowData.cqqlId + '" name="phi-' + rowData.cqqlId + '" type="text" value="' + rowData.phi + '"/></td>';
		row += '<td width="20%"><input class="egov-inputfield" style="width: 80%" id="lePhiId-' + rowData.cqqlId + '" name="lePhi-' + rowData.cqqlId + '" type="text" value="' + rowData.lePhi + '"/></td>';
		row += '<td align="center" width="4%"><input id="checkboxId-' + rowData.cqqlId + '" style="margin-top : 10px" type="checkbox" value="' + rowData.cqqlId + '-' + rowData.cqqlName + '"/></td>';
		row += '</tr>';
		$("#selectedCqqlId").append(row);
	}
	function removeFromSelectedCqql(cqqlId) {
		$("#selectedCqqlId tr[id='cqqlIdTr-" + cqqlId + "']").remove();
	}

	function add2CoQuanQuanLy(cqqlObject) {
		var optionStr = '<option value="' + cqqlObject.cqqlId + '">' + cqqlObject.cqqlName + '</option>';
		$("#select-system-id").append(optionStr);
	}
</script>