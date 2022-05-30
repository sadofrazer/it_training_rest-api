package formation.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import formation.bo.Theme;
import formation.dal.theme.ThemeDAO;
import formation.dal.theme.ThemeJdbcImpl;


@Service
public class ThemeBll implements ThemeDAO {
	
	@Autowired
	private ThemeJdbcImpl dao;
	
	public ThemeBll() {
		//dao = new ThemeJdbcImpl();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
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
