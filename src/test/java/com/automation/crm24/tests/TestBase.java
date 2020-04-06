package com.automation.crm24.tests;


import com.automation.crm24.utilites.BrowserUtils;
import com.automation.crm24.utilites.ConfigurationReader;
import com.automation.crm24.utilites.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {


    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("environment"));
        Driver.getDriver().manage().window().maximize();
        BrowserUtils.waitForPageLoad(10);
    }
    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }
}
