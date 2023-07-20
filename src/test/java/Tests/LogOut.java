package Tests;

import Pages.Header;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogOut extends BaseTestMethod{
    @DataProvider(name = "userPass")
    public Object[][] userPass() {
        return new Object[][]{
                {"PetarTest", "A123456!"}
        };

    }

    @Test(dataProvider = "userPass")
    public void LogOut(String username, String password) {
        System.out.println("1.Open site URL");
        HomePage homePage = new HomePage(driver);
        homePage.openSiteUrl();
        System.out.println("2. Click Login Bth");
        Header header = new Header(driver);
        header.goToLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyUrl();
        loginPage.login(username, password);
        System.out.println("3. Click LogOut");
        loginPage.clickLogout();







    }

}
