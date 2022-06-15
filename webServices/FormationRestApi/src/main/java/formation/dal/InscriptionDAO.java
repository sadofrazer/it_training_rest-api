package formation.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.Inscription;

@Repository
public interface InscriptionDAO extends JpaRepository<Inscription, Integer> {

	public Inscription findByCodeInscription(String codeInscription);
	
}
