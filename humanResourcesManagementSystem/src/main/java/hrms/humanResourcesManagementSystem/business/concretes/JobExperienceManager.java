package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobExperienceService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobExperienceDao;
import hrms.humanResourcesManagementSystem.entities.concretes.CoverLetter;
import hrms.humanResourcesManagementSystem.entities.concretes.JobExperience;
import hrms.humanResourcesManagementSystem.entities.concretes.Resume;

@Service
public class JobExperienceManager implements JobExperienceService {
	private JobExperienceDao jobExperienceDao;

	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll());
	}

	@Override
	public Result add(JobExperience jobExperience) {
	

		this.jobExperienceDao.save(jobExperience);
		return	new SuccessResult("JobExperience added");
	}
	
	@Override
	public Result delete(JobExperience jobExperience) {
		jobExperienceDao.delete(jobExperience);
		return new SuccessResult("JobExperience deleted");
		
	}

	@Override
	public DataResult<List<JobExperience>> getAllByJobSeekerIdOrderByEndingDateDesc(int jobSeekerId) {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.getAllByJobSeeker_IdOrderByEndingDateDesc(jobSeekerId));
	}

	



}
