package hrms.humanResourcesManagementSystem.core.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import hrms.humanResourcesManagementSystem.core.abstracts.EmailCheckService;

@Service
public class EmailCheckManager implements EmailCheckService {

	

	@Override
	public boolean sendEmail(String email) {
		if(checkIfRealEmail(email)) {
			return true;
		}
		return false;
	}
	
	//Email Rules
	public boolean checkIfRealEmail(String email) {
		String regex = "^[a-z0-9._+-]+@[a-z0-9.-]+.(com|org|net|gov)(.[a-z]{2})?$";
		Pattern pattern = Pattern.compile(regex);
		Matcher control = pattern.matcher(email);
		if(control.matches()) {
			return true;
		}else {
			return false;
		}
	}


}