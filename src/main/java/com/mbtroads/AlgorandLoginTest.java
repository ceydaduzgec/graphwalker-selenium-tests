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

public class AlgorandLoginTest {

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://developer.algorand.org/");
        driver.manage().window().setSize(new Dimension(1201, 630));

        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("id_login")).sendKeys("lol@gmail.com");
        driver.findElement(By.id("form-password-input")).sendKeys("123asd.FGH");

        //driver.findElement(By.cssSelector(".form__card")).click();

        driver.findElement(By.cssSelector(".form__submit-button")).click();
        driver.findElement(By.cssSelector(".user-section__button__user-avatar")).click();
        driver.findElement(By.id("logout-button")).click();
        driver.quit();
    }
}
