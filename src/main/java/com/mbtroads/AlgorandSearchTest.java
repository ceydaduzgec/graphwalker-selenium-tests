package com.mbtroads;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;

import java.time.Duration;

public class AlgorandSearchTest {

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://developer.algorand.org/");
        driver.manage().window().setSize(new Dimension(2560, 1416));

        driver.findElement(By.cssSelector(".ais-SearchBox-input")).click();
        driver.findElement(By.id("search-overlay-container")).click();


        driver.findElement(By.cssSelector(".ais-SearchBox-input")).sendKeys("algo");
        driver.findElement(By.cssSelector(".ais-SearchBox-input")).sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ais-InfiniteHits-item:nth-child(1) .search-overlay__hit")));
        driver.findElement(By.cssSelector(".ais-InfiniteHits-item:nth-child(1) .search-overlay__hit")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".md-header__button-text")));

        //String searchPageTitle = driver.fcan you write indElement(By.cssSelector(".typography--large-body md-header__button-text")).getAccessibleName();
        String articleTitle = driver.findElement(By.cssSelector(".md-header__button-text")).getText();
        assertEquals("algokey part info", articleTitle);
        driver.quit();
    }
}
