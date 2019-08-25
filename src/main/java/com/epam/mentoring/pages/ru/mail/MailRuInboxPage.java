package com.epam.mentoring.pages.ru.mail;

import com.epam.mentoring.pages.AbstractPage;
import org.openqa.selenium.By;

public class MailRuInboxPage extends AbstractPage {

    private static final By AUTH_MENU_USER = By.id("PH_user-email");
    private static final By WRITE_LETTER = By.cssSelector("a[data-name='compose']");

    public MailRuInboxPage clickWriteLetterBtn(){
        driver.findElement(WRITE_LETTER).click();
        return this;
    }


}
