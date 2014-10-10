package org.oep.sharedservice.exch.provider.hoso.business;

import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.oep.sharedservice.exch.provider.soap.OnlineAttachmentSoap;
import org.oep.sharedservice.exch.provider.soap.OnlineDocumentSoap;
import org.oep.sharedservice.exch.provider.soap.OnlineDocumentSoapList;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;


import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.FileDinhKem;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.thamso.model.AnhXa;
import org.oep.cmon.dao.thamso.model.ThamSo;
import org.oep.cmon.dao.thamso.service.AnhXaLocalServiceUtil;
import org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;
import org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil;
import org.oep.exch.dao.hoso.model.ExchFileDinhKem;
import org.oep.exch.dao.hoso.model.HoSoTrucTuyen;
import org.oep.exch.dao.hoso.model.HoSoTrucTuyenClp;

import org.oep.exch.dao.hoso.service.ExchFileDinhKemLocalServiceUtil;
import org.oep.exch.dao.hoso.service.HoSoTrucTuyenLocalServiceUtil;

/** 
 * OnlineDocumentBs class
 * 
 * This class contains all logics to get data in exch_hosotructuyen and exch_filedinhkem table
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  20-May-2013  Nam Dinh    Create new
 */
public class OnlineDocumentBs {
	
	/** Pull 10 document for each call */
	private static final int MAX_RECORD = 10;
	
	/** Online document list */
	private OnlineDocumentSoapList onlineDocumentSoapList = null;
	
	/**
	 * Parametered constructor
	 * 
	 * @param onlineDocumentSoapList
	 */
	public OnlineDocumentBs( OnlineDocumentSoapList onlineDocumentSoapList) {
		this.onlineDocumentSoapList = onlineDocumentSoapList;
	}
	
	/**
	 * Default constructor
	 */
	public OnlineDocumentBs() {
		this.onlineDocumentSoapList = new OnlineDocumentSoapList();		
	}

	/**
	 * @return the onlineDocumentSoapList
	 */
	public OnlineDocumentSoapList getOnlineDocumentSoapList() {
		return onlineDocumentSoapList;
	}

	/**
	 * @param onlineDocumentSoapList the onlineDocumentSoapList to set
	 */
	public void setOnlineDocumentSoapList(
			OnlineDocumentSoapList onlineDocumentSoapList) {
		this.onlineDocumentSoapList = onlineDocumentSoapList;
	}
	
