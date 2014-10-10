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
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/admin/init.jsp" %>
<%
	PortletURL coQuanQuanLyUrl = renderResponse.createRenderURL();
	coQuanQuanLyUrl.setParameter("jspPage","/html/portlet/admin/co_quan_quan_ly_list.jsp");
	
	PortletURL quocGiaUrl = renderResponse.createRenderURL();
	quocGiaUrl.setParameter("jspPage","/html/portlet/admin/quoc_gia_list.jsp");
	
	PortletURL capDonViHanhChinhUrl = renderResponse.createRenderURL();
	capDonViHanhChinhUrl.setParameter("jspPage","/html/portlet/admin/cdvhc_list.jsp");
	
	PortletURL capCoQuanQuanLyUrl = renderResponse.createRenderURL();
	capCoQuanQuanLyUrl.setParameter("jspPage","/html/portlet/admin/cap_co_quan_quan_ly_list.jsp");
	
	PortletURL gioiTinhUrl = renderResponse.createRenderURL();
	gioiTinhUrl.setParameter("jspPage","/html/portlet/admin/gioi_tinh_list.jsp");
	
	PortletURL danhMucDonViHanhChinh = renderResponse.createRenderURL();
	danhMucDonViHanhChinh.setParameter("jspPage","/html/portlet/admin/dmdvhc_list.jsp");
	
	PortletURL loaiDoiTuongSuDung = renderResponse.createRenderURL();
	loaiDoiTuongSuDung.setParameter("jspPage","/html/portlet/admin/loai_doi_tuong_list.jsp");
	
	PortletURL nguoiDungUrl = renderResponse.createRenderURL();
	nguoiDungUrl.setParameter("jspPage","/html/portlet/admin/tai_khoan_nguoi_dung_list.jsp");
	
	PortletURL heThongUrl = renderResponse.createRenderURL();
	heThongUrl.setParameter("jspPage","/html/portlet/admin/dmht_list.jsp");
	
	PortletURL vaiTroUrl = renderResponse.createRenderURL();
	vaiTroUrl.setParameter("jspPage","/html/portlet/admin/dmvt_list.jsp");
	
	PortletURL congChucUrl = renderResponse.createRenderURL();
	congChucUrl.setParameter("jspPage","/html/portlet/admin/cong_chuc_list.jsp");
	
	PortletURL chucVuUrl = renderResponse.createRenderURL();
	chucVuUrl.setParameter("jspPage","/html/portlet/admin/chuc_vu_list.jsp");
	
	PortletURL chucVuVaiTroCoQuanQuanLysUrl = renderResponse.createRenderURL();
	chucVuVaiTroCoQuanQuanLysUrl.setParameter("jspPage","/html/portlet/admin/dm_co_quan_quan_ly_chuc_vu_list_cqql.jsp");
	
	PortletURL jobMonitorUrl = renderResponse.createRenderURL();
	jobMonitorUrl.setParameter("jspPage","/html/portlet/admin/job_monitor.jsp");
	
	
	PortletURL dichVuCongCreationUrl = renderResponse.createRenderURL();
	dichVuCongCreationUrl.setParameter("jspPage","/html/portlet/admin/dvc_create.jsp");
	
	PortletURL dichVuCongAlonenUrl = renderResponse.createRenderURL();
	dichVuCongAlonenUrl.setParameter("jspPage","/html/portlet/admin/dvc_only_create.jsp");
	
	PortletURL assignDvcToDonViTiepNhanUrl = renderResponse.createRenderURL();
	assignDvcToDonViTiepNhanUrl.setParameter("jspPage","/html/portlet/admin/assign_dvc_donvi.jsp");
	
	PortletURL dataExchMonitorUrl = renderResponse.createRenderURL();
	dataExchMonitorUrl.setParameter("jspPage","/html/portlet/admin/exch_data_monitor.jsp");
	
	PortletURL hoSoTichHopUrl = renderResponse.createRenderURL();
	hoSoTichHopUrl.setParameter("jspPage","/html/portlet/admin/hoso_list.jsp");
	
	PortletURL tai_khoan_nguoi_dung_cong_chucUrl = renderResponse.createRenderURL();
	tai_khoan_nguoi_dung_cong_chucUrl.setParameter("jspPage","/html/portlet/admin/tai_khoan_nguoi_dung_cong_chuc_list.jsp"); 
%>
<div class="wd-main-content">
	<table width="100%" border="0">
	  <tr>
	    <td width = "33%"><a href = "<%=coQuanQuanLyUrl%>" >Danh mục cơ quan quản lý</a></td>
	    <td width = "33%"><aui:a href="<%=quocGiaUrl.toString() %>"><liferay-ui:message key="vn.dtt.cmon.admin.menu.quocgia.title"/></aui:a></td>
	    <td width = "34%"><aui:a href="<%=capDonViHanhChinhUrl.toString() %>"><liferay-ui:message key="vn.dtt.cmon.admin.menu.dvhc.title"/></aui:a></td>	    
	  </tr>
	  <tr>
	    <td width = "33%"><a href = "<%=capCoQuanQuanLyUrl%>" >Danh mục cấp cơ quan quản lý</a></td>
	    <td width = "33%"><a href = "<%=gioiTinhUrl%>" >Danh mục giới tính</a></td>
	    <td width = "33%"><a href = "<%=danhMucDonViHanhChinh%>" >Danh mục đơn vị hành chính</a></td>
	  </tr>
	  <tr>
	    <td width = "33%"><a href = "<%=loaiDoiTuongSuDung%>" >Danh mục đối tượng sử dụng</a></td>
	    <td><a href = "<%=nguoiDungUrl%>">Danh mục người sử dụng</a></td>
	    <td><a href = "<%=heThongUrl%>" >Danh mục hệ thống</a></td>
	  </tr>
	  <tr>
	    <td><a href = "<%=vaiTroUrl%>" >Danh mục vai trò</a></td>
	    <td><a href = "<%=congChucUrl%>" >Danh mục công chức</a></td>
	    <td><a href = "<%=chucVuUrl%>" >Danh mục chức vụ</a></td>
	  </tr>
	  <tr>
	    <td><a href = "<%=chucVuVaiTroCoQuanQuanLysUrl%>">Định nghĩa chức vụ cho cơ quan quản lý</a></td>
	    <td><a href = "<%=jobMonitorUrl%>" >Quản lý JOB</a></td>
	    <td><a href = "<%=dichVuCongCreationUrl%>" >Tạo dịch vụ công và assign luôn cho đon vị tiếp nhận(Dùng để tạo test data))</a></td>
	  </tr>
	  <tr>
	    <td><a href = "<%=dichVuCongAlonenUrl%>" >Tạo dịch vụ công only(for test data)</a></td>
	    <td><a href = "<%=assignDvcToDonViTiepNhanUrl%>" >Assign dịch vụ công vào đơn vị tiếp nhận (Theo Batch)</a></td>
	    <td><a href = "<%=dataExchMonitorUrl%>">Quản lý dữ liệu lỗi khi tích hợp</a></td>
	  </tr>	
	  
	  <tr>
	    <td><a href = "<%=hoSoTichHopUrl%>" >Danh sách hồ sơ tích hợp</a></td>
	    <td><a href = "<%=tai_khoan_nguoi_dung_cong_chucUrl%>" >Tìm công chức của người sử dụng</a></td>
	    <td></td>
	  </tr>	  
	</table>
</div>	
