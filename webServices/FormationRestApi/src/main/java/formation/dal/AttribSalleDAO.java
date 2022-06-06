package formation.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.AttribSalle;

@Repository
public interface AttribSalleDAO extends JpaRepository<AttribSalle, Integer>{

}
