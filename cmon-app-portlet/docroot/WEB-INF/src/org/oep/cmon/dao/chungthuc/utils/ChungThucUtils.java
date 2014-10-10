package org.oep.cmon.dao.chungthuc.utils;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;

import org.oep.cmon.dao.chungthuc.model.impl.HoSoChungThucImpl;
import org.oep.cmon.dao.chungthuc.model.impl.SoDanhMucImpl;
import org.oep.cmon.dao.chungthuc.model.impl.ThanhPhanHoSoChungThucImpl;
import org.oep.cmon.portlet.hosotructiep.HoSoFields;
import org.oep.cmon.portlet.hosotructiep.HoSoJSON;
import org.oep.cmon.util.DateUtil;
import org.oep.cmon.util.EgovUtil;
import org.oep.egovcore.util.Helper;
import org.oep.egovcore.util.VNNumberUtil;

import org.oep.cmon.dao.beans.thongtinthutuc2coquan.ThongTinThuTuc2CoQuan;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.chungthuc.model.HoSoChungThuc;
import org.oep.cmon.dao.chungthuc.model.SoDanhMuc;
import org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc;
import org.oep.cmon.dao.chungthuc.service.HoSoChungThucLocalServiceUtil;
import org.oep.cmon.dao.chungthuc.service.SoDanhMucLocalServiceUtil;
import org.oep.cmon.dao.chungthuc.service.ThanhPhanHoSoChungThucLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy;
import org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.tlct.model.DanhMucGiayTo;
import org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

public class ChungThucUtils {

