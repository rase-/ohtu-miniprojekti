
package wad.spring.tools;

import wad.spring.domain.Reference;

public class parsers {
    
    
    public static Reference parseScandit(Reference toBeParsed){
        toBeParsed.setAuthor(skandi(toBeParsed.getAuthor()));
        toBeParsed.setTitle(skandi(toBeParsed.getTitle()));
        if(toBeParsed.getPublisher() != null)
            toBeParsed.setPublisher(skandi(toBeParsed.getPublisher()));        
        if(toBeParsed.getAddress() != null)
            toBeParsed.setAddress(skandi(toBeParsed.getAddress()));
        if(toBeParsed.getBooktitle() != null)
            toBeParsed.setBooktitle(skandi(toBeParsed.getBooktitle()));
        
        return toBeParsed;
    }
    
    private static String skandi(String str) {
        if(str.contains("ä"))
            str = str.replace("ä", "\\\"{a}");
        if(str.contains("Ä"))
            str = str.replace("Ä", "\\\"{A}");
        if(str.contains("ö"))
            str = str.replace("ö", "\\\"{o}");
        if(str.contains("Ö"))
            str = str.replace("Ö", "\\\"{O}");        
        if(str.contains("å"))
            str = str.replace("å", "\\aa");
        if(str.contains("Å"))
            str = str.replace("Å", "\\AA");        
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
