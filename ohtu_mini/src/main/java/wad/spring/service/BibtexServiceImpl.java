/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.spring.repository.ReferenceRepository;
import wad.spring.tools.parsers;

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
        
        parsers.parsePageNumber("trololoo");
        parsers.parseScandit("trololoo");
        return "trolol";
    }
    
    
   
    
    
}
