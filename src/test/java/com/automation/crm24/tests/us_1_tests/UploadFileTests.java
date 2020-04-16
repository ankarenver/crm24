/**
 * Test: User should be able to click on upload files icon to upload files and pictures
 *
 * * @auhor Omer Faruk Sanlialp
 * @version 1.0
 * @since 2020-04-14
 */
package com.automation.crm24.tests.us_1_tests;

import com.automation.crm24.pages.LoginPage;
import com.automation.crm24.pages.activityStream.subFunctionTop.Message;
import com.automation.crm24.tests.TestBase;
import com.automation.crm24.utilites.BrowserUtils;
import com.automation.crm24.utilites.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.crm24.pages.activityStream.ActivityStreamPageTop;

public class UploadFileTests extends TestBase {

    /**
     * General login functionality for repeated test.
     */
    public static void login(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("hr");
        Assert.assertEquals(Driver.getDriver().getTitle(),"Portal");
    }

    /**
     * User should be able to click on upload files icon to upload files and pictures from local disks
     */
    @Test(description = "US-1")
    public void uploadFileFromLocalDisk(){

        extentTest = extentReports.createTest("Upload image from local drive");
        login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("message");
        Message msTest=new Message();

        msTest.uploadFileFromLocal("Downloads/CRM24/testDocument/1.jpg");

        msTest.typeMessage("Online Group - 2 Upload File from Local File");
        BrowserUtils.wait(5);
        extentTest.pass("Upload Succeed");
       // test.send();

    }

    /**
     * User should be able to click on upload files icon to download from external drive.
     */
    @Test(description = "US-1")
    public void downloadFileFromExtarnal(){
        extentTest = extentReports.createTest("Upload image from extarnal drive");
        login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("message");
        Message msTest=new Message();
        msTest.uploadFileFromExtarnalDrive();

        BrowserUtils.wait(5);
        msTest.typeMessage("Online Group - 2 Upload File from Extarnal");
        extentTest.pass("Upload Succeed");
        test.send();

    }


    /**
     * User should be able to click on upload files icon to select documents from bixtrix24,
     * and create files to upload.
     */
    @Test(description = "US-1")
    public void selectDocumentFromBitrix24(){
        extentTest = extentReports.createTest("Upload image from Bitrix24");
        login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("message");
        Message msTest=new Message();
        msTest.uploadFileFromBitrix24("1 (15).jpg");

        BrowserUtils.wait(5);
        msTest.typeMessage("Online Group - 2 Upload File From Bitrix24");

        extentTest.pass("Upload Succeed");
        test.send();

    }

    /**
     * User should be able to click on upload files icon to create files to upload. From Document
     */
    @Test(description = "US-1")
    public void createFileToUploadFromDocument(){

        extentTest = extentReports.createTest("Upload image from Office365");
        login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("message");
        Message msTest=new Message();
        msTest.createUploadFileOffice365("Document");
        BrowserUtils.wait(5);
        msTest.typeMessage("Online Group - 2 Upload File From Bitrix24");

        extentTest.pass("Upload Succeed");
        test.send();

    }
    /**
     * User should be able to click on upload files icon to create files to upload. From Spreadsheet
     */
    @Test(description = "US-1")
    public void createFileToUploadSpreadsheet(){

        extentTest = extentReports.createTest("Upload image from Office365");
        login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("message");
        Message msTest=new Message();
        msTest.createUploadFileOffice365("Spreadsheet");
        BrowserUtils.wait(5);
        msTest.typeMessage("Online Group - 2 Upload File From Bitrix24");

        extentTest.pass("Upload Succeed");
        test.send();

    }
    /**
     * User should be able to click on upload files icon to create files to upload. From Presentation
     */
    @Test(description = "US-1")
    public void createFileToUploadPresentation(){

        extentTest = extentReports.createTest("Upload image from Office365");
        login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("message");
        Message msTest=new Message();
        msTest.createUploadFileOffice365("Presentation");
        BrowserUtils.wait(5);
        msTest.typeMessage("Online Group - 2 Upload File From Bitrix24");

        extentTest.pass("Upload Succeed");
        test.send();

    }
}
