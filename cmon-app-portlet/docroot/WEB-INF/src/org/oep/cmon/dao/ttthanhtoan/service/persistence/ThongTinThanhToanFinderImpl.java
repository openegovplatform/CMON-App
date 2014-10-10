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

package org.oep.cmon.dao.ttthanhtoan.service.persistence;

import java.util.List;

import org.oep.cmon.Constants;
import org.oep.cmon.dao.ttthanhtoan.model.impl.ThongTinThanhToanImpl;

import org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan;
import org.oep.cmon.dao.ttthanhtoan.service.persistence.ThongTinThanhToanFinder;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
/**
*
* ThongTinThanhToanFinderImpl class
*   
* This class is used to get ThongTinThanhToan information 
* from database
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
public class ThongTinThanhToanFinderImpl extends BasePersistenceImpl<ThongTinThanhToan> implements ThongTinThanhToanFinder {

	/**
	  * This is fucntion searchByCoQuanQuanLyHoSo_QT 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long coQuanQuanLyId, String searchProfileCode, int loaiPhi, int start, int end
	  * @return List<ThongTinThanhToan>
	  */
	public List<ThongTinThanhToan> searchByCoQuanQuanLyHoSo_QT(long coQuanQuanLyId, String searchProfileCode, int loaiPhi, int start, int end) {
		Session session = null;
		Log log = LogFactoryUtil.getLog("");
		try {
			session = openSession();
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SELECT * FROM(");
			sqlBuilder.append("(SELECT tttt.* FROM CMON_THONGTINTHANHTOAN tttt INNER JOIN CMON_HOSOTTHCCONG hstthcc ON tttt.HOSOTTHCCONGID = hstthcc.ID WHERE hstthcc.COQUANTIEPNHANID = ? AND tttt.LOAIPHI = ?");
			if (Validator.isNotNull(searchProfileCode)) {
				sqlBuilder.append(" AND hstthcc.MASOHOSO LIKE ? ");
			}
			sqlBuilder.append(" ) UNION (");
			sqlBuilder.append("SELECT " +
								" hstthcc.ID AS ID, hstthcc.ID AS HOSOTTHCCONGID, tttt.TAIKHOANNGUOIDUNGNOPID, tttt.TAIKHOANNGUOIDUNGNHANID, 1 AS LOAITHANHTOAN, tttt.TENNGUOINOPTIEN, "
							+ "tttt.TENCANBONHANTIEN, 0 AS XACNHAN, ");
			if (loaiPhi == Constants.ThongTinThanhToan.PHI) {
				sqlBuilder.append(" 1 AS LOAIPHI");
			} else {
				sqlBuilder.append(" 2 AS LOAIPHI");
			}
			sqlBuilder.append(", tttt.SOTIEN, tttt.NGAYTHUTIEN, tttt.NGAYXACNHAN, tttt.NGAYCHUYENTIEN, tttt.YKIEN, "
							+ "tttt.NGUOITAO, Null AS NGAYTAO, tttt.NGUOISUA, tttt.NGAYSUA, tttt.NOILUUTRUID "
							+ " FROM CMON_HOSOTTHCCONG hstthcc LEFT JOIN CMON_THONGTINTHANHTOAN tttt ON hstthcc.ID = tttt.HOSOTTHCCONGID AND TTTT.LOAIPHI = " + loaiPhi
							+ "  WHERE tttt.LOAIPHI is Null AND hstthcc.DAXOA = 0 AND hstthcc.COQUANTIEPNHANID = ? " 
							+ " AND hstthcc.TRANGTHAIHOSO IN ('" + Constants.TRANGTHAIHOSO.HO_SO_MOI_DANG_KY_TRUC_TUYEN + "','" + Constants.TRANGTHAIHOSO.HO_SO_DA_TIEP_NHAN + "','" + Constants.TRANGTHAIHOSO.HO_SO_CHO_BO_XUNG + "','" 
					+ Constants.TRANGTHAIHOSO.HO_SO_DA_XU_LY_XONG + "','" + Constants.TRANGTHAIHOSO.HO_SO_DANG_XU_LY + "','" + Constants.TRANGTHAIHOSO.HO_SO_DA_BO_XUNG_CHO_TN + "')");
			if (loaiPhi == Constants.ThongTinThanhToan.PHI) {
				sqlBuilder.append(" AND hstthcc.PHIHOSO > 0");
			} else {
				sqlBuilder.append(" AND hstthcc.LEPHI > 0");
			}
			if (Validator.isNotNull(searchProfileCode)) {
				sqlBuilder.append(" AND hstthcc.MASOHOSO LIKE ? ");
			}
			sqlBuilder.append(")");
			
			sqlBuilder.append(") ORDER BY HOSOTTHCCONGID DESC");
			
			SQLQuery q = session.createSQLQuery(sqlBuilder.toString());
			q.setCacheable(false);
			q.addEntity("ThongTinThanhToan", ThongTinThanhToanImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(coQuanQuanLyId);
			qPos.add(loaiPhi);
			if (Validator.isNotNull(searchProfileCode)) {
				qPos.add(searchProfileCode + "%");
			}

			qPos.add(coQuanQuanLyId);
			if (Validator.isNotNull(searchProfileCode)) {
				qPos.add(searchProfileCode + "%");
			}
			return (List<ThongTinThanhToan>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}

		return null;
	}

	/**
	  * This is fucntion countByCoQuanQuanLyHoSo_QT
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long coQuanQuanLyId, String searchProfileCode, int loaiPhi
	  * @return int
	  */
	public int countByCoQuanQuanLyHoSo_QT(long coQuanQuanLyId, String searchProfileCode, int loaiPhi){
		Session session = null;
		try {
			session = openSession();
			StringBuilder sqlBuilder = new StringBuilder("(SELECT tttt.* FROM CMON_THONGTINTHANHTOAN tttt INNER JOIN CMON_HOSOTTHCCONG hstthcc ON tttt.HOSOTTHCCONGID = hstthcc.ID WHERE hstthcc.COQUANTIEPNHANID = ? AND tttt.LOAIPHI = ?");
			if (Validator.isNotNull(searchProfileCode)) {
				sqlBuilder.append(" AND hstthcc.MASOHOSO LIKE ? ");
			}
			sqlBuilder.append(" ) UNION (");
			sqlBuilder.append("SELECT " +
								" hstthcc.ID AS ID, hstthcc.ID AS HOSOTTHCCONGID, tttt.TAIKHOANNGUOIDUNGNOPID, tttt.TAIKHOANNGUOIDUNGNHANID, 1 AS LOAITHANHTOAN, tttt.TENNGUOINOPTIEN, "
							+ "tttt.TENCANBONHANTIEN, 0 AS XACNHAN, ");
			if (loaiPhi == Constants.ThongTinThanhToan.PHI) {
				sqlBuilder.append(" 1 AS LOAIPHI");
			} else {
				sqlBuilder.append(" 2 AS LOAIPHI");
			}
			sqlBuilder.append(", tttt.SOTIEN, tttt.NGAYTHUTIEN, tttt.NGAYXACNHAN, tttt.NGAYCHUYENTIEN, tttt.YKIEN, "
							+ "tttt.NGUOITAO, tttt.NGAYTAO, tttt.NGUOISUA, tttt.NGAYSUA, tttt.NOILUUTRUID "
							+ " FROM CMON_HOSOTTHCCONG hstthcc LEFT JOIN CMON_THONGTINTHANHTOAN tttt ON hstthcc.ID = tttt.HOSOTTHCCONGID "
							+ " WHERE tttt.ID IS NULL AND hstthcc.DAXOA = 0 AND hstthcc.COQUANTIEPNHANID = ? " 
							+ " AND hstthcc.TRANGTHAIHOSO IN ('" + Constants.TRANGTHAIHOSO.HO_SO_MOI_DANG_KY_TRUC_TUYEN + "','" + Constants.TRANGTHAIHOSO.HO_SO_DA_TIEP_NHAN + "','" + Constants.TRANGTHAIHOSO.HO_SO_CHO_BO_XUNG + "','" 
					+ Constants.TRANGTHAIHOSO.HO_SO_DA_XU_LY_XONG + "','" + Constants.TRANGTHAIHOSO.HO_SO_DANG_XU_LY + "','" + Constants.TRANGTHAIHOSO.HO_SO_DA_BO_XUNG_CHO_TN + "')");
			if (loaiPhi == Constants.ThongTinThanhToan.PHI) {
				sqlBuilder.append(" AND hstthcc.PHIHOSO > 0");
			} else {
				sqlBuilder.append(" AND hstthcc.LEPHI > 0");
			}
			if (Validator.isNotNull(searchProfileCode)) {
				sqlBuilder.append(" AND hstthcc.MASOHOSO LIKE ? ");
			}
			sqlBuilder.append(")");
			SQLQuery q = session.createSQLQuery(sqlBuilder.toString());
			q.setCacheable(false);
			q.addEntity("ThongTinThanhToan", ThongTinThanhToanImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(coQuanQuanLyId);
			qPos.add(loaiPhi);
			if (Validator.isNotNull(searchProfileCode)) {
				qPos.add(searchProfileCode + "%");
			}

			qPos.add(coQuanQuanLyId);
			if (Validator.isNotNull(searchProfileCode)) {
				qPos.add(searchProfileCode + "%");
			}
			List<ThongTinThanhToan> list = q.list();
			return list.size();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}

		return 0;
	}
}
