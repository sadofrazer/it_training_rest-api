package formation.bo;

public class CheckLogistic {
	private int idCheck;
	private String codeCheck;
	private String statut;
	private boolean salleIsOk;
	private boolean toolsIsOk;
	private String commentaires;
	private int idRespFor;
	private Session session;
	
	public CheckLogistic() {
		// TODO Auto-generated constructor stub
	}

	public CheckLogistic(int idCheck, String codeCheck, String statut, boolean salleIsOk, boolean toolsIsOk,
			String commentaires, int idRespFor, Session session) {
		super();
		this.idCheck = idCheck;
		this.codeCheck = codeCheck;
		this.statut = statut;
		this.salleIsOk = salleIsOk;
		this.toolsIsOk = toolsIsOk;
		this.commentaires = commentaires;
		this.idRespFor = idRespFor;
		this.session = session;
	}

	public int getIdCheck() {
		return idCheck;
	}

	public void setIdCheck(int idCheck) {
		this.idCheck = idCheck;
	}

	public String getCodeCheck() {
		return codeCheck;
	}

	public void setCodeCheck(String codeCheck) {
		this.codeCheck = codeCheck;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public boolean isSalleIsOk() {
		return salleIsOk;
	}

	public void setSalleIsOk(boolean salleIsOk) {
		this.salleIsOk = salleIsOk;
	}

	public boolean isToolsIsOk() {
		return toolsIsOk;
	}

	public void setToolsIsOk(boolean toolsIsOk) {
		this.toolsIsOk = toolsIsOk;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	public int getIdRespFor() {
		return idRespFor;
	}

	public void setIdRespFor(int idRespFor) {
		this.idRespFor = idRespFor;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
}
