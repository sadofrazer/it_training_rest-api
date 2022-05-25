package bo;

import java.time.LocalDate;

public class Responsable extends Utilisateur {
	

private String fonction;

public Responsable() {
	super();
	
}

public Responsable(int idUtilisateur, String codeUser, String nom, String prenom, String telephone, String email,
		LocalDate dateNaiss, String numeroSiret, String login, String password, String societe, String statut) {
	super(idUtilisateur, codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, login, password, societe, statut);
	
}

public String getFonction() {
	return fonction;
}

public void setFonction(String fonction) {
	this.fonction = fonction;
}



  
  
}
