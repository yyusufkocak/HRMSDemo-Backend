package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.ResumeService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.Resume;
import hrms.humanResourcesManagementSystem.entities.dtos.ResumeWithAllRelatedEntitiesDto;

@RestController
@RequestMapping("/api/resumes")
public class ResumesController {
	
	private ResumeService resumeService;
	
	@Autowired
	public ResumesController(ResumeService resumeService) 
	{
		this.resumeService=resumeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody @Valid Resume resume) {
		return this.resumeService.add(resume);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody @Valid Resume resume) {
		return this.resumeService.delete(resume);
	}

	@GetMapping("/getAll")
	public DataResult<List<Resume>> getAll() {
		return this.resumeService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<Resume> getById(int resumeId) {
		return this.resumeService.getById(resumeId);
	}

	@GetMapping("/getByJobseekerId")
	public DataResult<Resume> getByJobseekerId(int jobSeekerId) 
	{
		return this.resumeService.getByJobSeekerId(jobSeekerId);
		
	}
	

	
	@GetMapping("/getResumeDetailsByJobSeekerId")
	public DataResult<ResumeWithAllRelatedEntitiesDto> getResumeDetailsByJobSeekerId(int jobSeekerId)
	{
		return this.resumeService.getResumeDetailsByJobSeekerId(jobSeekerId);
	}
	
}
