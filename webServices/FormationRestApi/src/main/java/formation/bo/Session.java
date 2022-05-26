package formation.bo;

import java.time.LocalDate;

public class Session {
	private int idSession;
	private String codeSession;
	private String nom;
	private String description;
	private String statut;
	private String type;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private float prix;
	private int idRespFor;
	private Formation formation;
	private int idFormateur;
	
	public Session() {
		// TODO Auto-generated constructor stub
	}

	public Session(int idSession, String codeSession, String nom, String description, String statut, String type,
			LocalDate dateDebut, LocalDate dateFin, float prix, int idRespFor, Formation formation, int idFormateur) {
		super();
		this.idSession = idSession;
		this.codeSession = codeSession;
		this.nom = nom;
		this.description = description;
		this.statut = statut;
		this.type = type;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prix = prix;
		this.idRespFor = idRespFor;
		this.formation = formation;
		this.idFormateur = idFormateur;
	}

	public int getIdSession() {
		return idSession;
	}

	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}

	public String getCodeSession() {
		return codeSession;
	}

	public void setCodeSession(String codeSession) {
		this.codeSession = codeSession;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getIdRespFor() {
		return idRespFor;
	}

	public void setIdRespFor(int idRespFor) {
		this.idRespFor = idRespFor;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public int getIdFormateur() {
		return idFormateur;
	}

	public void setIdFormateur(int idFormateur) {
		this.idFormateur = idFormateur;
	}
	
}
