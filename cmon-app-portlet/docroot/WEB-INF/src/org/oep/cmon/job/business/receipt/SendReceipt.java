/**
 * 
 */
package org.oep.cmon.job.business.receipt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.oep.cmon.job.util.ReceiptSendMailUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import vn.dtt.cmon.mail.MailContext;
import vn.dtt.cmon.mail.MailTemplateUtil;
import vn.dtt.cmon.mail.SendMailUtil;

/** 
 * This is class SendReceipt
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  28-May-2013  Nam Dinh    Create new
 */
public class SendReceipt {

	/** Mail template */
	private final String MAIL_TEMPLATE = "vn/dtt/cmon/job/template/receiptDocument.html";

	/** Mail config file */
	private final String MAIL_CONFIG = "vn/dtt/cmon/job/template/mail_config.properties";

	public SendReceipt() {
	}

	/**
	 * This is  function loadDocumentSendReceipt
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 */  
	public void loadDocumentSendReceipt() {
		List<HoSoTTHCCong> results = findListHoSoTTHCCong();
		for (HoSoTTHCCong hoSoTTHCCong : results) {
			sendMail(hoSoTTHCCong);
		}
	}

	/**
	 * This is  function sendMail
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoSoTTHCCong
	 */  
	private void sendMail(HoSoTTHCCong hoSoTTHCCong) {
		StringBuilder danhSachTaiLieuDinhKem = new StringBuilder();

		// Get Mail template content
		URL resource = this.getClass().getClassLoader().getResource(MAIL_TEMPLATE);

		MailContext context = new MailContext();

		// Bind value to value place holder

		context.setProperty("Kinh_gui_co_quan", hoSoTTHCCong.getTenCoQuanTiepNhan());
		context.setProperty("ngay", (new SimpleDateFormat("dd")).format(new Date()));
		context.setProperty("thang", (new SimpleDateFormat("MM")).format(new Date()));
		context.setProperty("nam", (new SimpleDateFormat("yyyy")).format(new Date()));
		context.setProperty("ma_ho_so", hoSoTTHCCong.getMaSoHoSo());
		context.setProperty("ho_ten_can_bo_tiep_nhan", hoSoTTHCCong.getTenCanBoTiepNhan());
		context.setProperty("chuc_vu_can_bo_tiep_nhan", hoSoTTHCCong.getChucVuCanBoTiepNhan());
		context.setProperty("ho_ten_nguoi_lap_ho_so", hoSoTTHCCong.getHoTenNguoiNopHoSo());
		context.setProperty("dia_chi_thuong_tru", hoSoTTHCCong.getDiaChiThuongTruNguoiNop());
		context.setProperty("so_dien_thoai", hoSoTTHCCong.getSoDienThoaiDiDongNguoiNop());
		context.setProperty("ten_thu_tuc_tiep_nhan", hoSoTTHCCong.getTenThuTucHanhChinh());
		context.setProperty("ngay_nhan", (new SimpleDateFormat("dd/MM/yyyy")).format(hoSoTTHCCong.getNgayNhanHoSo()));
		context.setProperty("ngay_tra", (new SimpleDateFormat("dd/MM/yyyy")).format(hoSoTTHCCong.getNgayHenTraKetQua()));

		// Lay cac tai lieu dinh kem.
		BigDecimal taiLieuChungThucId = null;
//		List listDinhKems;
//		try {
//			listDinhKems = FileDinhKemLocalServiceUtil.findByHoSoTTHCCongId(hoSoTTHCCong.getId());
//			int index = 1;
//			for (int i = 0; i < listDinhKems.size(); i++) {
//				taiLieuChungThucId = (BigDecimal)listDinhKems.get(i); 
//				// Truong hop co ma tailieuchungthucId
//				if (taiLieuChungThucId != null) {
//					TaiLieuChungThuc taiLieuChungThuc = TaiLieuChungThucLocalServiceUtil.fetchTaiLieuChungThuc(taiLieuChungThucId.longValue());
//					if (taiLieuChungThuc != null) {
//						danhSachTaiLieuDinhKem.append("<tr><td></td><td>");
//						danhSachTaiLieuDinhKem.append(index++).append(".").append(taiLieuChungThuc.getTen()).append("</td></tr>");
//					}
//				}
//			}
//			// Danh sach tai lieu 2 la:
//			List<FileUpload> liFileUploads = FileUploadLocalServiceUtil.findByHosotthcCongId(hoSoTTHCCong.getId());
//			for (FileUpload fileUpload : liFileUploads) {
//				danhSachTaiLieuDinhKem.append("<tr><td></td><td>");
//				danhSachTaiLieuDinhKem.append(index++).append(".").append(fileUpload.getTenFileUpload()).append("</td></tr>");
//			}
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}

