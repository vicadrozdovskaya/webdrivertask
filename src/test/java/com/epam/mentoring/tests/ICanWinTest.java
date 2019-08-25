package com.epam.mentoring.tests;

import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.pages.github.gist.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ICanWinTest extends BaseTest {

    private static final String LOGIN = "vicadrozdovskaya";
    private static final String PASS = "Vica110493";
    private static final String DESCRIPTION = "Paste Expiration: 10 Minutes";
    private static final String NAME = "how to gain dominance among developers";
    private static final String TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";

    GistPage gistPage;

    @BeforeClass
    public void createNewGist() {
        MainGistGitHubPage mainGistGitHubPage = new MainGistGitHubPage(DriverSingleton.getDriver()).openPage().clickSignInButton();
        LoginGistPage loginGistPage = new LoginGistPage().enterLogin(LOGIN).enterPassword(PASS).clickSignInButton();
        CreateGistPage createGistPage = new CreateGistPage().openPage().fillGistDescription(DESCRIPTION).fillFileName(NAME).fillFileEditorArea(TEXT).clickOnCreatePublicGistButton();
        UserGistPage userGistPage = new UserGistPage(DriverSingleton.getDriver()).openUserPage(LOGIN).setCurrentGist(NAME).clickCurrentGist();
        gistPage = new GistPage();
    }

    @Test(description = "checkDescriptionTest")
    public void checkDescriptionTest() {
        Assert.assertEquals(gistPage.getGistDescription().getText(), DESCRIPTION, "gist descriptions not equal");
    }

    @Test(description = "checkDescriptionTest")
    public void checkGistTextTest() {
        Assert.assertEquals(gistPage.getGistArea().getText(), TEXT, "gist text not equal");
    }

    @Test(description = "checkGistNameTest")
    public void checkGistNameTest() {
        Assert.assertEquals(gistPage.getGistName().getText(), NAME, "gist name not equal");
    }

    @AfterClass
    public void clickDeleteGist() {
        gistPage.clickDeleteGistBtn();
    }
}
