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
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="org.oep.cmon.touchscreen.portlet.util.TouchscreenUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />    
<div class="content-block">                                
   	<div id="dichvucong" class="owl-carousel owl-theme">
   	<%
    PortletPreferences prefs = renderRequest.getPreferences();
    String portletResource = ParamUtil.getString(request, "portletResource");
    if(Validator.isNotNull(portletResource)){
    	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
    }
    String id_donvi = prefs.getValue("id_donvi","0");
    String[] id_capcoquan = prefs.getValues("id_capcoquan",null);
   	List<HoSoTTHCCong> listresult = TouchscreenUtil.listHoSo(Long.valueOf(id_donvi),id_capcoquan);
   	float pg = (float) listresult.size()/10;
   	int item = (int) Math.ceil(pg);
   	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
   	for(int i=0;i<item;i++){
   	%>
           <div class="item">
               <table class="table table-bordered tb-color">
                   <thead>
                       <tr>
                           <th class="hidden-mobile">#</th>
                           <th>Mã số biên nhận</th>
                           <th>Người nộp</th>
                           <th>Ngày nộp</th>
                           <th>Ngày hẹn trả</th>
                           <th>Nộp tại</th>
                           <th>Cách nộp</th>
                       </tr>
                   </thead>
                   <tbody>
                   <tbody>
                   <%
                  	int start = ((i+1)-1)*10;
                   	int end = (start+10);
                   	for(int j=start;j<end;j++){
                   		if(j>listresult.size()-1){
                   			break;
                   		}
                   %>
                   	<tr>
						<td class="color bold center hidden-mobile"><%=(j+1)%></td>
						<td class="center"><%=listresult.get(j).getMaSoBienNhan()%></td>
						<td class="color bold"><%=listresult.get(j).getHoTenNguoiNopHoSo()%></td>
						<td class="center"><%=listresult.get(j).getNgayNopHoSo()!=null?df.format(listresult.get(j).getNgayNopHoSo()):""%></td>
						<td class="color center"><%=listresult.get(j).getNgayHenTraKetQua()!=null?df.format(listresult.get(j).getNgayHenTraKetQua()):""%></td>
						<td><%=listresult.get(j).getTenCoQuanTiepNhan()%></td>
						<td class="<%=listresult.get(j).getLoaiHoSo()==0?"green":"orange"%> bold center"><%=listresult.get(j).getLoaiHoSo()==0?"Trực tuyến":"Trực tiếp"%></td>
					</tr>
					<%}	%>	
                    </tbody>
                </table>
           </div><!--/item-->
    <%} %>
   	</div>
</div><!--/content-block-->