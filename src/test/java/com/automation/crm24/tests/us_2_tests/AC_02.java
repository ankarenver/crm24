package com.automation.crm24.tests.us_2_tests;

import com.automation.crm24.pages.LoginPage;
import com.automation.crm24.pages.activityStream.ActivityStreamPageTop;
import com.automation.crm24.pages.activityStream.subFunctionTop.Task;
import com.automation.crm24.pages.tasks.TasksPage;
import com.automation.crm24.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AC_02 extends TestBase {

    /**
     * User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.
     */
    @Test
    public void AC_02(){
        extentTest = extentReports.createTest("user story 2 AC02");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("Task");
        Task t = new Task();
        Assert.assertTrue(t.isVisualEditorDisplayed());
        extentTest.pass("US02_AC02 test pass");
    }
}
