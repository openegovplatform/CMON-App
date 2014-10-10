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


package org.oep.cmon.dao.qlhc.service.impl;

import java.util.List;

import org.oep.cmon.Constants;
import org.oep.cmon.dao.qlhc.model.impl.CoQuanQuanLyImpl;
import org.oep.cmon.dao.qlhc.service.base.CoQuanQuanLyLocalServiceBaseImpl;
import org.oep.cmon.portlet.document.util.DocumentConstants;
import org.oep.cmon.util.CmonFields;

import org.oep.cmon.dao.qlhc.NoSuchQuocGiaException;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.persistence.DonViHanhChinhUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

/**
 * The implementation of the co quan quan ly local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author hunghq
 * @see org.oep.cmon.dao.qlhc.service.base.CoQuanQuanLyLocalServiceBaseImpl
 * @see org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil
 */
/**
*
* CoQuanQuanLyLocalServiceImpl class
*   
* This class is used to get CoQuanQuanLy information 
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
public class CoQuanQuanLyLocalServiceImpl extends
		CoQuanQuanLyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil} to access the
	 * co quan quan ly local service.
	 */

	/**
	  * This is fucntion findByMa 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ma
	  * @return List<CoQuanQuanLy>
	  */
	public List<CoQuanQuanLy> findByMa(String ma) throws SystemException,
			NoSuchQuocGiaException {
		return coQuanQuanLyPersistence.findByMa(ma);
	}

	public static final String FIELD_NOIBO = "noiBo";

	/**
	  * This is fucntion getDSPhongBanNoiBo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long chaId
	  * @return List<CoQuanQuanLy>
	  */
	@SuppressWarnings("unchecked")
	public List<CoQuanQuanLy> getDSPhongBanNoiBo(Long chaId)
			throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
				CoQuanQuanLyImpl.class, PortalClassLoaderUtil.getClassLoader());
		query.add(PropertyFactoryUtil.forName(CmonFields.chaId).eq(chaId));
		query.add(PropertyFactoryUtil.forName(FIELD_NOIBO).eq(1));
		query.add(PropertyFactoryUtil.forName(CmonFields.daXoa).eq(
				Constants.ACTIVE));
		return (List<CoQuanQuanLy>) CoQuanQuanLyLocalServiceUtil.dynamicQuery(
				query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	  * This is fucntion findByParentId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long chaId, int daXoa
	  * @return List<CoQuanQuanLy>
	  */
	@SuppressWarnings("unchecked")
	public List<CoQuanQuanLy> findByParentId(Long chaId, int daXoa) {
		try {
			if (chaId != null) {
				return coQuanQuanLyPersistence.findByCha(chaId, daXoa);
			} else {
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(
						CoQuanQuanLyImpl.class,
						PortalClassLoaderUtil.getClassLoader());
				query.add(PropertyFactoryUtil.forName(CmonFields.chaId).isNull());
				query.add(PropertyFactoryUtil.forName(CmonFields.daXoa).eq(
						Constants.ACTIVE));
				query.addOrder(OrderFactoryUtil.asc("ten"));
				return (List<CoQuanQuanLy>) CoQuanQuanLyLocalServiceUtil
						.dynamicQuery(query, QueryUtil.ALL_POS,
								QueryUtil.ALL_POS);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	/**
	  * This is fucntion findByCapCoQuanQuanLyId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long capCoQuanQuanlyId,int daXoa
	  * @return List<CoQuanQuanLy>
	  */
	public List<CoQuanQuanLy> findByCapCoQuanQuanLyId(Long capCoQuanQuanlyId,
			int daXoa) {
		try {
			return coQuanQuanLyPersistence.findByCapCoQuanQuanLy(
					capCoQuanQuanlyId, daXoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	/**
	  * This is fucntion getDSCoQuanQuanlyByMaOrTen 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maOrTen,int start, int end
	  * @return List<CoQuanQuanLy>
	  */
	public	List<CoQuanQuanLy> getDSCoQuanQuanlyByMaOrTen(String maOrTen,int start, int end){
		return coQuanQuanLyFinder.getDSCoQuanQuanlyByMaOrTen(maOrTen,start,end);
	}
	/**
	  * This is fucntion countDSCoQuanQuanlyByMaOrTen
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maOrTen
	  * @return int
	  */
	public int countDSCoQuanQuanlyByMaOrTen(String maOrTen){
		return coQuanQuanLyFinder.countDSCoQuanQuanlyByMaOrTen(maOrTen);
	}
	
	/**
	  * This is fucntion findByAllDonViHanhChinhId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long donviHanhChinhId,int typeSelect, int daXoa
	  * @return List<CoQuanQuanLy>
	  */
	public List<CoQuanQuanLy> findByAllDonViHanhChinhId(Long donviHanhChinhId,
			int typeSelect, int daXoa) {
		try {
			StringBuffer ids = new StringBuffer();
			ids.append(donviHanhChinhId.toString());
			if (typeSelect == DocumentConstants.TypeSelect.CAP_HUYEN) {
				List<DonViHanhChinh> xaList = DonViHanhChinhUtil.findByChaId(
						donviHanhChinhId, daXoa);
				if (xaList != null) {
					for (DonViHanhChinh donViHanhChinh : xaList) {
						ids.append("," + donViHanhChinh.getId());
					}
				}
			} else if (typeSelect == DocumentConstants.TypeSelect.CAP_TINH) {
				List<DonViHanhChinh> huyenList = DonViHanhChinhUtil
						.findByChaId(donviHanhChinhId, daXoa);
				if (huyenList != null) {
					for (DonViHanhChinh huyen : huyenList) {
						ids.append("," + huyen.getId());
						List<DonViHanhChinh> xaList = DonViHanhChinhUtil
								.findByChaId(huyen.getId(), daXoa);
						if (xaList != null) {
							for (DonViHanhChinh xa : xaList) {
								ids.append("," + xa.getId());
							}
						}
					}
				}
			}
			return coQuanQuanLyFinder.getDSCoQuanQuanlyByDonViHanhChinhId(ids
					.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
		return null;
	}
}