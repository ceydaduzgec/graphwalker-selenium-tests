package com.mbtroads;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


@GraphWalker(value = "random(edge_coverage(100))", start = "v_Homepage")
public class CommentTest extends ExecutionContext implements Comment {
    public CommentTest() {
        super();
        PageFactory.initElements(this.driver, this);
    }

    static WebDriver driver;

    @BeforeExecution
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @AfterExecution
    public void tearDown() {
        driver.quit();
    }

    @Override
    public void e_ClickLogo() {
        driver.findElement(By.cssSelector(".page-header__title")).click();
    }

    @Override
    public void v_ArticlePage() {
        assertEquals("selenium | Algorand Developer Portal", driver.getTitle());
    }

    @Override
    public void e_ClickArticle() {
        driver.findElement(By.cssSelector(".profile__unpublished-list-item:nth-child(1) .profile__unpublished-post__arrow-icon")).click();
    }

    @Override
    public void e_Comment() {
        driver.findElement(By.id("id_text")).click();
        driver.findElement(By.id("id_text")).sendKeys("comment coment");
        driver.findElement(By.cssSelector(".button--medium")).click();
    }

    @Override
    public void v_Homepage() {
        driver.get("https://developer.algorand.org/");
        driver.manage().window().setSize(new Dimension(1201, 630));
        assertEquals("Algorand Developer Portal", driver.getTitle());
    }

    @Override
    public void v_UserProfile() {
        assertEquals("https://developer.algorand.org/u/lol/", driver.getCurrentUrl());
        assertEquals("lol lol | Algorand Developer Portal", driver.getTitle());
    }

    @Override
    public void e_ClickProfile() {
        driver.findElement(By.cssSelector(".user-section__button__first-name")).click();
        driver.findElement(By.cssSelector(".text-color--gray-lightest")).click();
    }

    @Override
    public void e_SignIn() {
        driver.findElement(By.linkText("Sign In")).click();
    }

    @Override
    public void v_SignIn() {
        driver.findElement(By.id("id_login")).click();
        driver.findElement(By.id("id_login")).sendKeys("lol@gmail.com");
        driver.findElement(By.id("form-password-input")).sendKeys("123asd.FGH");
        driver.findElement(By.cssSelector(".form__submit-button")).click();
    }
}