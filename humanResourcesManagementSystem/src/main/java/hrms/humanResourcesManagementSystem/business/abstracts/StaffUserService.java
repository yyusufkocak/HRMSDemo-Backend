package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.StaffUser;

public interface StaffUserService {

	DataResult<List<StaffUser>> getAll();
	Result add(StaffUser staffUser);
	Result delete(StaffUser staffUser);
	
	DataResult<StaffUser> getById(int staffId);
}
