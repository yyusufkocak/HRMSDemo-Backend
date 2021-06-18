package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import hrms.humanResourcesManagementSystem.entities.concretes.Language;

@Repository
public interface LanguageDao extends JpaRepository<Language,Integer> {
	boolean existsByLanguageName(String language);
}
