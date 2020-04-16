/**
 * Test: User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.
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

public class VisualEditorTest extends TestBase {

    /**
     * General login functionality for repeated test.
     */
    public static void login(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("hr");
        Assert.assertEquals(Driver.getDriver().getTitle(),"Portal");
    }

    /**
     * User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.
     */
    @Test(description = "US-1")
    public void visualEditorTest(){
        extentTest = extentReports.createTest("Add Mention Test");
        login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("message");
        BrowserUtils.wait(3);
        Message msTest=new Message();
        msTest.typeMessage("Online Group - 2 Visual Editor Tested ");
        Assert.assertTrue(msTest.isVisualEditorDisplayed());
        BrowserUtils.wait(3);
        extentTest.pass("Test Succeed");
       test.send();

    }
}
