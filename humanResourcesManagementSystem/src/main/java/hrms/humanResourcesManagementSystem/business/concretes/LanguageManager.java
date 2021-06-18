package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.LanguageService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.LanguageDao;
import hrms.humanResourcesManagementSystem.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
	}

	@Override
	public Result add(Language language) {
		Result result = null;

		if (languageDao.existsByLanguageName(language.getLanguageName())) {
			result = new ErrorResult("Language  already defined");
		} else {
			this.languageDao.save(language);
			result = new SuccessResult("Language  added");
		}

		return result;
	}
	
	@Override
	public Result delete(Language language) {
		languageDao.delete(language);
		return new SuccessResult("Language deleted");
		
	}
}
