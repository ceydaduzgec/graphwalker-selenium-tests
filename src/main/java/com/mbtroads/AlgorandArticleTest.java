package com.mbtroads;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
public class AlgorandArticleTest {

    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //System.setProperty("webdriver.chrome.driver", "/Users/cduzgec/Desktop/GITHUB/SWe550/SWE550/lib/chromedriver");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.get("https://developer.algorand.org/");
        driver.manage().window().setSize(new Dimension(1032, 708));
        driver.findElement(By.id("page-header__menu-item-2")).click();
        driver.findElement(By.cssSelector("#menu-item--Learn li:nth-child(3) .typography--small-title")).click();
        driver.findElement(By.cssSelector(".hub__contribute-button")).click();
        driver.findElement(By.cssSelector(".create-publication__type-list-item:nth-child(3) .create-publication__type-info-container")).click();
        driver.findElement(By.id("id_login")).click();
        driver.findElement(By.id("id_login")).sendKeys("lol@gmail.com");
        driver.findElement(By.id("form-password-input")).sendKeys("123asd.FGH");
        driver.findElement(By.cssSelector(".form__submit-button")).click();
        driver.findElement(By.id("id_title")).click();
        driver.findElement(By.id("id_title")).sendKeys("selenium ");
        driver.findElement(By.id("id_long_summary")).click();
        driver.findElement(By.id("id_long_summary")).sendKeys("test purpose");
        driver.findElement(By.cssSelector(".ace_scroller")).click();
        driver.findElement(By.cssSelector(".ace_text-input")).sendKeys("lorem lorem\\n\\n");
        driver.findElement(By.id("submit_for_review")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.cssSelector(".page-header__title")).click();
    }
}
