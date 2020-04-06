package com.automation.crm24.tests;


import com.automation.crm24.utilites.BrowserUtils;
import com.automation.crm24.utilites.ConfigurationReader;
import com.automation.crm24.utilites.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public abstract class TestBase {

    protected WebDriver driver = Driver.getDriver();
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeTest
    public void beforeTest() {
        extentReports = new ExtentReports();
        String reportPath = "";

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            reportPath = System.getProperty("user.dir") + "\\test-output\\report.html";
        } else {
            reportPath = System.getProperty("user.dir") + "/test-output/report.html";
        }
        extentHtmlReporter = new ExtentHtmlReporter(reportPath);
        extentReports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setReportName("CRM24");
    }

    @AfterTest
    public void afterTest() {
        extentReports.flush();
    }



    @BeforeMethod
    public void setup(){
        driver.get(ConfigurationReader.getProperty("environment"));
        driver.manage().window().maximize();
        BrowserUtils.waitForPageLoad(10);
    }

    @AfterMethod
    public void teardown(ITestResult testResult){
        if(testResult.getStatus()==ITestResult.FAILURE){
            String  screenshotLocation = BrowserUtils.getScreenshot(testResult.getName());
            try {
                extentTest.fail(testResult.getName());//test name that failed
                extentTest.addScreenCaptureFromPath(screenshotLocation);//screenshot as an evidence
                extentTest.fail(testResult.getThrowable());//error message
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to attach screenshot");
            }
        }else if(testResult.getStatus() == ITestResult.SUCCESS){
            extentTest.pass(testResult.getName());
        }else if(testResult.getStatus() == ITestResult.SKIP){
            extentTest.skip(testResult.getName());
        }
        BrowserUtils.wait(3);

        Driver.closeDriver();
    }
}
