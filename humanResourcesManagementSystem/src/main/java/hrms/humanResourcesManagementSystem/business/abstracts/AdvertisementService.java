package hrms.humanResourcesManagementSystem.business.abstracts;

import hrms.humanResourcesManagementSystem.core.utilities.results.Result;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.entities.concretes.Advertisement;

public interface AdvertisementService {

	Result add(Advertisement advertisement);
	
	Result delete(Advertisement advertisement);
	
	
	
	DataResult<List<Advertisement>> getByIsActive();
	
	DataResult<List<Advertisement>> getByOrderByStartingDate();
	
	DataResult<List<Advertisement>> getByIsActiveTrueAndEmployer_Id(int employerId);
	
}
