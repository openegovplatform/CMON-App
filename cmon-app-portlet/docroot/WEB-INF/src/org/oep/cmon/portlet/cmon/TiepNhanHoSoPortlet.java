/*
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
 */

package org.oep.cmon.portlet.cmon;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;

import org.apache.commons.lang.StringUtils;
import org.oep.cmon.Constants;
import org.oep.cmon.dao.beans.cauhinhlienthong.CauHinhLienThong;
import org.oep.cmon.portlet.hosolienthong.HSLTBusinessUtil;
import org.oep.cmon.portlet.hosolienthong.HSLTFields;
import org.oep.cmon.portlet.hosotructiep.HoSoFields;
import org.oep.cmon.portlet.ipmslist.business.FormOfflineBusiness;
import org.oep.cmon.util.EgovUtil;
import org.oep.egovcore.portlet.AjaxResponse;
import org.oep.egovcore.util.DateTimeUtil;
import org.oep.egovcore.util.Helper;
import org.oep.egovcore.util.NgayNghiVNUtil;
import org.oep.egovcore.util.StringPool;
import org.oep.egovcore.validate.Validator;
import org.oep.egovcore.validate.term.file.FileExtension;
import org.oep.egovcore.validate.term.file.IsUploaded;
import org.oep.egovcore.validate.term.file.MaxFileSize;
import org.oep.sharedservice.cmon.provider.officer.IOfficerService;
import org.oep.sharedservice.cmon.provider.officer.OfficerServiceImpl;
import org.oep.sharedservice.cmon.provider.officer.soap.GiayToDinhKem;

