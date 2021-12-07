package com.saeed.petsData.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saeed.petsData.models.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long>{

}
