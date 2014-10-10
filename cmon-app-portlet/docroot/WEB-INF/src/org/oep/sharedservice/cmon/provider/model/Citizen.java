package org.oep.sharedservice.cmon.provider.model;

import java.io.Serializable;

import org.oep.cmon.dao.cd.model.CongDanSoap;
import org.oep.cmon.dao.cd.model.DanTocSoap;
import org.oep.cmon.dao.cd.model.NgheNghiepSoap;
import org.oep.cmon.dao.cd.model.QuanHeGiaDinhSoap;
import org.oep.cmon.dao.cd.model.TonGiaoSoap;
import org.oep.cmon.dao.cd.model.TrinhDoChuyenMonSoap;
import org.oep.cmon.dao.cd.model.TrinhDoHocVanSoap;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDungSoap;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinhSoap;
import org.oep.cmon.dao.qlhc.model.QuocGiaSoap;

public class Citizen  implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CongDanSoap congDan;	
	private QuanHeGiaDinhSoap quanHeChuHo;
	private QuocGiaSoap quocTich;
	private TrinhDoChuyenMonSoap  trinhDoChuyenMon;
	private CongDanSoap soDinhDanhCha;	
	private TrinhDoHocVanSoap trinhDoHocVan;
	private DanTocSoap danToc;
	private TaiKhoanNguoiDungSoap taiKhoanNguoiDung;	
	private NgheNghiepSoap ngheNghiep;
	private TonGiaoSoap tonGiao;
	private CongDanSoap soDinhDanhMe;
	private CongDanSoap soDinhDanhVoHoacChong;
	private DonViHanhChinhSoap diaChiHienNayTinh;
	private DonViHanhChinhSoap diaChiHienNayHuyen;
	private DonViHanhChinhSoap diaChiHienNayXa;
	private DonViHanhChinhSoap diaChiThuongTruTinh;
	private DonViHanhChinhSoap diaChiThuongTruHuyen;
	private DonViHanhChinhSoap diaChiThuongTruXa;
	
	
	public DonViHanhChinhSoap getDiaChiHienNayXa() {
		return diaChiHienNayXa;
	}
	public void setDiaChiHienNayXa(DonViHanhChinhSoap diaChiHienNayXa) {
		this.diaChiHienNayXa = diaChiHienNayXa;
	}
	public DonViHanhChinhSoap getDiaChiThuongTruXa() {
		return diaChiThuongTruXa;
	}
	public void setDiaChiThuongTruXa(DonViHanhChinhSoap diaChiThuongTruXa) {
		this.diaChiThuongTruXa = diaChiThuongTruXa;
	}
	public QuanHeGiaDinhSoap getQuanHeChuHo() {
		return quanHeChuHo;
	}
	public void setQuanHeChuHo(QuanHeGiaDinhSoap quanHeChuHo) {
		this.quanHeChuHo = quanHeChuHo;
	}
	public QuocGiaSoap getQuocTich() {
		return quocTich;
	}
	public void setQuocTich(QuocGiaSoap quocTich) {
		this.quocTich = quocTich;
	}
	public TrinhDoChuyenMonSoap getTrinhDoChuyenMon() {
		return trinhDoChuyenMon;
	}
	public void setTrinhDoChuyenMon(TrinhDoChuyenMonSoap trinhDoChuyenMon) {
		this.trinhDoChuyenMon = trinhDoChuyenMon;
	}
	public CongDanSoap getSoDinhDanhCha() {
		return soDinhDanhCha;
	}
	public void setSoDinhDanhCha(CongDanSoap soDinhDanhCha) {
		this.soDinhDanhCha = soDinhDanhCha;
	}
	public TrinhDoHocVanSoap getTrinhDoHocVan() {
		return trinhDoHocVan;
	}
	public void setTrinhDoHocVan(TrinhDoHocVanSoap trinhDoHocVan) {
		this.trinhDoHocVan = trinhDoHocVan;
	}
	public DanTocSoap getDanToc() {
		return danToc;
	}
	public void setDanToc(DanTocSoap danToc) {
		this.danToc = danToc;
	}
	
	public TaiKhoanNguoiDungSoap getTaiKhoanNguoiDung() {
		return taiKhoanNguoiDung;
	}
	public void setTaiKhoanNguoiDung(TaiKhoanNguoiDungSoap taiKhoanNguoiDung) {
		this.taiKhoanNguoiDung = taiKhoanNguoiDung;
	}
	public NgheNghiepSoap getNgheNghiep() {
		return ngheNghiep;
	}
	public void setNgheNghiep(NgheNghiepSoap ngheNghiep) {
		this.ngheNghiep = ngheNghiep;
	}
	public TonGiaoSoap getTonGiao() {
		return tonGiao;
	}
	public void setTonGiao(TonGiaoSoap tonGiao) {
		this.tonGiao = tonGiao;
	}
	public CongDanSoap getSoDinhDanhMe() {
		return soDinhDanhMe;
	}
	public void setSoDinhDanhMe(CongDanSoap soDinhDanhMe) {
		this.soDinhDanhMe = soDinhDanhMe;
	}
	public CongDanSoap getSoDinhDanhVoHoacChong() {
		return soDinhDanhVoHoacChong;
	}
	public void setSoDinhDanhVoHoacChong(CongDanSoap soDinhDanhVoHoacChong) {
		this.soDinhDanhVoHoacChong = soDinhDanhVoHoacChong;
	}
	public DonViHanhChinhSoap getDiaChiHienNayTinh() {
		return diaChiHienNayTinh;
	}
	public void setDiaChiHienNayTinh(DonViHanhChinhSoap diaChiHienNayTinh) {
		this.diaChiHienNayTinh = diaChiHienNayTinh;
	}
	public DonViHanhChinhSoap getDiaChiHienNayHuyen() {
		return diaChiHienNayHuyen;
	}
	public void setDiaChiHienNayHuyen(DonViHanhChinhSoap diaChiHienNayHuyen) {
		this.diaChiHienNayHuyen = diaChiHienNayHuyen;
	}
	public DonViHanhChinhSoap getDiaChiThuongTruTinh() {
		return diaChiThuongTruTinh;
	}
	public void setDiaChiThuongTruTinh(DonViHanhChinhSoap diaChiThuongTruTinh) {
		this.diaChiThuongTruTinh = diaChiThuongTruTinh;
	}
	public DonViHanhChinhSoap getDiaChiThuongTruHuyen() {
		return diaChiThuongTruHuyen;
	}
	public void setDiaChiThuongTruHuyen(DonViHanhChinhSoap diaChiThuongTruHuyen) {
		this.diaChiThuongTruHuyen = diaChiThuongTruHuyen;
	}
	public CongDanSoap getCongDan() {
		return congDan;
	}
	public void setCongDan(CongDanSoap congDan) {
		this.congDan = congDan;
	}
	
	
	

}
