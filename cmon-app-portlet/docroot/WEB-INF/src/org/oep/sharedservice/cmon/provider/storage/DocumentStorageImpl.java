package org.oep.sharedservice.cmon.provider.storage;


import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Calendar;

import org.oep.sharedservice.cmon.Constants;
import org.oep.sharedservice.cmon.provider.model.ResultUpload;

import vn.dtt.sharedservice.WebserviceFactory;




import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

public class DocumentStorageImpl implements IDocumentStorage {
	private static Log log = LogFactoryUtil.getLog(DocumentStorageImpl.class);
	private final static String FOLDER_DEFAULT_UPLOAD_PROCESS_OFFICER = "CANBOXULY";
	private final static String FOLDER_DEFAULT_UPLOAD_PROCESS_HOSO = "XULYHOSO";
	private final static String FOLDER_DEFAULT_UPLOAD_RESULT_HOSO = "TRAKETQUA";
	private final static String FOLDER_DEFAULT_UPLOAD_NOP_HOSO = "NOPHOSO";
	private final static String FOLDER_DEFAULT_UPLOAD_CAUHINH_TTHC = "CAUHINH_TTHC";
	
	public ResultUpload uploadTraKetQua(Long hosoId,Long userId,byte[] b, String fileName){
		// TODO Auto-generated method stub
		Long newNameIncrement = hosoId;
		try {
			newNameIncrement = CounterLocalServiceUtil.increment(DocumentStorageImpl.class.getName());
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			
		}
		Long folderId = Long.valueOf(WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.CMON_DOCUMENT_FOLDER_ID));
		DLFolder folder =  null;
		ResultUpload result = new ResultUpload();
		try {
			folder = DLFolderLocalServiceUtil.getDLFolder(folderId);
			if(folder == null){
				result.setCode(Constants.UPLOAD_FOLDER_NOT_FOUND);
				return result;
			}
			
			Long repositoryId = folder.getRepositoryId();
			
			User admin = getAdministrator();
			ServiceContext serviceContext = getServiceContext(admin);
			
			Folder myFolder = addFolders(admin.getUserId(),serviceContext, repositoryId,folderId,getFolderTraKetQua(userId,hosoId));
			if(myFolder == null){
				result.setCode(Constants.UPLOAD_MYFOLDER_NOT_CREATED);
				return result;
			}
			return addFile(admin.getUserId(),serviceContext, repositoryId, b, myFolder.getFolderId(), getFileName(fileName, newNameIncrement.toString()), 0);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setCode(Constants.UPLOAD_SYSTEM+":"+e.getMessage());
		}
		
