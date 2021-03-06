package com.gestionimpot.gestionimpot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/demo") // This means URL's start with /demo (after Application path)
public class HabitationController {

	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private HabitationRepository habitationRepository;

	@PostMapping(path = "/addhabitation") // Map ONLY POST Requests
	public @ResponseBody String addNewHabitation(@RequestParam String name, @RequestParam String email) {
// @ResponseBody means the returned String is the response, not a view name
// @RequestParam means it is a parameter from the GET or POST request

		Habitation n = new Habitation(); 
		n.setName(name);
		n.setEmail(email); 
		habitationRepository.save(n);
		return "{\"msg\":\"Habitation ajouté avec succès\"}";
	}

	@GetMapping(path = "/allhatations")   
	public @ResponseBody Iterable<Habitation> getAllHabitations() {
// This returns a JSON or XML with the users   user redirection
		return (Iterable<Habitation>) habitationRepository.findAll();
	}
}
