package formation.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import formation.bo.Domaine;
import formation.dal.domaine.DomaineDAO;
import formation.dal.domaine.DomaineJdbcImpl;

@Service
public class DomaineBll implements DomaineDAO{
	
	@Autowired
	private DomaineJdbcImpl dao;
	
	public DomaineBll() {
		//dao = new DomaineJdbcImpl();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
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
