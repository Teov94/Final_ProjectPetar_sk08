package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class PostModal extends BasePage {
    @FindBy(tagName = "app-post-modal")
    WebElement modalDialog;
    @FindBy(tagName = "app-post")
    WebElement newModalDialog;
    public PostModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void waitForDialogAppear(){
        smallWait.until(ExpectedConditions.visibilityOf(modalDialog));
    }
    public void clickPic(){
        smallWait.until(ExpectedConditions.visibilityOf(newModalDialog));
        newModalDialog.click();
    }
}
