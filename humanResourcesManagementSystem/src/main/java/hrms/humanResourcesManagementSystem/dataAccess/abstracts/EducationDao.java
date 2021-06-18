package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.Education;

@Repository
public interface EducationDao extends JpaRepository<Education,Integer> {
	boolean existsByEducationName(String education);
}
