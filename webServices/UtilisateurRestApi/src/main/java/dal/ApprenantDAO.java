package dal;

import java.util.List;

import bo.Apprenant;


public interface ApprenantDAO {

	Apprenant selectById(int idUtilisateur);

	List<Apprenant> selectAll();

	void insert(Apprenant apprenant);

	void update(Apprenant apprenant);

	void delete(int idUtilisateur);

}
