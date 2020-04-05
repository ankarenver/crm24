package com.automation.crm24.utilites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


// singleton Driver object

public class Driver {

    // singleton instant value
    private static WebDriver driver;

    // singleton constructor
    private Driver(){}

    public static WebDriver getDriver(String browserNumber){

        if(driver==null){
            String browser = ConfigurationReader.getProperty(browserNumber).toLowerCase();
            String os = System.getProperty("os.name").toLowerCase();
            if(os.contains("windows")&&browser.equalsIgnoreCase("safari")  ||  os.contains("mac")&&browser.equalsIgnoreCase("edg")){
                driver = null;
                throw new RuntimeException("wrong browser selection, browser incompatible with OS");
            }

            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "chromeheadless":
                    //to run chrome without interface (headless mode)
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Wrong browser name !");

            }

        }
        return driver;
    }

    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }



}
