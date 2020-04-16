package com.automation.crm24.pages.activityStream.subFunctionTop;

import com.automation.crm24.pages.PageBase;
import com.automation.crm24.utilites.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Task extends PageBase {

    @FindBy(id = "tasks-task-priority-cb")
    private WebElement highPriority;

    @FindBy(css = "#lhe_button_editor_task-form-lifefeed_task_form")
    private static WebElement visualEditor;

    @FindBy(css = "#bx-b-uploadfile-task-form-lifefeed_task_form")
    private WebElement uploadIco;

    @FindBy(xpath = "//span[@id='bx-b-uploadfile-task-form-lifefeed_task_form']/..//span[@title='Quote text']")
    private WebElement comaIcon;

    @FindBy(id = "bx-b-mention-task-form-lifefeed_task_form")
    private WebElement mentionIcon;




    public Task(){
        PageFactory.initElements(driver,this);
    }


    /**
     * this method will click on High Priority check-box
     */
    public void clickOnHighPriorityCheckBox(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(highPriority)).click();
    }

    /**
     * Checks is Visual Editor Displayed or Not
     * @return true/false if displayed/not displayed
     *
     */
    public boolean isVisualEditorDisplayed(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(visualEditor)).click();
        BrowserUtils.wait(1);
        return driver.findElement(By.id("bx-html-editor-tlbr-lifefeed_task_form")).isDisplayed();
    }

    public void clickOnUploadIcon(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(uploadIco)).click();
    }

    public void uploadFileSelectDocumentFromBitrix24(String fileName){
        BrowserUtils.waitForPageToLoad(10);
        driver.findElement(By.xpath("//div[@class='task-info']//span[@class='wd-fa-add-file-light-title-text diskuf-selector-link']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//a[@href='#' and (text()='"+fileName+"')]")).click();
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("//span[@class='popup-window-button popup-window-button-accept']")).click();
    }

    public void uploadFilesAndImagesFromLocal(){
        BrowserUtils.waitForPageToLoad(10);
        driver.findElement(By.xpath("//div[@class='task-info']//input[@class='diskuf-fileUploader wd-test-file-light-inp ']/..")).click();
        BrowserUtils.wait(2);
    }

    public void downloadFromExternalDrive(){
        BrowserUtils.waitForPageToLoad(10);
        driver.findElement(By.xpath("//div[@class='task-info']//span[@class='wd-fa-add-file-light-title-text' and contains(text(),'Download from external drive')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"ui-notification-balloon-message\"]")).isDisplayed());
        BrowserUtils.wait(2);
    }

    public void clickOnComaIcon(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(comaIcon)).click();
    }

    public boolean comaSpaceIsDisplay(){
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@class=\"bx-editor-iframe\"])[2]")));
        return driver.findElement(By.xpath("//body//blockquote")).isDisplayed();
    }

    public void addMentionTo(String... names){
        String path ;
        for (String each : names){
            BrowserUtils.waitForPageToLoad(10);
            wait.until(ExpectedConditions.visibilityOf(mentionIcon)).click();
            BrowserUtils.wait(2);
            driver.findElement(By.xpath("//a[text()='Employees and departments']")).click();
            BrowserUtils.wait(2);
            path = "//div[@class='bx-finder-company-department-employee-name' and (text()='"+each+"')]";
            driver.findElement(By.xpath(path)).click();
        }
        BrowserUtils.wait(3);
    }


}
