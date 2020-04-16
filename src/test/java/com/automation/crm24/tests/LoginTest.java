package com.automation.crm24.tests;

import com.automation.crm24.pages.LoginPage;
import com.automation.crm24.pages.activityStream.ActivityStreamPageTop;
import com.automation.crm24.pages.activityStream.subFunctionTop.Message;
import com.automation.crm24.utilites.BrowserUtils;
import com.automation.crm24.utilites.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginTestTry01(){
        extentTest = extentReports.createTest("Verify page logo");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("hr");

        ActivityStreamPageTop mainPage = new ActivityStreamPageTop();
//        System.out.println(mainPage.getCurrentTime("hh:mm"));
//        mainPage.topNavigation("Drive");
//        Thread.sleep(4000);
//        mainPage.topNavigation("My Workspace","Tasks");
//        Thread.sleep(4000);

//        mainPage.leftModule_clickByValue("");
//        Thread.sleep(4000);

        mainPage.navigateTo("message");
        BrowserUtils.wait(2);
        Driver.getDriver().switchTo().frame(1);
        BrowserUtils.wait(2);
        Driver.getDriver().findElement(By.tagName("body")).sendKeys("finally it worked !!!!!");
        BrowserUtils.wait(2);
        Driver.getDriver().switchTo().defaultContent();
        BrowserUtils.wait(2);
        Message m = new Message();
        BrowserUtils.wait(3);
        m.uploadFileFromLocal();
        BrowserUtils.wait(3);
        mainPage.send();
        BrowserUtils.wait(5);


        extentTest.pass("logo verified !!");






    }


}
