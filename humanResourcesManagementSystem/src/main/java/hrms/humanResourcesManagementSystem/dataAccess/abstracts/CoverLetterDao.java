package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.CoverLetter;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerLanguage;

@Repository
public interface CoverLetterDao extends JpaRepository<CoverLetter,Integer>{
	List<CoverLetter> getAllByJobSeeker_Id(int jobSeekerId);
}
