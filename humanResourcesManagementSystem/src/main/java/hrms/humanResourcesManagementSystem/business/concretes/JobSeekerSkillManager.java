package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerSkillService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobSeekerSkillDao;
import hrms.humanResourcesManagementSystem.entities.concretes.CoverLetter;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerSkill;

@Service
public class JobSeekerSkillManager implements JobSeekerSkillService{
	private JobSeekerSkillDao jobSeekerSkillDao;

	@Autowired
	public JobSeekerSkillManager(JobSeekerSkillDao jobSeekerSkillDao) {
		super();
		this.jobSeekerSkillDao = jobSeekerSkillDao;
	}

	@Override
	public DataResult<List<JobSeekerSkill>> getAll() {
		return new SuccessDataResult<List<JobSeekerSkill>>(this.jobSeekerSkillDao.findAll());
	}

	@Override
	public Result add(JobSeekerSkill jobSeekerSkill) {
	

		this.jobSeekerSkillDao.save(jobSeekerSkill);
		return	new SuccessResult("JobSeeker Skill added");
	}
	
	@Override
	public Result delete(JobSeekerSkill jobSeekerSkill) {
		jobSeekerSkillDao.delete(jobSeekerSkill);
		return new SuccessResult("JobSeeker Skill deleted");
		
	}

	@Override
	public DataResult<List<JobSeekerSkill>> getAllByJobSeekerId(int jobseekerId) {
		return new SuccessDataResult<List<JobSeekerSkill>>(this.jobSeekerSkillDao.getAllByJobSeeker_Id(jobseekerId));
	}
}
