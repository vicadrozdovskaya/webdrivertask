package com.epam.mentoring.pages.github.gist;

import com.epam.mentoring.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GistPage extends AbstractPage {

    @FindBy (css = "div[itemprop='about']")
    private WebElement gistDescription;

    @FindBy (css = "strong[itemprop='name']>a")
    private WebElement gistName;

    @FindBy (css = "div[itemprop='text']>table")
    private WebElement gistArea;

    @FindBy (css = "button[aria-label='Delete this Gist']")
    private WebElement deleteGistBtn;

    public GistPage () {
        super();
    }

    public WebElement getGistDescription () {
        return gistDescription;
    }

    public WebElement getGistName () {
        return gistName;
    }

    public WebElement getGistArea () {
        return gistArea;
    }

    public GistPage clickDeleteGistBtn () {
        deleteGistBtn.click();
        return this;
    }
}
