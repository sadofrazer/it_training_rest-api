package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import bll.UtilisateurBll;
import bo.Utilisateur;


@Path("/utilisateur")
public class GestionUtilisateur {
	
	private UtilisateurBll bll;
	
	public GestionUtilisateur() {
		bll = new UtilisateurBll();
	}
	
	@GET
	public List<Utilisateur> findAll() {
		System.out.println("Jusqu'ici tout va bien 2");
		return bll.selectAll();
	}
	
	
	@GET @Path("/{idUtilisateur : \\d+}")
	public Utilisateur findById(@PathParam("idUtilisateur") int idUtilisateur) {
		return bll.selectById(idUtilisateur);
	}
}
