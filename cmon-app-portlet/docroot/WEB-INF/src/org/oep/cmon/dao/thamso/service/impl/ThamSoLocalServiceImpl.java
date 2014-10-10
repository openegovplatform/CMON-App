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


package org.oep.cmon.dao.thamso.service.impl;

import java.util.List;

import org.oep.cmon.dao.thamso.service.base.ThamSoLocalServiceBaseImpl;
import org.oep.sharedservice.cmon.Constants;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.log.LogUtil;

import org.oep.cmon.dao.thamso.NoSuchThamSoException;
import org.oep.cmon.dao.thamso.model.ThamSo;
import org.oep.cmon.dao.thamso.service.persistence.ThamSoFinderUtil;

/**
 * The implementation of the tham so local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.thamso.service.ThamSoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author NAM
 * @see org.oep.cmon.dao.thamso.service.base.ThamSoLocalServiceBaseImpl
 * @see org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil
 */

/**
*
* ThamSoLocalServiceImpl class
*   
* This class is used to get ThamSo information 
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
public class ThamSoLocalServiceImpl extends ThamSoLocalServiceBaseImpl {
	
	private Log _log = LogFactoryUtil.getLog(ThamSoLocalServiceImpl.class); 
	
	
	/**
	  * This is fucntion getValue 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String tenThamSo
	  * @return String
	  */
	public String getValue(String tenThamSo) {
		String out = tenThamSo;
		try {
			ThamSo thamSo = thamSoPersistence.fetchByTen(tenThamSo.trim());
			if (thamSo != null) {
				out = thamSo.getGiaTri().trim();
			}
		} catch (SystemException e) {
			_log.warn(e);
		}
		return out;
	}
	
	
	/**
	  * This is fucntion getValues
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param List<String> listTenThamSo
	  * @return List<String>
	  */
	public List<String> getValues(List<String> listTenThamSo) {
		return thamSoFinder.fetchList(listTenThamSo);
	}
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil} to access the tham so local service.
	 */
	
	/**
	  * This is fucntion findByTen
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ten
	  * @return ThamSo
	  */
	public ThamSo findByTen(String ten) throws NoSuchThamSoException, SystemException {
		return thamSoPersistence.findByTen(ten);
	}
	
	/**
	  * This is fucntion add
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ThamSo thamSo
	  * @return ThamSo
	  */
	public ThamSo add(ThamSo thamSo) {
		try {
			thamSo.setId(CounterLocalServiceUtil.increment(ThamSo.class.getName()));
			return thamSoLocalService.addThamSo(thamSo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			
		}
		return null;
		
	}
	

	/**
	  * This is fucntion searchByTen
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ten,int start,int end
	  * @return List<ThamSo>
	  */
	public List<ThamSo> searchByTen(String ten,int start,int end) {
		try {
			return ThamSoFinderUtil.searchByTen(ten, start, end);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	/**
	  * This is fucntion countByDaXoa 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ten
	  * @return long
	  */
	public long countByDaXoa(String ten) {
		try {
			return ThamSoFinderUtil.countByTen(ten);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//add by duong.pham
	/**
	  * This is fucntion searchByTenUDHT
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ten, Long ungDungId, Long heThongId, int start,int end
	  * @return List<ThamSo>
	  */
	public List<ThamSo> searchByTenUDHT(String ten, Long ungDungId, Long heThongId, int start,int end) {
		try {
			return ThamSoFinderUtil.searchByTenUDHT(ten, ungDungId, heThongId, start, end);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	  * This is fucntion countByTenUDHT
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ten,  Long ungDungId, Long heThongId
	  * @return long
	  */
	public long countByTenUDHT(String ten,  Long ungDungId, Long heThongId) {
		try {
			return ThamSoFinderUtil.countByTenUDHT(ten, ungDungId, heThongId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	  * This is fucntion getAll
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return List<ThamSo>
	  */
	public List<ThamSo> getAll(){
		try {
			return  thamSoPersistence.findByDaXoa(Constants.ACTIVATED);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return null;
	}
	
	/**
	  * This is fucntion getThamSoByGiaTri
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String giaTri
	  * @return ThamSo
	  */
	public ThamSo getThamSoByGiaTri(String giaTri){
		try {
			return thamSoPersistence.findByGiaTri(giaTri);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
}