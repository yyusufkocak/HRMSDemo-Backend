package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.City;

@Repository
public interface CityDao extends JpaRepository<City,Integer>{
	boolean existsByCityName(String city);
}
