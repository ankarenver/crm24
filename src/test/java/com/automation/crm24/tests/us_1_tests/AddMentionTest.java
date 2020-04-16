/**
 * Test: User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown
 * @auhor Omer Faruk Sanlialp
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

public class AddMentionTest extends TestBase {

    /**
     * General login functionality for repeated test.
     */
    public static void login(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("hr");
        Assert.assertEquals(Driver.getDriver().getTitle(),"Portal");
    }

    /**
     * User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown
     */
    @Test(description = "US-1")
    public void addMentionTest(){
        extentTest = extentReports.createTest("Add Mention Test");
        login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("message");
        BrowserUtils.wait(3);
        Message msTest=new Message();
        msTest.typeMessage("Online Group - 2 Mention Added: ");
        msTest.addMention("Help");
        BrowserUtils.wait(3);
        extentTest.pass("Test Succeed");
        test.send();
    }

}
