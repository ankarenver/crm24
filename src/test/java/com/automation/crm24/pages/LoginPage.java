package com.automation.crm24.pages;

import com.automation.crm24.utilities.ConfigurationReader;
import com.automation.crm24.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(name = "USER_LOGIN")
    private WebElement userName;

    @FindBy(name = "USER_PASSWORD")
    private WebElement password;

    @FindBy(className = "login-btn")
    private WebElement loginBtn;

    @FindBy(className = "login-link-forgot-pass" )
    private WebElement forgetYourPassword;


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void login(){
        userName.sendKeys(ConfigurationReader.getProperty("hr"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
    }

    /**
     * this method get username and password form the user
     * @param nameOfUser user will enter any data
     * @param password   user will enter any data
     */
    public void login(String nameOfUser, String password){
        userName.sendKeys(nameOfUser);
        this.password.sendKeys(password);
        loginBtn.click();
    }

    /**
     * this method get the type of the credentials from properties file
     * @param userType help_desk, hr, marketing
     */
    public void loginAs(String userType){
        userName.sendKeys(ConfigurationReader.getProperty(userType));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        loginBtn.click();
    }



}
