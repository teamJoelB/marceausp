package fr.marceau.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.marceau.dao.MemoRepository;
import fr.marceau.entities.Memo;

@RestController @CrossOrigin("*")
public class MemoRest {
	
	@Autowired
	MemoRepository memoRepo;
	
	@GetMapping("/memo")
	public List<Memo> getAllMemo(){
		return memoRepo.findAll();
	}
	
	@PostMapping("/memo")
	public Memo saveMemo(@RequestBody Memo m){
		return memoRepo.save(m);
	}

}
