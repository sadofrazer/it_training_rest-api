package formation.bo;

public class Formation {
	private int idFormation;
	private String codeForm;
	private String nom;
	private String description;
	private SousTheme stheme;
	private int idRespCat;
	
	public Formation() {
		// TODO Auto-generated constructor stub
	}

	public Formation(int idFormation, String codeForm, String nom, String description, SousTheme stheme,
			int idRespCat) {
		super();
		this.idFormation = idFormation;
		this.codeForm = codeForm;
		this.nom = nom;
		this.description = description;
		this.stheme = stheme;
		this.idRespCat = idRespCat;
	}
	
	public Formation(String codeForm, String nom, String description, SousTheme stheme,
			int idRespCat) {
		super();
		this.codeForm = codeForm;
		this.nom = nom;
		this.description = description;
		this.stheme = stheme;
		this.idRespCat = idRespCat;
	}

	public int getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}

	public String getCodeForm() {
		return codeForm;
	}

	public void setCodeForm(String codeForm) {
		this.codeForm = codeForm;
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

	public SousTheme getStheme() {
		return stheme;
	}

	public void setStheme(SousTheme stheme) {
		this.stheme = stheme;
	}

	public int getIdRespCat() {
		return idRespCat;
	}

	public void setIdRespCat(int idRespCat) {
		this.idRespCat = idRespCat;
	}
	
}
