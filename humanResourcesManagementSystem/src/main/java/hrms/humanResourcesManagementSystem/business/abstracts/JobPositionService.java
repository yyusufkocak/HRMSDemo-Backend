package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobPosition;

public interface JobPositionService {
	
	DataResult<List<JobPosition>> getAll();
	Result add(JobPosition newJobPositions);
	
}
