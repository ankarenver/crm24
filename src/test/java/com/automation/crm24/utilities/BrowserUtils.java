package com.automation.crm24.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public static void waitForPageToLoad(long timeOutInSec){
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
    public static String getScreenshot(String name) {
        //adding date and time to screenshot name, to make screenshot unique
        name = new Date().toString().replace(" ", "_").replace(":", "-") + "_" + name;
        //where we gonna store a screenshot
        String path = "";

        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            path = System.getProperty("user.dir") + "/test-output/screenshots/" + name + ".png";
        } else {
            path = System.getProperty("user.dir") + "\\test-output\\screenshots\\" + name + ".png";
        }

        System.out.println("OS name: " + System.getProperty("os.name"));
        System.out.println("Screenshot is here: " + path);
        //since our reference type is a WebDriver
        //we cannot see methods from TakesScreenshot interface
        //that's why do casting
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        //take screenshot of web browser, and save it as a file
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        //where screenshot will be saved
        File destination = new File(path);
        try {
            //copy file to the previously specified location
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     *  this method will convert list of WebElement to list of String
     * @param data  represents collection of WebElements
     * @return list of strings
     */
    public static List<String> getTextFromWebElement(List<WebElement> data){
        List<String> result = new ArrayList<>();
        data.forEach(each -> result.add(each.getText()));
        return result;
    }
}
