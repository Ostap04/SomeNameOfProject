package com.it;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MyTest {
    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // <-- Яка різниця від  Thread.sleep?
        driver.get("https://www.i.ua/");
        driver.findElement(By.name("login")).sendKeys("ittest2", Keys.BACK_SPACE);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) { // <-- для чого це писати, якщо і без того ок?
            e.printStackTrace();
        }
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys("ittest2");
        Thread.sleep(2000);
        driver.findElement(By.name("pass")).sendKeys("337774a");
        driver.findElement(By.xpath("//input[@tabindex='5']")).click();
        String text = driver.findElement(By.xpath("//ul[@class='sn_menu']//span")).getText(); /* <-- куди зберігає текст
        // і коли прописувати String text*/
        Assert.assertEquals("ittest2@i.ua", text);
        driver.quit();
    }
}
// Як зберегти проект на комп?