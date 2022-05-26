package formation.dal.theme;

import java.util.List;

import formation.bo.Theme;


public interface ThemeDAO {
	public Theme getThemeById(int id);
	public List<Theme> selectAll();
}
