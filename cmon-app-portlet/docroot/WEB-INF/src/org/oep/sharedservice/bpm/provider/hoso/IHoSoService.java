package org.oep.sharedservice.bpm.provider.hoso;

import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.oep.cmon.dao.dvc.model.CapNhatKetQuaSoap;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoiSoap;





@WebService(name = "IHoSoService", targetNamespace = "http://hoso.provider.bpm.sharedservice.dtt.vn/")
public interface IHoSoService {
	
	@RequestWrapper(className = "org.oep.sharedservice.bpm.provider.hoso.jaxws.CapNhatTrangThaiHoSo", localName = "capNhatTrangThaiHoSo", targetNamespace = "http://hoso.provider.bpm.sharedservice.dtt.vn/")
	@ResponseWrapper(className = "org.oep.sharedservice.bpm.provider.hoso.jaxws.CapNhatTrangThaiHoSoResponse", localName = "capNhatTrangThaiHoSoResponse", targetNamespace = "http://hoso.provider.bpm.sharedservice.dtt.vn/")
	public boolean capNhatTrangThaiHoSo(Long userId,Long hosoId,int trangthai);
	
	public YKienTraoDoiSoap getYKienTraoDoiTheoId(Long id);
	public YKienTraoDoiSoap[] getYKienTraoDoiTheoHoSoTTHCId(Long tthcId);
	public YKienTraoDoiSoap addYKienTraoDoi(YKienTraoDoiSoap yKienTraoDoiSoap);
	public YKienTraoDoiSoap updateYKienTraoDoi(YKienTraoDoiSoap yKienTraoDoiSoap);
	
	public CapNhatKetQuaSoap addCapNhatKetQua(CapNhatKetQuaSoap soap);
	public CapNhatKetQuaSoap updateCapNhatKetQua(CapNhatKetQuaSoap soap);

}