	/**
	 * Get online document
	 * 
	 * @return
	 * @throws SystemException 
	 */
	public OnlineDocumentSoapList getOnlineDocument(String maDonViTiepNhan) throws Exception, SystemException {		
		// Get all ho so that not transferred yet
		List<HoSoTrucTuyen> lst = HoSoTrucTuyenLocalServiceUtil.findByMaDonViTiepNhan(maDonViTiepNhan, 0);
		int cnt = lst.size();		
		
		if ( cnt  < 1) {
			// Return empty list
			return this.onlineDocumentSoapList;
		}
		
		int max = cnt;		
		
		// Only transfer 10 record each calls
		if ( max > MAX_RECORD) {
			max = MAX_RECORD;
			this.onlineDocumentSoapList.setConTiep(1);
		}
		
		ArrayList<OnlineDocumentSoap> onlineLst = new ArrayList<OnlineDocumentSoap>();		

		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");		 
		
		for (int i = 0; i < max; i++){
			HoSoTrucTuyen hoSoTrucTuyen = lst.get(i);
					
			// Create the soap object
			OnlineDocumentSoap soap = new OnlineDocumentSoap();
			
			// Online id (use the id in exch_hosotructuyen table)
			soap.setOnlineId( hoSoTrucTuyen.getId());
			
			// Ma loai ho so (ma dich vu cong)
			soap.setMaLoaiHoSo(hoSoTrucTuyen.getMaLoaiHoSo());
			
			// Ma don vi tiep nhan
			soap.setMaDonViTiepNhan(hoSoTrucTuyen.getMaDonViTiepNhan());
			
			// Ho va ten nguoi nop
			soap.setHoTenNguoiNop(hoSoTrucTuyen.getHoTenNguoiNop());
			
			// Dia chi nguoi nop
			soap.setDiaChiNguoiNop(hoSoTrucTuyen.getDiaChiNguoiNop());
			
			// Ngay sinh
			soap.setNgaySinh(df.format(hoSoTrucTuyen.getNgaySinh()));
			
			// So cmnd
			soap.setSoCmnd(hoSoTrucTuyen.getSoCmnd());
			
			// Email
			soap.setEmail(hoSoTrucTuyen.getEmail());
			
			// So dt co dinh
			soap.setSoDtCoDinh(hoSoTrucTuyen.getSoDtCoDinh());
			
			// SO dt di dong
			soap.setSoDtDiDong(hoSoTrucTuyen.getSoDtDiDong());
			
			// Ngay dang ky ho so
			soap.setNgayDangKyHoSo(df.format(hoSoTrucTuyen.getNgayDangKyHoSo()));
			
			// Gioi Tinh
			soap.setGioiTinh(hoSoTrucTuyen.getGioiTinh());
			
			// Chu so huu ho so
			soap.setChuSoHuuHoSo(hoSoTrucTuyen.getChuSoHuuHoSo());
	
			// Get file dinh kem
			List <ExchFileDinhKem> lstFileDinhKem = ExchFileDinhKemLocalServiceUtil.findByOnlineId(hoSoTrucTuyen.getId());
			
			ArrayList<OnlineAttachmentSoap> onlineAttachmentSoapLst = new ArrayList<OnlineAttachmentSoap>();
			
			for (int j = 0; j < lstFileDinhKem.size(); j ++) {
				
				ExchFileDinhKem file = lstFileDinhKem.get(j);
				
				OnlineAttachmentSoap onlineAttachmentSoap = new OnlineAttachmentSoap();
				
				// Ten tai lieu dinh kem
				onlineAttachmentSoap.setTenTaiLieuDinhKem(new String(file.getTenFile().getBytes(Charset.forName("UTF-8")), Charset.forName("UTF-8")));
				
				// URL dung de download tai lieu dinh kem
				onlineAttachmentSoap.setUrlTaiLieuDinhKem(file.getUrlTaiLieuDinhKem());
				
				// Ten file upload
				onlineAttachmentSoap.setTenFile(file.getTenFile());
				
				// Add to array
				onlineAttachmentSoapLst.add(onlineAttachmentSoap);				
			}
			
			// Add attachment list to soap
			soap.setAttachmentList(onlineAttachmentSoapLst);
			
			onlineLst.add(soap);
		}
		
		
		this.onlineDocumentSoapList.setOnlineDocumentSoapList(onlineLst);		
		
		return this.onlineDocumentSoapList;		
	}
	
