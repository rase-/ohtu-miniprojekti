
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SeleniumTest {
    
    HtmlUnitDriver driver;
    WebElement element;
    public SeleniumTest() {
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
    public void testAdd() {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/ohtu_mini");
        element = driver.findElement(By.linkText("Add"));
        element.click();
        element = driver.findElement(By.name("author"));      
        element.sendKeys("pekka");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Trolls of Science");
        element = driver.findElement(By.name("submit"));
        System.out.println("Elementti: "+element);
        element.submit();
        boolean pekka = driver.getPageSource().contains("pekka");
        Assert.assertEquals(true, pekka);       
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