import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.FileDinhKem;
import org.oep.cmon.dao.hosohcc.model.FileDinhKemClp;
import org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil;
import org.oep.cmon.dao.tlct.model.DanhMucGiayTo;
import org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * This is abstract class TiepNhanHoSoPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public abstract class TiepNhanHoSoPortlet extends CanBoPortlet {
	
	public abstract void serveThongTinHoSoThuTuc(ResourceRequest request, AjaxResponse ajaxResponse) throws Exception;
	
	/**
	 * This is  function return NgayHenTra
	 * 
	 * @TODO Tra ve ngay hen tra ket qua xu ly ho so
	 * 		- Tu dong tru cac ngay nghi le quy dinh va thu 7, chu nhat
	 * 		- Neu la ho so dau tien trong chuoi~ lien thong 
	 * 			thi cong don` ca? so ngay` xu ly du kien' cua cac co quan se tiep' nhan. lien thong 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ajaxResponse
	 * @throws Exception
	 * @response
	 * 		{
	 * 			ngayHenTraHoSo : String (dd/MM/yyyy)
	 * 		,	soNgayXuLy : int
	 * 		,	laTiepNhanKhoiTaoLienThong : boolean
	 * 		,	dsTenCoQuanLienThong : String[] // Ten co quan trong chuoi lien thong (da duoc sap xep truoc sau)
	 * 		}
	 */
	public void serveNgayHenTra(ResourceRequest request, AjaxResponse ajaxResponse) throws Exception {
		
		long thuTucId = ParamUtil.getLong(request, HoSoFields.thuTucHanhChinhId);
		int soNgayXuLy = ParamUtil.getInteger(request, HoSoFields.soNgayXuLy);
		boolean laTiepNhanKhoiTaoLienThong = false;
		JSONArray dsTenCoQuanLienThong = JSONFactoryUtil.createJSONArray();
		
		ThuTucHanhChinh thuTuc = ThuTucHanhChinhLocalServiceUtil.fetchThuTucHanhChinh(thuTucId);
		if (HSLTBusinessUtil.laThuTucKhoiTaoLienThong(thuTuc)) {
			laTiepNhanKhoiTaoLienThong = true;
			List<CauHinhLienThong> dsCauHinhLienThongTiepTheo =
				HSLTBusinessUtil.getDSCauHinhLienThongTiepTheo(
					thuTucId, EgovUtil.getCongChucDaDangNhap(request).getCoQuanQuanLyId());
			
			for (CauHinhLienThong cauHinhLienThong : dsCauHinhLienThongTiepTheo) {
				soNgayXuLy += cauHinhLienThong.getSoNgayXy();
				dsTenCoQuanLienThong.put(cauHinhLienThong.getTenCoQuan());
			}
		}
		
		Date ngayKetThucCongViec = NgayNghiVNUtil.getNgayKetThucCongViec(
			DateTimeUtil.getRequestDate(request, HoSoFields.ngayNhanHoSo),
			soNgayXuLy
		);
		
		ajaxResponse
			.send( HoSoFields.ngayHenTraHoSo, DateTimeUtil.getDayMonthYear(ngayKetThucCongViec) )
			.send( HoSoFields.soNgayXuLy, soNgayXuLy )
			.send( HSLTFields.laTiepNhanKhoiTaoLienThong, laTiepNhanKhoiTaoLienThong )
			.send( HSLTFields.dsTenCoQuanLienThong, dsTenCoQuanLienThong )
		;
	}
	
	/**
	 * This is  function validate upload
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param validator
	 * @throws SystemException
	 */
	protected void _validateUpload(
		UploadPortletRequest request, Validator validator) throws SystemException
	{
		long[] tt2gtIds = ParamUtil.getLongValues(request, HoSoFields.thuTuc2GiayToId),
			lgtIds = ParamUtil.getLongValues(request, HoSoFields.loaiGiayToId);
		File[] files = request.getFiles(HoSoFields.fileGiayToQuyDinh);
		
		File file;
		String extension, tenGiayTo;
		long maxByte;
		
		FileExtension dinhDangFile = new FileExtension();
		MaxFileSize dungTuongToiDa = new MaxFileSize();
		DanhMucGiayTo loaiGiayTo;
		dinhDangFile.setRequired(false);
		dungTuongToiDa.setRequired(false);
		
		for (int i = 0; i < tt2gtIds.length; ++ i) {
			loaiGiayTo = DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(Helper.numberFromArray(lgtIds, i));
			if (loaiGiayTo != null) {
				extension = loaiGiayTo.getKieuTaiLieu();
				maxByte = loaiGiayTo.getGioiHanDungLuong();
				tenGiayTo = loaiGiayTo.getTen();
				file = Helper.fileFromArray(files, i);
				
				if ( !extension.trim().isEmpty() ) {
					dinhDangFile.setExtensions( StringUtils.split(extension, StringPool.COMMA) );
				}
				
				if ( !dinhDangFile.isValid(file) ) {
					validator.putMessage(
						HoSoFields.fileGiayToQuyDinh + i,
						dinhDangFile.message(tenGiayTo),
						null
					);
				}
				
				dungTuongToiDa.setMaxByte(maxByte);
				if (!dungTuongToiDa.isValid(file)) {
					validator.putMessage(
						HoSoFields.fileGiayToQuyDinh + i,
						dungTuongToiDa.message(tenGiayTo),
						null
					);
				}
			}
		}
	}
	
	/**
	 * This is  function upload file
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param hoSoId
	 * @param trangThaiHoSo
	 * @param maUngDung
	 * @throws SystemException
	 * @throws IOException
	 * @throws PortalException
	 */
	protected void _upload(
		UploadPortletRequest request,
		long hoSoId,
		int trangThaiHoSo,
		String maUngDung
	) throws SystemException, IOException, PortalException {

		String email = PortalUtil.getUser(request).getEmailAddress();
		Date now = DateTimeUtil.getDateTimeNow();
		long 
			canBoTiepNhanId = ParamUtil.getLong(request, HoSoFields.canBoTiepNhanId),
			liferayUserId = PortalUtil.getUserId(request),
			fileDinhKemId = 0L,
			noiLuuTruId = 0L
		;
		File[] files = request.getFiles(HoSoFields.fileGiayToQuyDinh);
		File fileToUpload = null;
		String[] tenGiayTos = ParamUtil.getParameterValues(request, HoSoFields.tenGiayToQuyDinh);
		String tenGiayTo;
		long[] 
			loaiGiayToIds = ParamUtil.getLongValues(request, HoSoFields.loaiGiayToId),
			tt2gtIds = ParamUtil.getLongValues(request, HoSoFields.thuTuc2GiayToId),
			fileDinhKemIds = ParamUtil.getLongValues(request, HoSoFields.fileDinhKemId),
			laBanChinhs = ParamUtil.getLongValues(request, HoSoFields.banChinhGiayToQuyDinh);
		int[] daNhans = ParamUtil.getIntegerValues(request, HoSoFields.daNhan);
		FileDinhKem fileDinhKem = null;
		IOfficerService service = new OfficerServiceImpl();
		IsUploaded uploadValidator = new IsUploaded();
		boolean

		// Da check vao checkbox "Da nhan"
			daNhan

		// 	La lan` dau` tien nhan thanh` phan` ho` so
		,	laLanDauTienNhanThanhPhanHoSo

		// Da upload file
		,	daUploadFile
		;

		long thuTuc2GiayToId;

		for (int i = 0; i < tt2gtIds.length; ++ i) {
			fileToUpload = Helper.fileFromArray(files, i);
			fileDinhKemId = Helper.numberFromArray(fileDinhKemIds, i);
			daNhan = Helper.inArray(daNhans, i);
			laLanDauTienNhanThanhPhanHoSo = ( (fileDinhKemId == 0L) && daNhan );
			daUploadFile = uploadValidator.isValid(fileToUpload);
			thuTuc2GiayToId = tt2gtIds[i];
			tenGiayTo = Helper.stringFromArray(tenGiayTos, i);
			
			if (laLanDauTienNhanThanhPhanHoSo) {
				
				fileDinhKem = new FileDinhKemClp();
				fileDinhKem.setId(CounterLocalServiceUtil.increment(FormOfflineBusiness.FILE_UPLOAD_SEQUENCE));
				fileDinhKem.setSoBanGiay(1);
				fileDinhKem.setBanChinh(Helper.inArray(laBanChinhs, i) ? 1L : 0L);
				fileDinhKem.setDaDoiChieu(1);
				fileDinhKem.setCanBoId(canBoTiepNhanId);
				fileDinhKem.setDanhMucGiayToId(Helper.numberFromArray(loaiGiayToIds, i));
				fileDinhKem.setThuTuc2GiayToId(thuTuc2GiayToId);
				fileDinhKem.setHoSoTTHCCongId(hoSoId);
				fileDinhKem.setTrangThaiHoSoTaiThoiDiemDinhKem(trangThaiHoSo);
				fileDinhKem.setNgayUpload(now);
				fileDinhKem.setNguoiUpload(email);
				fileDinhKem.setXoa(Constants.ACTIVE);
				fileDinhKem.setNguoiSua(email);
				fileDinhKem.setNgaySua(now);
				
				// Da upload file thi setNoiLuuTruTaiLieu
				if (daUploadFile) {

					noiLuuTruId = _callWebServiceUploadAndGetNoiLuuTruId(
						service,
						fileToUpload,
						maUngDung,
						hoSoId,
						liferayUserId,
						tenGiayTo
					);

					fileDinhKem.setNoiLuuTruTaiLieuId(noiLuuTruId);
				}

				FileDinhKemLocalServiceUtil.addFileDinhKem(fileDinhKem);

			} else {

				// Neu uncheck da nhan thi xoa record FileDinhKem tuong ung va cac version cua no'
				// Ve nghiep vu thi co nghia la can bo chua nhan tai lieu nay
				if ( !daNhan ) {
					List<FileDinhKem> list =
						FileDinhKemLocalServiceUtil.getDSGiayToByHoSoAndThuTuc2GiayTo(hoSoId, thuTuc2GiayToId);
					for (FileDinhKem toBeDeleted : list) {
						toBeDeleted.setXoa(Constants.INACTIVE);
						toBeDeleted.setNgaySua(now);
						toBeDeleted.setNguoiSua(email);
						FileDinhKemLocalServiceUtil.updateFileDinhKem(toBeDeleted);
					}
				} else {

					fileDinhKem = FileDinhKemLocalServiceUtil.fetchFileDinhKem(fileDinhKemId);
					
					// Truong hop da upload file luc tiep nhan va khi bo sung van~ upload file tiep'
					// thi se tao moi record, ko ghi de`, de? giu~ lai version file da~ upload tu` truoc'
					if ( (fileDinhKem.getNoiLuuTruTaiLieuId() != null) && daUploadFile ) {
						fileDinhKem = new FileDinhKemClp();
						fileDinhKem.setId(CounterLocalServiceUtil.increment(FormOfflineBusiness.FILE_UPLOAD_SEQUENCE));
						fileDinhKem.setSoBanGiay(1);
						fileDinhKem.setDaDoiChieu(1);
						fileDinhKem.setCanBoId(canBoTiepNhanId);
						fileDinhKem.setDanhMucGiayToId(Helper.numberFromArray(loaiGiayToIds, i));
						fileDinhKem.setThuTuc2GiayToId(thuTuc2GiayToId);
						fileDinhKem.setHoSoTTHCCongId(hoSoId);
						fileDinhKem.setTrangThaiHoSoTaiThoiDiemDinhKem(trangThaiHoSo);
						fileDinhKem.setXoa(Constants.ACTIVE);
					}
					
					if ( daUploadFile ) {
						noiLuuTruId = _callWebServiceUploadAndGetNoiLuuTruId(
							service,
							fileToUpload,
							maUngDung,
							hoSoId,
							liferayUserId,
							tenGiayTo
						);
						
						fileDinhKem.setNoiLuuTruTaiLieuId(noiLuuTruId);
					}
					
					fileDinhKem.setBanChinh(Helper.inArray(laBanChinhs, i) ? 1L : 0L);
					fileDinhKem.setNguoiSua(email);
					fileDinhKem.setNgaySua(now);
					fileDinhKem.setNguoiUpload(email);
					fileDinhKem.setNgayUpload(now);
					FileDinhKemLocalServiceUtil.updateFileDinhKem(fileDinhKem);
				}
			}
		}
	}

	/**
	 * This is  function call WebService upload and get NoiLuuTru
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param service     
	 * @param fileToUpload
	 * @param maUngDung
	 * @param hoSoId
	 * @param liferayUserId
	 * @param tenGiayTo
	 * @throws IOException
	 * @throws SystemException
	 */
	private long _callWebServiceUploadAndGetNoiLuuTruId(
		IOfficerService service,
		File fileToUpload,
		String maUngDung,
		long hoSoId,
		long liferayUserId,
		String tenGiayTo
	) throws IOException, SystemException {

		GiayToDinhKem result = service.upload(
			maUngDung, 
			0,
			hoSoId,
			liferayUserId,
			tenGiayTo,
			tenGiayTo,
			FileUtil.getBytes(fileToUpload),
			fileToUpload.getName()
		);

		if (result == null || !result.isResult()) {
			throw new SystemException(
					"LOI KHI GOI WEB SERVICE UPLOAD FILE"
				+	"<br>MA LOI:"  + result.getCode()
				+	"<br>_____UPLOAD PARAMETERS_____"
				+	"<br>maUngDung:" + maUngDung
				+	"<br>type:" + 0
				+	"<br>hoSoId:" + hoSoId
				+	"<br>liferayUserId:" + liferayUserId
				+	"<br>tenGiayTo:" + tenGiayTo
				+	"<br>Byte length:" + FileUtil.getBytes(fileToUpload).length
				+	"<br>File name:" + fileToUpload.getName()
			);
		}

		return result.getId();
	}
}
