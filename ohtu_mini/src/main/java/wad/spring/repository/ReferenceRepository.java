/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.spring.domain.Reference;

/**
 *
 * @author tonykova
 */
public interface ReferenceRepository extends JpaRepository<Reference, Long> {
    Reference findByAuthor(String author);
    List<Reference> findByTag(String tag);
    
}


