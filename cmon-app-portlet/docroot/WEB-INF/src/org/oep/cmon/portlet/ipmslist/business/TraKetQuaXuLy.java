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

package org.oep.cmon.portlet.ipmslist.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.servlet.http.HttpServletRequest;

import org.oep.cmon.Constants;
import org.oep.cmon.portlet.ipmslist.utils.ConvertUtil;
import org.oep.egovcore.util.DateTimeUtil;

import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo;
import org.oep.cmon.dao.dvc.service.ThuTuc2GiayToLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.FileDinhKem;
import org.oep.cmon.dao.hosohcc.model.FileDinhKemClp;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil;
import org.oep.cmon.dao.tlct.model.DanhMucGiayTo;
import org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

/**
 * This is class TraKetQuaXuLy
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class TraKetQuaXuLy {

	private HoSoTTHCCong _hoso;
	private List<DanhMucGiayTo> _giaytoketqua;// Store list giay to tra lai
	private List<DanhMucGiayTo> _giaytonopbangchinh;// Store list giay to nop
													// voi ho so
	private List<Boolean> _istraketqua;
	private List<Boolean> _istragiayto;
	private List<Integer> _numbertraketqua;
	private User _canbologin;
	private long[] _checkTraKetQuaPost;
	private long[] _checkDonPost;
	private int[] _sobangPost;
	private ActionRequest _request;
	private String _tinhId = "31";
	private String _huyenId = "0";

	private CongDan congDanNop;
	
	/**
	 * This is contructor
	 * Called when load jsp page
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @throws SystemException
	 * @throws PortalException
	 */
	public TraKetQuaXuLy(HttpServletRequest request) throws PortalException,
			SystemException {
		try {
			long hosoid = Long.valueOf(request.getParameter("HosotthcCongId"))
					.longValue();
			_hoso = HoSoTTHCCongLocalServiceUtil.getHoSoTTHCCong(hosoid);

			_giaytoketqua = DanhMucGiayToLocalServiceUtil
					.findGiayToKetQua(_hoso.getThuTucHanhChinhId().longValue());

			_giaytonopbangchinh = DanhMucGiayToLocalServiceUtil
					.finlistGiayToBCNopDon(hosoid);
			
			congDanNop = CongDanLocalServiceUtil.fetchCongDan(_hoso.getCongDanNopId());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (_giaytoketqua != null) {
			if (_giaytoketqua.size() > 0) {

				_istraketqua = new ArrayList<Boolean>();

				for (int i = 0; i < _giaytoketqua.size(); i++) {
					_istraketqua.add(false);
				}

				_numbertraketqua = new ArrayList<Integer>();

				for (int i = 0; i < _giaytoketqua.size(); i++) {
					_numbertraketqua.add(1);
				}
			}
		}

		if (_giaytonopbangchinh != null) {
			if (_giaytonopbangchinh.size() > 0) {
				_istragiayto = new ArrayList<Boolean>();

				for (int i = 0; i < _giaytonopbangchinh.size(); i++) {
					_istragiayto.add(false);
				}
			}
		}

		if (Validator.isNotNull(PortalUtil.getUser(request)))
			_canbologin = PortalUtil.getUser(request);

	}

	/**
	 * This is contructor
	 * Call on Controller when form is post
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param ok
	 * @throws SystemException
	 * @throws PortalException
	 * @throws NumberFormatException
	 */
	public TraKetQuaXuLy(ActionRequest request, boolean ok)
			throws NumberFormatException, PortalException, SystemException {

		this._request = request;
		try {
			_hoso = HoSoTTHCCUtil.getHoSo(request);

			_giaytoketqua = DanhMucGiayToLocalServiceUtil
					.findGiayToKetQua(_hoso.getThuTucHanhChinhId().longValue());

			_giaytonopbangchinh = DanhMucGiayToLocalServiceUtil
					.finlistGiayToBCNopDon(_hoso.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (_giaytoketqua != null) {
			if (_giaytoketqua.size() > 0) {

				_istraketqua = new ArrayList<Boolean>();

				for (int i = 0; i < _giaytoketqua.size(); i++) {
					_istraketqua.add(false);
				}

				_numbertraketqua = new ArrayList<Integer>();

				for (int i = 0; i < _giaytoketqua.size(); i++) {
					_numbertraketqua.add(1);
				}
			}
		}

		if (_giaytonopbangchinh != null) {
			if (_giaytonopbangchinh.size() > 0) {
				_istragiayto = new ArrayList<Boolean>();

				for (int i = 0; i < _giaytonopbangchinh.size(); i++) {
					_istragiayto.add(false);
				}
			}
		}
		long[] checkTraKetQuaPost = ParamUtil.getLongValues(request,
				"checkGTKQ");

		long[] checkGTNopPost = ParamUtil.getLongValues(request, "checkGTNop");

		int[] sobanPost = ParamUtil.getIntegerValues(request, "soban");

		_checkTraKetQuaPost = checkTraKetQuaPost;
		_checkDonPost = checkGTNopPost;
		_sobangPost = sobanPost;

		List<Integer> listIndexCheckTrakq = getIndexCheckKetQua();
		setListCheckKq(listIndexCheckTrakq);

		List<Integer> listIndexCheckGTNop = getIndexCheckGTNop();
		setListCheckGTNop(listIndexCheckGTNop);

		setSoBangPost(sobanPost);

		if (Validator.isNotNull(PortalUtil.getUser(request)))
			_canbologin = PortalUtil.getUser(request);

		// set value for tinh,huyen when post data
		_tinhId = ParamUtil.getString(request, "tinhId");
		_huyenId = ParamUtil.getString(request, "huyenId");

	}

	public HoSoTTHCCong getHoSo() {
		return this._hoso;
	}

	public List<DanhMucGiayTo> getGiayToKetQua() {
		return this._giaytoketqua;
	}

	public List<DanhMucGiayTo> getGiayToBCNop() {
		return this._giaytonopbangchinh;
	}

	public List<Boolean> getCheckTraKetQua() {
		return this._istraketqua;
	}

	public List<Boolean> getCheckTraGiayTo() {
		return this._istragiayto;
	}

	public List<Integer> getNumberGiayToTra() {
		return this._numbertraketqua;
	}

	/**
	 * This is function getMaSoHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return String
	 */
	public String getMaSoHoSo() {
		if (Validator.isNotNull(_hoso))
			return _hoso.getMaSoHoSo();
		else
			return "";
	}

	/**
	 * This is function getMaSoBienNhan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return String
	 */
	public String getMaSoBienNhan() {
		if (Validator.isNotNull(_hoso)) {
			if (_hoso.getMaSoBienNhan() != null) {
				return _hoso.getMaSoBienNhan();
			}
		}

		return "";
	}

	/**
	 * This is function getNameCanBoTraKQ
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return String
	 */
	public String getNameCanBoTraKQ() {

		if (Validator.isNotNull(_canbologin))
			return _canbologin.getFullName();
		else
			return "";
	}

	/**
	 * This is function getNgayTraKQ
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return String
	 */
	public String getNgayTraKQ() {

		if (Validator.isNull(_hoso.getNgayTraKetQua()))
			return ConvertUtil.parseDateToTring(new Date());
		else
			return ConvertUtil.parseDateToTring(_hoso.getNgayTraKetQua());
	}

	/**
	 * This is function getIdHoSoTTHCC
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return String
	 */
	public String getIdHoSoTTHCC() {

		if (Validator.isNotNull(_hoso))
			return String.valueOf(_hoso.getId());
		else
			return "";
	}

	/**
	 * This is function getIndexCheckKetQua
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return List<Integer>
	 */	
	public List<Integer> getIndexCheckKetQua() {

		List<Integer> listIndexCheck = new ArrayList<Integer>();

		for (int i = 0; i < _giaytoketqua.size(); i++) {
			for (int j = 0; j < _checkTraKetQuaPost.length; j++) {
				if (_giaytoketqua.get(i).getId() == _checkTraKetQuaPost[j]) {
					listIndexCheck.add(i);
				}
			}
		}

		return listIndexCheck;
	}

	/**
	 * This is function getIndexCheckGTNop
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return List<Integer>
	 */
	public List<Integer> getIndexCheckGTNop() {

		List<Integer> listIndexCheck = new ArrayList<Integer>();

		for (int i = 0; i < _giaytonopbangchinh.size(); i++) {
			for (int j = 0; j < _checkDonPost.length; j++) {
				if (_giaytonopbangchinh.get(i).getId() == _checkDonPost[j]) {
					listIndexCheck.add(i);
				}
			}
		}

		return listIndexCheck;
	}

	/**
	 * This is function setListCheckKq
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param list
	 */
	public void setListCheckKq(List<Integer> list) {
		if (list != null) {
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					_istraketqua.set(list.get(i).intValue(), Boolean.TRUE);
				}
			}
		}
	}

	/**
	 * This is function setListCheckGTNop
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param list
	 */
	public void setListCheckGTNop(List<Integer> list) {
		if (list != null) {
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					_istragiayto.set(list.get(i).intValue(), Boolean.TRUE);
				}
			}
		}
	}

	/**
	 * This is function setSoBangPost
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @throws sobangpost
	 */
	public void setSoBangPost(int[] sobangpost) {
		for (int k = 0; k < sobangpost.length; k++) {
			_numbertraketqua.set(k, sobangpost[k]);
		}
	}

	/**
	 * This is function saveTraKetQua
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void saveTraKetQua() throws SystemException, PortalException {
		_hoso.setNgaySua(new Date());
		HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(_hoso);
		saveGiayToNop();
		saveGiayToTra();
	}

	/**
	 * This is function saveGiayToTra
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 *  @throws SystemException
	 *  @throws PortalException
	 */
	public void saveGiayToTra() throws SystemException, PortalException {

		List<Integer> listIndex = getIndexCheckKetQua();//getIndexCheckGTNop();

		if (_checkTraKetQuaPost != null) {
			if (_checkTraKetQuaPost.length > 0) {

				for (int i = 0; i < _checkTraKetQuaPost.length; i++) {

					long iDFileGiayToNop = CounterLocalServiceUtil
							.increment(FileDinhKem.class.getName());
					FileDinhKem fileDinhKem = new FileDinhKemClp();

					fileDinhKem.setId(iDFileGiayToNop);
					
					int soBanGiay = 1, index;
					if (listIndex.size() > i) {
						index = listIndex.get(i).intValue();
						if (_sobangPost.length > index) {
							soBanGiay = _sobangPost[index];
						}
					}
					
					fileDinhKem.setSoBanGiay(soBanGiay);

					fileDinhKem
							.setTrangThaiHoSoTaiThoiDiemDinhKem(Constants.TRANGTHAIHOSO.STATUS_HOSO_DA_TRA_KET_QUA);
					fileDinhKem.setHoSoTTHCCongId(_hoso.getId());

					if (PortalUtil.getUser(_request) != null)
						fileDinhKem.setCanBoId(Long.valueOf(PortalUtil
								.getUserId(_request)));

					fileDinhKem.setDanhMucGiayToId(Long
							.valueOf(_checkTraKetQuaPost[i]));
					
					fileDinhKem
							.setDaTra(Constants.TRANGTHAIHOSO.DA_TRA_KET_QUA);
					//fileDinhKem.setBanChinh(Constants.TRANGTHAIHOSO.BANG_CHINH);
					
					Long idThuTuc2GiayTo =Long.valueOf(ThuTuc2GiayToLocalServiceUtil.getDSTT2GiayTo(_hoso.getThuTucHanhChinhId(), Long
							.valueOf(_checkTraKetQuaPost[i]), Constants.PHASE_PROCESS_HOSO.PHASE_BA).get(0).getId());
					
					FileDinhKem fileKetQuaUpload = FileDinhKemLocalServiceUtil.findMaxFileDinhKemByHoSoTTHCCongIdAndTT2GTId(_hoso.getId(), idThuTuc2GiayTo, _checkTraKetQuaPost[i]);
					
					if(Validator.isNotNull(fileKetQuaUpload))
					{
					  	fileDinhKem.setNoiLuuTruTaiLieuId(fileKetQuaUpload.getNoiLuuTruTaiLieuId());
					}
						
					
					fileDinhKem.setThuTuc2GiayToId(idThuTuc2GiayTo);
					 
					if (PortalUtil.getUser(_request) != null) {
						fileDinhKem.setNguoiUpload(PortalUtil.getUser(_request)
								.getFullName());
					}
						
					fileDinhKem.setNgayUpload(new Date());
					
					try {
						FileDinhKemLocalServiceUtil
								.updateFileDinhKem(fileDinhKem);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * This is function saveGiayToNop
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 *  @throws SystemException
	 *  @throws PortalException
	 */
	public void saveGiayToNop() throws SystemException, PortalException {
		if (_checkDonPost != null) {
			if (_checkDonPost.length > 0) {

				for (int i = 0; i < _checkDonPost.length; i++) {

					long iDFileGiayToNop = CounterLocalServiceUtil
							.increment(FileDinhKem.class.getName());
					FileDinhKem fileDinhKem = new FileDinhKemClp();

					fileDinhKem.setId(iDFileGiayToNop);
					fileDinhKem.setSoBanGiay(1L);
					fileDinhKem
							.setTrangThaiHoSoTaiThoiDiemDinhKem(Constants.TRANGTHAIHOSO.STATUS_HOSO_DA_TRA_KET_QUA);
					fileDinhKem.setHoSoTTHCCongId(_hoso.getId());

					if (PortalUtil.getUser(_request) != null) {
						fileDinhKem.setCanBoId(Long.valueOf(PortalUtil
								.getUserId(_request)));
					}

					fileDinhKem.setDanhMucGiayToId(Long
							.valueOf(_checkDonPost[i]));
					fileDinhKem
							.setDaTra(Constants.TRANGTHAIHOSO.DA_TRA_KET_QUA);
					fileDinhKem.setBanChinh(Constants.TRANGTHAIHOSO.BANG_CHINH);
					
					if (PortalUtil.getUser(_request) != null) {
						fileDinhKem.setNguoiUpload(PortalUtil.getUser(_request)
								.getFullName());
					}
						
					fileDinhKem.setNgayUpload(new Date());
					
					List<ThuTuc2GiayTo> list = ThuTuc2GiayToLocalServiceUtil.getDSTT2GiayTo(
						_hoso.getThuTucHanhChinhId(),
						Long.valueOf(_checkTraKetQuaPost[i]),
						Constants.PHASE_PROCESS_HOSO.PHASE_HAI
					);
					
					if ( !list.isEmpty() ) {
						fileDinhKem.setThuTuc2GiayToId( list.get(0).getId() );
					}
					
					try {
						FileDinhKemLocalServiceUtil
								.updateFileDinhKem(fileDinhKem);
					} catch (Exception e) {
					}
				}
			}
		}
	}

	/**
	 * This is function isNumber
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 *  @param stringPhone
	 *  @return boolean
	 */
	public boolean isNumber(String stringPhone) {
		char[] charPhone = null;
		if (stringPhone.trim().isEmpty()) {
			return false;
		} else {
			charPhone = stringPhone.toCharArray();
			for (char ch : charPhone) {
				if (Validator.isChar(ch)) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * This is function validTraKetQua
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 *  @param request
	 *  @return boolean
	 */
	public boolean validTraKetQua(ActionRequest request) {
		boolean result = true;

		String email = request.getParameter("email");
		String nguoinhanketqua = request.getParameter("nguoinhanketqua");
		String ngaysinh = request.getParameter("ngaysinh");
		String diachi = request.getParameter("diachi");
		String tinhId = request.getParameter("tinhId");
		String huyenId = request.getParameter("huyenId");
		// String xaId = request.getParameter("xaId");
		String nguoitra = request.getParameter("nguoitra");
		String dienthoaididong = request.getParameter("dienthoaididong");

		if (!email.isEmpty()) {
			if (!Validator.isEmailAddress(email)) {
				result = false;
				SessionErrors.add(request, "email");
			}
			if (email.length() > 50) {
				if (!Validator.isEmailAddress(email)) {
					result = false;
					SessionErrors.add(request, "emailLon");
				}
			}

		}

		if (!dienthoaididong.trim().isEmpty()) {
			if (!isNumber(dienthoaididong)) {
				result = false;
				SessionErrors.add(request, "dienthoaididong");
			}
		}

		if (nguoinhanketqua.trim().isEmpty()) {
			result = false;
			SessionErrors.add(request, "nguoinhanketqua");
		}
		if (ngaysinh.trim().isEmpty()) {
			result = false;
			SessionErrors.add(request, "ngaysinh");
		}
		if (diachi.isEmpty()) {
			result = false;
			SessionErrors.add(request, "diachi");
		}
		if (tinhId.matches(Constants.NUMBER_CONSTANT.VALUE_KHONG)) {
			result = false;
			SessionErrors.add(request, "tinhId");
		}
		if (huyenId.matches(Constants.NUMBER_CONSTANT.VALUE_KHONG)) {
			result = false;
			SessionErrors.add(request, "huyenId");
		}

		if (nguoitra.isEmpty()) {
			result = false;
			SessionErrors.add(request, "nguoitra");
		}

		return result;
	}

	/**
	 * This is function getNguoiNhanKq
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 *  @return String
	 */
	public String getNguoiNhanKq() {
		if (_hoso != null) {
			if (_hoso.getHoTenNguoiNhanKetQua() != null && 
					_hoso.getHoTenNguoiNhanKetQua().length() > 0) {
				return _hoso.getHoTenNguoiNhanKetQua();
				
/*			} else {
				return congDanNop.getTenDayDu();*/
			}
				
		}

		return "";
	}

	/**
	 * This is function getEmail
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 *  @return String
	 */
	public String getEmail() {
		if (_hoso != null) {
			if (_hoso.getEMailNguoiNhan() != null && 
					_hoso.getEMailNguoiNhan().length() > 0)
				return _hoso.getEMailNguoiNhan();
			
/*		} else {
			return congDanNop.getEmail();*/
		}
		
		return "";
	}

	/**
	 * This is function getNgaySinh
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return String
	 */
	public String getNgaySinh() {
		if (_hoso != null) {
			if (_hoso.getNgaySinhNguoiNhan() != null)
				return ConvertUtil.parseDateToTring(_hoso
						.getNgaySinhNguoiNhan());
			
/*			else 
				return ConvertUtil.parseDateToTring(congDanNop.getNgaySinh());*/
		}
		return "";
	}
	
	/**
	 * This is function getDienThoaiDiDong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return String
	 */
	public String getDienThoaiDiDong() {
		if (_hoso != null) {
			if (_hoso.getSoDienThoaiNguoiNhan() != null && 
					_hoso.getSoDienThoaiNguoiNhan().length() > 0)
				return _hoso.getSoDienThoaiNguoiNhan();
			
	/*		else 
				return congDanNop.getDienThoaiDiDong();*/
		}

		return "";
	}

	/**
	 * This is function getCmnd
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return String
	 */
	public String getCmnd() {
		if (_hoso != null) {
			if (_hoso.getCmndNguoiNhan() != null && 
					_hoso.getCmndNguoiNhan().length() > 0)
				return _hoso.getCmndNguoiNhan();
			
//			else 
//				return congDanNop.getSoCmnd();
		}

		return "";
	}

	/**
	 * This is function getDienThoaiCodinh
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return String
	 */
	public String getDienThoaiCodinh() {
		if (_hoso != null) {
			if (_hoso.getDienThoiCoDinhNguoiNhan() != null && _hoso.getDienThoiCoDinhNguoiNhan().length() > 0)
				return _hoso.getDienThoiCoDinhNguoiNhan();
			
//			else
//				return congDanNop.getDienThoaiCoDinh();
		}

		return "";
	}

	/**
	 * This is function getGioiTinh
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return int
	 */
	public int getGioiTinh() {
		if (_hoso != null) 
			return _hoso.getGioiTinh();
//		else 
//			return congDanNop.getGioiTinh();
		return 1;
	}

	/**
	 * This is function getDiaChi
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return String
	 */
	public String getDiaChi() {

		if (_hoso != null) {
			if (_hoso.getDiaChiThuongTruNguoiNhanKQ() != null && 
					_hoso.getDiaChiThuongTruNguoiNhanKQ().length() > 0)
				return _hoso.getDiaChiThuongTruNguoiNhanKQ();
//			
//			else 
//				return congDanNop.getDiaChiThuongTru();
		}

		return "";
	}

	/**
	 * This is function getGioTra
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return String
	 */
	public String getGioTra() {
		String strDateFormat = "HH:mm:ss a";
		SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);

		Calendar now = Calendar.getInstance();
		if (_hoso.getNgayTraKetQua() != null) {
			return DateTimeUtil.getHourMinute(_hoso.getNgayTraKetQua());
		}

		return DateTimeUtil.getHourMinuteNow();
	}
	
	/**
	 * This is function getIndexCongVan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param gt
	 * @return String
	 */
	public  String  getIndexCongVan(List<DanhMucGiayTo> gt) {
		
		int indexCongvan =0;
		long idCongVanKhongDuDK =0;
		
		 //Get tham so gia tri -> id cong van tra loi
		 if(ThamSoLocalServiceUtil.getValue(Constants.CONGVAN_TRALOI_KHONGDUKD) != null)
		 {
			 if(!ThamSoLocalServiceUtil.getValue(Constants.CONGVAN_TRALOI_KHONGDUKD).isEmpty() )
			 {
				 idCongVanKhongDuDK =Long.parseLong(ThamSoLocalServiceUtil.getValue(Constants.CONGVAN_TRALOI_KHONGDUKD));
			 }
		 }
		 
		//Get index cong van tra loi
		if(gt != null)
		{
		  if(gt.size() >0)
		  {
			  for(int i=0;i<gt.size();i++)
			  {
				  if(gt.get(i).getId() == idCongVanKhongDuDK)
				  {
					  indexCongvan = i;
					  break;
				  }
			  }
		  }
		}
		
		
		String index = "";
		
		if(indexCongvan ==0)	
		{
			index = indexCongvan +",1";	
		}
		else
		{
			index = indexCongvan +",0";
		}
			
			
		return index;
	}
}
