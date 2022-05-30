package formation.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import formation.bo.SousTheme;
import formation.dal.stheme.SthemeDAO;
import formation.dal.stheme.SthemeJdbcImpl;

@Service
public class SthemeBll implements SthemeDAO {
	
	@Autowired
	private SthemeJdbcImpl dao ;
	
	public SthemeBll() {
		//dao = new SthemeJdbcImpl();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
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
