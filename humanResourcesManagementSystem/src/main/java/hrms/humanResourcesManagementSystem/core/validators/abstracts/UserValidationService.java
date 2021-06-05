package hrms.humanResourcesManagementSystem.core.validators.abstracts;

public interface UserValidationService<T> {

	boolean checkIfRealPerson(T data);
}