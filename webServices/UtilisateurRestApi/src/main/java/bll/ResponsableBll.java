package bll;

import java.util.List;

import bo.Responsable;
import dal.ResponsableDAO;
import dal.ResponsableDAOjdbcImpl;



public class ResponsableBll {

private ResponsableDAO dao;
	
	public ResponsableBll() {
		dao = new ResponsableDAOjdbcImpl();
	}
	
	public Responsable selectById(int idUtilisateur) {
		return dao.selectById(idUtilisateur);
	}
	
	public List<Responsable> selectAll() {
		return dao.selectAll();
	}
	
	public void insert(Responsable responsable) {
		dao.insert(responsable);
	}
	
	public void update(Responsable responsable) {
		dao.update(responsable);
	}
	
	public void delete(int idUtilisateur) {
		dao.delete(idUtilisateur);
	}
}