package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.EmployerService;
import hrms.humanResourcesManagementSystem.core.tools.concretes.EmailRegexCheckTool;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.core.validators.abstracts.EmailValidationService;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.EmployerDao;
import hrms.humanResourcesManagementSystem.entities.concretes.Employer;


@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	private EmailValidationService emailValidationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao,EmailValidationService emailValidationService) {
		super();
		this.employerDao = employerDao;
		this.emailValidationService = emailValidationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employers Listed");
	}

	@Override
	public Result add(Employer employer) {
		
		String checkdomain=employer.getWebAddress().split("www.")[1];
				
		
		if (checkdomain.equals(employer.getMail().split("@")[1])) {

			if( EmailRegexCheckTool.checkEmail(employer.getMail()) && employerDao.existsByMail(employer.getMail())) {

				return new ErrorResult("This mail already exists.");
			}

			else {

				if (emailValidationService.emailValidate(employer.getMail())) {
				
					this.employerDao.save(employer);
					return new SuccessResult("Employer added");
					
				} else {
					return new ErrorResult("Email verification is not successful");
				}
			}

		}
		return new ErrorResult("Employer Not Added");

	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.getById(id));
	}

	@Override
	public Result update(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("Employer updated");
	}

}