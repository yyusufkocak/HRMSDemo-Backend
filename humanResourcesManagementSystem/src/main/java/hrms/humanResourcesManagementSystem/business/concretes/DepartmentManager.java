package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.DepartmentService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.DepartmentDao;
import hrms.humanResourcesManagementSystem.entities.concretes.Department;

@Service
public class DepartmentManager  implements DepartmentService{
	private DepartmentDao departmentDao;

	@Autowired
	public DepartmentManager(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}

	@Override
	public DataResult<List<Department>> getAll() {
		return new SuccessDataResult<List<Department>>(this.departmentDao.findAll());
	}

	@Override
	public Result add(Department department) {
		Result result = null;

		if (departmentDao.existsByDepartmentName(department.getDepartmentName())) {
			result = new ErrorResult("Department  already defined");
		} else {
			this.departmentDao.save(department);
			result = new SuccessResult("Department  added");
		}

		return result;
	}
	
	@Override
	public Result delete(Department department) {
		departmentDao.delete(department);
		return new SuccessResult("Department deleted");
		
	}

}
