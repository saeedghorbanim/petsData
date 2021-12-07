package com.saeed.petsData.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saeed.petsData.models.Pet;
import com.saeed.petsData.services.PetService;

@RestController 
public class PetApi {
	
	//the controller is the customer that talks with the teller
	//the service is the bank teller
	//let the controller know about the service 
	//the customer (controller) is the one that makes requests
	
	private final PetService petService;
	
	public PetApi(PetService petService) {
		this.petService = petService;
		
	}
	//obtaining data from the Service and presenting it
	@RequestMapping("/api/pets")
	public List<Pet> getAllPets() {
		return this.petService.allPets();
	}
	
	//to create a pet
	//we have to get the create pet method from the Service which the Service gets from the Repository
	@PostMapping("/api/pets")
	public Pet createNewPet(@RequestParam(value="name") String name, 
	@RequestParam(value="age") Integer age, @RequestParam(value="description") String description) {
		
		//create a pet objects using the constructor in the 
		//Pet.java model 
		
		Pet p = new Pet(name, age, description);
		
		return this.petService.createPet(p);
	}
	
	@GetMapping("/api/pets/{id}")
	public Pet getPet(@PathVariable("id") Long id) {
		return this.petService.findOnePet(id);
	}
	
	@DeleteMapping("/api/pets/delete/{id}")
	public void deletePet(@PathVariable("id") Long id) {
		this.petService.deletePet(id);
		
	}
	
	@PutMapping("/api/pets/update/{id}")
	public Pet updatePet(@PathVariable("id") Long id, @RequestParam(value="name") String name, 
						@RequestParam(value="age") Integer age, 
						@RequestParam(value="description") String description) 
	{
		//retrieve a pet from the db that has that id
		Pet p = this.petService.findOnePet(id);
		
		//update that object
		p.setName(name);
		p.setAge(age);
		p.setDescription(description);
		
		//send the updated object to service to update the db with
		return this.petService.updatePet(p);
		
	}
}
