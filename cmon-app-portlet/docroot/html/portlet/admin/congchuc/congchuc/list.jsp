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
<%@page import="java.net.URLEncoder"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page import="org.oep.cmon.dao.cc.model.ChucVu"%>
<%@page import="org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.UserIdMapperLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.persistence.UserFinderUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.cmon.util.Helpers"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
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
long coQuanQuanLyId = 0l;
String maOrTenOrEmail = "";
List<CongChuc> listCongChuc = new ArrayList<CongChuc>();
int total = 0;
//get request atts
if(Validator.isNotNull(request.getAttribute("coQuanQuanLyId"))){
	coQuanQuanLyId = Long.valueOf(request.getAttribute("coQuanQuanLyId").toString());
}
if(Validator.isNotNull(request.getAttribute("maOrTenOrEmail"))){
	maOrTenOrEmail = request.getAttribute("maOrTenOrEmail").toString();
}
//get render params
if ( Validator.isNotNull(renderRequest.getParameter("coQuanQuanLyId")) ) {
	coQuanQuanLyId = Long.valueOf(renderRequest.getParameter("coQuanQuanLyId"));
}
if ( Validator.isNotNull(renderRequest.getParameter("maOrTenOrEmail")) ) {
	maOrTenOrEmail = URLDecoder.decode(renderRequest.getParameter("maOrTenOrEmail"),StringPool.UTF8);
}
//end get param values
PortletURL pagingUrl = renderResponse.createRenderURL();
pagingUrl.setParameter("tab", "CC");
pagingUrl.setParameter("maOrTenOrEmail",URLEncoder.encode(maOrTenOrEmail,StringPool.UTF8));
pagingUrl.setParameter("coQuanQuanLyId",String.valueOf(coQuanQuanLyId));

PortletURL addUrl = renderResponse.createActionURL();
addUrl.setParameter(ActionRequest.ACTION_NAME, "createCongChuc");
addUrl.setParameter("tab", "CC");
addUrl.setParameter("maOrTenOrEmail",URLEncoder.encode(maOrTenOrEmail,StringPool.UTF8));
addUrl.setParameter("coQuanQuanLyId",String.valueOf(coQuanQuanLyId));


PortletURL searchUrl = renderResponse.createActionURL();
searchUrl.setParameter(ActionRequest.ACTION_NAME, "searchListCongChuc");
searchUrl.setParameter("coQuanQuanLyId",String.valueOf(coQuanQuanLyId));

SearchContainer searchContainer = null;
int currentTransPage = ParamUtil.getInteger(request,"currentTransPage");
if (currentTransPage > 0) {
	searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			currentTransPage, 10, pagingUrl, null, null);
} else {
	searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM, 10,
			pagingUrl, null, null);
}

int start = searchContainer.getStart();
int end = searchContainer.getEnd();

if(Validator.isNotNull(request.getAttribute("listCongChuc"))){
	listCongChuc = (List<CongChuc>)request.getAttribute("listCongChuc");
}else{
	listCongChuc = CongChucLocalServiceUtil.listCongChuc(coQuanQuanLyId, maOrTenOrEmail, start, end);
}
if(Validator.isNotNull(request.getAttribute("total"))){
	total = Integer.valueOf(request.getAttribute("total").toString());
}else{
	total = CongChucLocalServiceUtil.countListCongChuc(coQuanQuanLyId, maOrTenOrEmail);
}

searchContainer.setTotal(total);
searchContainer.setResults(listCongChuc);

%>
<div>
	<liferay-ui:success  key="insert.success" message="org.oep.cmon.admin.portlet.congchuc.success.insert" />
	<liferay-ui:success  key="update.success" message="org.oep.cmon.admin.portlet.congchuc.success.update" />
	<liferay-ui:error key="delete.error" message = "org.oep.cmon.admin.portlet.congchuc.err.delete"/>
	<liferay-ui:success  key="delete.success" message="org.oep.cmon.admin.portlet.congchuc.success.delete" />
</div>
<form method="post" action="<%= searchUrl %>" name="frmSearchCongChuc" id="frmSearchCongChuc">
<table cellspacing="5" cellpadding="5" width="100%" border="0" class="egov-table-form">
	<%
	if(coQuanQuanLyId!=0l){
		CoQuanQuanLy coQuan = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(coQuanQuanLyId);
	%>
	<tr>
		<td colspan="2">
			<h3><b>Công chức tại cơ quan: <%=coQuan.getTen() %></b></h3>
		</td>
	</tr>
	<%} %>
	<tr>
		<td>
			<input type="text" value="<%= maOrTenOrEmail %>" name="maOrTenOrEmail" style="width:70%;" class='egov-inputfield' placeholder="Tên, mã, email công chức" />
			<input type="submit" value="Tìm kiếm" class="egov-button-search"/>
		</td>
		<td align="right" style="text-align: right;">
			<a href = "<%=addUrl%>"><input type="button" value="+ THÊM MỚI"  class="egov-button-normal" /></a>
		</td>
	</tr>
