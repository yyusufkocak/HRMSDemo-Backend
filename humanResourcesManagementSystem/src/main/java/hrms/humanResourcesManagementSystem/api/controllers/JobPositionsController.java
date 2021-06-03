package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.JobPositionService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobPosition;



@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {
	
	
	private JobPositionService jobPositionsService;
	
	
	@Autowired
	public JobPositionsController(JobPositionService jobPositionsService) {
		super();
		this.jobPositionsService = jobPositionsService;
	}



	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.jobPositionsService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPositions) {
		return this.jobPositionsService.add(jobPositions);
	  }
	
}