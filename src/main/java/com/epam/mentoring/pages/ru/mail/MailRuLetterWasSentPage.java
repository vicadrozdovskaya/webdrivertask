package com.epam.mentoring.pages.ru.mail;

import com.epam.mentoring.pages.AbstractPage;
import org.openqa.selenium.By;

public class MailRuLetterWasSentPage extends AbstractPage {

    public static final By LETTER_WAS_SENT_TEXT = By.cssSelector("div[class='message-sent__title']");
    public static final By LETTER_RECEIVER = By.cssSelector("span[class='message-sent__info']");

    public String getLetterWasSentText(){
        return driver.findElement(LETTER_WAS_SENT_TEXT).getText();
    }

    public String getLetterReceiver(){
        return driver.findElement(LETTER_RECEIVER).getText();
    }

}
