package formation.bll;

import java.util.List;

import formation.bo.Formation;
import formation.dal.FormationDAO;
import formation.dal.FormationJdbcImpl;

public class FormationBll implements FormationDAO {
	
	private FormationJdbcImpl dao ;
	
	public FormationBll() {
		dao = new FormationJdbcImpl();
	}
	
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
		
		if(formation.getIdRespCat()!=0 && formation.getStheme()!=null && formation.getCodeForm()!=null && !dao.codeExist(formation.getCodeForm())) {
			return dao.insertFormation(formation);
			//return true;
		}else {
			System.err.println("Impossible d'ajouter cette formation car ID RespCat ou ID Theme est pas valide ou alors ce Code Formation existe déja");
			return false;
		}
	}

	@Override
	public boolean updateFormation(Formation formation) {
		//System.out.println(formation.getIdRespCat() +"    " + formation.getStheme().getIdStheme() + "     " +formation.getCodeForm());
		if(formation.getIdRespCat()!=0 && formation.getStheme()!=null && formation.getCodeForm()!=null) {
			return dao.updateFormation(formation);
		}else {
			System.err.println("Impossible de modifier cette formation d'Id : " + formation.getIdFormation());
			return false;
		}
	}

	@Override
	public boolean deleteFormation(int id) {
		if(id>0 && idExist(id)) {
			return dao.deleteFormation(id);
			//return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Formation> searchByParams(String codeForm, String nomForm, String nomStheme) {
		if(codeForm != null && nomForm != null && nomStheme !=null) {
			return dao.searchByParams(codeForm, nomForm, nomStheme);
		}else {
			return null;
		}
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
