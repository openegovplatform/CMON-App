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
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTBusinessUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo"%>
<%@page import="org.oep.cmon.Constants"%>
<%@page import="org.oep.cmon.dao.tlct.model.DanhMucGiayTo"%>
<%@page import="org.oep.cmon.dao.hosolienthong.model.HoSoLienThong"%>
<%@page import="org.oep.cmon.dao.hosolienthong.service.HoSoLienThongLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.hosolienthong.HSLTFields"%>
<%@page import="org.oep.egovcore.util.LiferayURL"%>
<%@page import="org.oep.egovcore.language.CmonMessager"%>
<%@page import="org.oep.egovcore.language.cmonkey.Label"%>
<%@page import="org.oep.egovcore.language.CmonMessagerUtil"%>
<%@page import="org.oep.egovcore.util.VNNumberUtil"%>
<%@page import="org.oep.egovcore.util.HSRParamUtil"%>
<%@page import="org.oep.egovcore.util.DateTimeUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.model.CoQuanQuanLy"%>
<%@page import="org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.FileDinhKem"%>
<%@page import="java.util.Date"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil"%>
<%@page import="org.oep.cmon.dao.dvc.model.ThuTucHanhChinh"%>
<%@page import="org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoFields"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@page import="org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil"%>
<%@page import="org.oep.egovcore.util.DateTimeUtil"%>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/core.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/in_giay_bien_nhan.css">

<liferay-theme:defineObjects />
<portlet:defineObjects />
<%
	long hoSoId = HSRParamUtil.getLong(request, HoSoFields.hoSoId);
	
	CmonMessager label = CmonMessagerUtil.forPrefix(Label.PREFIX);
	HoSoTTHCCong hoSo = HoSoTTHCCongLocalServiceUtil.fetchHoSoTTHCCong(hoSoId);
	
	Date ngayTiepNhan, ngayHenTraKetQua;
	ngayTiepNhan = hoSo.getNgayBoSung();
	if (ngayTiepNhan == null) {
		ngayTiepNhan = hoSo.getNgayNhanHoSo();
	}
	ngayHenTraKetQua = hoSo.getNgayHenTraKetQua();

	HoSoLienThong hoSoLienThong = HSLTBusinessUtil.getHoSoLienThongDaTiepNhan(hoSo, hoSo.getCoQuanTiepNhanId());
	if (hoSoLienThong != null) {
		ngayTiepNhan = hoSoLienThong.getNgayNhan();
		ngayHenTraKetQua = hoSoLienThong.getNgayNoiNhanHenTra();
	}
	
	String lucTiepNhan = DateTimeUtil.getFullDateTime(ngayTiepNhan, false);
	String lucHenTraKetQua = DateTimeUtil.getFullDateTime(ngayHenTraKetQua, false);

	CoQuanQuanLy coQuan = CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(hoSo.getCoQuanTiepNhanId());

	String soDienThoai = GetterUtil.getString(hoSo.getSoDienThoaiCoDinhNguoiNop()).trim();

	if (soDienThoai.isEmpty()) {
		soDienThoai = GetterUtil.getString(hoSo.getSoDienThoaiDiDongNguoiNop());
	}

	String maCapCQQL = 
		CapCoQuanQuanLyLocalServiceUtil.fetchCapCoQuanQuanLy(coQuan.getCapCoQuanQuanlyId()).getMa().trim();
	boolean laTinhHuyenXa = 
		maCapCQQL.equals(ThamSoLocalServiceUtil.getValue("CMON_CAP_CQQL_TINH_MA"))
		|| maCapCQQL.equals(ThamSoLocalServiceUtil.getValue("CMON_CAP_CQQL_QUAN_HUYEN_MA"))
		|| maCapCQQL.equals(ThamSoLocalServiceUtil.getValue("CMON_CAP_CQQL_PHUONG_XA_MA"));
	
%>

<script type="text/javascript">

	 $(function() {
		print = getURLParameter("print");
		if (print === "print") {
			printlnThisDoc();
			window.close();
		}
		
		$('.print-btn').bind('click', function() {
			printlnThisDoc();
		});
	}); 
	 
	function getURLParameter(sParam) {
		var sPageURL = window.location.search.substring(1);
		var sURLVariables = sPageURL.split('&');
		for ( var i = 0; i < sURLVariables.length; i++) {
			var sParameterName = sURLVariables[i].split('=');
			if (sParameterName[0] == sParam) {
				return sParameterName[1];
			}
		}
	}

	function printlnThisDoc() {
		var $tbody = $('#__tbody');
		var rowCount = $tbody.children().length;
		var $tplRow = $tbody.children().eq(0).clone();

		$tbody.empty();
		var $tplTable = $('#dataTable').clone();
		$('#dataTable').remove();
		var $wraper = $('#_wrapper');
		var $tbl = null;

		for ( var i = 0; i < rowCount; ++i) {

			if ((i % 4) === 0) {
				$tbl = $tplTable.clone();
				$wraper.append($tbl);
			}

			$tbl.find('#__tbody').append($tplRow.clone()).css("margin-top",
					"90px");
		}

		$('#_to_be_print')
				.print(
						[ '${pageContext.request.contextPath}/css/core.css',
								'${pageContext.request.contextPath}/css/in_phieu_luu_chuyen.css' ]);
	}
