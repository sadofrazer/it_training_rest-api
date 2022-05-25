package bll;

import java.util.List;

import bo.Apprenant;
import dal.ApprenantDAO;
import dal.ApprenantDAOjdbcImpl;



public class ApprenantBll {

	 private ApprenantDAO dao;
		
		public ApprenantBll() {
			dao = new ApprenantDAOjdbcImpl();
		}
		
		public Apprenant selectById(int idUtilisateur) {
			return dao.selectById(idUtilisateur);
		}
		
		public List<Apprenant> selectAll() {
			return dao.selectAll();
		}
		
		public void insert(Apprenant apprenant) {
			dao.insert(apprenant);
		}
		
		public void update(Apprenant apprenant) {
			dao.update(apprenant);
		}
		
		public void delete(int idUtilisateur) {
			dao.delete(idUtilisateur);
		}
	}
