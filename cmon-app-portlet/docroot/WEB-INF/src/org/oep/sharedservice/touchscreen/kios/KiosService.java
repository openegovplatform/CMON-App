package org.oep.sharedservice.touchscreen.kios;

import java.util.List;

import javax.jws.WebService;

import org.oep.cmon.dao.kios.model.DanhSachCoQuanSoap;
import org.oep.cmon.dao.kios.model.DanhSachHoSoSoap;
import org.oep.cmon.dao.kios.model.DanhSachThongKeSoap;

@WebService(name = "KiosService", targetNamespace = "http://kios.touchscreen.sharedservice.dtt.vn/")
public interface KiosService {
	
	public List<DanhSachHoSoSoap> getDanhSachHoSo(String id_coquan,int start,int end);	
	
	public List<DanhSachThongKeSoap> getDanhSachThongKe(String arrCapCoQuanid,String arrThang,String nam);	
	
	public List<DanhSachCoQuanSoap> getDanhSachCoQuan(String arrayCapCoQuanId);	
}
