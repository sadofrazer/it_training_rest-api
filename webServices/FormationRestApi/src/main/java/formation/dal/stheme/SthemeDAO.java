package formation.dal.stheme;

import java.util.List;

import formation.bo.SousTheme;



public interface SthemeDAO {
	public SousTheme getSthemeById(int id);
	public List<SousTheme> selectAll();
}
