package formation.bo;

public class Theme {
	private int idTheme;
	private String codeTheme;
	private String nom;
	private String description;
	private Domaine domaine;
	
	public Theme() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Theme(int idTheme, String codeTheme, String nom, String description, Domaine domaine) {
		super();
		this.idTheme = idTheme;
		this.codeTheme = codeTheme;
		this.nom = nom;
		this.description = description;
		this.domaine = domaine;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	public int getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	public String getCodeTheme() {
		return codeTheme;
	}

	public void setCodeTheme(String codeTheme) {
		this.codeTheme = codeTheme;
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
