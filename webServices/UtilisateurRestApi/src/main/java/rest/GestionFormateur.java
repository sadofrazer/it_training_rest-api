package rest;

import java.time.LocalDate;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import bll.FormateurBll;

import bo.Formateur;


@Path("/formateur")
public class GestionFormateur {

private FormateurBll bll;
	
	public GestionFormateur() {
		bll = new FormateurBll();
	}
	
	@GET
	public List<Formateur> findAll() {
		return bll.selectAll();
	}
	
	
	@GET @Path("/{idUtilisateur : \\d+}")
	public Formateur findById(@PathParam("idUtilisateur") int idUtilisateur) {
		return bll.selectById(idUtilisateur);
	}
	@POST
	public Formateur ajouterFormateur(
			@FormParam("codeUser") String codeUser,
			@FormParam("nom") String nom,
			@FormParam("prenom") String prenom,
			@FormParam("telephone") String telephone,
			@FormParam("email") String email,
			@FormParam("dateNaiss") String dateNaiss,
			@FormParam("numeroSiret") String numeroSiret,
			@FormParam("login") String login,
			@FormParam("password") String password,
			@FormParam("societe") String societe,
			@FormParam("statut") String statut,
			@FormParam("certifications") String certifications){
		
		Formateur ps = new Formateur( 0, codeUser, nom, prenom, telephone, email, LocalDate.now(), numeroSiret, login, password, societe, statut);
		bll.insert(ps);
		return ps;
	}
	@PUT @Path("/{idUtilisateur : \\d+}")
	public Formateur modifierFormateur(
			@PathParam("idUtilisateur") int idUtilisateur,
			@FormParam("codeUser") String codeUser,
			@FormParam("nom") String nom,
			@FormParam("prenom") String prenom,
			@FormParam("telephone") String telephone,
			@FormParam("email") String email,
			@FormParam("dateNaiss") String dateNaiss,
			@FormParam("numeroSiret") String numeroSiret,
			@FormParam("login") String login,
			@FormParam("password") String password,
			@FormParam("societe") String societe,
			@FormParam("statut") String statut,
			@FormParam("certifications") String certifications) {
		
		    Formateur ps = bll.selectById(idUtilisateur);
		    ps.setCodeUser(codeUser);
			ps.setNom(nom);
			ps.setPrenom(prenom);
			ps.setTelephone(telephone);
			ps.setEmail(email);
			ps.setDateNaiss(LocalDate.now());
			ps.setNumeroSiret(numeroSiret);
			ps.setLogin(login);
			ps.setPassword(password);
			ps.setSociete(societe);
			ps.setStatut(statut);
			ps.setCertification(certifications);
			
			
			
			bll.update(ps);
			return ps;
}
	@DELETE @Path("/{idUtilisateur : \\d+}")
	public void supprimerFormateur(@PathParam("idUtilisateur") int idUtilisateur) {
		bll.delete(idUtilisateur);
	}
}
