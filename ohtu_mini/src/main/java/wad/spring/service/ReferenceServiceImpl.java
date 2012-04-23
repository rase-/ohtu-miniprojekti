package wad.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.spring.domain.Reference;
import wad.spring.repository.ReferenceRepository;

/**
 *
 * @author tonykova
 */
@Service
public class ReferenceServiceImpl implements ReferenceService {

    
    ReferenceRepository referenceRepository;
    
    @Autowired
    public ReferenceServiceImpl(ReferenceRepository referenceRepository) {
        this.referenceRepository = referenceRepository;
    }
    

    @Override
    @Transactional
    public void addReference(Reference reference) {
        referenceRepository.save(reference);
    }

    @Override
    @Transactional
    public void deleteReference(Long id) {
        referenceRepository.delete(id);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Reference> listAllReferences() {
        return referenceRepository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Reference findOne(Long id) {
        return referenceRepository.findOne(id);
    }
    
    @Override
    @Transactional
    public void tagReference(Reference reference, String tag) {
        reference.setTag(tag);
        referenceRepository.save(reference);
    }
}
