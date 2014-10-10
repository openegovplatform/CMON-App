/*
 * Copyright (c) 2014 by Open eGovPlatform (http://http://openegovplatform.org/).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.oep.cmon.report.portlet.util;

import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.PortletConfig;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.Region;
import org.oep.cmon.dao.cc.model.impl.CongChucImpl;
import org.oep.cmon.dao.nsd.model.impl.TaiKhoanNguoiDungImpl;
import org.oep.cmon.dao.qlhc.model.impl.CoQuanQuanLyImpl;
import org.oep.cmon.portlet.hosotructiep.HoSoBusinessUtil;

import org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.chungthuc.model.HoSoChungThuc;
import org.oep.cmon.dao.chungthuc.service.HoSoChungThucLocalServiceUtil;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinhClp;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.report.model.Baocaochitiet;
import org.oep.cmon.dao.report.model.DanhMucBaoCao;
import org.oep.cmon.dao.report.model.Lephi_chitiet;
import org.oep.cmon.dao.report.model.Lephi_linhvuc;
import org.oep.cmon.dao.report.model.Lephi_tonghop;
import org.oep.cmon.dao.report.model.ReportThongKe;
import org.oep.cmon.dao.report.model.ReportTongHop;
import org.oep.cmon.dao.report.model.ReportTongHopChiTiet;
import org.oep.cmon.dao.report.service.BaocaochitietLocalServiceUtil;
import org.oep.cmon.dao.report.service.CongChuc2RoleLocalServiceUtil;
import org.oep.cmon.dao.report.service.Lephi_chitietLocalServiceUtil;
import org.oep.cmon.dao.report.service.Lephi_linhvucLocalServiceUtil;
import org.oep.cmon.dao.report.service.Lephi_tonghopLocalServiceUtil;
import org.oep.cmon.dao.report.service.ReportThongKeLocalServiceUtil;
import org.oep.cmon.dao.report.service.ReportTongHopChiTietLocalServiceUtil;
import org.oep.cmon.dao.report.service.ReportTongHopLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * This is class ActionUtil  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
@SuppressWarnings("deprecation")
public class ActionUtil {
	/**
	 * This is function excelTongHopChiTiet
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param req
	 * @param res
	 */
	public static void excelTongHopChiTiet(ResourceRequest req,
			ResourceResponse res) {
		try {
			String id_donvi = req.getParameter("id_donvi");
			String id_loaihoso = req.getParameter("id_loaihoso");
			String thang = req.getParameter("thang");
			String nam = req.getParameter("nam");
			CoQuanQuanLy coQuanQuanLy = new CoQuanQuanLyImpl();
			Set<Long> setIDNhomThuTuc = new HashSet<Long>(0);
			List<ReportTongHopChiTiet> listTongHopChiTiet = ReportTongHopChiTietLocalServiceUtil.getListReportTongHopChiTietGroupByIDThuTuc(id_donvi, id_loaihoso, thang, nam);
			if(id_donvi!=null && !id_donvi.equals("0")){
				coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(Long.valueOf(id_donvi));
			}
			for (int i = 0; i < listTongHopChiTiet.size(); i++) {
				setIDNhomThuTuc.add(listTongHopChiTiet.get(i)
						.getNHOMTHUTUCHANHCHINHID());
			}
			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook
					.createSheet("Bao_cao_tong_hop_chi_tiet");

			// define a cell style
			HSSFFont tableHeaderFont = (HSSFFont) workbook.createFont();
			tableHeaderFont.setBoldweight((short) 5000);

			HSSFFont ngaythangFont = (HSSFFont) workbook.createFont();
			ngaythangFont.setItalic(true);

			HSSFFont titleFont = (HSSFFont) workbook.createFont();
			titleFont.setBoldweight((short) 5000);
			titleFont.setFontHeightInPoints((short) 15);

			HSSFCellStyle styleCellHeader = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellHeader.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellHeader.setFont(tableHeaderFont);
			styleCellHeader.setWrapText(true);

			HSSFCellStyle styleCellNgaythang = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellNgaythang.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellNgaythang
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellNgaythang.setFont(ngaythangFont);
			styleCellNgaythang.setWrapText(true);

			HSSFCellStyle styleCellCenter = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellCenter.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellCenter.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellCenter.setWrapText(true);

			HSSFCellStyle styleCellLeft = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellLeft.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			styleCellLeft.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellLeft.setWrapText(true);

			HSSFCellStyle styleCellRight = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellRight.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			styleCellRight.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellRight.setWrapText(true);
			styleCellRight.setFont(tableHeaderFont);

			HSSFCellStyle styleHeader = (HSSFCellStyle) workbook
					.createCellStyle();
			styleHeader.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleHeader.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleHeader.setFont(tableHeaderFont);
			styleHeader.setWrapText(true);

			HSSFCellStyle styleCellNhomTTHC = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellNhomTTHC.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			styleCellNhomTTHC
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellNhomTTHC.setFont(tableHeaderFont);

			HSSFCellStyle styleTitle = (HSSFCellStyle) workbook
					.createCellStyle();
			styleTitle.setFont(titleFont);
			styleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// end style
			//header bao cao
			int rowNum = 1;
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow rowUBND = sheet.createRow(rowNum);
			rowUBND.createCell(0).setCellValue("");
			rowUBND.getCell(0).setCellStyle(styleCellHeader);

			sheet.addMergedRegion(new Region(rowNum, (short) 2, rowNum,
					(short) 14));
			rowUBND.createCell(2).setCellValue(
					ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.chxhcnvn"));
			rowUBND.getCell(2).setCellStyle(styleCellHeader);

			rowNum++;

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow rowTenDonVi = sheet.createRow(rowNum);
			rowTenDonVi.createCell(0).setCellValue(coQuanQuanLy.getTen());
			rowTenDonVi.getCell(0).setCellStyle(styleCellHeader);

			sheet.addMergedRegion(new Region(rowNum, (short) 2, rowNum,
					(short) 14));
			rowTenDonVi.createCell(2).setCellValue(
					ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.dltdhp"));
			rowTenDonVi.getCell(2).setCellStyle(styleCellHeader);

			rowNum++;
			
			String tieude = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaotonghop.tieude");
			
			String coquan = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.thutuc");
			String tong = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.tong");
			String tiepnhan = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.tiepnhan");
			String kytruocchuyenqua = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.kytruocchuyenqua");
			String hosodagiaiquyet = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.hosodagiaiquyet");
			String hosodanggiaiquyet = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.hosodanggiaiquyet");
			String cdruthoso = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.cdruthoso");
			String hosotralai = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.hosotralai");
			String ghichu = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.ghichu");
			String sohoso = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.sohoso");
			String som = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.som");
			String dung = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.dung");
			String tre = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.tre");
			String chuadenhan = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.chuadenhan");
			String daquahan = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.daquahan");
			String[] header = { "STT",coquan,tong,tiepnhan,kytruocchuyenqua,sohoso,som,dung,tre,sohoso,chuadenhan,daquahan,cdruthoso,hosotralai,ghichu};

			rowNum++;
			int[] width = { 1500, 10000, 2000, 2000, 5000, 2000,2000,2000,2000,2000,2000,2000,3000, 3000,3000};
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum + 1,
					(short) 14));
			HSSFRow titleRow = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell titleCell = titleRow.createCell(0);
			titleCell.setCellStyle(styleTitle);
			titleCell.setCellValue(tieude);

			rowNum += 2;

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 6));

			rowNum = rowNum + 2;
			HSSFRow headerRow1 = (HSSFRow) sheet.createRow(rowNum);
			HSSFRow headerRow2 = (HSSFRow) sheet.createRow(rowNum+1);
			sheet.addMergedRegion(new Region(rowNum, (short) 5, rowNum,	(short)8));
			sheet.addMergedRegion(new Region(rowNum, (short) 9, rowNum,	(short)11));
			for(int i = 0; i < header.length; i++){
				if(i<5 || i>11){
					sheet.addMergedRegion(new Region(rowNum, (short) i, rowNum+1,	(short)i));
				}
				HSSFCell cell = headerRow1.createCell(i);
				cell.setCellStyle(styleHeader);
				cell.setCellValue(header[i]);
				
				HSSFCell cell2 = headerRow2.createCell(i);
				cell2.setCellStyle(styleHeader);
				cell2.setCellValue(header[i]);
				if(i==5){
					cell.setCellValue(hosodagiaiquyet);
				}
				if(i==9){
					cell.setCellValue(hosodanggiaiquyet);
				}
				sheet.setColumnWidth(i, width[i]);
			}
			rowNum++;
			//end header bao cao
			//noi dung bao cao
			rowNum++;
			int stt = 0;
			int tongNhan = 0;
			int tongTiepNhan = 0;
			int tongTonDau = 0;
			int tongDaGiaiQuyet = 0;
			int tongSom = 0;
			int tongDung = 0;
			int tongTre = 0;
			int tongDangGiaiQuyet = 0;
			int tongChuaDenHan = 0;
			int tongDaQuaHan = 0;
			int tongRutHoSo = 0;
			int tongKhongHopLe = 0;
			int tongTonCuoi = 0;
			for (Long s : setIDNhomThuTuc) {
				stt++;
				sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
						(short) 14));
				HSSFRow rowNhomTTHC = (HSSFRow) sheet.createRow(rowNum);
				HSSFCell cellNhomTTHC = rowNhomTTHC.createCell(0);
				cellNhomTTHC.setCellValue(stt+". "+NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(s).getTen());
				cellNhomTTHC.setCellStyle(styleCellNhomTTHC);
				for(int i=1;i<15;i++){
					rowNhomTTHC.createCell(i).setCellStyle(styleCellCenter);
				}
				rowNum++;
				for (int a = 0; a < listTongHopChiTiet.size(); a++) {
					// khai bao dong va cac cell
					if (listTongHopChiTiet.get(a).getNHOMTHUTUCHANHCHINHID()==s) {
						tongNhan += listTongHopChiTiet.get(a).getTONGNHAN();
						tongTiepNhan += listTongHopChiTiet.get(a).getTIEPNHAN();
						tongTonDau += listTongHopChiTiet.get(a).getTONDAU();
						tongDaGiaiQuyet += listTongHopChiTiet.get(a).getTONGDAGIAIQUYET();
						tongSom += listTongHopChiTiet.get(a).getSOM();
						tongDung += listTongHopChiTiet.get(a).getDUNG();
						tongTre += listTongHopChiTiet.get(a).getTRE();
						tongDangGiaiQuyet += listTongHopChiTiet.get(a).getTONGDANGGIAIQUYET();
						tongChuaDenHan += listTongHopChiTiet.get(a).getCHUADENHAN();
						tongDaQuaHan += listTongHopChiTiet.get(a).getQUAHAN();
						tongRutHoSo += listTongHopChiTiet.get(a).getRUTHOSO();
						tongKhongHopLe += listTongHopChiTiet.get(a).getKHONGHOPLE();
						tongTonCuoi += listTongHopChiTiet.get(a).getTONCUOI();
						sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
								(short) 1));
						HSSFRow row = (HSSFRow) sheet.createRow(rowNum);
						HSSFCell cell = row.createCell(0);
						HSSFCell cell1 = row.createCell(1);
						HSSFCell cell2 = row.createCell(2);
						HSSFCell cell3 = row.createCell(3);
						HSSFCell cell4 = row.createCell(4);
						HSSFCell cell5 = row.createCell(5);
						HSSFCell cell6 = row.createCell(6);
						HSSFCell cell7 = row.createCell(7);
						HSSFCell cell8 = row.createCell(8);
						HSSFCell cell9 = row.createCell(9);
						HSSFCell cell10 = row.createCell(10);
						HSSFCell cell11 = row.createCell(11);
						HSSFCell cell12 = row.createCell(12);
						HSSFCell cell13 = row.createCell(13);
						HSSFCell cell14 = row.createCell(14);
						// set style cho cac cell
						cell.setCellStyle(styleCellLeft);
						cell1.setCellStyle(styleCellLeft);
						cell2.setCellStyle(styleCellCenter);
						cell3.setCellStyle(styleCellCenter);
						cell4.setCellStyle(styleCellCenter);
						cell5.setCellStyle(styleCellCenter);
						cell6.setCellStyle(styleCellCenter);
						cell7.setCellStyle(styleCellCenter);
						cell8.setCellStyle(styleCellCenter);
						cell9.setCellStyle(styleCellCenter);
						cell10.setCellStyle(styleCellCenter);
						cell11.setCellStyle(styleCellCenter);
						cell12.setCellStyle(styleCellCenter);
						cell13.setCellStyle(styleCellCenter);
						cell14.setCellStyle(styleCellCenter);
						// set gia tri cho cac cell
						cell.setCellValue(ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(listTongHopChiTiet.get(a).getTHUTUCHANHCHINHID()).getTen());
						//cell1.setCellValue("");
						cell2.setCellValue(listTongHopChiTiet.get(a).getTONGNHAN());
						cell3.setCellValue(listTongHopChiTiet.get(a).getTIEPNHAN());
						cell4.setCellValue(listTongHopChiTiet.get(a).getTONDAU());
						cell5.setCellValue(listTongHopChiTiet.get(a).getTONGDAGIAIQUYET());
						cell6.setCellValue(listTongHopChiTiet.get(a).getSOM());
						cell7.setCellValue(listTongHopChiTiet.get(a).getDUNG());
						cell8.setCellValue(listTongHopChiTiet.get(a).getTRE());
						cell9.setCellValue(listTongHopChiTiet.get(a).getTONGDANGGIAIQUYET());
						cell10.setCellValue(listTongHopChiTiet.get(a).getCHUADENHAN());
						cell11.setCellValue(listTongHopChiTiet.get(a).getQUAHAN());
						cell12.setCellValue(listTongHopChiTiet.get(a).getRUTHOSO());
						cell13.setCellValue(listTongHopChiTiet.get(a).getKHONGHOPLE());
						cell14.setCellValue(listTongHopChiTiet.get(a).getTONCUOI());
						rowNum++;
					}
				}
			}
			//row tong
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow row = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell cell = row.createCell(0);
			HSSFCell cell1 = row.createCell(1);
			HSSFCell cell2 = row.createCell(2);
			HSSFCell cell3 = row.createCell(3);
			HSSFCell cell4 = row.createCell(4);
			HSSFCell cell5 = row.createCell(5);
			HSSFCell cell6 = row.createCell(6);
			HSSFCell cell7 = row.createCell(7);
			HSSFCell cell8 = row.createCell(8);
			HSSFCell cell9 = row.createCell(9);
			HSSFCell cell10 = row.createCell(10);
			HSSFCell cell11 = row.createCell(11);
			HSSFCell cell12 = row.createCell(12);
			HSSFCell cell13 = row.createCell(13);
			HSSFCell cell14 = row.createCell(14);
			// set style cho cac cell
			cell.setCellStyle(styleHeader);
			cell1.setCellStyle(styleHeader);
			cell2.setCellStyle(styleHeader);
			cell3.setCellStyle(styleHeader);
			cell4.setCellStyle(styleHeader);
			cell5.setCellStyle(styleHeader);
			cell6.setCellStyle(styleHeader);
			cell7.setCellStyle(styleHeader);
			cell8.setCellStyle(styleHeader);
			cell9.setCellStyle(styleHeader);
			cell10.setCellStyle(styleHeader);
			cell11.setCellStyle(styleHeader);
			cell12.setCellStyle(styleHeader);
			cell13.setCellStyle(styleHeader);
			cell14.setCellStyle(styleHeader);
			// set gia tri cho cac cell
			cell.setCellValue("Tá»•ng");
			//cell1.setCellValue("");
			cell2.setCellValue(tongNhan);
			cell3.setCellValue(tongTiepNhan);
			cell4.setCellValue(tongTonDau);
			cell5.setCellValue(tongDaGiaiQuyet);
			cell6.setCellValue(tongSom);
			cell7.setCellValue(tongDung);
			cell8.setCellValue(tongTre);
			cell9.setCellValue(tongDangGiaiQuyet);
			cell10.setCellValue(tongChuaDenHan);
			cell11.setCellValue(tongDaQuaHan);
			cell12.setCellValue(tongRutHoSo);
			cell13.setCellValue(tongKhongHopLe);
			cell14.setCellValue(tongTonCuoi);
			//ket thuc row tong
			//ket thuc noi dung bao cao
			

			res.setContentType("application/vnd.ms-excel");
			res.addProperty(HttpHeaders.CACHE_CONTROL,
					"max-age=3600, must-revalidate");
			res.addProperty(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=Baocaotonghop.xls");
			OutputStream out = res.getPortletOutputStream();
			workbook.write(out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is function checkHosoByNHOMTTHCID
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param req
	 * @param res
	 */
	public static void excelTongHopNam(ResourceRequest req,
			ResourceResponse res) {
		try {
			String id_donvi = req.getParameter("id_donvi");
			String id_linhvuc = req.getParameter("id_linhvuc");
			String nam = req.getParameter("nam");
			CoQuanQuanLy coQuanQuanLy = new CoQuanQuanLyImpl();
			Set<Long> setIDNhomThuTuc = new HashSet<Long>(0);
			List<ReportTongHop> listTongHopChiTiet = ActionUtil.getListReportTongHop(id_donvi, id_linhvuc, nam);
			if(id_donvi!=null && !id_donvi.equals("0")){
				coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(Long.valueOf(id_donvi));
			}
			for (int i = 0; i < listTongHopChiTiet.size(); i++) {
				setIDNhomThuTuc.add(listTongHopChiTiet.get(i)
						.getNHOMTHUTUCHANHCHINHID());
			}
			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook
					.createSheet("Bao_cao_tong_hop_theo_nam");

			// define a cell style
			HSSFFont tableHeaderFont = (HSSFFont) workbook.createFont();
			tableHeaderFont.setBoldweight((short) 5000);

			HSSFFont ngaythangFont = (HSSFFont) workbook.createFont();
			ngaythangFont.setItalic(true);

			HSSFFont titleFont = (HSSFFont) workbook.createFont();
			titleFont.setBoldweight((short) 5000);
			titleFont.setFontHeightInPoints((short) 15);

			HSSFCellStyle styleCellHeader = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellHeader.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellHeader.setFont(tableHeaderFont);
			styleCellHeader.setWrapText(true);

			HSSFCellStyle styleCellNgaythang = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellNgaythang.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellNgaythang
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellNgaythang.setFont(ngaythangFont);
			styleCellNgaythang.setWrapText(true);

			HSSFCellStyle styleCellCenter = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellCenter.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellCenter.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellCenter.setWrapText(true);

			HSSFCellStyle styleCellLeft = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellLeft.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			styleCellLeft.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellLeft.setWrapText(true);

			HSSFCellStyle styleCellRight = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellRight.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			styleCellRight.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellRight.setWrapText(true);
			styleCellRight.setFont(tableHeaderFont);

			HSSFCellStyle styleHeader = (HSSFCellStyle) workbook
					.createCellStyle();
			styleHeader.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleHeader.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleHeader.setFont(tableHeaderFont);
			styleHeader.setWrapText(true);

			HSSFCellStyle styleCellNhomTTHC = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellNhomTTHC.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			styleCellNhomTTHC
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellNhomTTHC.setFont(tableHeaderFont);

			HSSFCellStyle styleTitle = (HSSFCellStyle) workbook
					.createCellStyle();
			styleTitle.setFont(titleFont);
			styleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// end style
			//header bao cao
			int rowNum = 1;
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow rowUBND = sheet.createRow(rowNum);
			rowUBND.createCell(0).setCellValue("");
			rowUBND.getCell(0).setCellStyle(styleCellHeader);

			sheet.addMergedRegion(new Region(rowNum, (short) 2, rowNum,
					(short) 14));
			rowUBND.createCell(2).setCellValue(
					ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.chxhcnvn"));
			rowUBND.getCell(2).setCellStyle(styleCellHeader);

			rowNum++;

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow rowTenDonVi = sheet.createRow(rowNum);
			rowTenDonVi.createCell(0).setCellValue(coQuanQuanLy.getTen());
			rowTenDonVi.getCell(0).setCellStyle(styleCellHeader);

			sheet.addMergedRegion(new Region(rowNum, (short) 2, rowNum,
					(short) 14));
			rowTenDonVi.createCell(2).setCellValue(
					ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.dltdhp"));
			rowTenDonVi.getCell(2).setCellStyle(styleCellHeader);

			rowNum++;
			
			String tieude = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaotonghop.tieude");
			
			String coquan = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.thang");
			String tong = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.tong");
			String tiepnhan = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.tiepnhan");
			String kytruocchuyenqua = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.kytruocchuyenqua");
			String hosodagiaiquyet = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.hosodagiaiquyet");
			String hosodanggiaiquyet = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.hosodanggiaiquyet");
			String cdruthoso = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.cdruthoso");
			String hosotralai = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.hosotralai");
			String ghichu = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.ghichu");
			String sohoso = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.sohoso");
			String som = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.som");
			String dung = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.dung");
			String tre = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.tre");
			String chuadenhan = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.chuadenhan");
			String daquahan = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.daquahan");
			String[] header = { "STT",coquan,tong,tiepnhan,kytruocchuyenqua,sohoso,som,dung,tre,sohoso,chuadenhan,daquahan,cdruthoso,hosotralai,ghichu};

			rowNum++;
			int[] width = { 1500, 10000, 2000, 2000, 5000, 2000,2000,2000,2000,2000,2000,2000,3000, 3000,3000};
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum + 1,
					(short) 14));
			HSSFRow titleRow = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell titleCell = titleRow.createCell(0);
			titleCell.setCellStyle(styleTitle);
			titleCell.setCellValue(tieude);

			rowNum += 2;

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 6));

			rowNum = rowNum + 2;
			HSSFRow headerRow1 = (HSSFRow) sheet.createRow(rowNum);
			HSSFRow headerRow2 = (HSSFRow) sheet.createRow(rowNum+1);
			sheet.addMergedRegion(new Region(rowNum, (short) 5, rowNum,	(short)8));
			sheet.addMergedRegion(new Region(rowNum, (short) 9, rowNum,	(short)11));
			for(int i = 0; i < header.length; i++){
				if(i<5 || i>11){
					sheet.addMergedRegion(new Region(rowNum, (short) i, rowNum+1,	(short)i));
				}
				HSSFCell cell = headerRow1.createCell(i);
				cell.setCellStyle(styleHeader);
				cell.setCellValue(header[i]);
				
				HSSFCell cell2 = headerRow2.createCell(i);
				cell2.setCellStyle(styleHeader);
				cell2.setCellValue(header[i]);
				if(i==5){
					cell.setCellValue(hosodagiaiquyet);
				}
				if(i==9){
					cell.setCellValue(hosodanggiaiquyet);
				}
				sheet.setColumnWidth(i, width[i]);
			}
			rowNum++;
			//end header bao cao
			//noi dung bao cao
			rowNum++;
			int stt = 0;
			int tongNhan = 0;
			int tongTiepNhan = 0;
			int tongTonDau = 0;
			int tongDaGiaiQuyet = 0;
			int tongSom = 0;
			int tongDung = 0;
			int tongTre = 0;
			int tongDangGiaiQuyet = 0;
			int tongChuaDenHan = 0;
			int tongDaQuaHan = 0;
			int tongRutHoSo = 0;
			int tongKhongHopLe = 0;
			int tongTonCuoi = 0;
			for (Long s : setIDNhomThuTuc) {
				stt++;
				sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
						(short) 14));
				HSSFRow rowNhomTTHC = (HSSFRow) sheet.createRow(rowNum);
				HSSFCell cellNhomTTHC = rowNhomTTHC.createCell(0);
				cellNhomTTHC.setCellValue(stt+". "+NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(s).getTen());
				cellNhomTTHC.setCellStyle(styleCellNhomTTHC);
				for(int i=1;i<15;i++){
					rowNhomTTHC.createCell(i).setCellStyle(styleCellCenter);
				}
				rowNum++;
				for (int a = 0; a < listTongHopChiTiet.size(); a++) {
					// khai bao dong va cac cell
					if (listTongHopChiTiet.get(a).getNHOMTHUTUCHANHCHINHID()==s) {
						tongNhan += listTongHopChiTiet.get(a).getTONGNHAN();
						tongTiepNhan += listTongHopChiTiet.get(a).getTIEPNHAN();
						tongTonDau += listTongHopChiTiet.get(a).getTONDAU();
						tongDaGiaiQuyet += listTongHopChiTiet.get(a).getTONGDAGIAIQUYET();
						tongSom += listTongHopChiTiet.get(a).getSOM();
						tongDung += listTongHopChiTiet.get(a).getDUNG();
						tongTre += listTongHopChiTiet.get(a).getTRE();
						tongDangGiaiQuyet += listTongHopChiTiet.get(a).getTONGDANGGIAIQUYET();
						tongChuaDenHan += listTongHopChiTiet.get(a).getCHUADENHAN();
						tongDaQuaHan += listTongHopChiTiet.get(a).getQUAHAN();
						tongRutHoSo += listTongHopChiTiet.get(a).getRUTHOSO();
						tongKhongHopLe += listTongHopChiTiet.get(a).getKHONGHOPLE();
						tongTonCuoi += listTongHopChiTiet.get(a).getTONCUOI();
						sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
								(short) 1));
						HSSFRow row = (HSSFRow) sheet.createRow(rowNum);
						HSSFCell cell = row.createCell(0);
						HSSFCell cell1 = row.createCell(1);
						HSSFCell cell2 = row.createCell(2);
						HSSFCell cell3 = row.createCell(3);
						HSSFCell cell4 = row.createCell(4);
						HSSFCell cell5 = row.createCell(5);
						HSSFCell cell6 = row.createCell(6);
						HSSFCell cell7 = row.createCell(7);
						HSSFCell cell8 = row.createCell(8);
						HSSFCell cell9 = row.createCell(9);
						HSSFCell cell10 = row.createCell(10);
						HSSFCell cell11 = row.createCell(11);
						HSSFCell cell12 = row.createCell(12);
						HSSFCell cell13 = row.createCell(13);
						HSSFCell cell14 = row.createCell(14);
						// set style cho cac cell
						cell.setCellStyle(styleCellLeft);
						cell1.setCellStyle(styleCellLeft);
						cell2.setCellStyle(styleCellCenter);
						cell3.setCellStyle(styleCellCenter);
						cell4.setCellStyle(styleCellCenter);
						cell5.setCellStyle(styleCellCenter);
						cell6.setCellStyle(styleCellCenter);
						cell7.setCellStyle(styleCellCenter);
						cell8.setCellStyle(styleCellCenter);
						cell9.setCellStyle(styleCellCenter);
						cell10.setCellStyle(styleCellCenter);
						cell11.setCellStyle(styleCellCenter);
						cell12.setCellStyle(styleCellCenter);
						cell13.setCellStyle(styleCellCenter);
						cell14.setCellStyle(styleCellCenter);
						// set gia tri cho cac cell
						cell.setCellValue("ThÃ¡ng "+listTongHopChiTiet.get(a).getTHANG());
						//cell1.setCellValue("");
						cell2.setCellValue(listTongHopChiTiet.get(a).getTONGNHAN());
						cell3.setCellValue(listTongHopChiTiet.get(a).getTIEPNHAN());
						cell4.setCellValue(listTongHopChiTiet.get(a).getTONDAU());
						cell5.setCellValue(listTongHopChiTiet.get(a).getTONGDAGIAIQUYET());
						cell6.setCellValue(listTongHopChiTiet.get(a).getSOM());
						cell7.setCellValue(listTongHopChiTiet.get(a).getDUNG());
						cell8.setCellValue(listTongHopChiTiet.get(a).getTRE());
						cell9.setCellValue(listTongHopChiTiet.get(a).getTONGDANGGIAIQUYET());
						cell10.setCellValue(listTongHopChiTiet.get(a).getCHUADENHAN());
						cell11.setCellValue(listTongHopChiTiet.get(a).getQUAHAN());
						cell12.setCellValue(listTongHopChiTiet.get(a).getRUTHOSO());
						cell13.setCellValue(listTongHopChiTiet.get(a).getKHONGHOPLE());
						cell14.setCellValue(listTongHopChiTiet.get(a).getTONCUOI());
						rowNum++;
					}
				}
			}
			//row tong
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow row = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell cell = row.createCell(0);
			HSSFCell cell1 = row.createCell(1);
			HSSFCell cell2 = row.createCell(2);
			HSSFCell cell3 = row.createCell(3);
			HSSFCell cell4 = row.createCell(4);
			HSSFCell cell5 = row.createCell(5);
			HSSFCell cell6 = row.createCell(6);
			HSSFCell cell7 = row.createCell(7);
			HSSFCell cell8 = row.createCell(8);
			HSSFCell cell9 = row.createCell(9);
			HSSFCell cell10 = row.createCell(10);
			HSSFCell cell11 = row.createCell(11);
			HSSFCell cell12 = row.createCell(12);
			HSSFCell cell13 = row.createCell(13);
			HSSFCell cell14 = row.createCell(14);
			// set style cho cac cell
			cell.setCellStyle(styleHeader);
			cell1.setCellStyle(styleHeader);
			cell2.setCellStyle(styleHeader);
			cell3.setCellStyle(styleHeader);
			cell4.setCellStyle(styleHeader);
			cell5.setCellStyle(styleHeader);
			cell6.setCellStyle(styleHeader);
			cell7.setCellStyle(styleHeader);
			cell8.setCellStyle(styleHeader);
			cell9.setCellStyle(styleHeader);
			cell10.setCellStyle(styleHeader);
			cell11.setCellStyle(styleHeader);
			cell12.setCellStyle(styleHeader);
			cell13.setCellStyle(styleHeader);
			cell14.setCellStyle(styleHeader);
			// set gia tri cho cac cell
			cell.setCellValue("Tá»•ng");
			//cell1.setCellValue("");
			cell2.setCellValue(tongNhan);
			cell3.setCellValue(tongTiepNhan);
			cell4.setCellValue(tongTonDau);
			cell5.setCellValue(tongDaGiaiQuyet);
			cell6.setCellValue(tongSom);
			cell7.setCellValue(tongDung);
			cell8.setCellValue(tongTre);
			cell9.setCellValue(tongDangGiaiQuyet);
			cell10.setCellValue(tongChuaDenHan);
			cell11.setCellValue(tongDaQuaHan);
			cell12.setCellValue(tongRutHoSo);
			cell13.setCellValue(tongKhongHopLe);
			cell14.setCellValue(tongTonCuoi);
			//ket thuc row tong
			//ket thuc noi dung bao cao
			

			res.setContentType("application/vnd.ms-excel");
			res.addProperty(HttpHeaders.CACHE_CONTROL,
					"max-age=3600, must-revalidate");
			res.addProperty(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=Baocaotonghop.xls");
			OutputStream out = res.getPortletOutputStream();
			workbook.write(out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * This is function checkHosoByNHOMTTHCID
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param req
	 * @param res
	 */
	public static void excelTonghopTongquat(ResourceRequest req,
			ResourceResponse res) {
		try {
			String thang = req.getParameter("thang");
			String nam = req.getParameter("nam");
			String id_donvi = req.getParameter("id_donvi");
			String id_linhvuc = req.getParameter("id_linhvuc");
			String coQuanQuanLyId = req.getParameter("id_coquanquanly");
			CoQuanQuanLy coQuanQuanLy = new CoQuanQuanLyImpl();
			if(coQuanQuanLyId!=null && !coQuanQuanLyId.equals("0")){
				coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(Long.valueOf(coQuanQuanLyId));
			}
			List<ReportTongHop> listtonghop = ReportTongHopLocalServiceUtil.getListReportTongHopGroupByIDNhomThuTuc(id_donvi, id_linhvuc,thang, nam);
			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook
					.createSheet("Thongke");

			// define a cell style
			HSSFFont tableHeaderFont = (HSSFFont) workbook.createFont();
			tableHeaderFont.setBoldweight((short) 5000);

			HSSFFont ngaythangFont = (HSSFFont) workbook.createFont();
			ngaythangFont.setItalic(true);

			HSSFFont titleFont = (HSSFFont) workbook.createFont();
			titleFont.setBoldweight((short) 5000);
			titleFont.setFontHeightInPoints((short) 15);

			HSSFCellStyle styleCellHeader = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellHeader.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellHeader.setFont(tableHeaderFont);
			styleCellHeader.setWrapText(true);

			HSSFCellStyle styleCellNgaythang = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellNgaythang.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellNgaythang
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellNgaythang.setFont(ngaythangFont);
			styleCellNgaythang.setWrapText(true);

			HSSFCellStyle styleCellCenter = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellCenter.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellCenter.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellCenter.setWrapText(true);

			HSSFCellStyle styleCellLeft = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellLeft.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			styleCellLeft.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellLeft.setWrapText(true);

			HSSFCellStyle styleCellRight = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellRight.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			styleCellRight.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellRight.setWrapText(true);
			styleCellRight.setFont(tableHeaderFont);

			HSSFCellStyle styleCellRightNobold = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellRightNobold.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellRightNobold.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellRightNobold.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellRightNobold.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellRightNobold.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			styleCellRightNobold
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellRightNobold.setWrapText(true);

			HSSFCellStyle styleHeader = (HSSFCellStyle) workbook
					.createCellStyle();
			styleHeader.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleHeader.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleHeader.setFont(tableHeaderFont);
			styleHeader.setWrapText(true);

			HSSFCellStyle styleCellNhomTTHC = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellNhomTTHC.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			styleCellNhomTTHC
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellNhomTTHC.setFont(tableHeaderFont);

			HSSFCellStyle styleTitle = (HSSFCellStyle) workbook
					.createCellStyle();
			styleTitle.setFont(titleFont);
			styleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// end style
			int rowNum = 1;
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow rowUBND = sheet.createRow(rowNum);
			rowUBND.createCell(0).setCellValue("");
			rowUBND.getCell(0).setCellStyle(styleCellHeader);

			sheet.addMergedRegion(new Region(rowNum, (short) 2, rowNum,
					(short) 14));
			rowUBND.createCell(2).setCellValue(
					ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.chxhcnvn"));
			rowUBND.getCell(2).setCellStyle(styleCellHeader);

			rowNum++;

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow rowTenDonVi = sheet.createRow(rowNum);
			rowTenDonVi.createCell(0).setCellValue(coQuanQuanLy.getTen());
			rowTenDonVi.getCell(0).setCellStyle(styleCellHeader);

			sheet.addMergedRegion(new Region(rowNum, (short) 2, rowNum,
					(short) 14));
			rowTenDonVi.createCell(2).setCellValue(
					ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.dltdhp"));
			rowTenDonVi.getCell(2).setCellStyle(styleCellHeader);

			rowNum++;
			
			String tieude = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaotonghop.tieude");
			
			String nhomtthc = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaotonghop.nhomtthc");
			String tong = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.tong");
			String tiepnhan = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.tiepnhan");
			String kytruocchuyenqua = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.kytruocchuyenqua");
			String hosodagiaiquyet = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.hosodagiaiquyet");
			String hosodanggiaiquyet = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.hosodanggiaiquyet");
			String cdruthoso = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.cdruthoso");
			String hosotralai = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.hosotralai");
			String ghichu = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.ghichu");
			String sohoso = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.sohoso");
			String som = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.som");
			String dung = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.dung");
			String tre = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.tre");
			String chuadenhan = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.chuadenhan");
			String daquahan = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.daquahan");
			String[] header = { "STT",nhomtthc,tong,tiepnhan,kytruocchuyenqua,sohoso,som,dung,tre,sohoso,chuadenhan,daquahan,cdruthoso,hosotralai,ghichu};

			rowNum++;
			int[] width = { 1500, 10000, 2000, 2000, 3000, 2000,2000,2000,2000,2000,2000,2000,3000, 3000,3000};
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum + 1,
					(short) 14));
			HSSFRow titleRow = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell titleCell = titleRow.createCell(0);
			titleCell.setCellStyle(styleTitle);
			titleCell.setCellValue(tieude);

			rowNum += 2;

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 6));

			rowNum = rowNum + 2;
			HSSFRow headerRow1 = (HSSFRow) sheet.createRow(rowNum);
			HSSFRow headerRow2 = (HSSFRow) sheet.createRow(rowNum+1);
			sheet.addMergedRegion(new Region(rowNum, (short) 5, rowNum,	(short)8));
			sheet.addMergedRegion(new Region(rowNum, (short) 9, rowNum,	(short)11));
			for(int i = 0; i < header.length; i++){
				if(i<5 || i>11){
					sheet.addMergedRegion(new Region(rowNum, (short) i, rowNum+1,	(short)i));
				}
				HSSFCell cell = headerRow1.createCell(i);
				cell.setCellStyle(styleHeader);
				cell.setCellValue(header[i]);
				
				HSSFCell cell2 = headerRow2.createCell(i);
				cell2.setCellStyle(styleHeader);
				cell2.setCellValue(header[i]);
				if(i==5){
					cell.setCellValue(hosodagiaiquyet);
				}
				if(i==9){
					cell.setCellValue(hosodanggiaiquyet);
				}
				sheet.setColumnWidth(i, width[i]);
			}
			rowNum+=2;
			int tongNhan = 0;
			int tongTiepNhan = 0;
			int tongTonDau = 0;
			int tongDaGiaiQuyet = 0;
			int tongSom = 0;
			int tongDung = 0;
			int tongTre = 0;
			int tongDangGiaiQuyet = 0;
			int tongChuaDenHan = 0;
			int tongDaQuaHan = 0;
			int tongRutHoSo = 0;
			int tongKhongHopLe = 0;
			int tongTonCuoi = 0;
			int stt = 1;
			for (int a = 0; a < listtonghop.size(); a++) {
					tongNhan += listtonghop.get(a).getTONGNHAN();
					tongTiepNhan += listtonghop.get(a).getTIEPNHAN();
					tongTonDau += listtonghop.get(a).getTONDAU();
					tongDaGiaiQuyet += listtonghop.get(a).getTONGDAGIAIQUYET();
					tongSom += listtonghop.get(a).getSOM();
					tongDung += listtonghop.get(a).getDUNG();
					tongTre += listtonghop.get(a).getTRE();
					tongDangGiaiQuyet += listtonghop.get(a).getTONGDANGGIAIQUYET();
					tongChuaDenHan += listtonghop.get(a).getCHUADENHAN();
					tongDaQuaHan += listtonghop.get(a).getQUAHAN();
					tongRutHoSo += listtonghop.get(a).getRUTHOSO();
					tongKhongHopLe += listtonghop.get(a).getKHONGHOPLE();
					tongTonCuoi += listtonghop.get(a).getTONCUOI();
				// khai bao dong va cac cell
					HSSFRow row = (HSSFRow) sheet.createRow(rowNum);
					HSSFCell cell = row.createCell(0);
					HSSFCell cell1 = row.createCell(1);
					HSSFCell cell2 = row.createCell(2);
					HSSFCell cell3 = row.createCell(3);
					HSSFCell cell4 = row.createCell(4);
					HSSFCell cell5 = row.createCell(5);
					HSSFCell cell6 = row.createCell(6);
					HSSFCell cell7 = row.createCell(7);
					HSSFCell cell8 = row.createCell(8);
					HSSFCell cell9 = row.createCell(9);
					HSSFCell cell10 = row.createCell(10);
					HSSFCell cell11 = row.createCell(11);
					HSSFCell cell12 = row.createCell(12);
					HSSFCell cell13 = row.createCell(13);
					HSSFCell cell14 = row.createCell(14);
					// set style cho cac cell
					cell.setCellStyle(styleCellLeft);
					cell1.setCellStyle(styleCellLeft);
					cell2.setCellStyle(styleCellCenter);
					cell3.setCellStyle(styleCellCenter);
					cell4.setCellStyle(styleCellCenter);
					cell5.setCellStyle(styleCellCenter);
					cell6.setCellStyle(styleCellCenter);
					cell7.setCellStyle(styleCellCenter);
					cell8.setCellStyle(styleCellCenter);
					cell9.setCellStyle(styleCellCenter);
					cell10.setCellStyle(styleCellCenter);
					cell11.setCellStyle(styleCellCenter);
					cell12.setCellStyle(styleCellCenter);
					cell13.setCellStyle(styleCellCenter);
					cell14.setCellStyle(styleCellCenter);
					// set gia tri cho cac cell
					cell.setCellValue(stt);
					//cell1.setCellValue("");
					cell1.setCellValue(NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(listtonghop.get(a).getNHOMTHUTUCHANHCHINHID()).getTen());
					cell2.setCellValue(listtonghop.get(a).getTONGNHAN());
					cell3.setCellValue(listtonghop.get(a).getTIEPNHAN());
					cell4.setCellValue(listtonghop.get(a).getTONDAU());
					cell5.setCellValue(listtonghop.get(a).getTONGDAGIAIQUYET());
					cell6.setCellValue(listtonghop.get(a).getSOM());
					cell7.setCellValue(listtonghop.get(a).getDUNG());
					cell8.setCellValue(listtonghop.get(a).getTRE());
					cell9.setCellValue(listtonghop.get(a).getTONGDANGGIAIQUYET());
					cell10.setCellValue(listtonghop.get(a).getCHUADENHAN());
					cell11.setCellValue(listtonghop.get(a).getQUAHAN());
					cell12.setCellValue(listtonghop.get(a).getRUTHOSO());
					cell13.setCellValue(listtonghop.get(a).getKHONGHOPLE());
					cell14.setCellValue(listtonghop.get(a).getTONCUOI());
					rowNum++;
					stt++;
			}
			//row tong
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow row = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell cell = row.createCell(0);
			HSSFCell cell1 = row.createCell(1);
			HSSFCell cell2 = row.createCell(2);
			HSSFCell cell3 = row.createCell(3);
			HSSFCell cell4 = row.createCell(4);
			HSSFCell cell5 = row.createCell(5);
			HSSFCell cell6 = row.createCell(6);
			HSSFCell cell7 = row.createCell(7);
			HSSFCell cell8 = row.createCell(8);
			HSSFCell cell9 = row.createCell(9);
			HSSFCell cell10 = row.createCell(10);
			HSSFCell cell11 = row.createCell(11);
			HSSFCell cell12 = row.createCell(12);
			HSSFCell cell13 = row.createCell(13);
			HSSFCell cell14 = row.createCell(14);
			// set style cho cac cell
			cell.setCellStyle(styleHeader);
			cell1.setCellStyle(styleHeader);
			cell2.setCellStyle(styleHeader);
			cell3.setCellStyle(styleHeader);
			cell4.setCellStyle(styleHeader);
			cell5.setCellStyle(styleHeader);
			cell6.setCellStyle(styleHeader);
			cell7.setCellStyle(styleHeader);
			cell8.setCellStyle(styleHeader);
			cell9.setCellStyle(styleHeader);
			cell10.setCellStyle(styleHeader);
			cell11.setCellStyle(styleHeader);
			cell12.setCellStyle(styleHeader);
			cell13.setCellStyle(styleHeader);
			cell14.setCellStyle(styleHeader);
			// set gia tri cho cac cell
			cell.setCellValue("Tá»•ng");
			//cell1.setCellValue("");
			cell2.setCellValue(tongNhan);
			cell3.setCellValue(tongTiepNhan);
			cell4.setCellValue(tongTonDau);
			cell5.setCellValue(tongDaGiaiQuyet);
			cell6.setCellValue(tongSom);
			cell7.setCellValue(tongDung);
			cell8.setCellValue(tongTre);
			cell9.setCellValue(tongDangGiaiQuyet);
			cell10.setCellValue(tongChuaDenHan);
			cell11.setCellValue(tongDaQuaHan);
			cell12.setCellValue(tongRutHoSo);
			cell13.setCellValue(tongKhongHopLe);
			cell14.setCellValue(tongTonCuoi);
			//ket thuc row tong
			//ket thuc noi dung bao cao
			
			res.setContentType("application/vnd.ms-excel");
			res.addProperty(HttpHeaders.CACHE_CONTROL,
					"max-age=3600, must-revalidate");
			res.addProperty(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename='Baocaotonghop.xls'");
			OutputStream out = res.getPortletOutputStream();
			workbook.write(out);
			out.flush();
			out.close();
		} catch (Exception e) {
		}
	}
	/**
	 * This is function checkHosoByNHOMTTHCID
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param req
	 * @param res
	 */
	public static void excelThongke(ResourceRequest req,
			ResourceResponse res) {
		try {
			String thang = req.getParameter("thang");
			String nam = req.getParameter("nam");
			String coQuanQuanLyId = req.getParameter("id_coquanquanly");
//			CoQuanQuanLy coQuanQuanLy = new CoQuanQuanLyImpl();
//			if(coQuanQuanLyId!=null && !coQuanQuanLyId.equals("0")){
//				coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(Long.valueOf(coQuanQuanLyId));
//			}
			List<ReportThongKe> listthongke = ReportThongKeLocalServiceUtil.getListReportThongKeGroupByIDCoQuan(coQuanQuanLyId, thang, nam);
			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook
					.createSheet("Thongke");

			// define a cell style
			HSSFFont tableHeaderFont = (HSSFFont) workbook.createFont();
			tableHeaderFont.setBoldweight((short) 5000);

			HSSFFont ngaythangFont = (HSSFFont) workbook.createFont();
			ngaythangFont.setItalic(true);

			HSSFFont titleFont = (HSSFFont) workbook.createFont();
			titleFont.setBoldweight((short) 5000);
			titleFont.setFontHeightInPoints((short) 15);

			HSSFCellStyle styleCellHeader = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellHeader.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellHeader.setFont(tableHeaderFont);
			styleCellHeader.setWrapText(true);

			HSSFCellStyle styleCellNgaythang = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellNgaythang.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellNgaythang
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellNgaythang.setFont(ngaythangFont);
			styleCellNgaythang.setWrapText(true);

			HSSFCellStyle styleCellCenter = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellCenter.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellCenter.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellCenter.setWrapText(true);

			HSSFCellStyle styleCellLeft = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellLeft.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			styleCellLeft.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellLeft.setWrapText(true);

			HSSFCellStyle styleCellRight = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellRight.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			styleCellRight.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellRight.setWrapText(true);
			styleCellRight.setFont(tableHeaderFont);

			HSSFCellStyle styleCellRightNobold = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellRightNobold.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellRightNobold.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellRightNobold.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellRightNobold.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellRightNobold.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			styleCellRightNobold
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellRightNobold.setWrapText(true);

			HSSFCellStyle styleHeader = (HSSFCellStyle) workbook
					.createCellStyle();
			styleHeader.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleHeader.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleHeader.setFont(tableHeaderFont);
			styleHeader.setWrapText(true);

			HSSFCellStyle styleCellNhomTTHC = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellNhomTTHC.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			styleCellNhomTTHC
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellNhomTTHC.setFont(tableHeaderFont);

			HSSFCellStyle styleTitle = (HSSFCellStyle) workbook
					.createCellStyle();
			styleTitle.setFont(titleFont);
			styleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// end style
			int rowNum = 1;
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow rowUBND = sheet.createRow(rowNum);
			rowUBND.createCell(0).setCellValue("");
			rowUBND.getCell(0).setCellStyle(styleCellHeader);

			sheet.addMergedRegion(new Region(rowNum, (short) 2, rowNum,
					(short) 14));
			rowUBND.createCell(2).setCellValue(
					ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.chxhcnvn"));
			rowUBND.getCell(2).setCellStyle(styleCellHeader);

			rowNum++;

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow rowTenDonVi = sheet.createRow(rowNum);
			rowTenDonVi.createCell(0).setCellValue("");
			rowTenDonVi.getCell(0).setCellStyle(styleCellHeader);

			sheet.addMergedRegion(new Region(rowNum, (short) 2, rowNum,
					(short) 14));
			rowTenDonVi.createCell(2).setCellValue(
					ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.dltdhp"));
			rowTenDonVi.getCell(2).setCellStyle(styleCellHeader);

			rowNum++;
			
			String tieude = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.tieude");
			
			String coquan = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.coquan");
			String tong = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.tong");
			String tiepnhan = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.tiepnhan");
			String kytruocchuyenqua = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.kytruocchuyenqua");
			String hosodagiaiquyet = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.hosodagiaiquyet");
			String hosodanggiaiquyet = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.hosodanggiaiquyet");
			String cdruthoso = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.cdruthoso");
			String hosotralai = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.hosotralai");
			String ghichu = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.ghichu");
			String sohoso = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.sohoso");
			String som = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.som");
			String dung = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.dung");
			String tre = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.tre");
			String chuadenhan = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.chuadenhan");
			String daquahan = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaothongke.daquahan");
			String[] header = { "STT",coquan,tong,tiepnhan,kytruocchuyenqua,sohoso,som,dung,tre,sohoso,chuadenhan,daquahan,cdruthoso,hosotralai,ghichu};

			rowNum++;
			int[] width = { 1500, 10000, 2000, 2000, 3000, 2000,2000,2000,2000,2000,2000,2000,3000, 3000,3000};
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum + 1,
					(short) 14));
			HSSFRow titleRow = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell titleCell = titleRow.createCell(0);
			titleCell.setCellStyle(styleTitle);
			titleCell.setCellValue(tieude);

			rowNum += 2;

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 6));

			rowNum = rowNum + 2;
			HSSFRow headerRow1 = (HSSFRow) sheet.createRow(rowNum);
			HSSFRow headerRow2 = (HSSFRow) sheet.createRow(rowNum+1);
			sheet.addMergedRegion(new Region(rowNum, (short) 5, rowNum,	(short)8));
			sheet.addMergedRegion(new Region(rowNum, (short) 9, rowNum,	(short)11));
			for(int i = 0; i < header.length; i++){
				if(i<5 || i>11){
					sheet.addMergedRegion(new Region(rowNum, (short) i, rowNum+1,	(short)i));
				}
				HSSFCell cell = headerRow1.createCell(i);
				cell.setCellStyle(styleHeader);
				cell.setCellValue(header[i]);
				
				HSSFCell cell2 = headerRow2.createCell(i);
				cell2.setCellStyle(styleHeader);
				cell2.setCellValue(header[i]);
				if(i==5){
					cell.setCellValue(hosodagiaiquyet);
				}
				if(i==9){
					cell.setCellValue(hosodanggiaiquyet);
				}
				sheet.setColumnWidth(i, width[i]);
			}
			rowNum+=2;
			long tongnhan = 0;
			long tongtiepnhan = 0;
			long tondau = 0;
			long dagiaiquyet = 0;
			long tongsom = 0;
			long tongdung = 0;
			long tongtre = 0;
			long danggiaiquyet = 0;
			long tongchuadenhan = 0;
			long quahan = 0;
			long ruthoso = 0;
			long khonghople = 0;
			long toncuoi = 0;
			int stt = 1;
			for (int a = 0; a < listthongke.size(); a++) {
					ReportThongKe thongke = listthongke.get(a);
					tongnhan += thongke.getTONGNHAN();
					tongtiepnhan += thongke.getTIEPNHAN();
					tondau += thongke.getTONDAU();
					dagiaiquyet += thongke.getTONGDAGIAIQUYET();
					tongsom += thongke.getSOM();
					tongdung += thongke.getDUNG();
					tongtre += thongke.getTRE();
					danggiaiquyet += thongke.getTONGDANGGIAIQUYET();
					tongchuadenhan += thongke.getCHUADENHAN();
					quahan += thongke.getQUAHAN();
					ruthoso += thongke.getRUTHOSO();
					khonghople += thongke.getKHONGHOPLE();
					toncuoi += thongke.getTONCUOI();
				// khai bao dong va cac cell
					HSSFRow row = (HSSFRow) sheet.createRow(rowNum);
					HSSFCell cell = row.createCell(0);
					HSSFCell cell1 = row.createCell(1);
					HSSFCell cell2 = row.createCell(2);
					HSSFCell cell3 = row.createCell(3);
					HSSFCell cell4 = row.createCell(4);
					HSSFCell cell5 = row.createCell(5);
					HSSFCell cell6 = row.createCell(6);
					HSSFCell cell7 = row.createCell(7);
					HSSFCell cell8 = row.createCell(8);
					HSSFCell cell9 = row.createCell(9);
					HSSFCell cell10 = row.createCell(10);
					HSSFCell cell11 = row.createCell(11);
					HSSFCell cell12 = row.createCell(12);
					HSSFCell cell13 = row.createCell(13);
					HSSFCell cell14 = row.createCell(14);
					// set style cho cac cell
					cell.setCellStyle(styleCellLeft);
					cell1.setCellStyle(styleCellLeft);
					cell2.setCellStyle(styleCellCenter);
					cell3.setCellStyle(styleCellCenter);
					cell4.setCellStyle(styleCellCenter);
					cell5.setCellStyle(styleCellCenter);
					cell6.setCellStyle(styleCellCenter);
					cell7.setCellStyle(styleCellCenter);
					cell8.setCellStyle(styleCellCenter);
					cell9.setCellStyle(styleCellCenter);
					cell10.setCellStyle(styleCellCenter);
					cell11.setCellStyle(styleCellCenter);
					cell12.setCellStyle(styleCellCenter);
					cell13.setCellStyle(styleCellCenter);
					cell14.setCellStyle(styleCellCenter);
					// set gia tri cho cac cell
					cell.setCellValue(stt);
					//cell1.setCellValue("");
					cell1.setCellValue(CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(listthongke.get(a).getCOQUANQUANLYID()).getTen());
					cell2.setCellValue(listthongke.get(a).getTONGNHAN());
					cell3.setCellValue(listthongke.get(a).getTIEPNHAN());
					cell4.setCellValue(listthongke.get(a).getTONDAU());
					cell5.setCellValue(listthongke.get(a).getTONGDAGIAIQUYET());
					cell6.setCellValue(listthongke.get(a).getSOM());
					cell7.setCellValue(listthongke.get(a).getDUNG());
					cell8.setCellValue(listthongke.get(a).getTRE());
					cell9.setCellValue(listthongke.get(a).getTONGDANGGIAIQUYET());
					cell10.setCellValue(listthongke.get(a).getCHUADENHAN());
					cell11.setCellValue(listthongke.get(a).getQUAHAN());
					cell12.setCellValue(listthongke.get(a).getRUTHOSO());
					cell13.setCellValue(listthongke.get(a).getKHONGHOPLE());
					cell14.setCellValue(listthongke.get(a).getTONCUOI());
					rowNum++;
					stt++;
			}
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow row = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell cell = row.createCell(0);
			HSSFCell cell1 = row.createCell(1);
			HSSFCell cell2 = row.createCell(2);
			HSSFCell cell3 = row.createCell(3);
			HSSFCell cell4 = row.createCell(4);
			HSSFCell cell5 = row.createCell(5);
			HSSFCell cell6 = row.createCell(6);
			HSSFCell cell7 = row.createCell(7);
			HSSFCell cell8 = row.createCell(8);
			HSSFCell cell9 = row.createCell(9);
			HSSFCell cell10 = row.createCell(10);
			HSSFCell cell11 = row.createCell(11);
			HSSFCell cell12 = row.createCell(12);
			HSSFCell cell13 = row.createCell(13);
			HSSFCell cell14 = row.createCell(14);
			// set style cho cac cell
			//cell.setCellStyle(styleCellCenter);
			cell.setCellStyle(styleCellCenter);
			cell1.setCellStyle(styleCellCenter);
			cell2.setCellStyle(styleCellCenter);
			cell3.setCellStyle(styleCellCenter);
			cell4.setCellStyle(styleCellCenter);
			cell5.setCellStyle(styleCellCenter);
			cell6.setCellStyle(styleCellCenter);
			cell7.setCellStyle(styleCellCenter);
			cell8.setCellStyle(styleCellCenter);
			cell9.setCellStyle(styleCellCenter);
			cell10.setCellStyle(styleCellCenter);
			cell11.setCellStyle(styleCellCenter);
			cell12.setCellStyle(styleCellCenter);
			cell13.setCellStyle(styleCellCenter);
			cell14.setCellStyle(styleCellCenter);
			// set gia tri cho cac cell
			
			//cell1.setCellValue("");
			cell.setCellValue("Tá»•ng cá»™ng");
			cell2.setCellValue(tongnhan);
			cell3.setCellValue(tongtiepnhan);
			cell4.setCellValue(tondau);
			cell5.setCellValue(dagiaiquyet);
			cell6.setCellValue(tongsom);
			cell7.setCellValue(tongdung);
			cell8.setCellValue(tongtre);
			cell9.setCellValue(danggiaiquyet);
			cell10.setCellValue(tongchuadenhan);
			cell11.setCellValue(quahan);
			cell12.setCellValue(ruthoso);
			cell13.setCellValue(khonghople);
			cell14.setCellValue(toncuoi);

			res.setContentType("application/vnd.ms-excel");
			res.addProperty(HttpHeaders.CACHE_CONTROL,
					"max-age=3600, must-revalidate");
			res.addProperty(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename='Baocaothongke.xls'");
			OutputStream out = res.getPortletOutputStream();
			workbook.write(out);
			out.flush();
			out.close();
		} catch (Exception e) {
		}
	}
	
	/**
	 * This is function checkHosoByNHOMTTHCID
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id_nhomtthc
	 * @param listlephi
	 * @return boolean
	 */
	public static boolean checkHosoByNHOMTTHCID(long id_nhomtthc,
			List<Lephi_chitiet> listlephi) throws Exception {
		for (int i = 0; i < listlephi.size(); i++) {
			if (listlephi.get(i).getNHOMTHUTUCHANHCHINHID() == Integer
					.valueOf(String.valueOf(id_nhomtthc))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This is function checkLePhiTongHopByNHOMTTHCID
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id_nhomtthc
	 * @param listlephi
	 * @return boolean
	 */
	public static boolean checkLePhiTongHopByNHOMTTHCID(long id_nhomtthc,
			List<Lephi_tonghop> listlephi) throws Exception {
		for (int i = 0; i < listlephi.size(); i++) {
			if (listlephi.get(i).getNHOMTHUTUCHANHCHINHID() == Integer
					.valueOf(String.valueOf(id_nhomtthc))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This is function get language
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param req
	 * @param key
	 * @return String
	 */
	public static String getLanguage(ActionRequest req, String key) {
		return LanguageUtil.get((PortletConfig) req
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG), req
				.getLocale(), key);
	}

	/**
	 * This is function get language
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param req
	 * @param key
	 * @return String
	 */
	public static String getLanguage(ResourceRequest req, String key) {
		return LanguageUtil.get((PortletConfig) req
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG), req
				.getLocale(), key);
	}

	/**
	 * This is function excelLephichitiet
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param req
	 * @param res
	 */
	public static void excelLephichitiet(ResourceRequest req,
			ResourceResponse res) {
		try {
			String coQuanQuanLyId = req.getParameter("coQuanQuanLyId");
			CoQuanQuanLy coQuanQuanLy = new CoQuanQuanLyImpl();
			if(coQuanQuanLyId!=null && !coQuanQuanLyId.equals("0")){
				coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(Long.valueOf(coQuanQuanLyId));
			}
			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook
					.createSheet("Tinh_hinh_thu_le_phi_chi_tiet");

			// define a cell style
			HSSFFont tableHeaderFont = (HSSFFont) workbook.createFont();
			tableHeaderFont.setBoldweight((short) 5000);

			HSSFFont ngaythangFont = (HSSFFont) workbook.createFont();
			ngaythangFont.setItalic(true);

			HSSFFont titleFont = (HSSFFont) workbook.createFont();
			titleFont.setBoldweight((short) 5000);
			titleFont.setFontHeightInPoints((short) 15);

			HSSFCellStyle styleCellHeader = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellHeader.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellHeader.setFont(tableHeaderFont);
			styleCellHeader.setWrapText(true);

			HSSFCellStyle styleCellNgaythang = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellNgaythang.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellNgaythang
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellNgaythang.setFont(ngaythangFont);
			styleCellNgaythang.setWrapText(true);

			HSSFCellStyle styleCellCenter = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellCenter.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellCenter.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellCenter.setWrapText(true);

			HSSFCellStyle styleCellLeft = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellLeft.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			styleCellLeft.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellLeft.setWrapText(true);

			HSSFCellStyle styleCellRight = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellRight.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			styleCellRight.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellRight.setWrapText(true);
			styleCellRight.setFont(tableHeaderFont);

			HSSFCellStyle styleHeader = (HSSFCellStyle) workbook
					.createCellStyle();
			styleHeader.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleHeader.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleHeader.setFont(tableHeaderFont);
			styleHeader.setWrapText(true);

			HSSFCellStyle styleCellNhomTTHC = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellNhomTTHC.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			styleCellNhomTTHC
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellNhomTTHC.setFont(tableHeaderFont);

			HSSFCellStyle styleTitle = (HSSFCellStyle) workbook
					.createCellStyle();
			styleTitle.setFont(titleFont);
			styleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// end style
			String tungay = ParamUtil.getString(req, "tungay");
			String denngay = ParamUtil.getString(req, "denngay");
			int rowNum = 1;
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow rowUBND = sheet.createRow(rowNum);
			rowUBND.createCell(0).setCellValue("");
			rowUBND.getCell(0).setCellStyle(styleCellHeader);

			sheet.addMergedRegion(new Region(rowNum, (short) 2, rowNum,
					(short) 9));
			rowUBND.createCell(2).setCellValue(
					ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.chxhcnvn"));
			rowUBND.getCell(2).setCellStyle(styleCellHeader);

			rowNum++;

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow rowTenDonVi = sheet.createRow(rowNum);
			rowTenDonVi.createCell(0).setCellValue(coQuanQuanLy.getTen());
			rowTenDonVi.getCell(0).setCellStyle(styleCellHeader);

			sheet.addMergedRegion(new Region(rowNum, (short) 2, rowNum,
					(short) 9));
			rowTenDonVi.createCell(2).setCellValue(
					ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.dltdhp"));
			rowTenDonVi.getCell(2).setCellStyle(styleCellHeader);
			rowNum++;
			List<NhomThuTucHanhChinh> listnhomtt = NhomThuTucHanhChinhLocalServiceUtil
					.getNhomThuTucHanhChinhs(0,
							NhomThuTucHanhChinhLocalServiceUtil
									.getNhomThuTucHanhChinhsCount());
			List<Lephi_chitiet> listlephichitiet = Lephi_chitietLocalServiceUtil
					.lephichitiet(ParamUtil.getString(req, "id_loaihoso"),
							tungay, denngay);

			String loaihoso = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephichitiet.loaihoso");
			String nguoinop = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephichitiet.nguoinop");
			String chuhoso = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephichitiet.chuhoso");
			String diachi = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephichitiet.diachi");
			String sobohoso = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephichitiet.sobohoso");
			String lephi = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephichitiet.lephi");
			String phihoso = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephichitiet.phihoso");
			String tonglephi = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephichitiet.tonglephi");
			String ghichu = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephichitiet.ghichu");
			String tieude = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephichitiet.tieude");
			String[] header = { "STT", loaihoso, nguoinop, chuhoso, diachi,
					sobohoso, lephi, phihoso, tonglephi, ghichu };

			rowNum++;
			int[] width = { 1500, 15000, 5000, 5000, 5000, 5000, 5000, 5000,
					5000, 5000 };
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum + 1,
					(short) 9));
			HSSFRow titleRow = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell titleCell = titleRow.createCell(0);
			titleCell.setCellStyle(styleTitle);
			titleCell.setCellValue(tieude);

			rowNum += 2;

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 9));
			HSSFRow ngaythangRow = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell ngaythangCell = ngaythangRow.createCell(0);
			ngaythangCell.setCellStyle(styleCellNgaythang);
			ngaythangCell
					.setCellValue(ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.tungay")
							+ " "
							+ tungay
							+ " "
							+ ActionUtil.getLanguage(req,
									"vn.dtt.cmon.report.excel.denngay")
							+ " "
							+ denngay);

			rowNum = rowNum + 3;
			HSSFRow headerRow = (HSSFRow) sheet.createRow(rowNum);
			int colNum = 0;
			for (int i = 0; i < header.length; i++) {
				HSSFCell cell = headerRow.createCell(colNum);
				cell.setCellStyle(styleHeader);
				cell.setCellValue(header[i]);
				sheet.setColumnWidth(i, width[i]);
				colNum++;
			}
			rowNum++;
			long tong = 0;
			int stt = 0;
			for (int j = 0; j < listnhomtt.size(); j++) {
				if (ActionUtil.checkHosoByNHOMTTHCID(listnhomtt.get(j).getId(),
						listlephichitiet)) {
					sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
							(short) 9));
					HSSFRow rowNhomTTHC = (HSSFRow) sheet.createRow(rowNum);
					HSSFCell cellNhomTTHC = rowNhomTTHC.createCell(0);
					cellNhomTTHC.setCellValue(listnhomtt.get(j).getTen());
					cellNhomTTHC.setCellStyle(styleCellNhomTTHC);
					rowNhomTTHC.createCell(9).setCellStyle(styleCellNhomTTHC);
					rowNum++;
					for (int a = 0; a < listlephichitiet.size(); a++) {
						// khai bao dong va cac cell
						if (listnhomtt.get(j).getId() == listlephichitiet
								.get(a).getNHOMTHUTUCHANHCHINHID()) {
							stt++;
							HSSFRow row = (HSSFRow) sheet.createRow(rowNum);
							HSSFCell cell = row.createCell(0);
							HSSFCell cell1 = row.createCell(1);
							HSSFCell cell2 = row.createCell(2);
							HSSFCell cell3 = row.createCell(3);
							HSSFCell cell4 = row.createCell(4);
							HSSFCell cell5 = row.createCell(5);
							HSSFCell cell6 = row.createCell(6);
							HSSFCell cell7 = row.createCell(7);
							HSSFCell cell8 = row.createCell(8);
							HSSFCell cell9 = row.createCell(9);
							// set style cho cac cell
							cell.setCellStyle(styleCellCenter);
							cell1.setCellStyle(styleCellLeft);
							cell2.setCellStyle(styleCellCenter);
							cell3.setCellStyle(styleCellCenter);
							cell4.setCellStyle(styleCellCenter);
							cell5.setCellStyle(styleCellCenter);
							cell6.setCellStyle(styleCellCenter);
							cell7.setCellStyle(styleCellCenter);
							cell8.setCellStyle(styleCellCenter);
							cell9.setCellStyle(styleCellCenter);
							// set gia tri cho cac cell
							cell.setCellValue(stt);
							cell1.setCellValue(listlephichitiet.get(a)
									.getTENHOSO());
							cell2.setCellValue(listlephichitiet.get(a)
									.getNGUOINOP());
							cell3.setCellValue(listlephichitiet.get(a)
									.getCHUHOSO());
							cell4.setCellValue(listlephichitiet.get(a)
									.getDIACHI());
							cell5.setCellValue(listlephichitiet.get(a)
									.getSOBOHOSO());
							cell6.setCellValue(listlephichitiet.get(a)
									.getLEPHI());
							cell7.setCellValue(listlephichitiet.get(a)
									.getPHIHOSO());
							cell8.setCellValue(listlephichitiet.get(a)
									.getTONGLEPHI());

							tong = tong
									+ Long.valueOf(listlephichitiet.get(a)
											.getTONGLEPHI());
							rowNum++;
						}
					}
				}
			}

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 7));
			HSSFRow rowTong = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell cell = rowTong.createCell(0);
			HSSFCell cell1 = rowTong.createCell(1);
			HSSFCell cell2 = rowTong.createCell(2);
			HSSFCell cell3 = rowTong.createCell(3);
			HSSFCell cell4 = rowTong.createCell(4);
			HSSFCell cell5 = rowTong.createCell(5);
			HSSFCell cell6 = rowTong.createCell(6);
			HSSFCell cell7 = rowTong.createCell(7);
			HSSFCell cell8 = rowTong.createCell(8);
			HSSFCell cell9 = rowTong.createCell(9);
			// set style cho cac cell
			cell.setCellStyle(styleCellRight);
			cell1.setCellStyle(styleCellCenter);
			cell2.setCellStyle(styleCellCenter);
			cell3.setCellStyle(styleCellCenter);
			cell4.setCellStyle(styleCellCenter);
			cell5.setCellStyle(styleCellCenter);
			cell6.setCellStyle(styleCellCenter);
			cell7.setCellStyle(styleCellCenter);
			cell8.setCellStyle(styleCellCenter);
			cell9.setCellStyle(styleCellCenter);
			// set value for cells of rowtong
			cell.setCellValue(ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.excel.tongcong"));
			cell8.setCellValue(tong);
			res.setContentType("application/vnd.ms-excel");
			res.addProperty(HttpHeaders.CACHE_CONTROL,
					"max-age=3600, must-revalidate");
			res.addProperty(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=Baocaotinhhinhlephi.xls");
			OutputStream out = res.getPortletOutputStream();
			workbook.write(out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is function excelLephilinhvuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param req
	 * @param res
	 */
	public static void excelLephilinhvuc(ResourceRequest req,
			ResourceResponse res) {
		try {
			String coQuanQuanLyId = req.getParameter("coQuanQuanLyId");
			CoQuanQuanLy coQuanQuanLy = new CoQuanQuanLyImpl();
			if(coQuanQuanLyId!=null && !coQuanQuanLyId.equals("0")){
				coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(Long.valueOf(coQuanQuanLyId));
			}
			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook
					.createSheet("Tinh_hinh_thu_le_phi_theo_linh_vuc");

			// define a cell style
			HSSFFont tableHeaderFont = (HSSFFont) workbook.createFont();
			tableHeaderFont.setBoldweight((short) 5000);

			HSSFFont ngaythangFont = (HSSFFont) workbook.createFont();
			ngaythangFont.setItalic(true);

			HSSFFont titleFont = (HSSFFont) workbook.createFont();
			titleFont.setBoldweight((short) 5000);
			titleFont.setFontHeightInPoints((short) 15);

			HSSFCellStyle styleCellHeader = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellHeader.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellHeader.setFont(tableHeaderFont);
			styleCellHeader.setWrapText(true);

			HSSFCellStyle styleCellNgaythang = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellNgaythang.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellNgaythang
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellNgaythang.setFont(ngaythangFont);
			styleCellNgaythang.setWrapText(true);

			HSSFCellStyle styleCellCenter = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellCenter.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellCenter.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellCenter.setWrapText(true);

			HSSFCellStyle styleCellLeft = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellLeft.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			styleCellLeft.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellLeft.setWrapText(true);

			HSSFCellStyle styleCellRight = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellRight.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			styleCellRight.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellRight.setWrapText(true);
			styleCellRight.setFont(tableHeaderFont);

			HSSFCellStyle styleCellRightNobold = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellRightNobold.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellRightNobold.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellRightNobold.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellRightNobold.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellRightNobold.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			styleCellRightNobold
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellRightNobold.setWrapText(true);

			HSSFCellStyle styleHeader = (HSSFCellStyle) workbook
					.createCellStyle();
			styleHeader.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleHeader.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleHeader.setFont(tableHeaderFont);
			styleHeader.setWrapText(true);

			HSSFCellStyle styleCellNhomTTHC = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellNhomTTHC.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			styleCellNhomTTHC
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellNhomTTHC.setFont(tableHeaderFont);

			HSSFCellStyle styleTitle = (HSSFCellStyle) workbook
					.createCellStyle();
			styleTitle.setFont(titleFont);
			styleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// end style
			String tungay = ParamUtil.getString(req, "tungay");
			String denngay = ParamUtil.getString(req, "denngay");
			int rowNum = 1;
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow rowUBND = sheet.createRow(rowNum);
			rowUBND.createCell(0).setCellValue("");
			rowUBND.getCell(0).setCellStyle(styleCellHeader);

			sheet.addMergedRegion(new Region(rowNum, (short) 2, rowNum,
					(short) 6));
			rowUBND.createCell(2).setCellValue(
					ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.chxhcnvn"));
			rowUBND.getCell(2).setCellStyle(styleCellHeader);

			rowNum++;

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow rowTenDonVi = sheet.createRow(rowNum);
			rowTenDonVi.createCell(0).setCellValue(coQuanQuanLy.getTen());
			rowTenDonVi.getCell(0).setCellStyle(styleCellHeader);

			sheet.addMergedRegion(new Region(rowNum, (short) 2, rowNum,
					(short) 6));
			rowTenDonVi.createCell(2).setCellValue(
					ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.dltdhp"));
			rowTenDonVi.getCell(2).setCellStyle(styleCellHeader);

			rowNum++;
			List<Lephi_linhvuc> listlephilinhvuc = Lephi_linhvucLocalServiceUtil
					.lephilinhvuc(ParamUtil.getString(req, "id_linhvuc"),
							tungay, denngay);

			String linhvuc = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephilinhvuc.linhvuc");
			String tongsohoso = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephilinhvuc.tongsohoso");
			String lephi = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephilinhvuc.lephi");
			String phihoso = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephilinhvuc.phihoso");
			String tonglephi = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephilinhvuc.tonglephi");
			String ghichu = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephilinhvuc.ghichu");
			String tieude = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephilinhvuc.tieude");
			String[] header = { "STT", linhvuc, tongsohoso, lephi, phihoso,
					tonglephi, ghichu };

			rowNum++;
			int[] width = { 1500, 15000, 5000, 5000, 5000, 5000, 5000, 5000,
					5000 };
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum + 1,
					(short) 6));
			HSSFRow titleRow = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell titleCell = titleRow.createCell(0);
			titleCell.setCellStyle(styleTitle);
			titleCell.setCellValue(tieude);

			rowNum += 2;

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 6));
			HSSFRow ngaythangRow = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell ngaythangCell = ngaythangRow.createCell(0);
			ngaythangCell.setCellStyle(styleCellNgaythang);
			ngaythangCell
					.setCellValue(ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.tungay")
							+ " "
							+ tungay
							+ " "
							+ ActionUtil.getLanguage(req,
									"vn.dtt.cmon.report.excel.denngay")
							+ " "
							+ denngay);

			rowNum = rowNum + 3;
			HSSFRow headerRow = (HSSFRow) sheet.createRow(rowNum);
			int colNum = 0;
			for (int i = 0; i < header.length; i++) {
				HSSFCell cell = headerRow.createCell(colNum);
				cell.setCellStyle(styleHeader);
				cell.setCellValue(header[i]);
				sheet.setColumnWidth(i, width[i]);
				colNum++;
			}
			rowNum++;
			long tong = 0;
			int stt = 0;
			for (int a = 0; a < listlephilinhvuc.size(); a++) {
				// khai bao dong va cac cell
				stt++;
				HSSFRow row = (HSSFRow) sheet.createRow(rowNum);
				HSSFCell cell = row.createCell(0);
				HSSFCell cell1 = row.createCell(1);
				HSSFCell cell2 = row.createCell(2);
				HSSFCell cell3 = row.createCell(3);
				HSSFCell cell4 = row.createCell(4);
				HSSFCell cell5 = row.createCell(5);
				HSSFCell cell6 = row.createCell(6);
				// set style cho cac cell
				cell.setCellStyle(styleCellCenter);
				cell1.setCellStyle(styleCellLeft);
				cell2.setCellStyle(styleCellCenter);
				cell3.setCellStyle(styleCellRightNobold);
				cell4.setCellStyle(styleCellRightNobold);
				cell5.setCellStyle(styleCellRightNobold);
				cell6.setCellStyle(styleCellRightNobold);
				// set gia tri cho cac cell
				cell.setCellValue(stt);
				cell1.setCellValue(NhomThuTucHanhChinhLocalServiceUtil
						.getNhomThuTucHanhChinh(
								listlephilinhvuc.get(a)
										.getNHOMTHUTUCHANHCHINHID()).getTen());
				cell2.setCellValue(listlephilinhvuc.get(a).getTONGHOSO());
				cell3.setCellValue(listlephilinhvuc.get(a).getLEPHIHOSO());
				cell4.setCellValue(listlephilinhvuc.get(a).getPHIHOSO());
				cell5.setCellValue(listlephilinhvuc.get(a).getTONGLEPHI());

				tong = tong
						+ Long.valueOf(listlephilinhvuc.get(a).getTONGLEPHI());
				rowNum++;
			}

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 4));
			HSSFRow rowTong = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell cell = rowTong.createCell(0);
			HSSFCell cell1 = rowTong.createCell(1);
			HSSFCell cell2 = rowTong.createCell(2);
			HSSFCell cell3 = rowTong.createCell(3);
			HSSFCell cell4 = rowTong.createCell(4);
			HSSFCell cell5 = rowTong.createCell(5);
			HSSFCell cell6 = rowTong.createCell(6);
			// set style cho cac cell
			cell.setCellStyle(styleCellRight);
			cell1.setCellStyle(styleCellCenter);
			cell2.setCellStyle(styleCellCenter);
			cell3.setCellStyle(styleCellCenter);
			cell4.setCellStyle(styleCellCenter);
			cell5.setCellStyle(styleCellRightNobold);
			cell6.setCellStyle(styleCellCenter);
			// set value for cells of rowtong
			cell.setCellValue(ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.excel.tongcong"));
			cell5.setCellValue(tong);
			res.setContentType("application/vnd.ms-excel");
			res.addProperty(HttpHeaders.CACHE_CONTROL,
					"max-age=3600, must-revalidate");
			res.addProperty(HttpHeaders.CACHE_CONTROL,"max-age=3600, must-revalidate");
			res.addProperty(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=Baocaotinhhinhlephi.xls");
			OutputStream out = res.getPortletOutputStream();
			workbook.write(out);
			out.flush();
			out.close();
		} catch (Exception e) {
		}
	}

	/**
	 * This is function excelLephitonghop
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param req
	 * @param res
	 */
	public static void excelLephitonghop(ResourceRequest req,
			ResourceResponse res) {
		try {
			String coQuanQuanLyId = req.getParameter("coQuanQuanLyId");
			CoQuanQuanLy coQuanQuanLy = new CoQuanQuanLyImpl();
			if(coQuanQuanLyId!=null && !coQuanQuanLyId.equals("0")){
				coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(Long.valueOf(coQuanQuanLyId));
			}
			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook
					.createSheet("Tinh_hinh_thu_le_phi_tong_hop");

			// define a cell style
			HSSFFont tableHeaderFont = (HSSFFont) workbook.createFont();
			tableHeaderFont.setBoldweight((short) 5000);

			HSSFFont ngaythangFont = (HSSFFont) workbook.createFont();
			ngaythangFont.setItalic(true);

			HSSFFont titleFont = (HSSFFont) workbook.createFont();
			titleFont.setBoldweight((short) 5000);
			titleFont.setFontHeightInPoints((short) 15);

			HSSFCellStyle styleCellHeader = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellHeader.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellHeader.setFont(tableHeaderFont);
			styleCellHeader.setWrapText(true);

			HSSFCellStyle styleCellNgaythang = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellNgaythang.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellNgaythang
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellNgaythang.setFont(ngaythangFont);
			styleCellNgaythang.setWrapText(true);

			HSSFCellStyle styleCellCenter = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellCenter.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellCenter.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellCenter.setWrapText(true);

			HSSFCellStyle styleCellLeft = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellLeft.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			styleCellLeft.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellLeft.setWrapText(true);

			HSSFCellStyle styleCellRight = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellRight.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			styleCellRight.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellRight.setWrapText(true);
			styleCellRight.setFont(tableHeaderFont);

			HSSFCellStyle styleCellRightNobold = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellRightNobold.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellRightNobold.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellRightNobold.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellRightNobold.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellRightNobold.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			styleCellRightNobold
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellRightNobold.setWrapText(true);

			HSSFCellStyle styleHeader = (HSSFCellStyle) workbook
					.createCellStyle();
			styleHeader.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleHeader.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleHeader.setFont(tableHeaderFont);
			styleHeader.setWrapText(true);

			HSSFCellStyle styleCellNhomTTHC = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellNhomTTHC.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			styleCellNhomTTHC
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellNhomTTHC.setFont(tableHeaderFont);

			HSSFCellStyle styleTitle = (HSSFCellStyle) workbook
					.createCellStyle();
			styleTitle.setFont(titleFont);
			styleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// end style
			String tungay = ParamUtil.getString(req, "tungay");
			String denngay = ParamUtil.getString(req, "denngay");
			int rowNum = 1;
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow rowUBND = sheet.createRow(rowNum);
			rowUBND.createCell(0).setCellValue("");
			rowUBND.getCell(0).setCellStyle(styleCellHeader);

			sheet.addMergedRegion(new Region(rowNum, (short) 2, rowNum,
					(short) 6));
			rowUBND.createCell(2).setCellValue(
					ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.chxhcnvn"));
			rowUBND.getCell(2).setCellStyle(styleCellHeader);

			rowNum++;

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow rowTenDonVi = sheet.createRow(rowNum);
			rowTenDonVi.createCell(0).setCellValue(coQuanQuanLy.getTen());
			rowTenDonVi.getCell(0).setCellStyle(styleCellHeader);

			sheet.addMergedRegion(new Region(rowNum, (short) 2, rowNum,
					(short) 6));
			rowTenDonVi.createCell(2).setCellValue(
					ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.dltdhp"));
			rowTenDonVi.getCell(2).setCellStyle(styleCellHeader);

			rowNum++;
			List<NhomThuTucHanhChinh> listnhomtt = NhomThuTucHanhChinhLocalServiceUtil
					.getNhomThuTucHanhChinhs(0,
							NhomThuTucHanhChinhLocalServiceUtil
									.getNhomThuTucHanhChinhsCount());
			List<Lephi_tonghop> listlephitonghop = Lephi_tonghopLocalServiceUtil
					.lephitonghop(ParamUtil.getString(req, "id_loaihoso"),
							tungay, denngay);

			String linhvuc = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephilinhvuc.linhvuc");
			String tongsohoso = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephilinhvuc.tongsohoso");
			String lephi = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephilinhvuc.lephi");
			String phihoso = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephilinhvuc.phihoso");
			String tonglephi = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephilinhvuc.tonglephi");
			String ghichu = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephilinhvuc.ghichu");
			String tieude = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaolephitonghop.tieude");
			String[] header = { "STT", linhvuc, tongsohoso, lephi, phihoso,
					tonglephi, ghichu };

			rowNum++;
			int[] width = { 1500, 15000, 5000, 5000, 5000, 5000, 5000, 5000,
					5000 };
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum + 1,
					(short) 6));
			HSSFRow titleRow = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell titleCell = titleRow.createCell(0);
			titleCell.setCellStyle(styleTitle);
			titleCell.setCellValue(tieude);

			rowNum += 2;

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 6));
			HSSFRow ngaythangRow = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell ngaythangCell = ngaythangRow.createCell(0);
			ngaythangCell.setCellStyle(styleCellNgaythang);
			ngaythangCell
					.setCellValue(ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.tungay")
							+ " "
							+ tungay
							+ " "
							+ ActionUtil.getLanguage(req,
									"vn.dtt.cmon.report.excel.denngay")
							+ " "
							+ denngay);

			rowNum = rowNum + 3;
			HSSFRow headerRow = (HSSFRow) sheet.createRow(rowNum);
			int colNum = 0;
			for (int i = 0; i < header.length; i++) {
				HSSFCell cell = headerRow.createCell(colNum);
				cell.setCellStyle(styleHeader);
				cell.setCellValue(header[i]);
				sheet.setColumnWidth(i, width[i]);
				colNum++;
			}
			rowNum++;
			long tong = 0;
			int stt = 0;
			for (int j = 0; j < listnhomtt.size(); j++) {
				if (ActionUtil.checkLePhiTongHopByNHOMTTHCID(listnhomtt.get(j)
						.getId(), listlephitonghop)) {
					sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
							(short) 6));
					HSSFRow rowNhomTTHC = (HSSFRow) sheet.createRow(rowNum);
					HSSFCell cellNhomTTHC = rowNhomTTHC.createCell(0);
					cellNhomTTHC.setCellValue(listnhomtt.get(j).getTen());
					cellNhomTTHC.setCellStyle(styleCellNhomTTHC);
					rowNhomTTHC.createCell(6).setCellStyle(styleCellNhomTTHC);
					rowNum++;
					for (int a = 0; a < listlephitonghop.size(); a++) {
						// khai bao dong va cac cell
						if (listnhomtt.get(j).getId() == listlephitonghop
								.get(a).getNHOMTHUTUCHANHCHINHID()) {
							stt++;
							HSSFRow row = (HSSFRow) sheet.createRow(rowNum);
							HSSFCell cell = row.createCell(0);
							HSSFCell cell1 = row.createCell(1);
							HSSFCell cell2 = row.createCell(2);
							HSSFCell cell3 = row.createCell(3);
							HSSFCell cell4 = row.createCell(4);
							HSSFCell cell5 = row.createCell(5);
							HSSFCell cell6 = row.createCell(6);
							// set style cho cac cell
							cell.setCellStyle(styleCellCenter);
							cell1.setCellStyle(styleCellLeft);
							cell2.setCellStyle(styleCellCenter);
							cell3.setCellStyle(styleCellRightNobold);
							cell4.setCellStyle(styleCellRightNobold);
							cell5.setCellStyle(styleCellRightNobold);
							cell6.setCellStyle(styleCellRightNobold);
							// set gia tri cho cac cell
							cell.setCellValue(stt);
							cell1.setCellValue(ActionUtil
									.getLanguage(req,
											"vn.dtt.cmon.report.baocaolephitonghop.thang")
									+ " "
									+ listlephitonghop.get(a).getTHANGNHAN());
							cell2.setCellValue(listlephitonghop.get(a)
									.getTONGHOSO());
							cell3.setCellValue(listlephitonghop.get(a)
									.getLEPHI());
							cell4.setCellValue(listlephitonghop.get(a)
									.getPHIHOSO());
							cell5.setCellValue(listlephitonghop.get(a)
									.getTONGLEPHI());

							tong = tong
									+ Long.valueOf(listlephitonghop.get(a)
											.getTONGLEPHI());
							rowNum++;
						}
					}
				}
			}

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 4));
			HSSFRow rowTong = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell cell = rowTong.createCell(0);
			HSSFCell cell1 = rowTong.createCell(1);
			HSSFCell cell2 = rowTong.createCell(2);
			HSSFCell cell3 = rowTong.createCell(3);
			HSSFCell cell4 = rowTong.createCell(4);
			HSSFCell cell5 = rowTong.createCell(5);
			HSSFCell cell6 = rowTong.createCell(6);
			// set style cho cac cell
			cell.setCellStyle(styleCellRight);
			cell1.setCellStyle(styleCellCenter);
			cell2.setCellStyle(styleCellCenter);
			cell3.setCellStyle(styleCellCenter);
			cell4.setCellStyle(styleCellCenter);
			cell5.setCellStyle(styleCellRightNobold);
			cell6.setCellStyle(styleCellCenter);
			// set value for cells of rowtong
			cell.setCellValue(ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.excel.tongcong"));
			cell5.setCellValue(tong);
			res.setContentType("application/vnd.ms-excel");
			res.addProperty(HttpHeaders.CACHE_CONTROL,
					"max-age=3600, must-revalidate");
			res.addProperty(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=Baocaotinhhinhlephi.xls");
			OutputStream out = res.getPortletOutputStream();
			workbook.write(out);
			out.flush();
			out.close();
		} catch (Exception e) {
		}
	}
	
	/**
	 * This is function excel BaoCaochungthuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param req
	 * @param res
	 */
	public static void excelBaocaochungthuc(ResourceRequest req,
			ResourceResponse res) {
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String coQuanQuanLyId = req.getParameter("coQuanQuanLyId");
			CoQuanQuanLy coQuanQuanLy = new CoQuanQuanLyImpl();
			if(coQuanQuanLyId!=null && !coQuanQuanLyId.equals("0")){
				coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(Long.valueOf(coQuanQuanLyId));
			}
			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook
					.createSheet("Baocaohosochungthuc");

			// define a cell style
			HSSFFont tableHeaderFont = (HSSFFont) workbook.createFont();
			tableHeaderFont.setBoldweight((short) 5000);

			HSSFFont ngaythangFont = (HSSFFont) workbook.createFont();
			ngaythangFont.setItalic(true);

			HSSFFont titleFont = (HSSFFont) workbook.createFont();
			titleFont.setBoldweight((short) 5000);
			titleFont.setFontHeightInPoints((short) 15);

			HSSFCellStyle styleCellHeader = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellHeader.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellHeader.setFont(tableHeaderFont);
			styleCellHeader.setWrapText(true);

			HSSFCellStyle styleCellNgaythang = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellNgaythang.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellNgaythang
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellNgaythang.setFont(ngaythangFont);
			styleCellNgaythang.setWrapText(true);

			HSSFCellStyle styleCellCenter = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellCenter.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleCellCenter.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellCenter.setWrapText(true);

			HSSFCellStyle styleCellLeft = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellLeft.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellLeft.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			styleCellLeft.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellLeft.setWrapText(true);

			HSSFCellStyle styleCellRight = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellRight.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellRight.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			styleCellRight.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellRight.setWrapText(true);
			styleCellRight.setFont(tableHeaderFont);

			HSSFCellStyle styleHeader = (HSSFCellStyle) workbook
					.createCellStyle();
			styleHeader.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleHeader.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleHeader.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleHeader.setFont(tableHeaderFont);
			styleHeader.setWrapText(true);

			HSSFCellStyle styleCellNhomTTHC = (HSSFCellStyle) workbook
					.createCellStyle();
			styleCellNhomTTHC.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleCellNhomTTHC.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			styleCellNhomTTHC
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			styleCellNhomTTHC.setFont(tableHeaderFont);

			HSSFCellStyle styleTitle = (HSSFCellStyle) workbook
					.createCellStyle();
			styleTitle.setFont(titleFont);
			styleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			styleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// end style
			String tungay = ParamUtil.getString(req, "tungay");
			String denngay = ParamUtil.getString(req, "denngay");
			int rowNum = 1;
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow rowUBND = sheet.createRow(rowNum);
			rowUBND.createCell(0).setCellValue("");
			rowUBND.getCell(0).setCellStyle(styleCellHeader);

			sheet.addMergedRegion(new Region(rowNum, (short) 2, rowNum,
					(short) 11));
			rowUBND.createCell(2).setCellValue(
					ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.chxhcnvn"));
			rowUBND.getCell(2).setCellStyle(styleCellHeader);

			rowNum++;

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 1));
			HSSFRow rowTenDonVi = sheet.createRow(rowNum);
			rowTenDonVi.createCell(0).setCellValue(coQuanQuanLy.getTen());
			rowTenDonVi.getCell(0).setCellStyle(styleCellHeader);

			sheet.addMergedRegion(new Region(rowNum, (short) 2, rowNum,
					(short) 11));
			rowTenDonVi.createCell(2).setCellValue(
					ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.dltdhp"));
			rowTenDonVi.getCell(2).setCellStyle(styleCellHeader);
			rowNum++;
			String str_loaihoso = ParamUtil.getString(req, "id_loaihoso");
			List<HoSoChungThuc> listhosochungthuc = ActionUtil.listhsct(str_loaihoso, tungay, denngay);

			String sochungthuc = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaochungthuc.sochungthuc");
			String nguoinop = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaochungthuc.nguoinop");
			String diachi = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaochungthuc.diachi");
			String noidungcongviec = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaochungthuc.noidungcongviec");
			String loaigiayto = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaochungthuc.loaigiayto");
			String sobo = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaochungthuc.sobo");
			String sotrang = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaochungthuc.sotrang");
			String ngaynhan = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaochungthuc.ngaynhan");
			String ngaytraketqua = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaochungthuc.ngaytraketqua");
			String lephi = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaochungthuc.lephi");
			String nguoithuchien = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaochungthuc.nguoithuchien");
			String nguoiky = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaochungthuc.nguoiky");
			String tieude = ActionUtil.getLanguage(req,
					"vn.dtt.cmon.report.baocaochungthuc.tieude");
			String[] header = { "STT",sochungthuc,nguoinop,diachi,noidungcongviec,loaigiayto,sobo,sotrang,ngaynhan,ngaytraketqua,lephi,nguoithuchien,nguoiky};

			rowNum++;
			int[] width = { 1500,2000, 5000, 5000, 5000, 5000, 2000, 2000,
					3000, 3000,2000,4000,4000 };
			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum + 1,
					(short) 12));
			HSSFRow titleRow = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell titleCell = titleRow.createCell(0);
			titleCell.setCellStyle(styleTitle);
			titleCell.setCellValue(tieude);

			rowNum += 2;

			sheet.addMergedRegion(new Region(rowNum, (short) 0, rowNum,
					(short) 12));
			HSSFRow ngaythangRow = (HSSFRow) sheet.createRow(rowNum);
			HSSFCell ngaythangCell = ngaythangRow.createCell(0);
			ngaythangCell.setCellStyle(styleCellNgaythang);
			ngaythangCell
					.setCellValue(ActionUtil.getLanguage(req,
							"vn.dtt.cmon.report.excel.tungay")
							+ " "
							+ tungay
							+ " "
							+ ActionUtil.getLanguage(req,
									"vn.dtt.cmon.report.excel.denngay")
							+ " "
							+ denngay);

			rowNum = rowNum + 3;
			HSSFRow headerRow = (HSSFRow) sheet.createRow(rowNum);
			int colNum = 0;
			for (int i = 0; i < header.length; i++) {
				HSSFCell cell = headerRow.createCell(colNum);
				cell.setCellStyle(styleHeader);
				cell.setCellValue(header[i]);
				sheet.setColumnWidth(i, width[i]);
				colNum++;
			}
			rowNum++;
			long tong = 0;
			int stt = 0;
			for (int a = 0; a < listhosochungthuc.size(); a++) {
			// khai bao dong va cac cell
				stt++;
				HSSFRow row = (HSSFRow) sheet.createRow(rowNum);
				HSSFCell cell = row.createCell(0);
				HSSFCell cell1 = row.createCell(1);
				HSSFCell cell2 = row.createCell(2);
				HSSFCell cell3 = row.createCell(3);
				HSSFCell cell4 = row.createCell(4);
				HSSFCell cell5 = row.createCell(5);
				HSSFCell cell6 = row.createCell(6);
				HSSFCell cell7 = row.createCell(7);
				HSSFCell cell8 = row.createCell(8);
				HSSFCell cell9 = row.createCell(9);
				HSSFCell cell10 = row.createCell(10);
				HSSFCell cell11 = row.createCell(11);
				HSSFCell cell12 = row.createCell(12);
				// set style cho cac cell
				cell.setCellStyle(styleCellCenter);
				cell1.setCellStyle(styleCellLeft);
				cell2.setCellStyle(styleCellCenter);
				cell3.setCellStyle(styleCellCenter);
				cell4.setCellStyle(styleCellCenter);
				cell5.setCellStyle(styleCellCenter);
				cell6.setCellStyle(styleCellCenter);
				cell7.setCellStyle(styleCellCenter);
				cell8.setCellStyle(styleCellCenter);
				cell9.setCellStyle(styleCellCenter);
				cell10.setCellStyle(styleCellCenter);
				cell11.setCellStyle(styleCellCenter);
				cell12.setCellStyle(styleCellCenter);
				
				// set gia tri cho cac cell
				String diachithuongtru = listhosochungthuc.get(a).getDiaChiThuongTruNguoiNop()!=null?listhosochungthuc.get(a).getDiaChiThuongTruNguoiNop():"";
				String dienthoaididong = listhosochungthuc.get(a).getSoDienThoaiDiDongNguoiNop()!=null?"Ä�T:"+listhosochungthuc.get(a).getSoDienThoaiDiDongNguoiNop():""; 
				cell.setCellValue(stt);
				cell1.setCellValue(listhosochungthuc.get(a).getSoChungThuc()!=null?listhosochungthuc.get(a).getSoChungThuc():"");
				cell2.setCellValue(listhosochungthuc.get(a).getHoTenNguoiNopHoSo()!=null?listhosochungthuc.get(a).getHoTenNguoiNopHoSo():"");
				cell3.setCellValue(diachithuongtru+"\n"+dienthoaididong);
				cell4.setCellValue(listhosochungthuc.get(a).getTenChungThuc());
				cell5.setCellValue(listhosochungthuc.get(a).getThuTucHanhChinhId()!=null?ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinh(listhosochungthuc.get(a).getThuTucHanhChinhId()).getTen():"");
				cell6.setCellValue(listhosochungthuc.get(a).getSoBoHoSo());
				cell7.setCellValue(listhosochungthuc.get(a).getSoTo());
				cell8.setCellValue(listhosochungthuc.get(a).getNgayNopHoSo()!=null?df.format(listhosochungthuc.get(a).getNgayNopHoSo()):"");
				cell9.setCellValue(listhosochungthuc.get(a).getNgayTraKetQua()!=null?df.format(listhosochungthuc.get(a).getNgayTraKetQua()):"");
				cell10.setCellValue(listhosochungthuc.get(a).getLePhi());
				cell11.setCellValue(listhosochungthuc.get(a).getCanBoTiepNhanId()!=null?CongChucLocalServiceUtil.fetchCongChuc(listhosochungthuc.get(a).getCanBoTiepNhanId()).getHoVaTen():"");
				cell12.setCellValue(listhosochungthuc.get(a).getTenCanBoKy()!=null?listhosochungthuc.get(a).getTenCanBoKy():"");
				rowNum++;
			}

			res.setContentType("application/vnd.ms-excel");
			res.addProperty(HttpHeaders.CACHE_CONTROL,
					"max-age=3600, must-revalidate");
			res.addProperty(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=Baocaohosochungthuc.xls");
			OutputStream out = res.getPortletOutputStream();
			workbook.write(out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is function excel report detail
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param resourceResponse
	 */
	public static void excelbaocaochitiet(ResourceRequest resourceRequest,ResourceResponse resourceResponse){
		try{
			 HSSFWorkbook workbook = new HSSFWorkbook();
			 HSSFSheet sheet = workbook.createSheet("new sheet");
			 HSSFFont Row2_font = workbook.createFont();
			 Row2_font.setFontName(HSSFFont.FONT_ARIAL);
			 Row2_font.setFontHeightInPoints((short)13);
			 Row2_font.setUnderline(HSSFFont.U_SINGLE);
			 
			 HSSFFont ngaythang_font = workbook.createFont();
			 ngaythang_font.setFontName(HSSFFont.FONT_ARIAL);
			 ngaythang_font.setFontHeightInPoints((short)13);
			 ngaythang_font.setItalic(true);
			 
			 HSSFFont style_font = workbook.createFont();
			 style_font.setFontHeightInPoints((short)13);
			 
			 HSSFFont trangthai_font = workbook.createFont();
			 trangthai_font.setFontName(HSSFFont.FONT_ARIAL);
			 trangthai_font.setFontHeightInPoints((short)11);
			 trangthai_font.setItalic(true);
			 
			 /*define a cell style*/
			 HSSFFont tableHeaderFont = (HSSFFont) workbook.createFont();
			 tableHeaderFont.setBoldweight((short)3500);
			 HSSFFont titleFont = (HSSFFont) workbook.createFont();
			 titleFont.setBoldweight((short)3500);
			 titleFont.setFontHeightInPoints((short)13);
			 
			 HSSFFont titleTongStyle_font = (HSSFFont) workbook.createFont();
			 titleTongStyle_font.setFontHeightInPoints((short)13);
			 titleTongStyle_font.setBoldweight((short)3500);
			 
			 
			 HSSFCellStyle styleCellCenter =(HSSFCellStyle) workbook.createCellStyle();
			 styleCellCenter.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			 styleCellCenter.setBorderTop(HSSFCellStyle.BORDER_THIN);
			 styleCellCenter.setBorderRight(HSSFCellStyle.BORDER_THIN);
			 styleCellCenter.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			 styleCellCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			 styleCellCenter.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			 styleCellCenter.setWrapText(true);
			 
			 HSSFCellStyle styleCellLeft =(HSSFCellStyle) workbook.createCellStyle();
			 styleCellLeft.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			 styleCellLeft.setBorderTop(HSSFCellStyle.BORDER_THIN);
			 styleCellLeft.setBorderRight(HSSFCellStyle.BORDER_THIN);
			 styleCellLeft.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			 styleCellLeft.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			 styleCellLeft.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			 styleCellLeft.setWrapText(true);
			 
			 HSSFCellStyle styleCellRight =(HSSFCellStyle) workbook.createCellStyle();
			 styleCellRight.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			 styleCellRight.setBorderTop(HSSFCellStyle.BORDER_THIN);
			 styleCellRight.setBorderRight(HSSFCellStyle.BORDER_THIN);
			 styleCellRight.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			 styleCellRight.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			 styleCellRight.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			 styleCellRight.setWrapText(true);
			 
			 HSSFCellStyle titleTongStyle = (HSSFCellStyle) workbook.createCellStyle();
			 titleTongStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			 titleTongStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			 titleTongStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			 titleTongStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			 titleTongStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			 titleTongStyle.setFont(titleTongStyle_font);
			 
			 HSSFCellStyle titleLinhvucStyle = (HSSFCellStyle) workbook.createCellStyle();
			 titleLinhvucStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			 titleLinhvucStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			 titleLinhvucStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			 titleLinhvucStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			 titleLinhvucStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			 titleLinhvucStyle.setFont(titleTongStyle_font);
			 
			 
			 HSSFCellStyle styleQuochieu = (HSSFCellStyle) workbook.createCellStyle();
			 styleQuochieu.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			 styleQuochieu.setFont(style_font);
			
			 HSSFCellStyle styleRow2 = (HSSFCellStyle) workbook.createCellStyle();
			 styleRow2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			 styleRow2.setFont(Row2_font);
			 
			 HSSFCellStyle ngaythang_style = (HSSFCellStyle) workbook.createCellStyle();
			 ngaythang_style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			 ngaythang_style.setFont(ngaythang_font);
			 
			 HSSFCellStyle style_trangthai = (HSSFCellStyle) workbook.createCellStyle();
			 style_trangthai.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			 style_trangthai.setFont(trangthai_font);
			 
			 HSSFCellStyle style_tungay_denngay = (HSSFCellStyle) workbook.createCellStyle();
			 style_tungay_denngay.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			 style_tungay_denngay.setFont(trangthai_font);
			 
			 
			 HSSFCellStyle styleHeader = (HSSFCellStyle) workbook.createCellStyle();
			 styleHeader.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			 styleHeader.setBorderTop(HSSFCellStyle.BORDER_THIN);
			 styleHeader.setBorderRight(HSSFCellStyle.BORDER_THIN);
			 styleHeader.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			 styleHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			 styleHeader.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			 styleHeader.setFont(tableHeaderFont);
			 styleHeader.setWrapText(true);
			 
			 HSSFCellStyle styleTitle = (HSSFCellStyle) workbook.createCellStyle();
			 styleTitle.setFont(titleFont);
			 styleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			 styleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		
			 /*end style*/
			 int rowNum = 0;
			 String[] header = {"STT","LÄ©nh vá»±c",LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.baocaochitiet.tenhoso"),
					 LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.baocaochitiet.sohoso"),
					 LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.baocaochitiet.trangthai"),
					 LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.baocaochitiet.diachi"),
					 LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.baocaochitiet.dienthoai"),
					 LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.baocaochitiet.nguoinophoso"),
					 LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.baocaochitiet.chuhoso"),
					 LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.baocaochitiet.ngaynhan"),
					 LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.baocaochitiet.ngaytra"),
					 "TÃ¬nh tráº¡ng\n há»“ sÆ¡",
					 LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.baocaochitiet.ghichu")};
			 int[] width ={1200,3750,3750,4200,3650,3650,3650,3650,3750,3750,3750,3750,3750};
			 
			 String[] listloaihoso = null;
			 if(Validator.isNotNull(ParamUtil.getParameterValues(resourceRequest,"chon_hoso"))){
				 listloaihoso = ParamUtil.getParameterValues(resourceRequest,"chon_hoso");
			 }
			 String ngaynhan_tungay = "";
			 if(Validator.isNotNull(ParamUtil.getString(resourceRequest, "ngaynhan_tungay"))){
				 ngaynhan_tungay = ParamUtil.getString(resourceRequest, "ngaynhan_tungay");
			 }
			 String ngaynhan_denngay = "";
			 if(Validator.isNotNull(ParamUtil.getString(resourceRequest, "ngaynhan_denngay"))){
				 ngaynhan_denngay = ParamUtil.getString(resourceRequest, "ngaynhan_denngay");
			 }
			 String trangthai_hoso = "";
			 if(Validator.isNotNull(ParamUtil.getString(resourceRequest, "trangthai_hoso"))){
				 trangthai_hoso = ParamUtil.getString(resourceRequest, "trangthai_hoso");
			 }
			 String tinhtrang = "";
			 if(Validator.isNotNull(ParamUtil.getString(resourceRequest, "tinhtrang_hoso"))){
				 tinhtrang = ParamUtil.getString(resourceRequest, "tinhtrang_hoso");
			 }
			 String loaidangky = "";
			 if(Validator.isNotNull(ParamUtil.getString(resourceRequest, "loaidangky_hoso"))){
				 loaidangky = ParamUtil.getString(resourceRequest, "loaidangky_hoso");
			 }
			 String ten_donvi ="";
			 if(Validator.isNotNull(ParamUtil.getString(resourceRequest,"chon_donvi"))){
				 ten_donvi = ParamUtil.getString(resourceRequest,"chon_donvi");
			 }
			 List<Baocaochitiet> list = BaocaochitietLocalServiceUtil.hienthiDanhsachBaocao(listloaihoso, ngaynhan_tungay, ngaynhan_denngay, trangthai_hoso, tinhtrang, loaidangky,  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			 
			 sheet.addMergedRegion(new Region(rowNum, (short)0, (short)0, (short)2));
			 HSSFRow Quochieu = sheet.createRow(rowNum);
			 HSSFCell Quochieucell_1 = Quochieu.createCell(0);
			 HSSFCell Quochieucell_2 = Quochieu.createCell(3);
			 Quochieucell_1.setCellStyle(styleQuochieu);
			 Quochieucell_2.setCellStyle(styleQuochieu);
			 Quochieucell_1.setCellValue(LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.excel.qlc"));
			 sheet.addMergedRegion(new Region(rowNum, (short)3, (short)0, (short)12));
			 Quochieucell_2.setCellValue(LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.excel.chxhcnvn"));
			 rowNum = rowNum+1;
			
			 sheet.addMergedRegion(new Region(rowNum,(short)0,(short)1,(short)2));
			 HSSFRow Row_2 = sheet.createRow(rowNum);
			 //HSSFCell Quan = Row_2.createCell(0);
			 //Quan.setCellValue(LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.excel.qlc"));
			 //Quan.setCellStyle(styleRow2);
			 
			 sheet.addMergedRegion(new Region(rowNum,(short)3,(short)1,(short)12));
			 HSSFCell Tieungu = Row_2.createCell(3);
			 Tieungu.setCellValue(LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.excel.dltdhp"));
			 Tieungu.setCellStyle(styleRow2);
			 rowNum = rowNum+1;
			 
			 Calendar dateTime = Calendar.getInstance();
			 SimpleDateFormat ngay_format = new SimpleDateFormat("dd");
			 SimpleDateFormat thang_format = new SimpleDateFormat("MM");
			 SimpleDateFormat nam_format = new SimpleDateFormat("yyyy");
			 Date time = dateTime.getTime();
		     String day = ngay_format.format(time);
		     String month = thang_format.format(time);
		     String year = nam_format.format(time);
			 sheet.addMergedRegion(new Region(rowNum,(short)0,(short)2,(short)10));
			 HSSFRow Row_3 = sheet.createRow(rowNum);
			 HSSFCell ngaythang = Row_3.createCell(0);
			 ngaythang.setCellValue(ten_donvi+", "+
					 				LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.excel.ngay")+" "+day+" "+
					 				LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.excel.thang")+" "+month+" "+
					 				LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.excel.nam")+" "+year);
			 ngaythang.setCellStyle(ngaythang_style);
			 rowNum = rowNum+1;
			 
			 sheet.addMergedRegion(new Region(rowNum,(short)0,rowNum,(short)10));
			 HSSFRow titleRow = sheet.createRow(rowNum);
			 HSSFCell titleCell = titleRow.createCell(0);
			 titleCell.setCellValue(LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.baocaochitiet.tieude"));
			 titleCell.setCellStyle(styleTitle);
			 if(ngaynhan_tungay!="" && ngaynhan_denngay!=""){
				 rowNum = rowNum+1;
				 sheet.addMergedRegion(new Region(rowNum,(short)0,rowNum,(short)10));
				 HSSFRow TimeReportRow = sheet.createRow(rowNum);
				 HSSFCell TimeReportCell = TimeReportRow.createCell(0);
				 TimeReportCell.setCellValue(LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.excel.tungay")+": "+ngaynhan_tungay+" "+LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.excel.denngay")+": "+ngaynhan_denngay);
				 TimeReportCell.setCellStyle(style_tungay_denngay);
			 }else if(ngaynhan_tungay!="" && ngaynhan_denngay==""){
				 rowNum = rowNum+1;
				 ngaynhan_denngay = "01/12/"+ngaynhan_tungay.substring(6,10);
				 sheet.addMergedRegion(new Region(rowNum,(short)0,rowNum,(short)10));
				 HSSFRow TimeReportRow = sheet.createRow(rowNum);
				 HSSFCell TimeReportCell = TimeReportRow.createCell(0);
				 TimeReportCell.setCellValue(LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.excel.tungay")+": "+ngaynhan_tungay+" "+LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.excel.denngay")+": "+ngaynhan_denngay);
				 TimeReportCell.setCellStyle(style_tungay_denngay);
			 }else if(ngaynhan_tungay=="" && ngaynhan_denngay!=""){
				 rowNum = rowNum+1;
				 ngaynhan_tungay = "01/01/"+ngaynhan_denngay.substring(6,10);
				 sheet.addMergedRegion(new Region(rowNum,(short)0,rowNum,(short)10));
				 HSSFRow TimeReportRow = sheet.createRow(rowNum);
				 HSSFCell TimeReportCell = TimeReportRow.createCell(0);
				 TimeReportCell.setCellValue(LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.excel.tungay")+": "+ngaynhan_tungay+" "+LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.excel.denngay")+": "+ngaynhan_denngay);
				 TimeReportCell.setCellStyle(style_tungay_denngay);
			 }else{
				 rowNum = rowNum+1;
				 ngaynhan_tungay  = "01/01/"+year;
				 ngaynhan_denngay = "01/12/"+year; 
				 sheet.addMergedRegion(new Region(rowNum,(short)0,rowNum,(short)10));
				 HSSFRow TimeReportRow = sheet.createRow(rowNum);
				 HSSFCell TimeReportCell = TimeReportRow.createCell(0);
				 TimeReportCell.setCellValue(LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.excel.tungay")+": "+ngaynhan_tungay+" "+LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.excel.denngay")+": "+ngaynhan_denngay);
				 TimeReportCell.setCellStyle(style_tungay_denngay);
			 }
			 if(!trangthai_hoso.equals("")){
				 rowNum = rowNum+1;
				 sheet.addMergedRegion(new Region(rowNum,(short)0,rowNum,(short)10));
				 HSSFRow TimeReportRow = sheet.createRow(rowNum);
				 HSSFCell TimeReportCell = TimeReportRow.createCell(0);
				 TimeReportCell.setCellValue("("+LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.baocaochitiet.trangthai")+": "+TrangThaiHoSoLocalServiceUtil.getTrangThaiHoSo(Long.parseLong(trangthai_hoso)).getTrangThai()+")");
				 TimeReportCell.setCellStyle(style_trangthai);
			 }
			 rowNum = rowNum+3;
			 HSSFRow headerRow = (HSSFRow) sheet.createRow(rowNum);
				int colNum =0;
				for(int i = 0;i<header.length;i++){
					HSSFCell cell = headerRow.createCell(colNum);
					cell.setCellStyle(styleHeader);
					cell.setCellValue(header[i]);
					sheet.setColumnWidth(i,width[i]);
					colNum++;
				}
				rowNum++;
				long count = 0;
				if(list!= null && list.size()>0){
					long linhvucId = 0L;
					for(int a=0;a<list.size();a++){
							String tinh_trang = "";
							if(Validator.isNotNull(list.get(a).getNGAYTRAKETQUA()) && Validator.isNotNull(list.get(a).getNGAYHENTRAKETQUA())){
								DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
								Date ngaytra = df.parse(list.get(a).getNGAYTRAKETQUA());
								Date ngayhentra = df.parse(list.get(a).getNGAYHENTRAKETQUA());
								if(ngaytra.before(ngayhentra)){
									tinh_trang = "Sá»›m háº¹n";
								}else if(ngaytra.equals(ngayhentra)){
									tinh_trang ="Ä�Ãºng háº¹n";
								}else if(ngaytra.after(ngayhentra)){
									tinh_trang ="Trá»… háº¹n";
								}
							}
							//khai bao dong va cac cell
							HSSFRow row = (HSSFRow) sheet.createRow(rowNum);
							HSSFCell cell = row.createCell(0);
							HSSFCell cell1 = row.createCell(1);
							HSSFCell cell2 = row.createCell(2);
							HSSFCell cell3 = row.createCell(3);
							HSSFCell cell4 = row.createCell(4);
							HSSFCell cell5 = row.createCell(5);
							HSSFCell cell6 = row.createCell(6);
							HSSFCell cell7 = row.createCell(7);
							HSSFCell cell8 = row.createCell(8);
							HSSFCell cell9 = row.createCell(9);
							HSSFCell cell10 = row.createCell(10);
							HSSFCell cell11 = row.createCell(11);
							HSSFCell cell12 = row.createCell(12);
							//set style cho cac cell
							cell.setCellStyle(styleCellCenter);
							cell1.setCellStyle(styleCellLeft);
							cell2.setCellStyle(styleCellCenter);
							cell3.setCellStyle(styleCellCenter);
							cell4.setCellStyle(styleCellCenter);
							cell5.setCellStyle(styleCellCenter);
							cell6.setCellStyle(styleCellCenter);
							cell7.setCellStyle(styleCellCenter);
							cell8.setCellStyle(styleCellCenter);
							cell9.setCellStyle(styleCellCenter);
							cell10.setCellStyle(styleCellCenter);
							cell11.setCellStyle(styleCellCenter);
							cell12.setCellStyle(styleCellCenter);
							//set gia tri cho cac cell
							cell.setCellValue((a+1));
							cell1.setCellValue(NhomThuTucHanhChinhLocalServiceUtil.getNhomThuTucHanhChinh(list.get(a).getLINHVUCID()).getTen());
							cell2.setCellValue(list.get(a).getTEN());
							cell3.setCellValue(list.get(a).getMASOHOSO());
							cell4.setCellValue(list.get(a).getTRANGTHAI());
							cell5.setCellValue(list.get(a).getDIACHIHIENNAY());
							cell6.setCellValue(list.get(a).getDIENTHOAIDIDONG());
							cell7.setCellValue(list.get(a).getHOTENNGUOINOPHOSO());
							cell8.setCellValue(list.get(a).getNGUOIDAIDIENPHAPLUAT());
							cell9.setCellValue(list.get(a).getNGAYNHANHOSO());
							cell10.setCellValue(list.get(a).getNGAYTRAKETQUA());
							cell11.setCellValue(tinh_trang);
							cell12.setCellValue(list.get(a).getGHICHU());
							count = a;
							rowNum++;
					}
					count = count +1;
				}else{
					//khai bao dong va cac cell
					HSSFRow row = (HSSFRow) sheet.createRow(rowNum);
					HSSFCell cell = row.createCell(0);
					HSSFCell cell1 = row.createCell(1);
					HSSFCell cell2 = row.createCell(2);
					HSSFCell cell3 = row.createCell(3);
					HSSFCell cell4 = row.createCell(4);
					HSSFCell cell5 = row.createCell(5);
					HSSFCell cell6 = row.createCell(6);
					HSSFCell cell7 = row.createCell(7);
					HSSFCell cell8 = row.createCell(8);
					HSSFCell cell9 = row.createCell(9);
					HSSFCell cell10 = row.createCell(10);
					HSSFCell cell11 = row.createCell(11);
					HSSFCell cell12 = row.createCell(12);
					//set style cho cac cell
					cell.setCellStyle(styleCellCenter);
					cell1.setCellStyle(styleCellLeft);
					cell2.setCellStyle(styleCellCenter);
					cell3.setCellStyle(styleCellCenter);
					cell4.setCellStyle(styleCellCenter);
					cell5.setCellStyle(styleCellCenter);
					cell6.setCellStyle(styleCellCenter);
					cell7.setCellStyle(styleCellCenter);
					cell8.setCellStyle(styleCellCenter);
					cell9.setCellStyle(styleCellCenter);
					cell10.setCellStyle(styleCellCenter);
					cell11.setCellStyle(styleCellCenter);
					cell12.setCellStyle(styleCellCenter);
					//set gia tri cho cac cell
					cell.setCellValue("");
					cell1.setCellValue("");
					cell2.setCellValue("");
					cell3.setCellValue("");
					cell4.setCellValue("");
					cell5.setCellValue("");
					cell6.setCellValue("");
					cell7.setCellValue("");
					cell8.setCellValue("");
					cell9.setCellValue("");
					cell10.setCellValue("");
					cell11.setCellValue("");
					cell12.setCellValue("");
					count = 0;
					rowNum++;
				}
				sheet.addMergedRegion(new Region(rowNum, (short)0, rowNum, (short)11));
				HSSFRow rowTong = (HSSFRow) sheet.createRow(rowNum);
				HSSFCell cell = rowTong.createCell(0);
				HSSFCell cell1 = rowTong.createCell(1);
				HSSFCell cell2 = rowTong.createCell(2);
				HSSFCell cell3 = rowTong.createCell(3);
				HSSFCell cell4 = rowTong.createCell(4);
				HSSFCell cell5 = rowTong.createCell(5);
				HSSFCell cell6 = rowTong.createCell(6);
				HSSFCell cell7 = rowTong.createCell(7);
				HSSFCell cell8 = rowTong.createCell(8);
				HSSFCell cell9 = rowTong.createCell(9);
				HSSFCell cell10 = rowTong.createCell(10);
				HSSFCell cell11 = rowTong.createCell(11);
				HSSFCell cell12 = rowTong.createCell(12);
				//set style cho cac cell
				cell.setCellStyle(titleTongStyle);
				cell1.setCellStyle(styleCellCenter);
				cell2.setCellStyle(styleCellCenter);
				cell3.setCellStyle(styleCellCenter);
				cell4.setCellStyle(styleCellCenter);
				cell5.setCellStyle(styleCellCenter);
				cell6.setCellStyle(styleCellCenter);
				cell7.setCellStyle(styleCellCenter);
				cell8.setCellStyle(styleCellCenter);
				cell9.setCellStyle(styleCellCenter);
				cell10.setCellStyle(styleCellCenter);
				cell11.setCellStyle(styleCellCenter);
				cell12.setCellStyle(styleCellCenter);
				//set value for cells of rowtong 
				cell.setCellValue(LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.baocaochitiet.tonghoso"));
				cell12.setCellValue(count);
				
				rowNum =rowNum+2;
				sheet.addMergedRegion(new Region(rowNum,(short)1,rowNum,(short)2));
				HSSFRow nguoilap_baocaoRow = sheet.createRow(rowNum);
				HSSFCell nguoilap_Cell = nguoilap_baocaoRow.createCell(1);
				nguoilap_Cell.setCellValue(LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.excel.nguoilap"));
				nguoilap_Cell.setCellStyle(styleTitle);
				
				sheet.addMergedRegion(new Region(rowNum,(short)7,rowNum,(short)10));
				HSSFCell title_nguoibaocao_Cell = nguoilap_baocaoRow.createCell(7);
				title_nguoibaocao_Cell.setCellValue(LanguageUtil.get((PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG) ,resourceRequest.getLocale(),"vn.dtt.cmon.report.excel.nguoibaocao"));
				title_nguoibaocao_Cell.setCellStyle(styleTitle);
				
				rowNum = rowNum+4;
				
				if(Validator.isNotNull(resourceRequest.getAttribute("THEME_DISPLAY"))){
					CongChuc congchuc = new CongChucImpl();
					ThemeDisplay themdisplay = (ThemeDisplay) resourceRequest.getAttribute("THEME_DISPLAY");
					User user = themdisplay.getUser();
					TaiKhoanNguoiDung taikhoan = new TaiKhoanNguoiDungImpl();
					taikhoan = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(user.getUserId());
					congchuc = ActionUtil.getCongchucByTaiKhoanNguoiDungId(taikhoan.getId());
					
					sheet.addMergedRegion(new Region(rowNum,(short)1,rowNum,(short)2));
					HSSFRow nguoi_baocaoRow = sheet.createRow(rowNum);
					HSSFCell nguoibaocao_Cell = nguoi_baocaoRow.createCell(1);
					nguoibaocao_Cell.setCellValue(congchuc.getHoVaTen());
					nguoibaocao_Cell.setCellStyle(styleTitle);
				}
		
				resourceResponse.setContentType("application/vnd.ms-excel;charset=utf-8");
			 resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
			 resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=Baocaochitiet.xls");
			 OutputStream out = resourceResponse.getPortletOutputStream();
			 workbook.write(out);
			 out.flush();
			 out.close();
		} catch ( Exception e ) {
		}
	}

	/**
	 * This is function get CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param test
	 * @param user_id
	 * @param baocao_id
	 * @throws Exception
	 * @return List<CoQuanQuanLy>
	 */
	public static List<CoQuanQuanLy> getCoquanquanly(boolean test,long user_id,
			long baocao_id) throws Exception {
		List<CoQuanQuanLy> listCoQuanQuanLy = new ArrayList<CoQuanQuanLy>();
		if(test){
			listCoQuanQuanLy = CongChuc2RoleLocalServiceUtil.getCoQuanQuanLy(user_id, baocao_id);
		}else{
			CongChuc congChuc = ActionUtil.getCongchucByTaiKhoanNguoiDungId(user_id);
			if(congChuc!=null){
				listCoQuanQuanLy.add(CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(congChuc.getCoQuanQuanLyId()));
			}
		}
		return listCoQuanQuanLy;
	}

	/**
	 * This is function get DanhMucBaoCao
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param user_id
	 * @throws Exception
	 * @return List<DanhMucBaoCao>
	 */
	public static List<DanhMucBaoCao> getDanhmucbaocao(long user_id) 
			throws Exception {
		return CongChuc2RoleLocalServiceUtil.getDanhsachbaocao(user_id);
	}
	
	/**
	 * This is function get NhomThuTucHanhChinh
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param test
	 * @param user_id
	 * @param baocao_id
	 * @param donvi_id
	 * @throws Exception
	 * @return List<NhomThuTucHanhChinh>
	 */
	public static List<NhomThuTucHanhChinh> getNhomTTHC(boolean test,long user_id,
			long baocao_id, long donvi_id) throws Exception {
		List<NhomThuTucHanhChinh> listNhomThuTucHanhChinh = new ArrayList<NhomThuTucHanhChinh>();
		if(test){
			listNhomThuTucHanhChinh = CongChuc2RoleLocalServiceUtil.getNhomTTHC(user_id, baocao_id,donvi_id);
		}else{
			CongChuc congChuc = ActionUtil.getCongchucByTaiKhoanNguoiDungId(user_id);
			if(congChuc!=null){
				listNhomThuTucHanhChinh = NhomThuTucHanhChinhLocalServiceUtil.getDSNhomThuTucHanhChinhByCanBo(congChuc.getId());
			}
		}
		return listNhomThuTucHanhChinh;
	}

	/**
	 * This is function get list ThuTucHanhChinh by CanBo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param congChuc
	 * @throws Exception
	 * @return List<ThuTucHanhChinh>
	 */
	public static List<ThuTucHanhChinh> getListTTHCByCanBo(CongChuc congChuc) throws Exception {
		List<ThongTinThuTuc> list = HoSoBusinessUtil.getDSThuTuc2CanBo(congChuc);
		List<ThuTucHanhChinh> out = new ArrayList<ThuTucHanhChinh>();
		ThuTucHanhChinh tthc;
		for (ThongTinThuTuc item : list) {
			tthc = new ThuTucHanhChinhClp();
			tthc.setId(item.getThuTucId());
			tthc.setNhomThuTucHanhChinhId(item.getNhomThuTucId());
			tthc.setTen(item.getTenThuTuc());
			tthc.setMa(item.getMaThuTuc());
			out.add(tthc);
		}
		return out;
	}
	
	/**
	 * This is function get ThuTucHanhChinh
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param test
	 * @param user_id
	 * @param baocao_id
	 * @param donvi_id
	 * @throws Exception
	 * @return List<ThuTucHanhChinh>
	 */
	public static List<ThuTucHanhChinh> getTTHC(boolean test, long user_id, long baocao_id,
			long donvi_id) throws Exception {
		List<ThuTucHanhChinh> listThuTucHanhChinh = new ArrayList<ThuTucHanhChinh>();
		if(test){
			listThuTucHanhChinh = CongChuc2RoleLocalServiceUtil.getThutuchanhchinh(user_id,baocao_id, donvi_id);
		}else{
			CongChuc congChuc = ActionUtil.getCongchucByTaiKhoanNguoiDungId(user_id);
			if(congChuc!=null){
				listThuTucHanhChinh = getListTTHCByCanBo(congChuc);
			}
		}
		return listThuTucHanhChinh;
	}
	
	/**
	 * This is function get ThuTucHanhChinh
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param test
	 * @param user_id
	 * @param baocao_id
	 * @param donvi_id
	 * @param idUngDung
	 * @throws Exception
	 * @return List<ThuTucHanhChinh>
	 */
	public static List<ThuTucHanhChinh> getTTHCChungThuc(boolean test, long user_id, long baocao_id,
			long donvi_id,long idUngDung) throws Exception {
		List<ThuTucHanhChinh> listTTHC = new ArrayList<ThuTucHanhChinh>();
		if(test){
			listTTHC = CongChuc2RoleLocalServiceUtil.getThutuchanhchinh(user_id,baocao_id, donvi_id);
		}else{
			CongChuc congChuc = ActionUtil.getCongchucByTaiKhoanNguoiDungId(user_id);
			//filter the tthc by ung dung chung thuc
			List<NhomThuTucHanhChinh> listNhomTTHC =  NhomThuTucHanhChinhLocalServiceUtil.
					getDSNhomThuTucHanhChinhByCanBo(congChuc.getId());  
			if (listNhomTTHC != null && !listNhomTTHC.isEmpty()) {
				for (NhomThuTucHanhChinh ntthc: listNhomTTHC) {
					if (ntthc.getDanhMucUngDungId() == idUngDung) {
						List<ThuTucHanhChinh> listTthc = ThuTucHanhChinhLocalServiceUtil.searchByUngDungOrNhom(null, ntthc.getId(), 0, 1000);
						listTTHC.addAll(listTthc);
					}
				}
			}   
		}
		return listTTHC;
	}
	
	/**
	 * This is function test report permission
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param user_id
	 * @param baocao_id
	 * @throws Exception
	 * @return Bollean
	 */
	public static Boolean testReportPermission(long user_id, long baocao_id) throws Exception {
		return CongChuc2RoleLocalServiceUtil.testReportPermission(user_id, baocao_id);
	}
	
	/**
	 * This is function get CongChuc by TaiKhoanNguoiDungId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param tkNguoidungId
	 * @throws Exception
	 * @return CongChuc
	 */
	@SuppressWarnings("unchecked")
	public static CongChuc getCongchucByTaiKhoanNguoiDungId(long tkNguoidungId) throws Exception {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CongChuc.class);
		query.add(PropertyFactoryUtil.forName("taiKhoanNguoiDungId").eq(tkNguoidungId));
		List<CongChuc> listcc = CongChucLocalServiceUtil.dynamicQuery(query);
		if(listcc.size()>0){
			return listcc.get(0);
		}
		return null;
	}
	public static List<ReportTongHop> getListReportTongHop(String idDonVi,String arrIDNhomThuTuc,String nam) throws Exception {
		return ReportTongHopLocalServiceUtil.getListReportTongHop(idDonVi, arrIDNhomThuTuc, nam);
	}
	
	public static List<ReportTongHop> getListReportTongHopGroupByIDNhomThuTuc(String idDonVi,String arrIDNhomThuTuc,String arrThang,String nam) throws Exception {
		return ReportTongHopLocalServiceUtil.getListReportTongHopGroupByIDNhomThuTuc(idDonVi, arrIDNhomThuTuc, arrThang, nam);
	}
	
	/**
	 * This is function get list HoSoChungThuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param str_loaihoso
	 * @param ngaynhan_tungay
	 * @param ngaynhan_denngay
	 * @throws Exception
	 * @return List<HoSoChungThuc>
	 */
	@SuppressWarnings("unchecked")
	public static List<HoSoChungThuc> listhsct(String str_loaihoso,String ngaynhan_tungay,String ngaynhan_denngay) throws Exception{
		List<HoSoChungThuc> hosochungthuc = new ArrayList<HoSoChungThuc>();
		if(!str_loaihoso.equals("")){
			List<Long> arr_loaihoso = new ArrayList<Long>();
			List<String> id_loaihoso = new ArrayList<String>(Arrays.asList(str_loaihoso.split(",")));
			for(int i=0;i<id_loaihoso.size();i++){
				arr_loaihoso.add(Long.valueOf(id_loaihoso.get(i)));
			}
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(HoSoChungThuc.class);
			query.add(PropertyFactoryUtil.forName("thuTucHanhChinhId").in(arr_loaihoso.toArray()));
			if(!ngaynhan_tungay.equals("")){
				query.add(PropertyFactoryUtil.forName("ngayNopHoSo").ge(df.parse(ngaynhan_tungay)));
			}
			if(!ngaynhan_denngay.equals("")){
				query.add(PropertyFactoryUtil.forName("ngayNopHoSo").le(df.parse(ngaynhan_denngay)));
			}
			query.addOrder(OrderFactoryUtil.asc("ngayNopHoSo"));
			hosochungthuc = HoSoChungThucLocalServiceUtil.dynamicQuery(query);
		}
		return hosochungthuc;
	}
	
}
