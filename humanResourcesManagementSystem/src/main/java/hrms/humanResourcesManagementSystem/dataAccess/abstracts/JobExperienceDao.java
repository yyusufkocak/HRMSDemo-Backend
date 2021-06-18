package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.JobExperience;

@Repository
public interface JobExperienceDao extends JpaRepository<JobExperience,Integer>{
	List<JobExperience> getAllByJobSeeker_IdOrderByEndingDateDesc(int jobSeekerId);
}
