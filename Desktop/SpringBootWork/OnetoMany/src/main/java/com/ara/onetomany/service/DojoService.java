package com.ara.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ara.onetomany.model.Dojo;
import com.ara.onetomany.repository.DojoRepository;

@Service
public class DojoService {
		private final DojoRepository dojoRep;
	
		public DojoService(DojoRepository dojoRep) {
			this.dojoRep =  dojoRep;
		}
		//para listar todos los dojos
		public List<Dojo> allDojo(){
			return dojoRep.findAll();
		}
		//para guardar/crear un dojo 
		public Dojo createD (Dojo  dojo) {
			return dojoRep.save(dojo);
		}
		//encontrar dojo por el id
		public Dojo findById(Long id) {
			Optional<Dojo> optinalDojo =dojoRep.findById(id);
			if(optinalDojo.isPresent()) {
				return optinalDojo.get();
			}else {
				return null;
			}
		}
}
