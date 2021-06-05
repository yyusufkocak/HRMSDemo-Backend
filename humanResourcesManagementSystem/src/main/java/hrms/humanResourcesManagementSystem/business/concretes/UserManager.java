package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.UserService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.UserDao;
import hrms.humanResourcesManagementSystem.entities.concretes.User;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao=userDao;
	}

	@Override
	public Result add(User user) {
	if (userDao.existsByMail(user.getMail())) {
		return new SuccessResult("User Added");
	}
	return new ErrorResult("User Not Added");
	}

	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"User Listed");
		
	}

}
