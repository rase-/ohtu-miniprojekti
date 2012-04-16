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
public class parsersTest {
    
    public parsersTest() {
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
        reference.setBooktitle("älpälä");
        reference.setAddress("löl");
        reference.setPublisher("läl");
        reference.setTitle("kirja");
        reference.setJournal("journal");
        reference.setPages("3-7");
        return reference;
    }
    
    public Reference generateValmis(){
       Reference reference = new Reference();
       reference.setAuthor("Vihavainen");
       reference.setBooktitle("\"{a}l\"{a}p\"{a}l\"{a}");
        reference.setAddress("l\"{o}l");
        reference.setPublisher("l\"{a}l");
        reference.setTitle("kirja");
        reference.setJournal("journal");
        reference.setPages("3--7");
        return reference; 
    }
    /**
     * Test of parseScandit method, of class parsers.
     */
    @Test
    public void testParseScandit() {
        System.out.println("parseScandit");
        Reference toBeParsed = generateParsittava();
        Reference expResult = generateValmis();
        Reference result = parsers.parseScandit(toBeParsed);
        assertEquals(expResult.getAuthor(), result.getAuthor());
     
    }

    /**
     * Test of parsePageNumber method, of class parsers.
     */
    @Test
    public void testParsePageNumber() {
        System.out.println("parsePageNumber");
        Reference toBeParsed = generateParsittava();
        Reference expResult = generateValmis();
        Reference result = parsers.parsePageNumber(toBeParsed);
        assertEquals(expResult.getPages(), result.getPages());

    }
}