</table>
</form>
<div style="width:100%;padding-top: 10px"></div>
<table class="egov-table">
		<thead>
			<tr>
				<th style="width: 15px;text-align: center;">STT</th>
				<th style="text-align: center;">Mã công chức</th>
				<th style="text-align: center;">Tên công chức</th>
				<th style="text-align: center;">Email</th>
				<th style="text-align: center;">Cơ quan quản lý</th>
				<th style="text-align: center;">Chức vụ</th>
				<th style="text-align: center;">Hành động</th>
			</tr>
		</thead>
		<tbody>			
			<%
			int rowStyle = 1;
			int i = searchContainer.getStart();
			for(CongChuc row: listCongChuc){
				i++;
				TaiKhoanNguoiDung taikhoan = TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(row.getTaiKhoanNguoiDungId());
				CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(row.getCoQuanQuanLyId());
				ChucVu chucVu = ChucVuLocalServiceUtil.fetchChucVu(row.getChucVuId());
				
				PortletURL detailUrl = renderResponse.createActionURL();
				detailUrl.setParameter("congChucId",String.valueOf(row.getId()));
				detailUrl.setParameter(ActionRequest.ACTION_NAME, "detailCongChuc");
				detailUrl.setParameter("maOrTenOrEmail", URLEncoder.encode(maOrTenOrEmail,StringPool.UTF8) );
				detailUrl.setParameter("coQuanQuanLyId",String.valueOf(coQuanQuanLyId));
				
				PortletURL editUrl = renderResponse.createActionURL();
				editUrl.setParameter("congChucId",String.valueOf(row.getId()));
				editUrl.setParameter(ActionRequest.ACTION_NAME, "editCongChuc");
				editUrl.setParameter("maOrTenOrEmail",URLEncoder.encode(maOrTenOrEmail,StringPool.UTF8));
				editUrl.setParameter("coQuanQuanLyId",String.valueOf(coQuanQuanLyId));
				
				PortletURL deleteUrl = renderResponse.createActionURL();
				deleteUrl.setParameter("congChucId",String.valueOf(row.getId()));
				deleteUrl.setParameter(ActionRequest.ACTION_NAME, "deleteCongChuc");
				deleteUrl.setParameter("maOrTenOrEmail",URLEncoder.encode(maOrTenOrEmail,StringPool.UTF8));
				deleteUrl.setParameter("coQuanQuanLyId",String.valueOf(coQuanQuanLyId));
				deleteUrl.setParameter("tab","CC");
				
				PortletURL resetPasswordUrl = renderResponse.createActionURL();
				resetPasswordUrl.setParameter(ActionRequest.ACTION_NAME, "resetPassword");
				resetPasswordUrl.setWindowState(LiferayWindowState.POP_UP);
				resetPasswordUrl.setParameter("congChucId",String.valueOf(row.getId()));
				
				PortletURL ganQuyenUrl = renderResponse.createActionURL();
				ganQuyenUrl.setParameter(ActionRequest.ACTION_NAME, "quyenCongChuc");
				ganQuyenUrl.setParameter("congChucId",String.valueOf(row.getId()));
				ganQuyenUrl.setParameter("maOrTenOrEmail",URLEncoder.encode(maOrTenOrEmail,StringPool.UTF8));
				ganQuyenUrl.setParameter("coQuanQuanLyId",String.valueOf(coQuanQuanLyId));

				%>
				<tr class="bgcolor-<%=rowStyle%>">
					<td style="text-align: center;"><%= i %></td>
					<td style="text-align: center;"><%= row.getMa()%></td>
					<td><%= row.getHoVaTen()%></td>
					<td><%= ((taikhoan != null)?taikhoan.getTenDangNhap():"") %></td>
					<td><%= ((coQuanQuanLy != null)?coQuanQuanLy.getTen():"") %></td>
					<td><%= ((chucVu != null)?chucVu.getTen():"") %></td>
					<td style="text-align: center;" nowrap="nowrap">
						<a href="<%=detailUrl%>"><button class="egov-func-detail" title="Chi tiết" ></button></a>
						<a href="<%=editUrl%>"><button class="egov-func-edit" title="Chỉnh sửa" ></button></a>
						<a href="<%=deleteUrl %>" onclick = "return app.congchuc.confirmDelete()"><button class="egov-func-delete" title="Xóa" ></button></a>
						<a href="#" onclick="app.congchuc.popupResetPassword('<%= resetPasswordUrl %>'); return false;"><button class="egov-func-history" title="Đổi mật khẩu" ></button></a>
						<a href="<%= ganQuyenUrl %>"><button class="egov-func-config" title="Quyền hạn" ></button></a>
					</td>
				</tr>
			<%
				rowStyle = rowStyle==1?2:1;
			}
			%>			
		
		</tbody>
	</table>
	<div style="width: 100%;padding: 10px 10px;">
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
	</div>
<script type="text/javascript">
var app = app || {};
//var app = {};
app.congchuc = {
		config:null,
		portletNamespace:null,
		newWindow:null,
		init:function(portletNamespace,config){
			this.config = config;
			this.portletNamespace = portletNamespace;
			//console.log(this.portletNamespace);
			return this;
		},
		test:function(){
			console.log(this.portletNamespace,app.congchuc.portletNamespace);
		},
		popupResetPassword:function(url){
			//jQuery("#dialogDiv").dialog({modal: true, title: 'Confirmation',show: 'slide', hide: 'slide', width : '370px', height : 'auto', resizable: true, closeOnEscape:true, focus:true});
			
			this.newWindow = window.open(url,'Đổi mật khẩu','height=350,width=550,left=90,top=100,resizable=no,location=no,status=no,menubar=no');

			if (window.focus) {
				this.newWindow.focus();
			}			
			return this;
		},
		popupGanQuyen:function(url){
			this.newWindow = window.open(url,'Gán quyền','height=550,width=850,left=90,top=100,resizable=no,location=no,status=no,menubar=no');

			if (window.focus) {
				this.newWindow.focus();
			}			
			return this;
		},
		create:function(url){
			$.get(url,function(respons){
				console.log(respons);
			});
			return this;
		},
		confirmDelete:function(){
			return confirm("Bạn thực sự muốn xóa cán bộ này?");
		}
};
//jQuery(document).ready(function($){
	app.congchuc.init('<portlet:namespace/>',null).test();
//});
</script>
