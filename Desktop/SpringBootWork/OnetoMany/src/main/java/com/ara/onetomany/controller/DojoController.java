package com.ara.onetomany.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ara.onetomany.model.Dojo;

import com.ara.onetomany.service.DojoService;

@Controller
public class DojoController {
	private final DojoService dojoS ;
	
	public DojoController (DojoService dojoS) {
		this.dojoS = dojoS;
	}
	//crear un dojo
	@RequestMapping("/dojos/new")
	public String crearDojo (@ModelAttribute ("dojo")Dojo dojo) {
		
		return "newDojo.jsp";
	}
	//almacena información del formulario
	@RequestMapping(value="dojos/new",method=RequestMethod.POST)
	public String guardarDojo(@Valid @ModelAttribute("dojo")Dojo dojoto,BindingResult result){
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}else {
			dojoS.createD(dojoto);
			return "redirect:/dojos/new";
		}
	}
	//buscar por id y mostrar en vista
	@RequestMapping("/dojos/{id}")
	public String buscarDojo (@PathVariable("id")Long id,Model model) {
		Dojo dojote =dojoS.findById(id);
		if(dojote ==null) {
			return "redirect:/dojos/new";
		}else {
			
			model.addAttribute("eldojo",dojote);
			
			
			return "showDojo.jsp";
		}
		
	}
}
		
	

