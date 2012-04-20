
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SeleniumIT {
    
    HtmlUnitDriver driver;
    WebElement element;
    boolean testable = false;
    String address = "http://localhost:9090/v6-pilveen";
    public SeleniumIT() {
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
        driver.get(address);
        element = driver.findElement(By.linkText("Add"));
        element.click();
        element = driver.findElement(By.name("author"));      
        element.sendKeys("pekka");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Trolls of Science");
        element = driver.findElement(By.name("submit"));
        element = driver.findElement(By.name("publishingYear"));
        element.sendKeys("1992");
        element.submit();
        testable = driver.getPageSource().contains("pekka");
        Assert.assertEquals(true, testable);       
    }
    
    @Test
    public void creationNotSuccessfulNoAuthor() {
        driver = new HtmlUnitDriver();
        driver.get(address);
        element = driver.findElement(By.linkText("Add"));
        element.click();
        element = driver.findElement(By.name("author"));      
        element.sendKeys("");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Trolls of Science");
        element = driver.findElement(By.name("publishingYear"));
        element.sendKeys("1992");
        element = driver.findElement(By.name("submit"));
        element.submit();
        testable = driver.getPageSource().contains("pekka");
        Assert.assertEquals(false, testable);       
    }
    
    @Test
    public void creationNotSuccessfulNoTitle() {
        driver = new HtmlUnitDriver();
        driver.get(address);
        element = driver.findElement(By.linkText("Add"));
        element.click();
        element = driver.findElement(By.name("author"));      
        element.sendKeys("pekka");
        element = driver.findElement(By.name("title"));
        element.sendKeys("");
        element = driver.findElement(By.name("publishingYear"));
        element.sendKeys("1992");
        element = driver.findElement(By.name("submit"));
        element.submit();
        testable = driver.getPageSource().contains("Trolls of Science");
        Assert.assertEquals(false, testable); 
    }
    @Test
    public void creationSuccessfulWithPages() {
        driver = new HtmlUnitDriver();
        driver.get(address);
        element = driver.findElement(By.linkText("Add"));
        element.click();
        element = driver.findElement(By.name("author"));      
        element.sendKeys("pekka");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Trolls of Science");
        element = driver.findElement(By.name("pages"));
        element.sendKeys("123-456");
        element = driver.findElement(By.name("publishingYear"));
        element.sendKeys("1992");
        element = driver.findElement(By.name("submit"));
        element.submit();
        testable = driver.getPageSource().contains("123-456");
        Assert.assertEquals(true, testable); 
    }
        
    @Test
    public void creationNotSuccessfulWithoutYear() {
        driver = new HtmlUnitDriver();
        driver.get(address);
        element = driver.findElement(By.linkText("Add"));
        element.click();
        element = driver.findElement(By.name("author"));      
        element.sendKeys("pekka");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Trolls of Science");
        element = driver.findElement(By.name("submit"));
        element.submit();
        testable = driver.getPageSource().contains("2012");
        Assert.assertFalse(testable);
    }
    
    @Test
    public void creationNotSuccessfulPagesWrong() {

    }
    
    @Test
    public void creationNotSuccessfulYearWrong() {

    }
}
