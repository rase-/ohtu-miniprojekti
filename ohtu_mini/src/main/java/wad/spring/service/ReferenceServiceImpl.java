/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
    @Autowired
    ReferenceRepository repo;
    
    @Override
    @Transactional
    public void addReference(Reference reference) {
        repo.save(reference);
    }

}
