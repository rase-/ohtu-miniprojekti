/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.spring.repository.ReferenceRepository;
import wad.spring.tools.parsers;
import wad.spring.domain.Reference;
/**
 *
 * @author tonykova
 */
@Service
public class BibtexServiceImpl implements BibtexService {
    @Autowired
    ReferenceRepository referenceRepository;
    
    @Override
    public String generateBibtex() {
        
        List AllReferences = referenceRepository.findAll();
        for (int i=0; i<AllReferences.size(); i++){
            Reference parsittava = (Reference)AllReferences.get(i);
            parsers.parsePageNumber(parsittava);
            parsers.parseScandit(parsittava);   
        }
        
        return "trolol";
    }
    
    
}
