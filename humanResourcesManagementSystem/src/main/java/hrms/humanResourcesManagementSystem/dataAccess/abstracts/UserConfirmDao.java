package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.UserConfirm;




@Repository
public interface UserConfirmDao extends JpaRepository<UserConfirm,Integer> {
	
}
