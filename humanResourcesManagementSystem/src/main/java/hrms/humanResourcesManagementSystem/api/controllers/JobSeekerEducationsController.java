package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerEducationService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerEducation;

@RestController
@RequestMapping("/api/jobseekereducations")
public class JobSeekerEducationsController {
private JobSeekerEducationService jobSeekerEducationService;
	
	
	@Autowired
	public JobSeekerEducationsController(JobSeekerEducationService jobSeekerEducationService) {
		super();
		this.jobSeekerEducationService = jobSeekerEducationService;
	}



	@GetMapping("/getall")
	public DataResult<List<JobSeekerEducation>> getAll(){
		return this.jobSeekerEducationService.getAll();
	}
	
	@GetMapping("/getallbyjobseekeridorderbyendingdatedesc")
	public DataResult<List<JobSeekerEducation>> getAllByJobSeekerIdOrderByEndingDateDesc(int jobSeekerId) {
		
		return this.jobSeekerEducationService.getAllByJobSeekerIdOrderByEndingDateDesc(jobSeekerId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerEducation jobSeekerEducation) {
		return this.jobSeekerEducationService.add(jobSeekerEducation);
	  }
	@PostMapping("/delete")
	public Result delete(@RequestBody JobSeekerEducation jobSeekerEducation) {
		return this.jobSeekerEducationService.delete(jobSeekerEducation);
	  }
}
