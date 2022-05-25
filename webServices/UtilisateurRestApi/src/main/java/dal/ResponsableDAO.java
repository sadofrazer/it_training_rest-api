package dal;

import java.util.List;

import bo.Responsable;

public interface ResponsableDAO {

	Responsable selectById(int idUtilisateur);

	List<Responsable> selectAll();

	void insert(Responsable responsable);

	void update(Responsable responsable);

	void delete(int idUtilisateur);

}
