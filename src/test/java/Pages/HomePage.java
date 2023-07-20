package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage{
    private final String URL = "http://training.skillo-bg.com:4200/posts/all";


    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void openSiteUrl (){
        driver.get(URL);
    }
    public void verifyUrl(){
        verifyUrl(URL);
    }





}
