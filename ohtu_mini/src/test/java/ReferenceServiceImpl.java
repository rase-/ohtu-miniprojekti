/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.spring.domain.Reference;
import wad.spring.repository.ReferenceRepository;
import wad.spring.service.ReferenceService;

/**
 *
 * @author tonykovanen
 */
@Service
public class ReferenceServiceImpl implements ReferenceService {

    private ReferenceRepository referenceRepo;

    public ReferenceServiceImpl() {
    }

    @Autowired
    public ReferenceServiceImpl(ReferenceRepository teamRepository) {
        this.referenceRepo = teamRepository;
    }

    @Override
    public void addReference(Reference reference) {
        referenceRepo.save(reference);
    }

    @Override
    public List<Reference> listAllReferences() {
        return referenceRepo.findAll();
    }

    @Override
    public void deleteReference(Long id) {
        referenceRepo.delete(id);
    }

    @Override
    public Reference findOne(Long id) {
        return referenceRepo.findOne(id);
    }

    @Override
    public void tagReference(Reference reference, String tag) {
        reference.setTag(tag);
        referenceRepo.save(reference);
    }
}