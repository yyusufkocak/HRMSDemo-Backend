package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.StaffUserService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.StaffUser;

@RestController
@RequestMapping("/api/StaffUsers")
public class StaffUsersController {
	private StaffUserService staffUserService;

	@Autowired
	public StaffUsersController(StaffUserService staffUserService) {
		this.staffUserService = staffUserService;
	}

	@GetMapping("/getAll")
	public DataResult<List<StaffUser>> getAll() {
		return staffUserService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<StaffUser> getById(int staffId) {
		return staffUserService.getById(staffId);
	}

	@PostMapping("/add")
	public Result add(@RequestBody StaffUser staffUser) {
		return this.staffUserService.add(staffUser);

	}

	@PostMapping("/delete")
	public Result delete(@RequestBody StaffUser staffUser) {
		return this.staffUserService.delete(staffUser);
	}
}
