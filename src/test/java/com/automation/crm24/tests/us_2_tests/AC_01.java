package com.automation.crm24.tests.us_2_tests;

import com.automation.crm24.pages.LoginPage;
import com.automation.crm24.pages.tasks.TasksPage;
import com.automation.crm24.tests.TestBase;
import org.testng.annotations.Test;

public class AC_01 extends TestBase {

    @Test
    public void AC_01(){
        extentTest = extentReports.createTest("user story 2 AC01");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        TasksPage t = new TasksPage();
        t.leftModule_clickByValue("Tasks");
        t.clickOnNewTaskBtn();
        t.clickOnHighPriorityCheckBox();
        extentTest.pass("US02_AC01 test pass");
    }
}
