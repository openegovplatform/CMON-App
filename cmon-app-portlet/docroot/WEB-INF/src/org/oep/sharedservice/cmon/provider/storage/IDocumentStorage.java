package org.oep.sharedservice.cmon.provider.storage;


import org.oep.sharedservice.cmon.provider.model.ResultUpload;



public interface IDocumentStorage {
	
	public ResultUpload uploadXuLyHoSo(Long hosoId,String maUngDung,int type,Long userId,byte[] b, String fileName);
	
	public ResultUpload uploadTraKetQua(Long hosoId,Long userId,byte[] b, String fileName);
	
	public ResultUpload uploadCauHinhTTHC(Long tthcId,Long userId,byte[] b, String fileName);
	
	public ResultUpload upload(Long userId, Long folderId,byte[] b, String fileName,long limit);
	
	public void deleteFile(Long documentId);
	
	public String getURLById(Long fileId);
	
	public String getFileName(String fileName,String newName);
	public boolean existFile(Long fileId);
		
		
}
