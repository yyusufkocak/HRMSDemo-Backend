package hrms.humanResourcesManagementSystem.business.concretes;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerImageService;
import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerService;
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
	private JobSeekerService jobSeekerService;
	
	@Autowired
	public JobSeekerImageManager(JobSeekerImageDao jobSeekerImageDao,ImageUploadCloudinaryService imageUploadCloudinaryService,JobSeekerService jobSeekerService) {
		this.jobSeekerImageDao=jobSeekerImageDao;		
		this.imageUploadCloudinaryService=imageUploadCloudinaryService;
		this.jobSeekerService=jobSeekerService;
	}
	
	 @Override
	 public Result add(int jobSeekerId,String path) {
		 
		  
	        File file= (new File(path));


	        String url=imageUploadCloudinaryService.upload(file);

	       
	        JobSeekerImage jobSeekerImage=new JobSeekerImage();
	        jobSeekerImage.setImageUrl(url);
	        jobSeekerImage.setJobSeeker(jobSeekerService.getById(jobSeekerId).getData());

	       

	        jobSeekerImageDao.save(jobSeekerImage);
	        return new SuccessResult("Image Added");
			
	}



}
