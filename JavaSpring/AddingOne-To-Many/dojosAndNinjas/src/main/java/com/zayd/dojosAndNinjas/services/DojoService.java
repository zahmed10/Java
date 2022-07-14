package com.zayd.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zayd.dojosAndNinjas.models.Dojo;
import com.zayd.dojosAndNinjas.repos.DojoRepo;

@Service
public class DojoService {
	@Autowired
	private DojoRepo dojoRepo;
	
//	Create a dojo
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
//	Read all dojos
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
//	Read one dojo
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
//	Update dojo
	public Dojo updateDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
//	Delete dojo
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
}