	/**
	 * Move a hoso to communication layer
	 * 
	 * @param hoSoOnlineId
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void moveToCommunicationLayer(long hoSoOnlineId) throws SystemException, PortalException {
		// Get HoSo thutuc hanh chinh cong
		HoSoTTHCCong hoSo = null;
		
		// Incase data not found
		try {
			hoSo = HoSoTTHCCongLocalServiceUtil.getHoSoTTHCCong(hoSoOnlineId);
		} catch (Exception e) {
			try {
				hoSo = HoSoTTHCCongLocalServiceUtil.getHoSoTTHCCong(hoSoOnlineId);
			} catch (Exception e1) {
				return;
			}
		}
		
		// This to make sure ho so is not found, incase the above code does not throw exception
		if (hoSo == null) {
			return;
		}
		
		// Get cong dan nop information
		CongDan congDan = CongDanLocalServiceUtil.getCongDan(hoSo.getCongDanNopId());
		
		// Insert data to ho so truc tuyen table
		HoSoTrucTuyen hoSoTrucTuyen = new HoSoTrucTuyenClp();
		
		// Record id
		hoSoTrucTuyen.setId(CounterLocalServiceUtil.increment("exch_hosotructuyen"));
		
		// Ngay trich xuat
		hoSoTrucTuyen.setNgayTrichXuat(new Date());
		
		// Online ID
		hoSoTrucTuyen.setOnlineId(hoSo.getId());
		
		// Get gropu dich vu cong id
		ThuTucHanhChinh thuTuc = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(hoSo.getThuTucHanhChinhId());
		
		// BinhNT Add 2013-10-16
		long danhMucUngDungId = getDanhMucUngDungId(hoSo.getThuTucHanhChinhId());

		List<AnhXa> listTHU = AnhXaLocalServiceUtil.getMaKhacExCh(thuTuc.getMa(), "CMON_THUTUCHANHCHINH", danhMucUngDungId);
		
		if (listTHU != null && listTHU.size() > 0) {
			// Ma dich vu cong
			try {
				if (listTHU.get(0).getMaKhac() == null || listTHU.get(0).getMaKhac().trim().length() == 0) {
					hoSoTrucTuyen.setMaLoaiHoSo(thuTuc.getMa());
					return;
				} else {
					hoSoTrucTuyen.setMaLoaiHoSo(listTHU.get(0).getMaKhac());
				}
			} catch (Exception e){
				hoSoTrucTuyen.setMaLoaiHoSo(listTHU.get(0).getMaKhac());
			}
		} else {
			// Ma dich vu cong
			hoSoTrucTuyen.setMaLoaiHoSo(thuTuc.getMa());
		}
		
		// End  BinhNT ADD
		
		CoQuanQuanLy coQuan = CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(hoSo.getCoQuanTiepNhanId());
		
		// BinhNT Add 2013-10-16
		List<AnhXa> list = AnhXaLocalServiceUtil.getMaKhacExCh(coQuan.getMa(), "CMON_COQUANQUANLY");
		if (list != null && list.size() > 0) {
			// Ma don vi tiep nhan
			hoSoTrucTuyen.setMaDonViTiepNhan(list.get(0).getMaKhac());
		} else {
			hoSoTrucTuyen.setMaDonViTiepNhan(coQuan.getMa());
		}
		// End  BinhNT ADD
		
		// Ho va ten nguoi nop
		hoSoTrucTuyen.setHoTenNguoiNop(congDan.getTenDayDu());
		
		// Dia chi nguoi nop
		hoSoTrucTuyen.setDiaChiNguoiNop(this.getDiaChiThuongTruCongDan(congDan));
		
		// Ngay sinh
		hoSoTrucTuyen.setNgaySinh(congDan.getNgaySinh());
		
		// So cmnd
		hoSoTrucTuyen.setSoCmnd(congDan.getSoCmnd());
		
		// Email
		hoSoTrucTuyen.setEmail(congDan.getEmail());
		
		// So dt co dinh
		hoSoTrucTuyen.setSoDtCoDinh(congDan.getDienThoaiCoDinh());
		
		// So dt di dong
		hoSoTrucTuyen.setSoDtDiDong(congDan.getDienThoaiDiDong());
		
		// Ngay dang ky ho so
		hoSoTrucTuyen.setNgayDangKyHoSo(hoSo.getNgayNopHoSo());
		
		// Insert to DB
		HoSoTrucTuyenLocalServiceUtil.addHoSoTrucTuyen(hoSoTrucTuyen);		
		
		// Get giay to dinh kem ho so when cong dan nop
		List<FileDinhKem> fileDinhKemLst = FileDinhKemLocalServiceUtil.findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(hoSoOnlineId);
		
		// Get the prefix
		ThamSo prefixThamSo = ThamSoLocalServiceUtil.findByTen("PORTAL_PREFIX");
		String portalPrefix = prefixThamSo.getGiaTri();
				
		// Insert file dinh kem
//		for (FileDinhKem fileDinhKem: fileDinhKemLst) {
//			ExchFileDinhKem file = new ExchFileDinhKemImpl();
//			
//			file.setId(CounterLocalServiceUtil.increment("exch_filedinhkem"));
//			
//			file.setOnlineId(hoSoTrucTuyen.getId());
//			
//			// Get tai lieu chuc thuc record
//			TaiLieuChungThuc taiLieu = null;
//			try {
//				taiLieu = TaiLieuChungThucLocalServiceUtil.getTaiLieuChungThuc(fileDinhKem.getNoiLuuTruTaiLieuId());
//			} catch (Exception e1) {
//				try {
//					taiLieu = TaiLieuChungThucLocalServiceUtil.getTaiLieuChungThuc(fileDinhKem.getNoiLuuTruTaiLieuId());
//				} catch (Exception e) {
//					e.printStackTrace();
//					continue;
//				}
//			}
//			
//			if (taiLieu == null  || taiLieu.getNoiLuuTruId() < 1  ) {
//				// Ignore this file dinh kem because it has no uploaded file
//				continue;
//			}
//			
//			String tenTaiLieu = taiLieu.getTen();
//			
//			file.setTenTaiLieuDinhKem(tenTaiLieu);
//			
//			Map<String,String> fileMap = this.makeTaiLieuDinhKem(taiLieu.getNoiLuuTruId(), portalPrefix, tenTaiLieu);
//			
//			file.setUrlTaiLieuDinhKem(fileMap.get("url"));
//			
//			file.setTenFile(fileMap.get("fileName"));
//			try {
//				ExchFileDinhKemLocalServiceUtil.addExchFileDinhKem(file);
//			} catch (Exception es) {
//				continue;
//			}
//		}		
	}
	
	/**
	 * Get dia chi thuong tru of cong dan
	 * 
	 * @param congDan
	 * @return dia chi thuong tru
	 */
	private String getDiaChiThuongTruCongDan(CongDan congDan) {
		StringBuilder result = new StringBuilder();
		try {
			result.append(congDan.getDiaChiThuongTru()).append(",");
			result.append(DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(congDan.getDiaChiThuongTruXaId()).getTen()).append(",");
			result.append(DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(congDan.getDiaChiThuongTruHuyenId()).getTen()).append(",");
			result.append(DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(congDan.getDiaChiThuongTruTinhId()).getTen());
			
		} catch (Exception e) {
			return StringPool.BLANK;
		}
		
		return result.toString();
	}
	
