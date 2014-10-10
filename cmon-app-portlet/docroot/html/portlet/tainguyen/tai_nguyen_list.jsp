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
<%@page import="org.oep.cmon.Constants.Paging"%>
<%@page import="org.oep.cmon.dao.cd.service.HeThongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="org.oep.cmon.portlet.tainguyen.util.FormatUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiNguyen"%>
<%@page import="org.oep.cmon.dao.cd.model.HeThong"%>
<%@page import="org.oep.cmon.dao.dvc.model.DanhMucUngDung"%>
<%@page import="org.oep.cmon.portlet.tainguyen.business.TaiNguyenBusiness"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="/html/portlet/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	
	int cur =  Integer.valueOf(prefs.getValue("curTN", "1"));
	int delta =  Integer.valueOf(prefs.getValue("deltaTN", String.valueOf(Paging.DELTA)));
	int curnext = ParamUtil.getInteger(renderRequest, "cur", 1);
	int deltanext = ParamUtil.getInteger(renderRequest, "delta", Paging.DELTA);
	if(curnext!=cur) {
		cur = curnext;
	}
	if(deltanext!=delta) {
		delta = deltanext;
	}

	PortletURL searchURL = renderResponse.createActionURL();
	searchURL.setParameter(ActionRequest.ACTION_NAME, "searchTaiNguyenRequest");	
	
	PortletURL addNewUrl = renderResponse.createActionURL();
	addNewUrl.setParameter(ActionRequest.ACTION_NAME, "addTaiNguyenRequest");
	addNewUrl.setParameter("jspPage", "/html/portlet/tainguyen/tai_nguyen_add.jsp");
	addNewUrl.setParameter("cur", String.valueOf(cur));
	addNewUrl.setParameter("delta", String.valueOf(delta));
	
	String keyWord =ParamUtil.getString(request, "searchKeyWord", "");
	String statusTN="";
	
	Long ungDungId=ParamUtil.getLong(request, "ungDungId");
	Long heThongId=ParamUtil.getLong(request, "heThongId");
	
	// Get default search value
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
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter(	"jspPage","/html/portlet/tainguyen/tai_nguyen_list.jsp");
	if (renderRequest.getParameter("searchKeyWord") != null) {
		iteratorUrl.setParameter("searchKeyWord", keyWord);
	}
	if (renderRequest.getParameter("ungDungId") != null) {
		iteratorUrl.setParameter("ungDungId", renderRequest.getPortletSession().getAttribute("ungDungId").toString());
	}
	if (renderRequest.getParameter("heThongId") != null) {
		iteratorUrl.setParameter("heThongId", renderRequest.getPortletSession().getAttribute("heThongId").toString());
	}
	
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
		longTotal = TaiNguyenBusiness.countByCongChung(keyWord, ungDungId, heThongId);
				
		results = TaiNguyenBusiness.findByTaiNguyen(keyWord, ungDungId, heThongId, start, end);
				
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
<form name = "<portlet:namespace/>searchThamSoForm" method = "post" action = "<%=searchURL%>" >
<br><br>
			<table   class="egov-table-form2" style="width: 100%">
			  <tr>
			    <td align = "left" width="35%"><label class ="egov-label-bold">Tên tài nguyên</label><br>	    
			     	<input name="searchKeyWord" id="searchKeyWord" type="text"  class="egov-inputfield-search" style="width: 94.2%;"
				     	      value = "<%=HtmlUtil.escape(keyWord)%>" placeholder="<%=LanguageUtil.get(pageContext, "vn.dtt.cmon.tainguyen.list.search.defaultValue")%>"/>
			    </td>
			    <td align = "left" width="20%" style="padding-left: 5px"><label class ="egov-label-bold">Ứng dụng</label> <br>
		      		<select id="ungDungId" name="ungDungId" class="egov-select">
		      		<option value="">--Theo ứng dụng--</option>	 
		      			<%
		      			if(ungDungList!=null)
		      			{
				      		for (DanhMucUngDung ungDung : ungDungList) {
				      			if(ungDung!=null)
				      			{
					      			%>
					      			<option value="<%=ungDung.getId() %>" <%=TaiNguyenBusiness.checkSelectedValue(ungDung.getId(), ungDungId)%>><%=ungDung.getTen() %></option>
					      			<%
				      			}
				      		}
		      			}
			      		%>
		      		</select>	
			    </td>
			    <td align = "left" width="20%" style="padding-left: 5px"><label class ="egov-label-bold">Hệ thống</label> <br>
			    <select id="heThongId" name="heThongId" class="egov-select">
			    	<option value="">--Chọn hệ thống--</option>
		      			<%
		      			if(heThongList!=null)
		      			{
				      		for (HeThong heThong : heThongList) {
				      			if(heThong!=null)
				      			{
					      			%>
					      			<option value="<%=heThong.getId() %>" <%=TaiNguyenBusiness.checkSelectedValue(heThong.getId(), heThongId)%>><%=heThong.getTen() %></option>
					      			<%
				      			}
				      		}
		      			}
			      		%>
		      		</select>	
			    </td>
			    <td  width="5%" valign="top" style="padding-left: 5px"><br>	
			 			<input type="submit" name="button" value=""  class="egov-button-search" />
			 	</td>		
			    <td align = "right" width="25%"><br>
			    	<input type="button" name="button" value="+ THÊM MỚI" 
			    	 class="egov-button-normal" onclick="javascript: window.location = '<%=addNewUrl.toString() %>'" style="float: right;"/>
			    </td>
			  </tr>
			  <tr>
			    <td colspan="5">
			    	<liferay-ui:error key="errorSearch" message = "vn.dtt.cmon.tainguyen.list.error.search"/>
			    	<liferay-ui:error key="errorDeleteTaiNguyen" message = "vn.dtt.cmon.tainguyen.list.error.delete"/>
			    	<%
				if (request.getAttribute("delete_success") != null && request.getAttribute("delete_success").toString().trim().length() > 0) {
					%>
					<liferay-ui:success key="successDeleteTaiNguyen" message="vn.dtt.cmon.tainguyen.list.completed.delete"/>
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
			<th style="text-align:center">TT</th>
			<th>Tên tài nguyên</th>
			<th style="text-align:center">Ứng dụng</th>
			<th style="text-align:center">Hệ thống</th>			
			<th style="text-align:center">Loại</th>			
			<th style="text-align:center">Trạng thái</th>
			<th style="text-align:center">Chức năng</th>
		</tr>
		<%
		List<TaiNguyen> items = results;
		if (items != null && items.size() > 0) {
			for (int i = 0; i < results.size(); i++) {
				TaiNguyen taiNguyen = (TaiNguyen) items.get(i);
										
			
			PortletURL viewRequestUrl = renderResponse.createRenderURL();
			viewRequestUrl.setParameter("ActionType", TaiNguyenBusiness.VIEW_TAINGUYEN);
			viewRequestUrl.setParameter("jspPage", "/html/portlet/tainguyen/tai_nguyen_add.jsp");
			viewRequestUrl.setParameter("taiNguyenId", String.valueOf(taiNguyen.getId()));
			if (renderRequest.getParameter("searchKeyWord") != null) {
				viewRequestUrl.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
			viewRequestUrl.setParameter("cur", String.valueOf(cur));
			viewRequestUrl.setParameter("delta", String.valueOf(delta));
			
			PortletURL editRequestUrl = renderResponse.createRenderURL();
			editRequestUrl.setParameter("ActionType", "editTaiNguyenRequest");		
			editRequestUrl.setParameter("jspPage", "/html/portlet/tainguyen/tai_nguyen_add.jsp");
			editRequestUrl.setParameter("taiNguyenId", String.valueOf(taiNguyen.getId()));
			if (renderRequest.getParameter("searchKeyWord") != null) {
				editRequestUrl.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
			editRequestUrl.setParameter("cur", String.valueOf(cur));
			editRequestUrl.setParameter("delta", String.valueOf(delta));
			
			PortletURL deleteUrl = renderResponse.createActionURL();
			deleteUrl.setParameter(ActionRequest.ACTION_NAME, "deleteTaiNguyenRequest");
			deleteUrl.setParameter("jspPage", "/html/portlet/tainguyen/tai_nguyen_list.jsp");
			deleteUrl.setParameter("taiNguyenId", String.valueOf(taiNguyen.getId()));
			if (renderRequest.getParameter("searchKeyWord") != null) {
				deleteUrl.setParameter("searchKeyWord", renderRequest.getParameter("searchKeyWord"));
			}
			deleteUrl.setParameter("cur", String.valueOf(cur));
			deleteUrl.setParameter("delta", String.valueOf(delta));
		%>
		<tr>
			<td style="text-align:center"><%=(searchContainer.getStart() + i + 1)%></td>
			<td><a href="<%=viewRequestUrl.toString()%>" class="bold" title="<%=taiNguyen.getMoTa()%>"><%=taiNguyen.getTen() %></a></td>
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
				strLoai = LanguageUtil.get(pageContext,"vn.dtt.cmon.tainguyen.list.loai.page.liferay");
			}
			else if(taiNguyen.getLoai()==2)
			{
				strLoai = LanguageUtil.get(pageContext,"vn.dtt.cmon.tainguyen.list.loai.portlet.liferay");
			}
			else
			{
				strLoai = LanguageUtil.get(pageContext,"vn.dtt.cmon.tainguyen.list.loai.function.liferay");
			}
				%>
			<td style="text-align:center">
			<%=strLoai %>
			<%if(taiNguyen.getTrangThai()==0)
			{
				statusTN=LanguageUtil.get(pageContext,"vn.dtt.cmon.tainguyen.list.inactive.status");
			}
			else
			{
				statusTN=LanguageUtil.get(pageContext,"vn.dtt.cmon.tainguyen.list.active.status");
			}
				%>
			<td style="text-align:center">
			<%=statusTN %>
			</td>
			<td width="10%">
				<table class="egov-table-function"
						style="text-align: center; width: 90px">
						<tbody>
							<tr>
							<td><a href="<%=editRequestUrl.toString()%>">
							<button	class="egov-func-edit" title="Chỉnh sửa"></button></a></td>
							<td><button class="egov-func-delete" title="Xóa" onclick="javascript:<portlet:namespace/>deleteRow('<%=deleteUrl.toString()%>')"></button></td>
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
				<td colspan="7" align="center"><label class="egov-label">Không
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
	var answer = confirm('<%=LanguageUtil.get(pageContext, "vn.dtt.cmon.tainguyen.list.confirm.delete") %>');
	if (answer){
		window.location = url;
	}
}
	
</script>