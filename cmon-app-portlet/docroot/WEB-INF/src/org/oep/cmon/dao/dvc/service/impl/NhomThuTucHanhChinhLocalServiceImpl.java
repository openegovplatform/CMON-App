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


package org.oep.cmon.dao.dvc.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.oep.cmon.Constants;
import org.oep.cmon.dao.dvc.model.impl.NhomThuTucHanhChinhImpl;
import org.oep.cmon.dao.dvc.service.base.NhomThuTucHanhChinhLocalServiceBaseImpl;
import org.oep.cmon.util.CmonFields;

import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc;
import org.oep.cmon.dao.cc.service.CongChuc2NhomThuTucLocalServiceUtil;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException;
import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;



/**
 * The implementation of the nhom thu tuc hanh chinh local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hunghq
 * @see org.oep.cmon.dao.dvc.service.base.NhomThuTucHanhChinhLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dvc.service.NhomThuTucHanhChinhLocalServiceUtil
 */
/**
*
* NhomThuTucHanhChinhLocalServiceImpl class
*   
* This class is used to get NhomThuTucHanhChinh information 
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
public class NhomThuTucHanhChinhLocalServiceImpl
	extends NhomThuTucHanhChinhLocalServiceBaseImpl {
	/**
	  * This is fucntion get NhomThuTucHanhChinh by Object[] 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Object[] ids
	  * @return List<NhomThuTucHanhChinh>
	  */
	@SuppressWarnings("unchecked")
	public List<NhomThuTucHanhChinh> getDSNhomThuTucHanhChinh(Object[] ids) throws SystemException {
		List<NhomThuTucHanhChinh> out = Collections.emptyList();
		if (ids.length > 0) {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(
					NhomThuTucHanhChinhImpl.class,
					PortalClassLoaderUtil.getClassLoader());
			query.add(PropertyFactoryUtil.forName(CmonFields.id).in(ids));
			query.add(PropertyFactoryUtil.forName(CmonFields.daXoa).eq(Constants.ACTIVE));
			query.addOrder(OrderFactoryUtil.asc(CmonFields.id));
			 out = (List<NhomThuTucHanhChinh>) NhomThuTucHanhChinhLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		}
		return out;
	}
	/**
	  * This is fucntion get NhomThuTucHanhChinh by coQuanId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long coQuanId
	  * @return List<NhomThuTucHanhChinh>
	  */
	public List<NhomThuTucHanhChinh> getDSNhomThuTucHanhChinhByCoQuan(long coQuanId) throws SystemException{
		List<ThuTucHanhChinh> list = ThuTucHanhChinhLocalServiceUtil.getListTTHCByCQQL(coQuanId);
		long id = 0L;
		ArrayList<Long> ids = new ArrayList<Long>();
		for (ThuTucHanhChinh item : list) {
			if (item.getNhomThuTucHanhChinhId() != id) {
				id = item.getNhomThuTucHanhChinhId();
				ids.add(id);
			}
		}
		return getDSNhomThuTucHanhChinh(ids.toArray());
	}
	/**
	  * This is fucntion get NhomThuTucHanhChinh by canboId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long canBoId
	  * @return List<NhomThuTucHanhChinh>
	  */
	public List<NhomThuTucHanhChinh> getDSNhomThuTucHanhChinhByCanBo(long canBoId) throws SystemException{
		List<NhomThuTucHanhChinh> out = new ArrayList<NhomThuTucHanhChinh>();
		List<CongChuc2NhomThuTuc> canBo2Nhoms = CongChuc2NhomThuTucLocalServiceUtil.findByCongChuc(canBoId);
		
		if (canBo2Nhoms.isEmpty()) {
			CongChuc canBo = CongChucLocalServiceUtil.fetchCongChuc(canBoId);
			if (canBo != null && canBo.getDaXoa() == Constants.ACTIVE) {
				List<ThuTucHanhChinh> list = ThuTucHanhChinhLocalServiceUtil.getListTTHCByCQQL(canBo.getCoQuanQuanLyId());
				long id = 0L;
				ArrayList<Long> ids = new ArrayList<Long>();
				for (ThuTucHanhChinh item : list) {
					if (item.getNhomThuTucHanhChinhId() != id) {
						id = item.getNhomThuTucHanhChinhId();
						ids.add(id);
					}
				}
				out = getDSNhomThuTucHanhChinh(ids.toArray());
			}
		} else {
			int size = canBo2Nhoms.size();
			Long[] ids = new Long[size];
			for (int i = 0; i < size; ++ i) {
				ids[i] = canBo2Nhoms.get(i).getNhomThuTucId();
			}
			out = getDSNhomThuTucHanhChinh(ids);
		}
		
		return out;
	}
	/**
	  * This is fucntion get NhomThuTucHanhChinh by maUngDung 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maUngDung
	  * @return List<NhomThuTucHanhChinh>
	  */
	public List<NhomThuTucHanhChinh> getDSNhomTTHCByMaUngDung(String maUngDung) throws SystemException {
		
		List<NhomThuTucHanhChinh> out = Collections.emptyList();
		
		DanhMucUngDung ud = DanhMucUngDungLocalServiceUtil.getUngDungTheoMa(maUngDung);
		
		if (ud != null) {
			out = nhomThuTucHanhChinhPersistence.findByDanhMucUngDungId(ud.getId(), 0);
		}
		
		return out;
	}
	/**
	  * This is fucntion get NhomThuTucHanhChinh by status 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int status
	  * @return List<NhomThuTucHanhChinh>
	  */
	public List<NhomThuTucHanhChinh> getDSNhomThuTucHanhChinh(int status){
		try {
			return nhomThuTucHanhChinhPersistence.findByTrangThai(status);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	  * This is fucntion get NhomThuTucHanhChinh by ungdungId, status
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long ungdungId,int status
	  * @return List<NhomThuTucHanhChinh>
	  */
	public List<NhomThuTucHanhChinh> getDSNhomThuTucHanhChinhBoiUngDung(Long ungdungId,int status){
		try {
			return nhomThuTucHanhChinhPersistence.findByDanhMucUngDungId(ungdungId, status);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//Add by duongpt
	/**
	  * This is fucntion find NhomThuTucHanhChinh by Ma 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of ma
	  * @return NhomThuTucHanhChinh
	  */
		public NhomThuTucHanhChinh findTheoMa(String ma) throws com.liferay.portal.kernel.exception.SystemException, NoSuchNhomThuTucHanhChinhException {
			return nhomThuTucHanhChinhPersistence.findByByMa(ma);
		}
}