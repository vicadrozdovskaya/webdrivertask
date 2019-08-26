package com.epam.mentoring.tests.mailru;

import com.epam.mentoring.pages.ru.mail.MailRuInboxPage;
import com.epam.mentoring.pages.ru.mail.MailRuLetterWasSentPage;
import com.epam.mentoring.pages.ru.mail.MailRuLoginPage;
import com.epam.mentoring.pages.ru.mail.MailRuWriteLetterPage;
import com.epam.mentoring.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = "mailruWithLogin")
public class MailRuSendLetterTest extends MailRuBaseTest {

    private final String EMAIL = "vica.drozdovskaya@gmail.com";
    private final String SUBJECT = "new subject";
    private final String TEXT = "new content";
    MailRuLetterWasSentPage mailRuLetterWasSentPage;

    @BeforeClass
    public void writeLetter() {
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
