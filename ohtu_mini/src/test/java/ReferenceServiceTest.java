



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wad.spring.domain.Reference;
import wad.spring.domain.ReferenceType;
import wad.spring.service.ReferenceService;

/**
 *
 * @author tonykovanen
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ReferenceServiceConfig.class)
public class ReferenceServiceTest {
    
    @Autowired
    private ReferenceService referenceService;
    
    
    
    public ReferenceServiceTest() {
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
    
    @Test
    public void additionOfNewReferenceIncrementsTotalAmount() {
        int firstAmount = referenceService.listAllReferences().size();
        Reference reference = new Reference();
        reference.setId(Long.valueOf(90));
        reference.setAuthor("Pekka");
        referenceService.addReference(reference);
        Assert.assertEquals(firstAmount + 1, referenceService.listAllReferences().size());
    }
    
    
    @Test
    public void listingOfReferencesListsAllReferences() {
        int firstAmount = referenceService.listAllReferences().size();
        Reference[] added = new Reference[3];
        for (int i = 0; i < 3; i++) {
            Reference r = new Reference();
            r.setId(Long.valueOf("" + i));
            added[i] = r;
            referenceService.addReference(r);
        }
        
        Assert.assertEquals(firstAmount + 3, referenceService.listAllReferences().size());
    }
    
    @Test
    public void deletionOfReferenceDecrementsAmount() {
        int firstAmount = referenceService.listAllReferences().size();
        Reference r = new Reference();
        r.setId(Long.valueOf(10));
        referenceService.addReference(r);
        referenceService.deleteReference(Long.valueOf(1));
        Assert.assertEquals(firstAmount, referenceService.listAllReferences().size());
    }
    
    @Test
    public void taggingOfReferenceAddsTag() {
        Reference r = new Reference();
        r.setId(Long.valueOf(9000));
        r.setAuthor("Lolz");
        r.setType(ReferenceType.ARTICLE);
        r.setTag(new ArrayList<String>());
        referenceService.addReference(r);
        r = referenceService.findOne(Long.valueOf(9000));
        referenceService.tagReference(r, "tagged");
        assertEquals("tagged", referenceService.findOne(Long.valueOf(9000)).getTag().get(0));
    }
    
}
