package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.CoverLetter;
import hrms.humanResourcesManagementSystem.entities.concretes.Link;

@Repository
public interface LinkDao extends JpaRepository<Link,Integer> {
	List<Link> getAllByJobSeeker_Id(int jobSeekerId);
}
