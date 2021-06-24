package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hrms.humanResourcesManagementSystem.business.abstracts.SkillService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.Skill;


@RestController
@RequestMapping("/api/skills")
public class SkillsController {
private SkillService skillService;
	
	
	@Autowired
	public SkillsController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}



	@GetMapping("/getall")
	public DataResult<List<Skill>> getAll(){
		return this.skillService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Skill skill) {
		return this.skillService.add(skill);
	  }
	@PostMapping("/delete")
	public Result delete(@RequestBody Skill skill) {
		return this.skillService.delete(skill);
	  }
	
	
	@GetMapping("/getById")
	public DataResult<Skill> getById(int id){
		
		return this.skillService.getById(id);
	}
}
