package com.mbtroads;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


@GraphWalker(value = "random(edge_coverage(100))", start = "v_Homepage")
public class DocsTest extends ExecutionContext implements Docs {
    public DocsTest(){
        super();
        PageFactory.initElements(this.driver,this);
    }
    static WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeExecution
    public static void setUp() throws  Exception{
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "/Users/cduzgec/Desktop/GITHUB/SWe550/SWE550/chromedriver");
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
    public void e_ClickDocs() {
        driver.findElement(By.id("page-header__menu-item-1")).click();
        driver.findElement(By.cssSelector("#menu-item--Build li:nth-child(1) .typography--small-title")).click();
        driver.findElement(By.cssSelector(".docs-homepage__card-list:nth-child(5) > .docs-homepage__card-list-item:nth-child(1) > .docs-homepage__card")).click();
        driver.findElement(By.cssSelector("h1")).click();
        driver.findElement(By.cssSelector("h1")).click();
        {
            WebElement element = driver.findElement(By.cssSelector("h1"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
    }

    @Override
    public void v_DocsPage() {
        assertEquals("Developer Portal", driver.getTitle());
    }

    @Override
    public void e_ClickLogo() {
        driver.findElement(By.cssSelector(".page-header__title")).click();
    }

}