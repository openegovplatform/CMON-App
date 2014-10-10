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
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.report.service.CoQuanQuanLy2LinhVucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc"%>
<%@page import="org.oep.cmon.dao.report.model.Role2DonViBaoCao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.report.portlet.util.ActionAdminUtil"%>
<%@page import="org.oep.cmon.dao.report.model.DanhMucBaoCao"%>
<%@page import="org.oep.cmon.dao.report.service.DanhMucRoleLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.report.model.DanhMucRole"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/init.jsp"%>
<portlet:defineObjects />
<%
PortletURL actionUrl = renderResponse.createActionURL();
actionUrl.setParameter(ActionRequest.ACTION_NAME, "saveRole");

PortletURL linhvucurl = renderResponse.createActionURL();
linhvucurl.setParameter(ActionRequest.ACTION_NAME, "getLinhvuc");

PortletURL backUrl = renderResponse.createRenderURL();
backUrl.setParameter("tab","vaitro");

String name ="";
String id = request.getParameter("id")!=null?request.getParameter("id"):"" ;
DanhMucRole dmRole = null;
if(id.trim().length()>0){
	dmRole = DanhMucRoleLocalServiceUtil.getDanhMucRole(Long.valueOf(id));
	name = dmRole.getNAME();
	id = String.valueOf(dmRole.getID());
}

