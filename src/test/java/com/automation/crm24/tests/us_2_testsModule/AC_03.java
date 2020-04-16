package com.automation.crm24.tests.us_2_testsModule;

import com.automation.crm24.pages.LoginPage;
import com.automation.crm24.pages.tasks.TasksPage;
import com.automation.crm24.tests.TestBase;
import com.automation.crm24.utilities.BrowserUtils;
import org.testng.annotations.Test;

public class AC_03 extends TestBase {



    @Test
    public void AC_03_UploadFileAndImages(){
        extentTest = extentReports.createTest("user story 2");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        TasksPage t = new TasksPage();
        t.leftNavigation("Tasks");
        t.clickOnNewTaskBtn();
        t.uploadFilesAndImages();
        BrowserUtils.wait(2);
        extentTest.pass("test pass");
    }

    @Test
    public void AC_03_SelectDocumentFromBitrix24(){
        extentTest = extentReports.createTest("user story 2");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        TasksPage t = new TasksPage();
        t.leftNavigation("Tasks");
        t.clickOnNewTaskBtn();
        t.selectDocumentFromBitrix24("class_notes (1).txt");
        BrowserUtils.wait(2);
        extentTest.pass("test pass");
    }

    @Test
    public void AC_03_DownloadFormExternalDrive(){
        extentTest = extentReports.createTest("user story 2");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        TasksPage t = new TasksPage();
        t.leftNavigation("Tasks");
        t.clickOnNewTaskBtn();



        BrowserUtils.wait(2);
        extentTest.pass("test pass");
    }
}
