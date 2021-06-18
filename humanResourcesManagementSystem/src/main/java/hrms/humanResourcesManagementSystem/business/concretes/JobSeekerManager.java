package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.JobSeekerService;
import hrms.humanResourcesManagementSystem.core.tools.concretes.EmailRegexCheckTool;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.core.validators.abstracts.EmailValidationService;
import hrms.humanResourcesManagementSystem.core.validators.abstracts.UserValidationService;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.JobSeekerDao;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private UserValidationService<JobSeeker> uservalidationService;
	private EmailValidationService emailValidationService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,UserValidationService<JobSeeker> uservalidationService,EmailValidationService emailValidationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.uservalidationService = uservalidationService;

		this.emailValidationService=emailValidationService;
		
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"JobSeekers Listed");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		
	
		
		
		if(uservalidationService.checkIfRealPerson(jobSeeker) 	
				&& !jobSeekerDao.existsByMail(jobSeeker.getMail()) )
					
			 {
			
			if (jobSeekerDao.existsByNationalityIdentity(jobSeeker.getNationalityIdentity()) 
					&& EmailRegexCheckTool.checkEmail(jobSeeker.getMail())) {
				return new ErrorResult("this user already exists");
			}			
			else {
				if(emailValidationService.emailValidate(jobSeeker.getMail())) {
					
					this.jobSeekerDao.save(jobSeeker);
					return new SuccessResult("JobSeeker Added");
					
				}else {
				return new ErrorResult("Email verification not successful");
			}
			
	    } 
		
		}
		return new ErrorResult("JobSeekers Not Added");
	}

	@Override
	public DataResult<JobSeeker> getById(int jobSeekerId) {
		
	
		 return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getById(jobSeekerId));
	}
}