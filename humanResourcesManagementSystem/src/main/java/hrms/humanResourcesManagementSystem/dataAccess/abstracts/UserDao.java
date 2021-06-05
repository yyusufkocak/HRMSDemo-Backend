package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hrms.humanResourcesManagementSystem.entities.concretes.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	boolean existsByMail(String email);
}