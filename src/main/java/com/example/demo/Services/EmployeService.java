package com.example.demo.Services;
import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employe;
import com.example.demo.Repostory.EmployeRepostory;

@Service
public class EmployeService {
	@Autowired
   EmployeRepostory employerepostory;
 
	public List<Employe> getAll(){ 
	   return employerepostory.findAll();  
   }
   public Employe AddEmploye( Employe e) {
	    e.setActived(true); 
	   return employerepostory.save(e);   
   }
   public Employe UpdateEmploye(Integer id , Employe e) {   
	   e.setId(id);
	    Employe C = employerepostory.save(e);
	      return C;
   }
   public List<Employe> findActived() {	
		return employerepostory.findEmployeeByactived(true);
	}
   
   public Employe FindById(Integer id) {	
	   Optional<Employe> o =employerepostory.findById(id);
		 if(o.isPresent())
			 return o.get();
		 else
			 return null;
	}
   
   public Employe deleteEmployerById(Integer id) {
		Employe e=employerepostory.getById(id);
		e.setActived(false);
		
	    return	employerepostory.save(e);
	}
}
