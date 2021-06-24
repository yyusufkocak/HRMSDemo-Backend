package hrms.humanResourcesManagementSystem.adapters;


import java.io.File;
import java.io.IOException;
import java.util.Map;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrms.humanResourcesManagementSystem.core.utilities.image.ImageUploadCloudinaryService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;



@Service
public class ImageUploadCloudinaryAdapter implements ImageUploadCloudinaryService {

	 Cloudinary cloudinary;

	    public ImageUploadCloudinaryAdapter() {
	        this.cloudinary = new com.cloudinary.Cloudinary(ObjectUtils.asMap(
	                "cloud_name","dqsui1mz7",
	                "api_key","711464732159579",
	                "api_secret","KmgxsC70D6btNxzkcnQzDO5VFgw"
	        ));
	    }

	    @Override
		public DataResult<?> upload(MultipartFile multipartFile) {

			try {
				Map<?, ?> uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
				return new SuccessDataResult<>(uploadResult);
			} catch (IOException e) {
				e.printStackTrace();
				return new ErrorDataResult<>();
			}
		}
}
