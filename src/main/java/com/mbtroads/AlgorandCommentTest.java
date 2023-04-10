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
public class AlgorandCommentTest {

    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //System.setProperty("webdriver.chrome.driver", "/Users/cduzgec/Desktop/GITHUB/SWe550/SWE550/lib/chromedriver");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.get("https://developer.algorand.org/");
        driver.manage().window().setSize(new Dimension(1250, 708));
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("id_login")).click();
        driver.findElement(By.id("id_login")).sendKeys("lol@gmail.com");
        driver.findElement(By.id("form-password-input")).sendKeys("123asd.FGH");
        driver.findElement(By.cssSelector(".form__submit-button")).click();
        driver.findElement(By.cssSelector(".user-section__button__first-name")).click();
        driver.findElement(By.cssSelector(".text-color--gray-lightest")).click();
        driver.findElement(By.cssSelector(".profile__unpublished-list-item:nth-child(1) .profile__unpublished-post__arrow-icon")).click();
        driver.findElement(By.id("id_text")).click();
        driver.findElement(By.id("id_text")).sendKeys("comment coment");
        driver.findElement(By.cssSelector(".button--medium")).click();
    }
}
