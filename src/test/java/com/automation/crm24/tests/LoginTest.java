package com.automation.crm24.tests;

import com.automation.crm24.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginTestTry01(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("hr");
    }

    @Test
    public void  loginTestTry02(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("marketing27@cybertekschool.com","UserUser");
    }
}
