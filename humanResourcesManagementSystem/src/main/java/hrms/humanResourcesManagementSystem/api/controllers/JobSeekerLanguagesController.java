package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerLanguageService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerLanguage;

@RestController
@RequestMapping("/api/jobseekerlanguages")
public class JobSeekerLanguagesController {
private JobSeekerLanguageService jobSeekerLanguageService;
	
	
	@Autowired
	public JobSeekerLanguagesController(JobSeekerLanguageService jobSeekerLanguageService) {
		super();
		this.jobSeekerLanguageService = jobSeekerLanguageService;
	}



	@GetMapping("/getall")
	public DataResult<List<JobSeekerLanguage>> getAll(){
		return this.jobSeekerLanguageService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerLanguage jobSeekerLanguage) {
		return this.jobSeekerLanguageService.add(jobSeekerLanguage);
	  }
	@PostMapping("/delete")
	public Result delete(@RequestBody JobSeekerLanguage jobSeekerLanguage) {
		return this.jobSeekerLanguageService.delete(jobSeekerLanguage);
	  }
}
