package org.oep.sharedservice.cmon.provider.officer.soap;

import java.io.Serializable;
import java.util.List;

import org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem;
import org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKemSoap;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThucSoap;



public class GiayToDinhKem extends TaiLieuChungThucSoap implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<LichSuGiayToDinhKemSoap> lichSu;
	private String url;
	private boolean result = false;
	private String code;
	
	
	
	public static GiayToDinhKem toSoapModel(TaiLieuChungThuc model) {
		GiayToDinhKem soapModel = new GiayToDinhKem();

		soapModel.setId(model.getId());
		soapModel.setTen(model.getTen());
		soapModel.setGhiChu(model.getGhiChu());
		soapModel.setNoiLuuTruId(model.getNoiLuuTruId());
		soapModel.setNgayUpload(model.getNgayUpload());
		soapModel.setPhienBan(model.getPhienBan());
		soapModel.setNgayDuyet(model.getNgayDuyet());
		soapModel.setHieuLucTuNgay(model.getHieuLucTuNgay());
		soapModel.setHieuLucDenNgay(model.getHieuLucDenNgay());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setDanhMucGiayToId(model.getDanhMucGiayToId());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setChuSohuuId(model.getChuSohuuId());
		soapModel.setNguoiUploadId(model.getNguoiUploadId());
		soapModel.setNguoiduyetId(model.getNguoiduyetId());
		soapModel.setHoSoTTHCCId(model.getHoSoTTHCCId());

		return soapModel;
	}
	
	

	public boolean isResult() {
		return result;
	}



	public void setResult(boolean result) {
		this.result = result;
	}




	public List<LichSuGiayToDinhKemSoap> getLichSu() {
		return lichSu;
	}



	public void setLichSu(List<LichSuGiayToDinhKemSoap> lichSu) {
		this.lichSu = lichSu;
	}



	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	

}
