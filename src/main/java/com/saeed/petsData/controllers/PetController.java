package com.saeed.petsData.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.saeed.petsData.models.Pet;
import com.saeed.petsData.services.PetService;

@Controller
public class PetController {
	
	//tell the controller about the service
	private final PetService petService;
	
	public PetController(PetService petService) {
		this.petService = petService;
		
	}
	
	@GetMapping("/pets")
	public String getAllPets(Model model) {
		List<Pet> allPets = this.petService.allPets();
		model.addAttribute("allPets", allPets);
		return "index.jsp";
		
	}
	
	//creating an empty object for the template
	@GetMapping("/pets/new")
	public String newPet(Model model) {
		Pet p = new Pet();
		model.addAttribute("pett", p);
		return "newPet.jsp";
	}

	@PostMapping("/pets/create")
	public String createPet(@Valid @ModelAttribute("pett") Pet pet, BindingResult result) {
		if(result.hasErrors()) {
			return "newPet.jsp";
		}
		this.petService.createPet(pet);
		//returning page with created data from the form
		return "redirect:/pets";

	}
	
	@GetMapping("/pet/info/{id}")
	public String showPetInfo(@PathVariable("id") Long id, Model model) {
		//using the id from the route, we can get the pet object
		//from the Service that has that id
		Pet p = this.petService.findOnePet(id);
		
		model.addAttribute("petDisplay", p);
		return "petinfo.jsp";
	}
	
	@GetMapping("/pet/edit/{id}")
	public String editPet(@PathVariable("id") Long id, Model model) {
		//get a pet object to pass it for editing
		Pet p = this.petService.findOnePet(id);
		
		//forwarding the pre-filled in "p" object to get used as "pet" in the template
		model.addAttribute("pet", p);
		
		return "editPet.jsp";
	}
	
	@PostMapping("/pet/update/{id}")
	public String updatePet(@PathVariable("id") Long id, @Valid @ModelAttribute("pet") Pet pet, BindingResult result) {
		if(result.hasErrors()) {
			return "editPet.jsp";
		}
		//if the form doesn't have errors, this updates the pet object
		//so we get the updated data when redirected back to /pets
		this.petService.updatePet(pet);
		
		return "redirect:/pets";
	}
	
	@GetMapping("/pet/delete/{id}")
	public String deletePet(@PathVariable("id") Long id) {
		this.petService.deletePet(id);
		
		return "redirect:/pets";
	}
	
	
}


