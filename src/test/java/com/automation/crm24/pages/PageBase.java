package com.automation.crm24.pages;

import com.automation.crm24.utilites.BrowserUtils;
import com.automation.crm24.utilites.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,20);


    @FindBy(id = "user-block")
    protected WebElement currentUser;

    @FindBy(className = "time-hours")
    protected WebElement clockHour;

    @FindBy(className = "time-minutes")
    protected WebElement clockMin;

    @FindBy(className = "time-am-pm")
    protected WebElement clockAmOrPm;

    @FindBy(id = "timeman-container")
    protected WebElement clockBlock;

    @FindBy(id = "search-textbox-input")
    protected WebElement searchBox;

    @FindBy(id = "sitemap-menu")
    protected WebElement siteMapBtn;

    @FindBy(id = "sitemap-content")
    protected WebElement sideMapElement;

    public PageBase(){
        PageFactory.initElements(driver,this);
    }

    public String getCurrentUserName(){
        BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }

    /**
     * this method will return time in different format which user specified
     * @param format user will enter hh:mm or hh or mm
     *
     * @return to return hole hour:minute or only hour or only minute
     */
    public String getCurrentTime(String format){

        BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.visibilityOf(clockBlock));
        format = format.toUpperCase();

        switch (format){
            case "HH:MM":
                return clockHour.getText()+":"+clockMin.getText()+" "+clockAmOrPm.getText();
            case "HH":
                return clockHour.getText();
            case "MM":
                return clockMin.getText();
            case "PERIOD":
                return clockAmOrPm.getText();
            default:
                return "invalid time format selection";
        }

    }


    /**
     * this method will search based on the value that user provide
     * @param value any data that user wants to search
     */
    public void search_value(String value){
        BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys(value, Keys.ENTER);
    }


    /**
     * this method will navigated to user specified module
     * @param module user will enter module name case sensitive
     */
    public void topNavigation(String module){
        BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.visibilityOf(siteMapBtn));
        siteMapBtn.click();
        String path="//a[@class='sitemap-section-title' and contains(text(),'"+module+"')]";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(path)))).click();

    }

    /**
     *
     * @param module
     * @param subModule
     */
    public void topNavigation(String module, String subModule){
        BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.visibilityOf(siteMapBtn));
        siteMapBtn.click();
        String path="//*[@class='sitemap-section-title' and contains(text(),'"+module+"')] /..//a[@class='sitemap-section-item' and contains(text(),'"+subModule+"')]";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(path)))).click();

    }

    /**
     * this method will click on the left modules by user's data
     * @param value  data that user provide case sensitive
     */
    public void leftModule_clickByValue(String value){
        BrowserUtils.waitForPageToLoad(15);
        String path = "//*[@title='"+value+"']";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(path)))).click();
    }









}
