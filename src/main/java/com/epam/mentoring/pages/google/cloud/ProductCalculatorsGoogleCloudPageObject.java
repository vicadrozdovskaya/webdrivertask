package com.epam.mentoring.pages.google.cloud;

import com.epam.mentoring.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;

import java.util.List;
import java.util.stream.Collectors;


public class ProductCalculatorsGoogleCloudPageObject extends AbstractPage {

    private final static By searchNumberOfInstancesField = By.cssSelector("input[ng-model='listingCtrl.computeServer.quantity']");

    private final static By searchOperationSystemLocator = By.xpath("//label[text()='Operating System / Software']/parent::*/md-select");

    private final static By searchMachineClassLocator = By.cssSelector("md-select[placeholder='VM Class']");

    private final static By searchMachineTypeLocator = By.cssSelector("md-select[placeholder='Instance type']");

    private final static By searchAddGPUsCheckboxLocator = By.xpath("//div[contains(text(),'Add GPUs.')]");

    private final static By searchNumberOfGPUsLocator = By.cssSelector("md-select[placeholder='Number of GPUs']");

    private final static By searchGPUTypeLocator = By.cssSelector("md-select[placeholder='GPU type']");

    private final static By searchLocalSsdLocator = By.cssSelector("md-select[placeholder='Local SSD']");

    private final static By searchDatacenterLocationLocator = By.cssSelector("md-select[placeholder='Datacenter location']");

    private final static By searchCommitedUsageLocator = By.cssSelector("md-select[placeholder='Committed usage']");

    private final static By searchAddToEstimateBtnLocator = By.cssSelector("button[aria-label='Add to Estimate']");

    private final static By searchResultBlockLocator = By.id("resultBlock");

    private final static By searchItemInDropDownMenu = By.xpath(
            "//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[@class=('md-text' or 'md-text ng-binding')]");

    private final static By searchMachineTypeItemInDropDownMenu = By.cssSelector(
            "div[class='md-select-menu-container md-active md-clickable']>md-select-menu>md-content>md-optgroup>md-option>div[class='md-text ng-binding']");

    private final static By searchFieldInEstimateSection = By.cssSelector("div[class='md-list-item-text ng-binding']");

    public ProductCalculatorsGoogleCloudPageObject () {
        this.driver.switchTo().frame(driver.findElement(By.id("idIframe")));
    }

    public ProductCalculatorsGoogleCloudPageObject clickAddToEstimateBtn () {
        moveAndClickAction(searchAddToEstimateBtnLocator);
        return this;
    }

    public ProductCalculatorsGoogleCloudPageObject clickOperationSystem () {
        moveAndClickAction(searchOperationSystemLocator);
        return this;
    }

    public ProductCalculatorsGoogleCloudPageObject clickMachineClass () {
        moveAndClickAction(searchMachineClassLocator);
        return this;
    }

    public ProductCalculatorsGoogleCloudPageObject clickMachineType () {
        moveAndClickAction(searchMachineTypeLocator);
        return this;
    }

    public ProductCalculatorsGoogleCloudPageObject clickAddGPUs () {
        moveAndClickAction(searchAddGPUsCheckboxLocator);
        return this;
    }

    public ProductCalculatorsGoogleCloudPageObject clickNumberOfGPUs () {
        moveAndClickAction(searchNumberOfGPUsLocator);
        return this;
    }

    public ProductCalculatorsGoogleCloudPageObject clickGPUType () {
        moveAndClickAction(searchGPUTypeLocator);
        return this;
    }

    public ProductCalculatorsGoogleCloudPageObject clickLocalSSD () {
        moveAndClickAction(searchLocalSsdLocator);
        return this;
    }

    public ProductCalculatorsGoogleCloudPageObject clickDatacenterLocation () {
        moveAndClickAction(searchDatacenterLocationLocator);
        return this;
    }

    public ProductCalculatorsGoogleCloudPageObject clickCommitedUsage () {
        moveAndClickAction(searchCommitedUsageLocator);
        return this;
    }

    public ProductCalculatorsGoogleCloudPageObject enterNumberOfInstances (int number) {
        new Actions(driver).sendKeys(driver.findElement(searchNumberOfInstancesField), String.valueOf(number)).perform();
        return this;
    }

    public ProductCalculatorsGoogleCloudPageObject chooseItemInDropDownMenu (String item) {
        List<WebElement> list = driver.findElements(searchItemInDropDownMenu);
        waitForElementsVisible(searchItemInDropDownMenu);
        list.stream().filter(webElement -> webElement.getText().contains(item)).findFirst().get().click();
        return this;
    }

    public ProductCalculatorsGoogleCloudPageObject chooseMachineTypeInDropDownMenu (String item) {
        List<WebElement> list = driver.findElements(searchMachineTypeItemInDropDownMenu);
        waitForElementsVisible(searchMachineTypeItemInDropDownMenu);
        list.stream().filter(webElement -> webElement.getText().contains(item)).findFirst().get().click();
        return this;
    }

    public String getFieldFromEstimate (String field) {
        List<WebElement> list = driver.findElement(searchResultBlockLocator).findElements(searchFieldInEstimateSection);
        return list.stream().filter(webElement -> webElement.getText().contains(field)).findFirst().get().getText();
    }

    public void scrollToElement (By by) {
        Locatable element = (Locatable) driver.findElement(by);
        Point point = element.getCoordinates().inViewPort();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(" + point.getX() + "," + (point.getY() + 150) + ");");
    }

    public void moveAndClickAction (By by) {
        scrollToElement(by);
        new Actions(driver).moveToElement(driver.findElement(by)).click().perform();
    }

}
