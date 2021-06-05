package hrms.humanResourcesManagementSystem.business.validators;

import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.core.validators.abstracts.SystemValidationService;
import hrms.humanResourcesManagementSystem.entities.concretes.Employer;

@Service
public class SystemValidationManager implements SystemValidationService<Employer> {

	@Override
	public boolean systemValidate(Employer entity) {
		
		return true; 
	}

	
}
