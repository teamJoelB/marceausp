package fr.marceau.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.marceau.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
	public Person findByNom(String nom);
	
	public Optional<Person> findByLoginAndPassword(String login, String pass);

}
