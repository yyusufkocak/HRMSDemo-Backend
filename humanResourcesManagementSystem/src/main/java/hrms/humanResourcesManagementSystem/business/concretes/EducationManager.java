package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.EducationService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.EducationDao;
import hrms.humanResourcesManagementSystem.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;

	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll());
	}

	@Override
	public Result add(Education education) {
		Result result = null;

		if (educationDao.existsByEducationName(education.getEducationName())) {
			result = new ErrorResult("Education  already defined");
		} else {
			this.educationDao.save(education);
			result = new SuccessResult("Education  added");
		}

		return result;
	}
	
	@Override
	public Result delete(Education education) {
		educationDao.delete(education);
		return new SuccessResult("Education deleted");
		
	}

}
