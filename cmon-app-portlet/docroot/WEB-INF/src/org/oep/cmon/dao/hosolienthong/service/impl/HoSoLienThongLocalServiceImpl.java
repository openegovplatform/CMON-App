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


package org.oep.cmon.dao.hosolienthong.service.impl;

import java.util.List;

import javax.portlet.PortletRequest;

import org.oep.cmon.Constants;
import org.oep.cmon.dao.hosolienthong.model.impl.HoSoLienThongImpl;
import org.oep.cmon.dao.hosolienthong.service.base.HoSoLienThongLocalServiceBaseImpl;
import org.oep.cmon.util.CmonFields;

import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.hosolienthong.model.HoSoLienThong;
import org.oep.egovcore.sqlutil.QueryResult;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

/**
 * The implementation of the ho so lien thong local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.hosolienthong.service.HoSoLienThongLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hoangtrung.nguyen
 * @see org.oep.cmon.dao.hosolienthong.service.base.HoSoLienThongLocalServiceBaseImpl
 * @see org.oep.cmon.dao.hosolienthong.service.HoSoLienThongLocalServiceUtil
 */
/**
*
* HoSoLienThongLocalServiceImpl class
*   
* This class is used to get HoSoLienThong information 
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
@SuppressWarnings("unchecked")
public class HoSoLienThongLocalServiceImpl
	extends HoSoLienThongLocalServiceBaseImpl {
	
	public static final String FIELD_HOSOID = "hoSoId"; 
	public static final String FIELD_THUTULIENTHONG = "thuTuLienThong"; 

	/**
	  * This is fucntion countByMaSoBienNhanLucGui 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoBienNhanLucGui
	  * @return int
	  */
	public int countByMaSoBienNhanLucGui(String maSoBienNhanLucGui) throws SystemException {
		return hoSoLienThongPersistence.countByMaSoBienNhanLucGui(maSoBienNhanLucGui.trim());
	}
	
	/**
	  * This is fucntion fetchByMaSoBienNhanLucGui
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoBienNhanLucGui
	  * @return HoSoLienThong
	  */
	public HoSoLienThong fetchByMaSoBienNhanLucGui(String maSoBienNhanLucGui) throws SystemException {
		return hoSoLienThongPersistence.fetchByMaSoBienNhanLucGui(maSoBienNhanLucGui.trim());
	}
	
	/**
	  * This is fucntion countByHoSoId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoId
	  * @return int
	  */
	public int countByHoSoId(long hoSoId) throws SystemException {
		return hoSoLienThongPersistence.countByHoSoId(hoSoId);
	}
	
	/**
	  * This is fucntion fetchByHoSoIdAndThuTuLienThong 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoId, int thuTu
	  * @return HoSoLienThong
	  */
	public HoSoLienThong fetchByHoSoIdAndThuTuLienThong(long hoSoId, int thuTu) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			HoSoLienThongImpl.class,
			PortalClassLoaderUtil.getClassLoader());
		query.add(PropertyFactoryUtil.forName(FIELD_HOSOID).eq(hoSoId));
		query.add(PropertyFactoryUtil.forName(FIELD_THUTULIENTHONG).eq(thuTu));
		query.add(PropertyFactoryUtil.forName(CmonFields.daXoa).eq(Constants.ACTIVE));
		List<HoSoLienThong> list =
			(List<HoSoLienThong>) hoSoLienThongPersistence.findWithDynamicQuery(query);
		if ( !list.isEmpty() ) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	/**
	  * This is fucntion findByHoSoId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoId
	  * @return List<HoSoLienThong>
	  */
	public List<HoSoLienThong> findByHoSoId(long hoSoId) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
			HoSoLienThongImpl.class,
			PortalClassLoaderUtil.getClassLoader());
		query.add(PropertyFactoryUtil.forName(FIELD_HOSOID).eq(hoSoId));
		query.add(PropertyFactoryUtil.forName(CmonFields.daXoa).eq(Constants.ACTIVE));
		query.addOrder(OrderFactoryUtil.asc(FIELD_THUTULIENTHONG));
		return (List<HoSoLienThong>) hoSoLienThongPersistence.findWithDynamicQuery(query);
	}
	
	/**
	  * This is fucntion searchHoSoNoiNhan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request, CongChuc canBoNoiNhan, long[] thuTucNhanIds
	  * @return QueryResult<HoSoLienThong>
	  */
	public QueryResult<HoSoLienThong> searchHoSoNoiNhan(PortletRequest request, CongChuc canBoNoiNhan, long[] thuTucNhanIds) {
		return hoSoLienThongFinder.searchHoSoNoiNhan(request, canBoNoiNhan, thuTucNhanIds);
	}
	
	/**
	  * This is fucntion searchHoSoNoiGui 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request, CongChuc canBoNoiGui, long[] thuTucGuiIds
	  * @return QueryResult<HoSoLienThong>
	  */
	public QueryResult<HoSoLienThong> searchHoSoNoiGui(PortletRequest request, CongChuc canBoNoiGui, long[] thuTucGuiIds) {
		return hoSoLienThongFinder.searchHoSoNoiGui(request, canBoNoiGui, thuTucGuiIds);
	}
}