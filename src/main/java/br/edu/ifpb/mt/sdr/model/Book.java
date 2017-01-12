package br.edu.ifpb.mt.sdr.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * 
 * <p>
 * <b> Book </b>
 * </p>
 *
 * <p>
 * represents the entity of business Book
 * </p>
 * 
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Entity
@Table(name = "BOOK")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotBlank
	private String title;

	@NotBlank
	private String description;

	@Min(50)
	private Integer numbeOfPages;

	@Valid
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Author> authors = new HashSet<>();
	
	public void addAuthor(Author author){
		authors.add(author);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNumbeOfPages() {
		return numbeOfPages;
	}

	public void setNumbeOfPages(Integer numbeOfPages) {
		this.numbeOfPages = numbeOfPages;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

}
