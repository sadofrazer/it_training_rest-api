package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import bo.Utilisateur;


public class UtilisateurDAOjdbcImpl implements UtilisateurDAO{

	@Override
	public Utilisateur selectById(int idUtilisateur) {
		Utilisateur utilisateur = null;
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM Utilisateur WHERE idUtilisateur = ?");
			ps.setInt(1, idUtilisateur);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setIdUtilisateur(idUtilisateur);
				utilisateur.setCodeUser(rs.getString("codeUser"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setDateNaiss(rs.getDate("dateNaiss").toLocalDate());
				utilisateur.setNumeroSiret(rs.getString("numeroSiret"));
				utilisateur.setLogin(rs.getString("login"));
				utilisateur.setPassword(rs.getString("password"));
				utilisateur.setSociete(rs.getString("societe"));
				utilisateur.setStatut(rs.getString("statut"));

				Date dateNaiss = rs.getDate("dateNaiss");
				if (dateNaiss != null) {
					utilisateur.setDateNaiss(dateNaiss.toLocalDate());
				}
			}
			
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

@Override
public List<Utilisateur> selectAll() {
	List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	try {
		Connection cnx = ConnectionProvider.getConnection();
		PreparedStatement ps = cnx.prepareStatement("SELECT * FROM Utilisateur ORDER BY nom DESC");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
		
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setIdUtilisateur(rs.getInt("idUtilisateur"));
			utilisateur.setCodeUser(rs.getString("codeUser"));
			utilisateur.setNom(rs.getString("nom"));
			utilisateur.setPrenom(rs.getString("prenom"));
			utilisateur.setTelephone(rs.getString("telephone"));
			utilisateur.setEmail(rs.getString("email"));
			utilisateur.setNumeroSiret(rs.getString("numeroSiret"));
			utilisateur.setLogin(rs.getString("login"));
			utilisateur.setPassword(rs.getString("password"));
			utilisateur.setSociete(rs.getString("societe"));
			utilisateur.setStatut(rs.getString("statut"));

			
			Date dateNaiss = rs.getDate("dateNaiss");
			if (dateNaiss != null) {
				utilisateur.setDateNaiss(dateNaiss.toLocalDate());
			}
			
			utilisateurs.add(utilisateur);
		}
		cnx.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return utilisateurs;
}
@Override
public void insert(Utilisateur utilisateur) {
	Connection cnx = ConnectionProvider.getConnection();
	PreparedStatement ps;
	try {
		ps = cnx.prepareStatement("INSERT INTO Utilisateur (codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, login, password, societe, statut  ) VALUES (?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
	
		ps.setString(1, utilisateur.getCodeUser());
		ps.setString(2, utilisateur.getNom());
		ps.setString(3, utilisateur.getPrenom());
		ps.setString(4, utilisateur.getTelephone());
		ps.setString(5, utilisateur.getEmail());
		ps.setString(7, utilisateur.getNumeroSiret());
		ps.setString(8, utilisateur.getLogin());
		ps.setString(9, utilisateur.getPassword());
		ps.setString(10, utilisateur.getSociete());
		ps.setString(11, utilisateur.getStatut());

		ps.setDate(6, Date.valueOf(utilisateur.getDateNaiss()));
		if (utilisateur.getDateNaiss() != null) {
			ps.setDate(6, Date.valueOf(utilisateur.getDateNaiss()));
		} else {
			ps.setDate(6, null);
		}
		
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			utilisateur.setIdUtilisateur(rs.getInt(1));
		}
		cnx.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
@Override
public void update(Utilisateur utilisateur) {
	Connection cnx = ConnectionProvider.getConnection();
	PreparedStatement ps;
	try {
		ps = cnx.prepareStatement("UPDATE Utilisateur SET codeUser = ?, nom = ?, prenom = ?, telephone = ?, email = ?, dateNaiss = ?, numeroSiret = ?, login = ?, password = ?, societe = ?, statut = ? WHERE idUtilisateur = ?");
	
		ps.setString(1, utilisateur.getCodeUser());
		ps.setString(2, utilisateur.getNom());
		ps.setString(3, utilisateur.getPrenom());
		ps.setString(4, utilisateur.getTelephone());
		ps.setString(5, utilisateur.getEmail());
		ps.setString(7, utilisateur.getNumeroSiret());
		ps.setString(8, utilisateur.getLogin());
		ps.setString(9, utilisateur.getPassword());
		ps.setString(10, utilisateur.getSociete());
		ps.setString(11, utilisateur.getStatut());

		if (utilisateur.getDateNaiss() != null) {
			ps.setDate(6, Date.valueOf(utilisateur.getDateNaiss()));
		} else {
			ps.setDate(6, null);
		}
		
		ps.setInt(11, utilisateur.getIdUtilisateur());
		
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
