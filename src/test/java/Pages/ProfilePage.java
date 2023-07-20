package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProfilePage extends BasePage {
    private final String BASE_URL = "http://training.skillo-bg.com:4200/users/";
    @FindBy(css = ".profile-user-settings > h2")
    WebElement usernameHeader;
    @FindBy(className = "gallery-item")
    List<WebElement> existingPosts;
    @FindBy(css = ".fa-trash-alt")
    WebElement deletePostBtn;
    @FindBy(xpath = "//button[text() = 'Yes']")
    WebElement confirmDeletion;
    @FindBy(className = "post-feed-img")
    WebElement clickPic;
    @FindBy(css = "input[formcontrolname='content']")
    WebElement commentField;
    @FindBy(xpath = "//button[text () = 'Follow']")
    WebElement followBtn;
    @FindBy(xpath = "//button[text () = 'Unfollow']")
    WebElement unfollow;

    @FindBy(xpath = "fas fa-sign-out-alt fa-lg")
    static
    WebElement LogoutBtn;

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public String getUsernameHeaderText() {
        return getElementText(usernameHeader);
    }
    public void verifyUrl() {
        verifyUrlContains(BASE_URL);
    }
    public int getExistingPostCount() {
        mediumWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("gallery-item")));
        return existingPosts.size();
    }
    public void openPostByIndex(int index) {
        clickElement(existingPosts.get(index));
    }

    public void clickDelBtnPic() {
        deletePostBtn.click();
    }
    public void confirmPicDeletion() {
        confirmDeletion.click();
    }
    public void clickOnPic (){
        clickPic.click();
    }
    public void enterComment(){
        commentField.click();
        commentField.sendKeys("nice");
        commentField.sendKeys(Keys.ENTER);
    }
    public void follow (){
        followBtn.click();
    }
    public void unfollowBtn(){
        String actualTextUnfollow = unfollow.getText();
        Assert.assertEquals(actualTextUnfollow, "Unfollow", "Cant Follow");
    }
}