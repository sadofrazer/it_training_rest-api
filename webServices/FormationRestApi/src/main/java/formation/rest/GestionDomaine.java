package formation.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import formation.bll.DomaineBll;
import formation.bo.Domaine;


@Path("/domaine")
public class GestionDomaine {
	
	@Autowired
	private DomaineBll domaineBll;
	
	public GestionDomaine() {
		//domaineBll = new  DomaineBll();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	@GET
	public List<Domaine> getAll(){
		return domaineBll.selectAll();
	}
	
	@GET @Path("/{id: \\d+}")
	public Domaine getById(@PathParam("id") int id) {
		return domaineBll.getDomaineById(id);
	}
	
}
