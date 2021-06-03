package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerService;
import hrms.humanResourcesManagementSystem.core.abstracts.ValidationService;
import hrms.humanResourcesManagementSystem.core.concretes.EmailCheckManager;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobSeekerDao;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private ValidationService<JobSeeker> validationService;
	private EmailCheckManager emailCheckManager ;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,ValidationService<JobSeeker> validationService,EmailCheckManager emailValidationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.validationService = validationService;
		this.emailCheckManager = emailValidationService;
		
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>
		(this.jobSeekerDao.findAll(),"JobSeekers Listed");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		
	
		
		
		if(validationService.checkIfRealPerson(jobSeeker) 	
				&& !jobSeekerDao.existsByMail(jobSeeker.getMail()) )
					
			 {
			
			if (jobSeekerDao.existsByNationalityIdentity(jobSeeker.getNationalityIdentity()) ) {
				return new ErrorResult("this user already exists");
			}			
			else {
				if(emailCheckManager.sendEmail(jobSeeker.getMail())) {
					
					this.jobSeekerDao.save(jobSeeker);
					return new SuccessResult("JobSeeker is Added");
					
				}else {
				return new ErrorResult("Email verification is not successful");
			}
			
	    } 
		
		}
		return new ErrorResult("JobSeekers Not Added");
	}
}