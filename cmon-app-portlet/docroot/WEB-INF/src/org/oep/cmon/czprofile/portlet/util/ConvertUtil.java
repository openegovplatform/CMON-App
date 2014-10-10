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

package org.oep.cmon.czprofile.portlet.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.oep.cmon.dao.cd.model.DanToc;
import org.oep.cmon.dao.cd.model.DanTocClp;
import org.oep.cmon.dao.cd.model.GioiTinh;
import org.oep.cmon.dao.cd.model.GioiTinhClp;
import org.oep.cmon.dao.cd.model.NgheNghiep;
import org.oep.cmon.dao.cd.model.NgheNghiepClp;
import org.oep.cmon.dao.cd.model.QuanHeGiaDinh;
import org.oep.cmon.dao.cd.model.QuanHeGiaDinhClp;
import org.oep.cmon.dao.cd.model.TinhTrangHonNhan;
import org.oep.cmon.dao.cd.model.TinhTrangHonNhanClp;
import org.oep.cmon.dao.cd.model.TonGiao;
import org.oep.cmon.dao.cd.model.TonGiaoClp;
import org.oep.cmon.dao.cd.model.TrinhDoChuyenMon;
import org.oep.cmon.dao.cd.model.TrinhDoChuyenMonClp;
import org.oep.cmon.dao.cd.model.TrinhDoHocVan;
import org.oep.cmon.dao.cd.model.TrinhDoHocVanClp;

import org.oep.cmon.dao.cd.service.DanTocLocalServiceUtil;
import org.oep.cmon.dao.cd.service.GioiTinhLocalServiceUtil;
import org.oep.cmon.dao.cd.service.NgheNghiepLocalServiceUtil;
import org.oep.cmon.dao.cd.service.QuanHeGiaDinhLocalServiceUtil;
import org.oep.cmon.dao.cd.service.TinhTrangHonNhanLocalServiceUtil;
import org.oep.cmon.dao.cd.service.TonGiaoLocalServiceUtil;
import org.oep.cmon.dao.cd.service.TrinhDoChuyenMonLocalServiceUtil;
import org.oep.cmon.dao.cd.service.TrinhDoHocVanLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinhClp;
import org.oep.cmon.dao.qlhc.model.QuocGia;
import org.oep.cmon.dao.qlhc.model.QuocGiaClp;

import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil;

