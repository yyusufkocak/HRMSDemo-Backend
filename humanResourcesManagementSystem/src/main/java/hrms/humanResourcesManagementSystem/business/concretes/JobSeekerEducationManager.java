package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerEducationService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobSeekerEducationDao;
import hrms.humanResourcesManagementSystem.entities.concretes.CoverLetter;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerEducation;

@Service
public class JobSeekerEducationManager implements JobSeekerEducationService {
	private JobSeekerEducationDao JobSeekerEducationDao;

	@Autowired
	public JobSeekerEducationManager(JobSeekerEducationDao JobSeekerEducationDao) {
		super();
		this.JobSeekerEducationDao = JobSeekerEducationDao;
	}

	@Override
	public DataResult<List<JobSeekerEducation>> getAll() {
		return new SuccessDataResult<List<JobSeekerEducation>>(this.JobSeekerEducationDao.findAll());
	}

	@Override
	public Result add(JobSeekerEducation jobSeekerEducation) {
	

		this.JobSeekerEducationDao.save(jobSeekerEducation);
		return	new SuccessResult("JobSeekerEducation added");
	}
	
	@Override
	public Result delete(JobSeekerEducation jobSeekerEducation) {
		JobSeekerEducationDao.delete(jobSeekerEducation);
		return new SuccessResult("JobSeekerEducation deleted");
		
	}

	@Override
	public DataResult<List<JobSeekerEducation>> getAllByJobSeekerIdOrderByEndingDateDesc(int jobSeekerId) {
		
		return new SuccessDataResult<List<JobSeekerEducation>>(JobSeekerEducationDao.getAllByJobSeeker_IdOrderByEndingDateDesc(jobSeekerId));
	
	}

	
}
