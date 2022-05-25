package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Apprenant;



public class ApprenantDAOjdbcImpl implements ApprenantDAO {

	
	@Override
	public Apprenant selectById(int idUtilisateur) {
		Apprenant apprenant = null;
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM Utilisateur WHERE idUtilisateur = ?");
			ps.setInt(1, idUtilisateur);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				apprenant = new Apprenant();
				apprenant.setIdUtilisateur(idUtilisateur);
				apprenant.setCodeUser(rs.getString("codeUser"));
				apprenant.setNom(rs.getString("nom"));
				apprenant.setPrenom(rs.getString("prenom"));
				apprenant.setTelephone(rs.getString("telephone"));
				apprenant.setEmail(rs.getString("email"));
				apprenant.setDateNaiss(rs.getDate("dateNaiss").toLocalDate());
				apprenant.setNumeroSiret(rs.getString("numeroSiret"));
				apprenant.setDernierDiplome(rs.getString("derinerDiplome"));
				apprenant.setLogin(rs.getString("login"));
				apprenant.setPassword(rs.getString("password"));
				apprenant.setSociete(rs.getString("societe"));
				apprenant.setStatut(rs.getString("statut"));

				
				Date dateNaiss = rs.getDate("dateNaiss");
				if (dateNaiss != null) {
					apprenant.setDateNaiss(dateNaiss.toLocalDate());
				}
			}
			
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return apprenant;
	}

@Override
public List<Apprenant> selectAll() {
	List<Apprenant> apprenants = new ArrayList<Apprenant>();
	try {
		Connection cnx = ConnectionProvider.getConnection();
		PreparedStatement ps = cnx.prepareStatement("SELECT * FROM Utilisateur WHERE idTypeUser = 2 ORDER BY nom DESC");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
		
			Apprenant apprenant = new Apprenant();
			apprenant.setIdUtilisateur(rs.getInt("idUtilisateur"));
			apprenant.setCodeUser(rs.getString("codeUser"));
			apprenant.setNom(rs.getString("nom"));
			apprenant.setPrenom(rs.getString("prenom"));
			apprenant.setTelephone(rs.getString("telephone"));
			apprenant.setEmail(rs.getString("email"));
			apprenant.setNumeroSiret(rs.getString("numeroSiret"));
			apprenant.setDernierDiplome(rs.getString("dernierDiplome"));
			apprenant.setLogin(rs.getString("login"));
			apprenant.setPassword(rs.getString("password"));
			apprenant.setSociete(rs.getString("societe"));
			apprenant.setStatut(rs.getString("statut"));

			
			Date dateNaiss = rs.getDate("dateNaiss");
			if (dateNaiss != null) {
				apprenant.setDateNaiss(dateNaiss.toLocalDate());
			}
			
			apprenants.add(apprenant);
		}
		cnx.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return apprenants;
}
@Override
public void insert(Apprenant apprenant) {
	Connection cnx = ConnectionProvider.getConnection();
	PreparedStatement ps;
	try {
		ps = cnx.prepareStatement("INSERT INTO Utilisateur (codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, login, password, societe, statut) VALUES (?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
	
		ps.setString(1, apprenant.getCodeUser());
		ps.setString(2, apprenant.getNom());
		ps.setString(3, apprenant.getPrenom());
		ps.setString(4, apprenant.getTelephone());
		ps.setString(5, apprenant.getEmail());
		ps.setString(7, apprenant.getNumeroSiret());
		ps.setString(8, apprenant.getDernierDiplome());
		ps.setString(9, apprenant.getLogin());
		ps.setString(10, apprenant.getPassword());
		ps.setString(11, apprenant.getSociete());
		ps.setString(12, apprenant.getStatut());
		ps.setDate(6, Date.valueOf(apprenant.getDateNaiss()));
		if (apprenant.getDateNaiss() != null) {
			ps.setDate(6, Date.valueOf(apprenant.getDateNaiss()));
		} else {
			ps.setDate(6, null);
		}
		
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			apprenant.setIdUtilisateur(rs.getInt(1));
		}
		cnx.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
@Override
public void update(Apprenant apprenant) {
	Connection cnx = ConnectionProvider.getConnection();
	PreparedStatement ps;
	try {
		ps = cnx.prepareStatement("UPDATE Utilisateur SET codeUser = ?, nom = ?, prenom = ?, telephone = ?, email = ?, dateNaiss = ?, numeroSiret = ?, login = ?, password = ?, societe = ?, statut = ? WHERE idUtilisateur = ?");
	
		ps.setString(1, apprenant.getCodeUser());
		ps.setString(2, apprenant.getNom());
		ps.setString(3, apprenant.getPrenom());
		ps.setString(4, apprenant.getTelephone());
		ps.setString(5, apprenant.getEmail());
		ps.setString(7, apprenant.getNumeroSiret());
		ps.setString(8, apprenant.getDernierDiplome());
		ps.setString(9, apprenant.getLogin());
		ps.setString(10, apprenant.getPassword());
		ps.setString(11, apprenant.getSociete());
		ps.setString(12, apprenant.getStatut());
		if (apprenant.getDateNaiss() != null) {
			ps.setDate(6, Date.valueOf(apprenant.getDateNaiss()));
		} else {
			ps.setDate(6, null);
		}
		
		ps.setInt(11, apprenant.getIdUtilisateur());
		
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