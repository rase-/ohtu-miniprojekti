import wad.*
import wad.spring.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can create a reference'

scenario "creation successful", {
    given 'command add a reference is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        System.out.println("driver.getPageSource()");
        element = driver.findElement(By.linkText("Add"));    
        element.click();       
    }
    when 'article data entered', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("submit"));
        element.submit();
    }
    then 'new reference has been registered to system', {
        driver.get("http://localhost:8080")
        driver.getPageSource().contains("pekka").shouldBe true
    }
}