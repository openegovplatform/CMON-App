package org.oep.sharedservice.touchscreen.tracuuhoso;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.oep.cmon.dao.dvc.model.impl.NhomThuTucHanhChinhImpl;
import org.oep.cmon.dao.dvc.model.impl.ThuTucHanhChinhImpl;
import org.oep.cmon.dao.hosohcc.model.impl.HoSoTTHCCongImpl;
import org.oep.cmon.dao.hosohcc.model.impl.TrangThaiHoSoImpl;
import org.oep.cmon.dao.touchscreen.model.impl.TraCuuHoSoTTHCCongImpl;

import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil;
import org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong;
import org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCongSoap;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

@WebService(targetNamespace = "http://tracuuhoso.touchscreen.sharedservice.dtt.vn/", endpointInterface = "org.oep.sharedservice.touchscreen.tracuuhoso.TraCuuHoSoService", portName = "TraCuuHoSoImplPort", serviceName = "TraCuuHoSoImplService")
public class TraCuuHoSoImpl implements TraCuuHoSoService {

	//Lay ho so tthc theo ma so bien nhan
	public TraCuuHoSoTTHCCongSoap getHoSoTTHCCongByMaSoBienNhan(String mabiennhan) {
		// TODO Auto-generated method stub
		if(!mabiennhan.equals("")){
			mabiennhan = mabiennhan.replace(".","").trim();
			if(Validator.isNumber(mabiennhan)){
				List<HoSoTTHCCong> listhoso = new ArrayList<HoSoTTHCCong>();
				HoSoTTHCCong hoso = new HoSoTTHCCongImpl();
				TrangThaiHoSo trangThaiHoso = new TrangThaiHoSoImpl();
				TraCuuHoSoTTHCCong traCuuHoSo = new TraCuuHoSoTTHCCongImpl();
				NhomThuTucHanhChinh nhomThuTucHanhChinh = new NhomThuTucHanhChinhImpl();
				ThuTucHanhChinh thuTucHanhChinh = new ThuTucHanhChinhImpl();
				try {
					listhoso = HoSoTTHCCongLocalServiceUtil.findByMaSoBienNhan(mabiennhan);
					
					if(listhoso.size()>0){
						hoso = listhoso.get(0);
						thuTucHanhChinh = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(hoso.getThuTucHanhChinhId());
						nhomThuTucHanhChinh = NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(thuTucHanhChinh.getNhomThuTucHanhChinhId());
						trangThaiHoso = TrangThaiHoSoLocalServiceUtil.getTrangThaiHoSo(hoso.getTrangThaiHoSo());
						//set value for traCuuHoSo
						traCuuHoSo.setId(hoso.getId());
						traCuuHoSo.setTrangThaiHoSoTen(trangThaiHoso.getTrangThai());
						traCuuHoSo.setTenThuTucHanhChinh(hoso.getTenThuTucHanhChinh());
						traCuuHoSo.setNhomThuTucHanhChinhTen(nhomThuTucHanhChinh.getTen());
						traCuuHoSo.setTenCoQuanTiepNhan(hoso.getTenCoQuanTiepNhan());
						traCuuHoSo.setLoaiHoSo(hoso.getLoaiHoSo());
						traCuuHoSo.setPhiHoSo(hoso.getPhiHoSo());
						traCuuHoSo.setLePhi(hoso.getLePhi());
						traCuuHoSo.setMaSoBienNhan(hoso.getMaSoBienNhan());
						traCuuHoSo.setHoTenNguoiNopHoSo(hoso.getHoTenNguoiNopHoSo());
						traCuuHoSo.setChuSoHuu(hoso.getChuSoHuu());
						traCuuHoSo.setDiaChiThuongTruNguoiNop(hoso.getDiaChiThuongTruNguoiNop());
						traCuuHoSo.setEmailNguoiNop(hoso.getEmailNguoiNop());
						traCuuHoSo.setSoDienThoaiDiDongNguoiNop(hoso.getSoDienThoaiDiDongNguoiNop());
						traCuuHoSo.setSoDienThoaiCoDinhNguoiNop(hoso.getSoDienThoaiCoDinhNguoiNop());
						traCuuHoSo.setNgayHenTraKetQua(hoso.getNgayHenTraKetQua());
						traCuuHoSo.setNgayTraKetQua(hoso.getNgayTraKetQua());
						traCuuHoSo.setNgayNhanHoSo(hoso.getNgayNhanHoSo());
						traCuuHoSo.setNgayKetThucXuLy(hoso.getNgayKetThucXuLy());
						
						return TraCuuHoSoTTHCCongSoap.toSoapModel(traCuuHoSo);
					}
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
