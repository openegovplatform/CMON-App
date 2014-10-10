package org.oep.sharedservice.exch.provider.hoso;

import java.util.Date;

import javax.jws.WebService;

import org.oep.sharedservice.exch.provider.hoso.business.DocumentResultBs;
import org.oep.sharedservice.exch.provider.hoso.business.DocumentStatusBs;
import org.oep.sharedservice.exch.provider.hoso.business.OSSDocumentBs;
import org.oep.sharedservice.exch.provider.hoso.business.OnlineDocumentBs;
import org.oep.sharedservice.exch.provider.hoso.util.AuthenticationUtil;
import org.oep.sharedservice.exch.provider.soap.CountDocumentSoap;
import org.oep.sharedservice.exch.provider.soap.DocumentResultSoapList;
import org.oep.sharedservice.exch.provider.soap.DocumentStatusSoapList;
import org.oep.sharedservice.exch.provider.soap.OSSDocumentSoapList;
import org.oep.sharedservice.exch.provider.soap.OnlineDocumentSoapList;
import org.oep.sharedservice.exch.provider.soap.OnlineRecordSoapList;
import org.oep.sharedservice.exch.provider.soap.PullerSoap;
import org.oep.sharedservice.exch.provider.soap.ResponseSignalSoap;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

import org.oep.exch.dao.hoso.model.HoSoTrucTuyen;
import org.oep.exch.dao.hoso.service.HoSoTrucTuyenLocalServiceUtil;

@WebService(targetNamespace = "http://hoso.provider.exch.sharedservice.dtt.vn/", endpointInterface = "org.oep.sharedservice.exch.provider.hoso.IExchDocumentService", portName = "ExchDocumentServiceImplPort", serviceName = "ExchDocumentServiceImplService")
public class ExchDocumentServiceImpl implements IExchDocumentService {
	
	/**
	 * 
	 */
	public ResponseSignalSoap  pushDocument( OSSDocumentSoapList ossDocumentList ){		
		
		ResponseSignalSoap resp = new ResponseSignalSoap();
		
		// Check for NULL
		if ( ossDocumentList == null ) {
			// Error code and message should be defined in constants
			resp.setErrCode("1");
			resp.setErrMsg("Input parameter is NULL");
			
			return resp;
		}
		
		// Check for record
		if ( ossDocumentList.getOssDocumentSoapList().length < 1) {
			resp.setErrCode("2");
			resp.setErrMsg("Input parameter contains no record");
			
			return resp;
		}
		
		// Check user name and password
		String userName = ossDocumentList.getUserName();
		
		String password = ossDocumentList.getPassword();
		
		if ( !AuthenticationUtil.isTrue(userName, password)) {
			resp.setErrCode("3");
			resp.setErrMsg("Unknown user name or password");
			
			return resp;
		}
		
		try {
			OSSDocumentBs bs = new OSSDocumentBs();
			
			bs.createOSSDocument(ossDocumentList);
		} catch (SystemException e) {
			resp.setErrCode("9");
			resp.setErrMsg(e.getMessage());
		} catch (Exception e) {
			resp.setErrCode("99");
			resp.setErrMsg(e.getMessage());
		}		
		
		return resp;
	}
	
	/**
	 * 
	 */
	public OnlineDocumentSoapList  pullDocument(PullerSoap caller) {
		// Check parameter
		OnlineDocumentSoapList resp = new OnlineDocumentSoapList();
		
		// Check for NULL
		if ( caller == null ) {
			// Error code and message should be defined in constants
			resp.setErrCode("1");
			resp.setErrMsg("Input parameter is NULL");
			
			return resp;
		}
		
		// Check user name and password
		String userName = caller.getUserName();
		
		String password = caller.getPassword();
		
		if ( !AuthenticationUtil.isTrue(userName, password)) {
			resp.setErrCode("3");
			resp.setErrMsg("Unknown user name or password");
			
			return resp;
		}
		
		// Check ma don vi tiep nhan
		if (Validator.isNull(caller.getMaDonViTiepNhan())) {
			resp.setErrCode("4");
			resp.setErrMsg("Document receiver has no value");
			
			return resp;
		}
		
		OnlineDocumentBs onlineDocumentBs = new OnlineDocumentBs(resp);
		
		try {
			return onlineDocumentBs.getOnlineDocument(caller.getMaDonViTiepNhan());
		} catch (SystemException e) {
			resp.setErrCode("9");
			resp.setErrMsg(e.getMessage());
		} catch (Exception e) {
			resp.setErrCode("99");
			resp.setErrMsg(e.getMessage());
		}		
		
		return resp;
	}
	
