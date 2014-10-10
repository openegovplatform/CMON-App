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
<%@page import="org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.document.util.FormatUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.HeThong"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="org.oep.cmon.portlet.thamso.util.ThamSoConstants"%>
<%@page import="org.oep.cmon.dao.cd.service.HeThongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.thamso.business.ThamSoBusiness"%>
<%@page import="org.oep.cmon.dao.thamso.model.ThamSo"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="/html/portlet/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	PortletURL searchURL = renderResponse.createActionURL();
	searchURL.setParameter(ActionRequest.ACTION_NAME, "searchThamSoRequest");	
	
	PortletURL addNewUrl = renderResponse.createRenderURL();
	addNewUrl.setParameter("ActionType", "editOrAddThamSoRequest");
	addNewUrl.setParameter("jspPage", "/html/portlet/thamso/tham_so_add.jsp");
	
	String keyWord =ParamUtil.getString(request, "searchKeyWord", "");
	String statusUD="";
	
	Long ungDungId=ParamUtil.getLong(request, "ungDungId");
	Long heThongId=ParamUtil.getLong(request, "heThongId");
	
	if (Validator.isNull(keyWord) && renderRequest.getPortletSession().getAttribute("searchKeyWord") != null) {
		keyWord = renderRequest.getPortletSession().getAttribute("searchKeyWord").toString();
	}
	if (Validator.isNull(ungDungId)	&& renderRequest.getPortletSession().getAttribute("ungDungId") != null)
	{
		ungDungId = FormatUtil.convertToLong((renderRequest.getPortletSession().getAttribute("ungDungId").toString()));
	}
	if (Validator.isNull(heThongId)	&& renderRequest.getPortletSession().getAttribute("heThongId") != null)
	{
		heThongId = FormatUtil.convertToLong((renderRequest.getPortletSession().getAttribute("heThongId").toString()));
	}
	
	if(ungDungId==0L) ungDungId=null;
	if(heThongId==0L) heThongId=null;
	// Get default search value
	String defaultSearch = LanguageUtil.get(pageContext, "vn.dtt.cmon.thamso.list.search.defaultValue");
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter(	"jspPage","/html/portlet/thamso/tham_so_view.jsp");
	if (renderRequest.getParameter("searchKeyWord") != null) {
		iteratorUrl.setParameter("searchKeyWord", keyWord);
	}
	if (renderRequest.getParameter("ungDungId") != null) {
		iteratorUrl.setParameter("ungDungId", renderRequest.getPortletSession().getAttribute("ungDungId").toString());
	}
	if (renderRequest.getParameter("heThongId") != null) {
		iteratorUrl.setParameter("heThongId", renderRequest.getPortletSession().getAttribute("heThongId").toString());
	}
	
	int cur =  Integer.valueOf(prefs.getValue("curTS", "1"));
	int delta =  Integer.valueOf(prefs.getValue("deltaTS", "10"));
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
	List<ThamSo>  result = new ArrayList<ThamSo>(); 
	
	SearchContainer searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			cur, delta, iteratorUrl, null, null);
	
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	
	Long longTotal=0L;

	longTotal=ThamSoLocalServiceUtil.countByTenUDHT(keyWord, ungDungId, heThongId);
	result = ThamSoLocalServiceUtil.searchByTenUDHT(keyWord, ungDungId, heThongId, start, end);
	
	if ( result == null ) {	
		 result = new ArrayList<ThamSo>();
	}
	
	// Paging
	searchContainer.setTotal(longTotal.intValue());
	searchContainer.setResults(result);

%>

<div class="egov-container">
<form name = "<portlet:namespace/>searchThamSoForm" method = "post" action = "<%=searchURL%>" >
<br><br>
			<table   class="egov-table-form2" style="width: 100%">
			  <tr>
			    <td align = "left" width="35%">		    
			     	<input name="searchKeyWord" type="text"  class="egov-inputfield-search" style="width: 96%;"
			     	      value = "<%=HtmlUtil.escape(keyWord)%>" placeholder="<%=defaultSearch%>"/>
			    </td>
			    <td align = "left" width="20%" style="padding-left: 5px">
		      		<select id="ungDungId" name="ungDungId" class="egov-select" >
			      		<option value="">--Theo ứng dụng--</option>	 
			      		<%
			      		List<DanhMucUngDung> ungDungList = ThamSoBusiness.getUngDungList();
			      		
			      		for (DanhMucUngDung ungDung : ungDungList) {
				      			%>
				      			<option value="<%=ungDung.getId() %>" <%=ThamSoBusiness.checkSelectedValue(ungDung.getId(), ungDungId)%>><%=ungDung.getTen() %></option>
				      			<%
			      		}
			      		%>
		      		</select>	
			    </td>
			    <td align = "left" width="20%" style="padding-left: 5px">
			    <select id="heThongId" name="heThongId" class="egov-select">
		      			<option value="">--Theo hệ thống-</option>	 
			      		<%
			      		List<HeThong> heThongList = ThamSoBusiness.getHeThongList();
			      		
			      		for (HeThong heThong : heThongList) {
				      			%>
				      			<option value="<%=heThong.getId() %>" <%=ThamSoBusiness.checkSelectedValue(heThong.getId(), heThongId)%>><%=heThong.getTen() %></option>
				      			<%
			      		}
			      		%>
		      		</select>	
			    </td>
			    <td  width="5%" valign="top" style="padding-left: 5px"> 		
			 			<input type="submit" name="button" value=""  class="egov-button-search" />
			 	</td>		
			    <td align = "right" width="25%">
			    	<input type="button" name="button" value="+ THÊM MỚI" 
			    	 class="egov-button-normal" onclick="javascript: window.location = '<%=addNewUrl.toString() %>'" style="float: right;"/>
			    </td>
			  </tr>
			  <tr>
			    <td>
			    	<liferay-ui:error key="errorDeleteThamSo" message = "vn.dtt.cmon.thamso.list.error.delete"/>
			    	<%
				if (request.getAttribute("delete_success") != null && request.getAttribute("delete_success").toString().trim().length() > 0) {
					%>
					<liferay-ui:success key="successDeleteThamSo" message="vn.dtt.cmon.thamso.list.completed.delete"/>
					<%
				}
				%>
			    </td>
			 </tr>
			</table>
		</form>
