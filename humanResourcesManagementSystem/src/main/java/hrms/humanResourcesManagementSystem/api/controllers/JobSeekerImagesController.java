package hrms.humanResourcesManagementSystem.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerImageService;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerImage;


@RestController
@RequestMapping("/api/jobseekerimages")
public class JobSeekerImagesController {
	
	private JobSeekerImageService jobSeekerImageService; 
	
	@Autowired
	public JobSeekerImagesController(JobSeekerImageService jobSeekerImageService) {
		super();
		this.jobSeekerImageService = jobSeekerImageService;
	}

	@PostMapping("/upload")
	public Result upload(@RequestParam int userId,MultipartFile multipartFile) {
		return jobSeekerImageService.upload(userId, multipartFile);
	}
}
