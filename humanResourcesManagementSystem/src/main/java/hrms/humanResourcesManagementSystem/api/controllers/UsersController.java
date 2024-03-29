package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import hrms.humanResourcesManagementSystem.business.abstracts.UserService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeeker;
import hrms.humanResourcesManagementSystem.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
private UserService userService;
	
	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<User>> getAll(){
		
		return this.userService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<User> getById(int userId){
		
		return this.userService.getById(userId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker){
		return userService.add(jobSeeker);
	}

}
