package formation.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.bo.Salle;

public interface SalleDAO extends JpaRepository<Salle, Integer>{

}
