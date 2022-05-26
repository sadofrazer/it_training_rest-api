package formation.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import formation.bll.FormationBll;
import formation.bll.SthemeBll;
import formation.bo.Formation;

@Path("/formation")
public class GestionFormation {
	private FormationBll formationBll;
	private SthemeBll sthemeBll;
	
	public GestionFormation() {
		formationBll = new FormationBll();
		sthemeBll=new SthemeBll();
	}
	
	@GET
	public List<Formation> getAllFormations(){
		return formationBll.selectAllFormations();
	}
	
	@GET @Path("/{id: \\d+}")
	public Formation getFormationById(@PathParam("id") int id) {
		if(id>0) {
			return formationBll.getFormationById(id);
		}else {
			return null;
		}
	}
	
	
	@POST @Path("/search")
	public List<Formation> SearchFormationByParams(@FormParam("codeForm") String CodeForm, @FormParam("nomForm") String nomForm, @FormParam("nomStheme") String nomStheme) {
		return formationBll.searchByParams(CodeForm, nomForm, nomStheme);
	}
	
	@POST
	public boolean insertFormation(@FormParam("codeForm") String code, @FormParam("nomForm") String nom, 
			@FormParam("description") String description, @FormParam("idStheme") String stheme, @FormParam("idRespCat") String respCat) {
		
		int idStheme =(stheme!=null)? Integer.parseInt(stheme):0;
		int idRespCat =(respCat!=null)? Integer.parseInt(respCat):0;
		Formation formation = new Formation(code, nom, description,sthemeBll.getSthemeById(idStheme), idRespCat);
		return formationBll.insertFormation(formation);
		
	}
	
	@PUT @Path("/{id: \\d+}")
	public boolean updateFormation(@PathParam("id") int id, @FormParam("codeForm") String codeForm, @FormParam("nomForm") String nom, 
			@FormParam("description") String description, @FormParam("idStheme") String stheme, @FormParam("idRespCat") String respCat) {
		
		if (formationBll.idExist(id)) {
			
			Formation formation = formationBll.getFormationById(id);
			int idStheme =(stheme!=null)? Integer.parseInt(stheme):0;
			int idRespCat =(respCat!=null)? Integer.parseInt(respCat):0;
			formation.setCodeForm(codeForm);
			formation.setDescription(description);
			formation.setNom(nom);
			formation.setStheme(sthemeBll.getSthemeById(idStheme));
			formation.setIdRespCat(idRespCat);
			
			return formationBll.updateFormation(formation);
		}else {
			return false;
		}
		
	}
	
	@DELETE @Path("/{id: \\d+}")
	public boolean deleteFormation(@PathParam("id") int id) {
		if (formationBll.idExist(id)) {
			return formationBll.deleteFormation(id);
		}else return false;
	}
}
