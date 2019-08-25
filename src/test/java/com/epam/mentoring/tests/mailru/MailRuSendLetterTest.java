package com.epam.mentoring.tests.mailru;

import com.epam.mentoring.pages.ru.mail.MailRuInboxPage;
import com.epam.mentoring.pages.ru.mail.MailRuLetterWasSentPage;
import com.epam.mentoring.pages.ru.mail.MailRuLoginPage;
import com.epam.mentoring.pages.ru.mail.MailRuWriteLetterPage;
import com.epam.mentoring.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MailRuSendLetterTest extends BaseTest {

    private final String USERNAME = "tathtp";
    private final String PASSWORD = "Klopik123";
    private final String EMAIL = "vica.drozdovskaya@gmail.com";
    private final String SUBJECT = "new subject";
    private final String TEXT = "new content";
    MailRuLetterWasSentPage mailRuLetterWasSentPage;

    @BeforeClass
    public void signIn() {
        MailRuLoginPage mailRuLoginPage = new MailRuLoginPage().openPage().fillLoginField(USERNAME).fillPasswordField(PASSWORD).clickSignInBtn();
        MailRuInboxPage mailRuInboxPage = new MailRuInboxPage().clickWriteLetterBtn();
        MailRuWriteLetterPage mailRuWriteLetterPage = new MailRuWriteLetterPage()
                .fillRecieverLetterField(EMAIL)
                .fillSubjectOfLetterField(SUBJECT)
                .fillContentOfLetter(TEXT)
                .clickSendLetterBtn();
        mailRuLetterWasSentPage = new MailRuLetterWasSentPage();
    }

    @Test
    public void checkThatLetterWasSent() {
        Assert.assertEquals(mailRuLetterWasSentPage.getLetterWasSentText(),
                "Ваше письмо отправлено. Перейти во Входящие", "messages are not equal");
    }

    @Test
    public void checkLetterWasSentToReceiver() {
        Assert.assertEquals(mailRuLetterWasSentPage.getLetterReceiver(),
                EMAIL , "emails are not equal");
    }
}
