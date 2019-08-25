package com.epam.mentoring.pages.google.cloud;

import com.epam.mentoring.annotation.PageFactory;
import com.epam.mentoring.driver.DriverSingleton;
import com.epam.mentoring.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@PageFactory
public class ProductCalculatorsGoogleCloudPage extends AbstractPage {

    @FindBy (css = "input[ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstancesField;

    @FindBy (xpath = "//label[text()='Operating System / Software']/parent::*/md-select")
    private WebElement arrowOperationSystem;

    @FindBy (css = "md-select[placeholder='VM Class']")
    private WebElement arrowMachineClass;

    @FindBy (css = "md-select[placeholder='Instance type']")
    private WebElement arrowMachineType;

    @FindBy (xpath = "//div[contains(text(),'Add GPUs.')]")
    private WebElement addGPUsCheckbox;

    @FindBy (css = "md-select[placeholder='Number of GPUs']")
    private WebElement arrowNumberOfGPUs;

    @FindBy (css = "md-select[placeholder='GPU type']")
    private WebElement arrowGPUType;

    @FindBy (css = "md-select[placeholder='Local SSD']")
    private WebElement arrowLocalSsd;

    @FindBy (css = "md-select[placeholder='Datacenter location']")
    private WebElement arrowDatacenterLocation;

    @FindBy (css = "md-select[placeholder='Committed usage']")
    private WebElement arrowCommitedUsage;

    @FindBy (css = "button[aria-label='Add to Estimate']")
    private WebElement addToEstimateBtn;

    @FindBy (id = "resultBlock")
    private WebElement resultBlock;

    private Wait<WebDriver> wait = new FluentWait<>(DriverSingleton.getDriver()).withMessage("Element was not found")
                                                                                .withTimeout(Duration.ofSeconds(10))
                                                                                .pollingEvery(Duration.ofSeconds(1));


    public ProductCalculatorsGoogleCloudPage () {
        super();
        this.driver.switchTo().frame(driver.findElement(By.id("idIframe")));
    }

    public ProductCalculatorsGoogleCloudPage clickAddToEstimateBtn () {
        clickElementViaJS(addToEstimateBtn);
        return this;
    }

    public ProductCalculatorsGoogleCloudPage clickOperationSystem () {
        scrollToElementViaJS(arrowOperationSystem);
        clickElementViaJS(arrowOperationSystem);
        return this;
    }

    public ProductCalculatorsGoogleCloudPage clickMachineClass () {
        scrollToElementViaJS(arrowMachineClass);
        clickElementViaJS(arrowMachineClass);
        return this;
    }

    public ProductCalculatorsGoogleCloudPage clickMachineType () {
        scrollToElementViaJS(arrowMachineType);
        clickElementViaJS(arrowMachineType);
        return this;
    }

    public ProductCalculatorsGoogleCloudPage clickAddGPUs () {
        addGPUsCheckbox.click();
        return this;
    }

    public ProductCalculatorsGoogleCloudPage clickNumberOfGPUs () {
        scrollToElementViaJS(arrowLocalSsd);
        clickElementViaJS(arrowNumberOfGPUs);
        return this;
    }

    public ProductCalculatorsGoogleCloudPage clickGPUType () {
        scrollToElementViaJS(arrowGPUType);
        clickElementViaJS(arrowGPUType);
        return this;
    }

    public ProductCalculatorsGoogleCloudPage clickLocalSSD () {
        clickElementViaJS(arrowLocalSsd);
        return this;
    }

    public ProductCalculatorsGoogleCloudPage clickDatacenterLocation () {
        clickElementViaJS(arrowDatacenterLocation);
        return this;
    }

    public ProductCalculatorsGoogleCloudPage clickCommitedUsage () {
        clickElementViaJS(arrowCommitedUsage);
        return this;
    }

    public ProductCalculatorsGoogleCloudPage enterNumberOfInstances (int number) {
        numberOfInstancesField.sendKeys(String.valueOf(number));
        return this;
    }

    public ProductCalculatorsGoogleCloudPage chooseItemInDropDownMenu (String item) {
        List<WebElement> list = driver.findElements(By.xpath(
            "//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[@class=('md-text' or 'md-text ng-binding')]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(list));
        list.stream().filter(webElement -> webElement.getText().contains(item)).collect(Collectors.toList()).get(0).click();
        return this;
    }

    public ProductCalculatorsGoogleCloudPage chooseNumberOfGPUsInDropDownMenu (String item) {
        List<WebElement> list = driver.findElements(By.cssSelector(
            "div[class='md-select-menu-container md-active md-clickable']>md-select-menu>md-content>md-option>div[class='md-text ng-binding']"));
        wait.until(ExpectedConditions.visibilityOfAllElements(list));
        list.stream().filter(webElement -> webElement.getText().contains(item)).collect(Collectors.toList()).get(0).click();
        return this;
    }

    public ProductCalculatorsGoogleCloudPage chooseMachineTypeInDropDownMenu (String item) {
        List<WebElement> list = driver.findElements(By.cssSelector(
            "div[class='md-select-menu-container md-active md-clickable']>md-select-menu>md-content>md-optgroup>md-option>div[class='md-text ng-binding']"));
        wait.until(ExpectedConditions.visibilityOfAllElements(list));
        list.stream().filter(webElement -> webElement.getText().contains(item)).collect(Collectors.toList()).get(0).click();
        return this;
    }

    public void clickElementViaJS (WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
    }

    public void scrollToElementViaJS (WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
    }

    public String getFieldFromEstimate (String field) {
        List<WebElement> list = resultBlock.findElements(By.cssSelector("div[class='md-list-item-text ng-binding']"));
        return list.stream().filter(webElement -> webElement.getText().contains(field)).collect(Collectors.toList()).get(0).getText();
    }

}
