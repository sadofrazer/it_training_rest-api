package formation.dal;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import formation.bo.Formation;
import formation.bo.SousTheme;
import formation.dal.stheme.SthemeJdbcImpl;

public class FormationJdbcImpl {
	
	
	/**
	 * Méthode du module Formation permettant de retourner la formation correspondant à l'Id passé en paramètre
	 */

	public Formation getFormationByCode(String codeForm) {
		
		Formation formation = null;
		SthemeJdbcImpl sthemeBll = new SthemeJdbcImpl();
		
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM Formation WHERE codeFormation  = ?");
			ps.setString(1, codeForm);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				formation = new Formation();
				formation.setIdFormation(rs.getInt("idFormation"));
				formation.setCodeForm(rs.getString("codeFormation"));
				formation.setNom(rs.getString("nom"));
				formation.setDescription(rs.getString("description"));
				formation.setNbreJrs(rs.getInt("nbreJrs"));
				formation.setStheme(sthemeBll.getSthemeById(rs.getInt("idStheme")));
				formation.setIdRespCat(rs.getInt("idRespCat"));

			}else {
				System.err.println("Aucune Formation correspondante au code :" + codeForm +" n'a été trouvé en base de données");
			}
			cnx.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return formation;
	}
	
	public Formation getFormationById(int id) {
		
		Formation formation = null;
		SthemeJdbcImpl sthemeBll = new SthemeJdbcImpl();
		
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM Formation WHERE idFormation = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				formation = new Formation();
				formation.setIdFormation(rs.getInt("idFormation"));
				formation.setCodeForm(rs.getString("codeFormation"));
				formation.setNom(rs.getString("nom"));
				formation.setDescription(rs.getString("description"));
				formation.setNbreJrs(rs.getInt("nbreJrs"));
				formation.setStheme(sthemeBll.getSthemeById(rs.getInt("idStheme")));
				formation.setIdRespCat(rs.getInt("idRespCat"));

			}else {
				System.err.println("Aucune Formation correspondante à l'ID :" + id +" n'a été trouvé en base de données");
			}
			cnx.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return formation;
	}

	
	
	/**
	 * Méthode du module Formation permettant de retourner la liste de toutes les formations présentes en BDD
	 */

	public List<Formation> selectAllFormations() {
		
		SthemeJdbcImpl sthemeBll = new SthemeJdbcImpl();
		List<Formation> formations = new ArrayList<Formation>();
		
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM Formation ORDER BY nom");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idFormation = rs.getInt("idFormation");
				String codeFormation = rs.getString("codeFormation");
				String nom = rs.getString("nom");
				String description = rs.getString("description");
				int nbreJrs = rs.getInt("nbreJrs");
				SousTheme stheme = sthemeBll.getSthemeById(rs.getInt("idStheme"));
				int idRespcat = rs.getInt("idRespcat");
				formations.add(new Formation(idFormation, codeFormation, nom, description,nbreJrs, stheme, idRespcat));
			}
			cnx.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return formations;
	}
	
	public List<Formation> getAllOrderBy(String order) {
		
		SthemeJdbcImpl sthemeBll = new SthemeJdbcImpl();
		List<Formation> formations = new ArrayList<Formation>();
		
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT f.*, s.nom as nomStheme FROM Formation f, SousTheme s WHERE (f.idStheme=s.idStheme) ORDER BY " + order);
			//PreparedStatement ps = cnx.prepareStatement("SELECT f.*, s.nom as nomStheme FROM Formation f, SousTheme s WHERE (f.idStheme=s.idStheme) ORDER BY ?");
			//ps.setString(1, "order");
			System.out.println("Valeur utilisée pour exécution de la requete : " + order);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idFormation = rs.getInt("idFormation");
				String codeFormation = rs.getString("codeFormation");
				String nom = rs.getString("nom");
				String description = rs.getString("description");
				int nbreJrs = rs.getInt("nbreJrs");
				SousTheme stheme = sthemeBll.getSthemeById(rs.getInt("idStheme"));
				int idRespcat = rs.getInt("idRespcat");
				formations.add(new Formation(idFormation, codeFormation, nom, description,nbreJrs, stheme, idRespcat));
			}
			cnx.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return formations;
	}

	
	
	/**
	 * Méthode du module Formation permettant d'insérer la formation passée en paramètre dans la BDD (CREATE)
	 */

	public boolean insertFormation(Formation formation) {
		
		Connection cnx = ConnectionProvider.getConnection();
		
		if (formation != null) {
			try {
				PreparedStatement ps = cnx.prepareStatement("INSERT INTO Formation (codeFormation, nom, description,nbreJrs, idStheme, idRespCat)"
						+ " VALUES (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, formation.getCodeForm());
				ps.setString(2, formation.getNom());
				ps.setString(3, formation.getDescription());
				ps.setInt(4, formation.getNbreJrs());
				ps.setInt(5, formation.getStheme().getIdStheme());
				ps.setInt(6, formation.getIdRespCat());
				ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) {
					formation.setIdFormation(rs.getInt(1));
				}
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}else {
			System.err.println("Impossible d'ajouter cette formation car la valeur de l'objet est nulle");
			return false;
		}
	}

	
	
	/**
	 * Méthode du module Formation permettant de mettre à jour une formation avec les paramètres de l'objet Formation passé en paramètre
	 */

	public boolean updateFormation(Formation formation) {
		
		Connection cnx = ConnectionProvider.getConnection();
		
		if (formation != null) {
			try {
				PreparedStatement ps = cnx.prepareStatement("UPDATE Formation SET codeFormation=?, nom=?, description=?, nbreJrs=?, idStheme=?, idRespCat=? WHERE idFormation=?");
				ps.setInt(7, formation.getIdFormation());
				ps.setString(1, formation.getCodeForm());
				ps.setString(2, formation.getNom());
				ps.setString(3, formation.getDescription());
				ps.setInt(4, formation.getNbreJrs());
				ps.setInt(5, formation.getStheme().getIdStheme());
				ps.setInt(6, formation.getIdRespCat());
				ps.executeUpdate();
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}else {
			System.err.println("Impossible de modifier cette formation car la valeur de l'objet est nulle");
			return false;
		}
		
	}

	
	
	/**
	 * Méthode du module Formation permettant de supprimer dans la BDD la formation ayant l'ID passé en paramètres 
	 */

	public boolean deleteFormation(int id) {
		
		Connection cnx = ConnectionProvider.getConnection();
	
		try {
			PreparedStatement ps = cnx.prepareStatement("DELETE FROM Formation WHERE idFormation=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}


	public List<Formation> searchByParams(String codeForm, String nomForm, String nomStheme) {
		
		SthemeJdbcImpl sthemeBll = new SthemeJdbcImpl();
		List<Formation> formations = new ArrayList<Formation>();
		
		Connection cnx = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("SELECT  f.*, s.nom as nomStheme FROM Formation f, SousTheme s "
					+ "WHERE (f.idStheme=s.idStheme and  CodeFormation LIKE ? and f.nom LIKE ? and s.nom LIKE ?)");
			ps.setString(1, "%"+codeForm+"%");
			ps.setString(2, "%"+nomForm+"%");
			ps.setString(3, "%"+nomStheme+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idFormation = rs.getInt("idFormation");
				String codeFormation = rs.getString("codeFormation");
				String nom = rs.getString("nom");
				String description = rs.getString("description");
				int nbreJrs = rs.getInt("nbreJrs");
				SousTheme stheme = sthemeBll.getSthemeById(rs.getInt("idStheme"));
				int idRespcat = rs.getInt("idRespcat");
				formations.add(new Formation(idFormation, codeFormation, nom, description,nbreJrs, stheme, idRespcat));
			}
			rs.close();
			cnx.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return formations;
	}


	public boolean idExist(int id) {
		
		if (getFormationById(id)!= null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean codeExist(String codeForm) {
		
		if (getFormationByCode(codeForm)!= null) {
			return true;
		}
		else {
			return false;
		}
	}

}
