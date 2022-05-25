package formation.bo;

import java.time.LocalDate;

public class Emargement {
	private int idEmargement;
	private String codeEmarg;
	private String nom;
	private LocalDate dateSign;
	private String periode;
	private String statut;
	private boolean presenceIsOk;
	private boolean inscription;
	
	public Emargement() {
		// TODO Auto-generated constructor stub
	}

	public Emargement(int idEmargement, String codeEmarg, String nom, LocalDate dateSign, String periode, String statut,
			boolean presenceIsOk, boolean inscription) {
		super();
		this.idEmargement = idEmargement;
		this.codeEmarg = codeEmarg;
		this.nom = nom;
		this.dateSign = dateSign;
		this.periode = periode;
		this.statut = statut;
		this.presenceIsOk = presenceIsOk;
		this.inscription = inscription;
	}

	public int getIdEmargement() {
		return idEmargement;
	}

	public void setIdEmargement(int idEmargement) {
		this.idEmargement = idEmargement;
	}

	public String getCodeEmarg() {
		return codeEmarg;
	}

	public void setCodeEmarg(String codeEmarg) {
		this.codeEmarg = codeEmarg;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDateSign() {
		return dateSign;
	}

	public void setDateSign(LocalDate dateSign) {
		this.dateSign = dateSign;
	}

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public boolean isPresenceIsOk() {
		return presenceIsOk;
	}

	public void setPresenceIsOk(boolean presenceIsOk) {
		this.presenceIsOk = presenceIsOk;
	}

	public boolean isInscription() {
		return inscription;
	}

	public void setInscription(boolean inscription) {
		this.inscription = inscription;
	}
	
	
}
