package formation.bo;

public class Evaluation {
	private int idEvaluation;
	private String codeEvaluation;
	private String nom;
	private String dateEval;
	private String description;
	private String statut;
	private boolean EvalIsOk;
	private boolean inscription;
	
	public Evaluation() {
		// TODO Auto-generated constructor stub
	}

	public Evaluation(int idEvaluation, String codeEvaluation, String nom, String dateEval, String description,
			String statut, boolean evalIsOk, boolean inscription) {
		super();
		this.idEvaluation = idEvaluation;
		this.codeEvaluation = codeEvaluation;
		this.nom = nom;
		this.dateEval = dateEval;
		this.description = description;
		this.statut = statut;
		EvalIsOk = evalIsOk;
		this.inscription = inscription;
	}

	public int getIdEvaluation() {
		return idEvaluation;
	}

	public void setIdEvaluation(int idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

	public String getCodeEvaluation() {
		return codeEvaluation;
	}

	public void setCodeEvaluation(String codeEvaluation) {
		this.codeEvaluation = codeEvaluation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDateEval() {
		return dateEval;
	}

	public void setDateEval(String dateEval) {
		this.dateEval = dateEval;
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

	public boolean isEvalIsOk() {
		return EvalIsOk;
	}

	public void setEvalIsOk(boolean evalIsOk) {
		EvalIsOk = evalIsOk;
	}

	public boolean isInscription() {
		return inscription;
	}

	public void setInscription(boolean inscription) {
		this.inscription = inscription;
	}
	
}
