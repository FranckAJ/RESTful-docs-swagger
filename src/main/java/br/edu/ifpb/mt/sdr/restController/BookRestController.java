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
import com.wordnik.swagger.annotations.Authorization;
import com.wordnik.swagger.annotations.AuthorizationScope;

import br.edu.ifpb.mt.sdr.model.Book;
import br.edu.ifpb.mt.sdr.repository.BookRepository;

@Api(value = "Book")
@RestController
@RequestMapping("/books")
public class BookRestController {

	@Autowired
	private BookRepository bookRepository;

	/**
	 * 
	 * @param Book
	 * @return
	 */
	@ApiOperation(value = "Save a new book", response=ResponseEntity.class, authorizations = {
		@Authorization(scopes= {@AuthorizationScope(scope="write:books", description="create book")}, value="bookAuth")

	})
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Book> save(@RequestBody Book Book) {

		Book BookSaved = bookRepository.save(Book);

		return new ResponseEntity<>(BookSaved, HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param Book
	 * @return
	 */
	@ApiOperation(value = "Update a book existing")
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Book> update(@RequestBody Book Book) {

		Book BookSaved = bookRepository.save(Book);

		return new ResponseEntity<>(BookSaved, HttpStatus.OK);
	}

	/**
	 * 
	 * @return
	 */
	@ApiOperation(value = "Find all books")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Book>> findAll() {
		List<Book> Books = bookRepository.findAll();

		return new ResponseEntity<>(Books, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "Find by ID", notes="this operation return a unic Book")
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Book> findById(@PathVariable Long id) {

		Book Book = bookRepository.findOne(id);

		if (Book == null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Book>(HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "Delete a book saved")
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Book> delete(@PathVariable Long id) {

		bookRepository.delete(new Book(id));

		return new ResponseEntity<Book>(HttpStatus.OK);
	}

}
