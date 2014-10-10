package org.oep.egovcore.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import org.oep.egovcore.Config;


import com.liferay.portal.kernel.util.GetterUtil;

/**
*
* NgayNghiVNUtil  class
*   
* This class is used to declare NgayNghiVNUtil 
*
* 
* 
* History:
*  
*   DATE         AUTHOR      DESCRIPTION 
*  --------------------------------------------------------
*  10-Aug-2012   NamDH       Create new
*  15-Sept-2012  LanDD       Add code to generate secret confirmation code
*
*/
public class NgayNghiVNUtil {
	
	/**
	  * This is fucntion getNgayKetThucCongViec
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date ngayBatDau, int soNgayXuLyDuKien
	  * @return Date
	  */
	public static Date getNgayKetThucCongViec(Date ngayBatDau, int soNgayXuLyDuKien) {
		if (ngayBatDau == null) {
			return null;
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(ngayBatDau);
		for (int i = 1; i <= soNgayXuLyDuKien; ++ i) {
			cal.add(Calendar.DAY_OF_YEAR, 1);
			if (laNgayNghi(cal.getTime())) {
				++ soNgayXuLyDuKien;
			}
		}
		cal.setTime(ngayBatDau);
		cal.add(Calendar.DAY_OF_YEAR, soNgayXuLyDuKien);
		return cal.getTime();
	}
	
	/**
	  * This is fucntion getSoNgayNghiTrongKhoang
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date from, Date to
	  * @return int
	  */
	public static int getSoNgayNghiTrongKhoang(Date from, Date to) {
		if (from == null || to == null) {
			return 0;
		}
		int out = 0;
		from = DateTimeUtil.getStartOfDay(from);
		to = DateTimeUtil.getStartOfDay(to);
		if (to.before(from)) {
			Date tmp = from;
			from = to;
			to = tmp;
		}
		Calendar cal = Calendar.getInstance();
		while(from.before(to)) {
			if (laNgayNghi(from)) {
				++ out;
			}
			cal.setTime(from);
			cal.add(Calendar.DAY_OF_YEAR, 1);
			from = cal.getTime();
		}
		if (laNgayNghi(to)) {
			++ out;
		}
		return out;
	}
	
	/**
	  * This is fucntion laNgayNghi
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date date
	  * @return boolean
	  */
	public static boolean laNgayNghi(Date date) {
		if (date == null) {
			return false;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dow = cal.get(Calendar.DAY_OF_WEEK);
		return (dow == Calendar.SATURDAY || dow == Calendar.SUNDAY) 
				? true
				: laNgayNghiLe(date);
	}
	
	/**
	  * This is fucntion laNgayNghiLe
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date date
	  * @return boolean
	  */
	public static boolean laNgayNghiLe(Date date) {
		if (date == null) {
			return false;
		}
		date = DateTimeUtil.getStartOfDay(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		
		return _laNgayNghiLe(date, year);
	}
	
	/**
	  * This is fucntion getNgayNghiLe
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String key, int year
	  * @return NgayNghiLeVn
	  */
	public static NgayNghiLeVn getNgayNghiLe(String key, int year) {
		if (key == null) {
			return null;
		}
		year = _getValidYear(year);
		String tmp;
		String[] arrTmp;
		Date[] arrNgay;
		
		tmp = _getValueNgayDuong(key);
		if (!tmp.isEmpty()) {
			arrTmp = tmp.split(SEP);
			arrNgay = new Date[arrTmp.length];
			for (int i = 0; i < arrNgay.length; ++ i) {
				arrNgay[i] = DateTimeUtil.parseDate(arrTmp[i] + StringPool.SLASH + year);
			}
		} else {
			tmp = _getValueNgayAm(key);
			arrTmp = tmp.split(SEP);
			arrNgay = new Date[arrTmp.length];
			for (int i = 0; i < arrNgay.length; ++ i) {
				arrNgay[i] = _getNgayDuongLich(arrTmp[i], year);
			}
		}
		return new NgayNghiLeVn(_getValueMoTa(key), arrNgay, key.startsWith(QD_PREFIX));
	}
	
	/**
	  * This is fucntion getDSNgayNghiLeTheoQuyDinh
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int year
	  * @return List<NgayNghiLeVn>
	  */
	public static List<NgayNghiLeVn> getDSNgayNghiLeTheoQuyDinh(int year) {
		year = _getValidYear(year);
		List<NgayNghiLeVn> out = new ArrayList<NgayNghiLeVn>();
		Enumeration<String> keys = _dataSource.getKeys();
		String curKey = StringPool.BLANK, key;
		for (Enumeration<String> e = keys; keys.hasMoreElements();) {
			key = Config.getRootKey(e.nextElement());
			if (key.startsWith(QD_PREFIX) && !curKey.equals(key)) {
				curKey = key;
				out.add(getNgayNghiLe(curKey, year));
			}
		}
		return out;
	}

	/**
	  * This is fucntion getDSNgayNghiLe
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int year
	  * @return List<NgayNghiLeVn>
	  */
	public static List<NgayNghiLeVn> getDSNgayNghiLe(int year) {
		year = _getValidYear(year);
		List<NgayNghiLeVn> out = new ArrayList<NgayNghiLeVn>();
		Enumeration<String>  keys = _dataSource.getKeys();
		String curKey = StringPool.BLANK, key;
		for (Enumeration<String>  e = keys; keys.hasMoreElements();) {
			key = Config.getRootKey(e.nextElement());
			if (!curKey.equals(key)) {
				curKey = key;
				out.add(getNgayNghiLe(curKey, year));
			}
		}
		return out;
	}
	
	/**
	  * This is class NgayNghiLeVn
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return 
	  */
	public static class NgayNghiLeVn {
		/**
		  * This is Contructor NgayNghiLeVN
		  * Version: 1.0
		  *  
		  * History: 
		  *   DATE        AUTHOR      DESCRIPTION 
		  *  ------------------------------------------------- 
		  *  3-March-2013  Nam Dinh    Create new
		  * @param String moTa, Date[] dsNgay, boolean theoQuyDinh
		  * @return 
		  */
		public NgayNghiLeVn(String moTa, Date[] dsNgay, boolean theoQuyDinh) {
			_moTa = moTa;
			_dsNgay = dsNgay; 
			_theoQuyDinh = theoQuyDinh; 
		}
		
		/**
		  * This is fucntion getMoTa
		  * Version: 1.0
		  *  
		  * History: 
		  *   DATE        AUTHOR      DESCRIPTION 
		  *  ------------------------------------------------- 
		  *  3-March-2013  Nam Dinh    Create new
		  * @param 
		  * @return String
		  */
		public String getMoTa() {
			return _moTa;
		}
		
		/**
		  * This is fucntion getDSNgay
		  * Version: 1.0
		  *  
		  * History: 
		  *   DATE        AUTHOR      DESCRIPTION 
		  *  ------------------------------------------------- 
		  *  3-March-2013  Nam Dinh    Create new
		  * @param 
		  * @return Date[]
		  */
		public Date[] getDSNgay() {
			return _dsNgay;
		}
		
		/**
		  * This is fucntion getTheoQuyDinh
		  * Version: 1.0
		  *  
		  * History: 
		  *   DATE        AUTHOR      DESCRIPTION 
		  *  ------------------------------------------------- 
		  *  3-March-2013  Nam Dinh    Create new
		  * @param 
		  * @return boolean
		  */
		public boolean getTheoQuyDinh() {
			return _theoQuyDinh;
		}
		private String _moTa;
		private Date[] _dsNgay;
		private boolean _theoQuyDinh;
	}
	
	private static final String QD_PREFIX = "qd_";
	private static final String KEY_MOTA = "moTa";
	private static final String KEY_NGAYDUONG = "ngayDuong";
	private static final String KEY_NGAYAM = "ngayAm";
	
	// ky hieu chia tach cac day~ ngay, vd: 30/11|02/12|05/12 => se lay duoc 3 ngay
	private static final String SEP = "\\|";
	private static final String DMY_SEP = "\\/";
	
	
	/**
	  * This is fucntion _laNgayNghiLe
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date date, int year
	  * @return boolean
	  */
	private static boolean _laNgayNghiLe(Date date, int year) {
		Enumeration<String>  keys = _dataSource.getKeys();
		String curKey = StringPool.BLANK, key;
		for (Enumeration<String>  e = keys; keys.hasMoreElements();) {
			key = Config.getRootKey(e.nextElement());
			if (!curKey.equals(key)) {
				curKey = key;
				for (Date d : getNgayNghiLe(curKey, year).getDSNgay()) {
					if (d.equals(date)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	  * This is fucntion _getValidYear
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int year
	  * @return int
	  */
	private static int _getValidYear(int year) {
		return (year < 1945 || year > 2199) ? Calendar.getInstance().get(Calendar.YEAR) : year; 
	}
	
	
	/**
	  * This is fucntion _getValueMoTa
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String key
	  * @return String
	  */
	private static String _getValueMoTa(String key) {
		return _dataSource.get(key + StringPool.PERIOD + KEY_MOTA).trim();
	}
	
	/**
	  * This is fucntion _getValueNgayDuong
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String key
	  * @return long
	  */
	private static String _getValueNgayDuong(String key) {
		return _dataSource.get(key + StringPool.PERIOD + KEY_NGAYDUONG).trim();
	}
	
	/**
	  * This is fucntion _getValueNgayAm
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String key
	  * @return String
	  */
	private static String _getValueNgayAm(String key) {
		return _dataSource.get(key + StringPool.PERIOD + KEY_NGAYAM).trim();
	}
	
	/**
	  * This is fucntion _getNgayDuongLich
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ddMMAL, int yearAL
	  * @return Date
	  */
	private static Date _getNgayDuongLich(String ddMMAL, int yearAL) {
		int[] arrDMYAL = parseDMY(ddMMAL, yearAL);
		int[] ngayDL = VNCalendar.convertLunar2Solar(
			arrDMYAL[0], 
			arrDMYAL[1], 
			arrDMYAL[2],
			0,
			VNCalendar.VN_TIMEZONE
		);
		Calendar cal = Calendar.getInstance();
		cal.set(ngayDL[2], ngayDL[1] - 1, ngayDL[0]);
		
		if (arrDMYAL[0] == 30) {
			boolean laThangChap = (arrDMYAL[1] == 12);
			int[] ngayKeTiepDL = VNCalendar.convertLunar2Solar(
				1, 
				laThangChap ? 1 : arrDMYAL[1] + 1, 
				laThangChap ? arrDMYAL[2] + 1 : arrDMYAL[2],
				0,
				VNCalendar.VN_TIMEZONE
			);
			
			if (Arrays.equals(ngayDL, ngayKeTiepDL)) {
				cal.add(Calendar.DAY_OF_YEAR, -1);
			}
		}
		return DateTimeUtil.getStartOfDay(cal.getTime());
	}
	
	
	/**
	  * This is fucntion parseDMY
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ddMM, int year
	  * @return int[]
	  */
	public static int[] parseDMY(String ddMM, int year) {
		year = _getValidYear(year);
		int[] out = new int[] {1, 1, year};
		if (ddMM != null) {
			String[] tmp = ddMM.split(DMY_SEP);
			out[0] = GetterUtil.getInteger(Helper.stringFromArray(tmp, 0));
			out[1] = GetterUtil.getInteger(Helper.stringFromArray(tmp, 1));
		}
		return out;
	}
	
	private static Config _dataSource = Config.forClass(NgayNghiVNUtil.class);
}
