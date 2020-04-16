package com.automation.crm24.tests.us_2_tests;

import com.automation.crm24.pages.LoginPage;
import com.automation.crm24.pages.activityStream.ActivityStreamPageTop;
import com.automation.crm24.pages.activityStream.subFunctionTop.Task;
import com.automation.crm24.tests.TestBase;
import org.testng.annotations.Test;

public class AC_01 extends TestBase {

    /**
     *  User should be able to click on "High Priority" checkbox to set the current task to a top priority task.
     */
    @Test
    public void AC_01(){
        extentTest = extentReports.createTest("user story 2 AC01");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("Task");
        Task t = new Task();
        t.clickOnHighPriorityCheckBox();
        extentTest.pass("US02_AC01 test pass");
    }
}
