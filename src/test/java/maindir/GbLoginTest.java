package maindir;


import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GbLoginTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Тест формы логина")
    @Description("Проверяем, правильно ли заполнены поля логина и пароля + заполнены ли они вообще.")
    public void loginFormTest() {
    driver.findElement(By.xpath ("//input[@id='prependedInput']")).click();
        driver.findElement(By.xpath ("//input[@id='prependedInput']")).sendKeys("Applanatest1");
        Assertions.assertFalse(driver.findElement(By.xpath("//input[@id='prependedInput']")).getAttribute("value").isEmpty(), "Логин не был введён");
        Assertions.assertEquals("Applanatest1", driver.findElement(By.xpath("//input[@id='prependedInput']")).getAttribute("value"));
        driver.findElement(By.xpath ("//input[@id='prependedInput2']")).click();
        driver.findElement(By.xpath ("//input[@id='prependedInput2']")).sendKeys("Student2020!");
        Assertions.assertFalse(driver.findElement(By.xpath("//input[@id='prependedInput2']")).getAttribute("value").isEmpty(), "Пароль не был введён");
        Assertions.assertEquals("Student2020!", driver.findElement(By.xpath("//input[@id='prependedInput2']")).getAttribute("value"));
        driver.findElement(By.xpath ("//button[@id='_submit']")).click();
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}