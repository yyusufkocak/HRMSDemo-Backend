package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.StaffUserService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.StaffUserDao;
import hrms.humanResourcesManagementSystem.entities.concretes.StaffUser;

@Service
public class StaffUserManager implements StaffUserService {

	private StaffUserDao staffUserDao;
	
	@Autowired
	public StaffUserManager(StaffUserDao staffUserDao) {

		this.staffUserDao=staffUserDao;
	}

	@Override
	public DataResult<List<StaffUser>> getAll() {
		return new SuccessDataResult<List<StaffUser>>(this.staffUserDao.findAll());
	}

	@Override
	public Result add(StaffUser staffUser) {
		this.staffUserDao.save(staffUser);
		return new SuccessResult("StaffUser added");
	}

	@Override
	public Result delete(StaffUser staffUser) {
		this.staffUserDao.delete(staffUser);
		return new SuccessResult("StaffUser deleted");
	}

	@Override
	public DataResult<StaffUser> getById(int staffId) {
		return new SuccessDataResult<StaffUser>(this.staffUserDao.getById(staffId));
	}

}
