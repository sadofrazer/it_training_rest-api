package formation.bo;

import java.time.LocalDate;

public class Utilisateur {
	private int id;
	private String nom;
	private String codeUser;
	private String prenom;
	private String adresse;
	private String telephone;
	private String societe;
	private LocalDate dateNaiss;
	private String numeroSiret;
	private String statut;
	private String login;
	private String password;
	private int typeUser;
	
	public Utilisateur(int id, String nom, String codeUser, String prenom, String adresse, String telephone,
			String societe, LocalDate dateNaiss, String numeroSiret, String statut, String login, String password,
			int typeUser) {
		super();
		this.id = id;
		this.nom = nom;
		this.codeUser = codeUser;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.societe = societe;
		this.dateNaiss = dateNaiss;
		this.numeroSiret = numeroSiret;
		this.statut = statut;
		this.login = login;
		this.password = password;
		this.typeUser = typeUser;
	}

	public Utilisateur() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodeUser() {
		return codeUser;
	}

	public void setCodeUser(String codeUser) {
		this.codeUser = codeUser;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
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

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
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

	public int getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(int typeUser) {
		this.typeUser = typeUser;
	}
	
}
