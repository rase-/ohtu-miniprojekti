
package wad.spring.tools;

import wad.spring.domain.Reference;

public class parsers {
    
    
    public static Reference parseScandit(Reference toBeParsed){
        toBeParsed.setAuthor(skandi(toBeParsed.getAuthor()));
        toBeParsed.setBooktitle(skandi(toBeParsed.getBooktitle()));
        
        return toBeParsed;
    }
    
    private static String skandi(String str) {
        String a = "\\\"{a}"; //ä
        String o = "\\\"{o}"; //ö
        if(str.contains("ä"))
            str = str.replace("ä", a);
        if(str.contains("ö"))
            str = str.replace("ö", o);
        System.out.println(str);
        return str;
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
