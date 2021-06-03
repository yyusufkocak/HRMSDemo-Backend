package hrms.humanResourcesManagementSystem.core.abstracts;

public interface ValidationService<T> {

	boolean checkIfRealPerson(T data);
}