package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.CoverLetter;

@Repository
public interface CoverLetterDao extends JpaRepository<CoverLetter,Integer>{

}
