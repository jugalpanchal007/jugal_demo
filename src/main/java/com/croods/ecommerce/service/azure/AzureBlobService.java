package com.croods.ecommerce.service.azure;

import java.io.File;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface AzureBlobService {
	
	public Map<String, String> sendImageFileToAZURE(File sourceFile,String fileName,String fileExtension,long companyId,long productId);
	
//	public Map<String, String> sendZipFileToAZURE(File sourceFile,String fileName,String fileExtension,long companyId,long productId);
	
	public String getSignedImageFileFromAZURE(String fileName,long companyId,long productId);
	
	public String sendPurchaseAttachmentFileToAZURE(File sourceFile, String filePath);
	
	public ResponseEntity<Resource> getPurchaseAttachmentFileFromAZURE(String blobName, String fileName);
	
	
	public String sendSalesAttachmentFileToAZURE(File sourceFile,String fileName,String fileExtension,long companyId,long salesId);
	
	public ResponseEntity<Resource> getSalesAttachmentFileFromAZURE(String fileName, long companyId, long salesId);
	

	String deleteProductImageFromAzure(String filePath) throws Exception;

	public Map<String, String> sendLogoImageFileToAZURE(File sourceFile, String fileName);

	public Map<String, String> sendBannerToAZURE(File fb, String fileName,long companyId,long bfranchId);
	
	public Map<String, String> sendLogoToAZURE(File fb, String fileName);
	

	public String sendContactAttachmentFileToAZURE(File sourceFile, String filePath);

	public ResponseEntity<Resource> getContactAttachmentFileFromAZURE(String blobName, String fileName);
	
	public String sendJVAttachmentFileToAZURE(File sourceFile, String filePath);

	public ResponseEntity<Resource> getJVAttachmentFileFromAZURE(String blobName, String fileName);

	public ResponseEntity<Resource> getExpenseAttachmentFileFromAZURE(String fileLocation, String imgLocation);

	public String sendExpenseAttachmentFileToAZURE(File fb, String filePath);

	public String sendDriveAttachmentFileToAZURE(File sourceFile, String filePath);
	
	public ResponseEntity<Resource> getDriveAttachmentFileFromAZURE(String fileLocation, String docPath);
	
	public String sendMaterialGatePassFileToAZURE(File sourceFile, String filePath);

	public Map<String, String> sendCategoryBrandDeptImageFileToAZURE(File fb, String filePath);

	public ResponseEntity<Resource> getMaterialGatePassFileFromAZURE(String fileLocation, String attachmentPath);
	
	public String sendEwayBillFileToAZURE(File sourceFile, String fileName);

	ResponseEntity<Resource> getEwayBillFileFromAZURE(String blobName, String fileName);

	void generateSignedSrcForAllSystemFiles();
	
	void generateSignedSrcForAllSystemFiles(long companyId);


	
}
