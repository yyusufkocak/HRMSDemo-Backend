package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.EmployerService;
import hrms.humanResourcesManagementSystem.core.concretes.EmailCheckManager;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.EmployerDao;
import hrms.humanResourcesManagementSystem.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailCheckManager emailCheckManager;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailCheckManager emailCheckManager) {
		super();
		this.employerDao = employerDao;
		this.emailCheckManager = emailCheckManager;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employers Listed");
	}

	@Override
	public Result add(Employer employer) {
		if (employer.getWebAddress().contains(
				employer.getMail().substring(employer.getMail().indexOf("@") + 1, employer.getMail().indexOf(".")))) {

			if (employerDao.existsByMail(employer.getMail())) {

				return new ErrorResult("This mail already exists.");
			}

			else {

				if (emailCheckManager.sendEmail(employer.getMail())) {
					this.employerDao.save(employer);
					return new SuccessResult("Employer is Added");
				} else {
					return new ErrorResult("Email verification is not successful");
				}
			}

		}
		return new ErrorResult("Employer is Not Added");

	}

}