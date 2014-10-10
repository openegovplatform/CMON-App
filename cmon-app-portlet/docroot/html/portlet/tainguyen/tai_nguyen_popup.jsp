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
<%@page import="org.oep.cmon.dao.cd.service.HeThongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.portlet.tainguyen.business.TaiNguyenBusiness"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiNguyenLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiNguyen"%>
<%@page import="org.oep.cmon.dao.cd.model.HeThong"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="/html/portlet/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	
	String keyWord =ParamUtil.getString(request, "searchKeyWord", "");
	Long vaiTroId =ParamUtil.getLong(request, "vaiTroId");	
	if(vaiTroId==0L) vaiTroId=null;
	
	String statusTN="";
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setWindowState(LiferayWindowState.EXCLUSIVE);
	iteratorUrl.setParameter(	"jspPage","/html/portlet/tainguyen/tai_nguyen_popup.jsp");
	if (renderRequest.getParameter("searchKeyWord") != null) {
		iteratorUrl.setParameter("searchKeyWord", renderRequest.getPortletSession().getAttribute("searchKeyWord").toString());
	}

	int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
	int delta = ParamUtil.getInteger(renderRequest, "delta", 10);
	
	List<TaiNguyen>  results = new ArrayList<TaiNguyen>(); 
	
	SearchContainer searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			cur, delta, iteratorUrl, null, null);
	
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	
	Long longTotal=0L;
	
	// Get ung dung
	List<DanhMucUngDung> ungDungList= null;
	// Get he thong
	List<HeThong> heThongList = null;

	try {
		longTotal = TaiNguyenLocalServiceUtil.countByVaiTroId(vaiTroId, Constants.ACTIVE);
				
		results = TaiNguyenLocalServiceUtil.searchByVaiTroId(vaiTroId, Constants.ACTIVE, start, end);
				
	// Get ung dung
	ungDungList = TaiNguyenBusiness.getUngDungList();

	// Get he thong
	heThongList = TaiNguyenBusiness.getHeThongList();

} catch (Exception e) {
	SessionErrors.add(renderRequest, "errorSearch");
}
	
	if ( results == null ) {	
		 results = new ArrayList<TaiNguyen>();
		
	}
	
	// Paging
	searchContainer.setTotal(longTotal.intValue());
	searchContainer.setResults(results);

%>

<div class="egov-container">
<div id="danhSachTaiNguyen">
<table cellpadding="0" cellspacing="0" class="egov-table" width="100%">
	<tbody>
			<tr>
			    <td colspan="5">
			    	<liferay-ui:error key="errorSearch" message = "vn.dtt.cmon.tainguyen.list.error.search"/>
			    </td>
			</tr>
			<tr>
			<th>TT</th>
			<th>Tên tài nguyên</th>
			<th>Ứng dụng</th>
			<th>Hệ thống</th>			
			<th>Loại</th>			
		</tr>
		<%
		List<TaiNguyen> items = results;
		if (items != null && items.size() > 0) {
			for (int i = 0; i < results.size(); i++) {
				TaiNguyen taiNguyen = (TaiNguyen) items.get(i);
		%>
		<tr>
			<td style="text-align:center"><%=(searchContainer.getStart() + i + 1)%></td>
			<td><label class ="egov-label-bold"><%=taiNguyen.getTen() %></label></td>
			<td style="text-align:left">
			<%
			String strTenUD="";
			Long ungDungID=taiNguyen.getUngDungId()==null?0L:taiNguyen.getUngDungId();
			if(ungDungID!=0L && ungDungID!=null)
			{
				strTenUD=DanhMucUngDungLocalServiceUtil.fetchDanhMucUngDung(taiNguyen.getUngDungId()).getTen();
			}	
			
			%>
			<%=strTenUD %>
			</td>
			<td style="text-align:center">
			<%
			String strTenHT="";
			Long heThongID=taiNguyen.getHeThongId()==null?0L:taiNguyen.getHeThongId();
			if(heThongID!=0L&& heThongID!=null)
			{
				strTenHT=HeThongLocalServiceUtil.fetchHeThong(taiNguyen.getHeThongId()).getTen();
			}
			
			%>
			<%=strTenHT %>
			</td>
			<%
			String strLoai = "";
			if(taiNguyen.getLoai()==1)
			{
				strLoai = LanguageUtil.get(pageContext,"vn.dtt.cmon.tainguyen.list.loai.page.liferay", "Trang của liferay");
			}
			else if(taiNguyen.getLoai()==2)
			{
				strLoai = LanguageUtil.get(pageContext,"vn.dtt.cmon.tainguyen.list.loai.portlet.liferay", "Porlet của liferay");
			}
			else
			{
				strLoai = LanguageUtil.get(pageContext,"vn.dtt.cmon.tainguyen.list.loai.function.liferay", "Chức năng của liferay");
			}
				%>
			<td style="text-align:center">
			<%=strLoai %>
		</tr>			
			<%
				}
					} else {
			%>
			<tr>
				<td colspan="5" align="center"><label class="egov-label">Không
						có bản ghi dữ liệu nào. </label></td>
			</tr>
			<%
				}
			%>
			</tbody>
		</table>
		<%
			if (searchContainer != null) {
		%>
		<div id = "pagination" style="font-size: 12px">
			<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
		</div>
		<%
			}
		%>
</div>
</div>
<script type="text/javascript">

function timTaiNguyen() {
	AUI().use('aui-io-plugin','aui-io-request', 'aui-io', 'node', 'event', 'event-custom','gallery-base64',
	function(A) {
		url = "<%= iteratorUrl.toString() %> ";
			//alert(url);
		var content = A.one('#danhSachTaiNguyen');
		content.plug(A.Plugin.IO,{autoLoad: false,failureMessage: '',});
		content.io.set('uri', url);
		//chay duong dan sang trang				
		content.io.start(); 
 	});
}

function resultPageSelect(node,url){
	AUI().use('aui-io-plugin','aui-io-request', 'aui-io', 'node',
	function(A) {
		var content = A.one('#danhSachTaiNguyen');
		content.plug(A.Plugin.IO,{autoLoad: false,failureMessage: '',});
		content.io.set('uri', url+$(node).val());
		content.io.start(); 
	});
}

$(".delta-selector").hide(0); // Will hide the div and free its space.
$(".delta-selector").css('visibility', 'hidden');

AUI().ready('aui-io-plugin','node', function(A) {
	paginatorSearchContainer(
		A.one('#danhSachTaiNguyen'), 
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
		}
	}
	
});
	
</script>

