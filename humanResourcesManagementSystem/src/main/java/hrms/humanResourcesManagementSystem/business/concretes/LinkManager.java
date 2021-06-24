package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.LinkService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.LinkDao;
import hrms.humanResourcesManagementSystem.entities.concretes.CoverLetter;
import hrms.humanResourcesManagementSystem.entities.concretes.Link;

@Service
public class LinkManager implements LinkService {
	private LinkDao linkDao;

	@Autowired
	public LinkManager(LinkDao linkDao) {
		super();
		this.linkDao = linkDao;
	}

	@Override
	public DataResult<List<Link>> getAll() {
		return new SuccessDataResult<List<Link>>(this.linkDao.findAll());
	}

	@Override
	public Result add(Link link) {
	

		this.linkDao.save(link);
		return	new SuccessResult("Link added");
	}
	
	@Override
	public Result delete(Link link) {
		linkDao.delete(link);
		return new SuccessResult("Link deleted");
		
	}

	@Override
	public DataResult<List<Link>> getAllByJobSeekerId(int jobseekerId) {
		return new SuccessDataResult<List<Link>>(this.linkDao.getAllByJobSeeker_Id(jobseekerId));
	}
	
}
