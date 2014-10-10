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
<%@page import="org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.service.VaiTroLocalServiceUtil"%>
<%@page import="java.util.Arrays"%>
<%@page import="org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro"%>
<%@page import="org.oep.cmon.dao.cc.model.ChucVu"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.oep.cmon.dao.nsd.model.VaiTro"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
String coQuanQuanLyId = "";
long chucVuId = 0l;
String searchInputText = ""; 
String parentId = "";
List<ChucVu2VaiTro> listChucVu2VaiTro = new ArrayList<ChucVu2VaiTro>();
List<ChucVu> listChucVu = new ArrayList<ChucVu>();
List<VaiTro> listVaiTro = new ArrayList<VaiTro>();
//get request atts
if(Validator.isNotNull(request.getAttribute("searchInputText"))){
	searchInputText = request.getAttribute("searchInputText").toString();
}
if(Validator.isNotNull(request.getAttribute("parentId"))){
	parentId = request.getAttribute("parentId").toString();
}
if(Validator.isNotNull(request.getAttribute("coQuanQuanLyId"))){
	coQuanQuanLyId = request.getAttribute("coQuanQuanLyId").toString();
}
if(Validator.isNotNull(request.getAttribute("chucVuId"))){
	chucVuId = Long.valueOf(request.getAttribute("chucVuId").toString());
}
if(Validator.isNotNull(request.getAttribute("listChucVu2VaiTro"))){
	listChucVu2VaiTro = (List<ChucVu2VaiTro>)request.getAttribute("listChucVu2VaiTro");
}
if(Validator.isNotNull(request.getAttribute("listChucVu"))){
	listChucVu = (List<ChucVu>)request.getAttribute("listChucVu");
}
if(Validator.isNotNull(request.getAttribute("listVaiTro"))){
	listVaiTro = (List<VaiTro>)request.getAttribute("listVaiTro");
}
List<Long> vaiTroIds = new ArrayList<Long>();
for(int i=0;i<listChucVu2VaiTro.size();i++){
	vaiTroIds.add(listChucVu2VaiTro.get(i).getVaiTroId());
}
CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(Long.valueOf(coQuanQuanLyId));
//end get params
//save CQQL URL
PortletURL saveChucVuURL = renderResponse.createActionURL();
saveChucVuURL.setParameter(ActionRequest.ACTION_NAME, "saveChucVu");
saveChucVuURL.setParameter("parentId",parentId);
saveChucVuURL.setParameter("searchInputText",searchInputText);
//back to list CQQL URL
PortletURL backToChucVuURL = renderResponse.createActionURL();
backToChucVuURL.setParameter(ActionRequest.ACTION_NAME, "listChucVuCoQuanQuanLy");
backToChucVuURL.setParameter("coQuanQuanLyId", coQuanQuanLyId);
backToChucVuURL.setParameter("parentId",parentId);
backToChucVuURL.setParameter("searchInputText",searchInputText);
%>
<html>
<style>
.egov-table tr:hover{
	background: #fff !important;
}
.egov-table tr td{
	border:none !important;
	padding: 0px 10px !important;	
}
.egov-inputfield{
	width: 100%;
	min-height: 20px !important ;
	padding: 5px 10px !important;
}
.btn-move-vaitro{
	width: 50px;
	font-weight: bold;
}
.sel-multiple{
	height: 300px;
}
.aui-form-validator-error-container .aui-field-element{
	display: block !important;
}
</style>	
<div class="egov-container">
<aui:form action="<%=saveChucVuURL.toString()%>" method="post" name="frmCreateChucVu" id="frmCreateChucVu">
	<table class="egov-table" width="100%" border="0">
		<thead>
			<tr>
				<td colspan="3">
					<aui:input name="coquanquanlyid" type="hidden" value="<%=coQuanQuanLyId %>"></aui:input>
					<h3>Cơ quan quản lý: <b><%=coQuanQuanLy.getTen() %></b></h3>
				</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="1" style="width: 40% !important">
					<%
					if(chucVuId!=0){
					%>
					<aui:input name="chucvuid" type="hidden" value="<%=chucVuId %>"/>
					<b>Chức vụ: <%=ChucVuLocalServiceUtil.fetchChucVu(chucVuId).getTen() %></b>
					<%}else{ %>
					<aui:select name="chucvuid" id="chucvuid" label="Chức vụ <label class='egov-label-red'>(*)</label>" inputCssClass="egov-inputfield">
						<aui:option value="">--Hãy chọn--</aui:option>
						<%
						for(int i = 0; i< listChucVu.size();i++){
							boolean isSelected = false;
							ChucVu chucVu = listChucVu.get(i);
							if(chucVuId == chucVu.getId()){
								isSelected = true;
							}
						%>	
						<aui:option value="<%=chucVu.getId() %>" selected="<%=isSelected %>"><%= chucVu.getTen()%></aui:option>					
						<%} %>
					</aui:select>
					<%} %>
				</td>
				<td colspan="2" style="width: 50% !important">
					
				</td>
			</tr>
			<tr>
				<td width="40%">
				<aui:select name="" id="select-system-id" label="Vai trò hệ thống" multiple="true" size="15" inputCssClass="egov-inputfield egov-multi-select">
					<%
					for(int i = 0; i< listVaiTro.size();i++){
						VaiTro vaiTro = listVaiTro.get(i);
						if(!vaiTroIds.contains(vaiTro.getId())){
					%>	
					<aui:option value="<%=vaiTro.getId() %>"><%= vaiTro.getTen()%></aui:option>					
					<%}} %>
				</aui:select>
					<!-- du lieu cache du lieu nguon -->
				<aui:select id="select-data-system" name="" style="display:none;">
					<%
					for(int i = 0; i< listVaiTro.size();i++){
						VaiTro vaiTro = listVaiTro.get(i);
					%>	
					<aui:option value="<%=vaiTro.getId() %>"><%= vaiTro.getTen()%></aui:option>					
					<%} %>
				</aui:select>
				<div class='egov-div-search' style='margin-top:3px;'>
   					<input type="text"  onkeyup="addChucVu.searchOptions(this.value,'select-data-system','select-system-id','select-selected-id');" />
   				</div>
				</td>
				<td width="10%" style="text-align: center !important">
					<input type="button" class="egov-func-select" value=">>" 
					onclick="addChucVu.moveAllOptions('select-system-id','select-selected-id');">
					<br><br>
					<input type="button" class="egov-func-select" value=">" 
					onclick="addChucVu.moveOptions('select-system-id','select-selected-id');">
					<br><br>
					<input  type="button" class="egov-func-select" value="<" 
					onclick="addChucVu.moveOptions('select-selected-id','select-system-id');">
					<br><br>
					<input type="button" class="egov-func-select" value="<<" 
					onclick="addChucVu.moveAllOptions('select-selected-id','select-system-id');">
				</td>
				<td width="40%">
				<aui:select name="vaitroids" id="select-selected-id" label="Vai trò được chọn <label class='egov-label-red'>(*)</label>" multiple="true" size="17" inputCssClass="egov-inputfield egov-multi-select">
					<%
					for(int i = 0; i< listChucVu2VaiTro.size();i++){
						VaiTro vaiTro = VaiTroLocalServiceUtil.fetchVaiTro(listChucVu2VaiTro.get(i).getVaiTroId());
					%>	
					<aui:option value="<%=vaiTro.getId() %>"><%= vaiTro.getTen()%></aui:option>					
					<%} %>
				</aui:select>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="3" style="text-align: left;">
					<aui:button-row>
						<aui:button type="submit" value="Ghi lại" onClick="addChucVu.selectAllSelected()" />
						<a href="<%=backToChucVuURL%>"><aui:button
								type="cancel" value="Quay lại danh sách" /></a>
					</aui:button-row>
				</td>
			</tr>
		</tfoot>
	</table><br/>
