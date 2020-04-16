/**
 * Test: User should be able to click on "Record Video" tab to record a video and attach it with the message.
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

public class VideoRecordTest extends TestBase {

    /**
     * General login functionality for repeated test.
     */
    public static void login(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("hr");
        Assert.assertEquals(Driver.getDriver().getTitle(),"Portal");
    }

    /**
     * User should be able to click on "Record Video" tab to record a video and attach it with the message.
     */
    @Test(description = "US-1")
    public void videoRecordTest(){
        extentTest = extentReports.createTest("Video Record Test");
        login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("message");
        BrowserUtils.wait(3);
        Message msTest=new Message();
        msTest.typeMessage("Online Group - 2 Video Record Tested ");
        msTest.addVideoRecord();
        BrowserUtils.wait(10);
        test.send();


    }


}
