package bll;

import java.util.List;

import bo.Formateur;
import dal.FormateurDAO;
import dal.FormmteurDAOjdbcImpl;



public class FormateurBll {
	 private FormateurDAO dao;
		
		public FormateurBll() {
			dao = new FormmteurDAOjdbcImpl();
		}
		
		public Formateur selectById(int idUtilisateur) {
			return dao.selectById(idUtilisateur);
		}
		
		public List<Formateur> selectAll() {
			return dao.selectAll();
		}
		
		public void insert(Formateur formateur) {
			dao.insert(formateur);
		}
		
		public void update(Formateur formateur) {
			dao.update(formateur);
		}
		
		public void delete(int idUtilisateur) {
			dao.delete(idUtilisateur);
		}
	}