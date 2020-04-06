package com.automation.crm24.utilites;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class BrowserUtils {

    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * this method will wait until page is fully loaded
     * @param timeOutInSec user will provide time in second
     */
    public static void waitForPageLoad(long timeOutInSec){
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");

        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),timeOutInSec);
            wait.until(expectation);
        }catch (Throwable e){
            e.printStackTrace();
        }
    }


    /**
     * @param name screenshot name
     * @return path to the screenshot
     */
    public static String getScreenshot(String name){
        // adding date and time to screenshot name, to make screenshot unique
        name = new Date().toString().replace(" ","_").replace(":","_")+"_"+name;
        // where we gonna store a screenshot
        String path = System.getProperty("user.dir")+"\\test-output\\screenshots\\"+name+".png";
        System.out.println("Screenshot is here: "+path);
        // since our reference type is a WebDriver
        // we cannot see methods from TakesScreenshot interface
        // that is why do casting
        TakesScreenshot takesScreenshot =(TakesScreenshot) Driver.getDriver();
        // screenshot itself  take screenshot of web browser, and save it as a file
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        // where screenshot will be saved
        File destination = new File(path);
        try {
            FileUtils.copyFile(source,destination);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File is not found");
        }
        return path;
    }
}
