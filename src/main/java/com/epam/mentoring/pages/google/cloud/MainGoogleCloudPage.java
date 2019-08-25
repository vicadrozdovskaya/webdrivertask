package com.epam.mentoring.pages.google.cloud;

import com.epam.mentoring.annotation.PageFactory;
import com.epam.mentoring.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageFactory
public class MainGoogleCloudPage extends AbstractPage {

    private final String BASE_URL = "https://cloud.google.com";

    @FindBy (css = "a[track-name='pricing']")
    private WebElement tabPricing;

    @FindBy (css = "a[track-metadata-eventdetail='calculators']")
    private WebElement tabPricingCalculator;

    public MainGoogleCloudPage () {
        super();
    }

    public MainGoogleCloudPage openPage () {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public MainGoogleCloudPage clickTabPricing () {
        tabPricing.click();
        return this;
    }

    public MainGoogleCloudPage clickTabPricingCalculator () {
        tabPricingCalculator.click();
        return this;
    }

}
