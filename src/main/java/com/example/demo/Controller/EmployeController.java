package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employe;
import com.example.demo.Services.EmployeService;
@RestController
@RequestMapping("/pepsi")
public class EmployeController {
	   
	@Autowired
	   EmployeService employeService;
	@GetMapping("/all")
	public List<Employe> Afficher(){
		return employeService.getAll();		
	}
	
	@GetMapping("/allActive")
	public List<Employe> Afficheractive(){
		return employeService.findActived();	
	}
	
	@GetMapping("/FindById/{id}")
	public Employe FindByID(@PathVariable Integer id) {
		  return employeService.FindById(id);
		
	}
	
	@PostMapping("/ajouter")
	public Employe ajouter(@RequestBody Employe e){		
		return employeService.AddEmploye(e);		
	}
	@PutMapping("/update/{id}")
	public Employe update(@PathVariable Integer id , @RequestBody Employe e) {
		return employeService.UpdateEmploye(id, e);
	}
	
	@PutMapping("/delete/{id}")
	public Employe inactive(@PathVariable Integer id) {
		
		return employeService.deleteEmployerById(id);
	}
	

   
	
	
	
   

}
