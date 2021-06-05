package hrms.humanResourcesManagementSystem.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.humanResourcesManagementSystem.business.abstracts.AdvertisementService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.Advertisement;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementsController {

	private AdvertisementService advertisementService;

	@Autowired
	public AdvertisementsController(AdvertisementService advertisementService) {
		this.advertisementService = advertisementService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid Advertisement advertisement) {
		return this.advertisementService.add(advertisement);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody @Valid Advertisement advertisement) {
		return this.advertisementService.delete(advertisement);
	}

	@GetMapping("/getByIsActive")
	public DataResult<List<Advertisement>> getByIsActive() {
		return this.advertisementService.getByIsActive();
	}

	@GetMapping("/getByOrderByStartingDate")
	public DataResult<List<Advertisement>> getByOrderByStartingDate() {
		return this.advertisementService.getByOrderByStartingDate();	}

	@GetMapping("/getByIsActiveTrueAndEmployer_Id")
	public DataResult<List<Advertisement>> getByIsActiveTrueAndEmployer_Id(int employerId) {
		return this.advertisementService.getByIsActiveTrueAndEmployer_Id(employerId);
	}

}
