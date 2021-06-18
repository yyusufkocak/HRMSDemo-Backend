package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobExperience;

public interface JobExperienceService {
	DataResult<List<JobExperience>> getAll();
	
	Result add(JobExperience jobExperience);
	Result delete(JobExperience jobExperience);
	
	DataResult<List<JobExperience>> getAllByJobSeekerIdOrderByEndingDateDesc(int jobSeekerId);
}
