package hrms.humanResourcesManagementSystem.core.validators.concretes;

import org.springframework.stereotype.Service;


import hrms.humanResourcesManagementSystem.core.validators.abstracts.EmailValidationService;

@Service
public class EmailValidationManager implements EmailValidationService {



	@Override
	public boolean emailValidate(String email) {
		// TODO Auto-generated method stub
		return true;
	}


	

}
