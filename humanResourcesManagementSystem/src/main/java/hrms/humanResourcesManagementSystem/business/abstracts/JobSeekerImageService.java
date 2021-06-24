package hrms.humanResourcesManagementSystem.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerImage;


public interface JobSeekerImageService {

	 public Result upload(int userId, MultipartFile multipartFile);
    
}
