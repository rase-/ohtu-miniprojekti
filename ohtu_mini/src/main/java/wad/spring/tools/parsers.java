
package wad.spring.tools;

import wad.spring.domain.Reference;

public class parsers {
    
    
    public static Reference parseScandit(Reference toBeParsed){
        
        return toBeParsed;
    }
    
    public static Reference parsePageNumber(Reference toBeParsed){
        
        
        return toBeParsed;
    }
    
    public static Reference generateCite(Reference toBeGenerated){
        String firstLetter = toBeGenerated.getAuthor();
        firstLetter = firstLetter.substring(0, 1);
        
        String year = toBeGenerated.getPublishingYear();
        year = year.substring(2);
        String palautettava = firstLetter + year;
        
        toBeGenerated.setReferenceCite(palautettava);
        return toBeGenerated;
    }
}
