package formation.dal.stheme;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import formation.bo.SousTheme;
import formation.bo.Theme;
import formation.dal.ConnectionProvider;
import formation.dal.theme.ThemeJdbcImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class SthemeJdbcImpl implements SthemeDAO{
	
	public SthemeJdbcImpl() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	@Autowired
    private ThemeJdbcImpl themeDal;
	
	@Override
	public SousTheme getSthemeById(int id) {
		
		// = new ThemeJdbcImpl();
		SousTheme stheme = null;
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM SousTheme WHERE idStheme = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				stheme = new SousTheme();
				stheme.setIdStheme(rs.getInt("idStheme"));
				stheme.setCodeStheme(rs.getString("codeSthem"));
				stheme.setNom(rs.getString("nom"));
				stheme.setDescription(rs.getString("description"));
				if (rs.getInt("idTheme")>0) {
					stheme.setTheme(themeDal.getThemeById(rs.getInt("idTheme")));
				}else {
					stheme.setTheme(null);
				}
			}else {
				System.err.println("Aucun Sous Theme correspondant à l'ID :" + id +" n'a été trouvé en base de données");
			}
			cnx.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return stheme;
	}
	
	

	@Override
	public List<SousTheme> selectAll() {
		
		//ThemeJdbcImpl themeBll = new ThemeJdbcImpl();
		List<SousTheme> sThemes = new ArrayList<SousTheme>();
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM SousTheme");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idStheme = rs.getInt("idStheme");
				String codeSthem = rs.getString("codeSthem");
				String nom = rs.getString("nom");
				String description = rs.getString("description");
				Theme Theme =  themeDal.getThemeById(rs.getInt("idTheme"));
				sThemes.add(new SousTheme(idStheme, codeSthem, nom, description, Theme));
			}
			cnx.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sThemes;
	}

}
