import wad.*
import wad.spring.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can tag and untag a reference'

serverAddress = "http://localhost:9090/";

scenario "Tagging successful", {
    given 'tagging is selected for first item listed', {
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
        
    }
    when 'proper tag is inserted', {
        element = driver.findElement(By.name("tag"));
        element.sendKeys("tagtest");
        element = driver.findElement(By.name("submit"));
        element.submit();
    }
    then 'tag is visible', {
        driver.get(serverAddress)
        driver.getPageSource().contains("tagtest").shouldBe true
    }
}

scenario "Untagging successful", {
    given 'tagging is selected for first item listed', {
        driver = new HtmlUnitDriver();
        driver.get(serverAddress);
        element = driver.findElement(By.linkText("tag"));
        element.click();
        element = driver.findElement(By.linkText("delete"));
        element.click();
    }
    when 'tag is deleted', {
        element = driver.findElement(By.linkText("delete"));
        element.click();
    }
    then 'tag is not visible', {
        driver.get(serverAddress)
        driver.getPageSource().contains("tagtest").shouldBe false
    }
}



