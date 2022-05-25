package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Responsable;


public class ResponsableDAOjdbcImpl implements ResponsableDAO{

	@Override
	public Responsable selectById(int idUtilisateur) {
		Responsable responsable = null;
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM Utilisateur WHERE idUtilisateur = ?");
			ps.setInt(1, idUtilisateur);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				responsable = new Responsable();
				responsable.setIdUtilisateur(idUtilisateur);
				responsable.setCodeUser(rs.getString("codeUser"));
				responsable.setNom(rs.getString("nom"));
				responsable.setPrenom(rs.getString("prenom"));
				responsable.setTelephone(rs.getString("telephone"));
				responsable.setEmail(rs.getString("email"));
				responsable.setDateNaiss(rs.getDate("dateNaiss").toLocalDate());
				responsable.setNumeroSiret(rs.getString("numeroSiret"));
				responsable.setLogin(rs.getString("login"));
				responsable.setPassword(rs.getString("password"));
				responsable.setSociete(rs.getString("societe"));
				responsable.setStatut(rs.getString("statut"));
				responsable.setFonction(rs.getString("fonction"));

				
				Date dateNaiss = rs.getDate("dateNaiss");
				if (dateNaiss != null) {
					responsable.setDateNaiss(dateNaiss.toLocalDate());
				}
			}
			
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return responsable;
	}

@Override
public List<Responsable> selectAll() {
	List<Responsable> responsables = new ArrayList<Responsable>();
	try {
		Connection cnx = ConnectionProvider.getConnection();
		PreparedStatement ps = cnx.prepareStatement("SELECT * FROM Utilisateur WHERE idTypeUser = 1 ORDER BY nom DESC");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
		
			Responsable responsable = new Responsable();
			responsable.setIdUtilisateur(rs.getInt("idUtilisateur"));
			responsable.setCodeUser(rs.getString("codeUser"));
			responsable.setNom(rs.getString("nom"));
			responsable.setPrenom(rs.getString("prenom"));
			responsable.setTelephone(rs.getString("telephone"));
			responsable.setEmail(rs.getString("email"));
			responsable.setNumeroSiret(rs.getString("numeroSiret"));
			responsable.setLogin(rs.getString("login"));
			responsable.setPassword(rs.getString("password"));
			responsable.setSociete(rs.getString("societe"));
			responsable.setStatut(rs.getString("statut"));
			responsable.setFonction(rs.getString("fonction"));

			
			Date dateNaiss = rs.getDate("dateNaiss");
			if (dateNaiss != null) {
				responsable.setDateNaiss(dateNaiss.toLocalDate());
			}
			
			responsables.add(responsable);
		}
		cnx.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return responsables;
}
@Override
public void insert(Responsable responsable) {
	Connection cnx = ConnectionProvider.getConnection();
	PreparedStatement ps;
	try {
		ps = cnx.prepareStatement("INSERT INTO Utilisateur (codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, login, password, societe, fonction, statut) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
	
		ps.setString(1, responsable.getCodeUser());
		ps.setString(2, responsable.getNom());
		ps.setString(3, responsable.getPrenom());
		ps.setString(4, responsable.getTelephone());
		ps.setString(5, responsable.getEmail());
		ps.setString(7, responsable.getNumeroSiret());
		ps.setString(8, responsable.getLogin());
		ps.setString(9, responsable.getPassword());
		ps.setString(10, responsable.getSociete());
		ps.setString(11, responsable.getFonction());
		ps.setString(12, responsable.getStatut());
		ps.setDate(6, Date.valueOf(responsable.getDateNaiss()));
		if (responsable.getDateNaiss() != null) {
			ps.setDate(6, Date.valueOf(responsable.getDateNaiss()));
		} else {
			ps.setDate(6, null);
		}
		
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			responsable.setIdUtilisateur(rs.getInt(1));
		}
		cnx.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
@Override
public void update(Responsable responsable) {
	Connection cnx = ConnectionProvider.getConnection();
	PreparedStatement ps;
	try {
		ps = cnx.prepareStatement("UPDATE Utilisateur SET codeUser = ?, nom = ?, prenom = ?, telephone = ?, email = ?, dateNaiss = ?, numeroSiret = ?, login = ?, password = ?, societe = ?, fonction = ?, statut = ? WHERE idUtilisateur = ?");
	
		ps.setString(1, responsable.getCodeUser());
		ps.setString(2, responsable.getNom());
		ps.setString(3, responsable.getPrenom());
		ps.setString(4, responsable.getTelephone());
		ps.setString(5, responsable.getEmail());
		ps.setString(7, responsable.getNumeroSiret());
		ps.setString(8, responsable.getLogin());
		ps.setString(9, responsable.getPassword());
		ps.setString(10, responsable.getSociete());
		ps.setString(11, responsable.getFonction());
		ps.setString(12, responsable.getStatut());
		if (responsable.getDateNaiss() != null) {
			ps.setDate(6, Date.valueOf(responsable.getDateNaiss()));
		} else {
			ps.setDate(6, null);
		}
		
		ps.setInt(11, responsable.getIdUtilisateur());
		
		ps.executeUpdate();
		cnx.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
@Override
public void delete(int idUtilisateur) {
	Connection cnx = ConnectionProvider.getConnection();
	PreparedStatement ps;
	try {
		ps = cnx.prepareStatement("DELETE FROM Utilisateur WHERE idUtilisateur = ?");
		ps.setInt(1, idUtilisateur);
		ps.executeUpdate();
		cnx.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}