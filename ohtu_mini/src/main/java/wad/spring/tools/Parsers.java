package wad.spring.tools;

import java.util.List;
import wad.spring.domain.Reference;

public class Parsers {

    //Anni
    public static Reference parseScandit(Reference toBeParsed) {
        toBeParsed.setAuthor(skandi(toBeParsed.getAuthor()));
        toBeParsed.setTitle(skandi(toBeParsed.getTitle()));
        if (toBeParsed.getPublisher() != null) {
            toBeParsed.setPublisher(skandi(toBeParsed.getPublisher()));
        }
        if (toBeParsed.getAddress() != null) {
            toBeParsed.setAddress(skandi(toBeParsed.getAddress()));
        }
        if (toBeParsed.getBooktitle() != null) {
            toBeParsed.setBooktitle(skandi(toBeParsed.getBooktitle()));
        }

        return toBeParsed;
    }

    private static String skandi(String str) {
        if (str.contains("ä")) {
            str = str.replace("ä", "\\\"{a}");
        }
        if (str.contains("Ä")) {
            str = str.replace("Ä", "\\\"{A}");
        }
        if (str.contains("ö")) {
            str = str.replace("ö", "\\\"{o}");
        }
        if (str.contains("Ö")) {
            str = str.replace("Ö", "\\\"{O}");
        }
        if (str.contains("å")) {
            str = str.replace("å", "\\aa");
        }
        if (str.contains("Å")) {
            str = str.replace("Å", "\\AA");
        }
        return str;
    }

    //Markus
    public static Reference parsePageNumber(Reference toBeParsed) {
        if (toBeParsed.getPages() != null) {
            toBeParsed.setPages(toBeParsed.getPages().replace("-", "--"));
        }
        return toBeParsed;
    }

    public static Reference generateCite(Reference toBeGenerated) {
        String firstLetter = toBeGenerated.getAuthor().substring(0, 1);
        String year = toBeGenerated.getPublishingYear().substring(2);
        toBeGenerated.setReferenceCite(firstLetter + year);
        return toBeGenerated;
    }

    //Herkko
    public static boolean checkCites(List<Reference> list) {
        //tarkistetaan ettei yksikään Cite koodi ole samanlainen ja jos on, niin korvataan se uudella.

        return true;
    }
}
