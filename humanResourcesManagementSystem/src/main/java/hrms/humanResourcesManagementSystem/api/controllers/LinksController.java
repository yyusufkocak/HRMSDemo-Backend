package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.LinkService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.Link;

@RestController
@RequestMapping("/api/links")
public class LinksController {
private LinkService linkService;
	
	
	@Autowired
	public LinksController(LinkService linkService) {
		super();
		this.linkService = linkService;
	}



	@GetMapping("/getall")
	public DataResult<List<Link>> getAll(){
		return this.linkService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Link link) {
		return this.linkService.add(link);
	  }
	@PostMapping("/delete")
	public Result delete(@RequestBody Link link) {
		return this.linkService.delete(link);
	  }
}
