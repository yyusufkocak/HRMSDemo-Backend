package hrms.humanResourcesManagementSystem.adapters;


import java.io.File;
import java.util.Map;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrms.humanResourcesManagementSystem.core.utilities.image.ImageUploadCloudinaryService;



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
	    public String upload(File file) {
	        try {
	            Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
	            return  (uploadResult.get("url").toString());
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
