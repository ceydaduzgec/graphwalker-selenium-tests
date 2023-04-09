package com.mbtroads;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


@GraphWalker(value = "random(edge_coverage(100))", start = "v_HomePage")
public class SignInTest extends ExecutionContext implements SignIn {
    public SignInTest(){
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

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Override
    public void v_Logout() {
        String userName = driver.findElement(By.cssSelector(".user-section__button__first-name")).getText();
        assertEquals("lol", userName);

    }

    @Override
    public void e_AutomaticRedirect() {

    }

    @Override
    public void e_FillInformation() {
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("id_login")).sendKeys("lol@gmail.com");
        driver.findElement(By.id("form-password-input")).sendKeys("123asd.FGH");
        driver.findElement(By.cssSelector(".form__submit-button")).click();
    }

    @Override
    public void e_ClickLogout() {
        driver.findElement(By.cssSelector(".user-section__button__user-avatar")).click();
        driver.findElement(By.id("logout-button")).click();

    }
    @Override
    public void v_HomePage() {
        driver.get("https://developer.algorand.org/");
        driver.manage().window().setSize(new Dimension(1201, 630));
        assertEquals("Algorand Developer Portal", driver.getTitle());
    }

    @Override
    public void v_SignIn() {
        String userName = driver.findElement(By.cssSelector(".user-section__button__first-name")).getText();
        assertEquals("lol", userName);
    }

}

