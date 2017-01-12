package br.edu.ifpb.mt.sdr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.mt.sdr.model.Author;

/**
 * 
 * 
 * <p>
 * <b> Author Repository </b>
 * </p>
 *
 * <p>
 * This is repository of a @Author 
 * </p>
 * 
 * <pre>
 * @see <a href="https://link.reference>Link Reference</a>
 * </pre>
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
