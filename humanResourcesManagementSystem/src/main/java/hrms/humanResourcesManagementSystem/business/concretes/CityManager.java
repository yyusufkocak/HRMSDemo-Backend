package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.CityService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.CityDao;
import hrms.humanResourcesManagementSystem.entities.concretes.City;


@Service
public class CityManager implements CityService {
	
	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}

	@Override
	public Result add(City city) {
		Result result = null;

		if (cityDao.existsByCityName(city.getCityName())) {
			result = new ErrorResult("City  already defined");
		} else {
			this.cityDao.save(city);
			result = new SuccessResult("City  added");
		}

		return result;
	}
	
	@Override
	public Result delete(City city) {
		cityDao.delete(city);
		return new SuccessResult("City deleted");
		
	}

}
