package com.epam.mentoring.pages.ru.mail;

import com.epam.mentoring.pages.AbstractPage;
import org.openqa.selenium.By;

public class MailRuLoginPage extends AbstractPage {
    private final static String BASE_URL = "https://mail.ru/login";
    private final static By LOGIN = By.cssSelector("input[name='Login']");
    private final static By PASSWORD = By.cssSelector("input[name='Password']");
    private final static By SINGN_IN = By.cssSelector("button[data-test-id='submit-button']");

    public MailRuLoginPage(){

    }
    public MailRuLoginPage fillLoginField(String login){
        //waitForElementVisible(LOGIN,"name");
        driver.switchTo().frame(driver.findElement(By.className("ag-popup__frame__layout__iframe")));
        driver.findElement(LOGIN).sendKeys(login);
        return this;
    }

    public MailRuLoginPage fillPasswordField(String password){
        driver.findElement(PASSWORD).sendKeys(password);
        return this;
    }

    public MailRuLoginPage clickSignInBtn(){
        driver.findElement(SINGN_IN).click();
        return this;
    }

    public MailRuLoginPage openPage(){
        driver.navigate().to(BASE_URL);
        return this;
    }

}
