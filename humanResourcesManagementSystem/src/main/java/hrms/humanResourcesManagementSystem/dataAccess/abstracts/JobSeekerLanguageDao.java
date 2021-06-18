package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerLanguage;

@Repository
public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage,Integer>{

}
