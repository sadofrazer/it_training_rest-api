package dal;

import java.util.List;

import bo.Formateur;

public interface FormateurDAO {

	Formateur selectById(int idUtilisateur);

	List<Formateur> selectAll();

	void insert(Formateur formateur);

	void update(Formateur formateur);

	void delete(int idUtilisateur);

}
