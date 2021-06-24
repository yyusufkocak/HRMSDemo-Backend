package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.StaffUser;

@Repository
public interface StaffUserDao extends JpaRepository<StaffUser,Integer> {

}