	/**
	 * Construct download URL for file dinh kem
	 * 
	 * @param noiLuuTruId
	 * @param hostPrefix
	 * @param tenTaiLieu
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private Map<String, String> makeTaiLieuDinhKem(long noiLuuTruId, String hostPrefix, String tenTaiLieu) throws PortalException, SystemException {
		FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(noiLuuTruId);
		
		// Download URL
		String url =    hostPrefix + "/documents/" 
                	+ fileEntry.getGroupId() 
                	+ StringPool.SLASH 
                	+ fileEntry.getFolderId() 
                	+ StringPool.SLASH 
                	+ fileEntry.getTitle() + "?version=" + fileEntry.getVersion();
		
		// Return data
		Map<String, String> fileMap = new HashMap<String,String>();
		
		fileMap.put("url", url);
		
		String fileExtension = fileEntry.getExtension();
		
		//tenTaiLieu = AccentUtil.removeAccent(tenTaiLieu);
		
		tenTaiLieu = tenTaiLieu + "." + fileExtension;
		
		fileMap.put("fileName", tenTaiLieu);
		
		return fileMap;		
	}
	
	private long getDanhMucUngDungId(long thuTucHanhChinhId) {
		ThuTucHanhChinh thuTuc = null;
		NhomThuTucHanhChinh nhomThuTucHanhChinh = null;
		DanhMucUngDung danhMucUngDung = null;
		try {
			thuTuc = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(thuTucHanhChinhId);
		} catch (Exception e) {
			try {
				thuTuc = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(thuTucHanhChinhId);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (thuTuc != null) {
			try {
				nhomThuTucHanhChinh = NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(thuTuc.getNhomThuTucHanhChinhId());
			} catch (Exception e) {
				try {
					nhomThuTucHanhChinh = NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(thuTuc.getNhomThuTucHanhChinhId());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (nhomThuTucHanhChinh != null) {
				try {
					danhMucUngDung = DanhMucUngDungLocalServiceUtil.getDanhMucUngDung(nhomThuTucHanhChinh.getDanhMucUngDungId());
				} catch (Exception e) {
					try {
						danhMucUngDung = DanhMucUngDungLocalServiceUtil.getDanhMucUngDung(nhomThuTucHanhChinh.getDanhMucUngDungId());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (danhMucUngDung != null) {
					return danhMucUngDung.getId();
				}
			}
		}
		return 0;
	}
}