	public static HoSoChungThuc  fillDataHoSoChungThuc(UploadPortletRequest actionRequest) 
			throws PortalException, SystemException {
		//long idThuTucHanhChinh = ParamUtil.getLong(actionRequest, HoSoFields.thuTucHanhChinhId);
		//ThuTucHanhChinh thuTucHanhChinh = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(idThuTucHanhChinh);
		
		long uid = PortalUtil.getUserId(actionRequest);
		CongChuc congChuc = EgovUtil.getCongChucDaDangNhap(uid);

/*		CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.
			fetchCoQuanQuanLy(congChuc.getCoQuanQuanLyId());*/
		
		long idHoSo = ParamUtil.getLong(actionRequest, "idHoSo");
		
		HoSoChungThuc result = null;
		if (idHoSo > 0) 
			result = HoSoChungThucLocalServiceUtil.getHoSoChungThuc(idHoSo);
		
		if (result == null ) {
			result = new HoSoChungThucImpl();
		}
		// set id
		result.setHoSoChungThucId(idHoSo);
		
		// set ma bien nhan
/*		result.setMaSoBienNhan(MaSoBienNhanUtil.get(coQuanQuanLy.getMaCapSoBienNhan(),
				thuTucHanhChinh.getMaDNG(), false));*/
		
		// set tthc id
		result.setThuTucHanhChinhId(ParamUtil.getLong(actionRequest, HoSoFields.thuTucHanhChinhId));
		
		// set ngay nhan ho so
		result.setNgayNopHoSo(
				DateUtil.parseStringToDate(ParamUtil.getString(actionRequest, HoSoFields.ngayNhanHoSo)));
		
		// set ngay hen tra
		result.setNgayTraKetQua(
				DateUtil.parseStringToDate(ParamUtil.getString(actionRequest, HoSoFields.ngayHenTraHoSo)));
				
		// set co quan quan li
		result.setCanBoTiepNhanId(congChuc.getId());
		
		// ten can bo tiep nhan
		result.setNguoiTao(congChuc.getHoVaTen());
		
		// set ho ten nguoi nop
		result.setHoTenNguoiNopHoSo(ParamUtil.getString(actionRequest, HoSoFields.hoTenNguoiNopHoSo));
		
		// set ten chung thuc
		result.setTenChungThuc(ParamUtil.getString(actionRequest, HoSoFields.ten));
		
		// set dia chi nguoi nop
		result.setDiaChiThuongTruNguoiNop(ParamUtil.getString(actionRequest, HoSoFields.diaChiThuongTru));
		
		// set dien thoai nguoi nop
		//result.setSoDienThoaiCoDinhNguoiNop(ParamUtil.getString(actionRequest, Fields.dienThoaiCoDinh));

		// set dien thoai di dong
		result.setSoDienThoaiDiDongNguoiNop(ParamUtil.getString(actionRequest, HoSoFields.dienThoaiDiDong));
		
		if (idHoSo == 0)
			result.setNgayTao(new Date());
		
		else 
			result.setNgaySua(new Date());
		
		result.setMucDichChungThuc(ParamUtil.getString(actionRequest, "mucDich"));
		
		// set chu so huu
		result.setChuSoHuu(ParamUtil.getString(actionRequest, HoSoFields.chuSoHuu));

		// set so bo 
		result.setSoBoHoSo(ParamUtil.getInteger(actionRequest, HoSoFields.soBoHoSo));
		
		// set so to 
		result.setSoTo(ParamUtil.getInteger(actionRequest, "soTo"));

		// set so bo 
		result.setTruongHop(ParamUtil.getString(actionRequest, "truongHop"));
		
		//  phi
		result.setPhiHoSo((int)VNNumberUtil.toNum(ParamUtil.getString(actionRequest, HoSoFields.phiHoSo)));
		
		// le phi
		result.setLePhi((int)VNNumberUtil.toNum(ParamUtil.getString(actionRequest, HoSoFields.lePhiHoSo)));
		
		// email
		//result.setEmailNguoiNop(ParamUtil.getString(actionRequest, Fields.email));
		
		// ngay sinh nguoi nop
		//result.setNgaySinhNguoiNop(DateUtil.parseStringToDate(ParamUtil.getString(actionRequest, Fields.ngaySinh)));
		
		// cmnd
		result.setSoCMNDNguoiNop(ParamUtil.getString(actionRequest, HoSoFields.soCMND));
		
		// gioi tinh 
		//result.setGioiTinhNguoiNop(ParamUtil.getInteger(actionRequest, Fields.gioiTinh));
		
		// ten can bo ky
		result.setTenCanBoKy(ParamUtil.getString(actionRequest,"canBoKy"));
		
		// set chuc vu
		result.setChucVuCanBoKyId(ParamUtil.getLong(actionRequest,"chucVuCanBoKyId"));
		
		// so danh muc id
		result.setSoDanhMucId(ParamUtil.getLong(actionRequest,"soDanhMucId"));
		
		// soChungThuc
		result.setSoChungThuc(ParamUtil.getString(actionRequest,"soChungThuc"));
		
		result.setThuongTruTinhId(ParamUtil.getLong(actionRequest,HoSoFields.tinhThuongTruId));
		result.setThuongTruHuyenId(ParamUtil.getLong(actionRequest,HoSoFields.huyenThuongTruId));
		result.setThuongTruXaId(ParamUtil.getLong(actionRequest,HoSoFields.xaThuongTruId));

		return result;
	}
	
	public static SoDanhMuc fillDataSoDanhMuc(ActionRequest actionRequest)
			throws PortalException, SystemException {
		SoDanhMuc result = null;
		
		// get coquan by login user
		CongChuc congChuc = EgovUtil.getCongChucDaDangNhap(PortalUtil.getUserId(actionRequest));
		
		long idHoSo = ParamUtil.getLong(actionRequest, "idHoSo");

		if (idHoSo > 0) 
			result = SoDanhMucLocalServiceUtil.getSoDanhMuc(idHoSo);
		
		if (result == null ) {
			result = new SoDanhMucImpl();
		}
		
		result.setId(idHoSo);
		result.setTenSo(ParamUtil.getString(actionRequest,"tenSo"));
		result.setThuTucHanhChinhId(ParamUtil.getLong(actionRequest, "thuTucHanhChinhId"));
		result.setSoSo(ParamUtil.getString(actionRequest,"soChungThuc"));
		result.setNam(ParamUtil.getLong(actionRequest, "nam"));
		result.setTheoQuyetDinh(ParamUtil.getString(actionRequest,"theoQuyetDinh"));
		result.setCoQuanQuanLiId(congChuc.getCoQuanQuanLyId());
		
		return result;
	}
	
