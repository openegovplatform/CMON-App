package org.oep.sharedservice.exch.provider.hoso;

import javax.jws.WebService;

import org.oep.sharedservice.exch.provider.soap.CountDocumentSoap;
import org.oep.sharedservice.exch.provider.soap.DocumentResultSoapList;
import org.oep.sharedservice.exch.provider.soap.DocumentStatusSoapList;
import org.oep.sharedservice.exch.provider.soap.OSSDocumentSoapList;
import org.oep.sharedservice.exch.provider.soap.OnlineDocumentSoapList;
import org.oep.sharedservice.exch.provider.soap.OnlineRecordSoapList;
import org.oep.sharedservice.exch.provider.soap.PullerSoap;
import org.oep.sharedservice.exch.provider.soap.ResponseSignalSoap;


@WebService(name = "IExchDocumentService", targetNamespace = "http://hoso.provider.exch.sharedservice.dtt.vn/")
public interface IExchDocumentService {
	
	public ResponseSignalSoap  pushDocument( OSSDocumentSoapList ossDocumentList );
	
	public OnlineDocumentSoapList  pullDocument(PullerSoap caller);
	
	public ResponseSignalSoap  updateSendSignal( OnlineRecordSoapList onlineRecordSoapList );
	
	public ResponseSignalSoap updateStatus( DocumentStatusSoapList documentStatusSoapList );
	
	public ResponseSignalSoap  updateResult( DocumentResultSoapList documentResultSoapList );
	
	public CountDocumentSoap countDocument(PullerSoap caller);

	public ResponseSignalSoap moveToCommunicationLayer(long hoSoOnlineId, String userName, String password);
}
