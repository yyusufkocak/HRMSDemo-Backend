package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerLanguage;


public interface JobSeekerLanguageService {
	DataResult<List<JobSeekerLanguage>> getAll();
	Result add(JobSeekerLanguage jobSeekerLanguage);
	Result delete(JobSeekerLanguage jobSeekerLanguage);
	
	DataResult<List<JobSeekerLanguage>> getAllByJobSeekerId(int jobseekerId);
}
