package com.automation.crm24.tests;

import com.automation.crm24.pages.LoginPage;
import com.automation.crm24.pages.mainPage.MainPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginTestTry01() throws Exception{
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("hr");

        MainPage mainPage = new MainPage();
//        System.out.println(mainPage.getCurrentTime("hh:mm"));
        mainPage.topNavigation("Drive");
        Thread.sleep(4000);
        mainPage.topNavigation("My Workspace","Tasks");
        Thread.sleep(4000);




    }


}
