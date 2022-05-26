package formation.dal;

import java.util.List;

import formation.bo.Formation;

public interface FormationDAO {
	public Formation getFormationById(int id);
	public List<Formation> selectAllFormations();
	public boolean insertFormation(Formation formation);
	public boolean updateFormation(Formation formation);
	public boolean deleteFormation(int id);
	public List<Formation> searchByParams(String codeForm, String nomForm, String nomSthem);
	public boolean idExist(int id);
}
