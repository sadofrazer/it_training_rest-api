package formation.bo;

public class SousTheme {
	private int idStheme;
	private String codeStheme;
	private String nom;
	private String description;
	private Theme Theme;
	
	public SousTheme() {
		// TODO Auto-generated constructor stub
	}

	public SousTheme(int idStheme, String codeStheme, String nom, String description, Theme Theme) {
		super();
		this.idStheme = idStheme;
		this.codeStheme = codeStheme;
		this.nom = nom;
		this.description = description;
		this.Theme = Theme;
	}

	public int getIdStheme() {
		return idStheme;
	}

	public void setIdStheme(int idStheme) {
		this.idStheme = idStheme;
	}

	public String getCodeStheme() {
		return codeStheme;
	}

	public void setCodeStheme(String codeStheme) {
		this.codeStheme = codeStheme;
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

	public Theme getTheme() {
		return Theme;
	}

	public void setTheme(Theme Theme) {
		this.Theme = Theme;
	}
	
	
}
