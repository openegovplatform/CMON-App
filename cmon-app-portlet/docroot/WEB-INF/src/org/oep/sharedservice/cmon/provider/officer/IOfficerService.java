package org.oep.sharedservice.cmon.provider.officer;

import java.util.List;

import javax.jws.WebService;

import org.oep.sharedservice.cmon.provider.officer.soap.GiayToDinhKem;




import org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKemSoap;



@WebService(name = "IOfficerService", targetNamespace = "http://officer.provider.cmon.sharedservice.dtt.vn/")
public interface IOfficerService {
	
	public List<GiayToDinhKem> getDSGiayToDinhKemTheoHoSoId(Long hosoId);
	public List<GiayToDinhKem> getDSGiayToDinhKemTheoMaHoSo(String maHoSo);
	public List<LichSuGiayToDinhKemSoap> getDSLichSuCuaGiayToDinhKem(Long giayToDinhKemId);
	public String getURLCuaGiayToDinhKem(Long giayToDinhKemId);
	public boolean yeuCauXoaGiayToDinhKem(Long giayToDinhKemId,Long taikhoanLiferayId);
	public boolean yeuCauPhucHoiGiayToDinhKem(Long giayToDinhKemId,Long taikhoanLiferayId);
	public boolean xoaGiayToDinhKem(Long giayToDinhKemId,Long taikhoanLiferayId);
	public GiayToDinhKem  upload(String maUngDung,int type,Long hosoId,Long taikhoanLiferayId,String tenGiayTo,String mota,byte[]b,String tenFile);
	
}
