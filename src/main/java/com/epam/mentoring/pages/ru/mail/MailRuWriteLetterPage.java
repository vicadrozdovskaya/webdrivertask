package com.epam.mentoring.pages.ru.mail;

import com.epam.mentoring.pages.AbstractPage;
import org.openqa.selenium.By;

public class MailRuWriteLetterPage extends AbstractPage {

    private static final By TO_FIELD = By.cssSelector("textarea[data-original-name='To']");

    private static final By SUBJECT_FIELD = By.cssSelector("input[class='b-input']");

    private static final By BODY_OF_LETTER = By.id("tinymce");

    private static final By BODY_OF_LETTER_FRAME = By.cssSelector("td[class='mceIframeContainer mceFirst mceLast']>iframe");

    private static final By SEND_BTN = By.cssSelector("div[data-name='send']");

    public MailRuWriteLetterPage fillRecieverLetterField(String email){
        driver.findElement(TO_FIELD).sendKeys(email);
        return this;
    }

    public MailRuWriteLetterPage fillSubjectOfLetterField(String subject){
        driver.findElement(SUBJECT_FIELD).sendKeys(subject);
        return this;
    }

    public MailRuWriteLetterPage fillContentOfLetter(String text){
        driver.switchTo().frame(driver.findElement(BODY_OF_LETTER_FRAME));
        driver.findElement(BODY_OF_LETTER).sendKeys(text);
        driver.switchTo().defaultContent();
        return this;
    }

    public MailRuWriteLetterPage clickSendLetterBtn(){
        driver.findElement(SEND_BTN).click();
        return this;
    }
}
