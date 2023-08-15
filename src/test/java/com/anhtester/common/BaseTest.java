package com.anhtester.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    public  WebDriver driver;

    @BeforeMethod //Chạy trước mỗi 1 @Test
    public  void createBrowser() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");//xử lý cảnh báo (Wamming) Connection reset trong Selenium
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public  void createBrowser(String browserName) {
        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        }else if (browserName.equals("edge")) {
            driver = new EdgeDriver();
        }else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod //Tắt browser
    public  void closedBrowser() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public static void sleep(double seconds){
        try {
            Thread.sleep((long) (1000*seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
