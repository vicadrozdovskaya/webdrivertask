package com.epam.mentoring.tests;

import com.epam.mentoring.driver.DriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass (description = "Start browser")
    private void initBrowser () {
        DriverSingleton.getDriver();
    }

    @AfterClass (description = "close browser")
    public void kill () {
        DriverSingleton.closeDriver();
    }

}
