package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.Advertisement;
import hrms.humanResourcesManagementSystem.entities.concretes.Skill;

public interface SkillService {
	DataResult<List<Skill>> getAll();
	Result add(Skill skill);
	Result delete(Skill skill);
	
	DataResult<Skill> getById(int id);
}
