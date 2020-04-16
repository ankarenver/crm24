/**
 * This class includes main functionality of Message module for Activity Stream Module
 * @auhor Omer Faruk Sanlialp
 * @version 1.0
 * @since 2020-04-14
 */
package com.automation.crm24.pages.activityStream.subFunctionTop;

import com.automation.crm24.pages.PageBase;
import com.automation.crm24.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Message extends PageBase {



    @FindBy(xpath = "(//span[@class=\"feed-add-post-form-but feed-add-file\"])[1]")
    private static WebElement uploadFile;

    @FindBy(xpath = "//span[@id=\"bx-b-link-blogPostForm\"]")
    private static  WebElement addLink;

    @FindBy(xpath = "//span[@id=\"bx-b-video-blogPostForm\"]")
    private static WebElement insertVideo;

    @FindBy(xpath = "//span[@id=\"bx-b-quote-blogPostForm\"]")
    private static WebElement quoteText;

    @FindBy(xpath = "//span[@id=\"bx-b-mention-blogPostForm\"]")
    private static WebElement addMention;

    @FindBy(xpath = "//a[text()='Add more']")
    private static WebElement addTO_Contact;


    @FindBy(xpath = "//span[@id=\"bx-b-tag-input-blogPostForm\"]")
    private static WebElement addTag;

    @FindBy(xpath = "//span[@class='feed-add-post-form-but-cnt feed-add-videomessage' and contains(text(),'Record Video')]")
    private static  WebElement recordVideo;

    @FindBy(className = "bx-editor-iframe")
    private static WebElement editorIframe;

    @FindBy(id="POST_TITLE")
    private static WebElement topicTitle;

    @FindBy(id = "lhe_button_title_blogPostForm")
    private static WebElement titleBtn;

    @FindBy(id = "lhe_button_editor_blogPostForm")
    private static WebElement visualEditor;

    @FindBy(xpath = "//span[@class=\"feed-add-post-form-but-cnt feed-add-videomessage\"]")
    private static WebElement videoRecordBtn;


    public void typeMessage(String message){
        driver.switchTo().frame(editorIframe).findElement(By.tagName("body")).sendKeys(message);
BrowserUtils.wait(1);
        driver.switchTo().defaultContent();
    }

    public void clickUploadFileIcon(){
        wait.until(ExpectedConditions.visibilityOf(uploadFile)).click();
    }

    /**
     * Upload file from local
     */
    public void uploadFileFromLocal(String fileLocation){

       clickUploadFileIcon();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class=\"wd-fa-add-file-light-descript\" and contains(text(),'Drag')]/../../..")))).click();

        try {
            Runtime.getRuntime().exec("osascript "+System.getProperty("user.dir") + "/uploadFile.scpt "+fileLocation);

        }catch (Exception e){
            e.printStackTrace();
        }

        BrowserUtils.wait(3);


    }

    /**
     * Upload file from Bitrix24
     */
    public void uploadFileFromBitrix24(String itemName){
        clickUploadFileIcon();

        //There is a bug, this box is not clickable. You should click directly title
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class=\"wd-fa-add-file-light-title-text diskuf-selector-link\" and contains(text(),'Select document from Bitrix24')]")))).click();

        BrowserUtils.wait(2);
        List<WebElement> recentItemList=driver.findElements(By.xpath("//a[@class='bx-file-dialog-content-link bx-file-dialog-icon bx-file-dialog-icon-file']"));
        for (WebElement e:recentItemList) {
           if(e.getText().equalsIgnoreCase(itemName)){
               e.click();
               break;
           }
        }
        BrowserUtils.wait(2);
        WebElement selectDocument=driver.findElement(By.xpath("//span[@class='popup-window-button popup-window-button-accept']"));
        selectDocument.click();
        BrowserUtils.wait(3);


    }

    /**
     * Upload file from Extarnal Drive
     */
    public void uploadFileFromExtarnalDrive(){
        clickUploadFileIcon();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class=\"wd-fa-add-file-light-title-text\" and contains(text(),'Download from')]/..")))).click();

        BrowserUtils.wait(3);
        WebElement error=driver.findElement(By.className("ui-notification-balloon-content"));
        Assert.assertFalse(error.isDisplayed(),"Download from extarnal drive Service Problem");

    }

    /**
     * Upload created file from Office365
     */
    public void createUploadFileOffice365(String documentType){
        clickUploadFileIcon();
        BrowserUtils.wait(3);

        String mainWindow=driver.getWindowHandle();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[span[@class=\"wd-fa-add-file-editor-link\" and contains(text(),\""+documentType+"\")]]")))).click();

        BrowserUtils.wait(3);
        Set<String> set =driver.getWindowHandles();
        Iterator<String> itr= set.iterator();
        while(itr.hasNext()){
            String childWindow=itr.next();
            if(!mainWindow.equals(childWindow)){
                driver.switchTo().window(childWindow);
                System.out.println(driver.switchTo().window(childWindow).getTitle());
                Assert.assertFalse(driver.findElement(By.id("error-text")).isDisplayed(),"There is error for Office365 - "+documentType+"");
            }
        }
        driver.switchTo().window(mainWindow);

        BrowserUtils.wait(3);

    }


    /**
     * Add contact from
     * @param category accepts contact folder name
     *             "My Groups"
     *             "Employees and departments"
     *             "E-mail users"
     * @param contactName accepts contact name (email, or departmen name or group name)
     */
    public void addPersonFrom(String category, String contactName){
        String path="";
        addTO_Contact.click();
        driver.findElement(By.xpath("//a[text()='"+category+"']")).click();
        BrowserUtils.wait(3);
        switch (category){
            case "My Groups":
                path="//div[@id=\"bx-lm-box-group-content\"]//a[div/div[@class=\"bx-finder-box-item-t7-name\" and text()=\""+contactName+"\"]]";
                BrowserUtils.wait(1);
                driver.findElement(By.xpath(path)).click();
                break;
            case "Employees and departments":
                path="//a[div/div[@class=\"bx-finder-company-department-employee-name\" and text()=\""+contactName+"\"]]";
                BrowserUtils.wait(1);
                driver.findElement(By.xpath(path)).click();
                break;
            case "E-mail users":
                driver.findElement(By.xpath("//input[@id='feed-add-post-destination-input']")).sendKeys(contactName);
                BrowserUtils.wait(1);
                path="//a[div/div[@class=\"bx-finder-box-item-t7-name\" and text()=\""+contactName+"\"]]";
                driver.findElement(By.xpath(path)).click();
                break;
        }


    }

    /**
     * Add link to message
     * @param text accepts a text for link
     * @param link accepts a link
     */
    public void addLink(String text, String link){
        addLink.click();
        BrowserUtils.wait(2);
        driver.findElement(By.id("linkidPostFormLHE_blogPostForm-text")).sendKeys(text);
        driver.findElement(By.id("linkidPostFormLHE_blogPostForm-href")).sendKeys(link);
        driver.findElement(By.xpath("//input[@value=\"Save\"]")).click();

    }

    /**
     * Add Video Link to message
     * @param link accepts a link
     */
    public void addVideo(String link){
        insertVideo.click();
        BrowserUtils.wait(2);
        driver.findElement(By.id("video_idPostFormLHE_blogPostForm-source")).sendKeys(link);
        Assert.assertFalse(driver.findElement(By.xpath("//td[@class='bxhtmled-video-error-cell']")).isDisplayed(),"Someting wrong with the link");
        driver.findElement(By.xpath("//input[@value=\"Save\"]")).click();

    }

    /**
     * Add a quote
     * @param text accepts quote
     */
    public void addQuote(String text){
        quoteText.click();
        driver.switchTo().frame(editorIframe).findElement(By.tagName("blockquote")).sendKeys(text);
        BrowserUtils.wait(1);
        driver.switchTo().defaultContent();
    }

    /**
     * Add a mention person
     * @param name accepts email, or person
     */
    public void addMention(String name){

        String path="";
        addMention.click();
        path="//a[div/div[@class=\"bx-finder-box-item-t7-name\" and text()=\""+name+"\"]]";
        BrowserUtils.wait(1);
        driver.findElement(By.xpath(path)).click();
        BrowserUtils.wait(1);
    }

    /**
     * Checks is Visual Editor Displayed or Not
     * @return true/false if displayed/not displayed
     *
     */
    public boolean isVisualEditorDisplayed(){

        visualEditor.click();
        BrowserUtils.wait(1);
        return driver.findElement(By.id("bx-html-editor-tlbr-idPostFormLHE_blogPostForm")).isDisplayed();

    }

    /**
     * Checks is title of topic displayed or not
     * @return true/false if displayed/not displayed
     */
    public boolean isTitleOfTopicDisplayed(){

        titleBtn.click();
        BrowserUtils.wait(3);
        return  topicTitle.isDisplayed();
    }

    /**
     * Add Video record (There is a bug on site, because of that functiond doesn't work properly)
     */
    public void addVideoRecord(){
        videoRecordBtn.click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//span[@class=\"popup-window-button popup-window-button-blue\"]")).click();
        BrowserUtils.wait(10);
        if(driver.findElement(By.className("//span[@class=\"popup-window-titlebar-text\"]")).getText().equalsIgnoreCase("Error")){
            driver.findElement(By.className("popup-window-button popup-window-button-blue")).click();
            Assert.assertTrue(false);
        }
        BrowserUtils.wait(10);

    }



}
