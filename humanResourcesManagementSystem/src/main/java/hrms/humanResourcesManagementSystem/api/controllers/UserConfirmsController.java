package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.UserConfirmService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.UserConfirm;



@RestController
@RequestMapping("/api/userConfirms")
public class UserConfirmsController {
	
	private UserConfirmService userConfirmService;
	
	@Autowired
	public UserConfirmsController(UserConfirmService userConfirmService) 
	{
		this.userConfirmService=userConfirmService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<UserConfirm>> getAll() 
	{
		return this.userConfirmService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<UserConfirm> getById(int userConfirmId) 
	{
		return this.userConfirmService.getById(userConfirmId);
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody UserConfirm userConfirm) 
	{
		return this.userConfirmService.add(userConfirm);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody UserConfirm userConfirm) 
	{
		return this.userConfirmService.delete(userConfirm);
	}
}
