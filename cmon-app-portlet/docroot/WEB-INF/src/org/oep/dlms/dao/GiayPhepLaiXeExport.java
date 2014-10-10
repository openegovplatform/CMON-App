/**
 * 
 */
package org.oep.dlms.dao;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author win_64
 *
 */
@XmlRootElement(name="GiayPhepLaiXe")
public class GiayPhepLaiXeExport {

	private String ID;
	/**
	 * @return the iD
	 */
	@XmlElement(type = String.class)
	public String getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}
	/**
	 * @return the mASOHOSO
	 */
	@XmlElement(type = String.class)
	public String getMASOHOSO() {
		return MASOHOSO;
	}
	/**
	 * @param mASOHOSO the mASOHOSO to set
	 */
	public void setMASOHOSO(String mASOHOSO) {
		MASOHOSO = mASOHOSO;
	}
	
	private String MASOHOSO;
	private String NGAYNOPHOSO;
	private String NGAYNHANHOSO;
	private String TENCOQUANTIEPNHAN;
	private String TENTHUTUCHANHCHINH;
	private String NGAYHENTRAKETQUA;
	private String NGAYTRAKETQUA;
	private String NGAYNOPHOSOGOC;
	private String NGAYHENNOPHOSOGOC;
	private String TENCANBOTIEPNHAN;
	private String CHUCVUCANBOTIEPNHAN;
	private String HOTENNGUOINOPHOSO;
	private String DIACHITHUONGTRUNGUOINOP;
	private String SODIENTHOAICODINHNGUOINOP;
	private String TENCANBOTRAKETQUA;
	private String CHUCVUCANBOTRAKETQUA;
	private String HOTENNGUOINHANKETQUA;
	private String DIACHITHUONGTRUNGUOINHANKQ;
	private String SODIENTHOAINGUOINHAN;
	private String NGAYCAP;
	private String LANCAP;
	private String TENCOQUANCAP;
	private String HIEULUCTUNGAY;
	private String HIEULUCDENNGAY;
	private String TRANGTHAIHOSO;
	private String DAXOA;
	private String NGUOITAO;
	private String NGAYTAO;
	private String NGUOISUA;
	private String NGAYSUA;
	private String THUTUCHANHCHINHID;
	private String CONGDANNOPID;
	private String DIACHITHUONGTRUNGUOINHANKQID;
	private String COQUANTIEPNHANID;
	private String CANBOTRAKETQUAID;
	private String CANBOTIEPNHANID;
	private String DIACHITHUONGTRUNGUOINOPID;
	private String SODIENTHOAIDIDONGNGUOINOP;
	private String PHONGBANXULYHIENTHOIID;
	private String TENPHONGBANXULYHIENTHOI;
	private String CANBOXULYHIENTHOIID;
	private String TENCANBOXULYHIENTHOI;
	private String DANHGIAKETQUA;
	private String GHICHU;
	private String NGAYKETTHUCXULY;
	private String LOAIHOSO;
	private String YEUCAUHUYHOSO;
	private String MASOBIENNHAN;
	private String TENBANGCHUAHOSO;
	private String CHUSOHUU;
	private String NGUOIDAIDIENPHAPLUATID;
	private String SOBOHOSO;
	private String LEPHI;
	private String PHIHOSO;
	private String TRICHYEU;
	private String NGAYHENTBTHUE;
	private String EMAILNGUOINOP;
	private String MAUNGDUNG;
	private String LYDO;
	private String NGUOIDAIDIENPHAPLUAT;
	/**
	 * @return the nGAYNOPHOSO
	 */
	@XmlElement(type = String.class)
	public String getNGAYNOPHOSO() {
		return NGAYNOPHOSO;
	}
	/**
	 * @param nGAYNOPHOSO the nGAYNOPHOSO to set
	 */
	public void setNGAYNOPHOSO(String nGAYNOPHOSO) {
		NGAYNOPHOSO = nGAYNOPHOSO;
	}
	/**
	 * @return the nGAYNHANHOSO
	 */
	@XmlElement(type = String.class)
	public String getNGAYNHANHOSO() {
		return NGAYNHANHOSO;
	}
	/**
	 * @param nGAYNHANHOSO the nGAYNHANHOSO to set
	 */
	public void setNGAYNHANHOSO(String nGAYNHANHOSO) {
		NGAYNHANHOSO = nGAYNHANHOSO;
	}
	/**
	 * @return the tENCOQUANTIEPNHAN
	 */
	@XmlElement(type = String.class)
	public String getTENCOQUANTIEPNHAN() {
		return TENCOQUANTIEPNHAN;
	}
	/**
	 * @param tENCOQUANTIEPNHAN the tENCOQUANTIEPNHAN to set
	 */
	public void setTENCOQUANTIEPNHAN(String tENCOQUANTIEPNHAN) {
		TENCOQUANTIEPNHAN = tENCOQUANTIEPNHAN;
	}
	/**
	 * @return the tENTHUTUCHANHCHINH
	 */
	@XmlElement(type = String.class)
	public String getTENTHUTUCHANHCHINH() {
		return TENTHUTUCHANHCHINH;
	}
	/**
	 * @param tENTHUTUCHANHCHINH the tENTHUTUCHANHCHINH to set
	 */
	public void setTENTHUTUCHANHCHINH(String tENTHUTUCHANHCHINH) {
		TENTHUTUCHANHCHINH = tENTHUTUCHANHCHINH;
	}
	/**
	 * @return the nGAYHENTRAKETQUA
	 */
	@XmlElement(type = String.class)
	public String getNGAYHENTRAKETQUA() {
		return NGAYHENTRAKETQUA;
	}

	/**
	 * @param nGAYHENTRAKETQUA the nGAYHENTRAKETQUA to set
	 */
	public void setNGAYHENTRAKETQUA(String nGAYHENTRAKETQUA) {
		NGAYHENTRAKETQUA = nGAYHENTRAKETQUA;
	}
	/**
	 * @return the nGAYTRAKETQUA
	 */
	@XmlElement(type = String.class)
	public String getNGAYTRAKETQUA() {
		return NGAYTRAKETQUA;
	}
	/**
	 * @param nGAYTRAKETQUA the nGAYTRAKETQUA to set
	 */
	public void setNGAYTRAKETQUA(String nGAYTRAKETQUA) {
		NGAYTRAKETQUA = nGAYTRAKETQUA;
	}
	/**
	 * @return the nGAYNOPHOSOGOC
	 */
	@XmlElement(type = String.class)
	public String getNGAYNOPHOSOGOC() {
		return NGAYNOPHOSOGOC;
	}
	/**
	 * @param nGAYNOPHOSOGOC the nGAYNOPHOSOGOC to set
	 */
	public void setNGAYNOPHOSOGOC(String nGAYNOPHOSOGOC) {
		NGAYNOPHOSOGOC = nGAYNOPHOSOGOC;
	}
	/**
	 * @return the nGAYHENNOPHOSOGOC
	 */
	@XmlElement(type = String.class)
	public String getNGAYHENNOPHOSOGOC() {
		return NGAYHENNOPHOSOGOC;
	}
	/**
	 * @param nGAYHENNOPHOSOGOC the nGAYHENNOPHOSOGOC to set
	 */
	public void setNGAYHENNOPHOSOGOC(String nGAYHENNOPHOSOGOC) {
		NGAYHENNOPHOSOGOC = nGAYHENNOPHOSOGOC;
	}
	/**
	 * @return the tENCANBOTIEPNHAN
	 */
	@XmlElement(type = String.class)
	public String getTENCANBOTIEPNHAN() {
		return TENCANBOTIEPNHAN;
	}
	/**
	 * @param tENCANBOTIEPNHAN the tENCANBOTIEPNHAN to set
	 */
	public void setTENCANBOTIEPNHAN(String tENCANBOTIEPNHAN) {
		TENCANBOTIEPNHAN = tENCANBOTIEPNHAN;
	}
	/**
	 * @return the cHUCVUCANBOTIEPNHAN
	 */
	@XmlElement(type = String.class)
	public String getCHUCVUCANBOTIEPNHAN() {
		return CHUCVUCANBOTIEPNHAN;
	}
	/**
	 * @param cHUCVUCANBOTIEPNHAN the cHUCVUCANBOTIEPNHAN to set
	 */
	public void setCHUCVUCANBOTIEPNHAN(String cHUCVUCANBOTIEPNHAN) {
		CHUCVUCANBOTIEPNHAN = cHUCVUCANBOTIEPNHAN;
	}
	/**
	 * @return the hOTENNGUOINOPHOSO
	 */
	@XmlElement(type = String.class)
	public String getHOTENNGUOINOPHOSO() {
		return HOTENNGUOINOPHOSO;
	}
	/**
	 * @param hOTENNGUOINOPHOSO the hOTENNGUOINOPHOSO to set
	 */
	public void setHOTENNGUOINOPHOSO(String hOTENNGUOINOPHOSO) {
		HOTENNGUOINOPHOSO = hOTENNGUOINOPHOSO;
	}
	/**
	 * @return the dIACHITHUONGTRUNGUOINOP
	 */
	@XmlElement(type = String.class)
	public String getDIACHITHUONGTRUNGUOINOP() {
		return DIACHITHUONGTRUNGUOINOP;
	}
	/**
	 * @param dIACHITHUONGTRUNGUOINOP the dIACHITHUONGTRUNGUOINOP to set
	 */
	public void setDIACHITHUONGTRUNGUOINOP(String dIACHITHUONGTRUNGUOINOP) {
		DIACHITHUONGTRUNGUOINOP = dIACHITHUONGTRUNGUOINOP;
	}
	/**
	 * @return the sODIENTHOAICODINHNGUOINOP
	 */
	@XmlElement(type = String.class)
	public String getSODIENTHOAICODINHNGUOINOP() {
		return SODIENTHOAICODINHNGUOINOP;
	}
	/**
	 * @param sODIENTHOAICODINHNGUOINOP the sODIENTHOAICODINHNGUOINOP to set
	 */
	public void setSODIENTHOAICODINHNGUOINOP(String sODIENTHOAICODINHNGUOINOP) {
		SODIENTHOAICODINHNGUOINOP = sODIENTHOAICODINHNGUOINOP;
	}
	/**
	 * @return the tENCANBOTRAKETQUA
	 */
	@XmlElement(type = String.class)
	public String getTENCANBOTRAKETQUA() {
		return TENCANBOTRAKETQUA;
	}
	/**
	 * @param tENCANBOTRAKETQUA the tENCANBOTRAKETQUA to set
	 */
	public void setTENCANBOTRAKETQUA(String tENCANBOTRAKETQUA) {
		TENCANBOTRAKETQUA = tENCANBOTRAKETQUA;
	}
	/**
	 * @return the cHUCVUCANBOTRAKETQUA
	 */
	@XmlElement(type = String.class)
	public String getCHUCVUCANBOTRAKETQUA() {
		return CHUCVUCANBOTRAKETQUA;
	}
	/**
	 * @param cHUCVUCANBOTRAKETQUA the cHUCVUCANBOTRAKETQUA to set
	 */
	public void setCHUCVUCANBOTRAKETQUA(String cHUCVUCANBOTRAKETQUA) {
		CHUCVUCANBOTRAKETQUA = cHUCVUCANBOTRAKETQUA;
	}
	/**
	 * @return the hOTENNGUOINHANKETQUA
	 */
	@XmlElement(type = String.class)
	public String getHOTENNGUOINHANKETQUA() {
		return HOTENNGUOINHANKETQUA;
	}
	/**
	 * @param hOTENNGUOINHANKETQUA the hOTENNGUOINHANKETQUA to set
	 */
	public void setHOTENNGUOINHANKETQUA(String hOTENNGUOINHANKETQUA) {
		HOTENNGUOINHANKETQUA = hOTENNGUOINHANKETQUA;
	}
	/**
	 * @return the dIACHITHUONGTRUNGUOINHANKQ
	 */
	@XmlElement(type = String.class)
	public String getDIACHITHUONGTRUNGUOINHANKQ() {
		return DIACHITHUONGTRUNGUOINHANKQ;
	}
	/**
	 * @param dIACHITHUONGTRUNGUOINHANKQ the dIACHITHUONGTRUNGUOINHANKQ to set
	 */
	public void setDIACHITHUONGTRUNGUOINHANKQ(String dIACHITHUONGTRUNGUOINHANKQ) {
		DIACHITHUONGTRUNGUOINHANKQ = dIACHITHUONGTRUNGUOINHANKQ;
	}
	/**
	 * @return the sODIENTHOAINGUOINHAN
	 */
	@XmlElement(type = String.class)
	public String getSODIENTHOAINGUOINHAN() {
		return SODIENTHOAINGUOINHAN;
	}
	/**
	 * @param sODIENTHOAINGUOINHAN the sODIENTHOAINGUOINHAN to set
	 */
	public void setSODIENTHOAINGUOINHAN(String sODIENTHOAINGUOINHAN) {
		SODIENTHOAINGUOINHAN = sODIENTHOAINGUOINHAN;
	}
	/**
	 * @return the nGAYCAP
	 */
	@XmlElement(type = String.class)
	public String getNGAYCAP() {
		return NGAYCAP;
	}
	/**
	 * @param nGAYCAP the nGAYCAP to set
	 */
	public void setNGAYCAP(String nGAYCAP) {
		NGAYCAP = nGAYCAP;
	}
	/**
	 * @return the lANCAP
	 */
	@XmlElement(type = String.class)
	public String getLANCAP() {
		return LANCAP;
	}
	/**
	 * @param lANCAP the lANCAP to set
	 */
	public void setLANCAP(String lANCAP) {
		LANCAP = lANCAP;
	}
	/**
	 * @return the tENCOQUANCAP
	 */
	@XmlElement(type = String.class)
	public String getTENCOQUANCAP() {
		return TENCOQUANCAP;
	}
	/**
	 * @param tENCOQUANCAP the tENCOQUANCAP to set
	 */
	public void setTENCOQUANCAP(String tENCOQUANCAP) {
		TENCOQUANCAP = tENCOQUANCAP;
	}
	/**
	 * @return the hIEULUCTUNGAY
	 */
	@XmlElement(type = String.class)
	public String getHIEULUCTUNGAY() {
		return HIEULUCTUNGAY;
	}
	/**
	 * @param hIEULUCTUNGAY the hIEULUCTUNGAY to set
	 */
	public void setHIEULUCTUNGAY(String hIEULUCTUNGAY) {
		HIEULUCTUNGAY = hIEULUCTUNGAY;
	}
	/**
	 * @return the hIEULUCDENNGAY
	 */
	@XmlElement(type = String.class)
	public String getHIEULUCDENNGAY() {
		return HIEULUCDENNGAY;
	}
	/**
	 * @param hIEULUCDENNGAY the hIEULUCDENNGAY to set
	 */
	public void setHIEULUCDENNGAY(String hIEULUCDENNGAY) {
		HIEULUCDENNGAY = hIEULUCDENNGAY;
	}
	/**
	 * @return the tRANGTHAIHOSO
	 */
	@XmlElement(type = String.class)
	public String getTRANGTHAIHOSO() {
		return TRANGTHAIHOSO;
	}
	/**
	 * @param tRANGTHAIHOSO the tRANGTHAIHOSO to set
	 */
	public void setTRANGTHAIHOSO(String tRANGTHAIHOSO) {
		TRANGTHAIHOSO = tRANGTHAIHOSO;
	}
	/**
	 * @return the dAXOA
	 */
	@XmlElement(type = String.class)
	public String getDAXOA() {
		return DAXOA;
	}
	/**
	 * @param dAXOA the dAXOA to set
	 */
	public void setDAXOA(String dAXOA) {
		DAXOA = dAXOA;
	}
	/**
	 * @return the nGUOITAO
	 */
	@XmlElement(type = String.class)
	public String getNGUOITAO() {
		return NGUOITAO;
	}
	/**
	 * @param nGUOITAO the nGUOITAO to set
	 */
	public void setNGUOITAO(String nGUOITAO) {
		NGUOITAO = nGUOITAO;
	}
	/**
	 * @return the nGAYTAO
	 */
	@XmlElement(type = String.class)
	public String getNGAYTAO() {
		return NGAYTAO;
	}
	/**
	 * @param nGAYTAO the nGAYTAO to set
	 */
	public void setNGAYTAO(String nGAYTAO) {
		NGAYTAO = nGAYTAO;
	}
	/**
	 * @return the nGUOISUA
	 */
	@XmlElement(type = String.class)
	public String getNGUOISUA() {
		return NGUOISUA;
	}
	/**
	 * @param nGUOISUA the nGUOISUA to set
	 */
	public void setNGUOISUA(String nGUOISUA) {
		NGUOISUA = nGUOISUA;
	}
	/**
	 * @return the nGAYSUA
	 */
	@XmlElement(type = String.class)
	public String getNGAYSUA() {
		return NGAYSUA;
	}
	/**
	 * @param nGAYSUA the nGAYSUA to set
	 */
	public void setNGAYSUA(String nGAYSUA) {
		NGAYSUA = nGAYSUA;
	}
	/**
	 * @return the tHUTUCHANHCHINHID
	 */
	@XmlElement(type = String.class)
	public String getTHUTUCHANHCHINHID() {
		return THUTUCHANHCHINHID;
	}
	/**
	 * @param tHUTUCHANHCHINHID the tHUTUCHANHCHINHID to set
	 */
	public void setTHUTUCHANHCHINHID(String tHUTUCHANHCHINHID) {
		THUTUCHANHCHINHID = tHUTUCHANHCHINHID;
	}
	/**
	 * @return the cONGDANNOPID
	 */
	@XmlElement(type = String.class)
	public String getCONGDANNOPID() {
		return CONGDANNOPID;
	}
	/**
	 * @param cONGDANNOPID the cONGDANNOPID to set
	 */
	public void setCONGDANNOPID(String cONGDANNOPID) {
		CONGDANNOPID = cONGDANNOPID;
	}
	/**
	 * @return the dIACHITHUONGTRUNGUOINHANKQID
	 */
	@XmlElement(type = String.class)
	public String getDIACHITHUONGTRUNGUOINHANKQID() {
		return DIACHITHUONGTRUNGUOINHANKQID;
	}
	/**
	 * @param dIACHITHUONGTRUNGUOINHANKQID the dIACHITHUONGTRUNGUOINHANKQID to set
	 */
	public void setDIACHITHUONGTRUNGUOINHANKQID(String dIACHITHUONGTRUNGUOINHANKQID) {
		DIACHITHUONGTRUNGUOINHANKQID = dIACHITHUONGTRUNGUOINHANKQID;
	}
	/**
	 * @return the cOQUANTIEPNHANID
	 */
	@XmlElement(type = String.class)
	public String getCOQUANTIEPNHANID() {
		return COQUANTIEPNHANID;
	}
	/**
	 * @param cOQUANTIEPNHANID the cOQUANTIEPNHANID to set
	 */
	public void setCOQUANTIEPNHANID(String cOQUANTIEPNHANID) {
		COQUANTIEPNHANID = cOQUANTIEPNHANID;
	}
	/**
	 * @return the cANBOTRAKETQUAID
	 */
	@XmlElement(type = String.class)
	public String getCANBOTRAKETQUAID() {
		return CANBOTRAKETQUAID;
	}
	/**
	 * @param cANBOTRAKETQUAID the cANBOTRAKETQUAID to set
	 */
	public void setCANBOTRAKETQUAID(String cANBOTRAKETQUAID) {
		CANBOTRAKETQUAID = cANBOTRAKETQUAID;
	}
	/**
	 * @return the cANBOTIEPNHANID
	 */
	@XmlElement(type = String.class)
	public String getCANBOTIEPNHANID() {
		return CANBOTIEPNHANID;
	}
	/**
	 * @param cANBOTIEPNHANID the cANBOTIEPNHANID to set
	 */
	public void setCANBOTIEPNHANID(String cANBOTIEPNHANID) {
		CANBOTIEPNHANID = cANBOTIEPNHANID;
	}
	/**
	 * @return the dIACHITHUONGTRUNGUOINOPID
	 */
	@XmlElement(type = String.class)
	public String getDIACHITHUONGTRUNGUOINOPID() {
		return DIACHITHUONGTRUNGUOINOPID;
	}
	/**
	 * @param dIACHITHUONGTRUNGUOINOPID the dIACHITHUONGTRUNGUOINOPID to set
	 */
	public void setDIACHITHUONGTRUNGUOINOPID(String dIACHITHUONGTRUNGUOINOPID) {
		DIACHITHUONGTRUNGUOINOPID = dIACHITHUONGTRUNGUOINOPID;
	}
	/**
	 * @return the sODIENTHOAIDIDONGNGUOINOP
	 */
	@XmlElement(type = String.class)
	public String getSODIENTHOAIDIDONGNGUOINOP() {
		return SODIENTHOAIDIDONGNGUOINOP;
	}
	/**
	 * @param sODIENTHOAIDIDONGNGUOINOP the sODIENTHOAIDIDONGNGUOINOP to set
	 */
	public void setSODIENTHOAIDIDONGNGUOINOP(String sODIENTHOAIDIDONGNGUOINOP) {
		SODIENTHOAIDIDONGNGUOINOP = sODIENTHOAIDIDONGNGUOINOP;
	}
	/**
	 * @return the pHONGBANXULYHIENTHOIID
	 */
	@XmlElement(type = String.class)
	public String getPHONGBANXULYHIENTHOIID() {
		return PHONGBANXULYHIENTHOIID;
	}
	/**
	 * @param pHONGBANXULYHIENTHOIID the pHONGBANXULYHIENTHOIID to set
	 */
	public void setPHONGBANXULYHIENTHOIID(String pHONGBANXULYHIENTHOIID) {
		PHONGBANXULYHIENTHOIID = pHONGBANXULYHIENTHOIID;
	}
	/**
	 * @return the tENPHONGBANXULYHIENTHOI
	 */
	@XmlElement(type = String.class)
	public String getTENPHONGBANXULYHIENTHOI() {
		return TENPHONGBANXULYHIENTHOI;
	}
	/**
	 * @param tENPHONGBANXULYHIENTHOI the tENPHONGBANXULYHIENTHOI to set
	 */
	public void setTENPHONGBANXULYHIENTHOI(String tENPHONGBANXULYHIENTHOI) {
		TENPHONGBANXULYHIENTHOI = tENPHONGBANXULYHIENTHOI;
	}
	/**
	 * @return the cANBOXULYHIENTHOIID
	 */
	@XmlElement(type = String.class)
	public String getCANBOXULYHIENTHOIID() {
		return CANBOXULYHIENTHOIID;
	}
	/**
	 * @param cANBOXULYHIENTHOIID the cANBOXULYHIENTHOIID to set
	 */
	public void setCANBOXULYHIENTHOIID(String cANBOXULYHIENTHOIID) {
		CANBOXULYHIENTHOIID = cANBOXULYHIENTHOIID;
	}
	/**
	 * @return the tENCANBOXULYHIENTHOI
	 */
	@XmlElement(type = String.class)
	public String getTENCANBOXULYHIENTHOI() {
		return TENCANBOXULYHIENTHOI;
	}
	/**
	 * @param tENCANBOXULYHIENTHOI the tENCANBOXULYHIENTHOI to set
	 */
	public void setTENCANBOXULYHIENTHOI(String tENCANBOXULYHIENTHOI) {
		TENCANBOXULYHIENTHOI = tENCANBOXULYHIENTHOI;
	}
	/**
	 * @return the dANHGIAKETQUA
	 */
	@XmlElement(type = String.class)
	public String getDANHGIAKETQUA() {
		return DANHGIAKETQUA;
	}
	/**
	 * @param dANHGIAKETQUA the dANHGIAKETQUA to set
	 */
	public void setDANHGIAKETQUA(String dANHGIAKETQUA) {
		DANHGIAKETQUA = dANHGIAKETQUA;
	}
	/**
	 * @return the nGAYKETTHUCXULY
	 */
	@XmlElement(type = String.class)
	public String getNGAYKETTHUCXULY() {
		return NGAYKETTHUCXULY;
	}
	/**
	 * @param nGAYKETTHUCXULY the nGAYKETTHUCXULY to set
	 */
	public void setNGAYKETTHUCXULY(String nGAYKETTHUCXULY) {
		NGAYKETTHUCXULY = nGAYKETTHUCXULY;
	}
	/**
	 * @return the lOAIHOSO
	 */
	@XmlElement(type = String.class)
	public String getLOAIHOSO() {
		return LOAIHOSO;
	}
	/**
	 * @param lOAIHOSO the lOAIHOSO to set
	 */
	public void setLOAIHOSO(String lOAIHOSO) {
		LOAIHOSO = lOAIHOSO;
	}
	/**
	 * @return the yEUCAUHUYHOSO
	 */
	@XmlElement(type = String.class)
	public String getYEUCAUHUYHOSO() {
		return YEUCAUHUYHOSO;
	}
	/**
	 * @param yEUCAUHUYHOSO the yEUCAUHUYHOSO to set
	 */
	public void setYEUCAUHUYHOSO(String yEUCAUHUYHOSO) {
		YEUCAUHUYHOSO = yEUCAUHUYHOSO;
	}
	/**
	 * @return the mASOBIENNHAN
	 */
	@XmlElement(type = String.class)
	public String getMASOBIENNHAN() {
		return MASOBIENNHAN;
	}
	/**
	 * @param mASOBIENNHAN the mASOBIENNHAN to set
	 */
	public void setMASOBIENNHAN(String mASOBIENNHAN) {
		MASOBIENNHAN = mASOBIENNHAN;
	}
	/**
	 * @return the tENBANGCHUAHOSO
	 */
	@XmlElement(type = String.class)
	public String getTENBANGCHUAHOSO() {
		return TENBANGCHUAHOSO;
	}
	/**
	 * @param tENBANGCHUAHOSO the tENBANGCHUAHOSO to set
	 */
	public void setTENBANGCHUAHOSO(String tENBANGCHUAHOSO) {
		TENBANGCHUAHOSO = tENBANGCHUAHOSO;
	}
	/**
	 * @return the cHUSOHUU
	 */
	@XmlElement(type = String.class)
	public String getCHUSOHUU() {
		return CHUSOHUU;
	}
	/**
	 * @param cHUSOHUU the cHUSOHUU to set
	 */
	public void setCHUSOHUU(String cHUSOHUU) {
		CHUSOHUU = cHUSOHUU;
	}
	/**
	 * @return the nGUOIDAIDIENPHAPLUATID
	 */
	@XmlElement(type = String.class)
	public String getNGUOIDAIDIENPHAPLUATID() {
		return NGUOIDAIDIENPHAPLUATID;
	}
	/**
	 * @param nGUOIDAIDIENPHAPLUATID the nGUOIDAIDIENPHAPLUATID to set
	 */
	public void setNGUOIDAIDIENPHAPLUATID(String nGUOIDAIDIENPHAPLUATID) {
		NGUOIDAIDIENPHAPLUATID = nGUOIDAIDIENPHAPLUATID;
	}
	/**
	 * @return the sOBOHOSO
	 */
	@XmlElement(type = String.class)
	public String getSOBOHOSO() {
		return SOBOHOSO;
	}
	/**
	 * @param sOBOHOSO the sOBOHOSO to set
	 */
	public void setSOBOHOSO(String sOBOHOSO) {
		SOBOHOSO = sOBOHOSO;
	}
	/**
	 * @return the lEPHI
	 */
	@XmlElement(type = String.class)
	public String getLEPHI() {
		return LEPHI;
	}
	/**
	 * @param lEPHI the lEPHI to set
	 */
	public void setLEPHI(String lEPHI) {
		LEPHI = lEPHI;
	}
	/**
	 * @return the pHIHOSO
	 */
	@XmlElement(type = String.class)
	public String getPHIHOSO() {
		return PHIHOSO;
	}
	/**
	 * @param pHIHOSO the pHIHOSO to set
	 */
	public void setPHIHOSO(String pHIHOSO) {
		PHIHOSO = pHIHOSO;
	}
	/**
	 * @return the tRICHYEU
	 */
	@XmlElement(type = String.class)
	public String getTRICHYEU() {
		return TRICHYEU;
	}
	/**
	 * @param tRICHYEU the tRICHYEU to set
	 */
	public void setTRICHYEU(String tRICHYEU) {
		TRICHYEU = tRICHYEU;
	}
	/**
	 * @return the nGAYHENTBTHUE
	 */
	@XmlElement(type = String.class)
	public String getNGAYHENTBTHUE() {
		return NGAYHENTBTHUE;
	}
	/**
	 * @param nGAYHENTBTHUE the nGAYHENTBTHUE to set
	 */
	public void setNGAYHENTBTHUE(String nGAYHENTBTHUE) {
		NGAYHENTBTHUE = nGAYHENTBTHUE;
	}
	/**
	 * @return the eMAILNGUOINOP
	 */
	@XmlElement(type = String.class)
	public String getEMAILNGUOINOP() {
		return EMAILNGUOINOP;
	}
	/**
	 * @param eMAILNGUOINOP the eMAILNGUOINOP to set
	 */
	public void setEMAILNGUOINOP(String eMAILNGUOINOP) {
		EMAILNGUOINOP = eMAILNGUOINOP;
	}
	/**
	 * @return the mAUNGDUNG
	 */
	@XmlElement(type = String.class)
	public String getMAUNGDUNG() {
		return MAUNGDUNG;
	}
	/**
	 * @param mAUNGDUNG the mAUNGDUNG to set
	 */
	public void setMAUNGDUNG(String mAUNGDUNG) {
		MAUNGDUNG = mAUNGDUNG;
	}
	/**
	 * @return the lYDO
	 */
	@XmlElement(type = String.class)
	public String getLYDO() {
		return LYDO;
	}
	/**
	 * @param lYDO the lYDO to set
	 */
	public void setLYDO(String lYDO) {
		LYDO = lYDO;
	}
	/**
	 * @return the nGUOIDAIDIENPHAPLUAT
	 */
	@XmlElement(type = String.class)
	public String getNGUOIDAIDIENPHAPLUAT() {
		return NGUOIDAIDIENPHAPLUAT;
	}
	/**
	 * @param nGUOIDAIDIENPHAPLUAT the nGUOIDAIDIENPHAPLUAT to set
	 */
	public void setNGUOIDAIDIENPHAPLUAT(String nGUOIDAIDIENPHAPLUAT) {
		NGUOIDAIDIENPHAPLUAT = nGUOIDAIDIENPHAPLUAT;
	}
	/**
	 * @return the cHUYENSANGMOTCUA
	 */
	@XmlElement(type = String.class)
	public String getCHUYENSANGMOTCUA() {
		return CHUYENSANGMOTCUA;
	}
	/**
	 * @param cHUYENSANGMOTCUA the cHUYENSANGMOTCUA to set
	 */
	public void setCHUYENSANGMOTCUA(String cHUYENSANGMOTCUA) {
		CHUYENSANGMOTCUA = cHUYENSANGMOTCUA;
	}
	/**
	 * @return the dAGUIGIAYHEN
	 */
	@XmlElement(type = String.class)
	public String getDAGUIGIAYHEN() {
		return DAGUIGIAYHEN;
	}
	/**
	 * @param dAGUIGIAYHEN the dAGUIGIAYHEN to set
	 */
	public void setDAGUIGIAYHEN(String dAGUIGIAYHEN) {
		DAGUIGIAYHEN = dAGUIGIAYHEN;
	}
	/**
	 * @return the dOITUONGCANXULYID
	 */
	@XmlElement(type = String.class)
	public String getDOITUONGCANXULYID() {
		return DOITUONGCANXULYID;
	}
	/**
	 * @param dOITUONGCANXULYID the dOITUONGCANXULYID to set
	 */
	public void setDOITUONGCANXULYID(String dOITUONGCANXULYID) {
		DOITUONGCANXULYID = dOITUONGCANXULYID;
	}

	private String CHUYENSANGMOTCUA;
	private String DAGUIGIAYHEN;
	private String DOITUONGCANXULYID;
	private String COQUANQUANLYID;
	private String CONGDANID;
	private String LOAIHOSOID;
	private String SOHOSO;
	private String HOVATEN;
	private String NGAYSINH;
	private String GIOITINHID;
	private String QUOCTICHID;
	private String SOCMND;
	private String NGAYCAPCMND;
	private String NOICAPCMNDID;
	private String DIENTHOAI;
	private String EMAIL;
	private String TINHTHUONGTRUID;
	private String HUYENTHUONGTRUID;
	private String XATHUONGTRUID;
	private String DIACHITHUONGTRU;
	private String TINHCUTRUID;
	private String HUYENCUTRUID;
	private String XACUTRUID;
	private String DIACHICUTRU;
	private String SOGIAYPHEPLAIXE;
	private String HANGGIAYPHEPLAIXEID;
	private String NGAYCAPGPLX;
	private String NOICAPGPLXID;
	private String NGAYDAUSATHACH;
	private String NOIHOCLAIXEID;
	private String NAMHOCLAIXE;
	private String LYDOCAPDOILAIGPLXID;
	/**
	 * @return the cOQUANQUANLYID
	 */
	@XmlElement(type = String.class)
	public String getCOQUANQUANLYID() {
		return COQUANQUANLYID;
	}
	/**
	 * @param cOQUANQUANLYID the cOQUANQUANLYID to set
	 */
	public void setCOQUANQUANLYID(String cOQUANQUANLYID) {
		COQUANQUANLYID = cOQUANQUANLYID;
	}
	/**
	 * @return the cONGDANID
	 */
	@XmlElement(type = String.class)
	public String getCONGDANID() {
		return CONGDANID;
	}
	/**
	 * @param cONGDANID the cONGDANID to set
	 */
	public void setCONGDANID(String cONGDANID) {
		CONGDANID = cONGDANID;
	}
	/**
	 * @return the lOAIHOSOID
	 */
	@XmlElement(type = String.class)
	public String getLOAIHOSOID() {
		return LOAIHOSOID;
	}
	/**
	 * @param lOAIHOSOID the lOAIHOSOID to set
	 */
	public void setLOAIHOSOID(String lOAIHOSOID) {
		LOAIHOSOID = lOAIHOSOID;
	}
	/**
	 * @return the sOHOSO
	 */
	@XmlElement(type = String.class)
	public String getSOHOSO() {
		return SOHOSO;
	}
	/**
	 * @param sOHOSO the sOHOSO to set
	 */
	public void setSOHOSO(String sOHOSO) {
		SOHOSO = sOHOSO;
	}
	/**
	 * @return the hOVATEN
	 */
	@XmlElement(type = String.class)
	public String getHOVATEN() {
		return HOVATEN;
	}
	/**
	 * @param hOVATEN the hOVATEN to set
	 */
	public void setHOVATEN(String hOVATEN) {
		HOVATEN = hOVATEN;
	}
	/**
	 * @return the nGAYSINH
	 */
	@XmlElement(type = String.class)
	public String getNGAYSINH() {
		return NGAYSINH;
	}
	/**
	 * @param nGAYSINH the nGAYSINH to set
	 */
	public void setNGAYSINH(String nGAYSINH) {
		NGAYSINH = nGAYSINH;
	}
	/**
	 * @return the gIOITINHID
	 */
	@XmlElement(type = String.class)
	public String getGIOITINHID() {
		return GIOITINHID;
	}
	/**
	 * @param gIOITINHID the gIOITINHID to set
	 */
	public void setGIOITINHID(String gIOITINHID) {
		GIOITINHID = gIOITINHID;
	}
	/**
	 * @return the qUOCTICHID
	 */
	@XmlElement(type = String.class)
	public String getQUOCTICHID() {
		return QUOCTICHID;
	}
	/**
	 * @param qUOCTICHID the qUOCTICHID to set
	 */
	public void setQUOCTICHID(String qUOCTICHID) {
		QUOCTICHID = qUOCTICHID;
	}
	/**
	 * @return the sOCMND
	 */
	@XmlElement(type = String.class)
	public String getSOCMND() {
		return SOCMND;
	}
	/**
	 * @param sOCMND the sOCMND to set
	 */
	public void setSOCMND(String sOCMND) {
		SOCMND = sOCMND;
	}
	/**
	 * @return the nGAYCAPCMND
	 */
	@XmlElement(type = String.class)
	public String getNGAYCAPCMND() {
		return NGAYCAPCMND;
	}
	/**
	 * @param nGAYCAPCMND the nGAYCAPCMND to set
	 */
	public void setNGAYCAPCMND(String nGAYCAPCMND) {
		NGAYCAPCMND = nGAYCAPCMND;
	}
	/**
	 * @return the nOICAPCMNDID
	 */
	@XmlElement(type = String.class)
	public String getNOICAPCMNDID() {
		return NOICAPCMNDID;
	}
	/**
	 * @param nOICAPCMNDID the nOICAPCMNDID to set
	 */
	public void setNOICAPCMNDID(String nOICAPCMNDID) {
		NOICAPCMNDID = nOICAPCMNDID;
	}
	/**
	 * @return the dIENTHOAI
	 */
	@XmlElement(type = String.class)
	public String getDIENTHOAI() {
		return DIENTHOAI;
	}
	/**
	 * @param dIENTHOAI the dIENTHOAI to set
	 */
	public void setDIENTHOAI(String dIENTHOAI) {
		DIENTHOAI = dIENTHOAI;
	}
	/**
	 * @return the eMAIL
	 */
	@XmlElement(type = String.class)
	public String getEMAIL() {
		return EMAIL;
	}
	/**
	 * @param eMAIL the eMAIL to set
	 */
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	/**
	 * @return the gHICHU
	 */
	@XmlElement(type = String.class)
	public String getGHICHU() {
		return GHICHU;
	}
	/**
	 * @param gHICHU the gHICHU to set
	 */
	public void setGHICHU(String gHICHU) {
		GHICHU = gHICHU;
	}
	/**
	 * @return the tINHTHUONGTRUID
	 */
	@XmlElement(type = String.class)
	public String getTINHTHUONGTRUID() {
		return TINHTHUONGTRUID;
	}
	/**
	 * @param tINHTHUONGTRUID the tINHTHUONGTRUID to set
	 */
	public void setTINHTHUONGTRUID(String tINHTHUONGTRUID) {
		TINHTHUONGTRUID = tINHTHUONGTRUID;
	}
	/**
	 * @return the hUYENTHUONGTRUID
	 */
	@XmlElement(type = String.class)
	public String getHUYENTHUONGTRUID() {
		return HUYENTHUONGTRUID;
	}
	/**
	 * @param hUYENTHUONGTRUID the hUYENTHUONGTRUID to set
	 */
	public void setHUYENTHUONGTRUID(String hUYENTHUONGTRUID) {
		HUYENTHUONGTRUID = hUYENTHUONGTRUID;
	}
	/**
	 * @return the xATHUONGTRUID
	 */
	@XmlElement(type = String.class)
	public String getXATHUONGTRUID() {
		return XATHUONGTRUID;
	}
	/**
	 * @param xATHUONGTRUID the xATHUONGTRUID to set
	 */
	public void setXATHUONGTRUID(String xATHUONGTRUID) {
		XATHUONGTRUID = xATHUONGTRUID;
	}
	/**
	 * @return the dIACHITHUONGTRU
	 */
	@XmlElement(type = String.class)
	public String getDIACHITHUONGTRU() {
		return DIACHITHUONGTRU;
	}
	/**
	 * @param dIACHITHUONGTRU the dIACHITHUONGTRU to set
	 */
	public void setDIACHITHUONGTRU(String dIACHITHUONGTRU) {
		DIACHITHUONGTRU = dIACHITHUONGTRU;
	}
	/**
	 * @return the tINHCUTRUID
	 */
	@XmlElement(type = String.class)
	public String getTINHCUTRUID() {
		return TINHCUTRUID;
	}
	/**
	 * @param tINHCUTRUID the tINHCUTRUID to set
	 */
	public void setTINHCUTRUID(String tINHCUTRUID) {
		TINHCUTRUID = tINHCUTRUID;
	}
	/**
	 * @return the hUYENCUTRUID
	 */
	@XmlElement(type = String.class)
	public String getHUYENCUTRUID() {
		return HUYENCUTRUID;
	}
	/**
	 * @param hUYENCUTRUID the hUYENCUTRUID to set
	 */
	public void setHUYENCUTRUID(String hUYENCUTRUID) {
		HUYENCUTRUID = hUYENCUTRUID;
	}
	/**
	 * @return the xACUTRUID
	 */
	@XmlElement(type = String.class)
	public String getXACUTRUID() {
		return XACUTRUID;
	}
	/**
	 * @param xACUTRUID the xACUTRUID to set
	 */
	public void setXACUTRUID(String xACUTRUID) {
		XACUTRUID = xACUTRUID;
	}
	/**
	 * @return the dIACHICUTRU
	 */
	@XmlElement(type = String.class)
	public String getDIACHICUTRU() {
		return DIACHICUTRU;
	}
	/**
	 * @param dIACHICUTRU the dIACHICUTRU to set
	 */
	public void setDIACHICUTRU(String dIACHICUTRU) {
		DIACHICUTRU = dIACHICUTRU;
	}
	/**
	 * @return the sOGIAYPHEPLAIXE
	 */
	@XmlElement(type = String.class)
	public String getSOGIAYPHEPLAIXE() {
		return SOGIAYPHEPLAIXE;
	}
	/**
	 * @param sOGIAYPHEPLAIXE the sOGIAYPHEPLAIXE to set
	 */
	public void setSOGIAYPHEPLAIXE(String sOGIAYPHEPLAIXE) {
		SOGIAYPHEPLAIXE = sOGIAYPHEPLAIXE;
	}
	/**
	 * @return the hANGGIAYPHEPLAIXEID
	 */
	@XmlElement(type = String.class)
	public String getHANGGIAYPHEPLAIXEID() {
		return HANGGIAYPHEPLAIXEID;
	}
	/**
	 * @param hANGGIAYPHEPLAIXEID the hANGGIAYPHEPLAIXEID to set
	 */
	public void setHANGGIAYPHEPLAIXEID(String hANGGIAYPHEPLAIXEID) {
		HANGGIAYPHEPLAIXEID = hANGGIAYPHEPLAIXEID;
	}
	/**
	 * @return the nGAYCAPGPLX
	 */
	@XmlElement(type = String.class)
	public String getNGAYCAPGPLX() {
		return NGAYCAPGPLX;
	}
	/**
	 * @param nGAYCAPGPLX the nGAYCAPGPLX to set
	 */
	public void setNGAYCAPGPLX(String nGAYCAPGPLX) {
		NGAYCAPGPLX = nGAYCAPGPLX;
	}
	/**
	 * @return the nOICAPGPLXID
	 */
	@XmlElement(type = String.class)
	public String getNOICAPGPLXID() {
		return NOICAPGPLXID;
	}
	/**
	 * @param nOICAPGPLXID the nOICAPGPLXID to set
	 */
	public void setNOICAPGPLXID(String nOICAPGPLXID) {
		NOICAPGPLXID = nOICAPGPLXID;
	}
	/**
	 * @return the nGAYDAUSATHACH
	 */
	@XmlElement(type = String.class)
	public String getNGAYDAUSATHACH() {
		return NGAYDAUSATHACH;
	}
	/**
	 * @param nGAYDAUSATHACH the nGAYDAUSATHACH to set
	 */
	public void setNGAYDAUSATHACH(String nGAYDAUSATHACH) {
		NGAYDAUSATHACH = nGAYDAUSATHACH;
	}
	/**
	 * @return the nOIHOCLAIXEID
	 */
	@XmlElement(type = String.class)
	public String getNOIHOCLAIXEID() {
		return NOIHOCLAIXEID;
	}
	/**
	 * @param nOIHOCLAIXEID the nOIHOCLAIXEID to set
	 */
	public void setNOIHOCLAIXEID(String nOIHOCLAIXEID) {
		NOIHOCLAIXEID = nOIHOCLAIXEID;
	}
	/**
	 * @return the nAMHOCLAIXE
	 */
	@XmlElement(type = String.class)
	public String getNAMHOCLAIXE() {
		return NAMHOCLAIXE;
	}
	/**
	 * @param nAMHOCLAIXE the nAMHOCLAIXE to set
	 */
	public void setNAMHOCLAIXE(String nAMHOCLAIXE) {
		NAMHOCLAIXE = nAMHOCLAIXE;
	}
	/**
	 * @return the lYDOCAPDOILAIGPLXID
	 */
	@XmlElement(type = String.class)
	public String getLYDOCAPDOILAIGPLXID() {
		return LYDOCAPDOILAIGPLXID;
	}
	/**
	 * @param lYDOCAPDOILAIGPLXID the lYDOCAPDOILAIGPLXID to set
	 */
	public void setLYDOCAPDOILAIGPLXID(String lYDOCAPDOILAIGPLXID) {
		LYDOCAPDOILAIGPLXID = lYDOCAPDOILAIGPLXID;
	}
}
