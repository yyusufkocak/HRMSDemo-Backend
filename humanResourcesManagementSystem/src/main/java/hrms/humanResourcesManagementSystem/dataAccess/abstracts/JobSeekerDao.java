package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.JobSeeker;

@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{
		
	boolean existsByNationalityIdentity(String nationalityIdentity);
	boolean existsByMail(String mail);
	
		
}