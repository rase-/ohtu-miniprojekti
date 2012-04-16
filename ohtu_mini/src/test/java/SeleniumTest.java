
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SeleniumTest {
    
    HtmlUnitDriver driver;
    WebElement element;
    boolean testable = false;
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
    public void creationSuccessful() {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/ohtu_mini");
        element = driver.findElement(By.linkText("Add"));
        element.click();
        element = driver.findElement(By.name("author"));      
        element.sendKeys("pekka");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Trolls of Science");
        element = driver.findElement(By.name("submit"));
        element.submit();
        testable = driver.getPageSource().contains("pekka");
        Assert.assertEquals(true, testable);       
    }
    
    @Test
    public void creationNotSuccessfulNoAuthor() {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/ohtu_mini");
        element = driver.findElement(By.linkText("Add"));
        element.click();
        element = driver.findElement(By.name("author"));      
        element.sendKeys("");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Trolls of Science");
        element = driver.findElement(By.name("submit"));
        element.submit();
        testable = driver.getPageSource().contains("pekka");
        Assert.assertEquals(false, testable);       
    }
    
    @Test
    public void creationNotSuccessfulNoTitle() {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/ohtu_mini");
        element = driver.findElement(By.linkText("Add"));
        element.click();
        element = driver.findElement(By.name("author"));      
        element.sendKeys("pekka");
        element = driver.findElement(By.name("title"));
        element.sendKeys("");
        element = driver.findElement(By.name("submit"));
        element.submit();
        testable = driver.getPageSource().contains("Trolls of Science");
        Assert.assertEquals(false, testable); 
    }
    @Test
    public void creationSuccessfulWithPages() {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/ohtu_mini");
        element = driver.findElement(By.linkText("Add"));
        element.click();
        element = driver.findElement(By.name("author"));      
        element.sendKeys("pekka");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Trolls of Science");
        element = driver.findElement(By.name("pages"));
        element.sendKeys("123-456");
        element = driver.findElement(By.name("submit"));
        element.submit();
        testable = driver.getPageSource().contains("123-456");
        Assert.assertEquals(true, testable); 
    }
        
    @Test
    public void creationSuccessfulWithYear() {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/ohtu_mini");
        element = driver.findElement(By.linkText("Add"));
        element.click();
        element = driver.findElement(By.name("author"));      
        element.sendKeys("pekka");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Trolls of Science");
        element = driver.findElement(By.name("publishingYear"));
        element.sendKeys("2012");
        element = driver.findElement(By.name("submit"));
        element.submit();
        testable = driver.getPageSource().contains("2012");
        Assert.assertEquals(true, testable); 
    }
    
    @Test
    public void creationNotSuccessfulPagesWrong() {

    }
    
    @Test
    public void creationNotSuccessfulYearWrong() {

    }
}
