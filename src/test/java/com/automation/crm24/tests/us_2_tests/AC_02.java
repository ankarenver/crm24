package com.automation.crm24.tests.us_2_tests;

import com.automation.crm24.pages.LoginPage;
import com.automation.crm24.pages.tasks.TasksPage;
import com.automation.crm24.tests.TestBase;
import org.testng.annotations.Test;

public class AC_02 extends TestBase {

    @Test
    public void AC_02(){
        extentTest = extentReports.createTest("user story 2 AC02");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        TasksPage t = new TasksPage();
        t.leftModule_clickByValue("Tasks");
        t.clickOnEditIcon();
        extentTest.pass("US02_AC02 test pass");
    }
}
