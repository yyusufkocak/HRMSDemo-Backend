package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.Department;

public interface DepartmentService {
	DataResult<List<Department>> getAll();
	Result add(Department department);
	Result delete(Department department);
}
