package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.Resume;

@Repository
public interface ResumeDao extends JpaRepository<Resume,Integer>{
	

	
	Resume getByJobSeeker_Id(int jobSeekerId);
	
}
