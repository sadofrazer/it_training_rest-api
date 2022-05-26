package formation.bll;

import java.util.List;

import formation.bo.SousTheme;
import formation.dal.stheme.SthemeDAO;
import formation.dal.stheme.SthemeJdbcImpl;

public class SthemeBll implements SthemeDAO {
	private SthemeJdbcImpl dao ;
	
	public SthemeBll() {
		dao = new SthemeJdbcImpl();
	}

	@Override
	public SousTheme getSthemeById(int id) {
		if(id>0) {
			return dao.getSthemeById(id);
		}else {
			return null;
		}
	}

	@Override
	public List<SousTheme> selectAll() {
		return dao.selectAll();
	}

}
