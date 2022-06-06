package formation.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.Session;

@Repository
public interface SessionDAO extends JpaRepository<Session, Integer> {

}
