package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.Advertisement;

@Repository
public interface AdvertisementDao extends JpaRepository<Advertisement, Integer> {
	
 List<Advertisement> getByIsActiveTrue(); //Sistemdeki tüm aktif iş ilanları listelenmesi
   
   List<Advertisement> getByOrderByStartingDate(); //Sistemdeki tüm aktif iş ilanları tarihe göre listelenebilmelidir.
   
   List<Advertisement> getByIsActiveTrueAndEmployer_Id(int employerId); //Sistemde bir firmaya ait tüm aktif iş ilanları listelenmesi

}