/**
 * This is class ConvertUtil  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class ConvertUtil {
	static SimpleDateFormat formatDateShort = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * This is function convert date to string
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param date
	 * @return String
	 */
	public static String parseDateToTring(Date date) {
		try {
			return formatDateShort.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	/**
	 * This is function get DonViHanhChinh by id
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
	 * @return DonViHanhChinh
	 */
	public static DonViHanhChinh getDonViHanhChinh(long id) {
		DonViHanhChinh donViHanhChinh = null;
		try {
			donViHanhChinh = DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(id);
		} catch (Exception e) {
			try {
				donViHanhChinh = DonViHanhChinhLocalServiceUtil.fetchDonViHanhChinh(id);
			} catch (Exception e1) {
			}
		}
		if (donViHanhChinh == null) {
			donViHanhChinh = new DonViHanhChinhClp();
			donViHanhChinh.setTen("");
		} 
		return donViHanhChinh;
	}
	
	/**
	 * This is function get GioiTinh by id
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
	 * @return GioiTinh
	 */
	public static GioiTinh getGioiTinh(long id) {
		GioiTinh gioiTinh = null;
		try {
			gioiTinh = GioiTinhLocalServiceUtil.fetchGioiTinh(id);
		} catch (Exception e) {
			try {
				gioiTinh =  GioiTinhLocalServiceUtil.fetchGioiTinh(id);
			} catch (Exception e1) {
			}
		}
		if (gioiTinh == null) {
			gioiTinh = new GioiTinhClp();
		} 
		return gioiTinh;
	}
	
	/**
	 * This is function get DanToc by id
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
	 * @return DanToc
	 */
	public static DanToc getDanToc(long id) {
		DanToc danToc = null;
		try {
			danToc =  DanTocLocalServiceUtil.fetchDanToc(id);
		} catch (Exception e) {
			try {
				danToc =  DanTocLocalServiceUtil.fetchDanToc(id);
			} catch (Exception e1) {
			}
		}
		if (danToc == null) {
			danToc = new DanTocClp();
		} 
		return danToc;
	}
	
	/**
	 * This is function get QuocGia by id
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
	 * @return QuocGia
	 */
	public static QuocGia getQuocGia(long id) {
		QuocGia quocGia = null;
		try {
			quocGia =  QuocGiaLocalServiceUtil.fetchQuocGia(id);
		} catch (Exception e) {
			try {
				quocGia =  QuocGiaLocalServiceUtil.fetchQuocGia(id);
			} catch (Exception e1) {
			}
		}
		if (quocGia == null) {
			quocGia = new QuocGiaClp();
		} 
		return quocGia;
	}
	
	/**
	 * This is function get TonGiao by id
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
	 * @return TonGiao
	 */
	public static TonGiao getTonGiao(long id) {
		TonGiao quocGia = null;
		try {
			 quocGia = TonGiaoLocalServiceUtil.fetchTonGiao(id);
		} catch (Exception e) {
			try {
				 quocGia = TonGiaoLocalServiceUtil.fetchTonGiao(id);
			} catch (Exception e1) {
			}
		}
		if (quocGia == null) {
			quocGia = new TonGiaoClp();
		} 
		return quocGia;
	}
	
	/**
	 * This is function get TrinhDoChuyenMon by id
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
	 * @return TrinhDoChuyenMon
	 */
	public static TrinhDoChuyenMon getTrinhDoChuyenMon(long id) {
		TrinhDoChuyenMon quocGia = null;
		try {
			quocGia =  TrinhDoChuyenMonLocalServiceUtil.fetchTrinhDoChuyenMon(id);
		} catch (Exception e) {
			try {
				quocGia =  TrinhDoChuyenMonLocalServiceUtil.fetchTrinhDoChuyenMon(id);
			} catch (Exception e1) {
			}
		}
		if (quocGia == null) {
			quocGia = new TrinhDoChuyenMonClp();
		} 
		return quocGia;
	}
	
	/**
	 * This is function get TrinhDoHocVan by id
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
	 * @return TrinhDoHocVan
	 */
	public static TrinhDoHocVan getTrinhDoHocVan(long id) {
		TrinhDoHocVan quocGia = null;
		try {
			quocGia =   TrinhDoHocVanLocalServiceUtil.fetchTrinhDoHocVan(id);
		} catch (Exception e) {
			try {
				quocGia =   TrinhDoHocVanLocalServiceUtil.fetchTrinhDoHocVan(id);
			} catch (Exception e1) {
			}
		}
		if (quocGia == null) {
			quocGia = new TrinhDoHocVanClp();
		} 
		return quocGia;
	}
	
	/**
	 * This is function get NgheNghiep by id
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
	 * @return NgheNghiep
	 */
	public static NgheNghiep getNgheNghiep(long id) {
		NgheNghiep quocGia = null;
		try {
			quocGia =  NgheNghiepLocalServiceUtil.fetchNgheNghiep(id);
		} catch (Exception e) {
			try {
				quocGia =  NgheNghiepLocalServiceUtil.fetchNgheNghiep(id);
			} catch (Exception e1) {
			}
		}
		if (quocGia == null) {
			quocGia = new NgheNghiepClp();
		} 
		return quocGia;
	}
	
	/**
	 * This is function get QuanHeGiaDinh by id
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
	 * @return QuanHeGiaDinh
	 */
	public static QuanHeGiaDinh getQuanHeGiaDinh(long id) {
		QuanHeGiaDinh quocGia = null;
		try {
			quocGia =  QuanHeGiaDinhLocalServiceUtil.fetchQuanHeGiaDinh(id);
		} catch (Exception e) {
			try {
				quocGia =  QuanHeGiaDinhLocalServiceUtil.fetchQuanHeGiaDinh(id);
			} catch (Exception e1) {
			}
		}
		if (quocGia == null) {
			quocGia = new QuanHeGiaDinhClp();
		} 
		return quocGia;
	}
	
	/**
	 * This is function get TinhTrangHonNhan by id
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
	 * @return TinhTrangHonNhan
	 */
	public static TinhTrangHonNhan getTinhTrangHonNhan(long id) {
		TinhTrangHonNhan quocGia = null;
		try {
			quocGia =  TinhTrangHonNhanLocalServiceUtil.fetchTinhTrangHonNhan(id);
		} catch (Exception e) {
			try {
				quocGia =  TinhTrangHonNhanLocalServiceUtil.fetchTinhTrangHonNhan(id);
			} catch (Exception e1) {
			}
		}
		if (quocGia == null) {
			quocGia = new TinhTrangHonNhanClp();
		} 
		return quocGia;
	}
}