<table cellpadding="0" cellspacing="0" class="egov-table" width="100%">
	<tbody>
		<tr>
			<th>TT</th>
			<th>Tên tham số</th>
			<th>Kiểu dữ liệu</th>
			<th>Giá trị</th>			
			<th>Mã ứng dụng</th>
			<th>Tên hệ thống</th>
			<th>Trạng thái</th>
			<th>Chức năng</th>
		</tr>
		<%
		if(result!=null)
		{
		int index=1;
		for(ThamSo thamSo : result) {											
			
			PortletURL viewRequestUrl = renderResponse.createRenderURL();
			viewRequestUrl.setParameter("ActionType", ThamSoBusiness.VIEW_THAM_SO);
			viewRequestUrl.setParameter("jspPage", "/html/portlet/thamso/tham_so_add.jsp");
			viewRequestUrl.setParameter("thamSoId", String.valueOf(thamSo.getId()));
			if (renderRequest.getParameter("searchKeyWord") != null) {
				viewRequestUrl.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
			
			PortletURL editRequestUrl = renderResponse.createRenderURL();
			editRequestUrl.setParameter("ActionType", "editThamSoRequest");		
			editRequestUrl.setParameter("jspPage", "/html/portlet/thamso/tham_so_add.jsp");
			editRequestUrl.setParameter("thamSoId", String.valueOf(thamSo.getId()));
			if (renderRequest.getParameter("searchKeyWord") != null) {
				editRequestUrl.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
			
			PortletURL deleteUrl = renderResponse.createActionURL();
			deleteUrl.setParameter(ActionRequest.ACTION_NAME, "deleteThamSoRequest");
			deleteUrl.setParameter("jspPage", "/html/portlet/thamso/tham_so_view.jsp");
			deleteUrl.setParameter("thamSoId", String.valueOf(thamSo.getId()));
			if (renderRequest.getParameter("searchKeyWord") != null) {
				deleteUrl.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
			
			
	%>
		<tr>
			<td style="text-align:center"><%=(searchContainer.getStart() +  (index++))%></td>
			<td><a href="<%=viewRequestUrl.toString()%>" class="bold"><%=thamSo.getTen() %></a></td>
			<td style="text-align:center">
			<%
			 int iKieu=thamSo.getKieuDuLieu();
			String strKieu="";
			
			if(thamSo.getKieuDuLieu()==ThamSoConstants.KIEUDULIEU.KIEU_STRING)
			{
				strKieu="Kiểu String";
			}
			else if(thamSo.getKieuDuLieu()==ThamSoConstants.KIEUDULIEU.KIEU_INTEGER)
			{
				strKieu="Kiểu Integer";
			}
			else
			{
				strKieu="Kiểu Double";
			}
				
			%>
			<%=strKieu %>
			</td>
			<td style="text-align:center">
			<%
			String strGiaTri=thamSo.getGiaTri();
	
			if(strGiaTri==null)
			{
				strGiaTri="";
			}
			%>
			<%=strGiaTri %>
	
			</td>
			<td style="text-align:center">
			<%
			String strTenUD="";
			Long ungDungID=thamSo.getUngDungId()==null?0L:thamSo.getUngDungId();
			if(ungDungID!=0L && ungDungID!=null)
			{
				strTenUD=DanhMucUngDungLocalServiceUtil.fetchDanhMucUngDung(thamSo.getUngDungId()).getTen();
			}	
			
			%>
			<%=strTenUD %>
			</td>
			<td style="text-align:center">
			<%
			String strTenHT="";
			Long heThongID=thamSo.getHeThongId()==null?0L:thamSo.getHeThongId();
			if(heThongID!=0L&& heThongID!=null)
			{
				strTenHT=HeThongLocalServiceUtil.fetchHeThong(thamSo.getHeThongId()).getTen();
			}
			
			%>
			<%=strTenHT %>
			</td>
			<%if(thamSo.getDaXoa()==1)
			{
				statusUD=LanguageUtil.get(pageContext,"vn.dtt.cmon.thamso.list.inactive.status");
			}
			else
			{
				statusUD=LanguageUtil.get(pageContext,"vn.dtt.cmon.thamso.list.active.status");
			}
				%>
			<td style="text-align:center">
			<%=statusUD %>
			</td>
			<td width="10%">
				<table class="egov-table-function"
						style="text-align: center; width: 90px">
						<tbody>
							<tr>
							<td><a href="<%=editRequestUrl.toString()%>"><button
										class="egov-func-edit" title="Chỉnh sửa"></button></a></td>
							<td><button class="egov-func-delete" title="Xóa"
									onclick="javascript:<portlet:namespace/>deleteRow('<%=deleteUrl.toString()%>')"></button></td>
							</tr>
						</tbody>
					</table>
				</td>
		</tr>			
			<%
				}
					} else {
			%>
			<tr>
				<td colspan="5" align="center"><label class="egov-label">Không
						có bản ghi dữ liệu nào. Sử dụng chức năng tìm kiếm để có dữ liệu.</label></td>
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
	var answer = confirm('<%=LanguageUtil.get(pageContext, "vn.dtt.cmon.thamso.list.confirm.delete") %>');
	if (answer){
		window.location = url;
	}
}
	
</script>