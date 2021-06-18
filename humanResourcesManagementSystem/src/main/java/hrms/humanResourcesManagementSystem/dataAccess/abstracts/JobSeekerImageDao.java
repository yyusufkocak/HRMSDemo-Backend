package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerImage;

@Repository
public interface JobSeekerImageDao extends JpaRepository<JobSeekerImage, Integer> {
	 List<JobSeekerImage> getByJobSeeker_Id(int jobSeekerid);
}
