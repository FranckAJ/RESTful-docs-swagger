package br.edu.ifpb.mt.sdr.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import br.edu.ifpb.mt.sdr.model.Author;
import br.edu.ifpb.mt.sdr.repository.AuthorRepository;

/**
 * 
 * <p>
 * <b> Rest Controller @Author </b>
 * </p>
 *
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Api(value = "Author")
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
	@ApiOperation(value="Save a new Author", tags="author, save, new")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Author> save(@RequestBody Author author){
		
		Author authorSaved = authorRepository.save(author);
		
		return new ResponseEntity<>(authorSaved, HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param Author
	 * @return
	 */
	@ApiOperation(value = "Update a book existing")
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Author> update(@RequestBody Author author) {

		Author authorUpdated = authorRepository.save(author);

		return new ResponseEntity<>(authorUpdated, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @return
	 */
	@ApiOperation(value="Find all authors")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Author>> findAll(){
		List<Author> authors = authorRepository.findAll();
	
		return new ResponseEntity<>(authors, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="Find by ID")
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<Author> findById(@PathVariable Long id) {
		
		Author author = authorRepository.findOne(id);
		
		if(author == null){
			return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Author>(HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="Delete a author saved")
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<Author> delete(@PathVariable Long id) {
		
		authorRepository.delete(new Author(id));
		
		return new ResponseEntity<Author>(HttpStatus.OK);
	}

}
