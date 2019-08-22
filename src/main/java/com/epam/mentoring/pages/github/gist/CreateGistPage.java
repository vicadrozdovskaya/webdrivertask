package com.epam.mentoring.pages.github.gist;

import com.epam.mentoring.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateGistPage extends AbstractPage {

    private final String BASE_URL = "https://gist.github.com/";

    @FindBy (className = "input-contrast")
    private WebElement gistDescription;

    @FindBy (className = "js-blob-filename")
    private WebElement fileNameArea;

    @FindBy (className = "CodeMirror-code")
    private WebElement fileEditorArea;

    @FindBy (css = "button[class='btn js-gist-create ']")
    private WebElement createPublicGistButton;

    public CreateGistPage (WebDriver driver) {
        super(driver);
    }

    public CreateGistPage clickOnCreatePublicGistButton () {
        createPublicGistButton.click();
        return this;
    }

    public CreateGistPage openPage () {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public CreateGistPage fillGistDescription (String description) {
        gistDescription.click();
        gistDescription.sendKeys(description);
        return this;
    }

    public CreateGistPage fillFileName (String fileName) {
        fileNameArea.click();
        fileNameArea.sendKeys(fileName);
        return this;
    }

    public CreateGistPage fillFileEditorArea (String text) {
        fileEditorArea.click();
        fileEditorArea.sendKeys(text);
        return this;
    }
}
