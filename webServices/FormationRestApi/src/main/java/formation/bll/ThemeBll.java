package formation.bll;

import java.util.List;

import formation.bo.Theme;
import formation.theme.dal.ThemeDAO;
import formation.theme.dal.ThemeJdbcImpl;

public class ThemeBll implements ThemeDAO {
	private ThemeJdbcImpl dao;
	
	public ThemeBll() {
		dao = new ThemeJdbcImpl();
	}
	@Override
	public Theme getThemeById(int id) {
		if(id>0) {
			return dao.getThemeById(id);
		}else {
			return null;
		}
	}

	@Override
	public List<Theme> selectAll() {
		return dao.selectAll();
	}

}
