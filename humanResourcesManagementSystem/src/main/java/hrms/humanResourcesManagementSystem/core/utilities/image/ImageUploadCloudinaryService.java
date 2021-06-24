package hrms.humanResourcesManagementSystem.core.utilities.image;



import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;







public interface ImageUploadCloudinaryService {
	DataResult<?> upload(MultipartFile multipartFile);
}
