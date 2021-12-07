package com.saeed.petsData.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saeed.petsData.models.Pet;
import com.saeed.petsData.repositories.PetRepository;

@Service
public class PetService {
	
	//tell the service which repository to use 
	private final PetRepository petRepository;
	
	//create a constructor for the service
	
	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	
	//telling the services how to access the repository methods
	//lets get all the pets
	public List<Pet> allPets() {
		//casting the object with (List<Pet>)
		return (List<Pet>) this.petRepository.findAll();
	}
	
	//call upon the Repository in order to
	//use a Create method
	//anything that is going to Create something new 
	//it's going to return an object of that class
	public Pet createPet(Pet pet) {
		return this.petRepository.save(pet);
	}
	
	
	//find a pet given an id
	public Pet findOnePet(Long id) {
		return this.petRepository.findById(id).orElse(null);
	}
	
	
	//delete a pet given the id
	public void deletePet(Long id) {
		this.petRepository.deleteById(id);
	}
	
	//update a pet given an id
	public Pet updatePet(Pet p) {
		return this.petRepository.save(p);
	}
}
