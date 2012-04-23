/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.tools;

import java.util.HashSet;
import org.junit.*;
import static org.junit.Assert.*;
import wad.spring.domain.Reference;
import wad.spring.domain.ReferenceType;

/**
 *
 * @author hjvirola
 */
public class ParsersTest {
    
    public ParsersTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
       
          }
    
    @After
    public void tearDown() {
    }

    public Reference generateParsittava(){
        Reference reference = new Reference();
        reference.setType(ReferenceType.INPROCEEDINGS);
        reference.setAuthor("Vihavainen");
        reference.setBooktitle("Nörttien päivä");
        reference.setAddress("USA");
        reference.setPublisher("ACM");
        reference.setTitle("kirja");
        reference.setJournal("journal");
        reference.setPublishingYear("2006");
        reference.setPages("3-7");
        
        return reference;
    }
    
    public Reference generateValmis(){
        Reference reference = new Reference();
        reference.setType(ReferenceType.INPROCEEDINGS);
        reference.setAuthor("Vihavainen");
        reference.setBooktitle("N\\\"{o}rttien p\\\"{a}iv\\\"{a}");
        reference.setAddress("USA");
        reference.setPublisher("ACM");
        reference.setTitle("kirja");
        reference.setJournal("journal");
        reference.setPages("3--7");
        reference.setPublishingYear("2006");
        reference.setReferenceCite("V06");
        return reference; 
    }
    /**
     * Test of parseScandit method, of class Parsers.
     */
    @Test
    public void testParseScandit() {
        System.out.println("parseScandit");
        Reference toBeParsed = generateParsittava();
        Reference expResult = generateValmis();
        Reference result = Parsers.parseScandit(toBeParsed);
        assertEquals(expResult.getBooktitle(), result.getBooktitle());
    }


    /**
     * Test of parsePageNumber method, of class Parsers.
     */
    @Test
    public void testParsePageNumber() {
        System.out.println("parsePageNumber");
        Reference toBeParsed = generateParsittava();
        Reference expResult = generateValmis();
        Reference result = Parsers.parsePageNumber(toBeParsed);
        assertEquals(expResult.getPages(), result.getPages());

    }

    @Test
    public void testGenerateCite(){
        System.out.println("Generate Cite");
        Reference toBeParsed = generateParsittava();
        Reference expResult = generateValmis();
        HashSet setti = new HashSet();
        Reference result = Parsers.generateCite(toBeParsed, setti);
        assertEquals(expResult.getReferenceCite(), result.getReferenceCite()); 
    }
    
    @Test
    public void testGenerateCiteWithSameCite(){
        Parsers.nollaaLaskuri();
        System.out.println("Generate Cite with same cite");
        Reference toBeParsed = generateParsittava();
        Reference expResult = generateValmis();
        expResult.setReferenceCite("V061");
        HashSet setti = new HashSet();
        Parsers.generateCite(toBeParsed, setti);
        Reference result = Parsers.generateCite(toBeParsed, setti);
        
        assertEquals(expResult.getReferenceCite(), result.getReferenceCite()); 
    }
    
    @Test
    public void citeGenerationCorrectWithOtherThanMisc() {
        Reference toBeParsed = generateParsittava();
        Reference expResult = generateValmis();
        expResult.setReferenceCite("V06");
        Parsers.generateCite(toBeParsed, new HashSet());
        assertEquals(expResult.getReferenceCite(), toBeParsed.getReferenceCite());
    }
    
    @Test
    public void citeGenerationCorrectWithMisc() {
        Reference toBeParsed = new Reference();
        toBeParsed.setType(ReferenceType.MISC);
        toBeParsed.setAuthor("Pekka");
        toBeParsed.setNote("lolz");
        Parsers.generateCite(toBeParsed, new HashSet());
        assertEquals("Pekka", toBeParsed.getReferenceCite());
    }
    
    @Test
    public void citeGenerationCorrectWithMiscWhenMissingAuthor() {
        Reference toBeParsed = new Reference();
        toBeParsed.setType(ReferenceType.MISC);
        toBeParsed.setNote("lolz");
        Parsers.nollaaLaskuri();
        Parsers.generateCite(toBeParsed, new HashSet());
        assertEquals("1", toBeParsed.getReferenceCite());
    }
}
