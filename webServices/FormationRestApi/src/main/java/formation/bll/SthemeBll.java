package formation.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.bo.SousTheme;
import formation.dal.SthemeDAO;


@Service
public class SthemeBLL {
	@Autowired
	private SthemeDAO dao;
	
	public List<SousTheme> selectAll() {
		return dao.findAll();
	}
	
	public SousTheme selectById(int id) {
		if(exist(id)) {
			return dao.findById(id).get();
		}else {
			return null;
		}
	}
	
	public boolean exist(int id) {
		return dao.existsById(id);
	}
}
