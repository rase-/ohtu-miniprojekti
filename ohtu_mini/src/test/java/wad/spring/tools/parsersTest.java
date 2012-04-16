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

    public Reference generate(){
        Reference reference = new Reference();
        reference.setAuthor("Vihavainen");
        reference.setBooktitle("älpälä");
        return reference;
    }
    /**
     * Test of parseScandit method, of class parsers.
     */
    @Test
    public void testParseScandit() {
        System.out.println("parseScandit");
        Reference toBeParsed = generate();
        Reference expResult = null;
        Reference result = parsers.parseScandit(toBeParsed);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parsePageNumber method, of class parsers.
     */
    @Test
    public void testParsePageNumber() {
        System.out.println("parsePageNumber");
        Reference toBeParsed = null;
        Reference expResult = null;
        Reference result = parsers.parsePageNumber(toBeParsed);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
