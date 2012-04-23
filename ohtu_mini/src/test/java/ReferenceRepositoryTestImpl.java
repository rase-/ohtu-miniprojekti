


import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import wad.spring.domain.Reference;
import wad.spring.repository.ReferenceRepository;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tonykovanen
 */
@Repository
public class ReferenceRepositoryTestImpl implements ReferenceRepository {
    
    ArrayList<Reference> references = new ArrayList<Reference>();
    
    
    
    @Override
    public Reference findByAuthor(String author) {
        for (Reference r : references) {
            if (r.getAuthor().equals(author)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public List<Reference> findAll() {
        return references;
    }

    @Override
    public List<Reference> findAll(Sort sort) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Reference> save(Iterable<? extends Reference> itrbl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Reference saveAndFlush(Reference t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteInBatch(Iterable<Reference> itrbl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Page<Reference> findAll(Pageable pgbl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Reference save(Reference t) {;
        references.add(t);
        return t;
    }

    @Override
    public Reference findOne(Long id) {
        for (Reference r : references) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public boolean exists(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Long id) {
        for (int i = 0; i < references.size(); i++) {
            if (references.get(i).getId() == id) {
                references.remove(i);
                return;
            }
        }
    }

    @Override
    public void delete(Reference t) {
        references.remove(t);
    }

    @Override
    public void delete(Iterable<? extends Reference> itrbl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAll() {
        references.clear();
    }
    
}
