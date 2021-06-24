package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.EmployerService;
import hrms.humanResourcesManagementSystem.business.abstracts.UserConfirmService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.UserConfirmDao;
import hrms.humanResourcesManagementSystem.entities.concretes.Employer;
import hrms.humanResourcesManagementSystem.entities.concretes.UserConfirm;

@Service
public class UserConfirmManager implements UserConfirmService {

	private UserConfirmDao userConfirmDao;
	private EmployerService employerService;
	
	@Autowired
	public UserConfirmManager(UserConfirmDao userConfirmDao,EmployerService employerService) {
		this.userConfirmDao=userConfirmDao;
		this.employerService=employerService;
	}

	@Override
	public Result add(UserConfirm userConfirm) {
		
		Employer updatedEmployer=employerService.getById(userConfirm.getEmployer().getId()).getData();
		updatedEmployer.setConfirm(true);
		employerService.update(updatedEmployer);
		this.userConfirmDao.save(userConfirm);
		return new SuccessResult("UserConfirm added");
	}
	
	@Override
	public Result delete(UserConfirm userConfirm) {
		this.userConfirmDao.delete(userConfirm);
		return new SuccessResult("UserConfirm deleted");
	}

	@Override
	public DataResult<List<UserConfirm>> getAll() {
		return new SuccessDataResult<List<UserConfirm>>(userConfirmDao.findAll());
	}




	@Override
	public DataResult<UserConfirm> getById(int userConfirmId) {
		return new SuccessDataResult<UserConfirm>(userConfirmDao.getById(userConfirmId));
	}

}
