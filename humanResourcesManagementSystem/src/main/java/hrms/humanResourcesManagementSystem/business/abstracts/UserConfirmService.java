package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.UserConfirm;

public interface UserConfirmService {

Result add(UserConfirm  userConfirm);
	
	Result delete(UserConfirm  userConfirm);
	
	DataResult<List<UserConfirm>> getAll();
	
	
	DataResult<UserConfirm> getById(int userConfirmId);
	
}
