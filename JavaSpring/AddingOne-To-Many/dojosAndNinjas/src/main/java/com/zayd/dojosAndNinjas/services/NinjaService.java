package com.zayd.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zayd.dojosAndNinjas.models.Ninja;
import com.zayd.dojosAndNinjas.repos.DojoRepo;
import com.zayd.dojosAndNinjas.repos.NinjaRepo;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepo ninjaR;
	
//	------------------------- Had a divider here not sure what else to write yet

//	Read all
	public List<Ninja> allNinjas() {
		return ninjaR.findAll();
	}
	
//	Create
	public Ninja createNinja(Ninja n) {
		return ninjaR.save(n);
	}
	
//	Read one
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinj = ninjaR.findById(id);
		if (optionalNinj.isPresent()) {
			return optionalNinj.get();
		} else {
			return null;
		}
	}
	
//	Update
	public Ninja updateNinja(Ninja n) {
		return ninjaR.save(n);
	}
	
//	Delete
	public void deleteNinja(Long id) {
		System.out.println("deleting ninja with id = " + id);
		ninjaR.deleteById(id);
	}
	

}
