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
        
        List<Reference> allReferences = referenceRepository.findAll();
        for (int i=0; i<allReferences.size(); i++){
            parsers.parsePageNumber(allReferences.get(i));
            parsers.parseScandit(allReferences.get(i));   
            parsers.generateCite(allReferences.get(i));
        }
        
        return generateString(allReferences);
        
    }
    
    
    public static String generateString(List<Reference> AllReferences){
        
        
        
        return "trololoo";
    }
    
}
