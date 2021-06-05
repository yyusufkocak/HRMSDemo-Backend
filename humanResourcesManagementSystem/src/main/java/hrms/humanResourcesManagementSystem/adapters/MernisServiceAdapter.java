package hrms.humanResourcesManagementSystem.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.core.validators.abstracts.UserValidationService;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements UserValidationService<JobSeeker> {

	@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
		KPSPublicSoapProxy mernisValidation = new KPSPublicSoapProxy();
		boolean result = true;
		try {
			result = mernisValidation.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalityIdentity()),
					jobSeeker.getFirstName().toUpperCase(), jobSeeker.getLastName().toUpperCase(),
					Integer.parseInt(jobSeeker.getBirthOfYear()));
			

		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return result;
	}
}