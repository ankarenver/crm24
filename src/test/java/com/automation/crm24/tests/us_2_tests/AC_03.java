package com.automation.crm24.tests.us_2_tests;

import com.automation.crm24.pages.LoginPage;
import com.automation.crm24.pages.activityStream.ActivityStreamPageTop;
import com.automation.crm24.pages.activityStream.subFunctionTop.Task;
import com.automation.crm24.tests.TestBase;
import com.automation.crm24.utilities.BrowserUtils;
import org.testng.annotations.Test;

public class AC_03 extends TestBase {

    /**
     *  User should be able to click on upload files icon to upload files and pictures from local disks.
     */
    @Test
    public void AC_03_UploadFileAndImages(){
        extentTest = extentReports.createTest("user story 2");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("Task");
        Task t = new Task();
        t.clickOnUploadIcon();
        t.uploadFilesAndImagesFromLocal();
        // we need to update this later by using AutoIT
        extentTest.pass("test pass");
    }

    /**
     *  User should be able to click on upload files icon to select documents from bixtrix24.
     */
    @Test
    public void AC_03_SelectDocumentFromBitrix24(){
        extentTest = extentReports.createTest("user story 2");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("Task");
        Task t = new Task();
        t.clickOnUploadIcon();
        t.uploadFileSelectDocumentFromBitrix24("class_notes (1).txt");
        extentTest.pass("test pass");
    }

    /**
     *  User should be able to click on upload files icon to download from external drive.
     */
    @Test
    public void AC_03_DownloadFormExternalDrive(){
        extentTest = extentReports.createTest("user story 2");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("Task");
        Task t = new Task();
        t.clickOnUploadIcon();
        t.downloadFromExternalDrive();
        BrowserUtils.wait(2);
        extentTest.pass("test pass");
    }

    /**
     * User should be able to click on upload files icon to create files to upload.
     */
    @Test
    public void AC_03_CreateUsingMSOfficeOnline(){
        extentTest = extentReports.createTest("user story 2");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("Task");
        Task t = new Task();
        t.clickOnUploadIcon();

        BrowserUtils.wait(2);
        extentTest.pass("test pass");
    }


}
