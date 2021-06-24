package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerEducation;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerSkill;

@Repository
public interface JobSeekerSkillDao extends JpaRepository<JobSeekerSkill,Integer>{
	List<JobSeekerSkill> getAllByJobSeeker_Id(int jobSeekerId);
}
