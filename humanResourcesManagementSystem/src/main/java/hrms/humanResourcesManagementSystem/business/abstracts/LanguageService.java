package hrms.humanResourcesManagementSystem.business.abstracts;

import java.util.List;

import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.Language;

public interface LanguageService {
	DataResult<List<Language>> getAll();
	Result add(Language language);
	Result delete(Language language);
}
