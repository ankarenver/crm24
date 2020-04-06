package com.automation.crm24.pages.activityStream;

import com.automation.crm24.pages.PageBase;
import com.automation.crm24.utilites.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivityStreamPageTop extends PageBase {


    @FindBy(id = "feed-add-post-form-tab-message")
    private WebElement message;

    @FindBy(id = "feed-add-post-form-tab-tasks")
    private WebElement task;

    @FindBy(id = "feed-add-post-form-tab-calendar")
    private WebElement event;

    @FindBy(id = "feed-add-post-form-tab-vote")
    private WebElement poll;

    @FindBy(xpath = "//span[@class='menu-popup-item-text' and contains(text(), 'File')]")
    private WebElement file;

    @FindBy(xpath = "//span[@class='menu-popup-item-text' and contains(text(), 'Appreciation')]")
    private WebElement appreciation;

    @FindBy(xpath = "//span[@class='menu-popup-item-text' and contains(text(), 'Announcement')]")
    private WebElement announcement;

    @FindBy(xpath = "//span[@class='menu-popup-item-text' and contains(text(), 'Workflow')]")
    private WebElement workflow;

    @FindBy(id = "blog-submit-button-save")
    private WebElement send;

    @FindBy(id = "blog-submit-button-cancel")
    private WebElement cancel;




    /**
     * this method will let user select which top tab to choose
     * @param tabValue tab name
     */
    public  void navigateTo(String tabValue){
        BrowserUtils.waitForPageLoad(15);
        tabValue = tabValue.toLowerCase();
        switch (tabValue){
            case "message":
                message.click();
                break;
            case "task":
                task.click();
                break;
            case "event":
                event.click();
                break;
            case "poll":
                poll.click();
                break;
            case "file":
                file.click();
                break;
            case "appreciation":
                appreciation.click();
                break;
            case "announcement":
                announcement.click();
                break;
            case "workflow":
                workflow.click();
                break;
            default:
                throw new RuntimeException("invalid tab value selection !!");
        }
    }

    public void  send(){
        BrowserUtils.waitForPageLoad(15);
        send.click();
    }

    public void cancel(){
        BrowserUtils.waitForPageLoad(15);
        cancel.click();
    }





}
