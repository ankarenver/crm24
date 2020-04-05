package com.automation.crm24.utilites;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

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
}
