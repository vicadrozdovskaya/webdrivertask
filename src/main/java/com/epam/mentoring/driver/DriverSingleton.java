package com.epam.mentoring.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static final ResourceBundle rb;
    private static WebDriver driver;

    static {
        rb = ResourceBundle.getBundle("driver");
    }

    DriverSingleton() {

    }

    public static WebDriver getDriver() {
        if (null == driver) {
            System.setProperty(rb.getString("driver.browser"), rb.getString("driver.browser.path"));
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(rb.getString("driver.page.load.timeout")), TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(rb.getString("driver.implicitly.wait")), TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
