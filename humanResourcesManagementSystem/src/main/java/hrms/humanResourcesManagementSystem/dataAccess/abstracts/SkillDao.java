package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import hrms.humanResourcesManagementSystem.entities.concretes.Skill;

@Repository
public interface SkillDao extends JpaRepository<Skill,Integer> {
	boolean existsBySkillName(String skill);
}
