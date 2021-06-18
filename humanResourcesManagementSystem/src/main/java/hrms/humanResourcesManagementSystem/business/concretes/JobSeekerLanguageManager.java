package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerLanguageService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobSeekerLanguageDao;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerLanguage;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {
	private JobSeekerLanguageDao jobSeekerLanguageDao;

	@Autowired
	public JobSeekerLanguageManager(JobSeekerLanguageDao jobSeekerLanguageDao) {
		super();
		this.jobSeekerLanguageDao = jobSeekerLanguageDao;
	}

	@Override
	public DataResult<List<JobSeekerLanguage>> getAll() {
		return new SuccessDataResult<List<JobSeekerLanguage>>(this.jobSeekerLanguageDao.findAll());
	}

	@Override
	public Result add(JobSeekerLanguage jobSeekerLanguage) {
	

		this.jobSeekerLanguageDao.save(jobSeekerLanguage);
		return	new SuccessResult("JobSeekerLanguage added");
	}
	
	@Override
	public Result delete(JobSeekerLanguage jobSeekerLanguage) {
		jobSeekerLanguageDao.delete(jobSeekerLanguage);
		return new SuccessResult("JobSeekerLanguage deleted");
		
	}
}
