/**
 * Test: User should be able to create a quote by clicking on the Comma icon.
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

public class AddQuoteTest extends TestBase {


    /**
     * General login functionality for repeated test.
     */
    public static void login(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("hr");
        Assert.assertEquals(Driver.getDriver().getTitle(),"Portal");
    }

    /**
     * User should be able to create a quote by clicking on the Comma icon.
     */
    @Test(description = "US-1")
    public void addQuote(){
        extentTest = extentReports.createTest("Add Quote Test");
        login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("message");
        BrowserUtils.wait(3);
        Message msTest=new Message();
        msTest.typeMessage("Online Group - 2 Quote Added: ");
        msTest.addQuote("If you can dream it, you can do it");
        BrowserUtils.wait(3);
       test.send();
    }

}
