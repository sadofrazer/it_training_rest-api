package formation.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import formation.bll.SthemeBll;
import formation.bo.SousTheme;

@Path("/stheme")
public class GestionStheme {
	private SthemeBll sthemeBll;
	
	public GestionStheme() {
		sthemeBll = new SthemeBll();
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

