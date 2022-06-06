package formation.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.SousTheme;

@Repository
public interface SthemeDAO extends JpaRepository<SousTheme, Integer> {

}
