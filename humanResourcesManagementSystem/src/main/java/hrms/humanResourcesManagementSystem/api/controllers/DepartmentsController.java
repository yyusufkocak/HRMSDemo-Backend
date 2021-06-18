package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.DepartmentService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.Department;

@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {
private DepartmentService departmentService;
	
	
	@Autowired
	public DepartmentsController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}



	@GetMapping("/getall")
	public DataResult<List<Department>> getAll(){
		return this.departmentService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Department department) {
		return this.departmentService.add(department);
	  }
	@PostMapping("/delete")
	public Result delete(@RequestBody Department department) {
		return this.departmentService.delete(department);
	  }
}
