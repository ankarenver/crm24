package com.automation.crm24.pages.tasks;

import com.automation.crm24.pages.PageBase;
import com.automation.crm24.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TasksPage extends PageBase {

    @FindBy(css = "#tasks-buttonAdd")
    private WebElement newTaskBtn;

    @FindBy(css = "#tasks-task-priority-cb")
    private WebElement highPriorityCheckBox;

    @FindBy(css = "#bx-panel-toggle-indicator")
    private WebElement editIcon;

    @FindBy(xpath = "//span[@class=\"feed-add-post-form-but feed-add-file\"]")
    private WebElement uploadFileIcon;


    public TasksPage(){
        PageFactory.initElements(driver,this);
    }

    /**
     * this method will fine NEW Task button and click on it
     */
    public void clickOnNewTaskBtn(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(newTaskBtn)).click();
    }

    /**
     * this method will click on High Priority check-box
     */
    public void clickOnHighPriorityCheckBox(){
        BrowserUtils.waitForPageToLoad(10);
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class=\"side-panel-content-container\"]//iframe")));
        BrowserUtils.wait(2);
//        driver.findElement(By.xpath("//div[@class=\"task-info-panel-title\"]//input[@type='text']")).sendKeys("hi there");
        wait.until(ExpectedConditions.visibilityOf(highPriorityCheckBox)).click();
        driver.switchTo().defaultContent();
        BrowserUtils.wait(2);
    }

    /**
     * this method will
     */
    public void clickOnEditIcon(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(editIcon)).click();
    }

    public void uploadFilesAndImages(){
        BrowserUtils.waitForPageToLoad(10);
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class=\"side-panel-content-container\"]//iframe")));
        wait.until(ExpectedConditions.visibilityOf(uploadFileIcon)).click();
        driver.findElement(By.xpath("//input[@class=\"diskuf-fileUploader wd-test-file-light-inp \"]/../..")).click();
        try {
            Runtime.getRuntime().exec("C:\\Users\\Msi\\Documents\\aouto.exe");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectDocumentFromBitrix24(String nameOfFile){
        BrowserUtils.waitForPageToLoad(10);
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class=\"side-panel-content-container\"]//iframe")));
        wait.until(ExpectedConditions.visibilityOf(uploadFileIcon)).click();
        driver.findElement(By.xpath("(//td[@class='wd-fa-add-file-light-cell'])[1]//span[@class='wd-fa-add-file-light-title-text diskuf-selector-link']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//a[@href='#' and (text()='"+nameOfFile+"')]")).click();
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("//span[@class='popup-window-button popup-window-button-accept']")).click();
    }

    public void downloadFromExternalDrive(){
        BrowserUtils.waitForPageToLoad(10);
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class=\"side-panel-content-container\"]//iframe")));
        wait.until(ExpectedConditions.visibilityOf(uploadFileIcon)).click();

    }


//    public void writeSth(){
//        BrowserUtils.waitForPageToLoad(10);
//        driver.switchTo().frame(driver.findElement(By.cssSelector("bx-editor-iframe")));
//        driver.findElement(By.xpath("//body[@contenteditable=\"true\"]")).sendKeys("hi there !!");
//    }
}
