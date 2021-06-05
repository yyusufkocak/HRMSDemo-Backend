package hrms.humanResourcesManagementSystem.core.constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;





@Service
public class EmailRegexCheckTool   {

	
	public static boolean checkEmail(String email) {
		String regex = "^[a-z0-9._+-]+@[a-z0-9.-]+.(com|org|net|gov)(.[a-z]{2})?$";
		Pattern pattern = Pattern.compile(regex);
		Matcher control = pattern.matcher(email);
		if (control.matches()) {
			return true;
		} else {
			return false;
		}

	}

}