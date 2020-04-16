/**
 * Test: User should be able to click on the Topic icon to see the Message Topic text box displays on top of the message box.
 *
 * * @auhor Omer Faruk Sanlialp
 * @version 1.0
 * @since 2020-04-14
 */
package com.automation.crm24.tests.us_1_tests;

import com.automation.crm24.pages.LoginPage;
import com.automation.crm24.pages.activityStream.subFunctionTop.Message;
import com.automation.crm24.tests.TestBase;
import com.automation.crm24.utilities.BrowserUtils;
import com.automation.crm24.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.crm24.pages.activityStream.ActivityStreamPageTop;

public class MessageTopicTest extends TestBase {

    /**
     * General login functionality for repeated test.
     */
    public static void login(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("hr");
        Assert.assertEquals(Driver.getDriver().getTitle(),"Portal");
    }

    /**
     * User should be able to click on the Topic icon to see the Message Topic text box displays on top of the message box.
     */
    @Test(description = "US-1")
    public void TitleTest(){
        extentTest = extentReports.createTest("Title Test");
        login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("message");
        BrowserUtils.wait(3);
        Message msTest=new Message();
        msTest.typeMessage("Online Group - 2 Message Title Tested: ");
         Assert.assertTrue(msTest.isTitleOfTopicDisplayed());
        BrowserUtils.wait(3);
        test.send();
    }

}
