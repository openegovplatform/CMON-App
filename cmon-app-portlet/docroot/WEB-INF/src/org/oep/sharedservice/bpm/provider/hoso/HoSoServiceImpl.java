package org.oep.sharedservice.bpm.provider.hoso;



import java.util.List;

import javax.jws.WebService;





import org.oep.cmon.dao.dvc.model.CapNhatKetQua;
import org.oep.cmon.dao.dvc.model.CapNhatKetQuaClp;
import org.oep.cmon.dao.dvc.model.CapNhatKetQuaSoap;

import org.oep.cmon.dao.dvc.service.CapNhatKetQuaLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoi;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoiClp;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoiSoap;

import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.YKienTraoDoiLocalServiceUtil;



@WebService(targetNamespace = "http://hoso.provider.bpm.sharedservice.dtt.vn/", endpointInterface = "org.oep.sharedservice.bpm.provider.hoso.IHoSoService", portName = "HoSoServiceImplPort", serviceName = "HoSoServiceImplService")
public class HoSoServiceImpl implements IHoSoService {

	
	public boolean capNhatTrangThaiHoSo(Long userId, Long hosoId, int trangthai) {
		// TODO Auto-generated method stub
		try{
			HoSoTTHCCong hoso = HoSoTTHCCongLocalServiceUtil.capNhatTrangThai(hosoId, trangthai);
			if(hoso != null){
				
					return true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public YKienTraoDoiSoap getYKienTraoDoiTheoId(Long id){
		try{
			YKienTraoDoi yKienTraoDoi = YKienTraoDoiLocalServiceUtil.fetchYKienTraoDoi(id);
			if(yKienTraoDoi != null){
				
					return YKienTraoDoiSoap.toSoapModel(yKienTraoDoi);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	public YKienTraoDoiSoap[] getYKienTraoDoiTheoHoSoTTHCId(Long tthcId){
		try{
			List<YKienTraoDoi> yList = YKienTraoDoiLocalServiceUtil.findByHoSoTTHCCongId(tthcId);
			if(yList != null && yList.size()>0){
				
					return YKienTraoDoiSoap.toSoapModels(yList);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	public YKienTraoDoiSoap addYKienTraoDoi(YKienTraoDoiSoap soap){
		if(soap == null) return null;
		
		YKienTraoDoi model = new YKienTraoDoiClp();
		model.setTieuDe(soap.getTieuDe());
		model.setNoiDungYKien(soap.getNoiDungYKien());
		model.setHoSoTTHCCongId(soap.getHoSoTTHCCongId());
		model.setThoiGianGuiYKien(soap.getThoiGianGuiYKien());
	 	model.setTrangThai(soap.getTrangThai());
	 	model.setNguoiNhanId(soap.getNguoiNhanId());
	 	model.setNguoiGuiId(soap.getNguoiGuiId());
	 	model.setChaiId(soap.getId());
		YKienTraoDoi result;
		try {
			result = YKienTraoDoiLocalServiceUtil.addYkien_Traodoi(model);
			if(result != null){
				return YKienTraoDoiSoap.toSoapModel(result);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public YKienTraoDoiSoap updateYKienTraoDoi(YKienTraoDoiSoap soap){
		if(soap == null) return null;
		
		YKienTraoDoi model = new YKienTraoDoiClp();
		model.setId(soap.getId());
		model.setTieuDe(soap.getTieuDe());
		model.setNoiDungYKien(soap.getNoiDungYKien());
		model.setHoSoTTHCCongId(soap.getHoSoTTHCCongId());
		model.setThoiGianGuiYKien(soap.getThoiGianGuiYKien());
	 	model.setTrangThai(soap.getTrangThai());
	 	model.setNguoiNhanId(soap.getNguoiNhanId());
	 	model.setNguoiGuiId(soap.getNguoiGuiId());
	 	model.setChaiId(soap.getId());
		YKienTraoDoi result;
		
		try {
			result = YKienTraoDoiLocalServiceUtil.updateYkien_Traodoi(model);
			if(result != null){
				return YKienTraoDoiSoap.toSoapModel(result);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

	public CapNhatKetQuaSoap addCapNhatKetQua(CapNhatKetQuaSoap soap){
		CapNhatKetQua newObj = new CapNhatKetQuaClp();
		newObj.setTenBang(soap.getTenBang());
		newObj.setBanGhiId(soap.getBanGhiId());
		newObj.setHanhDong(soap.getHanhDong());
		newObj.setNgayTao(soap.getNgayTao());
		newObj.setNguoiTao(soap.getNguoiTao());
		newObj.setNgaySua(soap.getNgaySua());
		newObj.setNguoiSua(soap.getNguoiSua());
		newObj.setDaXoa(soap.getDaXoa());
		newObj.setHosoTTHCCId(soap.getHosoTTHCCId());
		try {
			newObj = CapNhatKetQuaLocalServiceUtil.addCapNhatKetQua(newObj);
			if(newObj != null){
				return CapNhatKetQuaSoap.toSoapModel(newObj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public CapNhatKetQuaSoap updateCapNhatKetQua(CapNhatKetQuaSoap soap){
		CapNhatKetQua newObj = new CapNhatKetQuaClp();
		newObj.setId(soap.getId());
		newObj.setTenBang(soap.getTenBang());
		newObj.setBanGhiId(soap.getBanGhiId());
		newObj.setHanhDong(soap.getHanhDong());
		newObj.setNgayTao(soap.getNgayTao());
		newObj.setNguoiTao(soap.getNguoiTao());
		newObj.setNgaySua(soap.getNgaySua());
		newObj.setNguoiSua(soap.getNguoiSua());
		newObj.setDaXoa(soap.getDaXoa());
		newObj.setHosoTTHCCId(soap.getHosoTTHCCId());
		try {
			newObj = CapNhatKetQuaLocalServiceUtil.updateCapNhatKetQua(newObj);
			if(newObj != null){
				return CapNhatKetQuaSoap.toSoapModel(newObj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
