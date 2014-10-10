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

import java.util.ArrayList;
import java.util.List;

import org.oep.cmon.dao.thamso.service.base.AnhXaLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.oep.cmon.dao.thamso.model.AnhXa;
import org.oep.cmon.dao.thamso.service.persistence.AnhXaFinderUtil;


/**
 * The implementation of the anh xa local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.thamso.service.AnhXaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see org.oep.cmon.dao.thamso.service.base.AnhXaLocalServiceBaseImpl
 * @see org.oep.cmon.dao.thamso.service.AnhXaLocalServiceUtil
 */
/**
*
* AnhXaLocalServiceImpl class
*   
* This class is used to get AnhXa information 
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
public class AnhXaLocalServiceImpl extends AnhXaLocalServiceBaseImpl {
	
	private static Log log = LogFactoryUtil.getLog(AnhXaLocalServiceImpl.class);
	
	/**
	  * This is fucntion getMaById
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String table,Long id
	  * @return String
	  */
	public String getMaById(String table,Long id){
		return AnhXaFinderUtil.getCodeById(table, id);
	}
	
	
	/**
	  * This is fucntion getAnhXaByApp_Table_Code
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long appId,String table,String code
	  * @return AnhXa
	  */
	public AnhXa getAnhXaByApp_Table_Code(Long appId,String table,String code){
		try {
			List<AnhXa> aList = anhXaPersistence.findByUD_TB_MaDNG(appId, table, code);
			if(aList != null && aList.size()>0){
				return aList.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	  * This is fucntion synchronize
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long appId,String table,boolean overwriteAll
	  * @return void
	  */
	public void synchronize(Long appId,String table,boolean overwriteAll) throws SystemException{
		log.info("1.start synchronize with parameter: appId="+appId+",table="+table+",overwrite="+overwriteAll);
		List<AnhXa> aList = anhXaPersistence.findByUD_TB(appId, table);
		
		if(aList != null){
			log.info("2.list size :"+aList.size());
			int i=1;
			for (AnhXa anhXa : aList) {
				try{
					if(!overwriteAll 
							&& anhXa.getMaDNG()!=null){
						
						log.info(i+". continue with id="+anhXa.getId()+",makhac="+anhXa.getMaKhac()+",tenkhac="+anhXa.getTenKhac());
						i++;
						continue;
					}
					
					if(overwriteAll){
						anhXa.setTenDNG(null);
						anhXa.setMaDNG(null);
					}
					
					List<AnhXa> sysList =AnhXaFinderUtil.getDSByTenOrMa(table, null, anhXa.getTenKhac());
					
					if(sysList != null && sysList.size()>0){
						AnhXa old = sysList.get(0);
						anhXa.setTenDNG(old.getTenDNG());
						anhXa.setMaDNG(old.getMaDNG());
						anhXaPersistence.update(anhXa, false);
						log.info(i+". sych element id="+anhXa.getId()+",makhac="+anhXa.getMaKhac()+",tenkhac="
						+anhXa.getTenKhac()+",madng="+old.getMaDNG()+",tendng="+old.getTenDNG());
						
					}
					anhXaPersistence.update(anhXa, false);
					
					
					log.info(i+". sych element id="+anhXa.getId()+",makhac="+anhXa.getMaKhac()+",tenkhac="+anhXa.getTenKhac()+",madng=,tendng=");
					
					i++;
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}else{
			log.info("Not found element for synch");
		}
		
	}
	
	
	/**
	  * This is fucntion deleteMapping 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long appId,String table,boolean deleteMapping
	  * @return boolean
	  */
	public boolean deleteMapping(Long appId,String table,boolean deleteMapping){
		List<AnhXa> aList = null;
		try {
			aList = anhXaPersistence.findByUD_TB(appId, table);
			if(aList != null){
				for (AnhXa anhXa : aList) {
					if(deleteMapping){
						anhXa.setTenDNG(null);
						anhXa.setMaDNG(null);
					}else{
						anhXaPersistence.remove(anhXa);
					}
				
				}
				anhXaPersistence.clearCache();
				
			}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.thamso.service.AnhXaLocalServiceUtil} to access the anh xa local service.
	 */
	
	/**
	  * This is fucntion countSearch 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String keyword,Long appId,String table
	  * @return long
	  */
	public long countSearch(String keyword,Long appId,String table){
		try {
			return AnhXaFinderUtil.countSearch(keyword, appId, table);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	  * This is fucntion search
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String keyword,Long appId,String table,int start,int end
	  * @return List<AnhXa>
	  */
	public List<AnhXa> search(String keyword,Long appId,String table,int start,int end){
		try {
			return AnhXaFinderUtil.search(keyword, appId, table, start, end);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	  * This is fucntion getDSBang
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return List<String>
	  */
	public List<String> getDSBang(){
		try {
			return AnhXaFinderUtil.getListTable();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	  * This is fucntion getMaKhacExCh
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maDNG, String tenBang
	  * @return List<AnhXa>
	  */
	public List<AnhXa> getMaKhacExCh(String maDNG, String tenBang) {
		try {
			return AnhXaFinderUtil.getMaKhacExCh(maDNG, tenBang);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<AnhXa>();
	}
	
	/**
	  * This is fucntion getMaKhacExCh
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maDNG, String tenBang, long maUngDungId
	  * @return List<AnhXa>
	  */
	public List<AnhXa> getMaKhacExCh(String maDNG, String tenBang, long maUngDungId) {
		try {
			return AnhXaFinderUtil.getMaKhacExCh(maDNG, tenBang, maUngDungId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<AnhXa>();
	}
	
	/**
	  * This is fucntion getDNGFromMaKhacCQQL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maDNG, String tenBang
	  * @return List<AnhXa>
	  */
	public List<AnhXa> getDNGFromMaKhacCQQL(String maDNG, String tenBang) {
		try {
			return AnhXaFinderUtil.getDNGFromMaKhacCQQL(maDNG, tenBang);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<AnhXa>();
	}
	
	/**
	  * This is fucntion getDNGFromMaKhacTTHC
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maDNG, String tenBang
	  * @return List<AnhXa>
	  */
	public List<AnhXa> getDNGFromMaKhacTTHC(String maDNG, String tenBang) {
		try {
			return AnhXaFinderUtil.getDNGFromMaKhacTTHC(maDNG, tenBang);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<AnhXa>();
	}
	
	/**
	  * This is fucntion getDNGFromMaKhacGPLX
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maDNG, String tenBang
	  * @return List<AnhXa>
	  */
	public List<AnhXa> getDNGFromMaKhacGPLX(String maDNG, String tenBang) {
		try {
			return AnhXaFinderUtil.getDNGFromMaKhacGPLX(maDNG, tenBang);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<AnhXa>();
	}
}