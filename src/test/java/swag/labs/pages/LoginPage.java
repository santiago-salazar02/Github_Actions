package swag.labs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import swag.labs.utils.basePage.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="login-button")
    private WebElement buttonLogin;

    private static final String expectedUrl = "https://www.saucedemo.com/";

    public void setUserName(String username){
        this.username.sendKeys(username);
    }

    public void setPassword(String password){
        this.password.sendKeys(password);
    }

    public void clickLogin(){
        this.buttonLogin.click();
    }

    public InventoryPage sendLogin(String username, String password){
        this.setUserName(username);
        this.setPassword(password);
        this.clickLogin();
        return new InventoryPage(this.getDriver());
    }

    public static String getExpectedUrl() {
        return LoginPage.expectedUrl;
    }
}
