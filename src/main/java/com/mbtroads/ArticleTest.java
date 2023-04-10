package com.mbtroads;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


@GraphWalker(value = "random(edge_coverage(100))", start = "v_HomePage")
public class ArticleTest extends ExecutionContext implements Article {
    public ArticleTest(){
        super();
        PageFactory.initElements(this.driver,this);
    }
    static WebDriver driver;

    @BeforeExecution
    public static void setUp() throws  Exception{
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
    public void v_HomePage(){
        driver.get("https://developer.algorand.org/");
        driver.manage().window().setSize(new Dimension(1201, 630));
        assertEquals("Algorand Developer Portal", driver.getTitle());
    }

    @Override
    public void e_ValidSignin(){
        driver.findElement(By.cssSelector(".form__submit-button")).click();
    }

    @Override
    public void e_ClickArticles(){
        driver.findElement(By.id("page-header__menu-item-2")).click();
        driver.findElement(By.cssSelector("#menu-item--Learn li:nth-child(3) .typography--small-title")).click();
    }

    @Override
    public void e_ClickLogo(){
        driver.findElement(By.cssSelector(".page-header__title")).click();
    }


    @Override
    public void v_ArticlesPage(){
        assertEquals("Articles | Algorand Developer Portal", driver.getTitle());
        assertEquals("https://developer.algorand.org/articles/", driver.getCurrentUrl());
    }

    @Override
    public void e_CreateArticle(){
        driver.findElement(By.cssSelector(".hub__contribute-button")).click();
        driver.findElement(By.cssSelector(".create-publication__type-list-item:nth-child(3) .create-publication__type-info-container")).click();
    }

    @Override
    public void v_Signin(){
        driver.findElement(By.id("id_login")).click();
        driver.findElement(By.id("id_login")).sendKeys("lol@gmail.com");
        driver.findElement(By.id("form-password-input")).sendKeys("123asd.FGH");
    }

   @Override
   public void v_CreateArticle(){
       driver.findElement(By.id("id_title")).click();
       driver.findElement(By.id("id_title")).sendKeys("selenium ");
       driver.findElement(By.id("id_long_summary")).click();
       driver.findElement(By.id("id_long_summary")).sendKeys("test purpose");
       driver.findElement(By.cssSelector(".ace_scroller")).click();
       driver.findElement(By.cssSelector(".ace_text-input")).sendKeys("lorem lorem\\n\\n");

   }

    @Override
    public void v_NewArticle(){
        assertEquals("selenium | Algorand Developer Portal", driver.getTitle());
    }

    @Override
    public void e_SubmitArticle(){
        driver.findElement(By.id("submit_for_review")).click();
        assertEquals("Are you sure you want to submit this article for review?", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

    }

}

