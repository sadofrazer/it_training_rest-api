package bo;

import java.time.LocalDate;

public class Formateur extends Utilisateur {
	

private String certifications;

public Formateur(int idUtilisateur, String codeUser, String nom, String prenom, String telephone, String email,
		LocalDate dateNaiss, String numeroSiret, String login, String password, String societe, String statut) {
	super(idUtilisateur, codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, login, password, societe, statut);
	
}


	


public String getCertification() {
	return certifications;
}

public void setCertification(String certifications) {
	this.certifications = certifications;
}
  
}
