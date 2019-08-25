package com.epam.mentoring.pages.github.gist;

import com.epam.mentoring.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserGistPage extends AbstractPage {

    private final String BASE_URL = "https://gist.github.com/";

    public UserGistPage (WebDriver driver) {
        super();
    }

    @FindBy (css = "div[class='gist-snippet-meta d-inline-block width-full']")
    private List<WebElement> allUserGists;

    private WebElement currentGist;

    public UserGistPage setCurrentGist (final String name) {
        currentGist = driver.findElement(By.xpath("//strong[text()='" + name + "']"));
        return this;
    }

    public UserGistPage clickCurrentGist () {
        currentGist.click();
        return this;
    }

    public UserGistPage openUserPage (String userName) {
        driver.navigate().to(BASE_URL + userName);
        return this;
    }
}
