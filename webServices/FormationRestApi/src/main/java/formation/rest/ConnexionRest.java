package formation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import formation.bll.ConnexionBLL;
import formation.bo.Utilisateur;



@RestController
@RequestMapping("/connexion")
public class ConnexionRest {
	
	@Autowired
	private ConnexionBLL bll;
	
	@GetMapping
	public List<Utilisateur> getUtilisateurs() {
		return bll.selectAll();
	}
	
	@GetMapping("/{login}/{password}")
	public Utilisateur connexion(@PathVariable("login") String login,
									 @PathVariable("password") String password) {
		return bll.connexion(login, password);
	}

}
