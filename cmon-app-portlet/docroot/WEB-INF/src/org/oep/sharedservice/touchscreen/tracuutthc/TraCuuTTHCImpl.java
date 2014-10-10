package org.oep.sharedservice.touchscreen.tracuutthc;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.oep.cmon.dao.dvc.model.impl.NhomThuTucHanhChinhImpl;
import org.oep.cmon.dao.touchscreen.model.impl.TraCuuThuTucHanhChinhImpl;
import org.oep.cmon.report.portlet.util.ActionAdminUtil;
import org.oep.cmon.touchscreen.portlet.util.TouchscreenUtil;

import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinhSoap;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinhSoap;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy;
import org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLySoap;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLySoap;
import org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc;
import org.oep.cmon.dao.report.service.CoQuanQuanLy2LinhVucLocalServiceUtil;
import org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh;
import org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinhSoap;

@WebService(targetNamespace = "http://tracuutthc.touchscreen.sharedservice.dtt.vn/", endpointInterface = "org.oep.sharedservice.touchscreen.tracuutthc.TraCuuTTHCService", portName = "TraCuuTTHCImplPort", serviceName = "TraCuuTTHCImplService")
public class TraCuuTTHCImpl implements TraCuuTTHCService {

	// lay danh sach Cap co quan quan ly
	public List<CapCoQuanQuanLySoap> getAllCapCoQuanQuanLy() {
		// TODO Auto-generated method stub
		try {
			List<CapCoQuanQuanLy> listccqql = ActionAdminUtil
					.getAllCapcoquanquanly(0);
			if (listccqql != null && listccqql.size() > 0) {
				List<CapCoQuanQuanLySoap> listccqqlsoap = new ArrayList<CapCoQuanQuanLySoap>();
				for (int i = 0; i < listccqql.size(); i++) {
					CapCoQuanQuanLySoap capCoQuanQuanLySoap = CapCoQuanQuanLySoap
							.toSoapModel(listccqql.get(i));
					listccqqlsoap.add(capCoQuanQuanLySoap);
				}
				return listccqqlsoap;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	// lay danh sach Co quan quan ly theo id cap co quan
	public List<CoQuanQuanLySoap> getCoQuanQuanLyByIdCapCoQuan(
			String[] capcoquanId) {
		// TODO Auto-generated method stub
		try {
			List<Long> id_ccqql = new ArrayList<Long>();
			for (int i = 0; i < capcoquanId.length; i++) {
				id_ccqql.add(Long.valueOf(capcoquanId[i]));
			}
			List<CoQuanQuanLy> listcqql = TouchscreenUtil
					.listCoQuanQuanLy(id_ccqql);
			if (listcqql != null && listcqql.size() > 0) {
				List<CoQuanQuanLySoap> listcqqlsoap = new ArrayList<CoQuanQuanLySoap>();
				for (int i = 0; i < listcqql.size(); i++) {
					CoQuanQuanLySoap coQuanQuanLySoap = CoQuanQuanLySoap
							.toSoapModel(listcqql.get(i));
					listcqqlsoap.add(coQuanQuanLySoap);
				}
				return listcqqlsoap;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	// Lay danh sach nhom thu tuc hanh chinh theo id co quan
	public List<NhomThuTucHanhChinhSoap> getNhomTTHCByIdCoQuan(Long coquanId) {
		// TODO Auto-generated method stub
		try {
			List<CoQuanQuanLy2LinhVuc> listcqql2linhvuc = CoQuanQuanLy2LinhVucLocalServiceUtil
					.getLinhvucByIdDonvi(String.valueOf(coquanId));
			if (listcqql2linhvuc != null && listcqql2linhvuc.size() > 0) {
				List<NhomThuTucHanhChinhSoap> listNhomTTHCSoap = new ArrayList<NhomThuTucHanhChinhSoap>();
				for (int i = 0; i < listcqql2linhvuc.size(); i++) {
					NhomThuTucHanhChinh nhomTTHC = NhomThuTucHanhChinhLocalServiceUtil
							.getNhomThuTucHanhChinh(listcqql2linhvuc.get(i)
									.getNHOMTHUTUCHANHCHINHID());
					NhomThuTucHanhChinhSoap nhomTTHCSoap = NhomThuTucHanhChinhSoap
							.toSoapModel(nhomTTHC);
					listNhomTTHCSoap.add(nhomTTHCSoap);
				}
				return listNhomTTHCSoap;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	// Lay danh sach thu tuc hanh chinh theo id nhom tthc
	public List<ThuTucHanhChinhSoap> getTTHCByIdNhomTTHC(Long nhomtthcId,
			Long coquanId) {
		// TODO Auto-generated method stub
		try {
			List<Long> id_nhomtthc = new ArrayList<Long>();
			id_nhomtthc.add(nhomtthcId);
			List<ThuTucHanhChinh> listTTHC = ActionAdminUtil
					.getTTHCByIdNhomTTHC(id_nhomtthc, String.valueOf(coquanId));
			if (listTTHC != null && listTTHC.size() > 0) {
				List<ThuTucHanhChinhSoap> listTTHCSoap = new ArrayList<ThuTucHanhChinhSoap>();
				for (int i = 0; i < listTTHC.size(); i++) {
					ThuTucHanhChinhSoap thuTucHanhChinhSoap = ThuTucHanhChinhSoap
							.toSoapModel(listTTHC.get(i));
					listTTHCSoap.add(thuTucHanhChinhSoap);
				}
				return listTTHCSoap;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	// Lay thuc tuc hanh chinh theo id tthc
	public TraCuuThuTucHanhChinhSoap getTTHCByIdTTHC(Long tthcId) {
		// TODO Auto-generated method stub
		TraCuuThuTucHanhChinh traCuuThuTuc = new TraCuuThuTucHanhChinhImpl();
		NhomThuTucHanhChinh nhomThutuc = new NhomThuTucHanhChinhImpl();
		try {
			ThuTucHanhChinh thutuc = ThuTucHanhChinhLocalServiceUtil
					.getThuTucHanhChinh(tthcId);
			if (thutuc != null) {
				nhomThutuc = NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(thutuc.getNhomThuTucHanhChinhId());
				traCuuThuTuc.setNhomThuTucHanhChinhTen(nhomThutuc.getTen());
				traCuuThuTuc.setId(thutuc.getId());
				traCuuThuTuc.setMa(thutuc.getMa());
				traCuuThuTuc.setTen(thutuc.getTen());
				traCuuThuTuc.setSoNgayXuLy(thutuc.getSoNgayXuLy());
				traCuuThuTuc.setNgayTao(thutuc.getNgayTao());
				traCuuThuTuc.setNguoiTao(thutuc.getNguoiTao());
				traCuuThuTuc.setNgaySua(thutuc.getNgaySua());
				traCuuThuTuc.setNguoiSua(thutuc.getNguoiSua());
				traCuuThuTuc.setTrangThai(thutuc.getTrangThai());
				traCuuThuTuc.setPhienBan(thutuc.getPhienBan());
				traCuuThuTuc.setDaXoa(thutuc.getDaXoa());
				traCuuThuTuc.setNhomThuTucHanhChinhId(thutuc.getNhomThuTucHanhChinhId());
				traCuuThuTuc.setCanTichHop(thutuc.getCanTichHop());
				traCuuThuTuc.setMaDNG(thutuc.getMaDNG());
				traCuuThuTuc.setLePhi(thutuc.getLePhi());
				traCuuThuTuc.setDonViPhi(thutuc.getDonViPhi());
				traCuuThuTuc.setPhi(thutuc.getPhi());
				traCuuThuTuc.setDonViLePhi(thutuc.getDonViLePhi());
				traCuuThuTuc.setTenMauDonToKhai(thutuc.getTenMauDonToKhai());
				traCuuThuTuc.setCapCoQuanQuanLyId(thutuc.getCapCoQuanQuanLyId());
				traCuuThuTuc.setThuTucLienThongId(thutuc.getThuTucLienThongId());
				traCuuThuTuc.setTrinhTuThucHien(thutuc.getTrinhTuThucHien());
				traCuuThuTuc.setYeuCauDieuKienThucHien(thutuc.getYeuCauDieuKienThucHien());
				traCuuThuTuc.setCanCuPhapLy(thutuc.getCanCuPhapLy());
				traCuuThuTuc.setThanhPhanHoSo(thutuc.getThanhPhanHoSo());
				traCuuThuTuc.setLinhVucThucHien(thutuc.getLinhVucThucHien());
				traCuuThuTuc.setCachThucHien(thutuc.getCachThucHien());
				return TraCuuThuTucHanhChinhSoap.toSoapModel(traCuuThuTuc);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
