package org.oep.sharedservice.cmon.provider.thamso;


import java.util.ArrayList;

import java.util.List;

import javax.jws.WebService;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;
import org.oep.cmon.dao.thamso.model.AnhXa;
import org.oep.cmon.dao.thamso.model.AnhXaSoap;
import org.oep.cmon.dao.thamso.service.AnhXaLocalServiceUtil;






@WebService(targetNamespace = "http://thamso.provider.cmon.sharedservice.dtt.vn/", endpointInterface = "org.oep.sharedservice.cmon.provider.thamso.IThamSoService", portName = "ThamSoServiceImplPort", serviceName = "ThamSoServiceImplService")
public class ThamSoServiceImpl implements IThamSoService {
	private static Log log = LogFactoryUtil.getLog(ThamSoServiceImpl.class);
	
	
	
	public String getValue(String name) {
		// TODO Auto-generated method stub
		try{
			if(ThamSoUtils.parameters == null){
				ThamSoUtils.loading();
			}
			
			return ThamSoUtils.parameters.get(name);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
		
	}

	
	public List<String> getValues(List<String> keys){
		if(keys != null){
			List<String> result = new ArrayList<String>();
			for (int i=0;i<keys.size();i++) {
				result.add(i,getValue(keys.get(i)));
			}
			return result;
		}
		return null;
	}


	
	public AnhXaSoap getAnhXa(AnhXaInput anhXa) {
		// TODO Auto-generated method stub
		try{
			try{
				log.info("get Anhxa: table="+anhXa.getTable()+",app:"+anhXa.getAppCode()+",code"+anhXa.getCode()+",id"+anhXa.getId());	
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			DanhMucUngDung ungDung = DanhMucUngDungLocalServiceUtil.getUngDungTheoMa(anhXa.getAppCode());
			if(ungDung == null)	{
				log.info("Ung dung voi ma:"+anhXa.getAppCode()+"Bi null kiem tra lai am ung dung nay !");
				return null;
			}
			String code = anhXa.getCode();
			if(code == null || code.trim().length()<=0){
				if(anhXa.getId()==null || anhXa.getId().intValue()<=0){
					log.info("id is null");
					return null;
				}else{
					code = AnhXaLocalServiceUtil.getMaById(anhXa.getTable(), anhXa.getId());
					log.info("get code="+code);
				}
			}
			
			log.info("Tim ung anh xa voi : ungDungId="+ungDung.getId()+",table="+anhXa.getTable()+",code="+code);
					
			AnhXa obj = AnhXaLocalServiceUtil
						.getAnhXaByApp_Table_Code(ungDung.getId()
								, anhXa.getTable(), code);
			if(obj != null){ 
				
				return AnhXaSoap.toSoapModel(obj);
			}else{
				log.info("get code="+code+"is null khi nhan anh xa Tu he thong");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(e.getMessage(),e);
		}
		return null;
	}


	
	public List<AnhXaSoap> getAnhXas(List<AnhXaInput> anhXas) {
		// TODO Auto-generated method stub
		if(anhXas != null){
			List<AnhXaSoap> result = new ArrayList<AnhXaSoap>();
			for (int i=0;i<anhXas.size();i++) {
				result.add(i, getAnhXa(anhXas.get(i)));
			}
			return result;
		}
		return null;
	}




	
}
