package formation.bo;

public class AttribSalle {
	private int idAttribSalle;
	private String statut;
	private Session session;
	private int idRespFor;
	
	public AttribSalle() {
		// TODO Auto-generated constructor stub
	}

	public AttribSalle(int idAttribSalle, String statut, Session session, int idRespFor) {
		super();
		this.idAttribSalle = idAttribSalle;
		this.statut = statut;
		this.session = session;
		this.idRespFor = idRespFor;
	}

	public int getIdAttribSalle() {
		return idAttribSalle;
	}

	public void setIdAttribSalle(int idAttribSalle) {
		this.idAttribSalle = idAttribSalle;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public int getIdRespFor() {
		return idRespFor;
	}

	public void setIdRespFor(int idRespFor) {
		this.idRespFor = idRespFor;
	}
	
	
}
