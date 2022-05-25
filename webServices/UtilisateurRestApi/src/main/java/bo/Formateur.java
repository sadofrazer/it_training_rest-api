package bo;

import java.time.LocalDate;

public class Formateur extends Utilisateur {
	

private String certification;

public Formateur(int idUtilisateur, String codeUser, String nom, String prenom, String telephone, String email,
		LocalDate dateNaiss, String numeroSiret, String login, String password, String societe) {
	super(idUtilisateur, codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, login, password, societe);
	
}

public String getCertification() {
	return certification;
}

public void setCertification(String certification) {
	this.certification = certification;
}
  
}
