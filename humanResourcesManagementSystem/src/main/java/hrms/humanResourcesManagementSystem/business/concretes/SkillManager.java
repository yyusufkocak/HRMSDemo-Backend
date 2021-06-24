package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.SkillService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.SkillDao;
import hrms.humanResourcesManagementSystem.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService{
	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAll());
	}

	@Override
	public Result add(Skill skill) {
		Result result = null;

		if (skillDao.existsBySkillName(skill.getSkillName())) {
			result = new ErrorResult("Skill  already defined");
		} else {
			this.skillDao.save(skill);
			result = new SuccessResult("Skill  added");
		}

		return result;
	}
	
	@Override
	public Result delete(Skill skill) {
		skillDao.delete(skill);
		return new SuccessResult("Skill deleted");
		
	}

	@Override
	public DataResult<Skill> getById(int id) {
		return new SuccessDataResult<Skill>(this.skillDao.getById(id));
	}
	
}
