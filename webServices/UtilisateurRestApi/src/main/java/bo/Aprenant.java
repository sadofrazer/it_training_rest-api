package bo;

import java.time.LocalDate;

public class Aprenant extends Utilisateur {

private String dernierDiplome;

public Aprenant(int idUtilisateur, String codeUser, String nom, String prenom, String telephone, String email,
		LocalDate dateNaiss, String numeroSiret, String login, String password, String societe) {
	super(idUtilisateur, codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, login, password, societe);
	
}

public String getDernierDiplome() {
	return dernierDiplome;
}

public void setDernierDiplome(String dernierDiplome) {
	this.dernierDiplome = dernierDiplome;
}

}
