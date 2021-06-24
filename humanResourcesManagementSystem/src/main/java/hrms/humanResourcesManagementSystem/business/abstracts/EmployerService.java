package hrms.humanResourcesManagementSystem.business.abstracts;


import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;

import hrms.humanResourcesManagementSystem.entities.concretes.Employer;



public interface EmployerService {

	DataResult<List<Employer>> getAll();
	
	Result add (Employer employer);
	Result update(Employer employer);
	DataResult<Employer> getById(int id);
}