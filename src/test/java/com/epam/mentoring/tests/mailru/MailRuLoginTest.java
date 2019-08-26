package com.epam.mentoring.tests.mailru;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.pages.ru.mail.MailRuLoginPage;
import com.epam.mentoring.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
@Test(groups = "mailruWithLogin")
public class MailRuLoginTest extends MailRuBaseTest {

    @Test (description = "Login to Mail.ru")
    public void loginMailru () {
        Assert.assertTrue(DriverSingleton.getDriver().getCurrentUrl().contains("https://e.mail.ru/messages"));
    }
}
