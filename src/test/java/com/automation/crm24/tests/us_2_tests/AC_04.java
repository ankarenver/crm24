package com.automation.crm24.tests.us_2_tests;

import com.automation.crm24.pages.LoginPage;
import com.automation.crm24.pages.activityStream.ActivityStreamPageTop;
import com.automation.crm24.pages.activityStream.subFunctionTop.Task;
import com.automation.crm24.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AC_04 extends TestBase {

    /**
     *  User should be able to create a quote by clicking on the Comma icon.
     */
    @Test
    public void AC_04(){
        extentTest = extentReports.createTest("user story 2 AC04");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("Task");
        Task t = new Task();
        t.clickOnComaIcon();
        // to check if the yellow space is ready to type something
        Assert.assertTrue(t.comaSpaceIsDisplay());
        extentTest.pass("US02_AC04 test pass");
    }
}
