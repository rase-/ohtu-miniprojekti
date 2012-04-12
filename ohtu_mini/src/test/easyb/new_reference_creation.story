import wad.*
import wad.spring.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can create a reference'

scenario "creation successful", {
    given 'command add a reference is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("Add"));    
        element.click();       
    }
    when 'article data entered', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Trolls of Science");
        element = driver.findElement(By.name("submit"));
        element.submit();
    }
    then 'new reference has been registered to system', {
        driver.get("http://localhost:9090")
        driver.getPageSource().contains("pekka").shouldBe true
    }
}
scenario "creation not successful when missing author", {
    given 'command add a reference is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        System.out.println("driver.getPageSource()");
        element = driver.findElement(By.linkText("Add"));    
        element.click();
    }
    when 'article data entered', {
        element = driver.findElement(By.name("title"));
        element.sendKeys("Trolls of Science");
        element = driver.findElement(By.name("submit"));
        element.submit();
    }
    then 'new reference has been registered to system', {
        driver.get("http://localhost:9090")
        driver.getPageSource().contains("Trolls Of Science").shouldBe false
    }
}
scenario "creation not successful when missing title", {
    scenario "creation not successful when missing author", {
    given 'command add a reference is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("Add"));    
        element.click();
    }
    when 'article data entered', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("trolli");
        element = driver.findElement(By.name("submit"));
        element.submit();
    }
    then 'new reference has been registered to system', {
        driver.get("http://localhost:9090")
        driver.getPageSource().contains("trolli").shouldBe false
    }
}
scenario "creation not successful when pages are typed wrong", {
    given 'command add a reference is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("Add"));    
        element.click();
    }
    when 'article data entered', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("trolli");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Trolls of Science");
        element = driver.findElement(By.name("pages"));
        element.sendKeys("123");
        element = driver.findElement(By.name("submit"));
        element.submit();
    }
    then 'new reference has been registered to system', {
        driver.get("http://localhost:9090")
        driver.getPageSource().contains("trolli").shouldBe false
    }
}
scenario "creation successful when pages are typed right", {
    given 'command add a reference is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("Add"));    
        element.click();
    }
    when 'article data entered', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("trolli");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Trolls of Science");
        element = driver.findElement(By.name("pages"));
        element.sendKeys("123-126");
        element = driver.findElement(By.name("submit"));
        element.submit();
    }
    then 'new reference has been registered to system', {
        driver.get("http://localhost:9090")
        driver.getPageSource().contains("trolli").shouldBe true
    }
}
}
