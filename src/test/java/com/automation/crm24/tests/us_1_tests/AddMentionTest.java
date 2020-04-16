/**
 * Test: User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown
 * @auhor Omer Faruk Sanlialp
 * @version 1.0
 * @since 2020-04-14
 */
package com.automation.crm24.tests.us_1_tests;

import com.automation.crm24.pages.LoginPage;
import com.automation.crm24.pages.activityStream.ActivityStreamPageTop;
import com.automation.crm24.pages.activityStream.subFunctionTop.Message;
import com.automation.crm24.tests.TestBase;
import com.automation.crm24.utilities.BrowserUtils;
import com.automation.crm24.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        String mentionTo="Help";
        msTest.addMention(mentionTo);
        BrowserUtils.wait(3);
        Assert.assertEquals(mentionTo,Driver.getDriver().findElement(By.xpath("//span[@class='feed-add-post-destination-text' and text()='"+mentionTo+"']")).getText());
        extentTest.pass("Test Succeed");
        test.send();
    }

}