	/**
	 * Update sent signal for document transferred 
	 */
	public ResponseSignalSoap  updateSendSignal( OnlineRecordSoapList onlineRecordSoapList ){
		// Check parameter
		ResponseSignalSoap resp = new ResponseSignalSoap();
		
		// Check for NULL
		if ( onlineRecordSoapList == null ) {
			// Error code and message should be defined in constants
			resp.setErrCode("1");
			resp.setErrMsg("Input parameter is NULL");
			
			return resp;
		}
		
		// Check for record
		if ( onlineRecordSoapList.getIdList().length < 1) {
			resp.setErrCode("2");
			resp.setErrMsg("Input parameter contains no record");
			
			return resp;
		}
		
		// Check user name and password
		String userName = onlineRecordSoapList.getUserName();
		
		String password = onlineRecordSoapList.getPassword();
		
		if ( !AuthenticationUtil.isTrue(userName, password)) {
			resp.setErrCode("3");
			resp.setErrMsg("Unknown user name or password");
			
			return resp;
		}
		
		try {
			long[] idList = onlineRecordSoapList.getIdList();
			
			Date currentDate = new Date();
		
			for (int i = 0; i < idList.length; i++ ) {
				HoSoTrucTuyen updateHoSo = HoSoTrucTuyenLocalServiceUtil.getHoSoTrucTuyen(idList[i]);
								
				updateHoSo.setTrangThaiXuLy(1); // 1: Da chuyen
				
				updateHoSo.setNgayChuyen(currentDate);
				
				HoSoTrucTuyenLocalServiceUtil.updateHoSoTrucTuyen(updateHoSo);			
			}
		} catch (SystemException e) {
			resp.setErrCode("9");
			resp.setErrMsg(e.getMessage());
		} catch (Exception e) {
			resp.setErrCode("99");
			resp.setErrMsg(e.getMessage());
		}
		
		return resp;
	}
	
	/**
	 * Update document status 
	 */
	public ResponseSignalSoap updateStatus( DocumentStatusSoapList documentStatusSoapList ){
		// Check parameter
		ResponseSignalSoap resp = new ResponseSignalSoap();
		
		// Check for NULL
		if ( documentStatusSoapList == null ) {
			// Error code and message should be defined in constants
			resp.setErrCode("1");
			resp.setErrMsg("Input parameter is NULL");
			
			return resp;
		}
		
		// Check for record
		if ( documentStatusSoapList.getDocumentStatusSoapList().length < 1) {
			resp.setErrCode("2");
			resp.setErrMsg("Input parameter contains no record");
			
			return resp;
		}
		
		// Check user name and password
		String userName = documentStatusSoapList.getUserName();
		
		String password = documentStatusSoapList.getPassword();
		
		if ( !AuthenticationUtil.isTrue(userName, password)) {
			resp.setErrCode("3");
			resp.setErrMsg("Unknown user name or password");
			
			return resp;
		}
		
		DocumentStatusBs documentStatusBs = new DocumentStatusBs();
		
		try {
			documentStatusBs.createDocumentStatus(documentStatusSoapList);
		} catch (SystemException e) {
			resp.setErrCode("9");
			resp.setErrMsg(e.getMessage());
		} catch (Exception e) {
			resp.setErrCode("99");
			resp.setErrMsg(e.getMessage());
		}		
		
		return resp;
	}
	
