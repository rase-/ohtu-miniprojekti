package wad.spring.tools;

import java.util.HashSet;
import java.util.List;
import wad.spring.domain.Reference;

public class Parsers {
private static long citelaskuri = 1;
    //Anni
    public static Reference parseScandit(Reference toBeParsed) {
        if (toBeParsed.getAuthor() != null) {
            toBeParsed.setAuthor(skandi(toBeParsed.getAuthor()));
        }
        if (toBeParsed.getTitle() != null) {
            toBeParsed.setTitle(skandi(toBeParsed.getTitle()));
        }
        if (toBeParsed.getPublisher() != null) 
            toBeParsed.setPublisher(skandi(toBeParsed.getPublisher()));
        if (toBeParsed.getAddress() != null) 
            toBeParsed.setAddress(skandi(toBeParsed.getAddress()));
        if (toBeParsed.getBooktitle() != null) 
            toBeParsed.setBooktitle(skandi(toBeParsed.getBooktitle()));
        if (toBeParsed.getNote() != null)
            toBeParsed.setNote(skandi(toBeParsed.getNote()));
        if (toBeParsed.getAddress() != null) {
            toBeParsed.setAddress(skandi(toBeParsed.getAddress()));
        }
        if (toBeParsed.getJournal() != null) {
            toBeParsed.setJournal(skandi(toBeParsed.getJournal()));
        }
        return toBeParsed;
    }

    private static String skandi(String str) {
        str = str.replace("ä", "\\\"{a}");
        str = str.replace("Ä", "\\\"{A}");
        str = str.replace("ö", "\\\"{o}");
        str = str.replace("Ö", "\\\"{O}");
        str = str.replace("å", "\\aa");
        str = str.replace("Å", "\\AA");
        return str;
    }

    //Markus
    public static Reference parsePageNumber(Reference toBeParsed) {
        if (toBeParsed.getPages() != null) {
            toBeParsed.setPages(toBeParsed.getPages().replace("-", "--"));
        }
        return toBeParsed;
    }

    public static Reference generateCite(Reference toBeGenerated, HashSet codes) {
        String firstLetter = toBeGenerated.getAuthor().substring(0, 1);
        String year = toBeGenerated.getPublishingYear().substring(2);
        String citeCode = firstLetter + year;
        toBeGenerated.setReferenceCite(citeCode);
        
        if (codes.add(citeCode)) return toBeGenerated;
        else {
           
            citeCode = citeCode+citelaskuri;
            citelaskuri++;
            toBeGenerated.setReferenceCite(citeCode);
            codes.add(citeCode);
        }
        
        
        return toBeGenerated;
    }

  

   
}
