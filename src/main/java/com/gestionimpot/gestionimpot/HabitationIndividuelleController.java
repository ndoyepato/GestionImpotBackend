package com.gestionimpot.gestionimpot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/api") // This means URL's start with /demo (after Application path)
public class HabitationIndividuelleController {

	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private HabitationIndividuelleRepository habitationIndividuelleRepository;

	@PostMapping(path = "/add-habitation-ind") // Map ONLY POST Requests
	public @ResponseBody String addNewHabitationIndividuelle(@RequestParam String proprietaire,
			@RequestParam String adresse, @RequestParam double surface, @RequestParam int nbreDePiece, 
			@RequestParam boolean havePiscine) {

		HabitationIndividuelle habitInd = new HabitationIndividuelle();
		habitInd.setProprietaire(proprietaire);
		habitInd.setAdresse(adresse);
		habitInd.setSurface(surface); 
		habitInd.setNbreDePiece(nbreDePiece);
		habitInd.setHavePiscine(havePiscine);
		habitationIndividuelleRepository.save(habitInd);
		return "{\"success\": true, \"msg\":\"Habitation Individuelle ajoutée avec succès\"}";
	}
	
	@PutMapping(path = "/edit-habitation-ind") // Map ONLY POST Requests
	public @ResponseBody String editHabitationIndividuelle(@RequestParam Integer id, @RequestParam String proprietaire,
			@RequestParam String adresse, @RequestParam double surface, @RequestParam int nbreDePiece, 
			@RequestParam boolean havePiscine) {

		HabitationIndividuelle habitInd = new HabitationIndividuelle();
		habitInd.setId(id);
		habitInd.setProprietaire(proprietaire);
		habitInd.setAdresse(adresse);
		habitInd.setSurface(surface); 
		habitInd.setNbreDePiece(nbreDePiece);
		habitInd.setHavePiscine(havePiscine);
		habitationIndividuelleRepository.save(habitInd);
		return "{\"success\": true, \"msg\":\"Habitation Individuelle ajoutée avec succès\"}";
	}
	
	@DeleteMapping(path = "/delete-habitation-ind") // Map ONLY POST Requests
	public @ResponseBody String DeleteHabitationIndividuelle(@RequestParam Integer id) {

		habitationIndividuelleRepository.deleteById(id);
		return "{\"success\": true, \"msg\":\"Habitation Individuelle supprimée avec succès\"}";
	}

	@GetMapping(path = "/all-habitations-ind")
	public @ResponseBody Iterable<HabitationIndividuelle> getAllHabitationsIndividuelles() {
// This returns a JSON or XML with the users   user redirection
		return (Iterable<HabitationIndividuelle>) habitationIndividuelleRepository.findAll();
	}
}