	/**
	 * Update document result 
	 */
	public ResponseSignalSoap  updateResult( DocumentResultSoapList documentResultSoapList ){
		// Check parameter
		ResponseSignalSoap resp = new ResponseSignalSoap();
		
		// Check for NULL
		if ( documentResultSoapList == null ) {
			// Error code and message should be defined in constants
			resp.setErrCode("1");
			resp.setErrMsg("Input parameter is NULL");
			
			return resp;
		}
		
		// Check for record
		if ( documentResultSoapList.getDocumentResultSoapList().length < 1) {
			resp.setErrCode("2");
			resp.setErrMsg("Input parameter contains no record");
			
			return resp;
		}
		
		// Check user name and password
		String userName = documentResultSoapList.getUserName();
		
		String password = documentResultSoapList.getPassword();
		
		if ( !AuthenticationUtil.isTrue(userName, password)) {
			resp.setErrCode("3");
			resp.setErrMsg("Unknown user name or password");
			
			return resp;
		}
		
		DocumentResultBs documentResultBs = new DocumentResultBs();
		
		try {
			documentResultBs.createDocumentResult(documentResultSoapList);
		} catch (SystemException e) {
			resp.setErrCode("9");
			resp.setErrMsg(e.getMessage());
		} catch (Exception e) {
			resp.setErrCode("99");
			resp.setErrMsg(e.getMessage());
		}	
		
		return resp;		
	}
	
	/**
	 * Count new document 
	 */
	public CountDocumentSoap countDocument(PullerSoap caller){
		CountDocumentSoap resp = new CountDocumentSoap();
		
		// Check for NULL
		if ( caller == null ) {
			// Error code and message should be defined in constants
			resp.setErrCode("1");
			resp.setErrMsg("Input parameter is NULL");
			
			return resp;
		}
				
		// Check user name and password
		String userName = caller.getUserName();
		
		String password = caller.getPassword();
		
		if ( !AuthenticationUtil.isTrue(userName, password)) {
			resp.setErrCode("3");
			resp.setErrMsg("Unknown user name or password");
			
			return resp;
		}
		
		// Check ma don vi tiep nhan
		if (Validator.isNull(caller.getMaDonViTiepNhan())) {
			resp.setErrCode("4");
			resp.setErrMsg("Document receiver has no value");
			
			return resp;
		}
		
		try {
			int count = HoSoTrucTuyenLocalServiceUtil.findByMaDonViTiepNhan(caller.getMaDonViTiepNhan(), 0).size();
			
			resp.setCountDocument(count);
			
		} catch ( SystemException e) {
			resp.setErrCode("9");
			resp.setErrMsg(e.getMessage());
		} catch (Exception e) {
			resp.setErrCode("99");
			resp.setErrMsg(e.getMessage());
		}
		
		return resp;		
	}
	
	/**
	 * Move ho so document to cummincation layer
	 * 
	 * @param hoSoOnlineId
	 * @param userName
	 * @param password
	 * @return reponse signal
	 */
	public ResponseSignalSoap moveToCommunicationLayer(long hoSoOnlineId, String userName, String password) {
		ResponseSignalSoap resp = new ResponseSignalSoap();
		
		// Check user name and password		
		if ( !AuthenticationUtil.isTrue(userName, password)) {
			resp.setErrCode("3");
			resp.setErrMsg("Unknown user name or password");
			
			return resp;
		}
		
		OnlineDocumentBs bs = new OnlineDocumentBs();
		
		try {
			bs.moveToCommunicationLayer(hoSoOnlineId);
		} catch (SystemException e) {			
			e.printStackTrace();
			
			resp.setErrCode("9");
			resp.setErrMsg(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			
			resp.setErrCode("99");
			resp.setErrMsg(e.getMessage());
		}	
		
		return resp;
	}
}
