package com.epam.mentoring.tests;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.pages.github.gist.CreateGistPage;
import com.epam.mentoring.pages.github.gist.GistPage;
import com.epam.mentoring.pages.github.gist.LoginGistPage;
import com.epam.mentoring.pages.github.gist.MainGistGitHubPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BringItOnTest extends BaseTest {
    private static final String LOGIN = "vicadrozdovskaya";
    private static final String PASS = "Vica110493";

    @BeforeTest
    public void logIn() {
        MainGistGitHubPage mainGistGitHubPage = new MainGistGitHubPage(DriverSingleton.getDriver()).openPage().clickSignInButton();
        LoginGistPage loginGistPage = new LoginGistPage(DriverSingleton.getDriver()).enterLogin(LOGIN).enterPassword(PASS).clickSignInButton();

    }

    @Test(description = "create gist test")
    public void bringItOnTaskTest() {
        CreateGistPage createGistPage = new CreateGistPage(DriverSingleton.getDriver()).openPage().fillGistDescription("Paste Expiration: 10 Minutes").fillFileName("helloweb").fillFileEditorArea("Hello from WebDriver").clickOnCreatePublicGistButton();
        GistPage gistPage = new GistPage(DriverSingleton.getDriver());
        Assert.assertEquals(gistPage.getGistName().getText(),"helloweb","gist name not equals");
    }
}
