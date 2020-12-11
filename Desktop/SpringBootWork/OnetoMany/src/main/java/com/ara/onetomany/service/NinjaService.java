package com.ara.onetomany.service;

import org.springframework.stereotype.Service;

import com.ara.onetomany.model.Ninja;
import com.ara.onetomany.repository.NinjaRepository;

@Service 
public class NinjaService {
	private final NinjaRepository ninjaRep;
	//constructor
	public NinjaService(NinjaRepository ninjaRep) {
		this.ninjaRep =  ninjaRep;
	}
	
	//para crear/guaradr un ninja
	public Ninja createN(Ninja ninja) {
		return ninjaRep.save(ninja);
	}
}
