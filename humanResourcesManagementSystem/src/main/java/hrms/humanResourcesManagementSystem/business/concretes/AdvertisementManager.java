package hrms.humanResourcesManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.business.abstracts.AdvertisementService;
import hrms.humanResourcesManagementSystem.core.utilities.results.DataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.SuccessResult;
import hrms.humanResourcesManagementSystem.dataAccess.abstracts.AdvertisementDao;
import hrms.humanResourcesManagementSystem.entities.concretes.Advertisement;
import hrms.humanResourcesManagementSystem.entities.concretes.User;

@Service
public class AdvertisementManager implements AdvertisementService {

	private AdvertisementDao advertisementDao;

	@Autowired
	public AdvertisementManager(AdvertisementDao advertisementDao) {
		this.advertisementDao = advertisementDao;
	}

	@Override
	public Result add(Advertisement advertisement) {

		try {
			this.advertisementDao.save(advertisement);
			return new SuccessResult("Advertisement Added");
		} catch (Exception e) {
			return new ErrorResult("Advertisement Not Added");
		}

	}

	@Override
	public Result delete(Advertisement advertisement) {
		try {
			this.advertisementDao.delete(advertisement);
			return new SuccessResult("Advertisement Deleted");
		} catch (Exception e) {
			return new ErrorResult("Advertisement Not Deleted");
			
		}
	}



	@Override
	public DataResult<List<Advertisement>> getByIsActive() {
		return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.getByIsActiveTrue());
	}

	@Override
	public DataResult<List<Advertisement>> getByOrderByStartingDate() {
		return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.getByOrderByStartingDate());
	}

	@Override
	public DataResult<List<Advertisement>> getByIsActiveTrueAndEmployer_Id(int employerId) {
		return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.getByIsActiveTrueAndEmployer_Id(employerId));
	}

	@Override
	public DataResult<Advertisement> getById(int id) {
		return new SuccessDataResult<Advertisement>(this.advertisementDao.getById(id));
	}

}
