package com.croods.ecommerce.service.azure;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.BlobRequestOptions;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.SharedAccessBlobPermissions;
import com.microsoft.azure.storage.blob.SharedAccessBlobPolicy;

import lombok.extern.java.Log;

@Service
@Log
public class AzureBlobServiceImpl implements AzureBlobService {

	@Value("${CONTAINER_NAME}")
	private String CONTAINER_NAME;

//	@Value("${ZIP_LOCATION}")
//	private String ZIP_LOCATION;

//	@Value("${IMAGE_LOCATION}")
//	private String IMAGE_LOCATION;

//	@Value("${PURCHASE_ATTACHMENT_LOCATION}")
//	private String PURCHASE_ATTACHMENT_LOCATION;

	@Value("${STORAGE_CONNECTION_STRING}")
	private String STORAGE_CONNECTION_STRING;

	@Value("${FILE_UPLOAD_SERVER}")
	private String FILE_UPLOAD_SERVER;

	@Value("${ASURE_STORAGE_BASE_URL}")
	private String ASURE_STORAGE_BASE_URL;

//	@Value("${SALES_ATTACHMENT_LOCATION}")
//	private String SALES_ATTACHMENT_LOCATION;
//
//	@Value("${EXPENSE_ATTACHMENT_LOCATION}")
//	private String EXPENSE_ATTACHMENT_LOCATION;
//
//	@Value("${LOGO_IMAGE_LOCATION}")
//	private String LOGO_IMAGE_LOCATION;
//
//	@Value("${COMPANY_DRIVE_FILE_LOCATION}")
//	private String COMPANY_DRIVE_FILE_LOCATION;

	@Value("${BANNER_LOCATION}")
	private String BANNER_LOCATION;
	
	@Value("${LOGO_LOCATION}")
	private String LOGO_LOCATION;

//	@Override
//	public Map<String, String> sendImageFileToAZURE(File sourceFile, String fileName, String fileExtension,
//			long companyId, long productId) {
//		// log.warning("START===================sendImageFileToAZURE================START");
//		CloudStorageAccount storageAccount;
//		CloudBlobClient blobClient = null;
//		CloudBlobContainer container = null;
//		Map<String, String> map = new HashedMap();
//		String status = "500";
//		map.put("status", status);
//		try {
//			// Parse the connection string and create a blob client to interact with Blob
//			// storage
//			storageAccount = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
//			blobClient = storageAccount.createCloudBlobClient();
//			container = blobClient.getContainerReference(CONTAINER_NAME);
//
//			// Create the container if it does not exist with public access.
//			// System.out.println("Creating container: " + container.getName());
//			container.createIfNotExists(BlobContainerPublicAccessType.OFF, new BlobRequestOptions(),
//					new OperationContext());
//
//			// Getting a blob reference
//			String filePath;
//			if (productId == 0L) {
//				filePath = "" + IMAGE_LOCATION + "/" + companyId + "/" + fileName;
//			} else {
//				filePath = "" + IMAGE_LOCATION + "/" + companyId + "/" + productId + "/" + fileName;
//			}
//
//			// log.warning("filePath--->" + filePath);
//			CloudBlockBlob blob = container.getBlockBlobReference(filePath);
//
//			if (filePath.endsWith(".png")) {
//				log.info("Content-type set------------>image/png");
//				blob.getProperties().setContentType("image/png");
//			} else if (filePath.endsWith(".jpg")) {
//				log.info("Content-type set------------>image/jpg");
//				blob.getProperties().setContentType("image/jpg");
//			} else if (filePath.endsWith(".jpeg")) {
//				log.info("Content-type set------------>image/jpeg");
//				blob.getProperties().setContentType("image/jpeg");
//			} else if (filePath.endsWith(".PNG")) {
//				log.info("Content-type set------------>image/png");
//				blob.getProperties().setContentType("image/png");
//			} else if (filePath.endsWith(".JPG")) {
//				log.info("Content-type set------------>image/jpg");
//				blob.getProperties().setContentType("image/jpg");
//			} else if (filePath.endsWith(".JPEG")) {
//				log.info("Content-type set------------>image/jpeg");
//				blob.getProperties().setContentType("image/jpeg");
//			} else {
//				log.info("Content-type set------------>application/octet-stream");
//				blob.getProperties().setContentType("application/octet-stream");
//			}
//
//			// Creating blob and uploading file to it
//			try {
//
//				blob.uploadFromFile(sourceFile.getAbsolutePath());
//				String imageSrc = getSignedImageFileFromAZURE(filePath, companyId, productId);
//				if (StringUtils.isNotBlank(imageSrc) && !StringUtils.equals("500", imageSrc)) {
//					status = "200";
//					map.put("status", status);
//					map.put("imageSrc", imageSrc);
//				}
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//		} catch (StorageException ex) {
//			ex.printStackTrace();
//			// System.out.println(String.format("Error returned from the service. Http code:
//			// %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
//		}
//		// log.warning("END===================sendImageFileToAZURE================END");
//		return map;
//	}

//	@Override
//	public Map<String, String> sendZipFileToAZURE(File sourceFile, String fileName, String fileExtension,
//			long companyId, long productId) {
//		// log.warning("START===================sendImageFileToAZURE================START");
//		CloudStorageAccount storageAccount;
//		CloudBlobClient blobClient = null;
//		CloudBlobContainer container = null;
//		Map<String, String> map = new HashedMap();
//		String status = "500";
//		map.put("status", status);
//		try {
//			// Parse the connection string and create a blob client to interact with Blob
//			// storage
//			storageAccount = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
//			blobClient = storageAccount.createCloudBlobClient();
//			container = blobClient.getContainerReference(CONTAINER_NAME);
//
//			// Create the container if it does not exist with public access.
//			// System.out.println("Creating container: " + container.getName());
//			container.createIfNotExists(BlobContainerPublicAccessType.OFF, new BlobRequestOptions(),
//					new OperationContext());
//
//			// Getting a blob reference
//			String filePath;
//			if (productId == 0L) {
//				filePath = "" + ZIP_LOCATION + "/" + companyId + "/" + fileName;
//			} else {
//				filePath = "" + ZIP_LOCATION + "/" + companyId + "/" + productId + "/" + fileName;
//			}
//
//			// log.warning("filePath--->" + filePath);
//			CloudBlockBlob blob = container.getBlockBlobReference(filePath);
//
//			if (filePath.endsWith(".png")) {
//				log.info("Content-type set------------>image/png");
//				blob.getProperties().setContentType("image/png");
//			} else if (filePath.endsWith(".jpg")) {
//				log.info("Content-type set------------>image/jpg");
//				blob.getProperties().setContentType("image/jpg");
//			} else if (filePath.endsWith(".jpeg")) {
//				log.info("Content-type set------------>image/jpeg");
//				blob.getProperties().setContentType("image/jpeg");
//			} else if (filePath.endsWith(".PNG")) {
//				log.info("Content-type set------------>image/png");
//				blob.getProperties().setContentType("image/png");
//			} else if (filePath.endsWith(".JPG")) {
//				log.info("Content-type set------------>image/jpg");
//				blob.getProperties().setContentType("image/jpg");
//			} else if (filePath.endsWith(".JPEG")) {
//				log.info("Content-type set------------>image/jpeg");
//				blob.getProperties().setContentType("image/jpeg");
//			} else {
//				log.info("Content-type set------------>application/octet-stream");
//				blob.getProperties().setContentType("application/octet-stream");
//			}
//
//			// Creating blob and uploading file to it
//			try {
//
//				blob.uploadFromFile(sourceFile.getAbsolutePath());
//				String imageSrc = getSignedImageFileFromAZURE(filePath, companyId, productId);
//				if (StringUtils.isNotBlank(imageSrc) && !StringUtils.equals("500", imageSrc)) {
//					status = "200";
//					map.put("status", status);
//					map.put("imageSrc", imageSrc);
//				}
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//		} catch (StorageException ex) {
//			ex.printStackTrace();
//			// System.out.println(String.format("Error returned from the service. Http code:
//			// %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
//		}
//		// log.warning("END===================sendImageFileToAZURE================END");
//		return map;
//	}

//	@Override
//	public Map<String, String> sendLogoImageFileToAZURE(File sourceFile, String fileName) {
//		// log.warning("START===================sendLogoImageFileToAZURE================START");
//		CloudStorageAccount storageAccount;
//		CloudBlobClient blobClient = null;
//		CloudBlobContainer container = null;
//		Map<String, String> map = new HashedMap();
//		String status = "500";
//		map.put("status", status);
//		try {
//			// Parse the connection string and create a blob client to interact with Blob
//			// storage
//			storageAccount = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
//			blobClient = storageAccount.createCloudBlobClient();
//			container = blobClient.getContainerReference(CONTAINER_NAME);
//
//			// Create the container if it does not exist with public access.
//			// System.out.println("Creating container: " + container.getName());
//			container.createIfNotExists(BlobContainerPublicAccessType.OFF, new BlobRequestOptions(),
//					new OperationContext());
//
//			// Getting a blob reference
//			String filePath = LOGO_IMAGE_LOCATION + "/" + fileName;
//			// log.warning("filePath--->" + filePath);
//			CloudBlockBlob blob = container.getBlockBlobReference(filePath);
//
//			// Creating blob and uploading file to it
//			try {
//
//				blob.uploadFromFile(sourceFile.getAbsolutePath());
//				String imageSrc = getSignedImageFileFromAZURE(filePath, 0, 0);
//				if (StringUtils.isNotBlank(imageSrc) && !StringUtils.equals("500", imageSrc)) {
//					status = "200";
//					map.put("status", status);
//					map.put("imageSrc", imageSrc);
//				}
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//		} catch (StorageException ex) {
//			ex.printStackTrace();
//			// System.out.println(String.format("Error returned from the service. Http code:
//			// %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
//		}
//		// log.warning("END===================sendLogoImageFileToAZURE================END");
//		return map;
//	}

