package bo;

import java.time.LocalDate;

public class Responsable extends Utilisateur {
	

private String statut;

public Responsable(int idUtilisateur, String codeUser, String nom, String prenom, String telephone, String email,
		LocalDate dateNaiss, String numeroSiret, String login, String password, String societe) {
	super(idUtilisateur, codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, login, password, societe);
	
}

public String getStatut() {
	return statut;
}

public void setStatut(String statut) {
	this.statut = statut;
}
  
  
}
