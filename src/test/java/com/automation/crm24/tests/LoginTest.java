package com.automation.crm24.tests;

import com.automation.crm24.pages.LoginPage;
import com.automation.crm24.pages.activityStream.ActivityStreamPageTop;
import com.automation.crm24.utilites.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginTestTry01() throws Exception{
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

        Assert.assertEquals(Driver.getDriver().getTitle(),"Portal");






    }


}
