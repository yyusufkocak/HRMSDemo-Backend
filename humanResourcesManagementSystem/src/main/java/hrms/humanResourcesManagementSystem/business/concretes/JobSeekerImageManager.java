package hrms.humanResourcesManagementSystem.business.concretes;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerImageService;
import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerService;
import hrms.humanResourcesManagementSystem.business.abstracts.UserService;
import hrms.humanResourcesManagementSystem.core.utilities.image.ImageUploadCloudinaryService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobSeekerImageDao;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerImage;



@Service
public class JobSeekerImageManager implements JobSeekerImageService {

	private JobSeekerImageDao jobSeekerImageDao;
	private ImageUploadCloudinaryService imageUploadCloudinaryService;
	private UserService userService;
	
	@Autowired
	public JobSeekerImageManager(JobSeekerImageDao jobSeekerImageDao,ImageUploadCloudinaryService imageUploadCloudinaryService,UserService userService) {
		this.jobSeekerImageDao=jobSeekerImageDao;		
		this.imageUploadCloudinaryService=imageUploadCloudinaryService;
		this.userService=userService;
	}
	
	 @Override
	 public Result upload(int userId, MultipartFile multipartFile) {
		 
		  

			Map<?, ?> uploadImage = (Map<?, ?>) imageUploadCloudinaryService.upload(multipartFile).getData();

			JobSeekerImage jobSeekerImage = new JobSeekerImage();
			jobSeekerImage.setUser(userService.getById(userId).getData());
			jobSeekerImage.setImageUrl(uploadImage.get("url").toString());
			
			jobSeekerImageDao.save(jobSeekerImage);
			return new SuccessResult("Image added");
	}
	 
	 



}