		try {
			// Them danh sach tai lieu dinh kem.
			context.setProperty("ho_so_gom_co", danhSachTaiLieuDinhKem.toString());

			// Create mail content
			String mailContent = MailTemplateUtil.getContent("receiptDocument",	resource.openStream(), context);

			// Get the file from class package structure
			URL configResource = this.getClass().getClassLoader().getResource(MAIL_CONFIG);

			Properties props = new Properties();

			BufferedReader file = new BufferedReader(new InputStreamReader(configResource.openStream(), "utf-8"));
			props.load(file);

			String mailSubject = props.getProperty("MAIL_SUBJECT_CITIZEN_CREATION");
			String fromAddress = props.getProperty("RECEIPT_FROM_ADDRESS");
			String fromPerson = props.getProperty("RECEIPT_FROM_PERSON");

			CongDan congDan = null;
			try {
				try {
					congDan = CongDanLocalServiceUtil.fetchCongDan(hoSoTTHCCong.getCongDanNopId());
				}
				catch (Exception es) {
					es.printStackTrace();
				}
				if (congDan != null) {
					if (congDan.getEmail() != null && congDan.getEmail().trim().length() > 0) {
						SendMailUtil.send(congDan.getEmail(), fromAddress, fromPerson, mailSubject, mailContent);
						
						// Da gui giay hen thanh cong.
						HoSoTTHCCongLocalServiceUtil.updateHOSOTTHCCONGById(hoSoTTHCCong.getId(), ReceiptSendMailUtil.DA_GUI_GIAY_HEN);
					} else {
						// Da gui giay hen thanh cong.
						HoSoTTHCCongLocalServiceUtil.updateHOSOTTHCCONGById(hoSoTTHCCong.getId(), ReceiptSendMailUtil.KHONG_GUI_GIAY_HEN_KHONG_CO_EMAIL);
					}
				} else {
					// Truong hop khong co tai khoan cong dan.
					HoSoTTHCCongLocalServiceUtil.updateHOSOTTHCCONGById(hoSoTTHCCong.getId(), ReceiptSendMailUtil.KHONG_GUI_GIAY_HEN);
				}
			}
			catch (Exception es) {
				es.printStackTrace();
			}
		} catch (Exception e) {

			// Sending mail failure should not stop the process flow

			// so this exception is swallowed and stack trace is printed out
			// here

			e.printStackTrace();
		}
	}

	/**
	 * This is  function findListHoSoTTHCCong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param findListHoSoTTHCCong
	 * @return List<HoSoTTHCCong>
	 */  
	private List<HoSoTTHCCong> findListHoSoTTHCCong() {
		List<HoSoTTHCCong> results = new ArrayList<HoSoTTHCCong>();
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(HoSoTTHCCong.class);

		// This is a test line for display all request if there's no search
		// criteria
		Criterion loaiHoSo = RestrictionsFactoryUtil.eq("loaiHoSo", 0); // 0:
																			// online,
																			// 1:
																			// khong
																			// online
		Criterion daGuiGiayHen = RestrictionsFactoryUtil
				.eq("daGuiGiayHen", 0); // 0: chua gui, 1: da gui
		Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
		Criterion criteriaNgayTraKetQua = RestrictionsFactoryUtil
				.isNotNull("ngayHenTraKetQua");

		// Define search criteria
		query = query.add(loaiHoSo).add(criteriaNgayTraKetQua)
				.add(daGuiGiayHen).add(criteriaTrangThai);

		try {
			results = HoSoTTHCCongLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return results;
	}

}
