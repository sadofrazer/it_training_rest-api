package formation.bo;

import java.time.LocalDate;

public class Inscription {
	private int idInscription;
	private String codeInscription;
	private String statut;
	private LocalDate dateInscription;
	private int idApprenant;
	private Session session;
	
	public Inscription() {
		// TODO Auto-generated constructor stub
	}

	public Inscription(int idInscription, String codeInscription, String statut, LocalDate dateInscription,
			int idApprenant, Session session) {
		super();
		this.idInscription = idInscription;
		this.codeInscription = codeInscription;
		this.statut = statut;
		this.dateInscription = dateInscription;
		this.idApprenant = idApprenant;
		this.session = session;
	}

	public int getIdInscription() {
		return idInscription;
	}

	public void setIdInscription(int idInscription) {
		this.idInscription = idInscription;
	}

	public String getCodeInscription() {
		return codeInscription;
	}

	public void setCodeInscription(String codeInscription) {
		this.codeInscription = codeInscription;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public LocalDate getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(LocalDate dateInscription) {
		this.dateInscription = dateInscription;
	}

	public int getIdApprenant() {
		return idApprenant;
	}

	public void setIdApprenant(int idApprenant) {
		this.idApprenant = idApprenant;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	
}
