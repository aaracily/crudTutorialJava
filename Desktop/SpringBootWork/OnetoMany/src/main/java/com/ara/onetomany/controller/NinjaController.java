package com.ara.onetomany.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ara.onetomany.model.Dojo;
import com.ara.onetomany.model.Ninja;
import com.ara.onetomany.service.DojoService;
import com.ara.onetomany.service.NinjaService;

@Controller
public class NinjaController {
	//inyectar dependencia
	private final NinjaService ninjaS;
	private final DojoService dojoS;
	
	//constructor
	public NinjaController(NinjaService ninjaS,DojoService dojoS) {
		this.ninjaS = ninjaS;
		this.dojoS= dojoS;
	}
	
	//crear un ninja, requiere instanciar Dojo para crear un ninja
	@RequestMapping("/ninjas/new")
	public String crearNinja(@ModelAttribute("ninja")Ninja ninja,Model model) {
		List<Dojo> dojos= dojoS.allDojo();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	//recibe información del formulario incluye dojo en ninja
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
	public String guardarNinja(@Valid @ModelAttribute("ninja")Ninja nuevoNinja,BindingResult result) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		}else {
			ninjaS.createN(nuevoNinja);
			//Long path = nuevoNinja.getDojo().getId();
			return "redirect:/ninjas/new";
		}
	}
}
