package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerSkillService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerSkill;

@RestController
@RequestMapping("/api/jobseekerskills")
public class JobSeekerSkillsController {
private JobSeekerSkillService jobSeekerSkillService;
	
	
	@Autowired
	public JobSeekerSkillsController(JobSeekerSkillService jobSeekerSkillService) {
		super();
		this.jobSeekerSkillService = jobSeekerSkillService;
	}



	@GetMapping("/getall")
	public DataResult<List<JobSeekerSkill>> getAll(){
		return this.jobSeekerSkillService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerSkill jobSeekerSkill) {
		return this.jobSeekerSkillService.add(jobSeekerSkill);
	  }
	@PostMapping("/delete")
	public Result delete(@RequestBody JobSeekerSkill jobSeekerSkill) {
		return this.jobSeekerSkillService.delete(jobSeekerSkill);
	  }
}
