package com.mbtroads;

import com.mbtroads.Search;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.Edge;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.annotation.Vertex;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


@GraphWalker(value = "random(edge_coverage(100))", start = "v_Homepage")
public class SearchTest extends ExecutionContext implements Search {
    public SearchTest(){
        super();
        PageFactory.initElements(this.driver,this);
    }
    static WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeExecution
    public static void setUp() throws  Exception{
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "/Users/cduzgec/Desktop/GITHUB/SWe550/SWE550/lib/chromedriver");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Override
    public void v_Homepage() {
        driver.get("https://developer.algorand.org/");
        assertEquals("Algorand Developer Portal", driver.getTitle());
    }

    @Override
    public void e_InsertSearchWord() {
        {
            WebElement element = driver.findElement(By.cssSelector(".ais-SearchBox-input"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.id("search-overlay-container"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.cssSelector(".page-header__section:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".ais-SearchBox-input")).sendKeys("algo");
        driver.findElement(By.cssSelector(".ais-SearchBox-input")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector(".ais-InfiniteHits-item:nth-child(1) .search-overlay__hit")).click();
    }

    @Override
    public void v_Searchpage() {
        assertEquals("Developer Portal", driver.getTitle());
    }

    @Override
    public void e_ClickLogo() {
        driver.findElement(By.cssSelector(".page-header__title")).click();
    }

}
