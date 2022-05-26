package formation.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import formation.bll.ThemeBll;
import formation.bo.Theme;

@Path("/theme")
public class GestionTheme {
	private ThemeBll themeBll;
	
	public GestionTheme() {
		themeBll = new ThemeBll();
	}
	
	@GET
	public List<Theme> getAll(){
		return themeBll.selectAll();
	}
	
	@GET @Path("/{id: \\d+}")
	public Theme getById(@PathParam("id") int id) {
		return themeBll.getThemeById(id);
	}
}
