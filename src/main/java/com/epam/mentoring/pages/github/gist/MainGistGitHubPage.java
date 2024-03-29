package com.epam.mentoring.pages.github.gist;

import com.epam.mentoring.annotation.PageFactory;
import com.epam.mentoring.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageFactory
public class MainGistGitHubPage extends AbstractPage {

    private final String BASE_URL = "https://gist.github.com/discover";

    @FindBy (css = "a[class='HeaderMenu-link no-underline mr-3']")
    private WebElement signInButton;


    public MainGistGitHubPage () {
        super();

    }

    public MainGistGitHubPage openPage () {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public MainGistGitHubPage clickSignInButton () {
        signInButton.click();
        return this;
    }

}
