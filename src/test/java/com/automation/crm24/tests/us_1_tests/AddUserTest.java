/**
 * Test: User should be able to add users from selecting contact from E-mail user, Employees and Departments and Recent contact lists.
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

public class AddUserTest extends TestBase {
    /**
     * General login functionality for repeated test.
     */
    public static void login(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("hr");
        Assert.assertEquals(Driver.getDriver().getTitle(),"Portal");
    }


    /**
     * User should be able to add users from selecting contact from E-mail user, Employees and Departments and Recent contact lists.
     */
    @Test(description = "US-1")
    public void addContactFromGroupTest(){
        String department= "My Groups";
        String email="Soccer team";
        extentTest = extentReports.createTest("Add contact to message from "+department+"-"+email);
        login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("message");
        BrowserUtils.wait(3);
        sendMessageFromTo(department,email);
        extentTest.pass("Test Succeed");
        test.send();
    }

    /**
     * User should be able to add users from selecting contact from E-mail user, Employees and Departments and Recent contact lists.
     */
    @Test(description = "US-1")
    public void addContactFromEmployees(){
        String department= "Employees and departments";
        String email="helpdesk28@cybertekschool.com";
        extentTest = extentReports.createTest("Add contact to message from "+department+"-"+email);
        login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("message");
        BrowserUtils.wait(3);
        sendMessageFromTo(department,email);
        extentTest.pass("Test Succeed");
        test.send();
    }
    /**
     * User should be able to add users from selecting contact from E-mail user, Employees and Departments and Recent contact lists.
     */
    @Test(description = "US-1")
    public void addContactFromEmail(){
        String department= "E-mail users";
        String email="helpdesk28@cybertekschool.com";
        extentTest = extentReports.createTest("Add contact to message from "+department+"-"+email);
        login();
        ActivityStreamPageTop test=new ActivityStreamPageTop();
        test.navigateTo("message");
        BrowserUtils.wait(3);
        sendMessageFromTo(department,email);
        extentTest.pass("Test Succeed");
        test.send();
    }

    public void sendMessageFromTo(String department,String email){
        Message msTest=new Message();
        msTest.typeMessage("Online Group - 2 add contact from "+department+" - "+ email);
        msTest.addPersonFrom(department,email);
        BrowserUtils.wait(3);
    }
}
