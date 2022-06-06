package formation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import formation.bll.SthemeBLL;
import formation.bo.SousTheme;

@RestController
@RequestMapping("/stheme")
public class SthemeRest {
	@Autowired
	private SthemeBLL bll;
	
	@GetMapping
	public ResponseEntity<List<SousTheme>> getAllSousThemes() {
		try {
			return new ResponseEntity<List<SousTheme>>(bll.selectAll(), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<SousTheme>>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SousTheme> findById(@PathVariable("id") int id) {
		
		if (bll.exist(id)) {
			try {
				return new ResponseEntity<SousTheme>(bll.selectById(id), HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<SousTheme>(HttpStatus.CONFLICT);
			}
		} else {
			return new ResponseEntity<SousTheme>(HttpStatus.NOT_FOUND);
		}
	}
}