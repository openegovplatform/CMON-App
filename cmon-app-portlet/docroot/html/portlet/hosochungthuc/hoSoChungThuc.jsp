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
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.LinkedList"%>
<%@page import="org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="org.oep.cmon.util.EgovUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh"%>
<%@page import="org.oep.cmon.util.DateUtil"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="org.oep.cmon.dao.chungthuc.service.HoSoChungThucLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="org.oep.cmon.dao.chungthuc.model.HoSoChungThuc"%>


<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<portlet:defineObjects />
<%
renderResponse.setTitle("Chứng thực");
PortletURL portletUrl = renderResponse.createRenderURL();
int currentTransPage = ParamUtil.getInteger(request, "currentTransPage");

String defaultSearchStr = "Nhập số chứng thực";

String searchKeyWord = URLDecoder.decode(ParamUtil.getString(request, "searchKeyWord"),
 			StringPool.UTF8);
	
// phan trang seach
SearchContainer searchContainer = null;
if (currentTransPage > 0) {
	searchContainer = new SearchContainer(renderRequest, null, null
			,SearchContainer.DEFAULT_CUR_PARAM, currentTransPage, 10, portletUrl, null, null);	
} else {
	searchContainer = new SearchContainer(renderRequest, null, null
			, SearchContainer.DEFAULT_CUR_PARAM, 10, portletUrl, null, null);
} 
int start = searchContainer.getStart();
int end = searchContainer.getEnd();

long tthcId = ParamUtil.getLong(request, "thutuchanhchinhid");
List<HoSoChungThuc> listHsChungThuc = null;
long hsChungThucCount = 0;

long uid = PortalUtil.getUserId(request);
CongChuc congChuc = EgovUtil.getCongChucDaDangNhap(uid);	

listHsChungThuc = HoSoChungThucLocalServiceUtil.getHoSoChungThucByTTHCAndSCT(
		tthcId, 0, congChuc.getCoQuanQuanLyId(), searchKeyWord, start, end);

hsChungThucCount =  HoSoChungThucLocalServiceUtil.countHoSoChungThucByTTHCAndSCT(
		tthcId, 0, congChuc.getCoQuanQuanLyId(), searchKeyWord, start, end);

int total = Integer.parseInt(String.valueOf(hsChungThucCount));
   searchContainer.setTotal(total);
   searchContainer.setResults(listHsChungThuc);
   searchContainer.setTotal(total);


List<NhomThuTucHanhChinh> listNhomTTHC =  NhomThuTucHanhChinhLocalServiceUtil.
			getDSNhomThuTucHanhChinhByCanBo(congChuc.getId());  

//TEST
/*  List<NhomThuTucHanhChinh> listNhomTTHC =  new LinkedList<NhomThuTucHanhChinh>();
NhomThuTucHanhChinh nhomTTHC = NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(19);
listNhomTTHC.add(nhomTTHC);
nhomTTHC = NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(20);
listNhomTTHC.add(nhomTTHC);  */
//END TEST

//List<ThuTucHanhChinh> thuTucHanhChinhs = ThuTucHanhChinhLocalServiceUtil.getListTTHCByCanBo(congChuc.getId());
//get id danh muc ung dung chung thuc
String maUngDung = ThamSoLocalServiceUtil.getValue("CTMS");
long idUngDung = DanhMucUngDungLocalServiceUtil.getIdDanhmucUngdung(maUngDung);

List<ThuTucHanhChinh> listTTHC = new LinkedList<ThuTucHanhChinh>();

//filter the tthc by ung dung chung thuc
if (listNhomTTHC != null && !listNhomTTHC.isEmpty()) {
	for (NhomThuTucHanhChinh ntthc: listNhomTTHC) {
		if (ntthc.getDanhMucUngDungId() == idUngDung) {
			List<ThuTucHanhChinh> listTthc = ThuTucHanhChinhLocalServiceUtil.searchByUngDungOrNhom(null, ntthc.getId(), 0, 1000);
			
			listTTHC.addAll(listTthc);
		}
	}
}   

//PortletURL portletUrl = renderResponse.createRenderURL();

%>
<portlet:resourceURL var="rutHoSo" id="rutHoSoChungThuc" >
</portlet:resourceURL>

<div class="egov-container">		
<%
	if (request.getAttribute("savemessage") != null) {
%>
<div class="portlet-msg-success" style="padding-left: 20px;">Đã lưu hồ sơ</div>
<%
	}
