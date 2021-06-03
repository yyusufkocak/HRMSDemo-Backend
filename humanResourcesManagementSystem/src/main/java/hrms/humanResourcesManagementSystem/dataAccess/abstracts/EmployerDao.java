package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.Employer;



@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {
	boolean existsByMail(String email);
}