</script>

<div class="hidden-sep">&nbsp;</div>
<div class="button-bar" style="margin-top: 10px;">
	<button type="button" class="egov-button print-btn">In Phiếu lưu chuyển hồ sơ</button>
</div>
<div class="_outer egov-container preview clearfix" id="_to_be_print">
	<div class="fi90 left">
		<div>
			<div id="_wrapper" class="_wrapper">
				<div class="hidden-sep">&nbsp;</div>
				<div class="line septop10 nonsepbot">
					<div class="item fi45 center nonsepbot">
						<label class="egov-label upper ubnd">
						<% if (laTinhHuyenXa) { %>
							ỦY BAN NHÂN DÂN
						<% } else { %>
						 	<c:out value='<%=CoQuanQuanLyLocalServiceUtil.fetchCoQuanQuanLy(coQuan.getChaId()).getTen()%>'/>
						<% } %>
						</label>
					</div>
					<div class="item fi55 center nonsepbot">
						<label class="egov-label strong upper"><c:out value='<%=label.get(Label.chxhcnvn)%>'/></label>
					</div>
				</div>
				<div class="line nonseptop">
					<div class="item fi45 center">
						<label class="egov-label strong upper underline">
						<% if (laTinhHuyenXa) { %>
						 	<c:out value='<%=DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(coQuan.getDonViHanhChinhId()).getTen()%>'/>
						<% } else { %>
							<c:out value='<%=coQuan.getTen()%>'/>
						<% } %>
						</label>
					</div>
					<div class="item fi55 center">
						<label class="egov-label strong underline"><c:out value='<%=label.get(Label.dltdhp)%>'/></label>
					</div>
				</div>
				<div class="line">
					<div class="item fi45 center sobiennhan">
						<label class="egov-label">Số:</label>
						<label class="egov-label"><c:out value='<%=hoSo.getMaSoBienNhan()%>' /></label>
					</div>
				</div>
				<div class="line septop10 sepbot10">
					<div class="item center">
						<label class="egov-label strong upper">PHIẾU LƯU CHUYỂN HỒ SƠ</label>
					</div>
				</div>
				<div style ="margin-left: 35px;"class="line">
					<div class="item fi60">
						<label class="egov-label">Hồ sơ số:</label>
						<label class="egov-label"><c:out value='<%=hoSo.getMaSoBienNhan()%>'/></label>
					</div>
					<div class="item fi60">
						<label class="egov-label">Loại thủ tục:</label>
						<label class="egov-label"><c:out value='<%=hoSo.getTenThuTucHanhChinh()%>'/></label>
					</div>
				</div>
				<div style ="margin-left: 35px;"class="line">
					<div class="item">
						<label class="egov-label">Người nộp hồ sơ:</label>
						<label class="egov-label"><c:out value="<%=hoSo.getHoTenNguoiNopHoSo()%>"/></label>
					</div>
				</div>
				<div style ="margin-left: 35px;"class="line">
					<div class="item">
						<label class="egov-label">Thường trú tại:</label>
						<label class="egov-label">
							<c:out value="<%=HoSoBusinessUtil.getDiaChiDayDuCongDanNopHoSo(hoSo)%>"/>
						</label>
					</div>
				</div>
				<div style ="margin-left: 35px;"class="line">
					<div class="item">
						<label class="egov-label">Điện thoại:</label>
						<label class="egov-label"> <c:out value="<%= soDienThoai %>"/> </label>
					</div>
				</div>
				
				<div style ="margin-left: 35px;"class="line">
					<div class="item">
						<label class="egov-label">Thời gian tiếp nhận hồ sơ:</label>
						<label class="egov-label"><%= lucTiepNhan %></label>
					</div>
				</div>
				<div style ="margin-left: 35px;"class="line">
					<div class="item">
						<label class="egov-label">Thời gian trả kết quả:</label>
						<label class="egov-label"><%= lucHenTraKetQua %> </label>
					</div>
				</div>
				
				<!--Can Update lai table  -->
				<table id="dataTable" style="border: 1px solid;border-collapse: collapse;width: 100%;page-break-after: always;">
					<thead>
					
						<tr >
							<th style="border: 1px solid;width: 25%;">
									<div class="item center">
										<label class="egov-label strong">
										Tên đơn vị/bộ phận
										</label>
									</div>
							</th>
							<th style="border: 1px solid;width: 50%;">
									<div class="item center">
									<label class="egov-label strong">Ngày giao/nhận hồ sơ</label>		
									</div>
							</th>
							<th style="border: 1px solid;width: 25%;">
									<div class="item center">
										<label class="egov-label strong">Ghi chú</label>
									</div>
							</th>
						</tr>
					</thead>
					<tbody id="__tbody">					
						<% for(int i=0; i<4;i++){%>
						<tr class="add" style="border: 1px solid;">
							<td style="border: 1px solid;padding-bottom: 20pt;padding-top: 5px;">		
									<div >											
											<label class="egov-label">
											- Giao:.....................................<br>
											................................................
											</label>
											<br>
											<label class="egov-label">
											- Nhận:....................................<br>
											................................................<br>
											................................................
											</label>
											<br>
									</div>									
								
							</td>
							
							<td class="center" style="border: 1px solid;padding-bottom: 50pt;">		
									<div >											
											<label class="egov-label">..... giờ ..... phút, ngày ..... tháng ..... năm .....</label>
											<br>
											<label class="egov-label strong">NGƯỜI GIAO &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; NGƯỜI NHẬN</label>
											<br>
											<label class="egov-label">(ký , ghi rõ họ tên)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(ký , ghi rõ họ tên)</label>
									</div>									
								
							</td>
							
							<td style="border: 1px solid;">
									
									<div class="sepbot1" >
										<div class="item center">
										<br>											
											<label class="egov-label strong">&nbsp;</label>
											<br>
											<label class="egov-label">&nbsp;</label>
										</div>
									</div>
								
							</td>
						</tr>
					<%} %>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<div STYLE="position:absolute; LEFT:85%; " align ="right" >
					
						<input style="margin-top: 10px;width: 20px;" class="egov-button" type="button" id="butAppend" onclick="addRow('dataTable')"value="+"/>
						<input style="margin-top: 10px;width: 20px;" class="egov-button" type="button" id="butRemove" onclick="deleteRow('dataTable')" value="-"/>
						<br>
							
