package com.epam.mentoring.tests;

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
    public void logIn () {
        MainGistGitHubPage mainGistGitHubPage = new MainGistGitHubPage().openPage().clickSignInButton();
        LoginGistPage loginGistPage = new LoginGistPage().enterLogin(LOGIN).enterPassword(PASS).clickSignInButton();

    }

    @Test (description = "create gist test")
    public void bringItOnTaskTest () {
        CreateGistPage createGistPage = new CreateGistPage().openPage()
                                                            .fillGistDescription("Paste Expiration: 10 Minutes")
                                                            .fillFileName("helloweb")
                                                            .fillFileEditorArea("Hello from WebDriver")
                                                            .clickOnCreatePublicGistButton();
        GistPage gistPage = new GistPage();
        Assert.assertEquals(gistPage.getGistName().getText(), "helloweb", "gist name not equals");
    }
}
