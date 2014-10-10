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
<%@page import="org.oep.cmon.portlet.taocongdan.business.TaoCongDanBusiness"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	
	function onSelectCongDan(data, popup) {
		 //alert(data['tinhId'] + '  ' + data['huyenId'] + '  ' + data['xaId']);
		 
		 $("#isLoaded").val('load');
		 
		 $('#<portlet:namespace/>inputForm').find('#congDanId').val(data['id']);

		 $('#<portlet:namespace/>inputForm').find('#email').val(data['email']);
		 
		 $('#<portlet:namespace/>inputForm').find('#ho').val(data['ho']);
		// $('#<portlet:namespace/>inputForm').find('#ho').attr('readonly','readonly');
		 $('#<portlet:namespace/>inputForm').find('#ho').attr('placeholder','');
		// $('#<portlet:namespace/>inputForm').find('#ho').addClass('readonly');

		 $('#<portlet:namespace/>inputForm').find('#dem').val(data['dem']);
	//	 $('#<portlet:namespace/>inputForm').find('#dem').attr('readonly','readonly');
		 $('#<portlet:namespace/>inputForm').find('#dem').attr('placeholder','');
	//	 $('#<portlet:namespace/>inputForm').find('#dem').addClass('readonly');
		 
		 $('#<portlet:namespace/>inputForm').find('#ten').val(data['ten']);
	//	 $('#<portlet:namespace/>inputForm').find('#ten').attr('readonly','readonly');
		 $('#<portlet:namespace/>inputForm').find('#ten').attr('placeholder','');
	//	 $('#<portlet:namespace/>inputForm').find('#ten').addClass('readonly');
		 
		 $('#<portlet:namespace/>inputForm').find('#ngaySinh').val(data['ngaySinh']); 
		// $('#<portlet:namespace/>inputForm').find('#ngaySinh').attr('readonly','readonly');
		// $('#<portlet:namespace/>inputForm').find('#ngaySinh').addClass('readonly');
		 
		 $('#<portlet:namespace/>inputForm').find('#soCmnd').val(data['soCMND']);
	//	 $('#<portlet:namespace/>inputForm').find('#soCmnd').attr('readonly','readonly');
	//	 $('#<portlet:namespace/>inputForm').find('#soCmnd').addClass('readonly'); 
		 
		 $('#<portlet:namespace/>inputForm').find('#ngayCapCmnd').val(data['ngayCap']);
	//	 $('#<portlet:namespace/>inputForm').find('#ngayCapCmnd').attr('readonly','readonly');
	//	 $('#<portlet:namespace/>inputForm').find('#ngayCapCmnd').addClass('readonly');
		 
		 $('#<portlet:namespace/>inputForm').find('#noiCapCmndId').val(data['noiCapId']);
		// $('#<portlet:namespace/>inputForm').find('#noiCapCmndId').attr('disabled','disabled');
		// $('#<portlet:namespace/>inputForm').find('#noiCapCmndId').addClass('readonly');

		 $('#<portlet:namespace/>inputForm').find('#quocTichId').val(data['quocTichId']);
		// $('#<portlet:namespace/>inputForm').find('#quocTichId').attr('disabled','disabled');
		// $('#<portlet:namespace/>inputForm').find('#quocTichId').addClass('readonly');		 	
		 
		 $('#<portlet:namespace/>inputForm').find('#gioiTinh').val(data['gioiTinhId']);
		// $('#<portlet:namespace/>inputForm').find('#gioiTinh').attr('disabled','disabled');
		// $('#<portlet:namespace/>inputForm').find('#gioiTinh').addClass('readonly'); 
		 
		 $('#<portlet:namespace/>inputForm').find('#tonGiaoId').val(data['tonGiaoId']);
		// $('#<portlet:namespace/>inputForm').find('#tonGiaoId').attr('disabled','disabled');
		// $('#<portlet:namespace/>inputForm').find('#tonGiaoId').addClass('readonly');
		 
		 $('#<portlet:namespace/>inputForm').find('#danTocId').val(data['danTocId']);
		// $('#<portlet:namespace/>inputForm').find('#danTocId').attr('disabled','disabled');
		// $('#<portlet:namespace/>inputForm').find('#danTocId').addClass('readonly');
		 
		 $('#<portlet:namespace/>inputForm').find('#diaChiThuongTru').val(data['diaChiThuongTru']);
		// $('#<portlet:namespace/>inputForm').find('#diaChiThuongTru').attr('readonly','readonly');
		// $('#<portlet:namespace/>inputForm').find('#diaChiThuongTru').addClass('readonly');

		 if(Number(data['tinhId']) > 0) {
		  $('#<portlet:namespace/>inputForm').find('#diaChiThuongTruTinhId').val(data['tinhId']);
		//  $('#<portlet:namespace/>inputForm').find('#diaChiThuongTruTinhId').attr('disabled','disabled');
		  $('#<portlet:namespace/>inputForm').find('#diaChiThuongTruTinhId').attr('selected','selected');
		//  $('#<portlet:namespace/>inputForm').find('#diaChiThuongTruTinhId').addClass('readonly');
		
		 }
		 if(Number(data['huyenId']) > 0) {
		  	<portlet:namespace/>_get_dvhc_huyen(data['huyenId']);
		  	$('#<portlet:namespace/>inputForm').find('#diaChiThuongTruHuyenId').val(data['huyenId']);
		 // 	$('#<portlet:namespace/>inputForm').find('#diaChiThuongTruHuyenId').attr('disabled','disabled');
		  	$('#<portlet:namespace/>inputForm').find('#diaChiThuongTruHuyenId').attr('selected','selected');
		//  	$('#<portlet:namespace/>inputForm').find('#diaChiThuongTruHuyenId').addClass('readonly');
		
		 }
		 if(Number(data['xaId']) > 0) {
			<portlet:namespace/>_get_dvhc_xa(data['xaId']);
		  	$('#<portlet:namespace/>inputForm').find('#diaChiThuongTruXaId'). val(data['xaId']);
		 // 	$('#<portlet:namespace/>inputForm').find('#diaChiThuongTruXaId').attr('disabled','disabled');
		  	$('#<portlet:namespace/>inputForm').find('#diaChiThuongTruXaId').attr('selected','selected');
		//  	$('#<portlet:namespace/>inputForm').find('#diaChiThuongTruXaId').addClass('readonly');
	
		 }
		 //popup.close();
	}

		//---------------------------------------------
		function showPopup(url) {
			AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
				var dialog = new A.Dialog({
					stack: true,
					title: 'Tìm kiếm thông tin công dân',
					height:600,
					width:800,
					centered: true,
					draggable: true,
					destroyOnClose: true,
					modal: true,
					on: {
						close: function(evt){
							//$("#congDanCT").removeAttr("readonly");
							Liferay.Portlet.refresh(A.one('#p_p_id"+renderResponse.getNamespace()+"'));
						}
					}
				}).plug(A.Plugin.IO, {uri: url}).render(); 
				dialog.show(); 
			});
		}
				
		function <portlet:namespace/>_get_dvhc_huyen(id) {
			<portlet:namespace/>_clear_dvhc_huyen();		    
			$.post(listDVHC,{'DVHC_id' : id},function(data) {
				for(var key in data) {
					$('#<portlet:namespace/>inputForm').find('#diaChiThuongTruHuyenId')
						.append($("<option selected=\"selected\"></option>")
		                .attr("value",key)
		                .text(data[key]));
				}
			},'json');
		}
		
		
		function <portlet:namespace/>_get_dvhc_xa(id) {
			<portlet:namespace/>_clear_dvhc_xa();

			$.post(listDVHC,{'DVHC_id' : id},function(data) {
				for(var key in data) {
					$('#<portlet:namespace/>inputForm').find('#diaChiThuongTruXaId')
						.append($("<option selected=\"selected\"></option>")
		                .attr("value",key)
		                .text(data[key]));
				}
			},'json');
		}
		
		
		function <portlet:namespace/>_list_dvhc_huyen() {
			
			<portlet:namespace/>_clear_dvhc_huyen();

			<portlet:namespace/>_clear_dvhc_xa();
		    
			var dvhcTinhId = $('#<portlet:namespace/>inputForm').find('#diaChiThuongTruTinhId').val();
			$.ajax({
				url : listDVHC,
				type : 'post', 
				dataType : 'json',
				data : {
					'DVHC_chaId' : dvhcTinhId,
				},
				success : function(data) {
					for(var key in data) {
						$('#<portlet:namespace/>inputForm').find('#diaChiThuongTruHuyenId')
							.append($("<option></option>")
		                    .attr("value",key)
		                    .text(data[key]));
					}
				},
				error : function(xhr, ajaxOptions, thrownError) {
				}
			});
		}

		
		function <portlet:namespace/>_clear_dvhc_huyen() {
			$('#<portlet:namespace/>inputForm').find('#diaChiThuongTruHuyenId option').remove();
			$('#<portlet:namespace/>inputForm').find('#diaChiThuongTruHuyenId')
						.append($("<option></option>")
						.attr("value",'0')
		                .text('---Chọn huyện-'));
		}
		function <portlet:namespace/>_list_dvhc_xa() {
			
			<portlet:namespace/>_clear_dvhc_xa();
		    
			var dvhcHuyenId = $('#<portlet:namespace/>inputForm').find('#diaChiThuongTruHuyenId').val();
			$.ajax({
				url : listDVHC,
				type : 'post', 
				dataType : 'json',
				data : {
					'DVHC_chaId' : dvhcHuyenId,
				},
				success : function(data) {
					for(var key in data) {
						$('#<portlet:namespace/>inputForm').find('#diaChiThuongTruXaId')
							.append($("<option></option>")
		                    .attr("value",key)
		                    .text(data[key]));
					}
				},
				error : function(xhr, ajaxOptions, thrownError) {
				}
			});
		}
		
		function <portlet:namespace/>_clear_dvhc_xa() {
			$('#<portlet:namespace/>inputForm').find('#diaChiThuongTruXaId option').remove();
			$('#<portlet:namespace/>inputForm').find('#diaChiThuongTruXaId')
						.append($("<option></option>")
						.attr("value",'0')
		                .text('--Chọn xã--'));
		}
		
	$(document).ready(function(){
		
		this.document.<portlet:namespace/>inputForm.email.focus();
		
		$("#isLoaded").val('load');
		
		if(form_action == '<%=TaoCongDanBusiness.VIEW_CONGDAN%>') {
			$('#<portlet:namespace/>inputForm input').each(function() {
				   $(this).attr('disabled','disabled'); 
				   $(this).addClass('readonly');
				   if ($(this).attr('type') == 'button' || $(this).attr('type') == 'BUTTON') {
					   $(this).attr('style','display:none');  
				   } 
			});
			$('#<portlet:namespace/>inputForm select').each(function() {
			  	   $(this).attr('disabled','disabled');  
			  	   $(this).addClass('readonly');
			});
			$('#<portlet:namespace/>inputForm a').each(function() {
			  	   $(this).attr('style','display:none');  
			});
			$('#<portlet:namespace/>inputForm textarea').each(function() {
				  $(this).attr('disabled','disabled');
				  $(this).addClass('readonly'); 
			});
			// Enable link back
			$("#linkBackToList").removeAttr('style');
			$("#buttonBackToList").removeAttr('style');
			$("#buttonBackToList").removeAttr('disabled');
			$("#buttonBackToList").removeClass('readonly');
		}		
		
	});	


 </script>