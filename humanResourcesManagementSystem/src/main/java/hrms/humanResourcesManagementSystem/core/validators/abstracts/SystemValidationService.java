package hrms.humanResourcesManagementSystem.core.validators.abstracts;

public interface SystemValidationService<T> {
	boolean systemValidate(T entity);

}