</div>
<div class="button-bar" style="margin-top: 10px;">
	<%
		/* String backURL = HSRParamUtil.getString(request, "urlQuayLaiListTets").trim(); */
		String backURL = ParamUtil.getString(request, "backURL");
		//String backURL =LiferayURL.createRenderURL(request, "ipmslistportlet_WAR_cmonappportlet", null).toString();
		/* 
		if (backURL.isEmpty()) {
			backURL = LiferayURL.createRenderURL(request, "ipmslistportlet_WAR_cmonappportlet", null).toString();
		} */
	%>
	<br>
	<button type="button" class="egov-button print-btn">In Phiếu lưu chuyển hồ sơ</button>
	<button type="button" onclick="location.href='<%= backURL %>'" class="egov-button">Quay lại</button>
</div>
<div class="hidden-sep">&nbsp;</div>

<script type="text/javascript">


function addRow(tableID) {
	
	var bien=$('.add').clone().html();			
	$('#dataTable > tbody:last').append('<tr>'+bien+'</tr>');
}

/* function addRow(tableID) {
	 
	
	
	
	var table = document.getElementById(tableID);
	 
    var rowCount = table.rows.length;
    alert(rowCount);
    var row = table.insertRow(rowCount);

    var colCount = table.rows[0].cells.length;

    for(var i=0; i<colCount; i++) {

        var newcell = row.insertCell(i);

        newcell.innerHTML = table.rows[2].cells[i].innerHTML;
        //alert(newcell.childNodes);
        switch(newcell.childNodes[0].type) {
            case "text":
                    newcell.childNodes[0].value = "";
                    break;
            case "checkbox":
                    newcell.childNodes[0].checked = false;
                    break;
            case "select-one":
                    newcell.childNodes[0].selectedIndex = 0;
                    break;
        }
    }
} */

function deleteRow(tableID) {	 
	try {
		var table = document.getElementById(tableID);
		var rowCount = table.rows.length;
		if(rowCount<6)
			return false;
		table.deleteRow(rowCount-1);
		rowCount--;
		
		
		}catch(e) {
		alert(e);
		}


       
}
	jQuery(document).ready(function(){
		/* var i=1;
		jQuery("#butAppend").click(function(){
			i++;
			var bien=$('#clone').clone().html();
			jQuery("#temp").append(bien);
			
		}); */
		
		/* var counter = 2;
		 
	    $("#butAppend").click(function () {
	 
		if(counter>20){
	            alert("Only allow 20  ");
	            return false;
		}   
		
		var bien=$('#cloneHidd').clone().html();
		
		var newDiv = $(document.createElement('div'))
		     .attr("id", 'cloneHidd' + counter);
	 	
		newDiv.after().html(bien).attr("id", 'cloneHidd' + counter);		
		
	 
		newDiv.appendTo("#temp");
	 
	 
		counter++;
	     });
	 
	    $("#butRemove").click(function () {
		if(counter==1){
	          //alert("Not allow remove");
	          return false;
	       }   
	 
		counter--;
	 
	       
		$("#cloneHidd" + counter).remove(); 
	     });
		  */
		
		
	});
</script>



