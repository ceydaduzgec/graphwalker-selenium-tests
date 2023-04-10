package com.mbtroads;

import com.mbtroads.Search;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


@GraphWalker(value = "random(edge_coverage(100))", start = "v_Homepage")
public class SearchTest extends ExecutionContext implements Search {
    public SearchTest(){
        super();
        PageFactory.initElements(this.driver,this);
    }
    static WebDriver driver;

    @BeforeExecution
    public static void setUp() throws  Exception{
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //System.setProperty("webdriver.chrome.driver", "/Users/cduzgec/Desktop/GITHUB/SWe550/SWE550/lib/chromedriver");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        driver.close();
        driver.quit();
    }

    @Override
    public void v_Homepage() {
        driver.get("https://developer.algorand.org/");
        driver.manage().window().setSize(new Dimension(1099, 630));
        assertEquals("Algorand Developer Portal", driver.getTitle());
    }

    @Override
    public void e_InsertSearchWord() {
        driver.findElement(By.cssSelector(".ais-SearchBox-input")).click();
        //driver.findElement(By.id("search-overlay-container")).click();

        driver.findElement(By.cssSelector(".ais-SearchBox-input")).sendKeys("algo");
        driver.findElement(By.cssSelector(".ais-SearchBox-input")).sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ais-InfiniteHits-item:nth-child(1) .search-overlay__hit")));
        driver.findElement(By.cssSelector(".ais-InfiniteHits-item:nth-child(1) .search-overlay__hit")).click();
    }

    @Override
    public void v_Searchpage() {
        String articleTitle = driver.findElement(By.cssSelector(".md-header__button-text")).getText();
        assertEquals("algokey part info", articleTitle);
    }

    @Override
    public void e_ClickLogo() {
        driver.findElement(By.cssSelector(".page-header__home-link")).click();
    }

}
