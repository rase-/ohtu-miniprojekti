/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.domain;

import java.util.HashSet;
import org.junit.*;
import static org.junit.Assert.*;
import wad.spring.tools.Parsers;

/**
 *
 * @author hjvirola
 */
public class ReferenceTest {
    
    public ReferenceTest() {
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

    /**
     * Test of equals method, of class Reference.
     */
//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object o = null;
//        Reference instance = new Reference();
//        boolean expResult = false;
//        boolean result = instance.equals(o);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setAddress method, of class Reference.
//     */
//    @Test
//    public void testSetAddress() {
//        System.out.println("setAddress");
//        String address = "";
//        Reference instance = new Reference();
//        instance.setAddress(address);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setAuthor method, of class Reference.
//     */
//    @Test
//    public void testSetAuthor() {
//        System.out.println("setAuthor");
//        String author = "";
//        Reference instance = new Reference();
//        instance.setAuthor(author);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setBooktitle method, of class Reference.
//     */
//    @Test
//    public void testSetBooktitle() {
//        System.out.println("setBooktitle");
//        String booktitle = "";
//        Reference instance = new Reference();
//        instance.setBooktitle(booktitle);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setJournal method, of class Reference.
//     */
//    @Test
//    public void testSetJournal() {
//        System.out.println("setJournal");
//        String journal = "";
//        Reference instance = new Reference();
//        instance.setJournal(journal);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setNumber method, of class Reference.
//     */
//    @Test
//    public void testSetNumber() {
//        System.out.println("setNumber");
//        int number = 0;
//        Reference instance = new Reference();
//        instance.setNumber(number);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPages method, of class Reference.
//     */
//    @Test
//    public void testSetPages() {
//        System.out.println("setPages");
//        String pages = "";
//        Reference instance = new Reference();
//        instance.setPages(pages);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPublisher method, of class Reference.
//     */
//    @Test
//    public void testSetPublisher() {
//        System.out.println("setPublisher");
//        String publisher = "";
//        Reference instance = new Reference();
//        instance.setPublisher(publisher);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPublishingYear method, of class Reference.
//     */
//    @Test
//    public void testSetPublishingYear() {
//        System.out.println("setPublishingYear");
//        String publishingYear = "";
//        Reference instance = new Reference();
//        instance.setPublishingYear(publishingYear);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setTitle method, of class Reference.
//     */
//    @Test
//    public void testSetTitle() {
//        System.out.println("setTitle");
//        String title = "";
//        Reference instance = new Reference();
//        instance.setTitle(title);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setType method, of class Reference.
//     */
//    @Test
//    public void testSetType() {
//        System.out.println("setType");
//        ReferenceType type = null;
//        Reference instance = new Reference();
//        instance.setType(type);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setVolume method, of class Reference.
//     */
//    @Test
//    public void testSetVolume() {
//        System.out.println("setVolume");
//        int volume = 0;
//        Reference instance = new Reference();
//        instance.setVolume(volume);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getReferenceCite method, of class Reference.
//     */
//    @Test
//    public void testGetReferenceCite() {
//        System.out.println("getReferenceCite");
//        Reference instance = new Reference();
//        String expResult = "";
//        String result = instance.getReferenceCite();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setReferenceCite method, of class Reference.
//     */
//    @Test
//    public void testSetReferenceCite() {
//        System.out.println("setReferenceCite");
//        String referenceCite = "";
//        Reference instance = new Reference();
//        instance.setReferenceCite(referenceCite);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAddress method, of class Reference.
//     */
//    @Test
//    public void testGetAddress() {
//        System.out.println("getAddress");
//        Reference instance = new Reference();
//        String expResult = "";
//        String result = instance.getAddress();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAuthor method, of class Reference.
//     */
//    @Test
//    public void testGetAuthor() {
//        System.out.println("getAuthor");
//        Reference instance = new Reference();
//        String expResult = "";
//        String result = instance.getAuthor();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getBooktitle method, of class Reference.
//     */
//    @Test
//    public void testGetBooktitle() {
//        System.out.println("getBooktitle");
//        Reference instance = new Reference();
//        String expResult = "";
//        String result = instance.getBooktitle();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getJournal method, of class Reference.
//     */
//    @Test
//    public void testGetJournal() {
//        System.out.println("getJournal");
//        Reference instance = new Reference();
//        String expResult = "";
//        String result = instance.getJournal();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getNumber method, of class Reference.
//     */
//    @Test
//    public void testGetNumber() {
//        System.out.println("getNumber");
//        Reference instance = new Reference();
//        int expResult = 0;
//        int result = instance.getNumber();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPages method, of class Reference.
//     */
//    @Test
//    public void testGetPages() {
//        System.out.println("getPages");
//        Reference instance = new Reference();
//        String expResult = "";
//        String result = instance.getPages();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPublisher method, of class Reference.
//     */
//    @Test
//    public void testGetPublisher() {
//        System.out.println("getPublisher");
//        Reference instance = new Reference();
//        String expResult = "";
//        String result = instance.getPublisher();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPublishingYear method, of class Reference.
//     */
//    @Test
//    public void testGetPublishingYear() {
//        System.out.println("getPublishingYear");
//        Reference instance = new Reference();
//        String expResult = "";
//        String result = instance.getPublishingYear();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTitle method, of class Reference.
//     */
//    @Test
//    public void testGetTitle() {
//        System.out.println("getTitle");
//        Reference instance = new Reference();
//        String expResult = "";
//        String result = instance.getTitle();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getType method, of class Reference.
//     */
//    @Test
//    public void testGetType() {
//        System.out.println("getType");
//        Reference instance = new Reference();
//        ReferenceType expResult = null;
//        ReferenceType result = instance.getType();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getVolume method, of class Reference.
//     */
//    @Test
//    public void testGetVolume() {
//        System.out.println("getVolume");
//        Reference instance = new Reference();
//        int expResult = 0;
//        int result = instance.getVolume();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setId method, of class Reference.
//     */
//    @Test
//    public void testSetId() {
//        System.out.println("setId");
//        Long id = null;
//        Reference instance = new Reference();
//        instance.setId(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getId method, of class Reference.
//     */
//    @Test
//    public void testGetId() {
//        System.out.println("getId");
//        Reference instance = new Reference();
//        Long expResult = null;
//        Long result = instance.getId();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of toString method, of class Reference.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Reference instance = generateParsittava();
      
        
        String expResult = "@book{V06,\nauthor = {Vihavainen},\ntitle = {ohjelmistotuotannon perusteet},\nyear = {2006},\n}";
        String result = Parsers.generateCite(instance, new HashSet()).toString();
        System.out.println(instance.toString());
        assertEquals(expResult, result); //ei siis valmis

    }
    
       public Reference generateParsittava(){
        Reference reference = new Reference();
        reference.setType(ReferenceType.BOOK);
        reference.setAuthor("Vihavainen");
        reference.setTitle("ohjelmistotuotannon perusteet");
        reference.setPublishingYear("2006");
        reference.setReferenceCite("V06");
        
        return reference;
    }
}