</aui:form>
</div>
</html>
<aui:script>

AUI().ready('aui-form-validator', 'aui-overlay-context-panel', function(A) {
    var validator = new A.FormValidator({
        boundingBox: document.<portlet:namespace/>frmCreateChucVu,
        rules: {
            <portlet:namespace/>chucvuid: {
                required: true
            },
            <portlet:namespace/>vaitroids: {
                required: true
            }
        },

        //custom message
        fieldStrings: {
            <portlet:namespace/>chucvuid: {
                required: 'Hãy chọn chức vụ'
            },
            <portlet:namespace/>vaitroids: {
                required: 'Hãy chọn ít nhất 1 vai trò'
            }
        },

        on: {
            submitError: function(event) {
                var formEvent = event.validator.formEvent;
                var errors = event.validator.errors;
            },

            submit: function(event) {
                var formEvent = event.validator.formEvent;
            }
        }
    });
});

</aui:script>
<script type="text/javascript">
var addChucVu = {
	selectAllSelected : function(){
		$('#<%=renderResponse.getNamespace()%>select-selected-id option').prop('selected', true);
	},
	moveOptions: function(fromId,toId){
		
		$("#<%=renderResponse.getNamespace()%>"+fromId+" option").each(function() {
			if(this.selected){			
				$('#<%=renderResponse.getNamespace()%>'+toId).append($('<option>', { 
			        value: this.value,
			        text : this.text 
			    }));
				
				$(this).remove();
			}
		    
		});
	},
	moveAllOptions: function(fromId,toId){
		$("#<%=renderResponse.getNamespace()%>"+fromId+" option").each(function() {
						
				$('#<%=renderResponse.getNamespace()%>'+toId).append($('<option>', { 
			        value: this.value,
			        text : this.text 
			    }));
				
				$(this).remove();
			
		    
		});
	},

	searchOptions: function(keyword,dataId,fromId,toId){
		addChucVu.removeAllOptions(fromId);
		$("#<%=renderResponse.getNamespace()%>"+dataId+" option").each(function() {
			if(addChucVu.existOptions(toId, this.value) == false){
				if(keyword==null || keyword =='' || this.text.toUpperCase().indexOf(keyword.toUpperCase()) !=-1){
					$('#<%=renderResponse.getNamespace()%>'+fromId).append($('<option>', { 
				        value: this.value,
				        text : this.text 
				    }));
				}
				
			}
		    
		});
	},
	existOptions: function(selectId,optionValue){
		var result = false;
		$("#<%=renderResponse.getNamespace()%>"+selectId+" option").each(function() {		
			if(this.value == optionValue){			
				result =true;
			}
		    
		});
		return result;
	},
	removeAllOptions: function(selectId){
		
		$("#<%=renderResponse.getNamespace()%>"+selectId+" option").each(function() {
			$(this).remove();
		    
		});
		
	}
};
    
</script>