	public static void saveThanhPhanHoSoChungThuc(UploadPortletRequest request,
			long hsChungThucId, long tthcId) {
		try {
			File[] files = request.getFiles(HoSoFields.fileGiayToQuyDinh);
			File file = null;
			String[] tenGiayTos = ParamUtil.getParameterValues(request, HoSoFields.tenGiayToQuyDinh);
			String tenGiayTo = "";
			
			long[]	tt2gtIds = ParamUtil.getLongValues(request, HoSoFields.thuTuc2GiayToId);
			//int[] daNhans = ParamUtil.getIntegerValues(request, HoSoFields.daNhan);
			int[] daNhans = ParamUtil.getIntegerValues(request, HoSoFields.daNhan);
			long[] noiLuuTruIds = ParamUtil.getLongValues(request, "noiLuuTruId");
					
			if (files != null && files.length > 0)
				for (int i = 0; i < files.length; ++ i) {
					file = files[i];
					tenGiayTo = Helper.stringFromArray(tenGiayTos, i);
					if (tenGiayTo != null && tenGiayTo.length() >= 100)
						tenGiayTo = tenGiayTo.substring(0, 100) + "...";
					
					vn.dtt.sharedservice.cmon.consumer.officer.GiayToDinhKem result = null;
					
					if (FileUtil.getBytes(file) != null) {
						result = WebserviceFactory
								.getOfficerService().upload(
								getMaUngDung(tthcId), 
							1,
							null,
							PortalUtil.getUserId(request),
							tenGiayTo,
							tenGiayTo,
							FileUtil.getBytes(file),
							file.getName()
						);
					}
					
					long idHoSo = 0;
					ThanhPhanHoSoChungThuc thanhPhanHoSo = null;
					if (result != null && result.getNoiLuuTruId() > 0) {
						thanhPhanHoSo = new ThanhPhanHoSoChungThucImpl();
						idHoSo = CounterLocalServiceUtil.increment(ThanhPhanHoSoChungThuc.class.getName());
						thanhPhanHoSo.setThanhPhanHoSoId(idHoSo);
						thanhPhanHoSo.setHoSoChungThucId(hsChungThucId);
						thanhPhanHoSo.setNoiLuuTruHoSoDinhKemId(result.getNoiLuuTruId());
						thanhPhanHoSo.setTieuDe(tenGiayTo);
						thanhPhanHoSo.setThuTuc2GiayToId(tt2gtIds[i]);
						
						ThanhPhanHoSoChungThucLocalServiceUtil.addThanhPhanHoSoChungThuc(thanhPhanHoSo);
						
					} else if (daNhans != null && daNhans.length >= 0) {
						boolean checked = false;
						for (int j: daNhans) {
							if (j == i) {
								checked = true;
								break;
							}
						}
						
						if (checked) {
							thanhPhanHoSo = new ThanhPhanHoSoChungThucImpl();
							idHoSo = CounterLocalServiceUtil.increment(ThanhPhanHoSoChungThuc.class.getName());
							thanhPhanHoSo.setThanhPhanHoSoId(idHoSo);
							thanhPhanHoSo.setHoSoChungThucId(hsChungThucId);
							thanhPhanHoSo.setTieuDe(tenGiayTo);
							thanhPhanHoSo.setThuTuc2GiayToId(tt2gtIds[i]);
							thanhPhanHoSo.setNoiLuuTruHoSoDinhKemId(noiLuuTruIds[i]);
							ThanhPhanHoSoChungThucLocalServiceUtil.addThanhPhanHoSoChungThuc(thanhPhanHoSo);
						}
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Get "Ma ung dung" via thu tuc hanh chinh id
	 * 
	 * @param thuTucHanhChinhId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private  static String getMaUngDung(long thuTucHanhChinhId) throws PortalException, SystemException  {
		ThuTucHanhChinh thuTucHanhChinh =  ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(thuTucHanhChinhId);
		
		if (thuTucHanhChinh != null ) {
			long nhomThuTucHanhChinhId = thuTucHanhChinh.getNhomThuTucHanhChinhId();
			NhomThuTucHanhChinh nhomThuTucHanhChinh = NhomThuTucHanhChinhLocalServiceUtil.
								getNhomThuTucHanhChinh(nhomThuTucHanhChinhId);
			
			if (nhomThuTucHanhChinh != null) {
				long danhMucUngDungId = nhomThuTucHanhChinh.getDanhMucUngDungId();
				DanhMucUngDung danhMucUngDung =  DanhMucUngDungLocalServiceUtil.getDanhMucUngDung(danhMucUngDungId);
				
				if (danhMucUngDung != null) {
					return danhMucUngDung.getMa();
				}
			}
		}
		
		// return no data
		return  null;
	}
	
	public static JSONArray dsSoDanhMuc(List<SoDanhMuc> listSoDanhMuc, long idHoSo) throws SystemException {
		JSONArray out = JSONFactoryUtil.createJSONArray();
		
		long soDanhMucId = 0;
		if (idHoSo > 0) {
			HoSoChungThuc hsct = HoSoChungThucLocalServiceUtil.fetchHoSoChungThuc(idHoSo);
			
			if (hsct != null)
				soDanhMucId = hsct.getSoDanhMucId();
		}
		
		for (int i = 0; i < listSoDanhMuc.size(); i ++) {
			SoDanhMuc soDanhMuc = listSoDanhMuc.get(i);

			String check = "";
			if (soDanhMucId == soDanhMuc.getId()) {
				check = "selected";
				
			} else if (i == (listSoDanhMuc.size() - 1)) {
				check = "selected";
			}

			out.put(JSONFactoryUtil.createJSONObject()
				.put("id", soDanhMuc.getId())
				.put("ten", soDanhMuc.getTenSo())
				.put("so", soDanhMuc.getSoSo())
				.put("quyetDinh", soDanhMuc.getTheoQuyetDinh())
				.put("nam", soDanhMuc.getNam())
				.put("check", check)
			);
		}
		return out;
	}
	
	public static JSONObject countHoSoChungByTTHC(long tthcId, long soDanhMucId, long idHoSo) throws SystemException {
		JSONObject countHSObject = JSONFactoryUtil.createJSONObject();
		
//		List<HoSoChungThuc> dsHoSoChungThuc = HoSoChungThucLocalServiceUtil.
//				getHSChungThucByTTHC(tthcId);
		List<HoSoChungThuc> dsHoSoChungThuc = HoSoChungThucLocalServiceUtil.
				findByTheoTTHCIDAndSoDanhMucId(tthcId, soDanhMucId);
		
		if (idHoSo > 0) {
			HoSoChungThuc hsct = HoSoChungThucLocalServiceUtil.fetchHoSoChungThuc(idHoSo);
			
			if (hsct != null)
				return countHSObject.put("soChungThuc", hsct.getSoChungThuc());
		}
		
		// get max
		long max  = 0;
		if (dsHoSoChungThuc != null && dsHoSoChungThuc.size() > 0) {
			for (HoSoChungThuc hoSoChungThuc : dsHoSoChungThuc) {
				if (hoSoChungThuc.getSoChungThuc() != null &&
						checkIfIsLong(hoSoChungThuc.getSoChungThuc()) && 
						Long.parseLong(hoSoChungThuc.getSoChungThuc()) > max) {
						max = Long.parseLong(hoSoChungThuc.getSoChungThuc());
				}
			}
		}
		
		countHSObject.put("soChungThuc", (max + 1));
		
		return countHSObject;
	}
	
	public static boolean checkIfIsLong(String input) {

		if (input.contains(".") || input.contains(",")) {
			return false;
		}

		try {
			Long.parseLong(input);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}
	
	public static JSONArray dsGiayToQuyDinh(List<ThuTuc2GiayTo> dsGiayTo, long idHoSo) throws SystemException {
		JSONArray out = JSONFactoryUtil.createJSONArray();
		DanhMucGiayTo giayTo = null;
		
		List<ThanhPhanHoSoChungThuc> thanhPhanHoSoCTs = null;
		
		if (idHoSo > 0) {
			thanhPhanHoSoCTs = 
					ThanhPhanHoSoChungThucLocalServiceUtil.getThanhPhanHoSoChungThucListBy(idHoSo, 0, 1000);
		}
		
		for (ThuTuc2GiayTo gt : dsGiayTo) {
			giayTo = DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(gt.getDanhMucGiayToId());
			ThanhPhanHoSoChungThuc tphs = getTPHSCT(thanhPhanHoSoCTs, gt.getId());
			
			String daNhan = "";
			long noiLuuTruId = 0;
			
			if (tphs != null) {
				daNhan = "checked";
				noiLuuTruId = tphs.getNoiLuuTruHoSoDinhKemId();
			}
			
			out.put(JSONFactoryUtil.createJSONObject()
				.put(HoSoFields.loaiGiayToId, gt.getDanhMucGiayToId())
				.put(HoSoFields.thuTuc2GiayToId, gt.getId())
				.put(HoSoFields.tenGiayToQuyDinh, giayTo.getTen())
				.put(HoSoFields.dinhDangChoPhep, giayTo.getKieuTaiLieu())
				.put(HoSoFields.gioiHanDungLuong, giayTo.getGioiHanDungLuong())
				.put("daNhan", daNhan)
				.put("noiLuuTruId", noiLuuTruId));
		}
		
		return out;
	}
	
	private static ThanhPhanHoSoChungThuc getTPHSCT(
			List<ThanhPhanHoSoChungThuc> listThanhPhanHoSo, long tth2GiayToId) {
		
		if (listThanhPhanHoSo == null)
			return null;
		
		for (ThanhPhanHoSoChungThuc tphs : listThanhPhanHoSo) {
			if (tphs.getThuTuc2GiayToId() == tth2GiayToId)
				return tphs;
		}
		
		return null;
	}
	
	public static JSONObject thuTuc(TTHC2CoQuanQuanLy tthc2cq, long idHoSo) throws Exception {
		JSONObject out = JSONFactoryUtil.createJSONObject();
		
		if (idHoSo > 0) {
			HoSoChungThuc hsct = HoSoChungThucLocalServiceUtil.fetchHoSoChungThuc(idHoSo);
			
			if (hsct != null) {
				out
				.put(HoSoFields.lePhiHoSo, VNNumberUtil.toVNNum(hsct.getLePhi()))
				.put(HoSoFields.phiHoSo, VNNumberUtil.toVNNum(hsct.getPhiHoSo()));
				
				return out;
			}
		}
		
		if (tthc2cq != null) {
			return thuTuc2CoQuan(tthc2cq.getThuTucHanhChinhId(), tthc2cq.getCoQuanQuanLyId());
		}
		
		return out;
	}
	
	private static JSONObject thuTuc2CoQuan(long thuTucId, long coQuanId) throws Exception {
		ThongTinThuTuc2CoQuan info = 
			ThuTucHanhChinhLocalServiceUtil.fetchThongTinThuTuc2CoQuan(thuTucId, coQuanId);
		
		return HoSoJSON.thuTuc2CoQuan(info);
	}
}
