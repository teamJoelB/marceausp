package fr.marceau.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import fr.marceau.dao.PersonRepository;
import fr.marceau.entities.Person;

@RestController @CrossOrigin("*")
public class PersonRest {
	
	@Autowired
	PersonRepository personRepo;
	
	@GetMapping("/person")
	public List<Person> getAllPerson(){
		return personRepo.findAll();
	}
	
	@PostMapping("/person")
	public Person savePerson(@RequestBody Person p) {
		return personRepo.save(p);
	}
	
	@GetMapping("/person/{id}")
	public Optional<Person> getById(@PathVariable Long id){
		return personRepo.findById(id);
	}
	
	@DeleteMapping("/person/{id}")
	public boolean deletePerson(@PathVariable Long id) {
		 personRepo.deleteById(id);
		 return true;
	}
	
	@PutMapping("/person/{id}")
	public Person modifPerson(@RequestBody Person p, @PathVariable Long id) {
		p.setId(id);
		return personRepo.save(p);
	}
	
	@PostMapping("/login")
	public Optional<Person> connexion(@RequestBody Person p) {
		Optional<Person> pe = personRepo.findByLoginAndPassword(p.getLogin(), p.getPassword());
		
		return pe;
	}

}