%>
<form name="hosochungthuc" method = "post" action = "<%=portletUrl.toString()%>" >
	<div class="clearfix septop10 sepbot10">
		<div class="fi fi50">
		<div class="fi-wrapper">
			<div class="inner">
				<select style="margin-left: 5px;" name="thutuchanhchinhid" class="egov-select" onchange="submitForm();">
			        <option value = "0">
						<!-- <liferay-ui:message key="org.oep.brms.registry.viewTransaction.filter" /> --> 
						Chọn loại hồ sơ
					</option>					
					<%
						// danh sach thu tuc hanh chinh loc theo co quan quan ly sau
						long nhomTTHCId = 0L;

						for (int i = 0; i < listTTHC.size(); i++) {
							ThuTucHanhChinh item = listTTHC.get(i);
							if (nhomTTHCId != item.getNhomThuTucHanhChinhId()) {
								nhomTTHCId = item.getNhomThuTucHanhChinhId();
					%>
					<optgroup label="<c:out value='<%=NhomThuTucHanhChinhLocalServiceUtil
							.getNhomThuTucHanhChinh(nhomTTHCId).getTen()%>'/>">
							<%
								}
							%>	
						<option <%= tthcId == item.getId() ? "selected"
						: ""%> value="<%=listTTHC.get(i).getId()%>" >
							<%=listTTHC.get(i).getTen()%>	 							
						</option>
						<%
							if (listTTHC.size() > i + 1
										&& (listTTHC.get(i + 1)
												.getNhomThuTucHanhChinhId() != nhomTTHCId)) {
						%>	
								</optgroup>	
					<%
							}
						}
					%>
			    </select>
			</div>
			</div>
		</div>
		
		<div class="fi fi35">
			<div class="fi-wrapper">
				<div class="fi-input">
					<input
						name="searchKeyWord"
						type="text"
						class="egov-inputfield"
						placeholder="<%=defaultSearchStr%>"
						value="<%=searchKeyWord%>"
						<%-- onfocus="if(this.value=='<%=defaultSearchStr%>') this.value='';"
						onblur="if(this.value=='') this.value='<%=defaultSearchStr%>'" --%>
					/>
				</div>
			</div>
		</div>
		
		<div class="fi fi5">
				<div class="fi-wrapper">
					<div class="fi-input">
					<button type="submit"
						class="egov-button-search small">&nbsp;</button>
					</div>
				</div>
		</div>
	</div>
	
	<table class="egov-table result-grid clear">
		<tr>
			<th>TT</th>
			<th style="width: 20%;">Loại giấy tờ</th> 
<!-- 			<th>Mã biên nhận</th> -->
			<th>Tên giấy tờ</th>
			<th>Chủ sở hữu</th>
			<th>Ngày nộp</th>
			<th>Ngày trả</th>
			<th>Số chứng thực</th>
			<th>Thao tác</th>
		</tr>
		<% 
			int index = 1;
			for (HoSoChungThuc hsChungThuc: listHsChungThuc) {
				ThuTucHanhChinh tthc = ThuTucHanhChinhLocalServiceUtil.
						getThuTucHanhChinh(hsChungThuc.getThuTucHanhChinhId()); 
				
				PortletURL viewDetail = renderResponse.createRenderURL();
				viewDetail.setParameter("jspPage", "/html/portlet/hosochungthuc/hoSoChungThucPreview.jsp");
				viewDetail.setParameter("idHoSo", String.valueOf(hsChungThuc.getHoSoChungThucId()));
				
				PortletURL editHoSo = renderResponse.createRenderURL();
				editHoSo.setParameter("jspPage", "/html/portlet/hosochungthuc/chungThuc.jsp");
				editHoSo.setParameter("idHoSo", String.valueOf(hsChungThuc.getHoSoChungThucId()));
				
		%>
		<tr>
			<td><%= searchContainer.getStart() + index%></td>
			<td><%= tthc.getTen() != null ?  tthc.getTen() : ""%></td> 
<%-- 			<td><%= hsChungThuc.getMaSoBienNhan() %></td> --%>
			<td><%= hsChungThuc.getTenChungThuc() != null ? hsChungThuc.getTenChungThuc() : "" %></td>
			<td><%= hsChungThuc.getChuSoHuu() != null ? hsChungThuc.getChuSoHuu() : ""%></td>
			<td><%= hsChungThuc.getNgayNopHoSo() != null ? DateUtil.parseDateToString(hsChungThuc.getNgayNopHoSo()) : "" %></td>
			<td><%= hsChungThuc.getNgayTraKetQua() != null ? DateUtil.parseDateToString(hsChungThuc.getNgayTraKetQua()) : "" %></td>
			<td><%= hsChungThuc.getSoChungThuc() != null ? hsChungThuc.getSoChungThuc() : ""%></td>
			<td style="text-align: center; width: 12%"><a href="<%= viewDetail%>" title="Xem chi tiết" ><span class="icon-7" style="margin-top: 5px;"></span></a>
			<button onclick="location.href='<%=editHoSo.toString()%>'" class="egov-func-edit" title="Chỉnh sửa hồ sơ"  type="button"></button>
			<button onclick="rutHoSo('<%=rutHoSo%>','<%=hsChungThuc.getHoSoChungThucId()%>');" class="egov-func-delete" title="Xóa hồ sơ"  type="button" style="width: 15px; height: 15px;"></button>
			</td>
			
		</tr>
		<%
				index ++;
			}
		%>
	</table>
	
	<div id = "paginationTrans">
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
	</div>
</form>
</div>

<div id="loading" title="Đang chuyển hồ sơ"> 
</div>

<script type="text/javascript">

$(document).ready(function () {
	// hidden save message
  	$('.portlet-msg-success').fadeOut("slow");
});

function submitForm() {
	var form = document.hosochungthuc;
	form.submit();
}

function rutHoSo(url, idHoSo) {           
	if (confirm('Bạn chắc chắn muốn xóa hồ sơ?')) {
	  	var title = 'Đang xóa hồ sơ ...';
		postDataToServer(url, idHoSo, title);
	}
}

$("#loading").dialog({
    hide: 'close',
	show: 'slide',
	autoOpen: false,
    height: 30,
    width: 250,
    resizable: false,
    title: "Đang chuyển hồ sơ ..."
});

function postDataToServer(url, idHoSo, title) {	
	$.ajax({
		  url : url,
		  data : 'idHoSo=' + idHoSo,
		  type: 'POST',
		  dataType : "json",
		  beforeSend: function(){
			  $("#loading").dialog({
				    title: title
				});
	           $("#loading").dialog('open');
	        },
		  success : function(data) {
			 $("#loading").dialog('close');
			 var  status = jQuery.parseJSON(data.status);			  
			 
			 if (status) {
				  location.reload();
				  
			 } else {
				 alert("Không thể xóa");
			 }
		  }
		});
}
</script>
