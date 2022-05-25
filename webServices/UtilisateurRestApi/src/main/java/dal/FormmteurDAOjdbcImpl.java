package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Formateur;



public class FormmteurDAOjdbcImpl implements FormateurDAO {
	@Override
	public Formateur selectById(int idUtilisateur) {
		Formateur formateur = null;
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement ps = cnx.prepareStatement("SELECT * FROM Utilisateur WHERE idUtilisateur = ?");
			ps.setInt(1, idUtilisateur);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				formateur = new Formateur();
				formateur.setIdUtilisateur(idUtilisateur);
				formateur.setCodeUser(rs.getString("codeUser"));
				formateur.setNom(rs.getString("nom"));
				formateur.setPrenom(rs.getString("prenom"));
				formateur.setTelephone(rs.getString("telephone"));
				formateur.setEmail(rs.getString("email"));
				formateur.setDateNaiss(rs.getDate("dateNaiss").toLocalDate());
				formateur.setNumeroSiret(rs.getString("numeroSiret"));
				formateur.setCertification(rs.getString("certification"));
				formateur.setLogin(rs.getString("login"));
				formateur.setPassword(rs.getString("password"));
				formateur.setSociete(rs.getString("societe"));
				formateur.setStatut(rs.getString("statut"));
				
				Date dateNaiss = rs.getDate("dateNaiss");
				if (dateNaiss != null) {
					formateur.setDateNaiss(dateNaiss.toLocalDate());
				}
			}
			
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return formateur;
	}


@Override
public List<Formateur> selectAll() {
	List<Formateur> formateurs = new ArrayList<Formateur>();
	try {
		Connection cnx = ConnectionProvider.getConnection();
		PreparedStatement ps = cnx.prepareStatement("SELECT * FROM Utilisateur WHERE idTypeUser = 3 ");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			Formateur formateur = new Formateur();
			
			formateur.setIdUtilisateur(rs.getInt("idUtilisateur"));
			formateur.setCodeUser(rs.getString("codeUser"));
			formateur.setNom(rs.getString("nom"));
			formateur.setPrenom(rs.getString("prenom"));
			formateur.setTelephone(rs.getString("telephone"));
			formateur.setEmail(rs.getString("email"));
			formateur.setNumeroSiret(rs.getString("numeroSiret"));
			formateur.setCertification(rs.getString("certifications"));
			formateur.setLogin(rs.getString("login"));
			formateur.setPassword(rs.getString("password"));
			formateur.setSociete(rs.getString("societe"));
			formateur.setStatut(rs.getString("statut"));

			
			Date dateNaiss = rs.getDate("dateNaiss");
			if (dateNaiss != null) {
				formateur.setDateNaiss(dateNaiss.toLocalDate());
			}
			
			formateurs.add(formateur);
		}
		cnx.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return formateurs;
}
@Override
public void insert(Formateur formateur) {
	Connection cnx = ConnectionProvider.getConnection();
	PreparedStatement ps;
	try {
		ps = cnx.prepareStatement("INSERT INTO Utilisateur (codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, certifications, login, password, societe, statut) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
	
		ps.setString(1, formateur.getCodeUser());
		ps.setString(2, formateur.getNom());
		ps.setString(3, formateur.getPrenom());
		ps.setString(4, formateur.getTelephone());
		ps.setString(5, formateur.getEmail());
		ps.setString(7, formateur.getNumeroSiret());
		ps.setString(8, formateur.getCertification());
		ps.setString(9, formateur.getLogin());
		ps.setString(10, formateur.getPassword());
		ps.setString(11, formateur.getSociete());
		ps.setString(12, formateur.getStatut());
		ps.setDate(6, Date.valueOf(formateur.getDateNaiss()));
		if (formateur.getDateNaiss() != null) {
			ps.setDate(6, Date.valueOf(formateur.getDateNaiss()));
		} else {
			ps.setDate(6, null);
		}
		
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			formateur.setIdUtilisateur(rs.getInt(1));
		}
		cnx.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
@Override
public void update(Formateur formateur) {
	Connection cnx = ConnectionProvider.getConnection();
	PreparedStatement ps;
	try {
		ps = cnx.prepareStatement("UPDATE Utilisateur SET codeUser = ?, nom = ?, prenom = ?, telephone = ?, email = ?, dateNaiss = ?, numeroSiret = ?, certifications = ?, login = ?, password = ?, societe = ?, statut = ? WHERE idUtilisateur = ?");
	
		ps.setString(1, formateur.getCodeUser());
		ps.setString(2, formateur.getNom());
		ps.setString(3, formateur.getPrenom());
		ps.setString(4, formateur.getTelephone());
		ps.setString(5, formateur.getEmail());
		ps.setString(7, formateur.getNumeroSiret());
		ps.setString(8, formateur.getCertification());
		ps.setString(9, formateur.getLogin());
		ps.setString(10, formateur.getPassword());
		ps.setString(11, formateur.getSociete());
		ps.setString(12, formateur.getStatut());

		if (formateur.getDateNaiss() != null) {
			ps.setDate(6, Date.valueOf(formateur.getDateNaiss()));
		} else {
			ps.setDate(6, null);
		}
		
		ps.setInt(11, formateur.getIdUtilisateur());
		
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
