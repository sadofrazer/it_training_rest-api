package formation.dal.theme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import formation.bo.Domaine;
import formation.bo.Theme;
import formation.dal.ConnectionProvider;
import formation.dal.domaine.DomaineJdbcImpl;

public class ThemeJdbcImpl implements ThemeDAO{

	@Override
	public Theme getThemeById(int id) {
		DomaineJdbcImpl domaineDal = new DomaineJdbcImpl();
		Theme theme = null;
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM Theme WHERE idTheme = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				theme = new Theme();
				theme.setIdTheme(rs.getInt("idTheme"));
				theme.setCodeTheme(rs.getString("codeTheme"));
				theme.setNom(rs.getString("nom"));
				theme.setDescription(rs.getString("description"));
				theme.setDomaine(domaineDal.getDomaineById(rs.getInt("idDomaine")));
			}else {
				System.err.println("Aucun theme correspondant à l'ID :" + id + " n'a été trouvé en base de données");
			}
			cnx.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return theme;
	}

	@Override
	public List<Theme> selectAll() {
		DomaineJdbcImpl domaineDal = new DomaineJdbcImpl();
		List<Theme> themes = new ArrayList<Theme>();
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM Theme");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idTheme = rs.getInt("idTheme");
				String codeTheme = rs.getString("codeTheme");
				String nom = rs.getString("nom");
				String description = rs.getString("description");
				Domaine domaine = domaineDal.getDomaineById(rs.getInt("idDomaine"));
				themes.add(new Theme(idTheme, codeTheme, nom, description, domaine));
			}
			cnx.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return themes;
	}

}
