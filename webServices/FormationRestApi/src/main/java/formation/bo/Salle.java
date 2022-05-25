package formation.bo;

public class Salle {
	private int idSalle;
	private String codeSalle;
	private String nom;
	private String statut;
	private int nbrePlaces;
	private String ville;
	private String adresse;
	private String commentaires;
	
	public Salle() {
		// TODO Auto-generated constructor stub
	}

	public Salle(int idSalle, String codeSalle, String nom, String statut, int nbrePlaces, String ville, String adresse,
			String commentaires) {
		super();
		this.idSalle = idSalle;
		this.codeSalle = codeSalle;
		this.nom = nom;
		this.statut = statut;
		this.nbrePlaces = nbrePlaces;
		this.ville = ville;
		this.adresse = adresse;
		this.commentaires = commentaires;
	}

	public int getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	public String getCodeSalle() {
		return codeSalle;
	}

	public void setCodeSalle(String codeSalle) {
		this.codeSalle = codeSalle;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public int getNbrePlaces() {
		return nbrePlaces;
	}

	public void setNbrePlaces(int nbrePlaces) {
		this.nbrePlaces = nbrePlaces;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	
	
}
