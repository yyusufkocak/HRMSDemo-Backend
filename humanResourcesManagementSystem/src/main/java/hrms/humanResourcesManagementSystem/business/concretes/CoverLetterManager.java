package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.CoverLetterService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.CoverLetterDao;
import hrms.humanResourcesManagementSystem.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService{

	private CoverLetterDao coverLetterDao;

	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public DataResult<List<CoverLetter>> getAll() {
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.findAll());
	}

	@Override
	public Result add(CoverLetter coverLetter) {
	
			this.coverLetterDao.save(coverLetter);
			return	new SuccessResult("CoverLetter  added");
	
	}
	
	@Override
	public Result delete(CoverLetter coverLetter) {
		coverLetterDao.delete(coverLetter);
		return new SuccessResult("CoverLetter deleted");
		
	}

	@Override
	public DataResult<List<CoverLetter>> getAllByJobSeekerId(int jobseekerId) {
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.getAllByJobSeeker_Id(jobseekerId));
	}

}
