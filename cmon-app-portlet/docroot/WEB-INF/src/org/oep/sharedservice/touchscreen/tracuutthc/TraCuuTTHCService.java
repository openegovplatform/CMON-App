package org.oep.sharedservice.touchscreen.tracuutthc;

import java.util.List;

import javax.jws.WebService;

import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinhSoap;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinhSoap;
import org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLySoap;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLySoap;
import org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinhSoap;

@WebService(name = "TraCuuTTHCService", targetNamespace = "http://tracuutthc.touchscreen.sharedservice.dtt.vn/")
public interface TraCuuTTHCService {
	
	public List<CapCoQuanQuanLySoap> getAllCapCoQuanQuanLy();
	public List<CoQuanQuanLySoap> getCoQuanQuanLyByIdCapCoQuan(String[] capcoquanId);
	public List<NhomThuTucHanhChinhSoap> getNhomTTHCByIdCoQuan(Long coquanId);
	public List<ThuTucHanhChinhSoap> getTTHCByIdNhomTTHC(Long nhomtthcId,Long coquanId);
	public TraCuuThuTucHanhChinhSoap getTTHCByIdTTHC(Long tthcId);
}
