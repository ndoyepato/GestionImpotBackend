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
public class HabitationProfessionnelleController {

	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private HabitationProfessionnelleRepository habitationProfessionnelleRepository;

	@PostMapping(path = "/add-habitation-pro") // Map ONLY POST Requests
	public @ResponseBody String addNewHabitationProfessionnelle(@RequestParam String proprietaire,
			@RequestParam String adresse, @RequestParam double surface, @RequestParam int nbreEmploye) {

		HabitationProfessionnelle habitPro = new HabitationProfessionnelle();
		habitPro.setProprietaire(proprietaire);
		habitPro.setAdresse(adresse);
		habitPro.setSurface(surface);
		habitPro.setNbreEmploye(nbreEmploye);
		habitationProfessionnelleRepository.save(habitPro);
		return "{\"success\": true, \"msg\":\"Habitation Professionnelle ajoutée avec succès\"}";
	}
	
	@PutMapping(path = "/edit-habitation-pro") // Map ONLY POST Requests
	public @ResponseBody String editHabitationProfessionnelle(@RequestParam Integer id, @RequestParam String proprietaire,
			@RequestParam String adresse, @RequestParam double surface, @RequestParam int nbreEmploye) {

		HabitationProfessionnelle habitPro = new HabitationProfessionnelle();
		habitPro.setProprietaire(proprietaire);
		habitPro.setAdresse(adresse);
		habitPro.setSurface(surface);
		habitPro.setNbreEmploye(nbreEmploye);
		habitationProfessionnelleRepository.save(habitPro);
		return "{\"success\": true, \"msg\":\"Habitation Professionnelle ajoutée avec succès\"}";
	}
	
	@DeleteMapping(path = "/delete-habitation-pro") // Map ONLY POST Requests
	public @ResponseBody String deleteHabitationProfessionnelle(@RequestParam Integer id, @RequestParam String proprietaire,
			@RequestParam String adresse, @RequestParam double surface, @RequestParam int nbreEmploye) {

		habitationProfessionnelleRepository.deleteById(id);
		return "{\"success\": true, \"msg\":\"Habitation Professionnelle ajoutée avec succès\"}";
	}

	@GetMapping(path = "/all-habitations-pro")
	public @ResponseBody Iterable<HabitationProfessionnelle> getAllHabitationsProfessionelles() {
// This returns a JSON or XML with the users   user redirection
		return (Iterable<HabitationProfessionnelle>) habitationProfessionnelleRepository.findAll();
	}
}
