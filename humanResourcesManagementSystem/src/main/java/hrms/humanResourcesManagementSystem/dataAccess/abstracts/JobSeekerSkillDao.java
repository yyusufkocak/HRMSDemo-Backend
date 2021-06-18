package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerSkill;

@Repository
public interface JobSeekerSkillDao extends JpaRepository<JobSeekerSkill,Integer>{

}
