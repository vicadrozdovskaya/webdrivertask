package com.epam.mentoring.pages.github.gist;

import com.epam.mentoring.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginGistPage extends AbstractPage {

    @FindBy (id = "login_field")
    private WebElement userNameField;

    @FindBy (id = "password")
    private WebElement passwordField;

    @FindBy (xpath = "//input[@value='Sign in']")
    private WebElement signInButton;

    public LoginGistPage (WebDriver driver) {
        super(driver);
    }

    public LoginGistPage enterLogin (String login) {
        userNameField.click();
        userNameField.sendKeys(login);
        return this;
    }

    public LoginGistPage enterPassword (String password) {
        passwordField.click();
        passwordField.sendKeys(password);
        return this;
    }

    public LoginGistPage clickSignInButton () {
        signInButton.click();
        return this;
    }
}
