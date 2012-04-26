import wad.*
import wad.spring.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can tag and untag a reference'

serverAddress = "http://localhost:9090/";

scenario "Search successful", {
    given 'Some references are tagged', {
        driver = new HtmlUnitDriver();
        driver.get(serverAddress);

        element = driver.findElement(By.linkText("Add"));
        element.click();
        element = driver.findElement(By.name("author"));
        element.sendKeys("tagtest");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Trolls of Science");
        element = driver.findElement(By.name("publishingYear"));
        element.sendKeys("1991");
        element = driver.findElement(By.name("submit"));
        element.submit();
        driver = new HtmlUnitDriver();
        driver.get(serverAddress);
        element = driver.findElement(By.linkText("tag"));
        element.click();
        
        element = driver.findElement(By.name("tag"));
        element.sendKeys("tagtest");
        element = driver.findElement(By.name("submit"));
        element.submit();

        
    }
    when 'proper tag is inserted to search field', {
        element = driver.findElement(By.name("findByTag"));
        element.sendKeys("tagtest");
        element = driver.findElement(By.name("submit"));
        element.submit();
    }
    then 'proper references can be found', {
        driver.get(serverAddress)
        driver.getPageSource().contains("tagtest").shouldBe true
    }
}

scenario "multiple tags inserted", {
    given 'references has multiple tags', {
        driver = new HtmlUnitDriver();
        driver.get(serverAddress);
        element = driver.findElement(By.linkText("tag"));
        element.click();
    }
    when 'proper tag is inserted to search field', {
        element = driver.findElement(By.name("tag"));
        element.sendKeys("");
        element = driver.findElement(By.name("submit"));
        element.submit();
    }
    then 'references are found', {
        driver.get(serverAddress)
        driver.getPageSource().contains("tagtest").shouldBe true
    }
}

