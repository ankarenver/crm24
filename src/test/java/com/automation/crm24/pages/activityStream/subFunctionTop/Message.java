package com.automation.crm24.pages.activityStream.subFunctionTop;

import com.automation.crm24.pages.PageBase;
import com.automation.crm24.utilites.BrowserUtils;
import com.automation.crm24.utilites.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Message {

    private static WebDriverWait wait;
    protected WebDriver driver = Driver.getDriver();
    @FindBy(xpath = "(//div[@id=\"post-buttons-bottom\"]//span[@title='Upload files'])[1]")
    private  WebElement uploadFile;
    @FindBy(xpath = "//span[@id=\"bx-b-link-blogPostForm\"]")
    private  WebElement addLink;

    public Message(){
        PageFactory.initElements(driver,this);
    }



    public  void uploadFileFromLocal(){
        uploadFile.click();
        String filePath = System.getProperty("user.dir")+"\\Capture.PNG";
        WebElement a = Driver.getDriver().findElement(By.xpath("(//td[@class='diskuf-selector wd-fa-add-file-light-cell wd-fa-add-file-from-main'])[1]"));
        a.click();
        try {
            Runtime.getRuntime().exec("C:\\Users\\Msi\\Desktop\\aouto.exe");
        }catch (Exception e){
            e.printStackTrace();
        }



    }



    public  void addLink(){
        addLink.click();
    }



}