List<DanhMucBaoCao> dmBaocao = ActionAdminUtil.getAllDMBaocao(1);
List<CapCoQuanQuanLy> ccqQuanly = ActionAdminUtil.getAllCapcoquanquanly(0);
List<CoQuanQuanLy> cqQuanly = new ArrayList<CoQuanQuanLy>() ;
List<Long> donvibaocao = new ArrayList<Long>();
List<Long> linhvuc = new ArrayList<Long>();
List<Long> loaihoso = new ArrayList<Long>();
List<Long> baocao = new ArrayList<Long>();
List<CoQuanQuanLy2LinhVuc> listcqql = new ArrayList<CoQuanQuanLy2LinhVuc>();
List<ThuTucHanhChinh> listtthc = new ArrayList<ThuTucHanhChinh>();
List<NhomThuTucHanhChinh> listNhomTTHC = new ArrayList<NhomThuTucHanhChinh>();
%>
<style>
.ui-multiselect {
	width: 230px !important;
}
</style>
<div>
<form action="<%=actionUrl%>" method="post">
<center><%=name%></center>
<fieldset>
	<legend><strong>Phân quyền báo cáo, đơn vị, lĩnh vực</strong></legend>
	<table class="egov-table">
		<tr>
			<th width="10px">TT</th>
			<th width="10px">#</th>
			<th width="15%">Tên báo cáo</th>
			<th width="20%">Đơn vị</th>
			<th width="30%">Lĩnh vực</th>		
			<th width="30%">Loại hồ sơ</th>	
		</tr>
		<%
		for(int i=0;i<dmBaocao.size();i++){
			String chk_dmbaocao = "";
			String str_iddonvi = "";
			donvibaocao = ActionAdminUtil.getDovibaocaoByRoleId(Long.valueOf(id),dmBaocao.get(i).getID());
			baocao = ActionAdminUtil.getBaocaoByRoleId(Long.valueOf(id));
			if(donvibaocao.size()>0){
				chk_dmbaocao = "checked";
				for (int k = 0; k < donvibaocao.size(); k++) {
					str_iddonvi += donvibaocao.get(k);
					if(k<(donvibaocao.size()-1)){
						str_iddonvi += ",";
					}
				}
				listcqql = CoQuanQuanLy2LinhVucLocalServiceUtil.getLinhvucByIdDonvi(str_iddonvi);
				linhvuc = ActionAdminUtil.getLinhvucByRoleId(Long.valueOf(id),dmBaocao.get(i).getID());
			}
			if(baocao.size()>0){
				chk_dmbaocao = baocao.contains(dmBaocao.get(i).getID())?"checked":"";
			}
		%>
		<tr>
			<td style="text-align: center"><%=(i+1)%></td>
			<td style="text-align: center"><input type="checkbox" class="egov-checkbox" <%=chk_dmbaocao%> name="id_dmbaocao" value="<%=dmBaocao.get(i).getID()%>"></td>
			<td><%=dmBaocao.get(i).getTENBAOCAO()%></td>
			<td>
				<select multiple="multiple" name="id_donvibaocao_<%=dmBaocao.get(i).getID()%>" class="sel-donvi">
				<%
					for(int j=0;j<ccqQuanly.size();j++){
						cqQuanly = CoQuanQuanLyLocalServiceUtil.findByCapCoQuanQuanLyId(ccqQuanly.get(j).getId(),0);
						if(cqQuanly.size()>0){
				%>
					<optgroup label="<%=ccqQuanly.get(j).getTen()%>">
						<%
						  for(CoQuanQuanLy cq : cqQuanly){
							  String sel_donvibaocao = "";
							  if(donvibaocao.size()>0){
							 	 sel_donvibaocao = donvibaocao.contains(cq.getId())?"selected":"";
							  }
						%>	
							<option value="<%=cq.getId()%>" <%=sel_donvibaocao%>><%=cq.getTen()%></option>
						<%}%>
					</optgroup>
				<%}}%>
				</select>
			</td>
			<td>
				<%
				 if(donvibaocao.size()>0){
					if(listcqql.size()>0){%>
				<select name="id_linhvuc_<%=dmBaocao.get(i).getID()%>" class="sel-linhvuc" multiple="multiple" style="width:200px">
				<%
					for(CoQuanQuanLy2LinhVuc cqql : listcqql){
						String sel_linhvuc = "";
					    if(linhvuc.size()>0){
					    	sel_linhvuc = linhvuc.contains(cqql.getNHOMTHUTUCHANHCHINHID())?"selected":"";
					    }
				%>	
					<option value="<%=cqql.getNHOMTHUTUCHANHCHINHID()%>" <%=sel_linhvuc%>><%=cqql.getTENNHOMTTHC()%></option>
				<%}%>
				</select>
				<%}}%>
			</td>
			<td>
				<%
				if(donvibaocao.size()>0){
					if(linhvuc.size()>0){
						loaihoso = ActionAdminUtil.getLoaihosoByRoleId(Long.valueOf(id),dmBaocao.get(i).getID());
				%>
				<select name="id_loaihoso_<%=dmBaocao.get(i).getID()%>" class="sel-loaihoso" multiple="multiple" style="width:200px">
				<%
					listNhomTTHC = ActionAdminUtil.getNhomTTHCByIdNhomTTHC(linhvuc);
					listtthc = ActionAdminUtil.getTTHCByIdNhomTTHC(linhvuc,str_iddonvi);
					for(int k=0;k<listNhomTTHC.size();k++){
				%>
					<optgroup label="<%=listNhomTTHC.get(k).getTen()%>">
						<%
							for(int t=0;t<listtthc.size();t++){
								if(listNhomTTHC.get(k).getId()==listtthc.get(t).getNhomThuTucHanhChinhId()){
									String sel_loaihoso ="";
									if(loaihoso.size()>0){
										sel_loaihoso = loaihoso.contains(listtthc.get(t).getId())?"selected":"";
									}
						%>
							<option value="<%=listtthc.get(t).getId()%>" <%=sel_loaihoso%>><%=listtthc.get(t).getTen()%></option>
						<%		}
							}	%>
					</optgroup>
				<%	}	%>
				</select>
				<%}}%>
			</td>
		</tr>
		<%} %>
		<tr>
			<td colspan="6" style="text-align: center">
				<input type="submit" value="Cập nhật quyền hạn" class="egov-button">
				<input type="button" value="Quay lại" class="egov-button" onclick="javascript: window.location='<%=backUrl.toString()%>'"/>
				<input type="hidden" name="role_id" value="<%=id%>">
			</td>
		</tr>
	</table>
</fieldset>
</form>
</div>
<script>
$(function(){
	$(".sel-donvi").multiselect({ selectedText: "đã chọn # đơn vị"});
	$(".sel-linhvuc").multiselect({ selectedText: "đã chọn # lĩnh vực"});
	$(".sel-loaihoso").multiselect({ selectedText: "đã chọn # loại hồ sơ"});
});
</script>
