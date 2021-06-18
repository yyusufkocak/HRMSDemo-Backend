package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.CoverLetter;

public interface CoverLetterService {

	
	DataResult<List<CoverLetter>> getAll();
	Result add(CoverLetter coverLetter);
	Result delete(CoverLetter coverLetter);
	
}
