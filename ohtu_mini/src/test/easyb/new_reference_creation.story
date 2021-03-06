import wad.*
import wad.spring.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'User can create a reference'

serverAddress = "http://localhost:9090/";

 scenario "creation successful with misc", {
    given 'command add a reference is selected', {
        driver = new HtmlUnitDriver();
        driver.get(serverAddress);
        element = driver.findElement(By.linkText("Add"));    
        element.click();       
    }
    when 'article data entered', {
        Select select = new Select(driver.findElement(By.id("type")));
        select.selectByValue("MISC");
        element = driver.findElement(By.name("author"));
        element.sendKeys("PATROLOLOLOLOLOLOLOLO");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Trolls of Science");
        element = driver.findElement(By.name("publishingYear"));
        element.sendKeys("1991");
        element = driver.findElement(By.name("submit"));
        element.submit();
    }
    then 'new reference has been registered to system', {
        driver.get(serverAddress)
        driver.getPageSource().contains("PATROLOLOLOLOLOLOLOLO").shouldBe true
    }
}

scenario "creation successful", {
    given 'command add a reference is selected', {
        driver = new HtmlUnitDriver();
        driver.get(serverAddress);
        element = driver.findElement(By.linkText("Add"));    
        element.click();       
    }
    when 'article data entered', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Trolls of Science");
        element = driver.findElement(By.name("publishingYear"));
        element.sendKeys("1991");
        element = driver.findElement(By.name("submit"));
        element.submit();
    }
    then 'new reference has been registered to system', {
        driver.get(serverAddress)
        driver.getPageSource().contains("pekka").shouldBe true
    }
}
scenario "creation not successful when missing author", {
    given 'command add a reference is selected', {
        driver = new HtmlUnitDriver();
        driver.get(serverAddress);
        System.out.println("driver.getPageSource()");
        element = driver.findElement(By.linkText("Add"));    
        element.click();
    }
    when 'article data entered', {
        element = driver.findElement(By.name("title"));
        element.sendKeys("Trolls of Science");
        element = driver.findElement(By.name("publishingYear"));
        element.sendKeys("1991");
        element = driver.findElement(By.name("submit"));
        element.submit();
    }
    then 'new reference has been registered to system', {
        driver.get(serverAddress)
        driver.getPageSource().contains("Trolls Of Science").shouldBe false
    }
}
scenario "creation not successful when missing title", {
    scenario "creation not successful when missing author", {
    given 'command add a reference is selected', {
        driver = new HtmlUnitDriver();
        driver.get(serverAddress);
        element = driver.findElement(By.linkText("Add"));    
        element.click();
    }
    when 'article data entered', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("trolli");
        element = driver.findElement(By.name("publishingYear"));
        element.sendKeys("1991");
        element = driver.findElement(By.name("submit"));
        element.submit();
    }
    then 'new reference has been registered to system', {
        driver.get(serverAddress)
        driver.getPageSource().contains("trolli").shouldBe false
    }
}
scenario "creation not successful when pages are typed wrong", {
    given 'command add a reference is selected', {
        driver = new HtmlUnitDriver();
        driver.get(serverAddress);
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
        element = driver.findElement(By.name("publishingYear"));
        element.sendKeys("1991");
        element = driver.findElement(By.name("submit"));
        element.submit();
    }
    then 'new reference has been registered to system', {
        driver.get(serverAddress)
        driver.getPageSource().contains("trolli").shouldBe false
    }
}
scenario "creation successful when pages are typed right", {
    given 'command add a reference is selected', {
        driver = new HtmlUnitDriver();
        driver.get(serverAddress);
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
        element = driver.findElement(By.name("publishingYear"));
        element.sendKeys("1991");
        element = driver.findElement(By.name("submit"));
        element.submit();
    }
    then 'new reference has been registered to system', {
        driver.get(serverAddress)
        driver.getPageSource().contains("trolli").shouldBe true
    }
}
scenario "creation not successful when year not typed", {
    given 'command add a reference is selected', {
        driver = new HtmlUnitDriver();
        driver.get(serverAddress);
        element = driver.findElement(By.linkText("Add"));    
        element.click();
    }
    when 'article data entered', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("yearRight");
        element = driver.findElement(By.name("title"));
        element.sendKeys("YearRight");
        element = driver.findElement(By.name("submit"));
        element.submit();
    }
    then 'new reference has been registered to system', {
        driver.get(serverAddress)
        driver.getPageSource().contains("yearRight").shouldBe false
    }
}
scenario "creation not successful when year typed wrong", {
    given 'command add a reference is selected', {
        driver = new HtmlUnitDriver();
        driver.get(serverAddress);
        element = driver.findElement(By.linkText("Add"));    
        element.click();
    }
    when 'article data entered', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("yearWrong");
        element = driver.findElement(By.name("title"));
        element.sendKeys("YearWrong");
        element = driver.findElement(By.name("publishingYear"));
        element.sendKeys("asd");
        element = driver.findElement(By.name("submit"));
        element.submit();
    }
    then 'new reference has not been registered to system', {
        driver.get(serverAddress)
        driver.getPageSource().contains("yearWrong").shouldBe false
    }
}

}
