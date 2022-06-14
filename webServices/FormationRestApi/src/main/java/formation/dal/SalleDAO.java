package formation.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.Salle;

@Repository
public interface SalleDAO extends JpaRepository<Salle, Integer>{
	
	public Salle findByCodeSalle(String codeSalle);
}