		return result;
	}
	
	public ResultUpload uploadXuLyHoSo(Long hosoId,String maUngDung,int loai,Long userId,byte[] b, String fileName){
		// TODO Auto-generated method stub
		Long newNameIncrement = hosoId;
		try {
			newNameIncrement = CounterLocalServiceUtil.increment(DocumentStorageImpl.class.getName());
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			
		}
		Long folderId = Long.valueOf(WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.CMON_DOCUMENT_FOLDER_ID));
		DLFolder folder =  null;
		ResultUpload result = new ResultUpload();
		try {
			folder = DLFolderLocalServiceUtil.getDLFolder(folderId);
			if(folder == null){
				result.setCode(Constants.UPLOAD_FOLDER_NOT_FOUND);
				return result;
			}
			
			Long repositoryId = folder.getRepositoryId();
			
			
			User admin = getAdministrator();
			ServiceContext serviceContext = getServiceContext(admin);
			Folder myFolder = addFolders(admin.getUserId(),serviceContext, repositoryId,  folderId,getFolderXuLy(maUngDung, loai, userId, hosoId));
			if(myFolder == null){
				result.setCode(Constants.UPLOAD_MYFOLDER_NOT_CREATED);
				return result;
			}
			return addFile(admin.getUserId(),serviceContext, repositoryId, b, myFolder.getFolderId(), getFileName(fileName, newNameIncrement.toString()), 0);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setCode(Constants.UPLOAD_SYSTEM);
		}
		
		return result;
	}
	
	
	public ResultUpload uploadCauHinhTTHC(Long tthcId,Long userId, byte[] b,String fileName) {
		// TODO Auto-generated method stub
		Long newNameIncrement = tthcId;
		try {
			newNameIncrement = CounterLocalServiceUtil.increment(DocumentStorageImpl.class.getName());
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			
		}
		Long folderId = Long.valueOf(WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.CMON_DOCUMENT_FOLDER_ID));
		DLFolder folder =  null;
		ResultUpload result = new ResultUpload();
		try {
			folder = DLFolderLocalServiceUtil.getDLFolder(folderId);
			if(folder == null){
				result.setCode(Constants.UPLOAD_FOLDER_NOT_FOUND);
				return result;
			}
			
			Long repositoryId = folder.getRepositoryId();
			
			User admin = getAdministrator();
			ServiceContext serviceContext = getServiceContext(admin);
			Folder myFolder = addFolders(admin.getUserId(),serviceContext, repositoryId, folderId,getFolderCauHinhTTHC(tthcId));
			if(myFolder == null){
				result.setCode(Constants.UPLOAD_MYFOLDER_NOT_CREATED);
				return result;
			}
			return addFile(admin.getUserId(),serviceContext, repositoryId, b, myFolder.getFolderId(), getFileName(fileName, newNameIncrement.toString()), 0);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setCode(Constants.UPLOAD_SYSTEM);
		}
		
		return result;
	}
	
	/**
	 *  This is function get folder create when upload file for tthc
	 * @param tthcCode
	 * @return
	 */
	
	private String[] getFolderCauHinhTTHC(Long tthcId){
		String[] folders = new String[2];		
		folders[0] = FOLDER_DEFAULT_UPLOAD_CAUHINH_TTHC;				
		folders[1] = tthcId.toString();
		return folders;
	}
	
	private String[] getFolderXuLy(String maUngDung,int loai,Long userId,Long hosoId){
		if(loai == Constants.UPLOAD_TYPE_HOSO){
				String[] folders = new String[6];
				Calendar calendar = Calendar.getInstance();
				folders[0] = FOLDER_DEFAULT_UPLOAD_PROCESS_HOSO;
				folders[1] = ""+maUngDung; 
				folders[2] = ""+calendar.get(Calendar.YEAR); 
				folders[3] = ""+(calendar.get(Calendar.MONTH)+1);		
				folders[4]= ""+userId.toString();
				folders[5] = ""+hosoId.toString();
				return folders;
		}else if(loai == Constants.UPLOAD_TYPE_OTHER){
				String[] folders = new String[5];
				Calendar calendar = Calendar.getInstance();
				folders[0] = FOLDER_DEFAULT_UPLOAD_PROCESS_OFFICER;
				folders[1] = maUngDung;
				folders[2] = ""+userId;
				folders[3] = ""+calendar.get(Calendar.YEAR); 
				folders[4] = ""+(calendar.get(Calendar.MONTH)+1);	
				
				return folders;
		}
		return null;
	}
	
	private String[] getFolderTraKetQua(Long userId,Long hosoId){
		String[] folders = new String[5];
		Calendar calendar = Calendar.getInstance();
		folders[0] = FOLDER_DEFAULT_UPLOAD_RESULT_HOSO;
		folders[1] = ""+calendar.get(Calendar.YEAR); 
		folders[2] = ""+(calendar.get(Calendar.MONTH)+1);
		folders[3] = userId.toString();
		folders[4] = hosoId.toString();
		return folders;
	}
	
	
	private String[] getFolderNopHoSo(Long userId){
		String[] folders = new String[2];		
		folders[0] = FOLDER_DEFAULT_UPLOAD_NOP_HOSO;
		folders[1] = userId.toString();
		
		return folders;
	}
	
	public ResultUpload upload(Long userId, Long folderId,byte[] b, String fileName,long limit) {
		// TODO Auto-generated method stubu
		log.info("--------start---api liferay---------");
		DLFolder folder =  null;
		ResultUpload result = new ResultUpload();
		try {
			folder = DLFolderLocalServiceUtil.getDLFolder(folderId);
			if(folder == null){
				result.setCode(Constants.UPLOAD_FOLDER_NOT_FOUND);
				return result;
			}
			log.info("a.get folder and set context");
			Long repositoryId = folder.getRepositoryId();
			User admin = getAdministrator();
			ServiceContext serviceContext = getServiceContext(admin);
		
				
			log.info("b.add forder");
			//Folder myFolder = addFolder(serviceContext, repositoryId, user, folderId, String.valueOf(user.getUserId()));
			Folder myFolder = addFolders(userId,serviceContext, repositoryId,folderId, getFolderNopHoSo(userId));
			if(myFolder == null){
				result.setCode(Constants.UPLOAD_MYFOLDER_NOT_CREATED);
				return result;
			}
			log.info("b.add file in folder:"+myFolder.getName());
			return addFile(userId,serviceContext, repositoryId, b, myFolder.getFolderId(), fileName, limit);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("c2.error with exception:"+e.getMessage());
			result.setCode(Constants.UPLOAD_SYSTEM);
		}
		
		return result;
	}
	
	
	
	
	private  ServiceContext getServiceContext(User admin) throws Exception{		
		PrincipalThreadLocal.setName(admin.getUserId());		
        PermissionChecker permissionChecker =
            PermissionCheckerFactoryUtil.create(admin, false);
        PermissionThreadLocal.setPermissionChecker(permissionChecker);			
     
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);		
		return serviceContext;
	}
	
	
	private ResultUpload addFile(long userId,ServiceContext serviceContext,Long repositoryId
			,byte[] b,Long folderId,String fileName, long limit)
	
			throws IOException, PortalException, SystemException{
		ResultUpload result = new ResultUpload();
		java.io.File  tempFile = FileUtil.createTempFile(fileName);	
		FileOutputStream fos = new FileOutputStream(tempFile);
		fos.write(b);
		fos.flush();
		fos.close();
		fos=null;
		
		
		FileInputStream fis = new FileInputStream(tempFile);
		
		String contentType = MimeTypesUtil.getContentType(fis, tempFile.getName());
		fis.close();
		fis=null;
		
		
		fis = new FileInputStream(tempFile);
		long size =tempFile.length();
		if(limit > 0){
			long limitsize = (long)((size /(1024*1024)));
			if(limitsize>limit){
				result.setCode(Constants.UPLOAD_LIMITSIZE);
				tempFile.delete();
				return result;
			}else if(limitsize==limit){
				long yes = limitsize * 1024*1024;
				if(yes<size){
					result.setCode(Constants.UPLOAD_LIMITSIZE);
					tempFile.delete();
					return result;
				}
			}
		}
		
		FileEntry fileEntry = addFile(userId,serviceContext, repositoryId, folderId, contentType, b, size, fileName);
		
		//fis.getChannel().close();
		fis.close();
		fis=null;
		tempFile.delete();
		String url= getURL(fileEntry);	
		result.setResult(true);
		result.setCode(Constants.UPLOAD_OK);
		result.setFileId(fileEntry.getFileEntryId());
		result.setUrl(url);
		return result;
	} 
	
	

	@Override
	public void deleteFile(Long documentId) {
		// TODO Auto-generated method stub
		try {
			DLAppLocalServiceUtil.deleteFileEntry(documentId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
	}
	
	 private Folder addFolders (long userId,ServiceContext context,long repositoryId,long parentFolderId,String[] folders){
			
		 if(folders != null && folders.length > 0){
			 Folder folder = null;
			 for (String folderName : folders) {
				if(folder != null){
					parentFolderId = folder.getFolderId();
				}
				folder = addFolder(userId,context, repositoryId, parentFolderId, folderName);
			}
			 return folder;
		 }
		 return null;
	}
	
	
	
    private Folder addFolder (long userId,ServiceContext context,long repositoryId,long parentFolderId,String name){
		
		Folder folder = null;
		try{
			folder = DLAppLocalServiceUtil.getFolder(repositoryId, parentFolderId, name);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
		}
		if(folder == null){
			try{
				folder = DLAppLocalServiceUtil.addFolder(userId, repositoryId, parentFolderId, name, name, context);
						
			}catch (Exception e) {
				//e.printStackTrace();
				
			}
		}
		
		return folder;
	}
    
  private FileEntry addFile(long userId,ServiceContext context,Long repositoryId,Long folderId,String c,byte[] bytes,long size,String fileName) throws PortalException, SystemException{
		
		FileEntry fileEntry = null;
		try{
			
			fileEntry = DLAppLocalServiceUtil
					.addFileEntry(userId, repositoryId, folderId, fileName,fileName, fileName, fileName, fileName, bytes, context);	
		
		}catch (DuplicateFileException e) {
			DLAppServiceUtil.deleteFileEntryByTitle(repositoryId,folderId, fileName);
			
			fileEntry = DLAppLocalServiceUtil
					.addFileEntry(userId, repositoryId, folderId, fileName,fileName, fileName, fileName, fileName, bytes, context);	
			
		}
		return fileEntry;
	}



	
		private String getURL(FileEntry fileEntry){
			try{
				
				String url =    "/documents/" 
						        + fileEntry.getGroupId() 
						        + StringPool.SLASH 
						        + fileEntry.getFolderId() 
						        + StringPool.SLASH 
						        + fileEntry.getTitle()
						        + "?version="+fileEntry.getVersion();
				return url;
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
		
		return "";
		}
		
		
		
		public String getURLById(Long fileId){
			try {
				return getURL(DLAppLocalServiceUtil.getFileEntry(fileId));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return "";
		}

		@Override
		public String getFileName(String fileName, String newName) {
			// TODO Auto-generated method stub
			String typeFile = getFileType(fileName);
			fileName = newName+"."+typeFile;
			
			return fileName; 
		
		}
		
		
		private String getFileType(String fileName) {
			// TODO Auto-generated method stub
			String type = fileName.substring(fileName.lastIndexOf(".")+1 , fileName.length());
			return type; 
		}
		
		
		private User getAdministrator(){
			Long userId = Long.valueOf(WebserviceFactory.getThamSoService().getValue(Constants.ThamSo.CMON_DOCUMENT_USER_ADMIN_ID));
			User admin = null;
			try {
				admin = UserLocalServiceUtil.getUser(userId);
				return admin;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			
			}
			return null;
		}
		
		
		public boolean existFile(Long fileId){
			try {
				FileEntry file = DLAppLocalServiceUtil.getFileEntry(fileId);
				if(file == null || file.getFileEntryId()<=0){
					return false;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
			
			}
			return true;
		}
	



		
}
