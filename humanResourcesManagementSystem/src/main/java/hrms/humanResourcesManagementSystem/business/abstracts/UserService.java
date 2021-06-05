package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.entities.concretes.User;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;

public interface UserService {
	
	Result add(User user);
	DataResult<List<User>> getAll();

}
