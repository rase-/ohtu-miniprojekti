package wad.spring.service;

import java.util.ArrayList;
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
        System.out.println(reference);
        System.out.println(reference.getTag());
        System.out.println(tag);
        if (reference.getTag() != null) {
            reference.getTag().add(tag);
        } else {
            ArrayList<String> tags = new ArrayList<String>();
            tags.add(tag);
            reference.setTag(tags);
        }
        referenceRepository.save(reference);
    }

    @Override
    public void deleteTag(Long referenceId, String tag) {
        Reference reference = referenceRepository.findOne(referenceId);
        reference.getTag().remove(tag);
        referenceRepository.save(reference);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Reference>listByTag(String tag){
        List<Reference> allReferences = referenceRepository.findAll();
        List<Reference> withCorrectTag = new ArrayList<Reference>();
        for (Reference r : allReferences) {
            if (r.getTag() != null && r.getTag().contains(tag)) {
                withCorrectTag.add(r);
            }
        }
        return withCorrectTag;
    }
}
