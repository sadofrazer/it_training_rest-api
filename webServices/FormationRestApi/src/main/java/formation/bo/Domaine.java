package formation.bo;

public class Domaine {
	private int idDomaine;
	private String codeDom;
	private String nom;
	private String description;
	
	public Domaine() {
		// TODO Auto-generated constructor stub
	}

	public Domaine(int idDomaine, String codeDom, String nom, String description) {
		super();
		this.idDomaine = idDomaine;
		this.codeDom = codeDom;
		this.nom = nom;
		this.description = description;
	}

	public int getIdDomaine() {
		return idDomaine;
	}

	public void setIdDomaine(int idDomaine) {
		this.idDomaine = idDomaine;
	}

	public String getCodeDom() {
		return codeDom;
	}

	public void setCodeDom(String codeDom) {
		this.codeDom = codeDom;
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
	
	
}
