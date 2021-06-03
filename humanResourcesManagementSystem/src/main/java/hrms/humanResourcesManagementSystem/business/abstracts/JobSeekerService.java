package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeeker;


public interface JobSeekerService {
	
	DataResult<List<JobSeeker>> getAll();
	
	Result add (JobSeeker jobSeeker) ;
	
}