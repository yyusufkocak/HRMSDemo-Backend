package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department,Integer> {
	boolean existsByDepartmentName(String department);
}
