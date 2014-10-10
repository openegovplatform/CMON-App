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
	//iteratorUrl.setWindowState(LiferayWindowState.NORMAL);	
	iteratorUrl.setParameter("jspPage", "/html/portlet/document/setting/popup_giay_to_result.jsp");
	iteratorUrl.setParameter("searchKeyWord", keyWord);
	iteratorUrl.setParameter("doituongSuDung", doituongGroup);
	iteratorUrl.setParameter("tthcId", String.valueOf(tthcId));
	iteratorUrl.setParameter("giaiDoanId", String.valueOf(giaiDoanId));
		
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

	List<DanhMucGiayTo> result = new ArrayList<DanhMucGiayTo>();
	
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();	
		
	Long longTotal=DanhMucGiayToLocalServiceUtil.countByTTHCIdOrGDId(keyWord, doituongGroup, tthcId, giaiDoanId,
	DocumentConstants.TTHC2DT.DaXoa);
	
	result = DanhMucGiayToLocalServiceUtil.searchByTTHCIdOrGDId(keyWord, doituongGroup, tthcId, giaiDoanId,
					DocumentConstants.TTHC2DT.DaXoa, start, end);
	
	if (result == null) {
		result = new ArrayList<DanhMucGiayTo>();
	}

	List<DoiTuongSuDung> lstDoiTuong = new ArrayList<DoiTuongSuDung>();
	lstDoiTuong = DoiTuongSuDungLocalServiceUtil
			.getDSDoiTuongSuDung(Constants.ACTIVATED);

	searchContainer.setTotal(longTotal.intValue());
	searchContainer.setResults(result);
%>
	<input type="hidden" name="tthcId" id="tthcId" value="<%=tthcId%>">	
	<input type="hidden" name="giaiDoanId" id="giaiDoanId" value="<%=giaiDoanId%>">
	<input type="hidden" name="action" id="action" value="">
		<table cellpadding="0" cellspacing="0" class="egov-table" width="100%">
			<tbody>
				<tr>
					<th  width="5%">STT</th>
					<th  width="10%">Mã</th>
					<th  width="75%">Tên tài liệu</th>					
					<th	 width="10%">Chọn</th>					
				</tr>
					<%
					int index=1;
					for(DanhMucGiayTo danhMucGiayTo:result){	
								%>
								<tr>
								<td style="text-align:center"><%=(searchContainer.getStart()+(index++))%></td>
									<td style="text-align:center"><%=danhMucGiayTo.getMa()%></td>
								<td align="left">
									<input type="hidden" name="gtID" id="gtID" value="<%=danhMucGiayTo.getId()%>">
									<%=danhMucGiayTo.getTen()%>									
									</td>	
									<td style="text-align:center"><input type="checkbox" name="selectedGT" value="<%=danhMucGiayTo.getId()%>" id="selectedGT" >
									</td>					
								</tr>
								<%
					}
					%>
			</tbody>
		</table>
		<div id="pagination">
			<liferay-ui:search-paginator searchContainer="<%=searchContainer%>" />
		</div>
<script type="text/javascript">
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
			}
		}
		
	});
	
	
</script>