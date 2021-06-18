package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobExperienceService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobExperience;


@RestController
@RequestMapping("/api/jobexperiences")
public class JobExperiencesController {
private JobExperienceService jobExperienceService;
	
	
	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}



	@GetMapping("/getall")
	public DataResult<List<JobExperience>> getAll(){
		return this.jobExperienceService.getAll();
	}
	
	@GetMapping("/getallbyjobseekeridorderbyendingdatedesc")
	public DataResult<List<JobExperience>> getAllByJobSeekerIdOrderByEndingDateDesc(int jobSeekerId) {
		
		return this.jobExperienceService.getAllByJobSeekerIdOrderByEndingDateDesc(jobSeekerId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.add(jobExperience);
	  }
	@PostMapping("/delete")
	public Result delete(@RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.delete(jobExperience);
	  }
}
