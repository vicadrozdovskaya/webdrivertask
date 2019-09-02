package com.epam.mentoring.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
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
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            try {
                driver = new RemoteWebDriver(new URL("http://192.168.0.22:4444/wd/hub"), capability);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
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
