package formation.dal.domaine;

import java.util.List;

import formation.bo.Domaine;


public interface DomaineDAO {
	public Domaine getDomaineById(int id);
	public List<Domaine> selectAll();
}
