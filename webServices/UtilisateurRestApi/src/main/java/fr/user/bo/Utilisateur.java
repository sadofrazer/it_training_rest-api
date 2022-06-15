package fr.user.bo;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name= "utilisateur")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="initial")
@DiscriminatorValue(value="U")
public class Utilisateur {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	private TypeUser typeuser;
	
	

	public Utilisateur() {
		
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


	public TypeUser getTypeuser() {
		return typeuser;
	}


	public void setTypeuser(TypeUser typeuser) {
		this.typeuser = typeuser;
	}


	
	
}