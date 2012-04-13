
package wad.spring.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:8080/ohtu_mini");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("Add"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("author"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("submit"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
          
 
        
    }
}
