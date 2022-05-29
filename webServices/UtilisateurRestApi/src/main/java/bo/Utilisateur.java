package bo;

import java.time.LocalDate;
public class Utilisateur {
	
	private int idUtilisateur;
	private String codeUser;
	private String nom;
	private String prenom;
	private String telephone;
	private String email;
	private LocalDate  dateNaiss;
	private String numeroSiret;
	private String login;
	private String password;
	private String societe;
	private String statut;
	
	
	public Utilisateur(String codeUser, String nom, String prenom, String telephone, String email, LocalDate dateNaiss,
			String numeroSiret, String login, String password, String societe) {
		super();
		this.codeUser = codeUser;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.dateNaiss = dateNaiss;
		this.numeroSiret = numeroSiret;
		this.login = login;
		this.password = password;
		this.societe = societe;
	}


	public Utilisateur(int idUtilisateur, String codeUser, String nom, String prenom, String telephone, String email,
				LocalDate dateNaiss, String numeroSiret, String login, String password, String societe, String statut) {
			super();
			this.idUtilisateur = idUtilisateur;
			this.codeUser = codeUser;
			this.nom = nom;
			this.prenom = prenom;
			this.telephone = telephone;
			this.email = email;
			this.dateNaiss = dateNaiss;
			this.numeroSiret = numeroSiret;
			this.login = login;
			this.password = password;
			this.societe = societe;
			this.statut = statut;
			
}

public Utilisateur(){
	
}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getCodeUser() {
		return codeUser;
	}

	public void setCodeUser(String codeUser) {
		this.codeUser = codeUser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(LocalDate dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getNumeroSiret() {
		return numeroSiret;
	}

	public void setNumeroSiret(String numeroSiret) {
		this.numeroSiret = numeroSiret;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}
	
}