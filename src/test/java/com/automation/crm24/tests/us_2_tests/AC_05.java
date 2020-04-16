package com.automation.crm24.tests.us_2_tests;

import com.automation.crm24.pages.LoginPage;
import com.automation.crm24.pages.activityStream.ActivityStreamPageTop;
import com.automation.crm24.pages.activityStream.subFunctionTop.Task;
import com.automation.crm24.tests.TestBase;
import org.testng.annotations.Test;

public class AC_05 extends TestBase {

    /**
     *  User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.
     */
    @Test
    public void AC_05(){
        extentTest = extentReports.createTest("user story 2 AC05");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("Task");
        Task t = new Task();
        t.addMentionTo("marketing1@cybertekschool.com","helpdesk31@cybertekschool.com","hr85@cybertekschool.com");
        extentTest.pass("US02_AC05 test pass");
    }
}
