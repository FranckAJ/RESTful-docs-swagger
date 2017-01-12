package br.edu.ifpb.mt.sdr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * 
 * <p>
 * <b> Auhtor </b>
 * </p>
 *
 * <p>
 * represents the entity of business author
 * </p>
 * 
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Entity
public class Author {

	@Id
	@GeneratedValue
	private Long id;

	@NotBlank
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
