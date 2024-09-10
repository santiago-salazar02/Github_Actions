package swag.labs.utils.baseTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import swag.labs.pages.BurgerMenuPage;
import swag.labs.pages.InventoryPage;
import swag.labs.pages.LoginPage;
import swag.labs.utils.MyDriver;

public class BaseTest {

    protected MyDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"url","username","password"})
    public void beforeMethod(@Optional("https://www.saucedemo.com/") String url,
                             @Optional("standard_user") String username,
                             @Optional("secret_sauce") String password){
        String browserName = System.getProperty("browserName");
        driver = new MyDriver(browserName);
        driver.getDriver().manage().window().maximize();
        navigateTo(url);

        LoginPage loginPage = loadLogin();
        loginPage.sendLogin(username, password);
    }

    public void navigateTo(String url){
        driver.getDriver().get(url);
    }

    @AfterMethod()
    public void afterMethod(){
        driver.getDriver().close();
    }

    public LoginPage loadLogin(){
        return new LoginPage(driver.getDriver());
    }

    public InventoryPage loadInventory(){
        return new InventoryPage(driver.getDriver());
    }

    public BurgerMenuPage loadBurguerMenu(){
        return new BurgerMenuPage(driver.getDriver());
    }
}
