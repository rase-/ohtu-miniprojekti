
package wad.spring.tools;

import java.util.List;
import wad.spring.domain.Reference;

public class parsers {
    
    //Anni
    public static Reference parseScandit(Reference toBeParsed){
        
        return toBeParsed;
    }
    
    //Markus
    public static Reference parsePageNumber(Reference toBeParsed){
        
        
        return toBeParsed;
    }
    
    public static Reference generateCite(Reference toBeGenerated){
        String firstLetter = toBeGenerated.getAuthor().substring(0,1);
        String year = toBeGenerated.getPublishingYear().substring(2);
        toBeGenerated.setReferenceCite(firstLetter + year);
        return toBeGenerated;
    }
    
    //Herkko
    public static boolean checkCites(List<Reference> list){
        //tarkistetaan ettei yksikään Cite koodi ole samanlainen ja jos on, niin korvataan se uudella.
        
        return true;
    }
}
