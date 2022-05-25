package bll;

import java.util.List;

import bo.Utilisateur;
import dal.UtilisateurDAO;
import dal.UtilisateurDAOjdbcImpl;


public class UtilisateurBll {
 private UtilisateurDAO dao;
	
	public UtilisateurBll() {
		dao = new UtilisateurDAOjdbcImpl();
	}
	
	public Utilisateur selectById(int idUtilisateur) {
		return dao.selectById(idUtilisateur);
	}
	
	public List<Utilisateur> selectAll() {
		return dao.selectAll();
	}
	
	public void insert(Utilisateur utilisateur) {
		dao.insert(utilisateur);
	}
	
	public void update(Utilisateur utilisateur) {
		dao.update(utilisateur);
	}
	
	public void delete(int idUtilisateur) {
		dao.delete(idUtilisateur);
	}
}
