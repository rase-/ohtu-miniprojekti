import wad.*
import wad.spring.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can create a reference'

serverAddress = "http://localhost:8080";

scenario "deletion successful", {
    given 'delete is selected for first item listed', {
        driver = new HtmlUnitDriver();
        driver.get(serverAddress);
        element = driver.findElement(By.linkText("Add"));    
        element.click();
        element = driver.findElement(By.name("author"));
        element.sendKeys("testuser");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Trolls of Science");
        element = driver.findElement(By.name("submit"));
        element.submit();
        driver.get(serverAddress);
        element = driver.findElement(By.id("testuser"));
        element.click();
        
    }
    when 'listing is returned', {
        
    }
    then 'deleted author not listed', {
        driver.get(serverAddress)
        driver.getPageSource().contains("testuser").shouldBe false
    }
}



