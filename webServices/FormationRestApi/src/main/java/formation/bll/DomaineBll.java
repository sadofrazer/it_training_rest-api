package formation.bll;

import java.util.List;

import formation.bo.Domaine;
import formation.dal.domaine.DomaineDAO;
import formation.dal.domaine.DomaineJdbcImpl;

public class DomaineBll implements DomaineDAO{
	private DomaineJdbcImpl dao;
	
	public DomaineBll() {
		dao = new DomaineJdbcImpl();
	}
	@Override
	public Domaine getDomaineById(int id) {
		if(id>0) {
			return dao.getDomaineById(id);
		}
		else {
			return null;
		}
	}

	@Override
	public List<Domaine> selectAll() {
		return dao.selectAll();
	}
	
}
