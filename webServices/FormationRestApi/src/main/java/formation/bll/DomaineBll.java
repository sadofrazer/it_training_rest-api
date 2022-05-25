package formation.bll;

import java.util.List;

import formation.bo.Domaine;
import formation.domaine.dal.DomaineDAO;
import formation.domaine.dal.DomaineJdbcImpl;

public class DomaineBll implements DomaineDAO{
	private DomaineJdbcImpl dao;
	
	public DomaineBll() {
		// TODO Auto-generated constructor stub
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
