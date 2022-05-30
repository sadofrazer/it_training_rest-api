package formation.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import formation.bll.SthemeBll;
import formation.bo.SousTheme;

@Path("/stheme")
public class GestionStheme {
	
	@Autowired
	private SthemeBll sthemeBll;
	
	public GestionStheme() {
		//sthemeBll = new SthemeBll();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	@GET
	public List<SousTheme> getAll(){
		return sthemeBll.selectAll();
	}
	@GET @Path("/{id: \\d+}")
	public SousTheme getById(@PathParam("id") int id) {
		return sthemeBll.getSthemeById(id);
	}	
}

