package bo;

import java.time.LocalDate;

public class Apprenant extends Utilisateur {

private String dernierDiplome;

public Apprenant(){
	
}

public Apprenant(int idUtilisateur, String codeUser, String nom, String prenom, String telephone, String email,
		LocalDate dateNaiss, String numeroSiret, String login, String password, String societe, String statut) {
	super(idUtilisateur, codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, login, password, societe, statut);
	
}

public String getDernierDiplome() {
	return dernierDiplome;
}

public void setDernierDiplome(String dernierDiplome) {
	this.dernierDiplome = dernierDiplome;
}

}
