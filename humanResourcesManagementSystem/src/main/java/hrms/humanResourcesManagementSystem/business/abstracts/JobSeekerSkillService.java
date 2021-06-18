package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerSkill;

public interface JobSeekerSkillService {
	DataResult<List<JobSeekerSkill>> getAll();
	Result add(JobSeekerSkill jobSeekerSkill);
	Result delete(JobSeekerSkill jobSeekerSkill);
}
