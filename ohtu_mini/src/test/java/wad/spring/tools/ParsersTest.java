/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.tools;

import org.junit.*;
import static org.junit.Assert.*;
import wad.spring.domain.Reference;

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
        reference.setAuthor("Vihavainen");
//        reference.setBooktitle("älpälä");
        reference.setBooktitle("Nörttien päivä");
        reference.setAddress("löl");
        reference.setPublisher("läl");
        reference.setTitle("kirja");
        reference.setJournal("journal");
        reference.setPublishingYear("2006");
        reference.setPages("3-7");
        
        return reference;
    }
    
    public Reference generateValmis(){
        Reference reference = new Reference();
        reference.setAuthor("Vihavainen");
//        reference.setBooktitle("\"{a}l\"{a}p\"{a}l\"{a}");
        reference.setBooktitle("N\\\"{o}rttien p\\\"{a}iv\\\"{a}");
        reference.setAddress("l\"{o}l");
        reference.setPublisher("l\"{a}l");
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
//        assertEquals(expResult.getAuthor(), result.getAuthor());
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

//    @Test
//    public void testGenerateCite(){
//        System.out.println("Generate Cite");
//        Reference toBeParsed = generateParsittava();
//        Reference expResult = generateValmis();
//        Reference result = Parsers.generateCite(toBeParsed);
//        assertEquals(expResult.getReferenceCite(), result.getReferenceCite()); 
//    }
}
