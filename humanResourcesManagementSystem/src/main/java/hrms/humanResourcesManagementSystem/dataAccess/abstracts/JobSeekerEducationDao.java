package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerEducation;

@Repository
public interface JobSeekerEducationDao extends JpaRepository<JobSeekerEducation ,Integer> {
	List<JobSeekerEducation> getAllByJobSeeker_IdOrderByEndingDateDesc(int jobSeekerId);
}
