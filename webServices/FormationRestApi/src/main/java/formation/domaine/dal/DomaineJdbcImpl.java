package formation.domaine.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import formation.bo.Domaine;
import formation.dal.ConnectionProvider;

public class DomaineJdbcImpl implements DomaineDAO {

	@Override
	public Domaine getDomaineById(int id) {
		
		Domaine domaine = null;
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM Domaine WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				domaine = new Domaine();
				domaine.setIdDomaine(rs.getInt("idDomaine"));
				domaine.setCodeDom(rs.getString("codeDom"));
				domaine.setNom(rs.getString("nom"));
				domaine.setDescription(rs.getString("description"));
			}else {
				System.err.println("Aucun Domaine correspondant à l'ID :" + id +" n'a été trouvé en base de données");
			}
			cnx.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return domaine;
	}

	@Override
	public List<Domaine> selectAll() {
		
		List<Domaine> domaines = new ArrayList<Domaine>();
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM Domaine");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idDomaine = rs.getInt("iddomaine");
				String codeDom = rs.getString("codeSthem");
				String nom = rs.getString("nom");
				String description = rs.getString("description");
				domaines.add(new Domaine(idDomaine, codeDom, nom, description));
			}
			cnx.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return domaines;
	}

}
