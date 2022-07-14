package com.zayd.dojosAndNinjas.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zayd.dojosAndNinjas.models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
	
//	List<Ninja> this.findList<Ninja> findByDojo(Dojo dojo);

}


