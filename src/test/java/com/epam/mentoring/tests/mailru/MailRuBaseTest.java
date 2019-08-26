package com.epam.mentoring.tests.mailru;

import com.epam.mentoring.pages.ru.mail.MailRuLoginPage;
import com.epam.mentoring.tests.BaseTest;
import org.testng.annotations.BeforeClass;

import java.util.ResourceBundle;

public class MailRuBaseTest extends BaseTest {

    protected static final ResourceBundle rb;

    static {
        rb = ResourceBundle.getBundle("login");
    }

    @BeforeClass (groups = "mailruWithLogin")
    public void signIn () {
        MailRuLoginPage mailRuLoginPage = new MailRuLoginPage().openPage()
                                                               .fillLoginField(rb.getString("mailru.login"))
                                                               .fillPasswordField(rb.getString("mailru.password"))
                                                               .clickSignInBtn();
    }
}