	@Override
	public Map<String, String> sendBannerToAZURE(File sourceFile, String fileName, long companyId, long branchId) {
		// log.warning("START===================sendBannerToAZURE================START");
		CloudStorageAccount storageAccount;
		CloudBlobClient blobClient = null;
		CloudBlobContainer container = null;
		Map<String, String> map = new HashedMap();
		String status = "500";
		map.put("status", status);
		try {
			// Parse the connection string and create a blob client to interact with Blob
			// storage
			log.severe("INSIDE THE TRY BLOCK OF sendLogoToAZURE method");
			storageAccount = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
			blobClient = storageAccount.createCloudBlobClient();
			container = blobClient.getContainerReference(CONTAINER_NAME);

			// Create the container if it does not exist with public access.
			System.out.println("Creating container: " + container.getName());
			container.createIfNotExists(BlobContainerPublicAccessType.OFF, new BlobRequestOptions(),
					new OperationContext());

			// Getting a blob reference
			String filePath = BANNER_LOCATION + "/" + "comapny" + "/" + companyId+ "/" +"branch"+ "/" + branchId + "/" + fileName;
			 log.warning("filePath--->" + filePath);
			CloudBlockBlob blob = container.getBlockBlobReference(filePath);

			System.err.println("BLOB :: " +blob);
			// Creating blob and uploading file to it
			try {

				System.err.println("ABSOLUTE PATH :: " + sourceFile.getAbsolutePath());
				blob.uploadFromFile(sourceFile.getAbsolutePath());
				String imageSrc = getSignedImageFileFromAZURE(filePath, 0, 0);
				System.err.println("IMAGE SRC :: " + imageSrc);
				if (StringUtils.isNotBlank(imageSrc) && !StringUtils.equals("500", imageSrc)) {
					status = "200";
					map.put("status", status);
					map.put("imageSrc", imageSrc);
				}
			} catch (Exception ex) {
				System.err.println("CATCH :: " + ex);
				ex.printStackTrace();
			}
		} catch (StorageException ex) {
			ex.printStackTrace();
			// System.out.println(String.format("Error returned from the service. Http code:
			// %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		// log.warning("END===================sendBannerToAZURE================END");
		return map;
	}

	@Override
	public Map<String, String> sendLogoToAZURE(File sourceFile, String fileName) {
		// log.warning("START===================sendBannerToAZURE================START");
				CloudStorageAccount storageAccount;
				CloudBlobClient blobClient = null;
				CloudBlobContainer container = null;
				Map<String, String> map = new HashedMap();
				String status = "500";
				map.put("status", status);
				try {
					// Parse the connection string and create a blob client to interact with Blob
					// storage
					log.severe("INSIDE THE TRY BLOCK OF sendBannerToAZURE method");
					storageAccount = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
					blobClient = storageAccount.createCloudBlobClient();
					container = blobClient.getContainerReference(CONTAINER_NAME);

					// Create the container if it does not exist with public access.
					System.out.println("Creating container: " + container.getName());
					container.createIfNotExists(BlobContainerPublicAccessType.OFF, new BlobRequestOptions(),
							new OperationContext());

					// Getting a blob reference
					String filePath = LOGO_LOCATION + "/" + "comapny" + "/" + fileName;
					 log.warning("filePath--->" + filePath);
					CloudBlockBlob blob = container.getBlockBlobReference(filePath);

					System.err.println("BLOB :: " +blob);
					// Creating blob and uploading file to it
					try {

						System.err.println("ABSOLUTE PATH :: " + sourceFile.getAbsolutePath());
						blob.uploadFromFile(sourceFile.getAbsolutePath());
						String imageSrc = getSignedImageFileFromAZURE(filePath, 0, 0);
						System.err.println("IMAGE SRC :: " + imageSrc);
						if (StringUtils.isNotBlank(imageSrc) && !StringUtils.equals("500", imageSrc)) {
							status = "200";
							map.put("status", status);
							map.put("imageSrc", imageSrc);
						}
					} catch (Exception ex) {
						System.err.println("CATCH :: " + ex);
						ex.printStackTrace();
					}
				} catch (StorageException ex) {
					ex.printStackTrace();
					// System.out.println(String.format("Error returned from the service. Http code:
					// %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
				// log.warning("END===================sendBannerToAZURE================END");
				return map;
	}
	
	
	@Override
	public String getSignedImageFileFromAZURE(String fileName, long companyId, long productId) {
		// log.warning("START===================getImageFileFromAZURE================START");
		String fileUrl = "";
		String connString = STORAGE_CONNECTION_STRING;
		String containerName = CONTAINER_NAME;
		String blobName = fileName;// "/Gmart/product-image-pv/64/877328/877328-1651655206035.jpg";
//		BlobServiceClient client = new BlobServiceClientBuilder().connectionString(connString).buildClient();
//		BlobClient blobClient = client.getBlobContainerClient(containerName).getBlobClient(blobName);
//		BlobSasPermission blobSasPermission = new BlobSasPermission().setReadPermission(true);
//		OffsetDateTime expiryTime = OffsetDateTime.now().plusDays(1);
//		BlobServiceSasSignatureValues values = new BlobServiceSasSignatureValues(expiryTime, blobSasPermission)
//				.setStartTime(OffsetDateTime.now());
////		System.out.println(blobClient.generateSas(values));
//		String sasValue = blobClient.generateSas(values);

//		//log.warning("fileUrl---->"+fileUrl);
//		//log.warning("sasValue---->"+sasValue);
		String sasValue = "";

		/**
		 * if you have azure SDK then add below code for generate sas
		 */
		try {
			CloudStorageAccount account = CloudStorageAccount.parse(connString);

			// Create a blob service client
			CloudBlobClient blobClient = account.createCloudBlobClient();

			CloudBlobContainer container = blobClient.getContainerReference(containerName);
			CloudBlockBlob blob = container.getBlockBlobReference(blobName);
			if (blob.exists()) {
				log.warning("BLOB EXIST---->" + blobName);
				Date date = new Date();
				// log.info("date: " + date);
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				cal.set(Calendar.MONTH, 0);
				cal.set(Calendar.DAY_OF_MONTH, 1);
				Date firstDate = cal.getTime();
				// log.info("First Date: " + firstDate);
				cal.set(Calendar.MONTH, 11);
				cal.set(Calendar.DAY_OF_MONTH, 31);
				cal.set(Calendar.HOUR_OF_DAY, 23);
				Date lastDate = cal.getTime();
				// log.info("Last Date: " + lastDate);
				// Date expirationTime =
				// Date.from(LocalDateTime.now().plusDays(364).atZone(ZoneOffset.UTC).toInstant());
				SharedAccessBlobPolicy sharedAccessPolicy = new SharedAccessBlobPolicy();
				sharedAccessPolicy.setPermissions(EnumSet.of(SharedAccessBlobPermissions.READ,
						SharedAccessBlobPermissions.WRITE, SharedAccessBlobPermissions.ADD));
				sharedAccessPolicy.setSharedAccessStartTime(firstDate);
				sharedAccessPolicy.setSharedAccessExpiryTime(lastDate);

				// sasValue = container.generateSharedAccessSignature(sharedAccessPolicy, null);
				sasValue = blob.generateSharedAccessSignature(sharedAccessPolicy, null);
				fileUrl = ASURE_STORAGE_BASE_URL + CONTAINER_NAME + "/" + blobName;
			} else {
				log.severe("BLOB Not EXIST---->" + blobName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// log.warning("fileUrl---->" + fileUrl);
		// log.warning("sasValue---->" + sasValue);
		// log.warning("END===================getImageFileFromAZURE================END");
		if (StringUtils.isNotBlank(sasValue)) {
			return fileUrl + "?" + sasValue;
		} else {
			return "500";
		}
	}
//
//	@Override
//	public String sendPurchaseAttachmentFileToAZURE(File sourceFile, String filePath) {
//		// log.warning("START===================sendPurchaseAttachmentFileToAZURE================START");
//		CloudStorageAccount storageAccount;
//		CloudBlobClient blobClient = null;
//		CloudBlobContainer container = null;
//		String status = "500";
//		try {
//			// Parse the connection string and create a blob client to interact with Blob
//			// storage
//			storageAccount = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
//			blobClient = storageAccount.createCloudBlobClient();
//			container = blobClient.getContainerReference(CONTAINER_NAME);
//
//			// Create the container if it does not exist with public access.
//			System.out.println("Creating container: " + container.getName());
//			container.createIfNotExists(BlobContainerPublicAccessType.OFF, new BlobRequestOptions(),
//					new OperationContext());
//			// Getting a blob reference
//			// String filePath = "" + PURCHASE_ATTACHMENT_LOCATION + "/" + companyId + "/" +
//			// purchaseId + "/" + fileName;
//			// log.warning("filePath--->" + filePath);
//			CloudBlockBlob blob = container.getBlockBlobReference(filePath);
//
//			// Creating blob and uploading file to it
//			try {
//				blob.uploadFromFile(sourceFile.getAbsolutePath());
//				status = "200";
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//
//		} catch (StorageException ex) {
//			ex.printStackTrace();
//			// System.out.println(String.format("Error returned from the service. Http code:
//			// %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
//		}
//		// log.warning("END===================sendPurchaseAttachmentFileToAZURE================END");
//		return status;
//	}
//
//	@Override
//	public ResponseEntity<Resource> getPurchaseAttachmentFileFromAZURE(String blobName, String fileName) {
//		// String blobName = "" + PURCHASE_ATTACHMENT_LOCATION + "/" + companyId + "/" +
//		// purchaseId + "/" + fileName;
//		return downloadFileInLocal(blobName, fileName);
//	}
//
//	@Override
//	public String sendExpenseAttachmentFileToAZURE(File sourceFile, String filePath) {
//		// log.warning("START===================sendExpenseAttachmentFileToAZURE================START");
//		CloudStorageAccount storageAccount;
//		CloudBlobClient blobClient = null;
//		CloudBlobContainer container = null;
//		String status = "500";
//		try {
//			// Parse the connection string and create a blob client to interact with Blob
//			// storage
//			storageAccount = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
//			blobClient = storageAccount.createCloudBlobClient();
//			container = blobClient.getContainerReference(CONTAINER_NAME);
//
//			// Create the container if it does not exist with public access.
//			System.out.println("Creating container: " + container.getName());
//			container.createIfNotExists(BlobContainerPublicAccessType.OFF, new BlobRequestOptions(),
//					new OperationContext());
//			// Getting a blob reference
//			// String filePath = "" + PURCHASE_ATTACHMENT_LOCATION + "/" + companyId + "/" +
//			// purchaseId + "/" + fileName;
//			// log.warning("filePath--->" + filePath);
//			CloudBlockBlob blob = container.getBlockBlobReference(filePath);
//
//			// Creating blob and uploading file to it
//			try {
//				blob.uploadFromFile(sourceFile.getAbsolutePath());
//				status = "200";
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//
//		} catch (StorageException ex) {
//			ex.printStackTrace();
//			// System.out.println(String.format("Error returned from the service. Http code:
//			// %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
//		}
//		// log.warning("END===================sendExpenseAttachmentFileToAZURE================END");
//		return status;
//	}
//
//	@Override
//	public ResponseEntity<Resource> getExpenseAttachmentFileFromAZURE(String blobName, String fileName) {
//		// String blobName = "" + PURCHASE_ATTACHMENT_LOCATION + "/" + companyId + "/" +
//		// purchaseId + "/" + fileName;
//		return downloadFileInLocal(blobName, fileName);
//	}
//
//	@Override
//	public String sendDriveAttachmentFileToAZURE(File sourceFile, String filePath) {
//		// log.warning("START===================sendDriveAttachmentFileToAZURE================START");
//		CloudStorageAccount storageAccount;
//		CloudBlobClient blobClient = null;
//		CloudBlobContainer container = null;
//		// Map<String, String> map = new HashedMap();
//		String status = "500";
//		try {
//			// Parse the connection string and create a blob client to interact with Blob
//			// storage
//			storageAccount = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
//			blobClient = storageAccount.createCloudBlobClient();
//			container = blobClient.getContainerReference(CONTAINER_NAME);
//
//			// Create the container if it does not exist with public access.
//			System.out.println("Creating container: " + container.getName());
//			container.createIfNotExists(BlobContainerPublicAccessType.OFF, new BlobRequestOptions(),
//					new OperationContext());
//			// Getting a blob reference
//			// String filePath = "" + PURCHASE_ATTACHMENT_LOCATION + "/" + companyId + "/" +
//			// purchaseId + "/" + fileName;
//			// log.warning("filePath--->" + filePath);
//			CloudBlockBlob blob = container.getBlockBlobReference(filePath);
//
//			// Creating blob and uploading file to it
//			try {
//				blob.uploadFromFile(sourceFile.getAbsolutePath());
//				status = "200";
////				String imageSrc = getSignedImageFileFromAZURE(filePath, 0, 0);
////				if(StringUtils.isNotBlank(imageSrc) && !StringUtils.equals("500", imageSrc)) {
////					status = "200";
////					map.put("status", status);
////					map.put("imageSrc", imageSrc);	
////				}	
//
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//
//		} catch (StorageException ex) {
//			ex.printStackTrace();
//			// System.out.println(String.format("Error returned from the service. Http code:
//			// %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
//		}
//		// log.warning("END===================sendDriveAttachmentFileToAZURE================END");
//		return status;
//	}
//
//	@Override
//	public ResponseEntity<Resource> getDriveAttachmentFileFromAZURE(String blobName, String fileName) {
//		return downloadFileInLocal(blobName, fileName);
//	}
//
//	@Override
//	public String sendMaterialGatePassFileToAZURE(File sourceFile, String filePath) {
//		// log.warning("START===================sendMaterialGatePassFileToAZURE================START");
//		CloudStorageAccount storageAccount;
//		CloudBlobClient blobClient = null;
//		CloudBlobContainer container = null;
//		// Map<String, String> map = new HashedMap();
//		String status = "500";
//		try {
//			// Parse the connection string and create a blob client to interact with Blob
//			// storage
//			storageAccount = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
//			blobClient = storageAccount.createCloudBlobClient();
//			container = blobClient.getContainerReference(CONTAINER_NAME);
//
//			// Create the container if it does not exist with public access.
//			System.out.println("Creating container: " + container.getName());
//			container.createIfNotExists(BlobContainerPublicAccessType.OFF, new BlobRequestOptions(),
//					new OperationContext());
//			// Getting a blob reference
//			// String filePath = "" + PURCHASE_ATTACHMENT_LOCATION + "/" + companyId + "/" +
//			// purchaseId + "/" + fileName;
//			// log.warning("filePath--->" + filePath);
//			CloudBlockBlob blob = container.getBlockBlobReference(filePath);
//
//			// Creating blob and uploading file to it
//			try {
//				blob.uploadFromFile(sourceFile.getAbsolutePath());
////				String imageSrc = getSignedImageFileFromAZURE(filePath, 0, 0);
////				if(StringUtils.isNotBlank(imageSrc) && !StringUtils.equals("500", imageSrc)) {
////					status = "200";
////					map.put("status", status);
////					map.put("imageSrc", imageSrc);	
////				}	
//				status = "200";
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//
//		} catch (StorageException ex) {
//			ex.printStackTrace();
//			// System.out.println(String.format("Error returned from the service. Http code:
//			// %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
//		}
//		// log.warning("END===================sendMaterialGatePassFileToAZURE================END");
//		return status;
//	}
//
//	@Override
//	public ResponseEntity<Resource> getMaterialGatePassFileFromAZURE(String blobName, String fileName) {
//		// String blobName = "" + PURCHASE_ATTACHMENT_LOCATION + "/" + companyId + "/" +
//		// purchaseId + "/" + fileName;
//		return downloadFileInLocal(blobName, fileName);
//	}
//
//	@Override
//	public Map<String, String> sendCategoryBrandDeptImageFileToAZURE(File sourceFile, String filePath) {
//		// log.warning("START===================sendCategoryBrandDeptImageFileToAZURE================START");
//		CloudStorageAccount storageAccount;
//		CloudBlobClient blobClient = null;
//		CloudBlobContainer container = null;
//		Map<String, String> map = new HashedMap();
//		String status = "500";
//		try {
//			// Parse the connection string and create a blob client to interact with Blob
//			// storage
//			storageAccount = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
//			blobClient = storageAccount.createCloudBlobClient();
//			container = blobClient.getContainerReference(CONTAINER_NAME);
//
//			// Create the container if it does not exist with public access.
//			System.out.println("Creating container: " + container.getName());
//			container.createIfNotExists(BlobContainerPublicAccessType.OFF, new BlobRequestOptions(),
//					new OperationContext());
//			// Getting a blob reference
//			// String filePath = "" + PURCHASE_ATTACHMENT_LOCATION + "/" + companyId + "/" +
//			// purchaseId + "/" + fileName;
//			// log.warning("filePath--->" + filePath);
//			CloudBlockBlob blob = container.getBlockBlobReference(filePath);
//
//			// Creating blob and uploading file to it
//			try {
//				blob.uploadFromFile(sourceFile.getAbsolutePath());
//				String imageSrc = getSignedImageFileFromAZURE(filePath, 0, 0);
//				if (StringUtils.isNotBlank(imageSrc) && !StringUtils.equals("500", imageSrc)) {
//					status = "200";
//					map.put("status", status);
//					map.put("imageSrc", imageSrc);
//				}
//				status = "200";
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//
//		} catch (StorageException ex) {
//			ex.printStackTrace();
//			// System.out.println(String.format("Error returned from the service. Http code:
//			// %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
//		}
//		// log.warning("END===================sendCategoryBrandDeptImageFileToAZURE================END");
//		return map;
//	}
//
//	@Override
//	public String sendSalesAttachmentFileToAZURE(File sourceFile, String fileName, String fileExtension, long companyId,
//			long salesId) {
//		// log.warning("START===================sendSalesAttachmentFileToAZURE================START");
//		CloudStorageAccount storageAccount;
//		CloudBlobClient blobClient = null;
//		CloudBlobContainer container = null;
//		String status = "500";
//		try {
//			// Parse the connection string and create a blob client to interact with Blob
//			// storage
//			storageAccount = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
//			blobClient = storageAccount.createCloudBlobClient();
//			container = blobClient.getContainerReference(CONTAINER_NAME);
//
//			// Create the container if it does not exist with public access.
//			System.out.println("Creating container: " + container.getName());
//			container.createIfNotExists(BlobContainerPublicAccessType.OFF, new BlobRequestOptions(),
//					new OperationContext());
//			// Getting a blob reference
//			String filePath = "" + SALES_ATTACHMENT_LOCATION + "/" + companyId + "/" + salesId + "/" + fileName;
//			// log.warning("filePath--->" + filePath);
//			CloudBlockBlob blob = container.getBlockBlobReference(filePath);
//
//			// Creating blob and uploading file to it
//			try {
//				blob.uploadFromFile(sourceFile.getAbsolutePath());
//				status = "200";
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//
//		} catch (StorageException ex) {
//			ex.printStackTrace();
//			// System.out.println(String.format("Error returned from the service. Http code:
//			// %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
//		}
//		// log.warning("END===================sendSalesAttachmentFileToAZURE================END");
//		return status;
//	}
//
//	@Override
//	public ResponseEntity<Resource> getSalesAttachmentFileFromAZURE(String fileName, long companyId, long salesId) {
//		// log.warning("START===================getSalesAttachmentFileFromAZURE================START");
//		String blobName = "" + SALES_ATTACHMENT_LOCATION + "/" + companyId + "/" + salesId + "/" + fileName;
//
//		// log.warning("END===================getSalesAttachmentFileFromAZURE================END");
//		return downloadFileInLocal(blobName, fileName);
//	}
//
//	@Override
//	public String sendContactAttachmentFileToAZURE(File sourceFile, String filePath) {
//		// log.warning("START===================sendContactAttachmentFileToAZURE================START");
//		CloudStorageAccount storageAccount;
//		CloudBlobClient blobClient = null;
//		CloudBlobContainer container = null;
//		String status = "500";
//		try {
//			// Parse the connection string and create a blob client to interact with Blob
//			// storage
//			storageAccount = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
//			blobClient = storageAccount.createCloudBlobClient();
//			container = blobClient.getContainerReference(CONTAINER_NAME);
//
//			// Create the container if it does not exist with public access.
//			System.out.println("Creating container: " + container.getName());
//			container.createIfNotExists(BlobContainerPublicAccessType.OFF, new BlobRequestOptions(),
//					new OperationContext());
//			// Getting a blob reference
//			// String filePath = "" + SALES_ATTACHMENT_LOCATION + "/" + companyId + "/" +
//			// salesId + "/" + fileName;
//			// log.warning("filePath--->" + filePath);
//			CloudBlockBlob blob = container.getBlockBlobReference(filePath);
//
//			// Creating blob and uploading file to it
//			try {
//				blob.uploadFromFile(sourceFile.getAbsolutePath());
//				status = "200";
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//
//		} catch (StorageException ex) {
//			ex.printStackTrace();
//			// System.out.println(String.format("Error returned from the service. Http code:
//			// %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
//		}
//		// log.warning("END===================sendContactAttachmentFileToAZURE================END");
//		return status;
//	}
//
//	@Override
//	public ResponseEntity<Resource> getContactAttachmentFileFromAZURE(String blobName, String fileName) {
//		return downloadFileInLocal(blobName, fileName);
//	}
//
//	@Override
//	public String sendJVAttachmentFileToAZURE(File sourceFile, String filePath) {
//		// log.warning("START===================sendJVAttachmentFileToAZURE================START");
//		CloudStorageAccount storageAccount;
//		CloudBlobClient blobClient = null;
//		CloudBlobContainer container = null;
//		String status = "500";
//		try {
//			// Parse the connection string and create a blob client to interact with Blob
//			// storage
//			storageAccount = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
//			blobClient = storageAccount.createCloudBlobClient();
//			container = blobClient.getContainerReference(CONTAINER_NAME);
//
//			// Create the container if it does not exist with public access.
//			System.out.println("Creating container: " + container.getName());
//			container.createIfNotExists(BlobContainerPublicAccessType.OFF, new BlobRequestOptions(),
//					new OperationContext());
//			// Getting a blob reference
//			// String filePath = "" + SALES_ATTACHMENT_LOCATION + "/" + companyId + "/" +
//			// salesId + "/" + fileName;
//			// log.warning("filePath--->" + filePath);
//			CloudBlockBlob blob = container.getBlockBlobReference(filePath);
//
//			// Creating blob and uploading file to it
//			try {
//				blob.uploadFromFile(sourceFile.getAbsolutePath());
//				status = "200";
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//
//		} catch (StorageException ex) {
//			ex.printStackTrace();
//			// System.out.println(String.format("Error returned from the service. Http code:
//			// %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
//		}
//		// log.warning("END===================sendJVAttachmentFileToAZURE================END");
//		return status;
//	}
//
//	@Override
//	public ResponseEntity<Resource> getJVAttachmentFileFromAZURE(String blobName, String fileName) {
//		return downloadFileInLocal(blobName, fileName);
//	}
//
//	public ResponseEntity<Resource> downloadFileInLocal(String blobName, String fileName) {
//
//		try {
//			CloudStorageAccount storageAccount = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
//
//			// Create the service client object for credentialed access to the Blob service.
//			CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
//
//			// Retrieve a reference to a container.
//			CloudBlobContainer container AzureBlobServiceImpl= blobClient.getContainerReference(CONTAINER_NAME);
//
//			CloudBlob blob1 = container.getBlockBlobReference(blobName);
//			String path = System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + fileName;
//			blob1.download(new FileOutputStream(path));
//			Path filePath = Paths.get(path);
//			Resource resource = new UrlResource(filePath.toUri());
//
//			return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/octet-stream"))
//					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//					.body(resource);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		// HttpHeaders headers = new HttpHeaders();
//		// headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
//		// fileName + "\"");
//
////        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
////                .headers(headers)
////                .body(resource);
//
//		return null;
//	}
//
//	@Override
//	public String deleteProductImageFromAzure(String filePath) throws Exception {
//		CloudStorageAccount storageAccount;
//		CloudBlobClient blobClient = null;
//		CloudBlobContainer container = null;
//		String status = "500";
//		// log.warning("filePath--->"+filePath);
//		try {
//			storageAccount = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
//			blobClient = storageAccount.createCloudBlobClient();
//			container = blobClient.getContainerReference(CONTAINER_NAME);
//			filePath = filePath.replaceFirst("(?:" + CONTAINER_NAME + "/)+", "");
//			CloudBlockBlob blob = container.getBlockBlobReference(filePath);
//			try {
//				blob.delete();
//				status = "200";
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//		} catch (StorageException ex) {
//			ex.printStackTrace();
//			// System.out.println(String.format("Error returned from the service. Http code:
//			// %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
//		}
//		return status;
//	}
//
//	@Override
//	public String sendEwayBillFileToAZURE(File sourceFile, String filePath) {
//		// log.warning("START===================sendContactAttachmentFileToAZURE================START");
//		CloudStorageAccount storageAccount;
//		CloudBlobClient blobClient = null;
//		CloudBlobContainer container = null;
//		String status = "500";
//		try {
//			// Parse the connection string and create a blob client to interact with Blob
//			// storage
//			storageAccount = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
//			blobClient = storageAccount.createCloudBlobClient();
//			container = blobClient.getContainerReference(CONTAINER_NAME);
//
//			// Create the container if it does not exist with public access.
//			System.out.println("Creating container: " + container.getName());
//			container.createIfNotExists(BlobContainerPublicAccessType.OFF, new BlobRequestOptions(),
//					new OperationContext());
//			// Getting a blob reference
//			// String filePath = "" + SALES_ATTACHMENT_LOCATION + "/" + companyId + "/" +
//			// salesId + "/" + fileName;
//			// log.warning("filePath--->" + filePath);
//			CloudBlockBlob blob = container.getBlockBlobReference(filePath);
//
//			// Creating blob and uploading file to it
//			try {
//				blob.uploadFromFile(sourceFile.getAbsolutePath());
//				status = "200";
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//
//		} catch (StorageException ex) {
//			ex.printStackTrace();
//			// System.out.println(String.format("Error returned from the service. Http code:
//			// %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
//		}
//		// log.warning("END===================sendContactAttachmentFileToAZURE================END");
//		return status;
//	}
//
//	@Override
//	public ResponseEntity<Resource> getEwayBillFileFromAZURE(String blobName, String fileName) {
//		// String blobName = "" + PURCHASE_ATTACHMENT_LOCATION + "/" + companyId + "/" +
//		// purchaseId + "/" + fileName;
//		return downloadFileInLocal(blobName, fileName);
//	}
//
//	@Override
//	public void generateSignedSrcForAllSystemFiles() {
//		// first delete all signedSrcs
//		userRepository.deleteAllSignedSrcFromEntireSystem(0);
//
//		// then generate new
//		generateSignedSrcForLogo(0);
//		generateSignedSrcForCategory(0);
//		generateSignedSrcForBrand(0);
//		generateSignedSrcForDepartment(0);
//		generateSignedSrcForProduct(0);
//
//	}

	@Override
	public void generateSignedSrcForAllSystemFiles() {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateSignedSrcForAllSystemFiles(long companyId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, String> sendImageFileToAZURE(File sourceFile, String fileName, String fileExtension,
			long companyId, long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendPurchaseAttachmentFileToAZURE(File sourceFile, String filePath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Resource> getPurchaseAttachmentFileFromAZURE(String blobName, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendSalesAttachmentFileToAZURE(File sourceFile, String fileName, String fileExtension, long companyId,
			long salesId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Resource> getSalesAttachmentFileFromAZURE(String fileName, long companyId, long salesId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProductImageFromAzure(String filePath) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> sendLogoImageFileToAZURE(File sourceFile, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendContactAttachmentFileToAZURE(File sourceFile, String filePath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Resource> getContactAttachmentFileFromAZURE(String blobName, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendJVAttachmentFileToAZURE(File sourceFile, String filePath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Resource> getJVAttachmentFileFromAZURE(String blobName, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Resource> getExpenseAttachmentFileFromAZURE(String fileLocation, String imgLocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendExpenseAttachmentFileToAZURE(File fb, String filePath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendDriveAttachmentFileToAZURE(File sourceFile, String filePath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Resource> getDriveAttachmentFileFromAZURE(String fileLocation, String docPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendMaterialGatePassFileToAZURE(File sourceFile, String filePath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> sendCategoryBrandDeptImageFileToAZURE(File fb, String filePath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Resource> getMaterialGatePassFileFromAZURE(String fileLocation, String attachmentPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendEwayBillFileToAZURE(File sourceFile, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Resource> getEwayBillFileFromAZURE(String blobName, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

//	@Override
//	public void generateSignedSrcForAllSystemFiles(long companyId) {
//		// first delete all signedSrcs
//		userRepository.deleteAllSignedSrcFromEntireSystem(companyId);
//
//		// then generate new
//		generateSignedSrcForLogo(companyId);
//		generateSignedSrcForCategory(companyId);
//		generateSignedSrcForBrand(companyId);
//		generateSignedSrcForDepartment(companyId);
//		generateSignedSrcForProduct(companyId);
//
//	}

//	public void generateSignedSrcForProduct(long company_id) {
//		try {
//			log.info("START================PRODUCT=============START");
//			List<ProductImageAllDTO> imageVos = productImageRepository
//					.findCustomProductImageDetailsForAllCompany(company_id);
//			log.warning("imageVos size---->" + imageVos.size());
//			if (!imageVos.isEmpty()) {
//				for (int i = 0; i < imageVos.size(); i++) {
//					String filePath = imageVos.get(i).getSrc();
//					long productId = imageVos.get(i).getProductId();
//					long companyId = imageVos.get(i).getCompanyId();
//					filePath = filePath.replaceFirst("(?:" + CONTAINER_NAME + "/)+", "");
//					String imageSrc = getSignedImageFileFromAZURE(filePath, companyId, productId);
//					if (StringUtils.isNotBlank(imageSrc) && !StringUtils.equals("500", imageSrc)) {
//						int result = productImageRepository.updateSignedSrc(imageVos.get(i).getImageId(), imageSrc);
//						log.warning("updateSignedSrc--------->" + result);
//						try {
//							productService.updateImageInProduct(productId, imageSrc);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			}
//			log.info("END================PRODUCT=============END");
//		} catch (Exception e) {
//			log.info("ERROR---------->PRODUCT");
//			e.printStackTrace();
//		}
//	}
//
//	public void generateSignedSrcForLogo(long companyId) {
//		try {
//			log.info("START================LOGO=============START");
//			List<LogoListDTO> logoList = profileService.findbyAllCompanysAllLogos(companyId);
//			log.warning("logoList size---->" + logoList.size());
//			if (!logoList.isEmpty()) {
//				for (int i = 0; i < logoList.size(); i++) {
//					long userFrontId = logoList.get(i).getUserFrontId();
//					if (StringUtils.isNotBlank(logoList.get(i).getLogo())) {
//						String filePath = LOGO_IMAGE_LOCATION + "/" + logoList.get(i).getLogo();
//						filePath = filePath.replaceFirst("(?:" + CONTAINER_NAME + "/)+", "");
//						String azureImageSrc = getSignedImageFileFromAZURE(filePath, 0, 0);
//						if (StringUtils.isNotBlank(azureImageSrc) && !StringUtils.equals("500", azureImageSrc)) {
//							profileService.updateLogoSignedSrc(userFrontId, azureImageSrc);
//						}
//					}
//
//					if (StringUtils.isNotBlank(logoList.get(i).getWatermarkLogo())) {
//						String filePath = LOGO_IMAGE_LOCATION + "/" + logoList.get(i).getWatermarkLogo();
//						filePath = filePath.replaceFirst("(?:" + CONTAINER_NAME + "/)+", "");
//						String azureImageSrc = getSignedImageFileFromAZURE(filePath, 0, 0);
//						if (StringUtils.isNotBlank(azureImageSrc) && !StringUtils.equals("500", azureImageSrc)) {
//							profileService.updateWatermarkSignedSrc(userFrontId, azureImageSrc);
//						}
//					}
//
//					if (StringUtils.isNotBlank(logoList.get(i).getThermalLogo())) {
//						String filePath = LOGO_IMAGE_LOCATION + "/" + logoList.get(i).getThermalLogo();
//						filePath = filePath.replaceFirst("(?:" + CONTAINER_NAME + "/)+", "");
//						String azureImageSrc = getSignedImageFileFromAZURE(filePath, 0, 0);
//						if (StringUtils.isNotBlank(azureImageSrc) && !StringUtils.equals("500", azureImageSrc)) {
//							profileService.updateThermalLogoSignedSrc(userFrontId, azureImageSrc);
//						}
//					}
//
//					if (StringUtils.isNotBlank(logoList.get(i).getBanner())) {
//						String filePath = LOGO_IMAGE_LOCATION + "/" + logoList.get(i).getBanner();
//						filePath = filePath.replaceFirst("(?:" + CONTAINER_NAME + "/)+", "");
//						String azureImageSrc = getSignedImageFileFromAZURE(filePath, 0, 0);
//						if (StringUtils.isNotBlank(azureImageSrc) && !StringUtils.equals("500", azureImageSrc)) {
//							profileService.updatebannerSignedSrc(userFrontId, azureImageSrc);
//						}
//					}
//
//					if (StringUtils.isNotBlank(logoList.get(i).getSignatureLogo())) {
//						String filePath = LOGO_IMAGE_LOCATION + "/" + logoList.get(i).getSignatureLogo();
//						filePath = filePath.replaceFirst("(?:" + CONTAINER_NAME + "/)+", "");
//						String azureImageSrc = getSignedImageFileFromAZURE(filePath, 0, 0);
//						if (StringUtils.isNotBlank(azureImageSrc) && !StringUtils.equals("500", azureImageSrc)) {
//							profileService.updateSignatureLogoSignedSrc(userFrontId, azureImageSrc);
//						}
//					}
//
//					if (StringUtils.isNotBlank(logoList.get(i).getWooCommerceDefaultImage())) {
//						String filePath = LOGO_IMAGE_LOCATION + "/" + logoList.get(i).getWooCommerceDefaultImage();
//						filePath = filePath.replaceFirst("(?:" + CONTAINER_NAME + "/)+", "");
//						String azureImageSrc = getSignedImageFileFromAZURE(filePath, 0, 0);
//						if (StringUtils.isNotBlank(azureImageSrc) && !StringUtils.equals("500", azureImageSrc)) {
//							profileService.updateWooCommerceDefaultImageSignedSrc(userFrontId, azureImageSrc);
//						}
//					}
//
//				}
//			}
//			log.info("END================LOGO=============END");
//
//		} catch (Exception e) {
//			log.info("ERROR------------>LOGO");
//			e.printStackTrace();
//		}
//	}
//
//	public void generateSignedSrcForBrand(long company_id) {
//		try {
//			log.info("START================BRAND=============START");
//			List<CommonLogoListDTO> imageVos = brandRepository.findAllCompanysAllBrandLogos(company_id);
//			log.warning("imageVos size---->" + imageVos.size());
//			if (!imageVos.isEmpty()) {
//				for (int i = 0; i < imageVos.size(); i++) {
//					String fileName = imageVos.get(i).getLogo();
//					long companyId = imageVos.get(i).getCompanyId();
//					long id = imageVos.get(i).getId();
//					String filePath = IMAGE_LOCATION + "/" + companyId + "/brand/" + fileName;
//
//					filePath = filePath.replaceFirst("(?:" + CONTAINER_NAME + "/)+", "");
//					String imageSrc = getSignedImageFileFromAZURE(filePath, companyId, 0);
//					if (StringUtils.isNotBlank(imageSrc) && !StringUtils.equals("500", imageSrc)) {
//						int result = brandRepository.updateBrandLogoSignedSrc(id, imageSrc);
//						log.warning("updateSignedSrc--------->" + result);
//					}
//				}
//			}
//			log.info("END================BRAND=============END");
//		} catch (Exception e) {
//			log.info("ERROR------------>BRAND");
//			e.printStackTrace();
//		}
//	}
//
//	public void generateSignedSrcForCategory(long company_id) {
//		try {
//			log.info("START================CATEGORY=============START");
//			List<CommonLogoListDTO> imageVos = categoryRepository.findAllCompanysAllCategoryLogos(company_id);
//			log.warning("imageVos size---->" + imageVos.size());
//			if (!imageVos.isEmpty()) {
//				for (int i = 0; i < imageVos.size(); i++) {
//					String fileName = imageVos.get(i).getLogo();
//					long companyId = imageVos.get(i).getCompanyId();
//					long id = imageVos.get(i).getId();
//					String filePath = IMAGE_LOCATION + "/" + companyId + "/category/" + fileName;
//
//					filePath = filePath.replaceFirst("(?:" + CONTAINER_NAME + "/)+", "");
//					String imageSrc = getSignedImageFileFromAZURE(filePath, companyId, 0);
//					if (StringUtils.isNotBlank(imageSrc) && !StringUtils.equals("500", imageSrc)) {
//						int result = categoryRepository.updateCategoryLogoSignedSrc(id, imageSrc);
//						log.warning("updateSignedSrc--------->" + result);
//					}
//				}
//			}
//			log.info("END================CATEGORY=============END");
//		} catch (Exception e) {
//			log.info("ERROR------------>CATEGORY");
//			e.printStackTrace();
//		}
//	}
//
//	public void generateSignedSrcForDepartment(long company_id) {
//		try {
//			log.info("START================DEPARTMENT=============START");
//			List<CommonLogoListDTO> imageVos = departmentRepository.findAllCompanysAllDepartmentLogos(company_id);
//			log.warning("imageVos size---->" + imageVos.size());
//			if (!imageVos.isEmpty()) {
//				for (int i = 0; i < imageVos.size(); i++) {
//					String fileName = imageVos.get(i).getLogo();
//					long companyId = imageVos.get(i).getCompanyId();
//					long id = imageVos.get(i).getId();
//					String filePath = IMAGE_LOCATION + "/" + companyId + "/department/" + fileName;
//
//					filePath = filePath.replaceFirst("(?:" + CONTAINER_NAME + "/)+", "");
//					String imageSrc = getSignedImageFileFromAZURE(filePath, companyId, 0);
//					if (StringUtils.isNotBlank(imageSrc) && !StringUtils.equals("500", imageSrc)) {
//						int result = departmentRepository.updateDepartmentLogoSignedSrc(id, imageSrc);
//						log.warning("updateSignedSrc--------->" + result);
//					}
//				}
//			}
//
//			log.info("END================DEPARTMENT=============END");
//		} catch (Exception e) {
//			log.info("ERROR------------>DEPARTMENT");
//			e.printStackTrace();
//		}
//	}

}
