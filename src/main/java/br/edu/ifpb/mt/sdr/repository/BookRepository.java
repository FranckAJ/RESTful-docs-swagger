package br.edu.ifpb.mt.sdr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.mt.sdr.model.Book;

/**
 * 
 * 
 * <p>
 * <b> Book Repository </b>
 * </p>
 *
 * <p>
 * This is repositoty of a @Book 
 * </p>
 * 
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
