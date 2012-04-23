/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.spring.repository.ReferenceRepository;
import wad.spring.tools.Parsers;
import wad.spring.domain.Reference;

/**
 *
 * @author tonykova
 */
@Service
public class BibtexServiceImpl implements BibtexService {
    ReferenceRepository referenceRepository;
    
    
    @Autowired
    public BibtexServiceImpl(ReferenceRepository referenceRepository) {
        this.referenceRepository = referenceRepository;
    }
    
    @Override
    public String generateBibtex() {

        List<Reference> allReferences = referenceRepository.findAll();
        HashSet citeCodes = new HashSet();

        for (int i = 0; i < allReferences.size(); i++) {
            Parsers.generateCite(allReferences.get(i), citeCodes);
            Parsers.parsePageNumber(allReferences.get(i));
            Parsers.parseScandit(allReferences.get(i));
        }

        return generateString(allReferences);
    }

    private static String generateString(List<Reference> allReferences) {
        String palautettava = "";

        for (int i = 0; i < allReferences.size(); i++) {
            String yhdistettava = allReferences.get(i).toString();
            palautettava = palautettava + "\n\n" + yhdistettava;
        }


        return palautettava;
    }
    
    
}
