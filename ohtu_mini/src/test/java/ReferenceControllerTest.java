import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.request.MockMvcRequestBuilders;
import org.springframework.test.web.server.result.MockMvcResultMatchers;
import org.springframework.test.web.server.setup.MockMvcBuilders;
import wad.spring.form.FileForm;

/**
 *
 * @author tonykovanen
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-context.xml", 
    "file:src/main/webapp/WEB-INF/spring-database.xml"})
public class ReferenceControllerTest {
    private MockMvc mockMvc;
    
    public ReferenceControllerTest() {
    }
    
    @Before
    public void setUp() {
        String[] contextLoc = {"file:src/main/webapp/WEB-INF/spring-context.xml",
            "file:src/main/webapp/WEB-INF/spring-database.xml"};
        String warDir = "src/main/webapp";
        mockMvc = MockMvcBuilders.xmlConfigSetup(contextLoc).
                configureWebAppRootDir(warDir, false).build();
    }
    
    @Test
    public void referenceRedirectsToFormWithFormAttributeReference() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reference")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/view/reference.jsp")).
                andExpect(MockMvcResultMatchers.model().size(1)).
                andExpect(MockMvcResultMatchers.model().attributeExists("reference"));
    }
    
    @Test
    public void noSpecifiedAddressRedirectedHome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/view/home.jsp"));
    }
    
    @Test
    public void showBibtexPageRedirectsCorrectlyWithFormAttribute() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reference/bibtex")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/view/bibtex.jsp")).
                andExpect(MockMvcResultMatchers.model().size(1)).
                andExpect(MockMvcResultMatchers.model().attributeExists("fileForm"));
    }
    
    @Test
    public void showTaggingPageRedirectsCorrectlyWithTagForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reference/1/tag")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/view/tag.jsp")).
                andExpect(MockMvcResultMatchers.model().size(2)).
                andExpect(MockMvcResultMatchers.model().attributeExists("tagForm"));
    }
    
//    @Test
//    public void generateBibtexContentTypeIsOctetStream() throws Exception {
//        FileForm fileForm = new FileForm();
//        fileForm.setFilename("lolz");
//        mockMvc.perform(MockMvcRequestBuilders.post("/reference/bibtex/", fileForm)).
//                andExpect(MockMvcResultMatchers.status().isOk()).
//                andExpect(MockMvcResultMatchers.content().type("application/octet-stream"));
//    }
    
}
