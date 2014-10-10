package org.oep.sharedservice.cmon.provider.document;


import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.oep.sharedservice.cmon.provider.model.ResultUpload;
import org.oep.sharedservice.cmon.provider.model.TaiLieuDinhKem;











@WebService(name = "IDocumentService", targetNamespace = "http://document.provider.cmon.sharedservice.dtt.vn/")
public interface IDocumentService {
	@RequestWrapper(className = "vn.dtt.sharedservice.cmon.provider.document.jaxws.DoUpload", localName = "doUpload", targetNamespace = "http://document.provider.cmon.sharedservice.dtt.vn/")
	@ResponseWrapper(className = "vn.dtt.sharedservice.cmon.provider.document.jaxws.DoUploadResponse", localName = "doUploadResponse", targetNamespace = "http://document.provider.cmon.sharedservice.dtt.vn/")
	public ResultUpload doUpload(Long  userId,Long thutucId, String documentTypeCode, byte[] b, String fileName,boolean overwriteIfUsed,boolean overwriteIfApproved);
	public boolean doDelete(Long  userId, String documentTypeCode);
	public boolean doDeleteById(Long  chungthucId);
	public TaiLieuDinhKem getTailieuDinhKemBoiId(Long  chungthucId);
	public TaiLieuDinhKem getTailieuDinhKemTheoPhienBan(Long  userId, String code,int version);
	public TaiLieuDinhKem getThongTinTaiLieuDinhKem(Long thutucId,Long chungthucId);
	
	public TaiLieuDinhKem getPhienBanMoiNhatTheoMa(Long  userId, String code);
	public TaiLieuDinhKem getPhienBanMoiNhatTheoTTHC2GiayTo(Long  userId, Long thuTuc2GiayToId);
	public TaiLieuDinhKem getPhienBanMoiNhatTheoGiayTo(Long  userId, Long giayToId);
	
	public Long getIDTTHC2GiayTo(Long thutucId,Long taiLieuChungthucId);
	public TaiLieuDinhKem getDanhMucGiayTheoId(Long userId,Long giayToId);

}
