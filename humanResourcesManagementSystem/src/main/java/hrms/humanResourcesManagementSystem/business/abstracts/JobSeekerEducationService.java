package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobExperience;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerEducation;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerSkill;

public interface JobSeekerEducationService {
	DataResult<List<JobSeekerEducation>> getAll();
	Result add(JobSeekerEducation jobSeekerEducation);
	Result delete(JobSeekerEducation jobSeekerEducation);
	
	DataResult<List<JobSeekerEducation>> getAllByJobSeekerIdOrderByEndingDateDesc(int jobSeekerId);
	
	
}
