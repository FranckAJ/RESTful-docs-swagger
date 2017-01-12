package br.edu.ifpb.mt.sdr.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

import br.edu.ifpb.mt.sdr.model.Author;
import br.edu.ifpb.mt.sdr.repository.AuthorRepository;

@Api(value = "author")
@RestController
@RequestMapping("/authors")
public class AuthorRestController {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	/**
	 * 
	 * @param author
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Author> save(@RequestBody Author author){
		
		Author authorSaved = authorRepository.save(author);
		
		return new ResponseEntity<>(authorSaved, HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Author>> findAll(){
		List<Author> authors = authorRepository.findAll();
	
		return new ResponseEntity<>(authors, HttpStatus.OK);
	}

}
