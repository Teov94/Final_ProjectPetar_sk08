package Tests;

import Pages.Header;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class FollowUser extends BaseTestMethod {
    @DataProvider(name = "userPass")
    public Object[][] userPass() {
        return new Object[][]{
                {"PetarTest", "A123456!"}
        };
    }
    @Test(dataProvider = "userPass")
    public void followUser (String username, String password) {
        System.out.println("1.Open site URL");
        HomePage homePage = new HomePage(driver);
        homePage.openSiteUrl();
        System.out.println("2. Click Login Bth");
        Header header = new Header(driver);
        header.goToLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyUrl();
        loginPage.login(username, password);
        System.out.println("3.Press follow Btn");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.follow();
        System.out.println("4.Verify you followed that user");
        profilePage.unfollowBtn();
    }
}