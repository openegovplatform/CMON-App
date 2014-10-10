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
<%@page import="org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cd.model.GioiTinh"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.oep.cmon.czprofile.portlet.util.ConvertUtil"%>
<%@page import="org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.cc.model.CongChuc"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil"%>
<%@page import="org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%
	TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(user.getUserId());
	
	CongChuc congChuc = CongChucLocalServiceUtil.findByTaiKhoanNguoiDungId(taiKhoanNguoiDung.getId()).get(0);
	

%>

		<%
		if (congChuc != null) {

			PortletURL inputDetailUrl = renderResponse.createActionURL();
			inputDetailUrl.setParameter(ActionRequest.ACTION_NAME, "updateCongChucDetail");
					
			//Long noiCapCmndId = null;
			String noiCapCmndId = null;
			Long gioiTinhId = null;			
			String ngayCapCmnd = null;
			String coQuanQuanly = null;
			String chucVu = null;
			String hoVaTen = null;
			String ngaySinh = null;
			String soCmnd = null;
		
			// Get user request from session
			Map <String, String> userRequest = (Map <String, String>)renderRequest.getPortletSession().getAttribute("USER_REQUEST_OBJECT");
			if ( userRequest == null ) {
				userRequest = new HashMap<String, String>();
				
				hoVaTen = congChuc.getHoVaTen();
				ngaySinh = ConvertUtil.parseDateToTring(congChuc.getNgaySinh());
				gioiTinhId = congChuc.getGioiTinhId();	
				soCmnd = congChuc.getSoCmnd();
				ngayCapCmnd = ConvertUtil.parseDateToTring(congChuc.getNgayCapCmnd());
				noiCapCmndId = congChuc.getNoiCapCmnd();			
							
				coQuanQuanly = CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(congChuc.getCoQuanQuanLyId()).getTen()==null?"":CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(congChuc.getCoQuanQuanLyId()).getTen();
				chucVu = ChucVuLocalServiceUtil.getChucVu(congChuc.getChucVuId()).getTen()==null?"":ChucVuLocalServiceUtil.getChucVu(congChuc.getChucVuId()).getTen();
				
				renderRequest.getPortletSession().setAttribute("USER_REQUEST_OBJECT", userRequest);
			} 
			else
			{
				hoVaTen = userRequest.get("tenDaydu") == null ? congChuc.getHoVaTen() : userRequest.get("tenDaydu");
				ngaySinh = userRequest.get("ngaySinh") == null ? ConvertUtil.parseDateToTring(congChuc.getNgaySinh()) : userRequest.get("ngaySinh");
				gioiTinhId = userRequest.get("gioiTinh") == null ? congChuc.getGioiTinhId() : Integer.parseInt(userRequest.get("gioiTinh"));
				soCmnd = userRequest.get("soCmnd") == null ? congChuc.getSoCmnd() : userRequest.get("soCmnd");
				ngayCapCmnd = userRequest.get("ngayCapCmnd") == null ? ConvertUtil.parseDateToTring(congChuc.getNgayCapCmnd()) : userRequest.get("ngayCapCmnd");
				noiCapCmndId = userRequest.get("noiCapCmnd") == null ? congChuc.getNoiCapCmnd() : userRequest.get("noiCapCmnd");
				//noiCapCmndId = userRequest.get("IDNOICAPCMND") == null ? congDan.getNoiCapCmndId() : Long.parseLong(userRequest.get("IDNOICAPCMND"));
			
			}
		%>

    <div class="egov-container">
		<form id="updateDetailForm" name="updateDetailForm" method="post" action="<%=inputDetailUrl%>">
		<table align="center" class="egov-table-form" width="100%">
			
			<tr>
				<td colspan="6" align = "left">
				<liferay-ui:error key="org.oep.cmon.czprofile.form.input.err.notLogin"  message = "org.oep.cmon.czprofile.form.input.err.notLogin" />
				<liferay-ui:error key="org.oep.cmon.czprofile.form.input.err.notExist"  message = "org.oep.cmon.czprofile.form.input.err.notExist" />
				<select style="display: none;" id="egov-form-errors">
					<option value="tenDaydu"><liferay-ui:error key="org.oep.cmon.czprofile.form.canbo.input.ten.empty" message = "org.oep.cmon.czprofile.form.canbo.input.ten.empty"/></option>
					<option value="ngaySinh"><liferay-ui:error key="org.oep.cmon.czprofile.form.canbo.input.ngaysinh.empty" message = "org.oep.cmon.czprofile.form.canbo.input.ngaysinh.empty"/></option>
					<option value="soCmnd"><liferay-ui:error key="org.oep.cmon.czprofile.form.canbo.input.socmnd.empty" message = "org.oep.cmon.czprofile.form.canbo.input.socmnd.empty"/></option>
					<option value="soCmnd"><liferay-ui:error key="org.oep.cmon.czprofile.form.canbo.input.socmnd.invalid" message = "org.oep.cmon.czprofile.form.canbo.input.socmnd.invalid"/></option>
					<option value="ngayCapCmnd"><liferay-ui:error key="org.oep.cmon.czprofile.form.canbo.input.ngaycap.empty" message = "org.oep.cmon.czprofile.form.canbo.input.ngaycap.empty"/></option>
					<option value="ngayCapCmnd"><liferay-ui:error key="org.oep.cmon.czprofile.form.canbo.input.ngaycap.than.current" message = "org.oep.cmon.czprofile.form.canbo.input.ngaycap.than.current"/></option>
					<option value="ngayCapCmnd"><liferay-ui:error key="org.oep.cmon.czprofile.form.canbo.input.ngaycap.oldest" message = "org.oep.cmon.czprofile.form.canbo.input.ngaycap.oldest"/></option>
					<option value="noiCap"><liferay-ui:error key="org.oep.cmon.czprofile.form.canbo.input.noicap.empty" message = "org.oep.cmon.czprofile.form.canbo.input.noicap.empty"/></option>
				</select>					
					<liferay-ui:success key="success" message="Thông tin đã được cập nhật" />
				</td>
			</tr>
			<tr>					
					<td width="10%">&nbsp;</td>
					<td width="23.34%"><label class="egov-label-bold">
							Mã cán bộ:
						</label></td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%"><label class="egov-label-bold">
							Họ và tên:
						</label></td>						
					
			</tr>
			<tr>
					
					<td width="10%">&nbsp;</td>
					<td width="23.34%">
						<input type="text" name="maCanBo" id="maCanBo" class="readonly egov-inputfield" disabled="disabled" style="width:92%" value="<%=congChuc.getMa() %>"  />
						<input id="id" name="id" type="hidden" value="<%=congChuc.getId()%>"/>
					</td>
					
					<td width="10%">&nbsp;</td>
					<td width="23.34%">
						<input type="text" name="tenDaydu" id="tenDaydu" class="egov-inputfield" style="width:92%" value="<%=hoVaTen %>"  />
						
					</td>
					
			</tr>
			
			<tr>					
					<td width="10%">&nbsp;</td>
					<td width="23.34%" ><label class="egov-label-bold">
							Email:
						</label> <i>(Tài khoản đăng nhập)</i>
						
						</td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%"><label class="egov-label-bold">
							Ngày sinh:
						</label></td>					
					<td width="23.34%"  style="padding-left:20px"><label class="egov-label-bold">
							Giới tính:
						</label></td>					
					
			</tr>
			<tr>
					
					<td width="10%">&nbsp;</td>
					<td width="23.34%">
						<input type="text" name="maCanBo" id="maCanBo" class="readonly egov-inputfield" disabled="disabled" style="width:92%" value="<%=taiKhoanNguoiDung.getEmail() %>"  />
						
					</td>
					
					<td width="10%">&nbsp;</td>
					<td width="23.34%">					
						<input type="text" name="ngaySinh" id="ngaySinh" class = "egov-calendar" style="width:80%" value="<%=ngaySinh %>"  />
					</td>
										
					<td width="23.34%"  style="padding-left:20px">
					<%
						List <GioiTinh> gioiTinhList = GioiTinhLocalServiceUtil.getDSGioiTinh();
					%>
						<select name="gioiTinh" id="gioiTinh" class = "egov-select custom" style="width:98%; display:block;">
						<%
							String selected = "";
							for ( GioiTinh gioiTinh: gioiTinhList) {
								if ( Validator.isNotNull(gioiTinhId) && gioiTinh.getId() == gioiTinhId ) {
									selected = "selected";
								} else {
									selected = "";
								}
						%>
							<option value = "<%=gioiTinh.getId()%>" <%=selected %>><%=gioiTinh.getTen() %></option>
						<% } %>
						</select>
					</td>
			</tr>
			
			<tr>					
					<td width="10%">&nbsp;</td>
					<td width="23.34%"><label class="egov-label-bold">
							Cơ quan quản lý:
						</label></td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%"><label class="egov-label-bold">
							Số CMND:
						</label></td>						
					
			</tr>
			<tr>
					
					<td width="10%">&nbsp;</td>
					<td width="23.34%">
						<input type="text" name="coQuanQuanLy" id="coQuanQuanLy" class="readonly egov-inputfield" disabled="disabled" style="width:92%" value="<%=CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(congChuc.getCoQuanQuanLyId()).getTen()==null?"":CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(congChuc.getCoQuanQuanLyId()).getTen()%>"  />
						
					</td>
					
					<td width="10%">&nbsp;</td>
					<td width="23.34%">
						<input name="soCmnd" type="text" id="soCmnd" maxlength="12" class = "egov-inputfield" value = "<%=soCmnd%>" style = 'width:92%'/>
					</td>
					
			</tr>
				
			
				<tr>					
					<td width="10%">&nbsp;</td>
					<td width="23.34%"><label class="egov-label-bold">
							Chức vụ:
						</label></td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%"><label class="egov-label-bold">
							Ngày cấp CMND:
						</label></td>						
					<td width="23.34%"  style="padding-left:20px"><label class="egov-label-bold">
							Nơi cấp CMND:
						</label></td>
				</tr>
				<tr>
					
					<td width="10%">&nbsp;</td>
					<td width="23.34%">
						<input type="text" name="chucVu" id="chucVu" class="readonly egov-inputfield" disabled="disabled" style="width:92%" value="<%=ChucVuLocalServiceUtil.getChucVu(congChuc.getChucVuId()).getTen()==null?"":ChucVuLocalServiceUtil.getChucVu(congChuc.getChucVuId()).getTen() %>"  />
					</td>
					
					<td width="10%">&nbsp;</td>
					<td width="23.34%">
						<input name="ngayCapCmnd" type="text" id="ngayCapCmnd" maxlength="10" class = "egov-calendar" value = "<%=ngayCapCmnd%>" style = 'width:80%'/>
					</td>				
					<td width="23.34%"  style="padding-left:20px">
						<input type="text" name="noiCapCmnd" id="noiCapCmnd" class="egov-inputfield" style="width:83%" value="<%=noiCapCmndId  %>"  />
												
					</td>
				</tr>
				
				<tr>
					<td colspan="6">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" >
						<input type="submit" name="update" id="update" value="Cập nhật" class = "egov-button-normal"/>
						<a href="/group/guest">
							<input type="button" class = "egov-button-normal" name="back" id="back" value="Quay lại"/>
						</a>
					</td>
					<td width="10%">&nbsp;</td>
					<td width="23.34">&nbsp;</td>
					<td width="10%">&nbsp;</td>
					<td width="23.34%">&nbsp;</td>
				</tr>
		</table>
		
		<%
			PortletURL redirectUrl= renderResponse.createRenderURL();
			redirectUrl.setParameter("jspPage","/html/portlet/czprofile/view.jsp");
		%>
		<input type="hidden" name=redirectUrl value="<%=redirectUrl%>"/>
		</form>
		<script type="text/javascript">
		    $('#soCmnd').bind('input propertychange', function () {
			    $(this).val($(this).val().replace(/[^0-9]/g, ''));
			});
		 </script>
		<%
		} else {
			%>
			<font color="red" style="font-family: serif;">Bạn chưa có thông tin tài khoản cá nhân</font>
			<%
		}
		%>
	</div>