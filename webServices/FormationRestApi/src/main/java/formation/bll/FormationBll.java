package formation.bll;

import java.util.List;

import formation.bo.Formation;
import formation.dal.FormationDAO;
import formation.dal.FormationJdbcImpl;

public class FormationBll implements FormationDAO {
	
	private FormationJdbcImpl dao ;
	
	@Override
	public Formation getFormationById(int id) {
		if(id>0) {
			return dao.getFormationById(id);
		}else {
			return null;
		}
	}

	@Override
	public List<Formation> selectAllFormations() {
		return dao.selectAllFormations();
	}

	@Override
	public boolean insertFormation(Formation formation) {
		if(formation.getIdRespCat()!=0 && formation.getStheme()!=null) {
			dao.insertFormation(formation);
			return true;
		}else {
			System.err.println("Impossible d'ajouter cette formation car ID RespCat ou ID Theme est pas valide");
			return false;
		}
	}

	@Override
	public boolean updateFormation(Formation formation) {
		if(formation.getIdRespCat()!=0 && formation.getStheme()!=null) {
			dao.updateFormation(formation);
			return true;
		}else {
			System.err.println("Impossible d'ajouter cette formation car ID RespCat ou ID Theme est pas valide");
			return false;
		}
	}

	@Override
	public boolean deleteFormation(int id) {
		if(id>0) {
			dao.deleteFormation(id);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Formation> searchByParams(String codeForm, String nomForm, String nomSthem) {
		return dao.searchByParams(codeForm, nomForm, nomSthem);
	}


	@Override
	public boolean idExist(int id) {
		if(id>0) {
			return dao.idExist(id);
		}else {
			return false;
		}
	}

}
