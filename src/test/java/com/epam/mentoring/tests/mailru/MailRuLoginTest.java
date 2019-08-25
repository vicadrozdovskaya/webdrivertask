package com.epam.mentoring.tests.mailru;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.pages.ru.mail.MailRuLoginPage;
import com.epam.mentoring.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MailRuLoginTest extends BaseTest {
    private final String USERNAME = "tathtp";
    private final String PASSWORD = "Klopik123";

    @BeforeTest
    public void signIn() {
        MailRuLoginPage mailRuLoginPage = new MailRuLoginPage().openPage().fillLoginField(USERNAME).fillPasswordField(PASSWORD).clickSignInBtn();
    }
    @Test(description = "Login to Mail.ru")
    public void loginMailru()
    {
        Assert.assertTrue(DriverSingleton.getDriver().getCurrentUrl().contains("https://e.mail.ru/messages"));
    }
}
