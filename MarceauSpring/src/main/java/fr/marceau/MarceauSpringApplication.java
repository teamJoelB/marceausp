package fr.marceau;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.marceau.dao.MemoRepository;
import fr.marceau.dao.PersonRepository;
import fr.marceau.entities.Memo;
import fr.marceau.entities.Person;

@SpringBootApplication
public class MarceauSpringApplication implements CommandLineRunner {
	
	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	MemoRepository memoRepo;

	public static void main(String[] args) {
		SpringApplication.run(MarceauSpringApplication.class, args);
		
		System.out.println("Lancement terminé avec success");
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Debut de lancement");
		
		Person p1 = new Person(null, "Joel", 14, "jojo", "jojo");
		Person p2 = new Person(null, "Jojo", 17, "jo", "jo");
		Person p3 = new Person(null, "Marceau", 19, "marc", "marc");
		
		personRepo.save(p1);
		personRepo.save(p2);
		personRepo.save(p3);
		
		Memo m1 = new Memo(null, "rdv demain avec Nico", null, p1);
		Memo m2 = new Memo(null, "tester l'app de momo", null, p2);
		Memo m3 = new Memo(null, "appel jean ce soir", null, p3);
		Memo m4 = new Memo(null, "manger indien cette semaine", null, p1);
		Memo m5 = new Memo(null, "être inspirer a la réunion", null, p1);
		Memo m6 = new Memo(null, "re motivé l'équipe le matin", null, p2);
		
		Stream.of(m1, m2, m3, m4, m5, m6).forEach(m -> {
			memoRepo.save(m);
		});
		
		
		personRepo.findAll().forEach(p -> {
			System.out.println(p.toString());
		});
		
		System.out.println("--------------------------------------------------------------");
		
		Optional<Person> p = personRepo.findById((long) 2);
		System.out.println(p.get().toString());
		
		System.out.println("--------------------------------------------------------------");
		
		Person pe = personRepo.findByNom("Marceau");
		System.out.println(pe.toString());
		
	}

}
